/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.control.workflow;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Unparse</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link workflow.Unparse#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see workflow.WorkflowPackage#getUnparse()
 * @model
 * @generated
 */
public interface Unparse extends WorkflowElement, AnalysisElement {

	/**
	 * Returns the value of the '<em><b>Element</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Element</em>' containment reference.
	 * @see #setElement(AnalysisElement)
	 * @see workflow.WorkflowPackage#getUnparse_Element()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AnalysisElement getElement();

	/**
	 * Sets the value of the '{@link workflow.Unparse#getElement <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' containment reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(AnalysisElement value);
} // Unparse
