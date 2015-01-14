/**
 */
package fr.tpt.aadl.ramses.transformation.trc;

import java.util.List ;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;

import fr.tpt.aadl.ramses.transformation.trc.util.TaggedRuleApplicationTuple ;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Specification</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.TrcSpecification#getTransformationList <em>Transformation List</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.TrcSpecification#getDependencyList <em>Dependency List</em>}</li>
 *   <li>{@link fr.tpt.aadl.ramses.transformation.trc.TrcSpecification#getModuleList <em>Module List</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTrcSpecification()
 * @model
 * @generated
 */
public interface TrcSpecification extends EObject
{
  /**
	 * Returns the value of the '<em><b>Transformation List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Transformation List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Transformation List</em>' containment reference.
	 * @see #setTransformationList(TransformationList)
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTrcSpecification_TransformationList()
	 * @model containment="true" required="true"
	 * @generated
	 */
  TransformationList getTransformationList();

  /**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.TrcSpecification#getTransformationList <em>Transformation List</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Transformation List</em>' containment reference.
	 * @see #getTransformationList()
	 * @generated
	 */
  void setTransformationList(TransformationList value);

  /**
	 * Returns the value of the '<em><b>Dependency List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Dependency List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Dependency List</em>' containment reference.
	 * @see #setDependencyList(TransformationDependencyList)
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTrcSpecification_DependencyList()
	 * @model containment="true" required="true"
	 * @generated
	 */
  TransformationDependencyList getDependencyList();

  /**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.TrcSpecification#getDependencyList <em>Dependency List</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Dependency List</em>' containment reference.
	 * @see #getDependencyList()
	 * @generated
	 */
  void setDependencyList(TransformationDependencyList value);

  /**
	 * Returns the value of the '<em><b>Module List</b></em>' containment reference.
	 * <!-- begin-user-doc -->
   * <p>
   * If the meaning of the '<em>Module List</em>' containment reference isn't clear,
   * there really should be more of a description here...
   * </p>
   * <!-- end-user-doc -->
	 * @return the value of the '<em>Module List</em>' containment reference.
	 * @see #setModuleList(ModuleList)
	 * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#getTrcSpecification_ModuleList()
	 * @model containment="true" required="true"
	 * @generated
	 */
  ModuleList getModuleList();

  /**
	 * Sets the value of the '{@link fr.tpt.aadl.ramses.transformation.trc.TrcSpecification#getModuleList <em>Module List</em>}' containment reference.
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Module List</em>' containment reference.
	 * @see #getModuleList()
	 * @generated
	 */
  void setModuleList(ModuleList value);

  /**
   * 
   * @generated NOT
   */
  TrcRule getTrcRule(String value) ;

  List<List<TaggedRuleApplicationTuple>>
      getNormalizedDependencies(List<EObject> eObjList, TrcRule appliedRule) ;

  void
      addNormalizedDependencies(List<EObject> eObjList, 
                                TrcRule appliedRule,
                                List<List<TaggedRuleApplicationTuple>> dep) ;
  
  void cleanup();
  
} // TrcSpecification
