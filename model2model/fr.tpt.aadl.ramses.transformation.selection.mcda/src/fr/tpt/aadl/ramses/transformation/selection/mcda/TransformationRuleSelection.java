package fr.tpt.aadl.ramses.transformation.selection.mcda;

import java.util.ArrayList ;
import java.util.Comparator ;
import java.util.HashMap ;
import java.util.HashSet ;
import java.util.List ;
import java.util.Map ;
import java.util.Map.Entry ;
import java.util.Set ;
import java.util.SortedMap ;
import java.util.TreeMap ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EObject ;
import org.osate.aadl2.Aadl2Package ;
import org.osate.aadl2.BasicPropertyAssociation ;
import org.osate.aadl2.EnumerationLiteral ;
import org.osate.aadl2.IntegerLiteral ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.NamedValue ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.RecordValue ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.utils.PropertyUtils ;

import com.google.common.collect.Sets ;

import fr.tpt.aadl.ramses.control.support.utils.TrcUtils ;
import fr.tpt.aadl.ramses.transformation.selection.RuleApplicationUtils ;
import fr.tpt.aadl.ramses.transformation.trc.Transformation ;
import fr.tpt.aadl.ramses.transformation.trc.TransformationImpact ;
import fr.tpt.aadl.ramses.transformation.trc.TrcRule ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;
import fr.tpt.aadl.ramses.transformation.trc.util.RuleApplicationTuple ;

public class TransformationRuleSelection
{
  private static Logger _LOGGER = Logger.getLogger(TrcUtils.class) ;
  
  private TrcSpecification trc;
  private Map<List<EObject>, List<TrcRule>> alternativeMap;
  private SystemInstance rootSystem;
  
  public TransformationRuleSelection(TrcSpecification trc,
                                     SystemInstance rootSystem,
                                     Map<List<EObject>, List<TrcRule>> alternativeMap)
  {
    this.trc = trc;
    this.alternativeMap = alternativeMap;
    this.rootSystem = rootSystem;
  }

  public List<RuleApplicationTuple> selectBestRulesAlternatives()
  {
    // 1 - order potential results
    Set<List<RuleApplicationTuple>> orderedPotentialResults =
      orderPotentialSolutions().keySet();
    
    
    
    for(List<RuleApplicationTuple> potentialResults: orderedPotentialResults)
    {
      // 2 - validate dependencies
      DependencyValidation depValidation = 
          new DependencyValidation(trc,potentialResults);
      
      boolean validResult = depValidation.validate();
      if(validResult)
      {
        RuleApplicationTuple rat = potentialResults.get(0);
        return potentialResults;
      }
    }
    
    return null ;
  }
  
  // Returns a map of list of tuples associated with its performance (float).
  // This map is sorted according to the performance of the list of tuples.
  private SortedMap<List<RuleApplicationTuple>, Float> orderPotentialSolutions()
  {
    List<Set<RuleApplicationTuple>> sets = 
        new ArrayList<Set<RuleApplicationTuple>>(alternativeMap.size());
    
    Set<List<RuleApplicationTuple>> unsortedSolutions ;
    
    // 1 - browse elements in alternativeMap to construct "result" 
    
    for(Entry<List<EObject>, List<TrcRule>> e : alternativeMap.entrySet())
    {
      RuleApplicationTuple tmp ;
      List<EObject> elList = e.getKey() ;
      List<TrcRule> patterns = e.getValue() ;
      
      Set<RuleApplicationTuple> tuples = new HashSet<RuleApplicationTuple>
                                                             (patterns.size()) ;
      for(TrcRule pat: patterns)
      {
        tmp = new RuleApplicationTuple() ;
        tmp.setPatternMatchedElement(elList);
        tmp.setTransformationRule(pat);
        tuples.add(tmp) ;  
      }
      
      sets.add(tuples) ;
    }
    
    // 2 - cartesian product of the sets of tuples.
    
    unsortedSolutions = Sets.cartesianProduct(sets) ;
    
    // 3 - order the solution according to their performance.
    
    return orderSolutions(unsortedSolutions) ;
  }

