/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.Computation;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionBegin;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionEnd;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaFactory;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ThreadBehaviorElement;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class ReducedbaPackageImpl extends EPackageImpl implements ReducedbaPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass threadBehaviorElementEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass computationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass criticalSectionBeginEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass criticalSectionEndEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass reducedThreadBAEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private ReducedbaPackageImpl() {
		super(eNS_URI, ReducedbaFactory.eINSTANCE);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 * 
	 * <p>This method is used to initialize {@link ReducedbaPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static ReducedbaPackage init() {
		if (isInited) return (ReducedbaPackage)EPackage.Registry.INSTANCE.getEPackage(ReducedbaPackage.eNS_URI);

		// Obtain or create and register package
		ReducedbaPackageImpl theReducedbaPackage = (ReducedbaPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof ReducedbaPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new ReducedbaPackageImpl());

		isInited = true;

		// Create package meta-data objects
		theReducedbaPackage.createPackageContents();

		// Initialize created meta-data
		theReducedbaPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theReducedbaPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(ReducedbaPackage.eNS_URI, theReducedbaPackage);
		return theReducedbaPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getThreadBehaviorElement() {
		return threadBehaviorElementEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComputation() {
		return computationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComputation_Min() {
		return (EAttribute)computationEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComputation_Max() {
		return (EAttribute)computationEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComputation_Unit() {
		return (EAttribute)computationEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCriticalSectionBegin() {
		return criticalSectionBeginEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCriticalSectionEnd() {
		return criticalSectionEndEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getReducedThreadBA() {
		return reducedThreadBAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getReducedThreadBA_Elements() {
		return (EReference)reducedThreadBAEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getReducedThreadBA_ThreadID() {
		return (EAttribute)reducedThreadBAEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReducedbaFactory getReducedbaFactory() {
		return (ReducedbaFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		threadBehaviorElementEClass = createEClass(THREAD_BEHAVIOR_ELEMENT);

		computationEClass = createEClass(COMPUTATION);
		createEAttribute(computationEClass, COMPUTATION__MIN);
		createEAttribute(computationEClass, COMPUTATION__MAX);
		createEAttribute(computationEClass, COMPUTATION__UNIT);

		criticalSectionBeginEClass = createEClass(CRITICAL_SECTION_BEGIN);

		criticalSectionEndEClass = createEClass(CRITICAL_SECTION_END);

		reducedThreadBAEClass = createEClass(REDUCED_THREAD_BA);
		createEReference(reducedThreadBAEClass, REDUCED_THREAD_BA__ELEMENTS);
		createEAttribute(reducedThreadBAEClass, REDUCED_THREAD_BA__THREAD_ID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		computationEClass.getESuperTypes().add(this.getThreadBehaviorElement());
		criticalSectionBeginEClass.getESuperTypes().add(this.getThreadBehaviorElement());
		criticalSectionEndEClass.getESuperTypes().add(this.getThreadBehaviorElement());

		// Initialize classes and features; add operations and parameters
		initEClass(threadBehaviorElementEClass, ThreadBehaviorElement.class, "ThreadBehaviorElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(computationEClass, Computation.class, "Computation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getComputation_Min(), ecorePackage.getEInt(), "min", null, 0, 1, Computation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComputation_Max(), ecorePackage.getEInt(), "max", null, 0, 1, Computation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComputation_Unit(), ecorePackage.getEString(), "unit", null, 0, 1, Computation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(criticalSectionBeginEClass, CriticalSectionBegin.class, "CriticalSectionBegin", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(criticalSectionEndEClass, CriticalSectionEnd.class, "CriticalSectionEnd", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(reducedThreadBAEClass, ReducedThreadBA.class, "ReducedThreadBA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getReducedThreadBA_Elements(), this.getThreadBehaviorElement(), null, "elements", null, 0, -1, ReducedThreadBA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getReducedThreadBA_ThreadID(), ecorePackage.getEString(), "threadID", null, 0, 1, ReducedThreadBA.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //ReducedbaPackageImpl
