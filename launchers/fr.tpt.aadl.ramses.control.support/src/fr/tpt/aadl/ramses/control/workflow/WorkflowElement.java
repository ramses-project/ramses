/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.control.workflow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.WorkflowElement#getInputModelIdentifier <em>Input Model Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getWorkflowElement()
 * @model abstract="true"
 * @generated
 */
public interface WorkflowElement extends EObject {

	/**
   * Returns the value of the '<em><b>Input Model Identifier</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Model Identifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Input Model Identifier</em>' reference.
   * @see #setInputModelIdentifier(ModelIdentifier)
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getWorkflowElement_InputModelIdentifier()
   * @model required="true"
   * @generated
   */
	ModelIdentifier getInputModelIdentifier();

	/**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.WorkflowElement#getInputModelIdentifier <em>Input Model Identifier</em>}' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Input Model Identifier</em>' reference.
   * @see #getInputModelIdentifier()
   * @generated
   */
	void setInputModelIdentifier(ModelIdentifier value);
} // WorkflowElement
