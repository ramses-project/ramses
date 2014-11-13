/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Name Exp CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameExpCS#getPathName <em>Path Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameExpCS#isAtPre <em>At Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getNameExpCS()
 * @model
 * @generated
 */
public interface NameExpCS extends PrimaryExpCS
{
  /**
   * Returns the value of the '<em><b>Path Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path Name</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path Name</em>' containment reference.
   * @see #setPathName(PathNameCS)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getNameExpCS_PathName()
   * @model containment="true"
   * @generated
   */
  PathNameCS getPathName();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameExpCS#getPathName <em>Path Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path Name</em>' containment reference.
   * @see #getPathName()
   * @generated
   */
  void setPathName(PathNameCS value);

  /**
   * Returns the value of the '<em><b>At Pre</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>At Pre</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>At Pre</em>' attribute.
   * @see #setAtPre(boolean)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getNameExpCS_AtPre()
   * @model
   * @generated
   */
  boolean isAtPre();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameExpCS#isAtPre <em>At Pre</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>At Pre</em>' attribute.
   * @see #isAtPre()
   * @generated
   */
  void setAtPre(boolean value);

} // NameExpCS
