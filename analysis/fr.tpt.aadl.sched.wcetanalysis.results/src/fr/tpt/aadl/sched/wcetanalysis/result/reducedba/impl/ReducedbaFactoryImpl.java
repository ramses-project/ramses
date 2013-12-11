/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl;

import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReducedbaFactoryImpl extends EFactoryImpl implements ReducedbaFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static ReducedbaFactory init() {
		try {
			ReducedbaFactory theReducedbaFactory = (ReducedbaFactory)EPackage.Registry.INSTANCE.getEFactory("http://fr.tpt.aadl.sched.wcetanalysis.result.reducedba/1.0"); 
			if (theReducedbaFactory != null) {
				return theReducedbaFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new ReducedbaFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReducedbaFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case ReducedbaPackage.COMPUTATION: return createComputation();
			case ReducedbaPackage.CRITICAL_SECTION_BEGIN: return createCriticalSectionBegin();
			case ReducedbaPackage.CRITICAL_SECTION_END: return createCriticalSectionEnd();
			case ReducedbaPackage.REDUCED_THREAD_BA: return createReducedThreadBA();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Computation createComputation() {
		ComputationImpl computation = new ComputationImpl();
		return computation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CriticalSectionBegin createCriticalSectionBegin() {
		CriticalSectionBeginImpl criticalSectionBegin = new CriticalSectionBeginImpl();
		return criticalSectionBegin;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CriticalSectionEnd createCriticalSectionEnd() {
		CriticalSectionEndImpl criticalSectionEnd = new CriticalSectionEndImpl();
		return criticalSectionEnd;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReducedThreadBA createReducedThreadBA() {
		ReducedThreadBAImpl reducedThreadBA = new ReducedThreadBAImpl();
		return reducedThreadBA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReducedbaPackage getReducedbaPackage() {
		return (ReducedbaPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static ReducedbaPackage getPackage() {
		return ReducedbaPackage.eINSTANCE;
	}

} //ReducedbaFactoryImpl
