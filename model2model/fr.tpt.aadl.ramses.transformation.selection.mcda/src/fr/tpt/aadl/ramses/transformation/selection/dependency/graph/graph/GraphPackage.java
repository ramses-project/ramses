/**
 */
package fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphFactory
 * @model kind="package"
 * @generated
 */
public interface GraphPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "graph";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://fr.tpt.aadl.ramses.transformation/DependencyGraph/1.0";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "fr.tpt.aadl.ramses.transformation.selection.dependency";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  GraphPackage eINSTANCE = fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.GraphPackageImpl.init();

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyGraphImpl <em>Dependency Graph</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyGraphImpl
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.GraphPackageImpl#getDependencyGraph()
   * @generated
   */
  int DEPENDENCY_GRAPH = 0;

  /**
   * The feature id for the '<em><b>Nodes</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPENDENCY_GRAPH__NODES = 0;

  /**
   * The number of structural features of the '<em>Dependency Graph</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPENDENCY_GRAPH_FEATURE_COUNT = 1;

  /**
   * The number of operations of the '<em>Dependency Graph</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPENDENCY_GRAPH_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyNodeImpl <em>Dependency Node</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyNodeImpl
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.GraphPackageImpl#getDependencyNode()
   * @generated
   */
  int DEPENDENCY_NODE = 1;

  /**
   * The feature id for the '<em><b>Out Arcs</b></em>' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPENDENCY_NODE__OUT_ARCS = 0;

  /**
   * The feature id for the '<em><b>In Arcs</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPENDENCY_NODE__IN_ARCS = 1;

  /**
   * The feature id for the '<em><b>Matched Elements</b></em>' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPENDENCY_NODE__MATCHED_ELEMENTS = 2;

  /**
   * The number of structural features of the '<em>Dependency Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPENDENCY_NODE_FEATURE_COUNT = 3;

  /**
   * The number of operations of the '<em>Dependency Node</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPENDENCY_NODE_OPERATION_COUNT = 0;

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyArcImpl <em>Dependency Arc</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyArcImpl
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.GraphPackageImpl#getDependencyArc()
   * @generated
   */
  int DEPENDENCY_ARC = 2;

  /**
   * The feature id for the '<em><b>Source Node</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPENDENCY_ARC__SOURCE_NODE = 0;

  /**
   * The feature id for the '<em><b>Target Node</b></em>' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPENDENCY_ARC__TARGET_NODE = 1;

  /**
   * The number of structural features of the '<em>Dependency Arc</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPENDENCY_ARC_FEATURE_COUNT = 2;

  /**
   * The number of operations of the '<em>Dependency Arc</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int DEPENDENCY_ARC_OPERATION_COUNT = 0;


  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyGraph <em>Dependency Graph</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dependency Graph</em>'.
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyGraph
   * @generated
   */
  EClass getDependencyGraph();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyGraph#getNodes <em>Nodes</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Nodes</em>'.
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyGraph#getNodes()
   * @see #getDependencyGraph()
   * @generated
   */
  EReference getDependencyGraph_Nodes();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode <em>Dependency Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dependency Node</em>'.
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode
   * @generated
   */
  EClass getDependencyNode();

  /**
   * Returns the meta object for the containment reference list '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode#getOutArcs <em>Out Arcs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the containment reference list '<em>Out Arcs</em>'.
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode#getOutArcs()
   * @see #getDependencyNode()
   * @generated
   */
  EReference getDependencyNode_OutArcs();

  /**
   * Returns the meta object for the reference list '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode#getInArcs <em>In Arcs</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>In Arcs</em>'.
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode#getInArcs()
   * @see #getDependencyNode()
   * @generated
   */
  EReference getDependencyNode_InArcs();

  /**
   * Returns the meta object for the reference list '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode#getMatchedElements <em>Matched Elements</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference list '<em>Matched Elements</em>'.
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode#getMatchedElements()
   * @see #getDependencyNode()
   * @generated
   */
  EReference getDependencyNode_MatchedElements();

  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyArc <em>Dependency Arc</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Dependency Arc</em>'.
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyArc
   * @generated
   */
  EClass getDependencyArc();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyArc#getSourceNode <em>Source Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Source Node</em>'.
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyArc#getSourceNode()
   * @see #getDependencyArc()
   * @generated
   */
  EReference getDependencyArc_SourceNode();

  /**
   * Returns the meta object for the reference '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyArc#getTargetNode <em>Target Node</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for the reference '<em>Target Node</em>'.
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyArc#getTargetNode()
   * @see #getDependencyArc()
   * @generated
   */
  EReference getDependencyArc_TargetNode();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  GraphFactory getGraphFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each operation of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyGraphImpl <em>Dependency Graph</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyGraphImpl
     * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.GraphPackageImpl#getDependencyGraph()
     * @generated
     */
    EClass DEPENDENCY_GRAPH = eINSTANCE.getDependencyGraph();

    /**
     * The meta object literal for the '<em><b>Nodes</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEPENDENCY_GRAPH__NODES = eINSTANCE.getDependencyGraph_Nodes();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyNodeImpl <em>Dependency Node</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyNodeImpl
     * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.GraphPackageImpl#getDependencyNode()
     * @generated
     */
    EClass DEPENDENCY_NODE = eINSTANCE.getDependencyNode();

    /**
     * The meta object literal for the '<em><b>Out Arcs</b></em>' containment reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEPENDENCY_NODE__OUT_ARCS = eINSTANCE.getDependencyNode_OutArcs();

    /**
     * The meta object literal for the '<em><b>In Arcs</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEPENDENCY_NODE__IN_ARCS = eINSTANCE.getDependencyNode_InArcs();

    /**
     * The meta object literal for the '<em><b>Matched Elements</b></em>' reference list feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEPENDENCY_NODE__MATCHED_ELEMENTS = eINSTANCE.getDependencyNode_MatchedElements();

    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyArcImpl <em>Dependency Arc</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyArcImpl
     * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.GraphPackageImpl#getDependencyArc()
     * @generated
     */
    EClass DEPENDENCY_ARC = eINSTANCE.getDependencyArc();

    /**
     * The meta object literal for the '<em><b>Source Node</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEPENDENCY_ARC__SOURCE_NODE = eINSTANCE.getDependencyArc_SourceNode();

    /**
     * The meta object literal for the '<em><b>Target Node</b></em>' reference feature.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @generated
     */
    EReference DEPENDENCY_ARC__TARGET_NODE = eINSTANCE.getDependencyArc_TargetNode();

  }

} //GraphPackage
