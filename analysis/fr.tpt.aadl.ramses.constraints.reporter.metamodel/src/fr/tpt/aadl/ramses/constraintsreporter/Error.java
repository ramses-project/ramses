/**
 */
package fr.tpt.aadl.ramses.constraintsreporter;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Error</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.constraintsreporter.Error#getMessage <em>Message</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.constraintsreporter.Error#getObject <em>Object</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.constraintsreporter.reporterPackage#getError()
 * @model
 * @generated
 */
public interface Error extends EObject {
	/**
	 * Returns the value of the '<em><b>Message</b></em>' attribute.
	 * The default value is <code>""</code>.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Message</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Message</em>' attribute.
	 * @see #setMessage(String)
	 * @see fr.tpt.aadl.ramses.constraintsreporter.reporterPackage#getError_Message()
	 * @model default=""
	 * @generated
	 */
	String getMessage();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.constraintsreporter.Error#getMessage <em>Message</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Message</em>' attribute.
	 * @see #getMessage()
	 * @generated
	 */
	void setMessage(String value);

	/**
	 * Returns the value of the '<em><b>Object</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Object</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Object</em>' reference.
	 * @see #setObject(EObject)
	 * @see fr.tpt.aadl.ramses.constraintsreporter.reporterPackage#getError_Object()
	 * @model
	 * @generated
	 */
	EObject getObject();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.constraintsreporter.Error#getObject <em>Object</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Object</em>' reference.
	 * @see #getObject()
	 * @generated
	 */
	void setObject(EObject value);

} // Error
