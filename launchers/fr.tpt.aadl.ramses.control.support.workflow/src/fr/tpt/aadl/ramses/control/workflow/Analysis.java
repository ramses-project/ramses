/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.control.workflow;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Analysis#getMethod <em>Method</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Analysis#getMode <em>Mode</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Analysis#getYesOption <em>Yes Option</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Analysis#getInputModelIdentifier <em>Input Model Identifier</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Analysis#getNoOption <em>No Option</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getAnalysis()
 * @model
 * @generated
 */
public interface Analysis extends WorkflowElement, AnalysisElement {
	/**
	 * Returns the value of the '<em><b>Method</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Method</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Method</em>' attribute.
	 * @see #setMethod(String)
	 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getAnalysis_Method()
	 * @model
	 * @generated
	 */
	String getMethod();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.Analysis#getMethod <em>Method</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Method</em>' attribute.
	 * @see #getMethod()
	 * @generated
	 */
	void setMethod(String value);

	/**
	 * Returns the value of the '<em><b>Mode</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Mode</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Mode</em>' attribute.
	 * @see #setMode(String)
	 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getAnalysis_Mode()
	 * @model
	 * @generated
	 */
	String getMode();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.Analysis#getMode <em>Mode</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Mode</em>' attribute.
	 * @see #getMode()
	 * @generated
	 */
	void setMode(String value);

	/**
	 * Returns the value of the '<em><b>Yes Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Yes Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Yes Option</em>' containment reference.
	 * @see #setYesOption(AnalysisOption)
	 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getAnalysis_YesOption()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AnalysisOption getYesOption();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.Analysis#getYesOption <em>Yes Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Yes Option</em>' containment reference.
	 * @see #getYesOption()
	 * @generated
	 */
	void setYesOption(AnalysisOption value);

	/**
	 * Returns the value of the '<em><b>Input Model Identifier</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Input Model Identifier</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Input Model Identifier</em>' reference.
	 * @see #setInputModelIdentifier(ModelIdentifier)
	 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getAnalysis_InputModelIdentifier()
	 * @model
	 * @generated
	 */
	ModelIdentifier getInputModelIdentifier();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.Analysis#getInputModelIdentifier <em>Input Model Identifier</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Input Model Identifier</em>' reference.
	 * @see #getInputModelIdentifier()
	 * @generated
	 */
	void setInputModelIdentifier(ModelIdentifier value);

	/**
	 * Returns the value of the '<em><b>No Option</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>No Option</em>' containment reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>No Option</em>' containment reference.
	 * @see #setNoOption(AnalysisOption)
	 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getAnalysis_NoOption()
	 * @model containment="true" required="true"
	 * @generated
	 */
	AnalysisOption getNoOption();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.Analysis#getNoOption <em>No Option</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>No Option</em>' containment reference.
	 * @see #getNoOption()
	 * @generated
	 */
	void setNoOption(AnalysisOption value);

} // Analysis
