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
