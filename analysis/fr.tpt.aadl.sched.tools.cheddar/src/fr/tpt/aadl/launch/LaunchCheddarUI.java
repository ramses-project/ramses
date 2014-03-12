package fr.tpt.aadl.launch ;

import java.io.File ;
import java.io.IOException ;
import java.util.Map ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.ramses.control.support.RamsesException ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer ;
import fr.tpt.aadl.sched.cheddar.CheddarToolchain ;

public class LaunchCheddarUI implements Analyzer
{
/* extends
                            AbstractInstanceOrDeclarativeModelReadOnlyAction
                            
                            
{

  @Override
  protected String getActionName()
  {
    return "Generate Cheddar model and simulate scheduling" ;
  }

  @Override
  protected void analyzeDeclarativeModel(IProgressMonitor monitor,
                                         AnalysisErrorReporterManager errManager,
                                         Element declarativeObject)
  {
  }

  @Override
  protected void analyzeInstanceModel(IProgressMonitor monitor,
                                      AnalysisErrorReporterManager errManager,
                                      SystemInstance root,
                                      SystemOperationMode som)
  */
  
  private static Logger _LOGGER = Logger.getLogger(LaunchCheddarUI.class) ;
  
  @Override
  public void performAnalysis(SystemInstance systemInstance,
                            File outputDir,
                            AnalysisErrorReporterManager errManager,
                            IProgressMonitor monitor)
      throws AnalysisException
  {
    CheddarToolchain cheddar = new CheddarToolchain(systemInstance, outputDir,
                                                    errManager) ;

    try
    {
      cheddar.createCheddarModel() ;
      cheddar.exportAndSimule(true) ;
    }
    catch(IOException e)
    {
      String errMsg = "Simulation aborted (no generated file) : bad xml model" ;
      _LOGGER.fatal(errMsg, e) ;
      throw new RuntimeException(errMsg, e) ;
    }
    catch(Exception e2)
    {
      String errMsg = RamsesException.formatRethrowMessage("Simulation aborted (no generated file) : bad xml model", e2) ;
      _LOGGER.fatal(errMsg, e2) ;
      throw new AnalysisException(errMsg, e2) ;
    }
  }
  
  @Override
  public String getRegistryName()
  {
    throw new UnsupportedOperationException() ;
  }

  @Override
  public String getPluginName()
  {
    throw new UnsupportedOperationException() ;
  }

  @Override
  public String getPluginId()
  {
    throw new UnsupportedOperationException() ;
  }

  @Override
  public void setParameters(Map<String, Object> parameters)
  {
    throw new UnsupportedOperationException() ;
  }
}