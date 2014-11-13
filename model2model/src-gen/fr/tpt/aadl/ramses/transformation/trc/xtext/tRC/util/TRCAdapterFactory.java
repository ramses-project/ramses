/**
 */
package fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.util;

import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.*;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notifier;

import org.eclipse.emf.common.notify.impl.AdapterFactoryImpl;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * The <b>Adapter Factory</b> for the model.
 * It provides an adapter <code>createXXX</code> method for each class of the model.
 * <!-- end-user-doc -->
 * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TRCPackage
 * @generated
 */
public class TRCAdapterFactory extends AdapterFactoryImpl
{
  /**
   * The cached model package.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected static TRCPackage modelPackage;

  /**
   * Creates an instance of the adapter factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  public TRCAdapterFactory()
  {
    if (modelPackage == null)
    {
      modelPackage = TRCPackage.eINSTANCE;
    }
  }

  /**
   * Returns whether this factory is applicable for the type of the object.
   * <!-- begin-user-doc -->
   * This implementation returns <code>true</code> if the object is either the model's package or is an instance object of the model.
   * <!-- end-user-doc -->
   * @return whether this factory is applicable for the type of the object.
   * @generated
   */
  @Override
  public boolean isFactoryForType(Object object)
  {
    if (object == modelPackage)
    {
      return true;
    }
    if (object instanceof EObject)
    {
      return ((EObject)object).eClass().getEPackage() == modelPackage;
    }
    return false;
  }

