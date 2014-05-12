/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify it under
 * the terms of the Eclipse Public License as published by Eclipse, either
 * version 1.0 of the License, or (at your option) any later version. This
 * program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the Eclipse Public License for
 * more details. You should have received a copy of the Eclipse Public License
 * along with this program. If not, see
 * http://www.eclipse.org/org/documents/epl-v10.php
 */
package fr.tpt.aadl.ramses.control.workflow.impl;

import fr.tpt.aadl.ramses.control.workflow.AbstractAnalysis;
import fr.tpt.aadl.ramses.control.workflow.Analysis;
import fr.tpt.aadl.ramses.control.workflow.AnalysisElement;
import fr.tpt.aadl.ramses.control.workflow.AnalysisOption;
import fr.tpt.aadl.ramses.control.workflow.AnalysisSequence;
import fr.tpt.aadl.ramses.control.workflow.Conjunction;
import fr.tpt.aadl.ramses.control.workflow.Disjunction;
import fr.tpt.aadl.ramses.control.workflow.ErrorState;
import fr.tpt.aadl.ramses.control.workflow.File;
import fr.tpt.aadl.ramses.control.workflow.Generation;
import fr.tpt.aadl.ramses.control.workflow.List;
import fr.tpt.aadl.ramses.control.workflow.Loop;
import fr.tpt.aadl.ramses.control.workflow.ModelIdentifier;
import fr.tpt.aadl.ramses.control.workflow.ResolutionMethod;
import fr.tpt.aadl.ramses.control.workflow.Transformation;
import fr.tpt.aadl.ramses.control.workflow.Unparse;
import fr.tpt.aadl.ramses.control.workflow.Workflow;
import fr.tpt.aadl.ramses.control.workflow.WorkflowElement;
import fr.tpt.aadl.ramses.control.workflow.WorkflowFactory;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage;

