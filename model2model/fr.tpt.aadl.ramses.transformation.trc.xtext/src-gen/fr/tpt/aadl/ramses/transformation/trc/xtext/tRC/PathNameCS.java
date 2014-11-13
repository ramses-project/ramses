/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Path Name CS</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathNameCS#getPath <em>Path</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getPathNameCS()
 * @model
 * @generated
 */
public interface PathNameCS extends EObject
{
  /**
   * Returns the value of the '<em><b>Path</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathElementCS}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Path</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Path</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getPathNameCS_Path()
   * @model containment="true"
   * @generated
   */
  EList<PathElementCS> getPath();

} // PathNameCS
