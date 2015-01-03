package fr.tpt.aadl.ramses.transformation.selection.mcda;

import java.io.File ;
import java.io.FileInputStream ;
import java.io.IOException ;
import java.io.InputStream ;
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.HashSet ;
import java.util.Iterator ;
import java.util.LinkedHashMap ;
import java.util.List ;
import java.util.Map ;
import java.util.Map.Entry ;
import java.util.Properties ;
import java.util.Set ;

import jxl.write.WriteException ;
import jxl.write.biff.RowsExceededException ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.xtext.EcoreUtil2 ;
import org.eclipse.xtext.util.CancelIndicator ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.RecordValue ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.utils.FileUtils ;

import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException ;
import fr.tpt.aadl.ramses.control.support.instantiation.ParseException ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.utils.Command ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;
import fr.tpt.aadl.ramses.control.support.utils.WaitMonitor ;
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
import fr.tpt.aadl.ramses.transformation.tip.util.TipParser ;
import fr.tpt.aadl.ramses.transformation.tip.util.TipUtils ;
import fr.tpt.aadl.ramses.transformation.trc.Transformation ;
import fr.tpt.aadl.ramses.transformation.trc.TrcRule ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;
import fr.tpt.aadl.ramses.transformation.trc.util.RuleApplicationTuple ;
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

  private int iterationNb=0;
  private List<String> qualityAttributesIdentifiers;
  
  private ArchitectureRefinementProcessLauncher mergeLauncher;

  public int cpt = 0 ;
  public int size ;

  
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
    
    if(r==null)
    {
      String message = "Transformation alternatives "
      		+ "could not be loaded. Please check the URI provided "
      		+ "in the properties file, as well as the URI in the "
      		+ "workflow file. Then RESTART RAMSES.";
      _LOGGER.error(message);
      ServiceProvider.SYS_ERR_REP.error(message, false);
    }
    
    EcoreUtil2.resolveAll(r, CancelIndicator.NullImpl);
    trc = (TrcSpecification) r.getContents().get(0);

  }

  @Override
  public
  void
  selectTransformation(Map<List<EObject>, ArrayList<TrcRule>> patternMatchingMap,
                       ArrayList<ElementTransformation> tuplesToApply)
  {
    SystemInstance sinst = (SystemInstance) this.currentImplResource.getContents().get(0);
    
    qualityAttributesIdentifiers = MCDAUtils.getReferencedQualityAttributes(sinst);
    
    // 1 - create the dependency graph of alternatives
    DependencyGraph dg = DependencyGraphUtils.
        createDependencyGraph(trc, patternMatchingMap);

    // TODO: check if it already exists

    // 2 - isolate elements having alternatives
    Iterator<Entry<List<EObject>, ArrayList<TrcRule>>> patternMatchingIt = 
        patternMatchingMap.entrySet().iterator();

    boolean stop = false;

    String alternatives = RuleApplicationUtils.printAlternativesToFile(patternMatchingMap);
    File alternativeFiles = new File(mergeLauncher.getOutputPathSave()+"/alternatives.txt");
    if(alternativeFiles.exists())
      alternativeFiles.delete();
    try
    {
      FileUtils.copyIntoFile(alternativeFiles, alternatives);
    }
    catch(IOException e)
    {
      _LOGGER.error("Could not save file containing the list of " +
          "alternatives to select");
    }
    
    List<List<EObject>> treatedObjectInTIP = new ArrayList<List<EObject>>();
    
    List<Map<List<EObject>, List<TrcRule>>> connectedAlternativesMapList =
        new ArrayList<Map<List<EObject>, List<TrcRule>>>();
    while (patternMatchingIt.hasNext()) 
    {
      Map.Entry<List<EObject>, ArrayList<TrcRule>> tuple =
          (Map.Entry<List<EObject>, ArrayList<TrcRule>>)patternMatchingIt.next();
      List<EObject> currentElements = tuple.getKey();
      List<TrcRule> currentTransformationAlternatives = tuple.getValue();

      if(treatedObjectInTIP.contains(currentElements))
        continue;
      
      if(currentTransformationAlternatives.size()>1)
      {
        
        
        // 3 - Check if Performance is available for Elements
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
        Set<DependencyNode> dependencyNodeList =
            new HashSet<DependencyNode>();
        for(TrcRule rule: currentTransformationAlternatives)
        {
          RuleApplicationTuple r = DependencyGraphUtils.getActualRuleApplicationTuple(patternMatchingMap,
                                                                                      currentElements,
                                                                                      rule);
          DependencyNode currentNode = DependencyGraphUtils.getDependencyNode
              (dg, r.getPatternMatchedElement(), r.getTransformationRule());
          if(treatedAlternatives.contains(currentNode))
            continue;
          dependencyNodeList.add(currentNode);
          // 4 - isolate a connected subgraph containing currentElements
          List<DependencyNode> connectedDepNodes = DependencyGraphUtils.
              getConnectedSubgraph(dg, currentElements, rule);
          dependencyNodeList.addAll(connectedDepNodes);
          for(DependencyNode dn: connectedDepNodes)
          {
            treatedAlternatives.add(dn);
          }
        }
        if(dependencyNodeList.isEmpty())
          continue;

        Map<List<EObject>, List<TrcRule>> connectedAlternativesMap = 
            new LinkedHashMap<List<EObject>, List<TrcRule>>();
        for(DependencyNode dn : dependencyNodeList)
        {
          List<EObject> matchedElements = dn.getMatchedElements();
          ArrayList<TrcRule> transformationRules = patternMatchingMap.get(matchedElements);
          connectedAlternativesMap.put(matchedElements, transformationRules);
        }

        connectedAlternativesMapList.add(connectedAlternativesMap);
      }
    }
    size = connectedAlternativesMapList.size();
    final TransformationRuleSelectionThread[] rulesSelectionThreads = 
        new TransformationRuleSelectionThread[size] ;
    int iter = 0;
    ExcelFileWriter excelFileWriter = new ExcelFileWriter(config.getRamsesOutputDir()+
                                                          "/AlternativesScore_"+
                                                          TipParser.getLastIterationId()+".xls");

    for(Map<List<EObject>, List<TrcRule>> connectedAlternativesMap:
      connectedAlternativesMapList)
    {
      rulesSelectionThreads[iter] = new TransformationRuleSelectionThread(trc, 
                                                                          sinst, 
                                                                          connectedAlternativesMap, 
                                                                          this,
                                                                          excelFileWriter);
      iter++;
    }
    
    final MCDABasedTransformationSelection app = this ;
    Command cmd = new Command()
    {
      int status = Command.UNSET;
      @Override
      public int run() throws Exception
      {
        for(Thread t : rulesSelectionThreads)
        {
          t.start();
        }
        
        // Wait all the thread end.
        synchronized (app) {
          app.wait();
        }
        
        
        status = Command.OK ;
        return status ;
      }

      @Override
      public boolean isCanceled()
      {
    	String msg = "Transformation selection "
    			+ "cancelled" ;
    	_LOGGER.error(msg);
        return monitor.isCanceled() ;
      }

      @Override
      public String getLabel()
      {
        return null ;
      }

      @Override
      public int getStatus()
      {
        return status;
      }

      @Override
      public Process getProcess()
      {
        // TODO Auto-generated method stub
        return null ;
      }
    } ;
    
    int exitStatus ;
    WaitMonitor wm = new WaitMonitor(cmd) ;
    wm.start();
    
    try
    {
      exitStatus = wm.waitAndCheck(500) ;
    }
    catch(Exception e)
    {
      killThreads(rulesSelectionThreads) ;
      String msg = "Transformation rules selection" +
          " monitoring has been interrupted" ;
      _LOGGER.fatal(msg, e);
      trc.cleanup();
      throw new RuntimeException(msg, e) ;
    }
    for(Thread t : rulesSelectionThreads)
    {
      List<ExcelPositionnedRuleApplicationTuple> ratList = 
          ((TransformationRuleSelectionThread) t).ratList;
      if(ratList == null)
      {
        String msg = "Transformation rules selection" +
            " failed (cancelled?)" ;
        _LOGGER.error(msg);
        trc.cleanup();
        return;
      }
      
      for(RuleApplicationTuple rat:ratList)
      {
        List<EObject> ratElements = rat.getPatternMatchedElement();
        if(treatedObjectInTIP.contains(ratElements))
          continue;
        treatedObjectInTIP.add(ratElements);

        List<TrcRule> ratRules = patternMatchingMap.get(rat.getPatternMatchedElement());
        TransformationRuleAlternative tra = 
            new TransformationRuleAlternative(ratElements,ratRules);
        TrcRule ratRuleName = rat.getTransformationRule();
        RuleApplicationUtils.setTransformationToApply(tra, 
                                                      ratRuleName,
                                                      tuplesToApply);

      }
      
    }
    
    for(TransformationRuleSelectionThread t : rulesSelectionThreads)
    {
      t.addSolutionsToExcelSheet();
      
    }
    
    try
    {
      excelFileWriter.duplicateSheet();
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
    
    trc.cleanup();

  }

  private void killThreads(Thread[] aadlInspectorThreads)
  {
    for(Thread t : aadlInspectorThreads)
      t.interrupt();
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
      List<RecordValue> lv = MCDAUtils.getAcceptableQualityImpacts(obj);
      if(numberOfQualityAttributes==lv.size())
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

    mergeLauncher = new ArchitectureRefinementProcessLauncher
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
    
    iterationNb = TipUtils.getCurrentIteration()+1;
    String modelIdSuffix = getModelIdSuffix();
    String outputModelId = workflowPilot.getOutputModelId()+modelIdSuffix;
    
    Resource result = mergeLauncher.launch(sinst, outputModelId, loop.getIterationNb());
    resultingMap.put(outputModelId, result);
    return resultingMap;
  }

  @Override
  public String getModelIdSuffix()
  {
    return "_iter_"+getCurrentIterationNb() ;
  }

  @Override
  public int getCurrentIterationNb()
  {
    return iterationNb ;
  }

  
  static class TransformationRuleSelectionThread extends Thread
  {
    
    private TrcSpecification trc;
    private SystemInstance sinst;
    private Map<List<EObject>, List<TrcRule>> connectedAlternativesMap;
    private final MCDABasedTransformationSelection initiator;
    private ExcelFileWriter excelFileWriter;
    public List<ExcelPositionnedRuleApplicationTuple> ratList;
    
    TransformationRuleSelection trs = null;
    
    public TransformationRuleSelectionThread(TrcSpecification trc,
                                             SystemInstance sinst,
                                             Map<List<EObject>, List<TrcRule>> connectedAlternativesMap,
                                             MCDABasedTransformationSelection initiator, 
                                             ExcelFileWriter excelFileWriter)
    {
      this.trc = trc;
      this.sinst = sinst;
      this.connectedAlternativesMap = connectedAlternativesMap;
      this.initiator = initiator;
      this.excelFileWriter = excelFileWriter;
    }
    
    public void addSolutionsToExcelSheet()
    {
      trs.addSolutionsToExcelSheet();
      TransformationRuleSelection.block=0;
    }

    @Override
    public void run()
    {
      // 5 - select alternatives for elements in connectedDepGraph
      trs = 
          new TransformationRuleSelection(this.trc, 
                                          sinst,
                                          connectedAlternativesMap,
                                          this.initiator.config,
                                          this.excelFileWriter);
      
      ratList = trs.selectBestRulesAlternatives();
      
      synchronized(sinst)
      {
        initiator.cpt++ ;
        String message =
                         initiator.cpt +
                             " execution(s) of transformation selection" +
                             " done." ;
        _LOGGER.trace(message) ;
        evaluateIfFinished() ;
      }
      
    }
    
    void evaluateIfFinished()
    {
      if(initiator.cpt==initiator.size)
      synchronized (initiator) {
        initiator.notify();
        initiator.cpt=0;
      }
    }
  }
}
