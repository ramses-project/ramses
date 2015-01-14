/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.atl.patternmatching;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Transformation Tuple</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.atl.patternmatching.ElementTransformationTuple#getValue <em>Value</em>}</li>
 *   <li>{@link fr.tpt.atl.patternmatching.ElementTransformationTuple#getKey <em>Key</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.atl.patternmatching.patternmatchingPackage#getElementTransformationTuple()
 * @model
 * @generated
 */
public interface ElementTransformationTuple extends EObject {
	/**
	 * Returns the value of the '<em><b>Key</b></em>' reference list.
	 * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Key</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Key</em>' reference list.
	 * @see fr.tpt.atl.patternmatching.patternmatchingPackage#getElementTransformationTuple_Key()
	 * @model type="org.eclipse.emf.ecore.EObject" required="true"
	 * @generated
	 */
	EList getKey();

	/**
	 * Returns the value of the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Value</em>' attribute.
	 * @see #setValue(String)
	 * @see fr.tpt.atl.patternmatching.patternmatchingPackage#getElementTransformationTuple_Value()
	 * @model
	 * @generated
	 */
	String getValue();

	/**
	 * Sets the value of the '{@link fr.tpt.atl.patternmatching.ElementTransformationTuple#getValue <em>Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Value</em>' attribute.
	 * @see #getValue()
	 * @generated
	 */
	void setValue(String value);

} // ElementTransformationTuple
