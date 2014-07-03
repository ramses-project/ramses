package org.trc.xtext.dsl.serializer;

import com.google.inject.Inject;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AlternativeAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;
import org.trc.xtext.dsl.services.DslGrammarAccess;

@SuppressWarnings("all")
public class DslSyntacticSequencer extends AbstractSyntacticSequencer {

	protected DslGrammarAccess grammarAccess;
	protected AbstractElementAlias match_RuleDependency___AndKeyword_0_2_0_or_OrKeyword_0_2_1__q;
	protected AbstractElementAlias match_RuleDependency___AndKeyword_1_2_0_or_OrKeyword_1_2_1__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (DslGrammarAccess) access;
		match_RuleDependency___AndKeyword_0_2_0_or_OrKeyword_0_2_1__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getRuleDependencyAccess().getAndKeyword_0_2_0()), new TokenAlias(false, false, grammarAccess.getRuleDependencyAccess().getOrKeyword_0_2_1()));
		match_RuleDependency___AndKeyword_1_2_0_or_OrKeyword_1_2_1__q = new AlternativeAlias(false, true, new TokenAlias(false, false, grammarAccess.getRuleDependencyAccess().getAndKeyword_1_2_0()), new TokenAlias(false, false, grammarAccess.getRuleDependencyAccess().getOrKeyword_1_2_1()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		return "";
	}
	
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_RuleDependency___AndKeyword_0_2_0_or_OrKeyword_0_2_1__q.equals(syntax))
				emit_RuleDependency___AndKeyword_0_2_0_or_OrKeyword_0_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_RuleDependency___AndKeyword_1_2_0_or_OrKeyword_1_2_1__q.equals(syntax))
				emit_RuleDependency___AndKeyword_1_2_0_or_OrKeyword_1_2_1__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     ('or' | 'and')?
	 */
	protected void emit_RuleDependency___AndKeyword_0_2_0_or_OrKeyword_0_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('and' | 'or')?
	 */
	protected void emit_RuleDependency___AndKeyword_1_2_0_or_OrKeyword_1_2_1__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
