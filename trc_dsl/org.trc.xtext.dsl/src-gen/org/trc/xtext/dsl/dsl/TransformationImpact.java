/**
 */
package org.trc.xtext.dsl.dsl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation Impact</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.trc.xtext.dsl.dsl.TransformationImpact#getQualityAttributeName <em>Quality Attribute Name</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.TransformationImpact#getImpactValue <em>Impact Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.trc.xtext.dsl.dsl.DslPackage#getTransformationImpact()
 * @model
 * @generated
 */
public interface TransformationImpact extends EObject
{
  /**
   * Returns the value of the '<em><b>Quality Attribute Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Quality Attribute Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Quality Attribute Name</em>' attribute.
   * @see #setQualityAttributeName(String)
   * @see org.trc.xtext.dsl.dsl.DslPackage#getTransformationImpact_QualityAttributeName()
   * @model
   * @generated
   */
  String getQualityAttributeName();

  /**
   * Sets the value of the '{@link org.trc.xtext.dsl.dsl.TransformationImpact#getQualityAttributeName <em>Quality Attribute Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Quality Attribute Name</em>' attribute.
   * @see #getQualityAttributeName()
   * @generated
   */
  void setQualityAttributeName(String value);

  /**
   * Returns the value of the '<em><b>Impact Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Impact Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Impact Value</em>' attribute.
   * @see #setImpactValue(int)
   * @see org.trc.xtext.dsl.dsl.DslPackage#getTransformationImpact_ImpactValue()
   * @model
   * @generated
   */
  int getImpactValue();

  /**
   * Sets the value of the '{@link org.trc.xtext.dsl.dsl.TransformationImpact#getImpactValue <em>Impact Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Impact Value</em>' attribute.
   * @see #getImpactValue()
   * @generated
   */
  void setImpactValue(int value);

} // TransformationImpact
