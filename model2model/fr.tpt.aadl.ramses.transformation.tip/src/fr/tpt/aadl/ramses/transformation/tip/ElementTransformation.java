/**
 */
package fr.tpt.aadl.ramses.transformation.tip;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.instance.InstanceObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Element Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.tip.ElementTransformation#getElementId <em>Element Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.tip.ElementTransformation#getElementName <em>Element Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.tip.ElementTransformation#isIsExclusion <em>Is Exclusion</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.tip.ElementTransformation#getTransformationId <em>Transformation Id</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.tip.TipPackage#getElementTransformation()
 * @model
 * @generated
 */
public interface ElementTransformation extends EObject {
	/**
   * Returns the value of the '<em><b>Transformation Id</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Transformation Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Transformation Id</em>' attribute.
   * @see #setTransformationId(String)
   * @see fr.tpt.aadl.ramses.transformation.tip.TipPackage#getElementTransformation_TransformationId()
   * @model
   * @generated
   */
	String getTransformationId();

	/**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.tip.ElementTransformation#getTransformationId <em>Transformation Id</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transformation Id</em>' attribute.
   * @see #getTransformationId()
   * @generated
   */
	void setTransformationId(String value);

	/**
   * Returns the value of the '<em><b>Element Id</b></em>' reference list.
   * The list contents are of type {@link org.osate.aadl2.Element}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Id</em>' reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Element Id</em>' reference list.
   * @see fr.tpt.aadl.ramses.transformation.tip.TipPackage#getElementTransformation_ElementId()
   * @model type="org.osate.aadl2.Element" required="true"
   * @generated
   */
	EList getElementId();

	/**
   * Returns the value of the '<em><b>Element Name</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element Name</em>' attribute list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Element Name</em>' attribute list.
   * @see fr.tpt.aadl.ramses.transformation.tip.TipPackage#getElementTransformation_ElementName()
   * @model dataType="org.osate.aadl2.String" required="true"
   * @generated
   */
	EList getElementName();

	/**
   * Returns the value of the '<em><b>Is Exclusion</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Is Exclusion</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Is Exclusion</em>' attribute.
   * @see #setIsExclusion(boolean)
   * @see fr.tpt.aadl.ramses.transformation.tip.TipPackage#getElementTransformation_IsExclusion()
   * @model dataType="org.osate.aadl2.Boolean" required="true"
   * @generated
   */
	boolean isIsExclusion();

	/**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.tip.ElementTransformation#isIsExclusion <em>Is Exclusion</em>}' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Is Exclusion</em>' attribute.
   * @see #isIsExclusion()
   * @generated
   */
	void setIsExclusion(boolean value);

} // ElementTransformation
