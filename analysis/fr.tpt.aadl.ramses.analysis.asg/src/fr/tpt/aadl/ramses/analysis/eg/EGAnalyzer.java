package fr.tpt.aadl.ramses.analysis.eg ;

import java.io.BufferedWriter;
import java.io.File;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory;
import fr.tpt.aadl.ramses.analysis.AnalysisSource;
import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult;
import fr.tpt.aadl.ramses.analysis.eg.model.EGModels;
import fr.tpt.aadl.ramses.analysis.eg.model.EGNode;
import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel;

public class EGAnalyzer extends AbstractAnalyzer
{
  private static final String REGISTRY_NAME = "WCET" ;
  public final static String PLUGIN_NAME = "WCET" ;
  private final static String PLUGIN_ID = "WCET" ;
  
  private AadlModelInstantiatior _instantiator ;
  private PredefinedAadlModelManager _predefinedResourcesManager ;
  
  private final AnalysisArtifact currentResult = createResult();
  private int iterationCounter ;
  
  
  public EGAnalyzer(AadlModelInstantiatior instantiator,
                      PredefinedAadlModelManager predefinedResourcesManager)
  {
    _instantiator = instantiator ;
    _predefinedResourcesManager = predefinedResourcesManager ;
  }
  
  private static AnalysisArtifact createResult()
  {
    /** WCET analysis returns always true (it must be followed 
     * by a scheduling analysis */
    
    final AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE;
    
    AnalysisSource source = f.createAnalysisSource();
    source.setMethodName(PLUGIN_NAME);
    
    AnalysisArtifact currentResult = f.createAnalysisArtifact();
    
    QualitativeAnalysisResult r = f.createQualitativeAnalysisResult();
    r.setValidated(true);
    r.setSource(source);
    currentResult.getResults().add(r);
    
    return currentResult;
  }
  
  @Override
  public void performAnalysis(SystemInstance systemInstance,
                              RamsesConfiguration config,
                              AnalysisErrorReporterManager errManager,
                              IProgressMonitor monitor)
        throws AnalysisException
  {

	Map<ComponentInstance, List<EGNode>> wcetMap = extractWCETModelsMap(systemInstance);
    /** Normalize results */
    
    EGModels models3 = new EGModels();
    for(ComponentInstance thread: wcetMap.keySet())
    {
    	models3.put(thread, wcetMap.get(thread).get(0));
    }
    
    
    EG2ResultModel eg2resultModel = new EG2ResultModel(models3);
    AnalysisModel result = eg2resultModel.getAnalysisModel();
    
  }
  
  
  public Map<ComponentInstance, List<EGNode>> extractWCETModelsMap(ComponentInstance cpu) throws AnalysisException
  {
	    
	    EGLauncher launcher = new EGLauncher(cpu) ;
	    launcher.launch() ;
	  
	    EGModels models = launcher.lastLaunchResults() ;
	    
	    //EG2DOT eg2dot = new EG2DOT ("/home/fabien/execution_graphs/", DOTLayout.dot);
	    //eg2dot.launch(models,systemInstance);
	    
	    /** Clone graph and reduce to a sequence **/
	    
	    EGModels models2 = models.clone();
	    Map<ComponentInstance, List<EGNode>> wcetMap = models2.reduce();
	    
	    //EG2DOT eg2dot2 = new EG2DOT ("/home/fabien/execution_graphs/reduced/", DOTLayout.dot);
	    //eg2dot2.launch(models2,systemInstance);
	    
	    /** Print WCET overhead */
	    
	    for(ComponentInstance thread: models2.getThreads())
	    {
	      double wcet0 = models2.getWCETFromPropertyInMs(thread);
	      double wcet1 = models2.getWCETFromComputationInMs(thread);
	      System.out.printf(thread.getName()+"\t: WCET0=%.4g\tWCET1=%.4g\n",wcet0,wcet1);
	    }
	    return wcetMap;
  }

  @Override
  public void setParameters(Map<String, Object> parameters)
  {
    mode = (String) parameters.get("Mode");
    parameters.put("AnalysisResult", currentResult);
  }

  @Override
  public String getRegistryName()
  {
    return REGISTRY_NAME ;
  }

  @Override
  public String getPluginName()
  {
    return PLUGIN_NAME ;
  }

  @Override
  public String getPluginId()
  {
    return PLUGIN_ID ;
  }

  @Override
  public List<String> getTransformationModuleList() {
	// return null, no transformation performed in this analysis plugin
	return null;
  }

  @Override
  public void setIterationCounter(int iterationCounter)
  {
    this.iterationCounter = iterationCounter;
  }
}
