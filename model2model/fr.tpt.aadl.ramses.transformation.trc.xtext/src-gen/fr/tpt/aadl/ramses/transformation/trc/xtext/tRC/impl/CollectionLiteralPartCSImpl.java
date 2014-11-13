/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralPartCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpressCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Collection Literal Part CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.CollectionLiteralPartCSImpl#getExpressionCS <em>Expression CS</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.CollectionLiteralPartCSImpl#getLastExpressionCS <em>Last Expression CS</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionLiteralPartCSImpl extends MinimalEObjectImpl.Container implements CollectionLiteralPartCS
{
  /**
   * The cached value of the '{@link #getExpressionCS() <em>Expression CS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExpressionCS()
   * @generated
   * @ordered
   */
  protected ExpressCS expressionCS;

  /**
   * The cached value of the '{@link #getLastExpressionCS() <em>Last Expression CS</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getLastExpressionCS()
   * @generated
   * @ordered
   */
  protected ExpressCS lastExpressionCS;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CollectionLiteralPartCSImpl()
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
    return TRCPackage.Literals.COLLECTION_LITERAL_PART_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressCS getExpressionCS()
  {
    return expressionCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetExpressionCS(ExpressCS newExpressionCS, NotificationChain msgs)
  {
    ExpressCS oldExpressionCS = expressionCS;
    expressionCS = newExpressionCS;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS, oldExpressionCS, newExpressionCS);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExpressionCS(ExpressCS newExpressionCS)
  {
    if (newExpressionCS != expressionCS)
    {
      NotificationChain msgs = null;
      if (expressionCS != null)
        msgs = ((InternalEObject)expressionCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS, null, msgs);
      if (newExpressionCS != null)
        msgs = ((InternalEObject)newExpressionCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS, null, msgs);
      msgs = basicSetExpressionCS(newExpressionCS, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS, newExpressionCS, newExpressionCS));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressCS getLastExpressionCS()
  {
    return lastExpressionCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetLastExpressionCS(ExpressCS newLastExpressionCS, NotificationChain msgs)
  {
    ExpressCS oldLastExpressionCS = lastExpressionCS;
    lastExpressionCS = newLastExpressionCS;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS, oldLastExpressionCS, newLastExpressionCS);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setLastExpressionCS(ExpressCS newLastExpressionCS)
  {
    if (newLastExpressionCS != lastExpressionCS)
    {
      NotificationChain msgs = null;
      if (lastExpressionCS != null)
        msgs = ((InternalEObject)lastExpressionCS).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS, null, msgs);
      if (newLastExpressionCS != null)
        msgs = ((InternalEObject)newLastExpressionCS).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS, null, msgs);
      msgs = basicSetLastExpressionCS(newLastExpressionCS, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS, newLastExpressionCS, newLastExpressionCS));
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
      case TRCPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS:
        return basicSetExpressionCS(null, msgs);
      case TRCPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS:
        return basicSetLastExpressionCS(null, msgs);
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
      case TRCPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS:
        return getExpressionCS();
      case TRCPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS:
        return getLastExpressionCS();
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
      case TRCPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS:
        setExpressionCS((ExpressCS)newValue);
        return;
      case TRCPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS:
        setLastExpressionCS((ExpressCS)newValue);
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
      case TRCPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS:
        setExpressionCS((ExpressCS)null);
        return;
      case TRCPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS:
        setLastExpressionCS((ExpressCS)null);
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
      case TRCPackage.COLLECTION_LITERAL_PART_CS__EXPRESSION_CS:
        return expressionCS != null;
      case TRCPackage.COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS:
        return lastExpressionCS != null;
    }
    return super.eIsSet(featureID);
  }

} //CollectionLiteralPartCSImpl
