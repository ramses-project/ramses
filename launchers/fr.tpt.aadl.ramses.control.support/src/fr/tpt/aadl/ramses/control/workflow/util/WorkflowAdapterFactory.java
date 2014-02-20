/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.control.workflow.util;

import fr.tpt.aadl.ramses.control.workflow.*;
import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

import fr.tpt.aadl.ramses.control.workflow.Analysis;
import fr.tpt.aadl.ramses.control.workflow.AnalysisElement;
import fr.tpt.aadl.ramses.control.workflow.AnalysisOption;
import fr.tpt.aadl.ramses.control.workflow.ErrorState;
import fr.tpt.aadl.ramses.control.workflow.File;
import fr.tpt.aadl.ramses.control.workflow.Generation;
import fr.tpt.aadl.ramses.control.workflow.List;
import fr.tpt.aadl.ramses.control.workflow.ModelIdentifier;
import fr.tpt.aadl.ramses.control.workflow.Transformation;
import fr.tpt.aadl.ramses.control.workflow.Workflow;
import fr.tpt.aadl.ramses.control.workflow.WorkflowElement;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage;


/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage
 * @generated
 */
public class WorkflowAdapterFactory extends AdapterFactoryImpl {
	/**
   * The cached model package.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	protected static WorkflowPackage modelPackage;

	/**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public WorkflowAdapterFactory() {
    if (modelPackage == null)
    {
      modelPackage = WorkflowPackage.eINSTANCE;
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
	public boolean isFactoryForType(Object object) {
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
	protected WorkflowSwitch modelSwitch =
		new WorkflowSwitch()
    {
      public Object caseWorkflow(Workflow object)
      {
        return createWorkflowAdapter();
      }
      public Object caseWorkflowElement(WorkflowElement object)
      {
        return createWorkflowElementAdapter();
      }
      public Object caseTransformation(Transformation object)
      {
        return createTransformationAdapter();
      }
      public Object caseAnalysisElement(AnalysisElement object)
      {
        return createAnalysisElementAdapter();
      }
      public Object caseGeneration(Generation object)
      {
        return createGenerationAdapter();
      }
      public Object caseAbstractAnalysis(AbstractAnalysis object)
      {
        return createAbstractAnalysisAdapter();
      }
      public Object caseAnalysisSequence(AnalysisSequence object)
      {
        return createAnalysisSequenceAdapter();
      }
      public Object caseConjunction(Conjunction object)
      {
        return createConjunctionAdapter();
      }
      public Object caseDisjunction(Disjunction object)
      {
        return createDisjunctionAdapter();
      }
      public Object caseAnalysis(Analysis object)
      {
        return createAnalysisAdapter();
      }
      public Object caseErrorState(ErrorState object)
      {
        return createErrorStateAdapter();
      }
      public Object caseList(List object)
      {
        return createListAdapter();
      }
      public Object caseFile(File object)
      {
        return createFileAdapter();
      }
      public Object caseAnalysisOption(AnalysisOption object)
      {
        return createAnalysisOptionAdapter();
      }
      public Object caseModelIdentifier(ModelIdentifier object)
      {
        return createModelIdentifierAdapter();
      }
      public Object caseUnparse(Unparse object)
      {
        return createUnparseAdapter();
      }
      public Object caseLoop(Loop object)
      {
        return createLoopAdapter();
      }
      public Object defaultCase(EObject object)
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
	public Adapter createAdapter(Notifier target) {
    return (Adapter)modelSwitch.doSwitch((EObject)target);
  }


	/**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.Workflow <em>Workflow</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.Workflow
   * @generated
   */
	public Adapter createWorkflowAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.WorkflowElement <em>Element</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowElement
   * @generated
   */
	public Adapter createWorkflowElementAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.Transformation <em>Transformation</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.Transformation
   * @generated
   */
	public Adapter createTransformationAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.AnalysisElement <em>Analysis Element</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.AnalysisElement
   * @generated
   */
	public Adapter createAnalysisElementAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.Generation <em>Generation</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.Generation
   * @generated
   */
	public Adapter createGenerationAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis <em>Abstract Analysis</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis
   * @generated
   */
	public Adapter createAbstractAnalysisAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.AnalysisSequence <em>Analysis Sequence</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.AnalysisSequence
   * @generated
   */
	public Adapter createAnalysisSequenceAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.Conjunction <em>Conjunction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.Conjunction
   * @generated
   */
  public Adapter createConjunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.Disjunction <em>Disjunction</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.Disjunction
   * @generated
   */
  public Adapter createDisjunctionAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.Analysis <em>Analysis</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.Analysis
   * @generated
   */
	public Adapter createAnalysisAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.ErrorState <em>Error State</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.ErrorState
   * @generated
   */
	public Adapter createErrorStateAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.List <em>List</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.List
   * @generated
   */
	public Adapter createListAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.File <em>File</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.File
   * @generated
   */
	public Adapter createFileAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.AnalysisOption <em>Analysis Option</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.AnalysisOption
   * @generated
   */
	public Adapter createAnalysisOptionAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.ModelIdentifier <em>Model Identifier</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.ModelIdentifier
   * @generated
   */
	public Adapter createModelIdentifierAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.Unparse <em>Unparse</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.Unparse
   * @generated
   */
	public Adapter createUnparseAdapter() {
    return null;
  }

	/**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.control.workflow.Loop <em>Loop</em>}'.
   * <!-- begin-user-doc -->
	 * This default implementation returns null so that we can easily ignore cases;
	 * it's useful to ignore a case when inheritance will catch all the cases anyway.
	 * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.control.workflow.Loop
   * @generated
   */
	public Adapter createLoopAdapter() {
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

} //WorkflowAdapterFactory
