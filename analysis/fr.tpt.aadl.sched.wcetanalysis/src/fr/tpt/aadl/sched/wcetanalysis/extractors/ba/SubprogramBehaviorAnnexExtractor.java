package fr.tpt.aadl.sched.wcetanalysis.extractors.ba;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.instance.ComponentInstance;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSequence;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition;
import fr.tpt.aadl.sched.wcetanalysis.ExtractionContext;
import fr.tpt.aadl.sched.wcetanalysis.model.ASTNode;
import fr.tpt.aadl.sched.wcetanalysis.util.BehaviorAnnexUtil;

/**
 * Extract execution flow from subprogram behavior annex.
 * 
 * @author Fabien Cadoret
 * 
 */
public class SubprogramBehaviorAnnexExtractor extends BehaviorAnnexExtractor
{

	public SubprogramBehaviorAnnexExtractor(ExtractionContext ctxt)
	{
		super(ctxt);
	}

	public ASTNode extractFrom(SubprogramCall call, ASTNode lastAction)
	{
		SubprogramClassifier spg = (SubprogramClassifier) call.getCalledSubprogram();
		return extractFrom(spg,lastAction);
	}
	
	public ASTNode extractFrom(Classifier spg, ASTNode lastAction)
	{
		BehaviorAnnex ba = BehaviorAnnexUtil.getBehaviorAnnex(spg) ;
		
		if (!checkIsCompatibleSpecification(ba))
		{
			return null;
		}
		else
		{
			ComponentInstance task = lastAction.getElement();
			return extractFrom(ba, task, lastAction);
		}
	}

	private ASTNode extractFrom(BehaviorAnnex ba, ComponentInstance task,
			ASTNode lastAction)
	{
		final Map<String, ASTNode> stateToStart = new HashMap<String, ASTNode>();
		final Map<String, ASTNode> stateToEnd = new HashMap<String, ASTNode>();
		
		/** For each state, register start and end actions. */
		registerStatesIntoGraph(ba, task, stateToStart, stateToEnd);
		
		String initStateID = BehaviorAnnexUtil.getInitialState(ba);
		String finalStateID = BehaviorAnnexUtil.getFinalState(ba);
		
		ASTNode initialAction = stateToStart.get(initStateID);
		ASTNode endAction = stateToEnd.get(finalStateID);
		//initialAction.addNext(stateToEnd.get(initStateID));
		List<BehaviorTransition> transitions = ba.getTransitions();

		for (int indexTr = 0; indexTr < transitions.size(); indexTr++)
		{
			BehaviorTransition tran = transitions.get(indexTr);
			BehaviorActions bActions = tran.getActionBlock().getContent();
			List<BehaviorAction> actions = null;

			if (bActions instanceof BehaviorAction)
			{
				actions = new ArrayList<BehaviorAction>();
				actions.add((BehaviorAction) bActions);
			}
			else if (bActions instanceof BehaviorActionSequence)
			{
				actions = ((BehaviorActionSequence) bActions).getActions();
			}

			String srcState = tran.getSourceState().getName();
			String dstState = tran.getDestinationState().getName();
			
			ASTNode srcStart = stateToStart.get(srcState);
			ASTNode srcEnd   = stateToEnd.get(srcState);
			ASTNode dstStart = stateToStart.get(dstState);

			ASTNode last = ctxt.behaviorActionBlockExtractor.extractFrom(task,
					actions, srcStart);
			
			last.addNext(srcEnd);
			
			if (! isInitialFinalTran(tran))
			{
				srcEnd.addNext(dstStart);
			}
		}

		lastAction.addNext(initialAction);
		return endAction;
	}

}
