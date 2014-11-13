/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

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
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getAppliedTransformation <em>Applied Transformation</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getAppliedRule <em>Applied Rule</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getFields <em>Fields</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getRequiredTransformations <em>Required Transformations</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getBoolOP <em>Bool OP</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTransformationDependency()
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
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTransformationDependency_AppliedTransformation()
   * @model
   * @generated
   */
  Transformation getAppliedTransformation();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getAppliedTransformation <em>Applied Transformation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Applied Transformation</em>' reference.
   * @see #getAppliedTransformation()
   * @generated
   */
  void setAppliedTransformation(Transformation value);

  /**
   * Returns the value of the '<em><b>Applied Rule</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Applied Rule</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Applied Rule</em>' reference.
   * @see #setAppliedRule(trcRule)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTransformationDependency_AppliedRule()
   * @model
   * @generated
   */
  trcRule getAppliedRule();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getAppliedRule <em>Applied Rule</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Applied Rule</em>' reference.
   * @see #getAppliedRule()
   * @generated
   */
  void setAppliedRule(trcRule value);

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
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTransformationDependency_Fields()
   * @model unique="false"
   * @generated
   */
  EList<String> getFields();

  /**
   * Returns the value of the '<em><b>Required Transformations</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Transformations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Required Transformations</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTransformationDependency_RequiredTransformations()
   * @model containment="true"
   * @generated
   */
  EList<RuleDependency> getRequiredTransformations();

  /**
   * Returns the value of the '<em><b>Bool OP</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bool OP</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bool OP</em>' containment reference.
   * @see #setBoolOP(BooleanOperations)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTransformationDependency_BoolOP()
   * @model containment="true"
   * @generated
   */
  BooleanOperations getBoolOP();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getBoolOP <em>Bool OP</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bool OP</em>' containment reference.
   * @see #getBoolOP()
   * @generated
   */
  void setBoolOP(BooleanOperations value);

} // TransformationDependency
