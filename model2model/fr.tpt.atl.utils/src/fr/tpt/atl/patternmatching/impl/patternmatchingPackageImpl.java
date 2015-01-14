/**
 */
package fr.tpt.atl.patternmatching.impl;

import fr.tpt.atl.patternmatching.ElementTransformationTuple;
import fr.tpt.atl.patternmatching.patternmatchingFactory;
import fr.tpt.atl.patternmatching.patternmatchingPackage;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.impl.Aadl2PackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class patternmatchingPackageImpl extends EPackageImpl implements patternmatchingPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass elementTransformationTupleEClass = null;

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
	 * @see fr.tpt.atl.patternmatching.patternmatchingPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private patternmatchingPackageImpl() {
		super(eNS_URI, patternmatchingFactory.eINSTANCE);
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
	 * <p>This method is used to initialize {@link patternmatchingPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static patternmatchingPackage init() {
		if (isInited) return (patternmatchingPackage)EPackage.Registry.INSTANCE.getEPackage(patternmatchingPackage.eNS_URI);

		// Obtain or create and register package
		patternmatchingPackageImpl thepatternmatchingPackage = (patternmatchingPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof patternmatchingPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new patternmatchingPackageImpl());

		isInited = true;

		// Initialize simple dependencies
		Aadl2Package.eINSTANCE.eClass();

		// Create package meta-data objects
		thepatternmatchingPackage.createPackageContents();

		// Initialize created meta-data
		thepatternmatchingPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		thepatternmatchingPackage.freeze();

  
		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(patternmatchingPackage.eNS_URI, thepatternmatchingPackage);
		return thepatternmatchingPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getElementTransformationTuple() {
		return elementTransformationTupleEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getElementTransformationTuple_Value() {
		return (EAttribute)elementTransformationTupleEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getElementTransformationTuple_Key() {
		return (EReference)elementTransformationTupleEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public patternmatchingFactory getpatternmatchingFactory() {
		return (patternmatchingFactory)getEFactoryInstance();
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
		elementTransformationTupleEClass = createEClass(ELEMENT_TRANSFORMATION_TUPLE);
		createEAttribute(elementTransformationTupleEClass, ELEMENT_TRANSFORMATION_TUPLE__VALUE);
		createEReference(elementTransformationTupleEClass, ELEMENT_TRANSFORMATION_TUPLE__KEY);
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

		// Add supertypes to classes

		// Initialize classes and features; add operations and parameters
		initEClass(elementTransformationTupleEClass, ElementTransformationTuple.class, "ElementTransformationTuple", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getElementTransformationTuple_Value(), ecorePackage.getEString(), "value", null, 0, 1, ElementTransformationTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getElementTransformationTuple_Key(), ecorePackage.getEObject(), null, "key", null, 1, -1, ElementTransformationTuple.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		// Create resource
		createResource(eNS_URI);
	}

} //patternmatchingPackageImpl
