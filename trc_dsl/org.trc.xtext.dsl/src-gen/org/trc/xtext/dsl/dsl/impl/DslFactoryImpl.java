/**
 */
package org.trc.xtext.dsl.dsl.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import org.trc.xtext.dsl.dsl.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DslFactoryImpl extends EFactoryImpl implements DslFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static DslFactory init()
  {
    try
    {
      DslFactory theDslFactory = (DslFactory)EPackage.Registry.INSTANCE.getEFactory(DslPackage.eNS_URI);
      if (theDslFactory != null)
      {
        return theDslFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new DslFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case DslPackage.TRC_SPECIFICATION: return createTrcSpecification();
      case DslPackage.FROM: return createFrom();
      case DslPackage.RULES: return createRules();
      case DslPackage.MODULE_LIST: return createModuleList();
      case DslPackage.MODULES: return createModules();
      case DslPackage.TRANSFORMATION_LIST: return createTransformationList();
      case DslPackage.TRANSFORMATION: return createTransformation();
      case DslPackage.TRANSFORMATION_IMPACT: return createTransformationImpact();
      case DslPackage.TRANSFORMATION_DEPENDENCY_LIST: return createTransformationDependencyList();
      case DslPackage.TRANSFORMATION_DEPENDENCY: return createTransformationDependency();
      case DslPackage.ABSTRACT_RULE_DEPENDENCY: return createAbstractRuleDependency();
      case DslPackage.RULE_DEPENDENCY_CONJUNCTION: return createRuleDependencyConjunction();
      case DslPackage.RULE_DEPENDENCY_DISJUNCTION: return createRuleDependencyDisjunction();
      case DslPackage.RULE_DEPENDENCY: return createRuleDependency();
      case DslPackage.REQUIRES_DEPENDENCY: return createrequiresDependency();
      case DslPackage.EXCLUDE_DEPENDENCY: return createexcludeDependency();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrcSpecification createTrcSpecification()
  {
    TrcSpecificationImpl trcSpecification = new TrcSpecificationImpl();
    return trcSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public From createFrom()
  {
    FromImpl from = new FromImpl();
    return from;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Rules createRules()
  {
    RulesImpl rules = new RulesImpl();
    return rules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModuleList createModuleList()
  {
    ModuleListImpl moduleList = new ModuleListImpl();
    return moduleList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Modules createModules()
  {
    ModulesImpl modules = new ModulesImpl();
    return modules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransformationList createTransformationList()
  {
    TransformationListImpl transformationList = new TransformationListImpl();
    return transformationList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transformation createTransformation()
  {
    TransformationImpl transformation = new TransformationImpl();
    return transformation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransformationImpact createTransformationImpact()
  {
    TransformationImpactImpl transformationImpact = new TransformationImpactImpl();
    return transformationImpact;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransformationDependencyList createTransformationDependencyList()
  {
    TransformationDependencyListImpl transformationDependencyList = new TransformationDependencyListImpl();
    return transformationDependencyList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransformationDependency createTransformationDependency()
  {
    TransformationDependencyImpl transformationDependency = new TransformationDependencyImpl();
    return transformationDependency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AbstractRuleDependency createAbstractRuleDependency()
  {
    AbstractRuleDependencyImpl abstractRuleDependency = new AbstractRuleDependencyImpl();
    return abstractRuleDependency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleDependencyConjunction createRuleDependencyConjunction()
  {
    RuleDependencyConjunctionImpl ruleDependencyConjunction = new RuleDependencyConjunctionImpl();
    return ruleDependencyConjunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleDependencyDisjunction createRuleDependencyDisjunction()
  {
    RuleDependencyDisjunctionImpl ruleDependencyDisjunction = new RuleDependencyDisjunctionImpl();
    return ruleDependencyDisjunction;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleDependency createRuleDependency()
  {
    RuleDependencyImpl ruleDependency = new RuleDependencyImpl();
    return ruleDependency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public requiresDependency createrequiresDependency()
  {
    requiresDependencyImpl requiresDependency = new requiresDependencyImpl();
    return requiresDependency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public excludeDependency createexcludeDependency()
  {
    excludeDependencyImpl excludeDependency = new excludeDependencyImpl();
    return excludeDependency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslPackage getDslPackage()
  {
    return (DslPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static DslPackage getPackage()
  {
    return DslPackage.eINSTANCE;
  }

} //DslFactoryImpl
