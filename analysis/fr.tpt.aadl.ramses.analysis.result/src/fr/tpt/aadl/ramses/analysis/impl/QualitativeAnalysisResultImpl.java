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


import fr.tpt.aadl.ramses.analysis.AnalysisResultPackage;
import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualitative Analysis Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.impl.QualitativeAnalysisResultImpl#isValidated <em>Validated</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualitativeAnalysisResultImpl extends AnalysisResultImpl implements QualitativeAnalysisResult {
	/**
   * The default value of the '{@link #isValidated() <em>Validated</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isValidated()
   * @generated
   * @ordered
   */
	protected static final boolean VALIDATED_EDEFAULT = false;

	/**
   * The cached value of the '{@link #isValidated() <em>Validated</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #isValidated()
   * @generated
   * @ordered
   */
	protected boolean validated = VALIDATED_EDEFAULT;

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected QualitativeAnalysisResultImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected EClass eStaticClass() {
    return AnalysisResultPackage.Literals.QUALITATIVE_ANALYSIS_RESULT;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public boolean isValidated() {
    return validated;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setValidated(boolean newValidated) {
    boolean oldValidated = validated;
    validated = newValidated;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AnalysisResultPackage.QUALITATIVE_ANALYSIS_RESULT__VALIDATED, oldValidated, validated));
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case AnalysisResultPackage.QUALITATIVE_ANALYSIS_RESULT__VALIDATED:
        return isValidated() ? Boolean.TRUE : Boolean.FALSE;
    }
    return super.eGet(featureID, resolve, coreType);
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void eSet(int featureID, Object newValue) {
    switch (featureID)
    {
      case AnalysisResultPackage.QUALITATIVE_ANALYSIS_RESULT__VALIDATED:
        setValidated(((Boolean)newValue).booleanValue());
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
    switch (featureID)
    {
      case AnalysisResultPackage.QUALITATIVE_ANALYSIS_RESULT__VALIDATED:
        setValidated(VALIDATED_EDEFAULT);
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
    switch (featureID)
    {
      case AnalysisResultPackage.QUALITATIVE_ANALYSIS_RESULT__VALIDATED:
        return validated != VALIDATED_EDEFAULT;
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
    result.append(" (validated: ");
    result.append(validated);
    result.append(')');
    return result.toString();
  }

} //QualitativeAnalysisResultImpl
