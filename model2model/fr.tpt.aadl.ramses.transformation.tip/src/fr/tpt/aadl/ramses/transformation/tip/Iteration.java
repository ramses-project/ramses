/**
 */
package fr.tpt.aadl.ramses.transformation.tip;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Iteration</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.tip.Iteration#getId <em>Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.tip.Iteration#getElements <em>Elements</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.tip.TipPackage#getIteration()
 * @model
 * @generated
 */
public interface Iteration extends EObject {
	/**
	 * Returns the value of the '<em><b>Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Id</em>' attribute.
	 * @see #setId(int)
	 * @see fr.tpt.aadl.ramses.transformation.tip.TipPackage#getIteration_Id()
	 * @model
	 * @generated
	 */
	int getId();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.tip.Iteration#getId <em>Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Id</em>' attribute.
	 * @see #getId()
	 * @generated
	 */
	void setId(int value);

	/**
	 * Returns the value of the '<em><b>Elements</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.tip.ElementTransformation}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Elements</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Elements</em>' containment reference list.
	 * @see fr.tpt.aadl.ramses.transformation.tip.TipPackage#getIteration_Elements()
	 * @model type="fr.tpt.aadl.ramses.transformation.tip.ElementTransformation" containment="true"
	 * @generated
	 */
	EList getElements();

} // Iteration
