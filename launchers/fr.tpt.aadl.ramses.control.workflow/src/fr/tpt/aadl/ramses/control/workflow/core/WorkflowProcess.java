package fr.tpt.aadl.ramses.control.workflow.core;

import org.osate.aadl2.instance.SystemInstance;

import fr.tpt.aadl.ramses.control.support.analysis.AnalysisResultException;
import fr.tpt.aadl.ramses.control.workflow.core.WorkflowContext.ModelState;

public class WorkflowProcess {
	
	private final Branch mainBranch;
	private final WorkflowContext ctxt;
	
	public WorkflowProcess(Branch mainBranch, 
						   String outputDirectory)
	{
		this.mainBranch = mainBranch;
		this.ctxt = new WorkflowContext(outputDirectory);
	}
	
	public Branch getMainBranch()
	{
		return mainBranch;
	}
	
	public void runOn(SystemInstance model) throws AnalysisResultException
	{
		String aadlFilePath = model.getSystemImplementation().eResource().getURI().path();
		ctxt.addState(new ModelState(model, aadlFilePath));
		
		mainBranch.execute(ctxt);
	}
}
