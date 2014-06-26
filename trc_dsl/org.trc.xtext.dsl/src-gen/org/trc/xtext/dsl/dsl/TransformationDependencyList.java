/**
 */
package org.trc.xtext.dsl.dsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation Dependency List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.trc.xtext.dsl.dsl.TransformationDependencyList#getName <em>Name</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.TransformationDependencyList#getTransformationDependencies <em>Transformation Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.trc.xtext.dsl.dsl.DslPackage#getTransformationDependencyList()
 * @model
 * @generated
 */
public interface TransformationDependencyList extends EObject
{
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
   * @see org.trc.xtext.dsl.dsl.DslPackage#getTransformationDependencyList_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link org.trc.xtext.dsl.dsl.TransformationDependencyList#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Transformation Dependencies</b></em>' containment reference list.
   * The list contents are of type {@link org.trc.xtext.dsl.dsl.TransformationDependency}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transformation Dependencies</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transformation Dependencies</em>' containment reference list.
   * @see org.trc.xtext.dsl.dsl.DslPackage#getTransformationDependencyList_TransformationDependencies()
   * @model containment="true"
   * @generated
   */
  EList<TransformationDependency> getTransformationDependencies();

} // TransformationDependencyList
