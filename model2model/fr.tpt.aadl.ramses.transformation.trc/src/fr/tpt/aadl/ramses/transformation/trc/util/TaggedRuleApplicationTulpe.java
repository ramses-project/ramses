package fr.tpt.aadl.ramses.transformation.trc.util;

public class TaggedRuleApplicationTulpe extends RuleApplicationTulpe {

	boolean _exclusion=false;
	
	public boolean isExclusion()
  {
    return _exclusion ;
  }

  public void setExclusion(boolean _exclusion)
  {
    this._exclusion = _exclusion ;
  }
  
}
