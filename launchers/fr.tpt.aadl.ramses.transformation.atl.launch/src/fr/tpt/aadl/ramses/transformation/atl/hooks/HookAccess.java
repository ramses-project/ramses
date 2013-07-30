/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

/**
 * <copyright>
 * </copyright>
 *
 * $Id$
 */
package fr.tpt.aadl.ramses.transformation.atl.hooks ;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.ComponentType;
import org.osate.aadl2.DirectedFeature;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Port;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceObject;

import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hook Access</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see fr.tpt.aadl.ramses.transformation.atl.hooks.AtlHooksPackage#getHookAccess()
 * @model
 * @generated
 */
public interface HookAccess extends EObject
{

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
  void addTransformationBackTrace(NamedElement targetDeclarative, NamedElement sourceInstance);

    /**
	 * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
	 * @model stateRequired="true" transitionRequired="true"
	 * @generated
	 */
  void putTransitionWhereSrc(BehaviorState state, BehaviorTransition transition);

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model portRequired="true"
	 * @generated
	 */
	EList<Long> getCurrentPerionReadTable(FeatureInstance port);
	
	/**
	* <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model portRequired="true"
	 * @generated
	 */
	Long getHyperperiod(FeatureInstance port);
	
				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model portRequired="true"
	 * @generated
	 */
	EList<Long> getCurrentDeadlineWriteTable(FeatureInstance port, FeatureInstance destinationPort);

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model required="true" destinationFeatureInstanceRequired="true"
	 * @generated
	 */
	long getBufferSize(FeatureInstance destinationFeatureInstance);

				/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model featureRequired="true"
	 * @generated
	 */
	void setDirection(DirectedFeature feature, String direction);
	
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	Boolean isUsedInFreshClause(BehaviorAnnex ba, Port p);


} // HookAccess