/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralWithMultiplicityCS;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Type Literal Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TypeLiteralExpCSImpl#getOwnedType <em>Owned Type</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TypeLiteralExpCSImpl extends PrimaryExpCSImpl implements TypeLiteralExpCS
{
  /**
   * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedType()
   * @generated
   * @ordered
   */
  protected TypeLiteralWithMultiplicityCS ownedType;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TypeLiteralExpCSImpl()
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
    return TRCPackage.Literals.TYPE_LITERAL_EXP_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeLiteralWithMultiplicityCS getOwnedType()
  {
    return ownedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedType(TypeLiteralWithMultiplicityCS newOwnedType, NotificationChain msgs)
  {
    TypeLiteralWithMultiplicityCS oldOwnedType = ownedType;
    ownedType = newOwnedType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.TYPE_LITERAL_EXP_CS__OWNED_TYPE, oldOwnedType, newOwnedType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOwnedType(TypeLiteralWithMultiplicityCS newOwnedType)
  {
    if (newOwnedType != ownedType)
    {
      NotificationChain msgs = null;
      if (ownedType != null)
        msgs = ((InternalEObject)ownedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.TYPE_LITERAL_EXP_CS__OWNED_TYPE, null, msgs);
      if (newOwnedType != null)
        msgs = ((InternalEObject)newOwnedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.TYPE_LITERAL_EXP_CS__OWNED_TYPE, null, msgs);
      msgs = basicSetOwnedType(newOwnedType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.TYPE_LITERAL_EXP_CS__OWNED_TYPE, newOwnedType, newOwnedType));
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
      case TRCPackage.TYPE_LITERAL_EXP_CS__OWNED_TYPE:
        return basicSetOwnedType(null, msgs);
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
      case TRCPackage.TYPE_LITERAL_EXP_CS__OWNED_TYPE:
        return getOwnedType();
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
      case TRCPackage.TYPE_LITERAL_EXP_CS__OWNED_TYPE:
        setOwnedType((TypeLiteralWithMultiplicityCS)newValue);
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
      case TRCPackage.TYPE_LITERAL_EXP_CS__OWNED_TYPE:
        setOwnedType((TypeLiteralWithMultiplicityCS)null);
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
      case TRCPackage.TYPE_LITERAL_EXP_CS__OWNED_TYPE:
        return ownedType != null;
    }
    return super.eIsSet(featureID);
  }

} //TypeLiteralExpCSImpl
