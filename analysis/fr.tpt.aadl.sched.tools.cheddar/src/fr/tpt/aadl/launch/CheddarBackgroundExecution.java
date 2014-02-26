package fr.tpt.aadl.launch ;

import java.io.File ;
import java.io.FileNotFoundException ;
import java.util.Map ;

import javax.naming.OperationNotSupportedException ;

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

public class CheddarBackgroundExecution implements Analyzer

/*
extends
                                       AbstractInstanceOrDeclarativeModelReadOnlyAction
                                       
                                       */
{
/*
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
                              IProgressMonitor monitor
                              )
        throws AnalysisException
  {
    CheddarToolchain cheddar = new CheddarToolchain(systemInstance,
                                                    outputDir,
                                                    errManager) ;
    cheddar.createCheddarModel() ;

    try
    {
      cheddar.exportAndSimule() ;

      if(cheddar.isSchedulable())
      {
        System.out
              .println("[There is no missed deadlines ! System is schedulable.]") ;
      }
      else
      {
        System.err
              .println("[There is missed deadlines ! System is not schedulable.]") ;
        System.err.flush() ;
      }
    }
    catch(FileNotFoundException e1)
    {
      System.err
            .println("Simulation aborted (no generated file) : bad xml model") ;
      e1.printStackTrace() ;
    }
    catch(Exception e2)
    {
      e2.printStackTrace() ;
    }
    return;
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
