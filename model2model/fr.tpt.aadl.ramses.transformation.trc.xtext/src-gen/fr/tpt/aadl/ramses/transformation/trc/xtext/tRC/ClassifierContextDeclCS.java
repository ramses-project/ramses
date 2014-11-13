/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Classifier Context Decl CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ClassifierContextDeclCS#getSelfName <em>Self Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ClassifierContextDeclCS#getInvariants <em>Invariants</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ClassifierContextDeclCS#getDefinitions <em>Definitions</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getClassifierContextDeclCS()
 * @model
 * @generated
 */
public interface ClassifierContextDeclCS extends oclExpr
{
  /**
   * Returns the value of the '<em><b>Self Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Self Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Self Name</em>' attribute.
   * @see #setSelfName(String)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getClassifierContextDeclCS_SelfName()
   * @model
   * @generated
   */
  String getSelfName();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ClassifierContextDeclCS#getSelfName <em>Self Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Self Name</em>' attribute.
   * @see #getSelfName()
   * @generated
   */
  void setSelfName(String value);

  /**
   * Returns the value of the '<em><b>Invariants</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Invariants</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Invariants</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getClassifierContextDeclCS_Invariants()
   * @model containment="true"
   * @generated
   */
  EList<ConstraintCS> getInvariants();

  /**
   * Returns the value of the '<em><b>Definitions</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefCS}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Definitions</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Definitions</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getClassifierContextDeclCS_Definitions()
   * @model containment="true"
   * @generated
   */
  EList<DefCS> getDefinitions();

} // ClassifierContextDeclCS
