package fr.tpt.aadl.sched.wcetanalysis.extractors.ba.util;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.core.runtime.Platform;
import org.osate.aadl2.Aadl2Factory;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.AccessConnection;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.IntegerLiteral;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.RealLiteral;
import org.osate.aadl2.StringLiteral;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramCallSequence;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.ba.aadlba.AssignmentAction;
import org.osate.ba.aadlba.BehaviorAction;
import org.osate.ba.aadlba.BehaviorActionBlock;
import org.osate.ba.aadlba.BehaviorActionSequence;
import org.osate.ba.aadlba.BehaviorActionSet;
import org.osate.ba.aadlba.BehaviorActions;
import org.osate.ba.aadlba.CalledSubprogramHolder;
import org.osate.ba.aadlba.DataAccessHolder;
import org.osate.ba.aadlba.DataComponentReference;
import org.osate.ba.aadlba.ElementValues;
import org.osate.ba.aadlba.ElseStatement;
import org.osate.ba.aadlba.ForOrForAllStatement;
import org.osate.ba.aadlba.IfStatement;
import org.osate.ba.aadlba.IntegerValue;
import org.osate.ba.aadlba.LockAction;
import org.osate.ba.aadlba.ParameterLabel;
import org.osate.ba.aadlba.Relation;
import org.osate.ba.aadlba.SubprogramCallAction;
import org.osate.ba.aadlba.TimedAction;
import org.osate.ba.aadlba.UnlockAction;
import org.osate.ba.aadlba.Value;
import org.osate.ba.aadlba.ValueExpression;
import org.osate.ba.aadlba.WhileOrDoUntilStatement;
import org.osate.ba.utils.AadlBaUtils;
import org.osate.utils.Aadl2Utils;
import org.osate.utils.PropertyUtils;
import org.osate.xtext.aadl2.properties.util.GetProperties;

import fr.tpt.aadl.sched.wcetanalysis.ExtractionContext;
import fr.tpt.aadl.sched.wcetanalysis.WcetAnalysisDebug;
import fr.tpt.aadl.sched.wcetanalysis.extractors.ba.BehaviorAnnexExtractor;
import fr.tpt.aadl.sched.wcetanalysis.model.ASTNode;
import fr.tpt.aadl.sched.wcetanalysis.model.StatementKind;
import fr.tpt.aadl.sched.wcetanalysis.util.Aadl2ASTUtil;
import fr.tpt.aadl.sched.wcetanalysis.util.BehaviorAnnexUtil;
import fr.tpt.aadl.sched.wcetanalysis.util.IDGenerator;

import fr.tpt.aadl.ramses.instantiation.manager.PredefinedPackagesManager;
import fr.tpt.aadl.ramses.instantiation.manager.PredefinedPropertiesManager;
import fr.tpt.aadl.ramses.util.properties.AadlUtil;

/**
 * Extract action flow from a list of Behavior Actions
 * 
 * @author Fabien Cadoret
 */
public class BehaviorActionBlockExtractor extends BehaviorAnnexExtractor
{

	private static final String AWAIT_DISPATCH = "Periodic_Wait";

	private final AssignmentActionUtil assignUtil;
	private final WhileLoopUtil   whileUtil;
	private ComponentInstance taskInstance = null;

	/**
	 * Create a BlockExecutionFlow
	 * 
	 * @param errManager
	 *            error reporter
	 */
	public BehaviorActionBlockExtractor(ExtractionContext ctxt)
	{
		super(ctxt);
		assignUtil = new AssignmentActionUtil(ctxt);
		whileUtil = new WhileLoopUtil(ctxt);
	}

