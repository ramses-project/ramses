package fr.tpt.aadl.ramses.generation.ada.annex.behavior;



import org.osate.aadl2.AnnexSubclause;

import fr.tpt.aadl.annex.behavior.AadlBaUnParserAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement;
import fr.tpt.aadl.ramses.control.support.plugins.NamedPlugin;
import fr.tpt.aadl.ramses.generation.ada.annex.behavior.AadlBaToADAUnparser;


public class AadlBaToADAUnparserAction extends AadlBaUnParserAction implements NamedPlugin
{
	public static final String ANNEX_NAME = "ada_behavior_specification" ;
	  protected AadlBaToADAUnparser _unparser = null ;
	  
	  public AadlBaToADAUnparserAction()
	  {
	    _unparser = new AadlBaToADAUnparser() ;
	  }
	  
	  @Override
	  public String unparseAnnexSubclause(AnnexSubclause subclause,
	                                      String indent)
	  {
	    return _unparser.process((BehaviorElement) subclause) ;
	  }

	  public AadlBaToADAUnparser getUnparser()
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
