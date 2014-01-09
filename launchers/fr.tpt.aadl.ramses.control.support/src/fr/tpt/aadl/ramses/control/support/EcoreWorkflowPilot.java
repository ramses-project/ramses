package fr.tpt.aadl.ramses.control.support;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import fr.tpt.aadl.ramses.control.workflow.Analysis;
import fr.tpt.aadl.ramses.control.workflow.AnalysisElement;
import fr.tpt.aadl.ramses.control.workflow.Generation;
import fr.tpt.aadl.ramses.control.workflow.Transformation;
import fr.tpt.aadl.ramses.control.workflow.Unparse;
import fr.tpt.aadl.ramses.control.workflow.Workflow;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage;

/**
 * This class is an implementation of the WorkflowPilot for workflows
 * described in an Ecore resource.
 */
public class EcoreWorkflowPilot  implements WorkflowPilot {

	private ResourceSet resourceSet;

	private String workflowFileName;

	private AnalysisElement currentWorkflowElement;

	private boolean analysisResult;

	/**
	 * This method creates an EcoreWorkflowPilot from the file path passed
	 * as a parameter
	 * @param workflowFileName identifies the path to the file containing 
	 * the workflow description.
	 * @throws FileNotFoundException if the path does not point to any file
	 */
	public EcoreWorkflowPilot(String workflowFileName) throws FileNotFoundException{

		this.workflowFileName = workflowFileName;

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
			throw new FileNotFoundException();
		}

		if (getResourceSet().getURIConverter().exists(workflow_uri, null)) {
			resource = getResourceSet().getResource(workflow_uri, true);
			Workflow workflowRootObject = (Workflow) resource.getContents()
					.get(0);
			
			this.currentWorkflowElement = (AnalysisElement) workflowRootObject.getElement();
			
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(this.currentWorkflowElement) ;

	        switch ( diagnostic.getSeverity() )
	        {
	          case Diagnostic.ERROR :

	            for(Diagnostic d : diagnostic.getChildren())
	            {
	              System.err.println("Model has errors: "
	                    + resource.getURI().lastSegment() + " " + d.getMessage()) ;
	            }

	            break ;
	          case Diagnostic.WARNING :

	            for(Diagnostic d : diagnostic.getChildren())
	            {
	              System.err.println("Model has warnings: " + d.getMessage()) ;
	            }

	            break ;
	        }
		}

	}

	/**
	 * @see WorkflowPilot#hasNextOperation()
	 */
	public boolean hasNextOperation() {
		return currentWorkflowElement != null;
	}

	/**
	 * @see WorkflowPilot#getNextOperation()
	 */
	public String getNextOperation() {
		if (hasNextOperation()) {
			if (currentWorkflowElement instanceof Transformation) {
				return "transformation";
			} else if (currentWorkflowElement instanceof Analysis) {
				return "analysis";
			} else if (currentWorkflowElement instanceof Generation) {
				return "generation";
			} else if (currentWorkflowElement instanceof Unparse) {
				return "unparse";
			}
		}
		return null;
	}

	/**
	 * @see WorkflowPilot#getAnalysisName()
	 */
	public String getAnalysisName() {
		if (currentWorkflowElement instanceof Analysis) {
			return ((Analysis) currentWorkflowElement).getMethod();
		} else {
			System.err
					.println("You cannot ask for an analysis name if the current state is not an analysis.");
			return null;
		}
	}

	/**
	 * @see WorkflowPilot#getAnalysisMode()
	 */
	public String getAnalysisMode() {
		if (currentWorkflowElement instanceof Analysis) {
			return ((Analysis) currentWorkflowElement).getMode();
		} else {
			System.err
					.println("You cannot ask for an analysis mode if the current state is not an analysis.");
			return null;
		}
	}

	/**
	 * @see WorkflowPilot#getTransformationFileNameList()
	 */
	public List<String> getTransformationFileNameList() {
		if (currentWorkflowElement instanceof Transformation) {
			fr.tpt.aadl.ramses.control.workflow.List list = ((Transformation) currentWorkflowElement).getList();

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

	/**
	 * @see WorkflowPilot#setAnalysisResult(boolean)
	 */
	public void setAnalysisResult(boolean analysisResult) {
		this.analysisResult = analysisResult;
	}

	/**
	 * @see WorkflowPilot#goForward()
	 */
	public void goForward() {
		if (currentWorkflowElement instanceof Analysis) {
			
			if (analysisResult) {
				currentWorkflowElement = ((Analysis) currentWorkflowElement).getYesOption().getElement();
			} else {
				currentWorkflowElement = ((Analysis) currentWorkflowElement).getNoOption().getElement();
			}
		} else if (currentWorkflowElement instanceof Transformation) {

			currentWorkflowElement = ((Transformation) currentWorkflowElement).getElement();

		} else if (currentWorkflowElement instanceof Unparse) {
			
			currentWorkflowElement = ((Unparse) currentWorkflowElement).getElement();
			
		} else {
			currentWorkflowElement = null;
		}
	}

	/**
	 * This method returns the workflow resource set.
	 * @return the workflow resource set.
	 */
	protected ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	/**
	 * @see WorkflowPilot#getInputModelId()
	 */
	@Override
	public String getInputModelId() {
		String result=null;
		if (currentWorkflowElement instanceof Transformation) {
			Transformation t = (Transformation) currentWorkflowElement;
			result = t.getInputModelIdentifier().getId();
		}
		if (currentWorkflowElement instanceof Analysis) {
			Analysis a = (Analysis) currentWorkflowElement;
			result = a.getInputModelIdentifier().getId();
		}
		return result;
	}

	/**
	 * @see WorkflowPilot#getOutputModelId()
	 */
	@Override
	public String getOutputModelId() {
		String result=null;
		if (currentWorkflowElement instanceof Transformation) {
			Transformation t = (Transformation) currentWorkflowElement;
			result = t.getOutputModelIdentifier().getId();
		}
		if (currentWorkflowElement instanceof Analysis) {
			Analysis a = (Analysis) currentWorkflowElement;
			if(a.getOutputModelIdentifier()!=null)
				result = a.getOutputModelIdentifier().getId();
		}
		return result;
	}

}
