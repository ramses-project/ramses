/**
 */
package org.trc.xtext.dsl.dsl.impl;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

import org.trc.xtext.dsl.dsl.DslPackage;
import org.trc.xtext.dsl.dsl.From;
import org.trc.xtext.dsl.dsl.ModuleList;
import org.trc.xtext.dsl.dsl.TransformationDependencyList;
import org.trc.xtext.dsl.dsl.TransformationList;
import org.trc.xtext.dsl.dsl.TrcSpecification;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Trc Specification</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link org.trc.xtext.dsl.dsl.impl.TrcSpecificationImpl#getFroms <em>Froms</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.impl.TrcSpecificationImpl#getModuleList <em>Module List</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.impl.TrcSpecificationImpl#getTransformationList <em>Transformation List</em>}</li>
 *   <li>{@link org.trc.xtext.dsl.dsl.impl.TrcSpecificationImpl#getDependencyList <em>Dependency List</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TrcSpecificationImpl extends MinimalEObjectImpl.Container implements TrcSpecification
{
  /**
   * The cached value of the '{@link #getFroms() <em>Froms</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getFroms()
   * @generated
   * @ordered
   */
  protected EList<From> froms;

  /**
   * The cached value of the '{@link #getModuleList() <em>Module List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getModuleList()
   * @generated
   * @ordered
   */
  protected EList<ModuleList> moduleList;

  /**
   * The cached value of the '{@link #getTransformationList() <em>Transformation List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getTransformationList()
   * @generated
   * @ordered
   */
  protected EList<TransformationList> transformationList;

  /**
   * The cached value of the '{@link #getDependencyList() <em>Dependency List</em>}' containment reference list.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #getDependencyList()
   * @generated
   * @ordered
   */
  protected EList<TransformationDependencyList> dependencyList;

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
    return DslPackage.Literals.TRC_SPECIFICATION;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<From> getFroms()
  {
    if (froms == null)
    {
      froms = new EObjectContainmentEList<From>(From.class, this, DslPackage.TRC_SPECIFICATION__FROMS);
    }
    return froms;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<ModuleList> getModuleList()
  {
    if (moduleList == null)
    {
      moduleList = new EObjectContainmentEList<ModuleList>(ModuleList.class, this, DslPackage.TRC_SPECIFICATION__MODULE_LIST);
    }
    return moduleList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TransformationList> getTransformationList()
  {
    if (transformationList == null)
    {
      transformationList = new EObjectContainmentEList<TransformationList>(TransformationList.class, this, DslPackage.TRC_SPECIFICATION__TRANSFORMATION_LIST);
    }
    return transformationList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EList<TransformationDependencyList> getDependencyList()
  {
    if (dependencyList == null)
    {
      dependencyList = new EObjectContainmentEList<TransformationDependencyList>(TransformationDependencyList.class, this, DslPackage.TRC_SPECIFICATION__DEPENDENCY_LIST);
    }
    return dependencyList;
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
      case DslPackage.TRC_SPECIFICATION__FROMS:
        return ((InternalEList<?>)getFroms()).basicRemove(otherEnd, msgs);
      case DslPackage.TRC_SPECIFICATION__MODULE_LIST:
        return ((InternalEList<?>)getModuleList()).basicRemove(otherEnd, msgs);
      case DslPackage.TRC_SPECIFICATION__TRANSFORMATION_LIST:
        return ((InternalEList<?>)getTransformationList()).basicRemove(otherEnd, msgs);
      case DslPackage.TRC_SPECIFICATION__DEPENDENCY_LIST:
        return ((InternalEList<?>)getDependencyList()).basicRemove(otherEnd, msgs);
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
      case DslPackage.TRC_SPECIFICATION__FROMS:
        return getFroms();
      case DslPackage.TRC_SPECIFICATION__MODULE_LIST:
        return getModuleList();
      case DslPackage.TRC_SPECIFICATION__TRANSFORMATION_LIST:
        return getTransformationList();
      case DslPackage.TRC_SPECIFICATION__DEPENDENCY_LIST:
        return getDependencyList();
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
      case DslPackage.TRC_SPECIFICATION__FROMS:
        getFroms().clear();
        getFroms().addAll((Collection<? extends From>)newValue);
        return;
      case DslPackage.TRC_SPECIFICATION__MODULE_LIST:
        getModuleList().clear();
        getModuleList().addAll((Collection<? extends ModuleList>)newValue);
        return;
      case DslPackage.TRC_SPECIFICATION__TRANSFORMATION_LIST:
        getTransformationList().clear();
        getTransformationList().addAll((Collection<? extends TransformationList>)newValue);
        return;
      case DslPackage.TRC_SPECIFICATION__DEPENDENCY_LIST:
        getDependencyList().clear();
        getDependencyList().addAll((Collection<? extends TransformationDependencyList>)newValue);
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
      case DslPackage.TRC_SPECIFICATION__FROMS:
        getFroms().clear();
        return;
      case DslPackage.TRC_SPECIFICATION__MODULE_LIST:
        getModuleList().clear();
        return;
      case DslPackage.TRC_SPECIFICATION__TRANSFORMATION_LIST:
        getTransformationList().clear();
        return;
      case DslPackage.TRC_SPECIFICATION__DEPENDENCY_LIST:
        getDependencyList().clear();
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
      case DslPackage.TRC_SPECIFICATION__FROMS:
        return froms != null && !froms.isEmpty();
      case DslPackage.TRC_SPECIFICATION__MODULE_LIST:
        return moduleList != null && !moduleList.isEmpty();
      case DslPackage.TRC_SPECIFICATION__TRANSFORMATION_LIST:
        return transformationList != null && !transformationList.isEmpty();
      case DslPackage.TRC_SPECIFICATION__DEPENDENCY_LIST:
        return dependencyList != null && !dependencyList.isEmpty();
    }
    return super.eIsSet(featureID);
  }

} //TrcSpecificationImpl
