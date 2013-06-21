package fr.tpt.aadl.sched.wcetanalysis.extractors.ba.util;

import java.util.List;

import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DataSubcomponentType;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.SubprogramCall;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.instance.ComponentInstance;

import fr.tpt.aadl.annex.behavior.aadlba.ActualPortHolder;
import fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable;
import fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference;
import fr.tpt.aadl.annex.behavior.aadlba.DataHolder;
import fr.tpt.aadl.annex.behavior.aadlba.ParameterHolder;
import fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel;
import fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression;
import fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction;
import fr.tpt.aadl.annex.behavior.aadlba.Target;
import fr.tpt.aadl.annex.behavior.aadlba.Value;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression;
import fr.tpt.aadl.sched.wcetanalysis.ExtractionContext;
import fr.tpt.aadl.sched.wcetanalysis.WcetAnalysisDebug;
import fr.tpt.aadl.sched.wcetanalysis.model.ASTNode;
import fr.tpt.aadl.sched.wcetanalysis.model.IOTime;
import fr.tpt.aadl.sched.wcetanalysis.model.StatementKind;
import fr.tpt.aadl.sched.wcetanalysis.util.Aadl2ASTUtil;
import fr.tpt.aadl.sched.wcetanalysis.util.IDGenerator;
import fr.tpt.aadl.utils.PropertyUtils;

public class AssignmentActionUtil
{
	private ComponentInstance taskInstance = null;
	private final ExtractionContext ctxt;
	
	public AssignmentActionUtil(ExtractionContext ctxt)
	{
		this.ctxt = ctxt;
	}
	
	void setTaskInstance(ComponentInstance taskInstance)
	{
		this.taskInstance = taskInstance;
	}
	
	private static void debug(String msg)
	{
		debug(msg,"Assignment");
	}
	
	private static void debug(String msg, String prefix)
	{
		String p = "[" + prefix + "]";
		if (prefix.equals("*"))
			p = WcetAnalysisDebug.INDENT + p;
		WcetAnalysisDebug.println(p + msg);
	}

	private static Value getAssignedValue(AssignmentAction assign)
	{
		ValueExpression ve = assign.getValueExpression();
		SimpleExpression se = ve.getRelations().get(0).getFirstExpression();
		Value v = se.getTerms().get(0).getFactors().get(0).getFirstValue();
		
		return v;
	}

	private static NamedElement getAssignedData(AssignmentAction assign)
	{
		Value v = getAssignedValue(assign);
		
		if (v instanceof Target)
		{
			return getTargetElement((Target) v);
		}
		else
		{
			return null;
		}
	}

	/*private double computeAssignTime(DataClassifier dataClassifier)
	{
		//final double mSpeed     = getMemorySpeed();
		final long  size       = getSourceDataSize(dataClassifier);
		//final double assignTime = mSpeed * (double) size;
		
		return Aadl2ASTUtil.getWriteTime(taskInstance, (int) size);
	}*/
	
	private void setAssignTime(final double assignTime, ASTNode action)
	{
		action.setMinExecutionTime(assignTime);
		action.setMaxExecutionTime(assignTime);
	}
	
	/*private double getMemorySpeed()
	{
		long bytes = getSourceDataSize();
		return Aadl2ASTUtil.getWriteTime(thread, bytes);
	}*/

	private static long getSourceDataSize(DataClassifier dataClassifier)
	{
		if (dataClassifier == null)
		{
			return 0l;
		}
		
		try
		{
			return PropertyUtils.getIntValue(dataClassifier,
					"Source_Data_Size");
		}
		catch (Exception e)
		{
			try
			{
				DataClassifier baseType = (DataClassifier) PropertyUtils
						.getClassifierValue(dataClassifier, "Base_Type");
				if (baseType != null)
				{
					return getSourceDataSize(baseType);
				}
			}
			catch (Exception e2)
			{
			}
		}
		return 0l;
	}

	public static NamedElement getTargetElement(Target t)
	{
		if (t instanceof DataHolder)
		{
			return ((DataHolder) t).getElement();
		}
		else if (t instanceof DataComponentReference)
		{
			DataComponentReference r = (DataComponentReference) t;
			DataHolder h = r.getData().get(r.getData().size() - 1);
			return ((DataHolder) h).getElement();
		}
		else
		{
			debug("[getTargetElement] Other -> " + t.getClass().getSimpleName());
		}

		return null;
	}
	
	private DataClassifier getDataClassifier(DataSubcomponentType t)
	{
		NamedElement e = ctxt.getCurrentVisitedElement();
		SubprogramClassifier sc = null;
		if (e instanceof SubprogramClassifier)
		{
			sc = (SubprogramClassifier) e;
		}
		else if (e instanceof SubprogramCall)
		{
			sc = (SubprogramClassifier) 
					(((SubprogramCall) e).getCalledSubprogram());
		}
		return Aadl2ASTUtil.getDataClassifier(t,sc);
	}
	

