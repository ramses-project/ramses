/**
 */
package org.trc.xtext.dsl.dsl.util;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import org.trc.xtext.dsl.dsl.*;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see org.trc.xtext.dsl.dsl.DslPackage
 * @generated
 */
public class DslAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static DslPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = DslPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DslSwitch<Adapter> modelSwitch =
    new DslSwitch<Adapter>()
    {
      @Override
      public Adapter caseTrcSpecification(TrcSpecification object)
      {
        return createTrcSpecificationAdapter();
      }
      @Override
      public Adapter casetrcRule(trcRule object)
      {
        return createtrcRuleAdapter();
      }
      @Override
      public Adapter caseModuleList(ModuleList object)
      {
        return createModuleListAdapter();
      }
      @Override
      public Adapter caseModule(Module object)
      {
        return createModuleAdapter();
      }
      @Override
      public Adapter caseTransformationList(TransformationList object)
      {
        return createTransformationListAdapter();
      }
      @Override
      public Adapter caseTransformation(Transformation object)
      {
        return createTransformationAdapter();
      }
      @Override
      public Adapter caseTransformationImpact(TransformationImpact object)
      {
        return createTransformationImpactAdapter();
      }
      @Override
      public Adapter caseTransformationDependencyList(TransformationDependencyList object)
      {
        return createTransformationDependencyListAdapter();
      }
      @Override
      public Adapter caseTransformationDependency(TransformationDependency object)
      {
        return createTransformationDependencyAdapter();
      }
      @Override
      public Adapter caseAbstractRuleDependency(AbstractRuleDependency object)
      {
        return createAbstractRuleDependencyAdapter();
      }
      @Override
      public Adapter caseRuleDependency(RuleDependency object)
      {
        return createRuleDependencyAdapter();
      }
      @Override
      public Adapter caserequiresDependency(requiresDependency object)
      {
        return createrequiresDependencyAdapter();
      }
      @Override
      public Adapter caseexcludeDependency(excludeDependency object)
      {
        return createexcludeDependencyAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link org.trc.xtext.dsl.dsl.TrcSpecification <em>Trc Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.trc.xtext.dsl.dsl.TrcSpecification
   * @generated
   */
  public Adapter createTrcSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.trc.xtext.dsl.dsl.trcRule <em>trc Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.trc.xtext.dsl.dsl.trcRule
   * @generated
   */
  public Adapter createtrcRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.trc.xtext.dsl.dsl.ModuleList <em>Module List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.trc.xtext.dsl.dsl.ModuleList
   * @generated
   */
  public Adapter createModuleListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.trc.xtext.dsl.dsl.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.trc.xtext.dsl.dsl.Module
   * @generated
   */
  public Adapter createModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.trc.xtext.dsl.dsl.TransformationList <em>Transformation List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.trc.xtext.dsl.dsl.TransformationList
   * @generated
   */
  public Adapter createTransformationListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.trc.xtext.dsl.dsl.Transformation <em>Transformation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.trc.xtext.dsl.dsl.Transformation
   * @generated
   */
  public Adapter createTransformationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.trc.xtext.dsl.dsl.TransformationImpact <em>Transformation Impact</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.trc.xtext.dsl.dsl.TransformationImpact
   * @generated
   */
  public Adapter createTransformationImpactAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.trc.xtext.dsl.dsl.TransformationDependencyList <em>Transformation Dependency List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.trc.xtext.dsl.dsl.TransformationDependencyList
   * @generated
   */
  public Adapter createTransformationDependencyListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.trc.xtext.dsl.dsl.TransformationDependency <em>Transformation Dependency</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.trc.xtext.dsl.dsl.TransformationDependency
   * @generated
   */
  public Adapter createTransformationDependencyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.trc.xtext.dsl.dsl.AbstractRuleDependency <em>Abstract Rule Dependency</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.trc.xtext.dsl.dsl.AbstractRuleDependency
   * @generated
   */
  public Adapter createAbstractRuleDependencyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.trc.xtext.dsl.dsl.RuleDependency <em>Rule Dependency</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.trc.xtext.dsl.dsl.RuleDependency
   * @generated
   */
  public Adapter createRuleDependencyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.trc.xtext.dsl.dsl.requiresDependency <em>requires Dependency</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.trc.xtext.dsl.dsl.requiresDependency
   * @generated
   */
  public Adapter createrequiresDependencyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link org.trc.xtext.dsl.dsl.excludeDependency <em>exclude Dependency</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see org.trc.xtext.dsl.dsl.excludeDependency
   * @generated
   */
  public Adapter createexcludeDependencyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //DslAdapterFactory
