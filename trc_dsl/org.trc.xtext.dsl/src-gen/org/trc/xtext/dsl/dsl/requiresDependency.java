/**
 */
package org.trc.xtext.dsl.dsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>requires Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.trc.xtext.dsl.dsl.requiresDependency#getRequiredTransformation <em>Required Transformation</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.requiresDependency#getRequiredRule <em>Required Rule</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.requiresDependency#getFields <em>Fields</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.requiresDependency#getOclExpression <em>Ocl Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.trc.xtext.dsl.dsl.DslPackage#getrequiresDependency()
 * @model
 * @generated
 */
public interface requiresDependency extends EObject
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
   * @see org.trc.xtext.dsl.dsl.DslPackage#getrequiresDependency_RequiredTransformation()
   * @model
   * @generated
   */
  EList<Transformation> getRequiredTransformation();

  /**
   * Returns the value of the '<em><b>Required Rule</b></em>' reference list.
   * The list contents are of type {@link org.trc.xtext.dsl.dsl.trcRule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Rule</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Required Rule</em>' reference list.
   * @see org.trc.xtext.dsl.dsl.DslPackage#getrequiresDependency_RequiredRule()
   * @model
   * @generated
   */
  EList<trcRule> getRequiredRule();

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
   * @see org.trc.xtext.dsl.dsl.DslPackage#getrequiresDependency_Fields()
   * @model
   * @generated
   */
  String getFields();

  /**
   * Sets the value of the '{@link org.trc.xtext.dsl.dsl.requiresDependency#getFields <em>Fields</em>}' attribute.
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
   * @see org.trc.xtext.dsl.dsl.DslPackage#getrequiresDependency_OclExpression()
   * @model
   * @generated
   */
  String getOclExpression();

  /**
   * Sets the value of the '{@link org.trc.xtext.dsl.dsl.requiresDependency#getOclExpression <em>Ocl Expression</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Ocl Expression</em>' attribute.
   * @see #getOclExpression()
   * @generated
   */
  void setOclExpression(String value);

} // requiresDependency
