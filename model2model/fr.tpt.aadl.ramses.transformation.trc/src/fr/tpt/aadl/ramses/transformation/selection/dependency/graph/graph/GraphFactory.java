/**
 */
package fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphPackage
 * @generated
 */
public interface GraphFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GraphFactory eINSTANCE = fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.GraphFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Dependency Graph</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dependency Graph</em>'.
   * @generated
   */
  DependencyGraph createDependencyGraph();

  /**
   * Returns a new object of class '<em>Dependency Node</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dependency Node</em>'.
   * @generated
   */
  DependencyNode createDependencyNode();

  /**
   * Returns a new object of class '<em>Dependency Arc</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dependency Arc</em>'.
   * @generated
   */
  DependencyArc createDependencyArc();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  GraphPackage getGraphPackage();

} //GraphFactory
