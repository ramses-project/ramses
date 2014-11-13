/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BinaryOperatorCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Context Cs</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ContextCsImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ContextCsImpl#getB <em>B</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ContextCsImpl#getBO <em>BO</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ContextCsImpl extends MinimalEObjectImpl.Container implements ContextCs
{
  /**
   * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedExpression()
   * @generated
   * @ordered
   */
  protected EList<LetExpCS> ownedExpression;

  /**
   * The cached value of the '{@link #getB() <em>B</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getB()
   * @generated
   * @ordered
   */
  protected BinaryOperatorCS b;

  /**
   * The cached value of the '{@link #getBO() <em>BO</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBO()
   * @generated
   * @ordered
   */
  protected BinaryOperatorCS bo;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ContextCsImpl()
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
    return TRCPackage.Literals.CONTEXT_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<LetExpCS> getOwnedExpression()
  {
    if (ownedExpression == null)
    {
      ownedExpression = new EObjectContainmentEList<LetExpCS>(LetExpCS.class, this, TRCPackage.CONTEXT_CS__OWNED_EXPRESSION);
    }
    return ownedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinaryOperatorCS getB()
  {
    return b;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetB(BinaryOperatorCS newB, NotificationChain msgs)
  {
    BinaryOperatorCS oldB = b;
    b = newB;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.CONTEXT_CS__B, oldB, newB);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setB(BinaryOperatorCS newB)
  {
    if (newB != b)
    {
      NotificationChain msgs = null;
      if (b != null)
        msgs = ((InternalEObject)b).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.CONTEXT_CS__B, null, msgs);
      if (newB != null)
        msgs = ((InternalEObject)newB).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.CONTEXT_CS__B, null, msgs);
      msgs = basicSetB(newB, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.CONTEXT_CS__B, newB, newB));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinaryOperatorCS getBO()
  {
    return bo;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBO(BinaryOperatorCS newBO, NotificationChain msgs)
  {
    BinaryOperatorCS oldBO = bo;
    bo = newBO;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.CONTEXT_CS__BO, oldBO, newBO);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBO(BinaryOperatorCS newBO)
  {
    if (newBO != bo)
    {
      NotificationChain msgs = null;
      if (bo != null)
        msgs = ((InternalEObject)bo).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.CONTEXT_CS__BO, null, msgs);
      if (newBO != null)
        msgs = ((InternalEObject)newBO).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.CONTEXT_CS__BO, null, msgs);
      msgs = basicSetBO(newBO, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.CONTEXT_CS__BO, newBO, newBO));
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
      case TRCPackage.CONTEXT_CS__OWNED_EXPRESSION:
        return ((InternalEList<?>)getOwnedExpression()).basicRemove(otherEnd, msgs);
      case TRCPackage.CONTEXT_CS__B:
        return basicSetB(null, msgs);
      case TRCPackage.CONTEXT_CS__BO:
        return basicSetBO(null, msgs);
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
      case TRCPackage.CONTEXT_CS__OWNED_EXPRESSION:
        return getOwnedExpression();
      case TRCPackage.CONTEXT_CS__B:
        return getB();
      case TRCPackage.CONTEXT_CS__BO:
        return getBO();
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
      case TRCPackage.CONTEXT_CS__OWNED_EXPRESSION:
        getOwnedExpression().clear();
        getOwnedExpression().addAll((Collection<? extends LetExpCS>)newValue);
        return;
      case TRCPackage.CONTEXT_CS__B:
        setB((BinaryOperatorCS)newValue);
        return;
      case TRCPackage.CONTEXT_CS__BO:
        setBO((BinaryOperatorCS)newValue);
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
      case TRCPackage.CONTEXT_CS__OWNED_EXPRESSION:
        getOwnedExpression().clear();
        return;
      case TRCPackage.CONTEXT_CS__B:
        setB((BinaryOperatorCS)null);
        return;
      case TRCPackage.CONTEXT_CS__BO:
        setBO((BinaryOperatorCS)null);
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
      case TRCPackage.CONTEXT_CS__OWNED_EXPRESSION:
        return ownedExpression != null && !ownedExpression.isEmpty();
      case TRCPackage.CONTEXT_CS__B:
        return b != null;
      case TRCPackage.CONTEXT_CS__BO:
        return bo != null;
    }
    return super.eIsSet(featureID);
  }

} //ContextCsImpl
