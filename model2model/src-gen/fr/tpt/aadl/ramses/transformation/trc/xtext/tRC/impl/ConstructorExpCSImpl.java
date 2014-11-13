/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorPartCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathNameCS;
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
 * An implementation of the model object '<em><b>Constructor Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstructorExpCSImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstructorExpCSImpl#getOwnedParts <em>Owned Parts</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstructorExpCSImpl#getValue <em>Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstructorExpCSImpl extends PrimaryExpCSImpl implements ConstructorExpCS
{
  /**
   * The cached value of the '{@link #getPathName() <em>Path Name</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getPathName()
   * @generated
   * @ordered
   */
  protected PathNameCS pathName;

  /**
   * The cached value of the '{@link #getOwnedParts() <em>Owned Parts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedParts()
   * @generated
   * @ordered
   */
  protected EList<ConstructorPartCS> ownedParts;

  /**
   * The default value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected static final String VALUE_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getValue() <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getValue()
   * @generated
   * @ordered
   */
  protected String value = VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstructorExpCSImpl()
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
    return TRCPackage.Literals.CONSTRUCTOR_EXP_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PathNameCS getPathName()
  {
    return pathName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetPathName(PathNameCS newPathName, NotificationChain msgs)
  {
    PathNameCS oldPathName = pathName;
    pathName = newPathName;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.CONSTRUCTOR_EXP_CS__PATH_NAME, oldPathName, newPathName);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setPathName(PathNameCS newPathName)
  {
    if (newPathName != pathName)
    {
      NotificationChain msgs = null;
      if (pathName != null)
        msgs = ((InternalEObject)pathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.CONSTRUCTOR_EXP_CS__PATH_NAME, null, msgs);
      if (newPathName != null)
        msgs = ((InternalEObject)newPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.CONSTRUCTOR_EXP_CS__PATH_NAME, null, msgs);
      msgs = basicSetPathName(newPathName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.CONSTRUCTOR_EXP_CS__PATH_NAME, newPathName, newPathName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ConstructorPartCS> getOwnedParts()
  {
    if (ownedParts == null)
    {
      ownedParts = new EObjectContainmentEList<ConstructorPartCS>(ConstructorPartCS.class, this, TRCPackage.CONSTRUCTOR_EXP_CS__OWNED_PARTS);
    }
    return ownedParts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getValue()
  {
    return value;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setValue(String newValue)
  {
    String oldValue = value;
    value = newValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.CONSTRUCTOR_EXP_CS__VALUE, oldValue, value));
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
      case TRCPackage.CONSTRUCTOR_EXP_CS__PATH_NAME:
        return basicSetPathName(null, msgs);
      case TRCPackage.CONSTRUCTOR_EXP_CS__OWNED_PARTS:
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
      case TRCPackage.CONSTRUCTOR_EXP_CS__PATH_NAME:
        return getPathName();
      case TRCPackage.CONSTRUCTOR_EXP_CS__OWNED_PARTS:
        return getOwnedParts();
      case TRCPackage.CONSTRUCTOR_EXP_CS__VALUE:
        return getValue();
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
      case TRCPackage.CONSTRUCTOR_EXP_CS__PATH_NAME:
        setPathName((PathNameCS)newValue);
        return;
      case TRCPackage.CONSTRUCTOR_EXP_CS__OWNED_PARTS:
        getOwnedParts().clear();
        getOwnedParts().addAll((Collection<? extends ConstructorPartCS>)newValue);
        return;
      case TRCPackage.CONSTRUCTOR_EXP_CS__VALUE:
        setValue((String)newValue);
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
      case TRCPackage.CONSTRUCTOR_EXP_CS__PATH_NAME:
        setPathName((PathNameCS)null);
        return;
      case TRCPackage.CONSTRUCTOR_EXP_CS__OWNED_PARTS:
        getOwnedParts().clear();
        return;
      case TRCPackage.CONSTRUCTOR_EXP_CS__VALUE:
        setValue(VALUE_EDEFAULT);
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
      case TRCPackage.CONSTRUCTOR_EXP_CS__PATH_NAME:
        return pathName != null;
      case TRCPackage.CONSTRUCTOR_EXP_CS__OWNED_PARTS:
        return ownedParts != null && !ownedParts.isEmpty();
      case TRCPackage.CONSTRUCTOR_EXP_CS__VALUE:
        return VALUE_EDEFAULT == null ? value != null : !VALUE_EDEFAULT.equals(value);
    }
    return super.eIsSet(featureID);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public String toString()
  {
    if (eIsProxy()) return super.toString();

    StringBuffer result = new StringBuffer(super.toString());
    result.append(" (value: ");
    result.append(value);
    result.append(')');
    return result.toString();
  }

} //ConstructorExpCSImpl
