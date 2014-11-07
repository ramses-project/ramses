package fr.tpt.aadl.ramses.transformation.selection.mcda;

import java.io.FileInputStream ;
import java.io.IOException ;
import java.io.InputStream ;
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.Iterator ;
import java.util.LinkedHashMap ;
import java.util.List ;
import java.util.Map ;
import java.util.Properties ;
import java.util.Map.Entry ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException ;
import fr.tpt.aadl.ramses.control.support.instantiation.ParseException ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;
import fr.tpt.aadl.ramses.control.workflow.AbstractLoop ;
import fr.tpt.aadl.ramses.control.workflow.ResolutionMethod ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPilot ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificGenerator ;
import fr.tpt.aadl.ramses.generation.target.specific.LoopManager ;
import fr.tpt.aadl.ramses.transformation.launcher.ArchitectureRefinementProcessLauncher ;
import fr.tpt.aadl.ramses.transformation.selection.ITransformationSelection ;
import fr.tpt.aadl.ramses.transformation.selection.RuleApplicationUtils ;
import fr.tpt.aadl.ramses.transformation.selection.TransformationRuleAlternative ;
import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyGraph ;
import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode ;
import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.util.DependencyGraphUtils ;
import fr.tpt.aadl.ramses.transformation.tip.ElementTransformation ;
import fr.tpt.aadl.ramses.transformation.trc.Transformation ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;
import fr.tpt.aadl.ramses.transformation.trc.util.RuleApplicationTulpe ;
import fr.tpt.aadl.ramses.transformation.trc.util.TrcParser ;

public class MCDABasedTransformationSelection implements ITransformationSelection,LoopManager
{

  private static Logger _LOGGER = Logger.getLogger(MCDABasedTransformationSelection.class) ;
  
  private List<DependencyNode> treatedAlternatives;
  
  private AadlTargetSpecificGenerator generator ;
  private TrcSpecification trc ;
  private Resource currentImplResource ;
  private AbstractLoop loop;
  private RamsesConfiguration config ;
  private WorkflowPilot workflowPilot;
  private Properties prop ;
  private AnalysisErrorReporterManager errManager;
  private IProgressMonitor monitor;

  public MCDABasedTransformationSelection(AadlTargetSpecificGenerator generator,
                                   AbstractLoop loop,
                                   AnalysisErrorReporterManager errManager,
                                   WorkflowPilot workflowPilot,
                                   RamsesConfiguration config,
                                   IProgressMonitor monitor)
  {
    this.generator = generator;
    this.loop = loop;
    this.workflowPilot = workflowPilot;
    this.errManager = errManager;
    this.monitor = monitor;
    String propertyFile = (String) config.getParameters().get(Names.RAMSES_PROPERTIES);
    
    prop = new Properties() ;
    try {
      InputStream in = new FileInputStream(propertyFile);
      prop.load(in);
    } catch (IOException e) {
      String message = "could not open property file "
          + propertyFile;
      _LOGGER.error(message);
      e.printStackTrace();
    }
    
    currentImplResource = generator.currentImplResource;
    
    ResourceSet rs = currentImplResource.getResourceSet();
    
    
    String trcPath = prop.getProperty("ArchitectureRefinementLauncher.trc");
    if(trcPath!=null)
      TrcParser.parse(trcPath, rs);
    
    List<Transformation> list = loop.getTransformations();
    Resource r = list.get(0).eResource();
    trc = (TrcSpecification) r.getContents().get(0);
    
  }
  
