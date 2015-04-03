package fr.tpt.aadl.ramses.transformation.launcher;

import java.io.File ;
import java.io.FilenameFilter ;
import java.io.IOException ;
import java.io.PrintWriter ;
import java.io.StringWriter ;
import java.util.ArrayList ;
import java.util.Arrays ;
import java.util.HashMap ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;
import java.util.Map.Entry ;
import java.util.Properties ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.core.runtime.NullProgressMonitor ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl ;
import org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl ;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl ;
import org.eclipse.m2m.atl.core.ATLCoreException ;
import org.eclipse.m2m.atl.engine.compiler.CompileTimeError ;
import org.osate.aadl2.instance.SystemInstance ;

import fr.tpt.aadl.ramses.control.atl.AtlTransfoLauncher ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.ParseException ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;
import fr.tpt.aadl.ramses.control.support.utils.Command ;
import fr.tpt.aadl.ramses.control.support.utils.TrcUtils ;
import fr.tpt.aadl.ramses.control.support.utils.WaitMonitor ;
import fr.tpt.aadl.ramses.control.workflow.EcoreWorkflowPilot ;
import fr.tpt.aadl.ramses.control.workflow.ModelIdentifier ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowFactory ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPilot ;
import fr.tpt.aadl.ramses.control.workflow.util.WorkflowUtils ;
import fr.tpt.aadl.ramses.transformation.selection.ITransformationSelection ;
import fr.tpt.aadl.ramses.transformation.selection.RuleApplicationUtils ;
import fr.tpt.aadl.ramses.transformation.tip.ElementTransformation ;
import fr.tpt.aadl.ramses.transformation.tip.Iteration ;
import fr.tpt.aadl.ramses.transformation.tip.TipFactory ;
import fr.tpt.aadl.ramses.transformation.tip.TipSpecification ;
import fr.tpt.aadl.ramses.transformation.tip.util.TipParser ;
import fr.tpt.aadl.ramses.transformation.tip.util.TipUtils ;
import fr.tpt.aadl.ramses.transformation.trc.Module ;
import fr.tpt.aadl.ramses.transformation.trc.Transformation ;
import fr.tpt.aadl.ramses.transformation.trc.TrcRule ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;
import fr.tpt.atl.compiler.Atl2EmftvmCompiler ;
import fr.tpt.atl.hot.launcher.AtlTip2AtlLauncher ;
import fr.tpt.atl.patternmatching.util.PatternMatchingUtils ;


public class ArchitectureRefinementProcessLauncher {

  
  private IProgressMonitor monitor;

  private static Logger _LOGGER = Logger.getLogger(ArchitectureRefinementProcessLauncher.class) ;
  
  
  /**
   * The property file. Stores trc and tip locations.
   */
  private Properties properties;
  ResourceSet resourceSet;
  private ITransformationSelection transformationSelection;
  private RamsesConfiguration config;
  private AadlModelInstantiatior modelInstantiator;
  private PredefinedAadlModelManager predefinedResourcesManager;
  private List<Transformation> transformations;
  TrcSpecification trcSpec;

  
  private static ResourceSet intermediateRs = new ResourceSetImpl();
  
  private final File outputPathSave ;

  public int cpt ;

  public int size ;
  
  public File getOutputPathSave()
  {
    return outputPathSave ;
  }

  public ArchitectureRefinementProcessLauncher(TrcSpecification trcSpec,
                                                ResourceSet resourceSet,
                                                RamsesConfiguration config,
                                                IProgressMonitor monitor,
                                                ITransformationSelection selection,
                                                Properties configProperties,
                                                List<Transformation> transformations,
                                                AadlModelInstantiatior modelInstantiator,
                                                PredefinedAadlModelManager predefinedResourcesManager)
  {
    properties = configProperties;
    outputPathSave = config.getRamsesOutputDir();
    this.resourceSet = resourceSet;
    this.transformationSelection = selection;
    this.config = config;
    this.monitor = monitor;
    this.modelInstantiator = modelInstantiator;
    this.predefinedResourcesManager = predefinedResourcesManager;
    this.transformations = transformations;
    this.trcSpec = trcSpec;
    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap().put(
                                                                      "ecore", new EcoreResourceFactoryImpl());


    //----------setting the TIP parser-----------------
    //if TIP of a given path does not exist, then create a new TIP file

    String tipPath = this.getTipId();
    URI tipURI = URI.createFileURI(getOutputDir()+tipPath);
    String tipFilePath = tipURI.toFileString();
    File tipFile = new File(tipFilePath);
    Resource r = resourceSet.getResource(tipURI, tipFile.exists());
    if(r==null)
    {
      r=resourceSet.createResource(tipURI);
      TipUtils.setTipSpecification(TipUtils.createNewTIP(r));
      TipUtils.setCurrentIteration(0);
    }
    else
    {
      TipUtils.setTipSpecification((TipSpecification) r.getContents().get(0));
      TipUtils.setCurrentIteration(TipParser.getLastIterationId());
    }		

  }

