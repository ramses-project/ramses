/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Big Number</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BigNumber#getNumber <em>Number</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getBigNumber()
 * @model
 * @generated
 */
public interface BigNumber extends EObject
{
  /**
   * Returns the value of the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Number</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Number</em>' attribute.
   * @see #setNumber(int)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getBigNumber_Number()
   * @model
   * @generated
   */
  int getNumber();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BigNumber#getNumber <em>Number</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Number</em>' attribute.
   * @see #getNumber()
   * @generated
   */
  void setNumber(int value);

} // BigNumber
