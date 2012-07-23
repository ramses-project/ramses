package fr.tpt.aadl.ramses.generation.pokTT;

import fr.tpt.aadl.ramses.control.support.generator.AbstractGeneratorFactory;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.generation.c.AadlToCUnparser ;
import fr.tpt.aadl.ramses.generation.pok.makefile.AadlToPokMakefileUnparser ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificCodeGenerator ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificGenerator ;

public class PokTTGeneratorFactory extends AbstractGeneratorFactory
{
  public static String POK_TT_GENERATOR_NAME = "pok_time_triggered" ;
  
  private static Generator createPokTTGenerator()
  {
    AadlToPokCTTUnparser pokCUnparser = new AadlToPokCTTUnparser() ;
    
    AadlToCUnparser genericCUnparser = AadlToCUnparser.getAadlToCUnparser() ;
    
    AadlToPokMakefileUnparser pokMakefileUnparser = new AadlToPokMakefileUnparser() ;
    
    AadlTargetSpecificCodeGenerator tarSpecCodeGen = new 
                    AadlTargetSpecificCodeGenerator(genericCUnparser,
                                                    pokCUnparser,
                                                    pokMakefileUnparser) ;
    
    AadlArinc653TTTransformation targetTrans = new AadlArinc653TTTransformation();
    
    
    AadlTargetSpecificGenerator result = 
                  new AadlTargetSpecificGenerator(targetTrans, tarSpecCodeGen) ;
    
    result.setRegistryName(POK_TT_GENERATOR_NAME) ;
    
    return result ;
  }
  
  @Override
  public Generator createGenerator()
  {
    return createPokTTGenerator();
  }
}
