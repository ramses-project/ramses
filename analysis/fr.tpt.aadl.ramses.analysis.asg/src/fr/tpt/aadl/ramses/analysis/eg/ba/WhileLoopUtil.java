package fr.tpt.aadl.ramses.analysis.eg.ba;

import java.util.ArrayList ;
import java.util.Collections ;
import java.util.List ;

import org.osate.aadl2.Element ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Parameter ;
import org.osate.ba.aadlba.AssignmentAction ;
import org.osate.ba.aadlba.BehaviorAction ;
import org.osate.ba.aadlba.BehaviorIntegerLiteral ;
import org.osate.ba.aadlba.BehaviorVariableHolder ;
import org.osate.ba.aadlba.BinaryAddingOperator ;
import org.osate.ba.aadlba.DataComponentReference ;
import org.osate.ba.aadlba.DataHolder ;
import org.osate.ba.aadlba.Factor ;
import org.osate.ba.aadlba.LogicalOperator ;
import org.osate.ba.aadlba.ParameterHolder ;
import org.osate.ba.aadlba.Relation ;
import org.osate.ba.aadlba.RelationalOperator ;
import org.osate.ba.aadlba.SimpleExpression ;
import org.osate.ba.aadlba.Target ;
import org.osate.ba.aadlba.Term ;
import org.osate.ba.aadlba.Value ;
import org.osate.ba.aadlba.ValueExpression ;
import org.osate.ba.aadlba.ValueVariable ;
import org.osate.ba.aadlba.WhileOrDoUntilStatement ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.analysis.eg.context.EGContext ;
import fr.tpt.aadl.ramses.analysis.eg.context.SubprogramCallContext ;
import fr.tpt.aadl.ramses.analysis.eg.util.BehaviorUtil ;


public class WhileLoopUtil
{	
  private final static EGContext ctxt = EGContext.getInstance();
  
  
  private WhileLoopUtil(){}
	
	public static int computeMaxIterations(WhileOrDoUntilStatement action)
	{
	  final int countRelations = action.getLogicalValueExpression().getRelations().size();
	  int iRelation = -1;
	  
		if (!hasCompatibleGlobalCondition(action))
		{
		  error("Only logical operator AND is allowed on main condition");
		  return -1;
		}
		
		while (iRelation+1 < countRelations)
		{
			Relation indexCond = findSubconditionWithIndexTest(action, iRelation+1);
			if (indexCond==null)
			{
			  error("Subcondition is not found (index condition)");
			  return -1;
			}
			
			iRelation = action.getLogicalValueExpression().getRelations().indexOf(indexCond);
			if (indexCond != null)
			{
			  Element indexVar = getSubconditionIndexVariable(indexCond);
				String elementName = name (indexVar);
				int bound = getSubconditionBoundValue(indexCond);
				RelationalOperator rop = getIndexIncrementDirectionInActionBlock(action,indexVar);
				
				/*if (bound == -1)
				{
					error("No bound found for index " + elementName);
				}*/
				if (bound != -1)
				{
					debug("Subcondition is found: " + elementName 
							+ " " + rop.getLiteral() + " " + bound, "*");
					
					return bound;
				}
			}
		}
		error("Subcondition is not found (index condition)");
		return -1;
	}
	
	private static void debug(String msg, String prefix)
	{
		String p = "[" + prefix + "]";
		System.err.flush();
		System.out.println(p + msg);
	}
	
	private static void error(String msg)
	{
		System.out.flush();
		System.err.println("[*]" + msg);
	}
	
	private static String name (Element v)
	{
	  NamedElement e = getNamedElement (v);
	  return (e==null ? "???" : e.getName());
	}
	
	private static NamedElement getNamedElement (Element e)
	{
	  if (e instanceof ValueVariable)
	  {
	    ValueVariable v = (ValueVariable) e;
	    List<DataHolder> l = getDataHolders (v);
	    if (!l.isEmpty())
	    {
	      DataHolder h = l.get(l.size()-1);
	      return h.getElement();
	    }
	    else
	    {
	      return null;
	    }
	  }
	  else if (e instanceof NamedElement)
	  {
	    return (NamedElement) e;
	  }
	  else
	  {
	    return null;
	  }
	}
	
