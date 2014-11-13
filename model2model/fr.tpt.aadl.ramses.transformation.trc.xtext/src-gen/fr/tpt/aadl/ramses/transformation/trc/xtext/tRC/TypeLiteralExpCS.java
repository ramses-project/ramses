/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Type Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralExpCS#getOwnedType <em>Owned Type</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTypeLiteralExpCS()
 * @model
 * @generated
 */
public interface TypeLiteralExpCS extends PrimaryExpCS
{
  /**
   * Returns the value of the '<em><b>Owned Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Type</em>' containment reference.
   * @see #setOwnedType(TypeLiteralWithMultiplicityCS)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTypeLiteralExpCS_OwnedType()
   * @model containment="true"
   * @generated
   */
  TypeLiteralWithMultiplicityCS getOwnedType();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralExpCS#getOwnedType <em>Owned Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owned Type</em>' containment reference.
   * @see #getOwnedType()
   * @generated
   */
  void setOwnedType(TypeLiteralWithMultiplicityCS value);

} // TypeLiteralExpCS
