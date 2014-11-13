/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Context Cs</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs#getB <em>B</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs#getBO <em>BO</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getContextCs()
 * @model
 * @generated
 */
public interface ContextCs extends EObject
{
  /**
   * Returns the value of the '<em><b>Owned Expression</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetExpCS}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Expression</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getContextCs_OwnedExpression()
   * @model containment="true"
   * @generated
   */
  EList<LetExpCS> getOwnedExpression();

  /**
   * Returns the value of the '<em><b>B</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>B</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>B</em>' containment reference.
   * @see #setB(BinaryOperatorCS)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getContextCs_B()
   * @model containment="true"
   * @generated
   */
  BinaryOperatorCS getB();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs#getB <em>B</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>B</em>' containment reference.
   * @see #getB()
   * @generated
   */
  void setB(BinaryOperatorCS value);

  /**
   * Returns the value of the '<em><b>BO</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>BO</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>BO</em>' containment reference.
   * @see #setBO(BinaryOperatorCS)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getContextCs_BO()
   * @model containment="true"
   * @generated
   */
  BinaryOperatorCS getBO();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs#getBO <em>BO</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>BO</em>' containment reference.
   * @see #getBO()
   * @generated
   */
  void setBO(BinaryOperatorCS value);

} // ContextCs
