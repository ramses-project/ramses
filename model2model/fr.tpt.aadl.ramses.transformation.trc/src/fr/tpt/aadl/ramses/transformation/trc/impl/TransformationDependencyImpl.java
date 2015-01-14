/**
 */
package fr.tpt.aadl.ramses.transformation.trc.impl;

import fr.tpt.aadl.ramses.transformation.trc.AbstractRuleDependency;
import fr.tpt.aadl.ramses.transformation.trc.Transformation;
import fr.tpt.aadl.ramses.transformation.trc.TransformationDependency;
import fr.tpt.aadl.ramses.transformation.trc.TrcPackage;

import fr.tpt.aadl.ramses.transformation.trc.TrcRule;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.EObjectImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;
import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Transformation Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationDependencyImpl#getVariableId <em>Variable Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationDependencyImpl#getAppliedTransformation <em>Applied Transformation</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationDependencyImpl#getRequiredTransformations <em>Required Transformations</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.TransformationDependencyImpl#getAppliedRule <em>Applied Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class TransformationDependencyImpl extends EObjectImpl implements TransformationDependency
{
  /**
	 * The cached value of the '{@link #getVariableId() <em>Variable Id</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getVariableId()
	 * @generated
	 * @ordered
	 */
  protected EList<String> variableId;

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
	 * The cached value of the '{@link #getRequiredTransformations() <em>Required Transformations</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRequiredTransformations()
	 * @generated
	 * @ordered
	 */
  protected AbstractRuleDependency requiredTransformations;

  /**
	 * The cached value of the '{@link #getAppliedRule() <em>Applied Rule</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getAppliedRule()
	 * @generated
	 * @ordered
	 */
  protected TrcRule appliedRule;

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
		return TrcPackage.Literals.TRANSFORMATION_DEPENDENCY;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<String> getVariableId()
  {
		if (variableId == null) {
			variableId = new EDataTypeUniqueEList<String>(String.class, this, TrcPackage.TRANSFORMATION_DEPENDENCY__VARIABLE_ID);
		}
		return variableId;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Transformation getAppliedTransformation()
  {
		if (appliedTransformation != null && appliedTransformation.eIsProxy()) {
			InternalEObject oldAppliedTransformation = (InternalEObject)appliedTransformation;
			appliedTransformation = (Transformation)eResolveProxy(oldAppliedTransformation);
			if (appliedTransformation != oldAppliedTransformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrcPackage.TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION, oldAppliedTransformation, appliedTransformation));
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
			eNotify(new ENotificationImpl(this, Notification.SET, TrcPackage.TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION, oldAppliedTransformation, appliedTransformation));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public AbstractRuleDependency getRequiredTransformations()
  {
		return requiredTransformations;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetRequiredTransformations(AbstractRuleDependency newRequiredTransformations, NotificationChain msgs) {
		AbstractRuleDependency oldRequiredTransformations = requiredTransformations;
		requiredTransformations = newRequiredTransformations;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, TrcPackage.TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS, oldRequiredTransformations, newRequiredTransformations);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredTransformations(AbstractRuleDependency newRequiredTransformations) {
		if (newRequiredTransformations != requiredTransformations) {
			NotificationChain msgs = null;
			if (requiredTransformations != null)
				msgs = ((InternalEObject)requiredTransformations).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - TrcPackage.TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS, null, msgs);
			if (newRequiredTransformations != null)
				msgs = ((InternalEObject)newRequiredTransformations).eInverseAdd(this, EOPPOSITE_FEATURE_BASE - TrcPackage.TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS, null, msgs);
			msgs = basicSetRequiredTransformations(newRequiredTransformations, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrcPackage.TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS, newRequiredTransformations, newRequiredTransformations));
	}

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public TrcRule getAppliedRule()
  {
		if (appliedRule != null && appliedRule.eIsProxy()) {
			InternalEObject oldAppliedRule = (InternalEObject)appliedRule;
			appliedRule = (TrcRule)eResolveProxy(oldAppliedRule);
			if (appliedRule != oldAppliedRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrcPackage.TRANSFORMATION_DEPENDENCY__APPLIED_RULE, oldAppliedRule, appliedRule));
			}
		}
		return appliedRule;
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrcRule basicGetAppliedRule() {
		return appliedRule;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAppliedRule(TrcRule newAppliedRule) {
		TrcRule oldAppliedRule = appliedRule;
		appliedRule = newAppliedRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrcPackage.TRANSFORMATION_DEPENDENCY__APPLIED_RULE, oldAppliedRule, appliedRule));
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
			case TrcPackage.TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS:
				return basicSetRequiredTransformations(null, msgs);
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
			case TrcPackage.TRANSFORMATION_DEPENDENCY__VARIABLE_ID:
				return getVariableId();
			case TrcPackage.TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION:
				if (resolve) return getAppliedTransformation();
				return basicGetAppliedTransformation();
			case TrcPackage.TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS:
				return getRequiredTransformations();
			case TrcPackage.TRANSFORMATION_DEPENDENCY__APPLIED_RULE:
				if (resolve) return getAppliedRule();
				return basicGetAppliedRule();
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
			case TrcPackage.TRANSFORMATION_DEPENDENCY__VARIABLE_ID:
				getVariableId().clear();
				getVariableId().addAll((Collection<? extends String>)newValue);
				return;
			case TrcPackage.TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION:
				setAppliedTransformation((Transformation)newValue);
				return;
			case TrcPackage.TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS:
				setRequiredTransformations((AbstractRuleDependency)newValue);
				return;
			case TrcPackage.TRANSFORMATION_DEPENDENCY__APPLIED_RULE:
				setAppliedRule((TrcRule)newValue);
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
			case TrcPackage.TRANSFORMATION_DEPENDENCY__VARIABLE_ID:
				getVariableId().clear();
				return;
			case TrcPackage.TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION:
				setAppliedTransformation((Transformation)null);
				return;
			case TrcPackage.TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS:
				setRequiredTransformations((AbstractRuleDependency)null);
				return;
			case TrcPackage.TRANSFORMATION_DEPENDENCY__APPLIED_RULE:
				setAppliedRule((TrcRule)null);
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
			case TrcPackage.TRANSFORMATION_DEPENDENCY__VARIABLE_ID:
				return variableId != null && !variableId.isEmpty();
			case TrcPackage.TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION:
				return appliedTransformation != null;
			case TrcPackage.TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS:
				return requiredTransformations != null;
			case TrcPackage.TRANSFORMATION_DEPENDENCY__APPLIED_RULE:
				return appliedRule != null;
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
		result.append(" (variableId: ");
		result.append(variableId);
		result.append(')');
		return result.toString();
	}

} //TransformationDependencyImpl
