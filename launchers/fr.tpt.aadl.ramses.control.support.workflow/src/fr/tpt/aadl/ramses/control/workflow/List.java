/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.control.workflow;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.List#getFile <em>File</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getList()
 * @model
 * @generated
 */
public interface List extends EObject {
	/**
	 * Returns the value of the '<em><b>File</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.ramses.control.workflow.File}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>File</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>File</em>' containment reference list.
	 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getList_File()
	 * @model type="workflow.File" containment="true" required="true"
	 * @generated
	 */
	EList getFile();

} // List
