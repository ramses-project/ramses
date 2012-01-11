package fr.tpt.aadl.generation.code.annex.behavior ;

import java.util.Map ;

import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.DataAccess ;

import fr.tpt.aadl.annex.behavior.AadlBaUnParserAction ;
import fr.tpt.aadl.annex.behavior.unparser.AadlBaUnparser ;

public class AadlBaToCUnparserAction extends AadlBaUnParserAction
{

  public static final String ANNEX_NAME = "restricted_behavior_specification" ;
  protected AadlBaToCUnparser unparser = null ;

  @Override
  public String unparseAnnexSubclause(AnnexSubclause subclause,
                                      String indent)
  {
    return unparser.process(subclause) ;
  }

  public AadlBaToCUnparser createUnparser(Map<DataAccess, String> blackboardNames)
  {
    unparser = new AadlBaToCUnparser() ;
    unparser.setBlackboardNames(blackboardNames) ;
    return unparser ;
  }
  
  public AadlBaToCUnparser getUnparser()
  {
    return unparser ;
  }
}
