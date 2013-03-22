/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.control.workflow.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import fr.tpt.aadl.ramses.control.workflow.Analysis;
import fr.tpt.aadl.ramses.control.workflow.AnalysisElement;
import fr.tpt.aadl.ramses.control.workflow.AnalysisOption;
import fr.tpt.aadl.ramses.control.workflow.ErrorState;
import fr.tpt.aadl.ramses.control.workflow.File;
import fr.tpt.aadl.ramses.control.workflow.Generation;
import fr.tpt.aadl.ramses.control.workflow.List;
import fr.tpt.aadl.ramses.control.workflow.ModelIdentifier;
import fr.tpt.aadl.ramses.control.workflow.Transformation;
import fr.tpt.aadl.ramses.control.workflow.Workflow;
import fr.tpt.aadl.ramses.control.workflow.WorkflowElement;
import fr.tpt.aadl.ramses.control.workflow.WorkflowFactory;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage;


/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkflowFactoryImpl extends EFactoryImpl implements WorkflowFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static WorkflowFactory init() {
		try {
			WorkflowFactory theWorkflowFactory = (WorkflowFactory)EPackage.Registry.INSTANCE.getEFactory("http://fr.tpt.aadl.ramses.control.workflow/Ramses/1.0"); 
			if (theWorkflowFactory != null) {
				return theWorkflowFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new WorkflowFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case WorkflowPackage.WORKFLOW: return createWorkflow();
			case WorkflowPackage.WORKFLOW_ELEMENT: return createWorkflowElement();
			case WorkflowPackage.TRANSFORMATION: return createTransformation();
			case WorkflowPackage.ANALYSIS_ELEMENT: return createAnalysisElement();
			case WorkflowPackage.GENERATION: return createGeneration();
			case WorkflowPackage.ANALYSIS: return createAnalysis();
			case WorkflowPackage.ERROR_STATE: return createErrorState();
			case WorkflowPackage.LIST: return createList();
			case WorkflowPackage.FILE: return createFile();
			case WorkflowPackage.ANALYSIS_OPTION: return createAnalysisOption();
			case WorkflowPackage.MODEL_IDENTIFIER: return createModelIdentifier();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Workflow createWorkflow() {
		WorkflowImpl workflow = new WorkflowImpl();
		return workflow;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowElement createWorkflowElement() {
		WorkflowElementImpl workflowElement = new WorkflowElementImpl();
		return workflowElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Transformation createTransformation() {
		TransformationImpl transformation = new TransformationImpl();
		return transformation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisElement createAnalysisElement() {
		AnalysisElementImpl analysisElement = new AnalysisElementImpl();
		return analysisElement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Generation createGeneration() {
		GenerationImpl generation = new GenerationImpl();
		return generation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Analysis createAnalysis() {
		AnalysisImpl analysis = new AnalysisImpl();
		return analysis;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ErrorState createErrorState() {
		ErrorStateImpl errorState = new ErrorStateImpl();
		return errorState;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public List createList() {
		ListImpl list = new ListImpl();
		return list;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public File createFile() {
		FileImpl file = new FileImpl();
		return file;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisOption createAnalysisOption() {
		AnalysisOptionImpl analysisOption = new AnalysisOptionImpl();
		return analysisOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ModelIdentifier createModelIdentifier() {
		ModelIdentifierImpl modelIdentifier = new ModelIdentifierImpl();
		return modelIdentifier;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowPackage getWorkflowPackage() {
		return (WorkflowPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static WorkflowPackage getPackage() {
		return WorkflowPackage.eINSTANCE;
	}

} //WorkflowFactoryImpl
