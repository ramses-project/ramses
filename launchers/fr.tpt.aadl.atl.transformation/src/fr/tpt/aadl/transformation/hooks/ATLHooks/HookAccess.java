/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.transformation.hooks.ATLHooks ;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;

import fr.tpt.aadl.resources.manager.PredefinedPackagesManager ;

import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EObject ;

import org.osate.aadl2.ComponentType ;
import org.osate.aadl2.DirectedFeature ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ThreadImplementation ;
import org.osate.aadl2.instance.InstanceObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hook Access</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see fr.tpt.aadl.transformation.hooks.ATLHooks.ATLHooksPackage#getHookAccess()
 * @model
 * @generated
 */
public interface HookAccess extends EObject
{

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model required="true" threadImplRequired="true"
   * @generated NOT
   */
  void setPredefinedPackagesManager(PredefinedPackagesManager p) ;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model required="true" threadImplRequired="true"
	 * @generated
	 */
  BehaviorAnnex createBehaviorAnnex(ThreadImplementation threadImpl) ;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model featureRequired="true"
	 * @generated
	 */
  void setDirectionIn(DirectedFeature feature) ;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model baRequired="true"
	 * @generated
	 */
  void resolveBANames(BehaviorAnnex ba) ;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model
	 * @generated
	 */
  EList<Feature> orderFeatures(ComponentType cpt) ;

  /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model targetRequired="true" sourceRequired="true"
	 * @generated
	 */
  void copyLocationReference(Element target,
                             Element source) ;

		/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model targetDeclarativeRequired="true" sourceInstanceRequired="true"
	 * @generated
	 */
	void addTransformationBackTrace(NamedElement targetDeclarative, InstanceObject sourceInstance);

} // HookAccess
