/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl;

import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionBegin;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.osate.aadl2.DataAccess;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Critical Section Begin</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.CriticalSectionBeginImpl#getSharedData <em>Shared Data</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CriticalSectionBeginImpl extends ThreadBehaviorElementImpl implements CriticalSectionBegin {
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
	protected CriticalSectionBeginImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return ReducedbaPackage.Literals.CRITICAL_SECTION_BEGIN;
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, ReducedbaPackage.CRITICAL_SECTION_BEGIN__SHARED_DATA, oldSharedData, sharedData));
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
			eNotify(new ENotificationImpl(this, Notification.SET, ReducedbaPackage.CRITICAL_SECTION_BEGIN__SHARED_DATA, oldSharedData, sharedData));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case ReducedbaPackage.CRITICAL_SECTION_BEGIN__SHARED_DATA:
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
			case ReducedbaPackage.CRITICAL_SECTION_BEGIN__SHARED_DATA:
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
			case ReducedbaPackage.CRITICAL_SECTION_BEGIN__SHARED_DATA:
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
			case ReducedbaPackage.CRITICAL_SECTION_BEGIN__SHARED_DATA:
				return sharedData != null;
		}
		return super.eIsSet(featureID);
	}

} //CriticalSectionBeginImpl
