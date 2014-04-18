/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 1.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * http://www.eclipse.org/org/documents/epl-v10.php
 */
package fr.tpt.aadl.ramses.control.workflow.impl;

import fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis;
import fr.tpt.aadl.ramses.control.workflow.AnalysisOption;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Abstract Analysis</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.AbstractAnalysisImpl#getYesOption <em>Yes Option</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.impl.AbstractAnalysisImpl#getNoOption <em>No Option</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AbstractAnalysisImpl extends EObjectImpl implements AbstractAnalysis {
	/**
	 * The cached value of the '{@link #getYesOption() <em>Yes Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getYesOption()
	 * @generated
	 * @ordered
	 */
	protected AnalysisOption yesOption;

	/**
	 * The cached value of the '{@link #getNoOption() <em>No Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNoOption()
	 * @generated
	 * @ordered
	 */
	protected AnalysisOption noOption;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AbstractAnalysisImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return WorkflowPackage.Literals.ABSTRACT_ANALYSIS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisOption getYesOption() {
		return yesOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetYesOption(AnalysisOption newYesOption, NotificationChain msgs) {
		AnalysisOption oldYesOption = yesOption;
		yesOption = newYesOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.ABSTRACT_ANALYSIS__YES_OPTION, oldYesOption, newYesOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setYesOption(AnalysisOption newYesOption) {
		if (newYesOption != yesOption) {
			NotificationChain msgs = null;
			if (yesOption != null)
				msgs = ((InternalEObject)yesOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.ABSTRACT_ANALYSIS__YES_OPTION, null, msgs);
			if (newYesOption != null)
				msgs = ((InternalEObject)newYesOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.ABSTRACT_ANALYSIS__YES_OPTION, null, msgs);
			msgs = basicSetYesOption(newYesOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.ABSTRACT_ANALYSIS__YES_OPTION, newYesOption, newYesOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisOption getNoOption() {
		return noOption;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetNoOption(AnalysisOption newNoOption, NotificationChain msgs) {
		AnalysisOption oldNoOption = noOption;
		noOption = newNoOption;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, WorkflowPackage.ABSTRACT_ANALYSIS__NO_OPTION, oldNoOption, newNoOption);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNoOption(AnalysisOption newNoOption) {
		if (newNoOption != noOption) {
			NotificationChain msgs = null;
			if (noOption != null)
				msgs = ((InternalEObject)noOption).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.ABSTRACT_ANALYSIS__NO_OPTION, null, msgs);
			if (newNoOption != null)
				msgs = ((InternalEObject)newNoOption).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - WorkflowPackage.ABSTRACT_ANALYSIS__NO_OPTION, null, msgs);
			msgs = basicSetNoOption(newNoOption, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, WorkflowPackage.ABSTRACT_ANALYSIS__NO_OPTION, newNoOption, newNoOption));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case WorkflowPackage.ABSTRACT_ANALYSIS__YES_OPTION:
				return basicSetYesOption(null, msgs);
			case WorkflowPackage.ABSTRACT_ANALYSIS__NO_OPTION:
				return basicSetNoOption(null, msgs);
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
			case WorkflowPackage.ABSTRACT_ANALYSIS__YES_OPTION:
				return getYesOption();
			case WorkflowPackage.ABSTRACT_ANALYSIS__NO_OPTION:
				return getNoOption();
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
			case WorkflowPackage.ABSTRACT_ANALYSIS__YES_OPTION:
				setYesOption((AnalysisOption)newValue);
				return;
			case WorkflowPackage.ABSTRACT_ANALYSIS__NO_OPTION:
				setNoOption((AnalysisOption)newValue);
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
			case WorkflowPackage.ABSTRACT_ANALYSIS__YES_OPTION:
				setYesOption((AnalysisOption)null);
				return;
			case WorkflowPackage.ABSTRACT_ANALYSIS__NO_OPTION:
				setNoOption((AnalysisOption)null);
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
			case WorkflowPackage.ABSTRACT_ANALYSIS__YES_OPTION:
				return yesOption != null;
			case WorkflowPackage.ABSTRACT_ANALYSIS__NO_OPTION:
				return noOption != null;
		}
		return super.eIsSet(featureID);
	}

} //AbstractAnalysisImpl
