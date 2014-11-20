/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BooleanOperations;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.KeyWord;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency;

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
 * An implementation of the model object '<em><b>Rule Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.RuleDependencyImpl#getKw <em>Kw</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.RuleDependencyImpl#getRed <em>Red</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.RuleDependencyImpl#getBoolOP <em>Bool OP</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleDependencyImpl extends MinimalEObjectImpl.Container implements RuleDependency
{
  /**
   * The cached value of the '{@link #getKw() <em>Kw</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getKw()
   * @generated
   * @ordered
   */
  protected KeyWord kw;

  /**
   * The cached value of the '{@link #getRed() <em>Red</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRed()
   * @generated
   * @ordered
   */
  protected EList<requiresOrExcludeDependency> red;

  /**
   * The cached value of the '{@link #getBoolOP() <em>Bool OP</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBoolOP()
   * @generated
   * @ordered
   */
  protected BooleanOperations boolOP;

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
    return TRCPackage.Literals.RULE_DEPENDENCY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KeyWord getKw()
  {
    return kw;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetKw(KeyWord newKw, NotificationChain msgs)
  {
    KeyWord oldKw = kw;
    kw = newKw;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.RULE_DEPENDENCY__KW, oldKw, newKw);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setKw(KeyWord newKw)
  {
    if (newKw != kw)
    {
      NotificationChain msgs = null;
      if (kw != null)
        msgs = ((InternalEObject)kw).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.RULE_DEPENDENCY__KW, null, msgs);
      if (newKw != null)
        msgs = ((InternalEObject)newKw).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.RULE_DEPENDENCY__KW, null, msgs);
      msgs = basicSetKw(newKw, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.RULE_DEPENDENCY__KW, newKw, newKw));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<requiresOrExcludeDependency> getRed()
  {
    if (red == null)
    {
      red = new EObjectContainmentEList<requiresOrExcludeDependency>(requiresOrExcludeDependency.class, this, TRCPackage.RULE_DEPENDENCY__RED);
    }
    return red;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanOperations getBoolOP()
  {
    return boolOP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBoolOP(BooleanOperations newBoolOP, NotificationChain msgs)
  {
    BooleanOperations oldBoolOP = boolOP;
    boolOP = newBoolOP;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.RULE_DEPENDENCY__BOOL_OP, oldBoolOP, newBoolOP);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBoolOP(BooleanOperations newBoolOP)
  {
    if (newBoolOP != boolOP)
    {
      NotificationChain msgs = null;
      if (boolOP != null)
        msgs = ((InternalEObject)boolOP).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.RULE_DEPENDENCY__BOOL_OP, null, msgs);
      if (newBoolOP != null)
        msgs = ((InternalEObject)newBoolOP).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.RULE_DEPENDENCY__BOOL_OP, null, msgs);
      msgs = basicSetBoolOP(newBoolOP, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.RULE_DEPENDENCY__BOOL_OP, newBoolOP, newBoolOP));
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
      case TRCPackage.RULE_DEPENDENCY__KW:
        return basicSetKw(null, msgs);
      case TRCPackage.RULE_DEPENDENCY__RED:
        return ((InternalEList<?>)getRed()).basicRemove(otherEnd, msgs);
      case TRCPackage.RULE_DEPENDENCY__BOOL_OP:
        return basicSetBoolOP(null, msgs);
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
      case TRCPackage.RULE_DEPENDENCY__KW:
        return getKw();
      case TRCPackage.RULE_DEPENDENCY__RED:
        return getRed();
      case TRCPackage.RULE_DEPENDENCY__BOOL_OP:
        return getBoolOP();
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
      case TRCPackage.RULE_DEPENDENCY__KW:
        setKw((KeyWord)newValue);
        return;
      case TRCPackage.RULE_DEPENDENCY__RED:
        getRed().clear();
        getRed().addAll((Collection<? extends requiresOrExcludeDependency>)newValue);
        return;
      case TRCPackage.RULE_DEPENDENCY__BOOL_OP:
        setBoolOP((BooleanOperations)newValue);
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
      case TRCPackage.RULE_DEPENDENCY__KW:
        setKw((KeyWord)null);
        return;
      case TRCPackage.RULE_DEPENDENCY__RED:
        getRed().clear();
        return;
      case TRCPackage.RULE_DEPENDENCY__BOOL_OP:
        setBoolOP((BooleanOperations)null);
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
      case TRCPackage.RULE_DEPENDENCY__KW:
        return kw != null;
      case TRCPackage.RULE_DEPENDENCY__RED:
        return red != null && !red.isEmpty();
      case TRCPackage.RULE_DEPENDENCY__BOOL_OP:
        return boolOP != null;
    }
    return super.eIsSet(featureID);
  }

} //RuleDependencyImpl
