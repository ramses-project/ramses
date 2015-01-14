/**
 */
package fr.tpt.aadl.ramses.transformation.tip.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

import fr.tpt.aadl.ramses.transformation.tip.*;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TipFactoryImpl extends EFactoryImpl implements TipFactory {
	/**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public static TipFactory init() {
    try
    {
      TipFactory theTipFactory = (TipFactory)EPackage.Registry.INSTANCE.getEFactory(TipPackage.eNS_URI);
      if (theTipFactory != null)
      {
        return theTipFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TipFactoryImpl();
  }

	/**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public TipFactoryImpl() {
    super();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public EObject create(EClass eClass) {
    switch (eClass.getClassifierID())
    {
      case TipPackage.TIP_SPECIFICATION: return createTipSpecification();
      case TipPackage.ITERATION: return createIteration();
      case TipPackage.ELEMENT_TRANSFORMATION: return createElementTransformation();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public TipSpecification createTipSpecification() {
    TipSpecificationImpl tipSpecification = new TipSpecificationImpl();
    return tipSpecification;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public Iteration createIteration() {
    IterationImpl iteration = new IterationImpl();
    return iteration;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public ElementTransformation createElementTransformation() {
    ElementTransformationImpl elementTransformation = new ElementTransformationImpl();
    return elementTransformation;
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @generated
   */
	public TipPackage getTipPackage() {
    return (TipPackage)getEPackage();
  }

	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
	public static TipPackage getPackage() {
    return TipPackage.eINSTANCE;
  }

} //TipFactoryImpl
