package fr.tpt.aadl.ramses.control.workflow.core.actions;

import fr.tpt.aadl.ramses.control.workflow.core.BranchAction;
import fr.tpt.aadl.ramses.control.workflow.core.WorkflowContext;


public class Superimposition implements BranchAction {

	private final String modulePath;
	
	public Superimposition(String modulePath)
	{
		this.modulePath = modulePath;
	}
	
	@Override
	public boolean execute(WorkflowContext c) 
	{
		c.addModule(modulePath);
		return true;
	}

}
