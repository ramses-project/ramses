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

package fr.tpt.aadl.ramses.control.atl.hooks ;

import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EObject ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentType ;
import org.osate.aadl2.DirectedFeature ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Port ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.StringLiteral ;
import org.osate.aadl2.instance.FeatureInstance ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorElement ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BehaviorTransition ;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Hook Access</b></em>'.
 * <!-- end-user-doc -->
 *
 *
 * @see fr.tpt.aadl.ramses.control.atl.hooks.AtlHooksPackage#getHookAccess()
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
	long getHyperperiod(FeatureInstance port);
	
				/**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model dataType="org.osate.aadl2.String" required="true" namedElementRequired="true"
   * @generated
   */
  String getTimingPrecision(NamedElement namedElement);

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
   * @model featureRequired="true" directionDataType="org.osate.ba.aadlba.String"
   * @generated
   */
	void setDirection(DirectedFeature feature, String direction);
	
	/**
   * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
   * @model dataType="org.osate.aadl2.Boolean" required="true" baRequired="true" operatorNameDataType="org.osate.aadl2.String" operatorNameRequired="true"
   * @generated
   */
	boolean isUsedInSpecialOperator(BehaviorAnnex ba, Port p, String operatorName);

	
	NamedElement getElement(NamedElement ne);
	
	public String getOutputPackageName();
	  
	public void setOutputPackageName(String param);

	public EList<String> getListOfPath(PropertyAssociation pa);
	
	public Integer minus (Long lhs, Long rhs);
	
	public EList<Port> allPortCount(BehaviorElement e);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model required="true" paRequired="true" stringLiteralValueDataType="org.osate.aadl2.String" stringLiteralValueRequired="true"
   * @generated
   */
  StringLiteral getStringLiteral(PropertyAssociation pah, String stringLiteralValue);

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @model required="true" classifierRequired="true"
   * @generated
   */
  PropertyAssociation getEnumerators(Classifier classifier);
	
} // HookAccess