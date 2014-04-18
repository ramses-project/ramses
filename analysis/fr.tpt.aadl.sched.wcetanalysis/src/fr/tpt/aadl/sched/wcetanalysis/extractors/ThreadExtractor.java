package fr.tpt.aadl.sched.wcetanalysis.extractors;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.ba.aadlba.BehaviorAnnex;

import fr.tpt.aadl.sched.wcetanalysis.ExtractionContext;
import fr.tpt.aadl.sched.wcetanalysis.WcetAnalysisDebug;
import fr.tpt.aadl.sched.wcetanalysis.extractors.ba.ThreadBehaviorAnnexExtractor;
import fr.tpt.aadl.sched.wcetanalysis.extractors.seq.ThreadCallSequenceExtractor;
import fr.tpt.aadl.sched.wcetanalysis.model.ASTExtractor;
import fr.tpt.aadl.sched.wcetanalysis.model.TaskBody;
import fr.tpt.aadl.sched.wcetanalysis.util.BehaviorAnnexUtil;

public class ThreadExtractor extends ASTExtractor
{

	private final ThreadBehaviorAnnexExtractor threadAA;
	private final ThreadCallSequenceExtractor threadSA;

	public ThreadExtractor(ExtractionContext ctxt)
	{
		super(ctxt, ctxt.errManager);
		threadAA = new ThreadBehaviorAnnexExtractor(ctxt);
		threadSA = new ThreadCallSequenceExtractor(ctxt);
	}

	public final TaskBody extractFrom(ComponentInstance task)
	{
		BehaviorAnnex ba = BehaviorAnnexUtil.getBehaviorAnnex(task);
		TaskBody body = null;
		String name = ((NamedElement) task.eContainer()).getName() + "." + task.getName();
		
		WcetAnalysisDebug.println("----------------------------------------------------------------------------------------------------------------------------");
		WcetAnalysisDebug.println("                                             Thread instance " + name);
		WcetAnalysisDebug.println("----------------------------------------------------------------------------------------------------------------------------");
		
		
		ctxt.pushVisitingElement(task);

		if (ba != null)
		{
			body = threadAA.extractFrom(ba, task);
		}
		else
		{
			body = threadSA.extractFrom(task);
		}

		ctxt.popVisitedElement();

		return body;
	}

}
