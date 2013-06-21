/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.analysis;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Quantitative Analysis Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.QuantitativeAnalysisResult#getEvalValue <em>Eval Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.analysis.AnalysisPackage#getQuantitativeAnalysisResult()
 * @model
 * @generated
 */
public interface QuantitativeAnalysisResult extends AnalysisResult {
	/**
	 * Returns the value of the '<em><b>Eval Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eval Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eval Value</em>' attribute.
	 * @see #setEvalValue(float)
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisPackage#getQuantitativeAnalysisResult_EvalValue()
	 * @model
	 * @generated
	 */
	float getEvalValue();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.analysis.QuantitativeAnalysisResult#getEvalValue <em>Eval Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eval Value</em>' attribute.
	 * @see #getEvalValue()
	 * @generated
	 */
	void setEvalValue(float value);

} // QuantitativeAnalysisResult
