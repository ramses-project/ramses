package fr.tpt.aadl.ramses.transformation.selection.mcda;

import java.util.AbstractMap ;
import java.util.ArrayList ;
import java.util.Comparator ;
import java.util.HashSet ;
import java.util.List ;
import java.util.Map ;
import java.util.Map.Entry ;
import java.util.Set ;
import java.util.SortedMap ;
import java.util.TreeMap ;
import java.util.TreeSet ;

import org.eclipse.emf.ecore.EObject ;
import org.osate.aadl2.instance.SystemInstance ;

import com.google.common.collect.Sets ;

import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;
import fr.tpt.aadl.ramses.transformation.trc.util.RuleApplicationTulpe ;

public class TransformationRuleSelection
{

  private TrcSpecification trc;
  private Map<List<EObject>, List<String>> alternativeMap;
  private SystemInstance rootSystem;
  
  public TransformationRuleSelection(TrcSpecification trc,
                                     SystemInstance rootSystem,
                                     Map<List<EObject>, List<String>> alternativeMap)
  {
    this.trc = trc;
    this.alternativeMap = alternativeMap;
    this.rootSystem = rootSystem;
  }

  public List<RuleApplicationTulpe> selectBestRulesAlternatives()
  {
    // 1 - order potential results
    Set<List<RuleApplicationTulpe>> orderedPotentialResults =
      orderPotentialSolutions().keySet();
    
    
    
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

  private SortedMap<List<RuleApplicationTulpe>, Float> orderPotentialSolutions()
  {

    // TODO: SG, if you can work on that part, it would be great
    // attribute "trc" would give you the impact of transformations on QA
    // attribute "alternativeMap" gives you the transformation rules alternatives to consider
    // QA model (quality attibutes definition and weights) is an excel file referenced
    // air files should be obtained from EObjects in the matched elements
    //    --> compute average values if several (and different) air files are referenced
    
    // from the root system
    List<Set<RuleApplicationTulpe>> sets = 
        new ArrayList<Set<RuleApplicationTulpe>>(alternativeMap.size());
    
    Set<List<RuleApplicationTulpe>> unsortedSolutions ;
    
    // 1 - browse elements in alternativeMap to construct "result" 
    
    for(Entry<List<EObject>, List<String>> e : alternativeMap.entrySet())
    {
      RuleApplicationTulpe tmp ;
      List<EObject> elList = e.getKey() ;
      List<String> patterns = e.getValue() ;
      
      Set<RuleApplicationTulpe> tuples = new HashSet<RuleApplicationTulpe>
                                                             (patterns.size()) ;
      for(String pat: patterns)
      {
        tmp = new RuleApplicationTulpe() ;
        tmp.setPatternMatchedElement(elList);
        tmp.setTransformationRuleName(pat);
        tuples.add(tmp) ;  
      }
      
      sets.add(tuples) ;
    }
    
    unsortedSolutions = Sets.cartesianProduct(sets) ;
    
    return orderSolutions(unsortedSolutions) ;
  }

  private SortedMap<List<RuleApplicationTulpe>, Float>orderSolutions(
                              Set<List<RuleApplicationTulpe>> unsortedSolutions)
  {
    TreeMap<List<RuleApplicationTulpe>, Float> result =
              new TreeMap<List<RuleApplicationTulpe>, Float>();
    
    for(List<RuleApplicationTulpe> listTuples: unsortedSolutions)
    {
      Float perf = computePerformance(listTuples) ;
      result.put(listTuples, perf) ;
    }
    
    return result ;
  }

  private Float computePerformance(List<RuleApplicationTulpe> listTuples)
  {
    // TODO Auto-generated method stub
    return null ;
  }
}