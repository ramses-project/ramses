package fr.tpt.aadl.ramses.transformation.selection.manual;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.workflow.AbstractLoop ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPilot ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificGenerator ;
import fr.tpt.aadl.ramses.generation.target.specific.LoopManager ;
import fr.tpt.aadl.ramses.generation.target.specific.LoopManagerFactory ;

public class ManualSelectionFactory implements LoopManagerFactory
{

  @Override
  public
      LoopManager
      createLoopManager(AadlTargetSpecificGenerator aadlTargetSpecificGenerator,
                        AbstractLoop l,
                        AnalysisErrorReporterManager errManager,
                        WorkflowPilot workflowPilot,
                        RamsesConfiguration config, IProgressMonitor monitor)
  {
    
    return new ManualSelection(aadlTargetSpecificGenerator,
                               l,
                               errManager,
                               workflowPilot,
                               config,
                               monitor) ;
  }

}
