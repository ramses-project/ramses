package fr.tpt.aadl.ramses.transformation.selection.mcda;

import java.util.List ;

import org.eclipse.emf.ecore.EObject ;

import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;
import fr.tpt.aadl.ramses.transformation.trc.util.RuleApplicationTulpe ;
import fr.tpt.aadl.ramses.transformation.trc.util.TaggedRuleApplicationTulpe ;
import fr.tpt.aadl.ramses.transformation.trc.util.TrcUtils ;

public class DependencyValidation
{

  private TrcSpecification trc;
  private List<RuleApplicationTulpe> ruleApplicationList ;
  
  public DependencyValidation(TrcSpecification trc,
                              List<RuleApplicationTulpe> ruleApplicationList)
  {
    this.trc = trc;
    this.ruleApplicationList = ruleApplicationList;
  }

  public boolean validate()
  {
    
    for(RuleApplicationTulpe rat: ruleApplicationList)
    {
      List<List<TaggedRuleApplicationTulpe>> dependenciesDisjunctionList = 
          TrcUtils.getNormalizedDependencies(trc,
                                             rat.getPatternMatchedElement(),
                                             rat.getTransformationRuleName());
      if(dependenciesDisjunctionList.isEmpty())
        continue;
      
      boolean isDisjunctionValid = false;
      for(List<TaggedRuleApplicationTulpe> dependencyConjunctionList:
        dependenciesDisjunctionList)
      {
        if(validateConjunction(dependencyConjunctionList))
        {
          isDisjunctionValid = true;
          break;
        }
      }
      
      if(isDisjunctionValid==false)
        return false;
      
    }
    return true ;
  }

  private
      boolean
      validateConjunction(List<TaggedRuleApplicationTulpe> dependencyConjunctionList)
  {
    for(TaggedRuleApplicationTulpe trat: dependencyConjunctionList)
    {
      if(false==validateDependency(trat))
        return false;
    }
    return true ;
  }

  private boolean validateDependency(TaggedRuleApplicationTulpe trat)
  {
    // check if trat is valid in ruleApplicationList
    if(trat.isExclusion())
      return !isInRuleApplicationList(trat);
    else
      return isInRuleApplicationList(trat);
  }

  private boolean isInRuleApplicationList(TaggedRuleApplicationTulpe trat)
  {
    List<EObject> dependencyElements = trat.getPatternMatchedElement();
    String dependencyRule = trat.getTransformationRuleName();
    
    int indexInRuleApplicationList = ruleApplicationList.indexOf(dependencyElements);
    
    String solutionRule = ruleApplicationList
        .get(indexInRuleApplicationList)
        .getTransformationRuleName();
    
    return solutionRule.equals(dependencyRule) ;
  }

}
