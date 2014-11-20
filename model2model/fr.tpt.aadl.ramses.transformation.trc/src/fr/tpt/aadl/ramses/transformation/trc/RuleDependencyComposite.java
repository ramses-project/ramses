/**
 */
package fr.tpt.aadl.ramses.transformation.trc;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Dependency Composite</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependencyComposite#getRequiredTransformations <em>Required Transformations</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getRuleDependencyComposite()
 * @model abstract="true"
 * @generated
 */
public interface RuleDependencyComposite extends AbstractRuleDependency
{
  /**
	 * Returns the value of the '<em><b>Required Transformations</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.AbstractRuleDependency}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Transformations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Transformations</em>' containment reference list.
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getRuleDependencyComposite_RequiredTransformations()
	 * @model containment="true" required="true"
	 * @generated
	 */
  EList<AbstractRuleDependency> getRequiredTransformations();

} // RuleDependencyComposite
