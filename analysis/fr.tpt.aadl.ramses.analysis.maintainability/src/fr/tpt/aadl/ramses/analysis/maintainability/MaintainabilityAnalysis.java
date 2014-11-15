package fr.tpt.aadl.ramses.analysis.maintainability ;

import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.apache.log4j.Logger ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.BehavioredImplementation ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.SubprogramCall ;
import org.osate.aadl2.SubprogramCallSequence ;
import org.osate.aadl2.SubprogramClassifier ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.ba.aadlba.BehaviorAction ;
import org.osate.ba.aadlba.BehaviorActionBlock ;
import org.osate.ba.aadlba.BehaviorActionSequence ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorTransition ;
import org.osate.ba.aadlba.SubprogramCallAction ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.launch.MaintainabilityAnalyzer ;
import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory ;
import fr.tpt.aadl.ramses.analysis.AnalysisSource ;
import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult ;
import fr.tpt.aadl.ramses.analysis.QuantitativeAnalysisResult ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;

public class MaintainabilityAnalysis
{
  private final static Logger _LOGGER = Logger.getLogger(MaintainabilityAnalysis.class) ;

  public MaintainabilityAnalysis(){}
  private final AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE;
  private static int iterationCounter=0;
  
  Map<ComponentInstance, Long> maintenanceCostMap = 
      new HashMap<ComponentInstance, Long>();
  
  Map<ComponentInstance, Long> maintenanceBudgetMap = 
      new HashMap<ComponentInstance, Long>();
  
  private final String MAINTAINANCE_COST = "Maintenance_Cost";
  private final String MAINTAINANCE_BUDGET = "Maintenance_Budget";
  
  private boolean analysisValid = true;
  
  public void doAnalysis(SystemInstance s, AnalysisArtifact currentResult )
  {
    
    final QualitativeAnalysisResult qar = f.createQualitativeAnalysisResult();
    qar.setValidated(true);
    AnalysisSource sourceQar = f.createAnalysisSource();
    sourceQar.setMethodName(MaintainabilityAnalyzer.PLUGIN_NAME);
    sourceQar.setScope(s.getQualifiedName());
    qar.setSource(sourceQar);
    iterationCounter++;
    double margin=2; 
    /** For each process create a result indicating maintainability margin */
    for (ComponentInstance c : s.getAllComponentInstances())
    {
      if (c.getCategory()==ComponentCategory.PROCESS)
      {
        Long cost = getSubcomponentsConsumption(c);
        maintenanceCostMap.put(c, cost);
        Long budget = getMaintainanceBudget(c);
        maintenanceBudgetMap.put(c, budget);
      }
      if (c.getCategory()==ComponentCategory.THREAD)
      {
        // TODO: add management of maintainability overhead (thread specific code)
        Long budget = getMaintainanceBudget(c);
        maintenanceBudgetMap.put(c, budget);
      }
    }
    
    for (ComponentInstance c : s.getAllComponentInstances())
    {
      // check Process Component
      if (c.getCategory()==ComponentCategory.PROCESS
          || c.getCategory()==ComponentCategory.THREAD)
      {
        margin = getComponentMargin(c);
        addResult(currentResult, margin, c, qar);
      }
      else
        margin=2; // impossible value as a result of analysis
    }
    
    /** For the whole system, create a global result indicating 
     *  if memory size is enough. */
    AnalysisSource source = f.createAnalysisSource();
    source.setMethodName(MaintainabilityAnalyzer.PLUGIN_NAME);
    
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
      source.setMethodName(MaintainabilityAnalyzer.PLUGIN_NAME);
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
    sourceQar.setMethodName(MaintainabilityAnalyzer.PLUGIN_NAME);
    sourceQar.setScope(c.getQualifiedName());
    qar.setSource(sourceQar);
    sourceQar.setIterationId(iterationCounter);
  }
  
  private Long computeMaintainanceCost(NamedElement component,
                                      List<Element> treatedElements)
  {
    Long cost = (long) 0 ;
    if(component instanceof SubprogramClassifier)
    {
      cost += getMaintainanceCost(component);
    }
    if(component instanceof BehavioredImplementation)
    {
      BehavioredImplementation bi = (BehavioredImplementation) component;
      if(treatedElements.contains(bi))
        return cost;
      treatedElements.add(bi);
      
      for(AnnexSubclause as: bi.getOwnedAnnexSubclauses())
      {
        if(as instanceof BehaviorAnnex)
        {
          BehaviorAnnex ba = (BehaviorAnnex) as;
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
                  cost+=computeMaintainanceCost(sca.getSubprogram().getElement(),
                                               treatedElements);
                }
              }
            }
          }
        }
      }
      // check if found cost in BA
      if(cost>0)
        return cost;
      
      // if no BA
      for(SubprogramCallSequence scs: bi.getOwnedSubprogramCallSequences())
      {
        for(SubprogramCall sc: scs.getOwnedSubprogramCalls())
        {
          cost+=computeMaintainanceCost((NamedElement)sc.getCalledSubprogram(),
                                       treatedElements);
        }
      }
    }
    return cost ;
  }

  private double getComponentMargin(ComponentInstance component)
  {
    final Long maintenanceCost = maintenanceCostMap.get(component);
    final Long maintenanceBudget = maintenanceBudgetMap.get(component);
    double margin=2;
    if(maintenanceBudget!=0)
      margin = (maintenanceBudget-maintenanceCost)/maintenanceBudget;
    return margin;
  }

  
  private Long getThreadConsumption(ComponentInstance c)
  {
    List<Element> treatedElements =
        new ArrayList<Element>();
    Long threadConsumption = (long) 0;
    if(maintenanceCostMap.containsKey(c))
      threadConsumption = maintenanceCostMap.get(c);
    else
    {
      threadConsumption = computeMaintainanceCost((BehavioredImplementation) 
                             c.getComponentClassifier(), treatedElements);
      treatedElements.add(c.getComponentClassifier());
      maintenanceCostMap.put(c, threadConsumption);
    }
    return threadConsumption;
  }
  
  private Long getSubcomponentsConsumption(ComponentInstance p)
  {
    Long consumption = (long) 0 ;

    for(ComponentInstance c : p.getComponentInstances())
    {
      if(c.getCategory() == ComponentCategory.THREAD)
      {
        consumption += getThreadConsumption(c);
      }
    }
    if(p.getCategory() == ComponentCategory.THREAD)
    {
      
      consumption += 
          getThreadConsumption(p);
    }

    return consumption ;
  }
  
  private Long getMaintainanceCost(NamedElement ne)
  {
    return getPropertyMaintenanceValue(ne, MAINTAINANCE_COST) ;
  }
  
  private Long getMaintainanceBudget(NamedElement ne)
  {
    return getPropertyMaintenanceValue(ne, MAINTAINANCE_BUDGET) ;
  }
  
  private Long getPropertyMaintenanceValue(NamedElement e,
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
      return (long) 0 ;
    }
  }
}
