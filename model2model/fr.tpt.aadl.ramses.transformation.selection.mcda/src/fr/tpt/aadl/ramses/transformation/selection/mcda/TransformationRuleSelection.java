package fr.tpt.aadl.ramses.transformation.selection.mcda;

import java.util.ArrayList ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.emf.ecore.EObject ;

import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;
import fr.tpt.aadl.ramses.transformation.trc.util.RuleApplicationTulpe ;

public class TransformationRuleSelection
{

  private TrcSpecification trc;
  private Map<List<EObject>, ArrayList<String>> alternativeMap;
  
  public TransformationRuleSelection(TrcSpecification trc, 
                                     Map<List<EObject>, ArrayList<String>> alternativeMap)
  {
    this.trc = trc;
    this.alternativeMap = alternativeMap;
  }

  public List<RuleApplicationTulpe> selectBestRulesAlternatives()
  {
    // 1 - order potential results
    List<List<RuleApplicationTulpe>> orderedPotentialResults =
      orderPotentialSolutions();
    
    
    
    for(List<RuleApplicationTulpe> potentialResults
        : orderedPotentialResults)
    {
      // 2 - validate dependencies
      DependencyValidation depValidation = 
          new DependencyValidation(trc,potentialResults);
      
      boolean validResult = depValidation.validate();
      if(validResult)
        return potentialResults;
    }
    return null ;
  }

  private List<List<RuleApplicationTulpe>> orderPotentialSolutions()
  {
    // TODO Auto-generated method stub
    // SG, if you can work on that part, it would be great
    // attribute trc would give you the impact of transformations on QA
    // attribute alternativeMap gives you the transformation rules alternatives to consider
    
    return null ;
  }
  
  
}
