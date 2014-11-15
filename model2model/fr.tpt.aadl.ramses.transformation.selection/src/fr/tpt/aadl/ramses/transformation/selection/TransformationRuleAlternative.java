package fr.tpt.aadl.ramses.transformation.selection;

import java.util.List ;

import org.eclipse.emf.ecore.EObject ;

public class TransformationRuleAlternative
{

  private List<EObject> matchedElements;
  private List<String> alternativeRules;

  public TransformationRuleAlternative(List<EObject> matchedElements,
                                       List<String> alternativeRules)
  {
    this.alternativeRules = alternativeRules;
    this.matchedElements = matchedElements;
  }
  
  
  public List<EObject> getMatchedElements()
  {
    return matchedElements ;
  }

  public List<String> getAlternativeRules()
  {
    return alternativeRules ;
  }

  
}
