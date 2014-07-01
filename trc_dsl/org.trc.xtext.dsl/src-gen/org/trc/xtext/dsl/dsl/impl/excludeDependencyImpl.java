/**
 */
package org.trc.xtext.dsl.dsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectResolvingEList;

import org.trc.xtext.dsl.dsl.DslPackage;
import org.trc.xtext.dsl.dsl.Transformation;
import org.trc.xtext.dsl.dsl.excludeDependency;
import org.trc.xtext.dsl.dsl.trcRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>exclude Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.trc.xtext.dsl.dsl.impl.excludeDependencyImpl#getRequiredTransformation <em>Required Transformation</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.impl.excludeDependencyImpl#getRequiredRule <em>Required Rule</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.impl.excludeDependencyImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.impl.excludeDependencyImpl#getOclExpression <em>Ocl Expression</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class excludeDependencyImpl extends MinimalEObjectImpl.Container implements excludeDependency
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
   * The default value of the '{@link #getOclExpression() <em>Ocl Expression</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOclExpression()
   * @generated
   * @ordered
   */
  protected static final String OCL_EXPRESSION_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getOclExpression() <em>Ocl Expression</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getOclExpression()
   * @generated
   * @ordered
   */
  protected String oclExpression = OCL_EXPRESSION_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected excludeDependencyImpl()
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
    return DslPackage.Literals.EXCLUDE_DEPENDENCY;
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
      requiredTransformation = new EObjectResolvingEList<Transformation>(Transformation.class, this, DslPackage.EXCLUDE_DEPENDENCY__REQUIRED_TRANSFORMATION);
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
      requiredRule = new EObjectResolvingEList<trcRule>(trcRule.class, this, DslPackage.EXCLUDE_DEPENDENCY__REQUIRED_RULE);
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
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.EXCLUDE_DEPENDENCY__FIELDS, oldFields, fields));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getOclExpression()
  {
    return oclExpression;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setOclExpression(String newOclExpression)
  {
    String oldOclExpression = oclExpression;
    oclExpression = newOclExpression;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.EXCLUDE_DEPENDENCY__OCL_EXPRESSION, oldOclExpression, oclExpression));
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
      case DslPackage.EXCLUDE_DEPENDENCY__REQUIRED_TRANSFORMATION:
        return getRequiredTransformation();
      case DslPackage.EXCLUDE_DEPENDENCY__REQUIRED_RULE:
        return getRequiredRule();
      case DslPackage.EXCLUDE_DEPENDENCY__FIELDS:
        return getFields();
      case DslPackage.EXCLUDE_DEPENDENCY__OCL_EXPRESSION:
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
      case DslPackage.EXCLUDE_DEPENDENCY__REQUIRED_TRANSFORMATION:
        getRequiredTransformation().clear();
        getRequiredTransformation().addAll((Collection<? extends Transformation>)newValue);
        return;
      case DslPackage.EXCLUDE_DEPENDENCY__REQUIRED_RULE:
        getRequiredRule().clear();
        getRequiredRule().addAll((Collection<? extends trcRule>)newValue);
        return;
      case DslPackage.EXCLUDE_DEPENDENCY__FIELDS:
        setFields((String)newValue);
        return;
      case DslPackage.EXCLUDE_DEPENDENCY__OCL_EXPRESSION:
        setOclExpression((String)newValue);
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
      case DslPackage.EXCLUDE_DEPENDENCY__REQUIRED_TRANSFORMATION:
        getRequiredTransformation().clear();
        return;
      case DslPackage.EXCLUDE_DEPENDENCY__REQUIRED_RULE:
        getRequiredRule().clear();
        return;
      case DslPackage.EXCLUDE_DEPENDENCY__FIELDS:
        setFields(FIELDS_EDEFAULT);
        return;
      case DslPackage.EXCLUDE_DEPENDENCY__OCL_EXPRESSION:
        setOclExpression(OCL_EXPRESSION_EDEFAULT);
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
      case DslPackage.EXCLUDE_DEPENDENCY__REQUIRED_TRANSFORMATION:
        return requiredTransformation != null && !requiredTransformation.isEmpty();
      case DslPackage.EXCLUDE_DEPENDENCY__REQUIRED_RULE:
        return requiredRule != null && !requiredRule.isEmpty();
      case DslPackage.EXCLUDE_DEPENDENCY__FIELDS:
        return FIELDS_EDEFAULT == null ? fields != null : !FIELDS_EDEFAULT.equals(fields);
      case DslPackage.EXCLUDE_DEPENDENCY__OCL_EXPRESSION:
        return OCL_EXPRESSION_EDEFAULT == null ? oclExpression != null : !OCL_EXPRESSION_EDEFAULT.equals(oclExpression);
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
    result.append(", oclExpression: ");
    result.append(oclExpression);
    result.append(')');
    return result.toString();
  }

} //excludeDependencyImpl