  @Override
  public
      void
      selectTransformation(Map<List<EObject>, ArrayList<String>> patternMatchingMap,
                           ArrayList<ElementTransformation> tuplesToApply)
  {
    
    // 1 - create the dependency graph of alternatives
    DependencyGraph dg = DependencyGraphUtils.
        createDependencyGraph(trc, patternMatchingMap);
    
    
    // 2 - isolate elements having alternatives
    Iterator<Entry<List<EObject>, ArrayList<String>>> patternMatchingIt = patternMatchingMap.entrySet().iterator();
    
    while (patternMatchingIt.hasNext()) 
    {
      Map.Entry<List<EObject>, ArrayList<String>> tuple = (Map.Entry<List<EObject>, ArrayList<String>>)patternMatchingIt.next();
      List<EObject> currentElements = tuple.getKey();
      List<String> currentTransformationAlternatives = tuple.getValue();
      if(currentTransformationAlternatives.size()==1)
      {
        TransformationRuleAlternative tra = new TransformationRuleAlternative(currentElements, 
                                                                              currentTransformationAlternatives);
        RuleApplicationUtils.setTransformationToApply(tra,
                                                      currentTransformationAlternatives.get(0),
                                                      tuplesToApply);
      }
      else
      {
        DependencyNode currentNode = DependencyGraphUtils.getDependencyNode
            (dg, currentElements);
        if(treatedAlternatives.contains(currentNode))
          continue;
        // 3 - isolate a connected subgraph containing currentElements
        List<DependencyNode> connectedDepNodes = DependencyGraphUtils.
                                                getConnectedSubgraph(dg, currentElements);
        for(DependencyNode dn: connectedDepNodes)
        {
          treatedAlternatives.add(dn);
        }
        
        Map<List<EObject>, ArrayList<String>> connectedAlternativesMap = 
            new LinkedHashMap<List<EObject>, ArrayList<String>>();
        for(DependencyNode dn : connectedDepNodes)
        {
          List<EObject> matchedElements = dn.getMatchedElements();
          ArrayList<String> transformationRules = patternMatchingMap.get(matchedElements);
          connectedAlternativesMap.put(matchedElements, transformationRules);
        }
        
        // 4 - select alternatives for elements in connectedDepGraph
        SystemInstance sinst = (SystemInstance) this.currentImplResource.getContents().get(0);
        TransformationRuleSelection trs = 
            new TransformationRuleSelection(trc, 
                                            sinst,
                                            connectedAlternativesMap);
        
        List<RuleApplicationTulpe> ratList = trs.selectBestRulesAlternatives();
        
        for(RuleApplicationTulpe rat:ratList)
        {
          List<EObject> ratElements = rat.getPatternMatchedElement();
          List<String> ratRules = patternMatchingMap.get(rat.getPatternMatchedElement());
          TransformationRuleAlternative tra = 
              new TransformationRuleAlternative(ratElements,ratRules);
          RuleApplicationUtils.setTransformationToApply(tra, 
                                                        rat.getTransformationRuleName(),
                                                        tuplesToApply);
        }
      }
    }
    
    
    
  }

  @Override
  public boolean shouldSelectionContinue()
  {
    return false ;
  }

  @Override
  public String getResolutionMethodName()
  {
    return ResolutionMethod.MCDA_MERGE.getName() ;
  }

  @Override
  public Map<? extends String, ? extends Resource>
      processLoop() throws AnalysisException, ParseException,
                   TransformationException, ConfigurationException, IOException
  {
    Map<String, Resource> resultingMap = new HashMap<String, Resource>();
    
    ArchitectureRefinementProcessLauncher mergeLauncher = new ArchitectureRefinementProcessLauncher
        (trc,
         this.currentImplResource.getResourceSet(),
         config,
         this,
         prop,
         loop.getTransformations(),
         generator._modelInstantiator,
         generator._predefinedResourceManager
         );
    
    SystemInstance sinst = (SystemInstance) this.currentImplResource.getContents().get(0);
    boolean loopAnalysis = false;
    generator.loopIteration++;
    Resource result = mergeLauncher.launch(sinst, workflowPilot.getOutputModelId(), loop.getIterationNb());
    String modelIdSuffix = "_iter_"+generator.loopIteration;
    resultingMap.put(workflowPilot.getOutputModelId()+modelIdSuffix, result);
    loopAnalysis = generator.isValidLoopIteration(loop.getAnalysis(), errManager, workflowPilot, config, workflowPilot.getOutputModelId(), modelIdSuffix, monitor);
    if(loopAnalysis==false)
      _LOGGER.error("Analysis results show that some constraints are not satisfied");
    return resultingMap;
  }

}
