/**
 */
package fr.tpt.aadl.ramses.transformation.trc.impl;

import fr.tpt.aadl.ramses.transformation.trc.Module;
import fr.tpt.aadl.ramses.transformation.trc.ModuleList;
import fr.tpt.aadl.ramses.transformation.trc.Transformation;
import fr.tpt.aadl.ramses.transformation.trc.TransformationDependency;
import fr.tpt.aadl.ramses.transformation.trc.TransformationDependencyList;
import fr.tpt.aadl.ramses.transformation.trc.TransformationList;
import fr.tpt.aadl.ramses.transformation.trc.TrcPackage;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.TrcSpecificationImpl#getTransformations <em>Transformations</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.TrcSpecificationImpl#getDependencies <em>Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TrcSpecificationImpl extends EObjectImpl implements TrcSpecification
{
  /**
   * The cached value of the '{@link #getTransformations() <em>Transformations</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransformations()
   * @generated
   * @ordered
   */
  protected TransformationList transformations;

  /**
   * The cached value of the '{@link #getDependencies() <em>Dependencies</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDependencies()
   * @generated
   * @ordered
   */
  protected TransformationDependencyList dependencies;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TrcSpecificationImpl()
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
    return TrcPackage.Literals.TRC_SPECIFICATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransformationList getTransformations()
  {
    return transformations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetTransformations(TransformationList newTransformations, NotificationChain msgs)
  {
    TransformationList oldTransformations = transformations;
    transformations = newTransformations;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TrcPackage.TRC_SPECIFICATION__TRANSFORMATIONS, oldTransformations, newTransformations);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setTransformations(TransformationList newTransformations)
  {
    if (newTransformations != transformations)
    {
      NotificationChain msgs = null;
      if (transformations != null)
        msgs = ((InternalEObject)transformations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TrcPackage.TRC_SPECIFICATION__TRANSFORMATIONS, null, msgs);
      if (newTransformations != null)
        msgs = ((InternalEObject)newTransformations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TrcPackage.TRC_SPECIFICATION__TRANSFORMATIONS, null, msgs);
      msgs = basicSetTransformations(newTransformations, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TrcPackage.TRC_SPECIFICATION__TRANSFORMATIONS, newTransformations, newTransformations));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransformationDependencyList getDependencies()
  {
    return dependencies;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NotificationChain basicSetDependencies(TransformationDependencyList newDependencies, NotificationChain msgs)
  {
    TransformationDependencyList oldDependencies = dependencies;
    dependencies = newDependencies;
    if (eNotificationRequired())
    {
      ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TrcPackage.TRC_SPECIFICATION__DEPENDENCIES, oldDependencies, newDependencies);
      if (msgs == null) msgs = notification; else msgs.add(notification);
    }
    return msgs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void setDependencies(TransformationDependencyList newDependencies)
  {
    if (newDependencies != dependencies)
    {
      NotificationChain msgs = null;
      if (dependencies != null)
        msgs = ((InternalEObject)dependencies).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TrcPackage.TRC_SPECIFICATION__DEPENDENCIES, null, msgs);
      if (newDependencies != null)
        msgs = ((InternalEObject)newDependencies).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TrcPackage.TRC_SPECIFICATION__DEPENDENCIES, null, msgs);
      msgs = basicSetDependencies(newDependencies, msgs);
      if (msgs != null) msgs.dispatch();
    }
    else if (eNotificationRequired())
      eNotify(new ENotificationImpl(this, Notification.SET, TrcPackage.TRC_SPECIFICATION__DEPENDENCIES, newDependencies, newDependencies));
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
      case TrcPackage.TRC_SPECIFICATION__TRANSFORMATIONS:
        return basicSetTransformations(null, msgs);
      case TrcPackage.TRC_SPECIFICATION__DEPENDENCIES:
        return basicSetDependencies(null, msgs);
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
      case TrcPackage.TRC_SPECIFICATION__TRANSFORMATIONS:
        return getTransformations();
      case TrcPackage.TRC_SPECIFICATION__DEPENDENCIES:
        return getDependencies();
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
      case TrcPackage.TRC_SPECIFICATION__TRANSFORMATIONS:
        setTransformations((TransformationList)newValue);
        return;
      case TrcPackage.TRC_SPECIFICATION__DEPENDENCIES:
        setDependencies((TransformationDependencyList)newValue);
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
      case TrcPackage.TRC_SPECIFICATION__TRANSFORMATIONS:
        setTransformations((TransformationList)null);
        return;
      case TrcPackage.TRC_SPECIFICATION__DEPENDENCIES:
        setDependencies((TransformationDependencyList)null);
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
      case TrcPackage.TRC_SPECIFICATION__TRANSFORMATIONS:
        return transformations != null;
      case TrcPackage.TRC_SPECIFICATION__DEPENDENCIES:
        return dependencies != null;
    }
    return super.eIsSet(featureID);
  }

} //TrcSpecificationImpl
