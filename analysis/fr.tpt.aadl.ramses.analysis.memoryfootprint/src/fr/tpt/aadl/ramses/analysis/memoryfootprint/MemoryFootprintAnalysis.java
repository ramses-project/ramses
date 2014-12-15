package fr.tpt.aadl.ramses.analysis.memoryfootprint ;

import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.apache.log4j.Logger ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.BehavioredImplementation ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.ComponentImplementation ;
import org.osate.aadl2.DataAccess ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.DataSubcomponentType ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Parameter ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.SubprogramCall ;
import org.osate.aadl2.SubprogramCallSequence ;
import org.osate.aadl2.SubprogramClassifier ;
import org.osate.aadl2.SubprogramImplementation ;
import org.osate.aadl2.SubprogramType ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.InstanceReferenceValue ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.ba.aadlba.BehaviorAction ;
import org.osate.ba.aadlba.BehaviorActionBlock ;
import org.osate.ba.aadlba.BehaviorActionSequence ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorTransition ;
import org.osate.ba.aadlba.BehaviorVariable ;
import org.osate.ba.aadlba.SubprogramCallAction ;
import org.osate.utils.Aadl2Utils ;
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

  public MemoryFootprintAnalysis(){}
  private SystemInstance root;
  private final AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE;
  private int iterationCounter;
  private Map<ComponentInstance, ComponentInstance> memoryMap =
      new HashMap<ComponentInstance, ComponentInstance>();
  private final String CODE_SIZE = "Code_Size";
  private final String DATA_SIZE = "Data_Size";
  private final String HEAP_SIZE = "Heap_Size";
  private final String STACK_SIZE = "Stack_Size";
  private ComponentInstance currentMemory=null;
  
  private boolean analysisValid = true;
  
  public void doAnalysis(SystemInstance s, AnalysisArtifact currentResult, int iterationCounter)
  {
    root=s;
    this.iterationCounter = iterationCounter;
    final QualitativeAnalysisResult qar = f.createQualitativeAnalysisResult();
    qar.setValidated(true);
    AnalysisSource sourceQar = f.createAnalysisSource();
    sourceQar.setMethodName(MemoryFootprintAnalyzer.PLUGIN_NAME);
    sourceQar.setScope(s.getQualifiedName());
    sourceQar.setIterationId(iterationCounter);
    qar.setSource(sourceQar);
    double margin=2; 
    /** For each process create a result indicating memory overhead margin */
    for (ComponentInstance c : s.getAllComponentInstances())
    {
      // check Memory Component and fill in map (process/thread --> memory)
      if (c.getCategory()==ComponentCategory.MEMORY)
      {
        margin = getMemoryComponentMargin (c);
        addResult(currentResult, margin, c, qar);
      }
    }
    for (ComponentInstance c : s.getAllComponentInstances())
    {  
      // check Process Component
      if (c.getCategory()==ComponentCategory.PROCESS)
      {
        currentMemory=memoryMap.get(c);
        margin = getProcessComponentMargin(c);
        addResult(currentResult, margin, c, qar);
      }
      // check Thread components
      else if (c.getCategory()==ComponentCategory.THREAD)
      {
        currentMemory=memoryMap.get(c);
        margin = getThreadComponentMargin(c);
        addResult(currentResult, margin, c, qar);
      }
      else
        margin=2; // impossible value as a result of analysis
    }
    
    /** For the whole system, create a global result indicating 
     *  if memory size is enough. */
    AnalysisSource source = f.createAnalysisSource();
    source.setMethodName(MemoryFootprintAnalyzer.PLUGIN_NAME);
    source.setScope(s.getQualifiedName());
    source.setIterationId(iterationCounter);
    
    QualitativeAnalysisResult r = f.createQualitativeAnalysisResult();
    r.setSource(source);
    r.setValidated(analysisValid);
    currentResult.getResults().add(r);
    
  }
  
  private void addResult(AnalysisArtifact currentResult,
                                double margin, 
                                ComponentInstance c,
                                QualitativeAnalysisResult qar)
  {
    if(margin<2)
    {                
      analysisValid &= (margin >= 0d);
      addQualitativeAnalysisResult(currentResult, c, analysisValid);

      AnalysisSource source = f.createAnalysisSource();
      source.setMethodName(MemoryFootprintAnalyzer.PLUGIN_NAME);
      source.setScope(c.getQualifiedName());
      source.setIterationId(iterationCounter);
      
      QuantitativeAnalysisResult r = f.createQuantitativeAnalysisResult();
      r.setSource(source);
      r.setMargin((float) margin);
      currentResult.getResults().add(r);
    }
    else
      analysisValid = false;
    qar.setValidated(analysisValid);
    if(margin<0
        && qar.isValidated())
    {
      qar.setValidated(false);
    }
  }
  
  private void addQualitativeAnalysisResult(AnalysisArtifact a, ComponentInstance c, boolean valid)
  {
    final QualitativeAnalysisResult qar = f.createQualitativeAnalysisResult();
    qar.setValidated(valid);
    AnalysisSource sourceQar = f.createAnalysisSource();
    sourceQar.setMethodName(MemoryFootprintAnalyzer.PLUGIN_NAME);
    sourceQar.setScope(c.getQualifiedName());
    sourceQar.setIterationId(iterationCounter);
    qar.setSource(sourceQar);
  }
  
  private double getThreadComponentMargin(ComponentInstance threadComponent)
  {
    final double threadCodeSize = getComponentCodeMemory(threadComponent);
    final double threadCodeConsumption=getSubcomponentsConsumption(threadComponent, CODE_SIZE);
    
    double marginCode=2;
    if(threadCodeSize!=0)
      marginCode = (threadCodeSize-threadCodeConsumption)/threadCodeSize;
    
    final double threadDataSize = getComponentDataMemory(threadComponent);
    final double threadDataConsumption=getSubcomponentsConsumption(threadComponent, DATA_SIZE);
    
    double marginData=2;
    if(threadDataSize!=0)
      marginData = (threadDataSize-threadDataConsumption)/threadDataSize;
    
    
    double marginHeap=2;
    final double threadHeapSize = getComponentHeapMemory(threadComponent);
    final double threadHeapConsumption=getSubcomponentsConsumption(threadComponent, HEAP_SIZE);
    if(threadHeapSize!=0)
      marginHeap = (threadHeapSize-threadHeapConsumption)/threadHeapSize;
    
    
    double marginStack=2;
    final double threadStackSize = getComponentStackMemory(threadComponent);
    final double threadStackConsumption=getSubcomponentsConsumption(threadComponent, STACK_SIZE);
    if(threadStackSize!=0)
      marginStack = (threadStackSize-threadStackConsumption)/threadStackSize;
    
    double min1 = Math.min(marginHeap, marginStack);
    double min2 = Math.min(marginCode, marginData);
    return Math.min(min1,min2);
    
  }
  
  private double computeStackConsumption(NamedElement component)
  {
    double consumption = 0 ;
    if(component instanceof BehavioredImplementation)
    {
      BehavioredImplementation bi = (BehavioredImplementation) component;
      consumption += getConsumption(bi, STACK_SIZE);
    }
    return consumption ;
  }

  private double getConsumption(BehavioredImplementation bi, String PropertyName)
  {
    double consumption=0;
    double subprogramsMaxStack=0;
    if(PropertyName.equals(STACK_SIZE))
    {
      List<Feature> params=null;
      if(bi instanceof SubprogramImplementation)
      {
        SubprogramImplementation si = (SubprogramImplementation) bi;
        SubprogramType st = si.getType();
        params=st.getOwnedFeatures();
      }
      else if(bi instanceof SubprogramType)
      {
        SubprogramType st = (SubprogramType) bi;
        params=st.getOwnedFeatures();
      }
      if(params!=null)
      {
        for(Feature f: params)
        {
          DataSubcomponentType dst;
          if(f instanceof Parameter)
          {
            Parameter p = (Parameter) f;
            
            if(Aadl2Utils.isInOutParameter(p) || Aadl2Utils.isOutParameter(p) ||
                Aadl2Utils.getParameterUsage(p).equalsIgnoreCase("by_reference"))
              consumption+=getWordSize(currentMemory);
            else
            {
              dst = p.getDataFeatureClassifier();
              consumption+=DataSizeHelper.getOrComputeDataSize(dst);
            }
          }
          else if(f instanceof DataAccess)
          {
            DataAccess da = (DataAccess) f;
            if(Aadl2Utils.isReadWriteDataAccess(da) ||
                Aadl2Utils.isWriteOnlyDataAccess(da))
              consumption+=getWordSize(currentMemory);
            else
            {
              dst = da.getDataFeatureClassifier();
              consumption+=DataSizeHelper.getOrComputeDataSize(dst);
            }
          }
        }
      }
    }
    
    if(bi instanceof ComponentImplementation)
    {
      ComponentImplementation ci = (ComponentImplementation) bi;
      for(Subcomponent s: ci.getOwnedSubcomponents())
      {
        if(s.getSubcomponentType() instanceof DataClassifier)
        {
          DataClassifier dc = (DataClassifier) s.getSubcomponentType();
          consumption+=DataSizeHelper.getOrComputeDataSize(dc);
        }
      }
    }
    for(AnnexSubclause as: bi.getOwnedAnnexSubclauses())
    {
      if(as instanceof BehaviorAnnex)
      {
        BehaviorAnnex ba = (BehaviorAnnex) as;
        for(BehaviorVariable bv: ba.getVariables())
        {
          DataClassifier dc = bv.getDataClassifier();
          if(PropertyName.equals(STACK_SIZE))
            consumption+=DataSizeHelper.getOrComputeDataSize(dc);
        }
        for(BehaviorTransition bt: ba.getTransitions())
        {
          BehaviorActionBlock bab = (BehaviorActionBlock) bt.getActionBlock();
          if(bab.getContent() instanceof BehaviorActionSequence)
          {
            BehaviorActionSequence bas = (BehaviorActionSequence) bab.getContent();
            for(BehaviorAction bAction: bas.getActions())
            {
              if(bAction instanceof SubprogramCallAction)
              {
                SubprogramCallAction sca = (SubprogramCallAction) bAction;
                double newStackCons=0;
                if(PropertyName.equals(STACK_SIZE))
                {
                  newStackCons=getOrComputeComponentStackMemory(sca.getSubprogram().getElement());
                  if(newStackCons>subprogramsMaxStack)
                    subprogramsMaxStack=newStackCons;
                }
                else if(PropertyName.equals(HEAP_SIZE))
                  consumption+=getComponentHeapMemory(sca.getSubprogram().getElement());
              }
            }
          }
        }
      }
    }
    if(consumption>0)
      return consumption+subprogramsMaxStack;
    for(SubprogramCallSequence scs: bi.getOwnedSubprogramCallSequences())
    {
      for(SubprogramCall sc: scs.getOwnedSubprogramCalls())
      {
        if(sc.getCalledSubprogram() instanceof SubprogramClassifier)
        {
          if(PropertyName.equals(STACK_SIZE))
          {
            double newStackCons=getOrComputeComponentStackMemory((SubprogramClassifier)sc.getCalledSubprogram());
            if(newStackCons>subprogramsMaxStack)
              subprogramsMaxStack=newStackCons;
          }
          else if(PropertyName.equals(HEAP_SIZE))
            consumption+=getComponentHeapMemory((SubprogramClassifier)sc.getCalledSubprogram());
        }
      }
    }
    return consumption+subprogramsMaxStack ;
  }

  
  private double getProcessComponentMargin(ComponentInstance processComponent)
  {
    final double procCodeSize = getComponentCodeMemory(processComponent);
    final double procCodeConsumption=getSubcomponentsConsumption(processComponent, CODE_SIZE);
    
    double marginCode=2;
    if(procCodeSize!=0)
      marginCode = (procCodeSize-procCodeConsumption)/procCodeSize;
    
    final double procDataSize = getComponentDataMemory(processComponent);
    final double procDataConsumption=getSubcomponentsConsumption(processComponent, DATA_SIZE);
    
    double marginData=2;
    if(procDataSize!=0)
      marginData = (procDataSize-procDataConsumption)/procDataSize;
    if(marginData==2 && marginCode==2)
      return 2;
    else if(marginData<marginCode)
      return marginData;
    else
      return marginCode;
  }
  
  private double getMemoryComponentMargin(ComponentInstance memoryComponent)
  {
    final double memSize = getMemorySize(memoryComponent);
    double consumption=0;
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
          _LOGGER.warn("No memory bound to process " + processComponent.getQualifiedName(), e);
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
          memoryMap.put(processComponent, memoryComponent);
          for(ComponentInstance ci: processComponent.getComponentInstances())
            if(ci.getCategory().equals(ComponentCategory.THREAD))
              memoryMap.put(ci, memoryComponent);
        }
      }
    }
    if(memSize!=0)
      return (memSize-consumption)/memSize;
    return 0;
  }

  private double getSubcomponentsConsumption(ComponentInstance p, String pString)
  {
    double consumption = 0 ;

    for(ComponentInstance c : p.getComponentInstances())
    {
      if(c.getCategory() == ComponentCategory.THREAD)
      {
        if(pString.equals(CODE_SIZE))
          consumption += getComponentCodeMemory(c) ;
        else if(pString.equals(DATA_SIZE))
          consumption += getComponentDataMemory(c);
      }
      else if(c.getCategory() == ComponentCategory.DATA)
      {
        if(pString.equals(DATA_SIZE)
            || pString.equals(STACK_SIZE))
          consumption += DataSizeHelper.getOrComputeDataSize(c) ;
      }
    }
    if(p.getCategory() == ComponentCategory.THREAD)
    {
      consumption += getConsumption((BehavioredImplementation) p.getComponentClassifier(), pString);
    }

    return consumption ;
  }

  private double getMemorySize(ComponentInstance memory)
  {
    return getPropertyBytesValue(memory, "Memory_Size") ;
  }
  
  private double getWordSize(ComponentInstance memory)
  {
    return getPropertyBytesValue(memory, "Word_Size") ;
  }
  
  private double getProcessMemoryUsage(ComponentInstance e)
  {
    double memoryUsage = getComponentCodeMemory(e)
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
  
  private double getThreadDynamicSize(NamedElement e)
  {
   return getComponentStackMemory(e)
       +getComponentHeapMemory(e);
  }
  
  private double getComponentCodeMemory(NamedElement e)
  {
    return getPropertyBytesValue(e, CODE_SIZE) ;
  }
  
  private double getComponentDataMemory(NamedElement e)
  {
    return getPropertyBytesValue(e, DATA_SIZE) ;
  }
  
  private double getComponentStackMemory(NamedElement e)
  {
    return getPropertyBytesValue(e, STACK_SIZE) ;
  }

  private double getOrComputeComponentStackMemory(NamedElement e)
  {
    double stackSize=0;
    stackSize=getPropertyBytesValue(e, STACK_SIZE) ;
    if(stackSize==0)
      stackSize=computeStackConsumption(e);
    return stackSize;
  }
  
  private double getComponentHeapMemory(NamedElement e)
  {
    return getPropertyBytesValue(e, HEAP_SIZE) ;
  }
  
  private double getPropertyBytesValue(NamedElement e,
                                            String property)
  {
    try
    {
      return PropertyUtils.getIntValue(e, property) ;
    }
    catch(Exception e1)
    {
      _LOGGER.warn("Property " + property + " undefined for element " +
                         e.getQualifiedName(), e1) ;
      return 0 ;
    }
  }
}
