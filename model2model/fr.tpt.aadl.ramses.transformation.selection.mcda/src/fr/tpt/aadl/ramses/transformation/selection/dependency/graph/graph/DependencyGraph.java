/**
 */
package fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency Graph</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyGraph#getNodes <em>Nodes</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphPackage#getDependencyGraph()
 * @model
 * @generated
 */
public interface DependencyGraph extends EObject
{
  /**
   * Returns the value of the '<em><b>Nodes</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Nodes</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Nodes</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphPackage#getDependencyGraph_Nodes()
   * @model containment="true"
   * @generated
   */
  EList<DependencyNode> getNodes();

} // DependencyGraph
