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
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.utils.PropertyUtils ;

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

  private List<DependencyNode> treatedAlternatives = 
      new ArrayList<DependencyNode>();

  private AadlTargetSpecificGenerator generator ;
  private TrcSpecification trc ;
  private Resource currentImplResource ;
  private AbstractLoop loop;
  private RamsesConfiguration config ;
  private WorkflowPilot workflowPilot;
  private Properties prop ;
  private AnalysisErrorReporterManager errManager;
  private IProgressMonitor monitor;

  private List<String> qualityAttributesIdentifiers;
  
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
    this.config = config;
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
    SystemInstance sinst = (SystemInstance) this.currentImplResource.getContents().get(0);
    
    qualityAttributesIdentifiers = MCDAUtils.getReferencedQualityAttributes(sinst);
    
    // 1 - create the dependency graph of alternatives
    DependencyGraph dg = DependencyGraphUtils.
        createDependencyGraph(trc, patternMatchingMap);

    // TODO: check if it already exists

    // 2 - isolate elements having alternatives
    Iterator<Entry<List<EObject>, ArrayList<String>>> patternMatchingIt = 
        patternMatchingMap.entrySet().iterator();

    boolean stop = false;

    while (patternMatchingIt.hasNext()) 
    {
      Map.Entry<List<EObject>, ArrayList<String>> tuple =
          (Map.Entry<List<EObject>, ArrayList<String>>)patternMatchingIt.next();
      List<EObject> currentElements = tuple.getKey();
      List<String> currentTransformationAlternatives = tuple.getValue();

      if(currentTransformationAlternatives.size()>1)
      {
        
        
        // 3 - Check if Performance is available for Elements
        // TODO: add a service to get Acceptable Impact
        if(false==hasAcceptableQualityImpacts(currentElements,
                                                   qualityAttributesIdentifiers.size()))
        {
          stop = true;
          _LOGGER.error("Property " + MCDAUtils.ACCEPTABLE_QUALITY_IMPACT_PS +
                        " ratio not found or incomplete for: " +
                        getIdentifier(currentElements));
        }
        if(stop)
          continue;
        DependencyNode currentNode = DependencyGraphUtils.getDependencyNode
            (dg, currentElements);
        if(treatedAlternatives.contains(currentNode))
          continue;
        // 4 - isolate a connected subgraph containing currentElements
        // TODO: check if it already exists
        List<DependencyNode> connectedDepNodes = DependencyGraphUtils.
            getConnectedSubgraph(dg, currentElements);
        for(DependencyNode dn: connectedDepNodes)
        {
          treatedAlternatives.add(dn);
        }

        Map<List<EObject>, List<String>> connectedAlternativesMap = 
            new LinkedHashMap<List<EObject>, List<String>>();
        for(DependencyNode dn : connectedDepNodes)
        {
          List<EObject> matchedElements = dn.getMatchedElements();
          ArrayList<String> transformationRules = patternMatchingMap.get(matchedElements);
          connectedAlternativesMap.put(matchedElements, transformationRules);
        }

        // 5 - select alternatives for elements in connectedDepGraph
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

  private String getIdentifier(List<EObject> currentElements)
  {
    String result = "";
    for(EObject obj: currentElements)
    {
      if(obj instanceof NamedElement)
      {
        NamedElement ne = (NamedElement) obj;
        result += " "+ne.getQualifiedName();
      }
      else
        result = "NaNE";
    }
    return result ;
  }

  private boolean hasAcceptableQualityImpacts(List<EObject> currentElements,
                                         int numberOfQualityAttributes)
  {
    for(EObject obj: currentElements)
    {
      boolean isNamedElement = obj instanceof NamedElement; 
      if(isNamedElement==false)
      {
        obj = MCDAUtils.getContainingNamedElement(obj) ;
        if(obj == null)
        {
          continue ;
        }
      }
      
      NamedElement ne = (NamedElement) obj;
      PropertyExpression pe = 
          PropertyUtils.getPropertyValue(MCDAUtils.ACCEPTABLE_QUALITY_IMPACT_PS,
                                         ne);
      if(pe==null)
        continue;
      
      ListValue lv = (ListValue) pe;
      if(numberOfQualityAttributes==lv.getOwnedListElements().size())
        return true;
    }
    return false;
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
