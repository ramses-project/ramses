/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.control.workflow;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl;

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
 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowFactory
 * @model kind="package"
 * @generated
 */
public interface WorkflowPackage extends EPackage {
	/**
   * The package name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNAME = "workflow";

	/**
   * The package namespace URI.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_URI = "http://fr.tpt.aadl.ramses.control.workflow/Ramses/1.0";

	/**
   * The package namespace name.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	String eNS_PREFIX = "rwf";

	/**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	WorkflowPackage eINSTANCE = fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl.init();

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.WorkflowImpl <em>Workflow</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getWorkflow()
   * @generated
   */
	int WORKFLOW = 0;

	/**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WORKFLOW__ELEMENT = 0;

	/**
   * The feature id for the '<em><b>Input Model Identifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WORKFLOW__INPUT_MODEL_IDENTIFIER = 1;

	/**
   * The number of structural features of the '<em>Workflow</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WORKFLOW_FEATURE_COUNT = 2;

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.WorkflowElementImpl <em>Element</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowElementImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getWorkflowElement()
   * @generated
   */
	int WORKFLOW_ELEMENT = 1;

	/**
   * The feature id for the '<em><b>Input Model Identifier</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WORKFLOW_ELEMENT__INPUT_MODEL_IDENTIFIER = 0;

	/**
   * The number of structural features of the '<em>Element</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int WORKFLOW_ELEMENT_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.TransformationImpl <em>Transformation</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.TransformationImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getTransformation()
   * @generated
   */
	int TRANSFORMATION = 2;

	/**
   * The feature id for the '<em><b>Input Model Identifier</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TRANSFORMATION__INPUT_MODEL_IDENTIFIER = WORKFLOW_ELEMENT__INPUT_MODEL_IDENTIFIER;

	/**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TRANSFORMATION__ELEMENT = WORKFLOW_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>List</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TRANSFORMATION__LIST = WORKFLOW_ELEMENT_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Output Model Identifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TRANSFORMATION__OUTPUT_MODEL_IDENTIFIER = WORKFLOW_ELEMENT_FEATURE_COUNT + 2;

	/**
   * The number of structural features of the '<em>Transformation</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int TRANSFORMATION_FEATURE_COUNT = WORKFLOW_ELEMENT_FEATURE_COUNT + 3;

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.AnalysisElementImpl <em>Analysis Element</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.AnalysisElementImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getAnalysisElement()
   * @generated
   */
	int ANALYSIS_ELEMENT = 3;

	/**
   * The number of structural features of the '<em>Analysis Element</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANALYSIS_ELEMENT_FEATURE_COUNT = 0;

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.GenerationImpl <em>Generation</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.GenerationImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getGeneration()
   * @generated
   */
	int GENERATION = 4;

	/**
   * The feature id for the '<em><b>Input Model Identifier</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int GENERATION__INPUT_MODEL_IDENTIFIER = WORKFLOW_ELEMENT__INPUT_MODEL_IDENTIFIER;

	/**
   * The number of structural features of the '<em>Generation</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int GENERATION_FEATURE_COUNT = WORKFLOW_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.AbstractAnalysisImpl <em>Abstract Analysis</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.AbstractAnalysisImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getAbstractAnalysis()
   * @generated
   */
	int ABSTRACT_ANALYSIS = 5;

	/**
   * The feature id for the '<em><b>Yes Option</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ABSTRACT_ANALYSIS__YES_OPTION = 0;

	/**
   * The feature id for the '<em><b>No Option</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ABSTRACT_ANALYSIS__NO_OPTION = 1;

	/**
   * The number of structural features of the '<em>Abstract Analysis</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ABSTRACT_ANALYSIS_FEATURE_COUNT = 2;

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.AnalysisSequenceImpl <em>Analysis Sequence</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.AnalysisSequenceImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getAnalysisSequence()
   * @generated
   */
	int ANALYSIS_SEQUENCE = 6;

	/**
   * The feature id for the '<em><b>Yes Option</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANALYSIS_SEQUENCE__YES_OPTION = ABSTRACT_ANALYSIS__YES_OPTION;

	/**
   * The feature id for the '<em><b>No Option</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANALYSIS_SEQUENCE__NO_OPTION = ABSTRACT_ANALYSIS__NO_OPTION;

	/**
   * The feature id for the '<em><b>List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANALYSIS_SEQUENCE__LIST = ABSTRACT_ANALYSIS_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Analysis Sequence</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANALYSIS_SEQUENCE_FEATURE_COUNT = ABSTRACT_ANALYSIS_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.ConjunctionImpl <em>Conjunction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.ConjunctionImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getConjunction()
   * @generated
   */
  int CONJUNCTION = 7;

