package fr.tpt.aadl.launch;

import java.util.List ;
import java.util.Map ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory ;
import fr.tpt.aadl.ramses.analysis.memoryfootprint.MemoryFootprintAnalysis ;
import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;


public class MemoryFootprintAnalyzer extends AbstractAnalyzer
{

  private static final String REGISTRY_NAME = Names.MEMORY_ANALYSIS_PLUGIN_NAME ;
  public final static String PLUGIN_NAME = Names.MEMORY_ANALYSIS_PLUGIN_NAME ;
  private final static String PLUGIN_ID = Names.MEMORY_ANALYSIS_PLUGIN_NAME ;

  protected final AadlModelInstantiatior modelInstantiator;
  protected final PredefinedAadlModelManager predefinedAadlModels;
  
  public MemoryFootprintAnalyzer(AadlModelInstantiatior modelInstantiator,
                                 PredefinedAadlModelManager predefinedAadlModels)
  {
    this.modelInstantiator = modelInstantiator;
    this.predefinedAadlModels = predefinedAadlModels;
  }

  private boolean first = true;
  private int iterationCounter ;
  
  @Override
  public void setParameters(Map<String, Object> parameters)
  {
    if(first)
    {
      mode = (String) parameters.get("Mode") ;
      AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE ;
      currentResult = f.createAnalysisArtifact() ;
      first = false ;
    }
    parameters.put("AnalysisResult", currentResult) ;
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
  public void performAnalysis(SystemInstance systemInstance,
                              RamsesConfiguration config,
                              AnalysisErrorReporterManager errManager,
                              IProgressMonitor monitor)
                                                       throws AnalysisException
  {
    MemoryFootprintAnalysis mfa = new MemoryFootprintAnalysis();
    mfa.doAnalysis(systemInstance, currentResult, iterationCounter);
  }

  @Override
  public List<String> getTransformationModuleList()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public void setIterationCounter(int iterationCounter)
  {
    this.iterationCounter = iterationCounter;
    
  }
}
