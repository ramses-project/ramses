/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS;
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
 * An implementation of the model object '<em><b>Constraint CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstraintCSImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstraintCSImpl#getMessageSpecification <em>Message Specification</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.ConstraintCSImpl#getSpecification <em>Specification</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class ConstraintCSImpl extends MinimalEObjectImpl.Container implements ConstraintCS
{
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
   * The cached value of the '{@link #getMessageSpecification() <em>Message Specification</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getMessageSpecification()
   * @generated
   * @ordered
   */
  protected SpecificationCS messageSpecification;

  /**
   * The cached value of the '{@link #getSpecification() <em>Specification</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSpecification()
   * @generated
   * @ordered
   */
  protected EList<SpecificationCS> specification;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected ConstraintCSImpl()
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
    return TRCPackage.Literals.CONSTRAINT_CS;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.CONSTRAINT_CS__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecificationCS getMessageSpecification()
  {
    return messageSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetMessageSpecification(SpecificationCS newMessageSpecification, NotificationChain msgs)
  {
    SpecificationCS oldMessageSpecification = messageSpecification;
    messageSpecification = newMessageSpecification;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION, oldMessageSpecification, newMessageSpecification);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setMessageSpecification(SpecificationCS newMessageSpecification)
  {
    if (newMessageSpecification != messageSpecification)
    {
      NotificationChain msgs = null;
      if (messageSpecification != null)
        msgs = ((InternalEObject)messageSpecification).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION, null, msgs);
      if (newMessageSpecification != null)
        msgs = ((InternalEObject)newMessageSpecification).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION, null, msgs);
      msgs = basicSetMessageSpecification(newMessageSpecification, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION, newMessageSpecification, newMessageSpecification));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<SpecificationCS> getSpecification()
  {
    if (specification == null)
    {
      specification = new EObjectContainmentEList<SpecificationCS>(SpecificationCS.class, this, TRCPackage.CONSTRAINT_CS__SPECIFICATION);
    }
    return specification;
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
      case TRCPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION:
        return basicSetMessageSpecification(null, msgs);
      case TRCPackage.CONSTRAINT_CS__SPECIFICATION:
        return ((InternalEList<?>)getSpecification()).basicRemove(otherEnd, msgs);
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
      case TRCPackage.CONSTRAINT_CS__NAME:
        return getName();
      case TRCPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION:
        return getMessageSpecification();
      case TRCPackage.CONSTRAINT_CS__SPECIFICATION:
        return getSpecification();
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
      case TRCPackage.CONSTRAINT_CS__NAME:
        setName((String)newValue);
        return;
      case TRCPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION:
        setMessageSpecification((SpecificationCS)newValue);
        return;
      case TRCPackage.CONSTRAINT_CS__SPECIFICATION:
        getSpecification().clear();
        getSpecification().addAll((Collection<? extends SpecificationCS>)newValue);
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
      case TRCPackage.CONSTRAINT_CS__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TRCPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION:
        setMessageSpecification((SpecificationCS)null);
        return;
      case TRCPackage.CONSTRAINT_CS__SPECIFICATION:
        getSpecification().clear();
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
      case TRCPackage.CONSTRAINT_CS__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TRCPackage.CONSTRAINT_CS__MESSAGE_SPECIFICATION:
        return messageSpecification != null;
      case TRCPackage.CONSTRAINT_CS__SPECIFICATION:
        return specification != null && !specification.isEmpty();
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
    result.append(" (name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //ConstraintCSImpl
