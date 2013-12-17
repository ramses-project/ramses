/**
 */
package fr.tpt.aadl.sched.wcetanalysis.result.reducedba;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel#getThreadsBA <em>Threads BA</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage#getAnalysisModel()
 * @model
 * @generated
 */
public interface AnalysisModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Threads BA</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threads BA</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threads BA</em>' containment reference list.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage#getAnalysisModel_ThreadsBA()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ReducedThreadBA> getThreadsBA();

} // AnalysisModel
