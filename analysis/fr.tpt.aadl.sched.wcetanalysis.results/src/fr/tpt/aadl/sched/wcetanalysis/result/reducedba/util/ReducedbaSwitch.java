/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.sched.wcetanalysis.result.reducedba.util;

import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage
 * @generated
 */
public class ReducedbaSwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ReducedbaPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReducedbaSwitch() {
		if (modelPackage == null) {
			modelPackage = ReducedbaPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @parameter ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case ReducedbaPackage.THREAD_BEHAVIOR_ELEMENT: {
				ThreadBehaviorElement threadBehaviorElement = (ThreadBehaviorElement)theEObject;
				T result = caseThreadBehaviorElement(threadBehaviorElement);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ReducedbaPackage.COMPUTATION: {
				Computation computation = (Computation)theEObject;
				T result = caseComputation(computation);
				if (result == null) result = caseThreadBehaviorElement(computation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ReducedbaPackage.CRITICAL_SECTION_BEGIN: {
				CriticalSectionBegin criticalSectionBegin = (CriticalSectionBegin)theEObject;
				T result = caseCriticalSectionBegin(criticalSectionBegin);
				if (result == null) result = caseThreadBehaviorElement(criticalSectionBegin);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ReducedbaPackage.CRITICAL_SECTION_END: {
				CriticalSectionEnd criticalSectionEnd = (CriticalSectionEnd)theEObject;
				T result = caseCriticalSectionEnd(criticalSectionEnd);
				if (result == null) result = caseThreadBehaviorElement(criticalSectionEnd);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case ReducedbaPackage.REDUCED_THREAD_BA: {
				ReducedThreadBA reducedThreadBA = (ReducedThreadBA)theEObject;
				T result = caseReducedThreadBA(reducedThreadBA);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Thread Behavior Element</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Thread Behavior Element</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseThreadBehaviorElement(ThreadBehaviorElement object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Computation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Computation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComputation(Computation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Critical Section Begin</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Critical Section Begin</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCriticalSectionBegin(CriticalSectionBegin object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Critical Section End</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Critical Section End</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCriticalSectionEnd(CriticalSectionEnd object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Reduced Thread BA</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Reduced Thread BA</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseReducedThreadBA(ReducedThreadBA object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //ReducedbaSwitch
