package fr.tpt.aadl.launch ;

import java.io.FileNotFoundException ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.Element ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.instance.SystemOperationMode ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.ui.actions.AbstractInstanceOrDeclarativeModelReadOnlyAction ;

import fr.tpt.aadl.sched.cheddar.CheddarToolchain ;

public class CheddarBackgroundExecution extends
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
  {
    CheddarToolchain cheddar = new CheddarToolchain(root, errManager) ;
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
}
