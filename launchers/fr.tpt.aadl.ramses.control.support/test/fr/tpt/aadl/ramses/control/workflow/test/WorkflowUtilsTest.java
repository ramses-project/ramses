package fr.tpt.aadl.ramses.control.workflow.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import fr.tpt.aadl.ramses.control.workflow.File;
import fr.tpt.aadl.ramses.control.workflow.Generation;
import fr.tpt.aadl.ramses.control.workflow.List;
import fr.tpt.aadl.ramses.control.workflow.Transformation;
import fr.tpt.aadl.ramses.control.workflow.WorkflowFactory;
//import fr.tpt.aadl.ramses.control.workflow.util.WorkflowUtils;

public class WorkflowUtilsTest {

	final String workflowPath = "test.models/workflow_test_1.1.xmi";

	@Test
	public void testCreateWorkflow(){
		
		//-----workflow with Analysis element--------
		Transformation t = WorkflowFactory.eINSTANCE.createTransformation();

		Generation g = WorkflowFactory.eINSTANCE.createGeneration();

		List l = WorkflowFactory.eINSTANCE.createList();

		ArrayList<String> filePaths = new ArrayList<String>();
		filePaths.add("test1.asm");
		filePaths.add("test2.asm");
		filePaths.add("test3.asm");
		
		Iterator<String> fileNamesIt = filePaths.iterator();
		while (fileNamesIt.hasNext()) {
			File f = WorkflowFactory.eINSTANCE.createFile();
			f.setPath(fileNamesIt.next());
//			l.getFile().add(f);
		}

		t.setElement(g);
		t.setList(l);
		
		// Fixme: restore WorkflowUtils class
		//WorkflowUtils.createNewWorkflow(workflowPath, t);

		//-----workflow with Analysis element--------
/*		Analysis a = WorkflowFactory.eINSTANCE.createAnalysis();
		AnalysisOption o = WorkflowFactory.eINSTANCE.createAnalysisOption();
		Generation g = WorkflowFactory.eINSTANCE.createGeneration();
		o.setElement(g);		
		a.setNoOption(o);
		WorkflowUtils.createNewWorkflow(workflowPath, a);
*/		
		
		assertTrue(new java.io.File(workflowPath).exists());
	}
	
}
