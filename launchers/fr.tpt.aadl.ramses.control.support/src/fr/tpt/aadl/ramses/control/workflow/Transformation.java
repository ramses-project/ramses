/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.control.workflow;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Transformation#getElement <em>Element</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Transformation#getList <em>List</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Transformation#getOutputModelIdentifier <em>Output Model Identifier</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getTransformation()
 * @model
 * @generated
 */
public interface Transformation extends WorkflowElement, AnalysisElement {
	/**
   * Returns the value of the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Element</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Element</em>' containment reference.
   * @see #setElement(AnalysisElement)
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getTransformation_Element()
   * @model containment="true" required="true"
   * @generated
   */
	AnalysisElement getElement();

	/**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.Transformation#getElement <em>Element</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Element</em>' containment reference.
   * @see #getElement()
   * @generated
   */
	void setElement(AnalysisElement value);

	/**
   * Returns the value of the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>List</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>List</em>' containment reference.
   * @see #setList(List)
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getTransformation_List()
   * @model containment="true" required="true"
   * @generated
   */
	List getList();

	/**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.Transformation#getList <em>List</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>List</em>' containment reference.
   * @see #getList()
   * @generated
   */
	void setList(List value);

	/**
   * Returns the value of the '<em><b>Output Model Identifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Output Model Identifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Output Model Identifier</em>' containment reference.
   * @see #setOutputModelIdentifier(ModelIdentifier)
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getTransformation_OutputModelIdentifier()
   * @model containment="true"
   * @generated
   */
	ModelIdentifier getOutputModelIdentifier();

	/**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.Transformation#getOutputModelIdentifier <em>Output Model Identifier</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Output Model Identifier</em>' containment reference.
   * @see #getOutputModelIdentifier()
   * @generated
   */
	void setOutputModelIdentifier(ModelIdentifier value);

} // Transformation
