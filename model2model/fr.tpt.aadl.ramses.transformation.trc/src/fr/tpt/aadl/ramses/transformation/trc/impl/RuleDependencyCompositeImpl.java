/**
 */
package fr.tpt.aadl.ramses.transformation.trc.impl;

import fr.tpt.aadl.ramses.transformation.trc.AbstractRuleDependency;
import fr.tpt.aadl.ramses.transformation.trc.RuleDependencyComposite;
import fr.tpt.aadl.ramses.transformation.trc.TrcPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Dependency Composite</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyCompositeImpl#getRequiredTransformations <em>Required Transformations</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public abstract class RuleDependencyCompositeImpl extends AbstractRuleDependencyImpl implements RuleDependencyComposite
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
  protected RuleDependencyCompositeImpl()
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
    return TrcPackage.Literals.RULE_DEPENDENCY_COMPOSITE;
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
      requiredTransformations = new EObjectContainmentEList<AbstractRuleDependency>(AbstractRuleDependency.class, this, TrcPackage.RULE_DEPENDENCY_COMPOSITE__REQUIRED_TRANSFORMATIONS);
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
      case TrcPackage.RULE_DEPENDENCY_COMPOSITE__REQUIRED_TRANSFORMATIONS:
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
      case TrcPackage.RULE_DEPENDENCY_COMPOSITE__REQUIRED_TRANSFORMATIONS:
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
      case TrcPackage.RULE_DEPENDENCY_COMPOSITE__REQUIRED_TRANSFORMATIONS:
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
      case TrcPackage.RULE_DEPENDENCY_COMPOSITE__REQUIRED_TRANSFORMATIONS:
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
      case TrcPackage.RULE_DEPENDENCY_COMPOSITE__REQUIRED_TRANSFORMATIONS:
        return requiredTransformations != null && !requiredTransformations.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //RuleDependencyCompositeImpl
