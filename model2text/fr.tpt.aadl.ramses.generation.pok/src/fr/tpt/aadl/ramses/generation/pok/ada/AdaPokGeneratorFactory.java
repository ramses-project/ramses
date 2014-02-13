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


package fr.tpt.aadl.ramses.generation.pok.ada;

import org.eclipse.m2m.atl.core.ATLCoreException;

import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.generator.GeneratorFactory ;
import fr.tpt.aadl.ramses.generation.ada.AadlToADAUnparser ;
import fr.tpt.aadl.ramses.generation.pok.AadlArinc653Transformation ;
import fr.tpt.aadl.ramses.generation.pok.AadlArinc653Validation;
import fr.tpt.aadl.ramses.generation.pok.makefile.AadlToPokMakefileUnparser ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificCodeGenerator ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificGenerator ;
import fr.tpt.aadl.ramses.transformation.atl.AadlModelValidator;

public class AdaPokGeneratorFactory implements GeneratorFactory
{
  public static String ADA_GENERATOR_NAME = "ada-pok" ;
  
  public Generator createGenerator(AadlModelInstantiatior modelInstantiatior,
                                   PredefinedAadlModelManager predefinedAadlModels)
  {
    AadlToConfADAUnparser pokADAUnparser = new AadlToConfADAUnparser() ;
    
    AadlToADAUnparser genericADAUnparser = AadlToADAUnparser.getAadlToADAUnparser() ;
    
    AadlToPokMakefileUnparser pokMakefileUnparser = new AadlToPokMakefileUnparser() ;
    
    AadlTargetSpecificCodeGenerator tarSpecCodeGen = new 
                    AadlTargetSpecificCodeGenerator(genericADAUnparser,
                                                    pokADAUnparser,
                                                    pokMakefileUnparser) ;
    
    AadlArinc653Transformation targetTrans = new AadlArinc653Transformation(
                                            modelInstantiatior,
                                            predefinedAadlModels,
                                            "helpers/LanguageSpecificitiesAda");
    
    
    AadlModelValidator targetVal=null;
	try {
		targetVal = new AadlArinc653Validation(
				 								 modelInstantiatior,
				 								 predefinedAadlModels);
	} catch (ATLCoreException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
    AadlTargetSpecificGenerator result = 
                  new AadlTargetSpecificGenerator(targetTrans, tarSpecCodeGen,
                                                  modelInstantiatior,
                                                  targetVal) ;
    
    result.setRegistryName(ADA_GENERATOR_NAME) ;
    
    return result ;
  }
}
