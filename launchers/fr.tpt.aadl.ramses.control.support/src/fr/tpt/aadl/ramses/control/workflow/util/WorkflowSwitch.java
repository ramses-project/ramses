/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.control.workflow.util;

import fr.tpt.aadl.ramses.control.workflow.*;
import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

import fr.tpt.aadl.ramses.control.workflow.Analysis;
import fr.tpt.aadl.ramses.control.workflow.AnalysisElement;
import fr.tpt.aadl.ramses.control.workflow.AnalysisOption;
import fr.tpt.aadl.ramses.control.workflow.ErrorState;
import fr.tpt.aadl.ramses.control.workflow.File;
import fr.tpt.aadl.ramses.control.workflow.Generation;
import fr.tpt.aadl.ramses.control.workflow.ModelIdentifier;
import fr.tpt.aadl.ramses.control.workflow.Transformation;
import fr.tpt.aadl.ramses.control.workflow.Workflow;
import fr.tpt.aadl.ramses.control.workflow.WorkflowElement;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage;


/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage
 * @generated
 */
public class WorkflowSwitch {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static WorkflowPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public WorkflowSwitch() {
		if (modelPackage == null) {
			modelPackage = WorkflowPackage.eINSTANCE;
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	public Object doSwitch(EObject theEObject) {
		return doSwitch(theEObject.eClass(), theEObject);
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
		if (theEClass.eContainer() == modelPackage) {
			return doSwitch(theEClass.getClassifierID(), theEObject);
		}
		else {
			List eSuperTypes = theEClass.getESuperTypes();
			return
				eSuperTypes.isEmpty() ?
					defaultCase(theEObject) :
					doSwitch((EClass)eSuperTypes.get(0), theEObject);
		}
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	protected Object doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case WorkflowPackage.WORKFLOW: {
				Workflow workflow = (Workflow)theEObject;
				Object result = caseWorkflow(workflow);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkflowPackage.WORKFLOW_ELEMENT: {
				WorkflowElement workflowElement = (WorkflowElement)theEObject;
				Object result = caseWorkflowElement(workflowElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkflowPackage.TRANSFORMATION: {
				Transformation transformation = (Transformation)theEObject;
				Object result = caseTransformation(transformation);
				if (result == null) result = caseWorkflowElement(transformation);
				if (result == null) result = caseAnalysisElement(transformation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkflowPackage.ANALYSIS_ELEMENT: {
				AnalysisElement analysisElement = (AnalysisElement)theEObject;
				Object result = caseAnalysisElement(analysisElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkflowPackage.GENERATION: {
				Generation generation = (Generation)theEObject;
				Object result = caseGeneration(generation);
				if (result == null) result = caseWorkflowElement(generation);
				if (result == null) result = caseAnalysisElement(generation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkflowPackage.ANALYSIS: {
				Analysis analysis = (Analysis)theEObject;
				Object result = caseAnalysis(analysis);
				if (result == null) result = caseWorkflowElement(analysis);
				if (result == null) result = caseAnalysisElement(analysis);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkflowPackage.ERROR_STATE: {
				ErrorState errorState = (ErrorState)theEObject;
				Object result = caseErrorState(errorState);
				if (result == null) result = caseAnalysisElement(errorState);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkflowPackage.LIST: {
				fr.tpt.aadl.ramses.control.workflow.List list = (fr.tpt.aadl.ramses.control.workflow.List)theEObject;
				Object result = caseList(list);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkflowPackage.FILE: {
				File file = (File)theEObject;
				Object result = caseFile(file);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkflowPackage.ANALYSIS_OPTION: {
				AnalysisOption analysisOption = (AnalysisOption)theEObject;
				Object result = caseAnalysisOption(analysisOption);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkflowPackage.MODEL_IDENTIFIER: {
				ModelIdentifier modelIdentifier = (ModelIdentifier)theEObject;
				Object result = caseModelIdentifier(modelIdentifier);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case WorkflowPackage.UNPARSE: {
				Unparse unparse = (Unparse)theEObject;
				Object result = caseUnparse(unparse);
				if (result == null) result = caseWorkflowElement(unparse);
				if (result == null) result = caseAnalysisElement(unparse);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Workflow</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Workflow</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWorkflow(Workflow object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseWorkflowElement(WorkflowElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Transformation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Transformation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseTransformation(Transformation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Analysis Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Analysis Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAnalysisElement(AnalysisElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Generation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Generation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseGeneration(Generation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Analysis</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Analysis</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAnalysis(Analysis object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Error State</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Error State</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseErrorState(ErrorState object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>List</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>List</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseList(fr.tpt.aadl.ramses.control.workflow.List object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>File</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>File</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseFile(File object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Analysis Option</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Analysis Option</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseAnalysisOption(AnalysisOption object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Model Identifier</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Model Identifier</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseModelIdentifier(ModelIdentifier object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Unparse</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Unparse</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public Object caseUnparse(Unparse object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	public Object defaultCase(EObject object) {
		return null;
	}

} //WorkflowSwitch
