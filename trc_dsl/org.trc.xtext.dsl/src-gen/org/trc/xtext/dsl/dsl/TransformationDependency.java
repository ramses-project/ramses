/**
 */
package org.trc.xtext.dsl.dsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.trc.xtext.dsl.dsl.TransformationDependency#getAppliedTransformation <em>Applied Transformation</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.TransformationDependency#getAppliedRule <em>Applied Rule</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.TransformationDependency#getFields <em>Fields</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.TransformationDependency#getRequiredTransformations <em>Required Transformations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.trc.xtext.dsl.dsl.DslPackage#getTransformationDependency()
 * @model
 * @generated
 */
public interface TransformationDependency extends EObject
{
  /**
   * Returns the value of the '<em><b>Applied Transformation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Applied Transformation</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Applied Transformation</em>' reference.
   * @see #setAppliedTransformation(Transformation)
   * @see org.trc.xtext.dsl.dsl.DslPackage#getTransformationDependency_AppliedTransformation()
   * @model
   * @generated
   */
  Transformation getAppliedTransformation();

  /**
   * Sets the value of the '{@link org.trc.xtext.dsl.dsl.TransformationDependency#getAppliedTransformation <em>Applied Transformation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Applied Transformation</em>' reference.
   * @see #getAppliedTransformation()
   * @generated
   */
  void setAppliedTransformation(Transformation value);

  /**
   * Returns the value of the '<em><b>Applied Rule</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Applied Rule</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Applied Rule</em>' attribute.
   * @see #setAppliedRule(String)
   * @see org.trc.xtext.dsl.dsl.DslPackage#getTransformationDependency_AppliedRule()
   * @model
   * @generated
   */
  String getAppliedRule();

  /**
   * Sets the value of the '{@link org.trc.xtext.dsl.dsl.TransformationDependency#getAppliedRule <em>Applied Rule</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Applied Rule</em>' attribute.
   * @see #getAppliedRule()
   * @generated
   */
  void setAppliedRule(String value);

  /**
   * Returns the value of the '<em><b>Fields</b></em>' attribute list.
   * The list contents are of type {@link java.lang.String}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fields</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fields</em>' attribute list.
   * @see org.trc.xtext.dsl.dsl.DslPackage#getTransformationDependency_Fields()
   * @model unique="false"
   * @generated
   */
  EList<String> getFields();

  /**
   * Returns the value of the '<em><b>Required Transformations</b></em>' containment reference list.
   * The list contents are of type {@link org.trc.xtext.dsl.dsl.AbstractRuleDependency}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Transformations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Required Transformations</em>' containment reference list.
   * @see org.trc.xtext.dsl.dsl.DslPackage#getTransformationDependency_RequiredTransformations()
   * @model containment="true"
   * @generated
   */
  EList<AbstractRuleDependency> getRequiredTransformations();

} // TransformationDependency
