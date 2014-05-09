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

import fr.tpt.aadl.ramses.transformation.trc.Transformation;
import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Loop</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Loop#getAlternatives <em>Alternatives</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Loop#getAnalysis <em>Analysis</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Loop#getOutputModelIdentifier <em>Output Model Identifier</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Loop#getFoundOption <em>Found Option</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Loop#getNotFoundOption <em>Not Found Option</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.control.workflow.Loop#getResolutionMethod <em>Resolution Method</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getLoop()
 * @model
 * @generated
 */
public interface Loop extends WorkflowElement, AnalysisElement
{
  /**
   * Returns the value of the '<em><b>Alternatives</b></em>' reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.trc.Transformation}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Alternatives</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Alternatives</em>' reference list.
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getLoop_Alternatives()
   * @model lower="2"
   * @generated
   */
  EList<Transformation> getAlternatives();

  /**
   * Returns the value of the '<em><b>Analysis</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Analysis</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Analysis</em>' containment reference.
   * @see #setAnalysis(AbstractAnalysis)
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getLoop_Analysis()
   * @model containment="true" required="true"
   * @generated
   */
  AbstractAnalysis getAnalysis();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.Loop#getAnalysis <em>Analysis</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Analysis</em>' containment reference.
   * @see #getAnalysis()
   * @generated
   */
  void setAnalysis(AbstractAnalysis value);

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
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getLoop_OutputModelIdentifier()
   * @model containment="true"
   * @generated
   */
  ModelIdentifier getOutputModelIdentifier();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.Loop#getOutputModelIdentifier <em>Output Model Identifier</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Output Model Identifier</em>' containment reference.
   * @see #getOutputModelIdentifier()
   * @generated
   */
  void setOutputModelIdentifier(ModelIdentifier value);

  /**
   * Returns the value of the '<em><b>Found Option</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Found Option</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Found Option</em>' containment reference.
   * @see #setFoundOption(AnalysisOption)
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getLoop_FoundOption()
   * @model containment="true" required="true"
   * @generated
   */
  AnalysisOption getFoundOption();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.Loop#getFoundOption <em>Found Option</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Found Option</em>' containment reference.
   * @see #getFoundOption()
   * @generated
   */
  void setFoundOption(AnalysisOption value);

  /**
   * Returns the value of the '<em><b>Not Found Option</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Not Found Option</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Not Found Option</em>' containment reference.
   * @see #setNotFoundOption(AnalysisOption)
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getLoop_NotFoundOption()
   * @model containment="true" required="true"
   * @generated
   */
  AnalysisOption getNotFoundOption();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.Loop#getNotFoundOption <em>Not Found Option</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Not Found Option</em>' containment reference.
   * @see #getNotFoundOption()
   * @generated
   */
  void setNotFoundOption(AnalysisOption value);

  /**
   * Returns the value of the '<em><b>Resolution Method</b></em>' attribute.
   * The default value is <code>"TryEach"</code>.
   * The literals are from the enumeration {@link fr.tpt.aadl.ramses.control.workflow.ResolutionMethod}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Resolution Method</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Resolution Method</em>' attribute.
   * @see fr.tpt.aadl.ramses.control.workflow.ResolutionMethod
   * @see #setResolutionMethod(ResolutionMethod)
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#getLoop_ResolutionMethod()
   * @model default="TryEach"
   * @generated
   */
  ResolutionMethod getResolutionMethod();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.control.workflow.Loop#getResolutionMethod <em>Resolution Method</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Resolution Method</em>' attribute.
   * @see fr.tpt.aadl.ramses.control.workflow.ResolutionMethod
   * @see #getResolutionMethod()
   * @generated
   */
  void setResolutionMethod(ResolutionMethod value);

} // Loop
