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

  private MemoryFootprintAnalysis(){}
  private static SystemInstance root;
  private final static AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE;
  private static int iterationCounter=0;
  public static void doAnalysis(SystemInstance s, AnalysisArtifact currentResult )
  {
    root=s;
    boolean analysisValid = true;

    final QualitativeAnalysisResult qar = f.createQualitativeAnalysisResult();
    qar.setValidated(true);
    AnalysisSource sourceQar = f.createAnalysisSource();
    sourceQar.setMethodName(MemoryFootprintAnalyzer.PLUGIN_NAME);
    sourceQar.setScope(s.getQualifiedName());
    qar.setSource(sourceQar);
    iterationCounter++;
    /** For each process create a result indicating memory overhead margin */
    for (ComponentInstance c : s.getAllComponentInstances())
    {
      double margin; 
      // check Memory Component
      if (c.getCategory()==ComponentCategory.MEMORY)
      {
        margin = getMemoryComponentMargin (c);
      }
      // check Process Component
      else if (c.getCategory()==ComponentCategory.PROCESS)
      {
        margin = getProcessComponentMargin(c);
      }
      // check Thread components
      else if (c.getCategory()==ComponentCategory.THREAD)
      {
        margin = getThreadComponentMargin(c);
      }
      else
        margin=2; // impossible value as a result of analysis
      
      if(margin<2)
      {                
        analysisValid &= (margin >= 0d);
        addQualitativeAnalysisResult(currentResult, c, analysisValid);

        AnalysisSource source = f.createAnalysisSource();
        source.setMethodName(MemoryFootprintAnalyzer.PLUGIN_NAME);
        source.setScope(c.getName());
        source.setIterationId(iterationCounter);
        
        QuantitativeAnalysisResult r = f.createQuantitativeAnalysisResult();
        r.setSource(source);
        r.setMargin((float) margin);
        currentResult.getResults().add(r);
      }
      if(margin<0
          && qar.isValidated())
      {
        qar.setValidated(false);
      }
    }
    
    /** For the whole system, create a global result indicating 
     *  if memory size is enough. */
    AnalysisSource source = f.createAnalysisSource();
    source.setMethodName(MemoryFootprintAnalyzer.PLUGIN_NAME);
    
    QualitativeAnalysisResult r = f.createQualitativeAnalysisResult();
    r.setSource(source);
    r.setValidated(analysisValid);
    currentResult.getResults().add(r);
    
  }
  
  private static void addQualitativeAnalysisResult(AnalysisArtifact a, ComponentInstance c, boolean valid)
  {
    final QualitativeAnalysisResult qar = f.createQualitativeAnalysisResult();
    qar.setValidated(valid);
    AnalysisSource sourceQar = f.createAnalysisSource();
    sourceQar.setMethodName(MemoryFootprintAnalyzer.PLUGIN_NAME);
    sourceQar.setScope(c.getQualifiedName());
    qar.setSource(sourceQar);
  }
  
  private static double getThreadComponentMargin(ComponentInstance threadComponent)
  {
    final long threadSize = getThreadSize(threadComponent);
    final long consumption = getThreadSucomponentConsumption(threadComponent);
    if(threadSize!=0)
      return (threadSize-consumption)/threadSize;
    return 2; // TODO
  }
  
  private static long getThreadSucomponentConsumption(ComponentInstance threadComponent)
  {
    long consumption = 0 ;

    for(ComponentInstance c : threadComponent.getAllComponentInstances())
    {
      if(c.getCategory() == ComponentCategory.DATA)
      {
        consumption += DataSizeHelper.getOrComputeDataSize(c) ;
      }
    }
    
    // TODO: add stack and heap of subprograms
    
    return consumption ;
  }

  private static double getProcessComponentMargin(ComponentInstance processComponent)
  {
    final long procSize = getProcessSize(processComponent);
    final long consumption=getProcessSubcomponentsConsumption(processComponent);
    if(procSize!=0)
      return (procSize-consumption)/procSize;
    return 0;
  }
  
  private static double getMemoryComponentMargin(ComponentInstance memoryComponent)
  {
    final long memSize = getMemorySize(memoryComponent);
    long consumption=0;
    // get Processes binded to memory component
    for (ComponentInstance processComponent : root.getAllComponentInstances())
    {
      if (processComponent.getCategory()==ComponentCategory.PROCESS)
      {
        PropertyExpression pex = null;
        try
        {
          pex = PropertyUtils.getPropertyValue("Actual_Memory_Binding", processComponent) ;
        }
        catch(Exception e)
        {
          _LOGGER.warn("No memory bound to process " + processComponent.getName(), e);
          return 0;
        }
        
        ListValue lv = (ListValue) pex ;
        PropertyExpression pe = lv.getOwnedListElements().get(0) ;

        if(pe instanceof InstanceReferenceValue)
        {
          InstanceReferenceValue irv = (InstanceReferenceValue) pe ;
          ComponentInstance mem = (ComponentInstance) irv.getReferencedInstanceObject() ;
          if(mem!=memoryComponent)
            continue;
          consumption+=getProcessMemoryUsage(processComponent);
        }
      }
    }
    if(memSize!=0)
      return (memSize-consumption)/memSize;
    return 0;
  }

  private static long getProcessSubcomponentsConsumption(ComponentInstance p)
  {
    long consumption = 0 ;

    for(ComponentInstance c : p.getAllComponentInstances())
    {
      if(c.getCategory() == ComponentCategory.THREAD)
      {
        consumption += getThreadStaticSize(c) ;
      }
      else if(c.getCategory() == ComponentCategory.DATA)
      {
        consumption += DataSizeHelper.getOrComputeDataSize(c) ;
      }
    }

    return consumption ;
  }

  private static long getMemorySize(ComponentInstance memory)
  {
    return getPropertyBytesValue(memory, "Memory_Size") ;
  }
  
  private static long getProcessSize(ComponentInstance process)
  {
    return getComponentCodeMemory(process)
        +getComponentDataMemory(process);
  }
  
  private static long getProcessMemoryUsage(ComponentInstance e)
  {
    long memoryUsage = getComponentCodeMemory(e)
        +getComponentDataMemory(e);
    
    for (ComponentInstance threadComponent : e.getAllComponentInstances())
    {
      if (threadComponent.getCategory()==ComponentCategory.THREAD)
      {
        memoryUsage+=getThreadDynamicSize(threadComponent);
      }
    }
    
    return memoryUsage;
  }

  private static long getThreadSize(ComponentInstance e)
  {
    return getThreadStaticSize(e)
        +getThreadDynamicSize(e);
  }
  
  private static long getThreadStaticSize(ComponentInstance e)
  {
    return getComponentCodeMemory(e)
        +getComponentDataMemory(e);
  }
  
  private static long getThreadDynamicSize(NamedElement e)
  {
   return getComponentStackMemory(e)
       +getComponentHeapMemory(e);
  }
  
  private static long getComponentCodeMemory(NamedElement e)
  {
    return getPropertyBytesValue(e, "Code_Size") ;
  }
  
  private static long getComponentDataMemory(NamedElement e)
  {
    return getPropertyBytesValue(e, "Data_Size") ;
  }
  
  private static long getComponentStackMemory(NamedElement e)
  {
    return getPropertyBytesValue(e, "Stack_Size") ;
  }

  private static long getComponentHeapMemory(NamedElement e)
  {
    return getPropertyBytesValue(e, "Heap_Size") ;
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
