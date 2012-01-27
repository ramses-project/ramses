package fr.tpt.aadl.ramses.generation.pok;

import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.generation.c.AadlToCUnparser ;
import fr.tpt.aadl.ramses.generation.pok.c.AadlToPokCUnparser ;
import fr.tpt.aadl.ramses.generation.pok.makefile.AadlToPokMakefileUnparser ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificCodeGenerator ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificGenerator ;

public class PokGeneratorFactory
{
  public static String POK_GENERATOR_NAME = "pok_generator" ;
  
  private static Generator createPokGenerator()
  {
    AadlToCUnparser genericCUnparser = new AadlToCUnparser() ;
    
    AadlToPokCUnparser pokCUnparser = new AadlToPokCUnparser() ;
    
    AadlToPokMakefileUnparser pokMakefileUnparser = new AadlToPokMakefileUnparser() ;
    
    AadlTargetSpecificCodeGenerator tarSpecCodeGen = new 
                    AadlTargetSpecificCodeGenerator(genericCUnparser,
                                                    pokCUnparser,
                                                    pokMakefileUnparser) ;
    
    AadlArinc653Transformation targetTrans = new AadlArinc653Transformation();
    
    
    AadlTargetSpecificGenerator result = 
                  new AadlTargetSpecificGenerator(targetTrans, tarSpecCodeGen) ;
    
    result.setRegistryName(POK_GENERATOR_NAME) ;
    
    return result ;
  }
  
  public static Generator createPokGenerator(boolean isOSGi)
  {
    if (false == isOSGi)
    {
      return createPokGenerator();
    }
    else
    {
      throw new UnsupportedOperationException() ;
    }
  }
}
