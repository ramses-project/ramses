/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BigNumber;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BinaryOperatorCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BooleanLiteralExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BooleanOperations;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ClassifierContextDeclCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralPartCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionTypeCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorPartCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefPropertyCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.EssentialOCLInfixOperatorCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.EssentialOCLPrefixOperator;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpressCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IndexExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvalidLiteralExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvocationExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.KeyWord;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetVariableCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Module;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ModuleList;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityBoundsCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityStringCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameSpace;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NamedElement;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigatingArgCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigationOperatorCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NestedExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NullLiteralExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NumberLiteralExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ParameterCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathElementCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathNameCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixedExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixedExpOrLetExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimaryExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimaryExpOrLetExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimitiveLiteralExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimitiveTypeCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SelfExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.StringLiteralExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCFactory;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependencyList;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationImpact;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationList;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TrcSpecification;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralPartCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TuplePartCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleTypeCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralWithMultiplicityCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeNameExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypedRefCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.UnlimitedNaturalLiteralExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.oclExpr;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.trcRule;

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
public class TRCPackageImpl extends EPackageImpl implements TRCPackage
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
  private EClass booleanOperationsEClass = null;

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
  private EClass keyWordEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass requiresOrExcludeDependencyEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass oclExprEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass classifierContextDeclCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass operationContextDeclCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass parameterCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constraintCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass defCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass defPropertyCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typedRefCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicityCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicityStringCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass multiplicityBoundsCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass namedElementEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nameSpaceEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeNameExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pathNameCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass pathElementCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass specificationCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass essentialOCLInfixOperatorCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass binaryOperatorCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass navigationOperatorCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass contextCsEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expressCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass prefixedExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass essentialOCLPrefixOperatorEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass prefixedExpOrLetExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primaryExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constructorPartCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeLiteralWithMultiplicityCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeLiteralCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tupleTypeCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tuplePartCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primitiveTypeCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass typeLiteralExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass collectionLiteralExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass collectionLiteralPartCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass collectionTypeCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nestedExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass selfExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primaryExpOrLetExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass letExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass letVariableCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass navigatingArgCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass expCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass ifExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tupleLiteralExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass tupleLiteralPartCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass primitiveLiteralExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass numberLiteralExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass bigNumberEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass stringLiteralExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass booleanLiteralExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass unlimitedNaturalLiteralExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass invalidLiteralExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nullLiteralExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass prefixExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass indexExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass constructorExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass invocationExpCSEClass = null;

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  private EClass nameExpCSEClass = null;

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
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage#eNS_URI
   * @see #init()
   * @generated
   */
  private TRCPackageImpl()
  {
    super(eNS_URI, TRCFactory.eINSTANCE);
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
   * <p>This method is used to initialize {@link TRCPackage#eINSTANCE} when that field is accessed.
   * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @see #eNS_URI
   * @see #createPackageContents()
   * @see #initializePackageContents()
   * @generated
   */
  public static TRCPackage init()
  {
    if (isInited) return (TRCPackage)EPackage.Registry.INSTANCE.getEPackage(TRCPackage.eNS_URI);

    // Obtain or create and register package
    TRCPackageImpl theTRCPackage = (TRCPackageImpl)(EPackage.Registry.INSTANCE.get(eNS_URI) instanceof TRCPackageImpl ? EPackage.Registry.INSTANCE.get(eNS_URI) : new TRCPackageImpl());

    isInited = true;

    // Create package meta-data objects
    theTRCPackage.createPackageContents();

    // Initialize created meta-data
    theTRCPackage.initializePackageContents();

    // Mark meta-data to indicate it can't be changed
    theTRCPackage.freeze();

  
    // Update the registry and return the package
    EPackage.Registry.INSTANCE.put(TRCPackage.eNS_URI, theTRCPackage);
    return theTRCPackage;
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
  public EReference getTransformationDependency_BoolOP()
  {
    return (EReference)transformationDependencyEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanOperations()
  {
    return booleanOperationsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBooleanOperations_Name()
  {
    return (EAttribute)booleanOperationsEClass.getEStructuralFeatures().get(0);
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
  public EReference getRuleDependency_Kw()
  {
    return (EReference)ruleDependencyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleDependency_Red()
  {
    return (EReference)ruleDependencyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getRuleDependency_BoolOP()
  {
    return (EReference)ruleDependencyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getKeyWord()
  {
    return keyWordEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getKeyWord_Name()
  {
    return (EAttribute)keyWordEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getrequiresOrExcludeDependency()
  {
    return requiresOrExcludeDependencyEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getrequiresOrExcludeDependency_RequiredTransformation()
  {
    return (EReference)requiresOrExcludeDependencyEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getrequiresOrExcludeDependency_RequiredRule()
  {
    return (EReference)requiresOrExcludeDependencyEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getrequiresOrExcludeDependency_Fields()
  {
    return (EAttribute)requiresOrExcludeDependencyEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getrequiresOrExcludeDependency_OclExpression()
  {
    return (EReference)requiresOrExcludeDependencyEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getoclExpr()
  {
    return oclExprEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getClassifierContextDeclCS()
  {
    return classifierContextDeclCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getClassifierContextDeclCS_SelfName()
  {
    return (EAttribute)classifierContextDeclCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifierContextDeclCS_Invariants()
  {
    return (EReference)classifierContextDeclCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getClassifierContextDeclCS_Definitions()
  {
    return (EReference)classifierContextDeclCSEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getOperationContextDeclCS()
  {
    return operationContextDeclCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationContextDeclCS_PathName()
  {
    return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationContextDeclCS_Parameters()
  {
    return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationContextDeclCS_OwnedType()
  {
    return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationContextDeclCS_Preconditions()
  {
    return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationContextDeclCS_Postconditions()
  {
    return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(4);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getOperationContextDeclCS_Bodies()
  {
    return (EReference)operationContextDeclCSEClass.getEStructuralFeatures().get(5);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getParameterCS()
  {
    return parameterCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getParameterCS_Name()
  {
    return (EAttribute)parameterCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getParameterCS_OwnedType()
  {
    return (EReference)parameterCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstraintCS()
  {
    return constraintCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstraintCS_Name()
  {
    return (EAttribute)constraintCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintCS_MessageSpecification()
  {
    return (EReference)constraintCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstraintCS_Specification()
  {
    return (EReference)constraintCSEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefCS()
  {
    return defCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getDefPropertyCS()
  {
    return defPropertyCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDefPropertyCS_Static()
  {
    return (EAttribute)defPropertyCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getDefPropertyCS_Name()
  {
    return (EAttribute)defPropertyCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDefPropertyCS_OwnedType()
  {
    return (EReference)defPropertyCSEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getDefPropertyCS_Specification()
  {
    return (EReference)defPropertyCSEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypedRefCS()
  {
    return typedRefCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicityCS()
  {
    return multiplicityCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicityStringCS()
  {
    return multiplicityStringCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicityStringCS_StringBounds()
  {
    return (EAttribute)multiplicityStringCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getMultiplicityBoundsCS()
  {
    return multiplicityBoundsCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicityBoundsCS_LowerBound()
  {
    return (EAttribute)multiplicityBoundsCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getMultiplicityBoundsCS_UpperBound()
  {
    return (EAttribute)multiplicityBoundsCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNamedElement()
  {
    return namedElementEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamedElement_IsStatic()
  {
    return (EAttribute)namedElementEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNamedElement_Name()
  {
    return (EAttribute)namedElementEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNameSpace()
  {
    return nameSpaceEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNameSpace_ID()
  {
    return (EAttribute)nameSpaceEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeNameExpCS()
  {
    return typeNameExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeNameExpCS_Multiplicity()
  {
    return (EReference)typeNameExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeNameExpCS_PathName()
  {
    return (EReference)typeNameExpCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPathNameCS()
  {
    return pathNameCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPathNameCS_Path()
  {
    return (EReference)pathNameCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPathElementCS()
  {
    return pathElementCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPathElementCS_Element()
  {
    return (EReference)pathElementCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSpecificationCS()
  {
    return specificationCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getSpecificationCS_OwnedExpression()
  {
    return (EReference)specificationCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getSpecificationCS_ExprString()
  {
    return (EAttribute)specificationCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEssentialOCLInfixOperatorCS()
  {
    return essentialOCLInfixOperatorCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBinaryOperatorCS()
  {
    return binaryOperatorCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBinaryOperatorCS_Name()
  {
    return (EAttribute)binaryOperatorCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNavigationOperatorCS()
  {
    return navigationOperatorCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getContextCs()
  {
    return contextCsEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContextCs_OwnedExpression()
  {
    return (EReference)contextCsEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContextCs_B()
  {
    return (EReference)contextCsEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getContextCs_BO()
  {
    return (EReference)contextCsEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpressCS()
  {
    return expressCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpressCS_OwnedExpression()
  {
    return (EReference)expressCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getExpressCS_OwnedOperator()
  {
    return (EReference)expressCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrefixedExpCS()
  {
    return prefixedExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getEssentialOCLPrefixOperator()
  {
    return essentialOCLPrefixOperatorEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getEssentialOCLPrefixOperator_Name()
  {
    return (EAttribute)essentialOCLPrefixOperatorEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrefixedExpOrLetExpCS()
  {
    return prefixedExpOrLetExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimaryExpCS()
  {
    return primaryExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstructorPartCS()
  {
    return constructorPartCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstructorPartCS_Property()
  {
    return (EAttribute)constructorPartCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstructorPartCS_InitExpression()
  {
    return (EReference)constructorPartCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeLiteralWithMultiplicityCS()
  {
    return typeLiteralWithMultiplicityCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeLiteralCS()
  {
    return typeLiteralCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeLiteralCS_Multiplicity()
  {
    return (EReference)typeLiteralCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTypeLiteralCS_Name()
  {
    return (EAttribute)typeLiteralCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTupleTypeCS()
  {
    return tupleTypeCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTupleTypeCS_OwnedParts()
  {
    return (EReference)tupleTypeCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTuplePartCS()
  {
    return tuplePartCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTuplePartCS_Name()
  {
    return (EAttribute)tuplePartCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTuplePartCS_OwnedType()
  {
    return (EReference)tuplePartCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimitiveTypeCS()
  {
    return primitiveTypeCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTypeLiteralExpCS()
  {
    return typeLiteralExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTypeLiteralExpCS_OwnedType()
  {
    return (EReference)typeLiteralExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCollectionLiteralExpCS()
  {
    return collectionLiteralExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCollectionLiteralExpCS_OwnedType()
  {
    return (EReference)collectionLiteralExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCollectionLiteralExpCS_OwnedParts()
  {
    return (EReference)collectionLiteralExpCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCollectionLiteralPartCS()
  {
    return collectionLiteralPartCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCollectionLiteralPartCS_ExpressionCS()
  {
    return (EReference)collectionLiteralPartCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCollectionLiteralPartCS_LastExpressionCS()
  {
    return (EReference)collectionLiteralPartCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getCollectionTypeCS()
  {
    return collectionTypeCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getCollectionTypeCS_OwnedType()
  {
    return (EReference)collectionTypeCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNestedExpCS()
  {
    return nestedExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNestedExpCS_Source()
  {
    return (EReference)nestedExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getSelfExpCS()
  {
    return selfExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimaryExpOrLetExpCS()
  {
    return primaryExpOrLetExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLetExpCS()
  {
    return letExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLetExpCS_Variable()
  {
    return (EReference)letExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLetExpCS_In()
  {
    return (EReference)letExpCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getLetVariableCS()
  {
    return letVariableCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getLetVariableCS_Name()
  {
    return (EAttribute)letVariableCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLetVariableCS_OwnedType()
  {
    return (EReference)letVariableCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getLetVariableCS_InitExpression()
  {
    return (EReference)letVariableCSEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNavigatingArgCS()
  {
    return navigatingArgCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNavigatingArgCS_Name()
  {
    return (EReference)navigatingArgCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNavigatingArgCS_OwnedType()
  {
    return (EReference)navigatingArgCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNavigatingArgCS_Init()
  {
    return (EReference)navigatingArgCSEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNavigatingArgCS_Prefix()
  {
    return (EAttribute)navigatingArgCSEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getExpCS()
  {
    return expCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIfExpCS()
  {
    return ifExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfExpCS_Condition()
  {
    return (EReference)ifExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfExpCS_ThenExpression()
  {
    return (EReference)ifExpCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIfExpCS_ElseExpression()
  {
    return (EReference)ifExpCSEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTupleLiteralExpCS()
  {
    return tupleLiteralExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTupleLiteralExpCS_OwnedParts()
  {
    return (EReference)tupleLiteralExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getTupleLiteralPartCS()
  {
    return tupleLiteralPartCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getTupleLiteralPartCS_Name()
  {
    return (EAttribute)tupleLiteralPartCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTupleLiteralPartCS_OwnedType()
  {
    return (EReference)tupleLiteralPartCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getTupleLiteralPartCS_InitExpression()
  {
    return (EReference)tupleLiteralPartCSEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrimitiveLiteralExpCS()
  {
    return primitiveLiteralExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNumberLiteralExpCS()
  {
    return numberLiteralExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNumberLiteralExpCS_Name()
  {
    return (EReference)numberLiteralExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBigNumber()
  {
    return bigNumberEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBigNumber_Number()
  {
    return (EAttribute)bigNumberEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getStringLiteralExpCS()
  {
    return stringLiteralExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getStringLiteralExpCS_Name()
  {
    return (EAttribute)stringLiteralExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getBooleanLiteralExpCS()
  {
    return booleanLiteralExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getBooleanLiteralExpCS_Name()
  {
    return (EAttribute)booleanLiteralExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getUnlimitedNaturalLiteralExpCS()
  {
    return unlimitedNaturalLiteralExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInvalidLiteralExpCS()
  {
    return invalidLiteralExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNullLiteralExpCS()
  {
    return nullLiteralExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getPrefixExpCS()
  {
    return prefixExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrefixExpCS_OwnedOperator()
  {
    return (EReference)prefixExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getPrefixExpCS_OwnedExpression()
  {
    return (EReference)prefixExpCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getIndexExpCS()
  {
    return indexExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndexExpCS_PathName()
  {
    return (EReference)indexExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndexExpCS_FirstIndexes()
  {
    return (EReference)indexExpCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getIndexExpCS_SecondIndexes()
  {
    return (EReference)indexExpCSEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getIndexExpCS_AtPre()
  {
    return (EAttribute)indexExpCSEClass.getEStructuralFeatures().get(3);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getConstructorExpCS()
  {
    return constructorExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstructorExpCS_PathName()
  {
    return (EReference)constructorExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getConstructorExpCS_OwnedParts()
  {
    return (EReference)constructorExpCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getConstructorExpCS_Value()
  {
    return (EAttribute)constructorExpCSEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getInvocationExpCS()
  {
    return invocationExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationExpCS_PathName()
  {
    return (EReference)invocationExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getInvocationExpCS_AtPre()
  {
    return (EAttribute)invocationExpCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getInvocationExpCS_Argument()
  {
    return (EReference)invocationExpCSEClass.getEStructuralFeatures().get(2);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EClass getNameExpCS()
  {
    return nameExpCSEClass;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EReference getNameExpCS_PathName()
  {
    return (EReference)nameExpCSEClass.getEStructuralFeatures().get(0);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EAttribute getNameExpCS_AtPre()
  {
    return (EAttribute)nameExpCSEClass.getEStructuralFeatures().get(1);
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TRCFactory getTRCFactory()
  {
    return (TRCFactory)getEFactoryInstance();
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
    createEReference(transformationDependencyEClass, TRANSFORMATION_DEPENDENCY__BOOL_OP);

    booleanOperationsEClass = createEClass(BOOLEAN_OPERATIONS);
    createEAttribute(booleanOperationsEClass, BOOLEAN_OPERATIONS__NAME);

    ruleDependencyEClass = createEClass(RULE_DEPENDENCY);
    createEReference(ruleDependencyEClass, RULE_DEPENDENCY__KW);
    createEReference(ruleDependencyEClass, RULE_DEPENDENCY__RED);
    createEReference(ruleDependencyEClass, RULE_DEPENDENCY__BOOL_OP);

    keyWordEClass = createEClass(KEY_WORD);
    createEAttribute(keyWordEClass, KEY_WORD__NAME);

    requiresOrExcludeDependencyEClass = createEClass(REQUIRES_OR_EXCLUDE_DEPENDENCY);
    createEReference(requiresOrExcludeDependencyEClass, REQUIRES_OR_EXCLUDE_DEPENDENCY__REQUIRED_TRANSFORMATION);
    createEReference(requiresOrExcludeDependencyEClass, REQUIRES_OR_EXCLUDE_DEPENDENCY__REQUIRED_RULE);
    createEAttribute(requiresOrExcludeDependencyEClass, REQUIRES_OR_EXCLUDE_DEPENDENCY__FIELDS);
    createEReference(requiresOrExcludeDependencyEClass, REQUIRES_OR_EXCLUDE_DEPENDENCY__OCL_EXPRESSION);

    oclExprEClass = createEClass(OCL_EXPR);

    classifierContextDeclCSEClass = createEClass(CLASSIFIER_CONTEXT_DECL_CS);
    createEAttribute(classifierContextDeclCSEClass, CLASSIFIER_CONTEXT_DECL_CS__SELF_NAME);
    createEReference(classifierContextDeclCSEClass, CLASSIFIER_CONTEXT_DECL_CS__INVARIANTS);
    createEReference(classifierContextDeclCSEClass, CLASSIFIER_CONTEXT_DECL_CS__DEFINITIONS);

    operationContextDeclCSEClass = createEClass(OPERATION_CONTEXT_DECL_CS);
    createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__PATH_NAME);
    createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__PARAMETERS);
    createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__OWNED_TYPE);
    createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__PRECONDITIONS);
    createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__POSTCONDITIONS);
    createEReference(operationContextDeclCSEClass, OPERATION_CONTEXT_DECL_CS__BODIES);

    parameterCSEClass = createEClass(PARAMETER_CS);
    createEAttribute(parameterCSEClass, PARAMETER_CS__NAME);
    createEReference(parameterCSEClass, PARAMETER_CS__OWNED_TYPE);

    constraintCSEClass = createEClass(CONSTRAINT_CS);
    createEAttribute(constraintCSEClass, CONSTRAINT_CS__NAME);
    createEReference(constraintCSEClass, CONSTRAINT_CS__MESSAGE_SPECIFICATION);
    createEReference(constraintCSEClass, CONSTRAINT_CS__SPECIFICATION);

    defCSEClass = createEClass(DEF_CS);

    defPropertyCSEClass = createEClass(DEF_PROPERTY_CS);
    createEAttribute(defPropertyCSEClass, DEF_PROPERTY_CS__STATIC);
    createEAttribute(defPropertyCSEClass, DEF_PROPERTY_CS__NAME);
    createEReference(defPropertyCSEClass, DEF_PROPERTY_CS__OWNED_TYPE);
    createEReference(defPropertyCSEClass, DEF_PROPERTY_CS__SPECIFICATION);

    typedRefCSEClass = createEClass(TYPED_REF_CS);

    multiplicityCSEClass = createEClass(MULTIPLICITY_CS);

    multiplicityStringCSEClass = createEClass(MULTIPLICITY_STRING_CS);
    createEAttribute(multiplicityStringCSEClass, MULTIPLICITY_STRING_CS__STRING_BOUNDS);

    multiplicityBoundsCSEClass = createEClass(MULTIPLICITY_BOUNDS_CS);
    createEAttribute(multiplicityBoundsCSEClass, MULTIPLICITY_BOUNDS_CS__LOWER_BOUND);
    createEAttribute(multiplicityBoundsCSEClass, MULTIPLICITY_BOUNDS_CS__UPPER_BOUND);

    namedElementEClass = createEClass(NAMED_ELEMENT);
    createEAttribute(namedElementEClass, NAMED_ELEMENT__IS_STATIC);
    createEAttribute(namedElementEClass, NAMED_ELEMENT__NAME);

    nameSpaceEClass = createEClass(NAME_SPACE);
    createEAttribute(nameSpaceEClass, NAME_SPACE__ID);

    typeNameExpCSEClass = createEClass(TYPE_NAME_EXP_CS);
    createEReference(typeNameExpCSEClass, TYPE_NAME_EXP_CS__MULTIPLICITY);
    createEReference(typeNameExpCSEClass, TYPE_NAME_EXP_CS__PATH_NAME);

    pathNameCSEClass = createEClass(PATH_NAME_CS);
    createEReference(pathNameCSEClass, PATH_NAME_CS__PATH);

    pathElementCSEClass = createEClass(PATH_ELEMENT_CS);
    createEReference(pathElementCSEClass, PATH_ELEMENT_CS__ELEMENT);

    specificationCSEClass = createEClass(SPECIFICATION_CS);
    createEReference(specificationCSEClass, SPECIFICATION_CS__OWNED_EXPRESSION);
    createEAttribute(specificationCSEClass, SPECIFICATION_CS__EXPR_STRING);

    essentialOCLInfixOperatorCSEClass = createEClass(ESSENTIAL_OCL_INFIX_OPERATOR_CS);

    binaryOperatorCSEClass = createEClass(BINARY_OPERATOR_CS);
    createEAttribute(binaryOperatorCSEClass, BINARY_OPERATOR_CS__NAME);

    navigationOperatorCSEClass = createEClass(NAVIGATION_OPERATOR_CS);

    contextCsEClass = createEClass(CONTEXT_CS);
    createEReference(contextCsEClass, CONTEXT_CS__OWNED_EXPRESSION);
    createEReference(contextCsEClass, CONTEXT_CS__B);
    createEReference(contextCsEClass, CONTEXT_CS__BO);

    expressCSEClass = createEClass(EXPRESS_CS);
    createEReference(expressCSEClass, EXPRESS_CS__OWNED_EXPRESSION);
    createEReference(expressCSEClass, EXPRESS_CS__OWNED_OPERATOR);

    prefixedExpCSEClass = createEClass(PREFIXED_EXP_CS);

    essentialOCLPrefixOperatorEClass = createEClass(ESSENTIAL_OCL_PREFIX_OPERATOR);
    createEAttribute(essentialOCLPrefixOperatorEClass, ESSENTIAL_OCL_PREFIX_OPERATOR__NAME);

    prefixedExpOrLetExpCSEClass = createEClass(PREFIXED_EXP_OR_LET_EXP_CS);

    primaryExpCSEClass = createEClass(PRIMARY_EXP_CS);

    constructorPartCSEClass = createEClass(CONSTRUCTOR_PART_CS);
    createEAttribute(constructorPartCSEClass, CONSTRUCTOR_PART_CS__PROPERTY);
    createEReference(constructorPartCSEClass, CONSTRUCTOR_PART_CS__INIT_EXPRESSION);

    typeLiteralWithMultiplicityCSEClass = createEClass(TYPE_LITERAL_WITH_MULTIPLICITY_CS);

    typeLiteralCSEClass = createEClass(TYPE_LITERAL_CS);
    createEReference(typeLiteralCSEClass, TYPE_LITERAL_CS__MULTIPLICITY);
    createEAttribute(typeLiteralCSEClass, TYPE_LITERAL_CS__NAME);

    tupleTypeCSEClass = createEClass(TUPLE_TYPE_CS);
    createEReference(tupleTypeCSEClass, TUPLE_TYPE_CS__OWNED_PARTS);

    tuplePartCSEClass = createEClass(TUPLE_PART_CS);
    createEAttribute(tuplePartCSEClass, TUPLE_PART_CS__NAME);
    createEReference(tuplePartCSEClass, TUPLE_PART_CS__OWNED_TYPE);

    primitiveTypeCSEClass = createEClass(PRIMITIVE_TYPE_CS);

    typeLiteralExpCSEClass = createEClass(TYPE_LITERAL_EXP_CS);
    createEReference(typeLiteralExpCSEClass, TYPE_LITERAL_EXP_CS__OWNED_TYPE);

    collectionLiteralExpCSEClass = createEClass(COLLECTION_LITERAL_EXP_CS);
    createEReference(collectionLiteralExpCSEClass, COLLECTION_LITERAL_EXP_CS__OWNED_TYPE);
    createEReference(collectionLiteralExpCSEClass, COLLECTION_LITERAL_EXP_CS__OWNED_PARTS);

    collectionLiteralPartCSEClass = createEClass(COLLECTION_LITERAL_PART_CS);
    createEReference(collectionLiteralPartCSEClass, COLLECTION_LITERAL_PART_CS__EXPRESSION_CS);
    createEReference(collectionLiteralPartCSEClass, COLLECTION_LITERAL_PART_CS__LAST_EXPRESSION_CS);

    collectionTypeCSEClass = createEClass(COLLECTION_TYPE_CS);
    createEReference(collectionTypeCSEClass, COLLECTION_TYPE_CS__OWNED_TYPE);

    nestedExpCSEClass = createEClass(NESTED_EXP_CS);
    createEReference(nestedExpCSEClass, NESTED_EXP_CS__SOURCE);

    selfExpCSEClass = createEClass(SELF_EXP_CS);

    primaryExpOrLetExpCSEClass = createEClass(PRIMARY_EXP_OR_LET_EXP_CS);

    letExpCSEClass = createEClass(LET_EXP_CS);
    createEReference(letExpCSEClass, LET_EXP_CS__VARIABLE);
    createEReference(letExpCSEClass, LET_EXP_CS__IN);

    letVariableCSEClass = createEClass(LET_VARIABLE_CS);
    createEAttribute(letVariableCSEClass, LET_VARIABLE_CS__NAME);
    createEReference(letVariableCSEClass, LET_VARIABLE_CS__OWNED_TYPE);
    createEReference(letVariableCSEClass, LET_VARIABLE_CS__INIT_EXPRESSION);

    navigatingArgCSEClass = createEClass(NAVIGATING_ARG_CS);
    createEReference(navigatingArgCSEClass, NAVIGATING_ARG_CS__NAME);
    createEReference(navigatingArgCSEClass, NAVIGATING_ARG_CS__OWNED_TYPE);
    createEReference(navigatingArgCSEClass, NAVIGATING_ARG_CS__INIT);
    createEAttribute(navigatingArgCSEClass, NAVIGATING_ARG_CS__PREFIX);

    expCSEClass = createEClass(EXP_CS);

    ifExpCSEClass = createEClass(IF_EXP_CS);
    createEReference(ifExpCSEClass, IF_EXP_CS__CONDITION);
    createEReference(ifExpCSEClass, IF_EXP_CS__THEN_EXPRESSION);
    createEReference(ifExpCSEClass, IF_EXP_CS__ELSE_EXPRESSION);

    tupleLiteralExpCSEClass = createEClass(TUPLE_LITERAL_EXP_CS);
    createEReference(tupleLiteralExpCSEClass, TUPLE_LITERAL_EXP_CS__OWNED_PARTS);

    tupleLiteralPartCSEClass = createEClass(TUPLE_LITERAL_PART_CS);
    createEAttribute(tupleLiteralPartCSEClass, TUPLE_LITERAL_PART_CS__NAME);
    createEReference(tupleLiteralPartCSEClass, TUPLE_LITERAL_PART_CS__OWNED_TYPE);
    createEReference(tupleLiteralPartCSEClass, TUPLE_LITERAL_PART_CS__INIT_EXPRESSION);

    primitiveLiteralExpCSEClass = createEClass(PRIMITIVE_LITERAL_EXP_CS);

    numberLiteralExpCSEClass = createEClass(NUMBER_LITERAL_EXP_CS);
    createEReference(numberLiteralExpCSEClass, NUMBER_LITERAL_EXP_CS__NAME);

    bigNumberEClass = createEClass(BIG_NUMBER);
    createEAttribute(bigNumberEClass, BIG_NUMBER__NUMBER);

    stringLiteralExpCSEClass = createEClass(STRING_LITERAL_EXP_CS);
    createEAttribute(stringLiteralExpCSEClass, STRING_LITERAL_EXP_CS__NAME);

    booleanLiteralExpCSEClass = createEClass(BOOLEAN_LITERAL_EXP_CS);
    createEAttribute(booleanLiteralExpCSEClass, BOOLEAN_LITERAL_EXP_CS__NAME);

    unlimitedNaturalLiteralExpCSEClass = createEClass(UNLIMITED_NATURAL_LITERAL_EXP_CS);

    invalidLiteralExpCSEClass = createEClass(INVALID_LITERAL_EXP_CS);

    nullLiteralExpCSEClass = createEClass(NULL_LITERAL_EXP_CS);

    prefixExpCSEClass = createEClass(PREFIX_EXP_CS);
    createEReference(prefixExpCSEClass, PREFIX_EXP_CS__OWNED_OPERATOR);
    createEReference(prefixExpCSEClass, PREFIX_EXP_CS__OWNED_EXPRESSION);

    indexExpCSEClass = createEClass(INDEX_EXP_CS);
    createEReference(indexExpCSEClass, INDEX_EXP_CS__PATH_NAME);
    createEReference(indexExpCSEClass, INDEX_EXP_CS__FIRST_INDEXES);
    createEReference(indexExpCSEClass, INDEX_EXP_CS__SECOND_INDEXES);
    createEAttribute(indexExpCSEClass, INDEX_EXP_CS__AT_PRE);

    constructorExpCSEClass = createEClass(CONSTRUCTOR_EXP_CS);
    createEReference(constructorExpCSEClass, CONSTRUCTOR_EXP_CS__PATH_NAME);
    createEReference(constructorExpCSEClass, CONSTRUCTOR_EXP_CS__OWNED_PARTS);
    createEAttribute(constructorExpCSEClass, CONSTRUCTOR_EXP_CS__VALUE);

    invocationExpCSEClass = createEClass(INVOCATION_EXP_CS);
    createEReference(invocationExpCSEClass, INVOCATION_EXP_CS__PATH_NAME);
    createEAttribute(invocationExpCSEClass, INVOCATION_EXP_CS__AT_PRE);
    createEReference(invocationExpCSEClass, INVOCATION_EXP_CS__ARGUMENT);

    nameExpCSEClass = createEClass(NAME_EXP_CS);
    createEReference(nameExpCSEClass, NAME_EXP_CS__PATH_NAME);
    createEAttribute(nameExpCSEClass, NAME_EXP_CS__AT_PRE);
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
    classifierContextDeclCSEClass.getESuperTypes().add(this.getoclExpr());
    defPropertyCSEClass.getESuperTypes().add(this.getDefCS());
    multiplicityStringCSEClass.getESuperTypes().add(this.getMultiplicityCS());
    multiplicityBoundsCSEClass.getESuperTypes().add(this.getMultiplicityCS());
    nameSpaceEClass.getESuperTypes().add(this.getNamedElement());
    typeNameExpCSEClass.getESuperTypes().add(this.getTypedRefCS());
    essentialOCLInfixOperatorCSEClass.getESuperTypes().add(this.getBinaryOperatorCS());
    navigationOperatorCSEClass.getESuperTypes().add(this.getBinaryOperatorCS());
    expressCSEClass.getESuperTypes().add(this.getoclExpr());
    expressCSEClass.getESuperTypes().add(this.getExpCS());
    typeLiteralCSEClass.getESuperTypes().add(this.getTypeLiteralWithMultiplicityCS());
    tupleTypeCSEClass.getESuperTypes().add(this.getTypeLiteralCS());
    primitiveTypeCSEClass.getESuperTypes().add(this.getTypeLiteralCS());
    typeLiteralExpCSEClass.getESuperTypes().add(this.getPrimaryExpCS());
    collectionLiteralExpCSEClass.getESuperTypes().add(this.getPrimaryExpCS());
    collectionTypeCSEClass.getESuperTypes().add(this.getTypeLiteralCS());
    nestedExpCSEClass.getESuperTypes().add(this.getPrimaryExpCS());
    selfExpCSEClass.getESuperTypes().add(this.getPrimaryExpCS());
    primaryExpOrLetExpCSEClass.getESuperTypes().add(this.getExpressCS());
    primaryExpOrLetExpCSEClass.getESuperTypes().add(this.getPrefixedExpOrLetExpCS());
    letExpCSEClass.getESuperTypes().add(this.getPrimaryExpOrLetExpCS());
    ifExpCSEClass.getESuperTypes().add(this.getPrimaryExpCS());
    tupleLiteralExpCSEClass.getESuperTypes().add(this.getPrimaryExpCS());
    primitiveLiteralExpCSEClass.getESuperTypes().add(this.getPrimaryExpCS());
    numberLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
    stringLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
    booleanLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
    unlimitedNaturalLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
    invalidLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
    nullLiteralExpCSEClass.getESuperTypes().add(this.getPrimitiveLiteralExpCS());
    prefixExpCSEClass.getESuperTypes().add(this.getPrefixedExpCS());
    prefixExpCSEClass.getESuperTypes().add(this.getPrefixedExpOrLetExpCS());
    indexExpCSEClass.getESuperTypes().add(this.getPrimaryExpCS());
    constructorExpCSEClass.getESuperTypes().add(this.getPrimaryExpCS());
    invocationExpCSEClass.getESuperTypes().add(this.getPrimaryExpCS());
    nameExpCSEClass.getESuperTypes().add(this.getPrimaryExpCS());

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
    initEReference(getTransformationDependency_RequiredTransformations(), this.getRuleDependency(), null, "requiredTransformations", null, 0, -1, TransformationDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTransformationDependency_BoolOP(), this.getBooleanOperations(), null, "boolOP", null, 0, 1, TransformationDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanOperationsEClass, BooleanOperations.class, "BooleanOperations", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBooleanOperations_Name(), ecorePackage.getEString(), "name", null, 0, 1, BooleanOperations.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(ruleDependencyEClass, RuleDependency.class, "RuleDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getRuleDependency_Kw(), this.getKeyWord(), null, "kw", null, 0, 1, RuleDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleDependency_Red(), this.getrequiresOrExcludeDependency(), null, "red", null, 0, -1, RuleDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getRuleDependency_BoolOP(), this.getBooleanOperations(), null, "boolOP", null, 0, 1, RuleDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(keyWordEClass, KeyWord.class, "KeyWord", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getKeyWord_Name(), ecorePackage.getEString(), "name", null, 0, 1, KeyWord.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(requiresOrExcludeDependencyEClass, requiresOrExcludeDependency.class, "requiresOrExcludeDependency", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getrequiresOrExcludeDependency_RequiredTransformation(), this.getTransformation(), null, "requiredTransformation", null, 0, -1, requiresOrExcludeDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getrequiresOrExcludeDependency_RequiredRule(), this.gettrcRule(), null, "requiredRule", null, 0, -1, requiresOrExcludeDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getrequiresOrExcludeDependency_Fields(), ecorePackage.getEString(), "fields", null, 0, 1, requiresOrExcludeDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getrequiresOrExcludeDependency_OclExpression(), this.getoclExpr(), null, "oclExpression", null, 0, -1, requiresOrExcludeDependency.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(oclExprEClass, oclExpr.class, "oclExpr", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(classifierContextDeclCSEClass, ClassifierContextDeclCS.class, "ClassifierContextDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getClassifierContextDeclCS_SelfName(), ecorePackage.getEString(), "selfName", null, 0, 1, ClassifierContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassifierContextDeclCS_Invariants(), this.getConstraintCS(), null, "invariants", null, 0, -1, ClassifierContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getClassifierContextDeclCS_Definitions(), this.getDefCS(), null, "definitions", null, 0, -1, ClassifierContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(operationContextDeclCSEClass, OperationContextDeclCS.class, "OperationContextDeclCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getOperationContextDeclCS_PathName(), this.getPathNameCS(), null, "pathName", null, 0, 1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationContextDeclCS_Parameters(), this.getParameterCS(), null, "parameters", null, 0, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationContextDeclCS_OwnedType(), this.getTypedRefCS(), null, "ownedType", null, 0, 1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationContextDeclCS_Preconditions(), this.getConstraintCS(), null, "preconditions", null, 0, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationContextDeclCS_Postconditions(), this.getConstraintCS(), null, "postconditions", null, 0, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getOperationContextDeclCS_Bodies(), this.getSpecificationCS(), null, "bodies", null, 0, -1, OperationContextDeclCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(parameterCSEClass, ParameterCS.class, "ParameterCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getParameterCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, ParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getParameterCS_OwnedType(), this.getTypedRefCS(), null, "ownedType", null, 0, 1, ParameterCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constraintCSEClass, ConstraintCS.class, "ConstraintCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getConstraintCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstraintCS_MessageSpecification(), this.getSpecificationCS(), null, "messageSpecification", null, 0, 1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstraintCS_Specification(), this.getSpecificationCS(), null, "specification", null, 0, -1, ConstraintCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(defCSEClass, DefCS.class, "DefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(defPropertyCSEClass, DefPropertyCS.class, "DefPropertyCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getDefPropertyCS_Static(), ecorePackage.getEBoolean(), "static", null, 0, 1, DefPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getDefPropertyCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, DefPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDefPropertyCS_OwnedType(), this.getTypedRefCS(), null, "ownedType", null, 0, 1, DefPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getDefPropertyCS_Specification(), this.getSpecificationCS(), null, "specification", null, 0, 1, DefPropertyCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typedRefCSEClass, TypedRefCS.class, "TypedRefCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(multiplicityCSEClass, MultiplicityCS.class, "MultiplicityCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(multiplicityStringCSEClass, MultiplicityStringCS.class, "MultiplicityStringCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMultiplicityStringCS_StringBounds(), ecorePackage.getEString(), "stringBounds", null, 0, 1, MultiplicityStringCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(multiplicityBoundsCSEClass, MultiplicityBoundsCS.class, "MultiplicityBoundsCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getMultiplicityBoundsCS_LowerBound(), ecorePackage.getEInt(), "lowerBound", null, 0, 1, MultiplicityBoundsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getMultiplicityBoundsCS_UpperBound(), ecorePackage.getEInt(), "upperBound", null, 0, 1, MultiplicityBoundsCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(namedElementEClass, NamedElement.class, "NamedElement", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNamedElement_IsStatic(), ecorePackage.getEBoolean(), "isStatic", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNamedElement_Name(), ecorePackage.getEString(), "name", null, 0, 1, NamedElement.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nameSpaceEClass, NameSpace.class, "NameSpace", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getNameSpace_ID(), ecorePackage.getEString(), "ID", null, 0, 1, NameSpace.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeNameExpCSEClass, TypeNameExpCS.class, "TypeNameExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeNameExpCS_Multiplicity(), this.getMultiplicityCS(), null, "multiplicity", null, 0, 1, TypeNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTypeNameExpCS_PathName(), this.getPathNameCS(), null, "pathName", null, 0, 1, TypeNameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pathNameCSEClass, PathNameCS.class, "PathNameCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPathNameCS_Path(), this.getPathElementCS(), null, "path", null, 0, -1, PathNameCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(pathElementCSEClass, PathElementCS.class, "PathElementCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPathElementCS_Element(), this.getNamedElement(), null, "element", null, 0, 1, PathElementCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(specificationCSEClass, SpecificationCS.class, "SpecificationCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getSpecificationCS_OwnedExpression(), this.getContextCs(), null, "ownedExpression", null, 0, -1, SpecificationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getSpecificationCS_ExprString(), ecorePackage.getEString(), "exprString", null, 0, 1, SpecificationCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(essentialOCLInfixOperatorCSEClass, EssentialOCLInfixOperatorCS.class, "EssentialOCLInfixOperatorCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(binaryOperatorCSEClass, BinaryOperatorCS.class, "BinaryOperatorCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBinaryOperatorCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, BinaryOperatorCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(navigationOperatorCSEClass, NavigationOperatorCS.class, "NavigationOperatorCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(contextCsEClass, ContextCs.class, "ContextCs", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getContextCs_OwnedExpression(), this.getLetExpCS(), null, "ownedExpression", null, 0, -1, ContextCs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContextCs_B(), this.getBinaryOperatorCS(), null, "B", null, 0, 1, ContextCs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getContextCs_BO(), this.getBinaryOperatorCS(), null, "BO", null, 0, 1, ContextCs.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expressCSEClass, ExpressCS.class, "ExpressCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getExpressCS_OwnedExpression(), ecorePackage.getEObject(), null, "ownedExpression", null, 0, -1, ExpressCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getExpressCS_OwnedOperator(), ecorePackage.getEObject(), null, "ownedOperator", null, 0, -1, ExpressCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(prefixedExpCSEClass, PrefixedExpCS.class, "PrefixedExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(essentialOCLPrefixOperatorEClass, EssentialOCLPrefixOperator.class, "EssentialOCLPrefixOperator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getEssentialOCLPrefixOperator_Name(), ecorePackage.getEString(), "name", null, 0, 1, EssentialOCLPrefixOperator.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(prefixedExpOrLetExpCSEClass, PrefixedExpOrLetExpCS.class, "PrefixedExpOrLetExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(primaryExpCSEClass, PrimaryExpCS.class, "PrimaryExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(constructorPartCSEClass, ConstructorPartCS.class, "ConstructorPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getConstructorPartCS_Property(), ecorePackage.getEString(), "property", null, 0, 1, ConstructorPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstructorPartCS_InitExpression(), this.getExpressCS(), null, "initExpression", null, 0, 1, ConstructorPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(typeLiteralWithMultiplicityCSEClass, TypeLiteralWithMultiplicityCS.class, "TypeLiteralWithMultiplicityCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(typeLiteralCSEClass, TypeLiteralCS.class, "TypeLiteralCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeLiteralCS_Multiplicity(), this.getMultiplicityCS(), null, "multiplicity", null, 0, 1, TypeLiteralCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getTypeLiteralCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, TypeLiteralCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tupleTypeCSEClass, TupleTypeCS.class, "TupleTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTupleTypeCS_OwnedParts(), this.getTuplePartCS(), null, "ownedParts", null, 0, -1, TupleTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tuplePartCSEClass, TuplePartCS.class, "TuplePartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTuplePartCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, TuplePartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTuplePartCS_OwnedType(), this.getTypedRefCS(), null, "ownedType", null, 0, 1, TuplePartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(primitiveTypeCSEClass, PrimitiveTypeCS.class, "PrimitiveTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(typeLiteralExpCSEClass, TypeLiteralExpCS.class, "TypeLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTypeLiteralExpCS_OwnedType(), this.getTypeLiteralWithMultiplicityCS(), null, "ownedType", null, 0, 1, TypeLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(collectionLiteralExpCSEClass, CollectionLiteralExpCS.class, "CollectionLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCollectionLiteralExpCS_OwnedType(), this.getCollectionTypeCS(), null, "ownedType", null, 0, 1, CollectionLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCollectionLiteralExpCS_OwnedParts(), this.getCollectionLiteralPartCS(), null, "ownedParts", null, 0, -1, CollectionLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(collectionLiteralPartCSEClass, CollectionLiteralPartCS.class, "CollectionLiteralPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCollectionLiteralPartCS_ExpressionCS(), this.getExpressCS(), null, "expressionCS", null, 0, 1, CollectionLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getCollectionLiteralPartCS_LastExpressionCS(), this.getExpressCS(), null, "lastExpressionCS", null, 0, 1, CollectionLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(collectionTypeCSEClass, CollectionTypeCS.class, "CollectionTypeCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getCollectionTypeCS_OwnedType(), this.getTypedRefCS(), null, "ownedType", null, 0, 1, CollectionTypeCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nestedExpCSEClass, NestedExpCS.class, "NestedExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNestedExpCS_Source(), this.getExpressCS(), null, "source", null, 0, 1, NestedExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(selfExpCSEClass, SelfExpCS.class, "SelfExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(primaryExpOrLetExpCSEClass, PrimaryExpOrLetExpCS.class, "PrimaryExpOrLetExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(letExpCSEClass, LetExpCS.class, "LetExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getLetExpCS_Variable(), this.getLetVariableCS(), null, "variable", null, 0, -1, LetExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLetExpCS_In(), this.getExpressCS(), null, "in", null, 0, 1, LetExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(letVariableCSEClass, LetVariableCS.class, "LetVariableCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getLetVariableCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, LetVariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLetVariableCS_OwnedType(), this.getTypedRefCS(), null, "ownedType", null, 0, 1, LetVariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getLetVariableCS_InitExpression(), this.getExpressCS(), null, "initExpression", null, 0, 1, LetVariableCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(navigatingArgCSEClass, NavigatingArgCS.class, "NavigatingArgCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNavigatingArgCS_Name(), this.getExpCS(), null, "name", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNavigatingArgCS_OwnedType(), this.getTypedRefCS(), null, "ownedType", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getNavigatingArgCS_Init(), this.getExpressCS(), null, "init", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNavigatingArgCS_Prefix(), ecorePackage.getEString(), "prefix", null, 0, 1, NavigatingArgCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(expCSEClass, ExpCS.class, "ExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(ifExpCSEClass, IfExpCS.class, "IfExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIfExpCS_Condition(), this.getExpressCS(), null, "condition", null, 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfExpCS_ThenExpression(), this.getExpressCS(), null, "thenExpression", null, 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIfExpCS_ElseExpression(), this.getExpressCS(), null, "elseExpression", null, 0, 1, IfExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tupleLiteralExpCSEClass, TupleLiteralExpCS.class, "TupleLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getTupleLiteralExpCS_OwnedParts(), this.getTupleLiteralPartCS(), null, "ownedParts", null, 0, -1, TupleLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(tupleLiteralPartCSEClass, TupleLiteralPartCS.class, "TupleLiteralPartCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getTupleLiteralPartCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, TupleLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTupleLiteralPartCS_OwnedType(), this.getTypedRefCS(), null, "ownedType", null, 0, 1, TupleLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getTupleLiteralPartCS_InitExpression(), this.getExpressCS(), null, "initExpression", null, 0, 1, TupleLiteralPartCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(primitiveLiteralExpCSEClass, PrimitiveLiteralExpCS.class, "PrimitiveLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(numberLiteralExpCSEClass, NumberLiteralExpCS.class, "NumberLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNumberLiteralExpCS_Name(), this.getBigNumber(), null, "name", null, 0, 1, NumberLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(bigNumberEClass, BigNumber.class, "BigNumber", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBigNumber_Number(), ecorePackage.getEInt(), "number", null, 0, 1, BigNumber.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(stringLiteralExpCSEClass, StringLiteralExpCS.class, "StringLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getStringLiteralExpCS_Name(), ecorePackage.getEString(), "name", null, 0, -1, StringLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, !IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(booleanLiteralExpCSEClass, BooleanLiteralExpCS.class, "BooleanLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEAttribute(getBooleanLiteralExpCS_Name(), ecorePackage.getEString(), "name", null, 0, 1, BooleanLiteralExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(unlimitedNaturalLiteralExpCSEClass, UnlimitedNaturalLiteralExpCS.class, "UnlimitedNaturalLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(invalidLiteralExpCSEClass, InvalidLiteralExpCS.class, "InvalidLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(nullLiteralExpCSEClass, NullLiteralExpCS.class, "NullLiteralExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

    initEClass(prefixExpCSEClass, PrefixExpCS.class, "PrefixExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getPrefixExpCS_OwnedOperator(), this.getEssentialOCLPrefixOperator(), null, "ownedOperator", null, 0, -1, PrefixExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getPrefixExpCS_OwnedExpression(), this.getPrimaryExpOrLetExpCS(), null, "ownedExpression", null, 0, 1, PrefixExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(indexExpCSEClass, IndexExpCS.class, "IndexExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getIndexExpCS_PathName(), this.getPathNameCS(), null, "pathName", null, 0, 1, IndexExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIndexExpCS_FirstIndexes(), this.getExpressCS(), null, "firstIndexes", null, 0, -1, IndexExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getIndexExpCS_SecondIndexes(), this.getExpressCS(), null, "secondIndexes", null, 0, -1, IndexExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getIndexExpCS_AtPre(), ecorePackage.getEBoolean(), "atPre", null, 0, 1, IndexExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(constructorExpCSEClass, ConstructorExpCS.class, "ConstructorExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getConstructorExpCS_PathName(), this.getPathNameCS(), null, "pathName", null, 0, 1, ConstructorExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getConstructorExpCS_OwnedParts(), this.getConstructorPartCS(), null, "ownedParts", null, 0, -1, ConstructorExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getConstructorExpCS_Value(), ecorePackage.getEString(), "value", null, 0, 1, ConstructorExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(invocationExpCSEClass, InvocationExpCS.class, "InvocationExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getInvocationExpCS_PathName(), this.getPathNameCS(), null, "pathName", null, 0, 1, InvocationExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getInvocationExpCS_AtPre(), ecorePackage.getEBoolean(), "atPre", null, 0, 1, InvocationExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEReference(getInvocationExpCS_Argument(), this.getNavigatingArgCS(), null, "argument", null, 0, -1, InvocationExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    initEClass(nameExpCSEClass, NameExpCS.class, "NameExpCS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
    initEReference(getNameExpCS_PathName(), this.getPathNameCS(), null, "pathName", null, 0, 1, NameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
    initEAttribute(getNameExpCS_AtPre(), ecorePackage.getEBoolean(), "atPre", null, 0, 1, NameExpCS.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

    // Create resource
    createResource(eNS_URI);
  }

} //TRCPackageImpl
