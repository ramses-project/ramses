package fr.tpt.aadl.ramses.control.support;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import fr.tpt.aadl.ramses.control.workflow.Analysis;
import fr.tpt.aadl.ramses.control.workflow.AnalysisElement;
import fr.tpt.aadl.ramses.control.workflow.Generation;
import fr.tpt.aadl.ramses.control.workflow.Transformation;
import fr.tpt.aadl.ramses.control.workflow.*;
import fr.tpt.aadl.ramses.control.workflow.Workflow;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage;

//import workflow.WorkflowElement;

public class EcorePilot  implements WorkflowPilot {

	ResourceSet resourceSet;

	private String workflowFileName;

	//private WorkflowElement racine;
	private AnalysisElement racine;

	boolean analysisResult;

	public EcorePilot(String _workflowFileName) {

		this.workflowFileName = _workflowFileName;

		getResourceSet().setResourceFactoryRegistry(
				Resource.Factory.Registry.INSTANCE);

		getResourceSet().getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());
		getResourceSet().getPackageRegistry().put(WorkflowPackage.eNS_URI,
				WorkflowPackage.eINSTANCE);

		final Resource resource;
		URI workflow_uri = URI.createFileURI(this.workflowFileName);
		File testExist = new File(this.workflowFileName);
		if (!testExist.exists())
		{
			System.out.println("Workflow file does not exist: " + testExist.getAbsolutePath());
		}

		if (getResourceSet().getURIConverter().exists(workflow_uri, null)) {
			resource = getResourceSet().getResource(workflow_uri, true);
			Workflow workflowRootObject = (Workflow) resource.getContents()
					.get(0);
			// System.out.println("Workflow root element: "+workflowRootObject);

			this.racine = (AnalysisElement) workflowRootObject.getElement();
		}

	}

	public boolean hasNextOperation() {
		return racine != null;
	}

	public String getNextOperation() {
		if (hasNextOperation()) {
			if (racine instanceof Transformation) {
				return "transformation";
			} else if (racine instanceof Analysis) {
				return "analysis";
			} else if (racine instanceof Generation) {
				return "generation";
			} else if (racine instanceof Unparse) {
				return "unparse";
			}
		}
		return null;
	}

	public String getNextAnalysisName() {
		if (racine instanceof Analysis) {
			return ((Analysis) racine).getMethod();
		} else {
			System.err
					.println("You cannot ask for an analysis name if the current state is not an analysis.");
			return null;
		}
	}

	public String getNextAnalysisMode() {
		if (racine instanceof Analysis) {
			return ((Analysis) racine).getMode();
		} else {
			System.err
					.println("You cannot ask for an analysis mode if the current state is not an analysis.");
			return null;
		}
	}

	public List<String> getNextTransformationFileNameList() {
		if (racine instanceof Transformation) {
			fr.tpt.aadl.ramses.control.workflow.List list = ((Transformation) racine).getList();

			List<fr.tpt.aadl.ramses.control.workflow.File> listFileTags = list.getFile();
			Iterator<fr.tpt.aadl.ramses.control.workflow.File> listFileTagsIt = listFileTags.iterator();

			List<String> listFileNames = new ArrayList<String>();

			while (listFileTagsIt.hasNext()) {
				listFileNames.add(listFileTagsIt.next().getPath());
			}

			return listFileNames;
		} else {
			System.err
					.println("You cannot ask for an asm file if the current state is not a transformation.");
			return null;
		}
	}

	public void setAnalysisResult(boolean _analysisResult) {
		analysisResult = _analysisResult;
	}

	public void goForward() {
		if (racine instanceof Analysis) {
			
			if (analysisResult) {
				racine = ((Analysis) racine).getYesOption().getElement();
			} else {
				racine = ((Analysis) racine).getNoOption().getElement();
			}
		} else if (racine instanceof Transformation) {

			racine = ((Transformation) racine).getElement();

		} else if (racine instanceof Unparse) {
			
			racine = ((Unparse) racine).getElement();
			
		} else {
			racine = null;
		}
	}

	protected ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

}
