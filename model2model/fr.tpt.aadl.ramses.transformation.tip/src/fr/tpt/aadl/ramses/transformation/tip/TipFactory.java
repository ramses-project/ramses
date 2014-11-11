/**
 */
package fr.tpt.aadl.ramses.transformation.tip;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.ramses.transformation.tip.TipPackage
 * @generated
 */
public interface TipFactory extends EFactory {
	/**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	TipFactory eINSTANCE = fr.tpt.aadl.ramses.transformation.tip.impl.TipFactoryImpl.init();

	/**
   * Returns a new object of class '<em>Specification</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Specification</em>'.
   * @generated
   */
	TipSpecification createTipSpecification();

	/**
   * Returns a new object of class '<em>Iteration</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Iteration</em>'.
   * @generated
   */
	Iteration createIteration();

	/**
   * Returns a new object of class '<em>Element Transformation</em>'.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return a new object of class '<em>Element Transformation</em>'.
   * @generated
   */
	ElementTransformation createElementTransformation();

	/**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
	TipPackage getTipPackage();

} //TipFactory
