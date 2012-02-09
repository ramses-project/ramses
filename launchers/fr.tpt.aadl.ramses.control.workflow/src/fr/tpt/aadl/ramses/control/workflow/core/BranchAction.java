package fr.tpt.aadl.ramses.control.workflow.core;

import fr.tpt.aadl.ramses.control.support.analysis.AnalysisResultException;

public interface BranchAction
{
	public boolean execute(WorkflowContext c) throws AnalysisResultException;
}