  private String getOutputDir()
  {
    return config.getRamsesOutputDir().getAbsolutePath()+"/";
  }
  


  /**
   * This method executes ATL HOT transformation: Atl2DedicatedAtl4Aadl2Aadl. 
   * It is executed in every iteration.
   * 
   */
  public void generateDedicatedAtlForTip(Resource r,
                                         ArrayList<ElementTransformation> tuplesToApply,
                                         String tipPath) 
      throws IOException, ATLCoreException
  {
    //create hot launcher object

    AtlTip2AtlLauncher hotLauncher = new AtlTip2AtlLauncher("Atl2DedicatedAtl4Aadl2Aadl", 
                                                            resourceSet);
    List<String> treatedFiles = new ArrayList<String>();
    Iterator<ElementTransformation> tuplesToApplyIt = tuplesToApply.iterator();

    
    List<Iteration> iterationList = TipUtils.getTipSpecification().getIterations();
    Iteration iter = iterationList.get(iterationList.size()-1);
    // create temporary tip to isolate transformation plan for current iteration
    TipSpecification tmpTip = TipFactory.eINSTANCE.createTipSpecification();
    tmpTip.getIterations().add(iter);
    String tmpTipPath = getOutputDir()+"tmp_iter_"+iter.getId()+".tip";
    Resource tmpTipResource = resourceSet.createResource(URI.createFileURI(tmpTipPath));
    tmpTipResource.getContents().add(tmpTip);
    tmpTipResource.save(null);

    while (tuplesToApplyIt.hasNext()){
      ElementTransformation etObj = tuplesToApplyIt.next();
      Transformation transformationObject = TrcUtils.getTransformationById(trcSpec,
                                                                           trcSpec.getTrcRule(etObj.getTransformationId()));
      Module m = null;
      for(Module moduleIter: (List<Module>) transformationObject.getModules())
      {
        String moduleName = moduleIter.getPath();
        moduleName = moduleName.substring(moduleName.lastIndexOf("/")+1);
        moduleName = moduleName.substring(0, moduleName.length()-4);
        String toApplyModuleName = etObj.getTransformationId().substring(0, etObj.getTransformationId().lastIndexOf('.'));
        if(moduleName.equals(toApplyModuleName))
        {
          m = moduleIter;
          break;
        }
      }
      String mainATLFileName = RamsesConfiguration.getRamsesResourceDir().getAbsolutePath()+"/"+m.getPath();
      if(false == mainATLFileName.endsWith(".atl"))
      {
        mainATLFileName+=".atl";
      }
      if(treatedFiles.contains(mainATLFileName))
        continue;
      else
        treatedFiles.add(mainATLFileName);
      String refinedAtlFile = mainATLFileName.substring(mainATLFileName.lastIndexOf("/")).replace(".atl", "_applied_"+iter.getId()+".atl");
      refinedAtlFile = this.getOutputDir()+refinedAtlFile;


      String instanceModelPath = r.getURI().toString();
      //execute ATL 2 Dedicated ATL transformation

      String[] inputs = new String[]{mainATLFileName, tmpTipPath, instanceModelPath}; 
      hotLauncher.launchHot(inputs, refinedAtlFile);

      //compile generated transformation
      Atl2EmftvmCompiler aec = new Atl2EmftvmCompiler();
      CompileTimeError[] errors = aec.compile(refinedAtlFile, refinedAtlFile.replace(".atl", ""));
      if(errors.length > 0)
      {
        for(int i=0; i< errors.length; i++)
        {
          String message = errors[i].getDescription();
          _LOGGER.error(message);
        }
      }
    }

    // remove tmpTip, not useful anymore.
    TipUtils.getTipSpecification().getIterations().add(iter);
    tmpTipResource.delete(null);
  }