  private SortedMap<List<RuleApplicationTuple>, Float>orderSolutions(
                              Set<List<RuleApplicationTuple>> unsortedSolutions)
  {
    final HashMap<List<RuleApplicationTuple>, Float> ref =
        new HashMap<List<RuleApplicationTuple>, Float>(unsortedSolutions.size());
    
    Comparator<List<RuleApplicationTuple>> comp = new Comparator
                                                  <List<RuleApplicationTuple>>()
    {
      @Override
      public int compare(List<RuleApplicationTuple> o1,
                         List<RuleApplicationTuple> o2)
      {
        int result = 0 ;
        
        Float perfO1 = ref.get(o1) ;
        Float perfO2 = ref.get(o2) ;
        
        result = perfO2.compareTo(perfO1) ; // Descending order.
        
        if(result == 0)
        {
          result = -1 ; // Priority to the already stored tuple. 
        }
        
        return result ;
      }
    } ;
    
    TreeMap<List<RuleApplicationTuple>, Float> result =
              new TreeMap<List<RuleApplicationTuple>, Float>(comp);
    
    for(List<RuleApplicationTuple> listTuples: unsortedSolutions)
    {
      float perf = computePerformance(listTuples) ;
      ref.put(listTuples, perf) ;
    }
    
    result.putAll(ref);
    
    StringBuilder sb  = new StringBuilder("list of tuples in descending order: \n") ;
    
    for(Entry<List<RuleApplicationTuple>, Float> e: result.entrySet())
    {
      sb.append("   list #");
      sb.append(e.getKey().hashCode()+"\n");
      for(RuleApplicationTuple rat: e.getKey())
      {
        sb.append("\t\t");
        String ratId =
            RuleApplicationUtils.getRuleApplicationAsString(rat);
        sb.append(ratId);
        sb.append("\n");
      }
      sb.append(" with perf:");
      sb.append(e.getValue()) ;
      sb.append('\n') ;
    }
    
    _LOGGER.debug(sb.toString()) ;
    
    return result ;
  }

  private Float computePerformance(List<RuleApplicationTuple> listTuples)
  {
    float result = 0f ;
    
    float currentQaPerf ;
    
    QualityAttribute[] qas = getQualityAttributes(rootSystem) ;
    
    StringBuilder sb = new StringBuilder() ;
    sb.append("--- liste of tuples #" + listTuples.hashCode() + " ---\n") ;
    
    for(RuleApplicationTuple tuple: listTuples)
    {
      setTrcPerformance(tuple.getTransformationRule(), qas) ;
      computeAqiPerf(tuple.getPatternMatchedElement(), qas) ;
      
      sb.append("   for tuple " + tuple.hashCode());
      sb.append(" ; ");
      sb.append("number of matched elements: ");
      sb.append(tuple.getPatternMatchedElement().size());
      sb.append('\n');
      
      for(QualityAttribute currentQa: qas)
      {
        currentQaPerf = currentQa.qaWeight * (currentQa.trcImpact + currentQa.aqi) / 2 ;
        result += currentQaPerf ;
        
        sb.append("       ");
        sb.append(currentQa.id);
        sb.append(" perf: ");
        sb.append(currentQaPerf);
        sb.append(" weight: ");
        sb.append(currentQa.qaWeight);
        sb.append(" aqi: ");
        sb.append(currentQa.aqi);
        sb.append(" trcImpact: ");
        sb.append(currentQa.trcImpact) ;
        sb.append('\n');
      }
    }
    
    sb.append("--- global performance: ");
    sb.append(result);
    sb.append(" ---\n");
    
    _LOGGER.debug(sb.toString()) ;
    
    return result ;
  }

  private void computeAqiPerf(List<EObject> patternMatchedElement,
                              QualityAttribute[] qas)
  {
    int[] count = new int[qas.length] ;
    
    for(int i = 0 ; i < qas.length ; i++)
    {
      count[i] = 0 ;
      qas[i].aqi = 0l ; // Reset from the previous computation.
    }
    
    for(EObject element: patternMatchedElement)
    {
      boolean[] hasAqi = addAqiPerf(element, qas) ;
      
      for(int i = 0 ; i < qas.length ; i++)
      {
        if(hasAqi[i])
        {
          count[i]++ ;
        }
      }
    }
    
    for(int i = 0 ; i < qas.length ; i++)
    {
      // Calculates the mean of provided impacts for a given quality attribute.
      qas[i].aqi /= count[i] ;
    }
  }

