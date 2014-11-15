package fr.tpt.aadl.ramses.transformation.selection.mcda;

import java.util.List ;

import org.eclipse.emf.ecore.EObject ;

import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;
import fr.tpt.aadl.ramses.transformation.trc.util.RuleApplicationTuple ;
import fr.tpt.aadl.ramses.transformation.trc.util.TaggedRuleApplicationTuple ;
import fr.tpt.aadl.ramses.transformation.trc.util.TrcUtils ;

public class DependencyValidation
{

  private TrcSpecification trc;
  private List<RuleApplicationTuple> ruleApplicationList ;
  
  public DependencyValidation(TrcSpecification trc,
                              List<RuleApplicationTuple> ruleApplicationList)
  {
    this.trc = trc;
    this.ruleApplicationList = ruleApplicationList;
  }

  public boolean validate()
  {
    
    for(RuleApplicationTuple rat: ruleApplicationList)
    {
      List<List<TaggedRuleApplicationTuple>> dependenciesDisjunctionList = 
          TrcUtils.getNormalizedDependencies(trc,
                                             rat.getPatternMatchedElement(),
                                             rat.getTransformationRuleName());
      if(dependenciesDisjunctionList.isEmpty())
        continue;
      
      boolean isDisjunctionValid = false;
      for(List<TaggedRuleApplicationTuple> dependencyConjunctionList:
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
      validateConjunction(List<TaggedRuleApplicationTuple> dependencyConjunctionList)
  {
    for(TaggedRuleApplicationTuple trat: dependencyConjunctionList)
    {
      if(false==validateDependency(trat))
        return false;
    }
    return true ;
  }

  private boolean validateDependency(TaggedRuleApplicationTuple trat)
  {
    // check if trat is valid in ruleApplicationList
    if(trat.isExclusion())
      return !isInRuleApplicationList(trat);
    else
      return isInRuleApplicationList(trat);
  }

  private boolean isInRuleApplicationList(TaggedRuleApplicationTuple trat)
  {
    List<EObject> dependencyElements = trat.getPatternMatchedElement();
    String dependencyRule = trat.getTransformationRuleName();
    
    for(RuleApplicationTuple rat:ruleApplicationList)
    {
      boolean stop = false;
      for(EObject depObj:dependencyElements)
      {
        if(rat.getPatternMatchedElement().contains(depObj))
          continue;
        else
        {
          stop=true;
          break;
        }
      }
      if(stop)
        continue;
      if(rat.getTransformationRuleName().equals(dependencyRule))
        return true;
      else
        continue;
    }
    return false;
  }
}
