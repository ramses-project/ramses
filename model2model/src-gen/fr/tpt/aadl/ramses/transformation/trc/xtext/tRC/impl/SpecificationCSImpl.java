/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs;
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
 * An implementation of the model object '<em><b>Specification CS</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.SpecificationCSImpl#getOwnedExpression <em>Owned Expression</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.SpecificationCSImpl#getExprString <em>Expr String</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class SpecificationCSImpl extends MinimalEObjectImpl.Container implements SpecificationCS
{
  /**
   * The cached value of the '{@link #getOwnedExpression() <em>Owned Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOwnedExpression()
   * @generated
   * @ordered
   */
  protected EList<ContextCs> ownedExpression;

  /**
   * The default value of the '{@link #getExprString() <em>Expr String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExprString()
   * @generated
   * @ordered
   */
  protected static final String EXPR_STRING_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getExprString() <em>Expr String</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getExprString()
   * @generated
   * @ordered
   */
  protected String exprString = EXPR_STRING_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected SpecificationCSImpl()
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
    return TRCPackage.Literals.SPECIFICATION_CS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ContextCs> getOwnedExpression()
  {
    if (ownedExpression == null)
    {
      ownedExpression = new EObjectContainmentEList<ContextCs>(ContextCs.class, this, TRCPackage.SPECIFICATION_CS__OWNED_EXPRESSION);
    }
    return ownedExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getExprString()
  {
    return exprString;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setExprString(String newExprString)
  {
    String oldExprString = exprString;
    exprString = newExprString;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.SPECIFICATION_CS__EXPR_STRING, oldExprString, exprString));
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
      case TRCPackage.SPECIFICATION_CS__OWNED_EXPRESSION:
        return ((InternalEList<?>)getOwnedExpression()).basicRemove(otherEnd, msgs);
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
      case TRCPackage.SPECIFICATION_CS__OWNED_EXPRESSION:
        return getOwnedExpression();
      case TRCPackage.SPECIFICATION_CS__EXPR_STRING:
        return getExprString();
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
      case TRCPackage.SPECIFICATION_CS__OWNED_EXPRESSION:
        getOwnedExpression().clear();
        getOwnedExpression().addAll((Collection<? extends ContextCs>)newValue);
        return;
      case TRCPackage.SPECIFICATION_CS__EXPR_STRING:
        setExprString((String)newValue);
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
      case TRCPackage.SPECIFICATION_CS__OWNED_EXPRESSION:
        getOwnedExpression().clear();
        return;
      case TRCPackage.SPECIFICATION_CS__EXPR_STRING:
        setExprString(EXPR_STRING_EDEFAULT);
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
      case TRCPackage.SPECIFICATION_CS__OWNED_EXPRESSION:
        return ownedExpression != null && !ownedExpression.isEmpty();
      case TRCPackage.SPECIFICATION_CS__EXPR_STRING:
        return EXPR_STRING_EDEFAULT == null ? exprString != null : !EXPR_STRING_EDEFAULT.equals(exprString);
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
    result.append(" (exprString: ");
    result.append(exprString);
    result.append(')');
    return result.toString();
  }

} //SpecificationCSImpl
