/**
 */
package fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency Arc</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyArc#getSourceNode <em>Source Node</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyArc#getTargetNode <em>Target Node</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphPackage#getDependencyArc()
 * @model
 * @generated
 */
public interface DependencyArc extends EObject
{
  /**
   * Returns the value of the '<em><b>Source Node</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Source Node</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Source Node</em>' reference.
   * @see #setSourceNode(DependencyNode)
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphPackage#getDependencyArc_SourceNode()
   * @model required="true"
   * @generated
   */
  DependencyNode getSourceNode();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyArc#getSourceNode <em>Source Node</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Source Node</em>' reference.
   * @see #getSourceNode()
   * @generated
   */
  void setSourceNode(DependencyNode value);

  /**
   * Returns the value of the '<em><b>Target Node</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Target Node</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Target Node</em>' reference.
   * @see #setTargetNode(DependencyNode)
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphPackage#getDependencyArc_TargetNode()
   * @model required="true"
   * @generated
   */
  DependencyNode getTargetNode();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyArc#getTargetNode <em>Target Node</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Target Node</em>' reference.
   * @see #getTargetNode()
   * @generated
   */
  void setTargetNode(DependencyNode value);

} // DependencyArc
