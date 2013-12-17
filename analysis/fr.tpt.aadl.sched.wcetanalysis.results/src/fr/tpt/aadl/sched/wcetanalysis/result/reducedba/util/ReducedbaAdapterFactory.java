/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.sched.wcetanalysis.result.reducedba.util;

import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage
 * @generated
 */
public class ReducedbaAdapterFactory extends AdapterFactoryImpl {
	/**
	 * The cached model package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static ReducedbaPackage modelPackage;

	/**
	 * Creates an instance of the adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReducedbaAdapterFactory() {
		if (modelPackage == null) {
			modelPackage = ReducedbaPackage.eINSTANCE;
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
	public boolean isFactoryForType(Object object) {
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
	protected ReducedbaSwitch<Adapter> modelSwitch =
		new ReducedbaSwitch<Adapter>() {
			@Override
			public Adapter caseThreadBehaviorElement(ThreadBehaviorElement object) {
				return createThreadBehaviorElementAdapter();
			}
			@Override
			public Adapter caseComputation(Computation object) {
				return createComputationAdapter();
			}
			@Override
			public Adapter caseCriticalSectionBegin(CriticalSectionBegin object) {
				return createCriticalSectionBeginAdapter();
			}
			@Override
			public Adapter caseCriticalSectionEnd(CriticalSectionEnd object) {
				return createCriticalSectionEndAdapter();
			}
			@Override
			public Adapter caseReducedThreadBA(ReducedThreadBA object) {
				return createReducedThreadBAAdapter();
			}
			@Override
			public Adapter caseAnalysisModel(AnalysisModel object) {
				return createAnalysisModelAdapter();
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
	public Adapter createAdapter(Notifier target) {
		return modelSwitch.doSwitch((EObject)target);
	}


	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ThreadBehaviorElement <em>Thread Behavior Element</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ThreadBehaviorElement
	 * @generated
	 */
	public Adapter createThreadBehaviorElementAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.Computation <em>Computation</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.Computation
	 * @generated
	 */
	public Adapter createComputationAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionBegin <em>Critical Section Begin</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionBegin
	 * @generated
	 */
	public Adapter createCriticalSectionBeginAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionEnd <em>Critical Section End</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionEnd
	 * @generated
	 */
	public Adapter createCriticalSectionEndAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA <em>Reduced Thread BA</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA
	 * @generated
	 */
	public Adapter createReducedThreadBAAdapter() {
		return null;
	}

	/**
	 * Creates a new adapter for an object of class '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel <em>Analysis Model</em>}'.
	 * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
	 * @return the new adapter.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel
	 * @generated
	 */
	public Adapter createAnalysisModelAdapter() {
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
	public Adapter createEObjectAdapter() {
		return null;
	}

} //ReducedbaAdapterFactory
