package org.trc.xtext.dsl.serializer;

import com.google.inject.Inject;
import com.google.inject.Provider;
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
import org.trc.xtext.dsl.services.DslGrammarAccess;

@SuppressWarnings("all")
public class DslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private DslGrammarAccess grammarAccess;
	
	public void createSequence(EObject context, EObject semanticObject) {
		if(semanticObject.eClass().getEPackage() == DslPackage.eINSTANCE) switch(semanticObject.eClass().getClassifierID()) {
			case DslPackage.MODULE:
				if(context == grammarAccess.getModuleRule()) {
					sequence_Module(context, (Module) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.MODULE_LIST:
				if(context == grammarAccess.getModuleListRule()) {
					sequence_ModuleList(context, (ModuleList) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.RULE_DEPENDENCY:
				if(context == grammarAccess.getAbstractRuleDependencyRule() ||
				   context == grammarAccess.getRuleDependencyRule()) {
					sequence_RuleDependency(context, (RuleDependency) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.TRANSFORMATION:
				if(context == grammarAccess.getTransformationRule()) {
					sequence_Transformation(context, (Transformation) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.TRANSFORMATION_DEPENDENCY:
				if(context == grammarAccess.getTransformationDependencyRule()) {
					sequence_TransformationDependency(context, (TransformationDependency) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.TRANSFORMATION_DEPENDENCY_LIST:
				if(context == grammarAccess.getTransformationDependencyListRule()) {
					sequence_TransformationDependencyList(context, (TransformationDependencyList) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.TRANSFORMATION_IMPACT:
				if(context == grammarAccess.getTransformationImpactRule()) {
					sequence_TransformationImpact(context, (TransformationImpact) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.TRANSFORMATION_LIST:
				if(context == grammarAccess.getTransformationListRule()) {
					sequence_TransformationList(context, (TransformationList) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.TRC_SPECIFICATION:
				if(context == grammarAccess.getTrcSpecificationRule()) {
					sequence_TrcSpecification(context, (TrcSpecification) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.EXCLUDE_DEPENDENCY:
				if(context == grammarAccess.getExcludeDependencyRule()) {
					sequence_excludeDependency(context, (excludeDependency) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.REQUIRES_DEPENDENCY:
				if(context == grammarAccess.getRequiresDependencyRule()) {
					sequence_requiresDependency(context, (requiresDependency) semanticObject); 
					return; 
				}
				else break;
			case DslPackage.TRC_RULE:
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
	 *     ((rd+=requiresDependency rd+=requiresDependency*) | (rd+=excludeDependency ed+=excludeDependency*))
	 */
	protected void sequence_RuleDependency(EObject context, RuleDependency semanticObject) {
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
	 *         (
	 *             (requiredTransformations+=AbstractRuleDependency requiredTransformations+=AbstractRuleDependency*) | 
	 *             (requiredTransformations+=AbstractRuleDependency requiredTransformations+=AbstractRuleDependency*)
	 *         )
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
	 *     (name=EString modules+=[Module|EString] modules+=[Module|EString]* (impacts+=TransformationImpact impacts+=TransformationImpact*)?)
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
	 *     (requiredTransformation+=[Transformation|EString] requiredRule+=[trcRule|QualifiedName] fields=EString oclExpression=EString)
	 */
	protected void sequence_excludeDependency(EObject context, excludeDependency semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     (requiredTransformation+=[Transformation|EString] requiredRule+=[trcRule|QualifiedName] fields=EString oclExpression=EString)
	 */
	protected void sequence_requiresDependency(EObject context, requiresDependency semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Constraint:
	 *     name=EString
	 */
	protected void sequence_trcRule(EObject context, trcRule semanticObject) {
		if(errorAcceptor != null) {
			if(transientValues.isValueTransient(semanticObject, DslPackage.Literals.TRC_RULE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, DslPackage.Literals.TRC_RULE__NAME));
		}
		INodesForEObjectProvider nodes = createNodeProvider(semanticObject);
		SequenceFeeder feeder = createSequencerFeeder(semanticObject, nodes);
		feeder.accept(grammarAccess.getTrcRuleAccess().getNameEStringParserRuleCall_0(), semanticObject.getName());
		feeder.finish();
	}
}
