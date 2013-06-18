package fr.tpt.aadl.sched.aadlinspector;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
	
	private AADLInspectorLauncher() {}
	
	private static String getPath()
	{
		Map<String,String> variables = System.getenv();
		for(Map.Entry<String, String> entry : variables.entrySet())
		{
			if (entry.getKey().equals(ENV_VAR))
			{
				String path = entry.getValue();
				path = path.endsWith("/") ? path : path + "/";
				return path;
			}
		}
		System.err.println("AADLINSPECTOR_PATH environment variable should be initialized.");
		return "";
	}
	
	public static AnalysisResult launchAnalysis(String[] aadlModelsPath, String mode)
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
		
		String modeOption="";
		if(mode.equalsIgnoreCase("automatic"))
		{
			modeOption = " --show false";
		}
		
		final String command = BIN_PATH + "AADLInspector"
				+ " -a " + modelList
				+ " --plugin " + PATH + "config/plugins.common/cheddar.aip"
				+ " --result " + OUTPUT_FILE_PATH
				+ modeOption;
		
		System.out.println(command);
		
		Process p = Runtime.getRuntime().exec(command);
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
		return new XMLResultsProvider(f).getResult(); 
	}
	
	
	public static AnalysisResult launchAnalysis(SystemInstance root, String mode)
			throws Exception
	{
		String OS = (String) System.getProperties().get("os.name");
		System.out.println("OS :" + OS);
		if(OS.equalsIgnoreCase("linux"))
		  BIN_PATH = PATH + "bin.l32/";
		else if(OS.toLowerCase().contains("windows"))
		  BIN_PATH = PATH + "bin.w32/";
		final SystemImplementation si = root.getSystemImplementation();
		final PublicPackageSection pps = (PublicPackageSection) si.eContainer();
		final List<String> paths = new ArrayList<String>();
		
		paths.add(si.eResource().getURI().toFileString());
		
		loadResourcePaths(pps, paths);
		String[] modelList = paths.toArray(new String[paths.size()]);
		
		return launchAnalysis(modelList, mode);
	}
	
	private static void loadResourcePaths(PublicPackageSection pps, List<String> pathList)
	{
		final List<ModelUnit> imports = pps.getImportedUnits();
		for(ModelUnit u : imports)
		{
			final Resource r = u.eResource();
			final String path = r.getURI().toFileString();
			
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
