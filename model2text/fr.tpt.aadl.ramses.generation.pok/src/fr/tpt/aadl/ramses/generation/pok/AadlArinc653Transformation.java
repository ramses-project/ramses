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

import java.io.File ;
import java.util.ArrayList ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.emf.ecore.resource.Resource ;

import fr.tpt.aadl.ramses.control.support.generator.AadlToTargetSpecificAadl ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.instantiation.StandAloneInstantiator ;
import fr.tpt.aadl.ramses.transformation.atl.AtlTransfoLauncher ;

public class AadlArinc653Transformation implements
                                       AadlToTargetSpecificAadl
{
  public static final String DEFAULT_ATL_FILE_PATH = 
                    "../../model2model/fr.tpt.aadl.ramses.transformation.atl/" ;
  
  public static final String[] ATL_FILE_NAMES = new String[]
        {"targets/arinc653/ExpandThreadsPorts.asm","ExpandSubprogramCalls.asm",
         "targets/arinc653/ExpandThreadsDispatchProtocol.asm","CreateThreadsBehavior.asm"};
  
  
  // Common part shared between transform and transformXML
  public Resource transformCommon(Resource inputResource,
          File resourceFilePath,
          ArrayList<File> atlFiles,
          Map<String, Resource> standardPropertySets,
          File generatedFilePath)
                                    throws GenerationException
{
    AtlTransfoLauncher atlTransfo = null ;

    try
    {
      atlTransfo = new AtlTransfoLauncher() ;

      atlTransfo.setResourcesDirectory(resourceFilePath) ;

      String aaxlGeneratedFileName =  
          inputResource.getURI().toFileString()
          .replaceFirst(".aaxl2","_extended.aaxl2") ;;

          Resource expandedResult =
              atlTransfo.doGeneration(inputResource, standardPropertySets,
                  atlFiles, aaxlGeneratedFileName) ;

                    /*
          for(File f : postTransformationFiles)
          {
          List<File> refinements = new ArrayList<File>() ;
          refinements.add(f) ;
          expandedResult =
          atlTransfo.doGeneration(expandedResult, standardPropertySets,
                              refinements, dataTargetfilepath) ;
          }
                     */

          String aadlGeneratedFileName = inputResource.getURI().toFileString() ;
          aadlGeneratedFileName = aadlGeneratedFileName.replaceFirst(".aaxl2",
              "_extended.aadl2") ;

          StandAloneInstantiator instantiator =
              StandAloneInstantiator.getInstantiator() ;
          instantiator.serialize(expandedResult, aadlGeneratedFileName) ;

          return expandedResult ;
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
      throw new GenerationException(e.getMessage()) ;
    }
}
  
  // The transform method for a non workflow based execution
  @Override
  public Resource transform(Resource inputResource,
                            File resourceFilePath,
                            Map<String, Resource> standardPropertySets,
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

      return transformCommon(inputResource,
              resourceFilePath,
              atlFiles,
              standardPropertySets,
              generatedFilePath);
  }
  
  // The transform method for a workflow based execution
  @Override
  public Resource transformXML(Resource inputResource,
                            File resourceFilePath,
                            List<String> resourceFileNameList,
                            Map<String, Resource> standardPropertySets,
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

      return transformCommon(inputResource,
              resourceFilePath,
              atlFiles,
              standardPropertySets,
              generatedFilePath);
  }
  @Override
  public void setParameters(Map<Enum<?>, Object> parameters)
  {
    throw new UnsupportedOperationException() ;
  }
}
