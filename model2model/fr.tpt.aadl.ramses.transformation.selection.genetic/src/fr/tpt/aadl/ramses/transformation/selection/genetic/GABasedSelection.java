package fr.tpt.aadl.ramses.transformation.selection.genetic;

import java.io.IOException ;
import java.util.Map ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException ;
import fr.tpt.aadl.ramses.control.support.instantiation.ParseException ;
import fr.tpt.aadl.ramses.control.workflow.AbstractLoop ;
import fr.tpt.aadl.ramses.control.workflow.ResolutionMethod ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPilot ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificGenerator ;
import fr.tpt.aadl.ramses.generation.target.specific.LoopManager ;

public class GABasedSelection implements LoopManager
{

  AadlTargetSpecificGenerator aadlTargetSpecificGenerator;
  AbstractLoop l;
  AnalysisErrorReporterManager errManager;
  WorkflowPilot workflowPilot;
  RamsesConfiguration config;
  IProgressMonitor monitor;
  
  public GABasedSelection(AadlTargetSpecificGenerator aadlTargetSpecificGenerator,
                          AbstractLoop l,
                          AnalysisErrorReporterManager errManager,
                          WorkflowPilot workflowPilot,
                          RamsesConfiguration config, IProgressMonitor monitor)
  {
    this.aadlTargetSpecificGenerator = aadlTargetSpecificGenerator;
    this.l = l;
    this.errManager = errManager;
    this.workflowPilot = workflowPilot;
    this.config = config;
    this.monitor = monitor;
  }

  @Override
  public String getResolutionMethodName()
  {
    return ResolutionMethod.GENETIC_MERGE.getName();
  }

  @Override
  public Map<? extends String, ? extends Resource>
      processLoop() throws AnalysisException, ParseException,
                   TransformationException, ConfigurationException, IOException
  {
    // TODO Auto-generated method stub
    return null ;
  }

}
