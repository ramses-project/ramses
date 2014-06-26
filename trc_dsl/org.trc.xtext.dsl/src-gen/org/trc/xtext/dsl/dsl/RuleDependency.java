/**
 */
package org.trc.xtext.dsl.dsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.trc.xtext.dsl.dsl.RuleDependency#getRd <em>Rd</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.RuleDependency#getEd <em>Ed</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.trc.xtext.dsl.dsl.DslPackage#getRuleDependency()
 * @model
 * @generated
 */
public interface RuleDependency extends AbstractRuleDependency
{
  /**
   * Returns the value of the '<em><b>Rd</b></em>' containment reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rd</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Rd</em>' containment reference list.
   * @see org.trc.xtext.dsl.dsl.DslPackage#getRuleDependency_Rd()
   * @model containment="true"
   * @generated
   */
  EList<EObject> getRd();

  /**
   * Returns the value of the '<em><b>Ed</b></em>' containment reference list.
   * The list contents are of type {@link org.trc.xtext.dsl.dsl.excludeDependency}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ed</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ed</em>' containment reference list.
   * @see org.trc.xtext.dsl.dsl.DslPackage#getRuleDependency_Ed()
   * @model containment="true"
   * @generated
   */
  EList<excludeDependency> getEd();

} // RuleDependency
