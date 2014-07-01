/**
 */
package org.trc.xtext.dsl.dsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trc Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.trc.xtext.dsl.dsl.TrcSpecification#getModuleList <em>Module List</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.TrcSpecification#getTransformationList <em>Transformation List</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.TrcSpecification#getDependencyList <em>Dependency List</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.trc.xtext.dsl.dsl.DslPackage#getTrcSpecification()
 * @model
 * @generated
 */
public interface TrcSpecification extends EObject
{
  /**
   * Returns the value of the '<em><b>Module List</b></em>' containment reference list.
   * The list contents are of type {@link org.trc.xtext.dsl.dsl.ModuleList}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Module List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Module List</em>' containment reference list.
   * @see org.trc.xtext.dsl.dsl.DslPackage#getTrcSpecification_ModuleList()
   * @model containment="true"
   * @generated
   */
  EList<ModuleList> getModuleList();

  /**
   * Returns the value of the '<em><b>Transformation List</b></em>' containment reference list.
   * The list contents are of type {@link org.trc.xtext.dsl.dsl.TransformationList}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transformation List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transformation List</em>' containment reference list.
   * @see org.trc.xtext.dsl.dsl.DslPackage#getTrcSpecification_TransformationList()
   * @model containment="true"
   * @generated
   */
  EList<TransformationList> getTransformationList();

  /**
   * Returns the value of the '<em><b>Dependency List</b></em>' containment reference list.
   * The list contents are of type {@link org.trc.xtext.dsl.dsl.TransformationDependencyList}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dependency List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dependency List</em>' containment reference list.
   * @see org.trc.xtext.dsl.dsl.DslPackage#getTrcSpecification_DependencyList()
   * @model containment="true"
   * @generated
   */
  EList<TransformationDependencyList> getDependencyList();

} // TrcSpecification
