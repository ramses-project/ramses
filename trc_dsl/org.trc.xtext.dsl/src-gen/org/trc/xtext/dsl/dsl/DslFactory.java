/**
 */
package org.trc.xtext.dsl.dsl;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see org.trc.xtext.dsl.dsl.DslPackage
 * @generated
 */
public interface DslFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  DslFactory eINSTANCE = org.trc.xtext.dsl.dsl.impl.DslFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Trc Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trc Specification</em>'.
   * @generated
   */
  TrcSpecification createTrcSpecification();

  /**
   * Returns a new object of class '<em>trc Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>trc Rule</em>'.
   * @generated
   */
  trcRule createtrcRule();

  /**
   * Returns a new object of class '<em>Module List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module List</em>'.
   * @generated
   */
  ModuleList createModuleList();

  /**
   * Returns a new object of class '<em>Module</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module</em>'.
   * @generated
   */
  Module createModule();

  /**
   * Returns a new object of class '<em>Transformation List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transformation List</em>'.
   * @generated
   */
  TransformationList createTransformationList();

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
   * Returns a new object of class '<em>Transformation Dependency List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transformation Dependency List</em>'.
   * @generated
   */
  TransformationDependencyList createTransformationDependencyList();

  /**
   * Returns a new object of class '<em>Transformation Dependency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transformation Dependency</em>'.
   * @generated
   */
  TransformationDependency createTransformationDependency();

  /**
   * Returns a new object of class '<em>Abstract Rule Dependency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Abstract Rule Dependency</em>'.
   * @generated
   */
  AbstractRuleDependency createAbstractRuleDependency();

  /**
   * Returns a new object of class '<em>Rule Dependency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Dependency</em>'.
   * @generated
   */
  RuleDependency createRuleDependency();

  /**
   * Returns a new object of class '<em>requires Dependency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>requires Dependency</em>'.
   * @generated
   */
  requiresDependency createrequiresDependency();

  /**
   * Returns a new object of class '<em>exclude Dependency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>exclude Dependency</em>'.
   * @generated
   */
  excludeDependency createexcludeDependency();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  DslPackage getDslPackage();

} //DslFactory
