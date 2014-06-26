/**
 */
package org.trc.xtext.dsl.dsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.trc.xtext.dsl.dsl.AbstractRuleDependency;
import org.trc.xtext.dsl.dsl.DslPackage;
import org.trc.xtext.dsl.dsl.RuleDependencyConjunction;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Dependency Conjunction</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.trc.xtext.dsl.dsl.impl.RuleDependencyConjunctionImpl#getRequiredTransformations <em>Required Transformations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleDependencyConjunctionImpl extends MinimalEObjectImpl.Container implements RuleDependencyConjunction
{
  /**
   * The cached value of the '{@link #getRequiredTransformations() <em>Required Transformations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequiredTransformations()
   * @generated
   * @ordered
   */
  protected EList<AbstractRuleDependency> requiredTransformations;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected RuleDependencyConjunctionImpl()
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
    return DslPackage.Literals.RULE_DEPENDENCY_CONJUNCTION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<AbstractRuleDependency> getRequiredTransformations()
  {
    if (requiredTransformations == null)
    {
      requiredTransformations = new EObjectContainmentEList<AbstractRuleDependency>(AbstractRuleDependency.class, this, DslPackage.RULE_DEPENDENCY_CONJUNCTION__REQUIRED_TRANSFORMATIONS);
    }
    return requiredTransformations;
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
      case DslPackage.RULE_DEPENDENCY_CONJUNCTION__REQUIRED_TRANSFORMATIONS:
        return ((InternalEList<?>)getRequiredTransformations()).basicRemove(otherEnd, msgs);
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
      case DslPackage.RULE_DEPENDENCY_CONJUNCTION__REQUIRED_TRANSFORMATIONS:
        return getRequiredTransformations();
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
      case DslPackage.RULE_DEPENDENCY_CONJUNCTION__REQUIRED_TRANSFORMATIONS:
        getRequiredTransformations().clear();
        getRequiredTransformations().addAll((Collection<? extends AbstractRuleDependency>)newValue);
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
      case DslPackage.RULE_DEPENDENCY_CONJUNCTION__REQUIRED_TRANSFORMATIONS:
        getRequiredTransformations().clear();
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
      case DslPackage.RULE_DEPENDENCY_CONJUNCTION__REQUIRED_TRANSFORMATIONS:
        return requiredTransformations != null && !requiredTransformations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RuleDependencyConjunctionImpl
