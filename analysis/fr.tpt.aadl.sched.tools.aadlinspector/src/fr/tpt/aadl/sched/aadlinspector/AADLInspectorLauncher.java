package fr.tpt.aadl.sched.aadlinspector;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ModelUnit;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;

import fr.tpt.aadl.sched.aadlinspector.output.AnalysisResult;
import fr.tpt.aadl.sched.aadlinspector.output.XMLResultsProvider;

public class AADLInspectorLauncher 
{
	public final static String[] additionalPackages = {"types.aadl"};
	
	private final static String ENV_VAR = "AADLINSPECTOR_PATH";
	
	private final static String PATH = getPath();
	private static String BIN_PATH;
	private final static String OUTPUT_FILE_PATH = PATH + "output.xml";
	private static String extension = "";
	private AADLInspectorLauncher() {}
	
	private static String getPath()
	{
		String aIPath = System.getenv(ENV_VAR);
		if (aIPath == null)
			aIPath = System.getProperty(ENV_VAR);
		if(aIPath != null)
		{
		  aIPath = aIPath.endsWith("/") ? aIPath : aIPath + "/";
		  return aIPath;
		}
		System.err.println("AADLINSPECTOR_PATH environment variable should be initialized.");
		return "";
	}
	
	private static AnalysisResult launchAnalysis(String[] aadlModelsPath, 
			String mode, SystemInstance model)
		throws Exception
	{
		if (PATH.isEmpty())
		{
			throw new Exception("environment variable " + ENV_VAR + " not initialized");
		}
		
		
		String modelList = "";
		for(String aadlModelPath : aadlModelsPath)
		{
			modelList = modelList + aadlModelPath + ",";
		}
		for(String aadlModelPath : additionalPackages)
		{
			modelList = modelList + aadlModelPath + ",";
		}
		modelList = modelList.substring(0,modelList.length()-1);
		
		String modeOption="true";
		if(mode.equalsIgnoreCase("automatic"))
		{
			modeOption = "false";
		}
		
		final String command = BIN_PATH + "AADLInspector" + extension;
		Process p = Runtime.getRuntime().exec(new String[] {
				command, 
				"-a", modelList, 
				"--plugin", PATH + "config/plugins.common/cheddar.aip", 
				"--result", OUTPUT_FILE_PATH, 
				"--show", modeOption});
		int exitValue = p.waitFor();
		if (exitValue!=0)
		{
			throw new Exception("exit value " + exitValue);
		}
		
		final File f = new File (OUTPUT_FILE_PATH);
		if (! f.exists())
		{
			throw new Exception("output file " + OUTPUT_FILE_PATH 
					+ " is missing !\nMaybe there is some elements in the AADL model that are not supported" +
					" actually.");
		}
		
		/** If output format change, modify here the name of the class */
		return new XMLResultsProvider(f).getResult(model); 
	}
	
	
	public static AnalysisResult launchAnalysis(SystemInstance root, String mode)
			throws Exception
	{
		String OS = (String) System.getProperties().get("os.name");
		if(OS.equalsIgnoreCase("linux"))
		  BIN_PATH = PATH + "bin.l32/";
		else if(OS.toLowerCase().contains("windows"))
		{
		  BIN_PATH = PATH + "bin.w32/";
		  extension = ".exe";
		  BIN_PATH = BIN_PATH.replace('/', '\\');
		}
		final SystemImplementation si = root.getSystemImplementation();
		final PublicPackageSection pps = (PublicPackageSection) si.eContainer();
		final List<String> paths = new ArrayList<String>();
		URI uri = si.eResource().getURI();
		String path = uri.toFileString();
		if(path!=null)
		  paths.add(path);
		else
		{
		  String filePath = Platform.getLocation().toOSString();
		  filePath = filePath + uri.toPlatformString(true) ;
		  paths.add(filePath);
		}
		
		loadResourcePaths(pps, paths);
		String[] modelList = paths.toArray(new String[paths.size()]);
		
		return launchAnalysis(modelList, mode, root);
	}
	
	private static void loadResourcePaths(PublicPackageSection pps, List<String> pathList)
	{
		final List<ModelUnit> imports = pps.getImportedUnits();
		for(ModelUnit u : imports)
		{
			final Resource r = u.eResource();
			URI uri = r.getURI();
			String path = uri.toFileString();
			if(path==null)
			{
			  path = Platform.getLocation().toOSString();
			  path = path + uri.toPlatformString(true) ;
			}
			if (! pathList.contains(path))
			{
				pathList.add(path);
				if (r.getContents().get(0) instanceof AadlPackage)
				{
					AadlPackage pkg = (AadlPackage) r.getContents().get(0);
					loadResourcePaths(pkg.getPublicSection(), pathList);
				}
			}
		}
	}
}