  /**
   * The feature id for the '<em><b>Yes Option</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONJUNCTION__YES_OPTION = ANALYSIS_SEQUENCE__YES_OPTION;

  /**
   * The feature id for the '<em><b>No Option</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONJUNCTION__NO_OPTION = ANALYSIS_SEQUENCE__NO_OPTION;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONJUNCTION__LIST = ANALYSIS_SEQUENCE__LIST;

  /**
   * The number of structural features of the '<em>Conjunction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONJUNCTION_FEATURE_COUNT = ANALYSIS_SEQUENCE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.DisjunctionImpl <em>Disjunction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.DisjunctionImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getDisjunction()
   * @generated
   */
  int DISJUNCTION = 8;

  /**
   * The feature id for the '<em><b>Yes Option</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISJUNCTION__YES_OPTION = ANALYSIS_SEQUENCE__YES_OPTION;

  /**
   * The feature id for the '<em><b>No Option</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISJUNCTION__NO_OPTION = ANALYSIS_SEQUENCE__NO_OPTION;

  /**
   * The feature id for the '<em><b>List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISJUNCTION__LIST = ANALYSIS_SEQUENCE__LIST;

  /**
   * The number of structural features of the '<em>Disjunction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DISJUNCTION_FEATURE_COUNT = ANALYSIS_SEQUENCE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.AnalysisImpl <em>Analysis</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.AnalysisImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getAnalysis()
   * @generated
   */
	int ANALYSIS = 9;

	/**
   * The feature id for the '<em><b>Input Model Identifier</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANALYSIS__INPUT_MODEL_IDENTIFIER = WORKFLOW_ELEMENT__INPUT_MODEL_IDENTIFIER;

	/**
   * The feature id for the '<em><b>Yes Option</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANALYSIS__YES_OPTION = WORKFLOW_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>No Option</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANALYSIS__NO_OPTION = WORKFLOW_ELEMENT_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Method</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANALYSIS__METHOD = WORKFLOW_ELEMENT_FEATURE_COUNT + 2;

	/**
   * The feature id for the '<em><b>Mode</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANALYSIS__MODE = WORKFLOW_ELEMENT_FEATURE_COUNT + 3;

	/**
   * The feature id for the '<em><b>Output Model Identifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANALYSIS__OUTPUT_MODEL_IDENTIFIER = WORKFLOW_ELEMENT_FEATURE_COUNT + 4;

	/**
   * The number of structural features of the '<em>Analysis</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANALYSIS_FEATURE_COUNT = WORKFLOW_ELEMENT_FEATURE_COUNT + 5;

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.ErrorStateImpl <em>Error State</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.ErrorStateImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getErrorState()
   * @generated
   */
	int ERROR_STATE = 10;

	/**
   * The feature id for the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ERROR_STATE__TYPE = ANALYSIS_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The number of structural features of the '<em>Error State</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ERROR_STATE_FEATURE_COUNT = ANALYSIS_ELEMENT_FEATURE_COUNT + 1;

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.ListImpl <em>List</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.ListImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getList()
   * @generated
   */
	int LIST = 11;

	/**
   * The feature id for the '<em><b>File</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LIST__FILE = 0;

	/**
   * The number of structural features of the '<em>List</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LIST_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.FileImpl <em>File</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.FileImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getFile()
   * @generated
   */
	int FILE = 12;

	/**
   * The feature id for the '<em><b>Path</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FILE__PATH = 0;

	/**
   * The number of structural features of the '<em>File</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int FILE_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.AnalysisOptionImpl <em>Analysis Option</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.AnalysisOptionImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getAnalysisOption()
   * @generated
   */
	int ANALYSIS_OPTION = 13;

	/**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANALYSIS_OPTION__ELEMENT = 0;

	/**
   * The number of structural features of the '<em>Analysis Option</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int ANALYSIS_OPTION_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.ModelIdentifierImpl <em>Model Identifier</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.ModelIdentifierImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getModelIdentifier()
   * @generated
   */
	int MODEL_IDENTIFIER = 14;

