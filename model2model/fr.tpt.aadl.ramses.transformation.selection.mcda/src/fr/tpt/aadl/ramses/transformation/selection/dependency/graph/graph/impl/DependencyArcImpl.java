/**
 */
package fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl;

import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyArc;
import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode;
import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphPackage;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency Arc</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyArcImpl#getSourceNode <em>Source Node</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyArcImpl#getTargetNode <em>Target Node</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DependencyArcImpl extends MinimalEObjectImpl.Container implements DependencyArc
{
  /**
   * The cached value of the '{@link #getSourceNode() <em>Source Node</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSourceNode()
   * @generated
   * @ordered
   */
  protected DependencyNode sourceNode;

  /**
   * The cached value of the '{@link #getTargetNode() <em>Target Node</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTargetNode()
   * @generated
   * @ordered
   */
  protected DependencyNode targetNode;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DependencyArcImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  protected EClass eStaticClass()
  {
    return GraphPackage.Literals.DEPENDENCY_ARC;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DependencyNode getSourceNode()
  {
    if (sourceNode != null && sourceNode.eIsProxy())
    {
      InternalEObject oldSourceNode = (InternalEObject)sourceNode;
      sourceNode = (DependencyNode)eResolveProxy(oldSourceNode);
      if (sourceNode != oldSourceNode)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.DEPENDENCY_ARC__SOURCE_NODE, oldSourceNode, sourceNode));
      }
    }
    return sourceNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DependencyNode basicGetSourceNode()
  {
    return sourceNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSourceNode(DependencyNode newSourceNode)
  {
    DependencyNode oldSourceNode = sourceNode;
    sourceNode = newSourceNode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.DEPENDENCY_ARC__SOURCE_NODE, oldSourceNode, sourceNode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DependencyNode getTargetNode()
  {
    if (targetNode != null && targetNode.eIsProxy())
    {
      InternalEObject oldTargetNode = (InternalEObject)targetNode;
      targetNode = (DependencyNode)eResolveProxy(oldTargetNode);
      if (targetNode != oldTargetNode)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, GraphPackage.DEPENDENCY_ARC__TARGET_NODE, oldTargetNode, targetNode));
      }
    }
    return targetNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DependencyNode basicGetTargetNode()
  {
    return targetNode;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTargetNode(DependencyNode newTargetNode)
  {
    DependencyNode oldTargetNode = targetNode;
    targetNode = newTargetNode;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.DEPENDENCY_ARC__TARGET_NODE, oldTargetNode, targetNode));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public Object eGet(int featureID, boolean resolve, boolean coreType)
  {
    switch (featureID)
    {
      case GraphPackage.DEPENDENCY_ARC__SOURCE_NODE:
        if (resolve) return getSourceNode();
        return basicGetSourceNode();
      case GraphPackage.DEPENDENCY_ARC__TARGET_NODE:
        if (resolve) return getTargetNode();
        return basicGetTargetNode();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GraphPackage.DEPENDENCY_ARC__SOURCE_NODE:
        setSourceNode((DependencyNode)newValue);
        return;
      case GraphPackage.DEPENDENCY_ARC__TARGET_NODE:
        setTargetNode((DependencyNode)newValue);
        return;
    }
    super.eSet(featureID, newValue);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public void eUnset(int featureID)
  {
    switch (featureID)
    {
      case GraphPackage.DEPENDENCY_ARC__SOURCE_NODE:
        setSourceNode((DependencyNode)null);
        return;
      case GraphPackage.DEPENDENCY_ARC__TARGET_NODE:
        setTargetNode((DependencyNode)null);
        return;
    }
    super.eUnset(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public boolean eIsSet(int featureID)
  {
    switch (featureID)
    {
      case GraphPackage.DEPENDENCY_ARC__SOURCE_NODE:
        return sourceNode != null;
      case GraphPackage.DEPENDENCY_ARC__TARGET_NODE:
        return targetNode != null;
    }
    return super.eIsSet(featureID);
  }

} //DependencyArcImpl
