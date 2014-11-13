package fr.tpt.aadl.ramses.transformation.trc.xtext.serializer;

import com.google.inject.Inject;
import fr.tpt.aadl.ramses.transformation.trc.xtext.services.TRCGrammarAccess;
import java.util.List;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.AbstractElementAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.GroupAlias;
import org.eclipse.xtext.serializer.analysis.GrammarAlias.TokenAlias;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynNavigable;
import org.eclipse.xtext.serializer.analysis.ISyntacticSequencerPDAProvider.ISynTransition;
import org.eclipse.xtext.serializer.sequencer.AbstractSyntacticSequencer;

@SuppressWarnings("all")
public class TRCSyntacticSequencer extends AbstractSyntacticSequencer {

	protected TRCGrammarAccess grammarAccess;
	protected AbstractElementAlias match_ContextCs_SelfKeyword_1_1_0_q;
	protected AbstractElementAlias match_ContextCs_SelfKeyword_1_1_3_q;
	protected AbstractElementAlias match_DefPropertyCS_UnrestrictedNameParserRuleCall_2_q;
	protected AbstractElementAlias match_OperationContextDeclCS_UnrestrictedNameParserRuleCall_7_2_1_q;
	protected AbstractElementAlias match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q;
	
	@Inject
	protected void init(IGrammarAccess access) {
		grammarAccess = (TRCGrammarAccess) access;
		match_ContextCs_SelfKeyword_1_1_0_q = new TokenAlias(false, true, grammarAccess.getContextCsAccess().getSelfKeyword_1_1_0());
		match_ContextCs_SelfKeyword_1_1_3_q = new TokenAlias(false, true, grammarAccess.getContextCsAccess().getSelfKeyword_1_1_3());
		match_DefPropertyCS_UnrestrictedNameParserRuleCall_2_q = new TokenAlias(false, true, grammarAccess.getDefPropertyCSAccess().getUnrestrictedNameParserRuleCall_2());
		match_OperationContextDeclCS_UnrestrictedNameParserRuleCall_7_2_1_q = new TokenAlias(false, true, grammarAccess.getOperationContextDeclCSAccess().getUnrestrictedNameParserRuleCall_7_2_1());
		match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q = new GroupAlias(false, true, new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0()), new TokenAlias(false, false, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2()));
	}
	
	@Override
	protected String getUnassignedRuleCallToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if(ruleCall.getRule() == grammarAccess.getIDRule())
			return getIDToken(semanticObject, ruleCall, node);
		else if(ruleCall.getRule() == grammarAccess.getUnrestrictedNameRule())
			return getUnrestrictedNameToken(semanticObject, ruleCall, node);
		return "";
	}
	
	/**
	 * terminal ID  		: '^'?('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;
	 */
	protected String getIDToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	/**
	 * UnrestrictedName returns ecore::EString: 	EssentialOCLUnrestrictedName;
	 */
	protected String getUnrestrictedNameToken(EObject semanticObject, RuleCall ruleCall, INode node) {
		if (node != null)
			return getTokenText(node);
		return "";
	}
	
	@Override
	protected void emitUnassignedTokens(EObject semanticObject, ISynTransition transition, INode fromNode, INode toNode) {
		if (transition.getAmbiguousSyntaxes().isEmpty()) return;
		List<INode> transitionNodes = collectNodes(fromNode, toNode);
		for (AbstractElementAlias syntax : transition.getAmbiguousSyntaxes()) {
			List<INode> syntaxNodes = getNodesFor(transitionNodes, syntax);
			if(match_ContextCs_SelfKeyword_1_1_0_q.equals(syntax))
				emit_ContextCs_SelfKeyword_1_1_0_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_ContextCs_SelfKeyword_1_1_3_q.equals(syntax))
				emit_ContextCs_SelfKeyword_1_1_3_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_DefPropertyCS_UnrestrictedNameParserRuleCall_2_q.equals(syntax))
				emit_DefPropertyCS_UnrestrictedNameParserRuleCall_2_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_OperationContextDeclCS_UnrestrictedNameParserRuleCall_7_2_1_q.equals(syntax))
				emit_OperationContextDeclCS_UnrestrictedNameParserRuleCall_7_2_1_q(semanticObject, getLastNavigableState(), syntaxNodes);
			else if(match_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q.equals(syntax))
				emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(semanticObject, getLastNavigableState(), syntaxNodes);
			else acceptNodes(getLastNavigableState(), syntaxNodes);
		}
	}

	/**
	 * Syntax:
	 *     'self.'?
	 */
	protected void emit_ContextCs_SelfKeyword_1_1_0_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     'self.'?
	 */
	protected void emit_ContextCs_SelfKeyword_1_1_3_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     UnrestrictedName?
	 */
	protected void emit_DefPropertyCS_UnrestrictedNameParserRuleCall_2_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     UnrestrictedName?
	 */
	protected void emit_OperationContextDeclCS_UnrestrictedNameParserRuleCall_7_2_1_q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
	/**
	 * Syntax:
	 *     ('(' ')')?
	 */
	protected void emit_TupleTypeCS___LeftParenthesisKeyword_1_0_RightParenthesisKeyword_1_2__q(EObject semanticObject, ISynNavigable transition, List<INode> nodes) {
		acceptNodes(transition, nodes);
	}
	
}