	/**
	 * Extract action flow from a list of Behavior Actions
	 * 
	 * @param taskInstance
	 *            owner of behavior actions
	 * @param actions
	 *            list of Behavior Actions
	 * @param blockStart
	 *            first action to connect the following actions.
	 * @return last action of the list
	 */
	public ASTNode extractFrom(ComponentInstance taskInstance,
			List<BehaviorAction> actions, ASTNode blockStart)
	{
		this.taskInstance = taskInstance;
		this.assignUtil.setTaskInstance(taskInstance);
		return visitBehaviorActions(actions, blockStart);
	}

	public ASTNode visitBehaviorActions(BehaviorActions actions, 
			ASTNode lastAction)
	{
		return visitBehaviorActions(getActionList(actions), lastAction);
		/*
		if (actions instanceof BehaviorActionBlock)
		{
			return visitBehaviorActions(
					((BehaviorActionBlock) actions).getContent(),
					lastAction);
		}
		else
		{
			List<BehaviorAction> list = null;
			if (actions instanceof BehaviorAction)
			{
				list = new ArrayList<BehaviorAction>();
				list.add((BehaviorAction) actions);
			}
			else
			{
				list = ((BehaviorActionSequence) actions).getActions();
			}
			return visitBehaviorActions(list,lastAction);
		}*/
	}
	
	public static List<BehaviorAction> getActionList(BehaviorActions actions)
	{
		if (actions instanceof BehaviorActionBlock)
		{
			BehaviorActionBlock bl = (BehaviorActionBlock) actions;
			return getActionList(bl.getContent());
		}
		else if (actions instanceof BehaviorAction)
		{
			List<BehaviorAction> list = new ArrayList<BehaviorAction>();
			list.add((BehaviorAction) actions);
			return list;
		}
		else
		{
			return ((BehaviorActionSequence) actions).getActions();
		}
	}
	
	private ASTNode visitBehaviorActions(List<BehaviorAction> actions,
			ASTNode lastAction)
	{
		ASTNode last = lastAction;

		for (int indexAction = 0; indexAction < actions.size(); indexAction++)
		{
			BehaviorAction action = actions.get(indexAction);
			last = visitBehaviorAction(action, last);
		}

		return last;
	}

	private ASTNode visitBehaviorAction(BehaviorAction action, ASTNode lastAction)
	{
		if (action instanceof BehaviorActionBlock)
		{
			return visitBehaviorActions((BehaviorActionBlock) action, lastAction);
		}
		else if (action instanceof IfStatement)
		{
			return caseIf((IfStatement) action, lastAction);
		}
		else if (action instanceof ForOrForAllStatement)
		{
			return caseFor((ForOrForAllStatement) action, lastAction);
		}
		else if (action instanceof AssignmentAction)
		{
			return caseAssignment((AssignmentAction) action, lastAction);
		}
		else if (action instanceof TimedAction)
		{
			return caseTimedAction((TimedAction) action, lastAction);
		}
		else if (action instanceof SubprogramCallAction)
		{
			return caseSubprogramCall((SubprogramCallAction) action, lastAction);
		}
		else if (action instanceof WhileOrDoUntilStatement)
		{
			return caseWhileOrDoUntil((WhileOrDoUntilStatement) action, lastAction);
		}
		else if(action instanceof LockAction)
		{
			return caseLockAction((LockAction) action, lastAction);
		}
		else if(action instanceof UnlockAction)
		{
			return caseUnockAction((UnlockAction) action, lastAction);
		}
		else
		{
			reportError(action, "Unknown behavior action kind : " + action);
			return null;
		}
	}

	private ASTNode caseAssignment(AssignmentAction aa, ASTNode lastAction)
	{
		return assignUtil.computeAssignment(aa, lastAction);
	}

