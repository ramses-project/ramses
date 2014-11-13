/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation#getName <em>Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation#getModules <em>Modules</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation#getImpacts <em>Impacts</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTransformation()
 * @model
 * @generated
 */
public interface Transformation extends EObject
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
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTransformation_Name()
   * @model
   * @generated
   */
  String getName();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation#getName <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Name</em>' attribute.
   * @see #getName()
   * @generated
   */
  void setName(String value);

  /**
   * Returns the value of the '<em><b>Modules</b></em>' reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Module}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modules</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Modules</em>' reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTransformation_Modules()
   * @model
   * @generated
   */
  EList<Module> getModules();

  /**
   * Returns the value of the '<em><b>Impacts</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationImpact}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Impacts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Impacts</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#getTransformation_Impacts()
   * @model containment="true"
   * @generated
   */
  EList<TransformationImpact> getImpacts();

} // Transformation
