/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.analysis;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.ramses.analysis.AnalysisFactory
 * @model kind="package"
 * @generated
 */
public interface AnalysisPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "analysis";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://fr.tpt.aadl.ramses.analysis/Analysis/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "ares";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	AnalysisPackage eINSTANCE = fr.tpt.aadl.ramses.analysis.impl.AnalysisPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.ramses.analysis.impl.AnalysisArtifactImpl <em>Artifact</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.ramses.analysis.impl.AnalysisArtifactImpl
	 * @see fr.tpt.aadl.ramses.analysis.impl.AnalysisPackageImpl#getAnalysisArtifact()
	 * @generated
	 */
	int ANALYSIS_ARTIFACT = 0;

	/**
	 * The feature id for the '<em><b>Results</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_ARTIFACT__RESULTS = 0;

	/**
	 * The number of structural features of the '<em>Artifact</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_ARTIFACT_FEATURE_COUNT = 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.ramses.analysis.impl.AnalysisResultImpl <em>Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.ramses.analysis.impl.AnalysisResultImpl
	 * @see fr.tpt.aadl.ramses.analysis.impl.AnalysisPackageImpl#getAnalysisResult()
	 * @generated
	 */
	int ANALYSIS_RESULT = 1;

	/**
	 * The feature id for the '<em><b>Result Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_RESULT__RESULT_ID = 0;

	/**
	 * The feature id for the '<em><b>Nfp Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_RESULT__NFP_ID = 1;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_RESULT__SOURCE = 2;

	/**
	 * The number of structural features of the '<em>Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_RESULT_FEATURE_COUNT = 3;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.ramses.analysis.impl.QuantitativeAnalysisResultImpl <em>Quantitative Analysis Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.ramses.analysis.impl.QuantitativeAnalysisResultImpl
	 * @see fr.tpt.aadl.ramses.analysis.impl.AnalysisPackageImpl#getQuantitativeAnalysisResult()
	 * @generated
	 */
	int QUANTITATIVE_ANALYSIS_RESULT = 2;

	/**
	 * The feature id for the '<em><b>Result Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTITATIVE_ANALYSIS_RESULT__RESULT_ID = ANALYSIS_RESULT__RESULT_ID;

	/**
	 * The feature id for the '<em><b>Nfp Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTITATIVE_ANALYSIS_RESULT__NFP_ID = ANALYSIS_RESULT__NFP_ID;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTITATIVE_ANALYSIS_RESULT__SOURCE = ANALYSIS_RESULT__SOURCE;

	/**
	 * The feature id for the '<em><b>Eval Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTITATIVE_ANALYSIS_RESULT__EVAL_VALUE = ANALYSIS_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Quantitative Analysis Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUANTITATIVE_ANALYSIS_RESULT_FEATURE_COUNT = ANALYSIS_RESULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.ramses.analysis.impl.QualitativeAnalysisResultImpl <em>Qualitative Analysis Result</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.ramses.analysis.impl.QualitativeAnalysisResultImpl
	 * @see fr.tpt.aadl.ramses.analysis.impl.AnalysisPackageImpl#getQualitativeAnalysisResult()
	 * @generated
	 */
	int QUALITATIVE_ANALYSIS_RESULT = 3;

	/**
	 * The feature id for the '<em><b>Result Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITATIVE_ANALYSIS_RESULT__RESULT_ID = ANALYSIS_RESULT__RESULT_ID;

	/**
	 * The feature id for the '<em><b>Nfp Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITATIVE_ANALYSIS_RESULT__NFP_ID = ANALYSIS_RESULT__NFP_ID;

	/**
	 * The feature id for the '<em><b>Source</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITATIVE_ANALYSIS_RESULT__SOURCE = ANALYSIS_RESULT__SOURCE;

	/**
	 * The feature id for the '<em><b>Eval Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITATIVE_ANALYSIS_RESULT__EVAL_VALUE = ANALYSIS_RESULT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Qualitative Analysis Result</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int QUALITATIVE_ANALYSIS_RESULT_FEATURE_COUNT = ANALYSIS_RESULT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.ramses.analysis.impl.AnalysisSourceImpl <em>Source</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.ramses.analysis.impl.AnalysisSourceImpl
	 * @see fr.tpt.aadl.ramses.analysis.impl.AnalysisPackageImpl#getAnalysisSource()
	 * @generated
	 */
	int ANALYSIS_SOURCE = 4;

	/**
	 * The feature id for the '<em><b>Iteration Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_SOURCE__ITERATION_ID = 0;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_SOURCE__SCOPE = 1;

	/**
	 * The number of structural features of the '<em>Source</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_SOURCE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.ramses.analysis.AnalysisArtifact <em>Artifact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Artifact</em>'.
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisArtifact
	 * @generated
	 */
	EClass getAnalysisArtifact();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.analysis.AnalysisArtifact#getResults <em>Results</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Results</em>'.
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisArtifact#getResults()
	 * @see #getAnalysisArtifact()
	 * @generated
	 */
	EReference getAnalysisArtifact_Results();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.ramses.analysis.AnalysisResult <em>Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Result</em>'.
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisResult
	 * @generated
	 */
	EClass getAnalysisResult();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.analysis.AnalysisResult#getResultId <em>Result Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Result Id</em>'.
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisResult#getResultId()
	 * @see #getAnalysisResult()
	 * @generated
	 */
	EAttribute getAnalysisResult_ResultId();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.analysis.AnalysisResult#getNfpId <em>Nfp Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Nfp Id</em>'.
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisResult#getNfpId()
	 * @see #getAnalysisResult()
	 * @generated
	 */
	EAttribute getAnalysisResult_NfpId();

	/**
	 * Returns the meta object for the reference '{@link fr.tpt.aadl.ramses.analysis.AnalysisResult#getSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Source</em>'.
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisResult#getSource()
	 * @see #getAnalysisResult()
	 * @generated
	 */
	EReference getAnalysisResult_Source();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.ramses.analysis.QuantitativeAnalysisResult <em>Quantitative Analysis Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Quantitative Analysis Result</em>'.
	 * @see fr.tpt.aadl.ramses.analysis.QuantitativeAnalysisResult
	 * @generated
	 */
	EClass getQuantitativeAnalysisResult();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.analysis.QuantitativeAnalysisResult#getEvalValue <em>Eval Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Eval Value</em>'.
	 * @see fr.tpt.aadl.ramses.analysis.QuantitativeAnalysisResult#getEvalValue()
	 * @see #getQuantitativeAnalysisResult()
	 * @generated
	 */
	EAttribute getQuantitativeAnalysisResult_EvalValue();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult <em>Qualitative Analysis Result</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Qualitative Analysis Result</em>'.
	 * @see fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult
	 * @generated
	 */
	EClass getQualitativeAnalysisResult();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult#isEvalValue <em>Eval Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Eval Value</em>'.
	 * @see fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult#isEvalValue()
	 * @see #getQualitativeAnalysisResult()
	 * @generated
	 */
	EAttribute getQualitativeAnalysisResult_EvalValue();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.ramses.analysis.AnalysisSource <em>Source</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Source</em>'.
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisSource
	 * @generated
	 */
	EClass getAnalysisSource();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.analysis.AnalysisSource#getIterationId <em>Iteration Id</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Iteration Id</em>'.
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisSource#getIterationId()
	 * @see #getAnalysisSource()
	 * @generated
	 */
	EAttribute getAnalysisSource_IterationId();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.analysis.AnalysisSource#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scope</em>'.
	 * @see fr.tpt.aadl.ramses.analysis.AnalysisSource#getScope()
	 * @see #getAnalysisSource()
	 * @generated
	 */
	EAttribute getAnalysisSource_Scope();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	AnalysisFactory getAnalysisFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.ramses.analysis.impl.AnalysisArtifactImpl <em>Artifact</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.ramses.analysis.impl.AnalysisArtifactImpl
		 * @see fr.tpt.aadl.ramses.analysis.impl.AnalysisPackageImpl#getAnalysisArtifact()
		 * @generated
		 */
		EClass ANALYSIS_ARTIFACT = eINSTANCE.getAnalysisArtifact();

		/**
		 * The meta object literal for the '<em><b>Results</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_ARTIFACT__RESULTS = eINSTANCE.getAnalysisArtifact_Results();

		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.ramses.analysis.impl.AnalysisResultImpl <em>Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.ramses.analysis.impl.AnalysisResultImpl
		 * @see fr.tpt.aadl.ramses.analysis.impl.AnalysisPackageImpl#getAnalysisResult()
		 * @generated
		 */
		EClass ANALYSIS_RESULT = eINSTANCE.getAnalysisResult();

		/**
		 * The meta object literal for the '<em><b>Result Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_RESULT__RESULT_ID = eINSTANCE.getAnalysisResult_ResultId();

		/**
		 * The meta object literal for the '<em><b>Nfp Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_RESULT__NFP_ID = eINSTANCE.getAnalysisResult_NfpId();

		/**
		 * The meta object literal for the '<em><b>Source</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_RESULT__SOURCE = eINSTANCE.getAnalysisResult_Source();

		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.ramses.analysis.impl.QuantitativeAnalysisResultImpl <em>Quantitative Analysis Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.ramses.analysis.impl.QuantitativeAnalysisResultImpl
		 * @see fr.tpt.aadl.ramses.analysis.impl.AnalysisPackageImpl#getQuantitativeAnalysisResult()
		 * @generated
		 */
		EClass QUANTITATIVE_ANALYSIS_RESULT = eINSTANCE.getQuantitativeAnalysisResult();

		/**
		 * The meta object literal for the '<em><b>Eval Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUANTITATIVE_ANALYSIS_RESULT__EVAL_VALUE = eINSTANCE.getQuantitativeAnalysisResult_EvalValue();

		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.ramses.analysis.impl.QualitativeAnalysisResultImpl <em>Qualitative Analysis Result</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.ramses.analysis.impl.QualitativeAnalysisResultImpl
		 * @see fr.tpt.aadl.ramses.analysis.impl.AnalysisPackageImpl#getQualitativeAnalysisResult()
		 * @generated
		 */
		EClass QUALITATIVE_ANALYSIS_RESULT = eINSTANCE.getQualitativeAnalysisResult();

		/**
		 * The meta object literal for the '<em><b>Eval Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute QUALITATIVE_ANALYSIS_RESULT__EVAL_VALUE = eINSTANCE.getQualitativeAnalysisResult_EvalValue();

		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.ramses.analysis.impl.AnalysisSourceImpl <em>Source</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.ramses.analysis.impl.AnalysisSourceImpl
		 * @see fr.tpt.aadl.ramses.analysis.impl.AnalysisPackageImpl#getAnalysisSource()
		 * @generated
		 */
		EClass ANALYSIS_SOURCE = eINSTANCE.getAnalysisSource();

		/**
		 * The meta object literal for the '<em><b>Iteration Id</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_SOURCE__ITERATION_ID = eINSTANCE.getAnalysisSource_IterationId();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ANALYSIS_SOURCE__SCOPE = eINSTANCE.getAnalysisSource_Scope();

	}

} //AnalysisPackage