	private ASTNode caseTimedAction(TimedAction ta, ASTNode lastAction)
	{
		final ComponentInstance element = lastAction.getElement();
		
		double minVal, maxVal;
		
		IntegerValue min = ta.getLowerTime().getIntegerValue();
		IntegerValue max = ta.getUpperTime().getIntegerValue();
		
		String precision = AadlUtil.getPrecision(element);
				
		if (min instanceof IntegerLiteral)
		{
			IntegerLiteral ilMin = Aadl2Factory.eINSTANCE.createIntegerLiteral();
			ilMin.setUnit(ta.getLowerTime().getUnit());
			ilMin.setValue(((IntegerLiteral) min).getValue());
			minVal = ilMin.getScaledValue(precision);
		}
		else
		{
			RealLiteral irMin = Aadl2Factory.eINSTANCE.createRealLiteral();
			irMin.setUnit(ta.getLowerTime().getUnit());
			irMin.setValue(((RealLiteral) min).getValue());
			minVal = irMin.getScaledValue(precision);
		}

		if (max instanceof IntegerLiteral)
		{
			IntegerLiteral ilMax = Aadl2Factory.eINSTANCE.createIntegerLiteral();
			ilMax.setUnit(ta.getUpperTime().getUnit());
			ilMax.setValue(((IntegerLiteral) max).getValue());
			maxVal = ilMax.getScaledValue(precision);
		}
		else
		{
			RealLiteral irMax = Aadl2Factory.eINSTANCE.createRealLiteral();
			irMax.setUnit(ta.getUpperTime().getUnit());
			irMax.setValue(((RealLiteral) max).getValue());
			maxVal = irMax.getScaledValue(precision);
		}

		ASTNode comp = new ASTNode(IDGenerator.getNewIdForName("computation"),
				StatementKind.Compute, element);
		comp.setMinExecutionTime(minVal);
		comp.setMaxExecutionTime(maxVal);
		lastAction.addNext(comp);
		lastAction = comp;
		return lastAction;
	}

	private ASTNode caseSubprogramCall(SubprogramCallAction callAction,
			ASTNode lastAction)
	{
		final CalledSubprogramHolder holder = (CalledSubprogramHolder) callAction.getSubprogram();
		final NamedElement ref = BehaviorAnnexUtil.getSubprogramReference(callAction);
		
		
		ctxt.pushVisitingSubprogramCallAction(callAction);
		
		lastAction = ctxt.subprogramExtractor.caseSubprogramClassifier((Classifier) ref, lastAction);
		lastAction.addExecutionTime(assignUtil.computeParametersAssignmentTime(callAction));
		
		ctxt.popVisitingSubprogramCallAction();
		
		StatementKind type = lastAction.getType();

		if ((type == StatementKind.GetResource)
				|| (type == StatementKind.ReleaseResource))
		{
			String accessID = BehaviorAnnexUtil.getSharedDataNameFromSubprogramCall(callAction);
			NamedElement currentVisiting = ctxt.getCurrentVisitedElement(); // subprogram call Put_Value
			String res = getResourceID(currentVisiting, accessID);
			lastAction.setResourceID(res);
		}

		if (holder.getElement().getName().equals(AWAIT_DISPATCH))
		{
			lastAction.setType(StatementKind.AwaitDispatch);
		}
		return lastAction;
	}
	
	private String getResourceID(NamedElement e, String accessID)
	{
		if (e instanceof SubprogramCall)
		{
			SubprogramCall call = (SubprogramCall) e;
			SubprogramCallSequence seq = (SubprogramCallSequence) call.eContainer();
			ThreadImplementation ti = (ThreadImplementation) seq.eContainer();
			accessID = getResourceID(ti, accessID, call);
			return accessID;
		}
		return accessID;
	}
	
	private String getResourceID(NamedElement e, String resourceID, SubprogramCall call)
	{
		if (e instanceof ThreadImplementation)
		{
			ThreadImplementation ti = (ThreadImplementation) e;
			for(AccessConnection ac : ti.getOwnedAccessConnections())
			{
				ConnectedElement dstCE = (ConnectedElement) ac.getDestination();
				if (dstCE.getContext()==call && dstCE.getConnectionEnd().getName().equals(resourceID))
				{
					ConnectedElement srcCE = (ConnectedElement) ac.getSource();
					return srcCE.getConnectionEnd().getName();
				}
			}
			
		}
		return resourceID;
	}

