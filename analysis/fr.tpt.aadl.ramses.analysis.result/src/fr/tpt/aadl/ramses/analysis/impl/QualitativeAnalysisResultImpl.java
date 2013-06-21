/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.analysis.impl;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import fr.tpt.aadl.ramses.analysis.AnalysisPackage;
import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Qualitative Analysis Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.impl.QualitativeAnalysisResultImpl#isEvalValue <em>Eval Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class QualitativeAnalysisResultImpl extends AnalysisResultImpl implements QualitativeAnalysisResult {
	/**
	 * The default value of the '{@link #isEvalValue() <em>Eval Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEvalValue()
	 * @generated
	 * @ordered
	 */
	protected static final boolean EVAL_VALUE_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isEvalValue() <em>Eval Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isEvalValue()
	 * @generated
	 * @ordered
	 */
	protected boolean evalValue = EVAL_VALUE_EDEFAULT;

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
		return AnalysisPackage.Literals.QUALITATIVE_ANALYSIS_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isEvalValue() {
		return evalValue;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setEvalValue(boolean newEvalValue) {
		boolean oldEvalValue = evalValue;
		evalValue = newEvalValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, AnalysisPackage.QUALITATIVE_ANALYSIS_RESULT__EVAL_VALUE, oldEvalValue, evalValue));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalysisPackage.QUALITATIVE_ANALYSIS_RESULT__EVAL_VALUE:
				return isEvalValue() ? Boolean.TRUE : Boolean.FALSE;
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
			case AnalysisPackage.QUALITATIVE_ANALYSIS_RESULT__EVAL_VALUE:
				setEvalValue(((Boolean)newValue).booleanValue());
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
			case AnalysisPackage.QUALITATIVE_ANALYSIS_RESULT__EVAL_VALUE:
				setEvalValue(EVAL_VALUE_EDEFAULT);
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
			case AnalysisPackage.QUALITATIVE_ANALYSIS_RESULT__EVAL_VALUE:
				return evalValue != EVAL_VALUE_EDEFAULT;
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
		result.append(" (evalValue: ");
		result.append(evalValue);
		result.append(')');
		return result.toString();
	}

} //QualitativeAnalysisResultImpl
