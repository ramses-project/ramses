/**
 */
package fr.tpt.aadl.ramses.transformation.trc;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Transformation Impact</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.TransformationImpact#getImpactValue <em>Impact Value</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.TransformationImpact#getQualityAttributeName <em>Quality Attribute Name</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTransformationImpact()
 * @model
 * @generated
 */
public interface TransformationImpact extends TransformationElement
{
  /**
	 * Returns the value of the '<em><b>Impact Value</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Impact Value</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Impact Value</em>' attribute.
	 * @see #setImpactValue(int)
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTransformationImpact_ImpactValue()
	 * @model required="true"
	 * @generated
	 */
  int getImpactValue();

  /**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationImpact#getImpactValue <em>Impact Value</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Impact Value</em>' attribute.
	 * @see #getImpactValue()
	 * @generated
	 */
  void setImpactValue(int value);

  /**
	 * Returns the value of the '<em><b>Quality Attribute Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Quality Attribute Name</em>' attribute isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Quality Attribute Name</em>' attribute.
	 * @see #setQualityAttributeName(String)
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTransformationImpact_QualityAttributeName()
	 * @model
	 * @generated
	 */
  String getQualityAttributeName();

  /**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.TransformationImpact#getQualityAttributeName <em>Quality Attribute Name</em>}' attribute.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Quality Attribute Name</em>' attribute.
	 * @see #getQualityAttributeName()
	 * @generated
	 */
  void setQualityAttributeName(String value);

} // TransformationImpact
