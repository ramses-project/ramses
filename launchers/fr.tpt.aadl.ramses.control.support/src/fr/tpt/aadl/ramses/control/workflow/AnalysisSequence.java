/**
 */
package fr.tpt.aadl.ramses.control.workflow;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis Sequence</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.AnalysisSequence#getList <em>List</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getAnalysisSequence()
 * @model abstract="true"
 * @generated
 */
public interface AnalysisSequence extends AbstractAnalysis {
	/**
	 * Returns the value of the '<em><b>List</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>List</em>' containment reference list.
	 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getAnalysisSequence_List()
	 * @model type="fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis" containment="true" lower="2"
	 * @generated
	 */
	EList<AbstractAnalysis> getList();

} // AnalysisSequence
