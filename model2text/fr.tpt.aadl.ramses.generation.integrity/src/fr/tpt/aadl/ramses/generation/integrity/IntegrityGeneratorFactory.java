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

package fr.tpt.aadl.ramses.generation.integrity;

import fr.tpt.aadl.ramses.control.atl.AadlModelValidator;
import fr.tpt.aadl.ramses.control.support.generator.GeneratorFactory;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager;
import fr.tpt.aadl.ramses.generation.arinc653.xml.AadlToXMLArinc653Unparser;
import fr.tpt.aadl.ramses.generation.c.AadlToCUnparser ;
import fr.tpt.aadl.ramses.generation.integrity.makefile.AadlToIntegrityMakefileUnparser;
import fr.tpt.aadl.ramses.generation.pok.AadlArinc653Transformation;
import fr.tpt.aadl.ramses.generation.pok.AadlArinc653Validation;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificCodeGenerator ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificGenerator ;

public class IntegrityGeneratorFactory implements GeneratorFactory
{
  public static String INTEGRITY_GENERATOR_NAME = "integrity" ;
  
  private static Generator createIntegrityGenerator(AadlModelInstantiatior instantiator,
		  PredefinedAadlModelManager predefinedAadlModels)
  {
    
    AadlToCUnparser genericCUnparser = AadlToCUnparser.getAadlToCUnparser() ;
    
    AadlToIntegrityMakefileUnparser integMakefileUnparser = new AadlToIntegrityMakefileUnparser() ;
    
    AadlToXMLArinc653Unparser integUnparser = new AadlToXMLArinc653Unparser();
    
    AadlTargetSpecificCodeGenerator tarSpecCodeGen = new 
                    AadlTargetSpecificCodeGenerator(genericCUnparser,
                    								integUnparser,
                    								integMakefileUnparser) ;
    
    AadlArinc653Transformation targetTrans = new AadlArinc653Transformation(instantiator, 
    		predefinedAadlModels, 
    		"helpers/LanguageSpecificitiesC") ;
    
    AadlModelValidator targetVal = null ;
    
    targetVal =
            new AadlArinc653Validation(instantiator, predefinedAadlModels) ;
    
    AadlTargetSpecificGenerator result = 
                  new AadlTargetSpecificGenerator(targetTrans, 
                		  tarSpecCodeGen,
                		  instantiator, targetVal) ;
    
    result.setRegistryName(INTEGRITY_GENERATOR_NAME) ;
    
    return result ;
  }
  
  
  
  public Generator createGenerator(AadlModelInstantiatior modelInstantiatior,
          PredefinedAadlModelManager predefinedAadlModels)
  {
      return createIntegrityGenerator(modelInstantiatior, predefinedAadlModels);
  }
}