	/**
   * The feature id for the '<em><b>Id</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MODEL_IDENTIFIER__ID = 0;

	/**
   * The number of structural features of the '<em>Model Identifier</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int MODEL_IDENTIFIER_FEATURE_COUNT = 1;

	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.UnparseImpl <em>Unparse</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.UnparseImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getUnparse()
   * @generated
   */
	int UNPARSE = 15;

	/**
   * The feature id for the '<em><b>Input Model Identifier</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int UNPARSE__INPUT_MODEL_IDENTIFIER = WORKFLOW_ELEMENT__INPUT_MODEL_IDENTIFIER;

	/**
   * The feature id for the '<em><b>Element</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int UNPARSE__ELEMENT = WORKFLOW_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Output Model Identifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int UNPARSE__OUTPUT_MODEL_IDENTIFIER = WORKFLOW_ELEMENT_FEATURE_COUNT + 1;

	/**
   * The number of structural features of the '<em>Unparse</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int UNPARSE_FEATURE_COUNT = WORKFLOW_ELEMENT_FEATURE_COUNT + 2;


	/**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.LoopImpl <em>Loop</em>}' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.control.workflow.impl.LoopImpl
   * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getLoop()
   * @generated
   */
	int LOOP = 16;

	/**
   * The feature id for the '<em><b>Input Model Identifier</b></em>' reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LOOP__INPUT_MODEL_IDENTIFIER = WORKFLOW_ELEMENT__INPUT_MODEL_IDENTIFIER;

	/**
   * The feature id for the '<em><b>Alternatives</b></em>' containment reference list.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LOOP__ALTERNATIVES = WORKFLOW_ELEMENT_FEATURE_COUNT + 0;

	/**
   * The feature id for the '<em><b>Analysis</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LOOP__ANALYSIS = WORKFLOW_ELEMENT_FEATURE_COUNT + 1;

	/**
   * The feature id for the '<em><b>Initial Analysis</b></em>' attribute.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LOOP__INITIAL_ANALYSIS = WORKFLOW_ELEMENT_FEATURE_COUNT + 2;

	/**
   * The feature id for the '<em><b>Output Model Identifier</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LOOP__OUTPUT_MODEL_IDENTIFIER = WORKFLOW_ELEMENT_FEATURE_COUNT + 3;

	/**
   * The feature id for the '<em><b>Found Option</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LOOP__FOUND_OPTION = WORKFLOW_ELEMENT_FEATURE_COUNT + 4;

	/**
   * The feature id for the '<em><b>Not Found Option</b></em>' containment reference.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LOOP__NOT_FOUND_OPTION = WORKFLOW_ELEMENT_FEATURE_COUNT + 5;

	/**
   * The number of structural features of the '<em>Loop</em>' class.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
	int LOOP_FEATURE_COUNT = WORKFLOW_ELEMENT_FEATURE_COUNT + 6;


	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.Workflow <em>Workflow</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Workflow</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Workflow
   * @generated
   */
	EClass getWorkflow();

	/**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.control.workflow.Workflow#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Workflow#getElement()
   * @see #getWorkflow()
   * @generated
   */
	EReference getWorkflow_Element();

	/**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.control.workflow.Workflow#getInputModelIdentifier <em>Input Model Identifier</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Input Model Identifier</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Workflow#getInputModelIdentifier()
   * @see #getWorkflow()
   * @generated
   */
	EReference getWorkflow_InputModelIdentifier();

	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.WorkflowElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Element</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowElement
   * @generated
   */
	EClass getWorkflowElement();

	/**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.ramses.control.workflow.WorkflowElement#getInputModelIdentifier <em>Input Model Identifier</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Input Model Identifier</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowElement#getInputModelIdentifier()
   * @see #getWorkflowElement()
   * @generated
   */
	EReference getWorkflowElement_InputModelIdentifier();

	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.Transformation <em>Transformation</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Transformation
   * @generated
   */
	EClass getTransformation();

	/**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.control.workflow.Transformation#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Transformation#getElement()
   * @see #getTransformation()
   * @generated
   */
	EReference getTransformation_Element();

	/**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.control.workflow.Transformation#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>List</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Transformation#getList()
   * @see #getTransformation()
   * @generated
   */
	EReference getTransformation_List();

	/**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.control.workflow.Transformation#getOutputModelIdentifier <em>Output Model Identifier</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Output Model Identifier</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Transformation#getOutputModelIdentifier()
   * @see #getTransformation()
   * @generated
   */
	EReference getTransformation_OutputModelIdentifier();

	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.AnalysisElement <em>Analysis Element</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analysis Element</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.AnalysisElement
   * @generated
   */
	EClass getAnalysisElement();

	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.Generation <em>Generation</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Generation</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Generation
   * @generated
   */
	EClass getGeneration();

	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis <em>Abstract Analysis</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Analysis</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis
   * @generated
   */
	EClass getAbstractAnalysis();

