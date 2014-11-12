package fr.tpt.aadl.ramses.transformation.selection.mcda;

import java.util.ArrayList ;
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

import fr.tpt.aadl.ramses.transformation.trc.TransformationImpact ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;
import fr.tpt.aadl.ramses.transformation.trc.util.RuleApplicationTulpe ;
import fr.tpt.aadl.ramses.transformation.trc.util.TrcUtils ;

public class TransformationRuleSelection
{
  private static Logger _LOGGER = Logger.getLogger(TrcUtils.class) ;
  
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
  
  // Returns a map of list of tuples associated with its performance (float).
  // This map is sorted according to the performance of the list of tuples.
  private SortedMap<List<RuleApplicationTulpe>, Float> orderPotentialSolutions()
  {

    // TODO: SG, if you can work on that part, it would be great
    // attribute "trc" would give you the impact of transformations on QA
    // attribute "alternativeMap" gives you the transformation rules alternatives to consider
    // QA model (quality attibutes definition and weights) is an excel file referenced
    // aqi files should be obtained from EObjects in the matched elements
    //    --> compute average values if several (and different) aqi files are referenced
    
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
    
    // 2 - cartesian product of the sets of tuples.
    
    unsortedSolutions = Sets.cartesianProduct(sets) ;
    
    // 3 - order the solution according to their performance.
    
    return orderSolutions(unsortedSolutions) ;
  }

  private SortedMap<List<RuleApplicationTulpe>, Float>orderSolutions(
                              Set<List<RuleApplicationTulpe>> unsortedSolutions)
  {
    TreeMap<List<RuleApplicationTulpe>, Float> result =
              new TreeMap<List<RuleApplicationTulpe>, Float>();
    
    for(List<RuleApplicationTulpe> listTuples: unsortedSolutions)
    {
      float perf = computePerformance(listTuples) ;
      result.put(listTuples, perf) ; // Sorts according to performance/ natural order.
    }
    
    return result ;
  }

  private Float computePerformance(List<RuleApplicationTulpe> listTuples)
  {
    float result = 0f ;
    
    float currentQaPerf ;
    
    QualityAttribute[] qas = getQualityAttributes(rootSystem) ;
    
    for(RuleApplicationTulpe tuple: listTuples)
    {
      setTrcPerformance(tuple.getTransformationRuleName(), qas) ;
      computeAqiPerf(tuple.getPatternMatchedElement(), qas) ;
      
      for(QualityAttribute currentQa: qas)
      {
        currentQaPerf = currentQa.qaWeight * (currentQa.trcImpact + currentQa.aqi) / 2 ;
        result += currentQaPerf ;
      }
    }
    
    return result ;
  }


  private void computeAqiPerf(List<EObject> patternMatchedElement,
                              QualityAttribute[] qas)
  {
    int[] count = new int[qas.length] ;
    
    for(int i = 0 ; i < qas.length ; i++)
    {
      count[i] = 0 ;
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
    
    if(element instanceof NamedElement)
    {
      NamedElement ne = (NamedElement) element ;
      
      // Quality attribute impacts are modeled by a list of AADL record properties.
      List<RecordValue> recs = PropertyUtils.getListRecordValue(ne,
                                        MCDAUtils.ACCEPTABLE_QUALITY_IMPACT_PS);
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
          else
          {
            // DEBUG
            System.out.println("********** ERROR ************** " + value) ;
          }
        }
      }
    }
    
    return result ;
  }

  private void setTrcPerformance(String transformationRuleName,
                                 QualityAttribute[] qas)
  {
    String transformationId = transformationRuleName.substring(0,
                                       transformationRuleName.lastIndexOf('/'));
    EList<TransformationImpact> tis = TrcUtils
    .getQualityImpactsForTransformation(trc,transformationId);
    
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
      else
      {
        // DEBUG
        _LOGGER.debug("********** ERROR ************** " + value) ;
      }
    }
    
    return result ;
  }
}

// Default value are 0 .
class QualityAttribute
{
  public String id = "" ;
  
  public long qaWeight = 0 ;
  
  public int trcImpact = 0 ;
  
  public long aqi = 0 ;
}