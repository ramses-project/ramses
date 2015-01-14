/**
 */
package fr.tpt.atl.patternmatching.impl;

import fr.tpt.atl.patternmatching.*;

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
public class patternmatchingFactoryImpl extends EFactoryImpl implements patternmatchingFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static patternmatchingFactory init() {
		try {
			patternmatchingFactory thepatternmatchingFactory = (patternmatchingFactory)EPackage.Registry.INSTANCE.getEFactory(patternmatchingPackage.eNS_URI);
			if (thepatternmatchingFactory != null) {
				return thepatternmatchingFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new patternmatchingFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public patternmatchingFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			case patternmatchingPackage.ELEMENT_TRANSFORMATION_TUPLE: return createElementTransformationTuple();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ElementTransformationTuple createElementTransformationTuple() {
		ElementTransformationTupleImpl elementTransformationTuple = new ElementTransformationTupleImpl();
		return elementTransformationTuple;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public patternmatchingPackage getpatternmatchingPackage() {
		return (patternmatchingPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	public static patternmatchingPackage getPackage() {
		return patternmatchingPackage.eINSTANCE;
	}

} //patternmatchingFactoryImpl
