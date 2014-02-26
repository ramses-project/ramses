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

package fr.tpt.aadl.ramses.generation.osek;

import java.io.File ;
import java.io.FileReader ;
import java.io.IOException ;

import org.eclipse.m2m.atl.core.ATLCoreException;

import fr.tpt.aadl.ramses.control.atl.AadlModelValidator ;
import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.generator.GeneratorFactory ;
import fr.tpt.aadl.ramses.generation.c.AadlToCUnparser ;
import fr.tpt.aadl.ramses.generation.osek.ast.OIL ;
import fr.tpt.aadl.ramses.generation.osek.c.AadlOSEKCodeGenerator ;
import fr.tpt.aadl.ramses.generation.osek.c.AadlToOSEKNxtCUnparser ;
import fr.tpt.aadl.ramses.generation.osek.makefile.AadlToOSEKnxtMakefileUnparser ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificCodeGenerator ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificGenerator ;

public class OSEKGeneratorFactory implements GeneratorFactory {
	
  public final static String OSEK_GENERATOR_NAME = "osek";
  private final static String _OSEK_RUNTIME_PATH = "/ecrobot/c/ecrobot.c";

	@Override
	public Generator createGenerator(AadlModelInstantiatior modelInstantiator,
	                                 PredefinedAadlModelManager predefinedAadlModels)
	{
	   OIL oil = new OIL();
	    
	    // Instantiate generator ADDL-- to C
	    AadlToCUnparser genericCUnparser = AadlToCUnparser.getAadlToCUnparser() ;

	    // Instantiate generator OIL
	    AadlToOSEKNxtCUnparser osekCUnparser = new AadlToOSEKNxtCUnparser(oil);

	    // Call "goil" trampoline program
	    AadlToOSEKnxtMakefileUnparser osekMakefileUnparser = new AadlToOSEKnxtMakefileUnparser();

	    // Instantiate transformation AADL to refined ADDL
	    AadlOsekTransformation targetTrans = new AadlOsekTransformation(modelInstantiator,
	                                                                    predefinedAadlModels,
	                                                                    "helpers/LanguageSpecificitiesC");

	    // new implementation
	    AadlTargetSpecificCodeGenerator tarSpecCodeGen = new AadlOSEKCodeGenerator(genericCUnparser, osekCUnparser,
	        osekMakefileUnparser);

	    // Generate oil and C
	    AadlModelValidator targetVal=null;
		try {
			targetVal = new AadlOSEKValidation(modelInstantiator,
					 						   predefinedAadlModels);
		} catch (ATLCoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    AadlTargetSpecificGenerator result = 
	                  new AadlTargetSpecificGenerator(targetTrans, tarSpecCodeGen,
	                		  						  modelInstantiator,
	                                                  targetVal) ;
	    result.setRegistryName(OSEK_GENERATOR_NAME);

	    return result;
	}
	
	public static boolean runtimePathChecker(File runtimePath)
	{
    File result = new File(runtimePath + _OSEK_RUNTIME_PATH) ;
    
    try 
    {
      FileReader fr = new FileReader(result);
      fr.close();
    }
    catch (IOException e)
    {
      return false;
    }

    return true;
	}
}