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
 *   <li>{@link fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult#isValidated <em>Validated</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.analysis.AnalysisResultPackage#getQualitativeAnalysisResult()
 * @model
 * @generated
 */
public interface QualitativeAnalysisResult extends AnalysisResult {
	/**
	 * Returns the value of the '<em><b>Validated</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Validated</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Validated</em>' attribute.
	 * @see #setValidated(boolean)
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisResultPackage#getQualitativeAnalysisResult_Validated()
	 * @model
	 * @generated
	 */
	boolean isValidated();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult#isValidated <em>Validated</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Validated</em>' attribute.
	 * @see #isValidated()
	 * @generated
	 */
	void setValidated(boolean value);

} // QualitativeAnalysisResult
