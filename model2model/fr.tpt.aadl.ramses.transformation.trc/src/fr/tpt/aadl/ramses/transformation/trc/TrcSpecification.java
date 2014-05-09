/**
 */
package fr.tpt.aadl.ramses.transformation.trc;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.TrcSpecification#getTransformations <em>Transformations</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.TrcSpecification#getDependencies <em>Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTrcSpecification()
 * @model
 * @generated
 */
public interface TrcSpecification extends EObject
{
  /**
   * Returns the value of the '<em><b>Transformations</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transformations</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transformations</em>' containment reference.
   * @see #setTransformations(TransformationList)
   * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTrcSpecification_Transformations()
   * @model containment="true" required="true"
   * @generated
   */
  TransformationList getTransformations();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.TrcSpecification#getTransformations <em>Transformations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transformations</em>' containment reference.
   * @see #getTransformations()
   * @generated
   */
  void setTransformations(TransformationList value);

  /**
   * Returns the value of the '<em><b>Dependencies</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dependencies</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Dependencies</em>' containment reference.
   * @see #setDependencies(TransformationDependencyList)
   * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTrcSpecification_Dependencies()
   * @model containment="true" required="true"
   * @generated
   */
  TransformationDependencyList getDependencies();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.TrcSpecification#getDependencies <em>Dependencies</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Dependencies</em>' containment reference.
   * @see #getDependencies()
   * @generated
   */
  void setDependencies(TransformationDependencyList value);

} // TrcSpecification
