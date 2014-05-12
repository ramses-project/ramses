/**
 */
package fr.tpt.aadl.ramses.transformation.tip.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.osate.aadl2.NamedElement;

import org.osate.aadl2.instance.InstanceObject;
import fr.tpt.aadl.ramses.transformation.tip.ElementTransformation;
import fr.tpt.aadl.ramses.transformation.tip.TipPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.tip.impl.ElementTransformationImpl#getTransformationId <em>Transformation Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.tip.impl.ElementTransformationImpl#getElementId <em>Element Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.tip.impl.ElementTransformationImpl#getElementName <em>Element Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.tip.impl.ElementTransformationImpl#isIsExclusion <em>Is Exclusion</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementTransformationImpl extends EObjectImpl implements ElementTransformation {
	/**
	 * The default value of the '{@link #getTransformationId() <em>Transformation Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformationId()
	 * @generated
	 * @ordered
	 */
	protected static final String TRANSFORMATION_ID_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getTransformationId() <em>Transformation Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getTransformationId()
	 * @generated
	 * @ordered
	 */
	protected String transformationId = TRANSFORMATION_ID_EDEFAULT;

	/**
	 * The cached value of the '{@link #getElementId() <em>Element Id</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementId()
	 * @generated
	 * @ordered
	 */
	protected EList elementId;

	/**
	 * The cached value of the '{@link #getElementName() <em>Element Name</em>}' attribute list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getElementName()
	 * @generated
	 * @ordered
	 */
	protected EList elementName;

	/**
	 * The default value of the '{@link #isIsExclusion() <em>Is Exclusion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsExclusion()
	 * @generated
	 * @ordered
	 */
	protected static final boolean IS_EXCLUSION_EDEFAULT = false;

	/**
	 * The cached value of the '{@link #isIsExclusion() <em>Is Exclusion</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #isIsExclusion()
	 * @generated
	 * @ordered
	 */
	protected boolean isExclusion = IS_EXCLUSION_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementTransformationImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return TipPackage.Literals.ELEMENT_TRANSFORMATION;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getTransformationId() {
		return transformationId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setTransformationId(String newTransformationId) {
		String oldTransformationId = transformationId;
		transformationId = newTransformationId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TipPackage.ELEMENT_TRANSFORMATION__TRANSFORMATION_ID, oldTransformationId, transformationId));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getElementId() {
		if (elementId == null) {
			elementId = new EObjectResolvingEList(NamedElement.class, this, TipPackage.ELEMENT_TRANSFORMATION__ELEMENT_ID);
		}
		return elementId;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getElementName() {
		if (elementName == null) {
			elementName = new EDataTypeUniqueEList(String.class, this, TipPackage.ELEMENT_TRANSFORMATION__ELEMENT_NAME);
		}
		return elementName;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public boolean isIsExclusion() {
		return isExclusion;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIsExclusion(boolean newIsExclusion) {
		boolean oldIsExclusion = isExclusion;
		isExclusion = newIsExclusion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TipPackage.ELEMENT_TRANSFORMATION__IS_EXCLUSION, oldIsExclusion, isExclusion));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case TipPackage.ELEMENT_TRANSFORMATION__TRANSFORMATION_ID:
				return getTransformationId();
			case TipPackage.ELEMENT_TRANSFORMATION__ELEMENT_ID:
				return getElementId();
			case TipPackage.ELEMENT_TRANSFORMATION__ELEMENT_NAME:
				return getElementName();
			case TipPackage.ELEMENT_TRANSFORMATION__IS_EXCLUSION:
				return isIsExclusion() ? Boolean.TRUE : Boolean.FALSE;
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
			case TipPackage.ELEMENT_TRANSFORMATION__TRANSFORMATION_ID:
				setTransformationId((String)newValue);
				return;
			case TipPackage.ELEMENT_TRANSFORMATION__ELEMENT_ID:
				getElementId().clear();
				getElementId().addAll((Collection)newValue);
				return;
			case TipPackage.ELEMENT_TRANSFORMATION__ELEMENT_NAME:
				getElementName().clear();
				getElementName().addAll((Collection)newValue);
				return;
			case TipPackage.ELEMENT_TRANSFORMATION__IS_EXCLUSION:
				setIsExclusion(((Boolean)newValue).booleanValue());
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
			case TipPackage.ELEMENT_TRANSFORMATION__TRANSFORMATION_ID:
				setTransformationId(TRANSFORMATION_ID_EDEFAULT);
				return;
			case TipPackage.ELEMENT_TRANSFORMATION__ELEMENT_ID:
				getElementId().clear();
				return;
			case TipPackage.ELEMENT_TRANSFORMATION__ELEMENT_NAME:
				getElementName().clear();
				return;
			case TipPackage.ELEMENT_TRANSFORMATION__IS_EXCLUSION:
				setIsExclusion(IS_EXCLUSION_EDEFAULT);
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
			case TipPackage.ELEMENT_TRANSFORMATION__TRANSFORMATION_ID:
				return TRANSFORMATION_ID_EDEFAULT == null ? transformationId != null : !TRANSFORMATION_ID_EDEFAULT.equals(transformationId);
			case TipPackage.ELEMENT_TRANSFORMATION__ELEMENT_ID:
				return elementId != null && !elementId.isEmpty();
			case TipPackage.ELEMENT_TRANSFORMATION__ELEMENT_NAME:
				return elementName != null && !elementName.isEmpty();
			case TipPackage.ELEMENT_TRANSFORMATION__IS_EXCLUSION:
				return isExclusion != IS_EXCLUSION_EDEFAULT;
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
		result.append(" (transformationId: ");
		result.append(transformationId);
		result.append(", elementName: ");
		result.append(elementName);
		result.append(", isExclusion: ");
		result.append(isExclusion);
		result.append(')');
		return result.toString();
	}

} //ElementTransformationImpl
