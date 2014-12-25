package fr.tpt.aadl.ramses.transformation.selection.mcda;

import java.io.IOException ;
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

import jxl.write.WriteException ;

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

import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
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
  private ExcelFileWriter excelFileWriter;
  private RamsesConfiguration config;
  
  private Map<NamedElement, Integer> elementRow = 
      new HashMap<NamedElement, Integer>();
  private Map<Transformation, Integer> transformationRow = 
          new HashMap<Transformation, Integer>();
  
  private final int SECTIONS_SEPARATOR = 3;
  private int TRANSFOLIST_ROW_OFFSET = 2;
  private int ELEMENTLIST_ROW_OFFSET = 2;
  
  public TransformationRuleSelection(TrcSpecification trc,
                                     SystemInstance rootSystem,
                                     Map<List<EObject>, List<TrcRule>> alternativeMap,
                                     RamsesConfiguration config)
  {
    this.trc = trc;
    this.alternativeMap = alternativeMap;
    this.rootSystem = rootSystem;
    this.config = config;
  }

  int maxNbSolutions = 5;
  
  public List<ExcelPositionnedRuleApplicationTuple> selectBestRulesAlternatives(int id)
  {
    excelFileWriter = new ExcelFileWriter(config.getRamsesOutputDir()+"/ScoringForBlocK_"+id+".xls");
    
    // 1 - order potential results
    Set<List<ExcelPositionnedRuleApplicationTuple>> orderedPotentialResults =
      orderPotentialSolutions().keySet();
    
    List<ExcelPositionnedRuleApplicationTuple> result=null;
    int solution = 0;
    
    for(List<ExcelPositionnedRuleApplicationTuple> potentialResults: orderedPotentialResults)
    {
      // 2 - validate dependencies
      DependencyValidation depValidation = 
          new DependencyValidation(trc,potentialResults);
      
      boolean validResult = depValidation.validate();
      if(validResult)
      {
        if(solution==0)
          result = potentialResults;
        
        
        if(solution==maxNbSolutions)
          return result;
      }
    }
    
    return result ;
  }
  
  // Returns a map of list of tuples associated with its performance (float).
  // This map is sorted according to the performance of the list of tuples.
  private SortedMap<List<ExcelPositionnedRuleApplicationTuple>, Float> orderPotentialSolutions()
  {
    List<Set<ExcelPositionnedRuleApplicationTuple>> sets = 
        new ArrayList<Set<ExcelPositionnedRuleApplicationTuple>>(alternativeMap.size());
    
    Set<List<ExcelPositionnedRuleApplicationTuple>> unsortedSolutions ;
    
    // 1 - browse elements in alternativeMap to construct "result" 
    
    for(Entry<List<EObject>, List<TrcRule>> e : alternativeMap.entrySet())
    {
      ExcelPositionnedRuleApplicationTuple tmp ;
      List<EObject> elList = e.getKey() ;
      List<TrcRule> patterns = e.getValue() ;
      
      Set<ExcelPositionnedRuleApplicationTuple> tuples = new HashSet<ExcelPositionnedRuleApplicationTuple>
                                                             (patterns.size()) ;
      for(TrcRule pat: patterns)
      {
        tmp = new ExcelPositionnedRuleApplicationTuple() ;
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

  private SortedMap<List<ExcelPositionnedRuleApplicationTuple>, Float>orderSolutions(
                              Set<List<ExcelPositionnedRuleApplicationTuple>> unsortedSolutions)
  {
    final HashMap<List<ExcelPositionnedRuleApplicationTuple>, Float> ref =
        new HashMap<List<ExcelPositionnedRuleApplicationTuple>, Float>(unsortedSolutions.size());
    
    Comparator<List<ExcelPositionnedRuleApplicationTuple>> comp = new Comparator
                                                  <List<ExcelPositionnedRuleApplicationTuple>>()
    {
      @Override
      public int compare(List<ExcelPositionnedRuleApplicationTuple> o1,
                         List<ExcelPositionnedRuleApplicationTuple> o2)
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
    
    TreeMap<List<ExcelPositionnedRuleApplicationTuple>, Float> result =
              new TreeMap<List<ExcelPositionnedRuleApplicationTuple>, Float>(comp);
    
    for(List<ExcelPositionnedRuleApplicationTuple> listTuples: unsortedSolutions)
    {
      float perf = computePerformance(listTuples) ;
      ref.put(listTuples, perf) ;
    }
    
    result.putAll(ref);
    
    StringBuilder sb  = new StringBuilder("list of tuples in descending order: \n") ;
    
    for(Entry<List<ExcelPositionnedRuleApplicationTuple>, Float> e: result.entrySet())
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
    try
    {
      excelFileWriter.write();
    }
    catch(WriteException e1)
    {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    catch(IOException e1)
    {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    return result ;
  }

  private List<EObject> treatedEObjects = new ArrayList<EObject>();
  boolean first = true;
  
  private Float computePerformance(List<ExcelPositionnedRuleApplicationTuple> listTuples)
  {
    float result = 0f ;
    
    float currentQaPerf ;
    
    QualityAttribute[] qas = getQualityAttributes(rootSystem) ;
    try
    {
      if(first)
      {
        
        excelFileWriter.addLabel(2+qas.length/2,TRANSFOLIST_ROW_OFFSET,"Quality Importance");
        excelFileWriter.addLabel(2+qas.length/2+qas.length+SECTIONS_SEPARATOR,
                                 TRANSFOLIST_ROW_OFFSET,"Transformation Impact");
        TRANSFOLIST_ROW_OFFSET++;
        ELEMENTLIST_ROW_OFFSET++;
        excelFileWriter.addLabel(1,TRANSFOLIST_ROW_OFFSET,"Model Element (name)");
        excelFileWriter.addLabel(1+qas.length+SECTIONS_SEPARATOR,TRANSFOLIST_ROW_OFFSET,"Transformation (name)");
        for(int i=0; i<qas.length; i++)
        {
          excelFileWriter.addLabel(i+2,
                                   ELEMENTLIST_ROW_OFFSET,
                                   qas[i].qaId);
          excelFileWriter.addLabel(i+2+qas.length+SECTIONS_SEPARATOR,
                                   ELEMENTLIST_ROW_OFFSET,
                                   qas[i].qaId);
        }
        TRANSFOLIST_ROW_OFFSET++;
        ELEMENTLIST_ROW_OFFSET++;
        
        for(Transformation t: trc.
            getTransformationList().
            getTransformations())
        {
          excelFileWriter.addLabel(1+qas.length+SECTIONS_SEPARATOR,
                                   TRANSFOLIST_ROW_OFFSET,
                                   t.getName());
          for(int i=0; i<qas.length; i++)
          {
            for(TransformationImpact tImpact: t.getImpacts())
            {
              if(tImpact.getQualityAttributeName().equals(qas[i].qaId))
              {
                excelFileWriter.addNumber(i+2+qas.length+SECTIONS_SEPARATOR,
                                          TRANSFOLIST_ROW_OFFSET,
                                          tImpact.getImpactValue());
                transformationRow.put(t, TRANSFOLIST_ROW_OFFSET);
              }
            }
          }
          TRANSFOLIST_ROW_OFFSET++;
        }
        first = false;
      }

    }
    catch(WriteException e)
    {
      String message = "Could not write in Excel file to " +
          "store alternatives score";
      _LOGGER.fatal(message);
      ServiceProvider.SYS_ERR_REP.fatal(message, e);
    }
    StringBuilder sb = new StringBuilder() ;
    sb.append("--- liste of tuples #" + listTuples.hashCode() + " ---\n") ;
    
    for(ExcelPositionnedRuleApplicationTuple tuple: listTuples)
    {
      setTrcPerformance(tuple.getTransformationRule(), qas) ;
      List<Integer> rows = computeAqiPerf(tuple.getPatternMatchedElement(), qas) ;
      tuple.setElementRow(rows);
      Transformation t = TrcUtils.getTransformationById(trc,tuple.getTransformationRule());
      tuple.setTransformationRow(transformationRow.get(t));
      
      sb.append("   for tuple " + tuple.hashCode());
      sb.append(" ; ");
      sb.append("number of matched elements: ");
      sb.append(tuple.getPatternMatchedElement().size());
      sb.append('\n');
      
      for(QualityAttribute currentQa: qas)
      {
        currentQaPerf = currentQa.trcImpact * currentQa.aqi ;
        result += currentQaPerf ;
        
        sb.append("       ");
        sb.append(currentQa.qaId);
        sb.append(" perf: ");
        sb.append(currentQaPerf);
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

  private List<Integer> computeAqiPerf(List<EObject> patternMatchedElement,
                              QualityAttribute[] qas)
  {
    List<Integer> result = new ArrayList<Integer>();
    int[] count = new int[qas.length] ;
    
    for(int i = 0 ; i < qas.length ; i++)
    {
      count[i] = 0 ;
      qas[i].aqi = 0l ; // Reset from the previous computation.
    }
    
    for(EObject element: patternMatchedElement)
    { 
      Integer row = addAqiPerf(element, qas);
      if(row!=-1)
      result.add(row) ;
    }
    return result;
  }

  // Add every impact found to the right quality attribute.
  // Returns found/not found impact for each quality attribute. 
  private Integer addAqiPerf(EObject element, QualityAttribute[] qas)
  {
    
    
    NamedElement ne = MCDAUtils.getContainingNamedElement(element) ;
    
    // Quality attribute impacts are modeled by a list of AADL record properties.
    List<RecordValue> recs = 
        MCDAUtils.getAcceptableQualityImpacts(ne);
    NamedElement resultingElement = MCDAUtils.getResultingElement();
    if(resultingElement==null
        || treatedEObjects.contains(resultingElement)
        || recs.isEmpty())
      return -1;
    treatedEObjects.add(resultingElement);
    
    
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
              if(enumLiteral.equalsIgnoreCase(qas[i].qaId))
              {
                selectedQa = qas[i] ;
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
    
    try
    {
      if(elementRow.containsKey(resultingElement)==false)
      {
        elementRow.put(resultingElement, ELEMENTLIST_ROW_OFFSET);
        excelFileWriter.addLabel(1,ELEMENTLIST_ROW_OFFSET,resultingElement.getName());
        for(int i = 0; i<qas.length; i++)
        {
          excelFileWriter.addNumber(i+2,
                                    ELEMENTLIST_ROW_OFFSET,
                                    qas[i].aqi);
        }
        ELEMENTLIST_ROW_OFFSET++;
      }
    }
    catch(WriteException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return elementRow.get(resultingElement) ;
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
        if(ti.getQualityAttributeName().equalsIgnoreCase(qas[i].qaId))
        {
          qas[i].transformationName = t.getName();
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
          result.qaId = el.getName() ;
        }
      }
    }
    
    return result ;
  }
}

// Default value are 0 .
class QualityAttribute
{
  public String qaId = "" ;
  
  public int trcImpact = 0 ;
  
  public String transformationName = "";
  
  public long aqi = 0l ;
}