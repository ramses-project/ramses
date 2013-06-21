/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.analysis;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Qualitative Analysis Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult#isEvalValue <em>Eval Value</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.analysis.AnalysisPackage#getQualitativeAnalysisResult()
 * @model
 * @generated
 */
public interface QualitativeAnalysisResult extends AnalysisResult {
	/**
	 * Returns the value of the '<em><b>Eval Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Eval Value</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Eval Value</em>' attribute.
	 * @see #setEvalValue(boolean)
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisPackage#getQualitativeAnalysisResult_EvalValue()
	 * @model
	 * @generated
	 */
	boolean isEvalValue();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult#isEvalValue <em>Eval Value</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Eval Value</em>' attribute.
	 * @see #isEvalValue()
	 * @generated
	 */
	void setEvalValue(boolean value);

} // QualitativeAnalysisResult
