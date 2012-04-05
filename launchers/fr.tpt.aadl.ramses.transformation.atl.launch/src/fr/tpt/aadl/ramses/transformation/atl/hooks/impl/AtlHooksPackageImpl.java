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
package fr.tpt.aadl.ramses.transformation.atl.hooks.impl;

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage;

import fr.tpt.aadl.ramses.transformation.atl.hooks.AtlHooksFactory;
import fr.tpt.aadl.ramses.transformation.atl.hooks.AtlHooksPackage;
import fr.tpt.aadl.ramses.transformation.atl.hooks.HookAccess;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.osate.aadl2.Aadl2Package;

import org.osate.aadl2.instance.InstancePackage;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class AtlHooksPackageImpl extends EPackageImpl implements AtlHooksPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass hookAccessEClass = null;

  /**
   * Creates an instance of the model <b>Package</b>, registered with
   * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
   * package URI value.
   * <p>Note: the correct way to create the package is via the static
   * factory method {@link #init init()}, which also performs
   * initialization of the package, or returns the registered package,
   * if one already exists.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see org.eclipse.emf.ecore.EPackage.Registry
   * @see fr.tpt.aadl.ramses.transformation.atl.hooks.AtlHooksPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private AtlHooksPackageImpl()
  {
    super(eNS_URI, AtlHooksFactory.eINSTANCE);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private static boolean isInited = false;

  /**
   * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
   * 
   * <p>This method is used to initialize {@link AtlHooksPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static AtlHooksPackage init()
  {
    if (isInited) return (AtlHooksPackage)EPackage.Registry.INSTANCE.getEPackage(AtlHooksPackage.eNS_URI);

    // Obtain or create and register package
    AtlHooksPackageImpl theAtlHooksPackage = (AtlHooksPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof AtlHooksPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new AtlHooksPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    AadlBaPackage.eINSTANCE.eClass();
    InstancePackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theAtlHooksPackage.createPackageContents();

    // Initialize created meta-data
    theAtlHooksPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theAtlHooksPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(AtlHooksPackage.eNS_URI, theAtlHooksPackage);
    return theAtlHooksPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getHookAccess()
  {
    return hookAccessEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public AtlHooksFactory getAtlHooksFactory()
  {
    return (AtlHooksFactory)getEFactoryInstance();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isCreated = false;

  /**
   * Creates the meta-model objects for the package.  This method is
   * guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void createPackageContents()
  {
    if (isCreated) return;
    isCreated = true;

    // Create classes and their features
    hookAccessEClass = createEClass(HOOK_ACCESS);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private boolean isInitialized = false;

  /**
   * Complete the initialization of the package and its meta-model.  This
   * method is guarded to have no affect on any invocation but its first.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public void initializePackageContents()
  {
    if (isInitialized) return;
    isInitialized = true;

    // Initialize package
    setName(eNAME);
    setNsPrefix(eNS_PREFIX);
    setNsURI(eNS_URI);

    // Obtain other dependent packages
    AadlBaPackage theAadlBaPackage = (AadlBaPackage)EPackage.Registry.INSTANCE.getEPackage(AadlBaPackage.eNS_URI);
    Aadl2Package theAadl2Package = (Aadl2Package)EPackage.Registry.INSTANCE.getEPackage(Aadl2Package.eNS_URI);
    InstancePackage theInstancePackage = (InstancePackage)EPackage.Registry.INSTANCE.getEPackage(InstancePackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes

    // Initialize classes and features; add operations and parameters
    initEClass(hookAccessEClass, HookAccess.class, "HookAccess", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    EOperation op = addEOperation(hookAccessEClass, theAadlBaPackage.getBehaviorAnnex(), "createBehaviorAnnex", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getThreadImplementation(), "threadImpl", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = addEOperation(hookAccessEClass, null, "setDirectionIn", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getDirectedFeature(), "feature", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = addEOperation(hookAccessEClass, null, "resolveBANames", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadlBaPackage.getBehaviorAnnex(), "ba", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = addEOperation(hookAccessEClass, theAadl2Package.getFeature(), "orderFeatures", 0, -1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getComponentType(), "cpt", 0, 1, IS_UNIQUE, IS_ORDERED);

    op = addEOperation(hookAccessEClass, null, "copyLocationReference", 0, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getElement(), "target", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getElement(), "source", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = addEOperation(hookAccessEClass, null, "addTransformationBackTrace", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadl2Package.getNamedElement(), "targetDeclarative", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theInstancePackage.getInstanceObject(), "sourceInstance", 1, 1, IS_UNIQUE, IS_ORDERED);

    op = addEOperation(hookAccessEClass, null, "putTransitionWhereSrc", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadlBaPackage.getBehaviorState(), "state", 1, 1, IS_UNIQUE, IS_ORDERED);
    addEParameter(op, theAadlBaPackage.getBehaviorTransition(), "transition", 1, 1, IS_UNIQUE, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //AtlHooksPackageImpl