import fr.tpt.aadl.ramses.transformation.trc.TrcPackage;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class WorkflowPackageImpl extends EPackageImpl implements WorkflowPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass workflowEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass workflowElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transformationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass analysisElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass generationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractAnalysisEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass analysisSequenceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass conjunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass disjunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass analysisEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass errorStateEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass listEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass fileEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass analysisOptionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass modelIdentifierEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unparseEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass loopEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EEnum resolutionMethodEEnum = null;

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
   * @see fr.tpt.aadl.ramses.control.workflow.WorkflowPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private WorkflowPackageImpl()
  {
    super(eNS_URI, WorkflowFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link WorkflowPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static WorkflowPackage init()
  {
    if (isInited) return (WorkflowPackage)EPackage.Registry.INSTANCE.getEPackage(WorkflowPackage.eNS_URI);

    // Obtain or create and register package
    WorkflowPackageImpl theWorkflowPackage = (WorkflowPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof WorkflowPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new WorkflowPackageImpl());

    isInited = true;

    // Initialize simple dependencies
    TrcPackage.eINSTANCE.eClass();

    // Create package meta-data objects
    theWorkflowPackage.createPackageContents();

    // Initialize created meta-data
    theWorkflowPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theWorkflowPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(WorkflowPackage.eNS_URI, theWorkflowPackage);
    return theWorkflowPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWorkflow()
  {
    return workflowEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWorkflow_Element()
  {
    return (EReference)workflowEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWorkflow_InputModelIdentifier()
  {
    return (EReference)workflowEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWorkflow_RequirementsRoot()
  {
    return (EReference)workflowEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getWorkflowElement()
  {
    return workflowElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getWorkflowElement_InputModelIdentifier()
  {
    return (EReference)workflowElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransformation()
  {
    return transformationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformation_Element()
  {
    return (EReference)transformationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformation_List()
  {
    return (EReference)transformationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformation_OutputModelIdentifier()
  {
    return (EReference)transformationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransformation_Identifier()
  {
    return (EAttribute)transformationEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnalysisElement()
  {
    return analysisElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getGeneration()
  {
    return generationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractAnalysis()
  {
    return abstractAnalysisEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractAnalysis_YesOption()
  {
    return (EReference)abstractAnalysisEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAbstractAnalysis_NoOption()
  {
    return (EReference)abstractAnalysisEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnalysisSequence()
  {
    return analysisSequenceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnalysisSequence_List()
  {
    return (EReference)analysisSequenceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConjunction()
  {
    return conjunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDisjunction()
  {
    return disjunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnalysis()
  {
    return analysisEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnalysis_Method()
  {
    return (EAttribute)analysisEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getAnalysis_Mode()
  {
    return (EAttribute)analysisEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnalysis_OutputModelIdentifier()
  {
    return (EReference)analysisEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getErrorState()
  {
    return errorStateEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getErrorState_Type()
  {
    return (EAttribute)errorStateEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getList()
  {
    return listEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getList_File()
  {
    return (EReference)listEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getFile()
  {
    return fileEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getFile_Path()
  {
    return (EAttribute)fileEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAnalysisOption()
  {
    return analysisOptionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getAnalysisOption_Element()
  {
    return (EReference)analysisOptionEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModelIdentifier()
  {
    return modelIdentifierEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModelIdentifier_Id()
  {
    return (EAttribute)modelIdentifierEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnparse()
  {
    return unparseEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnparse_Element()
  {
    return (EReference)unparseEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getUnparse_OutputModelIdentifier()
  {
    return (EReference)unparseEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLoop()
  {
    return loopEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoop_Alternatives()
  {
    return (EReference)loopEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoop_Analysis()
  {
    return (EReference)loopEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoop_OutputModelIdentifier()
  {
    return (EReference)loopEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoop_FoundOption()
  {
    return (EReference)loopEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLoop_NotFoundOption()
  {
    return (EReference)loopEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoop_ResolutionMethod()
  {
    return (EAttribute)loopEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLoop_MaxNbIteration()
  {
    return (EAttribute)loopEClass.getEStructuralFeatures().get(6);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EEnum getResolutionMethod()
  {
    return resolutionMethodEEnum;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public WorkflowFactory getWorkflowFactory()
  {
    return (WorkflowFactory)getEFactoryInstance();
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
    workflowEClass = createEClass(WORKFLOW);
    createEReference(workflowEClass, WORKFLOW__ELEMENT);
    createEReference(workflowEClass, WORKFLOW__INPUT_MODEL_IDENTIFIER);
    createEReference(workflowEClass, WORKFLOW__REQUIREMENTS_ROOT);

    workflowElementEClass = createEClass(WORKFLOW_ELEMENT);
    createEReference(workflowElementEClass, WORKFLOW_ELEMENT__INPUT_MODEL_IDENTIFIER);

    transformationEClass = createEClass(TRANSFORMATION);
    createEReference(transformationEClass, TRANSFORMATION__ELEMENT);
    createEReference(transformationEClass, TRANSFORMATION__LIST);
    createEReference(transformationEClass, TRANSFORMATION__OUTPUT_MODEL_IDENTIFIER);
    createEAttribute(transformationEClass, TRANSFORMATION__IDENTIFIER);

    analysisElementEClass = createEClass(ANALYSIS_ELEMENT);

    generationEClass = createEClass(GENERATION);

    abstractAnalysisEClass = createEClass(ABSTRACT_ANALYSIS);
    createEReference(abstractAnalysisEClass, ABSTRACT_ANALYSIS__YES_OPTION);
    createEReference(abstractAnalysisEClass, ABSTRACT_ANALYSIS__NO_OPTION);

    analysisSequenceEClass = createEClass(ANALYSIS_SEQUENCE);
    createEReference(analysisSequenceEClass, ANALYSIS_SEQUENCE__LIST);

    conjunctionEClass = createEClass(CONJUNCTION);

    disjunctionEClass = createEClass(DISJUNCTION);

    analysisEClass = createEClass(ANALYSIS);
    createEAttribute(analysisEClass, ANALYSIS__METHOD);
    createEAttribute(analysisEClass, ANALYSIS__MODE);
    createEReference(analysisEClass, ANALYSIS__OUTPUT_MODEL_IDENTIFIER);

    errorStateEClass = createEClass(ERROR_STATE);
    createEAttribute(errorStateEClass, ERROR_STATE__TYPE);

    listEClass = createEClass(LIST);
    createEReference(listEClass, LIST__FILE);

    fileEClass = createEClass(FILE);
    createEAttribute(fileEClass, FILE__PATH);

    analysisOptionEClass = createEClass(ANALYSIS_OPTION);
    createEReference(analysisOptionEClass, ANALYSIS_OPTION__ELEMENT);

    modelIdentifierEClass = createEClass(MODEL_IDENTIFIER);
    createEAttribute(modelIdentifierEClass, MODEL_IDENTIFIER__ID);

    unparseEClass = createEClass(UNPARSE);
    createEReference(unparseEClass, UNPARSE__ELEMENT);
    createEReference(unparseEClass, UNPARSE__OUTPUT_MODEL_IDENTIFIER);

    loopEClass = createEClass(LOOP);
    createEReference(loopEClass, LOOP__ALTERNATIVES);
    createEReference(loopEClass, LOOP__ANALYSIS);
    createEReference(loopEClass, LOOP__OUTPUT_MODEL_IDENTIFIER);
    createEReference(loopEClass, LOOP__FOUND_OPTION);
    createEReference(loopEClass, LOOP__NOT_FOUND_OPTION);
    createEAttribute(loopEClass, LOOP__RESOLUTION_METHOD);
    createEAttribute(loopEClass, LOOP__MAX_NB_ITERATION);

    // Create enums
    resolutionMethodEEnum = createEEnum(RESOLUTION_METHOD);
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
    TrcPackage theTrcPackage = (TrcPackage)EPackage.Registry.INSTANCE.getEPackage(TrcPackage.eNS_URI);

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    transformationEClass.getESuperTypes().add(this.getWorkflowElement());
    transformationEClass.getESuperTypes().add(this.getAnalysisElement());
    generationEClass.getESuperTypes().add(this.getWorkflowElement());
    generationEClass.getESuperTypes().add(this.getAnalysisElement());
    analysisSequenceEClass.getESuperTypes().add(this.getAbstractAnalysis());
    conjunctionEClass.getESuperTypes().add(this.getAnalysisSequence());
    disjunctionEClass.getESuperTypes().add(this.getAnalysisSequence());
    analysisEClass.getESuperTypes().add(this.getWorkflowElement());
    analysisEClass.getESuperTypes().add(this.getAnalysisElement());
    analysisEClass.getESuperTypes().add(this.getAbstractAnalysis());
    errorStateEClass.getESuperTypes().add(this.getAnalysisElement());
    unparseEClass.getESuperTypes().add(this.getWorkflowElement());
    unparseEClass.getESuperTypes().add(this.getAnalysisElement());
    loopEClass.getESuperTypes().add(this.getWorkflowElement());
    loopEClass.getESuperTypes().add(this.getAnalysisElement());

    // Initialize classes and features; add operations and parameters
    initEClass(workflowEClass, Workflow.class, "Workflow", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWorkflow_Element(), this.getWorkflowElement(), null, "element", null, 1, 1, Workflow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWorkflow_InputModelIdentifier(), this.getModelIdentifier(), null, "inputModelIdentifier", null, 1, 1, Workflow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getWorkflow_RequirementsRoot(), ecorePackage.getEObject(), null, "requirementsRoot", null, 0, 1, Workflow.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(workflowElementEClass, WorkflowElement.class, "WorkflowElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getWorkflowElement_InputModelIdentifier(), this.getModelIdentifier(), null, "inputModelIdentifier", null, 1, 1, WorkflowElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transformationEClass, Transformation.class, "Transformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransformation_Element(), this.getAnalysisElement(), null, "element", null, 1, 1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransformation_List(), this.getList(), null, "list", null, 0, 1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransformation_OutputModelIdentifier(), this.getModelIdentifier(), null, "outputModelIdentifier", null, 0, 1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransformation_Identifier(), ecorePackage.getEString(), "identifier", null, 0, 1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(analysisElementEClass, AnalysisElement.class, "AnalysisElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(generationEClass, Generation.class, "Generation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(abstractAnalysisEClass, AbstractAnalysis.class, "AbstractAnalysis", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAbstractAnalysis_YesOption(), this.getAnalysisOption(), null, "yesOption", null, 0, 1, AbstractAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAbstractAnalysis_NoOption(), this.getAnalysisOption(), null, "noOption", null, 0, 1, AbstractAnalysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(analysisSequenceEClass, AnalysisSequence.class, "AnalysisSequence", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAnalysisSequence_List(), this.getAbstractAnalysis(), null, "list", null, 2, -1, AnalysisSequence.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(conjunctionEClass, Conjunction.class, "Conjunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(disjunctionEClass, Disjunction.class, "Disjunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(analysisEClass, Analysis.class, "Analysis", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getAnalysis_Method(), ecorePackage.getEString(), "method", null, 0, 1, Analysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getAnalysis_Mode(), ecorePackage.getEString(), "mode", null, 0, 1, Analysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getAnalysis_OutputModelIdentifier(), this.getModelIdentifier(), null, "outputModelIdentifier", null, 0, 1, Analysis.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(errorStateEClass, ErrorState.class, "ErrorState", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getErrorState_Type(), ecorePackage.getEString(), "type", null, 0, 1, ErrorState.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(listEClass, List.class, "List", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getList_File(), this.getFile(), null, "file", null, 1, -1, List.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(fileEClass, File.class, "File", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getFile_Path(), ecorePackage.getEString(), "path", null, 1, 1, File.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(analysisOptionEClass, AnalysisOption.class, "AnalysisOption", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getAnalysisOption_Element(), this.getAnalysisElement(), null, "element", null, 0, 1, AnalysisOption.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(modelIdentifierEClass, ModelIdentifier.class, "ModelIdentifier", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModelIdentifier_Id(), ecorePackage.getEString(), "id", null, 0, 1, ModelIdentifier.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unparseEClass, Unparse.class, "Unparse", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getUnparse_Element(), this.getAnalysisElement(), null, "element", null, 1, 1, Unparse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getUnparse_OutputModelIdentifier(), this.getModelIdentifier(), null, "outputModelIdentifier", null, 0, 1, Unparse.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(loopEClass, Loop.class, "Loop", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLoop_Alternatives(), theTrcPackage.getTransformation(), null, "alternatives", null, 2, -1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLoop_Analysis(), this.getAbstractAnalysis(), null, "analysis", null, 1, 1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLoop_OutputModelIdentifier(), this.getModelIdentifier(), null, "outputModelIdentifier", null, 0, 1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLoop_FoundOption(), this.getAnalysisOption(), null, "foundOption", null, 1, 1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLoop_NotFoundOption(), this.getAnalysisOption(), null, "notFoundOption", null, 1, 1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoop_ResolutionMethod(), this.getResolutionMethod(), "resolutionMethod", "TryEach", 0, 1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getLoop_MaxNbIteration(), ecorePackage.getEInt(), "maxNbIteration", null, 0, 1, Loop.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Initialize enums and add enum literals
    initEEnum(resolutionMethodEEnum, ResolutionMethod.class, "ResolutionMethod");
    addEEnumLiteral(resolutionMethodEEnum, ResolutionMethod.TRY_EACH);
    addEEnumLiteral(resolutionMethodEEnum, ResolutionMethod.MANUAL_MERGE);
    addEEnumLiteral(resolutionMethodEEnum, ResolutionMethod.SENSITIVITY_MERGE);
    addEEnumLiteral(resolutionMethodEEnum, ResolutionMethod.GENETIC_MERGE);

    // Create resource
    createResource(eNS_URI);
  }

} //WorkflowPackageImpl