	private static List<DataHolder> getDataHolders(ValueVariable v)
	{
	  if (v instanceof DataHolder)
	  {
	    List<DataHolder> l = new ArrayList<DataHolder>();
	    l.add((DataHolder) v);
	    return l;
	  }
	  else if (v instanceof DataComponentReference)
	  {
	    return ((DataComponentReference) v).getData();
	  }
	  else
	  {
	    return Collections.emptyList();
	  }
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
	
	private static int getSubconditionBoundValue(Relation indexCond)
	{
		SimpleExpression se = indexCond.getSecondExpression();
		if (se == null)
		{
		  return -1;
		}
		
		
		Value v = se.getTerms().get(0).getFactors().get(0).getFirstValue();
		if (v instanceof DataComponentReference)
		{
			DataComponentReference r = (DataComponentReference) v;
			int elementsCount = r.getData().size();
			DataHolder h = r.getData().get(elementsCount - 1);
			NamedElement data = h.getElement();
			int initialValue = getInitialValue(data);
			
			//FIXME: find assigned value
			/*if (initialValue==-1 && elementsCount > 1)
			{
				NamedElement assigned = SubprogramCallUtil.getAssignedValue(r);
				initialValue = getInitialValue(assigned);
			}*/
			
			return initialValue;
		}
		else if (v instanceof ParameterHolder)
		{
		  ParameterHolder h = (ParameterHolder) v;
		  Parameter p = h.getParameter();
		  
		  SubprogramCallContext currentCall = ctxt.getCurrentVisitedSubprogram();
		  int value = currentCall.getParameterIntValue(p.getName());
		  
		  return value;
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
	
	private static Relation findSubconditionWithIndexTest(WhileOrDoUntilStatement action, 
	                                                      int startRelation)
	{
	  for(int iRelation=startRelation;
	        iRelation<action.getLogicalValueExpression().getRelations().size();
	        iRelation++)
		//for(Relation r: action.getLogicalValueExpression().getRelations())
		{
	    Relation r = action.getLogicalValueExpression().getRelations().get(iRelation);
			Relation subcondition = getSubconditionWithIndexTest(
					r.getFirstExpression());
			if (subcondition == null)
			{
			  subcondition = r;
			}
			if (subcondition != null)
			{
			  Element indexVar = getSubconditionIndexVariable(subcondition);
				
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
			Element indexVar,
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
	
	private static Element getSubconditionIndexVariable(Relation r)
	{
		Value v = r.getFirstExpression().getTerms()
				.get(0).getFactors().get(0).getFirstValue();
		
		if (v instanceof ValueVariable)
		{
		  return (ValueVariable) v;
		}
		else if (v instanceof ValueExpression)
		{
		  ValueExpression ve = (ValueExpression) v;
		  return getSubconditionIndexVariable(ve.getRelations().get(0));
		}
		else if (v instanceof DataComponentReference)
		{
		  DataComponentReference dcr = (DataComponentReference) v;
		  DataHolder h = dcr.getData().get(dcr.getData().size()-1);
		  NamedElement e = h.getElement();
		  return e;
		}
		else
		{
		  return null;
		}
	}

	private static RelationalOperator getIndexIncrementDirectionInActionBlock(
			WhileOrDoUntilStatement action, Element indexVar)
	{
		List<BehaviorAction> actions = BehaviorUtil.getBehaviorActions(
				action.getBehaviorActions());
		
		NamedElement indexElement = getNamedElement (indexVar);
		
		if (indexElement == null)
		{
		  return RelationalOperator.NONE;
		}
		
		for(BehaviorAction a : actions)
		{
			if (a instanceof AssignmentAction)
			{
				AssignmentAction aa = (AssignmentAction) a;
				Target t = aa.getTarget();
				NamedElement target = AssignmentActionUtil.getTargetElement(t);
				
				if (target == indexElement)
				{
					ValueExpression assigned = aa.getValueExpression();
					Relation r = assigned.getRelations().get(0);
					SimpleExpression se = r.getFirstExpression();
					List<BinaryAddingOperator> addingOperators = se.getBinaryAddingOperators();
					
					if (addingOperators==null || addingOperators.isEmpty())
					{
					  continue;
					}
					
					BinaryAddingOperator baop = addingOperators.get(0);
					
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
