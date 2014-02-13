package fr.tpt.aadl.launch ;

import java.io.File ;
import java.util.Map ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisResultException ;
import fr.tpt.aadl.sched.cheddar.CheddarOptions ;
import fr.tpt.aadl.sched.cheddar.CheddarToolchain ;

public class WCETAnalysis extends AbstractAnalyzer
{

  public static final String ACTION_NAME = "Model-Based WCET analysis" ;
  public static final String ANALYZER_NAME = "WCETAnalysis" ;
  public final static String PLUGIN_NAME = "AADL-Toolsuite-Scheduling-Cheddar" ;
  public final static String PLUGIN_ID = "fr.tpt.aadl.sched.tools.cheddar" ;

/*
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
  {
    CheddarOptions.CHEDDAR_DEBUG = true ;
    CheddarToolchain cheddar = new CheddarToolchain(root, errManager) ;

    try
    {
      cheddar.createExportAndSimule() ;
      System.out.println("schedulable : " + cheddar.isSchedulable()) ;
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
    }
    return;
  }
*/
/*
  @Override
  protected String getActionName()
  {
    return ACTION_NAME ;
  }
*/
  @Override
  public String getRegistryName()
  {
    return WCETAnalysis.ANALYZER_NAME ;
  }

  @Override
  public void setParameters(Map<String, Object> parameters)
  {
    throw new UnsupportedOperationException() ;
  }

  @Override
  public String getPluginName()
  {
    return WCETAnalysis.PLUGIN_NAME ;
  }

  @Override
  public String getPluginId()
  {
    return WCETAnalysis.PLUGIN_ID ;
  }

  @Override
  public void performAnalysis(SystemInstance root,
                              File outputDir,
                              AnalysisErrorReporterManager errManager,
                              IProgressMonitor monitor)
        throws AnalysisResultException
  {
    CheddarOptions.CHEDDAR_DEBUG = true ;
    CheddarToolchain cheddar = new CheddarToolchain(root, outputDir, errManager) ;

    try
    {
      cheddar.createExportAndSimule() ;
      System.out.println("schedulable : " + cheddar.isSchedulable()) ;
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
    }
    return;
    
  }
}
