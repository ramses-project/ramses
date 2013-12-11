/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.sched.wcetanalysis.result.reducedba;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage
 * @generated
 */
public interface ReducedbaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ReducedbaFactory eINSTANCE = fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedbaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Computation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computation</em>'.
	 * @generated
	 */
	Computation createComputation();

	/**
	 * Returns a new object of class '<em>Critical Section Begin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Critical Section Begin</em>'.
	 * @generated
	 */
	CriticalSectionBegin createCriticalSectionBegin();

	/**
	 * Returns a new object of class '<em>Critical Section End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Critical Section End</em>'.
	 * @generated
	 */
	CriticalSectionEnd createCriticalSectionEnd();

	/**
	 * Returns a new object of class '<em>Reduced Thread BA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reduced Thread BA</em>'.
	 * @generated
	 */
	ReducedThreadBA createReducedThreadBA();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ReducedbaPackage getReducedbaPackage();

} //ReducedbaFactory
