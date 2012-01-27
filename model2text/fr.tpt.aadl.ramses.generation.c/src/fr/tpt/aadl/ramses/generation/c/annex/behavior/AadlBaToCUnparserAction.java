package fr.tpt.aadl.ramses.generation.c.annex.behavior ;


import org.osate.aadl2.AnnexSubclause ;

import fr.tpt.aadl.annex.behavior.AadlBaUnParserAction ;
import fr.tpt.aadl.ramses.control.support.plugins.NamedPlugin ;

// ** AADL RESTRICTED BA HAS TO BE SET AS A STANDALONE ECLIPSE PLUGIN PROJECT ** 

public class AadlBaToCUnparserAction extends AadlBaUnParserAction
                                     implements NamedPlugin
{

  public static final String ANNEX_NAME = "restricted_behavior_specification" ;
  protected AadlBaToCUnparser _unparser = null ;
  
  public AadlBaToCUnparserAction()
  {
    _unparser = new AadlBaToCUnparser() ;
  }
  
  @Override
  public String unparseAnnexSubclause(AnnexSubclause subclause,
                                      String indent)
  {
    return _unparser.process(subclause) ;
  }
/*
  public AadlBaToCUnparser createUnparser(Map<DataAccess, String> dataAccessMapping)
  {
    unparser = new AadlBaToCUnparser() ;
    unparser.setDataAccessMapping(dataAccessMapping) ;
    return unparser ;
  }
*/

  public AadlBaToCUnparser getUnparser()
  {
    return _unparser ;
  }

  @Override
  public String getRegistryName()
  {
    return ANNEX_NAME ;
  }

  @Override
  public String getPluginName()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public String getPluginId()
  {
    // TODO Auto-generated method stub
    return null ;
  }
}