  // Add every impact found to the right quality attribute.
  // Returns found/not found impact for each quality attribute. 
  private boolean[] addAqiPerf(EObject element, QualityAttribute[] qas)
  {
    boolean[] result = new boolean[qas.length] ;
    
    for(int i = 0 ; i < result.length ; i++)
    {
      result[i] = false ;
    }
    
    NamedElement ne = MCDAUtils.getContainingNamedElement(element) ;
    
    // Quality attribute impacts are modeled by a list of AADL record properties.
    List<RecordValue> recs = 
        MCDAUtils.getAcceptableQualityImpacts(ne);
    
    for(RecordValue rv: recs)
    {
      EList<BasicPropertyAssociation> bpas = rv.getOwnedFieldValues() ;
      PropertyExpression value ;
      int classId ;
      long impact = -1l ;
      QualityAttribute selectedQa = null ;
      
      for(BasicPropertyAssociation bpa : bpas)
      {
        value = bpa.getOwnedValue() ;
        classId = value.eClass().getClassifierID() ;
        
        if(Aadl2Package.NAMED_VALUE == classId)
        {
          NamedValue nv = (NamedValue) value;

          if (Aadl2Package.ENUMERATION_LITERAL == nv.getNamedValue().eClass().
                                                                getClassifierID())
          {
            String enumLiteral = ((EnumerationLiteral) nv.getNamedValue()).
                                                                   getName() ;
            for(int i=0 ; i<qas.length; i++)
            {
              if(enumLiteral.equalsIgnoreCase(qas[i].id))
              {
                selectedQa = qas[i] ;
                result[i] = true ;
                break ;
              }
            }
            
            // Early affectation.
            if(impact != -1l)
            {
              selectedQa.aqi += impact ; 
              selectedQa = null ;
              impact = -1l ;
            }
          }
        }
        else if(Aadl2Package.INTEGER_LITERAL == classId )
        {
          impact = ((IntegerLiteral) value).getValue() ;
          
          // Early affectation.
          if(selectedQa != null)
          {
            selectedQa.aqi += impact ; 
            selectedQa = null ;
            impact = -1l ;
          }
        }
      }
    }
    
    return result ;
  }

  private void setTrcPerformance(TrcRule transformationRuleName,
                                 QualityAttribute[] qas)
  {
    Transformation t = TrcUtils.getTransformationById(trc,transformationRuleName);
    
    EList<TransformationImpact> tis = t.getImpacts();
    
    for(TransformationImpact ti: tis)
    {
      for(int i=0 ; i<qas.length; i++)
      {
        if(ti.getQualityAttributeName().equalsIgnoreCase(qas[i].id))
        {
          qas[i].trcImpact = ti.getImpactValue() ;
          break ;
        }
      }
    }
  }

  // Instantiates a quality attribute array with quality attribute's weight set.
  private QualityAttribute[] getQualityAttributes(SystemInstance system)
  {
    QualityAttribute[] result = null ;
    
    // Quality attribute weights are modeled by a list of AADL record properties.
    List<RecordValue> recs = PropertyUtils.getListRecordValue(system,
                                        MCDAUtils.QUALITY_ATTRIBUTES_WEIGHT_PS);
    
    if(recs != null)
    {
      result = new QualityAttribute[recs.size()] ;

      for(int i = 0 ; i < result.length ;  i++)
      {
        result[i] = toQualityAttribute(recs.get(i)) ;
      }
    }
    
    return result ;
  }
  
  private QualityAttribute toQualityAttribute(RecordValue qa)
  {
    QualityAttribute result = new QualityAttribute();

    EList<BasicPropertyAssociation> bpas = qa.getOwnedFieldValues() ;
    PropertyExpression value ;
    int classId ;
    
    for(BasicPropertyAssociation bpa : bpas)
    {
      value = bpa.getOwnedValue() ;
      classId = value.eClass().getClassifierID() ;
      
      if(Aadl2Package.NAMED_VALUE == classId)
      {
        NamedValue nv = (NamedValue) value;

        if (Aadl2Package.ENUMERATION_LITERAL == nv.getNamedValue().eClass().
                                                              getClassifierID())
        {
          EnumerationLiteral el = (EnumerationLiteral) nv.getNamedValue();
          result.id = el.getName() ;
        }
      }
      else if(Aadl2Package.INTEGER_LITERAL == classId )
      {
        result.qaWeight = ((IntegerLiteral) value).getValue() ;
      }
    }
    
    return result ;
  }
}

// Default value are 0 .
class QualityAttribute
{
  public String id = "" ;
  
  public long qaWeight = 0l ;
  
  public int trcImpact = 0 ;
  
  public long aqi = 0l ;
}