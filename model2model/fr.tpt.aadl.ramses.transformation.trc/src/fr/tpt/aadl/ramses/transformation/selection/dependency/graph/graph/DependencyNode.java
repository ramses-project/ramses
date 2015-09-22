/**
 */
package fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph;

import fr.tpt.aadl.ramses.transformation.trc.TrcRule;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Dependency Node</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode#getOutArcs <em>Out Arcs</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode#getInArcs <em>In Arcs</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode#getMatchedElements <em>Matched Elements</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode#getTransformationRule <em>Transformation Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphPackage#getDependencyNode()
 * @model
 * @generated
 */
public interface DependencyNode extends EObject
{
  /**
   * Returns the value of the '<em><b>Out Arcs</b></em>' containment reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyArc}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Out Arcs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Out Arcs</em>' containment reference list.
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphPackage#getDependencyNode_OutArcs()
   * @model containment="true"
   * @generated
   */
  EList<DependencyArc> getOutArcs();

  /**
   * Returns the value of the '<em><b>In Arcs</b></em>' reference list.
   * The list contents are of type {@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyArc}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>In Arcs</em>' containment reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>In Arcs</em>' reference list.
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphPackage#getDependencyNode_InArcs()
   * @model
   * @generated
   */
  EList<DependencyArc> getInArcs();

  /**
   * Returns the value of the '<em><b>Matched Elements</b></em>' reference list.
   * The list contents are of type {@link org.eclipse.emf.ecore.EObject}.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Matched Elements</em>' reference list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Matched Elements</em>' reference list.
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphPackage#getDependencyNode_MatchedElements()
   * @model required="true"
   * @generated
   */
  EList<EObject> getMatchedElements();

  /**
   * Returns the value of the '<em><b>Transformation Rule</b></em>' reference.
   * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transformation Rule</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
   * @return the value of the '<em>Transformation Rule</em>' reference.
   * @see #setTransformationRule(TrcRule)
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphPackage#getDependencyNode_TransformationRule()
   * @model
   * @generated
   */
  TrcRule getTransformationRule();

  /**
   * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode#getTransformationRule <em>Transformation Rule</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Transformation Rule</em>' reference.
   * @see #getTransformationRule()
   * @generated
   */
  void setTransformationRule(TrcRule value);

} // DependencyNode
