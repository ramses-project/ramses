/**
 */
package fr.tpt.aadl.ramses.transformation.trc.impl;

import fr.tpt.aadl.ramses.transformation.trc.DependencyType;
import fr.tpt.aadl.ramses.transformation.trc.RuleDependency;
import fr.tpt.aadl.ramses.transformation.trc.Transformation;
import fr.tpt.aadl.ramses.transformation.trc.TrcPackage;

import fr.tpt.aadl.ramses.transformation.trc.TrcRule;
import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EDataTypeUniqueEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Rule Dependency</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyImpl#getVariableId <em>Variable Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyImpl#getFieldNames <em>Field Names</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyImpl#getRequiredTransformation <em>Required Transformation</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyImpl#isIsExclusion <em>Is Exclusion</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyImpl#getType <em>Type</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.impl.RuleDependencyImpl#getRequiredRule <em>Required Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @generated
 */
public class RuleDependencyImpl extends AbstractRuleDependencyImpl implements RuleDependency
{
  /**
	 * The default value of the '{@link #getVariableId() <em>Variable Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getVariableId()
	 * @generated
	 * @ordered
	 */
  protected static final int VARIABLE_ID_EDEFAULT = 0;

  /**
	 * The cached value of the '{@link #getVariableId() <em>Variable Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getVariableId()
	 * @generated
	 * @ordered
	 */
  protected int variableId = VARIABLE_ID_EDEFAULT;

  /**
	 * The cached value of the '{@link #getFieldNames() <em>Field Names</em>}' attribute list.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getFieldNames()
	 * @generated
	 * @ordered
	 */
  protected EList<String> fieldNames;

  /**
	 * The cached value of the '{@link #getRequiredTransformation() <em>Required Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #getRequiredTransformation()
	 * @generated
	 * @ordered
	 */
  protected Transformation requiredTransformation;

  /**
	 * The default value of the '{@link #isIsExclusion() <em>Is Exclusion</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isIsExclusion()
	 * @generated
	 * @ordered
	 */
  protected static final boolean IS_EXCLUSION_EDEFAULT = false;

  /**
	 * The cached value of the '{@link #isIsExclusion() <em>Is Exclusion</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @see #isIsExclusion()
	 * @generated
	 * @ordered
	 */
  protected boolean isExclusion = IS_EXCLUSION_EDEFAULT;

  /**
	 * The default value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated NOT
	 * @ordered
	 */
	protected static final String TYPE_EDEFAULT = "requires";

		/**
	 * The cached value of the '{@link #getType() <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getType()
	 * @generated
	 * @ordered
	 */
	protected String type = TYPE_EDEFAULT;

		/**
	 * The cached value of the '{@link #getRequiredRule() <em>Required Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRequiredRule()
	 * @generated
	 * @ordered
	 */
	protected TrcRule requiredRule;

