/**
 * <copyright>
 * </copyright>
 *
 * $Id$
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
	 * The number of structural features of the '<em>Critical Section Begin</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITICAL_SECTION_BEGIN_FEATURE_COUNT = THREAD_BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

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
	 * The number of structural features of the '<em>Critical Section End</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CRITICAL_SECTION_END_FEATURE_COUNT = THREAD_BEHAVIOR_ELEMENT_FEATURE_COUNT + 0;

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
	 * The number of structural features of the '<em>Reduced Thread BA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDUCED_THREAD_BA_FEATURE_COUNT = 1;


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
	 * Returns the meta object for class '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionEnd <em>Critical Section End</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Critical Section End</em>'.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionEnd
	 * @generated
	 */
	EClass getCriticalSectionEnd();

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
		 * The meta object literal for the '{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.CriticalSectionEndImpl <em>Critical Section End</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.CriticalSectionEndImpl
		 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedbaPackageImpl#getCriticalSectionEnd()
		 * @generated
		 */
		EClass CRITICAL_SECTION_END = eINSTANCE.getCriticalSectionEnd();

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

	}

} //ReducedbaPackage