	/**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis#getYesOption <em>Yes Option</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Yes Option</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis#getYesOption()
   * @see #getAbstractAnalysis()
   * @generated
   */
	EReference getAbstractAnalysis_YesOption();

	/**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis#getNoOption <em>No Option</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>No Option</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis#getNoOption()
   * @see #getAbstractAnalysis()
   * @generated
   */
	EReference getAbstractAnalysis_NoOption();

	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.AnalysisSequence <em>Analysis Sequence</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analysis Sequence</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.AnalysisSequence
   * @generated
   */
	EClass getAnalysisSequence();

	/**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.control.workflow.AnalysisSequence#getList <em>List</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>List</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.AnalysisSequence#getList()
   * @see #getAnalysisSequence()
   * @generated
   */
	EReference getAnalysisSequence_List();

	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.Conjunction <em>Conjunction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Conjunction</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Conjunction
   * @generated
   */
  EClass getConjunction();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.Disjunction <em>Disjunction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Disjunction</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Disjunction
   * @generated
   */
  EClass getDisjunction();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.Analysis <em>Analysis</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analysis</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Analysis
   * @generated
   */
	EClass getAnalysis();

	/**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.control.workflow.Analysis#getMethod <em>Method</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Method</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Analysis#getMethod()
   * @see #getAnalysis()
   * @generated
   */
	EAttribute getAnalysis_Method();

	/**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.control.workflow.Analysis#getMode <em>Mode</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Mode</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Analysis#getMode()
   * @see #getAnalysis()
   * @generated
   */
	EAttribute getAnalysis_Mode();

	/**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.control.workflow.Analysis#getOutputModelIdentifier <em>Output Model Identifier</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Output Model Identifier</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Analysis#getOutputModelIdentifier()
   * @see #getAnalysis()
   * @generated
   */
	EReference getAnalysis_OutputModelIdentifier();

	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.ErrorState <em>Error State</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Error State</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.ErrorState
   * @generated
   */
	EClass getErrorState();

	/**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.control.workflow.ErrorState#getType <em>Type</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Type</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.ErrorState#getType()
   * @see #getErrorState()
   * @generated
   */
	EAttribute getErrorState_Type();

	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.List <em>List</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>List</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.List
   * @generated
   */
	EClass getList();

	/**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.control.workflow.List#getFile <em>File</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>File</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.List#getFile()
   * @see #getList()
   * @generated
   */
	EReference getList_File();

	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.File <em>File</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>File</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.File
   * @generated
   */
	EClass getFile();

	/**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.control.workflow.File#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Path</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.File#getPath()
   * @see #getFile()
   * @generated
   */
	EAttribute getFile_Path();

	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.AnalysisOption <em>Analysis Option</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Analysis Option</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.AnalysisOption
   * @generated
   */
	EClass getAnalysisOption();

	/**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.control.workflow.AnalysisOption#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.AnalysisOption#getElement()
   * @see #getAnalysisOption()
   * @generated
   */
	EReference getAnalysisOption_Element();

	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.ModelIdentifier <em>Model Identifier</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Model Identifier</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.ModelIdentifier
   * @generated
   */
	EClass getModelIdentifier();

	/**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.control.workflow.ModelIdentifier#getId <em>Id</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Id</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.ModelIdentifier#getId()
   * @see #getModelIdentifier()
   * @generated
   */
	EAttribute getModelIdentifier_Id();

	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.Unparse <em>Unparse</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unparse</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Unparse
   * @generated
   */
	EClass getUnparse();

	/**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.control.workflow.Unparse#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Element</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Unparse#getElement()
   * @see #getUnparse()
   * @generated
   */
	EReference getUnparse_Element();

	/**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.control.workflow.Unparse#getOutputModelIdentifier <em>Output Model Identifier</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Output Model Identifier</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Unparse#getOutputModelIdentifier()
   * @see #getUnparse()
   * @generated
   */
	EReference getUnparse_OutputModelIdentifier();

	/**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.control.workflow.Loop <em>Loop</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for class '<em>Loop</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Loop
   * @generated
   */
	EClass getLoop();

	/**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.control.workflow.Loop#getAlternatives <em>Alternatives</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Alternatives</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Loop#getAlternatives()
   * @see #getLoop()
   * @generated
   */
	EReference getLoop_Alternatives();

