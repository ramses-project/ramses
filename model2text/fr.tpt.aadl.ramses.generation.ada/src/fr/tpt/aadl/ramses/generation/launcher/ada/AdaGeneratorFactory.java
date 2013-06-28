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


package fr.tpt.aadl.ramses.generation.launcher.ada;

import fr.tpt.aadl.ramses.control.support.generator.AbstractGeneratorFactory;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.generation.ada.AadlToADAUnparser;
import fr.tpt.aadl.ramses.generation.ada.makefile.AadlToAdaMakefileUnparser ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificCodeGenerator ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificGenerator ;

public class AdaGeneratorFactory extends AbstractGeneratorFactory
{
  public static String ADA_GENERATOR_NAME = "ada" ;
  
  private static Generator createPokGenerator()
  {
    AadlToConfADAUnparser pokADAUnparser = new AadlToConfADAUnparser() ;
    
    AadlToADAUnparser genericADAUnparser = AadlToADAUnparser.getAadlToADAUnparser() ;
    
    AadlToAdaMakefileUnparser pokMakefileUnparser = new AadlToAdaMakefileUnparser() ;
    /*
    AadlTargetSpecificCodeGenerator tarSpecCodeGen = new 
            AadlTargetSpecificCodeGenerator(genericADAUnparser,
                                            pokADAUnparser) ;


    */
    AadlTargetSpecificCodeGenerator tarSpecCodeGen = new 
                    AadlTargetSpecificCodeGenerator(genericADAUnparser,
                                                    pokADAUnparser,
                                                    pokMakefileUnparser) ;
    
    AadlAdaTransformation targetTrans = new AadlAdaTransformation();
    
    
    AadlTargetSpecificGenerator result = 
                  new AadlTargetSpecificGenerator(targetTrans, tarSpecCodeGen) ;
    
    result.setRegistryName(ADA_GENERATOR_NAME) ;
    
    return result ;
  }
  
  
  
  public Generator createGenerator()
  {
      return createPokGenerator();
  }
}
