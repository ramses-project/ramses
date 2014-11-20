/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Trc Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TrcSpecification#getModuleList <em>Module List</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TrcSpecification#getTransformationList <em>Transformation List</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TrcSpecification#getDependencyList <em>Dependency List</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTrcSpecification()
 * @model
 * @generated
 */
public interface TrcSpecification extends EObject
{
  /**
   * Returns the value of the '<em><b>Module List</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ModuleList}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Module List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Module List</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTrcSpecification_ModuleList()
   * @model containment="true"
   * @generated
   */
  EList<ModuleList> getModuleList();

  /**
   * Returns the value of the '<em><b>Transformation List</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationList}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transformation List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transformation List</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTrcSpecification_TransformationList()
   * @model containment="true"
   * @generated
   */
  EList<TransformationList> getTransformationList();

  /**
   * Returns the value of the '<em><b>Dependency List</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependencyList}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dependency List</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dependency List</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTrcSpecification_DependencyList()
   * @model containment="true"
   * @generated
   */
  EList<TransformationDependencyList> getDependencyList();

} // TrcSpecification
