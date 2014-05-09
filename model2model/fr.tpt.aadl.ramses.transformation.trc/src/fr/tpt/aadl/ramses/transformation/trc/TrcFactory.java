/**
 */
package fr.tpt.aadl.ramses.transformation.trc;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage
 * @generated
 */
public interface TrcFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TrcFactory eINSTANCE = fr.tpt.aadl.ramses.transformation.trc.impl.TrcFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Specification</em>'.
   * @generated
   */
  TrcSpecification createTrcSpecification();

  /**
   * Returns a new object of class '<em>Transformation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transformation</em>'.
   * @generated
   */
  Transformation createTransformation();

  /**
   * Returns a new object of class '<em>Transformation Impact</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transformation Impact</em>'.
   * @generated
   */
  TransformationImpact createTransformationImpact();

  /**
   * Returns a new object of class '<em>Module</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module</em>'.
   * @generated
   */
  Module createModule();

  /**
   * Returns a new object of class '<em>Transformation Dependency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transformation Dependency</em>'.
   * @generated
   */
  TransformationDependency createTransformationDependency();

  /**
   * Returns a new object of class '<em>Rule Dependency Conjunction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Dependency Conjunction</em>'.
   * @generated
   */
  RuleDependencyConjunction createRuleDependencyConjunction();

  /**
   * Returns a new object of class '<em>Rule Dependency Disjunction</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Dependency Disjunction</em>'.
   * @generated
   */
  RuleDependencyDisjunction createRuleDependencyDisjunction();

  /**
   * Returns a new object of class '<em>Rule Dependency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Dependency</em>'.
   * @generated
   */
  RuleDependency createRuleDependency();

  /**
   * Returns a new object of class '<em>Module List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module List</em>'.
   * @generated
   */
  ModuleList createModuleList();

  /**
   * Returns a new object of class '<em>Transformation List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transformation List</em>'.
   * @generated
   */
  TransformationList createTransformationList();

  /**
   * Returns a new object of class '<em>Transformation Dependency List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transformation Dependency List</em>'.
   * @generated
   */
  TransformationDependencyList createTransformationDependencyList();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TrcPackage getTrcPackage();

} //TrcFactory
