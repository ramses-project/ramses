/**
 */
package fr.tpt.aadl.ramses.transformation.trc;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Rule Dependency</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getVariableId <em>Variable Id</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getFieldNames <em>Field Names</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getRequiredTransformation <em>Required Transformation</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency#isIsExclusion <em>Is Exclusion</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getType <em>Type</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getRequiredRule <em>Required Rule</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getRuleDependency()
 * @model
 * @generated
 */
public interface RuleDependency extends AbstractRuleDependency
{
  /**
	 * Returns the value of the '<em><b>Variable Id</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Variable Id</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Variable Id</em>' attribute.
	 * @see #setVariableId(int)
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getRuleDependency_VariableId()
	 * @model
	 * @generated
	 */
  int getVariableId();

  /**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getVariableId <em>Variable Id</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Variable Id</em>' attribute.
	 * @see #getVariableId()
	 * @generated
	 */
  void setVariableId(int value);

  /**
	 * Returns the value of the '<em><b>Field Names</b></em>' attribute list.
	 * The list contents are of type {@link java.lang.String}.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Field Names</em>' attribute list isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Field Names</em>' attribute list.
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getRuleDependency_FieldNames()
	 * @model required="true"
	 * @generated
	 */
  EList<String> getFieldNames();

  /**
	 * Returns the value of the '<em><b>Required Transformation</b></em>' reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Required Transformation</em>' reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Transformation</em>' reference.
	 * @see #setRequiredTransformation(Transformation)
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getRuleDependency_RequiredTransformation()
	 * @model
	 * @generated
	 */
  Transformation getRequiredTransformation();

  /**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getRequiredTransformation <em>Required Transformation</em>}' reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Transformation</em>' reference.
	 * @see #getRequiredTransformation()
	 * @generated
	 */
  void setRequiredTransformation(Transformation value);

  /**
	 * Returns the value of the '<em><b>Is Exclusion</b></em>' attribute.
	 * The default value is <code>"false"</code>.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Is Exclusion</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Is Exclusion</em>' attribute.
	 * @see #setIsExclusion(boolean)
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getRuleDependency_IsExclusion()
	 * @model default="false"
	 * @generated
	 */
  boolean isIsExclusion();

  /**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency#isIsExclusion <em>Is Exclusion</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Is Exclusion</em>' attribute.
	 * @see #isIsExclusion()
	 * @generated
	 */
  void setIsExclusion(boolean value);

		/**
	 * Returns the value of the '<em><b>Type</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Type</em>' attribute isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Type</em>' attribute.
	 * @see #setType(String)
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getRuleDependency_Type()
	 * @model required="true"
	 * @generated
	 */
	String getType();

		/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getType <em>Type</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Type</em>' attribute.
	 * @see #getType()
	 * @generated
	 */
	void setType(String value);

		/**
	 * Returns the value of the '<em><b>Required Rule</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Required Rule</em>' reference isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Required Rule</em>' reference.
	 * @see #setRequiredRule(TrcRule)
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getRuleDependency_RequiredRule()
	 * @model required="true"
	 * @generated
	 */
	TrcRule getRequiredRule();

		/**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.RuleDependency#getRequiredRule <em>Required Rule</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Required Rule</em>' reference.
	 * @see #getRequiredRule()
	 * @generated
	 */
	void setRequiredRule(TrcRule value);

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model kind="operation"
	 * @generated
	 */
	boolean isExclusion();

} // RuleDependency
