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
import jxl.write.biff.RowsExceededException ;

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
  private RamsesConfiguration config;
  
  private static Map<NamedElement, Integer> elementRow = 
      new HashMap<NamedElement, Integer>();
  private static Map<Transformation, Integer> transformationRow = 
          new HashMap<Transformation, Integer>();
  
  private final int SECTIONS_SEPARATOR = 3;
  private int TRANSFOLIST_ROW_OFFSET = 2;
  private static int ELEMENTLIST_ROW_OFFSET = 2;
  
  private ExcelFileWriter excelFileWriter;
  
  private List<List<ExcelPositionnedRuleApplicationTuple>> potentialResultListList = 
      new ArrayList<List<ExcelPositionnedRuleApplicationTuple>>();
  
  
  public TransformationRuleSelection(TrcSpecification trc,
                                     SystemInstance rootSystem,
                                     Map<List<EObject>, List<TrcRule>> alternativeMap,
                                     RamsesConfiguration config,
                                     ExcelFileWriter excelFileWriter)
  {
    this.trc = trc;
    this.alternativeMap = alternativeMap;
    this.rootSystem = rootSystem;
    this.config = config;
    this.excelFileWriter = excelFileWriter;
  }

  int maxNbSolutions = 5;
  
  public List<ExcelPositionnedRuleApplicationTuple> selectBestRulesAlternatives()
  {
    
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
      synchronized(rootSystem)
      {
        if(validResult)
        {
          if(solution==0)
          {
            result = potentialResults;
          }

          solution++;
          potentialResultListList.add(potentialResults);
          if(solution==maxNbSolutions)
            return result;
        }
      }
    }
    
    return result ;
  }
  
  private String getColumnLetter(int i)
  {
    String letter = "\0";
    switch ( i )
    {
      case 0 :
        letter = "C";
        break ;
      case 1 :
        letter = "D";
        break;
      case 2 :
        letter = "E";
        break;
      case 3 :
        letter = "F";
        break;
      case 4:
        letter = "G";
        break;
      case 5:
        letter = "H";
        break;
      case 6:
        letter = "I";
        break;
      case 7:
        letter = "J";
        break;
      case 8:
        letter = "K";
        break;
      case 9:
        letter = "L";
        break;
      case 10:
        letter = "M";
        break;
      case 11:
        letter = "N";
        break;
      case 12:
        letter = "O";
        break;
      case 13:
        letter = "P";
        break;
      case 14:
        letter = "Q";
        break;
      case 15:
        letter = "R";
        break;
      case 16:
        letter = "S";
        break;
      case 17:
        letter = "T";
        break;
      case 18:
        letter = "U";
        break;
      case 19:
        letter = "V";
        break;
      case 20:
        letter = "W";
        break;
      case 21:
        letter = "X";
        break;
      case 22:
        letter = "Y";
        break;
      case 23:
        letter = "Z";
        break;
    }
    return letter;
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
      treatedEObjects.clear();
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
    
    return result ;
  }

  private List<EObject> treatedEObjects = new ArrayList<EObject>();
  
  public static boolean first = true;
  
  private Float computePerformance(List<ExcelPositionnedRuleApplicationTuple> listTuples)
  {
    float result = 0f ;
    
    float currentQaPerf ;
    
    QualityAttribute[] qas = getQualityAttributes(rootSystem) ;
    try
    {
      synchronized(this.rootSystem)
      {
        if(TransformationRuleSelection.first)
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
          TransformationRuleSelection.first = false;
        }

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
      synchronized(this.rootSystem)
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
    }
    catch(WriteException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    int res = -1;
    synchronized(this.rootSystem)
    {
      res = elementRow.get(resultingElement) ;
    }
    return res;
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

  
  public static int block = 0;
  
  public synchronized void addSolutionsToExcelSheet()
  {
    try
    {
      if(block==0)
      {
        ELEMENTLIST_ROW_OFFSET=ELEMENTLIST_ROW_OFFSET+2;
        excelFileWriter.addLabel(2,
                                 ELEMENTLIST_ROW_OFFSET,
            "Blocks (with dependencies)");
        excelFileWriter.addLabel(4,
                                 ELEMENTLIST_ROW_OFFSET,
                                 "Alternatives score");

        ELEMENTLIST_ROW_OFFSET=ELEMENTLIST_ROW_OFFSET+2;
      }

      block++;
      excelFileWriter.addLabel(2,
                               ELEMENTLIST_ROW_OFFSET,
                               "Block "+block);
      
      int block_column = 2;
      
      QualityAttribute[] qas = getQualityAttributes(rootSystem) ;
      int alternativeNb = 0;
      for(List<ExcelPositionnedRuleApplicationTuple> potentialResultList: 
        potentialResultListList)
      {
        String computationString = "";
        alternativeNb++;
        block_column = block_column+2;
        
        excelFileWriter.addLabel(block_column,
                                 ELEMENTLIST_ROW_OFFSET,
                                 "Alternative "+ alternativeNb);
        Integer epratCounter=0;
        String tupleString = "[";
        for(ExcelPositionnedRuleApplicationTuple eprat:potentialResultList)
        {
          tupleString += "("+eprat.getTransformationRule().getName()+" - ";
          int eObjeCounter=0;
          for(EObject eObj: eprat.getPatternMatchedElement())
          {
            NamedElement ne = (NamedElement) eObj;
            tupleString+=ne.getName();
            eObjeCounter++;
            if(eObjeCounter!=eprat.getPatternMatchedElement().size())
              tupleString+=";";
          }
            
          tupleString += ") ";
          
          List<Integer> importanceList = eprat.getElementRow();
          if(false==importanceList.isEmpty())
          {
            if(epratCounter>0)
              computationString += "+";
            epratCounter++;
          }
          Integer impact = eprat.getTransformationRow();
          // Add (Element, Transfo)
          int counter = 0;
          for(Integer importance: importanceList)
          {
            int realImportance=importance+1;
            int realImpact = impact+1;
            for(int i=0; i<qas.length; i++)
            {
              String letterElem = getColumnLetter(i);
              String letterTransfo = getColumnLetter(qas.length+i+SECTIONS_SEPARATOR);
              computationString += letterElem+realImportance+
                  "*"+
                  letterTransfo+
                  realImpact;
              if(i!=qas.length-1)
                computationString += "+";
            }
            counter++;
            if(importanceList.size()!=counter)
            {
              computationString+="+";
            }
          }
        }
        tupleString += "]";
        excelFileWriter.addLabel(block_column,
                                   ELEMENTLIST_ROW_OFFSET+2,
                                   tupleString);
        if(computationString.length()>1)
          excelFileWriter.addFormula(block_column,
                                     ELEMENTLIST_ROW_OFFSET+1,
                                     computationString);
      }
      ELEMENTLIST_ROW_OFFSET = ELEMENTLIST_ROW_OFFSET + 3;
    }
    catch(RowsExceededException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    catch(WriteException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

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