	/**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.control.workflow.Loop#getAnalysis <em>Analysis</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Analysis</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Loop#getAnalysis()
   * @see #getLoop()
   * @generated
   */
	EReference getLoop_Analysis();

	/**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.control.workflow.Loop#isInitialAnalysis <em>Initial Analysis</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Initial Analysis</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Loop#isInitialAnalysis()
   * @see #getLoop()
   * @generated
   */
	EAttribute getLoop_InitialAnalysis();

	/**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.control.workflow.Loop#getOutputModelIdentifier <em>Output Model Identifier</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Output Model Identifier</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Loop#getOutputModelIdentifier()
   * @see #getLoop()
   * @generated
   */
	EReference getLoop_OutputModelIdentifier();

	/**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.control.workflow.Loop#getFoundOption <em>Found Option</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Found Option</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Loop#getFoundOption()
   * @see #getLoop()
   * @generated
   */
	EReference getLoop_FoundOption();

	/**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.control.workflow.Loop#getNotFoundOption <em>Not Found Option</em>}'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Not Found Option</em>'.
   * @see fr.tpt.aadl.ramses.control.workflow.Loop#getNotFoundOption()
   * @see #getLoop()
   * @generated
   */
	EReference getLoop_NotFoundOption();

	/**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
	WorkflowFactory getWorkflowFactory();

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
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.WorkflowImpl <em>Workflow</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getWorkflow()
     * @generated
     */
		EClass WORKFLOW = eINSTANCE.getWorkflow();

		/**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference WORKFLOW__ELEMENT = eINSTANCE.getWorkflow_Element();

		/**
     * The meta object literal for the '<em><b>Input Model Identifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference WORKFLOW__INPUT_MODEL_IDENTIFIER = eINSTANCE.getWorkflow_InputModelIdentifier();

		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.WorkflowElementImpl <em>Element</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowElementImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getWorkflowElement()
     * @generated
     */
		EClass WORKFLOW_ELEMENT = eINSTANCE.getWorkflowElement();

		/**
     * The meta object literal for the '<em><b>Input Model Identifier</b></em>' reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference WORKFLOW_ELEMENT__INPUT_MODEL_IDENTIFIER = eINSTANCE.getWorkflowElement_InputModelIdentifier();

		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.TransformationImpl <em>Transformation</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.TransformationImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getTransformation()
     * @generated
     */
		EClass TRANSFORMATION = eINSTANCE.getTransformation();

		/**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference TRANSFORMATION__ELEMENT = eINSTANCE.getTransformation_Element();

		/**
     * The meta object literal for the '<em><b>List</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference TRANSFORMATION__LIST = eINSTANCE.getTransformation_List();

		/**
     * The meta object literal for the '<em><b>Output Model Identifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference TRANSFORMATION__OUTPUT_MODEL_IDENTIFIER = eINSTANCE.getTransformation_OutputModelIdentifier();

		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.AnalysisElementImpl <em>Analysis Element</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.AnalysisElementImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getAnalysisElement()
     * @generated
     */
		EClass ANALYSIS_ELEMENT = eINSTANCE.getAnalysisElement();

		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.GenerationImpl <em>Generation</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.GenerationImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getGeneration()
     * @generated
     */
		EClass GENERATION = eINSTANCE.getGeneration();

		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.AbstractAnalysisImpl <em>Abstract Analysis</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.AbstractAnalysisImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getAbstractAnalysis()
     * @generated
     */
		EClass ABSTRACT_ANALYSIS = eINSTANCE.getAbstractAnalysis();

		/**
     * The meta object literal for the '<em><b>Yes Option</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ABSTRACT_ANALYSIS__YES_OPTION = eINSTANCE.getAbstractAnalysis_YesOption();

		/**
     * The meta object literal for the '<em><b>No Option</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ABSTRACT_ANALYSIS__NO_OPTION = eINSTANCE.getAbstractAnalysis_NoOption();

		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.AnalysisSequenceImpl <em>Analysis Sequence</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.AnalysisSequenceImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getAnalysisSequence()
     * @generated
     */
		EClass ANALYSIS_SEQUENCE = eINSTANCE.getAnalysisSequence();

