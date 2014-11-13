/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS#getExprString <em>Expr String</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getSpecificationCS()
 * @model
 * @generated
 */
public interface SpecificationCS extends EObject
{
  /**
   * Returns the value of the '<em><b>Owned Expression</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Owned Expression</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Owned Expression</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getSpecificationCS_OwnedExpression()
   * @model containment="true"
   * @generated
   */
  EList<ContextCs> getOwnedExpression();

  /**
   * Returns the value of the '<em><b>Expr String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expr String</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expr String</em>' attribute.
   * @see #setExprString(String)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getSpecificationCS_ExprString()
   * @model
   * @generated
   */
  String getExprString();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS#getExprString <em>Expr String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expr String</em>' attribute.
   * @see #getExprString()
   * @generated
   */
  void setExprString(String value);

} // SpecificationCS
