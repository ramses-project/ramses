package fr.tpt.aadl.sched.wcetanalysis.extractors.seq;

import org.osate.aadl2.Classifier;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.util.properties.AadlUtil;
import fr.tpt.aadl.sched.wcetanalysis.ExtractionContext;
import fr.tpt.aadl.sched.wcetanalysis.model.ASTNode;
import fr.tpt.aadl.sched.wcetanalysis.model.StatementKind;
import fr.tpt.aadl.sched.wcetanalysis.model.TaskBody;

public class ThreadCallSequenceExtractor extends CallSequenceExtractor
{
	public ThreadCallSequenceExtractor(ExtractionContext ctxt)
	{
		super(ctxt, ctxt.errManager);
	}

	public TaskBody extractFrom(ComponentInstance comp)
	{
		TaskBody au = new TaskBody();
		au.setInitAST(extractInitSequence(comp));
		ASTNode first = ASTNode.createFlagNode(comp, "JobStart");
		ASTNode last = ASTNode.createFlagNode(comp, "JobEnd");
		
		/*
		 * Extraction for thread or subprogram call sequence
		 * is the same. So, we call the subprogram extractor
		 * to extract the AST from the thread call sequence
		 * instead of the subprogram call sequence. 
		 */
		ctxt.subprogramExtractor.caseThreadInstance(comp, first);
		first.getEnd().addNext(last);
		
		
		au.setMainLoopAST(first);
		return au;
	}

	private ASTNode extractInitSequence(ComponentInstance comp)
	{
		SubprogramClassifier sc = null;

		try
		{
			Classifier c = PropertyUtils.getClassifierValue(comp,
					"Initialize_Entrypoint");

			if (c instanceof SubprogramClassifier)
			{
				sc = (SubprogramClassifier) c;
			}
		}
		catch (Exception e)
		{
		}

		if (sc == null)
		{
			return new ASTNode("Task Init", StatementKind.Compute, comp);
		}
		else
		{
			ASTNode init = new ASTNode(sc.getName(), StatementKind.Compute, comp);
			int computationTime = (int) AadlUtil.getInfoMaxDuration(sc);
			init.setMaxExecutionTime(computationTime);
			return init;
		}
	}

	/*
	 * private TaskAction extractIterationSequence(ComponentInstance task) {
	 * SystemInstance root = (SystemInstance) task.getOwner();
	 * 
	 * List<ConnectionInstance> conns = root.getConnectionInstances();
	 * List<TaskAction> inputs = new ArrayList<TaskAction>(); List<TaskAction>
	 * outputs = new ArrayList<TaskAction>();
	 * 
	 * TaskAction taskStart = TaskAction.createEmptyAction("TaskStart", task);
	 * TaskAction taskEnd = TaskAction.createEmptyAction("TaskEnd", task);
	 * 
	 * for(int index=0; index<conns.size(); index++) { ConnectionInstance conn =
	 * conns.get(index); ConnectionInstanceEnd eStart = conn.getSource();
	 * ConnectionInstanceEnd eEnd = conn.getDestination();
	 * 
	 * ConnectionInstance start = eStart.getSrcConnectionInstances().get(0);
	 * ConnectionInstance end = eEnd.getDstConnectionInstances().get(0);
	 * 
	 * if ((! (start.getSource() instanceof FeatureInstance)) || (!
	 * (end.getSource() instanceof FeatureInstance))) continue;
	 * 
	 * FeatureInstance fSource = (FeatureInstance) start.getSource();
	 * FeatureInstance fEnd = (FeatureInstance) end.getDestination();
	 * 
	 * if (fSource.getOwner() == task) { switch (start.getKind()) { case
	 * PORT_CONNECTION : createPortAction(fSource, inputs, outputs, taskStart);
	 * break; } } else if (fEnd.getOwner() == task) { switch (end.getKind()) {
	 * case PORT_CONNECTION : createPortAction(fEnd, inputs, outputs,
	 * taskStart); break; } } }
	 * 
	 * 
	 * 
	 * TaskAction last = taskStart; for(int index=0; index < inputs.size();
	 * index++) { TaskAction input = inputs.get(index); input.addPrevious(last);
	 * last = input; }
	 * 
	 * for(int index=0; index < outputs.size(); index++) { TaskAction output =
	 * outputs.get(index); output.addPrevious(last); last = output; }
	 * last.addNext(taskEnd); last = taskEnd;
	 * 
	 * return last; }
	 * 
	 * 
	 * private static void createPortAction(FeatureInstance f, List<TaskAction>
	 * inputs, List<TaskAction> outputs, TaskAction start) { switch
	 * (f.getDirection()) { case IN : inputs.add(new TaskAction(f.getName(),
	 * TaskActionType.ReadPort, start.getElement())); break; case OUT :
	 * outputs.add(new TaskAction(f.getName(), TaskActionType.WritePort,
	 * start.getElement())); break; } }
	 */

	/*
	 * public void extractProcessTasksExecutionFlow( ComponentInstance process,
	 * SystemInstance root, Map<ComponentInstance, TaskAction> taskToAction) {
	 * 
	 * for(ComponentInstance sub : process.getAllComponentInstances()) { if
	 * (sub.getCategory().getValue() == ComponentCategory.THREAD_VALUE) {
	 * TaskAction lastAction = extractTaskExecutionFlow(sub, root);
	 * taskToAction.put(sub, lastAction); } } }
	 * 
	 * 
	 * public void extractVPTasksExecutionFlow( ComponentInstance vp,
	 * SystemInstance root, Map<ComponentInstance, TaskAction> taskToAction) {
	 * for(ComponentInstance sub : root.getAllComponentInstances()) { if
	 * (sub.getCategory().getValue() == ComponentCategory.PROCESS_VALUE) { if
	 * (PropertyUtils.getPropertyComponentRef("Actual_Processor_Binding",
	 * sub)==vp) { extractProcessTasksExecutionFlow(sub, root, taskToAction); }
	 * } } }
	 * 
	 * public void extractNodeTasksExecutionFlow( ComponentInstance node,
	 * SystemInstance root, Map<ComponentInstance, TaskAction> taskToAction) {
	 * for(ComponentInstance pSub : node.getAllComponentInstances()) { if
	 * (pSub.getCategory().getValue() ==
	 * ComponentCategory.VIRTUAL_PROCESSOR_VALUE)
	 * extractVPTasksExecutionFlow(pSub, root,taskToAction); } }
	 * 
	 * public Map<ComponentInstance, TaskAction>
	 * extractTasksExecutionFlow(SystemInstance root) { Map<ComponentInstance,
	 * TaskAction> taskToAction = new HashMap<ComponentInstance, TaskAction>();
	 * for(ComponentInstance sub : root.getAllComponentInstances()) { if
	 * (sub.getCategory().getValue() == ComponentCategory.PROCESSOR_VALUE) {
	 * extractNodeTasksExecutionFlow(sub, root,taskToAction); } } return
	 * taskToAction; }
	 */
}
