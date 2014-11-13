/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralPartCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionTypeCS;
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
 * An implementation of the model object '<em><b>Collection Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.CollectionLiteralExpCSImpl#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.CollectionLiteralExpCSImpl#getOwnedParts <em>Owned Parts</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class CollectionLiteralExpCSImpl extends PrimaryExpCSImpl implements CollectionLiteralExpCS
{
  /**
   * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedType()
   * @generated
   * @ordered
   */
  protected CollectionTypeCS ownedType;

  /**
   * The cached value of the '{@link #getOwnedParts() <em>Owned Parts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedParts()
   * @generated
   * @ordered
   */
  protected EList<CollectionLiteralPartCS> ownedParts;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected CollectionLiteralExpCSImpl()
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
    return TRCPackage.Literals.COLLECTION_LITERAL_EXP_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionTypeCS getOwnedType()
  {
    return ownedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedType(CollectionTypeCS newOwnedType, NotificationChain msgs)
  {
    CollectionTypeCS oldOwnedType = ownedType;
    ownedType = newOwnedType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, oldOwnedType, newOwnedType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOwnedType(CollectionTypeCS newOwnedType)
  {
    if (newOwnedType != ownedType)
    {
      NotificationChain msgs = null;
      if (ownedType != null)
        msgs = ((InternalEObject)ownedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, null, msgs);
      if (newOwnedType != null)
        msgs = ((InternalEObject)newOwnedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, null, msgs);
      msgs = basicSetOwnedType(newOwnedType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE, newOwnedType, newOwnedType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<CollectionLiteralPartCS> getOwnedParts()
  {
    if (ownedParts == null)
    {
      ownedParts = new EObjectContainmentEList<CollectionLiteralPartCS>(CollectionLiteralPartCS.class, this, TRCPackage.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS);
    }
    return ownedParts;
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
      case TRCPackage.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE:
        return basicSetOwnedType(null, msgs);
      case TRCPackage.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS:
        return ((InternalEList<?>)getOwnedParts()).basicRemove(otherEnd, msgs);
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
      case TRCPackage.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE:
        return getOwnedType();
      case TRCPackage.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS:
        return getOwnedParts();
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
      case TRCPackage.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE:
        setOwnedType((CollectionTypeCS)newValue);
        return;
      case TRCPackage.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS:
        getOwnedParts().clear();
        getOwnedParts().addAll((Collection<? extends CollectionLiteralPartCS>)newValue);
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
      case TRCPackage.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE:
        setOwnedType((CollectionTypeCS)null);
        return;
      case TRCPackage.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS:
        getOwnedParts().clear();
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
      case TRCPackage.COLLECTION_LITERAL_EXP_CS__OWNED_TYPE:
        return ownedType != null;
      case TRCPackage.COLLECTION_LITERAL_EXP_CS__OWNED_PARTS:
        return ownedParts != null && !ownedParts.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //CollectionLiteralExpCSImpl
