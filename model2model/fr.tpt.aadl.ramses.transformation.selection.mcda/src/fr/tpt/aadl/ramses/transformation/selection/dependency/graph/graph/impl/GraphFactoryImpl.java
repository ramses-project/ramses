/**
 */
package fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl;

import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class GraphFactoryImpl extends EFactoryImpl implements GraphFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static GraphFactory init()
  {
    try
    {
      GraphFactory theGraphFactory = (GraphFactory)EPackage.Registry.INSTANCE.getEFactory(GraphPackage.eNS_URI);
      if (theGraphFactory != null)
      {
        return theGraphFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new GraphFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GraphFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case GraphPackage.DEPENDENCY_GRAPH: return createDependencyGraph();
      case GraphPackage.DEPENDENCY_NODE: return createDependencyNode();
      case GraphPackage.DEPENDENCY_ARC: return createDependencyArc();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DependencyGraph createDependencyGraph()
  {
    DependencyGraphImpl dependencyGraph = new DependencyGraphImpl();
    return dependencyGraph;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DependencyNode createDependencyNode()
  {
    DependencyNodeImpl dependencyNode = new DependencyNodeImpl();
    return dependencyNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DependencyArc createDependencyArc()
  {
    DependencyArcImpl dependencyArc = new DependencyArcImpl();
    return dependencyArc;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public GraphPackage getGraphPackage()
  {
    return (GraphPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static GraphPackage getPackage()
  {
    return GraphPackage.eINSTANCE;
  }

} //GraphFactoryImpl
