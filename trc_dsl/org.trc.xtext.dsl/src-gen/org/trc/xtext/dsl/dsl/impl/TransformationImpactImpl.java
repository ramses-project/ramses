/**
 */
package org.trc.xtext.dsl.dsl.impl;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.trc.xtext.dsl.dsl.DslPackage;
import org.trc.xtext.dsl.dsl.TransformationImpact;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation Impact</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.trc.xtext.dsl.dsl.impl.TransformationImpactImpl#getQualityAttributeName <em>Quality Attribute Name</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.impl.TransformationImpactImpl#getImpactValue <em>Impact Value</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationImpactImpl extends MinimalEObjectImpl.Container implements TransformationImpact
{
  /**
   * The default value of the '{@link #getQualityAttributeName() <em>Quality Attribute Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualityAttributeName()
   * @generated
   * @ordered
   */
  protected static final String QUALITY_ATTRIBUTE_NAME_EDEFAULT = null;

  /**
   * The cached value of the '{@link #getQualityAttributeName() <em>Quality Attribute Name</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getQualityAttributeName()
   * @generated
   * @ordered
   */
  protected String qualityAttributeName = QUALITY_ATTRIBUTE_NAME_EDEFAULT;

  /**
   * The default value of the '{@link #getImpactValue() <em>Impact Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImpactValue()
   * @generated
   * @ordered
   */
  protected static final int IMPACT_VALUE_EDEFAULT = 0;

  /**
   * The cached value of the '{@link #getImpactValue() <em>Impact Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getImpactValue()
   * @generated
   * @ordered
   */
  protected int impactValue = IMPACT_VALUE_EDEFAULT;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransformationImpactImpl()
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
    return DslPackage.Literals.TRANSFORMATION_IMPACT;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public String getQualityAttributeName()
  {
    return qualityAttributeName;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setQualityAttributeName(String newQualityAttributeName)
  {
    String oldQualityAttributeName = qualityAttributeName;
    qualityAttributeName = newQualityAttributeName;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TRANSFORMATION_IMPACT__QUALITY_ATTRIBUTE_NAME, oldQualityAttributeName, qualityAttributeName));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public int getImpactValue()
  {
    return impactValue;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setImpactValue(int newImpactValue)
  {
    int oldImpactValue = impactValue;
    impactValue = newImpactValue;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, DslPackage.TRANSFORMATION_IMPACT__IMPACT_VALUE, oldImpactValue, impactValue));
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
      case DslPackage.TRANSFORMATION_IMPACT__QUALITY_ATTRIBUTE_NAME:
        return getQualityAttributeName();
      case DslPackage.TRANSFORMATION_IMPACT__IMPACT_VALUE:
        return getImpactValue();
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
      case DslPackage.TRANSFORMATION_IMPACT__QUALITY_ATTRIBUTE_NAME:
        setQualityAttributeName((String)newValue);
        return;
      case DslPackage.TRANSFORMATION_IMPACT__IMPACT_VALUE:
        setImpactValue((Integer)newValue);
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
      case DslPackage.TRANSFORMATION_IMPACT__QUALITY_ATTRIBUTE_NAME:
        setQualityAttributeName(QUALITY_ATTRIBUTE_NAME_EDEFAULT);
        return;
      case DslPackage.TRANSFORMATION_IMPACT__IMPACT_VALUE:
        setImpactValue(IMPACT_VALUE_EDEFAULT);
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
      case DslPackage.TRANSFORMATION_IMPACT__QUALITY_ATTRIBUTE_NAME:
        return QUALITY_ATTRIBUTE_NAME_EDEFAULT == null ? qualityAttributeName != null : !QUALITY_ATTRIBUTE_NAME_EDEFAULT.equals(qualityAttributeName);
      case DslPackage.TRANSFORMATION_IMPACT__IMPACT_VALUE:
        return impactValue != IMPACT_VALUE_EDEFAULT;
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
    result.append(" (qualityAttributeName: ");
    result.append(qualityAttributeName);
    result.append(", impactValue: ");
    result.append(impactValue);
    result.append(')');
    return result.toString();
  }

} //TransformationImpactImpl
