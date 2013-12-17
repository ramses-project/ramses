/**
 */
package fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl;

import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Analysis Model</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.AnalysisModelImpl#getThreadsBA <em>Threads BA</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class AnalysisModelImpl extends EObjectImpl implements AnalysisModel {
	/**
	 * The cached value of the '{@link #getThreadsBA() <em>Threads BA</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getThreadsBA()
	 * @generated
	 * @ordered
	 */
	protected EList<ReducedThreadBA> threadsBA;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnalysisModelImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReducedbaPackage.Literals.ANALYSIS_MODEL;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<ReducedThreadBA> getThreadsBA() {
		if (threadsBA == null) {
			threadsBA = new EObjectContainmentEList<ReducedThreadBA>(ReducedThreadBA.class, this, ReducedbaPackage.ANALYSIS_MODEL__THREADS_BA);
		}
		return threadsBA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case ReducedbaPackage.ANALYSIS_MODEL__THREADS_BA:
				return ((InternalEList<?>)getThreadsBA()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ReducedbaPackage.ANALYSIS_MODEL__THREADS_BA:
				return getThreadsBA();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ReducedbaPackage.ANALYSIS_MODEL__THREADS_BA:
				getThreadsBA().clear();
				getThreadsBA().addAll((Collection<? extends ReducedThreadBA>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case ReducedbaPackage.ANALYSIS_MODEL__THREADS_BA:
				getThreadsBA().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case ReducedbaPackage.ANALYSIS_MODEL__THREADS_BA:
				return threadsBA != null && !threadsBA.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //AnalysisModelImpl
