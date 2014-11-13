/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Nested Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NestedExpCS#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getNestedExpCS()
 * @model
 * @generated
 */
public interface NestedExpCS extends PrimaryExpCS
{
  /**
   * Returns the value of the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' containment reference.
   * @see #setSource(ExpressCS)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getNestedExpCS_Source()
   * @model containment="true"
   * @generated
   */
  ExpressCS getSource();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NestedExpCS#getSource <em>Source</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' containment reference.
   * @see #getSource()
   * @generated
   */
  void setSource(ExpressCS value);

} // NestedExpCS
