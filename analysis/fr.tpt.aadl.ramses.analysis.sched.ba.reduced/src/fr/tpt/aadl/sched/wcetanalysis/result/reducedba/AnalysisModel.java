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

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Analysis Model</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * <ul>
 *   <li>{@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel#getThreadsBA <em>Threads BA</em>}</li>
 * </ul>
 * </p>
 *
 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage#getAnalysisModel()
 * @model
 * @generated
 */
public interface AnalysisModel extends EObject {
	/**
	 * Returns the value of the '<em><b>Threads BA</b></em>' containment reference list.
	 * The list contents are of type {@link fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA}.
	 * <!-- begin-user-doc -->
	 * <p>
	 * If the meaning of the '<em>Threads BA</em>' containment reference list isn't clear,
	 * there really should be more of a description here...
	 * </p>
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Threads BA</em>' containment reference list.
	 * @see fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedbaPackage#getAnalysisModel_ThreadsBA()
	 * @model containment="true" required="true"
	 * @generated
	 */
	EList<ReducedThreadBA> getThreadsBA();

} // AnalysisModel
