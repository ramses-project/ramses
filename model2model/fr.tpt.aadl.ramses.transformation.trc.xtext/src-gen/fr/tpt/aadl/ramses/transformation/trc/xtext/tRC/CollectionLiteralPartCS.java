/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Collection Literal Part CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralPartCS#getExpressionCS <em>Expression CS</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralPartCS#getLastExpressionCS <em>Last Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getCollectionLiteralPartCS()
 * @model
 * @generated
 */
public interface CollectionLiteralPartCS extends EObject
{
  /**
   * Returns the value of the '<em><b>Expression CS</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Expression CS</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Expression CS</em>' containment reference.
   * @see #setExpressionCS(ExpressCS)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getCollectionLiteralPartCS_ExpressionCS()
   * @model containment="true"
   * @generated
   */
  ExpressCS getExpressionCS();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralPartCS#getExpressionCS <em>Expression CS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Expression CS</em>' containment reference.
   * @see #getExpressionCS()
   * @generated
   */
  void setExpressionCS(ExpressCS value);

  /**
   * Returns the value of the '<em><b>Last Expression CS</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Last Expression CS</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Last Expression CS</em>' containment reference.
   * @see #setLastExpressionCS(ExpressCS)
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getCollectionLiteralPartCS_LastExpressionCS()
   * @model containment="true"
   * @generated
   */
  ExpressCS getLastExpressionCS();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralPartCS#getLastExpressionCS <em>Last Expression CS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Last Expression CS</em>' containment reference.
   * @see #getLastExpressionCS()
   * @generated
   */
  void setLastExpressionCS(ExpressCS value);

} // CollectionLiteralPartCS
