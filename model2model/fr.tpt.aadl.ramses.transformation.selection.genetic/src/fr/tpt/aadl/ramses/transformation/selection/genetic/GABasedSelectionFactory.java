package fr.tpt.aadl.ramses.transformation.selection.genetic;

import org.eclipse.core.runtime.IProgressMonitor ;

import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificGenerator ;
import fr.tpt.aadl.ramses.generation.target.specific.LoopManager ;
import fr.tpt.aadl.ramses.generation.target.specific.LoopManagerFactory ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

public class GABasedSelectionFactory implements LoopManagerFactory
{

  @Override
  public
      LoopManager
      createLoopManager(AadlTargetSpecificGenerator aadlTargetSpecificGenerator,
                        fr.tpt.aadl.ramses.control.workflow.AbstractLoop l,
                        AnalysisErrorReporterManager errManager,
                        fr.tpt.aadl.ramses.control.workflow.WorkflowPilot workflowPilot,
                        fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration config,
                        IProgressMonitor monitor)
  {
    return new GABasedSelection(aadlTargetSpecificGenerator,
                                l,
                                errManager,
                                workflowPilot,
                                config,
                                monitor);
  }

}
