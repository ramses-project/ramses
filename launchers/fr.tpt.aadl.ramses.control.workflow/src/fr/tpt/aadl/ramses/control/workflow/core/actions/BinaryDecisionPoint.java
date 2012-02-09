package fr.tpt.aadl.ramses.control.workflow.core.actions;

import fr.tpt.aadl.ramses.control.support.analysis.AnalysisResultException;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer;
import fr.tpt.aadl.ramses.control.workflow.core.Branch;
import fr.tpt.aadl.ramses.control.workflow.core.BranchAction;
import fr.tpt.aadl.ramses.control.workflow.core.WorkflowContext;

public class BinaryDecisionPoint implements BranchAction {

	private final Analyzer decisionPoint;
	private final Branch yes;
	private final Branch no;
	
	public BinaryDecisionPoint(Analyzer decisionPoint, Branch yes, Branch no)
	{
		this.decisionPoint = decisionPoint;
		this.yes = yes;
		this.no = no;
	}
	
	@Override
	public boolean execute(WorkflowContext c)  throws AnalysisResultException
	{
		if (c.callAnalyzer(decisionPoint))
		{
			return yes.execute(c);
		}
		else
		{
			return no.execute(c);
		}
	}

}
