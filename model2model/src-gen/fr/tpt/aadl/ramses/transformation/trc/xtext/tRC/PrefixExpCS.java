/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Prefix Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixExpCS#getOwnedOperator <em>Owned Operator</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixExpCS#getOwnedExpression <em>Owned Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getPrefixExpCS()
 * @model
 * @generated
 */
public interface PrefixExpCS extends PrefixedExpCS, PrefixedExpOrLetExpCS
{
  /**
   * Returns the value of the '<em><b>Owned Operator</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.EssentialOCLPrefixOperator}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Operator</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Operator</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getPrefixExpCS_OwnedOperator()
   * @model containment="true"
   * @generated
   */
  EList<EssentialOCLPrefixOperator> getOwnedOperator();

  /**
   * Returns the value of the '<em><b>Owned Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Expression</em>' containment reference.
   * @see #setOwnedExpression(PrimaryExpOrLetExpCS)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getPrefixExpCS_OwnedExpression()
   * @model containment="true"
   * @generated
   */
  PrimaryExpOrLetExpCS getOwnedExpression();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixExpCS#getOwnedExpression <em>Owned Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owned Expression</em>' containment reference.
   * @see #getOwnedExpression()
   * @generated
   */
  void setOwnedExpression(PrimaryExpOrLetExpCS value);

} // PrefixExpCS
