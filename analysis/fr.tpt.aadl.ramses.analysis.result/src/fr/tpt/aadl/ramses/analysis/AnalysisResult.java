/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.analysis;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Result</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.AnalysisResult#getResultId <em>Result Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.AnalysisResult#getNfpId <em>Nfp Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.AnalysisResult#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.analysis.AnalysisPackage#getAnalysisResult()
 * @model abstract="true"
 * @generated
 */
public interface AnalysisResult extends EObject {
	/**
	 * Returns the value of the '<em><b>Result Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Result Id</em>' attribute.
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisPackage#getAnalysisResult_ResultId()
	 * @model id="true" required="true" changeable="false"
	 * @generated
	 */
	String getResultId();

	/**
	 * Returns the value of the '<em><b>Nfp Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Nfp Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Nfp Id</em>' attribute.
	 * @see #setNfpId(String)
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisPackage#getAnalysisResult_NfpId()
	 * @model required="true"
	 * @generated
	 */
	String getNfpId();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.analysis.AnalysisResult#getNfpId <em>Nfp Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Nfp Id</em>' attribute.
	 * @see #getNfpId()
	 * @generated
	 */
	void setNfpId(String value);

	/**
	 * Returns the value of the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Source</em>' reference.
	 * @see #setSource(AnalysisSource)
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisPackage#getAnalysisResult_Source()
	 * @model required="true"
	 * @generated
	 */
	AnalysisSource getSource();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.analysis.AnalysisResult#getSource <em>Source</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Source</em>' reference.
	 * @see #getSource()
	 * @generated
	 */
	void setSource(AnalysisSource value);

} // AnalysisResult
