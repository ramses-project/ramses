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
 * A representation of the model object '<em><b>Workflow</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Workflow#getElement <em>Element</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Workflow#getInputModelIdentifier <em>Input Model Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getWorkflow()
 * @model
 * @generated
 */
public interface Workflow extends EObject {
	/**
   * Returns the value of the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference.
   * @see #setElement(WorkflowElement)
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getWorkflow_Element()
   * @model containment="true" required="true"
   * @generated
   */
	WorkflowElement getElement();

	/**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.Workflow#getElement <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' containment reference.
   * @see #getElement()
   * @generated
   */
	void setElement(WorkflowElement value);

	/**
   * Returns the value of the '<em><b>Input Model Identifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Model Identifier</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Input Model Identifier</em>' containment reference.
   * @see #setInputModelIdentifier(ModelIdentifier)
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getWorkflow_InputModelIdentifier()
   * @model containment="true"
   * @generated
   */
	ModelIdentifier getInputModelIdentifier();

	/**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.Workflow#getInputModelIdentifier <em>Input Model Identifier</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Input Model Identifier</em>' containment reference.
   * @see #getInputModelIdentifier()
   * @generated
   */
	void setInputModelIdentifier(ModelIdentifier value);

} // Workflow
