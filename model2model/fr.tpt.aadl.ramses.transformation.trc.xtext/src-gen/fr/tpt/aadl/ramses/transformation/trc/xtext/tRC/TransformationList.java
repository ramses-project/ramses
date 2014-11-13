/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationList#getTransformations <em>Transformations</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTransformationList()
 * @model
 * @generated
 */
public interface TransformationList extends EObject
{
  /**
   * Returns the value of the '<em><b>Transformations</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transformations</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transformations</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTransformationList_Transformations()
   * @model containment="true"
   * @generated
   */
  EList<Transformation> getTransformations();

} // TransformationList
