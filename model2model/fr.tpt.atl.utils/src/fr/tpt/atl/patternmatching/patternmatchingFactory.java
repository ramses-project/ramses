/**
 */
package fr.tpt.atl.patternmatching;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.atl.patternmatching.patternmatchingPackage
 * @generated
 */
public interface patternmatchingFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	patternmatchingFactory eINSTANCE = fr.tpt.atl.patternmatching.impl.patternmatchingFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Element Transformation Tuple</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Element Transformation Tuple</em>'.
	 * @generated
	 */
	ElementTransformationTuple createElementTransformationTuple();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	patternmatchingPackage getpatternmatchingPackage();

} //patternmatchingFactory
