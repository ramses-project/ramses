package fr.tpt.aadl.ramses.transformation.trc.util;

import java.util.List;

import org.eclipse.emf.ecore.EObject;

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
