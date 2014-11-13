/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Constraint CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS#getName <em>Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS#getMessageSpecification <em>Message Specification</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getConstraintCS()
 * @model
 * @generated
 */
public interface ConstraintCS extends EObject
{
  /**
   * Returns the value of the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Name</em>' attribute.
   * @see #setName(String)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getConstraintCS_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Message Specification</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Message Specification</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Message Specification</em>' containment reference.
   * @see #setMessageSpecification(SpecificationCS)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getConstraintCS_MessageSpecification()
   * @model containment="true"
   * @generated
   */
  SpecificationCS getMessageSpecification();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS#getMessageSpecification <em>Message Specification</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Message Specification</em>' containment reference.
   * @see #getMessageSpecification()
   * @generated
   */
  void setMessageSpecification(SpecificationCS value);

  /**
   * Returns the value of the '<em><b>Specification</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Specification</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Specification</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getConstraintCS_Specification()
   * @model containment="true"
   * @generated
   */
  EList<SpecificationCS> getSpecification();

} // ConstraintCS
