/**
 */
package fr.tpt.aadl.ramses.transformation.trc;

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
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependency#getVariableId <em>Variable Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependency#getAppliedTransformation <em>Applied Transformation</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependency#getRequiredTransformations <em>Required Transformations</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependency#getAppliedRule <em>Applied Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTransformationDependency()
 * @model
 * @generated
 */
public interface TransformationDependency extends EObject
{
  /**
	 * Returns the value of the '<em><b>Variable Id</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable Id</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Id</em>' attribute list.
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTransformationDependency_VariableId()
	 * @model required="true"
	 * @generated
	 */
  EList<String> getVariableId();

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
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTransformationDependency_AppliedTransformation()
	 * @model required="true"
	 * @generated
	 */
  Transformation getAppliedTransformation();

  /**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependency#getAppliedTransformation <em>Applied Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applied Transformation</em>' reference.
	 * @see #getAppliedTransformation()
	 * @generated
	 */
  void setAppliedTransformation(Transformation value);

  /**
	 * Returns the value of the '<em><b>Required Transformations</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Transformations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Transformations</em>' containment reference.
	 * @see #setRequiredTransformations(AbstractRuleDependency)
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTransformationDependency_RequiredTransformations()
	 * @model containment="true" required="true"
	 * @generated
	 */
  AbstractRuleDependency getRequiredTransformations();

  /**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependency#getRequiredTransformations <em>Required Transformations</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Transformations</em>' containment reference.
	 * @see #getRequiredTransformations()
	 * @generated
	 */
	void setRequiredTransformations(AbstractRuleDependency value);

		/**
	 * Returns the value of the '<em><b>Applied Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Applied Rule</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Applied Rule</em>' reference.
	 * @see #setAppliedRule(TrcRule)
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTransformationDependency_AppliedRule()
	 * @model
	 * @generated
	 */
  TrcRule getAppliedRule();

  /**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependency#getAppliedRule <em>Applied Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Applied Rule</em>' reference.
	 * @see #getAppliedRule()
	 * @generated
	 */
	void setAppliedRule(TrcRule value);

} // TransformationDependency
