/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage
 * @generated
 */
public interface TRCFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  TRCFactory eINSTANCE = fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.impl.TRCFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Trc Specification</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Trc Specification</em>'.
   * @generated
   */
  TrcSpecification createTrcSpecification();

  /**
   * Returns a new object of class '<em>trc Rule</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>trc Rule</em>'.
   * @generated
   */
  trcRule createtrcRule();

  /**
   * Returns a new object of class '<em>Module List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module List</em>'.
   * @generated
   */
  ModuleList createModuleList();

  /**
   * Returns a new object of class '<em>Module</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Module</em>'.
   * @generated
   */
  Module createModule();

  /**
   * Returns a new object of class '<em>Transformation List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transformation List</em>'.
   * @generated
   */
  TransformationList createTransformationList();

  /**
   * Returns a new object of class '<em>Transformation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transformation</em>'.
   * @generated
   */
  Transformation createTransformation();

  /**
   * Returns a new object of class '<em>Transformation Impact</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transformation Impact</em>'.
   * @generated
   */
  TransformationImpact createTransformationImpact();

  /**
   * Returns a new object of class '<em>Transformation Dependency List</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transformation Dependency List</em>'.
   * @generated
   */
  TransformationDependencyList createTransformationDependencyList();

  /**
   * Returns a new object of class '<em>Transformation Dependency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Transformation Dependency</em>'.
   * @generated
   */
  TransformationDependency createTransformationDependency();

  /**
   * Returns a new object of class '<em>Boolean Operations</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Operations</em>'.
   * @generated
   */
  BooleanOperations createBooleanOperations();

  /**
   * Returns a new object of class '<em>Rule Dependency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Rule Dependency</em>'.
   * @generated
   */
  RuleDependency createRuleDependency();

  /**
   * Returns a new object of class '<em>Key Word</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Key Word</em>'.
   * @generated
   */
  KeyWord createKeyWord();

  /**
   * Returns a new object of class '<em>requires Or Exclude Dependency</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>requires Or Exclude Dependency</em>'.
   * @generated
   */
  requiresOrExcludeDependency createrequiresOrExcludeDependency();

  /**
   * Returns a new object of class '<em>ocl Expr</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>ocl Expr</em>'.
   * @generated
   */
  oclExpr createoclExpr();

  /**
   * Returns a new object of class '<em>Classifier Context Decl CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Classifier Context Decl CS</em>'.
   * @generated
   */
  ClassifierContextDeclCS createClassifierContextDeclCS();

  /**
   * Returns a new object of class '<em>Operation Context Decl CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Operation Context Decl CS</em>'.
   * @generated
   */
  OperationContextDeclCS createOperationContextDeclCS();

  /**
   * Returns a new object of class '<em>Parameter CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parameter CS</em>'.
   * @generated
   */
  ParameterCS createParameterCS();

  /**
   * Returns a new object of class '<em>Constraint CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constraint CS</em>'.
   * @generated
   */
  ConstraintCS createConstraintCS();

  /**
   * Returns a new object of class '<em>Def CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Def CS</em>'.
   * @generated
   */
  DefCS createDefCS();

  /**
   * Returns a new object of class '<em>Def Property CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Def Property CS</em>'.
   * @generated
   */
  DefPropertyCS createDefPropertyCS();

  /**
   * Returns a new object of class '<em>Typed Ref CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Typed Ref CS</em>'.
   * @generated
   */
  TypedRefCS createTypedRefCS();

  /**
   * Returns a new object of class '<em>Multiplicity CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicity CS</em>'.
   * @generated
   */
  MultiplicityCS createMultiplicityCS();

  /**
   * Returns a new object of class '<em>Multiplicity String CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicity String CS</em>'.
   * @generated
   */
  MultiplicityStringCS createMultiplicityStringCS();

  /**
   * Returns a new object of class '<em>Multiplicity Bounds CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multiplicity Bounds CS</em>'.
   * @generated
   */
  MultiplicityBoundsCS createMultiplicityBoundsCS();

  /**
   * Returns a new object of class '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Named Element</em>'.
   * @generated
   */
  NamedElement createNamedElement();

  /**
   * Returns a new object of class '<em>Name Space</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Name Space</em>'.
   * @generated
   */
  NameSpace createNameSpace();

  /**
   * Returns a new object of class '<em>Type Name Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Name Exp CS</em>'.
   * @generated
   */
  TypeNameExpCS createTypeNameExpCS();

  /**
   * Returns a new object of class '<em>Path Name CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Path Name CS</em>'.
   * @generated
   */
  PathNameCS createPathNameCS();

  /**
   * Returns a new object of class '<em>Path Element CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Path Element CS</em>'.
   * @generated
   */
  PathElementCS createPathElementCS();

  /**
   * Returns a new object of class '<em>Specification CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Specification CS</em>'.
   * @generated
   */
  SpecificationCS createSpecificationCS();

  /**
   * Returns a new object of class '<em>Essential OCL Infix Operator CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Essential OCL Infix Operator CS</em>'.
   * @generated
   */
  EssentialOCLInfixOperatorCS createEssentialOCLInfixOperatorCS();

  /**
   * Returns a new object of class '<em>Binary Operator CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Binary Operator CS</em>'.
   * @generated
   */
  BinaryOperatorCS createBinaryOperatorCS();

  /**
   * Returns a new object of class '<em>Navigation Operator CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Navigation Operator CS</em>'.
   * @generated
   */
  NavigationOperatorCS createNavigationOperatorCS();

  /**
   * Returns a new object of class '<em>Context Cs</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Context Cs</em>'.
   * @generated
   */
  ContextCs createContextCs();

  /**
   * Returns a new object of class '<em>Express CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Express CS</em>'.
   * @generated
   */
  ExpressCS createExpressCS();

  /**
   * Returns a new object of class '<em>Prefixed Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Prefixed Exp CS</em>'.
   * @generated
   */
  PrefixedExpCS createPrefixedExpCS();

  /**
   * Returns a new object of class '<em>Essential OCL Prefix Operator</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Essential OCL Prefix Operator</em>'.
   * @generated
   */
  EssentialOCLPrefixOperator createEssentialOCLPrefixOperator();

  /**
   * Returns a new object of class '<em>Prefixed Exp Or Let Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Prefixed Exp Or Let Exp CS</em>'.
   * @generated
   */
  PrefixedExpOrLetExpCS createPrefixedExpOrLetExpCS();

  /**
   * Returns a new object of class '<em>Primary Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primary Exp CS</em>'.
   * @generated
   */
  PrimaryExpCS createPrimaryExpCS();

  /**
   * Returns a new object of class '<em>Constructor Part CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constructor Part CS</em>'.
   * @generated
   */
  ConstructorPartCS createConstructorPartCS();

  /**
   * Returns a new object of class '<em>Type Literal With Multiplicity CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Literal With Multiplicity CS</em>'.
   * @generated
   */
  TypeLiteralWithMultiplicityCS createTypeLiteralWithMultiplicityCS();

  /**
   * Returns a new object of class '<em>Type Literal CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Literal CS</em>'.
   * @generated
   */
  TypeLiteralCS createTypeLiteralCS();

  /**
   * Returns a new object of class '<em>Tuple Type CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple Type CS</em>'.
   * @generated
   */
  TupleTypeCS createTupleTypeCS();

  /**
   * Returns a new object of class '<em>Tuple Part CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple Part CS</em>'.
   * @generated
   */
  TuplePartCS createTuplePartCS();

  /**
   * Returns a new object of class '<em>Primitive Type CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primitive Type CS</em>'.
   * @generated
   */
  PrimitiveTypeCS createPrimitiveTypeCS();

  /**
   * Returns a new object of class '<em>Type Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Type Literal Exp CS</em>'.
   * @generated
   */
  TypeLiteralExpCS createTypeLiteralExpCS();

  /**
   * Returns a new object of class '<em>Collection Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Collection Literal Exp CS</em>'.
   * @generated
   */
  CollectionLiteralExpCS createCollectionLiteralExpCS();

  /**
   * Returns a new object of class '<em>Collection Literal Part CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Collection Literal Part CS</em>'.
   * @generated
   */
  CollectionLiteralPartCS createCollectionLiteralPartCS();

  /**
   * Returns a new object of class '<em>Collection Type CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Collection Type CS</em>'.
   * @generated
   */
  CollectionTypeCS createCollectionTypeCS();

  /**
   * Returns a new object of class '<em>Nested Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Nested Exp CS</em>'.
   * @generated
   */
  NestedExpCS createNestedExpCS();

  /**
   * Returns a new object of class '<em>Self Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Self Exp CS</em>'.
   * @generated
   */
  SelfExpCS createSelfExpCS();

  /**
   * Returns a new object of class '<em>Primary Exp Or Let Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primary Exp Or Let Exp CS</em>'.
   * @generated
   */
  PrimaryExpOrLetExpCS createPrimaryExpOrLetExpCS();

  /**
   * Returns a new object of class '<em>Let Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Let Exp CS</em>'.
   * @generated
   */
  LetExpCS createLetExpCS();

  /**
   * Returns a new object of class '<em>Let Variable CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Let Variable CS</em>'.
   * @generated
   */
  LetVariableCS createLetVariableCS();

  /**
   * Returns a new object of class '<em>Navigating Arg CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Navigating Arg CS</em>'.
   * @generated
   */
  NavigatingArgCS createNavigatingArgCS();

  /**
   * Returns a new object of class '<em>Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Exp CS</em>'.
   * @generated
   */
  ExpCS createExpCS();

  /**
   * Returns a new object of class '<em>If Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>If Exp CS</em>'.
   * @generated
   */
  IfExpCS createIfExpCS();

  /**
   * Returns a new object of class '<em>Tuple Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple Literal Exp CS</em>'.
   * @generated
   */
  TupleLiteralExpCS createTupleLiteralExpCS();

  /**
   * Returns a new object of class '<em>Tuple Literal Part CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Tuple Literal Part CS</em>'.
   * @generated
   */
  TupleLiteralPartCS createTupleLiteralPartCS();

  /**
   * Returns a new object of class '<em>Primitive Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Primitive Literal Exp CS</em>'.
   * @generated
   */
  PrimitiveLiteralExpCS createPrimitiveLiteralExpCS();

  /**
   * Returns a new object of class '<em>Number Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Number Literal Exp CS</em>'.
   * @generated
   */
  NumberLiteralExpCS createNumberLiteralExpCS();

  /**
   * Returns a new object of class '<em>Big Number</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Big Number</em>'.
   * @generated
   */
  BigNumber createBigNumber();

  /**
   * Returns a new object of class '<em>String Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Literal Exp CS</em>'.
   * @generated
   */
  StringLiteralExpCS createStringLiteralExpCS();

  /**
   * Returns a new object of class '<em>Boolean Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Literal Exp CS</em>'.
   * @generated
   */
  BooleanLiteralExpCS createBooleanLiteralExpCS();

  /**
   * Returns a new object of class '<em>Unlimited Natural Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Unlimited Natural Literal Exp CS</em>'.
   * @generated
   */
  UnlimitedNaturalLiteralExpCS createUnlimitedNaturalLiteralExpCS();

  /**
   * Returns a new object of class '<em>Invalid Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Invalid Literal Exp CS</em>'.
   * @generated
   */
  InvalidLiteralExpCS createInvalidLiteralExpCS();

  /**
   * Returns a new object of class '<em>Null Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Null Literal Exp CS</em>'.
   * @generated
   */
  NullLiteralExpCS createNullLiteralExpCS();

  /**
   * Returns a new object of class '<em>Prefix Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Prefix Exp CS</em>'.
   * @generated
   */
  PrefixExpCS createPrefixExpCS();

  /**
   * Returns a new object of class '<em>Index Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Index Exp CS</em>'.
   * @generated
   */
  IndexExpCS createIndexExpCS();

  /**
   * Returns a new object of class '<em>Constructor Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Constructor Exp CS</em>'.
   * @generated
   */
  ConstructorExpCS createConstructorExpCS();

  /**
   * Returns a new object of class '<em>Invocation Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Invocation Exp CS</em>'.
   * @generated
   */
  InvocationExpCS createInvocationExpCS();

  /**
   * Returns a new object of class '<em>Name Exp CS</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Name Exp CS</em>'.
   * @generated
   */
  NameExpCS createNameExpCS();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  TRCPackage getTRCPackage();

} //TRCFactory
