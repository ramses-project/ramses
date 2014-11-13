/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Multiplicity Bounds CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityBoundsCS#getLowerBound <em>Lower Bound</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityBoundsCS#getUpperBound <em>Upper Bound</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getMultiplicityBoundsCS()
 * @model
 * @generated
 */
public interface MultiplicityBoundsCS extends MultiplicityCS
{
  /**
   * Returns the value of the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Lower Bound</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Lower Bound</em>' attribute.
   * @see #setLowerBound(int)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getMultiplicityBoundsCS_LowerBound()
   * @model
   * @generated
   */
  int getLowerBound();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityBoundsCS#getLowerBound <em>Lower Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Lower Bound</em>' attribute.
   * @see #getLowerBound()
   * @generated
   */
  void setLowerBound(int value);

  /**
   * Returns the value of the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Upper Bound</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Upper Bound</em>' attribute.
   * @see #setUpperBound(int)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getMultiplicityBoundsCS_UpperBound()
   * @model
   * @generated
   */
  int getUpperBound();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityBoundsCS#getUpperBound <em>Upper Bound</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Upper Bound</em>' attribute.
   * @see #getUpperBound()
   * @generated
   */
  void setUpperBound(int value);

} // MultiplicityBoundsCS
