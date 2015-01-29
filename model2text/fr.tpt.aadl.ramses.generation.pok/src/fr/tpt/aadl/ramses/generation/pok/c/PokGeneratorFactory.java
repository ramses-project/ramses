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

package fr.tpt.aadl.ramses.generation.pok.c;

import java.io.File ;
import java.io.FileReader ;
import java.io.IOException ;

import fr.tpt.aadl.ramses.control.atl.AadlModelValidator ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.generator.GeneratorFactory ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.generation.arinc653.xml.AadlArinc653Transformation ;
import fr.tpt.aadl.ramses.generation.c.AadlToCUnparser ;
import fr.tpt.aadl.ramses.generation.pok.AadlArinc653Validation ;
import fr.tpt.aadl.ramses.generation.pok.makefile.AadlToPokMakefileUnparser ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificCodeGenerator ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificGenerator ;

public class PokGeneratorFactory implements GeneratorFactory
{
  public final static String POK_GENERATOR_NAME = "pok" ;
  private final static String _POK_RUNTIME_PATH = "/misc/mk/config.mk";
  
  @Override
  public Generator createGenerator(AadlModelInstantiatior modelInstantiatior,
                                   PredefinedAadlModelManager predefinedAadlModels)
  {
    AadlToPokCUnparser pokCUnparser = new AadlToPokCUnparser() ;
    
    AadlToCUnparser genericCUnparser = AadlToCUnparser.getAadlToCUnparser() ;
    
    AadlToPokMakefileUnparser pokMakefileUnparser = new AadlToPokMakefileUnparser() ;
    
    AadlTargetSpecificCodeGenerator tarSpecCodeGen = new 
                    AadlTargetSpecificCodeGenerator(genericCUnparser,
                                                    pokCUnparser,
                                                    pokMakefileUnparser) ;
    
    AadlArinc653Transformation targetTrans = new AadlArinc653Transformation(
                                             modelInstantiatior,
                                             predefinedAadlModels,
                                             "helpers/LanguageSpecificitiesC") ;
    
    AadlModelValidator targetVal=null;
	  targetVal = new AadlArinc653Validation(modelInstantiatior,
				 								                   predefinedAadlModels);
    AadlTargetSpecificGenerator result = 
                  new AadlTargetSpecificGenerator(targetTrans, tarSpecCodeGen,
                                                  modelInstantiatior,
                                                  targetVal,
                                                  predefinedAadlModels) ;
    
    result.setRegistryName(POK_GENERATOR_NAME) ;
    
    return result ;
  }

  public static boolean runtimePathChecker(File runtimePath)
  {
    File result = new File(runtimePath + _POK_RUNTIME_PATH) ;
    
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