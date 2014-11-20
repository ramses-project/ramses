/**
 */
package fr.tpt.aadl.ramses.transformation.trc.util;

import fr.tpt.aadl.ramses.transformation.trc.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage
 * @generated
 */
public class TrcAdapterFactory extends AdapterFactoryImpl
{
  /**
	 * The cached model package.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected static TrcPackage modelPackage;

  /**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TrcAdapterFactory()
  {
		if (modelPackage == null) {
			modelPackage = TrcPackage.eINSTANCE;
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
		if (object == modelPackage) {
			return true;
		}
		if (object instanceof EObject) {
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
  protected TrcSwitch<Adapter> modelSwitch =
    new TrcSwitch<Adapter>() {
			@Override
			public Adapter caseTrcSpecification(TrcSpecification object) {
				return createTrcSpecificationAdapter();
			}
			@Override
			public Adapter caseTransformationImpact(TransformationImpact object) {
				return createTransformationImpactAdapter();
			}
			@Override
			public Adapter caseModule(Module object) {
				return createModuleAdapter();
			}
			@Override
			public Adapter caseTransformation(Transformation object) {
				return createTransformationAdapter();
			}
			@Override
			public Adapter caseTransformationDependency(TransformationDependency object) {
				return createTransformationDependencyAdapter();
			}
			@Override
			public Adapter caseAbstractRuleDependency(AbstractRuleDependency object) {
				return createAbstractRuleDependencyAdapter();
			}
			@Override
			public Adapter caseRuleDependencyConjunction(RuleDependencyConjunction object) {
				return createRuleDependencyConjunctionAdapter();
			}
			@Override
			public Adapter caseRuleDependencyDisjunction(RuleDependencyDisjunction object) {
				return createRuleDependencyDisjunctionAdapter();
			}
			@Override
			public Adapter caseRuleDependency(RuleDependency object) {
				return createRuleDependencyAdapter();
			}
			@Override
			public Adapter caseRuleDependencyComposite(RuleDependencyComposite object) {
				return createRuleDependencyCompositeAdapter();
			}
			@Override
			public Adapter caseTransformationElement(TransformationElement object) {
				return createTransformationElementAdapter();
			}
			@Override
			public Adapter caseModuleList(ModuleList object) {
				return createModuleListAdapter();
			}
			@Override
			public Adapter caseSpecificationElement(SpecificationElement object) {
				return createSpecificationElementAdapter();
			}
			@Override
			public Adapter caseTransformationList(TransformationList object) {
				return createTransformationListAdapter();
			}
			@Override
			public Adapter caseTransformationDependencyList(TransformationDependencyList object) {
				return createTransformationDependencyListAdapter();
			}
			@Override
			public Adapter caseTrcRule(TrcRule object) {
				return createTrcRuleAdapter();
			}
			@Override
			public Adapter defaultCase(EObject object) {
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
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.TrcSpecification <em>Specification</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcSpecification
	 * @generated
	 */
  public Adapter createTrcSpecificationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.Transformation <em>Transformation</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.ramses.transformation.trc.Transformation
	 * @generated
	 */
  public Adapter createTransformationAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationImpact <em>Transformation Impact</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.ramses.transformation.trc.TransformationImpact
	 * @generated
	 */
  public Adapter createTransformationImpactAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.Module <em>Module</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.ramses.transformation.trc.Module
	 * @generated
	 */
  public Adapter createModuleAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependency <em>Transformation Dependency</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.ramses.transformation.trc.TransformationDependency
	 * @generated
	 */
  public Adapter createTransformationDependencyAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.AbstractRuleDependency <em>Abstract Rule Dependency</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.ramses.transformation.trc.AbstractRuleDependency
	 * @generated
	 */
  public Adapter createAbstractRuleDependencyAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependencyConjunction <em>Rule Dependency Conjunction</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.ramses.transformation.trc.RuleDependencyConjunction
	 * @generated
	 */
  public Adapter createRuleDependencyConjunctionAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependencyDisjunction <em>Rule Dependency Disjunction</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.ramses.transformation.trc.RuleDependencyDisjunction
	 * @generated
	 */
  public Adapter createRuleDependencyDisjunctionAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency <em>Rule Dependency</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.ramses.transformation.trc.RuleDependency
	 * @generated
	 */
  public Adapter createRuleDependencyAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependencyComposite <em>Rule Dependency Composite</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.ramses.transformation.trc.RuleDependencyComposite
	 * @generated
	 */
  public Adapter createRuleDependencyCompositeAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationElement <em>Transformation Element</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.ramses.transformation.trc.TransformationElement
	 * @generated
	 */
  public Adapter createTransformationElementAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.ModuleList <em>Module List</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.ramses.transformation.trc.ModuleList
	 * @generated
	 */
  public Adapter createModuleListAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.SpecificationElement <em>Specification Element</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.ramses.transformation.trc.SpecificationElement
	 * @generated
	 */
  public Adapter createSpecificationElementAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationList <em>Transformation List</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.ramses.transformation.trc.TransformationList
	 * @generated
	 */
  public Adapter createTransformationListAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationDependencyList <em>Transformation Dependency List</em>}'.
	 * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.ramses.transformation.trc.TransformationDependencyList
	 * @generated
	 */
  public Adapter createTransformationDependencyListAdapter()
  {
		return null;
	}

  /**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.TrcRule <em>Rule</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcRule
	 * @generated
	 */
	public Adapter createTrcRuleAdapter() {
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

} //TrcAdapterFactory
