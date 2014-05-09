/**
 */
package fr.tpt.aadl.ramses.transformation.trc.impl;

import fr.tpt.aadl.ramses.transformation.trc.Module;
import fr.tpt.aadl.ramses.transformation.trc.ModuleList;
import fr.tpt.aadl.ramses.transformation.trc.Transformation;
import fr.tpt.aadl.ramses.transformation.trc.TransformationImpact;
import fr.tpt.aadl.ramses.transformation.trc.TrcPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationImpl#getImpacts <em>Impacts</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationImpl#getModules <em>Modules</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationImpl#getRuleName <em>Rule Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationImpl#getName <em>Name</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationImpl extends EObjectImpl implements Transformation
{
  /**
   * The cached value of the '{@link #getImpacts() <em>Impacts</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImpacts()
   * @generated
   * @ordered
   */
  protected EList<TransformationImpact> impacts;

  /**
   * The cached value of the '{@link #getModules() <em>Modules</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModules()
   * @generated
   * @ordered
   */
  protected ModuleList modules;

  /**
   * The cached value of the '{@link #getRuleName() <em>Rule Name</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRuleName()
   * @generated
   * @ordered
   */
  protected EList<String> ruleName;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransformationImpl()
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
    return TrcPackage.Literals.TRANSFORMATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TransformationImpact> getImpacts()
  {
    if (impacts == null)
    {
      impacts = new EObjectContainmentEList<TransformationImpact>(TransformationImpact.class, this, TrcPackage.TRANSFORMATION__IMPACTS);
    }
    return impacts;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModuleList getModules()
  {
    return modules;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetModules(ModuleList newModules, NotificationChain msgs)
  {
    ModuleList oldModules = modules;
    modules = newModules;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TrcPackage.TRANSFORMATION__MODULES, oldModules, newModules);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setModules(ModuleList newModules)
  {
    if (newModules != modules)
    {
      NotificationChain msgs = null;
      if (modules != null)
        msgs = ((InternalEObject)modules).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TrcPackage.TRANSFORMATION__MODULES, null, msgs);
      if (newModules != null)
        msgs = ((InternalEObject)newModules).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TrcPackage.TRANSFORMATION__MODULES, null, msgs);
      msgs = basicSetModules(newModules, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TrcPackage.TRANSFORMATION__MODULES, newModules, newModules));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getRuleName()
  {
    if (ruleName == null)
    {
      ruleName = new EDataTypeUniqueEList<String>(String.class, this, TrcPackage.TRANSFORMATION__RULE_NAME);
    }
    return ruleName;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TrcPackage.TRANSFORMATION__NAME, oldName, name));
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
      case TrcPackage.TRANSFORMATION__IMPACTS:
        return ((InternalEList<?>)getImpacts()).basicRemove(otherEnd, msgs);
      case TrcPackage.TRANSFORMATION__MODULES:
        return basicSetModules(null, msgs);
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
      case TrcPackage.TRANSFORMATION__IMPACTS:
        return getImpacts();
      case TrcPackage.TRANSFORMATION__MODULES:
        return getModules();
      case TrcPackage.TRANSFORMATION__RULE_NAME:
        return getRuleName();
      case TrcPackage.TRANSFORMATION__NAME:
        return getName();
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
      case TrcPackage.TRANSFORMATION__IMPACTS:
        getImpacts().clear();
        getImpacts().addAll((Collection<? extends TransformationImpact>)newValue);
        return;
      case TrcPackage.TRANSFORMATION__MODULES:
        setModules((ModuleList)newValue);
        return;
      case TrcPackage.TRANSFORMATION__RULE_NAME:
        getRuleName().clear();
        getRuleName().addAll((Collection<? extends String>)newValue);
        return;
      case TrcPackage.TRANSFORMATION__NAME:
        setName((String)newValue);
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
      case TrcPackage.TRANSFORMATION__IMPACTS:
        getImpacts().clear();
        return;
      case TrcPackage.TRANSFORMATION__MODULES:
        setModules((ModuleList)null);
        return;
      case TrcPackage.TRANSFORMATION__RULE_NAME:
        getRuleName().clear();
        return;
      case TrcPackage.TRANSFORMATION__NAME:
        setName(NAME_EDEFAULT);
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
      case TrcPackage.TRANSFORMATION__IMPACTS:
        return impacts != null && !impacts.isEmpty();
      case TrcPackage.TRANSFORMATION__MODULES:
        return modules != null;
      case TrcPackage.TRANSFORMATION__RULE_NAME:
        return ruleName != null && !ruleName.isEmpty();
      case TrcPackage.TRANSFORMATION__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
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
    result.append(" (ruleName: ");
    result.append(ruleName);
    result.append(", name: ");
    result.append(name);
    result.append(')');
    return result.toString();
  }

} //TransformationImpl
