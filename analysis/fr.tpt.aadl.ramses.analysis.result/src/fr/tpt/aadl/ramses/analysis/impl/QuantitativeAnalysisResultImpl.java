/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__MARGIN:
				return new Float(getMargin());
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
			case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__MARGIN:
				setMargin(((Float)newValue).floatValue());
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
			case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__MARGIN:
				setMargin(MARGIN_EDEFAULT);
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
			case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT__MARGIN:
				return margin != MARGIN_EDEFAULT;
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
		result.append(')');
		return result.toString();
	}

} //QuantitativeAnalysisResultImpl
