/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.transformation.atl;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;

import fr.tpt.aadl.ramses.control.support.InstantiationManager;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.generator.AadlToAadl;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;

public abstract class AadlToTargetSpecificAadl implements AadlToAadl
{
	protected String[] ATL_FILE_NAMES;
	public List<File> ATL_FILES;
	private static final String DEFAULT_ATL_FILE_PATH = 
      "../../model2model/fr.tpt.aadl.ramses.transformation.atl/" ;
	
	public void initAtlFileNameList(File resourceDir)
	{
		ATL_FILES = new ArrayList<File>(ATL_FILE_NAMES.length);
		for (String fileName : ATL_FILE_NAMES) {
	    ATL_FILES.add(new File(resourceDir.getAbsolutePath() +"/"+ fileName));
	  }
	}
	
  public Resource transform(Resource inputResource,
                            File resourceDir,
                            File outputDir) throws GenerationException
  {
  	
  	initAtlFileNameList(resourceDir);
  	if(resourceDir == null)
    {
      resourceDir = new File(DEFAULT_ATL_FILE_PATH) ;
    }

    
    ArrayList<File> atlFiles = new ArrayList<File>(ATL_FILE_NAMES.length) ;
    
    for(String fileName : ATL_FILE_NAMES)
    {
      atlFiles.add(new File(resourceDir + "/" + fileName)) ;
    }

    AtlTransfoLauncher atlLauncher;
    try {
    	atlLauncher = new Aadl2AadlLauncher();
    	return atlLauncher.generationEntryPoint(inputResource,
    			resourceDir,
    			atlFiles,
    			outputDir);
    } catch (Exception e) {
    	// TODO Auto-generated catch block
    	e.printStackTrace();
    	return null;
    }
  }
  
  public Resource unparse(Resource inputResource, 
          Resource expandedResult, File outputDir)
  {
	    String aadlGeneratedFileName = inputResource.getURI().lastSegment();
		aadlGeneratedFileName = aadlGeneratedFileName.replaceFirst(
				".aaxl2", "_extended.aadl2");
		
		File outputModelDir =  new File(outputDir.getAbsolutePath()+"/refined-models");
		if(outputModelDir.exists()==false)
			outputModelDir.mkdir();
		InstantiationManager instantiator = RamsesConfiguration.getInstantiationManager();
		String outputFilePath=outputModelDir.getAbsolutePath()+"/"+aadlGeneratedFileName;
		File outputFile = new File(outputFilePath);

		instantiator.serialize(expandedResult, outputFilePath);

		try {
			return Aadl2AadlLauncher.extractXtextResource(inputResource, outputFile);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
  }
  
  abstract public void setParameters(Map<Enum<?>, Object> parameters) ;

  public Resource transformXML(Resource inputResource,
  														 File resourceDir,
  														 List<String> resourceFileNameList,
  														 File outputDir) throws GenerationException
  {
  	if(resourceDir == null)
  	{
  		resourceDir = new File(DEFAULT_ATL_FILE_PATH) ;
  	}

  	ArrayList<File> atlFiles = new ArrayList<File>() ;
  	for(String resourceFileName : resourceFileNameList)
  	{
  		atlFiles.add(new File(resourceDir + "/" + resourceFileName)) ;
  	}

  	AtlTransfoLauncher atlLauncher;
  	try {
  		atlLauncher = new Aadl2AadlLauncher();
  		return atlLauncher.generationEntryPoint(inputResource,
  				resourceDir,
  				atlFiles,
  				outputDir);
  	} catch (Exception e) {
  		// TODO Auto-generated catch block
  		e.printStackTrace();
  		return null;
  	}
  }

}
