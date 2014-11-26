package fr.tpt.aadl.ramses.transformation.selection;

import java.util.List ;

import org.eclipse.emf.ecore.EObject ;

import fr.tpt.aadl.ramses.transformation.trc.TrcRule ;

public class TransformationRuleAlternative
{

  private List<EObject> matchedElements;
  private List<TrcRule> alternativeRules;

  public TransformationRuleAlternative(List<EObject> matchedElements,
                                       List<TrcRule> alternativeRules)
  {
    this.alternativeRules = alternativeRules;
    this.matchedElements = matchedElements;
  }
  
  
  public List<EObject> getMatchedElements()
  {
    return matchedElements ;
  }

  public List<TrcRule> getAlternativeRules()
  {
    return alternativeRules ;
  }

  
}
