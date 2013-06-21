package fr.tpt.aadl.sched.wcetanalysis.extractors.ba;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.instance.ComponentInstance;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionCollection;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition;
import fr.tpt.aadl.annex.behavior.aadlba.LoopStatement;
import fr.tpt.aadl.sched.wcetanalysis.ExtractionContext;
import fr.tpt.aadl.sched.wcetanalysis.model.ASTExtractor;
import fr.tpt.aadl.sched.wcetanalysis.model.ASTNode;
import fr.tpt.aadl.sched.wcetanalysis.util.IDGenerator;

public abstract class BehaviorAnnexExtractor extends ASTExtractor
{

	public BehaviorAnnexExtractor(ExtractionContext ctxt)
	{
		super(ctxt, ctxt.errManager);
	}

	protected static List<BehaviorAction> getActions(BehaviorTransition tran)
	{
		List<BehaviorAction> actions;
		BehaviorActionBlock block = ((BehaviorActionBlock) tran.getActionBlock());
		
		if (block == null)
		{
			return Collections.emptyList();
		}
		
		BehaviorActions bactions = block.getContent();

		if (tran.getActionBlock() == null)
		{
			actions = new ArrayList<BehaviorAction>();
		}
		else if (bactions instanceof BehaviorAction)
		{
			actions = new ArrayList<BehaviorAction>();
			actions.add((BehaviorAction) bactions);
		}
		else
		{
			actions = ((BehaviorActionCollection) bactions).getActions();
		}
		return actions;
	}

	protected boolean checkIsCompatibleSpecification(BehaviorAnnex ba)
	{
		List<BehaviorTransition> transitions = ba.getTransitions();

		for (int indexTr = 0; indexTr < transitions.size(); indexTr++)
		{
			BehaviorTransition tran = transitions.get(indexTr);
			List<BehaviorAction> actions = getActions(tran);

			for (BehaviorAction action : actions)
			{
				if (action instanceof LoopStatement)
				{
					//reportError(
					//		action,
					//		"Unable to perform time analysis : task behavior must not owns loop/while/do statements");
					return true;
				}
			}
		}

		return true;
	}

	protected static boolean isInitial(BehaviorTransition t, String stateID)
	{
		BehaviorState bs = t.getSourceState();
		return (bs.getName().equals(stateID) && bs.isInitial());
	}
	
	protected static boolean isFinal(BehaviorTransition t, String stateID)
	{
		BehaviorState bs = t.getDestinationState();
		return (bs.getName().equals(stateID) && bs.isFinal());
	}
	
	protected static BehaviorState getFinalState(BehaviorAnnex ba)
	{
		for(BehaviorState st : ba.getStates())
		{
			boolean isFinal = true;
			for(BehaviorTransition t : ba.getTransitions())
			{
				if (t.getSourceState() == st)
					isFinal = false;
			}
			if (isFinal)
				return st;
		}
		return null;
	}
	
	protected static boolean isInitialFinalTran(BehaviorTransition t)
	{
		BehaviorState src = t.getSourceState();
		BehaviorState dst = t.getDestinationState();
		return src==dst && src.isInitial() && src.isFinal();
	}

	protected void registerStatesIntoGraph(BehaviorAnnex ba,
			ComponentInstance task, Map<String, ASTNode> stateToStart,
			Map<String, ASTNode> stateToEnd)
	{
		String ownerID = ctxt.getCurrentVisitedElement().getName();
		ownerID = ownerID.replace(".", "_");

		for (BehaviorState s : ba.getStates())
		{
			String id = s.getName();
			String idEnter = IDGenerator.getNewIdForName(ownerID + "_entering_state_" + id);
			String idLeave = IDGenerator.getNewIdForName(ownerID + "_leaving_state_" + id);
			ASTNode st = ASTNode.createEmptyAction(idEnter,task);
			ASTNode end = ASTNode.createEmptyAction(idLeave,task);
			st.setJoin(end);
			stateToStart.put(id, st);
			stateToEnd.put(id, end);
		}
	}

}
