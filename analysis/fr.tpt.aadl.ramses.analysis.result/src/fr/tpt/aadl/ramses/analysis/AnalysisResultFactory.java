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

import org.eclipse.emf.ecore.EFactory;

import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.ramses.analysis.AnalysisResultPackage
 * @generated
 */
public interface AnalysisResultFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnalysisResultFactory eINSTANCE = fr.tpt.aadl.ramses.analysis.impl.AnalysisResultFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Analysis Artifact</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Analysis Artifact</em>'.
	 * @generated
	 */
	AnalysisArtifact createAnalysisArtifact();

	/**
	 * Returns a new object of class '<em>Quantitative Analysis Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Quantitative Analysis Result</em>'.
	 * @generated
	 */
	QuantitativeAnalysisResult createQuantitativeAnalysisResult();

	/**
	 * Returns a new object of class '<em>Qualitative Analysis Result</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Qualitative Analysis Result</em>'.
	 * @generated
	 */
	QualitativeAnalysisResult createQualitativeAnalysisResult();

	/**
	 * Returns a new object of class '<em>Analysis Source</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Analysis Source</em>'.
	 * @generated
	 */
	AnalysisSource createAnalysisSource();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	AnalysisResultPackage getAnalysisResultPackage();

} //AnalysisResultFactory
