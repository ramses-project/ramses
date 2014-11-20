/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvocationExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigatingArgCS;
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
 * An implementation of the model object '<em><b>Invocation Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.InvocationExpCSImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.InvocationExpCSImpl#isAtPre <em>At Pre</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.InvocationExpCSImpl#getArgument <em>Argument</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class InvocationExpCSImpl extends PrimaryExpCSImpl implements InvocationExpCS
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
   * The default value of the '{@link #isAtPre() <em>At Pre</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAtPre()
   * @generated
   * @ordered
   */
  protected static final boolean AT_PRE_EDEFAULT = false;

  /**
   * The cached value of the '{@link #isAtPre() <em>At Pre</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #isAtPre()
   * @generated
   * @ordered
   */
  protected boolean atPre = AT_PRE_EDEFAULT;

  /**
   * The cached value of the '{@link #getArgument() <em>Argument</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getArgument()
   * @generated
   * @ordered
   */
  protected EList<NavigatingArgCS> argument;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected InvocationExpCSImpl()
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
    return TRCPackage.Literals.INVOCATION_EXP_CS;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.INVOCATION_EXP_CS__PATH_NAME, oldPathName, newPathName);
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
        msgs = ((InternalEObject)pathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.INVOCATION_EXP_CS__PATH_NAME, null, msgs);
      if (newPathName != null)
        msgs = ((InternalEObject)newPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.INVOCATION_EXP_CS__PATH_NAME, null, msgs);
      msgs = basicSetPathName(newPathName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.INVOCATION_EXP_CS__PATH_NAME, newPathName, newPathName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public boolean isAtPre()
  {
    return atPre;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAtPre(boolean newAtPre)
  {
    boolean oldAtPre = atPre;
    atPre = newAtPre;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.INVOCATION_EXP_CS__AT_PRE, oldAtPre, atPre));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<NavigatingArgCS> getArgument()
  {
    if (argument == null)
    {
      argument = new EObjectContainmentEList<NavigatingArgCS>(NavigatingArgCS.class, this, TRCPackage.INVOCATION_EXP_CS__ARGUMENT);
    }
    return argument;
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
      case TRCPackage.INVOCATION_EXP_CS__PATH_NAME:
        return basicSetPathName(null, msgs);
      case TRCPackage.INVOCATION_EXP_CS__ARGUMENT:
        return ((InternalEList<?>)getArgument()).basicRemove(otherEnd, msgs);
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
      case TRCPackage.INVOCATION_EXP_CS__PATH_NAME:
        return getPathName();
      case TRCPackage.INVOCATION_EXP_CS__AT_PRE:
        return isAtPre();
      case TRCPackage.INVOCATION_EXP_CS__ARGUMENT:
        return getArgument();
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
      case TRCPackage.INVOCATION_EXP_CS__PATH_NAME:
        setPathName((PathNameCS)newValue);
        return;
      case TRCPackage.INVOCATION_EXP_CS__AT_PRE:
        setAtPre((Boolean)newValue);
        return;
      case TRCPackage.INVOCATION_EXP_CS__ARGUMENT:
        getArgument().clear();
        getArgument().addAll((Collection<? extends NavigatingArgCS>)newValue);
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
      case TRCPackage.INVOCATION_EXP_CS__PATH_NAME:
        setPathName((PathNameCS)null);
        return;
      case TRCPackage.INVOCATION_EXP_CS__AT_PRE:
        setAtPre(AT_PRE_EDEFAULT);
        return;
      case TRCPackage.INVOCATION_EXP_CS__ARGUMENT:
        getArgument().clear();
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
      case TRCPackage.INVOCATION_EXP_CS__PATH_NAME:
        return pathName != null;
      case TRCPackage.INVOCATION_EXP_CS__AT_PRE:
        return atPre != AT_PRE_EDEFAULT;
      case TRCPackage.INVOCATION_EXP_CS__ARGUMENT:
        return argument != null && !argument.isEmpty();
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
    result.append(" (atPre: ");
    result.append(atPre);
    result.append(')');
    return result.toString();
  }

} //InvocationExpCSImpl
