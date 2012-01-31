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
package fr.tpt.aadl.ramses.transformation.atl.hooks;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.ramses.transformation.atl.hooks.AtlHooksFactory
 * @model kind="package"
 * @generated
 */
public interface AtlHooksPackage extends EPackage
{
  /**
   * The package name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNAME = "hooks";

  /**
   * The package namespace URI.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_URI = "http://fr.tpt.aadl.ramses.transformation.atl.launch";

  /**
   * The package namespace name.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  String eNS_PREFIX = "hooks";

  /**
   * The singleton instance of the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  AtlHooksPackage eINSTANCE = fr.tpt.aadl.ramses.transformation.atl.hooks.impl.AtlHooksPackageImpl.init();

  /**
   * The meta object id for the '{@link fr.tpt.aadl.ramses.transformation.atl.hooks.impl.HookAccessImpl <em>Hook Access</em>}' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see fr.tpt.aadl.ramses.transformation.atl.hooks.impl.HookAccessImpl
   * @see fr.tpt.aadl.ramses.transformation.atl.hooks.impl.AtlHooksPackageImpl#getHookAccess()
   * @generated
   */
  int HOOK_ACCESS = 0;

  /**
   * The number of structural features of the '<em>Hook Access</em>' class.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   * @ordered
   */
  int HOOK_ACCESS_FEATURE_COUNT = 0;


  /**
   * Returns the meta object for class '{@link fr.tpt.aadl.ramses.transformation.atl.hooks.HookAccess <em>Hook Access</em>}'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the meta object for class '<em>Hook Access</em>'.
   * @see fr.tpt.aadl.ramses.transformation.atl.hooks.HookAccess
   * @generated
   */
  EClass getHookAccess();

  /**
   * Returns the factory that creates the instances of the model.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the factory that creates the instances of the model.
   * @generated
   */
  AtlHooksFactory getAtlHooksFactory();

  /**
   * <!-- begin-user-doc -->
   * Defines literals for the meta objects that represent
   * <ul>
   *   <li>each class,</li>
   *   <li>each feature of each class,</li>
   *   <li>each enum,</li>
   *   <li>and each data type</li>
   * </ul>
   * <!-- end-user-doc -->
   * @generated
   */
  interface Literals
  {
    /**
     * The meta object literal for the '{@link fr.tpt.aadl.ramses.transformation.atl.hooks.impl.HookAccessImpl <em>Hook Access</em>}' class.
     * <!-- begin-user-doc -->
     * <!-- end-user-doc -->
     * @see fr.tpt.aadl.ramses.transformation.atl.hooks.impl.HookAccessImpl
     * @see fr.tpt.aadl.ramses.transformation.atl.hooks.impl.AtlHooksPackageImpl#getHookAccess()
     * @generated
     */
    EClass HOOK_ACCESS = eINSTANCE.getHookAccess();

  }

} //AtlHooksPackage
