package fr.tpt.aadl.pok.c.unparser;

import fr.tpt.aadl.target.specific.generator.AadlTargetSpecificGenerator ;
import fr.tpt.aadl.toolsuite.support.generator.Generator ;

public class PokGeneratorFactory
{
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
    
    result.setRegistryName(pokCUnparser.generatorName()) ;
    
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
