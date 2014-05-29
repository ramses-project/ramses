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

package fr.tpt.aadl.ramses.analysis.util;

import fr.tpt.aadl.ramses.analysis.*;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.ramses.analysis.AnalysisResultPackage
 * @generated
 */
public class AnalysisResultSwitch {
	/**
   * The cached model package
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static AnalysisResultPackage modelPackage;

	/**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public AnalysisResultSwitch() {
    if (modelPackage == null)
    {
      modelPackage = AnalysisResultPackage.eINSTANCE;
    }
  }

	/**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
	public Object doSwitch(EObject theEObject) {
    return doSwitch(theEObject.eClass(), theEObject);
  }

	/**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
	protected Object doSwitch(EClass theEClass, EObject theEObject) {
    if (theEClass.eContainer() == modelPackage)
    {
      return doSwitch(theEClass.getClassifierID(), theEObject);
    }
    else
    {
      List eSuperTypes = theEClass.getESuperTypes();
      return
        eSuperTypes.isEmpty() ?
          defaultCase(theEObject) :
          doSwitch((EClass)eSuperTypes.get(0), theEObject);
    }
  }

	/**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
	protected Object doSwitch(int classifierID, EObject theEObject) {
    switch (classifierID)
    {
      case AnalysisResultPackage.ANALYSIS_ARTIFACT:
      {
        AnalysisArtifact analysisArtifact = (AnalysisArtifact)theEObject;
        Object result = caseAnalysisArtifact(analysisArtifact);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AnalysisResultPackage.ANALYSIS_RESULT:
      {
        AnalysisResult analysisResult = (AnalysisResult)theEObject;
        Object result = caseAnalysisResult(analysisResult);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT:
      {
        QuantitativeAnalysisResult quantitativeAnalysisResult = (QuantitativeAnalysisResult)theEObject;
        Object result = caseQuantitativeAnalysisResult(quantitativeAnalysisResult);
        if (result == null) result = caseAnalysisResult(quantitativeAnalysisResult);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AnalysisResultPackage.QUALITATIVE_ANALYSIS_RESULT:
      {
        QualitativeAnalysisResult qualitativeAnalysisResult = (QualitativeAnalysisResult)theEObject;
        Object result = caseQualitativeAnalysisResult(qualitativeAnalysisResult);
        if (result == null) result = caseAnalysisResult(qualitativeAnalysisResult);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case AnalysisResultPackage.ANALYSIS_SOURCE:
      {
        AnalysisSource analysisSource = (AnalysisSource)theEObject;
        Object result = caseAnalysisSource(analysisSource);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Analysis Artifact</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Analysis Artifact</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public Object caseAnalysisArtifact(AnalysisArtifact object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Analysis Result</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Analysis Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public Object caseAnalysisResult(AnalysisResult object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Quantitative Analysis Result</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Quantitative Analysis Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public Object caseQuantitativeAnalysisResult(QuantitativeAnalysisResult object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Qualitative Analysis Result</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Qualitative Analysis Result</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public Object caseQualitativeAnalysisResult(QualitativeAnalysisResult object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>Analysis Source</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Analysis Source</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
	public Object caseAnalysisSource(AnalysisSource object) {
    return null;
  }

	/**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
	public Object defaultCase(EObject object) {
    return null;
  }

} //AnalysisResultSwitch
