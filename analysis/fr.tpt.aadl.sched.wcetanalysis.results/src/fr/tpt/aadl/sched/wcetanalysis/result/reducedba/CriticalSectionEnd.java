/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.sched.wcetanalysis.result.reducedba;

import org.osate.aadl2.DataAccess;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Critical Section End</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionEnd#getSharedData <em>Shared Data</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage#getCriticalSectionEnd()
 * @model
 * @generated
 */
public interface CriticalSectionEnd extends ThreadBehaviorElement {

	/**
	 * Returns the value of the '<em><b>Shared Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Shared Data</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Shared Data</em>' reference.
	 * @see #setSharedData(DataAccess)
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage#getCriticalSectionEnd_SharedData()
	 * @model
	 * @generated
	 */
	DataAccess getSharedData();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionEnd#getSharedData <em>Shared Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Shared Data</em>' reference.
	 * @see #getSharedData()
	 * @generated
	 */
	void setSharedData(DataAccess value);
} // CriticalSectionEnd
