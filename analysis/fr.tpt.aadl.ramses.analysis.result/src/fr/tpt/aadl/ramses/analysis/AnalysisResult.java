/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
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
 *   <li>{@link fr.tpt.aadl.ramses.analysis.AnalysisResult#getResultUUId <em>Result UU Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.AnalysisResult#getNfpId <em>Nfp Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.analysis.AnalysisResult#getSource <em>Source</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.analysis.AnalysisResultPackage#getAnalysisResult()
 * @model abstract="true"
 * @generated
 */
public interface AnalysisResult extends EObject {
	/**
   * Returns the value of the '<em><b>Result UU Id</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Result UU Id</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Result UU Id</em>' attribute.
   * @see fr.tpt.aadl.ramses.analysis.AnalysisResultPackage#getAnalysisResult_ResultUUId()
   * @model id="true" required="true" changeable="false"
   * @generated
   */
	String getResultUUId();

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
   * @see fr.tpt.aadl.ramses.analysis.AnalysisResultPackage#getAnalysisResult_NfpId()
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
   * Returns the value of the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Source</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
   * @return the value of the '<em>Source</em>' containment reference.
   * @see #setSource(AnalysisSource)
   * @see fr.tpt.aadl.ramses.analysis.AnalysisResultPackage#getAnalysisResult_Source()
   * @model containment="true" required="true"
   * @generated
   */
	AnalysisSource getSource();

	/**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.analysis.AnalysisResult#getSource <em>Source</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source</em>' containment reference.
   * @see #getSource()
   * @generated
   */
	void setSource(AnalysisSource value);

} // AnalysisResult
