/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.control.workflow;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Abstract Analysis</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis#getYesOption <em>Yes Option</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis#getNoOption <em>No Option</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getAbstractAnalysis()
 * @model abstract="true"
 * @generated
 */
public interface AbstractAnalysis extends EObject {
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
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getAbstractAnalysis_YesOption()
   * @model containment="true"
   * @generated
   */
	AnalysisOption getYesOption();

	/**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis#getYesOption <em>Yes Option</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>Yes Option</em>' containment reference.
   * @see #getYesOption()
   * @generated
   */
	void setYesOption(AnalysisOption value);

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
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getAbstractAnalysis_NoOption()
   * @model containment="true"
   * @generated
   */
	AnalysisOption getNoOption();

	/**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis#getNoOption <em>No Option</em>}' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @param value the new value of the '<em>No Option</em>' containment reference.
   * @see #getNoOption()
   * @generated
   */
	void setNoOption(AnalysisOption value);

} // AbstractAnalysis