	private ASTNode caseIf(IfStatement action, ASTNode lastAction)
	{
		ASTNode actionIf = new ASTNode(IDGenerator.getNewIdForName("if"),
				StatementKind.Conditional, taskInstance);
		ASTNode actionIfEnd = new ASTNode(IDGenerator.getNewIdForName("endif"),
				StatementKind.ConditionalEnd, taskInstance);
		IfStatement stmt = (IfStatement) action;
		
		actionIf.setJoin(actionIfEnd);
		lastAction.addNext(actionIf);
				
		WcetAnalysisDebug.println("[If]Entering if action block");
		WcetAnalysisDebug.incrementIndent();
		
		ASTNode lastIf = visitBehaviorActions(stmt.getBehaviorActions(), 
				actionIf);
		lastIf.addNext(actionIfEnd);
		
		WcetAnalysisDebug.decrementIndent();
		
		if (stmt.getElseStatement() != null)
		{
			WcetAnalysisDebug.println("[If]Entering else action block");
			WcetAnalysisDebug.incrementIndent();
			
			ElseStatement elseStmt = stmt.getElseStatement();
			ASTNode lastElse = visitBehaviorActions(elseStmt.getBehaviorActions(),
					actionIf);
			lastElse.addNext(actionIfEnd);
			
			WcetAnalysisDebug.decrementIndent();
		}
		else
		{
			actionIf.addNext(actionIfEnd);
		}
		
		WcetAnalysisDebug.println("[If]Leaving if action block");
		
		return actionIfEnd;
	}

	private ASTNode caseFor(ForOrForAllStatement forall, ASTNode lastAction)
	{
		ASTNode actionFor = new ASTNode(IDGenerator.getNewIdForName("for"),
				StatementKind.Loop, taskInstance);
		ASTNode actionForEnd = new ASTNode(IDGenerator.getNewIdForName("endfor"),
				StatementKind.LoopEnd, taskInstance);
		actionFor.setJoin(actionForEnd);
		BehaviorActionSet set = (BehaviorActionSet) forall.getBehaviorActions();
		List<BehaviorAction> actionBlock = set.getActions();
		IntegerRange range = getForRange(forall);

		for (int i = range.getMin(); i <= range.getMax(); i++)
		{
			lastAction = extractFrom(taskInstance, actionBlock, actionFor);
		}

		lastAction.addNext(actionForEnd);
		return actionForEnd;
	}

	private IntegerRange getForRange(ForOrForAllStatement forall)
	{
		ElementValues values = forall.getIteratedValues();

		if (values instanceof org.osate.ba.aadlba.IntegerRange)
		{
			org.osate.ba.aadlba.IntegerRange r = (org.osate.ba.aadlba.IntegerRange) values;
			IntegerValue lower = r.getLowerIntegerValue();
			IntegerValue upper = r.getUpperIntegerValue();
			int lowerV = getIntegerValue(lower);
			int upperV = getIntegerValue(upper);
			return new IntegerRange(lowerV, upperV);
		}

		// TODO: return IntegerRange
		return null;
	}

	private ASTNode caseWhileOrDoUntil(WhileOrDoUntilStatement action,
			ASTNode lastAction)
	{
		final String name = (action.isDoUntil() ? "DoUntil" : "While");
		
		WcetAnalysisDebug.println("["+name+"]Entering "+name+" action block");
		WcetAnalysisDebug.incrementIndent();
		
		if (!action.isDoUntil())
		{
			int iterations = whileUtil.computeMaxIterations(action);
			if (iterations >= 0)
			{
				lastAction = whileUtil.unfold(action, iterations, lastAction);
			}
		}
		
		WcetAnalysisDebug.decrementIndent();
		WcetAnalysisDebug.println("["+name+"]Leaving "+name+" action block");
		
		
		return lastAction;
	}

