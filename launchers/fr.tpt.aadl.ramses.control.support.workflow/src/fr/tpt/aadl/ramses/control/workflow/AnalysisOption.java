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
 * A representation of the model object '<em><b>Analysis Option</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.AnalysisOption#getElement <em>Element</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getAnalysisOption()
 * @model
 * @generated
 */
public interface AnalysisOption extends EObject {
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
	 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getAnalysisOption_Element()
	 * @model containment="true"
	 * @generated
	 */
	AnalysisElement getElement();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.AnalysisOption#getElement <em>Element</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Element</em>' containment reference.
	 * @see #getElement()
	 * @generated
	 */
	void setElement(AnalysisElement value);

} // AnalysisOption
