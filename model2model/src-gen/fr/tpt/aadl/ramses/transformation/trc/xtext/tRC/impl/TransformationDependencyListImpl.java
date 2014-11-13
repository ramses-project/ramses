/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependencyList;

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
 * An implementation of the model object '<em><b>Transformation Dependency List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationDependencyListImpl#getName <em>Name</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TransformationDependencyListImpl#getTransformationDependencies <em>Transformation Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationDependencyListImpl extends MinimalEObjectImpl.Container implements TransformationDependencyList
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
   * The cached value of the '{@link #getTransformationDependencies() <em>Transformation Dependencies</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransformationDependencies()
   * @generated
   * @ordered
   */
  protected EList<TransformationDependency> transformationDependencies;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TransformationDependencyListImpl()
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
    return TRCPackage.Literals.TRANSFORMATION_DEPENDENCY_LIST;
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
      eNotify(new ENotificationImpl(this, Notification.SET, TRCPackage.TRANSFORMATION_DEPENDENCY_LIST__NAME, oldName, name));
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TransformationDependency> getTransformationDependencies()
  {
    if (transformationDependencies == null)
    {
      transformationDependencies = new EObjectContainmentEList<TransformationDependency>(TransformationDependency.class, this, TRCPackage.TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES);
    }
    return transformationDependencies;
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
      case TRCPackage.TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES:
        return ((InternalEList<?>)getTransformationDependencies()).basicRemove(otherEnd, msgs);
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
      case TRCPackage.TRANSFORMATION_DEPENDENCY_LIST__NAME:
        return getName();
      case TRCPackage.TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES:
        return getTransformationDependencies();
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
      case TRCPackage.TRANSFORMATION_DEPENDENCY_LIST__NAME:
        setName((String)newValue);
        return;
      case TRCPackage.TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES:
        getTransformationDependencies().clear();
        getTransformationDependencies().addAll((Collection<? extends TransformationDependency>)newValue);
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
      case TRCPackage.TRANSFORMATION_DEPENDENCY_LIST__NAME:
        setName(NAME_EDEFAULT);
        return;
      case TRCPackage.TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES:
        getTransformationDependencies().clear();
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
      case TRCPackage.TRANSFORMATION_DEPENDENCY_LIST__NAME:
        return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
      case TRCPackage.TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES:
        return transformationDependencies != null && !transformationDependencies.isEmpty();
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

} //TransformationDependencyListImpl