  /**
   * This method executes the architecture refinement process
   * INPUT: AADL candidate architecture model, RDAL specification, TRC artifact
   * OUTPUT: AADL architecture model is obtained from the workflow execution
   * @return Resource obtained after merge and execution of the transformation
   * @throws ParseException 
   * @throws ConfigurationException 
   * @throws TransformationException 
   * @throws AnalysisException 
   * 
   * @throws IOException 
   * 
   */		
  public Resource launch(SystemInstance systemInstance,
                     String outputResourceID,
                     int nbIterations) 
                         throws ParseException, ConfigurationException, AnalysisException, TransformationException, IOException
  {

    File outputDir = new File(getPatternMatchingOutputDir());
    if(!outputDir.exists())
    {
      outputDir.mkdir();
    }

    config.setRamsesOutputDir(outputDir.getAbsolutePath());
    
    
    // First, execute the HOT that produces pattern matching results
    PatternMatchingForTrcHotLauncher pmHotLauncher = new PatternMatchingForTrcHotLauncher(transformations,
                                                                                          resourceSet,
                                                                                          config);
    pmHotLauncher.launch();
    
    String message = "End of HOT to produce pattern matching traces";
    _LOGGER.trace(message);
    Resource r = null;
    try {
        TipUtils.setCurrentIteration(TipUtils.getCurrentIteration()+1);
        message = "Start production of " + outputResourceID;
        _LOGGER.trace(message);
        r = this.runArchitectureRefinementIteration(trcSpec,
                                                             systemInstance, 
                                                             config,
                                                             outputResourceID);
        if(r!=null)
          message = "Finish production of " + outputResourceID;
        config.setRamsesOutputDir(outputPathSave.getAbsolutePath());
    }
    finally
    {
      RuleApplicationUtils.clean();
    }
    return r;
  }


  private String getPatternMatchingOutputDir()
  {
    return this.outputPathSave.getAbsolutePath()+"/.PatternMatchingTransformations/";
  }

  /**
   * This method executes an iteration of architecture refinement process
   * INPUT: AADL candidate architecture model, RDAL specification, TRC artifact
   * OUTPUT: AADL architecture model is obtained from the workflow execution
   * @return 
   * @throws IOException 
   * @throws TransformationException 
   * @throws AnalysisException 
   * @throws Exception 
   * 
   */	
  private Resource runArchitectureRefinementIteration(TrcSpecification trcSpec,
                                                 SystemInstance sinst,
                                                 RamsesConfiguration config,
                                                 String outputResourceID) throws IOException, AnalysisException, TransformationException
  {

    TipUtils.addIteration(TipUtils.getTipSpecification(),
                          resourceSet,
                          getOutputPathSave()+"/"+getTipId());	

    /**
     * First step: produces the pattern matching information
     * Execute emtfvm modules listed in files variable on the input aadl model: 
     * 		produces .pml files
     */
    long startTimeIdentification = System.nanoTime();

    //create candidate tuples of possible transformations -> execute the AADL to pattern matching (all the files with ending "_2pml.atl")
    List<Transformation> transfoList = trcSpec.getTransformationList().getTransformations();
    
    _LOGGER.trace("Start identification step (trace all pattern matching)");
    
    // do identification transformations in threads
    size = transfoList.size();
    final PatternMatchingTransformationThread[] rulesSelectionThreads 
              = new PatternMatchingTransformationThread[size] ;
    int threadsIter = 0;
    final ArchitectureRefinementProcessLauncher app = this ;
    for(Transformation transfo : transfoList)
    {
      rulesSelectionThreads[threadsIter] = 
          new PatternMatchingTransformationThread(app,
                                                  transfo,
                                                  sinst,
                                                  outputResourceID+"_"+threadsIter);
      threadsIter++;
    }

    
    
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
      if(exitStatus == Command.CANCEL)
      {
        killThreads(rulesSelectionThreads) ;
      }
    }
    catch(Exception e)
    {
      killThreads(rulesSelectionThreads) ;
      String msg = "Transformation rule alternatives " +
          " identification has been interrupted" ;
      _LOGGER.fatal(msg, e);
    }
    finally
    {
      List<Resource> resList = new ArrayList<Resource>();
      for(Resource r: intermediateRs.getResources())
        if(false==resourceSet.getResources().contains(r))
          resList.add(r);
      
      resourceSet.getResources().addAll(resList);
    }


    Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
    .put("pml", new XMIResourceFactoryImpl()) ;
    
