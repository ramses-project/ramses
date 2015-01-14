/**
 */
package fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl;

import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyArc;
import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyGraph;
import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode;
import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphFactory;
import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphPackage;
import fr.tpt.aadl.ramses.transformation.trc.TrcPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphPackageImpl extends EPackageImpl implements GraphPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dependencyGraphEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dependencyNodeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass dependencyArcEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private GraphPackageImpl()
  {
    super(eNS_URI, GraphFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link GraphPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static GraphPackage init()
  {
    if (isInited) return (GraphPackage)EPackage.Registry.INSTANCE.getEPackage(GraphPackage.eNS_URI);

    // Obtain or create and register package
    GraphPackageImpl theGraphPackage = (GraphPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof GraphPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new GraphPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    TrcPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theGraphPackage.createPackageContents();

    // Initialize created meta-data
    theGraphPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theGraphPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(GraphPackage.eNS_URI, theGraphPackage);
    return theGraphPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDependencyGraph()
  {
    return dependencyGraphEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDependencyGraph_Nodes()
  {
    return (EReference)dependencyGraphEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDependencyNode()
  {
    return dependencyNodeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDependencyNode_OutArcs()
  {
    return (EReference)dependencyNodeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDependencyNode_InArcs()
  {
    return (EReference)dependencyNodeEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDependencyNode_MatchedElements()
  {
    return (EReference)dependencyNodeEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDependencyNode_TransformationRule()
  {
    return (EReference)dependencyNodeEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDependencyArc()
  {
    return dependencyArcEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDependencyArc_SourceNode()
  {
    return (EReference)dependencyArcEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDependencyArc_TargetNode()
  {
    return (EReference)dependencyArcEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GraphFactory getGraphFactory()
  {
    return (GraphFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    dependencyGraphEClass = createEClass(DEPENDENCY_GRAPH);
    createEReference(dependencyGraphEClass, DEPENDENCY_GRAPH__NODES);

    dependencyNodeEClass = createEClass(DEPENDENCY_NODE);
    createEReference(dependencyNodeEClass, DEPENDENCY_NODE__OUT_ARCS);
    createEReference(dependencyNodeEClass, DEPENDENCY_NODE__IN_ARCS);
    createEReference(dependencyNodeEClass, DEPENDENCY_NODE__MATCHED_ELEMENTS);
    createEReference(dependencyNodeEClass, DEPENDENCY_NODE__TRANSFORMATION_RULE);

    dependencyArcEClass = createEClass(DEPENDENCY_ARC);
    createEReference(dependencyArcEClass, DEPENDENCY_ARC__SOURCE_NODE);
    createEReference(dependencyArcEClass, DEPENDENCY_ARC__TARGET_NODE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    TrcPackage theTrcPackage = (TrcPackage)EPackage.Registry.INSTANCE.getEPackage(TrcPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes, features, and operations; add parameters
    initEClass(dependencyGraphEClass, DependencyGraph.class, "DependencyGraph", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDependencyGraph_Nodes(), this.getDependencyNode(), null, "nodes", null, 0, -1, DependencyGraph.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dependencyNodeEClass, DependencyNode.class, "DependencyNode", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDependencyNode_OutArcs(), this.getDependencyArc(), null, "outArcs", null, 0, -1, DependencyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDependencyNode_InArcs(), this.getDependencyArc(), null, "inArcs", null, 0, -1, DependencyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDependencyNode_MatchedElements(), ecorePackage.getEObject(), null, "matchedElements", null, 1, -1, DependencyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDependencyNode_TransformationRule(), theTrcPackage.getTrcRule(), null, "transformationRule", null, 0, 1, DependencyNode.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(dependencyArcEClass, DependencyArc.class, "DependencyArc", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getDependencyArc_SourceNode(), this.getDependencyNode(), null, "sourceNode", null, 1, 1, DependencyArc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDependencyArc_TargetNode(), this.getDependencyNode(), null, "targetNode", null, 1, 1, DependencyArc.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //GraphPackageImpl
