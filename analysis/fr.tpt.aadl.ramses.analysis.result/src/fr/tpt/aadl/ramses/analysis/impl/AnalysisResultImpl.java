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

package fr.tpt.aadl.ramses.analysis.impl;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import fr.tpt.aadl.ramses.analysis.AnalysisResult;
import fr.tpt.aadl.ramses.analysis.AnalysisResultPackage;
import fr.tpt.aadl.ramses.analysis.AnalysisSource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.impl.AnalysisResultImpl#getResultUUId <em>Result UU Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.impl.AnalysisResultImpl#getNfpId <em>Nfp Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.impl.AnalysisResultImpl#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AnalysisResultImpl extends EObjectImpl implements AnalysisResult {
	/**
	 * The default value of the '{@link #getResultUUId() <em>Result UU Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultUUId()
	 * @generated
	 * @ordered
	 */
	protected static final String RESULT_UU_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResultUUId() <em>Result UU Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultUUId()
	 * @generated
	 * @ordered
	 */
	protected String resultUUId = RESULT_UU_ID_EDEFAULT;

	/**
	 * The default value of the '{@link #getNfpId() <em>Nfp Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNfpId()
	 * @generated
	 * @ordered
	 */
	protected static final String NFP_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getNfpId() <em>Nfp Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getNfpId()
	 * @generated
	 * @ordered
	 */
	protected String nfpId = NFP_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getSource() <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSource()
	 * @generated
	 * @ordered
	 */
	protected AnalysisSource source;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected AnalysisResultImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return AnalysisResultPackage.Literals.ANALYSIS_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResultUUId() {
		return resultUUId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getNfpId() {
		return nfpId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setNfpId(String newNfpId) {
		String oldNfpId = nfpId;
		nfpId = newNfpId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalysisResultPackage.ANALYSIS_RESULT__NFP_ID, oldNfpId, nfpId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisSource getSource() {
		if (source != null && source.eIsProxy()) {
			InternalEObject oldSource = (InternalEObject)source;
			source = (AnalysisSource)eResolveProxy(oldSource);
			if (source != oldSource) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnalysisResultPackage.ANALYSIS_RESULT__SOURCE, oldSource, source));
			}
		}
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisSource basicGetSource() {
		return source;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setSource(AnalysisSource newSource) {
		AnalysisSource oldSource = source;
		source = newSource;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalysisResultPackage.ANALYSIS_RESULT__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalysisResultPackage.ANALYSIS_RESULT__RESULT_UU_ID:
				return getResultUUId();
			case AnalysisResultPackage.ANALYSIS_RESULT__NFP_ID:
				return getNfpId();
			case AnalysisResultPackage.ANALYSIS_RESULT__SOURCE:
				if (resolve) return getSource();
				return basicGetSource();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case AnalysisResultPackage.ANALYSIS_RESULT__NFP_ID:
				setNfpId((String)newValue);
				return;
			case AnalysisResultPackage.ANALYSIS_RESULT__SOURCE:
				setSource((AnalysisSource)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void eUnset(int featureID) {
		switch (featureID) {
			case AnalysisResultPackage.ANALYSIS_RESULT__NFP_ID:
				setNfpId(NFP_ID_EDEFAULT);
				return;
			case AnalysisResultPackage.ANALYSIS_RESULT__SOURCE:
				setSource((AnalysisSource)null);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case AnalysisResultPackage.ANALYSIS_RESULT__RESULT_UU_ID:
				return RESULT_UU_ID_EDEFAULT == null ? resultUUId != null : !RESULT_UU_ID_EDEFAULT.equals(resultUUId);
			case AnalysisResultPackage.ANALYSIS_RESULT__NFP_ID:
				return NFP_ID_EDEFAULT == null ? nfpId != null : !NFP_ID_EDEFAULT.equals(nfpId);
			case AnalysisResultPackage.ANALYSIS_RESULT__SOURCE:
				return source != null;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuffer result = new StringBuffer(super.toString());
		result.append(" (resultUUId: ");
		result.append(resultUUId);
		result.append(", nfpId: ");
		result.append(nfpId);
		result.append(')');
		return result.toString();
	}

} //AnalysisResultImpl
