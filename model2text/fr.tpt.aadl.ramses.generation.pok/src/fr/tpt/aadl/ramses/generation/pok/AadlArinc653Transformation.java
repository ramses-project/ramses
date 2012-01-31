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
        {"ExpandThreadsPorts.asm","ExpandSubprogramCalls.asm",
         "ExpandThreadsDispatchProtocol.asm","CreateThreadsBehavior.asm"};
  
  public static final List<File> ATL_FILES = 
                                    new ArrayList<File>(ATL_FILE_NAMES.length) ;
  
  static
  {
    for(String fileName : ATL_FILE_NAMES)
    {
      ATL_FILES.add(new File(DEFAULT_ATL_FILE_PATH + fileName)) ;
    }
  }
  
  @Override
  public Resource transform(Resource inputResource,
                            Map<String, Resource> standardPropertySets,
                            File generatedFilePath)
                                                      throws GenerationException
  {
    AtlTransfoLauncher atlTransfo = null ;
    
    try
    {
      atlTransfo = new AtlTransfoLauncher() ;

      File resourcesDirectory = new File(DEFAULT_ATL_FILE_PATH) ;
      atlTransfo.setResourcesDirectory(resourcesDirectory) ;

      String aaxlGeneratedFileName =  
                            inputResource.getURI().toFileString() ;
      
      Resource expandedResult =
            atlTransfo.doGeneration(inputResource, standardPropertySets,
                                    ATL_FILES, aaxlGeneratedFileName) ;
      
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
                                                                 ".aadl2") ;
      
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

  @Override
  public void setParameters(Map<Enum<?>, Object> parameters)
  {
    throw new UnsupportedOperationException() ;
  }
}
