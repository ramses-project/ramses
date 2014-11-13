/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpressCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Express CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ExpressCSImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ExpressCSImpl#getOwnedOperator <em>Owned Operator</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ExpressCSImpl extends oclExprImpl implements ExpressCS
{
  /**
   * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedExpression()
   * @generated
   * @ordered
   */
  protected EList<EObject> ownedExpression;

  /**
   * The cached value of the '{@link #getOwnedOperator() <em>Owned Operator</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedOperator()
   * @generated
   * @ordered
   */
  protected EList<EObject> ownedOperator;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ExpressCSImpl()
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
    return TRCPackage.Literals.EXPRESS_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getOwnedExpression()
  {
    if (ownedExpression == null)
    {
      ownedExpression = new EObjectContainmentEList<EObject>(EObject.class, this, TRCPackage.EXPRESS_CS__OWNED_EXPRESSION);
    }
    return ownedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EObject> getOwnedOperator()
  {
    if (ownedOperator == null)
    {
      ownedOperator = new EObjectContainmentEList<EObject>(EObject.class, this, TRCPackage.EXPRESS_CS__OWNED_OPERATOR);
    }
    return ownedOperator;
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
      case TRCPackage.EXPRESS_CS__OWNED_EXPRESSION:
        return ((InternalEList<?>)getOwnedExpression()).basicRemove(otherEnd, msgs);
      case TRCPackage.EXPRESS_CS__OWNED_OPERATOR:
        return ((InternalEList<?>)getOwnedOperator()).basicRemove(otherEnd, msgs);
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
      case TRCPackage.EXPRESS_CS__OWNED_EXPRESSION:
        return getOwnedExpression();
      case TRCPackage.EXPRESS_CS__OWNED_OPERATOR:
        return getOwnedOperator();
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
      case TRCPackage.EXPRESS_CS__OWNED_EXPRESSION:
        getOwnedExpression().clear();
        getOwnedExpression().addAll((Collection<? extends EObject>)newValue);
        return;
      case TRCPackage.EXPRESS_CS__OWNED_OPERATOR:
        getOwnedOperator().clear();
        getOwnedOperator().addAll((Collection<? extends EObject>)newValue);
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
      case TRCPackage.EXPRESS_CS__OWNED_EXPRESSION:
        getOwnedExpression().clear();
        return;
      case TRCPackage.EXPRESS_CS__OWNED_OPERATOR:
        getOwnedOperator().clear();
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
      case TRCPackage.EXPRESS_CS__OWNED_EXPRESSION:
        return ownedExpression != null && !ownedExpression.isEmpty();
      case TRCPackage.EXPRESS_CS__OWNED_OPERATOR:
        return ownedOperator != null && !ownedOperator.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //ExpressCSImpl
