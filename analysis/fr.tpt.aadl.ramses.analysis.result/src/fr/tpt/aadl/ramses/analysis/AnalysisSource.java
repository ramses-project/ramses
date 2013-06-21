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
 * A representation of the model object '<em><b>Source</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.AnalysisSource#getIterationId <em>Iteration Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.AnalysisSource#getScope <em>Scope</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.analysis.AnalysisPackage#getAnalysisSource()
 * @model
 * @generated
 */
public interface AnalysisSource extends EObject {
	/**
	 * Returns the value of the '<em><b>Iteration Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Iteration Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Iteration Id</em>' attribute.
	 * @see #setIterationId(int)
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisPackage#getAnalysisSource_IterationId()
	 * @model
	 * @generated
	 */
	int getIterationId();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.analysis.AnalysisSource#getIterationId <em>Iteration Id</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Iteration Id</em>' attribute.
	 * @see #getIterationId()
	 * @generated
	 */
	void setIterationId(int value);

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Scope</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' attribute.
	 * @see #setScope(String)
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisPackage#getAnalysisSource_Scope()
	 * @model
	 * @generated
	 */
	String getScope();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.analysis.AnalysisSource#getScope <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' attribute.
	 * @see #getScope()
	 * @generated
	 */
	void setScope(String value);

} // AnalysisSource