		/**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  protected RuleDependencyImpl()
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
		return TrcPackage.Literals.RULE_DEPENDENCY;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public int getVariableId()
  {
		return variableId;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setVariableId(int newVariableId)
  {
		int oldVariableId = variableId;
		variableId = newVariableId;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrcPackage.RULE_DEPENDENCY__VARIABLE_ID, oldVariableId, variableId));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public EList<String> getFieldNames()
  {
		if (fieldNames == null) {
			fieldNames = new EDataTypeUniqueEList<String>(String.class, this, TrcPackage.RULE_DEPENDENCY__FIELD_NAMES);
		}
		return fieldNames;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Transformation getRequiredTransformation()
  {
		if (requiredTransformation != null && requiredTransformation.eIsProxy()) {
			InternalEObject oldRequiredTransformation = (InternalEObject)requiredTransformation;
			requiredTransformation = (Transformation)eResolveProxy(oldRequiredTransformation);
			if (requiredTransformation != oldRequiredTransformation) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrcPackage.RULE_DEPENDENCY__REQUIRED_TRANSFORMATION, oldRequiredTransformation, requiredTransformation));
			}
		}
		return requiredTransformation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public Transformation basicGetRequiredTransformation()
  {
		return requiredTransformation;
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setRequiredTransformation(Transformation newRequiredTransformation)
  {
		Transformation oldRequiredTransformation = requiredTransformation;
		requiredTransformation = newRequiredTransformation;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrcPackage.RULE_DEPENDENCY__REQUIRED_TRANSFORMATION, oldRequiredTransformation, requiredTransformation));
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated NOT
	 */
  public boolean isIsExclusion()
  {
		return isExclusion();
	}

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @generated
	 */
  public void setIsExclusion(boolean newIsExclusion)
  {
		boolean oldIsExclusion = isExclusion;
		isExclusion = newIsExclusion;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrcPackage.RULE_DEPENDENCY__IS_EXCLUSION, oldIsExclusion, isExclusion));
	}

  /**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getType() {
		return type;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setType(String newType) {
		String oldType = type;
		type = newType;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrcPackage.RULE_DEPENDENCY__TYPE, oldType, type));
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrcRule getRequiredRule() {
		if (requiredRule != null && requiredRule.eIsProxy()) {
			InternalEObject oldRequiredRule = (InternalEObject)requiredRule;
			requiredRule = (TrcRule)eResolveProxy(oldRequiredRule);
			if (requiredRule != oldRequiredRule) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, TrcPackage.RULE_DEPENDENCY__REQUIRED_RULE, oldRequiredRule, requiredRule));
			}
		}
		return requiredRule;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrcRule basicGetRequiredRule() {
		return requiredRule;
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRequiredRule(TrcRule newRequiredRule) {
		TrcRule oldRequiredRule = requiredRule;
		requiredRule = newRequiredRule;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, TrcPackage.RULE_DEPENDENCY__REQUIRED_RULE, oldRequiredRule, requiredRule));
	}

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated NOT
	 */
	public boolean isExclusion() {
		return type.equalsIgnoreCase("excludes");
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
			case TrcPackage.RULE_DEPENDENCY__VARIABLE_ID:
				return getVariableId();
			case TrcPackage.RULE_DEPENDENCY__FIELD_NAMES:
				return getFieldNames();
			case TrcPackage.RULE_DEPENDENCY__REQUIRED_TRANSFORMATION:
				if (resolve) return getRequiredTransformation();
				return basicGetRequiredTransformation();
			case TrcPackage.RULE_DEPENDENCY__IS_EXCLUSION:
				return isIsExclusion();
			case TrcPackage.RULE_DEPENDENCY__TYPE:
				return getType();
			case TrcPackage.RULE_DEPENDENCY__REQUIRED_RULE:
				if (resolve) return getRequiredRule();
				return basicGetRequiredRule();
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
			case TrcPackage.RULE_DEPENDENCY__VARIABLE_ID:
				setVariableId((Integer)newValue);
				return;
			case TrcPackage.RULE_DEPENDENCY__FIELD_NAMES:
				getFieldNames().clear();
				getFieldNames().addAll((Collection<? extends String>)newValue);
				return;
			case TrcPackage.RULE_DEPENDENCY__REQUIRED_TRANSFORMATION:
				setRequiredTransformation((Transformation)newValue);
				return;
			case TrcPackage.RULE_DEPENDENCY__IS_EXCLUSION:
				setIsExclusion((Boolean)newValue);
				return;
			case TrcPackage.RULE_DEPENDENCY__TYPE:
				setType((String)newValue);
				return;
			case TrcPackage.RULE_DEPENDENCY__REQUIRED_RULE:
				setRequiredRule((TrcRule)newValue);
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
			case TrcPackage.RULE_DEPENDENCY__VARIABLE_ID:
				setVariableId(VARIABLE_ID_EDEFAULT);
				return;
			case TrcPackage.RULE_DEPENDENCY__FIELD_NAMES:
				getFieldNames().clear();
				return;
			case TrcPackage.RULE_DEPENDENCY__REQUIRED_TRANSFORMATION:
				setRequiredTransformation((Transformation)null);
				return;
			case TrcPackage.RULE_DEPENDENCY__IS_EXCLUSION:
				setIsExclusion(IS_EXCLUSION_EDEFAULT);
				return;
			case TrcPackage.RULE_DEPENDENCY__TYPE:
				setType(TYPE_EDEFAULT);
				return;
			case TrcPackage.RULE_DEPENDENCY__REQUIRED_RULE:
				setRequiredRule((TrcRule)null);
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
			case TrcPackage.RULE_DEPENDENCY__VARIABLE_ID:
				return variableId != VARIABLE_ID_EDEFAULT;
			case TrcPackage.RULE_DEPENDENCY__FIELD_NAMES:
				return fieldNames != null && !fieldNames.isEmpty();
			case TrcPackage.RULE_DEPENDENCY__REQUIRED_TRANSFORMATION:
				return requiredTransformation != null;
			case TrcPackage.RULE_DEPENDENCY__IS_EXCLUSION:
				return isExclusion != IS_EXCLUSION_EDEFAULT;
			case TrcPackage.RULE_DEPENDENCY__TYPE:
				return TYPE_EDEFAULT == null ? type != null : !TYPE_EDEFAULT.equals(type);
			case TrcPackage.RULE_DEPENDENCY__REQUIRED_RULE:
				return requiredRule != null;
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
		result.append(", fieldNames: ");
		result.append(fieldNames);
		result.append(", isExclusion: ");
		result.append(isExclusion);
		result.append(", type: ");
		result.append(type);
		result.append(')');
		return result.toString();
	}

} //RuleDependencyImpl
