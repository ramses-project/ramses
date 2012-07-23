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

package fr.tpt.aadl.ramses.generation.pok ;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;

import fr.tpt.aadl.ramses.control.support.generator.AadlToTargetSpecificAadl;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.transformation.atl.AtlTransfoLauncher;

public class AadlArinc653Transformation implements
                                       AadlToTargetSpecificAadl
{
  public static final String DEFAULT_ATL_FILE_PATH = 
                    "../../model2model/fr.tpt.aadl.ramses.transformation.atl/" ;
  
  public static final String[] ATL_FILE_NAMES = new String[]
        {"targets/arinc653/ExpandThreadsPorts.asm","ExpandSubprogramCalls.asm",
         "targets/arinc653/ExpandThreadsDispatchProtocol.asm","CreateThreadsBehavior.asm"};
  
  
  // The transform method for a non workflow based execution
  @Override
  public Resource transform(Resource inputResource,
                            File resourceFilePath,
                            File generatedFilePath)
                                  throws GenerationException
  {

      if(resourceFilePath == null)
      {
        resourceFilePath = new File(DEFAULT_ATL_FILE_PATH) ;
      }

      
      ArrayList<File> atlFiles = new ArrayList<File>(ATL_FILE_NAMES.length) ;
      
      for(String fileName : ATL_FILE_NAMES)
      {
        atlFiles.add(new File(resourceFilePath + "/" + fileName)) ;
      }

      AtlTransfoLauncher atlLauncher;
	  try {
		  atlLauncher = new AtlTransfoLauncher();
		  return atlLauncher.generationEntryPoint(inputResource,
				  resourceFilePath,
				  atlFiles,
				  generatedFilePath);
	  } catch (Exception e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		  return null;
	  }
  }
  
  // The transform method for a workflow based execution
  @Override
  public Resource transformXML(Resource inputResource,
                            File resourceFilePath,
                            List<String> resourceFileNameList,
                            File generatedFilePath)
                                  throws GenerationException
  {
      if(resourceFilePath == null)
      {
        resourceFilePath = new File(DEFAULT_ATL_FILE_PATH) ;
      }
      
      ArrayList<File> atlFiles = new ArrayList<File>() ;
      for(String resourceFileName : resourceFileNameList)
      {
        atlFiles.add(new File(resourceFilePath + "/" + resourceFileName)) ;
      }

      AtlTransfoLauncher atlLauncher;
	  try {
		  atlLauncher = new AtlTransfoLauncher();
		  return atlLauncher.generationEntryPoint(inputResource,
				  resourceFilePath,
				  atlFiles,
				  generatedFilePath);
	  } catch (Exception e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		  return null;
	  }
  }
  @Override
  public void setParameters(Map<Enum<?>, Object> parameters)
  {
    throw new UnsupportedOperationException() ;
  }
}