    String patternMatchingPath = getOutputDir()+
                                  sinst.eResource().getURI().lastSegment();
    patternMatchingPath = patternMatchingPath.
        substring(0, patternMatchingPath.lastIndexOf("."))+
        ".pml";
    URI uri = URI.createFileURI(patternMatchingPath);
    Resource outputResource = resourceSet.getResource(uri, false);
    if(outputResource==null)
      outputResource = resourceSet.createResource(uri);
    
    
    
    for(PatternMatchingTransformationThread t : rulesSelectionThreads)
    {
      Resource identification = t.getIdentificationResult();
      if(identification==null)
      {
        String message = "Identification of alternatives failed";
        _LOGGER.error(message);
        ServiceProvider.SYS_ERR_REP.error(message, true);
        return null;
      }
      outputResource.getContents().addAll(identification.getContents());
      identification.delete(null);
    }
    outputResource.save(null);
    //get the pattern matching results as a Map(elemenId, ArrayList(transformationId))
    Map<List<EObject>, ArrayList<TrcRule>> patternMatchingMap = 
        PatternMatchingUtils.getGroupedCandidateTuplesFromDirectory(trcSpec,
                                                                    config.getRamsesOutputDir().getAbsolutePath(),
                                                                    resourceSet);

    outputResource.delete(null);
    
    ArrayList<ElementTransformation> tuplesToApply = new ArrayList<ElementTransformation>();

    long finishTimeIdentification = System.nanoTime();

    _LOGGER.trace("Finished identification step (trace all pattern matching)");
    _LOGGER.trace("STEP1: time = "+
          Long.toString(finishTimeIdentification-startTimeIdentification));

    /**
     * Second step: select the transformations to apply.
     * 
     */

    _LOGGER.trace("Start selection step");
    
    long startTimeSelection = System.nanoTime();

    File outputDir = new File(this.outputPathSave+"/iter_"+TipUtils.getCurrentIteration());
    if(!outputDir.exists())
    {
      outputDir.mkdir();
    }

    config.setRamsesOutputDir(outputDir.getAbsolutePath());
    
    this.transformationSelection.selectTransformation(patternMatchingMap, tuplesToApply);
    
    if(tuplesToApply.isEmpty())
    {
      String message = "Selection of alternatives failed";
      _LOGGER.error(message);
      ServiceProvider.SYS_ERR_REP.error(message, true);
      return null;
    }
    
    // store the result of the selection: generate TIP
    String tipPath = outputPathSave+"/"+getTipId();
    TipUtils.addElementTransformationToLastIteration(tipPath, resourceSet, TipUtils.getTipSpecification(), tuplesToApply);

    
    
    _LOGGER.trace("Finished selection step");

    long finishTimeSelection = System.nanoTime();

    _LOGGER.trace("STEP2: time = "+
          Long.toString(finishTimeSelection-startTimeSelection));

    /**
     * 
     * Third Step and Second HOT: produce ATL code to apply transformations on selected EObjects only
     * 
     */

    _LOGGER.trace("Start specialization step");
    
    long startTimeSpecialization = System.nanoTime();
    
    File dirFileForWorkflow = new File(config.getRamsesOutputDir().getAbsolutePath());

