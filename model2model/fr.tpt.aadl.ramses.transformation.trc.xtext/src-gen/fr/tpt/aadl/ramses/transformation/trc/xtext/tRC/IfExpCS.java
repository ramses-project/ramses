/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>If Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS#getCondition <em>Condition</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS#getThenExpression <em>Then Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS#getElseExpression <em>Else Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getIfExpCS()
 * @model
 * @generated
 */
public interface IfExpCS extends PrimaryExpCS
{
  /**
   * Returns the value of the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Condition</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Condition</em>' containment reference.
   * @see #setCondition(ExpressCS)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getIfExpCS_Condition()
   * @model containment="true"
   * @generated
   */
  ExpressCS getCondition();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS#getCondition <em>Condition</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Condition</em>' containment reference.
   * @see #getCondition()
   * @generated
   */
  void setCondition(ExpressCS value);

  /**
   * Returns the value of the '<em><b>Then Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Then Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Then Expression</em>' containment reference.
   * @see #setThenExpression(ExpressCS)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getIfExpCS_ThenExpression()
   * @model containment="true"
   * @generated
   */
  ExpressCS getThenExpression();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS#getThenExpression <em>Then Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Then Expression</em>' containment reference.
   * @see #getThenExpression()
   * @generated
   */
  void setThenExpression(ExpressCS value);

  /**
   * Returns the value of the '<em><b>Else Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Else Expression</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Else Expression</em>' containment reference.
   * @see #setElseExpression(ExpressCS)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getIfExpCS_ElseExpression()
   * @model containment="true"
   * @generated
   */
  ExpressCS getElseExpression();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS#getElseExpression <em>Else Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Else Expression</em>' containment reference.
   * @see #getElseExpression()
   * @generated
   */
  void setElseExpression(ExpressCS value);

} // IfExpCS
