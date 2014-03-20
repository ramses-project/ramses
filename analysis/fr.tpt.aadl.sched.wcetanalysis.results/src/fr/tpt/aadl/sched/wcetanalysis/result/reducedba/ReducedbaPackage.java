/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.sched.wcetanalysis.result.reducedba;

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
 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaFactory
 * @model kind="package"
 * @generated
 */
public interface ReducedbaPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "reducedba";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://fr.tpt.aadl.sched.wcetanalysis.result.reducedba/1.0";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "fr.tpt.aadl.sched.wcetanalysis.result.reducedba";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ReducedbaPackage eINSTANCE = fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedbaPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ThreadBehaviorElementImpl <em>Thread Behavior Element</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ThreadBehaviorElementImpl
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedbaPackageImpl#getThreadBehaviorElement()
	 * @generated
	 */
	int THREAD_BEHAVIOR_ELEMENT = 0;

	/**
	 * The number of structural features of the '<em>Thread Behavior Element</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int THREAD_BEHAVIOR_ELEMENT_FEATURE_COUNT = 0;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ComputationImpl <em>Computation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ComputationImpl
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedbaPackageImpl#getComputation()
	 * @generated
	 */
	int COMPUTATION = 1;

	/**
	 * The feature id for the '<em><b>Min</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION__MIN = THREAD_BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Max</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION__MAX = THREAD_BEHAVIOR_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Unit</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION__UNIT = THREAD_BEHAVIOR_ELEMENT_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Computation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPUTATION_FEATURE_COUNT = THREAD_BEHAVIOR_ELEMENT_FEATURE_COUNT + 3;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.CriticalSectionBeginImpl <em>Critical Section Begin</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.CriticalSectionBeginImpl
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedbaPackageImpl#getCriticalSectionBegin()
	 * @generated
	 */
	int CRITICAL_SECTION_BEGIN = 2;

	/**
	 * The feature id for the '<em><b>Shared Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITICAL_SECTION_BEGIN__SHARED_DATA = THREAD_BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Critical Section Begin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITICAL_SECTION_BEGIN_FEATURE_COUNT = THREAD_BEHAVIOR_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.CriticalSectionEndImpl <em>Critical Section End</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.CriticalSectionEndImpl
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedbaPackageImpl#getCriticalSectionEnd()
	 * @generated
	 */
	int CRITICAL_SECTION_END = 3;

	/**
	 * The feature id for the '<em><b>Shared Data</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITICAL_SECTION_END__SHARED_DATA = THREAD_BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Critical Section End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITICAL_SECTION_END_FEATURE_COUNT = THREAD_BEHAVIOR_ELEMENT_FEATURE_COUNT + 1;

	/**
	 * The meta object id for the '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedThreadBAImpl <em>Reduced Thread BA</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedThreadBAImpl
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedbaPackageImpl#getReducedThreadBA()
	 * @generated
	 */
	int REDUCED_THREAD_BA = 4;

	/**
	 * The feature id for the '<em><b>Elements</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCED_THREAD_BA__ELEMENTS = 0;

	/**
	 * The feature id for the '<em><b>Thread</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCED_THREAD_BA__THREAD = 1;

	/**
	 * The number of structural features of the '<em>Reduced Thread BA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCED_THREAD_BA_FEATURE_COUNT = 2;


	/**
	 * The meta object id for the '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.AnalysisModelImpl <em>Analysis Model</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.AnalysisModelImpl
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedbaPackageImpl#getAnalysisModel()
	 * @generated
	 */
	int ANALYSIS_MODEL = 5;

	/**
	 * The feature id for the '<em><b>Threads BA</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_MODEL__THREADS_BA = 0;

	/**
	 * The number of structural features of the '<em>Analysis Model</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANALYSIS_MODEL_FEATURE_COUNT = 1;


	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ThreadBehaviorElement <em>Thread Behavior Element</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Thread Behavior Element</em>'.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ThreadBehaviorElement
	 * @generated
	 */
	EClass getThreadBehaviorElement();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.Computation <em>Computation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Computation</em>'.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.Computation
	 * @generated
	 */
	EClass getComputation();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.Computation#getMin <em>Min</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Min</em>'.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.Computation#getMin()
	 * @see #getComputation()
	 * @generated
	 */
	EAttribute getComputation_Min();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.Computation#getMax <em>Max</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Max</em>'.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.Computation#getMax()
	 * @see #getComputation()
	 * @generated
	 */
	EAttribute getComputation_Max();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.Computation#getUnit <em>Unit</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Unit</em>'.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.Computation#getUnit()
	 * @see #getComputation()
	 * @generated
	 */
	EAttribute getComputation_Unit();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionBegin <em>Critical Section Begin</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Critical Section Begin</em>'.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionBegin
	 * @generated
	 */
	EClass getCriticalSectionBegin();

	/**
	 * Returns the meta object for the reference '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionBegin#getSharedData <em>Shared Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Shared Data</em>'.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionBegin#getSharedData()
	 * @see #getCriticalSectionBegin()
	 * @generated
	 */
	EReference getCriticalSectionBegin_SharedData();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionEnd <em>Critical Section End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Critical Section End</em>'.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionEnd
	 * @generated
	 */
	EClass getCriticalSectionEnd();

	/**
	 * Returns the meta object for the reference '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionEnd#getSharedData <em>Shared Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Shared Data</em>'.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionEnd#getSharedData()
	 * @see #getCriticalSectionEnd()
	 * @generated
	 */
	EReference getCriticalSectionEnd_SharedData();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA <em>Reduced Thread BA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Reduced Thread BA</em>'.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA
	 * @generated
	 */
	EClass getReducedThreadBA();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA#getElements <em>Elements</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Elements</em>'.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA#getElements()
	 * @see #getReducedThreadBA()
	 * @generated
	 */
	EReference getReducedThreadBA_Elements();

	/**
	 * Returns the meta object for the reference '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA#getThread <em>Thread</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Thread</em>'.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA#getThread()
	 * @see #getReducedThreadBA()
	 * @generated
	 */
	EReference getReducedThreadBA_Thread();

	/**
	 * Returns the meta object for class '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel <em>Analysis Model</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Analysis Model</em>'.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel
	 * @generated
	 */
	EClass getAnalysisModel();

	/**
	 * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel#getThreadsBA <em>Threads BA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Threads BA</em>'.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel#getThreadsBA()
	 * @see #getAnalysisModel()
	 * @generated
	 */
	EReference getAnalysisModel_ThreadsBA();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	ReducedbaFactory getReducedbaFactory();

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
		 * The meta object literal for the '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ThreadBehaviorElementImpl <em>Thread Behavior Element</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ThreadBehaviorElementImpl
		 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedbaPackageImpl#getThreadBehaviorElement()
		 * @generated
		 */
		EClass THREAD_BEHAVIOR_ELEMENT = eINSTANCE.getThreadBehaviorElement();

		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ComputationImpl <em>Computation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ComputationImpl
		 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedbaPackageImpl#getComputation()
		 * @generated
		 */
		EClass COMPUTATION = eINSTANCE.getComputation();

		/**
		 * The meta object literal for the '<em><b>Min</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTATION__MIN = eINSTANCE.getComputation_Min();

		/**
		 * The meta object literal for the '<em><b>Max</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTATION__MAX = eINSTANCE.getComputation_Max();

		/**
		 * The meta object literal for the '<em><b>Unit</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPUTATION__UNIT = eINSTANCE.getComputation_Unit();

		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.CriticalSectionBeginImpl <em>Critical Section Begin</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.CriticalSectionBeginImpl
		 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedbaPackageImpl#getCriticalSectionBegin()
		 * @generated
		 */
		EClass CRITICAL_SECTION_BEGIN = eINSTANCE.getCriticalSectionBegin();

		/**
		 * The meta object literal for the '<em><b>Shared Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITICAL_SECTION_BEGIN__SHARED_DATA = eINSTANCE.getCriticalSectionBegin_SharedData();

		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.CriticalSectionEndImpl <em>Critical Section End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.CriticalSectionEndImpl
		 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedbaPackageImpl#getCriticalSectionEnd()
		 * @generated
		 */
		EClass CRITICAL_SECTION_END = eINSTANCE.getCriticalSectionEnd();

		/**
		 * The meta object literal for the '<em><b>Shared Data</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CRITICAL_SECTION_END__SHARED_DATA = eINSTANCE.getCriticalSectionEnd_SharedData();

		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedThreadBAImpl <em>Reduced Thread BA</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedThreadBAImpl
		 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedbaPackageImpl#getReducedThreadBA()
		 * @generated
		 */
		EClass REDUCED_THREAD_BA = eINSTANCE.getReducedThreadBA();

		/**
		 * The meta object literal for the '<em><b>Elements</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REDUCED_THREAD_BA__ELEMENTS = eINSTANCE.getReducedThreadBA_Elements();

		/**
		 * The meta object literal for the '<em><b>Thread</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference REDUCED_THREAD_BA__THREAD = eINSTANCE.getReducedThreadBA_Thread();

		/**
		 * The meta object literal for the '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.AnalysisModelImpl <em>Analysis Model</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.AnalysisModelImpl
		 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedbaPackageImpl#getAnalysisModel()
		 * @generated
		 */
		EClass ANALYSIS_MODEL = eINSTANCE.getAnalysisModel();

		/**
		 * The meta object literal for the '<em><b>Threads BA</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ANALYSIS_MODEL__THREADS_BA = eINSTANCE.getAnalysisModel_ThreadsBA();

	}

} //ReducedbaPackage
