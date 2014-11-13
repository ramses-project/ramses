/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.EssentialOCLPrefixOperator;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimaryExpOrLetExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Prefix Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrefixExpCSImpl#getOwnedOperator <em>Owned Operator</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.PrefixExpCSImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class PrefixExpCSImpl extends PrefixedExpCSImpl implements PrefixExpCS
{
  /**
   * The cached value of the '{@link #getOwnedOperator() <em>Owned Operator</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedOperator()
   * @generated
   * @ordered
   */
  protected EList<EssentialOCLPrefixOperator> ownedOperator;

  /**
   * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedExpression()
   * @generated
   * @ordered
   */
  protected PrimaryExpOrLetExpCS ownedExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected PrefixExpCSImpl()
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
    return TRCPackage.Literals.PREFIX_EXP_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<EssentialOCLPrefixOperator> getOwnedOperator()
  {
    if (ownedOperator == null)
    {
      ownedOperator = new EObjectContainmentEList<EssentialOCLPrefixOperator>(EssentialOCLPrefixOperator.class, this, TRCPackage.PREFIX_EXP_CS__OWNED_OPERATOR);
    }
    return ownedOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryExpOrLetExpCS getOwnedExpression()
  {
    return ownedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedExpression(PrimaryExpOrLetExpCS newOwnedExpression, NotificationChain msgs)
  {
    PrimaryExpOrLetExpCS oldOwnedExpression = ownedExpression;
    ownedExpression = newOwnedExpression;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.PREFIX_EXP_CS__OWNED_EXPRESSION, oldOwnedExpression, newOwnedExpression);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOwnedExpression(PrimaryExpOrLetExpCS newOwnedExpression)
  {
    if (newOwnedExpression != ownedExpression)
    {
      NotificationChain msgs = null;
      if (ownedExpression != null)
        msgs = ((InternalEObject)ownedExpression).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.PREFIX_EXP_CS__OWNED_EXPRESSION, null, msgs);
      if (newOwnedExpression != null)
        msgs = ((InternalEObject)newOwnedExpression).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.PREFIX_EXP_CS__OWNED_EXPRESSION, null, msgs);
      msgs = basicSetOwnedExpression(newOwnedExpression, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.PREFIX_EXP_CS__OWNED_EXPRESSION, newOwnedExpression, newOwnedExpression));
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
      case TRCPackage.PREFIX_EXP_CS__OWNED_OPERATOR:
        return ((InternalEList<?>)getOwnedOperator()).basicRemove(otherEnd, msgs);
      case TRCPackage.PREFIX_EXP_CS__OWNED_EXPRESSION:
        return basicSetOwnedExpression(null, msgs);
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
      case TRCPackage.PREFIX_EXP_CS__OWNED_OPERATOR:
        return getOwnedOperator();
      case TRCPackage.PREFIX_EXP_CS__OWNED_EXPRESSION:
        return getOwnedExpression();
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
      case TRCPackage.PREFIX_EXP_CS__OWNED_OPERATOR:
        getOwnedOperator().clear();
        getOwnedOperator().addAll((Collection<? extends EssentialOCLPrefixOperator>)newValue);
        return;
      case TRCPackage.PREFIX_EXP_CS__OWNED_EXPRESSION:
        setOwnedExpression((PrimaryExpOrLetExpCS)newValue);
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
      case TRCPackage.PREFIX_EXP_CS__OWNED_OPERATOR:
        getOwnedOperator().clear();
        return;
      case TRCPackage.PREFIX_EXP_CS__OWNED_EXPRESSION:
        setOwnedExpression((PrimaryExpOrLetExpCS)null);
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
      case TRCPackage.PREFIX_EXP_CS__OWNED_OPERATOR:
        return ownedOperator != null && !ownedOperator.isEmpty();
      case TRCPackage.PREFIX_EXP_CS__OWNED_EXPRESSION:
        return ownedExpression != null;
    }
    return super.eIsSet(featureID);
  }

} //PrefixExpCSImpl