	private DataClassifier getNamedElementClassifier(NamedElement t)
	{
		if (t instanceof DataAccess)
		{
			DataAccess da = (DataAccess) t;
			return getDataClassifier(da.getDataFeatureClassifier());
		}
		else if (t instanceof BehaviorVariable)
		{
			BehaviorVariable bv = (BehaviorVariable) t;
			return bv.getDataClassifier();
		}
		else if (t instanceof DataSubcomponent)
		{
			DataSubcomponent ds = (DataSubcomponent) t;
			return getDataClassifier(ds.getDataSubcomponentType());
		}
		else if (t instanceof Parameter)
		{
			Parameter p = (Parameter) t;
			return getDataClassifier(p.getDataFeatureClassifier());
		}
		else
		{
			return null;
		}
	}
	
	public ASTNode computeAssignment(AssignmentAction aa, ASTNode lastAction)
	{
		final ComponentInstance element = lastAction.getElement();
		final IOTime time = Aadl2ASTUtil.getWriteTime(element);
		
		final NamedElement eTarget = getTargetElement(aa.getTarget());
		
		final String name = "Assignment_" + eTarget.getName();		
		final ASTNode assignAction = new ASTNode(IDGenerator.getNewIdForName(name),
				StatementKind.Assignment, element);
		
		WcetAnalysisDebug.print("[Assignment]Target " + eTarget.getName() + " (" + eTarget.getClass().getSimpleName()+")");
		
		
		double assignTime = 0d;
		
		/* Get target data classifier */
		
		DataClassifier assignType = getNamedElementClassifier(eTarget);
		if (assignType != null)
		{
			long dataSize = getSourceDataSize(assignType);
			WcetAnalysisDebug.println(" which classifier is " + assignType.getName() + " (data size: " + dataSize+")");
			
			
			/* Computes assignment time considering target size */
			
			//assignTime = computeAssignTime(assignType);
			assignTime = time.getTime(dataSize);
		}
		
		if (assignTime == 0d)
		{
			/* No property found to obtain target size. 
			 * Trying on value expression */
			
			final NamedElement dataValue  = getAssignedData(aa);
			
			if (dataValue != null)
			{
				/* Value is a data element and has a data classifier. 
				 * Computes assignment time considering size property defined
				 * on this classifier. */
				
				debug("No data about target size. Checking assigned value " + dataValue.getName(), "*");
				
				DataClassifier valueType = getNamedElementClassifier(dataValue);
				long dataSize = getSourceDataSize(assignType);
				
				//assignTime = computeAssignTime(valueType);
				assignTime = time.getTime(dataSize);
				
				//FIXME: valueType null
				//debug(dataValue.getName() + " classifier is " + valueType.getName() + " with a size of " + dataSize, "*");
			}
		}
		
		setAssignTime(assignTime,assignAction);
		
		debug("Assignment time is " + assignTime + " (memory speed: " + time.Fixed + "+" + time.PerByte +" PerByte)","*");
		
		lastAction.addNext(assignAction);
		lastAction = assignAction;
		
		WcetAnalysisDebug.println();
		
		return assignAction;
	}
	
	private static boolean isInFeature(ParameterLabel l)
	{
		if (l instanceof ActualPortHolder)
		{
			return ((ActualPortHolder) l).getPort().getDirection()
					== DirectionType.IN;
		}
		else if (l instanceof ParameterHolder)
		{
			return ((ParameterHolder) l).getParameter().getDirection()
					== DirectionType.IN;
		}
		else
		{
			return false;
		}
	}
	
	private static boolean needsCopy(ParameterLabel l)
	{
		return ((l instanceof ActualPortHolder)
				|| (l instanceof ParameterHolder));
	}

	public double computeParametersAssignmentTime(SubprogramCallAction callAction)
	{
		final SubprogramClassifier s = (SubprogramClassifier) 
				callAction.getSubprogram().getElement();
		final List<ParameterLabel> labels = callAction.getParameterLabels();
		
		double assignTime = 0d;
		
		if (labels != null)
		{
			WcetAnalysisDebug.incrementIndent();
			for(ParameterLabel l : labels)
			{
				/* Check parameter type (ex: data access requires no copy) */
				if (needsCopy(l))
				{					
					/* In parameter is always copied.
					 * Out parameter is copied only if there is no 
					 * behavior annex/call sequence performing such assignment.
					 */
					if (isInFeature(l) || (!Aadl2ASTUtil.hasBehavior(s)))
					{
						final Target t = (Target) l;
						final NamedElement ne = getTargetElement(t);
						final DataClassifier pType = getNamedElementClassifier(ne);
						final long dataSize = getSourceDataSize(pType);
						
						debug("Parameter " + ne.getName() + " classifier is " 
														   + pType.getName() + " with a size of " + dataSize,
														   "SubprogramCall Parameter");
			
						//assignTime += computeAssignTime(pType);
						
						IOTime time = Aadl2ASTUtil.getWriteTime(
								(ComponentInstance) taskInstance.eContainer());
						
						assignTime += time.getTime(dataSize);
					}
					
				}
			}
			WcetAnalysisDebug.decrementIndent();
		}
		debug("Parameters copy time is " + assignTime + "\n", "*");
		return assignTime;
	}
}
