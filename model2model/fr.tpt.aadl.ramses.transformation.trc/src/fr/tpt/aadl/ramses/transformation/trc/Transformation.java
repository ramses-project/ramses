/**
 */
package fr.tpt.aadl.ramses.transformation.trc;

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
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.Transformation#getImpacts <em>Impacts</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.Transformation#getModules <em>Modules</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.Transformation#getRuleName <em>Rule Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.Transformation#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTransformation()
 * @model
 * @generated
 */
public interface Transformation extends EObject
{
  /**
	 * Returns the value of the '<em><b>Impacts</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.TransformationImpact}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Impacts</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Impacts</em>' containment reference list.
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTransformation_Impacts()
	 * @model containment="true"
	 * @generated
	 */
  EList<TransformationImpact> getImpacts();

  /**
	 * Returns the value of the '<em><b>Modules</b></em>' reference list.
	 * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.Module}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Modules</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Modules</em>' reference list.
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTransformation_Modules()
	 * @model required="true"
	 * @generated
	 */
  EList<Module> getModules();

  /**
	 * Returns the value of the '<em><b>Rule Name</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Rule Name</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Rule Name</em>' attribute list.
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTransformation_RuleName()
	 * @model
	 * @generated
	 */
  EList<String> getRuleName();

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
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTransformation_Name()
	 * @model required="true"
	 * @generated
	 */
  String getName();

  /**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.Transformation#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
  void setName(String value);

} // Transformation
