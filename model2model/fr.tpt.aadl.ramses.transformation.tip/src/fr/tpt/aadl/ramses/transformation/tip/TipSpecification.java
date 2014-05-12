/**
 */
package fr.tpt.aadl.ramses.transformation.tip;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.impl.DynamicEObjectImpl;
import org.osate.aadl2.NamedElement;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.tip.TipSpecification#getIterations <em>Iterations</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.tip.TipSpecification#getProjectName <em>Project Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.tip.TipSpecification#getVersion <em>Version</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.tip.TipPackage#getTipSpecification()
 * @model
 * @generated
 */
public interface TipSpecification extends EObject {
	/**
	 * Returns the value of the '<em><b>Iterations</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.tip.Iteration}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iterations</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iterations</em>' containment reference list.
	 * @see fr.tpt.aadl.ramses.transformation.tip.TipPackage#getTipSpecification_Iterations()
	 * @model type="fr.tpt.aadl.ramses.transformation.tip.Iteration" containment="true"
	 * @generated
	 */
	EList getIterations();

	/**
	 * Returns the value of the '<em><b>Project Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Project Name</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Project Name</em>' attribute.
	 * @see #setProjectName(String)
	 * @see fr.tpt.aadl.ramses.transformation.tip.TipPackage#getTipSpecification_ProjectName()
	 * @model
	 * @generated
	 */
	String getProjectName();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.tip.TipSpecification#getProjectName <em>Project Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Project Name</em>' attribute.
	 * @see #getProjectName()
	 * @generated
	 */
	void setProjectName(String value);

	/**
	 * Returns the value of the '<em><b>Version</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Version</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Version</em>' attribute.
	 * @see #setVersion(String)
	 * @see fr.tpt.aadl.ramses.transformation.tip.TipPackage#getTipSpecification_Version()
	 * @model
	 * @generated
	 */
	String getVersion();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.tip.TipSpecification#getVersion <em>Version</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Version</em>' attribute.
	 * @see #getVersion()
	 * @generated
	 */
	void setVersion(String value);

} // TipSpecification
