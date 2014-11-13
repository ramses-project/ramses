/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Operation Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getPathName <em>Path Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getParameters <em>Parameters</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getPreconditions <em>Preconditions</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getPostconditions <em>Postconditions</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getBodies <em>Bodies</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getOperationContextDeclCS()
 * @model
 * @generated
 */
public interface OperationContextDeclCS extends EObject
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
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getOperationContextDeclCS_PathName()
   * @model containment="true"
   * @generated
   */
  PathNameCS getPathName();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getPathName <em>Path Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Path Name</em>' containment reference.
   * @see #getPathName()
   * @generated
   */
  void setPathName(PathNameCS value);

  /**
   * Returns the value of the '<em><b>Parameters</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ParameterCS}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Parameters</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Parameters</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getOperationContextDeclCS_Parameters()
   * @model containment="true"
   * @generated
   */
  EList<ParameterCS> getParameters();

  /**
   * Returns the value of the '<em><b>Owned Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Type</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Type</em>' containment reference.
   * @see #setOwnedType(TypedRefCS)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getOperationContextDeclCS_OwnedType()
   * @model containment="true"
   * @generated
   */
  TypedRefCS getOwnedType();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getOwnedType <em>Owned Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Owned Type</em>' containment reference.
   * @see #getOwnedType()
   * @generated
   */
  void setOwnedType(TypedRefCS value);

  /**
   * Returns the value of the '<em><b>Preconditions</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Preconditions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Preconditions</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getOperationContextDeclCS_Preconditions()
   * @model containment="true"
   * @generated
   */
  EList<ConstraintCS> getPreconditions();

  /**
   * Returns the value of the '<em><b>Postconditions</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Postconditions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Postconditions</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getOperationContextDeclCS_Postconditions()
   * @model containment="true"
   * @generated
   */
  EList<ConstraintCS> getPostconditions();

  /**
   * Returns the value of the '<em><b>Bodies</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Bodies</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Bodies</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getOperationContextDeclCS_Bodies()
   * @model containment="true"
   * @generated
   */
  EList<SpecificationCS> getBodies();

} // OperationContextDeclCS
