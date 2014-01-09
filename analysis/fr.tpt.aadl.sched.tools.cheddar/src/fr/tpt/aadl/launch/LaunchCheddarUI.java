package fr.tpt.aadl.launch ;

import java.io.IOException ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.Element ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.instance.SystemOperationMode ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.ui.actions.AbstractInstanceOrDeclarativeModelReadOnlyAction ;

import fr.tpt.aadl.sched.cheddar.CheddarToolchain ;

public class LaunchCheddarUI extends
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
  protected Resource analyzeInstanceModel(IProgressMonitor monitor,
                                      AnalysisErrorReporterManager errManager,
                                      SystemInstance root,
                                      SystemOperationMode som)
  {
    CheddarToolchain cheddar = new CheddarToolchain(root, errManager) ;

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
    return null;
  }
}
