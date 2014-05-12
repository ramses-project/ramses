/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.atl.patternmatching.impl;


import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.osate.aadl2.NamedElement;

import fr.tpt.atl.patternmatching.ElementTransformationTuple;
import fr.tpt.atl.patternmatching.patternmatchingPackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Element Transformation Tuple</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.atl.patternmatching.impl.ElementTransformationTupleImpl#getValue <em>Value</em>}</li>
 *   <li>{@link fr.tpt.atl.patternmatching.impl.ElementTransformationTupleImpl#getKey <em>Key</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ElementTransformationTupleImpl extends EObjectImpl implements ElementTransformationTuple {
	/**
	 * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected static final String VALUE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getValue()
	 * @generated
	 * @ordered
	 */
	protected String value = VALUE_EDEFAULT;

	/**
	 * The cached value of the '{@link #getKey() <em>Key</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getKey()
	 * @generated
	 * @ordered
	 */
	protected EList key;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ElementTransformationTupleImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected EClass eStaticClass() {
		return patternmatchingPackage.Literals.ELEMENT_TRANSFORMATION_TUPLE;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList getKey() {
		if (key == null) {
			key = new EObjectResolvingEList(EObject.class, this, patternmatchingPackage.ELEMENT_TRANSFORMATION_TUPLE__KEY);
		}
		return key;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getValue() {
		return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setValue(String newValue) {
		String oldValue = value;
		value = newValue;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, patternmatchingPackage.ELEMENT_TRANSFORMATION_TUPLE__VALUE, oldValue, value));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case patternmatchingPackage.ELEMENT_TRANSFORMATION_TUPLE__VALUE:
				return getValue();
			case patternmatchingPackage.ELEMENT_TRANSFORMATION_TUPLE__KEY:
				return getKey();
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
			case patternmatchingPackage.ELEMENT_TRANSFORMATION_TUPLE__VALUE:
				setValue((String)newValue);
				return;
			case patternmatchingPackage.ELEMENT_TRANSFORMATION_TUPLE__KEY:
				getKey().clear();
				getKey().addAll((Collection)newValue);
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
			case patternmatchingPackage.ELEMENT_TRANSFORMATION_TUPLE__VALUE:
				setValue(VALUE_EDEFAULT);
				return;
			case patternmatchingPackage.ELEMENT_TRANSFORMATION_TUPLE__KEY:
				getKey().clear();
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
			case patternmatchingPackage.ELEMENT_TRANSFORMATION_TUPLE__VALUE:
				return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
			case patternmatchingPackage.ELEMENT_TRANSFORMATION_TUPLE__KEY:
				return key != null && !key.isEmpty();
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
		result.append(" (value: ");
		result.append(value);
		result.append(')');
		return result.toString();
	}

} //ElementTransformationTupleImpl
