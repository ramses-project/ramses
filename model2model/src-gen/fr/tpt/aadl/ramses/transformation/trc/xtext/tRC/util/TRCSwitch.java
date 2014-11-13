/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.util;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.*;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage
 * @generated
 */
public class TRCSwitch<T> extends Switch<T>
{
  /**
   * The cached model package
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TRCPackage modelPackage;

  /**
   * Creates an instance of the switch.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TRCSwitch()
  {
    if (modelPackage == null)
    {
      modelPackage = TRCPackage.eINSTANCE;
    }
  }

  /**
   * Checks whether this is a switch for the given package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @parameter ePackage the package in question.
   * @return whether this is a switch for the given package.
   * @generated
   */
  @Override
  protected boolean isSwitchFor(EPackage ePackage)
  {
    return ePackage == modelPackage;
  }

  /**
   * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the first non-null result returned by a <code>caseXXX</code> call.
   * @generated
   */
  @Override
  protected T doSwitch(int classifierID, EObject theEObject)
  {
    switch (classifierID)
    {
      case TRCPackage.TRC_SPECIFICATION:
      {
        TrcSpecification trcSpecification = (TrcSpecification)theEObject;
        T result = caseTrcSpecification(trcSpecification);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.TRC_RULE:
      {
        trcRule trcRule = (trcRule)theEObject;
        T result = casetrcRule(trcRule);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.MODULE_LIST:
      {
        ModuleList moduleList = (ModuleList)theEObject;
        T result = caseModuleList(moduleList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.MODULE:
      {
        Module module = (Module)theEObject;
        T result = caseModule(module);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.TRANSFORMATION_LIST:
      {
        TransformationList transformationList = (TransformationList)theEObject;
        T result = caseTransformationList(transformationList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.TRANSFORMATION:
      {
        Transformation transformation = (Transformation)theEObject;
        T result = caseTransformation(transformation);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.TRANSFORMATION_IMPACT:
      {
        TransformationImpact transformationImpact = (TransformationImpact)theEObject;
        T result = caseTransformationImpact(transformationImpact);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.TRANSFORMATION_DEPENDENCY_LIST:
      {
        TransformationDependencyList transformationDependencyList = (TransformationDependencyList)theEObject;
        T result = caseTransformationDependencyList(transformationDependencyList);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.TRANSFORMATION_DEPENDENCY:
      {
        TransformationDependency transformationDependency = (TransformationDependency)theEObject;
        T result = caseTransformationDependency(transformationDependency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.BOOLEAN_OPERATIONS:
      {
        BooleanOperations booleanOperations = (BooleanOperations)theEObject;
        T result = caseBooleanOperations(booleanOperations);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.RULE_DEPENDENCY:
      {
        RuleDependency ruleDependency = (RuleDependency)theEObject;
        T result = caseRuleDependency(ruleDependency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.KEY_WORD:
      {
        KeyWord keyWord = (KeyWord)theEObject;
        T result = caseKeyWord(keyWord);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY:
      {
        requiresOrExcludeDependency requiresOrExcludeDependency = (requiresOrExcludeDependency)theEObject;
        T result = caserequiresOrExcludeDependency(requiresOrExcludeDependency);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.OCL_EXPR:
      {
        oclExpr oclExpr = (oclExpr)theEObject;
        T result = caseoclExpr(oclExpr);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS:
      {
        ClassifierContextDeclCS classifierContextDeclCS = (ClassifierContextDeclCS)theEObject;
        T result = caseClassifierContextDeclCS(classifierContextDeclCS);
        if (result == null) result = caseoclExpr(classifierContextDeclCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.OPERATION_CONTEXT_DECL_CS:
      {
        OperationContextDeclCS operationContextDeclCS = (OperationContextDeclCS)theEObject;
        T result = caseOperationContextDeclCS(operationContextDeclCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.PARAMETER_CS:
      {
        ParameterCS parameterCS = (ParameterCS)theEObject;
        T result = caseParameterCS(parameterCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.CONSTRAINT_CS:
      {
        ConstraintCS constraintCS = (ConstraintCS)theEObject;
        T result = caseConstraintCS(constraintCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.DEF_CS:
      {
        DefCS defCS = (DefCS)theEObject;
        T result = caseDefCS(defCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.DEF_PROPERTY_CS:
      {
        DefPropertyCS defPropertyCS = (DefPropertyCS)theEObject;
        T result = caseDefPropertyCS(defPropertyCS);
        if (result == null) result = caseDefCS(defPropertyCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.TYPED_REF_CS:
      {
        TypedRefCS typedRefCS = (TypedRefCS)theEObject;
        T result = caseTypedRefCS(typedRefCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.MULTIPLICITY_CS:
      {
        MultiplicityCS multiplicityCS = (MultiplicityCS)theEObject;
        T result = caseMultiplicityCS(multiplicityCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.MULTIPLICITY_STRING_CS:
      {
        MultiplicityStringCS multiplicityStringCS = (MultiplicityStringCS)theEObject;
        T result = caseMultiplicityStringCS(multiplicityStringCS);
        if (result == null) result = caseMultiplicityCS(multiplicityStringCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.MULTIPLICITY_BOUNDS_CS:
      {
        MultiplicityBoundsCS multiplicityBoundsCS = (MultiplicityBoundsCS)theEObject;
        T result = caseMultiplicityBoundsCS(multiplicityBoundsCS);
        if (result == null) result = caseMultiplicityCS(multiplicityBoundsCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.NAMED_ELEMENT:
      {
        NamedElement namedElement = (NamedElement)theEObject;
        T result = caseNamedElement(namedElement);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.NAME_SPACE:
      {
        NameSpace nameSpace = (NameSpace)theEObject;
        T result = caseNameSpace(nameSpace);
        if (result == null) result = caseNamedElement(nameSpace);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.TYPE_NAME_EXP_CS:
      {
        TypeNameExpCS typeNameExpCS = (TypeNameExpCS)theEObject;
        T result = caseTypeNameExpCS(typeNameExpCS);
        if (result == null) result = caseTypedRefCS(typeNameExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.PATH_NAME_CS:
      {
        PathNameCS pathNameCS = (PathNameCS)theEObject;
        T result = casePathNameCS(pathNameCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.PATH_ELEMENT_CS:
      {
        PathElementCS pathElementCS = (PathElementCS)theEObject;
        T result = casePathElementCS(pathElementCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.SPECIFICATION_CS:
      {
        SpecificationCS specificationCS = (SpecificationCS)theEObject;
        T result = caseSpecificationCS(specificationCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.ESSENTIAL_OCL_INFIX_OPERATOR_CS:
      {
        EssentialOCLInfixOperatorCS essentialOCLInfixOperatorCS = (EssentialOCLInfixOperatorCS)theEObject;
        T result = caseEssentialOCLInfixOperatorCS(essentialOCLInfixOperatorCS);
        if (result == null) result = caseBinaryOperatorCS(essentialOCLInfixOperatorCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.BINARY_OPERATOR_CS:
      {
        BinaryOperatorCS binaryOperatorCS = (BinaryOperatorCS)theEObject;
        T result = caseBinaryOperatorCS(binaryOperatorCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.NAVIGATION_OPERATOR_CS:
      {
        NavigationOperatorCS navigationOperatorCS = (NavigationOperatorCS)theEObject;
        T result = caseNavigationOperatorCS(navigationOperatorCS);
        if (result == null) result = caseBinaryOperatorCS(navigationOperatorCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.CONTEXT_CS:
      {
        ContextCs contextCs = (ContextCs)theEObject;
        T result = caseContextCs(contextCs);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.EXPRESS_CS:
      {
        ExpressCS expressCS = (ExpressCS)theEObject;
        T result = caseExpressCS(expressCS);
        if (result == null) result = caseoclExpr(expressCS);
        if (result == null) result = caseExpCS(expressCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.PREFIXED_EXP_CS:
      {
        PrefixedExpCS prefixedExpCS = (PrefixedExpCS)theEObject;
        T result = casePrefixedExpCS(prefixedExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.ESSENTIAL_OCL_PREFIX_OPERATOR:
      {
        EssentialOCLPrefixOperator essentialOCLPrefixOperator = (EssentialOCLPrefixOperator)theEObject;
        T result = caseEssentialOCLPrefixOperator(essentialOCLPrefixOperator);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.PREFIXED_EXP_OR_LET_EXP_CS:
      {
        PrefixedExpOrLetExpCS prefixedExpOrLetExpCS = (PrefixedExpOrLetExpCS)theEObject;
        T result = casePrefixedExpOrLetExpCS(prefixedExpOrLetExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.PRIMARY_EXP_CS:
      {
        PrimaryExpCS primaryExpCS = (PrimaryExpCS)theEObject;
        T result = casePrimaryExpCS(primaryExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.CONSTRUCTOR_PART_CS:
      {
        ConstructorPartCS constructorPartCS = (ConstructorPartCS)theEObject;
        T result = caseConstructorPartCS(constructorPartCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.TYPE_LITERAL_WITH_MULTIPLICITY_CS:
      {
        TypeLiteralWithMultiplicityCS typeLiteralWithMultiplicityCS = (TypeLiteralWithMultiplicityCS)theEObject;
        T result = caseTypeLiteralWithMultiplicityCS(typeLiteralWithMultiplicityCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.TYPE_LITERAL_CS:
      {
        TypeLiteralCS typeLiteralCS = (TypeLiteralCS)theEObject;
        T result = caseTypeLiteralCS(typeLiteralCS);
        if (result == null) result = caseTypeLiteralWithMultiplicityCS(typeLiteralCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.TUPLE_TYPE_CS:
      {
        TupleTypeCS tupleTypeCS = (TupleTypeCS)theEObject;
        T result = caseTupleTypeCS(tupleTypeCS);
        if (result == null) result = caseTypeLiteralCS(tupleTypeCS);
        if (result == null) result = caseTypeLiteralWithMultiplicityCS(tupleTypeCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.TUPLE_PART_CS:
      {
        TuplePartCS tuplePartCS = (TuplePartCS)theEObject;
        T result = caseTuplePartCS(tuplePartCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.PRIMITIVE_TYPE_CS:
      {
        PrimitiveTypeCS primitiveTypeCS = (PrimitiveTypeCS)theEObject;
        T result = casePrimitiveTypeCS(primitiveTypeCS);
        if (result == null) result = caseTypeLiteralCS(primitiveTypeCS);
        if (result == null) result = caseTypeLiteralWithMultiplicityCS(primitiveTypeCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.TYPE_LITERAL_EXP_CS:
      {
        TypeLiteralExpCS typeLiteralExpCS = (TypeLiteralExpCS)theEObject;
        T result = caseTypeLiteralExpCS(typeLiteralExpCS);
        if (result == null) result = casePrimaryExpCS(typeLiteralExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.COLLECTION_LITERAL_EXP_CS:
      {
        CollectionLiteralExpCS collectionLiteralExpCS = (CollectionLiteralExpCS)theEObject;
        T result = caseCollectionLiteralExpCS(collectionLiteralExpCS);
        if (result == null) result = casePrimaryExpCS(collectionLiteralExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.COLLECTION_LITERAL_PART_CS:
      {
        CollectionLiteralPartCS collectionLiteralPartCS = (CollectionLiteralPartCS)theEObject;
        T result = caseCollectionLiteralPartCS(collectionLiteralPartCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.COLLECTION_TYPE_CS:
      {
        CollectionTypeCS collectionTypeCS = (CollectionTypeCS)theEObject;
        T result = caseCollectionTypeCS(collectionTypeCS);
        if (result == null) result = caseTypeLiteralCS(collectionTypeCS);
        if (result == null) result = caseTypeLiteralWithMultiplicityCS(collectionTypeCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.NESTED_EXP_CS:
      {
        NestedExpCS nestedExpCS = (NestedExpCS)theEObject;
        T result = caseNestedExpCS(nestedExpCS);
        if (result == null) result = casePrimaryExpCS(nestedExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.SELF_EXP_CS:
      {
        SelfExpCS selfExpCS = (SelfExpCS)theEObject;
        T result = caseSelfExpCS(selfExpCS);
        if (result == null) result = casePrimaryExpCS(selfExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.PRIMARY_EXP_OR_LET_EXP_CS:
      {
        PrimaryExpOrLetExpCS primaryExpOrLetExpCS = (PrimaryExpOrLetExpCS)theEObject;
        T result = casePrimaryExpOrLetExpCS(primaryExpOrLetExpCS);
        if (result == null) result = caseExpressCS(primaryExpOrLetExpCS);
        if (result == null) result = casePrefixedExpOrLetExpCS(primaryExpOrLetExpCS);
        if (result == null) result = caseoclExpr(primaryExpOrLetExpCS);
        if (result == null) result = caseExpCS(primaryExpOrLetExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.LET_EXP_CS:
      {
        LetExpCS letExpCS = (LetExpCS)theEObject;
        T result = caseLetExpCS(letExpCS);
        if (result == null) result = casePrimaryExpOrLetExpCS(letExpCS);
        if (result == null) result = caseExpressCS(letExpCS);
        if (result == null) result = casePrefixedExpOrLetExpCS(letExpCS);
        if (result == null) result = caseoclExpr(letExpCS);
        if (result == null) result = caseExpCS(letExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.LET_VARIABLE_CS:
      {
        LetVariableCS letVariableCS = (LetVariableCS)theEObject;
        T result = caseLetVariableCS(letVariableCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.NAVIGATING_ARG_CS:
      {
        NavigatingArgCS navigatingArgCS = (NavigatingArgCS)theEObject;
        T result = caseNavigatingArgCS(navigatingArgCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.EXP_CS:
      {
        ExpCS expCS = (ExpCS)theEObject;
        T result = caseExpCS(expCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.IF_EXP_CS:
      {
        IfExpCS ifExpCS = (IfExpCS)theEObject;
        T result = caseIfExpCS(ifExpCS);
        if (result == null) result = casePrimaryExpCS(ifExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.TUPLE_LITERAL_EXP_CS:
      {
        TupleLiteralExpCS tupleLiteralExpCS = (TupleLiteralExpCS)theEObject;
        T result = caseTupleLiteralExpCS(tupleLiteralExpCS);
        if (result == null) result = casePrimaryExpCS(tupleLiteralExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.TUPLE_LITERAL_PART_CS:
      {
        TupleLiteralPartCS tupleLiteralPartCS = (TupleLiteralPartCS)theEObject;
        T result = caseTupleLiteralPartCS(tupleLiteralPartCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.PRIMITIVE_LITERAL_EXP_CS:
      {
        PrimitiveLiteralExpCS primitiveLiteralExpCS = (PrimitiveLiteralExpCS)theEObject;
        T result = casePrimitiveLiteralExpCS(primitiveLiteralExpCS);
        if (result == null) result = casePrimaryExpCS(primitiveLiteralExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.NUMBER_LITERAL_EXP_CS:
      {
        NumberLiteralExpCS numberLiteralExpCS = (NumberLiteralExpCS)theEObject;
        T result = caseNumberLiteralExpCS(numberLiteralExpCS);
        if (result == null) result = casePrimitiveLiteralExpCS(numberLiteralExpCS);
        if (result == null) result = casePrimaryExpCS(numberLiteralExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.BIG_NUMBER:
      {
        BigNumber bigNumber = (BigNumber)theEObject;
        T result = caseBigNumber(bigNumber);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.STRING_LITERAL_EXP_CS:
      {
        StringLiteralExpCS stringLiteralExpCS = (StringLiteralExpCS)theEObject;
        T result = caseStringLiteralExpCS(stringLiteralExpCS);
        if (result == null) result = casePrimitiveLiteralExpCS(stringLiteralExpCS);
        if (result == null) result = casePrimaryExpCS(stringLiteralExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.BOOLEAN_LITERAL_EXP_CS:
      {
        BooleanLiteralExpCS booleanLiteralExpCS = (BooleanLiteralExpCS)theEObject;
        T result = caseBooleanLiteralExpCS(booleanLiteralExpCS);
        if (result == null) result = casePrimitiveLiteralExpCS(booleanLiteralExpCS);
        if (result == null) result = casePrimaryExpCS(booleanLiteralExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS:
      {
        UnlimitedNaturalLiteralExpCS unlimitedNaturalLiteralExpCS = (UnlimitedNaturalLiteralExpCS)theEObject;
        T result = caseUnlimitedNaturalLiteralExpCS(unlimitedNaturalLiteralExpCS);
        if (result == null) result = casePrimitiveLiteralExpCS(unlimitedNaturalLiteralExpCS);
        if (result == null) result = casePrimaryExpCS(unlimitedNaturalLiteralExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.INVALID_LITERAL_EXP_CS:
      {
        InvalidLiteralExpCS invalidLiteralExpCS = (InvalidLiteralExpCS)theEObject;
        T result = caseInvalidLiteralExpCS(invalidLiteralExpCS);
        if (result == null) result = casePrimitiveLiteralExpCS(invalidLiteralExpCS);
        if (result == null) result = casePrimaryExpCS(invalidLiteralExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.NULL_LITERAL_EXP_CS:
      {
        NullLiteralExpCS nullLiteralExpCS = (NullLiteralExpCS)theEObject;
        T result = caseNullLiteralExpCS(nullLiteralExpCS);
        if (result == null) result = casePrimitiveLiteralExpCS(nullLiteralExpCS);
        if (result == null) result = casePrimaryExpCS(nullLiteralExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.PREFIX_EXP_CS:
      {
        PrefixExpCS prefixExpCS = (PrefixExpCS)theEObject;
        T result = casePrefixExpCS(prefixExpCS);
        if (result == null) result = casePrefixedExpCS(prefixExpCS);
        if (result == null) result = casePrefixedExpOrLetExpCS(prefixExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.INDEX_EXP_CS:
      {
        IndexExpCS indexExpCS = (IndexExpCS)theEObject;
        T result = caseIndexExpCS(indexExpCS);
        if (result == null) result = casePrimaryExpCS(indexExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.CONSTRUCTOR_EXP_CS:
      {
        ConstructorExpCS constructorExpCS = (ConstructorExpCS)theEObject;
        T result = caseConstructorExpCS(constructorExpCS);
        if (result == null) result = casePrimaryExpCS(constructorExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.INVOCATION_EXP_CS:
      {
        InvocationExpCS invocationExpCS = (InvocationExpCS)theEObject;
        T result = caseInvocationExpCS(invocationExpCS);
        if (result == null) result = casePrimaryExpCS(invocationExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      case TRCPackage.NAME_EXP_CS:
      {
        NameExpCS nameExpCS = (NameExpCS)theEObject;
        T result = caseNameExpCS(nameExpCS);
        if (result == null) result = casePrimaryExpCS(nameExpCS);
        if (result == null) result = defaultCase(theEObject);
        return result;
      }
      default: return defaultCase(theEObject);
    }
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Trc Specification</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Trc Specification</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTrcSpecification(TrcSpecification object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>trc Rule</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>trc Rule</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casetrcRule(trcRule object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModuleList(ModuleList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Module</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Module</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseModule(Module object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transformation List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transformation List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransformationList(TransformationList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transformation</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transformation</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransformation(Transformation object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transformation Impact</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transformation Impact</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransformationImpact(TransformationImpact object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transformation Dependency List</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transformation Dependency List</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransformationDependencyList(TransformationDependencyList object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Transformation Dependency</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Transformation Dependency</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTransformationDependency(TransformationDependency object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Operations</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Operations</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanOperations(BooleanOperations object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Rule Dependency</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Rule Dependency</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseRuleDependency(RuleDependency object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Key Word</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Key Word</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseKeyWord(KeyWord object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>requires Or Exclude Dependency</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>requires Or Exclude Dependency</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caserequiresOrExcludeDependency(requiresOrExcludeDependency object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>ocl Expr</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>ocl Expr</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseoclExpr(oclExpr object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Classifier Context Decl CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Classifier Context Decl CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseClassifierContextDeclCS(ClassifierContextDeclCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Operation Context Decl CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Operation Context Decl CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseOperationContextDeclCS(OperationContextDeclCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Parameter CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Parameter CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseParameterCS(ParameterCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constraint CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constraint CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstraintCS(ConstraintCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Def CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Def CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefCS(DefCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Def Property CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Def Property CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseDefPropertyCS(DefPropertyCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Typed Ref CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Typed Ref CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypedRefCS(TypedRefCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicity CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicity CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiplicityCS(MultiplicityCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicity String CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicity String CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiplicityStringCS(MultiplicityStringCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Multiplicity Bounds CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Multiplicity Bounds CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseMultiplicityBoundsCS(MultiplicityBoundsCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Named Element</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNamedElement(NamedElement object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Name Space</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name Space</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNameSpace(NameSpace object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Name Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Name Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeNameExpCS(TypeNameExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Path Name CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Path Name CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePathNameCS(PathNameCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Path Element CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Path Element CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePathElementCS(PathElementCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Specification CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Specification CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSpecificationCS(SpecificationCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Essential OCL Infix Operator CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Essential OCL Infix Operator CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEssentialOCLInfixOperatorCS(EssentialOCLInfixOperatorCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Binary Operator CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Binary Operator CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBinaryOperatorCS(BinaryOperatorCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Navigation Operator CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Navigation Operator CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNavigationOperatorCS(NavigationOperatorCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Context Cs</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Context Cs</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseContextCs(ContextCs object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Express CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Express CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpressCS(ExpressCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Prefixed Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Prefixed Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrefixedExpCS(PrefixedExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Essential OCL Prefix Operator</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Essential OCL Prefix Operator</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseEssentialOCLPrefixOperator(EssentialOCLPrefixOperator object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Prefixed Exp Or Let Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Prefixed Exp Or Let Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrefixedExpOrLetExpCS(PrefixedExpOrLetExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primary Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primary Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimaryExpCS(PrimaryExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constructor Part CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constructor Part CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstructorPartCS(ConstructorPartCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Literal With Multiplicity CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Literal With Multiplicity CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeLiteralWithMultiplicityCS(TypeLiteralWithMultiplicityCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Literal CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Literal CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeLiteralCS(TypeLiteralCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tuple Type CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tuple Type CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTupleTypeCS(TupleTypeCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tuple Part CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tuple Part CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTuplePartCS(TuplePartCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primitive Type CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primitive Type CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimitiveTypeCS(PrimitiveTypeCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Type Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Type Literal Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTypeLiteralExpCS(TypeLiteralExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Collection Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Collection Literal Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCollectionLiteralExpCS(CollectionLiteralExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Collection Literal Part CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Collection Literal Part CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCollectionLiteralPartCS(CollectionLiteralPartCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Collection Type CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Collection Type CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseCollectionTypeCS(CollectionTypeCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Nested Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Nested Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNestedExpCS(NestedExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Self Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Self Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseSelfExpCS(SelfExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primary Exp Or Let Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primary Exp Or Let Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimaryExpOrLetExpCS(PrimaryExpOrLetExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Let Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Let Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLetExpCS(LetExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Let Variable CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Let Variable CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseLetVariableCS(LetVariableCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Navigating Arg CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Navigating Arg CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNavigatingArgCS(NavigatingArgCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseExpCS(ExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>If Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>If Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIfExpCS(IfExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tuple Literal Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTupleLiteralExpCS(TupleLiteralExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Tuple Literal Part CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Tuple Literal Part CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseTupleLiteralPartCS(TupleLiteralPartCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Primitive Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Primitive Literal Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrimitiveLiteralExpCS(PrimitiveLiteralExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Number Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Number Literal Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNumberLiteralExpCS(NumberLiteralExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Big Number</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Big Number</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBigNumber(BigNumber object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>String Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>String Literal Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseStringLiteralExpCS(StringLiteralExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Boolean Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Boolean Literal Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseBooleanLiteralExpCS(BooleanLiteralExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Unlimited Natural Literal Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseUnlimitedNaturalLiteralExpCS(UnlimitedNaturalLiteralExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invalid Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invalid Literal Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInvalidLiteralExpCS(InvalidLiteralExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Null Literal Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Null Literal Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNullLiteralExpCS(NullLiteralExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Prefix Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Prefix Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T casePrefixExpCS(PrefixExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Index Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Index Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseIndexExpCS(IndexExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Constructor Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Constructor Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseConstructorExpCS(ConstructorExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Invocation Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Invocation Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseInvocationExpCS(InvocationExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>Name Exp CS</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>Name Exp CS</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
   * @generated
   */
  public T caseNameExpCS(NameExpCS object)
  {
    return null;
  }

  /**
   * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
   * <!-- begin-user-doc -->
   * This implementation returns null;
   * returning a non-null result will terminate the switch, but this is the last case anyway.
   * <!-- end-user-doc -->
   * @param object the target of the switch.
   * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
   * @see #doSwitch(org.eclipse.emf.ecore.EObject)
   * @generated
   */
  @Override
  public T defaultCase(EObject object)
  {
    return null;
  }

} //TRCSwitch
