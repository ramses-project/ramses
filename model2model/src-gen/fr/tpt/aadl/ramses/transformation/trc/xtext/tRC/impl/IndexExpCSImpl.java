/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpressCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IndexExpCS;
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
 * An implementation of the model object '<em><b>Index Exp CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.IndexExpCSImpl#getPathName <em>Path Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.IndexExpCSImpl#getFirstIndexes <em>First Indexes</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.IndexExpCSImpl#getSecondIndexes <em>Second Indexes</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.IndexExpCSImpl#isAtPre <em>At Pre</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class IndexExpCSImpl extends PrimaryExpCSImpl implements IndexExpCS
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
   * The cached value of the '{@link #getFirstIndexes() <em>First Indexes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFirstIndexes()
   * @generated
   * @ordered
   */
  protected EList<ExpressCS> firstIndexes;

  /**
   * The cached value of the '{@link #getSecondIndexes() <em>Second Indexes</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getSecondIndexes()
   * @generated
   * @ordered
   */
  protected EList<ExpressCS> secondIndexes;

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
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected IndexExpCSImpl()
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
    return TRCPackage.Literals.INDEX_EXP_CS;
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
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.INDEX_EXP_CS__PATH_NAME, oldPathName, newPathName);
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
        msgs = ((InternalEObject)pathName).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.INDEX_EXP_CS__PATH_NAME, null, msgs);
      if (newPathName != null)
        msgs = ((InternalEObject)newPathName).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.INDEX_EXP_CS__PATH_NAME, null, msgs);
      msgs = basicSetPathName(newPathName, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.INDEX_EXP_CS__PATH_NAME, newPathName, newPathName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExpressCS> getFirstIndexes()
  {
    if (firstIndexes == null)
    {
      firstIndexes = new EObjectContainmentEList<ExpressCS>(ExpressCS.class, this, TRCPackage.INDEX_EXP_CS__FIRST_INDEXES);
    }
    return firstIndexes;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ExpressCS> getSecondIndexes()
  {
    if (secondIndexes == null)
    {
      secondIndexes = new EObjectContainmentEList<ExpressCS>(ExpressCS.class, this, TRCPackage.INDEX_EXP_CS__SECOND_INDEXES);
    }
    return secondIndexes;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.INDEX_EXP_CS__AT_PRE, oldAtPre, atPre));
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
      case TRCPackage.INDEX_EXP_CS__PATH_NAME:
        return basicSetPathName(null, msgs);
      case TRCPackage.INDEX_EXP_CS__FIRST_INDEXES:
        return ((InternalEList<?>)getFirstIndexes()).basicRemove(otherEnd, msgs);
      case TRCPackage.INDEX_EXP_CS__SECOND_INDEXES:
        return ((InternalEList<?>)getSecondIndexes()).basicRemove(otherEnd, msgs);
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
      case TRCPackage.INDEX_EXP_CS__PATH_NAME:
        return getPathName();
      case TRCPackage.INDEX_EXP_CS__FIRST_INDEXES:
        return getFirstIndexes();
      case TRCPackage.INDEX_EXP_CS__SECOND_INDEXES:
        return getSecondIndexes();
      case TRCPackage.INDEX_EXP_CS__AT_PRE:
        return isAtPre();
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
      case TRCPackage.INDEX_EXP_CS__PATH_NAME:
        setPathName((PathNameCS)newValue);
        return;
      case TRCPackage.INDEX_EXP_CS__FIRST_INDEXES:
        getFirstIndexes().clear();
        getFirstIndexes().addAll((Collection<? extends ExpressCS>)newValue);
        return;
      case TRCPackage.INDEX_EXP_CS__SECOND_INDEXES:
        getSecondIndexes().clear();
        getSecondIndexes().addAll((Collection<? extends ExpressCS>)newValue);
        return;
      case TRCPackage.INDEX_EXP_CS__AT_PRE:
        setAtPre((Boolean)newValue);
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
      case TRCPackage.INDEX_EXP_CS__PATH_NAME:
        setPathName((PathNameCS)null);
        return;
      case TRCPackage.INDEX_EXP_CS__FIRST_INDEXES:
        getFirstIndexes().clear();
        return;
      case TRCPackage.INDEX_EXP_CS__SECOND_INDEXES:
        getSecondIndexes().clear();
        return;
      case TRCPackage.INDEX_EXP_CS__AT_PRE:
        setAtPre(AT_PRE_EDEFAULT);
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
      case TRCPackage.INDEX_EXP_CS__PATH_NAME:
        return pathName != null;
      case TRCPackage.INDEX_EXP_CS__FIRST_INDEXES:
        return firstIndexes != null && !firstIndexes.isEmpty();
      case TRCPackage.INDEX_EXP_CS__SECOND_INDEXES:
        return secondIndexes != null && !secondIndexes.isEmpty();
      case TRCPackage.INDEX_EXP_CS__AT_PRE:
        return atPre != AT_PRE_EDEFAULT;
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

} //IndexExpCSImpl
