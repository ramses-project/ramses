/**
 */
package fr.tpt.aadl.ramses.transformation.trc.impl;

import fr.tpt.aadl.ramses.transformation.trc.TransformationDependency;
import fr.tpt.aadl.ramses.transformation.trc.TransformationDependencyList;
import fr.tpt.aadl.ramses.transformation.trc.TrcPackage;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation Dependency List</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationDependencyListImpl#getTransformationDependencies <em>Transformation Dependencies</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationDependencyListImpl extends EObjectImpl implements TransformationDependencyList
{
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
		return TrcPackage.Literals.TRANSFORMATION_DEPENDENCY_LIST;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<TransformationDependency> getTransformationDependencies()
  {
		if (transformationDependencies == null) {
			transformationDependencies = new EObjectContainmentEList<TransformationDependency>(TransformationDependency.class, this, TrcPackage.TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES);
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
		switch (featureID) {
			case TrcPackage.TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES:
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
		switch (featureID) {
			case TrcPackage.TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES:
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
		switch (featureID) {
			case TrcPackage.TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES:
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
		switch (featureID) {
			case TrcPackage.TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES:
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
		switch (featureID) {
			case TrcPackage.TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES:
				return transformationDependencies != null && !transformationDependencies.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //TransformationDependencyListImpl
