package fr.tpt.aadl.ramses.control.workflow.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import fr.tpt.aadl.ramses.control.workflow.Analysis;
import fr.tpt.aadl.ramses.control.workflow.AnalysisElement;
import fr.tpt.aadl.ramses.control.workflow.AnalysisOption;
import fr.tpt.aadl.ramses.control.workflow.File;
import fr.tpt.aadl.ramses.control.workflow.Generation;
import fr.tpt.aadl.ramses.control.workflow.List;
import fr.tpt.aadl.ramses.control.workflow.Transformation;
import fr.tpt.aadl.ramses.control.workflow.Workflow;
import fr.tpt.aadl.ramses.control.workflow.WorkflowElement;
import fr.tpt.aadl.ramses.control.workflow.WorkflowFactory;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage;

public class WorkflowUtils {

	private static ResourceSet resourceSet;
	private static Resource resource;

	/**
	 * Returns a Workflow object for a file of a given location
	 * 
	 * @param workflowPath
	 *            String representing the workflow file path
	 * @return Workflow object
	 */
	public static Workflow parse(String workflowPath) {

		getResourceSet().setResourceFactoryRegistry(
				Resource.Factory.Registry.INSTANCE);

		getResourceSet().getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());
		getResourceSet().getPackageRegistry().put(WorkflowPackage.eNS_URI,
				WorkflowPackage.eINSTANCE);

		final Resource resource;
		URI workflow_uri = URI.createFileURI(workflowPath);

		if (getResourceSet().getURIConverter().exists(workflow_uri, null)) {
			resource = getResourceSet().getResource(workflow_uri, true);
			Workflow workflowRootObject = (Workflow) resource.getContents()
					.get(0);
			return workflowRootObject;
		}

		return null;
	}

	/**
	 * Creates a new Workflow definition under a specified path
	 * 
	 * @param workflowPath
	 *            String representing the artifact path
	 */
	public static void createNewWorkflow(String _workflowPath, WorkflowElement _workflowElement) {

		Workflow workflow = WorkflowFactory.eINSTANCE.createWorkflow();

		workflow.setElement(_workflowElement);
		
		URI wf_uri = URI.createFileURI(_workflowPath);

		getResourceSet().getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());
		getResourceSet().getPackageRegistry().put(WorkflowPackage.eNS_URI,
				WorkflowPackage.eINSTANCE);

		if (!getResourceSet().getURIConverter().exists(wf_uri, null)) {
			resource = getResourceSet().createResource(wf_uri);
			saveWorkflow(resource, workflow);
		} else {
			System.out.println("Workflow artifact of the specified path: "
					+ _workflowPath + " already exists.");
		}
	}

/*	*//**
	 * Adds a Transformation object to Workflow artifact of specified path
	 * 
	 * @param _workflowPath   	String representing the artifact path
	 * @param _fileNames   		ArrayList of files to be executed
	 * @param _analysisElement  AnalysisElement that contains given transformation
	 * 
	 *//*
	public static void addTransformation(String _workflowPath,
			ArrayList<String> _fileNames, AnalysisElement _analysisElement) {

		Workflow w = WorkflowUtils.parse(_workflowPath);

		Transformation t = WorkflowFactory.eINSTANCE.createTransformation();

		Generation g = WorkflowFactory.eINSTANCE.createGeneration();

		List l = WorkflowFactory.eINSTANCE.createList();

		Iterator<String> fileNamesIt = _fileNames.iterator();
		while (fileNamesIt.hasNext()) {
			File f = WorkflowFactory.eINSTANCE.createFile();
			f.setPath(fileNamesIt.next());
			l.getFile().add(f);
		}

		t.setElement(g);
		t.setList(l);

		w.setElement(t);
		saveWorkflow(getResource(_workflowPath), w);
	}*/

/*	*//**
	 * Adds a Analysis object to Workflow artifact of specified path
	 * 
	 * @param _workflowPath   String representing the artifact path
	 * 
	 *//*
	public static void addAnalysis(String workflowPath) {

		Workflow w = WorkflowUtils.parse(workflowPath);

		Analysis a = WorkflowFactory.eINSTANCE.createAnalysis();

		Generation g = WorkflowFactory.eINSTANCE.createGeneration();

		AnalysisOption o = WorkflowFactory.eINSTANCE.createAnalysisOption();
		
		o.setElement(g);
		
		a.setNoOption(o);

		w.setElement(a);
		
		saveWorkflow(getResource(workflowPath), w);
	}*/
	
	
	/**
	 * Saves the given specification at the resource location
	 * 
	 * @param resource
	 *            Resource object associated with the specific disk location
	 * @param workflow
	 *            Workflow object to be saved
	 */
	private static void saveWorkflow(Resource resource, Workflow workflow) {
		resource.unload();
		resource.getContents().add(workflow);

		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns either existing ResourceSet object or a new one in case it was
	 * not already existing
	 * 
	 * @return ResourceSet object
	 */
	protected static ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	/**
	 * Returns a Resource object for a file of a given location
	 * 
	 * @param workflowPath
	 *            String representing the workflow file path
	 * @return Resource object
	 */
	protected static Resource getResource(String workflowPath) {
		URI p_uri = URI.createFileURI(workflowPath);

		getResourceSet().getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());
		getResourceSet().getPackageRegistry().put(WorkflowPackage.eNS_URI,
				WorkflowPackage.eINSTANCE);

		resource = getResourceSet().getResource(p_uri, true);

		return resource;
	}

}
