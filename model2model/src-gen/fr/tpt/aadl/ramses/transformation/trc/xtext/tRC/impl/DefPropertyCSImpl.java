/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefPropertyCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypedRefCS;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Def Property CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.DefPropertyCSImpl#isStatic <em>Static</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.DefPropertyCSImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.DefPropertyCSImpl#getOwnedType <em>Owned Type</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.DefPropertyCSImpl#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class DefPropertyCSImpl extends DefCSImpl implements DefPropertyCS
{
  /**
   * The default value of the '{@link #isStatic() <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStatic()
   * @generated
   * @ordered
   */
  protected static final boolean STATIC_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isStatic() <em>Static</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isStatic()
   * @generated
   * @ordered
   */
  protected boolean static_ = STATIC_EDEFAULT;

  /**
   * The default value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected static final String NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getName()
   * @generated
   * @ordered
   */
  protected String name = NAME_EDEFAULT;

  /**
   * The cached value of the '{@link #getOwnedType() <em>Owned Type</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedType()
   * @generated
   * @ordered
   */
  protected TypedRefCS ownedType;

  /**
   * The cached value of the '{@link #getSpecification() <em>Specification</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecification()
   * @generated
   * @ordered
   */
  protected SpecificationCS specification;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected DefPropertyCSImpl()
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
    return TRCPackage.Literals.DEF_PROPERTY_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isStatic()
  {
    return static_;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setStatic(boolean newStatic)
  {
    boolean oldStatic = static_;
    static_ = newStatic;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.DEF_PROPERTY_CS__STATIC, oldStatic, static_));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getName()
  {
    return name;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setName(String newName)
  {
    String oldName = name;
    name = newName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.DEF_PROPERTY_CS__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypedRefCS getOwnedType()
  {
    return ownedType;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetOwnedType(TypedRefCS newOwnedType, NotificationChain msgs)
  {
    TypedRefCS oldOwnedType = ownedType;
    ownedType = newOwnedType;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.DEF_PROPERTY_CS__OWNED_TYPE, oldOwnedType, newOwnedType);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOwnedType(TypedRefCS newOwnedType)
  {
    if (newOwnedType != ownedType)
    {
      NotificationChain msgs = null;
      if (ownedType != null)
        msgs = ((InternalEObject)ownedType).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.DEF_PROPERTY_CS__OWNED_TYPE, null, msgs);
      if (newOwnedType != null)
        msgs = ((InternalEObject)newOwnedType).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.DEF_PROPERTY_CS__OWNED_TYPE, null, msgs);
      msgs = basicSetOwnedType(newOwnedType, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.DEF_PROPERTY_CS__OWNED_TYPE, newOwnedType, newOwnedType));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecificationCS getSpecification()
  {
    return specification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetSpecification(SpecificationCS newSpecification, NotificationChain msgs)
  {
    SpecificationCS oldSpecification = specification;
    specification = newSpecification;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.DEF_PROPERTY_CS__SPECIFICATION, oldSpecification, newSpecification);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setSpecification(SpecificationCS newSpecification)
  {
    if (newSpecification != specification)
    {
      NotificationChain msgs = null;
      if (specification != null)
        msgs = ((InternalEObject)specification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.DEF_PROPERTY_CS__SPECIFICATION, null, msgs);
      if (newSpecification != null)
        msgs = ((InternalEObject)newSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.DEF_PROPERTY_CS__SPECIFICATION, null, msgs);
      msgs = basicSetSpecification(newSpecification, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.DEF_PROPERTY_CS__SPECIFICATION, newSpecification, newSpecification));
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
      case TRCPackage.DEF_PROPERTY_CS__OWNED_TYPE:
        return basicSetOwnedType(null, msgs);
      case TRCPackage.DEF_PROPERTY_CS__SPECIFICATION:
        return basicSetSpecification(null, msgs);
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
      case TRCPackage.DEF_PROPERTY_CS__STATIC:
        return isStatic();
      case TRCPackage.DEF_PROPERTY_CS__NAME:
        return getName();
      case TRCPackage.DEF_PROPERTY_CS__OWNED_TYPE:
        return getOwnedType();
      case TRCPackage.DEF_PROPERTY_CS__SPECIFICATION:
        return getSpecification();
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
      case TRCPackage.DEF_PROPERTY_CS__STATIC:
        setStatic((Boolean)newValue);
        return;
      case TRCPackage.DEF_PROPERTY_CS__NAME:
        setName((String)newValue);
        return;
      case TRCPackage.DEF_PROPERTY_CS__OWNED_TYPE:
        setOwnedType((TypedRefCS)newValue);
        return;
      case TRCPackage.DEF_PROPERTY_CS__SPECIFICATION:
        setSpecification((SpecificationCS)newValue);
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
      case TRCPackage.DEF_PROPERTY_CS__STATIC:
        setStatic(STATIC_EDEFAULT);
        return;
      case TRCPackage.DEF_PROPERTY_CS__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TRCPackage.DEF_PROPERTY_CS__OWNED_TYPE:
        setOwnedType((TypedRefCS)null);
        return;
      case TRCPackage.DEF_PROPERTY_CS__SPECIFICATION:
        setSpecification((SpecificationCS)null);
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
      case TRCPackage.DEF_PROPERTY_CS__STATIC:
        return static_ != STATIC_EDEFAULT;
      case TRCPackage.DEF_PROPERTY_CS__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TRCPackage.DEF_PROPERTY_CS__OWNED_TYPE:
        return ownedType != null;
      case TRCPackage.DEF_PROPERTY_CS__SPECIFICATION:
        return specification != null;
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
    result.append(" (static: ");
    result.append(static_);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //DefPropertyCSImpl
