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

package fr.tpt.aadl.generation.code.test ;

import java.io.File ;
import java.util.ArrayList ;
import java.util.List ;

import org.eclipse.emf.common.util.TreeIterator ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.PublicPackageSection ;

import fr.tpt.aadl.ramses.control.cli.StaticServiceRegistry ;
import fr.tpt.aadl.ramses.control.core.ToolSuiteLauncher ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider ;
import fr.tpt.aadl.ramses.generation.c.AadlToCUnparser ;

public class GenerationTester
{

  public static String DEPENDENCIES_DIR_NAME = "../../model2model/fr.tpt.aadl.ramses.transformation.atl/aadl_resources"; 
  
  public static void main(String[] args)
  {
    ToolSuiteLauncher launcher = new ToolSuiteLauncher() ;

    try
    {
      ServiceRegistryProvider.setDefault(new StaticServiceRegistry()) ;
    }
    catch(Exception e1)
    {
      // TODO Auto-generated catch block
      e1.printStackTrace() ;
    }

    List<File> test = new ArrayList<File>() ;
    test.add(new File(DEPENDENCIES_DIR_NAME+"/package/base_types.aadl2"));
    test.add(new File("test/dummyPropertySet.aadl")) ;
    test.add(new File("test/dummySubRoutine.aadl")) ;
    test.add(new File("test/dummyTypes.aadl")) ;
    test.add(new File("test/ba_generation_test_001.aadl")) ;
    launcher.parsePredefinedRessources(new File(DEPENDENCIES_DIR_NAME)) ;
    List<Resource> parsedFiles = launcher.parse(test) ;
    AadlToCUnparser generator = AadlToCUnparser.getAadlToCUnparser() ;

    for(Resource r : parsedFiles)
    {
      TreeIterator<EObject> iter = r.getAllContents() ;

      while(iter.hasNext())
      {
        EObject elt = iter.next() ;

        if(elt instanceof PublicPackageSection)
        {
          generator.process((Element) elt) ;
        }
      }
    }

    generator.saveGeneratedFilesContent(new File("test")) ;
  }
}
