/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.sched.wcetanalysis.result.reducedba;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.ComponentInstance;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Reduced Thread BA</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA#getElements <em>Elements</em>}</li>
 *   <li>{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA#getThread <em>Thread</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage#getReducedThreadBA()
 * @model
 * @generated
 */
public interface ReducedThreadBA extends EObject {
	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ThreadBehaviorElement}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage#getReducedThreadBA_Elements()
	 * @model containment="true"
	 * @generated
	 */
	EList<ThreadBehaviorElement> getElements();

	/**
	 * Returns the value of the '<em><b>Thread</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Thread</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Thread</em>' reference.
	 * @see #setThread(ComponentInstance)
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage#getReducedThreadBA_Thread()
	 * @model
	 * @generated
	 */
	ComponentInstance getThread();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA#getThread <em>Thread</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Thread</em>' reference.
	 * @see #getThread()
	 * @generated
	 */
	void setThread(ComponentInstance value);

} // ReducedThreadBA
