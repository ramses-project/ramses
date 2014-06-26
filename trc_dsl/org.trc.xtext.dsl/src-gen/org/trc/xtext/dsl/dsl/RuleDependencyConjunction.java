/**
 */
package org.trc.xtext.dsl.dsl;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Dependency Conjunction</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link org.trc.xtext.dsl.dsl.RuleDependencyConjunction#getRequiredTransformations <em>Required Transformations</em>}</li>
 * </ul>
 * </p>
 *
 * @see org.trc.xtext.dsl.dsl.DslPackage#getRuleDependencyConjunction()
 * @model
 * @generated
 */
public interface RuleDependencyConjunction extends EObject
{
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
   * @see org.trc.xtext.dsl.dsl.DslPackage#getRuleDependencyConjunction_RequiredTransformations()
   * @model containment="true"
   * @generated
   */
  EList<AbstractRuleDependency> getRequiredTransformations();

} // RuleDependencyConjunction
