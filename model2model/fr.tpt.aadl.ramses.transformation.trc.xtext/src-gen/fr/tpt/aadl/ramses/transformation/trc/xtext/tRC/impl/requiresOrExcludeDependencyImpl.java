/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.oclExpr;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.trcRule;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.EObjectResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>requires Or Exclude Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.requiresOrExcludeDependencyImpl#getRequiredTransformation <em>Required Transformation</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.requiresOrExcludeDependencyImpl#getRequiredRule <em>Required Rule</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.requiresOrExcludeDependencyImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.requiresOrExcludeDependencyImpl#getOclExpression <em>Ocl Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class requiresOrExcludeDependencyImpl extends MinimalEObjectImpl.Container implements requiresOrExcludeDependency
{
  /**
   * The cached value of the '{@link #getRequiredTransformation() <em>Required Transformation</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequiredTransformation()
   * @generated
   * @ordered
   */
  protected EList<Transformation> requiredTransformation;

  /**
   * The cached value of the '{@link #getRequiredRule() <em>Required Rule</em>}' reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequiredRule()
   * @generated
   * @ordered
   */
  protected EList<trcRule> requiredRule;

  /**
   * The default value of the '{@link #getFields() <em>Fields</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFields()
   * @generated
   * @ordered
   */
  protected static final String FIELDS_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getFields() <em>Fields</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFields()
   * @generated
   * @ordered
   */
  protected String fields = FIELDS_EDEFAULT;

  /**
   * The cached value of the '{@link #getOclExpression() <em>Ocl Expression</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOclExpression()
   * @generated
   * @ordered
   */
  protected EList<oclExpr> oclExpression;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected requiresOrExcludeDependencyImpl()
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
    return TRCPackage.Literals.REQUIRES_OR_EXCLUDE_DEPENDENCY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<Transformation> getRequiredTransformation()
  {
    if (requiredTransformation == null)
    {
      requiredTransformation = new EObjectResolvingEList<Transformation>(Transformation.class, this, TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__REQUIRED_TRANSFORMATION);
    }
    return requiredTransformation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<trcRule> getRequiredRule()
  {
    if (requiredRule == null)
    {
      requiredRule = new EObjectResolvingEList<trcRule>(trcRule.class, this, TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__REQUIRED_RULE);
    }
    return requiredRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getFields()
  {
    return fields;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setFields(String newFields)
  {
    String oldFields = fields;
    fields = newFields;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__FIELDS, oldFields, fields));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<oclExpr> getOclExpression()
  {
    if (oclExpression == null)
    {
      oclExpression = new EObjectContainmentEList<oclExpr>(oclExpr.class, this, TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__OCL_EXPRESSION);
    }
    return oclExpression;
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
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__OCL_EXPRESSION:
        return ((InternalEList<?>)getOclExpression()).basicRemove(otherEnd, msgs);
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
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__REQUIRED_TRANSFORMATION:
        return getRequiredTransformation();
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__REQUIRED_RULE:
        return getRequiredRule();
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__FIELDS:
        return getFields();
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__OCL_EXPRESSION:
        return getOclExpression();
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
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__REQUIRED_TRANSFORMATION:
        getRequiredTransformation().clear();
        getRequiredTransformation().addAll((Collection<? extends Transformation>)newValue);
        return;
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__REQUIRED_RULE:
        getRequiredRule().clear();
        getRequiredRule().addAll((Collection<? extends trcRule>)newValue);
        return;
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__FIELDS:
        setFields((String)newValue);
        return;
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__OCL_EXPRESSION:
        getOclExpression().clear();
        getOclExpression().addAll((Collection<? extends oclExpr>)newValue);
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
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__REQUIRED_TRANSFORMATION:
        getRequiredTransformation().clear();
        return;
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__REQUIRED_RULE:
        getRequiredRule().clear();
        return;
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__FIELDS:
        setFields(FIELDS_EDEFAULT);
        return;
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__OCL_EXPRESSION:
        getOclExpression().clear();
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
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__REQUIRED_TRANSFORMATION:
        return requiredTransformation != null && !requiredTransformation.isEmpty();
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__REQUIRED_RULE:
        return requiredRule != null && !requiredRule.isEmpty();
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__FIELDS:
        return FIELDS_EDEFAULT == null ? fields != null : !FIELDS_EDEFAULT.equals(fields);
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY__OCL_EXPRESSION:
        return oclExpression != null && !oclExpression.isEmpty();
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
    result.append(" (fields: ");
    result.append(fields);
    result.append(')');
    return result.toString();
  }

} //requiresOrExcludeDependencyImpl
