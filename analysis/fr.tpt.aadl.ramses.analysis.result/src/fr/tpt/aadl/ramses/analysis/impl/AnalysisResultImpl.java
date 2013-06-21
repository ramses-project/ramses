/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.analysis.impl;


import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import fr.tpt.aadl.ramses.analysis.AnalysisPackage;
import fr.tpt.aadl.ramses.analysis.AnalysisResult;
import fr.tpt.aadl.ramses.analysis.AnalysisSource;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.impl.AnalysisResultImpl#getResultId <em>Result Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.impl.AnalysisResultImpl#getNfpId <em>Nfp Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.impl.AnalysisResultImpl#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class AnalysisResultImpl extends EObjectImpl implements AnalysisResult {
	/**
	 * The default value of the '{@link #getResultId() <em>Result Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultId()
	 * @generated
	 * @ordered
	 */
	protected static final String RESULT_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getResultId() <em>Result Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getResultId()
	 * @generated
	 * @ordered
	 */
	protected String resultId = RESULT_ID_EDEFAULT;

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
		return AnalysisPackage.Literals.ANALYSIS_RESULT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getResultId() {
		return resultId;
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
			eNotify(new ENotificationImpl(this, Notification.SET, AnalysisPackage.ANALYSIS_RESULT__NFP_ID, oldNfpId, nfpId));
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
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, AnalysisPackage.ANALYSIS_RESULT__SOURCE, oldSource, source));
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
			eNotify(new ENotificationImpl(this, Notification.SET, AnalysisPackage.ANALYSIS_RESULT__SOURCE, oldSource, source));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case AnalysisPackage.ANALYSIS_RESULT__RESULT_ID:
				return getResultId();
			case AnalysisPackage.ANALYSIS_RESULT__NFP_ID:
				return getNfpId();
			case AnalysisPackage.ANALYSIS_RESULT__SOURCE:
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
			case AnalysisPackage.ANALYSIS_RESULT__NFP_ID:
				setNfpId((String)newValue);
				return;
			case AnalysisPackage.ANALYSIS_RESULT__SOURCE:
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
			case AnalysisPackage.ANALYSIS_RESULT__NFP_ID:
				setNfpId(NFP_ID_EDEFAULT);
				return;
			case AnalysisPackage.ANALYSIS_RESULT__SOURCE:
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
			case AnalysisPackage.ANALYSIS_RESULT__RESULT_ID:
				return RESULT_ID_EDEFAULT == null ? resultId != null : !RESULT_ID_EDEFAULT.equals(resultId);
			case AnalysisPackage.ANALYSIS_RESULT__NFP_ID:
				return NFP_ID_EDEFAULT == null ? nfpId != null : !NFP_ID_EDEFAULT.equals(nfpId);
			case AnalysisPackage.ANALYSIS_RESULT__SOURCE:
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
		result.append(" (resultId: ");
		result.append(resultId);
		result.append(", nfpId: ");
		result.append(nfpId);
		result.append(')');
		return result.toString();
	}

} //AnalysisResultImpl
