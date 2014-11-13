/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class TRCFactoryImpl extends EFactoryImpl implements TRCFactory
{
  /**
   * Creates the default factory implementation.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public static TRCFactory init()
  {
    try
    {
      TRCFactory theTRCFactory = (TRCFactory)EPackage.Registry.INSTANCE.getEFactory(TRCPackage.eNS_URI);
      if (theTRCFactory != null)
      {
        return theTRCFactory;
      }
    }
    catch (Exception exception)
    {
      EcorePlugin.INSTANCE.log(exception);
    }
    return new TRCFactoryImpl();
  }

  /**
   * Creates an instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TRCFactoryImpl()
  {
    super();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  @Override
  public EObject create(EClass eClass)
  {
    switch (eClass.getClassifierID())
    {
      case TRCPackage.TRC_SPECIFICATION: return createTrcSpecification();
      case TRCPackage.TRC_RULE: return createtrcRule();
      case TRCPackage.MODULE_LIST: return createModuleList();
      case TRCPackage.MODULE: return createModule();
      case TRCPackage.TRANSFORMATION_LIST: return createTransformationList();
      case TRCPackage.TRANSFORMATION: return createTransformation();
      case TRCPackage.TRANSFORMATION_IMPACT: return createTransformationImpact();
      case TRCPackage.TRANSFORMATION_DEPENDENCY_LIST: return createTransformationDependencyList();
      case TRCPackage.TRANSFORMATION_DEPENDENCY: return createTransformationDependency();
      case TRCPackage.BOOLEAN_OPERATIONS: return createBooleanOperations();
      case TRCPackage.RULE_DEPENDENCY: return createRuleDependency();
      case TRCPackage.KEY_WORD: return createKeyWord();
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY: return createrequiresOrExcludeDependency();
      case TRCPackage.OCL_EXPR: return createoclExpr();
      case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS: return createClassifierContextDeclCS();
      case TRCPackage.OPERATION_CONTEXT_DECL_CS: return createOperationContextDeclCS();
      case TRCPackage.PARAMETER_CS: return createParameterCS();
      case TRCPackage.CONSTRAINT_CS: return createConstraintCS();
      case TRCPackage.DEF_CS: return createDefCS();
      case TRCPackage.DEF_PROPERTY_CS: return createDefPropertyCS();
      case TRCPackage.TYPED_REF_CS: return createTypedRefCS();
      case TRCPackage.MULTIPLICITY_CS: return createMultiplicityCS();
      case TRCPackage.MULTIPLICITY_STRING_CS: return createMultiplicityStringCS();
      case TRCPackage.MULTIPLICITY_BOUNDS_CS: return createMultiplicityBoundsCS();
      case TRCPackage.NAMED_ELEMENT: return createNamedElement();
      case TRCPackage.NAME_SPACE: return createNameSpace();
      case TRCPackage.TYPE_NAME_EXP_CS: return createTypeNameExpCS();
      case TRCPackage.PATH_NAME_CS: return createPathNameCS();
      case TRCPackage.PATH_ELEMENT_CS: return createPathElementCS();
      case TRCPackage.SPECIFICATION_CS: return createSpecificationCS();
      case TRCPackage.ESSENTIAL_OCL_INFIX_OPERATOR_CS: return createEssentialOCLInfixOperatorCS();
      case TRCPackage.BINARY_OPERATOR_CS: return createBinaryOperatorCS();
      case TRCPackage.NAVIGATION_OPERATOR_CS: return createNavigationOperatorCS();
      case TRCPackage.CONTEXT_CS: return createContextCs();
      case TRCPackage.EXPRESS_CS: return createExpressCS();
      case TRCPackage.PREFIXED_EXP_CS: return createPrefixedExpCS();
      case TRCPackage.ESSENTIAL_OCL_PREFIX_OPERATOR: return createEssentialOCLPrefixOperator();
      case TRCPackage.PREFIXED_EXP_OR_LET_EXP_CS: return createPrefixedExpOrLetExpCS();
      case TRCPackage.PRIMARY_EXP_CS: return createPrimaryExpCS();
      case TRCPackage.CONSTRUCTOR_PART_CS: return createConstructorPartCS();
      case TRCPackage.TYPE_LITERAL_WITH_MULTIPLICITY_CS: return createTypeLiteralWithMultiplicityCS();
      case TRCPackage.TYPE_LITERAL_CS: return createTypeLiteralCS();
      case TRCPackage.TUPLE_TYPE_CS: return createTupleTypeCS();
      case TRCPackage.TUPLE_PART_CS: return createTuplePartCS();
      case TRCPackage.PRIMITIVE_TYPE_CS: return createPrimitiveTypeCS();
      case TRCPackage.TYPE_LITERAL_EXP_CS: return createTypeLiteralExpCS();
      case TRCPackage.COLLECTION_LITERAL_EXP_CS: return createCollectionLiteralExpCS();
      case TRCPackage.COLLECTION_LITERAL_PART_CS: return createCollectionLiteralPartCS();
      case TRCPackage.COLLECTION_TYPE_CS: return createCollectionTypeCS();
      case TRCPackage.NESTED_EXP_CS: return createNestedExpCS();
      case TRCPackage.SELF_EXP_CS: return createSelfExpCS();
      case TRCPackage.PRIMARY_EXP_OR_LET_EXP_CS: return createPrimaryExpOrLetExpCS();
      case TRCPackage.LET_EXP_CS: return createLetExpCS();
      case TRCPackage.LET_VARIABLE_CS: return createLetVariableCS();
      case TRCPackage.NAVIGATING_ARG_CS: return createNavigatingArgCS();
      case TRCPackage.EXP_CS: return createExpCS();
      case TRCPackage.IF_EXP_CS: return createIfExpCS();
      case TRCPackage.TUPLE_LITERAL_EXP_CS: return createTupleLiteralExpCS();
      case TRCPackage.TUPLE_LITERAL_PART_CS: return createTupleLiteralPartCS();
      case TRCPackage.PRIMITIVE_LITERAL_EXP_CS: return createPrimitiveLiteralExpCS();
      case TRCPackage.NUMBER_LITERAL_EXP_CS: return createNumberLiteralExpCS();
      case TRCPackage.BIG_NUMBER: return createBigNumber();
      case TRCPackage.STRING_LITERAL_EXP_CS: return createStringLiteralExpCS();
      case TRCPackage.BOOLEAN_LITERAL_EXP_CS: return createBooleanLiteralExpCS();
      case TRCPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS: return createUnlimitedNaturalLiteralExpCS();
      case TRCPackage.INVALID_LITERAL_EXP_CS: return createInvalidLiteralExpCS();
      case TRCPackage.NULL_LITERAL_EXP_CS: return createNullLiteralExpCS();
      case TRCPackage.PREFIX_EXP_CS: return createPrefixExpCS();
      case TRCPackage.INDEX_EXP_CS: return createIndexExpCS();
      case TRCPackage.CONSTRUCTOR_EXP_CS: return createConstructorExpCS();
      case TRCPackage.INVOCATION_EXP_CS: return createInvocationExpCS();
      case TRCPackage.NAME_EXP_CS: return createNameExpCS();
      default:
        throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
    }
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TrcSpecification createTrcSpecification()
  {
    TrcSpecificationImpl trcSpecification = new TrcSpecificationImpl();
    return trcSpecification;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public trcRule createtrcRule()
  {
    trcRuleImpl trcRule = new trcRuleImpl();
    return trcRule;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ModuleList createModuleList()
  {
    ModuleListImpl moduleList = new ModuleListImpl();
    return moduleList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Module createModule()
  {
    ModuleImpl module = new ModuleImpl();
    return module;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransformationList createTransformationList()
  {
    TransformationListImpl transformationList = new TransformationListImpl();
    return transformationList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public Transformation createTransformation()
  {
    TransformationImpl transformation = new TransformationImpl();
    return transformation;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransformationImpact createTransformationImpact()
  {
    TransformationImpactImpl transformationImpact = new TransformationImpactImpl();
    return transformationImpact;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransformationDependencyList createTransformationDependencyList()
  {
    TransformationDependencyListImpl transformationDependencyList = new TransformationDependencyListImpl();
    return transformationDependencyList;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TransformationDependency createTransformationDependency()
  {
    TransformationDependencyImpl transformationDependency = new TransformationDependencyImpl();
    return transformationDependency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanOperations createBooleanOperations()
  {
    BooleanOperationsImpl booleanOperations = new BooleanOperationsImpl();
    return booleanOperations;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public RuleDependency createRuleDependency()
  {
    RuleDependencyImpl ruleDependency = new RuleDependencyImpl();
    return ruleDependency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public KeyWord createKeyWord()
  {
    KeyWordImpl keyWord = new KeyWordImpl();
    return keyWord;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public requiresOrExcludeDependency createrequiresOrExcludeDependency()
  {
    requiresOrExcludeDependencyImpl requiresOrExcludeDependency = new requiresOrExcludeDependencyImpl();
    return requiresOrExcludeDependency;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public oclExpr createoclExpr()
  {
    oclExprImpl oclExpr = new oclExprImpl();
    return oclExpr;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ClassifierContextDeclCS createClassifierContextDeclCS()
  {
    ClassifierContextDeclCSImpl classifierContextDeclCS = new ClassifierContextDeclCSImpl();
    return classifierContextDeclCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public OperationContextDeclCS createOperationContextDeclCS()
  {
    OperationContextDeclCSImpl operationContextDeclCS = new OperationContextDeclCSImpl();
    return operationContextDeclCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ParameterCS createParameterCS()
  {
    ParameterCSImpl parameterCS = new ParameterCSImpl();
    return parameterCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstraintCS createConstraintCS()
  {
    ConstraintCSImpl constraintCS = new ConstraintCSImpl();
    return constraintCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefCS createDefCS()
  {
    DefCSImpl defCS = new DefCSImpl();
    return defCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public DefPropertyCS createDefPropertyCS()
  {
    DefPropertyCSImpl defPropertyCS = new DefPropertyCSImpl();
    return defPropertyCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypedRefCS createTypedRefCS()
  {
    TypedRefCSImpl typedRefCS = new TypedRefCSImpl();
    return typedRefCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityCS createMultiplicityCS()
  {
    MultiplicityCSImpl multiplicityCS = new MultiplicityCSImpl();
    return multiplicityCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityStringCS createMultiplicityStringCS()
  {
    MultiplicityStringCSImpl multiplicityStringCS = new MultiplicityStringCSImpl();
    return multiplicityStringCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public MultiplicityBoundsCS createMultiplicityBoundsCS()
  {
    MultiplicityBoundsCSImpl multiplicityBoundsCS = new MultiplicityBoundsCSImpl();
    return multiplicityBoundsCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NamedElement createNamedElement()
  {
    NamedElementImpl namedElement = new NamedElementImpl();
    return namedElement;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameSpace createNameSpace()
  {
    NameSpaceImpl nameSpace = new NameSpaceImpl();
    return nameSpace;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeNameExpCS createTypeNameExpCS()
  {
    TypeNameExpCSImpl typeNameExpCS = new TypeNameExpCSImpl();
    return typeNameExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PathNameCS createPathNameCS()
  {
    PathNameCSImpl pathNameCS = new PathNameCSImpl();
    return pathNameCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PathElementCS createPathElementCS()
  {
    PathElementCSImpl pathElementCS = new PathElementCSImpl();
    return pathElementCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SpecificationCS createSpecificationCS()
  {
    SpecificationCSImpl specificationCS = new SpecificationCSImpl();
    return specificationCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EssentialOCLInfixOperatorCS createEssentialOCLInfixOperatorCS()
  {
    EssentialOCLInfixOperatorCSImpl essentialOCLInfixOperatorCS = new EssentialOCLInfixOperatorCSImpl();
    return essentialOCLInfixOperatorCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BinaryOperatorCS createBinaryOperatorCS()
  {
    BinaryOperatorCSImpl binaryOperatorCS = new BinaryOperatorCSImpl();
    return binaryOperatorCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NavigationOperatorCS createNavigationOperatorCS()
  {
    NavigationOperatorCSImpl navigationOperatorCS = new NavigationOperatorCSImpl();
    return navigationOperatorCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ContextCs createContextCs()
  {
    ContextCsImpl contextCs = new ContextCsImpl();
    return contextCs;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpressCS createExpressCS()
  {
    ExpressCSImpl expressCS = new ExpressCSImpl();
    return expressCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrefixedExpCS createPrefixedExpCS()
  {
    PrefixedExpCSImpl prefixedExpCS = new PrefixedExpCSImpl();
    return prefixedExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public EssentialOCLPrefixOperator createEssentialOCLPrefixOperator()
  {
    EssentialOCLPrefixOperatorImpl essentialOCLPrefixOperator = new EssentialOCLPrefixOperatorImpl();
    return essentialOCLPrefixOperator;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrefixedExpOrLetExpCS createPrefixedExpOrLetExpCS()
  {
    PrefixedExpOrLetExpCSImpl prefixedExpOrLetExpCS = new PrefixedExpOrLetExpCSImpl();
    return prefixedExpOrLetExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryExpCS createPrimaryExpCS()
  {
    PrimaryExpCSImpl primaryExpCS = new PrimaryExpCSImpl();
    return primaryExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstructorPartCS createConstructorPartCS()
  {
    ConstructorPartCSImpl constructorPartCS = new ConstructorPartCSImpl();
    return constructorPartCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeLiteralWithMultiplicityCS createTypeLiteralWithMultiplicityCS()
  {
    TypeLiteralWithMultiplicityCSImpl typeLiteralWithMultiplicityCS = new TypeLiteralWithMultiplicityCSImpl();
    return typeLiteralWithMultiplicityCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeLiteralCS createTypeLiteralCS()
  {
    TypeLiteralCSImpl typeLiteralCS = new TypeLiteralCSImpl();
    return typeLiteralCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TupleTypeCS createTupleTypeCS()
  {
    TupleTypeCSImpl tupleTypeCS = new TupleTypeCSImpl();
    return tupleTypeCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TuplePartCS createTuplePartCS()
  {
    TuplePartCSImpl tuplePartCS = new TuplePartCSImpl();
    return tuplePartCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveTypeCS createPrimitiveTypeCS()
  {
    PrimitiveTypeCSImpl primitiveTypeCS = new PrimitiveTypeCSImpl();
    return primitiveTypeCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TypeLiteralExpCS createTypeLiteralExpCS()
  {
    TypeLiteralExpCSImpl typeLiteralExpCS = new TypeLiteralExpCSImpl();
    return typeLiteralExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionLiteralExpCS createCollectionLiteralExpCS()
  {
    CollectionLiteralExpCSImpl collectionLiteralExpCS = new CollectionLiteralExpCSImpl();
    return collectionLiteralExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionLiteralPartCS createCollectionLiteralPartCS()
  {
    CollectionLiteralPartCSImpl collectionLiteralPartCS = new CollectionLiteralPartCSImpl();
    return collectionLiteralPartCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public CollectionTypeCS createCollectionTypeCS()
  {
    CollectionTypeCSImpl collectionTypeCS = new CollectionTypeCSImpl();
    return collectionTypeCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NestedExpCS createNestedExpCS()
  {
    NestedExpCSImpl nestedExpCS = new NestedExpCSImpl();
    return nestedExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public SelfExpCS createSelfExpCS()
  {
    SelfExpCSImpl selfExpCS = new SelfExpCSImpl();
    return selfExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimaryExpOrLetExpCS createPrimaryExpOrLetExpCS()
  {
    PrimaryExpOrLetExpCSImpl primaryExpOrLetExpCS = new PrimaryExpOrLetExpCSImpl();
    return primaryExpOrLetExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LetExpCS createLetExpCS()
  {
    LetExpCSImpl letExpCS = new LetExpCSImpl();
    return letExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public LetVariableCS createLetVariableCS()
  {
    LetVariableCSImpl letVariableCS = new LetVariableCSImpl();
    return letVariableCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NavigatingArgCS createNavigatingArgCS()
  {
    NavigatingArgCSImpl navigatingArgCS = new NavigatingArgCSImpl();
    return navigatingArgCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ExpCS createExpCS()
  {
    ExpCSImpl expCS = new ExpCSImpl();
    return expCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IfExpCS createIfExpCS()
  {
    IfExpCSImpl ifExpCS = new IfExpCSImpl();
    return ifExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TupleLiteralExpCS createTupleLiteralExpCS()
  {
    TupleLiteralExpCSImpl tupleLiteralExpCS = new TupleLiteralExpCSImpl();
    return tupleLiteralExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TupleLiteralPartCS createTupleLiteralPartCS()
  {
    TupleLiteralPartCSImpl tupleLiteralPartCS = new TupleLiteralPartCSImpl();
    return tupleLiteralPartCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrimitiveLiteralExpCS createPrimitiveLiteralExpCS()
  {
    PrimitiveLiteralExpCSImpl primitiveLiteralExpCS = new PrimitiveLiteralExpCSImpl();
    return primitiveLiteralExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NumberLiteralExpCS createNumberLiteralExpCS()
  {
    NumberLiteralExpCSImpl numberLiteralExpCS = new NumberLiteralExpCSImpl();
    return numberLiteralExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BigNumber createBigNumber()
  {
    BigNumberImpl bigNumber = new BigNumberImpl();
    return bigNumber;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public StringLiteralExpCS createStringLiteralExpCS()
  {
    StringLiteralExpCSImpl stringLiteralExpCS = new StringLiteralExpCSImpl();
    return stringLiteralExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public BooleanLiteralExpCS createBooleanLiteralExpCS()
  {
    BooleanLiteralExpCSImpl booleanLiteralExpCS = new BooleanLiteralExpCSImpl();
    return booleanLiteralExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public UnlimitedNaturalLiteralExpCS createUnlimitedNaturalLiteralExpCS()
  {
    UnlimitedNaturalLiteralExpCSImpl unlimitedNaturalLiteralExpCS = new UnlimitedNaturalLiteralExpCSImpl();
    return unlimitedNaturalLiteralExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvalidLiteralExpCS createInvalidLiteralExpCS()
  {
    InvalidLiteralExpCSImpl invalidLiteralExpCS = new InvalidLiteralExpCSImpl();
    return invalidLiteralExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NullLiteralExpCS createNullLiteralExpCS()
  {
    NullLiteralExpCSImpl nullLiteralExpCS = new NullLiteralExpCSImpl();
    return nullLiteralExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public PrefixExpCS createPrefixExpCS()
  {
    PrefixExpCSImpl prefixExpCS = new PrefixExpCSImpl();
    return prefixExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public IndexExpCS createIndexExpCS()
  {
    IndexExpCSImpl indexExpCS = new IndexExpCSImpl();
    return indexExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public ConstructorExpCS createConstructorExpCS()
  {
    ConstructorExpCSImpl constructorExpCS = new ConstructorExpCSImpl();
    return constructorExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public InvocationExpCS createInvocationExpCS()
  {
    InvocationExpCSImpl invocationExpCS = new InvocationExpCSImpl();
    return invocationExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public NameExpCS createNameExpCS()
  {
    NameExpCSImpl nameExpCS = new NameExpCSImpl();
    return nameExpCS;
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TRCPackage getTRCPackage()
  {
    return (TRCPackage)getEPackage();
  }

  /**
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @deprecated
   * @generated
   */
  @Deprecated
  public static TRCPackage getPackage()
  {
    return TRCPackage.eINSTANCE;
  }

} //TRCFactoryImpl
