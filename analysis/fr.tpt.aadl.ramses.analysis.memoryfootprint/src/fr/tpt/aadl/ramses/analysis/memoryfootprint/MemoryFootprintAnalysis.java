package fr.tpt.aadl.ramses.analysis.memoryfootprint ;

import org.apache.log4j.Logger ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.InstanceReferenceValue ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.launch.MemoryFootprintAnalyzer ;
import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory ;
import fr.tpt.aadl.ramses.analysis.AnalysisSource ;
import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult ;
import fr.tpt.aadl.ramses.analysis.QuantitativeAnalysisResult ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;

public class MemoryFootprintAnalysis
{
  private final static Logger _LOGGER = Logger.getLogger(MemoryFootprintAnalysis.class) ;

  //Source_Data_Size + Source_Code_Size + Source_Stack_Size < Word_Count (memory)

  private MemoryFootprintAnalysis(){}
  
  private final static AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE;
  
  public static AnalysisArtifact doAnalysis(SystemInstance s)
  {
    final AnalysisArtifact a = f.createAnalysisArtifact();
    boolean analysisValid = true;
    
    /** For each process create a result indicating memory overhead margin */
    for (ComponentInstance c : s.getAllComponentInstances())
    {
      if (c.getCategory()==ComponentCategory.PROCESS)
      {
        final double margin = getProcessMargin (c);
        
        analysisValid &= (margin >= 0d);
        
        AnalysisSource source = f.createAnalysisSource();
        source.setMethodName(MemoryFootprintAnalyzer.PLUGIN_NAME);
        source.setScope(c.getName());
        
        QuantitativeAnalysisResult r = f.createQuantitativeAnalysisResult();
        r.setSource(source);
        r.setMargin((float) margin);
        a.getResults().add(r);
        
      }
    }
    
    /** For the whole system, create a global result indicating 
     *  if memory size is enough. */
    AnalysisSource source = f.createAnalysisSource();
    source.setMethodName(MemoryFootprintAnalyzer.PLUGIN_NAME);
    
    QualitativeAnalysisResult r = f.createQualitativeAnalysisResult();
    r.setSource(source);
    r.setValidated(analysisValid);
    a.getResults().add(r);
    
    return a;
  }
  
  private static double getProcessMargin(ComponentInstance p)
  {
    PropertyExpression pex = null;
    try
    {
      pex = PropertyUtils.getPropertyValue("Actual_Memory_Binding", p) ;
    }
    catch(Exception e)
    {
      _LOGGER.warn("No memory bound to process " + p.getName(), e);
      return 0;
    }
    
    ListValue lv = (ListValue) pex ;
    PropertyExpression pe = lv.getOwnedListElements().get(0) ;

    if(pe instanceof InstanceReferenceValue)
    {
      InstanceReferenceValue irv = (InstanceReferenceValue) pe ;
      ComponentInstance mem = (ComponentInstance) irv.getReferencedInstanceObject() ;
      
      final long memSize = getMemorySize(mem);
      return ((double) (memSize - getProcessOverhead (p))) / memSize;
    }
    else
    {
      return 0;
    }
  }

  private static long getProcessOverhead(ComponentInstance p)
  {
    long overhead = 0 ;

    for(ComponentInstance c : p.getAllComponentInstances())
    {
      if(c.getCategory() == ComponentCategory.THREAD)
      {
        overhead += getComponentOverhead(c) ;
      }
      else if(c.getCategory() == ComponentCategory.DATA)
      {
        overhead += DataSizeHelper.getOrComputeDataSize(c) ;
      }
    }

    return overhead ;
  }

  private static long getMemorySize(NamedElement memory)
  {
    return getPropertyBytesValue(memory, "Memory_Size") ;
  }

  private static long getComponentOverhead(NamedElement e)
  {
    final long Data_Size = getPropertyBytesValue(e, "Data_Size") ;
    final long Code_Size = getPropertyBytesValue(e, "Code_Size") ;
    final long Stack_Size = getPropertyBytesValue(e, "Stack_Size") ;

    return Data_Size + Code_Size + Stack_Size ;
  }

  private static long getPropertyBytesValue(NamedElement e,
                                            String property)
  {
    try
    {
      return PropertyUtils.getIntValue(e, property) ;
    }
    catch(Exception e1)
    {
      _LOGGER.warn("Property " + property + " undefined for element " +
                         e.getName(), e1) ;
      return 0 ;
    }
  }
}
