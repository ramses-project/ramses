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

import fr.tpt.aadl.ramses.analysis.QuantitativeAnalysisResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Quantitative Analysis Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.impl.QuantitativeAnalysisResultImpl#getMargin <em>Margin</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.impl.QuantitativeAnalysisResultImpl#getValue <em>Value</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.impl.QuantitativeAnalysisResultImpl#getLimit <em>Limit</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QuantitativeAnalysisResultImpl extends AnalysisResultImpl implements QuantitativeAnalysisResult {
	/**
   * The default value of the '{@link #getMargin() <em>Margin</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getMargin()
   * @generated
   * @ordered
   */
	protected static final float MARGIN_EDEFAULT = 0.0F;

	/**
   * The cached value of the '{@link #getMargin() <em>Margin</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see #getMargin()
   * @generated
   * @ordered
   */
	protected float margin = MARGIN_EDEFAULT;

	/**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final float VALUE_EDEFAULT = 0.0F;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected float value = VALUE_EDEFAULT;

  /**
   * The default value of the '{@link #getLimit() <em>Limit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLimit()
   * @generated
   * @ordered
   */
  protected static final float LIMIT_EDEFAULT = 0.0F;

  /**
   * The cached value of the '{@link #getLimit() <em>Limit</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLimit()
   * @generated
   * @ordered
   */
  protected float limit = LIMIT_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected QuantitativeAnalysisResultImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected EClass eStaticClass() {
    return AnalysisResultPackage.Literals.QUANTITATIVE_ANALYSIS_RESULT;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public float getMargin() {
    return margin;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public void setMargin(float newMargin) {
    float oldMargin = margin;
    margin = newMargin;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__MARGIN, oldMargin, margin));
  }

	/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public float getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(float newValue)
  {
    float oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__VALUE, oldValue, value));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public float getLimit()
  {
    return limit;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLimit(float newLimit)
  {
    float oldLimit = limit;
    limit = newLimit;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__LIMIT, oldLimit, limit));
  }

  /**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
    switch (featureID)
    {
      case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__MARGIN:
        return new Float(getMargin());
      case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__VALUE:
        return new Float(getValue());
      case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__LIMIT:
        return new Float(getLimit());
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
      case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__MARGIN:
        setMargin(((Float)newValue).floatValue());
        return;
      case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__VALUE:
        setValue(((Float)newValue).floatValue());
        return;
      case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__LIMIT:
        setLimit(((Float)newValue).floatValue());
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
      case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__MARGIN:
        setMargin(MARGIN_EDEFAULT);
        return;
      case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__VALUE:
        setValue(VALUE_EDEFAULT);
        return;
      case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__LIMIT:
        setLimit(LIMIT_EDEFAULT);
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
      case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__MARGIN:
        return margin != MARGIN_EDEFAULT;
      case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__VALUE:
        return value != VALUE_EDEFAULT;
      case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__LIMIT:
        return limit != LIMIT_EDEFAULT;
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
    result.append(" (margin: ");
    result.append(margin);
    result.append(", value: ");
    result.append(value);
    result.append(", limit: ");
    result.append(limit);
    result.append(')');
    return result.toString();
  }

} //QuantitativeAnalysisResultImpl
