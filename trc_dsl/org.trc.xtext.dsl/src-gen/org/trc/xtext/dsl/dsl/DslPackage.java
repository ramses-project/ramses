/**
 */
package org.trc.xtext.dsl.dsl;

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
 * @see org.trc.xtext.dsl.dsl.DslFactory
 * @model kind="package"
 * @generated
 */
public interface DslPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "dsl";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://www.trc.org/xtext/dsl/Dsl";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "dsl";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DslPackage eINSTANCE = org.trc.xtext.dsl.dsl.impl.DslPackageImpl.init();

  /**
   * The meta object id for the '{@link org.trc.xtext.dsl.dsl.impl.TrcSpecificationImpl <em>Trc Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.trc.xtext.dsl.dsl.impl.TrcSpecificationImpl
   * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getTrcSpecification()
   * @generated
   */
  int TRC_SPECIFICATION = 0;

  /**
   * The feature id for the '<em><b>Froms</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRC_SPECIFICATION__FROMS = 0;

  /**
   * The feature id for the '<em><b>Module List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRC_SPECIFICATION__MODULE_LIST = 1;

  /**
   * The feature id for the '<em><b>Transformation List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRC_SPECIFICATION__TRANSFORMATION_LIST = 2;

  /**
   * The feature id for the '<em><b>Dependency List</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRC_SPECIFICATION__DEPENDENCY_LIST = 3;

  /**
   * The number of structural features of the '<em>Trc Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRC_SPECIFICATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.trc.xtext.dsl.dsl.impl.FromImpl <em>From</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.trc.xtext.dsl.dsl.impl.FromImpl
   * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getFrom()
   * @generated
   */
  int FROM = 1;

  /**
   * The feature id for the '<em><b>Import URI</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROM__IMPORT_URI = 0;

  /**
   * The number of structural features of the '<em>From</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int FROM_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.trc.xtext.dsl.dsl.impl.RulesImpl <em>Rules</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.trc.xtext.dsl.dsl.impl.RulesImpl
   * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getRules()
   * @generated
   */
  int RULES = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULES__NAME = 0;

  /**
   * The number of structural features of the '<em>Rules</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULES_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.trc.xtext.dsl.dsl.impl.ModuleListImpl <em>Module List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.trc.xtext.dsl.dsl.impl.ModuleListImpl
   * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getModuleList()
   * @generated
   */
  int MODULE_LIST = 3;

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
   * The meta object id for the '{@link org.trc.xtext.dsl.dsl.impl.ModulesImpl <em>Modules</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.trc.xtext.dsl.dsl.impl.ModulesImpl
   * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getModules()
   * @generated
   */
  int MODULES = 4;

  /**
   * The feature id for the '<em><b>Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULES__PATH = 0;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULES__NAME = 1;

  /**
   * The feature id for the '<em><b>Rule Name</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULES__RULE_NAME = 2;

  /**
   * The number of structural features of the '<em>Modules</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULES_FEATURE_COUNT = 3;

  /**
   * The meta object id for the '{@link org.trc.xtext.dsl.dsl.impl.TransformationListImpl <em>Transformation List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.trc.xtext.dsl.dsl.impl.TransformationListImpl
   * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getTransformationList()
   * @generated
   */
  int TRANSFORMATION_LIST = 5;

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
   * The meta object id for the '{@link org.trc.xtext.dsl.dsl.impl.TransformationImpl <em>Transformation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.trc.xtext.dsl.dsl.impl.TransformationImpl
   * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getTransformation()
   * @generated
   */
  int TRANSFORMATION = 6;

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
   * The meta object id for the '{@link org.trc.xtext.dsl.dsl.impl.TransformationImpactImpl <em>Transformation Impact</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.trc.xtext.dsl.dsl.impl.TransformationImpactImpl
   * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getTransformationImpact()
   * @generated
   */
  int TRANSFORMATION_IMPACT = 7;

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
   * The meta object id for the '{@link org.trc.xtext.dsl.dsl.impl.TransformationDependencyListImpl <em>Transformation Dependency List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.trc.xtext.dsl.dsl.impl.TransformationDependencyListImpl
   * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getTransformationDependencyList()
   * @generated
   */
  int TRANSFORMATION_DEPENDENCY_LIST = 8;

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
   * The meta object id for the '{@link org.trc.xtext.dsl.dsl.impl.TransformationDependencyImpl <em>Transformation Dependency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.trc.xtext.dsl.dsl.impl.TransformationDependencyImpl
   * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getTransformationDependency()
   * @generated
   */
  int TRANSFORMATION_DEPENDENCY = 9;

  /**
   * The feature id for the '<em><b>Applied Transformation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION = 0;

  /**
   * The feature id for the '<em><b>Applied Rule</b></em>' attribute.
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
   * The number of structural features of the '<em>Transformation Dependency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.trc.xtext.dsl.dsl.impl.AbstractRuleDependencyImpl <em>Abstract Rule Dependency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.trc.xtext.dsl.dsl.impl.AbstractRuleDependencyImpl
   * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getAbstractRuleDependency()
   * @generated
   */
  int ABSTRACT_RULE_DEPENDENCY = 10;

  /**
   * The number of structural features of the '<em>Abstract Rule Dependency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_RULE_DEPENDENCY_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link org.trc.xtext.dsl.dsl.impl.RuleDependencyConjunctionImpl <em>Rule Dependency Conjunction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.trc.xtext.dsl.dsl.impl.RuleDependencyConjunctionImpl
   * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getRuleDependencyConjunction()
   * @generated
   */
  int RULE_DEPENDENCY_CONJUNCTION = 11;

  /**
   * The feature id for the '<em><b>Required Transformations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY_CONJUNCTION__REQUIRED_TRANSFORMATIONS = 0;

  /**
   * The number of structural features of the '<em>Rule Dependency Conjunction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY_CONJUNCTION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.trc.xtext.dsl.dsl.impl.RuleDependencyDisjunctionImpl <em>Rule Dependency Disjunction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.trc.xtext.dsl.dsl.impl.RuleDependencyDisjunctionImpl
   * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getRuleDependencyDisjunction()
   * @generated
   */
  int RULE_DEPENDENCY_DISJUNCTION = 12;

  /**
   * The feature id for the '<em><b>Required Transformations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY_DISJUNCTION__REQUIRED_TRANSFORMATIONS = 0;

  /**
   * The number of structural features of the '<em>Rule Dependency Disjunction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY_DISJUNCTION_FEATURE_COUNT = 1;

  /**
   * The meta object id for the '{@link org.trc.xtext.dsl.dsl.impl.RuleDependencyImpl <em>Rule Dependency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.trc.xtext.dsl.dsl.impl.RuleDependencyImpl
   * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getRuleDependency()
   * @generated
   */
  int RULE_DEPENDENCY = 13;

  /**
   * The feature id for the '<em><b>Rd</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY__RD = ABSTRACT_RULE_DEPENDENCY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Ed</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY__ED = ABSTRACT_RULE_DEPENDENCY_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Rule Dependency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY_FEATURE_COUNT = ABSTRACT_RULE_DEPENDENCY_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link org.trc.xtext.dsl.dsl.impl.requiresDependencyImpl <em>requires Dependency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.trc.xtext.dsl.dsl.impl.requiresDependencyImpl
   * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getrequiresDependency()
   * @generated
   */
  int REQUIRES_DEPENDENCY = 14;

  /**
   * The feature id for the '<em><b>Required Transformation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRES_DEPENDENCY__REQUIRED_TRANSFORMATION = 0;

  /**
   * The feature id for the '<em><b>Required Rule</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRES_DEPENDENCY__REQUIRED_RULE = 1;

  /**
   * The feature id for the '<em><b>Fields</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRES_DEPENDENCY__FIELDS = 2;

  /**
   * The feature id for the '<em><b>Ocl Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRES_DEPENDENCY__OCL_EXPRESSION = 3;

  /**
   * The number of structural features of the '<em>requires Dependency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int REQUIRES_DEPENDENCY_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link org.trc.xtext.dsl.dsl.impl.excludeDependencyImpl <em>exclude Dependency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.trc.xtext.dsl.dsl.impl.excludeDependencyImpl
   * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getexcludeDependency()
   * @generated
   */
  int EXCLUDE_DEPENDENCY = 15;

  /**
   * The feature id for the '<em><b>Required Transformation</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUDE_DEPENDENCY__REQUIRED_TRANSFORMATION = 0;

  /**
   * The feature id for the '<em><b>Required Rule</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUDE_DEPENDENCY__REQUIRED_RULE = 1;

  /**
   * The feature id for the '<em><b>Fields</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUDE_DEPENDENCY__FIELDS = 2;

  /**
   * The feature id for the '<em><b>Ocl Expression</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUDE_DEPENDENCY__OCL_EXPRESSION = 3;

  /**
   * The number of structural features of the '<em>exclude Dependency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int EXCLUDE_DEPENDENCY_FEATURE_COUNT = 4;


  /**
   * Returns the meta object for class '{@link org.trc.xtext.dsl.dsl.TrcSpecification <em>Trc Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Trc Specification</em>'.
   * @see org.trc.xtext.dsl.dsl.TrcSpecification
   * @generated
   */
  EClass getTrcSpecification();

  /**
   * Returns the meta object for the containment reference list '{@link org.trc.xtext.dsl.dsl.TrcSpecification#getFroms <em>Froms</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Froms</em>'.
   * @see org.trc.xtext.dsl.dsl.TrcSpecification#getFroms()
   * @see #getTrcSpecification()
   * @generated
   */
  EReference getTrcSpecification_Froms();

  /**
   * Returns the meta object for the containment reference list '{@link org.trc.xtext.dsl.dsl.TrcSpecification#getModuleList <em>Module List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Module List</em>'.
   * @see org.trc.xtext.dsl.dsl.TrcSpecification#getModuleList()
   * @see #getTrcSpecification()
   * @generated
   */
  EReference getTrcSpecification_ModuleList();

  /**
   * Returns the meta object for the containment reference list '{@link org.trc.xtext.dsl.dsl.TrcSpecification#getTransformationList <em>Transformation List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transformation List</em>'.
   * @see org.trc.xtext.dsl.dsl.TrcSpecification#getTransformationList()
   * @see #getTrcSpecification()
   * @generated
   */
  EReference getTrcSpecification_TransformationList();

  /**
   * Returns the meta object for the containment reference list '{@link org.trc.xtext.dsl.dsl.TrcSpecification#getDependencyList <em>Dependency List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Dependency List</em>'.
   * @see org.trc.xtext.dsl.dsl.TrcSpecification#getDependencyList()
   * @see #getTrcSpecification()
   * @generated
   */
  EReference getTrcSpecification_DependencyList();

  /**
   * Returns the meta object for class '{@link org.trc.xtext.dsl.dsl.From <em>From</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>From</em>'.
   * @see org.trc.xtext.dsl.dsl.From
   * @generated
   */
  EClass getFrom();

  /**
   * Returns the meta object for the attribute '{@link org.trc.xtext.dsl.dsl.From#getImportURI <em>Import URI</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Import URI</em>'.
   * @see org.trc.xtext.dsl.dsl.From#getImportURI()
   * @see #getFrom()
   * @generated
   */
  EAttribute getFrom_ImportURI();

  /**
   * Returns the meta object for class '{@link org.trc.xtext.dsl.dsl.Rules <em>Rules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rules</em>'.
   * @see org.trc.xtext.dsl.dsl.Rules
   * @generated
   */
  EClass getRules();

  /**
   * Returns the meta object for the attribute '{@link org.trc.xtext.dsl.dsl.Rules#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.trc.xtext.dsl.dsl.Rules#getName()
   * @see #getRules()
   * @generated
   */
  EAttribute getRules_Name();

  /**
   * Returns the meta object for class '{@link org.trc.xtext.dsl.dsl.ModuleList <em>Module List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module List</em>'.
   * @see org.trc.xtext.dsl.dsl.ModuleList
   * @generated
   */
  EClass getModuleList();

  /**
   * Returns the meta object for the containment reference list '{@link org.trc.xtext.dsl.dsl.ModuleList#getModules <em>Modules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Modules</em>'.
   * @see org.trc.xtext.dsl.dsl.ModuleList#getModules()
   * @see #getModuleList()
   * @generated
   */
  EReference getModuleList_Modules();

  /**
   * Returns the meta object for class '{@link org.trc.xtext.dsl.dsl.Modules <em>Modules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Modules</em>'.
   * @see org.trc.xtext.dsl.dsl.Modules
   * @generated
   */
  EClass getModules();

  /**
   * Returns the meta object for the attribute '{@link org.trc.xtext.dsl.dsl.Modules#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Path</em>'.
   * @see org.trc.xtext.dsl.dsl.Modules#getPath()
   * @see #getModules()
   * @generated
   */
  EAttribute getModules_Path();

  /**
   * Returns the meta object for the attribute '{@link org.trc.xtext.dsl.dsl.Modules#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.trc.xtext.dsl.dsl.Modules#getName()
   * @see #getModules()
   * @generated
   */
  EAttribute getModules_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.trc.xtext.dsl.dsl.Modules#getRuleName <em>Rule Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rule Name</em>'.
   * @see org.trc.xtext.dsl.dsl.Modules#getRuleName()
   * @see #getModules()
   * @generated
   */
  EReference getModules_RuleName();

  /**
   * Returns the meta object for class '{@link org.trc.xtext.dsl.dsl.TransformationList <em>Transformation List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation List</em>'.
   * @see org.trc.xtext.dsl.dsl.TransformationList
   * @generated
   */
  EClass getTransformationList();

  /**
   * Returns the meta object for the containment reference list '{@link org.trc.xtext.dsl.dsl.TransformationList#getTransformations <em>Transformations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transformations</em>'.
   * @see org.trc.xtext.dsl.dsl.TransformationList#getTransformations()
   * @see #getTransformationList()
   * @generated
   */
  EReference getTransformationList_Transformations();

  /**
   * Returns the meta object for class '{@link org.trc.xtext.dsl.dsl.Transformation <em>Transformation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation</em>'.
   * @see org.trc.xtext.dsl.dsl.Transformation
   * @generated
   */
  EClass getTransformation();

  /**
   * Returns the meta object for the attribute '{@link org.trc.xtext.dsl.dsl.Transformation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.trc.xtext.dsl.dsl.Transformation#getName()
   * @see #getTransformation()
   * @generated
   */
  EAttribute getTransformation_Name();

  /**
   * Returns the meta object for the reference list '{@link org.trc.xtext.dsl.dsl.Transformation#getModules <em>Modules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Modules</em>'.
   * @see org.trc.xtext.dsl.dsl.Transformation#getModules()
   * @see #getTransformation()
   * @generated
   */
  EReference getTransformation_Modules();

  /**
   * Returns the meta object for the containment reference list '{@link org.trc.xtext.dsl.dsl.Transformation#getImpacts <em>Impacts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Impacts</em>'.
   * @see org.trc.xtext.dsl.dsl.Transformation#getImpacts()
   * @see #getTransformation()
   * @generated
   */
  EReference getTransformation_Impacts();

  /**
   * Returns the meta object for class '{@link org.trc.xtext.dsl.dsl.TransformationImpact <em>Transformation Impact</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation Impact</em>'.
   * @see org.trc.xtext.dsl.dsl.TransformationImpact
   * @generated
   */
  EClass getTransformationImpact();

  /**
   * Returns the meta object for the attribute '{@link org.trc.xtext.dsl.dsl.TransformationImpact#getQualityAttributeName <em>Quality Attribute Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Quality Attribute Name</em>'.
   * @see org.trc.xtext.dsl.dsl.TransformationImpact#getQualityAttributeName()
   * @see #getTransformationImpact()
   * @generated
   */
  EAttribute getTransformationImpact_QualityAttributeName();

  /**
   * Returns the meta object for the attribute '{@link org.trc.xtext.dsl.dsl.TransformationImpact#getImpactValue <em>Impact Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Impact Value</em>'.
   * @see org.trc.xtext.dsl.dsl.TransformationImpact#getImpactValue()
   * @see #getTransformationImpact()
   * @generated
   */
  EAttribute getTransformationImpact_ImpactValue();

  /**
   * Returns the meta object for class '{@link org.trc.xtext.dsl.dsl.TransformationDependencyList <em>Transformation Dependency List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation Dependency List</em>'.
   * @see org.trc.xtext.dsl.dsl.TransformationDependencyList
   * @generated
   */
  EClass getTransformationDependencyList();

  /**
   * Returns the meta object for the attribute '{@link org.trc.xtext.dsl.dsl.TransformationDependencyList#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see org.trc.xtext.dsl.dsl.TransformationDependencyList#getName()
   * @see #getTransformationDependencyList()
   * @generated
   */
  EAttribute getTransformationDependencyList_Name();

  /**
   * Returns the meta object for the containment reference list '{@link org.trc.xtext.dsl.dsl.TransformationDependencyList#getTransformationDependencies <em>Transformation Dependencies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transformation Dependencies</em>'.
   * @see org.trc.xtext.dsl.dsl.TransformationDependencyList#getTransformationDependencies()
   * @see #getTransformationDependencyList()
   * @generated
   */
  EReference getTransformationDependencyList_TransformationDependencies();

  /**
   * Returns the meta object for class '{@link org.trc.xtext.dsl.dsl.TransformationDependency <em>Transformation Dependency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation Dependency</em>'.
   * @see org.trc.xtext.dsl.dsl.TransformationDependency
   * @generated
   */
  EClass getTransformationDependency();

  /**
   * Returns the meta object for the reference '{@link org.trc.xtext.dsl.dsl.TransformationDependency#getAppliedTransformation <em>Applied Transformation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Applied Transformation</em>'.
   * @see org.trc.xtext.dsl.dsl.TransformationDependency#getAppliedTransformation()
   * @see #getTransformationDependency()
   * @generated
   */
  EReference getTransformationDependency_AppliedTransformation();

  /**
   * Returns the meta object for the attribute '{@link org.trc.xtext.dsl.dsl.TransformationDependency#getAppliedRule <em>Applied Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Applied Rule</em>'.
   * @see org.trc.xtext.dsl.dsl.TransformationDependency#getAppliedRule()
   * @see #getTransformationDependency()
   * @generated
   */
  EAttribute getTransformationDependency_AppliedRule();

  /**
   * Returns the meta object for the attribute list '{@link org.trc.xtext.dsl.dsl.TransformationDependency#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Fields</em>'.
   * @see org.trc.xtext.dsl.dsl.TransformationDependency#getFields()
   * @see #getTransformationDependency()
   * @generated
   */
  EAttribute getTransformationDependency_Fields();

  /**
   * Returns the meta object for the containment reference list '{@link org.trc.xtext.dsl.dsl.TransformationDependency#getRequiredTransformations <em>Required Transformations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Required Transformations</em>'.
   * @see org.trc.xtext.dsl.dsl.TransformationDependency#getRequiredTransformations()
   * @see #getTransformationDependency()
   * @generated
   */
  EReference getTransformationDependency_RequiredTransformations();

  /**
   * Returns the meta object for class '{@link org.trc.xtext.dsl.dsl.AbstractRuleDependency <em>Abstract Rule Dependency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Rule Dependency</em>'.
   * @see org.trc.xtext.dsl.dsl.AbstractRuleDependency
   * @generated
   */
  EClass getAbstractRuleDependency();

  /**
   * Returns the meta object for class '{@link org.trc.xtext.dsl.dsl.RuleDependencyConjunction <em>Rule Dependency Conjunction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Dependency Conjunction</em>'.
   * @see org.trc.xtext.dsl.dsl.RuleDependencyConjunction
   * @generated
   */
  EClass getRuleDependencyConjunction();

  /**
   * Returns the meta object for the containment reference list '{@link org.trc.xtext.dsl.dsl.RuleDependencyConjunction#getRequiredTransformations <em>Required Transformations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Required Transformations</em>'.
   * @see org.trc.xtext.dsl.dsl.RuleDependencyConjunction#getRequiredTransformations()
   * @see #getRuleDependencyConjunction()
   * @generated
   */
  EReference getRuleDependencyConjunction_RequiredTransformations();

  /**
   * Returns the meta object for class '{@link org.trc.xtext.dsl.dsl.RuleDependencyDisjunction <em>Rule Dependency Disjunction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Dependency Disjunction</em>'.
   * @see org.trc.xtext.dsl.dsl.RuleDependencyDisjunction
   * @generated
   */
  EClass getRuleDependencyDisjunction();

  /**
   * Returns the meta object for the containment reference list '{@link org.trc.xtext.dsl.dsl.RuleDependencyDisjunction#getRequiredTransformations <em>Required Transformations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Required Transformations</em>'.
   * @see org.trc.xtext.dsl.dsl.RuleDependencyDisjunction#getRequiredTransformations()
   * @see #getRuleDependencyDisjunction()
   * @generated
   */
  EReference getRuleDependencyDisjunction_RequiredTransformations();

  /**
   * Returns the meta object for class '{@link org.trc.xtext.dsl.dsl.RuleDependency <em>Rule Dependency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Dependency</em>'.
   * @see org.trc.xtext.dsl.dsl.RuleDependency
   * @generated
   */
  EClass getRuleDependency();

  /**
   * Returns the meta object for the containment reference list '{@link org.trc.xtext.dsl.dsl.RuleDependency#getRd <em>Rd</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Rd</em>'.
   * @see org.trc.xtext.dsl.dsl.RuleDependency#getRd()
   * @see #getRuleDependency()
   * @generated
   */
  EReference getRuleDependency_Rd();

  /**
   * Returns the meta object for the containment reference list '{@link org.trc.xtext.dsl.dsl.RuleDependency#getEd <em>Ed</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Ed</em>'.
   * @see org.trc.xtext.dsl.dsl.RuleDependency#getEd()
   * @see #getRuleDependency()
   * @generated
   */
  EReference getRuleDependency_Ed();

  /**
   * Returns the meta object for class '{@link org.trc.xtext.dsl.dsl.requiresDependency <em>requires Dependency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>requires Dependency</em>'.
   * @see org.trc.xtext.dsl.dsl.requiresDependency
   * @generated
   */
  EClass getrequiresDependency();

  /**
   * Returns the meta object for the reference list '{@link org.trc.xtext.dsl.dsl.requiresDependency#getRequiredTransformation <em>Required Transformation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Required Transformation</em>'.
   * @see org.trc.xtext.dsl.dsl.requiresDependency#getRequiredTransformation()
   * @see #getrequiresDependency()
   * @generated
   */
  EReference getrequiresDependency_RequiredTransformation();

  /**
   * Returns the meta object for the attribute '{@link org.trc.xtext.dsl.dsl.requiresDependency#getRequiredRule <em>Required Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Required Rule</em>'.
   * @see org.trc.xtext.dsl.dsl.requiresDependency#getRequiredRule()
   * @see #getrequiresDependency()
   * @generated
   */
  EAttribute getrequiresDependency_RequiredRule();

  /**
   * Returns the meta object for the attribute '{@link org.trc.xtext.dsl.dsl.requiresDependency#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fields</em>'.
   * @see org.trc.xtext.dsl.dsl.requiresDependency#getFields()
   * @see #getrequiresDependency()
   * @generated
   */
  EAttribute getrequiresDependency_Fields();

  /**
   * Returns the meta object for the attribute '{@link org.trc.xtext.dsl.dsl.requiresDependency#getOclExpression <em>Ocl Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ocl Expression</em>'.
   * @see org.trc.xtext.dsl.dsl.requiresDependency#getOclExpression()
   * @see #getrequiresDependency()
   * @generated
   */
  EAttribute getrequiresDependency_OclExpression();

  /**
   * Returns the meta object for class '{@link org.trc.xtext.dsl.dsl.excludeDependency <em>exclude Dependency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>exclude Dependency</em>'.
   * @see org.trc.xtext.dsl.dsl.excludeDependency
   * @generated
   */
  EClass getexcludeDependency();

  /**
   * Returns the meta object for the reference list '{@link org.trc.xtext.dsl.dsl.excludeDependency#getRequiredTransformation <em>Required Transformation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Required Transformation</em>'.
   * @see org.trc.xtext.dsl.dsl.excludeDependency#getRequiredTransformation()
   * @see #getexcludeDependency()
   * @generated
   */
  EReference getexcludeDependency_RequiredTransformation();

  /**
   * Returns the meta object for the attribute '{@link org.trc.xtext.dsl.dsl.excludeDependency#getRequiredRule <em>Required Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Required Rule</em>'.
   * @see org.trc.xtext.dsl.dsl.excludeDependency#getRequiredRule()
   * @see #getexcludeDependency()
   * @generated
   */
  EAttribute getexcludeDependency_RequiredRule();

  /**
   * Returns the meta object for the attribute '{@link org.trc.xtext.dsl.dsl.excludeDependency#getFields <em>Fields</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Fields</em>'.
   * @see org.trc.xtext.dsl.dsl.excludeDependency#getFields()
   * @see #getexcludeDependency()
   * @generated
   */
  EAttribute getexcludeDependency_Fields();

  /**
   * Returns the meta object for the attribute '{@link org.trc.xtext.dsl.dsl.excludeDependency#getOclExpression <em>Ocl Expression</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Ocl Expression</em>'.
   * @see org.trc.xtext.dsl.dsl.excludeDependency#getOclExpression()
   * @see #getexcludeDependency()
   * @generated
   */
  EAttribute getexcludeDependency_OclExpression();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  DslFactory getDslFactory();

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
     * The meta object literal for the '{@link org.trc.xtext.dsl.dsl.impl.TrcSpecificationImpl <em>Trc Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.trc.xtext.dsl.dsl.impl.TrcSpecificationImpl
     * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getTrcSpecification()
     * @generated
     */
    EClass TRC_SPECIFICATION = eINSTANCE.getTrcSpecification();

    /**
     * The meta object literal for the '<em><b>Froms</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRC_SPECIFICATION__FROMS = eINSTANCE.getTrcSpecification_Froms();

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
     * The meta object literal for the '{@link org.trc.xtext.dsl.dsl.impl.FromImpl <em>From</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.trc.xtext.dsl.dsl.impl.FromImpl
     * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getFrom()
     * @generated
     */
    EClass FROM = eINSTANCE.getFrom();

    /**
     * The meta object literal for the '<em><b>Import URI</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute FROM__IMPORT_URI = eINSTANCE.getFrom_ImportURI();

    /**
     * The meta object literal for the '{@link org.trc.xtext.dsl.dsl.impl.RulesImpl <em>Rules</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.trc.xtext.dsl.dsl.impl.RulesImpl
     * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getRules()
     * @generated
     */
    EClass RULES = eINSTANCE.getRules();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULES__NAME = eINSTANCE.getRules_Name();

    /**
     * The meta object literal for the '{@link org.trc.xtext.dsl.dsl.impl.ModuleListImpl <em>Module List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.trc.xtext.dsl.dsl.impl.ModuleListImpl
     * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getModuleList()
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
     * The meta object literal for the '{@link org.trc.xtext.dsl.dsl.impl.ModulesImpl <em>Modules</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.trc.xtext.dsl.dsl.impl.ModulesImpl
     * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getModules()
     * @generated
     */
    EClass MODULES = eINSTANCE.getModules();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULES__PATH = eINSTANCE.getModules_Path();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULES__NAME = eINSTANCE.getModules_Name();

    /**
     * The meta object literal for the '<em><b>Rule Name</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference MODULES__RULE_NAME = eINSTANCE.getModules_RuleName();

    /**
     * The meta object literal for the '{@link org.trc.xtext.dsl.dsl.impl.TransformationListImpl <em>Transformation List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.trc.xtext.dsl.dsl.impl.TransformationListImpl
     * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getTransformationList()
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
     * The meta object literal for the '{@link org.trc.xtext.dsl.dsl.impl.TransformationImpl <em>Transformation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.trc.xtext.dsl.dsl.impl.TransformationImpl
     * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getTransformation()
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
     * The meta object literal for the '{@link org.trc.xtext.dsl.dsl.impl.TransformationImpactImpl <em>Transformation Impact</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.trc.xtext.dsl.dsl.impl.TransformationImpactImpl
     * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getTransformationImpact()
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
     * The meta object literal for the '{@link org.trc.xtext.dsl.dsl.impl.TransformationDependencyListImpl <em>Transformation Dependency List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.trc.xtext.dsl.dsl.impl.TransformationDependencyListImpl
     * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getTransformationDependencyList()
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
     * The meta object literal for the '{@link org.trc.xtext.dsl.dsl.impl.TransformationDependencyImpl <em>Transformation Dependency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.trc.xtext.dsl.dsl.impl.TransformationDependencyImpl
     * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getTransformationDependency()
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
     * The meta object literal for the '<em><b>Applied Rule</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSFORMATION_DEPENDENCY__APPLIED_RULE = eINSTANCE.getTransformationDependency_AppliedRule();

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
     * The meta object literal for the '{@link org.trc.xtext.dsl.dsl.impl.AbstractRuleDependencyImpl <em>Abstract Rule Dependency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.trc.xtext.dsl.dsl.impl.AbstractRuleDependencyImpl
     * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getAbstractRuleDependency()
     * @generated
     */
    EClass ABSTRACT_RULE_DEPENDENCY = eINSTANCE.getAbstractRuleDependency();

    /**
     * The meta object literal for the '{@link org.trc.xtext.dsl.dsl.impl.RuleDependencyConjunctionImpl <em>Rule Dependency Conjunction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.trc.xtext.dsl.dsl.impl.RuleDependencyConjunctionImpl
     * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getRuleDependencyConjunction()
     * @generated
     */
    EClass RULE_DEPENDENCY_CONJUNCTION = eINSTANCE.getRuleDependencyConjunction();

    /**
     * The meta object literal for the '<em><b>Required Transformations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DEPENDENCY_CONJUNCTION__REQUIRED_TRANSFORMATIONS = eINSTANCE.getRuleDependencyConjunction_RequiredTransformations();

    /**
     * The meta object literal for the '{@link org.trc.xtext.dsl.dsl.impl.RuleDependencyDisjunctionImpl <em>Rule Dependency Disjunction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.trc.xtext.dsl.dsl.impl.RuleDependencyDisjunctionImpl
     * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getRuleDependencyDisjunction()
     * @generated
     */
    EClass RULE_DEPENDENCY_DISJUNCTION = eINSTANCE.getRuleDependencyDisjunction();

    /**
     * The meta object literal for the '<em><b>Required Transformations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DEPENDENCY_DISJUNCTION__REQUIRED_TRANSFORMATIONS = eINSTANCE.getRuleDependencyDisjunction_RequiredTransformations();

    /**
     * The meta object literal for the '{@link org.trc.xtext.dsl.dsl.impl.RuleDependencyImpl <em>Rule Dependency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.trc.xtext.dsl.dsl.impl.RuleDependencyImpl
     * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getRuleDependency()
     * @generated
     */
    EClass RULE_DEPENDENCY = eINSTANCE.getRuleDependency();

    /**
     * The meta object literal for the '<em><b>Rd</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DEPENDENCY__RD = eINSTANCE.getRuleDependency_Rd();

    /**
     * The meta object literal for the '<em><b>Ed</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DEPENDENCY__ED = eINSTANCE.getRuleDependency_Ed();

    /**
     * The meta object literal for the '{@link org.trc.xtext.dsl.dsl.impl.requiresDependencyImpl <em>requires Dependency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.trc.xtext.dsl.dsl.impl.requiresDependencyImpl
     * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getrequiresDependency()
     * @generated
     */
    EClass REQUIRES_DEPENDENCY = eINSTANCE.getrequiresDependency();

    /**
     * The meta object literal for the '<em><b>Required Transformation</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference REQUIRES_DEPENDENCY__REQUIRED_TRANSFORMATION = eINSTANCE.getrequiresDependency_RequiredTransformation();

    /**
     * The meta object literal for the '<em><b>Required Rule</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQUIRES_DEPENDENCY__REQUIRED_RULE = eINSTANCE.getrequiresDependency_RequiredRule();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQUIRES_DEPENDENCY__FIELDS = eINSTANCE.getrequiresDependency_Fields();

    /**
     * The meta object literal for the '<em><b>Ocl Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute REQUIRES_DEPENDENCY__OCL_EXPRESSION = eINSTANCE.getrequiresDependency_OclExpression();

    /**
     * The meta object literal for the '{@link org.trc.xtext.dsl.dsl.impl.excludeDependencyImpl <em>exclude Dependency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see org.trc.xtext.dsl.dsl.impl.excludeDependencyImpl
     * @see org.trc.xtext.dsl.dsl.impl.DslPackageImpl#getexcludeDependency()
     * @generated
     */
    EClass EXCLUDE_DEPENDENCY = eINSTANCE.getexcludeDependency();

    /**
     * The meta object literal for the '<em><b>Required Transformation</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference EXCLUDE_DEPENDENCY__REQUIRED_TRANSFORMATION = eINSTANCE.getexcludeDependency_RequiredTransformation();

    /**
     * The meta object literal for the '<em><b>Required Rule</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXCLUDE_DEPENDENCY__REQUIRED_RULE = eINSTANCE.getexcludeDependency_RequiredRule();

    /**
     * The meta object literal for the '<em><b>Fields</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXCLUDE_DEPENDENCY__FIELDS = eINSTANCE.getexcludeDependency_Fields();

    /**
     * The meta object literal for the '<em><b>Ocl Expression</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute EXCLUDE_DEPENDENCY__OCL_EXPRESSION = eINSTANCE.getexcludeDependency_OclExpression();

  }

} //DslPackage
