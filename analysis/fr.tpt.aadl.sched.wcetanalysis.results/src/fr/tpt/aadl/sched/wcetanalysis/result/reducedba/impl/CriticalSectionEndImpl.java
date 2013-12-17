/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl;

import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionEnd;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.DataAccess;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Critical Section End</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.CriticalSectionEndImpl#getSharedData <em>Shared Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CriticalSectionEndImpl extends ThreadBehaviorElementImpl implements CriticalSectionEnd {
	/**
	 * The cached value of the '{@link #getSharedData() <em>Shared Data</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSharedData()
	 * @generated
	 * @ordered
	 */
	protected DataAccess sharedData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CriticalSectionEndImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReducedbaPackage.Literals.CRITICAL_SECTION_END;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataAccess getSharedData() {
		if (sharedData != null && ((EObject)sharedData).eIsProxy()) {
			InternalEObject oldSharedData = (InternalEObject)sharedData;
			sharedData = (DataAccess)eResolveProxy(oldSharedData);
			if (sharedData != oldSharedData) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReducedbaPackage.CRITICAL_SECTION_END__SHARED_DATA, oldSharedData, sharedData));
			}
		}
		return sharedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataAccess basicGetSharedData() {
		return sharedData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSharedData(DataAccess newSharedData) {
		DataAccess oldSharedData = sharedData;
		sharedData = newSharedData;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, ReducedbaPackage.CRITICAL_SECTION_END__SHARED_DATA, oldSharedData, sharedData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ReducedbaPackage.CRITICAL_SECTION_END__SHARED_DATA:
				if (resolve) return getSharedData();
				return basicGetSharedData();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case ReducedbaPackage.CRITICAL_SECTION_END__SHARED_DATA:
				setSharedData((DataAccess)newValue);
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
			case ReducedbaPackage.CRITICAL_SECTION_END__SHARED_DATA:
				setSharedData((DataAccess)null);
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
			case ReducedbaPackage.CRITICAL_SECTION_END__SHARED_DATA:
				return sharedData != null;
		}
		return super.eIsSet(featureID);
	}

} //CriticalSectionEndImpl
