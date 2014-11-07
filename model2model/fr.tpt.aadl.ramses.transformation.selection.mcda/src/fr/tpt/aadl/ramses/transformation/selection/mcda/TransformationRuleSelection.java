package fr.tpt.aadl.ramses.transformation.selection.mcda;

import java.util.ArrayList ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.emf.ecore.EObject ;
import org.osate.aadl2.instance.SystemInstance ;

import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;
import fr.tpt.aadl.ramses.transformation.trc.util.RuleApplicationTulpe ;

public class TransformationRuleSelection
{

  private TrcSpecification trc;
  private Map<List<EObject>, ArrayList<String>> alternativeMap;
  private SystemInstance rootSystem;
  
  public TransformationRuleSelection(TrcSpecification trc,
                                     SystemInstance rootSystem,
                                     Map<List<EObject>, ArrayList<String>> alternativeMap)
  {
    this.trc = trc;
    this.alternativeMap = alternativeMap;
    this.rootSystem = rootSystem;
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

    // TODO: SG, if you can work on that part, it would be great
    // attribute "trc" would give you the impact of transformations on QA
    // attribute "alternativeMap" gives you the transformation rules alternatives to consider
    // QA model (quality attibutes definition and weights) is an excel file referenced
    // air files should be obtained from EObjects in the matched elements
    //    --> compute average values if several (and different) air files are referenced
    
    // from the root system
    List<List<RuleApplicationTulpe>> result = 
        new ArrayList<List<RuleApplicationTulpe>>();
    // 1 - browse elements in alternativeMap to construct "result" 
     
    
    return null ;
  }
  
  
}
