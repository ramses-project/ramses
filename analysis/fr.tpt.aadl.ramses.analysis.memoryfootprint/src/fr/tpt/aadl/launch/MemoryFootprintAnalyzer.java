package fr.tpt.aadl.launch;

import java.io.File ;
import java.util.Map ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory ;
import fr.tpt.aadl.ramses.analysis.memoryfootprint.MemoryFootprintAnalysis ;
import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;


public class MemoryFootprintAnalyzer extends AbstractAnalyzer
{

  private static final String REGISTRY_NAME = "MemoryFootprint" ;
  public final static String PLUGIN_NAME = "MemoryFootprint" ;
  private final static String PLUGIN_ID = "MemoryFootprint" ;

  protected final AadlModelInstantiatior modelInstantiator;
  protected final PredefinedAadlModelManager predefinedAadlModels;
  
  public MemoryFootprintAnalyzer(AadlModelInstantiatior modelInstantiator,
                                 PredefinedAadlModelManager predefinedAadlModels)
  {
    this.modelInstantiator = modelInstantiator;
    this.predefinedAadlModels = predefinedAadlModels;
  }

  @Override
  public void performAnalysis(SystemInstance systemInstance,
                              File outputDir,
                              AnalysisErrorReporterManager errManager,
                              IProgressMonitor monitor)
        throws AnalysisException
  {
    currentResult = MemoryFootprintAnalysis.doAnalysis(systemInstance);
  }

  private boolean first = true;
  
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
}
