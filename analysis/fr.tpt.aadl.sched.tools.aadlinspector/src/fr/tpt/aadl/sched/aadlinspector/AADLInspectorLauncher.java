/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.sched.aadlinspector;

import java.io.File ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.List ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.Platform ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.AadlPackage ;
import org.osate.aadl2.ModelUnit ;
import org.osate.aadl2.PublicPackageSection ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.instance.SystemInstance ;

import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.sched.aadlinspector.output.AnalysisResult ;
import fr.tpt.aadl.sched.aadlinspector.output.XMLResultsProvider ;

public class AADLInspectorLauncher 
{
	public final static String[] additionalPackages = {"types.aadl"};
	
	private final static String ENV_VAR = "AADLINSPECTOR_PATH";
	
	private final String PATH = getPath();
	private String BIN_PATH;
	private String OUTPUT_FILE_PATH;
	private String extension = "";
	
	private Logger _LOGGER = Logger.getLogger(AADLInspectorLauncher.class) ;
	
	private String getPath()
	{
		String aIPath = System.getProperty(ENV_VAR);
		if (aIPath == null)
			aIPath = System.getenv(ENV_VAR);
		if(aIPath != null)
		{
		  aIPath = aIPath.endsWith(File.separator) ? aIPath : aIPath + File.separator;
		  return aIPath;
		}
		
		String msg = ENV_VAR + " environment variable should be initialized." ;
		_LOGGER.error(msg) ;
		// TODO : add configuration page
		
		ServiceProvider.SYS_ERR_REP.error(msg, true);
		return "";
	}
	
	private AnalysisResult launchAnalysis(String[] aadlModelsPath, 
			                                         File outputDir,
			                                         String mode,
			                                         SystemInstance model)
		                                               throws AnalysisException
	{
		if (PATH.isEmpty())
		{
		  String msg = "environment variable " + ENV_VAR +
		                               " not initialized" ;
		  _LOGGER.fatal(msg) ;
		  throw new RuntimeException(msg);
		}
		
		OUTPUT_FILE_PATH = outputDir.getAbsolutePath() + "/AADL_Inspector_output.xml";
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
		Process p ;
    try
    {
      p = Runtime.getRuntime().exec(new String[] {
      		command, 
      		"-a", modelList, 
      		"--plugin", "schedulability.cheddarSimTest", 
      		"--result", OUTPUT_FILE_PATH, 
      		"--show", modeOption}) ;
    }
    catch(IOException e)
    {
      String msg = "cannot execute AADLInspector" ;
      _LOGGER.fatal(msg, e) ;
      throw new RuntimeException(msg, e) ;
    }
		
		String debugCommand = command+" -a "+modelList+ 
				" --plugin "+ "schedulability.cheddarSimTest"+ 
				//" --result "+ OUTPUT_FILE_PATH+
				" --show "+ modeOption;
		
		_LOGGER.trace("AADL Inspector command: "+debugCommand) ;
		
		int exitValue = -1 ;
    try
    {
      exitValue = p.waitFor() ;
    }
    catch(InterruptedException e)
    {
      String msg = "AADLInspector was interrupted" ;
      _LOGGER.fatal(msg, e) ;
      throw new RuntimeException(msg, e) ;
    }
    
		if (exitValue!=0)
		{
		  String msg = "AADLInspector failed with exit value = " + exitValue ;
		  _LOGGER.fatal(msg) ;
		  throw new AnalysisException(msg);
		}
		
		final File f = new File (OUTPUT_FILE_PATH);
		if (! f.exists())
		{
			String msg = "output file \'" + OUTPUT_FILE_PATH 
          + "\' is not found ! Maybe there is some elements in the AADL model that are not supported" +
          " actually" ; 
		  _LOGGER.fatal(msg) ;
		  throw new RuntimeException(msg) ;
		}
		
		/** If output format change, modify here the name of the class */
		try
    {
      return new XMLResultsProvider(f).getResult(model);
    }
    catch(Exception e)
    {
      String msg = "cannot fetch AADLInspector XML result" ;
      _LOGGER.fatal(msg) ;
      throw new AnalysisException(msg);
    }
	}
	
	public AnalysisResult launchAnalysis(SystemInstance root,
	                                            File outputDir,
	                                            String mode)
	                                                throws AnalysisException
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
		
		return launchAnalysis(modelList, outputDir, mode, root);
	}
	
	private void loadResourcePaths(PublicPackageSection pps, List<String> pathList)
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