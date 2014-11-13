/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BooleanOperations;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.trcRule;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationDependencyImpl#getAppliedTransformation <em>Applied Transformation</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationDependencyImpl#getAppliedRule <em>Applied Rule</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationDependencyImpl#getFields <em>Fields</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationDependencyImpl#getRequiredTransformations <em>Required Transformations</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationDependencyImpl#getBoolOP <em>Bool OP</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationDependencyImpl extends MinimalEObjectImpl.Container implements TransformationDependency
{
  /**
   * The cached value of the '{@link #getAppliedTransformation() <em>Applied Transformation</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAppliedTransformation()
   * @generated
   * @ordered
   */
  protected Transformation appliedTransformation;

  /**
   * The cached value of the '{@link #getAppliedRule() <em>Applied Rule</em>}' reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getAppliedRule()
   * @generated
   * @ordered
   */
  protected trcRule appliedRule;

  /**
   * The cached value of the '{@link #getFields() <em>Fields</em>}' attribute list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFields()
   * @generated
   * @ordered
   */
  protected EList<String> fields;

  /**
   * The cached value of the '{@link #getRequiredTransformations() <em>Required Transformations</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getRequiredTransformations()
   * @generated
   * @ordered
   */
  protected EList<RuleDependency> requiredTransformations;

  /**
   * The cached value of the '{@link #getBoolOP() <em>Bool OP</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getBoolOP()
   * @generated
   * @ordered
   */
  protected BooleanOperations boolOP;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransformationDependencyImpl()
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
    return TRCPackage.Literals.TRANSFORMATION_DEPENDENCY;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transformation getAppliedTransformation()
  {
    if (appliedTransformation != null && appliedTransformation.eIsProxy())
    {
      InternalEObject oldAppliedTransformation = (InternalEObject)appliedTransformation;
      appliedTransformation = (Transformation)eResolveProxy(oldAppliedTransformation);
      if (appliedTransformation != oldAppliedTransformation)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TRCPackage.TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION, oldAppliedTransformation, appliedTransformation));
      }
    }
    return appliedTransformation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transformation basicGetAppliedTransformation()
  {
    return appliedTransformation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAppliedTransformation(Transformation newAppliedTransformation)
  {
    Transformation oldAppliedTransformation = appliedTransformation;
    appliedTransformation = newAppliedTransformation;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION, oldAppliedTransformation, appliedTransformation));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public trcRule getAppliedRule()
  {
    if (appliedRule != null && appliedRule.eIsProxy())
    {
      InternalEObject oldAppliedRule = (InternalEObject)appliedRule;
      appliedRule = (trcRule)eResolveProxy(oldAppliedRule);
      if (appliedRule != oldAppliedRule)
      {
        if (eNotificationRequired())
          eNotify(new ENotificationImpl(this, Notification.RESOLVE, TRCPackage.TRANSFORMATION_DEPENDENCY__APPLIED_RULE, oldAppliedRule, appliedRule));
      }
    }
    return appliedRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public trcRule basicGetAppliedRule()
  {
    return appliedRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setAppliedRule(trcRule newAppliedRule)
  {
    trcRule oldAppliedRule = appliedRule;
    appliedRule = newAppliedRule;
    if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.TRANSFORMATION_DEPENDENCY__APPLIED_RULE, oldAppliedRule, appliedRule));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<String> getFields()
  {
    if (fields == null)
    {
      fields = new EDataTypeEList<String>(String.class, this, TRCPackage.TRANSFORMATION_DEPENDENCY__FIELDS);
    }
    return fields;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<RuleDependency> getRequiredTransformations()
  {
    if (requiredTransformations == null)
    {
      requiredTransformations = new EObjectContainmentEList<RuleDependency>(RuleDependency.class, this, TRCPackage.TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS);
    }
    return requiredTransformations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanOperations getBoolOP()
  {
    return boolOP;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetBoolOP(BooleanOperations newBoolOP, NotificationChain msgs)
  {
    BooleanOperations oldBoolOP = boolOP;
    boolOP = newBoolOP;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TRCPackage.TRANSFORMATION_DEPENDENCY__BOOL_OP, oldBoolOP, newBoolOP);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setBoolOP(BooleanOperations newBoolOP)
  {
    if (newBoolOP != boolOP)
    {
      NotificationChain msgs = null;
      if (boolOP != null)
        msgs = ((InternalEObject)boolOP).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TRCPackage.TRANSFORMATION_DEPENDENCY__BOOL_OP, null, msgs);
      if (newBoolOP != null)
        msgs = ((InternalEObject)newBoolOP).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TRCPackage.TRANSFORMATION_DEPENDENCY__BOOL_OP, null, msgs);
      msgs = basicSetBoolOP(newBoolOP, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.TRANSFORMATION_DEPENDENCY__BOOL_OP, newBoolOP, newBoolOP));
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
      case TRCPackage.TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS:
        return ((InternalEList<?>)getRequiredTransformations()).basicRemove(otherEnd, msgs);
      case TRCPackage.TRANSFORMATION_DEPENDENCY__BOOL_OP:
        return basicSetBoolOP(null, msgs);
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
      case TRCPackage.TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION:
        if (resolve) return getAppliedTransformation();
        return basicGetAppliedTransformation();
      case TRCPackage.TRANSFORMATION_DEPENDENCY__APPLIED_RULE:
        if (resolve) return getAppliedRule();
        return basicGetAppliedRule();
      case TRCPackage.TRANSFORMATION_DEPENDENCY__FIELDS:
        return getFields();
      case TRCPackage.TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS:
        return getRequiredTransformations();
      case TRCPackage.TRANSFORMATION_DEPENDENCY__BOOL_OP:
        return getBoolOP();
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
      case TRCPackage.TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION:
        setAppliedTransformation((Transformation)newValue);
        return;
      case TRCPackage.TRANSFORMATION_DEPENDENCY__APPLIED_RULE:
        setAppliedRule((trcRule)newValue);
        return;
      case TRCPackage.TRANSFORMATION_DEPENDENCY__FIELDS:
        getFields().clear();
        getFields().addAll((Collection<? extends String>)newValue);
        return;
      case TRCPackage.TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS:
        getRequiredTransformations().clear();
        getRequiredTransformations().addAll((Collection<? extends RuleDependency>)newValue);
        return;
      case TRCPackage.TRANSFORMATION_DEPENDENCY__BOOL_OP:
        setBoolOP((BooleanOperations)newValue);
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
      case TRCPackage.TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION:
        setAppliedTransformation((Transformation)null);
        return;
      case TRCPackage.TRANSFORMATION_DEPENDENCY__APPLIED_RULE:
        setAppliedRule((trcRule)null);
        return;
      case TRCPackage.TRANSFORMATION_DEPENDENCY__FIELDS:
        getFields().clear();
        return;
      case TRCPackage.TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS:
        getRequiredTransformations().clear();
        return;
      case TRCPackage.TRANSFORMATION_DEPENDENCY__BOOL_OP:
        setBoolOP((BooleanOperations)null);
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
      case TRCPackage.TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION:
        return appliedTransformation != null;
      case TRCPackage.TRANSFORMATION_DEPENDENCY__APPLIED_RULE:
        return appliedRule != null;
      case TRCPackage.TRANSFORMATION_DEPENDENCY__FIELDS:
        return fields != null && !fields.isEmpty();
      case TRCPackage.TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS:
        return requiredTransformations != null && !requiredTransformations.isEmpty();
      case TRCPackage.TRANSFORMATION_DEPENDENCY__BOOL_OP:
        return boolOP != null;
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

} //TransformationDependencyImpl
