/**
 */
package fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl;

import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyArc;
import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.DependencyNode;
import fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.GraphPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Dependency Node</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyNodeImpl#getOutArcs <em>Out Arcs</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyNodeImpl#getInArcs <em>In Arcs</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyNodeImpl#getMatchedElements <em>Matched Elements</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.selection.dependency.graph.graph.impl.DependencyNodeImpl#getTransformationRule <em>Transformation Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DependencyNodeImpl extends MinimalEObjectImpl.Container implements DependencyNode
{
  /**
   * The cached value of the '{@link #getOutArcs() <em>Out Arcs</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOutArcs()
   * @generated
   * @ordered
   */
  protected EList<DependencyArc> outArcs;

  /**
   * The cached value of the '{@link #getInArcs() <em>In Arcs</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getInArcs()
   * @generated
   * @ordered
   */
  protected EList<DependencyArc> inArcs;

  /**
   * The cached value of the '{@link #getMatchedElements() <em>Matched Elements</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMatchedElements()
   * @generated
   * @ordered
   */
  protected EList<EObject> matchedElements;

  /**
   * The default value of the '{@link #getTransformationRule() <em>Transformation Rule</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransformationRule()
   * @generated
   * @ordered
   */
  protected static final String TRANSFORMATION_RULE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getTransformationRule() <em>Transformation Rule</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransformationRule()
   * @generated
   * @ordered
   */
  protected String transformationRule = TRANSFORMATION_RULE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DependencyNodeImpl()
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
    return GraphPackage.Literals.DEPENDENCY_NODE;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DependencyArc> getOutArcs()
  {
    if (outArcs == null)
    {
      outArcs = new EObjectContainmentEList<DependencyArc>(DependencyArc.class, this, GraphPackage.DEPENDENCY_NODE__OUT_ARCS);
    }
    return outArcs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<DependencyArc> getInArcs()
  {
    if (inArcs == null)
    {
      inArcs = new EObjectResolvingEList<DependencyArc>(DependencyArc.class, this, GraphPackage.DEPENDENCY_NODE__IN_ARCS);
    }
    return inArcs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getMatchedElements()
  {
    if (matchedElements == null)
    {
      matchedElements = new EObjectResolvingEList<EObject>(EObject.class, this, GraphPackage.DEPENDENCY_NODE__MATCHED_ELEMENTS);
    }
    return matchedElements;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getTransformationRule()
  {
    return transformationRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransformationRule(String newTransformationRule)
  {
    String oldTransformationRule = transformationRule;
    transformationRule = newTransformationRule;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, GraphPackage.DEPENDENCY_NODE__TRANSFORMATION_RULE, oldTransformationRule, transformationRule));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs)
  {
    switch (featureID)
    {
      case GraphPackage.DEPENDENCY_NODE__OUT_ARCS:
        return ((InternalEList<?>)getOutArcs()).basicRemove(otherEnd, msgs);
    }
    return super.eInverseRemove(otherEnd, featureID, msgs);
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
      case GraphPackage.DEPENDENCY_NODE__OUT_ARCS:
        return getOutArcs();
      case GraphPackage.DEPENDENCY_NODE__IN_ARCS:
        return getInArcs();
      case GraphPackage.DEPENDENCY_NODE__MATCHED_ELEMENTS:
        return getMatchedElements();
      case GraphPackage.DEPENDENCY_NODE__TRANSFORMATION_RULE:
        return getTransformationRule();
    }
    return super.eGet(featureID, resolve, coreType);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @SuppressWarnings("unchecked")
  @Override
  public void eSet(int featureID, Object newValue)
  {
    switch (featureID)
    {
      case GraphPackage.DEPENDENCY_NODE__OUT_ARCS:
        getOutArcs().clear();
        getOutArcs().addAll((Collection<? extends DependencyArc>)newValue);
        return;
      case GraphPackage.DEPENDENCY_NODE__IN_ARCS:
        getInArcs().clear();
        getInArcs().addAll((Collection<? extends DependencyArc>)newValue);
        return;
      case GraphPackage.DEPENDENCY_NODE__MATCHED_ELEMENTS:
        getMatchedElements().clear();
        getMatchedElements().addAll((Collection<? extends EObject>)newValue);
        return;
      case GraphPackage.DEPENDENCY_NODE__TRANSFORMATION_RULE:
        setTransformationRule((String)newValue);
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
      case GraphPackage.DEPENDENCY_NODE__OUT_ARCS:
        getOutArcs().clear();
        return;
      case GraphPackage.DEPENDENCY_NODE__IN_ARCS:
        getInArcs().clear();
        return;
      case GraphPackage.DEPENDENCY_NODE__MATCHED_ELEMENTS:
        getMatchedElements().clear();
        return;
      case GraphPackage.DEPENDENCY_NODE__TRANSFORMATION_RULE:
        setTransformationRule(TRANSFORMATION_RULE_EDEFAULT);
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
      case GraphPackage.DEPENDENCY_NODE__OUT_ARCS:
        return outArcs != null && !outArcs.isEmpty();
      case GraphPackage.DEPENDENCY_NODE__IN_ARCS:
        return inArcs != null && !inArcs.isEmpty();
      case GraphPackage.DEPENDENCY_NODE__MATCHED_ELEMENTS:
        return matchedElements != null && !matchedElements.isEmpty();
      case GraphPackage.DEPENDENCY_NODE__TRANSFORMATION_RULE:
        return TRANSFORMATION_RULE_EDEFAULT == null ? transformationRule != null : !TRANSFORMATION_RULE_EDEFAULT.equals(transformationRule);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (transformationRule: ");
    result.append(transformationRule);
    result.append(')');
    return result.toString();
  }

} //DependencyNodeImpl
