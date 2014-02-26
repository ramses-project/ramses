package fr.tpt.aadl.launch ;

import java.io.File ;
import java.io.IOException ;
import java.util.Map ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.Element ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.instance.SystemOperationMode ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.ui.actions.AbstractInstanceOrDeclarativeModelReadOnlyAction ;

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
    catch(IOException e1)
    {
      System.err
            .println("Simulation aborted (no generated file) : bad xml model") ;
      e1.printStackTrace() ;
    }
    catch(Exception e2)
    {
      e2.printStackTrace() ;
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