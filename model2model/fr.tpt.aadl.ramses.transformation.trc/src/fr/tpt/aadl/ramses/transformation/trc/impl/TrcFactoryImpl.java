/**
 */
package fr.tpt.aadl.ramses.transformation.trc.impl;

import fr.tpt.aadl.ramses.transformation.trc.*;

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
public class TrcFactoryImpl extends EFactoryImpl implements TrcFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TrcFactory init()
  {
    try
    {
      TrcFactory theTrcFactory = (TrcFactory)EPackage.Registry.INSTANCE.getEFactory(TrcPackage.eNS_URI);
      if (theTrcFactory != null)
      {
        return theTrcFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TrcFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrcFactoryImpl()
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
      case TrcPackage.TRC_SPECIFICATION: return createTrcSpecification();
      case TrcPackage.TRANSFORMATION_IMPACT: return createTransformationImpact();
      case TrcPackage.MODULE: return createModule();
      case TrcPackage.TRANSFORMATION: return createTransformation();
      case TrcPackage.TRANSFORMATION_DEPENDENCY: return createTransformationDependency();
      case TrcPackage.RULE_DEPENDENCY_CONJUNCTION: return createRuleDependencyConjunction();
      case TrcPackage.RULE_DEPENDENCY_DISJUNCTION: return createRuleDependencyDisjunction();
      case TrcPackage.RULE_DEPENDENCY: return createRuleDependency();
      case TrcPackage.MODULE_LIST: return createModuleList();
      case TrcPackage.TRANSFORMATION_LIST: return createTransformationList();
      case TrcPackage.TRANSFORMATION_DEPENDENCY_LIST: return createTransformationDependencyList();
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
  public Module createModule()
  {
    ModuleImpl module = new ModuleImpl();
    return module;
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
  public TrcPackage getTrcPackage()
  {
    return (TrcPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TrcPackage getPackage()
  {
    return TrcPackage.eINSTANCE;
  }

} //TrcFactoryImpl
