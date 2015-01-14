package fr.tpt.aadl.ramses.generation.target.specific;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.workflow.AbstractLoop ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPilot ;

public interface LoopManagerFactory
{

  LoopManager createLoopManager(AadlTargetSpecificGenerator aadlTargetSpecificGenerator,
                                AbstractLoop l,
                                AnalysisErrorReporterManager errManager,
                                WorkflowPilot workflowPilot,
                                RamsesConfiguration config,
                                IProgressMonitor monitor) ;

}
