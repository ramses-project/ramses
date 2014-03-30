/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 1.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * http://www.eclipse.org/org/documents/epl-v10.php
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
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Transformation#getIdentifier <em>Identifier</em>}</li>
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
	 * @model containment="true"
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
	 * If the meaning of the '<em>Output Model Identifier</em>' containment reference isn't clear,
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

	/**
	 * Returns the value of the '<em><b>Identifier</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Identifier</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifier</em>' attribute.
	 * @see #setIdentifier(String)
	 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getTransformation_Identifier()
	 * @model
	 * @generated
	 */
	String getIdentifier();

	/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.Transformation#getIdentifier <em>Identifier</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifier</em>' attribute.
	 * @see #getIdentifier()
	 * @generated
	 */
	void setIdentifier(String value);

} // Transformation