    // clean of the output directory
    File[] filesToDelete = dirFileForWorkflow.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        int iter = TipParser.getLastIterationId();
        return name.toLowerCase().endsWith( "_applied_"+iter+".emftvm");
      }
    });
    if(filesToDelete.length>0)
    {
      for(int i=0;i<filesToDelete.length;i++)
      {
        filesToDelete[i].delete();
      }
    }

    _LOGGER.trace("Start specialization HOT");
    // generate transformations for particular elements
    try {
      this.generateDedicatedAtlForTip(sinst.eResource(),tuplesToApply, getOutputDir()+getTipId());
    } catch (ATLCoreException e) {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      e.printStackTrace(pw);
      _LOGGER.fatal(sw.toString());
    }

    _LOGGER.trace("Finished specialization HOT");
    _LOGGER.trace("Create iteration workflow");
    
    // warning: this code concatenates all the produced transformations in the produced workflow; 
    // a clean of the output directory has been done to restart from scratch.
    File[] additionalTransfoFiles = dirFileForWorkflow.listFiles(new FilenameFilter() {
      public boolean accept(File dir, String name) {
        int iter = TipParser.getLastIterationId();
        return name.toLowerCase().endsWith( "_applied_"+iter+".emftvm");
      }
    });

    List<File> additionnalTransfoList = new ArrayList<File>();
    additionnalTransfoList.addAll((List<File>) Arrays.asList(additionalTransfoFiles));

    //generate ramses workflow from TIP
    String workflowPath = getOutputDir()+"workflow"+
        TipParser.getLastIterationId()+".xmi";
    fr.tpt.aadl.ramses.control.workflow.Transformation rootTransfo = WorkflowFactory.eINSTANCE.createTransformation();
    
    ModelIdentifier outputMi = WorkflowFactory.eINSTANCE.createModelIdentifier();
    outputMi.setId(outputResourceID);
    rootTransfo.setOutputModelIdentifier(outputMi);
    
    ModelIdentifier inputMi = WorkflowFactory.eINSTANCE.createModelIdentifier();
    inputMi.setId("input_model");
    rootTransfo.setInputModelIdentifier(inputMi);
    
    fr.tpt.aadl.ramses.control.workflow.List l = WorkflowFactory.eINSTANCE.createList();
    rootTransfo.setList(l);
    
    // retreive module dependencies for current transformation.
    List<Module> completeModuleList = TrcUtils.buildVerticalDependencyList(transfoList);
    // add dependencies in the workflow model.
    for(int i = 0; i<completeModuleList.size(); i++)
    {
      // iterator on system specific model transformations (resulting from second HOT)
      Iterator<File> additionalTransfoIt = additionnalTransfoList.iterator();
      Module m = completeModuleList.get(i);
      String mPath = m.getPath();
      if(mPath.endsWith(".atl"))
        mPath = mPath.substring(0,mPath.length()-4);
      if(mPath.endsWith(".emftvm"))
        mPath=mPath.substring(0, mPath.length()-7);
      
      String prefix = mPath.substring(mPath.lastIndexOf("/")+1,mPath.length());
      fr.tpt.aadl.ramses.control.workflow.File f = WorkflowFactory.eINSTANCE.createFile();
      f.setPath(mPath);
      l.getFile().add(f);
      while (additionalTransfoIt.hasNext()) {
        fr.tpt.aadl.ramses.control.workflow.File additionalFile = WorkflowFactory.eINSTANCE.createFile();
        String fPath = additionalTransfoIt.next().getPath();

        int iter = TipParser.getLastIterationId();
        String additionalFilePrefix = fPath.substring(fPath.lastIndexOf("/")+1,fPath.lastIndexOf(Integer.toString(iter))-9);
        if(false == additionalFilePrefix.equals(prefix))
          continue;
        if(fPath.endsWith(".emftvm"))
          fPath=fPath.substring(0, fPath.length()-7);
        additionalFile.setPath(fPath);
        l.getFile().add(additionalFile);
      }
    }

    // create workflow and save the workflow file
    WorkflowUtils.createNewWorkflow(resourceSet,workflowPath, rootTransfo, inputMi);

    _LOGGER.trace("Finished specialization step");
    
    long finishTimeSpecialization = System.nanoTime();
    _LOGGER.trace("STEP3: time = "+Long.toString(finishTimeSpecialization-startTimeSpecialization));


    _LOGGER.trace("Launch specialized transformation");
    
    // execute ramses workflow transformation 
    WorkflowPilot workflowPilot = new EcoreWorkflowPilot(this.resourceSet,
                                                         workflowPath);
    ServiceRegistry registry = ServiceProvider.getServiceRegistry() ;

    Generator generator = registry.getGenerator(config.getTargetId()) ;
    try {
      Map<String, Resource> res = generator.generateWorkflow(sinst, config, workflowPilot, null, ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER, monitor);
      File[] additionalTransfoFilesToDelete = dirFileForWorkflow.listFiles(new FilenameFilter() {
        public boolean accept(File dir, String name) {
          int iter = TipParser.getLastIterationId();
          return name.toLowerCase().contains( "_applied_"+iter);
        }
      });
      
      for(int i = 0; i< additionalTransfoFilesToDelete.length;i++)
        additionalTransfoFilesToDelete[i].delete();
      
      URI wf_uri = URI.createFileURI(workflowPath);
      resourceSet.getPackageRegistry().put(WorkflowPackage.eNS_URI,
                                           WorkflowPackage.eINSTANCE);

      Resource workflowResource = resourceSet.getResource(wf_uri, false);
      if(workflowResource!=null)
        workflowResource.delete(null);
      
      return res.get(outputResourceID);
    } catch (GenerationException e) {
      StringWriter sw = new StringWriter();
      PrintWriter pw = new PrintWriter(sw);
      e.printStackTrace(pw);
      _LOGGER.fatal(sw.toString());
    }
    String message = "Execution of specialized transformations failed";
    _LOGGER.error(message);
    ServiceProvider.SYS_ERR_REP.error(message, true);
    return null ;


  }


  //--------------------------------------------------------------------
  //-------------Getters and setters----------------------
  //--------------------------------------------------------------------

  
  /**
   * Returns the URI of the given tip configuration
   * 
   * @return the TIP URI
   */
  protected String getTipId() {
    return ".ramses-generated.tip";
  }


  /**
   * Returns the options map, parameterized from the property file.
   * 
   * @return the options map
   * 
   * @generated
   */
  protected Map<String, Object> getOptions() {
    Map<String, Object> options = new HashMap<String, Object>();
    for (Entry<Object, Object> entry : properties.entrySet()) {
      if (entry.getKey().toString()
          .startsWith("ArchitectureRefinementLauncher.options.")) {
        options.put(
                    entry.getKey()
                    .toString()
                    .replaceFirst("ArchitectureRefinementLauncher.options.",
                        ""), entry.getValue().toString());
      }
    }
    return options;
  }

  private void killThreads(Thread[] aadlInspectorThreads)
  {
    for(Thread t : aadlInspectorThreads)
      t.interrupt();
  }
  
  static class PatternMatchingTransformationThread extends Thread
  {
    private Transformation transfo;
    private String patternMatchingOutputDir;
    private ArchitectureRefinementProcessLauncher initiator;
    private SystemInstance sinst;
    private String outputResourceID;
    
    private Resource result;
    
    public PatternMatchingTransformationThread(ArchitectureRefinementProcessLauncher initiator, 
                                               Transformation transfo,
                                               SystemInstance sinst,
                                               String outputResourceID)
    {
      this.initiator = initiator;
      this.transfo = transfo;
      this.sinst = sinst;
      patternMatchingOutputDir = initiator.getPatternMatchingOutputDir();
      this.outputResourceID = outputResourceID;
    }

    @Override
    public void run()
    {
      PatternMatchingTransformationLauncher pmtl = new PatternMatchingTransformationLauncher(initiator.modelInstantiator,
                                                                                             initiator.predefinedResourcesManager,
                                                                                             initiator.trcSpec);  
      
      List<Module> moduleList = transfo.getModules();
      List<File> emftvmFiles = new ArrayList<File>();
      for(int i = 0; i<moduleList.size(); i++)
      {
        String modulePath = moduleList.get(i).getPath();
        modulePath = modulePath.substring(0, modulePath.length()-4)+"_2pml.emftvm";
        File f = new File(patternMatchingOutputDir+modulePath);
        emftvmFiles.add(f);
      }

      AtlTransfoLauncher.initTransformation();
      
      
      ResourceSet existingRs = sinst.eResource().getResourceSet();
      
      synchronized(sinst)
      {
        intermediateRs.getResources().addAll(existingRs.getResources());
        pmtl.setResourceSet(intermediateRs);
      }
      
      result = pmtl.doTransformation(emftvmFiles, 
                                     sinst.eResource(),  
                                     initiator.getOutputDir(),
                                     outputResourceID, 
                                     initiator.monitor);
      
      synchronized(sinst)
      {
        initiator.cpt++ ;
        String message =
                         initiator.cpt +
                             " execution(s) of transformation selection" +
                             " done." ;
        _LOGGER.trace(message) ;
        evaluateIfFinished(existingRs) ;
      }
    }
    
    void evaluateIfFinished(ResourceSet existingRs)
    {
      if(initiator.cpt==initiator.size)
      {
        synchronized (initiator) {
          initiator.notify();
          initiator.cpt=0;
        }
      }
    }
    
    public Resource getIdentificationResult()
    {
      return result;
    }
  }
}
