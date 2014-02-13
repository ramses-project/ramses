package fr.tpt.aadl.sched.wcetanalysis;

import java.io.File ;
import java.io.IOException ;
import java.io.PrintStream ;
import java.util.ArrayList ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.util.Aadl2Util ;

import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory ;
import fr.tpt.aadl.ramses.analysis.AnalysisSource ;
import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult ;
import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisResultException ;
import fr.tpt.aadl.sched.wcetanalysis.model.TaskBody ;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel ;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.Computation ;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionBegin ;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA ;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ThreadBehaviorElement ;
import fr.tpt.aadl.sched.wcetanalysis.util.AST2DOT ;

public class WcetAnalysis extends AbstractAnalyzer {

	
//	private static final String ACTION_NAME = "Compute WCET from AADL model";
	private static final String REGISTRY_NAME = "WCET";
	public final static String PLUGIN_NAME = "WCET";
	private final static String PLUGIN_ID = "fr.tpt.aadl.ramses.control.osate.wcet";

  private String outputModelIdentifier;
  private Resource aadlWithWcet;
  boolean init = true;
  
  private AadlModelInstantiatior _instantiator ;
  private PredefinedAadlModelManager _predefinedResourcesManager ;
  
  public WcetAnalysis(AadlModelInstantiatior instantiator,
                      PredefinedAadlModelManager predefinedResourcesManager)
  {
    _instantiator = instantiator ;
    _predefinedResourcesManager = predefinedResourcesManager ;
  }
  
  @Override
  public void setParameters(Map<String, Object> parameters) {
    if(init)
    {
      mode = (String) parameters.get("Mode");
      AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE;
      currentResult = f.createAnalysisArtifact();
      parameters.put("AnalysisResult", currentResult);
      outputModelIdentifier = (String) parameters.get("OutputModelIdentifier");
      init=false;
    }
    else
      parameters.put("OutputResource", aadlWithWcet);
  }

  
  /*
  @Override
  protected String getActionName() {
    return ACTION_NAME;
  }
  */

  @Override
  public String getRegistryName() {
    return REGISTRY_NAME;
  }

  @Override
  public String getPluginName() {
    return PLUGIN_NAME;
  }

  @Override
  public String getPluginId() {
    return PLUGIN_ID;
  }

  /*
  @Override
  protected void analyzeDeclarativeModel(IProgressMonitor monitor,
      AnalysisErrorReporterManager errManager, Element declarativeObject) 
  {
    //Dialog.showError("WCET Computation Error", "Please select an instance model");
    System.err.println("WCET Computation Error: Please select an instance model");
  }

  @SuppressWarnings("restriction")
  @Override
  protected void analyzeInstanceModel(IProgressMonitor monitor,
      AnalysisErrorReporterManager errManager, SystemInstance root,
      SystemOperationMode som)
  */
  @Override
  public void performAnalysis(SystemInstance systemInstance,
                              File outputDir,
                              AnalysisErrorReporterManager errManager,
                              IProgressMonitor monitor)
                                throws AnalysisResultException
  {
    
    AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE;
    QualitativeAnalysisResult hasWCET = f.createQualitativeAnalysisResult();
    AnalysisSource as = f.createAnalysisSource();
    as.setMethodName(PLUGIN_NAME);
    hasWCET.setSource(as);
    hasWCET.setValidated(true);
    currentResult.getResults().add(hasWCET);
    
    
    String generatedFilePath = systemInstance.eResource().getURI().path();
    File generatedFile = new File(generatedFilePath);
    
    String wcetPath = generatedFile.getParentFile().getParentFile().getParentFile().getAbsolutePath() + "/wcet/";
		File wcetPathFile = new File(wcetPath);
		if(wcetPathFile.exists()==false)
			wcetPathFile.mkdir();
		
    AST2DOT ast2dot = new AST2DOT(wcetPath);
    File outputFile = new File(wcetPath + "threads_ast_extraction.txt");
    try {
      File dir = outputFile.getParentFile();
      if (!dir.exists()) {
        dir.mkdirs();
      }
      if (!outputFile.exists()) {
        outputFile.createNewFile();
      }
      System.out.println("WCET/AST output path: " + wcetPath);

      PrintStream ps = new PrintStream(outputFile);
      WcetAnalysisDebug.addPrinter(ps);
      WcetAnalysisDebug.addErrorPrinter(ps);
    } catch (IOException e) {
      e.printStackTrace();
    }

    // ASTDebug.addPrinter(System.out);
    WcetAnalysisDebug.addErrorPrinter(System.err);

    String outputPath = systemInstance.eResource().getURI().path();
    WcetAnalysisDebug.println("Source file: " + outputPath);

    ExtractionContext helper = ExtractionContext.createNewInstance(systemInstance,
                                                                   null);
    AST2ResultModel toResult = new AST2ResultModel(systemInstance,helper);
    
    AnalysisModel m = toResult.getAnalysisModel();
    try
    {
      Wcet2AadlEMFTVMLauncher launcher = new Wcet2AadlEMFTVMLauncher(m, _instantiator, _predefinedResourcesManager);
      List<File> transformationFileList = new ArrayList<File>();
      Aadl2Util.setUseTunedEqualsMethods (false);
      
      transformationFileList.add(new File(RamsesConfiguration.getAtlResourceDir().getAbsolutePath()+"/WcetAnalysis/ReducedBA"));
      
      launcher.setOutputPackageName(outputModelIdentifier);
      File wcetOutputDir = new File(outputDir.getAbsolutePath()+"/wcet");
      if(wcetOutputDir.exists()==false)
        wcetOutputDir.mkdir();
      File aadlWithWcetFile = new File(wcetOutputDir.getAbsolutePath()+File.separator+outputModelIdentifier+".aadl2");
      Resource rootResource = systemInstance.eResource();
      aadlWithWcet = launcher.doTransformation(transformationFileList, 
                    rootResource,
                    outputDir.getAbsolutePath(),
                    "_"+outputModelIdentifier);
      
      aadlWithWcet.setURI(URI.createFileURI(aadlWithWcetFile.getAbsolutePath()));
      
      _instantiator.serialize(aadlWithWcet, aadlWithWcetFile.getAbsolutePath());
    }
    catch(Exception e)
    {
      e.printStackTrace();
      System.exit(-1);
    }
    finally
    {
      Aadl2Util.setUseTunedEqualsMethods (false);
    }
    for(ReducedThreadBA rba : m.getThreadsBA())
    {
      ComponentInstance thread = rba.getThread();
      List<ThreadBehaviorElement> l = rba.getElements();
      
      System.out.println("\n\nThread " + thread.getName());
      for(ThreadBehaviorElement e : l)
      {
        if (e instanceof Computation)
        {
          Computation c = (Computation) e;
          System.out.println("\tComputation WCET=" + c.getMax());
        }
        else if (e instanceof CriticalSectionBegin)
        {
//          CriticalSectionBegin csb = (CriticalSectionBegin) e;
//          DataAccess da = csb.getSharedData();
          System.out.println("\tGet_Resource");
        }
        else
        {
//          CriticalSectionEnd cse = (CriticalSectionEnd) e;
//          DataAccess da = cse.getSharedData();
          System.out.println("\tRelease_Resource");
        }
      }
    }
    for (ComponentInstance ci : systemInstance.getAllComponentInstances()) 
    {
      if (ci.getCategory() == ComponentCategory.THREAD) 
      {
        TaskBody tb = helper.getAST(ci);
        ast2dot.visit(tb);
      }
    }
  }
}