package fr.tpt.aadl.ramses.transformation.trc.xtext.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
import fr.tpt.aadl.ramses.transformation.trc.Module;
import fr.tpt.aadl.ramses.transformation.trc.ModuleList;
import fr.tpt.aadl.ramses.transformation.trc.RuleDependency;
import fr.tpt.aadl.ramses.transformation.trc.RuleDependencyConjunction;
import fr.tpt.aadl.ramses.transformation.trc.RuleDependencyDisjunction;
import fr.tpt.aadl.ramses.transformation.trc.Transformation;
import fr.tpt.aadl.ramses.transformation.trc.TransformationDependency;
import fr.tpt.aadl.ramses.transformation.trc.TransformationDependencyList;
import fr.tpt.aadl.ramses.transformation.trc.TransformationImpact;
import fr.tpt.aadl.ramses.transformation.trc.TransformationList;
import fr.tpt.aadl.ramses.transformation.trc.TrcPackage;
import fr.tpt.aadl.ramses.transformation.trc.TrcRule;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification;
import fr.tpt.aadl.ramses.transformation.trc.xtext.services.TRCGrammarAccess;
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
		if(semanticObject.eClass().getEPackage() == TrcPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case TrcPackage.MODULE:
				if(context == grammarAccess.getModuleRule()) {
					sequence_Module(context, (Module) semanticObject); 
					return; 
				}
				else break;
			case TrcPackage.MODULE_LIST:
				if(context == grammarAccess.getModuleListRule()) {
					sequence_ModuleList(context, (ModuleList) semanticObject); 
					return; 
				}
				else break;
			case TrcPackage.RULE_DEPENDENCY:
				if(context == grammarAccess.getAbstractRuleDependencyRule() ||
				   context == grammarAccess.getRuleDependencyRule()) {
					sequence_RuleDependency(context, (RuleDependency) semanticObject); 
					return; 
				}
				else break;
			case TrcPackage.RULE_DEPENDENCY_CONJUNCTION:
				if(context == grammarAccess.getAbstractRuleDependencyRule() ||
				   context == grammarAccess.getRuleDependencyCompositeRule() ||
				   context == grammarAccess.getRuleDependencyConjunctionRule()) {
					sequence_RuleDependencyConjunction(context, (RuleDependencyConjunction) semanticObject); 
					return; 
				}
				else break;
			case TrcPackage.RULE_DEPENDENCY_DISJUNCTION:
				if(context == grammarAccess.getAbstractRuleDependencyRule() ||
				   context == grammarAccess.getRuleDependencyCompositeRule() ||
				   context == grammarAccess.getRuleDependencyDisjunctionRule()) {
					sequence_RuleDependencyDisjunction(context, (RuleDependencyDisjunction) semanticObject); 
					return; 
				}
				else break;
			case TrcPackage.TRANSFORMATION:
				if(context == grammarAccess.getTransformationRule()) {
					sequence_Transformation(context, (Transformation) semanticObject); 
					return; 
				}
				else break;
			case TrcPackage.TRANSFORMATION_DEPENDENCY:
				if(context == grammarAccess.getTransformationDependencyRule()) {
					sequence_TransformationDependency(context, (TransformationDependency) semanticObject); 
					return; 
				}
				else break;
			case TrcPackage.TRANSFORMATION_DEPENDENCY_LIST:
				if(context == grammarAccess.getTransformationDependencyListRule()) {
					sequence_TransformationDependencyList(context, (TransformationDependencyList) semanticObject); 
					return; 
				}
				else break;
			case TrcPackage.TRANSFORMATION_IMPACT:
				if(context == grammarAccess.getTransformationImpactRule()) {
					sequence_TransformationImpact(context, (TransformationImpact) semanticObject); 
					return; 
				}
				else break;
			case TrcPackage.TRANSFORMATION_LIST:
				if(context == grammarAccess.getTransformationListRule()) {
					sequence_TransformationList(context, (TransformationList) semanticObject); 
					return; 
				}
				else break;
			case TrcPackage.TRC_RULE:
				if(context == grammarAccess.getTrcRuleRule()) {
					sequence_TrcRule(context, (TrcRule) semanticObject); 
					return; 
				}
				else break;
			case TrcPackage.TRC_SPECIFICATION:
				if(context == grammarAccess.getTrcSpecificationRule()) {
					sequence_TrcSpecification(context, (TrcSpecification) semanticObject); 
					return; 
				}
				else break;
			}
		if (errorAcceptor != null) errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
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
	 *     (name=EString path=EString (rules+=TrcRule rules+=TrcRule*)?)
	 */
	protected void sequence_Module(EObject context, Module semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (requiredTransformations+=AbstractRuleDependency requiredTransformations+=AbstractRuleDependency+)
	 */
	protected void sequence_RuleDependencyConjunction(EObject context, RuleDependencyConjunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (requiredTransformations+=AbstractRuleDependency requiredTransformations+=AbstractRuleDependency+)
	 */
	protected void sequence_RuleDependencyDisjunction(EObject context, RuleDependencyDisjunction semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         (type='requires' | type='excludes') 
	 *         requiredTransformation=[Transformation|EString] 
	 *         requiredRule=[TrcRule|QualifiedName] 
	 *         fieldNames+=EString 
	 *         fieldNames+=EString*
	 *     )
	 */
	protected void sequence_RuleDependency(EObject context, RuleDependency semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (transformationDependencies+=TransformationDependency transformationDependencies+=TransformationDependency*)
	 */
	protected void sequence_TransformationDependencyList(EObject context, TransformationDependencyList semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (
	 *         appliedTransformation=[Transformation|EString] 
	 *         appliedRule=[TrcRule|QualifiedName] 
	 *         variableId+=EString 
	 *         variableId+=EString* 
	 *         requiredTransformations=AbstractRuleDependency
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
	 *     name=EString
	 */
	protected void sequence_TrcRule(EObject context, TrcRule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (moduleList=ModuleList transformationList=TransformationList dependencyList=TransformationDependencyList)
	 */
	protected void sequence_TrcSpecification(EObject context, TrcSpecification semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, TrcPackage.Literals.TRC_SPECIFICATION__TRANSFORMATION_LIST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TrcPackage.Literals.TRC_SPECIFICATION__TRANSFORMATION_LIST));
			if(transientValues.isValueTransient(semanticObject, TrcPackage.Literals.TRC_SPECIFICATION__DEPENDENCY_LIST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TrcPackage.Literals.TRC_SPECIFICATION__DEPENDENCY_LIST));
			if(transientValues.isValueTransient(semanticObject, TrcPackage.Literals.TRC_SPECIFICATION__MODULE_LIST) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, TrcPackage.Literals.TRC_SPECIFICATION__MODULE_LIST));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTrcSpecificationAccess().getModuleListModuleListParserRuleCall_0_0(), semanticObject.getModuleList());
		feeder.accept(grammarAccess.getTrcSpecificationAccess().getTransformationListTransformationListParserRuleCall_1_0(), semanticObject.getTransformationList());
		feeder.accept(grammarAccess.getTrcSpecificationAccess().getDependencyListTransformationDependencyListParserRuleCall_2_0(), semanticObject.getDependencyList());
		feeder.finish();
	}
}
