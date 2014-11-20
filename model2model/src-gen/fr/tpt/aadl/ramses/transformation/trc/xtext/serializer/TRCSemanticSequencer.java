package fr.tpt.aadl.ramses.transformation.trc.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import fr.tpt.aadl.ramses.transformation.trc.xtext.services.TRCGrammarAccess;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.BigNumber;
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
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.DefPropertyCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.EssentialOCLInfixOperatorCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.EssentialOCLPrefixOperator;
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
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.PrimitiveTypeCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.RuleDependency;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SelfExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.SpecificationCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.StringLiteralExpCS;
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
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeLiteralExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TypeNameExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.UnlimitedNaturalLiteralExpCS;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.requiresOrExcludeDependency;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.trcRule;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.serializer.acceptor.ISemanticSequenceAcceptor;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.diagnostic.ISemanticSequencerDiagnosticProvider;
import org.eclipse.xtext.serializer.diagnostic.ISerializationDiagnostic.Acceptor;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.GenericSequencer;
import org.eclipse.xtext.serializer.sequencer.ISemanticNodeProvider.INodesForEObjectProvider;
import org.eclipse.xtext.serializer.sequencer.ISemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;

@SuppressWarnings("all")
public class TRCSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private TRCGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == TRCPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TRCPackage.BIG_NUMBER:
				if(context == grammarAccess.getNUMBER_LITERALRule()) {
					sequence_NUMBER_LITERAL(context, (BigNumber) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.BOOLEAN_LITERAL_EXP_CS:
				if(context == grammarAccess.getBooleanLiteralExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule()) {
					sequence_BooleanLiteralExpCS(context, (BooleanLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.BOOLEAN_OPERATIONS:
				if(context == grammarAccess.getBooleanOperationsRule()) {
					sequence_BooleanOperations(context, (BooleanOperations) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.CLASSIFIER_CONTEXT_DECL_CS:
				if(context == grammarAccess.getClassifierContextDeclCSRule() ||
				   context == grammarAccess.getOclExprRule()) {
					sequence_ClassifierContextDeclCS(context, (ClassifierContextDeclCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.COLLECTION_LITERAL_EXP_CS:
				if(context == grammarAccess.getCollectionLiteralExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_CollectionLiteralExpCS(context, (CollectionLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.COLLECTION_LITERAL_PART_CS:
				if(context == grammarAccess.getCollectionLiteralPartCSRule()) {
					sequence_CollectionLiteralPartCS(context, (CollectionLiteralPartCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.COLLECTION_TYPE_CS:
				if(context == grammarAccess.getCollectionTypeCSRule() ||
				   context == grammarAccess.getTypeLiteralCSRule()) {
					sequence_CollectionTypeCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_CollectionTypeCS_TypeLiteralWithMultiplicityCS(context, (CollectionTypeCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.CONSTRAINT_CS:
				if(context == grammarAccess.getConstraintCSRule()) {
					sequence_ConstraintCS(context, (ConstraintCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.CONSTRUCTOR_EXP_CS:
				if(context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_PrimaryExpCS(context, (ConstructorExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.CONSTRUCTOR_PART_CS:
				if(context == grammarAccess.getConstructorPartCSRule()) {
					sequence_ConstructorPartCS(context, (ConstructorPartCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.CONTEXT_CS:
				if(context == grammarAccess.getContextCsRule()) {
					sequence_ContextCs(context, (ContextCs) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.DEF_PROPERTY_CS:
				if(context == grammarAccess.getDefCSRule() ||
				   context == grammarAccess.getDefPropertyCSRule()) {
					sequence_DefPropertyCS(context, (DefPropertyCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.ESSENTIAL_OCL_INFIX_OPERATOR_CS:
				if(context == grammarAccess.getBinaryOperatorCSRule() ||
				   context == grammarAccess.getEssentialOCLInfixOperatorCSRule()) {
					sequence_EssentialOCLInfixOperatorCS(context, (EssentialOCLInfixOperatorCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.ESSENTIAL_OCL_PREFIX_OPERATOR:
				if(context == grammarAccess.getEssentialOCLPrefixOperatorRule()) {
					sequence_EssentialOCLPrefixOperator(context, (EssentialOCLPrefixOperator) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.EXPRESS_CS:
				if(context == grammarAccess.getExpressCSRule() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getOclExprRule()) {
					sequence_ExpressCS(context, (ExpressCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.IF_EXP_CS:
				if(context == grammarAccess.getIfExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_IfExpCS(context, (IfExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.INDEX_EXP_CS:
				if(context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_PrimaryExpCS(context, (IndexExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.INVALID_LITERAL_EXP_CS:
				if(context == grammarAccess.getInvalidLiteralExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule()) {
					sequence_InvalidLiteralExpCS(context, (InvalidLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.INVOCATION_EXP_CS:
				if(context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_PrimaryExpCS(context, (InvocationExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.KEY_WORD:
				if(context == grammarAccess.getKeyWordRule()) {
					sequence_KeyWord(context, (KeyWord) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.LET_EXP_CS:
				if(context == grammarAccess.getExpressCSRule() ||
				   context == grammarAccess.getLetExpCSRule() ||
				   context == grammarAccess.getNavigatingArgExpCSRule() ||
				   context == grammarAccess.getPrefixedExpOrLetExpCSRule() ||
				   context == grammarAccess.getPrimaryExpOrLetExpCSRule() ||
				   context == grammarAccess.getOclExprRule()) {
					sequence_LetExpCS(context, (LetExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.LET_VARIABLE_CS:
				if(context == grammarAccess.getLetVariableCSRule()) {
					sequence_LetVariableCS(context, (LetVariableCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.MODULE:
				if(context == grammarAccess.getModuleRule()) {
					sequence_Module(context, (Module) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.MODULE_LIST:
				if(context == grammarAccess.getModuleListRule()) {
					sequence_ModuleList(context, (ModuleList) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.MULTIPLICITY_BOUNDS_CS:
				if(context == grammarAccess.getMultiplicityBoundsCSRule() ||
				   context == grammarAccess.getMultiplicityCSRule()) {
					sequence_MultiplicityBoundsCS(context, (MultiplicityBoundsCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.MULTIPLICITY_STRING_CS:
				if(context == grammarAccess.getMultiplicityCSRule() ||
				   context == grammarAccess.getMultiplicityStringCSRule()) {
					sequence_MultiplicityStringCS(context, (MultiplicityStringCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.NAME_EXP_CS:
				if(context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_PrimaryExpCS(context, (NameExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.NAME_SPACE:
				if(context == grammarAccess.getNameSpaceRule() ||
				   context == grammarAccess.getNamedElementRule()) {
					sequence_NameSpace(context, (NameSpace) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.NAMED_ELEMENT:
				if(context == grammarAccess.getNamedElementRule()) {
					sequence_NamedElement(context, (NamedElement) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.NAVIGATING_ARG_CS:
				if(context == grammarAccess.getNavigatingArgCSRule()) {
					sequence_NavigatingArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNavigatingBarArgCSRule()) {
					sequence_NavigatingBarArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNavigatingCommaArgCSRule()) {
					sequence_NavigatingCommaArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNavigatingSemiArgCSRule()) {
					sequence_NavigatingSemiArgCS(context, (NavigatingArgCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.NAVIGATION_OPERATOR_CS:
				if(context == grammarAccess.getBinaryOperatorCSRule() ||
				   context == grammarAccess.getNavigationOperatorCSRule()) {
					sequence_NavigationOperatorCS(context, (NavigationOperatorCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.NESTED_EXP_CS:
				if(context == grammarAccess.getNestedExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule()) {
					sequence_NestedExpCS(context, (NestedExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.NULL_LITERAL_EXP_CS:
				if(context == grammarAccess.getNullLiteralExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule()) {
					sequence_NullLiteralExpCS(context, (NullLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.NUMBER_LITERAL_EXP_CS:
				if(context == grammarAccess.getNumberLiteralExpCSRule() ||
				   context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule()) {
					sequence_NumberLiteralExpCS(context, (NumberLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.OPERATION_CONTEXT_DECL_CS:
				if(context == grammarAccess.getOperationContextDeclCSRule()) {
					sequence_OperationContextDeclCS(context, (OperationContextDeclCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.PARAMETER_CS:
				if(context == grammarAccess.getParameterCSRule()) {
					sequence_ParameterCS(context, (ParameterCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.PATH_ELEMENT_CS:
				if(context == grammarAccess.getFirstPathElementCSRule()) {
					sequence_FirstPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getNextPathElementCSRule()) {
					sequence_NextPathElementCS(context, (PathElementCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.PATH_NAME_CS:
				if(context == grammarAccess.getPathNameCSRule()) {
					sequence_PathNameCS(context, (PathNameCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.PREFIX_EXP_CS:
				if(context == grammarAccess.getPrefixedExpCSRule()) {
					sequence_PrefixedExpCS(context, (PrefixExpCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getPrefixedExpOrLetExpCSRule()) {
					sequence_PrefixedExpOrLetExpCS(context, (PrefixExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.PRIMITIVE_TYPE_CS:
				if(context == grammarAccess.getPrimitiveTypeCSRule() ||
				   context == grammarAccess.getTypeLiteralCSRule()) {
					sequence_PrimitiveTypeCS(context, (PrimitiveTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_PrimitiveTypeCS_TypeLiteralWithMultiplicityCS(context, (PrimitiveTypeCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.RULE_DEPENDENCY:
				if(context == grammarAccess.getRuleDependencyRule()) {
					sequence_RuleDependency(context, (RuleDependency) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.SELF_EXP_CS:
				if(context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getSelfExpCSRule()) {
					sequence_SelfExpCS(context, (SelfExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.SPECIFICATION_CS:
				if(context == grammarAccess.getSpecificationCSRule()) {
					sequence_SpecificationCS(context, (SpecificationCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.STRING_LITERAL_EXP_CS:
				if(context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule() ||
				   context == grammarAccess.getStringLiteralExpCSRule()) {
					sequence_StringLiteralExpCS(context, (StringLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.TRANSFORMATION:
				if(context == grammarAccess.getTransformationRule()) {
					sequence_Transformation(context, (Transformation) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.TRANSFORMATION_DEPENDENCY:
				if(context == grammarAccess.getTransformationDependencyRule()) {
					sequence_TransformationDependency(context, (TransformationDependency) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.TRANSFORMATION_DEPENDENCY_LIST:
				if(context == grammarAccess.getTransformationDependencyListRule()) {
					sequence_TransformationDependencyList(context, (TransformationDependencyList) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.TRANSFORMATION_IMPACT:
				if(context == grammarAccess.getTransformationImpactRule()) {
					sequence_TransformationImpact(context, (TransformationImpact) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.TRANSFORMATION_LIST:
				if(context == grammarAccess.getTransformationListRule()) {
					sequence_TransformationList(context, (TransformationList) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.TRC_SPECIFICATION:
				if(context == grammarAccess.getTrcSpecificationRule()) {
					sequence_TrcSpecification(context, (TrcSpecification) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.TUPLE_LITERAL_EXP_CS:
				if(context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getTupleLiteralExpCSRule()) {
					sequence_TupleLiteralExpCS(context, (TupleLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.TUPLE_LITERAL_PART_CS:
				if(context == grammarAccess.getTupleLiteralPartCSRule()) {
					sequence_TupleLiteralPartCS(context, (TupleLiteralPartCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.TUPLE_PART_CS:
				if(context == grammarAccess.getTuplePartCSRule()) {
					sequence_TuplePartCS(context, (TuplePartCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.TUPLE_TYPE_CS:
				if(context == grammarAccess.getTupleTypeCSRule() ||
				   context == grammarAccess.getTypeLiteralCSRule()) {
					sequence_TupleTypeCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeLiteralWithMultiplicityCSRule()) {
					sequence_TupleTypeCS_TypeLiteralWithMultiplicityCS(context, (TupleTypeCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.TYPE_LITERAL_EXP_CS:
				if(context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getTypeLiteralExpCSRule()) {
					sequence_TypeLiteralExpCS(context, (TypeLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.TYPE_NAME_EXP_CS:
				if(context == grammarAccess.getTypeExpCSRule()) {
					sequence_TypeExpCS_TypeNameExpCS(context, (TypeNameExpCS) semanticObject); 
					return; 
				}
				else if(context == grammarAccess.getTypeNameExpCSRule()) {
					sequence_TypeNameExpCS(context, (TypeNameExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.UNLIMITED_NATURAL_LITERAL_EXP_CS:
				if(context == grammarAccess.getPrimaryExpCSRule() ||
				   context == grammarAccess.getPrimitiveLiteralExpCSRule() ||
				   context == grammarAccess.getUnlimitedNaturalLiteralExpCSRule()) {
					sequence_UnlimitedNaturalLiteralExpCS(context, (UnlimitedNaturalLiteralExpCS) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.REQUIRES_OR_EXCLUDE_DEPENDENCY:
				if(context == grammarAccess.getRequiresOrExcludeDependencyRule()) {
					sequence_requiresOrExcludeDependency(context, (requiresOrExcludeDependency) semanticObject); 
					return; 
				}
				else break;
			case TRCPackage.TRC_RULE:
				if(context == grammarAccess.getTrcRuleRule()) {
					sequence_trcRule(context, (trcRule) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Constraint:
	 *     (name='true' | name='false')
	 */
	protected void sequence_BooleanLiteralExpCS(EObject context, BooleanLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='and' | name='or')
	 */
	protected void sequence_BooleanOperations(EObject context, BooleanOperations semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (selfName=UnrestrictedName? (invariants+=ConstraintCS | definitions+=DefCS)+)
	 */
	protected void sequence_ClassifierContextDeclCS(EObject context, ClassifierContextDeclCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedType=CollectionTypeCS (ownedParts+=CollectionLiteralPartCS ownedParts+=CollectionLiteralPartCS*)?)
	 */
	protected void sequence_CollectionLiteralExpCS(EObject context, CollectionLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (expressionCS=ExpressCS lastExpressionCS=ExpressCS?)
	 */
	protected void sequence_CollectionLiteralPartCS(EObject context, CollectionLiteralPartCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=CollectionTypeIdentifier ownedType=TypeExpCS?)
	 */
	protected void sequence_CollectionTypeCS(EObject context, CollectionTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=CollectionTypeIdentifier ownedType=TypeExpCS? multiplicity=MultiplicityCS?)
	 */
	protected void sequence_CollectionTypeCS_TypeLiteralWithMultiplicityCS(EObject context, CollectionTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=UnrestrictedName messageSpecification=SpecificationCS?)? specification+=SpecificationCS specification+=SpecificationCS*)
	 */
	protected void sequence_ConstraintCS(EObject context, ConstraintCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (property=UnrestrictedName initExpression=ExpressCS)
	 */
	protected void sequence_ConstructorPartCS(EObject context, ConstructorPartCS semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TRCPackage.Literals.CONSTRUCTOR_PART_CS__PROPERTY) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TRCPackage.Literals.CONSTRUCTOR_PART_CS__PROPERTY));
			if(transientValues.isValueTransient(semanticObject, TRCPackage.Literals.CONSTRUCTOR_PART_CS__INIT_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TRCPackage.Literals.CONSTRUCTOR_PART_CS__INIT_EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getConstructorPartCSAccess().getPropertyUnrestrictedNameParserRuleCall_0_0(), semanticObject.getProperty());
		feeder.accept(grammarAccess.getConstructorPartCSAccess().getInitExpressionExpressCSParserRuleCall_2_0(), semanticObject.getInitExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (ownedExpression+=LetExpCS | (B=BinaryOperatorCS? BO=BinaryOperatorCS))
	 */
	protected void sequence_ContextCs(EObject context, ContextCs semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (static?='static'? name=UnrestrictedName ownedType=TypeExpCS specification=SpecificationCS)
	 */
	protected void sequence_DefPropertyCS(EObject context, DefPropertyCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         name='*' | 
	 *         name='/' | 
	 *         name='+' | 
	 *         name='-' | 
	 *         name='>' | 
	 *         name='<' | 
	 *         name='>=' | 
	 *         name='<=' | 
	 *         name='=' | 
	 *         name='<>' | 
	 *         name='and' | 
	 *         name='or' | 
	 *         name='xor' | 
	 *         name='implies'
	 *     )
	 */
	protected void sequence_EssentialOCLInfixOperatorCS(EObject context, EssentialOCLInfixOperatorCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='-' | name='not')
	 */
	protected void sequence_EssentialOCLPrefixOperator(EObject context, EssentialOCLPrefixOperator semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         ((ownedExpression+=PrefixedExpCS ownedOperator+=BinaryOperatorCS)+ ownedExpression+=PrefixedExpOrLetExpCS) | 
	 *         (ownedOperator+=EssentialOCLPrefixOperator ownedExpression+=PrimaryExpOrLetExpCS)
	 *     )
	 */
	protected void sequence_ExpressCS(EObject context, ExpressCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     element=[NamedElement|UnrestrictedName]
	 */
	protected void sequence_FirstPathElementCS(EObject context, PathElementCS semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TRCPackage.Literals.PATH_ELEMENT_CS__ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TRCPackage.Literals.PATH_ELEMENT_CS__ELEMENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getFirstPathElementCSAccess().getElementNamedElementUnrestrictedNameParserRuleCall_0_1(), semanticObject.getElement());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (condition=ExpressCS thenExpression=ExpressCS elseExpression=ExpressCS)
	 */
	protected void sequence_IfExpCS(EObject context, IfExpCS semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TRCPackage.Literals.IF_EXP_CS__CONDITION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TRCPackage.Literals.IF_EXP_CS__CONDITION));
			if(transientValues.isValueTransient(semanticObject, TRCPackage.Literals.IF_EXP_CS__THEN_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TRCPackage.Literals.IF_EXP_CS__THEN_EXPRESSION));
			if(transientValues.isValueTransient(semanticObject, TRCPackage.Literals.IF_EXP_CS__ELSE_EXPRESSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TRCPackage.Literals.IF_EXP_CS__ELSE_EXPRESSION));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getIfExpCSAccess().getConditionExpressCSParserRuleCall_1_0(), semanticObject.getCondition());
		feeder.accept(grammarAccess.getIfExpCSAccess().getThenExpressionExpressCSParserRuleCall_3_0(), semanticObject.getThenExpression());
		feeder.accept(grammarAccess.getIfExpCSAccess().getElseExpressionExpressCSParserRuleCall_5_0(), semanticObject.getElseExpression());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {InvalidLiteralExpCS}
	 */
	protected void sequence_InvalidLiteralExpCS(EObject context, InvalidLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='requires' | name='excludes')
	 */
	protected void sequence_KeyWord(EObject context, KeyWord semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (variable+=LetVariableCS variable+=LetVariableCS* in=ExpressCS)
	 */
	protected void sequence_LetExpCS(EObject context, LetExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypeExpCS? initExpression=ExpressCS)
	 */
	protected void sequence_LetVariableCS(EObject context, LetVariableCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (modules+=Module modules+=Module*)
	 */
	protected void sequence_ModuleList(EObject context, ModuleList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ((name=EString rules+=trcRule rules+=trcRule*)?)
	 */
	protected void sequence_Module(EObject context, Module semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (lowerBound=LOWER upperBound=UPPER?)
	 */
	protected void sequence_MultiplicityBoundsCS(EObject context, MultiplicityBoundsCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (stringBounds='*' | stringBounds='+' | stringBounds='?')
	 */
	protected void sequence_MultiplicityStringCS(EObject context, MultiplicityStringCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     number=INT
	 */
	protected void sequence_NUMBER_LITERAL(EObject context, BigNumber semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TRCPackage.Literals.BIG_NUMBER__NUMBER) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TRCPackage.Literals.BIG_NUMBER__NUMBER));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNUMBER_LITERALAccess().getNumberINTTerminalRuleCall_0(), semanticObject.getNumber());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     ID=EString
	 */
	protected void sequence_NameSpace(EObject context, NameSpace semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (isStatic=EBoolean name=EString)
	 */
	protected void sequence_NamedElement(EObject context, NamedElement semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TRCPackage.Literals.NAMED_ELEMENT__IS_STATIC) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TRCPackage.Literals.NAMED_ELEMENT__IS_STATIC));
			if(transientValues.isValueTransient(semanticObject, TRCPackage.Literals.NAMED_ELEMENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TRCPackage.Literals.NAMED_ELEMENT__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNamedElementAccess().getIsStaticEBooleanParserRuleCall_1_0_0(), semanticObject.isIsStatic());
		feeder.accept(grammarAccess.getNamedElementAccess().getNameEStringParserRuleCall_1_1_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name=NavigatingArgExpCS (ownedType=TypeExpCS init=ExpressCS?)?)
	 */
	protected void sequence_NavigatingArgCS(EObject context, NavigatingArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (prefix='|' name=NavigatingArgExpCS (ownedType=TypeExpCS init=ExpressCS?)?)
	 */
	protected void sequence_NavigatingBarArgCS(EObject context, NavigatingArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (prefix=',' name=NavigatingArgExpCS (ownedType=TypeExpCS init=ExpressCS?)?)
	 */
	protected void sequence_NavigatingCommaArgCS(EObject context, NavigatingArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (prefix=';' name=NavigatingArgExpCS (ownedType=TypeExpCS init=ExpressCS?)?)
	 */
	protected void sequence_NavigatingSemiArgCS(EObject context, NavigatingArgCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='.' | name='->')
	 */
	protected void sequence_NavigationOperatorCS(EObject context, NavigationOperatorCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     source=ExpressCS
	 */
	protected void sequence_NestedExpCS(EObject context, NestedExpCS semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TRCPackage.Literals.NESTED_EXP_CS__SOURCE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TRCPackage.Literals.NESTED_EXP_CS__SOURCE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNestedExpCSAccess().getSourceExpressCSParserRuleCall_1_0(), semanticObject.getSource());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     element=[NamedElement|UnreservedName]
	 */
	protected void sequence_NextPathElementCS(EObject context, PathElementCS semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TRCPackage.Literals.PATH_ELEMENT_CS__ELEMENT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TRCPackage.Literals.PATH_ELEMENT_CS__ELEMENT));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNextPathElementCSAccess().getElementNamedElementUnreservedNameParserRuleCall_0_1(), semanticObject.getElement());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     {NullLiteralExpCS}
	 */
	protected void sequence_NullLiteralExpCS(EObject context, NullLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=NUMBER_LITERAL
	 */
	protected void sequence_NumberLiteralExpCS(EObject context, NumberLiteralExpCS semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TRCPackage.Literals.NUMBER_LITERAL_EXP_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TRCPackage.Literals.NUMBER_LITERAL_EXP_CS__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getNumberLiteralExpCSAccess().getNameNUMBER_LITERALParserRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         pathName=PathNameCS 
	 *         (parameters+=ParameterCS parameters+=ParameterCS*)? 
	 *         ownedType=TypeExpCS? 
	 *         (preconditions+=ConstraintCS | postconditions+=ConstraintCS | bodies+=SpecificationCS)*
	 *     )
	 */
	protected void sequence_OperationContextDeclCS(EObject context, OperationContextDeclCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName? ownedType=TypeExpCS)
	 */
	protected void sequence_ParameterCS(EObject context, ParameterCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (path+=FirstPathElementCS path+=NextPathElementCS*)
	 */
	protected void sequence_PathNameCS(EObject context, PathNameCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ownedOperator+=EssentialOCLPrefixOperator
	 */
	protected void sequence_PrefixedExpCS(EObject context, PrefixExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedOperator+=EssentialOCLPrefixOperator ownedExpression=PrimaryExpOrLetExpCS)
	 */
	protected void sequence_PrefixedExpOrLetExpCS(EObject context, PrefixExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (pathName=PathNameCS ((ownedParts+=ConstructorPartCS ownedParts+=ConstructorPartCS*) | value=ID))
	 */
	protected void sequence_PrimaryExpCS(EObject context, ConstructorExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (pathName=PathNameCS firstIndexes+=ExpressCS firstIndexes+=ExpressCS* (secondIndexes+=ExpressCS secondIndexes+=ExpressCS*)? atPre?='@'?)
	 */
	protected void sequence_PrimaryExpCS(EObject context, IndexExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         pathName=PathNameCS 
	 *         atPre?='@'? 
	 *         (
	 *             argument+=NavigatingArgCS 
	 *             argument+=NavigatingCommaArgCS* 
	 *             (argument+=NavigatingSemiArgCS argument+=NavigatingCommaArgCS*)? 
	 *             (argument+=NavigatingBarArgCS argument+=NavigatingCommaArgCS*)?
	 *         )?
	 *     )
	 */
	protected void sequence_PrimaryExpCS(EObject context, InvocationExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (pathName=PathNameCS atPre?='@'?)
	 */
	protected void sequence_PrimaryExpCS(EObject context, NameExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=PrimitiveTypeIdentifier
	 */
	protected void sequence_PrimitiveTypeCS(EObject context, PrimitiveTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=PrimitiveTypeIdentifier multiplicity=MultiplicityCS?)
	 */
	protected void sequence_PrimitiveTypeCS_TypeLiteralWithMultiplicityCS(EObject context, PrimitiveTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (kw=KeyWord red+=requiresOrExcludeDependency (boolOP=BooleanOperations red+=requiresOrExcludeDependency)?)
	 */
	protected void sequence_RuleDependency(EObject context, RuleDependency semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {SelfExpCS}
	 */
	protected void sequence_SelfExpCS(EObject context, SelfExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedExpression+=ContextCs | exprString=UNQUOTED_STRING)
	 */
	protected void sequence_SpecificationCS(EObject context, SpecificationCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name+=ID+
	 */
	protected void sequence_StringLiteralExpCS(EObject context, StringLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString transformationDependencies+=TransformationDependency transformationDependencies+=TransformationDependency*)
	 */
	protected void sequence_TransformationDependencyList(EObject context, TransformationDependencyList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         appliedTransformation=[Transformation|EString] 
	 *         appliedRule=[trcRule|QualifiedName] 
	 *         fields+=EString 
	 *         fields+=EString* 
	 *         requiredTransformations+=RuleDependency 
	 *         boolOP=BooleanOperations 
	 *         requiredTransformations+=RuleDependency*
	 *     )
	 */
	protected void sequence_TransformationDependency(EObject context, TransformationDependency semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (qualityAttributeName=EString? impactValue=EInt)
	 */
	protected void sequence_TransformationImpact(EObject context, TransformationImpact semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (transformations+=Transformation transformations+=Transformation*)
	 */
	protected void sequence_TransformationList(EObject context, TransformationList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=EString modules+=[Module|ID] modules+=[Module|ID]* (impacts+=TransformationImpact impacts+=TransformationImpact*)?)
	 */
	protected void sequence_Transformation(EObject context, Transformation semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (moduleList+=ModuleList transformationList+=TransformationList dependencyList+=TransformationDependencyList)
	 */
	protected void sequence_TrcSpecification(EObject context, TrcSpecification semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (ownedParts+=TupleLiteralPartCS ownedParts+=TupleLiteralPartCS*)
	 */
	protected void sequence_TupleLiteralExpCS(EObject context, TupleLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypeExpCS? initExpression=ExpressCS)
	 */
	protected void sequence_TupleLiteralPartCS(EObject context, TupleLiteralPartCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name=UnrestrictedName ownedType=TypeExpCS)
	 */
	protected void sequence_TuplePartCS(EObject context, TuplePartCS semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TRCPackage.Literals.TUPLE_PART_CS__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TRCPackage.Literals.TUPLE_PART_CS__NAME));
			if(transientValues.isValueTransient(semanticObject, TRCPackage.Literals.TUPLE_PART_CS__OWNED_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TRCPackage.Literals.TUPLE_PART_CS__OWNED_TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0(), semanticObject.getOwnedType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     (name='Tuple' (ownedParts+=TuplePartCS ownedParts+=TuplePartCS*)?)
	 */
	protected void sequence_TupleTypeCS(EObject context, TupleTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (name='Tuple' (ownedParts+=TuplePartCS ownedParts+=TuplePartCS*)? multiplicity=MultiplicityCS?)
	 */
	protected void sequence_TupleTypeCS_TypeLiteralWithMultiplicityCS(EObject context, TupleTypeCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (pathName=PathNameCS multiplicity=MultiplicityCS?)
	 */
	protected void sequence_TypeExpCS_TypeNameExpCS(EObject context, TypeNameExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     ownedType=TypeLiteralWithMultiplicityCS
	 */
	protected void sequence_TypeLiteralExpCS(EObject context, TypeLiteralExpCS semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TRCPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TRCPackage.Literals.TYPE_LITERAL_EXP_CS__OWNED_TYPE));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0(), semanticObject.getOwnedType());
		feeder.finish();
	}
	
	
	/**
	 * Constraint:
	 *     pathName=PathNameCS
	 */
	protected void sequence_TypeNameExpCS(EObject context, TypeNameExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     {UnlimitedNaturalLiteralExpCS}
	 */
	protected void sequence_UnlimitedNaturalLiteralExpCS(EObject context, UnlimitedNaturalLiteralExpCS semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (requiredTransformation+=[Transformation|EString] requiredRule+=[trcRule|QualifiedName] fields=EString oclExpression+=oclExpr)
	 */
	protected void sequence_requiresOrExcludeDependency(EObject context, requiresOrExcludeDependency semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_trcRule(EObject context, trcRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TRCPackage.Literals.TRC_RULE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TRCPackage.Literals.TRC_RULE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTrcRuleAccess().getNameEStringParserRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
}
