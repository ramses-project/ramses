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

package fr.tpt.aadl.ramses.analysis.impl;

import fr.tpt.aadl.ramses.analysis.*;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.impl.EFactoryImpl;
import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AnalysisResultFactoryImpl extends EFactoryImpl implements AnalysisResultFactory {
	
  private static Logger _LOGGER = Logger.getLogger(AnalysisResultFactoryImpl.class) ;
  
  /**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static AnalysisResultFactory init() {
		try {
			AnalysisResultFactory theAnalysisResultFactory = (AnalysisResultFactory)EPackage.Registry.INSTANCE.getEFactory("http://fr.tpt.aadl.ramses.analysis/Analysis/1.0"); 
			if (theAnalysisResultFactory != null) {
				return theAnalysisResultFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new AnalysisResultFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisResultFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case AnalysisResultPackage.ANALYSIS_ARTIFACT: return createAnalysisArtifact();
			case AnalysisResultPackage.QUANTITATIVE_ANALYSIS_RESULT: return createQuantitativeAnalysisResult();
			case AnalysisResultPackage.QUALITATIVE_ANALYSIS_RESULT: return createQualitativeAnalysisResult();
			case AnalysisResultPackage.ANALYSIS_SOURCE: return createAnalysisSource();
			default:
			{
			  String msg = "The class '" + eClass.getName() + "' is not a valid classifier" ;
			  _LOGGER.fatal(msg) ;
			  throw new IllegalArgumentException(msg);
			}
				
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisArtifact createAnalysisArtifact() {
		AnalysisArtifactImpl analysisArtifact = new AnalysisArtifactImpl();
		return analysisArtifact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QuantitativeAnalysisResult createQuantitativeAnalysisResult() {
		QuantitativeAnalysisResultImpl quantitativeAnalysisResult = new QuantitativeAnalysisResultImpl();
		return quantitativeAnalysisResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public QualitativeAnalysisResult createQualitativeAnalysisResult() {
		QualitativeAnalysisResultImpl qualitativeAnalysisResult = new QualitativeAnalysisResultImpl();
		return qualitativeAnalysisResult;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisSource createAnalysisSource() {
		AnalysisSourceImpl analysisSource = new AnalysisSourceImpl();
		return analysisSource;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AnalysisResultPackage getAnalysisResultPackage() {
		return (AnalysisResultPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static AnalysisResultPackage getPackage() {
		return AnalysisResultPackage.eINSTANCE;
	}

} //AnalysisResultFactoryImpl
