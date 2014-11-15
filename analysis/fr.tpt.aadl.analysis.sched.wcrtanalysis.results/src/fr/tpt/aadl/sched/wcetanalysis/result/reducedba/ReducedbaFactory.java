/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.sched.wcetanalysis.result.reducedba;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage
 * @generated
 */
public interface ReducedbaFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	ReducedbaFactory eINSTANCE = fr.tpt.aadl.sched.wcetanalysis.result.reducedba.impl.ReducedbaFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Computation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Computation</em>'.
	 * @generated
	 */
	Computation createComputation();

	/**
	 * Returns a new object of class '<em>Critical Section Begin</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Critical Section Begin</em>'.
	 * @generated
	 */
	CriticalSectionBegin createCriticalSectionBegin();

	/**
	 * Returns a new object of class '<em>Critical Section End</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Critical Section End</em>'.
	 * @generated
	 */
	CriticalSectionEnd createCriticalSectionEnd();

	/**
	 * Returns a new object of class '<em>Reduced Thread BA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Reduced Thread BA</em>'.
	 * @generated
	 */
	ReducedThreadBA createReducedThreadBA();

	/**
	 * Returns a new object of class '<em>Analysis Model</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Analysis Model</em>'.
	 * @generated
	 */
	AnalysisModel createAnalysisModel();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	ReducedbaPackage getReducedbaPackage();

} //ReducedbaFactory
