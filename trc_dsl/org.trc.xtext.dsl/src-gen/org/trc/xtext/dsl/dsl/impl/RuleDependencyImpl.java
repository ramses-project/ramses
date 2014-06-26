/**
 */
package org.trc.xtext.dsl.dsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.trc.xtext.dsl.dsl.DslPackage;
import org.trc.xtext.dsl.dsl.RuleDependency;
import org.trc.xtext.dsl.dsl.excludeDependency;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.trc.xtext.dsl.dsl.impl.RuleDependencyImpl#getRd <em>Rd</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.impl.RuleDependencyImpl#getEd <em>Ed</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleDependencyImpl extends AbstractRuleDependencyImpl implements RuleDependency
{
  /**
   * The cached value of the '{@link #getRd() <em>Rd</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRd()
   * @generated
   * @ordered
   */
  protected EList<EObject> rd;

  /**
   * The cached value of the '{@link #getEd() <em>Ed</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getEd()
   * @generated
   * @ordered
   */
  protected EList<excludeDependency> ed;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleDependencyImpl()
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
    return DslPackage.Literals.RULE_DEPENDENCY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getRd()
  {
    if (rd == null)
    {
      rd = new EObjectContainmentEList<EObject>(EObject.class, this, DslPackage.RULE_DEPENDENCY__RD);
    }
    return rd;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<excludeDependency> getEd()
  {
    if (ed == null)
    {
      ed = new EObjectContainmentEList<excludeDependency>(excludeDependency.class, this, DslPackage.RULE_DEPENDENCY__ED);
    }
    return ed;
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
      case DslPackage.RULE_DEPENDENCY__RD:
        return ((InternalEList<?>)getRd()).basicRemove(otherEnd, msgs);
      case DslPackage.RULE_DEPENDENCY__ED:
        return ((InternalEList<?>)getEd()).basicRemove(otherEnd, msgs);
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
      case DslPackage.RULE_DEPENDENCY__RD:
        return getRd();
      case DslPackage.RULE_DEPENDENCY__ED:
        return getEd();
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
      case DslPackage.RULE_DEPENDENCY__RD:
        getRd().clear();
        getRd().addAll((Collection<? extends EObject>)newValue);
        return;
      case DslPackage.RULE_DEPENDENCY__ED:
        getEd().clear();
        getEd().addAll((Collection<? extends excludeDependency>)newValue);
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
      case DslPackage.RULE_DEPENDENCY__RD:
        getRd().clear();
        return;
      case DslPackage.RULE_DEPENDENCY__ED:
        getEd().clear();
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
      case DslPackage.RULE_DEPENDENCY__RD:
        return rd != null && !rd.isEmpty();
      case DslPackage.RULE_DEPENDENCY__ED:
        return ed != null && !ed.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RuleDependencyImpl
