/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

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
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency#getKw <em>Kw</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency#getRed <em>Red</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency#getBoolOP <em>Bool OP</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getRuleDependency()
 * @model
 * @generated
 */
public interface RuleDependency extends EObject
{
  /**
   * Returns the value of the '<em><b>Kw</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Kw</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Kw</em>' containment reference.
   * @see #setKw(KeyWord)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getRuleDependency_Kw()
   * @model containment="true"
   * @generated
   */
  KeyWord getKw();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency#getKw <em>Kw</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Kw</em>' containment reference.
   * @see #getKw()
   * @generated
   */
  void setKw(KeyWord value);

  /**
   * Returns the value of the '<em><b>Red</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Red</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Red</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getRuleDependency_Red()
   * @model containment="true"
   * @generated
   */
  EList<requiresOrExcludeDependency> getRed();

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
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getRuleDependency_BoolOP()
   * @model containment="true"
   * @generated
   */
  BooleanOperations getBoolOP();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency#getBoolOP <em>Bool OP</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Bool OP</em>' containment reference.
   * @see #getBoolOP()
   * @generated
   */
  void setBoolOP(BooleanOperations value);

} // RuleDependency
