/**
 */
package org.trc.xtext.dsl.dsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>exclude Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.trc.xtext.dsl.dsl.excludeDependency#getRequiredTransformation <em>Required Transformation</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.excludeDependency#getRequiredRule <em>Required Rule</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.excludeDependency#getFields <em>Fields</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.excludeDependency#getOclExpression <em>Ocl Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.trc.xtext.dsl.dsl.DslPackage#getexcludeDependency()
 * @model
 * @generated
 */
public interface excludeDependency extends EObject
{
  /**
   * Returns the value of the '<em><b>Required Transformation</b></em>' reference list.
   * The list contents are of type {@link org.trc.xtext.dsl.dsl.Transformation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Transformation</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Required Transformation</em>' reference list.
   * @see org.trc.xtext.dsl.dsl.DslPackage#getexcludeDependency_RequiredTransformation()
   * @model
   * @generated
   */
  EList<Transformation> getRequiredTransformation();

  /**
   * Returns the value of the '<em><b>Required Rule</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Rule</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Required Rule</em>' attribute.
   * @see #setRequiredRule(String)
   * @see org.trc.xtext.dsl.dsl.DslPackage#getexcludeDependency_RequiredRule()
   * @model
   * @generated
   */
  String getRequiredRule();

  /**
   * Sets the value of the '{@link org.trc.xtext.dsl.dsl.excludeDependency#getRequiredRule <em>Required Rule</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Required Rule</em>' attribute.
   * @see #getRequiredRule()
   * @generated
   */
  void setRequiredRule(String value);

  /**
   * Returns the value of the '<em><b>Fields</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Fields</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Fields</em>' attribute.
   * @see #setFields(String)
   * @see org.trc.xtext.dsl.dsl.DslPackage#getexcludeDependency_Fields()
   * @model
   * @generated
   */
  String getFields();

  /**
   * Sets the value of the '{@link org.trc.xtext.dsl.dsl.excludeDependency#getFields <em>Fields</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fields</em>' attribute.
   * @see #getFields()
   * @generated
   */
  void setFields(String value);

  /**
   * Returns the value of the '<em><b>Ocl Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ocl Expression</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ocl Expression</em>' attribute.
   * @see #setOclExpression(String)
   * @see org.trc.xtext.dsl.dsl.DslPackage#getexcludeDependency_OclExpression()
   * @model
   * @generated
   */
  String getOclExpression();

  /**
   * Sets the value of the '{@link org.trc.xtext.dsl.dsl.excludeDependency#getOclExpression <em>Ocl Expression</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ocl Expression</em>' attribute.
   * @see #getOclExpression()
   * @generated
   */
  void setOclExpression(String value);

} // excludeDependency