  /**
   * The switch that delegates to the <code>createXXX</code> methods.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  protected TRCSwitch<Adapter> modelSwitch =
    new TRCSwitch<Adapter>()
    {
      @Override
      public Adapter caseTrcSpecification(TrcSpecification object)
      {
        return createTrcSpecificationAdapter();
      }
      @Override
      public Adapter casetrcRule(trcRule object)
      {
        return createtrcRuleAdapter();
      }
      @Override
      public Adapter caseModuleList(ModuleList object)
      {
        return createModuleListAdapter();
      }
      @Override
      public Adapter caseModule(Module object)
      {
        return createModuleAdapter();
      }
      @Override
      public Adapter caseTransformationList(TransformationList object)
      {
        return createTransformationListAdapter();
      }
      @Override
      public Adapter caseTransformation(Transformation object)
      {
        return createTransformationAdapter();
      }
      @Override
      public Adapter caseTransformationImpact(TransformationImpact object)
      {
        return createTransformationImpactAdapter();
      }
      @Override
      public Adapter caseTransformationDependencyList(TransformationDependencyList object)
      {
        return createTransformationDependencyListAdapter();
      }
      @Override
      public Adapter caseTransformationDependency(TransformationDependency object)
      {
        return createTransformationDependencyAdapter();
      }
      @Override
      public Adapter caseBooleanOperations(BooleanOperations object)
      {
        return createBooleanOperationsAdapter();
      }
      @Override
      public Adapter caseRuleDependency(RuleDependency object)
      {
        return createRuleDependencyAdapter();
      }
      @Override
      public Adapter caseKeyWord(KeyWord object)
      {
        return createKeyWordAdapter();
      }
      @Override
      public Adapter caserequiresOrExcludeDependency(requiresOrExcludeDependency object)
      {
        return createrequiresOrExcludeDependencyAdapter();
      }
      @Override
      public Adapter caseoclExpr(oclExpr object)
      {
        return createoclExprAdapter();
      }
      @Override
      public Adapter caseClassifierContextDeclCS(ClassifierContextDeclCS object)
      {
        return createClassifierContextDeclCSAdapter();
      }
      @Override
      public Adapter caseOperationContextDeclCS(OperationContextDeclCS object)
      {
        return createOperationContextDeclCSAdapter();
      }
      @Override
      public Adapter caseParameterCS(ParameterCS object)
      {
        return createParameterCSAdapter();
      }
      @Override
      public Adapter caseConstraintCS(ConstraintCS object)
      {
        return createConstraintCSAdapter();
      }
      @Override
      public Adapter caseDefCS(DefCS object)
      {
        return createDefCSAdapter();
      }
      @Override
      public Adapter caseDefPropertyCS(DefPropertyCS object)
      {
        return createDefPropertyCSAdapter();
      }
      @Override
      public Adapter caseTypedRefCS(TypedRefCS object)
      {
        return createTypedRefCSAdapter();
      }
      @Override
      public Adapter caseMultiplicityCS(MultiplicityCS object)
      {
        return createMultiplicityCSAdapter();
      }
      @Override
      public Adapter caseMultiplicityStringCS(MultiplicityStringCS object)
      {
        return createMultiplicityStringCSAdapter();
      }
      @Override
      public Adapter caseMultiplicityBoundsCS(MultiplicityBoundsCS object)
      {
        return createMultiplicityBoundsCSAdapter();
      }
      @Override
      public Adapter caseNamedElement(NamedElement object)
      {
        return createNamedElementAdapter();
      }
      @Override
      public Adapter caseNameSpace(NameSpace object)
      {
        return createNameSpaceAdapter();
      }
      @Override
      public Adapter caseTypeNameExpCS(TypeNameExpCS object)
      {
        return createTypeNameExpCSAdapter();
      }
      @Override
      public Adapter casePathNameCS(PathNameCS object)
      {
        return createPathNameCSAdapter();
      }
      @Override
      public Adapter casePathElementCS(PathElementCS object)
      {
        return createPathElementCSAdapter();
      }
      @Override
      public Adapter caseSpecificationCS(SpecificationCS object)
      {
        return createSpecificationCSAdapter();
      }
      @Override
      public Adapter caseEssentialOCLInfixOperatorCS(EssentialOCLInfixOperatorCS object)
      {
        return createEssentialOCLInfixOperatorCSAdapter();
      }
      @Override
      public Adapter caseBinaryOperatorCS(BinaryOperatorCS object)
      {
        return createBinaryOperatorCSAdapter();
      }
      @Override
      public Adapter caseNavigationOperatorCS(NavigationOperatorCS object)
      {
        return createNavigationOperatorCSAdapter();
      }
      @Override
      public Adapter caseContextCs(ContextCs object)
      {
        return createContextCsAdapter();
      }
      @Override
      public Adapter caseExpressCS(ExpressCS object)
      {
        return createExpressCSAdapter();
      }
      @Override
      public Adapter casePrefixedExpCS(PrefixedExpCS object)
      {
        return createPrefixedExpCSAdapter();
      }
      @Override
      public Adapter caseEssentialOCLPrefixOperator(EssentialOCLPrefixOperator object)
      {
        return createEssentialOCLPrefixOperatorAdapter();
      }
      @Override
      public Adapter casePrefixedExpOrLetExpCS(PrefixedExpOrLetExpCS object)
      {
        return createPrefixedExpOrLetExpCSAdapter();
      }
      @Override
      public Adapter casePrimaryExpCS(PrimaryExpCS object)
      {
        return createPrimaryExpCSAdapter();
      }
      @Override
      public Adapter caseConstructorPartCS(ConstructorPartCS object)
      {
        return createConstructorPartCSAdapter();
      }
      @Override
      public Adapter caseTypeLiteralWithMultiplicityCS(TypeLiteralWithMultiplicityCS object)
      {
        return createTypeLiteralWithMultiplicityCSAdapter();
      }
      @Override
      public Adapter caseTypeLiteralCS(TypeLiteralCS object)
      {
        return createTypeLiteralCSAdapter();
      }
      @Override
      public Adapter caseTupleTypeCS(TupleTypeCS object)
      {
        return createTupleTypeCSAdapter();
      }
      @Override
      public Adapter caseTuplePartCS(TuplePartCS object)
      {
        return createTuplePartCSAdapter();
      }
      @Override
      public Adapter casePrimitiveTypeCS(PrimitiveTypeCS object)
      {
        return createPrimitiveTypeCSAdapter();
      }
      @Override
      public Adapter caseTypeLiteralExpCS(TypeLiteralExpCS object)
      {
        return createTypeLiteralExpCSAdapter();
      }
      @Override
      public Adapter caseCollectionLiteralExpCS(CollectionLiteralExpCS object)
      {
        return createCollectionLiteralExpCSAdapter();
      }
      @Override
      public Adapter caseCollectionLiteralPartCS(CollectionLiteralPartCS object)
      {
        return createCollectionLiteralPartCSAdapter();
      }
      @Override
      public Adapter caseCollectionTypeCS(CollectionTypeCS object)
      {
        return createCollectionTypeCSAdapter();
      }
      @Override
      public Adapter caseNestedExpCS(NestedExpCS object)
      {
        return createNestedExpCSAdapter();
      }
      @Override
      public Adapter caseSelfExpCS(SelfExpCS object)
      {
        return createSelfExpCSAdapter();
      }
      @Override
      public Adapter casePrimaryExpOrLetExpCS(PrimaryExpOrLetExpCS object)
      {
        return createPrimaryExpOrLetExpCSAdapter();
      }
      @Override
      public Adapter caseLetExpCS(LetExpCS object)
      {
        return createLetExpCSAdapter();
      }
      @Override
      public Adapter caseLetVariableCS(LetVariableCS object)
      {
        return createLetVariableCSAdapter();
      }
      @Override
      public Adapter caseNavigatingArgCS(NavigatingArgCS object)
      {
        return createNavigatingArgCSAdapter();
      }
      @Override
      public Adapter caseExpCS(ExpCS object)
      {
        return createExpCSAdapter();
      }
      @Override
      public Adapter caseIfExpCS(IfExpCS object)
      {
        return createIfExpCSAdapter();
      }
      @Override
      public Adapter caseTupleLiteralExpCS(TupleLiteralExpCS object)
      {
        return createTupleLiteralExpCSAdapter();
      }
      @Override
      public Adapter caseTupleLiteralPartCS(TupleLiteralPartCS object)
      {
        return createTupleLiteralPartCSAdapter();
      }
      @Override
      public Adapter casePrimitiveLiteralExpCS(PrimitiveLiteralExpCS object)
      {
        return createPrimitiveLiteralExpCSAdapter();
      }
      @Override
      public Adapter caseNumberLiteralExpCS(NumberLiteralExpCS object)
      {
        return createNumberLiteralExpCSAdapter();
      }
      @Override
      public Adapter caseBigNumber(BigNumber object)
      {
        return createBigNumberAdapter();
      }
      @Override
      public Adapter caseStringLiteralExpCS(StringLiteralExpCS object)
      {
        return createStringLiteralExpCSAdapter();
      }
      @Override
      public Adapter caseBooleanLiteralExpCS(BooleanLiteralExpCS object)
      {
        return createBooleanLiteralExpCSAdapter();
      }
      @Override
      public Adapter caseUnlimitedNaturalLiteralExpCS(UnlimitedNaturalLiteralExpCS object)
      {
        return createUnlimitedNaturalLiteralExpCSAdapter();
      }
      @Override
      public Adapter caseInvalidLiteralExpCS(InvalidLiteralExpCS object)
      {
        return createInvalidLiteralExpCSAdapter();
      }
      @Override
      public Adapter caseNullLiteralExpCS(NullLiteralExpCS object)
      {
        return createNullLiteralExpCSAdapter();
      }
      @Override
      public Adapter casePrefixExpCS(PrefixExpCS object)
      {
        return createPrefixExpCSAdapter();
      }
      @Override
      public Adapter caseIndexExpCS(IndexExpCS object)
      {
        return createIndexExpCSAdapter();
      }
      @Override
      public Adapter caseConstructorExpCS(ConstructorExpCS object)
      {
        return createConstructorExpCSAdapter();
      }
      @Override
      public Adapter caseInvocationExpCS(InvocationExpCS object)
      {
        return createInvocationExpCSAdapter();
      }
      @Override
      public Adapter caseNameExpCS(NameExpCS object)
      {
        return createNameExpCSAdapter();
      }
      @Override
      public Adapter defaultCase(EObject object)
      {
        return createEObjectAdapter();
      }
    };

  /**
   * Creates an adapter for the <code>target</code>.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param target the object to adapt.
   * @return the adapter for the <code>target</code>.
   * @generated
   */
  @Override
  public Adapter createAdapter(Notifier target)
  {
    return modelSwitch.doSwitch((EObject)target);
  }


  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TrcSpecification <em>Trc Specification</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TrcSpecification
   * @generated
   */
  public Adapter createTrcSpecificationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.trcRule <em>trc Rule</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.trcRule
   * @generated
   */
  public Adapter createtrcRuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ModuleList <em>Module List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ModuleList
   * @generated
   */
  public Adapter createModuleListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Module <em>Module</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Module
   * @generated
   */
  public Adapter createModuleAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationList <em>Transformation List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationList
   * @generated
   */
  public Adapter createTransformationListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation <em>Transformation</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation
   * @generated
   */
  public Adapter createTransformationAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationImpact <em>Transformation Impact</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationImpact
   * @generated
   */
  public Adapter createTransformationImpactAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependencyList <em>Transformation Dependency List</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependencyList
   * @generated
   */
  public Adapter createTransformationDependencyListAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency <em>Transformation Dependency</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency
   * @generated
   */
  public Adapter createTransformationDependencyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BooleanOperations <em>Boolean Operations</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BooleanOperations
   * @generated
   */
  public Adapter createBooleanOperationsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency <em>Rule Dependency</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency
   * @generated
   */
  public Adapter createRuleDependencyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.KeyWord <em>Key Word</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.KeyWord
   * @generated
   */
  public Adapter createKeyWordAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency <em>requires Or Exclude Dependency</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency
   * @generated
   */
  public Adapter createrequiresOrExcludeDependencyAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.oclExpr <em>ocl Expr</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.oclExpr
   * @generated
   */
  public Adapter createoclExprAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ClassifierContextDeclCS <em>Classifier Context Decl CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ClassifierContextDeclCS
   * @generated
   */
  public Adapter createClassifierContextDeclCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS <em>Operation Context Decl CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.OperationContextDeclCS
   * @generated
   */
  public Adapter createOperationContextDeclCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ParameterCS <em>Parameter CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ParameterCS
   * @generated
   */
  public Adapter createParameterCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS <em>Constraint CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstraintCS
   * @generated
   */
  public Adapter createConstraintCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefCS <em>Def CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefCS
   * @generated
   */
  public Adapter createDefCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefPropertyCS <em>Def Property CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefPropertyCS
   * @generated
   */
  public Adapter createDefPropertyCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypedRefCS <em>Typed Ref CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypedRefCS
   * @generated
   */
  public Adapter createTypedRefCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityCS <em>Multiplicity CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityCS
   * @generated
   */
  public Adapter createMultiplicityCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityStringCS <em>Multiplicity String CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityStringCS
   * @generated
   */
  public Adapter createMultiplicityStringCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityBoundsCS <em>Multiplicity Bounds CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.MultiplicityBoundsCS
   * @generated
   */
  public Adapter createMultiplicityBoundsCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NamedElement <em>Named Element</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NamedElement
   * @generated
   */
  public Adapter createNamedElementAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameSpace <em>Name Space</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameSpace
   * @generated
   */
  public Adapter createNameSpaceAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeNameExpCS <em>Type Name Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeNameExpCS
   * @generated
   */
  public Adapter createTypeNameExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathNameCS <em>Path Name CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathNameCS
   * @generated
   */
  public Adapter createPathNameCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathElementCS <em>Path Element CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PathElementCS
   * @generated
   */
  public Adapter createPathElementCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS <em>Specification CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS
   * @generated
   */
  public Adapter createSpecificationCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.EssentialOCLInfixOperatorCS <em>Essential OCL Infix Operator CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.EssentialOCLInfixOperatorCS
   * @generated
   */
  public Adapter createEssentialOCLInfixOperatorCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BinaryOperatorCS <em>Binary Operator CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BinaryOperatorCS
   * @generated
   */
  public Adapter createBinaryOperatorCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigationOperatorCS <em>Navigation Operator CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigationOperatorCS
   * @generated
   */
  public Adapter createNavigationOperatorCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs <em>Context Cs</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ContextCs
   * @generated
   */
  public Adapter createContextCsAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpressCS <em>Express CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpressCS
   * @generated
   */
  public Adapter createExpressCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixedExpCS <em>Prefixed Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixedExpCS
   * @generated
   */
  public Adapter createPrefixedExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.EssentialOCLPrefixOperator <em>Essential OCL Prefix Operator</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.EssentialOCLPrefixOperator
   * @generated
   */
  public Adapter createEssentialOCLPrefixOperatorAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixedExpOrLetExpCS <em>Prefixed Exp Or Let Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixedExpOrLetExpCS
   * @generated
   */
  public Adapter createPrefixedExpOrLetExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimaryExpCS <em>Primary Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimaryExpCS
   * @generated
   */
  public Adapter createPrimaryExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorPartCS <em>Constructor Part CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorPartCS
   * @generated
   */
  public Adapter createConstructorPartCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralWithMultiplicityCS <em>Type Literal With Multiplicity CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralWithMultiplicityCS
   * @generated
   */
  public Adapter createTypeLiteralWithMultiplicityCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralCS <em>Type Literal CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralCS
   * @generated
   */
  public Adapter createTypeLiteralCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleTypeCS <em>Tuple Type CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleTypeCS
   * @generated
   */
  public Adapter createTupleTypeCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TuplePartCS <em>Tuple Part CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TuplePartCS
   * @generated
   */
  public Adapter createTuplePartCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimitiveTypeCS <em>Primitive Type CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimitiveTypeCS
   * @generated
   */
  public Adapter createPrimitiveTypeCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralExpCS <em>Type Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralExpCS
   * @generated
   */
  public Adapter createTypeLiteralExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralExpCS <em>Collection Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralExpCS
   * @generated
   */
  public Adapter createCollectionLiteralExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralPartCS <em>Collection Literal Part CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionLiteralPartCS
   * @generated
   */
  public Adapter createCollectionLiteralPartCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionTypeCS <em>Collection Type CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.CollectionTypeCS
   * @generated
   */
  public Adapter createCollectionTypeCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NestedExpCS <em>Nested Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NestedExpCS
   * @generated
   */
  public Adapter createNestedExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SelfExpCS <em>Self Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SelfExpCS
   * @generated
   */
  public Adapter createSelfExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimaryExpOrLetExpCS <em>Primary Exp Or Let Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimaryExpOrLetExpCS
   * @generated
   */
  public Adapter createPrimaryExpOrLetExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetExpCS <em>Let Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetExpCS
   * @generated
   */
  public Adapter createLetExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetVariableCS <em>Let Variable CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.LetVariableCS
   * @generated
   */
  public Adapter createLetVariableCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigatingArgCS <em>Navigating Arg CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NavigatingArgCS
   * @generated
   */
  public Adapter createNavigatingArgCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpCS <em>Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ExpCS
   * @generated
   */
  public Adapter createExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS <em>If Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IfExpCS
   * @generated
   */
  public Adapter createIfExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralExpCS <em>Tuple Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralExpCS
   * @generated
   */
  public Adapter createTupleLiteralExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralPartCS <em>Tuple Literal Part CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TupleLiteralPartCS
   * @generated
   */
  public Adapter createTupleLiteralPartCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimitiveLiteralExpCS <em>Primitive Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimitiveLiteralExpCS
   * @generated
   */
  public Adapter createPrimitiveLiteralExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NumberLiteralExpCS <em>Number Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NumberLiteralExpCS
   * @generated
   */
  public Adapter createNumberLiteralExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BigNumber <em>Big Number</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BigNumber
   * @generated
   */
  public Adapter createBigNumberAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.StringLiteralExpCS <em>String Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.StringLiteralExpCS
   * @generated
   */
  public Adapter createStringLiteralExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BooleanLiteralExpCS <em>Boolean Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BooleanLiteralExpCS
   * @generated
   */
  public Adapter createBooleanLiteralExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.UnlimitedNaturalLiteralExpCS <em>Unlimited Natural Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.UnlimitedNaturalLiteralExpCS
   * @generated
   */
  public Adapter createUnlimitedNaturalLiteralExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvalidLiteralExpCS <em>Invalid Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvalidLiteralExpCS
   * @generated
   */
  public Adapter createInvalidLiteralExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NullLiteralExpCS <em>Null Literal Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NullLiteralExpCS
   * @generated
   */
  public Adapter createNullLiteralExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixExpCS <em>Prefix Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrefixExpCS
   * @generated
   */
  public Adapter createPrefixExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IndexExpCS <em>Index Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.IndexExpCS
   * @generated
   */
  public Adapter createIndexExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorExpCS <em>Constructor Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.ConstructorExpCS
   * @generated
   */
  public Adapter createConstructorExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvocationExpCS <em>Invocation Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.InvocationExpCS
   * @generated
   */
  public Adapter createInvocationExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for an object of class '{@link fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameExpCS <em>Name Exp CS</em>}'.
   * <!-- begin-user-doc -->
   * This default implementation returns null so that we can easily ignore cases;
   * it's useful to ignore a case when inheritance will catch all the cases anyway.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @see fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.NameExpCS
   * @generated
   */
  public Adapter createNameExpCSAdapter()
  {
    return null;
  }

  /**
   * Creates a new adapter for the default case.
   * <!-- begin-user-doc -->
   * This default implementation returns null.
   * <!-- end-user-doc -->
   * @return the new adapter.
   * @generated
   */
  public Adapter createEObjectAdapter()
  {
    return null;
  }

} //TRCAdapterFactory
