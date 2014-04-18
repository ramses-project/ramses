package fr.tpt.aadl.sched.wcetanalysis.extractors.ba.util;

import java.util.List;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.ba.aadlba.AssignmentAction;
import org.osate.ba.aadlba.BehaviorAction;
import org.osate.ba.aadlba.BehaviorActions;
import org.osate.ba.aadlba.BehaviorIntegerLiteral;
import org.osate.ba.aadlba.BehaviorVariable;
import org.osate.ba.aadlba.BehaviorVariableHolder;
import org.osate.ba.aadlba.BinaryAddingOperator;
import org.osate.ba.aadlba.DataComponentReference;
import org.osate.ba.aadlba.DataHolder;
import org.osate.ba.aadlba.Factor;
import org.osate.ba.aadlba.LogicalOperator;
import org.osate.ba.aadlba.Relation;
import org.osate.ba.aadlba.RelationalOperator;
import org.osate.ba.aadlba.SimpleExpression;
import org.osate.ba.aadlba.Target;
import org.osate.ba.aadlba.Term;
import org.osate.ba.aadlba.Value;
import org.osate.ba.aadlba.ValueExpression;
import org.osate.ba.aadlba.WhileOrDoUntilStatement;
import org.osate.utils.PropertyUtils;

import fr.tpt.aadl.sched.wcetanalysis.ExtractionContext;
import fr.tpt.aadl.sched.wcetanalysis.WcetAnalysisDebug;
import fr.tpt.aadl.sched.wcetanalysis.model.ASTNode;
import fr.tpt.aadl.sched.wcetanalysis.model.StatementKind;
import fr.tpt.aadl.sched.wcetanalysis.util.IDGenerator;


public class WhileLoopUtil
{	
	private final ExtractionContext ctxt;
	
	public WhileLoopUtil(ExtractionContext ctxt)
	{
		this.ctxt = ctxt;
	}
	
	public ASTNode unfold(WhileOrDoUntilStatement action, int iterations,
			ASTNode lastAction)
	{
		final ComponentInstance taskInstance = ctxt.getCurrentVisitedThread();
		
		ASTNode actionWhile = new ASTNode(IDGenerator.getNewIdForName("while"),
				StatementKind.Loop, taskInstance);
		ASTNode actionWhileEnd = new ASTNode(IDGenerator.getNewIdForName("endwhile"),
				StatementKind.LoopEnd, taskInstance);
		actionWhile.setJoin(actionWhileEnd);
		
		final BehaviorActions body = action.getBehaviorActions();
		
		ASTNode first = actionWhile;
		for(int i=0;i<iterations;i++)
		{
			String name = actionWhile.getName() + "__Iteration_" + (i+1);
			ASTNode nodeIter = new ASTNode(name,StatementKind.Empty, taskInstance);
			
			debug("Iteration " + (i+1), "*");
			WcetAnalysisDebug.incrementIndent();
			
			ASTNode lastLoopAction = ctxt.behaviorActionBlockExtractor
					.visitBehaviorActions(body,nodeIter);
			
			first.addNext(nodeIter);
			first = lastLoopAction;
			
			WcetAnalysisDebug.decrementIndent();
		}
		first.addNext(actionWhileEnd);
		
		lastAction.addNext(actionWhile);
		
		return actionWhileEnd;
	}
	
	
	public int computeMaxIterations(WhileOrDoUntilStatement action)
	{
		if (hasCompatibleGlobalCondition(action))
		{
			Relation indexCond = findSubconditionWithIndexTest(action);
			if (indexCond != null)
			{
				BehaviorVariable indexVar = getSubconditionIndexVariable(indexCond);
				int bound = getSubconditionBoundValue(indexCond);
				RelationalOperator rop = getIndexIncrementDirectionInActionBlock(action,indexVar);
				
				if (bound == -1)
				{
					error("No bound found for index " + indexVar.getName());
				}
				else
				{
					debug("Subcondition is found: " + indexVar.getName() 
							+ " " + rop.getLiteral() + " " + bound, "*");
					
					return bound;
				}
			}
			else
			{
				error("Subcondition is not found (index condition)");
			}
		}
		else
		{
			error("Only logical operator AND is allowed on main condition");
		}
		
		return -1;
	}
	
	private static void debug(String msg, String prefix)
	{
		String p = "[" + prefix + "]";
		WcetAnalysisDebug.println(p + msg);
	}
	
	private static void error(String msg)
	{
		WcetAnalysisDebug.error("[*]" + msg);
	}
	
	private static boolean hasCompatibleGlobalCondition(WhileOrDoUntilStatement action)
	{
		ValueExpression cond = action.getLogicalValueExpression();
		List<LogicalOperator> lops = cond.getLogicalOperators();
		if (lops != null)
		{
			for(LogicalOperator o : lops)
			{
				if ((o != LogicalOperator.AND) 
						&& (o != LogicalOperator.NONE))
				{
					return false;
				}
			}
		}
		return true;
	}
	
