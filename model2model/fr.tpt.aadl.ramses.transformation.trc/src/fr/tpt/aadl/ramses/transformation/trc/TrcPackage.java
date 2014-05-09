/**
 */
package fr.tpt.aadl.ramses.transformation.trc;

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
 * @see fr.tpt.aadl.ramses.transformation.trc.TrcFactory
 * @model kind="package"
 * @generated
 */
public interface TrcPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "trc";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://fr.tpt.aadl.ramses.transformation/TRC/1.0";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "trc";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TrcPackage eINSTANCE = fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl.init();

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.TrcSpecificationImpl <em>Specification</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcSpecificationImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getTrcSpecification()
   * @generated
   */
  int TRC_SPECIFICATION = 0;

  /**
   * The feature id for the '<em><b>Transformations</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRC_SPECIFICATION__TRANSFORMATIONS = 0;

  /**
   * The feature id for the '<em><b>Dependencies</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRC_SPECIFICATION__DEPENDENCIES = 1;

  /**
   * The number of structural features of the '<em>Specification</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRC_SPECIFICATION_FEATURE_COUNT = 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationImpl <em>Transformation</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TransformationImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getTransformation()
   * @generated
   */
  int TRANSFORMATION = 3;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationElementImpl <em>Transformation Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TransformationElementImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getTransformationElement()
   * @generated
   */
  int TRANSFORMATION_ELEMENT = 10;

  /**
   * The number of structural features of the '<em>Transformation Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationImpactImpl <em>Transformation Impact</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TransformationImpactImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getTransformationImpact()
   * @generated
   */
  int TRANSFORMATION_IMPACT = 1;

  /**
   * The feature id for the '<em><b>Impact Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_IMPACT__IMPACT_VALUE = TRANSFORMATION_ELEMENT_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Quality Attribute Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_IMPACT__QUALITY_ATTRIBUTE_NAME = TRANSFORMATION_ELEMENT_FEATURE_COUNT + 1;

  /**
   * The number of structural features of the '<em>Transformation Impact</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_IMPACT_FEATURE_COUNT = TRANSFORMATION_ELEMENT_FEATURE_COUNT + 2;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.ModuleImpl <em>Module</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.ModuleImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getModule()
   * @generated
   */
  int MODULE = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__NAME = 0;

  /**
   * The feature id for the '<em><b>Rule Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__RULE_NAME = 1;

  /**
   * The feature id for the '<em><b>Path</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE__PATH = 2;

  /**
   * The number of structural features of the '<em>Module</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int MODULE_FEATURE_COUNT = 3;

  /**
   * The feature id for the '<em><b>Impacts</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION__IMPACTS = 0;

  /**
   * The feature id for the '<em><b>Modules</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION__MODULES = 1;

  /**
   * The feature id for the '<em><b>Rule Name</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION__RULE_NAME = 2;

  /**
   * The feature id for the '<em><b>Name</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION__NAME = 3;

  /**
   * The number of structural features of the '<em>Transformation</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationDependencyImpl <em>Transformation Dependency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TransformationDependencyImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getTransformationDependency()
   * @generated
   */
  int TRANSFORMATION_DEPENDENCY = 4;

  /**
   * The feature id for the '<em><b>Variable Id</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY__VARIABLE_ID = 0;

  /**
   * The feature id for the '<em><b>Applied Transformation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION = 1;

  /**
   * The feature id for the '<em><b>Required Transformations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS = 2;

  /**
   * The feature id for the '<em><b>Applied Rule</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY__APPLIED_RULE = 3;

  /**
   * The number of structural features of the '<em>Transformation Dependency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY_FEATURE_COUNT = 4;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.AbstractRuleDependencyImpl <em>Abstract Rule Dependency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.AbstractRuleDependencyImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getAbstractRuleDependency()
   * @generated
   */
  int ABSTRACT_RULE_DEPENDENCY = 5;

  /**
   * The number of structural features of the '<em>Abstract Rule Dependency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int ABSTRACT_RULE_DEPENDENCY_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyCompositeImpl <em>Rule Dependency Composite</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyCompositeImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getRuleDependencyComposite()
   * @generated
   */
  int RULE_DEPENDENCY_COMPOSITE = 9;

  /**
   * The feature id for the '<em><b>Required Transformations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY_COMPOSITE__REQUIRED_TRANSFORMATIONS = ABSTRACT_RULE_DEPENDENCY_FEATURE_COUNT + 0;

  /**
   * The number of structural features of the '<em>Rule Dependency Composite</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY_COMPOSITE_FEATURE_COUNT = ABSTRACT_RULE_DEPENDENCY_FEATURE_COUNT + 1;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyConjunctionImpl <em>Rule Dependency Conjunction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyConjunctionImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getRuleDependencyConjunction()
   * @generated
   */
  int RULE_DEPENDENCY_CONJUNCTION = 6;

  /**
   * The feature id for the '<em><b>Required Transformations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY_CONJUNCTION__REQUIRED_TRANSFORMATIONS = RULE_DEPENDENCY_COMPOSITE__REQUIRED_TRANSFORMATIONS;

  /**
   * The number of structural features of the '<em>Rule Dependency Conjunction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY_CONJUNCTION_FEATURE_COUNT = RULE_DEPENDENCY_COMPOSITE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyDisjunctionImpl <em>Rule Dependency Disjunction</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyDisjunctionImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getRuleDependencyDisjunction()
   * @generated
   */
  int RULE_DEPENDENCY_DISJUNCTION = 7;

  /**
   * The feature id for the '<em><b>Required Transformations</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY_DISJUNCTION__REQUIRED_TRANSFORMATIONS = RULE_DEPENDENCY_COMPOSITE__REQUIRED_TRANSFORMATIONS;

  /**
   * The number of structural features of the '<em>Rule Dependency Disjunction</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY_DISJUNCTION_FEATURE_COUNT = RULE_DEPENDENCY_COMPOSITE_FEATURE_COUNT + 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyImpl <em>Rule Dependency</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getRuleDependency()
   * @generated
   */
  int RULE_DEPENDENCY = 8;

  /**
   * The feature id for the '<em><b>Variable Id</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY__VARIABLE_ID = ABSTRACT_RULE_DEPENDENCY_FEATURE_COUNT + 0;

  /**
   * The feature id for the '<em><b>Field Names</b></em>' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY__FIELD_NAMES = ABSTRACT_RULE_DEPENDENCY_FEATURE_COUNT + 1;

  /**
   * The feature id for the '<em><b>Required Transformation</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY__REQUIRED_TRANSFORMATION = ABSTRACT_RULE_DEPENDENCY_FEATURE_COUNT + 2;

  /**
   * The feature id for the '<em><b>Required Rule</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY__REQUIRED_RULE = ABSTRACT_RULE_DEPENDENCY_FEATURE_COUNT + 3;

  /**
   * The feature id for the '<em><b>Is Exclusion</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY__IS_EXCLUSION = ABSTRACT_RULE_DEPENDENCY_FEATURE_COUNT + 4;

  /**
   * The number of structural features of the '<em>Rule Dependency</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int RULE_DEPENDENCY_FEATURE_COUNT = ABSTRACT_RULE_DEPENDENCY_FEATURE_COUNT + 5;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.ModuleListImpl <em>Module List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.ModuleListImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getModuleList()
   * @generated
   */
  int MODULE_LIST = 11;

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
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.SpecificationElementImpl <em>Specification Element</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.SpecificationElementImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getSpecificationElement()
   * @generated
   */
  int SPECIFICATION_ELEMENT = 12;

  /**
   * The number of structural features of the '<em>Specification Element</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int SPECIFICATION_ELEMENT_FEATURE_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationListImpl <em>Transformation List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TransformationListImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getTransformationList()
   * @generated
   */
  int TRANSFORMATION_LIST = 13;

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
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationDependencyListImpl <em>Transformation Dependency List</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TransformationDependencyListImpl
   * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getTransformationDependencyList()
   * @generated
   */
  int TRANSFORMATION_DEPENDENCY_LIST = 14;

  /**
   * The feature id for the '<em><b>Transformation Dependencies</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES = 0;

  /**
   * The number of structural features of the '<em>Transformation Dependency List</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int TRANSFORMATION_DEPENDENCY_LIST_FEATURE_COUNT = 1;


  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.TrcSpecification <em>Specification</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Specification</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.TrcSpecification
   * @generated
   */
  EClass getTrcSpecification();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.TrcSpecification#getTransformations <em>Transformations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Transformations</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.TrcSpecification#getTransformations()
   * @see #getTrcSpecification()
   * @generated
   */
  EReference getTrcSpecification_Transformations();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.TrcSpecification#getDependencies <em>Dependencies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Dependencies</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.TrcSpecification#getDependencies()
   * @see #getTrcSpecification()
   * @generated
   */
  EReference getTrcSpecification_Dependencies();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.Transformation <em>Transformation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.Transformation
   * @generated
   */
  EClass getTransformation();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.Transformation#getImpacts <em>Impacts</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Impacts</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.Transformation#getImpacts()
   * @see #getTransformation()
   * @generated
   */
  EReference getTransformation_Impacts();

  /**
   * Returns the meta object for the containment reference '{@link fr.tpt.aadl.ramses.transformation.trc.Transformation#getModules <em>Modules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference '<em>Modules</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.Transformation#getModules()
   * @see #getTransformation()
   * @generated
   */
  EReference getTransformation_Modules();

  /**
   * Returns the meta object for the attribute list '{@link fr.tpt.aadl.ramses.transformation.trc.Transformation#getRuleName <em>Rule Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Rule Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.Transformation#getRuleName()
   * @see #getTransformation()
   * @generated
   */
  EAttribute getTransformation_RuleName();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.Transformation#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.Transformation#getName()
   * @see #getTransformation()
   * @generated
   */
  EAttribute getTransformation_Name();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationImpact <em>Transformation Impact</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation Impact</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.TransformationImpact
   * @generated
   */
  EClass getTransformationImpact();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationImpact#getImpactValue <em>Impact Value</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Impact Value</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.TransformationImpact#getImpactValue()
   * @see #getTransformationImpact()
   * @generated
   */
  EAttribute getTransformationImpact_ImpactValue();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationImpact#getQualityAttributeName <em>Quality Attribute Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Quality Attribute Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.TransformationImpact#getQualityAttributeName()
   * @see #getTransformationImpact()
   * @generated
   */
  EAttribute getTransformationImpact_QualityAttributeName();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.Module
   * @generated
   */
  EClass getModule();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.Module#getName <em>Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.Module#getName()
   * @see #getModule()
   * @generated
   */
  EAttribute getModule_Name();

  /**
   * Returns the meta object for the attribute list '{@link fr.tpt.aadl.ramses.transformation.trc.Module#getRuleName <em>Rule Name</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Rule Name</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.Module#getRuleName()
   * @see #getModule()
   * @generated
   */
  EAttribute getModule_RuleName();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.Module#getPath <em>Path</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Path</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.Module#getPath()
   * @see #getModule()
   * @generated
   */
  EAttribute getModule_Path();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependency <em>Transformation Dependency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation Dependency</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.TransformationDependency
   * @generated
   */
  EClass getTransformationDependency();

  /**
   * Returns the meta object for the attribute list '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependency#getVariableId <em>Variable Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Variable Id</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.TransformationDependency#getVariableId()
   * @see #getTransformationDependency()
   * @generated
   */
  EAttribute getTransformationDependency_VariableId();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependency#getAppliedTransformation <em>Applied Transformation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Applied Transformation</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.TransformationDependency#getAppliedTransformation()
   * @see #getTransformationDependency()
   * @generated
   */
  EReference getTransformationDependency_AppliedTransformation();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependency#getRequiredTransformations <em>Required Transformations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Required Transformations</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.TransformationDependency#getRequiredTransformations()
   * @see #getTransformationDependency()
   * @generated
   */
  EReference getTransformationDependency_RequiredTransformations();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependency#getAppliedRule <em>Applied Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Applied Rule</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.TransformationDependency#getAppliedRule()
   * @see #getTransformationDependency()
   * @generated
   */
  EAttribute getTransformationDependency_AppliedRule();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.AbstractRuleDependency <em>Abstract Rule Dependency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Abstract Rule Dependency</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.AbstractRuleDependency
   * @generated
   */
  EClass getAbstractRuleDependency();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependencyConjunction <em>Rule Dependency Conjunction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Dependency Conjunction</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.RuleDependencyConjunction
   * @generated
   */
  EClass getRuleDependencyConjunction();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependencyDisjunction <em>Rule Dependency Disjunction</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Dependency Disjunction</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.RuleDependencyDisjunction
   * @generated
   */
  EClass getRuleDependencyDisjunction();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency <em>Rule Dependency</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Dependency</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.RuleDependency
   * @generated
   */
  EClass getRuleDependency();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getVariableId <em>Variable Id</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Variable Id</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getVariableId()
   * @see #getRuleDependency()
   * @generated
   */
  EAttribute getRuleDependency_VariableId();

  /**
   * Returns the meta object for the attribute list '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getFieldNames <em>Field Names</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute list '<em>Field Names</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getFieldNames()
   * @see #getRuleDependency()
   * @generated
   */
  EAttribute getRuleDependency_FieldNames();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getRequiredTransformation <em>Required Transformation</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Required Transformation</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getRequiredTransformation()
   * @see #getRuleDependency()
   * @generated
   */
  EReference getRuleDependency_RequiredTransformation();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getRequiredRule <em>Required Rule</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Required Rule</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getRequiredRule()
   * @see #getRuleDependency()
   * @generated
   */
  EAttribute getRuleDependency_RequiredRule();

  /**
   * Returns the meta object for the attribute '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency#isIsExclusion <em>Is Exclusion</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the attribute '<em>Is Exclusion</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.RuleDependency#isIsExclusion()
   * @see #getRuleDependency()
   * @generated
   */
  EAttribute getRuleDependency_IsExclusion();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependencyComposite <em>Rule Dependency Composite</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Rule Dependency Composite</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.RuleDependencyComposite
   * @generated
   */
  EClass getRuleDependencyComposite();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependencyComposite#getRequiredTransformations <em>Required Transformations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Required Transformations</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.RuleDependencyComposite#getRequiredTransformations()
   * @see #getRuleDependencyComposite()
   * @generated
   */
  EReference getRuleDependencyComposite_RequiredTransformations();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationElement <em>Transformation Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation Element</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.TransformationElement
   * @generated
   */
  EClass getTransformationElement();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.ModuleList <em>Module List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Module List</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.ModuleList
   * @generated
   */
  EClass getModuleList();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.ModuleList#getModules <em>Modules</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Modules</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.ModuleList#getModules()
   * @see #getModuleList()
   * @generated
   */
  EReference getModuleList_Modules();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.SpecificationElement <em>Specification Element</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Specification Element</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.SpecificationElement
   * @generated
   */
  EClass getSpecificationElement();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationList <em>Transformation List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation List</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.TransformationList
   * @generated
   */
  EClass getTransformationList();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationList#getTransformations <em>Transformations</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transformations</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.TransformationList#getTransformations()
   * @see #getTransformationList()
   * @generated
   */
  EReference getTransformationList_Transformations();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependencyList <em>Transformation Dependency List</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Transformation Dependency List</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.TransformationDependencyList
   * @generated
   */
  EClass getTransformationDependencyList();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependencyList#getTransformationDependencies <em>Transformation Dependencies</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Transformation Dependencies</em>'.
   * @see fr.tpt.aadl.ramses.transformation.trc.TransformationDependencyList#getTransformationDependencies()
   * @see #getTransformationDependencyList()
   * @generated
   */
  EReference getTransformationDependencyList_TransformationDependencies();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  TrcFactory getTrcFactory();

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
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.TrcSpecificationImpl <em>Specification</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcSpecificationImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getTrcSpecification()
     * @generated
     */
    EClass TRC_SPECIFICATION = eINSTANCE.getTrcSpecification();

    /**
     * The meta object literal for the '<em><b>Transformations</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRC_SPECIFICATION__TRANSFORMATIONS = eINSTANCE.getTrcSpecification_Transformations();

    /**
     * The meta object literal for the '<em><b>Dependencies</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRC_SPECIFICATION__DEPENDENCIES = eINSTANCE.getTrcSpecification_Dependencies();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationImpl <em>Transformation</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TransformationImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getTransformation()
     * @generated
     */
    EClass TRANSFORMATION = eINSTANCE.getTransformation();

    /**
     * The meta object literal for the '<em><b>Impacts</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION__IMPACTS = eINSTANCE.getTransformation_Impacts();

    /**
     * The meta object literal for the '<em><b>Modules</b></em>' containment reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION__MODULES = eINSTANCE.getTransformation_Modules();

    /**
     * The meta object literal for the '<em><b>Rule Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSFORMATION__RULE_NAME = eINSTANCE.getTransformation_RuleName();

    /**
     * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSFORMATION__NAME = eINSTANCE.getTransformation_Name();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationImpactImpl <em>Transformation Impact</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TransformationImpactImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getTransformationImpact()
     * @generated
     */
    EClass TRANSFORMATION_IMPACT = eINSTANCE.getTransformationImpact();

    /**
     * The meta object literal for the '<em><b>Impact Value</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSFORMATION_IMPACT__IMPACT_VALUE = eINSTANCE.getTransformationImpact_ImpactValue();

    /**
     * The meta object literal for the '<em><b>Quality Attribute Name</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSFORMATION_IMPACT__QUALITY_ATTRIBUTE_NAME = eINSTANCE.getTransformationImpact_QualityAttributeName();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.ModuleImpl <em>Module</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.ModuleImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getModule()
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
     * The meta object literal for the '<em><b>Rule Name</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE__RULE_NAME = eINSTANCE.getModule_RuleName();

    /**
     * The meta object literal for the '<em><b>Path</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute MODULE__PATH = eINSTANCE.getModule_Path();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationDependencyImpl <em>Transformation Dependency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TransformationDependencyImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getTransformationDependency()
     * @generated
     */
    EClass TRANSFORMATION_DEPENDENCY = eINSTANCE.getTransformationDependency();

    /**
     * The meta object literal for the '<em><b>Variable Id</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSFORMATION_DEPENDENCY__VARIABLE_ID = eINSTANCE.getTransformationDependency_VariableId();

    /**
     * The meta object literal for the '<em><b>Applied Transformation</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION = eINSTANCE.getTransformationDependency_AppliedTransformation();

    /**
     * The meta object literal for the '<em><b>Required Transformations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS = eINSTANCE.getTransformationDependency_RequiredTransformations();

    /**
     * The meta object literal for the '<em><b>Applied Rule</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute TRANSFORMATION_DEPENDENCY__APPLIED_RULE = eINSTANCE.getTransformationDependency_AppliedRule();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.AbstractRuleDependencyImpl <em>Abstract Rule Dependency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.AbstractRuleDependencyImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getAbstractRuleDependency()
     * @generated
     */
    EClass ABSTRACT_RULE_DEPENDENCY = eINSTANCE.getAbstractRuleDependency();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyConjunctionImpl <em>Rule Dependency Conjunction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyConjunctionImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getRuleDependencyConjunction()
     * @generated
     */
    EClass RULE_DEPENDENCY_CONJUNCTION = eINSTANCE.getRuleDependencyConjunction();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyDisjunctionImpl <em>Rule Dependency Disjunction</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyDisjunctionImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getRuleDependencyDisjunction()
     * @generated
     */
    EClass RULE_DEPENDENCY_DISJUNCTION = eINSTANCE.getRuleDependencyDisjunction();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyImpl <em>Rule Dependency</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getRuleDependency()
     * @generated
     */
    EClass RULE_DEPENDENCY = eINSTANCE.getRuleDependency();

    /**
     * The meta object literal for the '<em><b>Variable Id</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_DEPENDENCY__VARIABLE_ID = eINSTANCE.getRuleDependency_VariableId();

    /**
     * The meta object literal for the '<em><b>Field Names</b></em>' attribute list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_DEPENDENCY__FIELD_NAMES = eINSTANCE.getRuleDependency_FieldNames();

    /**
     * The meta object literal for the '<em><b>Required Transformation</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DEPENDENCY__REQUIRED_TRANSFORMATION = eINSTANCE.getRuleDependency_RequiredTransformation();

    /**
     * The meta object literal for the '<em><b>Required Rule</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_DEPENDENCY__REQUIRED_RULE = eINSTANCE.getRuleDependency_RequiredRule();

    /**
     * The meta object literal for the '<em><b>Is Exclusion</b></em>' attribute feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EAttribute RULE_DEPENDENCY__IS_EXCLUSION = eINSTANCE.getRuleDependency_IsExclusion();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyCompositeImpl <em>Rule Dependency Composite</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyCompositeImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getRuleDependencyComposite()
     * @generated
     */
    EClass RULE_DEPENDENCY_COMPOSITE = eINSTANCE.getRuleDependencyComposite();

    /**
     * The meta object literal for the '<em><b>Required Transformations</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference RULE_DEPENDENCY_COMPOSITE__REQUIRED_TRANSFORMATIONS = eINSTANCE.getRuleDependencyComposite_RequiredTransformations();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationElementImpl <em>Transformation Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TransformationElementImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getTransformationElement()
     * @generated
     */
    EClass TRANSFORMATION_ELEMENT = eINSTANCE.getTransformationElement();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.ModuleListImpl <em>Module List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.ModuleListImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getModuleList()
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
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.SpecificationElementImpl <em>Specification Element</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.SpecificationElementImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getSpecificationElement()
     * @generated
     */
    EClass SPECIFICATION_ELEMENT = eINSTANCE.getSpecificationElement();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationListImpl <em>Transformation List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TransformationListImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getTransformationList()
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
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationDependencyListImpl <em>Transformation Dependency List</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TransformationDependencyListImpl
     * @see fr.tpt.aadl.ramses.transformation.trc.impl.TrcPackageImpl#getTransformationDependencyList()
     * @generated
     */
    EClass TRANSFORMATION_DEPENDENCY_LIST = eINSTANCE.getTransformationDependencyList();

    /**
     * The meta object literal for the '<em><b>Transformation Dependencies</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES = eINSTANCE.getTransformationDependencyList_TransformationDependencies();

  }

} //TrcPackage
