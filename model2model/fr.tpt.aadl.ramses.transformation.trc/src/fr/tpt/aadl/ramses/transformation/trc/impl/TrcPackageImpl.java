/**
 */
package fr.tpt.aadl.ramses.transformation.trc.impl;

import fr.tpt.aadl.ramses.transformation.trc.AbstractRuleDependency;
import fr.tpt.aadl.ramses.transformation.trc.Module;
import fr.tpt.aadl.ramses.transformation.trc.ModuleList;
import fr.tpt.aadl.ramses.transformation.trc.RuleDependency;
import fr.tpt.aadl.ramses.transformation.trc.RuleDependencyComposite;
import fr.tpt.aadl.ramses.transformation.trc.RuleDependencyConjunction;
import fr.tpt.aadl.ramses.transformation.trc.RuleDependencyDisjunction;
import fr.tpt.aadl.ramses.transformation.trc.SpecificationElement;
import fr.tpt.aadl.ramses.transformation.trc.Transformation;
import fr.tpt.aadl.ramses.transformation.trc.TransformationDependency;
import fr.tpt.aadl.ramses.transformation.trc.TransformationDependencyList;
import fr.tpt.aadl.ramses.transformation.trc.TransformationElement;
import fr.tpt.aadl.ramses.transformation.trc.TransformationImpact;
import fr.tpt.aadl.ramses.transformation.trc.TransformationList;
import fr.tpt.aadl.ramses.transformation.trc.TrcFactory;
import fr.tpt.aadl.ramses.transformation.trc.TrcPackage;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TrcPackageImpl extends EPackageImpl implements TrcPackage
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
  private EClass moduleEClass = null;

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
  private EClass ruleDependencyConjunctionEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ruleDependencyDisjunctionEClass = null;

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
  private EClass ruleDependencyCompositeEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass transformationElementEClass = null;

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
  private EClass specificationElementEClass = null;

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
  private EClass transformationDependencyListEClass = null;

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
   * @see fr.tpt.aadl.ramses.transformation.trc.TrcPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TrcPackageImpl()
  {
    super(eNS_URI, TrcFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link TrcPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TrcPackage init()
  {
    if (isInited) return (TrcPackage)EPackage.Registry.INSTANCE.getEPackage(TrcPackage.eNS_URI);

    // Obtain or create and register package
    TrcPackageImpl theTrcPackage = (TrcPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TrcPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TrcPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theTrcPackage.createPackageContents();

    // Initialize created meta-data
    theTrcPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTrcPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TrcPackage.eNS_URI, theTrcPackage);
    return theTrcPackage;
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
  public EReference getTrcSpecification_Transformations()
  {
    return (EReference)trcSpecificationEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTrcSpecification_Dependencies()
  {
    return (EReference)trcSpecificationEClass.getEStructuralFeatures().get(1);
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
  public EReference getTransformation_Impacts()
  {
    return (EReference)transformationEClass.getEStructuralFeatures().get(0);
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
  public EAttribute getTransformation_RuleName()
  {
    return (EAttribute)transformationEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransformation_Name()
  {
    return (EAttribute)transformationEClass.getEStructuralFeatures().get(3);
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
  public EAttribute getTransformationImpact_ImpactValue()
  {
    return (EAttribute)transformationImpactEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransformationImpact_QualityAttributeName()
  {
    return (EAttribute)transformationImpactEClass.getEStructuralFeatures().get(1);
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
  public EAttribute getModule_RuleName()
  {
    return (EAttribute)moduleEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getModule_Path()
  {
    return (EAttribute)moduleEClass.getEStructuralFeatures().get(2);
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
  public EAttribute getTransformationDependency_VariableId()
  {
    return (EAttribute)transformationDependencyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformationDependency_AppliedTransformation()
  {
    return (EReference)transformationDependencyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformationDependency_RequiredTransformations()
  {
    return (EReference)transformationDependencyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTransformationDependency_AppliedRule()
  {
    return (EAttribute)transformationDependencyEClass.getEStructuralFeatures().get(3);
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
  public EClass getRuleDependencyConjunction()
  {
    return ruleDependencyConjunctionEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleDependencyDisjunction()
  {
    return ruleDependencyDisjunctionEClass;
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
  public EAttribute getRuleDependency_VariableId()
  {
    return (EAttribute)ruleDependencyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRuleDependency_FieldNames()
  {
    return (EAttribute)ruleDependencyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleDependency_RequiredTransformation()
  {
    return (EReference)ruleDependencyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRuleDependency_RequiredRule()
  {
    return (EAttribute)ruleDependencyEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getRuleDependency_IsExclusion()
  {
    return (EAttribute)ruleDependencyEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getRuleDependencyComposite()
  {
    return ruleDependencyCompositeEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleDependencyComposite_RequiredTransformations()
  {
    return (EReference)ruleDependencyCompositeEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTransformationElement()
  {
    return transformationElementEClass;
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
  public EClass getSpecificationElement()
  {
    return specificationElementEClass;
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
  public EClass getTransformationDependencyList()
  {
    return transformationDependencyListEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTransformationDependencyList_TransformationDependencies()
  {
    return (EReference)transformationDependencyListEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrcFactory getTrcFactory()
  {
    return (TrcFactory)getEFactoryInstance();
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
    createEReference(trcSpecificationEClass, TRC_SPECIFICATION__TRANSFORMATIONS);
    createEReference(trcSpecificationEClass, TRC_SPECIFICATION__DEPENDENCIES);

    transformationImpactEClass = createEClass(TRANSFORMATION_IMPACT);
    createEAttribute(transformationImpactEClass, TRANSFORMATION_IMPACT__IMPACT_VALUE);
    createEAttribute(transformationImpactEClass, TRANSFORMATION_IMPACT__QUALITY_ATTRIBUTE_NAME);

    moduleEClass = createEClass(MODULE);
    createEAttribute(moduleEClass, MODULE__NAME);
    createEAttribute(moduleEClass, MODULE__RULE_NAME);
    createEAttribute(moduleEClass, MODULE__PATH);

    transformationEClass = createEClass(TRANSFORMATION);
    createEReference(transformationEClass, TRANSFORMATION__IMPACTS);
    createEReference(transformationEClass, TRANSFORMATION__MODULES);
    createEAttribute(transformationEClass, TRANSFORMATION__RULE_NAME);
    createEAttribute(transformationEClass, TRANSFORMATION__NAME);

    transformationDependencyEClass = createEClass(TRANSFORMATION_DEPENDENCY);
    createEAttribute(transformationDependencyEClass, TRANSFORMATION_DEPENDENCY__VARIABLE_ID);
    createEReference(transformationDependencyEClass, TRANSFORMATION_DEPENDENCY__APPLIED_TRANSFORMATION);
    createEReference(transformationDependencyEClass, TRANSFORMATION_DEPENDENCY__REQUIRED_TRANSFORMATIONS);
    createEAttribute(transformationDependencyEClass, TRANSFORMATION_DEPENDENCY__APPLIED_RULE);

    abstractRuleDependencyEClass = createEClass(ABSTRACT_RULE_DEPENDENCY);

    ruleDependencyConjunctionEClass = createEClass(RULE_DEPENDENCY_CONJUNCTION);

    ruleDependencyDisjunctionEClass = createEClass(RULE_DEPENDENCY_DISJUNCTION);

    ruleDependencyEClass = createEClass(RULE_DEPENDENCY);
    createEAttribute(ruleDependencyEClass, RULE_DEPENDENCY__VARIABLE_ID);
    createEAttribute(ruleDependencyEClass, RULE_DEPENDENCY__FIELD_NAMES);
    createEReference(ruleDependencyEClass, RULE_DEPENDENCY__REQUIRED_TRANSFORMATION);
    createEAttribute(ruleDependencyEClass, RULE_DEPENDENCY__REQUIRED_RULE);
    createEAttribute(ruleDependencyEClass, RULE_DEPENDENCY__IS_EXCLUSION);

    ruleDependencyCompositeEClass = createEClass(RULE_DEPENDENCY_COMPOSITE);
    createEReference(ruleDependencyCompositeEClass, RULE_DEPENDENCY_COMPOSITE__REQUIRED_TRANSFORMATIONS);

    transformationElementEClass = createEClass(TRANSFORMATION_ELEMENT);

    moduleListEClass = createEClass(MODULE_LIST);
    createEReference(moduleListEClass, MODULE_LIST__MODULES);

    specificationElementEClass = createEClass(SPECIFICATION_ELEMENT);

    transformationListEClass = createEClass(TRANSFORMATION_LIST);
    createEReference(transformationListEClass, TRANSFORMATION_LIST__TRANSFORMATIONS);

    transformationDependencyListEClass = createEClass(TRANSFORMATION_DEPENDENCY_LIST);
    createEReference(transformationDependencyListEClass, TRANSFORMATION_DEPENDENCY_LIST__TRANSFORMATION_DEPENDENCIES);
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
    transformationImpactEClass.getESuperTypes().add(this.getTransformationElement());
    ruleDependencyConjunctionEClass.getESuperTypes().add(this.getRuleDependencyComposite());
    ruleDependencyDisjunctionEClass.getESuperTypes().add(this.getRuleDependencyComposite());
    ruleDependencyEClass.getESuperTypes().add(this.getAbstractRuleDependency());
    ruleDependencyCompositeEClass.getESuperTypes().add(this.getAbstractRuleDependency());

    // Initialize classes and features; add operations and parameters
    initEClass(trcSpecificationEClass, TrcSpecification.class, "TrcSpecification", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTrcSpecification_Transformations(), this.getTransformationList(), null, "transformations", null, 1, 1, TrcSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTrcSpecification_Dependencies(), this.getTransformationDependencyList(), null, "dependencies", null, 1, 1, TrcSpecification.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transformationImpactEClass, TransformationImpact.class, "TransformationImpact", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransformationImpact_ImpactValue(), ecorePackage.getEInt(), "impactValue", null, 1, 1, TransformationImpact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransformationImpact_QualityAttributeName(), ecorePackage.getEString(), "qualityAttributeName", null, 0, 1, TransformationImpact.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(moduleEClass, Module.class, "Module", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getModule_Name(), ecorePackage.getEString(), "name", null, 0, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModule_RuleName(), ecorePackage.getEString(), "ruleName", null, 1, -1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getModule_Path(), ecorePackage.getEString(), "path", null, 1, 1, Module.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transformationEClass, Transformation.class, "Transformation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransformation_Impacts(), this.getTransformationImpact(), null, "impacts", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransformation_Modules(), this.getModuleList(), null, "modules", null, 1, 1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransformation_RuleName(), ecorePackage.getEString(), "ruleName", null, 0, -1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransformation_Name(), ecorePackage.getEString(), "name", null, 1, 1, Transformation.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transformationDependencyEClass, TransformationDependency.class, "TransformationDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTransformationDependency_VariableId(), ecorePackage.getEString(), "variableId", null, 1, -1, TransformationDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransformationDependency_AppliedTransformation(), this.getTransformation(), null, "appliedTransformation", null, 1, 1, TransformationDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransformationDependency_RequiredTransformations(), this.getAbstractRuleDependency(), null, "requiredTransformations", null, 1, -1, TransformationDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTransformationDependency_AppliedRule(), ecorePackage.getEString(), "appliedRule", null, 1, 1, TransformationDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(abstractRuleDependencyEClass, AbstractRuleDependency.class, "AbstractRuleDependency", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ruleDependencyConjunctionEClass, RuleDependencyConjunction.class, "RuleDependencyConjunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ruleDependencyDisjunctionEClass, RuleDependencyDisjunction.class, "RuleDependencyDisjunction", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ruleDependencyEClass, RuleDependency.class, "RuleDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getRuleDependency_VariableId(), ecorePackage.getEInt(), "variableId", null, 0, 1, RuleDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRuleDependency_FieldNames(), ecorePackage.getEString(), "fieldNames", null, 1, -1, RuleDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleDependency_RequiredTransformation(), this.getTransformation(), null, "requiredTransformation", null, 0, 1, RuleDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRuleDependency_RequiredRule(), ecorePackage.getEString(), "requiredRule", null, 0, 1, RuleDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getRuleDependency_IsExclusion(), ecorePackage.getEBoolean(), "isExclusion", "false", 0, 1, RuleDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleDependencyCompositeEClass, RuleDependencyComposite.class, "RuleDependencyComposite", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRuleDependencyComposite_RequiredTransformations(), this.getAbstractRuleDependency(), null, "requiredTransformations", null, 1, -1, RuleDependencyComposite.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transformationElementEClass, TransformationElement.class, "TransformationElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(moduleListEClass, ModuleList.class, "ModuleList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getModuleList_Modules(), this.getModule(), null, "modules", null, 0, -1, ModuleList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(specificationElementEClass, SpecificationElement.class, "SpecificationElement", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(transformationListEClass, TransformationList.class, "TransformationList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransformationList_Transformations(), this.getTransformation(), null, "transformations", null, 1, -1, TransformationList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(transformationDependencyListEClass, TransformationDependencyList.class, "TransformationDependencyList", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTransformationDependencyList_TransformationDependencies(), this.getTransformationDependency(), null, "transformationDependencies", null, 1, -1, TransformationDependencyList.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //TrcPackageImpl