	private int getSubconditionBoundValue(Relation indexCond)
	{
		SimpleExpression se = indexCond.getSecondExpression();
		Value v = se.getTerms().get(0).getFactors().get(0).getFirstValue();
		if (v instanceof DataComponentReference)
		{
			DataComponentReference r = (DataComponentReference) v;
			int elementsCount = r.getData().size();
			DataHolder h = r.getData().get(elementsCount - 1);
			NamedElement data = h.getElement();
			int initialValue = getInitialValue(data);
			
			if (initialValue==-1 && elementsCount > 1)
			{
				NamedElement assigned = ctxt.callUtil.getAssignedValue(r);
				initialValue = getInitialValue(assigned);
			}
			
			return initialValue;
		}
		
		return -1;
	}
	
	private static int getInitialValue(NamedElement data)
	{
		try
		{
			List<String> values = PropertyUtils.getStringListValue(data, "Initial_Value");
			if (values!=null && values.size()>0)
			{
				return Integer.parseInt(values.get(0));
			}
			else
			{
				return -1;
			}
		}
		catch (Exception e)
		{
			return -1;
		}
	}
	
	private static Relation findSubconditionWithIndexTest(WhileOrDoUntilStatement action)
	{
		for(Relation r: action.getLogicalValueExpression().getRelations())
		{
			Relation subcondition = getSubconditionWithIndexTest(
					r.getFirstExpression());
			if (subcondition != null)
			{
				BehaviorVariable indexVar = getSubconditionIndexVariable(subcondition);
				
				/* Check if the increment (+1 or -1) of the variable in 
				 * the loop body is in coherency with the 
				 * relational operator (< or >) of the condition.
				 */
				if (checkIndexAssignmentCoherencyWithCondition(action,
						indexVar, subcondition.getRelationalOperator()))
				{
					return subcondition;
				}
			}
		}
		return null;
	}
	
	private static boolean checkIndexAssignmentCoherencyWithCondition(
			WhileOrDoUntilStatement action, 
			BehaviorVariable indexVar,
			RelationalOperator conditionOp)
	{
		return conditionOp == getIndexIncrementDirectionInActionBlock(
				action, indexVar);
	}
	
	private static Relation getSubconditionWithIndexTest(SimpleExpression se)
	{
		if (se.getTerms().size()!=1)
		{
			return null;
		}
		
		Term t = se.getTerms().get(0);
		if (t.getFactors().size()!=1)
		{
			return null;
		}
		
		Factor f = t.getFactors().get(0);
		if (f.getSecondValue()!=null)
		{
			return null;
		}
		
		Value v = f.getFirstValue();
		if (!(v instanceof ValueExpression))
		{
			return null;
		}
		
		ValueExpression ve = (ValueExpression) v;
		if (ve.getRelations().size()!=1)
		{
			return null;
		}
		
		Relation r = ve.getRelations().get(0);
		SimpleExpression left = r.getFirstExpression();
		if (left.getTerms().size()!=1)
		{
			return null;
		}
				
		Term t2 = left.getTerms().get(0);
		if (t2.getFactors().size()!=1)
		{
			return null;
		}
		
		Factor f2 = t2.getFactors().get(0);
		if (f2.getSecondValue()!=null)
		{
			return null;
		}
		
		Value v2 = f2.getFirstValue();
		if (v2 instanceof BehaviorVariableHolder)
		{
			return r;
		}
		return null;
	}
	
	private static BehaviorVariable getSubconditionIndexVariable(Relation r)
	{
		Value v = r.getFirstExpression().getTerms()
				.get(0).getFactors().get(0).getFirstValue();
		
		return ((BehaviorVariableHolder) v).getBehaviorVariable();
	}

	private static RelationalOperator getIndexIncrementDirectionInActionBlock(
			WhileOrDoUntilStatement action, BehaviorVariable indexVar)
	{
		List<BehaviorAction> actions = BehaviorActionBlockExtractor
				.getActionList(action.getBehaviorActions());
		
		for(BehaviorAction a : actions)
		{
			if (a instanceof AssignmentAction)
			{
				AssignmentAction aa = (AssignmentAction) a;
				Target t = aa.getTarget();
				NamedElement target = AssignmentActionUtil.getTargetElement(t);
				
				if (target == indexVar)
				{
					ValueExpression assigned = aa.getValueExpression();
					Relation r = assigned.getRelations().get(0);
					SimpleExpression se = r.getFirstExpression();
					BinaryAddingOperator baop = se.getBinaryAddingOperators().get(0);
					
					if (se.getTerms().size()>1)
					{
						Value incValue = se.getTerms().get(1).getFactors().get(0).getFirstValue();
						if (incValue instanceof BehaviorIntegerLiteral)
						{
							BehaviorIntegerLiteral bil = (BehaviorIntegerLiteral) incValue;
							if (bil.getValue()==1l)
							{
								return getCorresponding(baop);
							}
						}
					}
				}
			}
		}
		return RelationalOperator.NONE;
	}
	
	private static RelationalOperator getCorresponding(BinaryAddingOperator baop)
	{
		switch (baop)
		{
			case PLUS: return RelationalOperator.LESS_THAN;
			case MINUS: return RelationalOperator.GREATER_THAN;
			default: return RelationalOperator.NONE;
		}
	}
}
