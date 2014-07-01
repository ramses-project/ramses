/**
 */
package org.trc.xtext.dsl.dsl.impl;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

import org.trc.xtext.dsl.dsl.AbstractRuleDependency;
import org.trc.xtext.dsl.dsl.DslFactory;
import org.trc.xtext.dsl.dsl.DslPackage;
import org.trc.xtext.dsl.dsl.Module;
import org.trc.xtext.dsl.dsl.ModuleList;
import org.trc.xtext.dsl.dsl.RuleDependency;
import org.trc.xtext.dsl.dsl.Transformation;
import org.trc.xtext.dsl.dsl.TransformationDependency;
import org.trc.xtext.dsl.dsl.TransformationDependencyList;
import org.trc.xtext.dsl.dsl.TransformationImpact;
import org.trc.xtext.dsl.dsl.TransformationList;
import org.trc.xtext.dsl.dsl.TrcSpecification;
import org.trc.xtext.dsl.dsl.excludeDependency;
import org.trc.xtext.dsl.dsl.requiresDependency;
import org.trc.xtext.dsl.dsl.trcRule;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class DslPackageImpl extends EPackageImpl implements DslPackage
{
  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trcSpecificationEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass trcRuleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass moduleEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transformationListEClass = null;

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
  private EClass transformationImpactEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transformationDependencyListEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transformationDependencyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass abstractRuleDependencyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleDependencyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass requiresDependencyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass excludeDependencyEClass = null;

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
   * @see org.trc.xtext.dsl.dsl.DslPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private DslPackageImpl()
  {
    super(eNS_URI, DslFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link DslPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static DslPackage init()
  {
    if (isInited) return (DslPackage)EPackage.Registry.INSTANCE.getEPackage(DslPackage.eNS_URI);

    // Obtain or create and register package
    DslPackageImpl theDslPackage = (DslPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof DslPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new DslPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theDslPackage.createPackageContents();

    // Initialize created meta-data
    theDslPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theDslPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(DslPackage.eNS_URI, theDslPackage);
    return theDslPackage;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTrcSpecification()
  {
    return trcSpecificationEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTrcSpecification_ModuleList()
  {
    return (EReference)trcSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTrcSpecification_TransformationList()
  {
    return (EReference)trcSpecificationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTrcSpecification_DependencyList()
  {
    return (EReference)trcSpecificationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass gettrcRule()
  {
    return trcRuleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute gettrcRule_Name()
  {
    return (EAttribute)trcRuleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModuleList()
  {
    return moduleListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModuleList_Modules()
  {
    return (EReference)moduleListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getModule()
  {
    return moduleEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModule_Name()
  {
    return (EAttribute)moduleEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getModule_Rules()
  {
    return (EReference)moduleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransformationList()
  {
    return transformationListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformationList_Transformations()
  {
    return (EReference)transformationListEClass.getEStructuralFeatures().get(0);
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
  public EAttribute getTransformation_Name()
  {
    return (EAttribute)transformationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformation_Modules()
  {
    return (EReference)transformationEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformation_Impacts()
  {
    return (EReference)transformationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransformationImpact()
  {
    return transformationImpactEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransformationImpact_QualityAttributeName()
  {
    return (EAttribute)transformationImpactEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransformationImpact_ImpactValue()
  {
    return (EAttribute)transformationImpactEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransformationDependencyList()
  {
    return transformationDependencyListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransformationDependencyList_Name()
  {
    return (EAttribute)transformationDependencyListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformationDependencyList_TransformationDependencies()
  {
    return (EReference)transformationDependencyListEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransformationDependency()
  {
    return transformationDependencyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformationDependency_AppliedTransformation()
  {
    return (EReference)transformationDependencyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformationDependency_AppliedRule()
  {
    return (EReference)transformationDependencyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransformationDependency_Fields()
  {
    return (EAttribute)transformationDependencyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformationDependency_RequiredTransformations()
  {
    return (EReference)transformationDependencyEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getAbstractRuleDependency()
  {
    return abstractRuleDependencyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleDependency()
  {
    return ruleDependencyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleDependency_Rd()
  {
    return (EReference)ruleDependencyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleDependency_Ed()
  {
    return (EReference)ruleDependencyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getrequiresDependency()
  {
    return requiresDependencyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getrequiresDependency_RequiredTransformation()
  {
    return (EReference)requiresDependencyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getrequiresDependency_RequiredRule()
  {
    return (EReference)requiresDependencyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getrequiresDependency_Fields()
  {
    return (EAttribute)requiresDependencyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getrequiresDependency_OclExpression()
  {
    return (EAttribute)requiresDependencyEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getexcludeDependency()
  {
    return excludeDependencyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getexcludeDependency_RequiredTransformation()
  {
    return (EReference)excludeDependencyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getexcludeDependency_RequiredRule()
  {
    return (EReference)excludeDependencyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getexcludeDependency_Fields()
  {
    return (EAttribute)excludeDependencyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getexcludeDependency_OclExpression()
  {
    return (EAttribute)excludeDependencyEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DslFactory getDslFactory()
  {
    return (DslFactory)getEFactoryInstance();
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
    trcSpecificationEClass = createEClass(TRC_SPECIFICATION);
    createEReference(trcSpecificationEClass, TRC_SPECIFICATION__MODULE_LIST);
    createEReference(trcSpecificationEClass, TRC_SPECIFICATION__TRANSFORMATION_LIST);
    createEReference(trcSpecificationEClass, TRC_SPECIFICATION__DEPENDENCY_LIST);

    trcRuleEClass = createEClass(TRC_RULE);
    createEAttribute(trcRuleEClass, TRC_RULE__NAME);

    moduleListEClass = createEClass(MODULE_LIST);
    createEReference(moduleListEClass, MODULE_LIST__MODULES);

    moduleEClass = createEClass(MODULE);
    createEAttribute(moduleEClass, MODULE__NAME);
    createEReference(moduleEClass, MODULE__RULES);

    transformationListEClass = createEClass(TRANSFORMATION_LIST);
    createEReference(transformationListEClass, TRANSFORMATION_LIST__TRANSFORMATIONS);

    transformationEClass = createEClass(TRANSFORMATION);
    createEAttribute(transformationEClass, TRANSFORMATION__NAME);
    createEReference(transformationEClass, TRANSFORMATION__MODULES);
    createEReference(transformationEClass, TRANSFORMATION__IMPACTS);

    transformationImpactEClass = createEClass(TRANSFORMATION_IMPACT);
    createEAttribute(transformationImpactEClass, TRANSFORMATION_IMPACT__QUALITY_ATTRIBUTE_NAME);
    createEAttribute(transformationImpactEClass, TRANSFORMATION_IMPACT__IMPACT_VALUE);

    transformationDependencyListEClass = createEClass(TRANSFORMATION_DEPENDENCY_LIST);
    createEAttribute(transformationDependencyListEClass, TRANSFORMATION_DEPENDENCY_LIST__NAME);
    createEReference(transformationDependencyListEClass, TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES);

    transformationDependencyEClass = createEClass(TRANSFORMATION_DEPENDENCY);
    createEReference(transformationDependencyEClass, TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION);
    createEReference(transformationDependencyEClass, TRANSFORMATION_DEPENDENCY__APPLIED_RULE);
    createEAttribute(transformationDependencyEClass, TRANSFORMATION_DEPENDENCY__FIELDS);
    createEReference(transformationDependencyEClass, TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS);

    abstractRuleDependencyEClass = createEClass(ABSTRACT_RULE_DEPENDENCY);

    ruleDependencyEClass = createEClass(RULE_DEPENDENCY);
    createEReference(ruleDependencyEClass, RULE_DEPENDENCY__RD);
    createEReference(ruleDependencyEClass, RULE_DEPENDENCY__ED);

    requiresDependencyEClass = createEClass(REQUIRES_DEPENDENCY);
    createEReference(requiresDependencyEClass, REQUIRES_DEPENDENCY__REQUIRED_TRANSFORMATION);
    createEReference(requiresDependencyEClass, REQUIRES_DEPENDENCY__REQUIRED_RULE);
    createEAttribute(requiresDependencyEClass, REQUIRES_DEPENDENCY__FIELDS);
    createEAttribute(requiresDependencyEClass, REQUIRES_DEPENDENCY__OCL_EXPRESSION);

    excludeDependencyEClass = createEClass(EXCLUDE_DEPENDENCY);
    createEReference(excludeDependencyEClass, EXCLUDE_DEPENDENCY__REQUIRED_TRANSFORMATION);
    createEReference(excludeDependencyEClass, EXCLUDE_DEPENDENCY__REQUIRED_RULE);
    createEAttribute(excludeDependencyEClass, EXCLUDE_DEPENDENCY__FIELDS);
    createEAttribute(excludeDependencyEClass, EXCLUDE_DEPENDENCY__OCL_EXPRESSION);
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

    // Create type parameters

    // Set bounds for type parameters

    // Add supertypes to classes
    ruleDependencyEClass.getESuperTypes().add(this.getAbstractRuleDependency());

    // Initialize classes and features; add operations and parameters
    initEClass(trcSpecificationEClass, TrcSpecification.class, "TrcSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTrcSpecification_ModuleList(), this.getModuleList(), null, "moduleList", null, 0, -1, TrcSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTrcSpecification_TransformationList(), this.getTransformationList(), null, "transformationList", null, 0, -1, TrcSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTrcSpecification_DependencyList(), this.getTransformationDependencyList(), null, "dependencyList", null, 0, -1, TrcSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(trcRuleEClass, trcRule.class, "trcRule", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(gettrcRule_Name(), ecorePackage.getEString(), "name", null, 0, 1, trcRule.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(moduleListEClass, ModuleList.class, "ModuleList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModuleList_Modules(), this.getModule(), null, "modules", null, 0, -1, ModuleList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModule_Name(), ecorePackage.getEString(), "name", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getModule_Rules(), this.gettrcRule(), null, "rules", null, 0, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transformationListEClass, TransformationList.class, "TransformationList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransformationList_Transformations(), this.getTransformation(), null, "transformations", null, 0, -1, TransformationList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transformationEClass, Transformation.class, "Transformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransformation_Name(), ecorePackage.getEString(), "name", null, 0, 1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransformation_Modules(), this.getModule(), null, "modules", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransformation_Impacts(), this.getTransformationImpact(), null, "impacts", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transformationImpactEClass, TransformationImpact.class, "TransformationImpact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransformationImpact_QualityAttributeName(), ecorePackage.getEString(), "qualityAttributeName", null, 0, 1, TransformationImpact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransformationImpact_ImpactValue(), ecorePackage.getEInt(), "impactValue", null, 0, 1, TransformationImpact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transformationDependencyListEClass, TransformationDependencyList.class, "TransformationDependencyList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransformationDependencyList_Name(), ecorePackage.getEString(), "name", null, 0, 1, TransformationDependencyList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransformationDependencyList_TransformationDependencies(), this.getTransformationDependency(), null, "transformationDependencies", null, 0, -1, TransformationDependencyList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transformationDependencyEClass, TransformationDependency.class, "TransformationDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransformationDependency_AppliedTransformation(), this.getTransformation(), null, "appliedTransformation", null, 0, 1, TransformationDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransformationDependency_AppliedRule(), this.gettrcRule(), null, "appliedRule", null, 0, 1, TransformationDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransformationDependency_Fields(), ecorePackage.getEString(), "fields", null, 0, -1, TransformationDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransformationDependency_RequiredTransformations(), this.getAbstractRuleDependency(), null, "requiredTransformations", null, 0, -1, TransformationDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractRuleDependencyEClass, AbstractRuleDependency.class, "AbstractRuleDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ruleDependencyEClass, RuleDependency.class, "RuleDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRuleDependency_Rd(), ecorePackage.getEObject(), null, "rd", null, 0, -1, RuleDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleDependency_Ed(), this.getexcludeDependency(), null, "ed", null, 0, -1, RuleDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(requiresDependencyEClass, requiresDependency.class, "requiresDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getrequiresDependency_RequiredTransformation(), this.getTransformation(), null, "requiredTransformation", null, 0, -1, requiresDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getrequiresDependency_RequiredRule(), this.gettrcRule(), null, "requiredRule", null, 0, -1, requiresDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getrequiresDependency_Fields(), ecorePackage.getEString(), "fields", null, 0, 1, requiresDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getrequiresDependency_OclExpression(), ecorePackage.getEString(), "oclExpression", null, 0, 1, requiresDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(excludeDependencyEClass, excludeDependency.class, "excludeDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getexcludeDependency_RequiredTransformation(), this.getTransformation(), null, "requiredTransformation", null, 0, -1, excludeDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getexcludeDependency_RequiredRule(), this.gettrcRule(), null, "requiredRule", null, 0, -1, excludeDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getexcludeDependency_Fields(), ecorePackage.getEString(), "fields", null, 0, 1, excludeDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getexcludeDependency_OclExpression(), ecorePackage.getEString(), "oclExpression", null, 0, 1, excludeDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //DslPackageImpl
