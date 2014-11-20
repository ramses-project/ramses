/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

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
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCFactory
 * @model kind="package"
 * @generated
 */
public interface TRCPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "tRC";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.tpt.fr/aadl/ramses/transformation/trc/xtext/TRC";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "tRC";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TRCPackage eINSTANCE = fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl.init();

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TrcSpecificationImpl <em>Trc Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TrcSpecificationImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTrcSpecification()
   * @generated
   */
  int TRC_SPECIFICATION = 0;

  /**
   * The feature id for the '<em><b>Module List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRC_SPECIFICATION__MODULE_LIST = 0;

  /**
   * The feature id for the '<em><b>Transformation List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRC_SPECIFICATION__TRANSFORMATION_LIST = 1;

  /**
   * The feature id for the '<em><b>Dependency List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRC_SPECIFICATION__DEPENDENCY_LIST = 2;

  /**
   * The number of structural features of the '<em>Trc Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRC_SPECIFICATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.trcRuleImpl <em>trc Rule</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.trcRuleImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#gettrcRule()
   * @generated
   */
  int TRC_RULE = 1;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRC_RULE__NAME = 0;

  /**
   * The number of structural features of the '<em>trc Rule</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRC_RULE_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ModuleListImpl <em>Module List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ModuleListImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getModuleList()
   * @generated
   */
  int MODULE_LIST = 2;

  /**
   * The feature id for the '<em><b>Modules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_LIST__MODULES = 0;

  /**
   * The number of structural features of the '<em>Module List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ModuleImpl <em>Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ModuleImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getModule()
   * @generated
   */
  int MODULE = 3;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__NAME = 0;

  /**
   * The feature id for the '<em><b>Rules</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__RULES = 1;

  /**
   * The number of structural features of the '<em>Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationListImpl <em>Transformation List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationListImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTransformationList()
   * @generated
   */
  int TRANSFORMATION_LIST = 4;

  /**
   * The feature id for the '<em><b>Transformations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_LIST__TRANSFORMATIONS = 0;

  /**
   * The number of structural features of the '<em>Transformation List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_LIST_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationImpl <em>Transformation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTransformation()
   * @generated
   */
  int TRANSFORMATION = 5;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION__NAME = 0;

  /**
   * The feature id for the '<em><b>Modules</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION__MODULES = 1;

  /**
   * The feature id for the '<em><b>Impacts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION__IMPACTS = 2;

  /**
   * The number of structural features of the '<em>Transformation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationImpactImpl <em>Transformation Impact</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationImpactImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTransformationImpact()
   * @generated
   */
  int TRANSFORMATION_IMPACT = 6;

  /**
   * The feature id for the '<em><b>Quality Attribute Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_IMPACT__QUALITY_ATTRIBUTE_NAME = 0;

  /**
   * The feature id for the '<em><b>Impact Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_IMPACT__IMPACT_VALUE = 1;

  /**
   * The number of structural features of the '<em>Transformation Impact</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_IMPACT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationDependencyListImpl <em>Transformation Dependency List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationDependencyListImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTransformationDependencyList()
   * @generated
   */
  int TRANSFORMATION_DEPENDENCY_LIST = 7;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY_LIST__NAME = 0;

  /**
   * The feature id for the '<em><b>Transformation Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES = 1;

  /**
   * The number of structural features of the '<em>Transformation Dependency List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY_LIST_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationDependencyImpl <em>Transformation Dependency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationDependencyImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTransformationDependency()
   * @generated
   */
  int TRANSFORMATION_DEPENDENCY = 8;

  /**
   * The feature id for the '<em><b>Applied Transformation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION = 0;

  /**
   * The feature id for the '<em><b>Applied Rule</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY__APPLIED_RULE = 1;

  /**
   * The feature id for the '<em><b>Fields</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY__FIELDS = 2;

  /**
   * The feature id for the '<em><b>Required Transformations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS = 3;

  /**
   * The feature id for the '<em><b>Bool OP</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY__BOOL_OP = 4;

  /**
   * The number of structural features of the '<em>Transformation Dependency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY_FEATURE_COUNT = 5;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.BooleanOperationsImpl <em>Boolean Operations</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.BooleanOperationsImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getBooleanOperations()
   * @generated
   */
  int BOOLEAN_OPERATIONS = 9;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_OPERATIONS__NAME = 0;

  /**
   * The number of structural features of the '<em>Boolean Operations</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_OPERATIONS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.RuleDependencyImpl <em>Rule Dependency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.RuleDependencyImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getRuleDependency()
   * @generated
   */
  int RULE_DEPENDENCY = 10;

  /**
   * The feature id for the '<em><b>Kw</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY__KW = 0;

  /**
   * The feature id for the '<em><b>Red</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY__RED = 1;

  /**
   * The feature id for the '<em><b>Bool OP</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY__BOOL_OP = 2;

  /**
   * The number of structural features of the '<em>Rule Dependency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.KeyWordImpl <em>Key Word</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.KeyWordImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getKeyWord()
   * @generated
   */
  int KEY_WORD = 11;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_WORD__NAME = 0;

  /**
   * The number of structural features of the '<em>Key Word</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int KEY_WORD_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.requiresOrExcludeDependencyImpl <em>requires Or Exclude Dependency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.requiresOrExcludeDependencyImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getrequiresOrExcludeDependency()
   * @generated
   */
  int REQUIRES_OR_EXCLUDE_DEPENDENCY = 12;

  /**
   * The feature id for the '<em><b>Required Transformation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRES_OR_EXCLUDE_DEPENDENCY__REQUIRED_TRANSFORMATION = 0;

  /**
   * The feature id for the '<em><b>Required Rule</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRES_OR_EXCLUDE_DEPENDENCY__REQUIRED_RULE = 1;

  /**
   * The feature id for the '<em><b>Fields</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRES_OR_EXCLUDE_DEPENDENCY__FIELDS = 2;

  /**
   * The feature id for the '<em><b>Ocl Expression</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRES_OR_EXCLUDE_DEPENDENCY__OCL_EXPRESSION = 3;

  /**
   * The number of structural features of the '<em>requires Or Exclude Dependency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRES_OR_EXCLUDE_DEPENDENCY_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.oclExprImpl <em>ocl Expr</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.oclExprImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getoclExpr()
   * @generated
   */
  int OCL_EXPR = 13;

  /**
   * The number of structural features of the '<em>ocl Expr</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OCL_EXPR_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ClassifierContextDeclCSImpl <em>Classifier Context Decl CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ClassifierContextDeclCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getClassifierContextDeclCS()
   * @generated
   */
  int CLASSIFIER_CONTEXT_DECL_CS = 14;

  /**
   * The feature id for the '<em><b>Self Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME = OCL_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Invariants</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS = OCL_EXPR_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Definitions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS = OCL_EXPR_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Classifier Context Decl CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CLASSIFIER_CONTEXT_DECL_CS_FEATURE_COUNT = OCL_EXPR_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.OperationContextDeclCSImpl <em>Operation Context Decl CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.OperationContextDeclCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getOperationContextDeclCS()
   * @generated
   */
  int OPERATION_CONTEXT_DECL_CS = 15;

  /**
   * The feature id for the '<em><b>Path Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CONTEXT_DECL_CS__PATH_NAME = 0;

  /**
   * The feature id for the '<em><b>Parameters</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CONTEXT_DECL_CS__PARAMETERS = 1;

  /**
   * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CONTEXT_DECL_CS__OWNED_TYPE = 2;

  /**
   * The feature id for the '<em><b>Preconditions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CONTEXT_DECL_CS__PRECONDITIONS = 3;

  /**
   * The feature id for the '<em><b>Postconditions</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS = 4;

  /**
   * The feature id for the '<em><b>Bodies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CONTEXT_DECL_CS__BODIES = 5;

  /**
   * The number of structural features of the '<em>Operation Context Decl CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int OPERATION_CONTEXT_DECL_CS_FEATURE_COUNT = 6;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ParameterCSImpl <em>Parameter CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ParameterCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getParameterCS()
   * @generated
   */
  int PARAMETER_CS = 16;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_CS__NAME = 0;

  /**
   * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_CS__OWNED_TYPE = 1;

  /**
   * The number of structural features of the '<em>Parameter CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PARAMETER_CS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstraintCSImpl <em>Constraint CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstraintCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getConstraintCS()
   * @generated
   */
  int CONSTRAINT_CS = 17;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_CS__NAME = 0;

  /**
   * The feature id for the '<em><b>Message Specification</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_CS__MESSAGE_SPECIFICATION = 1;

  /**
   * The feature id for the '<em><b>Specification</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_CS__SPECIFICATION = 2;

  /**
   * The number of structural features of the '<em>Constraint CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRAINT_CS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.DefCSImpl <em>Def CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.DefCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getDefCS()
   * @generated
   */
  int DEF_CS = 18;

  /**
   * The number of structural features of the '<em>Def CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEF_CS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.DefPropertyCSImpl <em>Def Property CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.DefPropertyCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getDefPropertyCS()
   * @generated
   */
  int DEF_PROPERTY_CS = 19;

  /**
   * The feature id for the '<em><b>Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEF_PROPERTY_CS__STATIC = DEF_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEF_PROPERTY_CS__NAME = DEF_CS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEF_PROPERTY_CS__OWNED_TYPE = DEF_CS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Specification</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEF_PROPERTY_CS__SPECIFICATION = DEF_CS_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Def Property CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEF_PROPERTY_CS_FEATURE_COUNT = DEF_CS_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypedRefCSImpl <em>Typed Ref CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypedRefCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTypedRefCS()
   * @generated
   */
  int TYPED_REF_CS = 20;

  /**
   * The number of structural features of the '<em>Typed Ref CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPED_REF_CS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.MultiplicityCSImpl <em>Multiplicity CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.MultiplicityCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getMultiplicityCS()
   * @generated
   */
  int MULTIPLICITY_CS = 21;

  /**
   * The number of structural features of the '<em>Multiplicity CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_CS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.MultiplicityStringCSImpl <em>Multiplicity String CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.MultiplicityStringCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getMultiplicityStringCS()
   * @generated
   */
  int MULTIPLICITY_STRING_CS = 22;

  /**
   * The feature id for the '<em><b>String Bounds</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_STRING_CS__STRING_BOUNDS = MULTIPLICITY_CS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Multiplicity String CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_STRING_CS_FEATURE_COUNT = MULTIPLICITY_CS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.MultiplicityBoundsCSImpl <em>Multiplicity Bounds CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.MultiplicityBoundsCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getMultiplicityBoundsCS()
   * @generated
   */
  int MULTIPLICITY_BOUNDS_CS = 23;

  /**
   * The feature id for the '<em><b>Lower Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_BOUNDS_CS__LOWER_BOUND = MULTIPLICITY_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Upper Bound</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_BOUNDS_CS__UPPER_BOUND = MULTIPLICITY_CS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Multiplicity Bounds CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MULTIPLICITY_BOUNDS_CS_FEATURE_COUNT = MULTIPLICITY_CS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NamedElementImpl <em>Named Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NamedElementImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getNamedElement()
   * @generated
   */
  int NAMED_ELEMENT = 24;

  /**
   * The feature id for the '<em><b>Is Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ELEMENT__IS_STATIC = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ELEMENT__NAME = 1;

  /**
   * The number of structural features of the '<em>Named Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAMED_ELEMENT_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NameSpaceImpl <em>Name Space</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NameSpaceImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getNameSpace()
   * @generated
   */
  int NAME_SPACE = 25;

  /**
   * The feature id for the '<em><b>Is Static</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_SPACE__IS_STATIC = NAMED_ELEMENT__IS_STATIC;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_SPACE__NAME = NAMED_ELEMENT__NAME;

  /**
   * The feature id for the '<em><b>ID</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_SPACE__ID = NAMED_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Name Space</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_SPACE_FEATURE_COUNT = NAMED_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeNameExpCSImpl <em>Type Name Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeNameExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTypeNameExpCS()
   * @generated
   */
  int TYPE_NAME_EXP_CS = 26;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NAME_EXP_CS__MULTIPLICITY = TYPED_REF_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Path Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NAME_EXP_CS__PATH_NAME = TYPED_REF_CS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Type Name Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_NAME_EXP_CS_FEATURE_COUNT = TYPED_REF_CS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PathNameCSImpl <em>Path Name CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PathNameCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPathNameCS()
   * @generated
   */
  int PATH_NAME_CS = 27;

  /**
   * The feature id for the '<em><b>Path</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_NAME_CS__PATH = 0;

  /**
   * The number of structural features of the '<em>Path Name CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_NAME_CS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PathElementCSImpl <em>Path Element CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PathElementCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPathElementCS()
   * @generated
   */
  int PATH_ELEMENT_CS = 28;

  /**
   * The feature id for the '<em><b>Element</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_ELEMENT_CS__ELEMENT = 0;

  /**
   * The number of structural features of the '<em>Path Element CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PATH_ELEMENT_CS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.SpecificationCSImpl <em>Specification CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.SpecificationCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getSpecificationCS()
   * @generated
   */
  int SPECIFICATION_CS = 29;

  /**
   * The feature id for the '<em><b>Owned Expression</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION_CS__OWNED_EXPRESSION = 0;

  /**
   * The feature id for the '<em><b>Expr String</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION_CS__EXPR_STRING = 1;

  /**
   * The number of structural features of the '<em>Specification CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION_CS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.BinaryOperatorCSImpl <em>Binary Operator CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.BinaryOperatorCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getBinaryOperatorCS()
   * @generated
   */
  int BINARY_OPERATOR_CS = 31;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_OPERATOR_CS__NAME = 0;

  /**
   * The number of structural features of the '<em>Binary Operator CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BINARY_OPERATOR_CS_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.EssentialOCLInfixOperatorCSImpl <em>Essential OCL Infix Operator CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.EssentialOCLInfixOperatorCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getEssentialOCLInfixOperatorCS()
   * @generated
   */
  int ESSENTIAL_OCL_INFIX_OPERATOR_CS = 30;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESSENTIAL_OCL_INFIX_OPERATOR_CS__NAME = BINARY_OPERATOR_CS__NAME;

  /**
   * The number of structural features of the '<em>Essential OCL Infix Operator CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESSENTIAL_OCL_INFIX_OPERATOR_CS_FEATURE_COUNT = BINARY_OPERATOR_CS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NavigationOperatorCSImpl <em>Navigation Operator CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NavigationOperatorCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getNavigationOperatorCS()
   * @generated
   */
  int NAVIGATION_OPERATOR_CS = 32;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAVIGATION_OPERATOR_CS__NAME = BINARY_OPERATOR_CS__NAME;

  /**
   * The number of structural features of the '<em>Navigation Operator CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAVIGATION_OPERATOR_CS_FEATURE_COUNT = BINARY_OPERATOR_CS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ContextCsImpl <em>Context Cs</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ContextCsImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getContextCs()
   * @generated
   */
  int CONTEXT_CS = 33;

  /**
   * The feature id for the '<em><b>Owned Expression</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_CS__OWNED_EXPRESSION = 0;

  /**
   * The feature id for the '<em><b>B</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_CS__B = 1;

  /**
   * The feature id for the '<em><b>BO</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_CS__BO = 2;

  /**
   * The number of structural features of the '<em>Context Cs</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONTEXT_CS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ExpressCSImpl <em>Express CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ExpressCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getExpressCS()
   * @generated
   */
  int EXPRESS_CS = 34;

  /**
   * The feature id for the '<em><b>Owned Expression</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESS_CS__OWNED_EXPRESSION = OCL_EXPR_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Operator</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESS_CS__OWNED_OPERATOR = OCL_EXPR_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Express CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXPRESS_CS_FEATURE_COUNT = OCL_EXPR_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrefixedExpCSImpl <em>Prefixed Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrefixedExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPrefixedExpCS()
   * @generated
   */
  int PREFIXED_EXP_CS = 35;

  /**
   * The number of structural features of the '<em>Prefixed Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIXED_EXP_CS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.EssentialOCLPrefixOperatorImpl <em>Essential OCL Prefix Operator</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.EssentialOCLPrefixOperatorImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getEssentialOCLPrefixOperator()
   * @generated
   */
  int ESSENTIAL_OCL_PREFIX_OPERATOR = 36;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESSENTIAL_OCL_PREFIX_OPERATOR__NAME = 0;

  /**
   * The number of structural features of the '<em>Essential OCL Prefix Operator</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ESSENTIAL_OCL_PREFIX_OPERATOR_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrefixedExpOrLetExpCSImpl <em>Prefixed Exp Or Let Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrefixedExpOrLetExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPrefixedExpOrLetExpCS()
   * @generated
   */
  int PREFIXED_EXP_OR_LET_EXP_CS = 37;

  /**
   * The number of structural features of the '<em>Prefixed Exp Or Let Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIXED_EXP_OR_LET_EXP_CS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrimaryExpCSImpl <em>Primary Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrimaryExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPrimaryExpCS()
   * @generated
   */
  int PRIMARY_EXP_CS = 38;

  /**
   * The number of structural features of the '<em>Primary Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXP_CS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstructorPartCSImpl <em>Constructor Part CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstructorPartCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getConstructorPartCS()
   * @generated
   */
  int CONSTRUCTOR_PART_CS = 39;

  /**
   * The feature id for the '<em><b>Property</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_PART_CS__PROPERTY = 0;

  /**
   * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_PART_CS__INIT_EXPRESSION = 1;

  /**
   * The number of structural features of the '<em>Constructor Part CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_PART_CS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeLiteralWithMultiplicityCSImpl <em>Type Literal With Multiplicity CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeLiteralWithMultiplicityCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTypeLiteralWithMultiplicityCS()
   * @generated
   */
  int TYPE_LITERAL_WITH_MULTIPLICITY_CS = 40;

  /**
   * The number of structural features of the '<em>Type Literal With Multiplicity CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_LITERAL_WITH_MULTIPLICITY_CS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeLiteralCSImpl <em>Type Literal CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeLiteralCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTypeLiteralCS()
   * @generated
   */
  int TYPE_LITERAL_CS = 41;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_LITERAL_CS__MULTIPLICITY = TYPE_LITERAL_WITH_MULTIPLICITY_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_LITERAL_CS__NAME = TYPE_LITERAL_WITH_MULTIPLICITY_CS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Type Literal CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_LITERAL_CS_FEATURE_COUNT = TYPE_LITERAL_WITH_MULTIPLICITY_CS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TupleTypeCSImpl <em>Tuple Type CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TupleTypeCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTupleTypeCS()
   * @generated
   */
  int TUPLE_TYPE_CS = 42;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE_CS__MULTIPLICITY = TYPE_LITERAL_CS__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE_CS__NAME = TYPE_LITERAL_CS__NAME;

  /**
   * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE_CS__OWNED_PARTS = TYPE_LITERAL_CS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tuple Type CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_TYPE_CS_FEATURE_COUNT = TYPE_LITERAL_CS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TuplePartCSImpl <em>Tuple Part CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TuplePartCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTuplePartCS()
   * @generated
   */
  int TUPLE_PART_CS = 43;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_PART_CS__NAME = 0;

  /**
   * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_PART_CS__OWNED_TYPE = 1;

  /**
   * The number of structural features of the '<em>Tuple Part CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_PART_CS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrimitiveTypeCSImpl <em>Primitive Type CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrimitiveTypeCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPrimitiveTypeCS()
   * @generated
   */
  int PRIMITIVE_TYPE_CS = 44;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE_CS__MULTIPLICITY = TYPE_LITERAL_CS__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE_CS__NAME = TYPE_LITERAL_CS__NAME;

  /**
   * The number of structural features of the '<em>Primitive Type CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_TYPE_CS_FEATURE_COUNT = TYPE_LITERAL_CS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeLiteralExpCSImpl <em>Type Literal Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeLiteralExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTypeLiteralExpCS()
   * @generated
   */
  int TYPE_LITERAL_EXP_CS = 45;

  /**
   * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_LITERAL_EXP_CS__OWNED_TYPE = PRIMARY_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Type Literal Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TYPE_LITERAL_EXP_CS_FEATURE_COUNT = PRIMARY_EXP_CS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.CollectionLiteralExpCSImpl <em>Collection Literal Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.CollectionLiteralExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getCollectionLiteralExpCS()
   * @generated
   */
  int COLLECTION_LITERAL_EXP_CS = 46;

  /**
   * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_LITERAL_EXP_CS__OWNED_TYPE = PRIMARY_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_LITERAL_EXP_CS__OWNED_PARTS = PRIMARY_EXP_CS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Collection Literal Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_LITERAL_EXP_CS_FEATURE_COUNT = PRIMARY_EXP_CS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.CollectionLiteralPartCSImpl <em>Collection Literal Part CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.CollectionLiteralPartCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getCollectionLiteralPartCS()
   * @generated
   */
  int COLLECTION_LITERAL_PART_CS = 47;

  /**
   * The feature id for the '<em><b>Expression CS</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_LITERAL_PART_CS__EXPRESSION_CS = 0;

  /**
   * The feature id for the '<em><b>Last Expression CS</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS = 1;

  /**
   * The number of structural features of the '<em>Collection Literal Part CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_LITERAL_PART_CS_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.CollectionTypeCSImpl <em>Collection Type CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.CollectionTypeCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getCollectionTypeCS()
   * @generated
   */
  int COLLECTION_TYPE_CS = 48;

  /**
   * The feature id for the '<em><b>Multiplicity</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_TYPE_CS__MULTIPLICITY = TYPE_LITERAL_CS__MULTIPLICITY;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_TYPE_CS__NAME = TYPE_LITERAL_CS__NAME;

  /**
   * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_TYPE_CS__OWNED_TYPE = TYPE_LITERAL_CS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Collection Type CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int COLLECTION_TYPE_CS_FEATURE_COUNT = TYPE_LITERAL_CS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NestedExpCSImpl <em>Nested Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NestedExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getNestedExpCS()
   * @generated
   */
  int NESTED_EXP_CS = 49;

  /**
   * The feature id for the '<em><b>Source</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_EXP_CS__SOURCE = PRIMARY_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Nested Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NESTED_EXP_CS_FEATURE_COUNT = PRIMARY_EXP_CS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.SelfExpCSImpl <em>Self Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.SelfExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getSelfExpCS()
   * @generated
   */
  int SELF_EXP_CS = 50;

  /**
   * The number of structural features of the '<em>Self Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SELF_EXP_CS_FEATURE_COUNT = PRIMARY_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrimaryExpOrLetExpCSImpl <em>Primary Exp Or Let Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrimaryExpOrLetExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPrimaryExpOrLetExpCS()
   * @generated
   */
  int PRIMARY_EXP_OR_LET_EXP_CS = 51;

  /**
   * The feature id for the '<em><b>Owned Expression</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXP_OR_LET_EXP_CS__OWNED_EXPRESSION = EXPRESS_CS__OWNED_EXPRESSION;

  /**
   * The feature id for the '<em><b>Owned Operator</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXP_OR_LET_EXP_CS__OWNED_OPERATOR = EXPRESS_CS__OWNED_OPERATOR;

  /**
   * The number of structural features of the '<em>Primary Exp Or Let Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMARY_EXP_OR_LET_EXP_CS_FEATURE_COUNT = EXPRESS_CS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.LetExpCSImpl <em>Let Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.LetExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getLetExpCS()
   * @generated
   */
  int LET_EXP_CS = 52;

  /**
   * The feature id for the '<em><b>Owned Expression</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXP_CS__OWNED_EXPRESSION = PRIMARY_EXP_OR_LET_EXP_CS__OWNED_EXPRESSION;

  /**
   * The feature id for the '<em><b>Owned Operator</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXP_CS__OWNED_OPERATOR = PRIMARY_EXP_OR_LET_EXP_CS__OWNED_OPERATOR;

  /**
   * The feature id for the '<em><b>Variable</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXP_CS__VARIABLE = PRIMARY_EXP_OR_LET_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>In</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXP_CS__IN = PRIMARY_EXP_OR_LET_EXP_CS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Let Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_EXP_CS_FEATURE_COUNT = PRIMARY_EXP_OR_LET_EXP_CS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.LetVariableCSImpl <em>Let Variable CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.LetVariableCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getLetVariableCS()
   * @generated
   */
  int LET_VARIABLE_CS = 53;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_VARIABLE_CS__NAME = 0;

  /**
   * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_VARIABLE_CS__OWNED_TYPE = 1;

  /**
   * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_VARIABLE_CS__INIT_EXPRESSION = 2;

  /**
   * The number of structural features of the '<em>Let Variable CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int LET_VARIABLE_CS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NavigatingArgCSImpl <em>Navigating Arg CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NavigatingArgCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getNavigatingArgCS()
   * @generated
   */
  int NAVIGATING_ARG_CS = 54;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAVIGATING_ARG_CS__NAME = 0;

  /**
   * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAVIGATING_ARG_CS__OWNED_TYPE = 1;

  /**
   * The feature id for the '<em><b>Init</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAVIGATING_ARG_CS__INIT = 2;

  /**
   * The feature id for the '<em><b>Prefix</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAVIGATING_ARG_CS__PREFIX = 3;

  /**
   * The number of structural features of the '<em>Navigating Arg CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAVIGATING_ARG_CS_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ExpCSImpl <em>Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getExpCS()
   * @generated
   */
  int EXP_CS = 55;

  /**
   * The number of structural features of the '<em>Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXP_CS_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.IfExpCSImpl <em>If Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.IfExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getIfExpCS()
   * @generated
   */
  int IF_EXP_CS = 56;

  /**
   * The feature id for the '<em><b>Condition</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXP_CS__CONDITION = PRIMARY_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Then Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXP_CS__THEN_EXPRESSION = PRIMARY_EXP_CS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Else Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXP_CS__ELSE_EXPRESSION = PRIMARY_EXP_CS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>If Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int IF_EXP_CS_FEATURE_COUNT = PRIMARY_EXP_CS_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TupleLiteralExpCSImpl <em>Tuple Literal Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TupleLiteralExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTupleLiteralExpCS()
   * @generated
   */
  int TUPLE_LITERAL_EXP_CS = 57;

  /**
   * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL_EXP_CS__OWNED_PARTS = PRIMARY_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Tuple Literal Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL_EXP_CS_FEATURE_COUNT = PRIMARY_EXP_CS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TupleLiteralPartCSImpl <em>Tuple Literal Part CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TupleLiteralPartCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTupleLiteralPartCS()
   * @generated
   */
  int TUPLE_LITERAL_PART_CS = 58;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL_PART_CS__NAME = 0;

  /**
   * The feature id for the '<em><b>Owned Type</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL_PART_CS__OWNED_TYPE = 1;

  /**
   * The feature id for the '<em><b>Init Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL_PART_CS__INIT_EXPRESSION = 2;

  /**
   * The number of structural features of the '<em>Tuple Literal Part CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TUPLE_LITERAL_PART_CS_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrimitiveLiteralExpCSImpl <em>Primitive Literal Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrimitiveLiteralExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPrimitiveLiteralExpCS()
   * @generated
   */
  int PRIMITIVE_LITERAL_EXP_CS = 59;

  /**
   * The number of structural features of the '<em>Primitive Literal Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT = PRIMARY_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NumberLiteralExpCSImpl <em>Number Literal Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NumberLiteralExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getNumberLiteralExpCS()
   * @generated
   */
  int NUMBER_LITERAL_EXP_CS = 60;

  /**
   * The feature id for the '<em><b>Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL_EXP_CS__NAME = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Number Literal Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NUMBER_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.BigNumberImpl <em>Big Number</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.BigNumberImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getBigNumber()
   * @generated
   */
  int BIG_NUMBER = 61;

  /**
   * The feature id for the '<em><b>Number</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_NUMBER__NUMBER = 0;

  /**
   * The number of structural features of the '<em>Big Number</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BIG_NUMBER_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.StringLiteralExpCSImpl <em>String Literal Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.StringLiteralExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getStringLiteralExpCS()
   * @generated
   */
  int STRING_LITERAL_EXP_CS = 62;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_EXP_CS__NAME = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>String Literal Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int STRING_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.BooleanLiteralExpCSImpl <em>Boolean Literal Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.BooleanLiteralExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getBooleanLiteralExpCS()
   * @generated
   */
  int BOOLEAN_LITERAL_EXP_CS = 63;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_EXP_CS__NAME = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Boolean Literal Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int BOOLEAN_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.UnlimitedNaturalLiteralExpCSImpl <em>Unlimited Natural Literal Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.UnlimitedNaturalLiteralExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getUnlimitedNaturalLiteralExpCS()
   * @generated
   */
  int UNLIMITED_NATURAL_LITERAL_EXP_CS = 64;

  /**
   * The number of structural features of the '<em>Unlimited Natural Literal Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int UNLIMITED_NATURAL_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.InvalidLiteralExpCSImpl <em>Invalid Literal Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.InvalidLiteralExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getInvalidLiteralExpCS()
   * @generated
   */
  int INVALID_LITERAL_EXP_CS = 65;

  /**
   * The number of structural features of the '<em>Invalid Literal Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVALID_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NullLiteralExpCSImpl <em>Null Literal Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NullLiteralExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getNullLiteralExpCS()
   * @generated
   */
  int NULL_LITERAL_EXP_CS = 66;

  /**
   * The number of structural features of the '<em>Null Literal Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NULL_LITERAL_EXP_CS_FEATURE_COUNT = PRIMITIVE_LITERAL_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrefixExpCSImpl <em>Prefix Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrefixExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPrefixExpCS()
   * @generated
   */
  int PREFIX_EXP_CS = 67;

  /**
   * The feature id for the '<em><b>Owned Operator</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIX_EXP_CS__OWNED_OPERATOR = PREFIXED_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Expression</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIX_EXP_CS__OWNED_EXPRESSION = PREFIXED_EXP_CS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Prefix Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int PREFIX_EXP_CS_FEATURE_COUNT = PREFIXED_EXP_CS_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.IndexExpCSImpl <em>Index Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.IndexExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getIndexExpCS()
   * @generated
   */
  int INDEX_EXP_CS = 68;

  /**
   * The feature id for the '<em><b>Path Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEX_EXP_CS__PATH_NAME = PRIMARY_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>First Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEX_EXP_CS__FIRST_INDEXES = PRIMARY_EXP_CS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Second Indexes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEX_EXP_CS__SECOND_INDEXES = PRIMARY_EXP_CS_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>At Pre</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEX_EXP_CS__AT_PRE = PRIMARY_EXP_CS_FEATURE_COUNT + 3;

  /**
   * The number of structural features of the '<em>Index Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INDEX_EXP_CS_FEATURE_COUNT = PRIMARY_EXP_CS_FEATURE_COUNT + 4;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstructorExpCSImpl <em>Constructor Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstructorExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getConstructorExpCS()
   * @generated
   */
  int CONSTRUCTOR_EXP_CS = 69;

  /**
   * The feature id for the '<em><b>Path Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_EXP_CS__PATH_NAME = PRIMARY_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Owned Parts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_EXP_CS__OWNED_PARTS = PRIMARY_EXP_CS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_EXP_CS__VALUE = PRIMARY_EXP_CS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Constructor Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int CONSTRUCTOR_EXP_CS_FEATURE_COUNT = PRIMARY_EXP_CS_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.InvocationExpCSImpl <em>Invocation Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.InvocationExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getInvocationExpCS()
   * @generated
   */
  int INVOCATION_EXP_CS = 70;

  /**
   * The feature id for the '<em><b>Path Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_EXP_CS__PATH_NAME = PRIMARY_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>At Pre</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_EXP_CS__AT_PRE = PRIMARY_EXP_CS_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Argument</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_EXP_CS__ARGUMENT = PRIMARY_EXP_CS_FEATURE_COUNT + 2;

  /**
   * The number of structural features of the '<em>Invocation Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int INVOCATION_EXP_CS_FEATURE_COUNT = PRIMARY_EXP_CS_FEATURE_COUNT + 3;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NameExpCSImpl <em>Name Exp CS</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NameExpCSImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getNameExpCS()
   * @generated
   */
  int NAME_EXP_CS = 71;

  /**
   * The feature id for the '<em><b>Path Name</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_EXP_CS__PATH_NAME = PRIMARY_EXP_CS_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>At Pre</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_EXP_CS__AT_PRE = PRIMARY_EXP_CS_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Name Exp CS</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int NAME_EXP_CS_FEATURE_COUNT = PRIMARY_EXP_CS_FEATURE_COUNT + 2;


  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TrcSpecification <em>Trc Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trc Specification</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TrcSpecification
   * @generated
   */
  EClass getTrcSpecification();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TrcSpecification#getModuleList <em>Module List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Module List</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TrcSpecification#getModuleList()
   * @see #getTrcSpecification()
   * @generated
   */
  EReference getTrcSpecification_ModuleList();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TrcSpecification#getTransformationList <em>Transformation List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transformation List</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TrcSpecification#getTransformationList()
   * @see #getTrcSpecification()
   * @generated
   */
  EReference getTrcSpecification_TransformationList();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TrcSpecification#getDependencyList <em>Dependency List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Dependency List</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TrcSpecification#getDependencyList()
   * @see #getTrcSpecification()
   * @generated
   */
  EReference getTrcSpecification_DependencyList();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.trcRule <em>trc Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>trc Rule</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.trcRule
   * @generated
   */
  EClass gettrcRule();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.trcRule#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.trcRule#getName()
   * @see #gettrcRule()
   * @generated
   */
  EAttribute gettrcRule_Name();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ModuleList <em>Module List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module List</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ModuleList
   * @generated
   */
  EClass getModuleList();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ModuleList#getModules <em>Modules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Modules</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ModuleList#getModules()
   * @see #getModuleList()
   * @generated
   */
  EReference getModuleList_Modules();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Module
   * @generated
   */
  EClass getModule();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Module#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Module#getName()
   * @see #getModule()
   * @generated
   */
  EAttribute getModule_Name();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Module#getRules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rules</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Module#getRules()
   * @see #getModule()
   * @generated
   */
  EReference getModule_Rules();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationList <em>Transformation List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation List</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationList
   * @generated
   */
  EClass getTransformationList();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationList#getTransformations <em>Transformations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transformations</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationList#getTransformations()
   * @see #getTransformationList()
   * @generated
   */
  EReference getTransformationList_Transformations();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation <em>Transformation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation
   * @generated
   */
  EClass getTransformation();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation#getName()
   * @see #getTransformation()
   * @generated
   */
  EAttribute getTransformation_Name();

  /**
   * Returns the meta object for the reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation#getModules <em>Modules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Modules</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation#getModules()
   * @see #getTransformation()
   * @generated
   */
  EReference getTransformation_Modules();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation#getImpacts <em>Impacts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Impacts</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation#getImpacts()
   * @see #getTransformation()
   * @generated
   */
  EReference getTransformation_Impacts();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationImpact <em>Transformation Impact</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation Impact</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationImpact
   * @generated
   */
  EClass getTransformationImpact();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationImpact#getQualityAttributeName <em>Quality Attribute Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Quality Attribute Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationImpact#getQualityAttributeName()
   * @see #getTransformationImpact()
   * @generated
   */
  EAttribute getTransformationImpact_QualityAttributeName();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationImpact#getImpactValue <em>Impact Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Impact Value</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationImpact#getImpactValue()
   * @see #getTransformationImpact()
   * @generated
   */
  EAttribute getTransformationImpact_ImpactValue();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependencyList <em>Transformation Dependency List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation Dependency List</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependencyList
   * @generated
   */
  EClass getTransformationDependencyList();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependencyList#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependencyList#getName()
   * @see #getTransformationDependencyList()
   * @generated
   */
  EAttribute getTransformationDependencyList_Name();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependencyList#getTransformationDependencies <em>Transformation Dependencies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transformation Dependencies</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependencyList#getTransformationDependencies()
   * @see #getTransformationDependencyList()
   * @generated
   */
  EReference getTransformationDependencyList_TransformationDependencies();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency <em>Transformation Dependency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation Dependency</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency
   * @generated
   */
  EClass getTransformationDependency();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getAppliedTransformation <em>Applied Transformation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Applied Transformation</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getAppliedTransformation()
   * @see #getTransformationDependency()
   * @generated
   */
  EReference getTransformationDependency_AppliedTransformation();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getAppliedRule <em>Applied Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Applied Rule</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getAppliedRule()
   * @see #getTransformationDependency()
   * @generated
   */
  EReference getTransformationDependency_AppliedRule();

  /**
   * Returns the meta object for the attribute list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Fields</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getFields()
   * @see #getTransformationDependency()
   * @generated
   */
  EAttribute getTransformationDependency_Fields();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getRequiredTransformations <em>Required Transformations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Required Transformations</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getRequiredTransformations()
   * @see #getTransformationDependency()
   * @generated
   */
  EReference getTransformationDependency_RequiredTransformations();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getBoolOP <em>Bool OP</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Bool OP</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency#getBoolOP()
   * @see #getTransformationDependency()
   * @generated
   */
  EReference getTransformationDependency_BoolOP();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BooleanOperations <em>Boolean Operations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Operations</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BooleanOperations
   * @generated
   */
  EClass getBooleanOperations();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BooleanOperations#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BooleanOperations#getName()
   * @see #getBooleanOperations()
   * @generated
   */
  EAttribute getBooleanOperations_Name();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency <em>Rule Dependency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Dependency</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency
   * @generated
   */
  EClass getRuleDependency();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency#getKw <em>Kw</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Kw</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency#getKw()
   * @see #getRuleDependency()
   * @generated
   */
  EReference getRuleDependency_Kw();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency#getRed <em>Red</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Red</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency#getRed()
   * @see #getRuleDependency()
   * @generated
   */
  EReference getRuleDependency_Red();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency#getBoolOP <em>Bool OP</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Bool OP</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency#getBoolOP()
   * @see #getRuleDependency()
   * @generated
   */
  EReference getRuleDependency_BoolOP();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.KeyWord <em>Key Word</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Key Word</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.KeyWord
   * @generated
   */
  EClass getKeyWord();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.KeyWord#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.KeyWord#getName()
   * @see #getKeyWord()
   * @generated
   */
  EAttribute getKeyWord_Name();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency <em>requires Or Exclude Dependency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>requires Or Exclude Dependency</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency
   * @generated
   */
  EClass getrequiresOrExcludeDependency();

  /**
   * Returns the meta object for the reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency#getRequiredTransformation <em>Required Transformation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Required Transformation</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency#getRequiredTransformation()
   * @see #getrequiresOrExcludeDependency()
   * @generated
   */
  EReference getrequiresOrExcludeDependency_RequiredTransformation();

  /**
   * Returns the meta object for the reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency#getRequiredRule <em>Required Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Required Rule</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency#getRequiredRule()
   * @see #getrequiresOrExcludeDependency()
   * @generated
   */
  EReference getrequiresOrExcludeDependency_RequiredRule();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fields</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency#getFields()
   * @see #getrequiresOrExcludeDependency()
   * @generated
   */
  EAttribute getrequiresOrExcludeDependency_Fields();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency#getOclExpression <em>Ocl Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ocl Expression</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency#getOclExpression()
   * @see #getrequiresOrExcludeDependency()
   * @generated
   */
  EReference getrequiresOrExcludeDependency_OclExpression();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.oclExpr <em>ocl Expr</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>ocl Expr</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.oclExpr
   * @generated
   */
  EClass getoclExpr();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ClassifierContextDeclCS <em>Classifier Context Decl CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Classifier Context Decl CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ClassifierContextDeclCS
   * @generated
   */
  EClass getClassifierContextDeclCS();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ClassifierContextDeclCS#getSelfName <em>Self Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Self Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ClassifierContextDeclCS#getSelfName()
   * @see #getClassifierContextDeclCS()
   * @generated
   */
  EAttribute getClassifierContextDeclCS_SelfName();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ClassifierContextDeclCS#getInvariants <em>Invariants</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Invariants</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ClassifierContextDeclCS#getInvariants()
   * @see #getClassifierContextDeclCS()
   * @generated
   */
  EReference getClassifierContextDeclCS_Invariants();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ClassifierContextDeclCS#getDefinitions <em>Definitions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Definitions</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ClassifierContextDeclCS#getDefinitions()
   * @see #getClassifierContextDeclCS()
   * @generated
   */
  EReference getClassifierContextDeclCS_Definitions();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS <em>Operation Context Decl CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Operation Context Decl CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS
   * @generated
   */
  EClass getOperationContextDeclCS();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getPathName <em>Path Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getPathName()
   * @see #getOperationContextDeclCS()
   * @generated
   */
  EReference getOperationContextDeclCS_PathName();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getParameters <em>Parameters</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Parameters</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getParameters()
   * @see #getOperationContextDeclCS()
   * @generated
   */
  EReference getOperationContextDeclCS_Parameters();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getOwnedType <em>Owned Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Owned Type</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getOwnedType()
   * @see #getOperationContextDeclCS()
   * @generated
   */
  EReference getOperationContextDeclCS_OwnedType();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getPreconditions <em>Preconditions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Preconditions</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getPreconditions()
   * @see #getOperationContextDeclCS()
   * @generated
   */
  EReference getOperationContextDeclCS_Preconditions();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getPostconditions <em>Postconditions</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Postconditions</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getPostconditions()
   * @see #getOperationContextDeclCS()
   * @generated
   */
  EReference getOperationContextDeclCS_Postconditions();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getBodies <em>Bodies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Bodies</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS#getBodies()
   * @see #getOperationContextDeclCS()
   * @generated
   */
  EReference getOperationContextDeclCS_Bodies();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ParameterCS <em>Parameter CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Parameter CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ParameterCS
   * @generated
   */
  EClass getParameterCS();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ParameterCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ParameterCS#getName()
   * @see #getParameterCS()
   * @generated
   */
  EAttribute getParameterCS_Name();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ParameterCS#getOwnedType <em>Owned Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Owned Type</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ParameterCS#getOwnedType()
   * @see #getParameterCS()
   * @generated
   */
  EReference getParameterCS_OwnedType();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS <em>Constraint CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constraint CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS
   * @generated
   */
  EClass getConstraintCS();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS#getName()
   * @see #getConstraintCS()
   * @generated
   */
  EAttribute getConstraintCS_Name();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS#getMessageSpecification <em>Message Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Message Specification</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS#getMessageSpecification()
   * @see #getConstraintCS()
   * @generated
   */
  EReference getConstraintCS_MessageSpecification();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS#getSpecification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Specification</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS#getSpecification()
   * @see #getConstraintCS()
   * @generated
   */
  EReference getConstraintCS_Specification();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefCS <em>Def CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Def CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefCS
   * @generated
   */
  EClass getDefCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefPropertyCS <em>Def Property CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Def Property CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefPropertyCS
   * @generated
   */
  EClass getDefPropertyCS();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefPropertyCS#isStatic <em>Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Static</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefPropertyCS#isStatic()
   * @see #getDefPropertyCS()
   * @generated
   */
  EAttribute getDefPropertyCS_Static();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefPropertyCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefPropertyCS#getName()
   * @see #getDefPropertyCS()
   * @generated
   */
  EAttribute getDefPropertyCS_Name();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefPropertyCS#getOwnedType <em>Owned Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Owned Type</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefPropertyCS#getOwnedType()
   * @see #getDefPropertyCS()
   * @generated
   */
  EReference getDefPropertyCS_OwnedType();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefPropertyCS#getSpecification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Specification</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefPropertyCS#getSpecification()
   * @see #getDefPropertyCS()
   * @generated
   */
  EReference getDefPropertyCS_Specification();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypedRefCS <em>Typed Ref CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Typed Ref CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypedRefCS
   * @generated
   */
  EClass getTypedRefCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityCS <em>Multiplicity CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicity CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityCS
   * @generated
   */
  EClass getMultiplicityCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityStringCS <em>Multiplicity String CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicity String CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityStringCS
   * @generated
   */
  EClass getMultiplicityStringCS();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityStringCS#getStringBounds <em>String Bounds</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>String Bounds</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityStringCS#getStringBounds()
   * @see #getMultiplicityStringCS()
   * @generated
   */
  EAttribute getMultiplicityStringCS_StringBounds();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityBoundsCS <em>Multiplicity Bounds CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Multiplicity Bounds CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityBoundsCS
   * @generated
   */
  EClass getMultiplicityBoundsCS();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityBoundsCS#getLowerBound <em>Lower Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Lower Bound</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityBoundsCS#getLowerBound()
   * @see #getMultiplicityBoundsCS()
   * @generated
   */
  EAttribute getMultiplicityBoundsCS_LowerBound();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityBoundsCS#getUpperBound <em>Upper Bound</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Upper Bound</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityBoundsCS#getUpperBound()
   * @see #getMultiplicityBoundsCS()
   * @generated
   */
  EAttribute getMultiplicityBoundsCS_UpperBound();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Named Element</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NamedElement
   * @generated
   */
  EClass getNamedElement();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NamedElement#isIsStatic <em>Is Static</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Static</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NamedElement#isIsStatic()
   * @see #getNamedElement()
   * @generated
   */
  EAttribute getNamedElement_IsStatic();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NamedElement#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NamedElement#getName()
   * @see #getNamedElement()
   * @generated
   */
  EAttribute getNamedElement_Name();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameSpace <em>Name Space</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Name Space</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameSpace
   * @generated
   */
  EClass getNameSpace();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameSpace#getID <em>ID</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>ID</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameSpace#getID()
   * @see #getNameSpace()
   * @generated
   */
  EAttribute getNameSpace_ID();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeNameExpCS <em>Type Name Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Name Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeNameExpCS
   * @generated
   */
  EClass getTypeNameExpCS();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeNameExpCS#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplicity</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeNameExpCS#getMultiplicity()
   * @see #getTypeNameExpCS()
   * @generated
   */
  EReference getTypeNameExpCS_Multiplicity();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeNameExpCS#getPathName <em>Path Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeNameExpCS#getPathName()
   * @see #getTypeNameExpCS()
   * @generated
   */
  EReference getTypeNameExpCS_PathName();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathNameCS <em>Path Name CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Path Name CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathNameCS
   * @generated
   */
  EClass getPathNameCS();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathNameCS#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Path</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathNameCS#getPath()
   * @see #getPathNameCS()
   * @generated
   */
  EReference getPathNameCS_Path();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathElementCS <em>Path Element CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Path Element CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathElementCS
   * @generated
   */
  EClass getPathElementCS();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathElementCS#getElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Element</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathElementCS#getElement()
   * @see #getPathElementCS()
   * @generated
   */
  EReference getPathElementCS_Element();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS <em>Specification CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Specification CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS
   * @generated
   */
  EClass getSpecificationCS();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS#getOwnedExpression <em>Owned Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Expression</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS#getOwnedExpression()
   * @see #getSpecificationCS()
   * @generated
   */
  EReference getSpecificationCS_OwnedExpression();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS#getExprString <em>Expr String</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Expr String</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS#getExprString()
   * @see #getSpecificationCS()
   * @generated
   */
  EAttribute getSpecificationCS_ExprString();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.EssentialOCLInfixOperatorCS <em>Essential OCL Infix Operator CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Essential OCL Infix Operator CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.EssentialOCLInfixOperatorCS
   * @generated
   */
  EClass getEssentialOCLInfixOperatorCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BinaryOperatorCS <em>Binary Operator CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Binary Operator CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BinaryOperatorCS
   * @generated
   */
  EClass getBinaryOperatorCS();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BinaryOperatorCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BinaryOperatorCS#getName()
   * @see #getBinaryOperatorCS()
   * @generated
   */
  EAttribute getBinaryOperatorCS_Name();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigationOperatorCS <em>Navigation Operator CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Navigation Operator CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigationOperatorCS
   * @generated
   */
  EClass getNavigationOperatorCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs <em>Context Cs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Context Cs</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs
   * @generated
   */
  EClass getContextCs();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs#getOwnedExpression <em>Owned Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Expression</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs#getOwnedExpression()
   * @see #getContextCs()
   * @generated
   */
  EReference getContextCs_OwnedExpression();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs#getB <em>B</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>B</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs#getB()
   * @see #getContextCs()
   * @generated
   */
  EReference getContextCs_B();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs#getBO <em>BO</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>BO</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs#getBO()
   * @see #getContextCs()
   * @generated
   */
  EReference getContextCs_BO();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpressCS <em>Express CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Express CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpressCS
   * @generated
   */
  EClass getExpressCS();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpressCS#getOwnedExpression <em>Owned Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Expression</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpressCS#getOwnedExpression()
   * @see #getExpressCS()
   * @generated
   */
  EReference getExpressCS_OwnedExpression();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpressCS#getOwnedOperator <em>Owned Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Operator</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpressCS#getOwnedOperator()
   * @see #getExpressCS()
   * @generated
   */
  EReference getExpressCS_OwnedOperator();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixedExpCS <em>Prefixed Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Prefixed Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixedExpCS
   * @generated
   */
  EClass getPrefixedExpCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.EssentialOCLPrefixOperator <em>Essential OCL Prefix Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Essential OCL Prefix Operator</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.EssentialOCLPrefixOperator
   * @generated
   */
  EClass getEssentialOCLPrefixOperator();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.EssentialOCLPrefixOperator#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.EssentialOCLPrefixOperator#getName()
   * @see #getEssentialOCLPrefixOperator()
   * @generated
   */
  EAttribute getEssentialOCLPrefixOperator_Name();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixedExpOrLetExpCS <em>Prefixed Exp Or Let Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Prefixed Exp Or Let Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixedExpOrLetExpCS
   * @generated
   */
  EClass getPrefixedExpOrLetExpCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimaryExpCS <em>Primary Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimaryExpCS
   * @generated
   */
  EClass getPrimaryExpCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorPartCS <em>Constructor Part CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constructor Part CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorPartCS
   * @generated
   */
  EClass getConstructorPartCS();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorPartCS#getProperty <em>Property</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Property</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorPartCS#getProperty()
   * @see #getConstructorPartCS()
   * @generated
   */
  EAttribute getConstructorPartCS_Property();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorPartCS#getInitExpression <em>Init Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init Expression</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorPartCS#getInitExpression()
   * @see #getConstructorPartCS()
   * @generated
   */
  EReference getConstructorPartCS_InitExpression();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralWithMultiplicityCS <em>Type Literal With Multiplicity CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Literal With Multiplicity CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralWithMultiplicityCS
   * @generated
   */
  EClass getTypeLiteralWithMultiplicityCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralCS <em>Type Literal CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Literal CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralCS
   * @generated
   */
  EClass getTypeLiteralCS();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralCS#getMultiplicity <em>Multiplicity</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Multiplicity</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralCS#getMultiplicity()
   * @see #getTypeLiteralCS()
   * @generated
   */
  EReference getTypeLiteralCS_Multiplicity();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralCS#getName()
   * @see #getTypeLiteralCS()
   * @generated
   */
  EAttribute getTypeLiteralCS_Name();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleTypeCS <em>Tuple Type CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Type CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleTypeCS
   * @generated
   */
  EClass getTupleTypeCS();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleTypeCS#getOwnedParts <em>Owned Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleTypeCS#getOwnedParts()
   * @see #getTupleTypeCS()
   * @generated
   */
  EReference getTupleTypeCS_OwnedParts();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TuplePartCS <em>Tuple Part CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Part CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TuplePartCS
   * @generated
   */
  EClass getTuplePartCS();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TuplePartCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TuplePartCS#getName()
   * @see #getTuplePartCS()
   * @generated
   */
  EAttribute getTuplePartCS_Name();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TuplePartCS#getOwnedType <em>Owned Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Owned Type</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TuplePartCS#getOwnedType()
   * @see #getTuplePartCS()
   * @generated
   */
  EReference getTuplePartCS_OwnedType();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimitiveTypeCS <em>Primitive Type CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primitive Type CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimitiveTypeCS
   * @generated
   */
  EClass getPrimitiveTypeCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralExpCS <em>Type Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Type Literal Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralExpCS
   * @generated
   */
  EClass getTypeLiteralExpCS();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralExpCS#getOwnedType <em>Owned Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Owned Type</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralExpCS#getOwnedType()
   * @see #getTypeLiteralExpCS()
   * @generated
   */
  EReference getTypeLiteralExpCS_OwnedType();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralExpCS <em>Collection Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Collection Literal Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralExpCS
   * @generated
   */
  EClass getCollectionLiteralExpCS();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralExpCS#getOwnedType <em>Owned Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Owned Type</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralExpCS#getOwnedType()
   * @see #getCollectionLiteralExpCS()
   * @generated
   */
  EReference getCollectionLiteralExpCS_OwnedType();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralExpCS#getOwnedParts <em>Owned Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralExpCS#getOwnedParts()
   * @see #getCollectionLiteralExpCS()
   * @generated
   */
  EReference getCollectionLiteralExpCS_OwnedParts();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralPartCS <em>Collection Literal Part CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Collection Literal Part CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralPartCS
   * @generated
   */
  EClass getCollectionLiteralPartCS();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralPartCS#getExpressionCS <em>Expression CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Expression CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralPartCS#getExpressionCS()
   * @see #getCollectionLiteralPartCS()
   * @generated
   */
  EReference getCollectionLiteralPartCS_ExpressionCS();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralPartCS#getLastExpressionCS <em>Last Expression CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Last Expression CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralPartCS#getLastExpressionCS()
   * @see #getCollectionLiteralPartCS()
   * @generated
   */
  EReference getCollectionLiteralPartCS_LastExpressionCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionTypeCS <em>Collection Type CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Collection Type CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionTypeCS
   * @generated
   */
  EClass getCollectionTypeCS();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionTypeCS#getOwnedType <em>Owned Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Owned Type</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionTypeCS#getOwnedType()
   * @see #getCollectionTypeCS()
   * @generated
   */
  EReference getCollectionTypeCS_OwnedType();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NestedExpCS <em>Nested Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Nested Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NestedExpCS
   * @generated
   */
  EClass getNestedExpCS();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NestedExpCS#getSource <em>Source</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Source</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NestedExpCS#getSource()
   * @see #getNestedExpCS()
   * @generated
   */
  EReference getNestedExpCS_Source();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SelfExpCS <em>Self Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Self Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SelfExpCS
   * @generated
   */
  EClass getSelfExpCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimaryExpOrLetExpCS <em>Primary Exp Or Let Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primary Exp Or Let Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimaryExpOrLetExpCS
   * @generated
   */
  EClass getPrimaryExpOrLetExpCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetExpCS <em>Let Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Let Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetExpCS
   * @generated
   */
  EClass getLetExpCS();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetExpCS#getVariable <em>Variable</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Variable</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetExpCS#getVariable()
   * @see #getLetExpCS()
   * @generated
   */
  EReference getLetExpCS_Variable();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetExpCS#getIn <em>In</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>In</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetExpCS#getIn()
   * @see #getLetExpCS()
   * @generated
   */
  EReference getLetExpCS_In();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetVariableCS <em>Let Variable CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Let Variable CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetVariableCS
   * @generated
   */
  EClass getLetVariableCS();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetVariableCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetVariableCS#getName()
   * @see #getLetVariableCS()
   * @generated
   */
  EAttribute getLetVariableCS_Name();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetVariableCS#getOwnedType <em>Owned Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Owned Type</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetVariableCS#getOwnedType()
   * @see #getLetVariableCS()
   * @generated
   */
  EReference getLetVariableCS_OwnedType();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetVariableCS#getInitExpression <em>Init Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init Expression</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetVariableCS#getInitExpression()
   * @see #getLetVariableCS()
   * @generated
   */
  EReference getLetVariableCS_InitExpression();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigatingArgCS <em>Navigating Arg CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Navigating Arg CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigatingArgCS
   * @generated
   */
  EClass getNavigatingArgCS();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigatingArgCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigatingArgCS#getName()
   * @see #getNavigatingArgCS()
   * @generated
   */
  EReference getNavigatingArgCS_Name();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigatingArgCS#getOwnedType <em>Owned Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Owned Type</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigatingArgCS#getOwnedType()
   * @see #getNavigatingArgCS()
   * @generated
   */
  EReference getNavigatingArgCS_OwnedType();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigatingArgCS#getInit <em>Init</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigatingArgCS#getInit()
   * @see #getNavigatingArgCS()
   * @generated
   */
  EReference getNavigatingArgCS_Init();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigatingArgCS#getPrefix <em>Prefix</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Prefix</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigatingArgCS#getPrefix()
   * @see #getNavigatingArgCS()
   * @generated
   */
  EAttribute getNavigatingArgCS_Prefix();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpCS <em>Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpCS
   * @generated
   */
  EClass getExpCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS <em>If Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>If Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS
   * @generated
   */
  EClass getIfExpCS();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS#getCondition <em>Condition</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Condition</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS#getCondition()
   * @see #getIfExpCS()
   * @generated
   */
  EReference getIfExpCS_Condition();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS#getThenExpression <em>Then Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Then Expression</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS#getThenExpression()
   * @see #getIfExpCS()
   * @generated
   */
  EReference getIfExpCS_ThenExpression();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS#getElseExpression <em>Else Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Else Expression</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS#getElseExpression()
   * @see #getIfExpCS()
   * @generated
   */
  EReference getIfExpCS_ElseExpression();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralExpCS <em>Tuple Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Literal Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralExpCS
   * @generated
   */
  EClass getTupleLiteralExpCS();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralExpCS#getOwnedParts <em>Owned Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralExpCS#getOwnedParts()
   * @see #getTupleLiteralExpCS()
   * @generated
   */
  EReference getTupleLiteralExpCS_OwnedParts();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralPartCS <em>Tuple Literal Part CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Tuple Literal Part CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralPartCS
   * @generated
   */
  EClass getTupleLiteralPartCS();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralPartCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralPartCS#getName()
   * @see #getTupleLiteralPartCS()
   * @generated
   */
  EAttribute getTupleLiteralPartCS_Name();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralPartCS#getOwnedType <em>Owned Type</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Owned Type</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralPartCS#getOwnedType()
   * @see #getTupleLiteralPartCS()
   * @generated
   */
  EReference getTupleLiteralPartCS_OwnedType();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralPartCS#getInitExpression <em>Init Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Init Expression</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralPartCS#getInitExpression()
   * @see #getTupleLiteralPartCS()
   * @generated
   */
  EReference getTupleLiteralPartCS_InitExpression();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimitiveLiteralExpCS <em>Primitive Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Primitive Literal Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimitiveLiteralExpCS
   * @generated
   */
  EClass getPrimitiveLiteralExpCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NumberLiteralExpCS <em>Number Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Number Literal Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NumberLiteralExpCS
   * @generated
   */
  EClass getNumberLiteralExpCS();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NumberLiteralExpCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NumberLiteralExpCS#getName()
   * @see #getNumberLiteralExpCS()
   * @generated
   */
  EReference getNumberLiteralExpCS_Name();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BigNumber <em>Big Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Big Number</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BigNumber
   * @generated
   */
  EClass getBigNumber();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BigNumber#getNumber <em>Number</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Number</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BigNumber#getNumber()
   * @see #getBigNumber()
   * @generated
   */
  EAttribute getBigNumber_Number();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.StringLiteralExpCS <em>String Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>String Literal Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.StringLiteralExpCS
   * @generated
   */
  EClass getStringLiteralExpCS();

  /**
   * Returns the meta object for the attribute list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.StringLiteralExpCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.StringLiteralExpCS#getName()
   * @see #getStringLiteralExpCS()
   * @generated
   */
  EAttribute getStringLiteralExpCS_Name();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BooleanLiteralExpCS <em>Boolean Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Boolean Literal Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BooleanLiteralExpCS
   * @generated
   */
  EClass getBooleanLiteralExpCS();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BooleanLiteralExpCS#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BooleanLiteralExpCS#getName()
   * @see #getBooleanLiteralExpCS()
   * @generated
   */
  EAttribute getBooleanLiteralExpCS_Name();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.UnlimitedNaturalLiteralExpCS <em>Unlimited Natural Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Unlimited Natural Literal Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.UnlimitedNaturalLiteralExpCS
   * @generated
   */
  EClass getUnlimitedNaturalLiteralExpCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvalidLiteralExpCS <em>Invalid Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invalid Literal Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvalidLiteralExpCS
   * @generated
   */
  EClass getInvalidLiteralExpCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NullLiteralExpCS <em>Null Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Null Literal Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NullLiteralExpCS
   * @generated
   */
  EClass getNullLiteralExpCS();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixExpCS <em>Prefix Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Prefix Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixExpCS
   * @generated
   */
  EClass getPrefixExpCS();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixExpCS#getOwnedOperator <em>Owned Operator</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Operator</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixExpCS#getOwnedOperator()
   * @see #getPrefixExpCS()
   * @generated
   */
  EReference getPrefixExpCS_OwnedOperator();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixExpCS#getOwnedExpression <em>Owned Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Owned Expression</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixExpCS#getOwnedExpression()
   * @see #getPrefixExpCS()
   * @generated
   */
  EReference getPrefixExpCS_OwnedExpression();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IndexExpCS <em>Index Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Index Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IndexExpCS
   * @generated
   */
  EClass getIndexExpCS();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IndexExpCS#getPathName <em>Path Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IndexExpCS#getPathName()
   * @see #getIndexExpCS()
   * @generated
   */
  EReference getIndexExpCS_PathName();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IndexExpCS#getFirstIndexes <em>First Indexes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>First Indexes</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IndexExpCS#getFirstIndexes()
   * @see #getIndexExpCS()
   * @generated
   */
  EReference getIndexExpCS_FirstIndexes();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IndexExpCS#getSecondIndexes <em>Second Indexes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Second Indexes</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IndexExpCS#getSecondIndexes()
   * @see #getIndexExpCS()
   * @generated
   */
  EReference getIndexExpCS_SecondIndexes();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IndexExpCS#isAtPre <em>At Pre</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>At Pre</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IndexExpCS#isAtPre()
   * @see #getIndexExpCS()
   * @generated
   */
  EAttribute getIndexExpCS_AtPre();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorExpCS <em>Constructor Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Constructor Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorExpCS
   * @generated
   */
  EClass getConstructorExpCS();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorExpCS#getPathName <em>Path Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorExpCS#getPathName()
   * @see #getConstructorExpCS()
   * @generated
   */
  EReference getConstructorExpCS_PathName();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorExpCS#getOwnedParts <em>Owned Parts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Owned Parts</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorExpCS#getOwnedParts()
   * @see #getConstructorExpCS()
   * @generated
   */
  EReference getConstructorExpCS_OwnedParts();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorExpCS#getValue <em>Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Value</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorExpCS#getValue()
   * @see #getConstructorExpCS()
   * @generated
   */
  EAttribute getConstructorExpCS_Value();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvocationExpCS <em>Invocation Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Invocation Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvocationExpCS
   * @generated
   */
  EClass getInvocationExpCS();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvocationExpCS#getPathName <em>Path Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvocationExpCS#getPathName()
   * @see #getInvocationExpCS()
   * @generated
   */
  EReference getInvocationExpCS_PathName();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvocationExpCS#isAtPre <em>At Pre</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>At Pre</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvocationExpCS#isAtPre()
   * @see #getInvocationExpCS()
   * @generated
   */
  EAttribute getInvocationExpCS_AtPre();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvocationExpCS#getArgument <em>Argument</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Argument</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvocationExpCS#getArgument()
   * @see #getInvocationExpCS()
   * @generated
   */
  EReference getInvocationExpCS_Argument();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameExpCS <em>Name Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Name Exp CS</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameExpCS
   * @generated
   */
  EClass getNameExpCS();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameExpCS#getPathName <em>Path Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Path Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameExpCS#getPathName()
   * @see #getNameExpCS()
   * @generated
   */
  EReference getNameExpCS_PathName();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameExpCS#isAtPre <em>At Pre</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>At Pre</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameExpCS#isAtPre()
   * @see #getNameExpCS()
   * @generated
   */
  EAttribute getNameExpCS_AtPre();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TRCFactory getTRCFactory();

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
  interface Literals
  {
    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TrcSpecificationImpl <em>Trc Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TrcSpecificationImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTrcSpecification()
     * @generated
     */
    EClass TRC_SPECIFICATION = eINSTANCE.getTrcSpecification();

    /**
     * The meta object literal for the '<em><b>Module List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRC_SPECIFICATION__MODULE_LIST = eINSTANCE.getTrcSpecification_ModuleList();

    /**
     * The meta object literal for the '<em><b>Transformation List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRC_SPECIFICATION__TRANSFORMATION_LIST = eINSTANCE.getTrcSpecification_TransformationList();

    /**
     * The meta object literal for the '<em><b>Dependency List</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRC_SPECIFICATION__DEPENDENCY_LIST = eINSTANCE.getTrcSpecification_DependencyList();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.trcRuleImpl <em>trc Rule</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.trcRuleImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#gettrcRule()
     * @generated
     */
    EClass TRC_RULE = eINSTANCE.gettrcRule();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRC_RULE__NAME = eINSTANCE.gettrcRule_Name();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ModuleListImpl <em>Module List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ModuleListImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getModuleList()
     * @generated
     */
    EClass MODULE_LIST = eINSTANCE.getModuleList();

    /**
     * The meta object literal for the '<em><b>Modules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE_LIST__MODULES = eINSTANCE.getModuleList_Modules();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ModuleImpl <em>Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ModuleImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getModule()
     * @generated
     */
    EClass MODULE = eINSTANCE.getModule();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE__NAME = eINSTANCE.getModule_Name();

    /**
     * The meta object literal for the '<em><b>Rules</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULE__RULES = eINSTANCE.getModule_Rules();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationListImpl <em>Transformation List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationListImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTransformationList()
     * @generated
     */
    EClass TRANSFORMATION_LIST = eINSTANCE.getTransformationList();

    /**
     * The meta object literal for the '<em><b>Transformations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION_LIST__TRANSFORMATIONS = eINSTANCE.getTransformationList_Transformations();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationImpl <em>Transformation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTransformation()
     * @generated
     */
    EClass TRANSFORMATION = eINSTANCE.getTransformation();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSFORMATION__NAME = eINSTANCE.getTransformation_Name();

    /**
     * The meta object literal for the '<em><b>Modules</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION__MODULES = eINSTANCE.getTransformation_Modules();

    /**
     * The meta object literal for the '<em><b>Impacts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION__IMPACTS = eINSTANCE.getTransformation_Impacts();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationImpactImpl <em>Transformation Impact</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationImpactImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTransformationImpact()
     * @generated
     */
    EClass TRANSFORMATION_IMPACT = eINSTANCE.getTransformationImpact();

    /**
     * The meta object literal for the '<em><b>Quality Attribute Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSFORMATION_IMPACT__QUALITY_ATTRIBUTE_NAME = eINSTANCE.getTransformationImpact_QualityAttributeName();

    /**
     * The meta object literal for the '<em><b>Impact Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSFORMATION_IMPACT__IMPACT_VALUE = eINSTANCE.getTransformationImpact_ImpactValue();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationDependencyListImpl <em>Transformation Dependency List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationDependencyListImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTransformationDependencyList()
     * @generated
     */
    EClass TRANSFORMATION_DEPENDENCY_LIST = eINSTANCE.getTransformationDependencyList();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSFORMATION_DEPENDENCY_LIST__NAME = eINSTANCE.getTransformationDependencyList_Name();

    /**
     * The meta object literal for the '<em><b>Transformation Dependencies</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES = eINSTANCE.getTransformationDependencyList_TransformationDependencies();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationDependencyImpl <em>Transformation Dependency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationDependencyImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTransformationDependency()
     * @generated
     */
    EClass TRANSFORMATION_DEPENDENCY = eINSTANCE.getTransformationDependency();

    /**
     * The meta object literal for the '<em><b>Applied Transformation</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION = eINSTANCE.getTransformationDependency_AppliedTransformation();

    /**
     * The meta object literal for the '<em><b>Applied Rule</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION_DEPENDENCY__APPLIED_RULE = eINSTANCE.getTransformationDependency_AppliedRule();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSFORMATION_DEPENDENCY__FIELDS = eINSTANCE.getTransformationDependency_Fields();

    /**
     * The meta object literal for the '<em><b>Required Transformations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS = eINSTANCE.getTransformationDependency_RequiredTransformations();

    /**
     * The meta object literal for the '<em><b>Bool OP</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION_DEPENDENCY__BOOL_OP = eINSTANCE.getTransformationDependency_BoolOP();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.BooleanOperationsImpl <em>Boolean Operations</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.BooleanOperationsImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getBooleanOperations()
     * @generated
     */
    EClass BOOLEAN_OPERATIONS = eINSTANCE.getBooleanOperations();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_OPERATIONS__NAME = eINSTANCE.getBooleanOperations_Name();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.RuleDependencyImpl <em>Rule Dependency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.RuleDependencyImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getRuleDependency()
     * @generated
     */
    EClass RULE_DEPENDENCY = eINSTANCE.getRuleDependency();

    /**
     * The meta object literal for the '<em><b>Kw</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DEPENDENCY__KW = eINSTANCE.getRuleDependency_Kw();

    /**
     * The meta object literal for the '<em><b>Red</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DEPENDENCY__RED = eINSTANCE.getRuleDependency_Red();

    /**
     * The meta object literal for the '<em><b>Bool OP</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DEPENDENCY__BOOL_OP = eINSTANCE.getRuleDependency_BoolOP();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.KeyWordImpl <em>Key Word</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.KeyWordImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getKeyWord()
     * @generated
     */
    EClass KEY_WORD = eINSTANCE.getKeyWord();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute KEY_WORD__NAME = eINSTANCE.getKeyWord_Name();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.requiresOrExcludeDependencyImpl <em>requires Or Exclude Dependency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.requiresOrExcludeDependencyImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getrequiresOrExcludeDependency()
     * @generated
     */
    EClass REQUIRES_OR_EXCLUDE_DEPENDENCY = eINSTANCE.getrequiresOrExcludeDependency();

    /**
     * The meta object literal for the '<em><b>Required Transformation</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIRES_OR_EXCLUDE_DEPENDENCY__REQUIRED_TRANSFORMATION = eINSTANCE.getrequiresOrExcludeDependency_RequiredTransformation();

    /**
     * The meta object literal for the '<em><b>Required Rule</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIRES_OR_EXCLUDE_DEPENDENCY__REQUIRED_RULE = eINSTANCE.getrequiresOrExcludeDependency_RequiredRule();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQUIRES_OR_EXCLUDE_DEPENDENCY__FIELDS = eINSTANCE.getrequiresOrExcludeDependency_Fields();

    /**
     * The meta object literal for the '<em><b>Ocl Expression</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIRES_OR_EXCLUDE_DEPENDENCY__OCL_EXPRESSION = eINSTANCE.getrequiresOrExcludeDependency_OclExpression();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.oclExprImpl <em>ocl Expr</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.oclExprImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getoclExpr()
     * @generated
     */
    EClass OCL_EXPR = eINSTANCE.getoclExpr();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ClassifierContextDeclCSImpl <em>Classifier Context Decl CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ClassifierContextDeclCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getClassifierContextDeclCS()
     * @generated
     */
    EClass CLASSIFIER_CONTEXT_DECL_CS = eINSTANCE.getClassifierContextDeclCS();

    /**
     * The meta object literal for the '<em><b>Self Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME = eINSTANCE.getClassifierContextDeclCS_SelfName();

    /**
     * The meta object literal for the '<em><b>Invariants</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS = eINSTANCE.getClassifierContextDeclCS_Invariants();

    /**
     * The meta object literal for the '<em><b>Definitions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS = eINSTANCE.getClassifierContextDeclCS_Definitions();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.OperationContextDeclCSImpl <em>Operation Context Decl CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.OperationContextDeclCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getOperationContextDeclCS()
     * @generated
     */
    EClass OPERATION_CONTEXT_DECL_CS = eINSTANCE.getOperationContextDeclCS();

    /**
     * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CONTEXT_DECL_CS__PATH_NAME = eINSTANCE.getOperationContextDeclCS_PathName();

    /**
     * The meta object literal for the '<em><b>Parameters</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CONTEXT_DECL_CS__PARAMETERS = eINSTANCE.getOperationContextDeclCS_Parameters();

    /**
     * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CONTEXT_DECL_CS__OWNED_TYPE = eINSTANCE.getOperationContextDeclCS_OwnedType();

    /**
     * The meta object literal for the '<em><b>Preconditions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CONTEXT_DECL_CS__PRECONDITIONS = eINSTANCE.getOperationContextDeclCS_Preconditions();

    /**
     * The meta object literal for the '<em><b>Postconditions</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS = eINSTANCE.getOperationContextDeclCS_Postconditions();

    /**
     * The meta object literal for the '<em><b>Bodies</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference OPERATION_CONTEXT_DECL_CS__BODIES = eINSTANCE.getOperationContextDeclCS_Bodies();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ParameterCSImpl <em>Parameter CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ParameterCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getParameterCS()
     * @generated
     */
    EClass PARAMETER_CS = eINSTANCE.getParameterCS();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute PARAMETER_CS__NAME = eINSTANCE.getParameterCS_Name();

    /**
     * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PARAMETER_CS__OWNED_TYPE = eINSTANCE.getParameterCS_OwnedType();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstraintCSImpl <em>Constraint CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstraintCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getConstraintCS()
     * @generated
     */
    EClass CONSTRAINT_CS = eINSTANCE.getConstraintCS();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRAINT_CS__NAME = eINSTANCE.getConstraintCS_Name();

    /**
     * The meta object literal for the '<em><b>Message Specification</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT_CS__MESSAGE_SPECIFICATION = eINSTANCE.getConstraintCS_MessageSpecification();

    /**
     * The meta object literal for the '<em><b>Specification</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRAINT_CS__SPECIFICATION = eINSTANCE.getConstraintCS_Specification();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.DefCSImpl <em>Def CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.DefCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getDefCS()
     * @generated
     */
    EClass DEF_CS = eINSTANCE.getDefCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.DefPropertyCSImpl <em>Def Property CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.DefPropertyCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getDefPropertyCS()
     * @generated
     */
    EClass DEF_PROPERTY_CS = eINSTANCE.getDefPropertyCS();

    /**
     * The meta object literal for the '<em><b>Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEF_PROPERTY_CS__STATIC = eINSTANCE.getDefPropertyCS_Static();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute DEF_PROPERTY_CS__NAME = eINSTANCE.getDefPropertyCS_Name();

    /**
     * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEF_PROPERTY_CS__OWNED_TYPE = eINSTANCE.getDefPropertyCS_OwnedType();

    /**
     * The meta object literal for the '<em><b>Specification</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEF_PROPERTY_CS__SPECIFICATION = eINSTANCE.getDefPropertyCS_Specification();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypedRefCSImpl <em>Typed Ref CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypedRefCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTypedRefCS()
     * @generated
     */
    EClass TYPED_REF_CS = eINSTANCE.getTypedRefCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.MultiplicityCSImpl <em>Multiplicity CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.MultiplicityCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getMultiplicityCS()
     * @generated
     */
    EClass MULTIPLICITY_CS = eINSTANCE.getMultiplicityCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.MultiplicityStringCSImpl <em>Multiplicity String CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.MultiplicityStringCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getMultiplicityStringCS()
     * @generated
     */
    EClass MULTIPLICITY_STRING_CS = eINSTANCE.getMultiplicityStringCS();

    /**
     * The meta object literal for the '<em><b>String Bounds</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICITY_STRING_CS__STRING_BOUNDS = eINSTANCE.getMultiplicityStringCS_StringBounds();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.MultiplicityBoundsCSImpl <em>Multiplicity Bounds CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.MultiplicityBoundsCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getMultiplicityBoundsCS()
     * @generated
     */
    EClass MULTIPLICITY_BOUNDS_CS = eINSTANCE.getMultiplicityBoundsCS();

    /**
     * The meta object literal for the '<em><b>Lower Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICITY_BOUNDS_CS__LOWER_BOUND = eINSTANCE.getMultiplicityBoundsCS_LowerBound();

    /**
     * The meta object literal for the '<em><b>Upper Bound</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MULTIPLICITY_BOUNDS_CS__UPPER_BOUND = eINSTANCE.getMultiplicityBoundsCS_UpperBound();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NamedElementImpl <em>Named Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NamedElementImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getNamedElement()
     * @generated
     */
    EClass NAMED_ELEMENT = eINSTANCE.getNamedElement();

    /**
     * The meta object literal for the '<em><b>Is Static</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_ELEMENT__IS_STATIC = eINSTANCE.getNamedElement_IsStatic();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAMED_ELEMENT__NAME = eINSTANCE.getNamedElement_Name();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NameSpaceImpl <em>Name Space</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NameSpaceImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getNameSpace()
     * @generated
     */
    EClass NAME_SPACE = eINSTANCE.getNameSpace();

    /**
     * The meta object literal for the '<em><b>ID</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAME_SPACE__ID = eINSTANCE.getNameSpace_ID();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeNameExpCSImpl <em>Type Name Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeNameExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTypeNameExpCS()
     * @generated
     */
    EClass TYPE_NAME_EXP_CS = eINSTANCE.getTypeNameExpCS();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_NAME_EXP_CS__MULTIPLICITY = eINSTANCE.getTypeNameExpCS_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_NAME_EXP_CS__PATH_NAME = eINSTANCE.getTypeNameExpCS_PathName();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PathNameCSImpl <em>Path Name CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PathNameCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPathNameCS()
     * @generated
     */
    EClass PATH_NAME_CS = eINSTANCE.getPathNameCS();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATH_NAME_CS__PATH = eINSTANCE.getPathNameCS_Path();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PathElementCSImpl <em>Path Element CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PathElementCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPathElementCS()
     * @generated
     */
    EClass PATH_ELEMENT_CS = eINSTANCE.getPathElementCS();

    /**
     * The meta object literal for the '<em><b>Element</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PATH_ELEMENT_CS__ELEMENT = eINSTANCE.getPathElementCS_Element();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.SpecificationCSImpl <em>Specification CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.SpecificationCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getSpecificationCS()
     * @generated
     */
    EClass SPECIFICATION_CS = eINSTANCE.getSpecificationCS();

    /**
     * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference SPECIFICATION_CS__OWNED_EXPRESSION = eINSTANCE.getSpecificationCS_OwnedExpression();

    /**
     * The meta object literal for the '<em><b>Expr String</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute SPECIFICATION_CS__EXPR_STRING = eINSTANCE.getSpecificationCS_ExprString();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.EssentialOCLInfixOperatorCSImpl <em>Essential OCL Infix Operator CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.EssentialOCLInfixOperatorCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getEssentialOCLInfixOperatorCS()
     * @generated
     */
    EClass ESSENTIAL_OCL_INFIX_OPERATOR_CS = eINSTANCE.getEssentialOCLInfixOperatorCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.BinaryOperatorCSImpl <em>Binary Operator CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.BinaryOperatorCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getBinaryOperatorCS()
     * @generated
     */
    EClass BINARY_OPERATOR_CS = eINSTANCE.getBinaryOperatorCS();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BINARY_OPERATOR_CS__NAME = eINSTANCE.getBinaryOperatorCS_Name();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NavigationOperatorCSImpl <em>Navigation Operator CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NavigationOperatorCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getNavigationOperatorCS()
     * @generated
     */
    EClass NAVIGATION_OPERATOR_CS = eINSTANCE.getNavigationOperatorCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ContextCsImpl <em>Context Cs</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ContextCsImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getContextCs()
     * @generated
     */
    EClass CONTEXT_CS = eINSTANCE.getContextCs();

    /**
     * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT_CS__OWNED_EXPRESSION = eINSTANCE.getContextCs_OwnedExpression();

    /**
     * The meta object literal for the '<em><b>B</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT_CS__B = eINSTANCE.getContextCs_B();

    /**
     * The meta object literal for the '<em><b>BO</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONTEXT_CS__BO = eINSTANCE.getContextCs_BO();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ExpressCSImpl <em>Express CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ExpressCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getExpressCS()
     * @generated
     */
    EClass EXPRESS_CS = eINSTANCE.getExpressCS();

    /**
     * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESS_CS__OWNED_EXPRESSION = eINSTANCE.getExpressCS_OwnedExpression();

    /**
     * The meta object literal for the '<em><b>Owned Operator</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXPRESS_CS__OWNED_OPERATOR = eINSTANCE.getExpressCS_OwnedOperator();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrefixedExpCSImpl <em>Prefixed Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrefixedExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPrefixedExpCS()
     * @generated
     */
    EClass PREFIXED_EXP_CS = eINSTANCE.getPrefixedExpCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.EssentialOCLPrefixOperatorImpl <em>Essential OCL Prefix Operator</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.EssentialOCLPrefixOperatorImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getEssentialOCLPrefixOperator()
     * @generated
     */
    EClass ESSENTIAL_OCL_PREFIX_OPERATOR = eINSTANCE.getEssentialOCLPrefixOperator();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute ESSENTIAL_OCL_PREFIX_OPERATOR__NAME = eINSTANCE.getEssentialOCLPrefixOperator_Name();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrefixedExpOrLetExpCSImpl <em>Prefixed Exp Or Let Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrefixedExpOrLetExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPrefixedExpOrLetExpCS()
     * @generated
     */
    EClass PREFIXED_EXP_OR_LET_EXP_CS = eINSTANCE.getPrefixedExpOrLetExpCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrimaryExpCSImpl <em>Primary Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrimaryExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPrimaryExpCS()
     * @generated
     */
    EClass PRIMARY_EXP_CS = eINSTANCE.getPrimaryExpCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstructorPartCSImpl <em>Constructor Part CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstructorPartCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getConstructorPartCS()
     * @generated
     */
    EClass CONSTRUCTOR_PART_CS = eINSTANCE.getConstructorPartCS();

    /**
     * The meta object literal for the '<em><b>Property</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRUCTOR_PART_CS__PROPERTY = eINSTANCE.getConstructorPartCS_Property();

    /**
     * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRUCTOR_PART_CS__INIT_EXPRESSION = eINSTANCE.getConstructorPartCS_InitExpression();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeLiteralWithMultiplicityCSImpl <em>Type Literal With Multiplicity CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeLiteralWithMultiplicityCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTypeLiteralWithMultiplicityCS()
     * @generated
     */
    EClass TYPE_LITERAL_WITH_MULTIPLICITY_CS = eINSTANCE.getTypeLiteralWithMultiplicityCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeLiteralCSImpl <em>Type Literal CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeLiteralCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTypeLiteralCS()
     * @generated
     */
    EClass TYPE_LITERAL_CS = eINSTANCE.getTypeLiteralCS();

    /**
     * The meta object literal for the '<em><b>Multiplicity</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_LITERAL_CS__MULTIPLICITY = eINSTANCE.getTypeLiteralCS_Multiplicity();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TYPE_LITERAL_CS__NAME = eINSTANCE.getTypeLiteralCS_Name();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TupleTypeCSImpl <em>Tuple Type CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TupleTypeCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTupleTypeCS()
     * @generated
     */
    EClass TUPLE_TYPE_CS = eINSTANCE.getTupleTypeCS();

    /**
     * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_TYPE_CS__OWNED_PARTS = eINSTANCE.getTupleTypeCS_OwnedParts();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TuplePartCSImpl <em>Tuple Part CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TuplePartCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTuplePartCS()
     * @generated
     */
    EClass TUPLE_PART_CS = eINSTANCE.getTuplePartCS();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TUPLE_PART_CS__NAME = eINSTANCE.getTuplePartCS_Name();

    /**
     * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_PART_CS__OWNED_TYPE = eINSTANCE.getTuplePartCS_OwnedType();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrimitiveTypeCSImpl <em>Primitive Type CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrimitiveTypeCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPrimitiveTypeCS()
     * @generated
     */
    EClass PRIMITIVE_TYPE_CS = eINSTANCE.getPrimitiveTypeCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeLiteralExpCSImpl <em>Type Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeLiteralExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTypeLiteralExpCS()
     * @generated
     */
    EClass TYPE_LITERAL_EXP_CS = eINSTANCE.getTypeLiteralExpCS();

    /**
     * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TYPE_LITERAL_EXP_CS__OWNED_TYPE = eINSTANCE.getTypeLiteralExpCS_OwnedType();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.CollectionLiteralExpCSImpl <em>Collection Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.CollectionLiteralExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getCollectionLiteralExpCS()
     * @generated
     */
    EClass COLLECTION_LITERAL_EXP_CS = eINSTANCE.getCollectionLiteralExpCS();

    /**
     * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLLECTION_LITERAL_EXP_CS__OWNED_TYPE = eINSTANCE.getCollectionLiteralExpCS_OwnedType();

    /**
     * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLLECTION_LITERAL_EXP_CS__OWNED_PARTS = eINSTANCE.getCollectionLiteralExpCS_OwnedParts();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.CollectionLiteralPartCSImpl <em>Collection Literal Part CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.CollectionLiteralPartCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getCollectionLiteralPartCS()
     * @generated
     */
    EClass COLLECTION_LITERAL_PART_CS = eINSTANCE.getCollectionLiteralPartCS();

    /**
     * The meta object literal for the '<em><b>Expression CS</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLLECTION_LITERAL_PART_CS__EXPRESSION_CS = eINSTANCE.getCollectionLiteralPartCS_ExpressionCS();

    /**
     * The meta object literal for the '<em><b>Last Expression CS</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS = eINSTANCE.getCollectionLiteralPartCS_LastExpressionCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.CollectionTypeCSImpl <em>Collection Type CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.CollectionTypeCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getCollectionTypeCS()
     * @generated
     */
    EClass COLLECTION_TYPE_CS = eINSTANCE.getCollectionTypeCS();

    /**
     * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference COLLECTION_TYPE_CS__OWNED_TYPE = eINSTANCE.getCollectionTypeCS_OwnedType();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NestedExpCSImpl <em>Nested Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NestedExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getNestedExpCS()
     * @generated
     */
    EClass NESTED_EXP_CS = eINSTANCE.getNestedExpCS();

    /**
     * The meta object literal for the '<em><b>Source</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NESTED_EXP_CS__SOURCE = eINSTANCE.getNestedExpCS_Source();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.SelfExpCSImpl <em>Self Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.SelfExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getSelfExpCS()
     * @generated
     */
    EClass SELF_EXP_CS = eINSTANCE.getSelfExpCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrimaryExpOrLetExpCSImpl <em>Primary Exp Or Let Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrimaryExpOrLetExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPrimaryExpOrLetExpCS()
     * @generated
     */
    EClass PRIMARY_EXP_OR_LET_EXP_CS = eINSTANCE.getPrimaryExpOrLetExpCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.LetExpCSImpl <em>Let Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.LetExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getLetExpCS()
     * @generated
     */
    EClass LET_EXP_CS = eINSTANCE.getLetExpCS();

    /**
     * The meta object literal for the '<em><b>Variable</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_EXP_CS__VARIABLE = eINSTANCE.getLetExpCS_Variable();

    /**
     * The meta object literal for the '<em><b>In</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_EXP_CS__IN = eINSTANCE.getLetExpCS_In();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.LetVariableCSImpl <em>Let Variable CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.LetVariableCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getLetVariableCS()
     * @generated
     */
    EClass LET_VARIABLE_CS = eINSTANCE.getLetVariableCS();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute LET_VARIABLE_CS__NAME = eINSTANCE.getLetVariableCS_Name();

    /**
     * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_VARIABLE_CS__OWNED_TYPE = eINSTANCE.getLetVariableCS_OwnedType();

    /**
     * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference LET_VARIABLE_CS__INIT_EXPRESSION = eINSTANCE.getLetVariableCS_InitExpression();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NavigatingArgCSImpl <em>Navigating Arg CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NavigatingArgCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getNavigatingArgCS()
     * @generated
     */
    EClass NAVIGATING_ARG_CS = eINSTANCE.getNavigatingArgCS();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAVIGATING_ARG_CS__NAME = eINSTANCE.getNavigatingArgCS_Name();

    /**
     * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAVIGATING_ARG_CS__OWNED_TYPE = eINSTANCE.getNavigatingArgCS_OwnedType();

    /**
     * The meta object literal for the '<em><b>Init</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAVIGATING_ARG_CS__INIT = eINSTANCE.getNavigatingArgCS_Init();

    /**
     * The meta object literal for the '<em><b>Prefix</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAVIGATING_ARG_CS__PREFIX = eINSTANCE.getNavigatingArgCS_Prefix();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ExpCSImpl <em>Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getExpCS()
     * @generated
     */
    EClass EXP_CS = eINSTANCE.getExpCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.IfExpCSImpl <em>If Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.IfExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getIfExpCS()
     * @generated
     */
    EClass IF_EXP_CS = eINSTANCE.getIfExpCS();

    /**
     * The meta object literal for the '<em><b>Condition</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_EXP_CS__CONDITION = eINSTANCE.getIfExpCS_Condition();

    /**
     * The meta object literal for the '<em><b>Then Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_EXP_CS__THEN_EXPRESSION = eINSTANCE.getIfExpCS_ThenExpression();

    /**
     * The meta object literal for the '<em><b>Else Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference IF_EXP_CS__ELSE_EXPRESSION = eINSTANCE.getIfExpCS_ElseExpression();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TupleLiteralExpCSImpl <em>Tuple Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TupleLiteralExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTupleLiteralExpCS()
     * @generated
     */
    EClass TUPLE_LITERAL_EXP_CS = eINSTANCE.getTupleLiteralExpCS();

    /**
     * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_LITERAL_EXP_CS__OWNED_PARTS = eINSTANCE.getTupleLiteralExpCS_OwnedParts();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TupleLiteralPartCSImpl <em>Tuple Literal Part CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TupleLiteralPartCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getTupleLiteralPartCS()
     * @generated
     */
    EClass TUPLE_LITERAL_PART_CS = eINSTANCE.getTupleLiteralPartCS();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TUPLE_LITERAL_PART_CS__NAME = eINSTANCE.getTupleLiteralPartCS_Name();

    /**
     * The meta object literal for the '<em><b>Owned Type</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_LITERAL_PART_CS__OWNED_TYPE = eINSTANCE.getTupleLiteralPartCS_OwnedType();

    /**
     * The meta object literal for the '<em><b>Init Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TUPLE_LITERAL_PART_CS__INIT_EXPRESSION = eINSTANCE.getTupleLiteralPartCS_InitExpression();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrimitiveLiteralExpCSImpl <em>Primitive Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrimitiveLiteralExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPrimitiveLiteralExpCS()
     * @generated
     */
    EClass PRIMITIVE_LITERAL_EXP_CS = eINSTANCE.getPrimitiveLiteralExpCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NumberLiteralExpCSImpl <em>Number Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NumberLiteralExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getNumberLiteralExpCS()
     * @generated
     */
    EClass NUMBER_LITERAL_EXP_CS = eINSTANCE.getNumberLiteralExpCS();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NUMBER_LITERAL_EXP_CS__NAME = eINSTANCE.getNumberLiteralExpCS_Name();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.BigNumberImpl <em>Big Number</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.BigNumberImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getBigNumber()
     * @generated
     */
    EClass BIG_NUMBER = eINSTANCE.getBigNumber();

    /**
     * The meta object literal for the '<em><b>Number</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BIG_NUMBER__NUMBER = eINSTANCE.getBigNumber_Number();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.StringLiteralExpCSImpl <em>String Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.StringLiteralExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getStringLiteralExpCS()
     * @generated
     */
    EClass STRING_LITERAL_EXP_CS = eINSTANCE.getStringLiteralExpCS();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute STRING_LITERAL_EXP_CS__NAME = eINSTANCE.getStringLiteralExpCS_Name();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.BooleanLiteralExpCSImpl <em>Boolean Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.BooleanLiteralExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getBooleanLiteralExpCS()
     * @generated
     */
    EClass BOOLEAN_LITERAL_EXP_CS = eINSTANCE.getBooleanLiteralExpCS();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute BOOLEAN_LITERAL_EXP_CS__NAME = eINSTANCE.getBooleanLiteralExpCS_Name();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.UnlimitedNaturalLiteralExpCSImpl <em>Unlimited Natural Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.UnlimitedNaturalLiteralExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getUnlimitedNaturalLiteralExpCS()
     * @generated
     */
    EClass UNLIMITED_NATURAL_LITERAL_EXP_CS = eINSTANCE.getUnlimitedNaturalLiteralExpCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.InvalidLiteralExpCSImpl <em>Invalid Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.InvalidLiteralExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getInvalidLiteralExpCS()
     * @generated
     */
    EClass INVALID_LITERAL_EXP_CS = eINSTANCE.getInvalidLiteralExpCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NullLiteralExpCSImpl <em>Null Literal Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NullLiteralExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getNullLiteralExpCS()
     * @generated
     */
    EClass NULL_LITERAL_EXP_CS = eINSTANCE.getNullLiteralExpCS();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrefixExpCSImpl <em>Prefix Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrefixExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getPrefixExpCS()
     * @generated
     */
    EClass PREFIX_EXP_CS = eINSTANCE.getPrefixExpCS();

    /**
     * The meta object literal for the '<em><b>Owned Operator</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREFIX_EXP_CS__OWNED_OPERATOR = eINSTANCE.getPrefixExpCS_OwnedOperator();

    /**
     * The meta object literal for the '<em><b>Owned Expression</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference PREFIX_EXP_CS__OWNED_EXPRESSION = eINSTANCE.getPrefixExpCS_OwnedExpression();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.IndexExpCSImpl <em>Index Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.IndexExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getIndexExpCS()
     * @generated
     */
    EClass INDEX_EXP_CS = eINSTANCE.getIndexExpCS();

    /**
     * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INDEX_EXP_CS__PATH_NAME = eINSTANCE.getIndexExpCS_PathName();

    /**
     * The meta object literal for the '<em><b>First Indexes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INDEX_EXP_CS__FIRST_INDEXES = eINSTANCE.getIndexExpCS_FirstIndexes();

    /**
     * The meta object literal for the '<em><b>Second Indexes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INDEX_EXP_CS__SECOND_INDEXES = eINSTANCE.getIndexExpCS_SecondIndexes();

    /**
     * The meta object literal for the '<em><b>At Pre</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INDEX_EXP_CS__AT_PRE = eINSTANCE.getIndexExpCS_AtPre();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstructorExpCSImpl <em>Constructor Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstructorExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getConstructorExpCS()
     * @generated
     */
    EClass CONSTRUCTOR_EXP_CS = eINSTANCE.getConstructorExpCS();

    /**
     * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRUCTOR_EXP_CS__PATH_NAME = eINSTANCE.getConstructorExpCS_PathName();

    /**
     * The meta object literal for the '<em><b>Owned Parts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference CONSTRUCTOR_EXP_CS__OWNED_PARTS = eINSTANCE.getConstructorExpCS_OwnedParts();

    /**
     * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute CONSTRUCTOR_EXP_CS__VALUE = eINSTANCE.getConstructorExpCS_Value();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.InvocationExpCSImpl <em>Invocation Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.InvocationExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getInvocationExpCS()
     * @generated
     */
    EClass INVOCATION_EXP_CS = eINSTANCE.getInvocationExpCS();

    /**
     * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION_EXP_CS__PATH_NAME = eINSTANCE.getInvocationExpCS_PathName();

    /**
     * The meta object literal for the '<em><b>At Pre</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute INVOCATION_EXP_CS__AT_PRE = eINSTANCE.getInvocationExpCS_AtPre();

    /**
     * The meta object literal for the '<em><b>Argument</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference INVOCATION_EXP_CS__ARGUMENT = eINSTANCE.getInvocationExpCS_Argument();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NameExpCSImpl <em>Name Exp CS</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.NameExpCSImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCPackageImpl#getNameExpCS()
     * @generated
     */
    EClass NAME_EXP_CS = eINSTANCE.getNameExpCS();

    /**
     * The meta object literal for the '<em><b>Path Name</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference NAME_EXP_CS__PATH_NAME = eINSTANCE.getNameExpCS_PathName();

    /**
     * The meta object literal for the '<em><b>At Pre</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute NAME_EXP_CS__AT_PRE = eINSTANCE.getNameExpCS_AtPre();

  }

} //TRCPackage
