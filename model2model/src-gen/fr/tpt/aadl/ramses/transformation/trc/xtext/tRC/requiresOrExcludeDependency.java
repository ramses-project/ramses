/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>requires Or Exclude Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency#getRequiredTransformation <em>Required Transformation</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency#getRequiredRule <em>Required Rule</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency#getFields <em>Fields</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency#getOclExpression <em>Ocl Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getrequiresOrExcludeDependency()
 * @model
 * @generated
 */
public interface requiresOrExcludeDependency extends EObject
{
  /**
   * Returns the value of the '<em><b>Required Transformation</b></em>' reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Transformation</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Required Transformation</em>' reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getrequiresOrExcludeDependency_RequiredTransformation()
   * @model
   * @generated
   */
  EList<Transformation> getRequiredTransformation();

  /**
   * Returns the value of the '<em><b>Required Rule</b></em>' reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.trcRule}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Rule</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Required Rule</em>' reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getrequiresOrExcludeDependency_RequiredRule()
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
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getrequiresOrExcludeDependency_Fields()
   * @model
   * @generated
   */
  String getFields();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency#getFields <em>Fields</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Fields</em>' attribute.
   * @see #getFields()
   * @generated
   */
  void setFields(String value);

  /**
   * Returns the value of the '<em><b>Ocl Expression</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.oclExpr}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Ocl Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Ocl Expression</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getrequiresOrExcludeDependency_OclExpression()
   * @model containment="true"
   * @generated
   */
  EList<oclExpr> getOclExpression();

} // requiresOrExcludeDependency
