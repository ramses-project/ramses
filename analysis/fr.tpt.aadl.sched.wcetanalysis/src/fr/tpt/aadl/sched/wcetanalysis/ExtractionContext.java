package fr.tpt.aadl.sched.wcetanalysis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.ba.aadlba.SubprogramCallAction;

import fr.tpt.aadl.sched.wcetanalysis.extractors.SubprogramExtractor;
import fr.tpt.aadl.sched.wcetanalysis.extractors.ThreadExtractor;
import fr.tpt.aadl.sched.wcetanalysis.extractors.ba.util.BehaviorActionBlockExtractor;
import fr.tpt.aadl.sched.wcetanalysis.extractors.seq.SubprogramCallUtil;
import fr.tpt.aadl.sched.wcetanalysis.model.TaskBody;

public class ExtractionContext
{
	private final ThreadExtractor threadExtractor;

	public final AnalysisErrorReporterManager errManager;
	public final SubprogramExtractor subprogramExtractor;
	public final BehaviorActionBlockExtractor behaviorActionBlockExtractor;
	public final SubprogramCallUtil callUtil;
	
	private Stack<NamedElement> visiting = new Stack<NamedElement>();
	private Stack<SubprogramCallAction> visitingBA = new Stack<SubprogramCallAction>();


	private ExtractionContext(AnalysisErrorReporterManager errManager)
	{
		this.errManager = errManager;
		behaviorActionBlockExtractor = new BehaviorActionBlockExtractor(this);
		threadExtractor = new ThreadExtractor(this);
		subprogramExtractor = new SubprogramExtractor(this);
		callUtil = new SubprogramCallUtil(this);
	}

	public static List<TaskBody> createTaskBodies(ComponentInstance process,
			AnalysisErrorReporterManager errManager)
	{
		List<TaskBody> ownedGraphs = new ArrayList<TaskBody>();
		ExtractionContext ctxt = new ExtractionContext(errManager);

		for (ComponentInstance owned : process.getComponentInstances())
		{
			if (owned.getCategory() == ComponentCategory.THREAD)
			{
				TaskBody aTask = ctxt.threadExtractor.extractFrom(owned);

				if (aTask != null)
				{
					// Component owns a behavior annex: execution is extracted
					// from it
					ownedGraphs.add(aTask);
				}
			}
		}

		return ownedGraphs;
	}

	private Map<ComponentInstance, TaskBody> taskToAST = new HashMap<ComponentInstance, TaskBody>();
	
	public static ExtractionContext createNewInstance(SystemInstance root,
			AnalysisErrorReporterManager errManager)
	{
		ExtractionContext ctxt = new ExtractionContext(errManager);
		for (ComponentInstance i : root.getAllComponentInstances())
		{
			if (i.getCategory() == ComponentCategory.THREAD)
			{
				TaskBody aTask = ctxt.threadExtractor.extractFrom(i);
				ctxt.taskToAST.put(i, aTask);
			}
		}
		return ctxt;
	}
	
	public TaskBody getAST(ComponentInstance task)
	{
		return taskToAST.get(task);
	}
	
	public void pushVisitingSubprogramCallAction(SubprogramCallAction a)
	{
		visitingBA.push(a);
	}
	
	public SubprogramCallAction popVisitingSubprogramCallAction()
	{
		return visitingBA.pop();
	}
	
	public SubprogramCallAction peekVisitingSubprogramCallAction()
	{
		if (visitingBA.isEmpty())
			return null;
		else
			return visitingBA.peek();
	}
	
	public SubprogramCallAction getVisitingSubprogramCallAction(int i)
	{
		return visitingBA.get(i);
	}
	
	public int getVisitingSubprogramCallActionSize()
	{
		return visitingBA.size();
	}
	
	public void pushVisitingElement(NamedElement e)
	{
		visiting.push(e);
		if (! (e instanceof ComponentInstance))
			WcetAnalysisDebug.incrementIndent();
	}
	
	public NamedElement popVisitedElement()
	{
		NamedElement e = visiting.pop();
		if (!(e instanceof ComponentInstance))
			WcetAnalysisDebug.decrementIndent();
		return e;
	}
	
	public NamedElement getParentVisitedElement()
	{
		if (visiting.size()>1)
		{
			return visiting.get(1);
		}
		return null;
	}
	
	public NamedElement getCurrentVisitedElement()
	{
		return visiting.peek();
	}
	
	public ComponentInstance getCurrentVisitedThread()
	{
		for(int i=0;i<visiting.size();i++)
		{
			if (visiting.get(i) instanceof ComponentInstance)
			{
				ComponentInstance ci = (ComponentInstance) visiting.get(i);
				if (ci.getCategory()==ComponentCategory.THREAD)
				{
					return ci;
				}
			}
		}
		return null;
	}

}
