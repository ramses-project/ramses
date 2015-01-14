/**
 */
package fr.tpt.atl.patternmatching;

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
 * @see fr.tpt.atl.patternmatching.patternmatchingFactory
 * @model kind="package"
 * @generated
 */
public interface patternmatchingPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "patternmatching";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://fr.tpt.atl.hot.pm/pml";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "pml";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	patternmatchingPackage eINSTANCE = fr.tpt.atl.patternmatching.impl.patternmatchingPackageImpl.init();

	/**
	 * The meta object id for the '{@link fr.tpt.atl.patternmatching.impl.ElementTransformationTupleImpl <em>Element Transformation Tuple</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see fr.tpt.atl.patternmatching.impl.ElementTransformationTupleImpl
	 * @see fr.tpt.atl.patternmatching.impl.patternmatchingPackageImpl#getElementTransformationTuple()
	 * @generated
	 */
	int ELEMENT_TRANSFORMATION_TUPLE = 0;

	/**
	 * The feature id for the '<em><b>Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TRANSFORMATION_TUPLE__VALUE = 0;

	/**
	 * The feature id for the '<em><b>Key</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TRANSFORMATION_TUPLE__KEY = 1;

	/**
	 * The number of structural features of the '<em>Element Transformation Tuple</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ELEMENT_TRANSFORMATION_TUPLE_FEATURE_COUNT = 2;


	/**
	 * Returns the meta object for class '{@link fr.tpt.atl.patternmatching.ElementTransformationTuple <em>Element Transformation Tuple</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Element Transformation Tuple</em>'.
	 * @see fr.tpt.atl.patternmatching.ElementTransformationTuple
	 * @generated
	 */
	EClass getElementTransformationTuple();

	/**
	 * Returns the meta object for the attribute '{@link fr.tpt.atl.patternmatching.ElementTransformationTuple#getValue <em>Value</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Value</em>'.
	 * @see fr.tpt.atl.patternmatching.ElementTransformationTuple#getValue()
	 * @see #getElementTransformationTuple()
	 * @generated
	 */
	EAttribute getElementTransformationTuple_Value();

	/**
	 * Returns the meta object for the reference list '{@link fr.tpt.atl.patternmatching.ElementTransformationTuple#getKey <em>Key</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Key</em>'.
	 * @see fr.tpt.atl.patternmatching.ElementTransformationTuple#getKey()
	 * @see #getElementTransformationTuple()
	 * @generated
	 */
	EReference getElementTransformationTuple_Key();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	patternmatchingFactory getpatternmatchingFactory();

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
		 * The meta object literal for the '{@link fr.tpt.atl.patternmatching.impl.ElementTransformationTupleImpl <em>Element Transformation Tuple</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see fr.tpt.atl.patternmatching.impl.ElementTransformationTupleImpl
		 * @see fr.tpt.atl.patternmatching.impl.patternmatchingPackageImpl#getElementTransformationTuple()
		 * @generated
		 */
		EClass ELEMENT_TRANSFORMATION_TUPLE = eINSTANCE.getElementTransformationTuple();

		/**
		 * The meta object literal for the '<em><b>Value</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute ELEMENT_TRANSFORMATION_TUPLE__VALUE = eINSTANCE.getElementTransformationTuple_Value();

		/**
		 * The meta object literal for the '<em><b>Key</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference ELEMENT_TRANSFORMATION_TUPLE__KEY = eINSTANCE.getElementTransformationTuple_Key();

	}

} //patternmatchingPackage
