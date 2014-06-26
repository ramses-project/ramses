/**
 */
package org.trc.xtext.dsl.dsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Modules</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.trc.xtext.dsl.dsl.Modules#getPath <em>Path</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.Modules#getName <em>Name</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.Modules#getRuleName <em>Rule Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.trc.xtext.dsl.dsl.DslPackage#getModules()
 * @model
 * @generated
 */
public interface Modules extends EObject
{
  /**
   * Returns the value of the '<em><b>Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path</em>' attribute.
   * @see #setPath(String)
   * @see org.trc.xtext.dsl.dsl.DslPackage#getModules_Path()
   * @model
   * @generated
   */
  String getPath();

  /**
   * Sets the value of the '{@link org.trc.xtext.dsl.dsl.Modules#getPath <em>Path</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path</em>' attribute.
   * @see #getPath()
   * @generated
   */
  void setPath(String value);

  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see org.trc.xtext.dsl.dsl.DslPackage#getModules_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.trc.xtext.dsl.dsl.Modules#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Rule Name</b></em>' containment reference list.
   * The list contents are of type {@link org.trc.xtext.dsl.dsl.Rules}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rule Name</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rule Name</em>' containment reference list.
   * @see org.trc.xtext.dsl.dsl.DslPackage#getModules_RuleName()
   * @model containment="true"
   * @generated
   */
  EList<Rules> getRuleName();

} // Modules