	private ASTNode caseLockAction(LockAction action,
			ASTNode lastAction)
	{
		ASTNode newNode = new ASTNode(StatementKind.GetResource, ctxt.getCurrentVisitedThread());
		NamedElement currentVisiting = ctxt.getCurrentVisitedElement(); // subprogram call Put_Value
		
		int size = ctxt.getVisitingSubprogramCallActionSize();
		DataAccess da = action.getDataAccess().getDataAccess();
		SubprogramType spg = (SubprogramType) da.getContainingClassifier();
		int containerFeatureIdx = Aadl2Utils.orderFeatures(spg).indexOf(da);
		for(int i=0;i<size;i++)
		{
			SubprogramCallAction sca = ctxt.getVisitingSubprogramCallAction(i);
			ParameterLabel pl = sca.getParameterLabels().get(containerFeatureIdx);
			{
				if(pl instanceof ValueExpression)
				{
					ValueExpression ve = (ValueExpression) pl;
					Relation relation = ve.getRelations().get(0);
					Value v = relation.getFirstExpression().getTerms().get(0).getFactors().get(0).getFirstValue();
					if(v instanceof DataAccessHolder)
					{
						DataAccessHolder dah = (DataAccessHolder) v;
						da = (DataAccess) dah.getDataAccess();
						spg = (SubprogramType) da.getContainingClassifier();
						containerFeatureIdx = Aadl2Utils.orderFeatures(spg).indexOf(da);
					}
				}
			}
		}
		
		String res = getResourceID(currentVisiting, da.getName());
		newNode.setResourceID(res);
		lastAction.addNext(newNode);
		return newNode;
	}
	
	private ASTNode caseUnockAction(UnlockAction action, ASTNode lastAction) {
		ASTNode newNode = new ASTNode(StatementKind.ReleaseResource, ctxt.getCurrentVisitedThread());
		NamedElement currentVisiting = ctxt.getCurrentVisitedElement(); // subprogram call Put_Value
		
		int size = ctxt.getVisitingSubprogramCallActionSize();
		DataAccess da = action.getDataAccess().getDataAccess();
		SubprogramType spg = (SubprogramType) da.getContainingClassifier();
		int containerFeatureIdx = Aadl2Utils.orderFeatures(spg).indexOf(da);
		for(int i=0;i<size;i++)
		{
			SubprogramCallAction sca = ctxt.getVisitingSubprogramCallAction(i);
			ParameterLabel pl = sca.getParameterLabels().get(containerFeatureIdx);
			{
				if(pl instanceof ValueExpression)
				{
					ValueExpression ve = (ValueExpression) pl;
					Relation relation = ve.getRelations().get(0);
					Value v = relation.getFirstExpression().getTerms().get(0).getFactors().get(0).getFirstValue();
					if(v instanceof DataAccessHolder)
					{
						DataAccessHolder dah = (DataAccessHolder) v;
						da = (DataAccess) dah.getDataAccess();
						spg = (SubprogramType) da.getContainingClassifier();
						containerFeatureIdx = Aadl2Utils.orderFeatures(spg).indexOf(da);
					}
				}
			}
		}
		
		String res = getResourceID(currentVisiting, da.getName());
		newNode.setResourceID(res);
		lastAction.addNext(newNode);
		return newNode;
	}
	
	private class IntegerRange
	{
		private int min, max;

		private IntegerRange(int min, int max)
		{
			this.min = min;
			this.max = max;
		}

		public int getMax()
		{
			return min;
		}

		public int getMin()
		{
			return max;
		}
	}

	private int getIntegerValue(IntegerValue v)
	{
		// TODO: extract integer parameters from "for statement".
		if (v instanceof DataComponentReference)
		{
			DataComponentReference ref = (DataComponentReference) v;
		}

		return 0; // XXX
	}
}