		/**
     * The meta object literal for the '<em><b>List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ANALYSIS_SEQUENCE__LIST = eINSTANCE.getAnalysisSequence_List();

		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.ConjunctionImpl <em>Conjunction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.ConjunctionImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getConjunction()
     * @generated
     */
    EClass CONJUNCTION = eINSTANCE.getConjunction();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.DisjunctionImpl <em>Disjunction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.DisjunctionImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getDisjunction()
     * @generated
     */
    EClass DISJUNCTION = eINSTANCE.getDisjunction();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.AnalysisImpl <em>Analysis</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.AnalysisImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getAnalysis()
     * @generated
     */
		EClass ANALYSIS = eINSTANCE.getAnalysis();

		/**
     * The meta object literal for the '<em><b>Method</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ANALYSIS__METHOD = eINSTANCE.getAnalysis_Method();

		/**
     * The meta object literal for the '<em><b>Mode</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ANALYSIS__MODE = eINSTANCE.getAnalysis_Mode();

		/**
     * The meta object literal for the '<em><b>Output Model Identifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ANALYSIS__OUTPUT_MODEL_IDENTIFIER = eINSTANCE.getAnalysis_OutputModelIdentifier();

		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.ErrorStateImpl <em>Error State</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.ErrorStateImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getErrorState()
     * @generated
     */
		EClass ERROR_STATE = eINSTANCE.getErrorState();

		/**
     * The meta object literal for the '<em><b>Type</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute ERROR_STATE__TYPE = eINSTANCE.getErrorState_Type();

		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.ListImpl <em>List</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.ListImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getList()
     * @generated
     */
		EClass LIST = eINSTANCE.getList();

		/**
     * The meta object literal for the '<em><b>File</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference LIST__FILE = eINSTANCE.getList_File();

		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.FileImpl <em>File</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.FileImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getFile()
     * @generated
     */
		EClass FILE = eINSTANCE.getFile();

		/**
     * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute FILE__PATH = eINSTANCE.getFile_Path();

		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.AnalysisOptionImpl <em>Analysis Option</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.AnalysisOptionImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getAnalysisOption()
     * @generated
     */
		EClass ANALYSIS_OPTION = eINSTANCE.getAnalysisOption();

		/**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference ANALYSIS_OPTION__ELEMENT = eINSTANCE.getAnalysisOption_Element();

		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.ModelIdentifierImpl <em>Model Identifier</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.ModelIdentifierImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getModelIdentifier()
     * @generated
     */
		EClass MODEL_IDENTIFIER = eINSTANCE.getModelIdentifier();

		/**
     * The meta object literal for the '<em><b>Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute MODEL_IDENTIFIER__ID = eINSTANCE.getModelIdentifier_Id();

		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.UnparseImpl <em>Unparse</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.UnparseImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getUnparse()
     * @generated
     */
		EClass UNPARSE = eINSTANCE.getUnparse();

		/**
     * The meta object literal for the '<em><b>Element</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference UNPARSE__ELEMENT = eINSTANCE.getUnparse_Element();

		/**
     * The meta object literal for the '<em><b>Output Model Identifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference UNPARSE__OUTPUT_MODEL_IDENTIFIER = eINSTANCE.getUnparse_OutputModelIdentifier();

		/**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.control.workflow.impl.LoopImpl <em>Loop</em>}' class.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.control.workflow.impl.LoopImpl
     * @see fr.tpt.aadl.ramses.control.workflow.impl.WorkflowPackageImpl#getLoop()
     * @generated
     */
		EClass LOOP = eINSTANCE.getLoop();

		/**
     * The meta object literal for the '<em><b>Alternatives</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference LOOP__ALTERNATIVES = eINSTANCE.getLoop_Alternatives();

		/**
     * The meta object literal for the '<em><b>Analysis</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference LOOP__ANALYSIS = eINSTANCE.getLoop_Analysis();

		/**
     * The meta object literal for the '<em><b>Initial Analysis</b></em>' attribute feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EAttribute LOOP__INITIAL_ANALYSIS = eINSTANCE.getLoop_InitialAnalysis();

		/**
     * The meta object literal for the '<em><b>Output Model Identifier</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference LOOP__OUTPUT_MODEL_IDENTIFIER = eINSTANCE.getLoop_OutputModelIdentifier();

		/**
     * The meta object literal for the '<em><b>Found Option</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference LOOP__FOUND_OPTION = eINSTANCE.getLoop_FoundOption();

		/**
     * The meta object literal for the '<em><b>Not Found Option</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
     * @generated
     */
		EReference LOOP__NOT_FOUND_OPTION = eINSTANCE.getLoop_NotFoundOption();

	}

} //WorkflowPackage
