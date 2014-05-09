/**
 */
package fr.tpt.aadl.ramses.transformation.trc;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation Dependency List</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependencyList#getTransformationDependencies <em>Transformation Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTransformationDependencyList()
 * @model
 * @generated
 */
public interface TransformationDependencyList extends EObject
{
  /**
   * Returns the value of the '<em><b>Transformation Dependencies</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependency}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transformation Dependencies</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transformation Dependencies</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTransformationDependencyList_TransformationDependencies()
   * @model containment="true" required="true"
   * @generated
   */
  EList<TransformationDependency> getTransformationDependencies();

} // TransformationDependencyList
