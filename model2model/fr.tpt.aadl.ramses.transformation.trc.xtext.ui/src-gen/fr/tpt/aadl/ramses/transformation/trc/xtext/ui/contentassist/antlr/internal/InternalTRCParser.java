package fr.tpt.aadl.ramses.transformation.trc.xtext.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import fr.tpt.aadl.ramses.transformation.trc.xtext.services.TRCGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalTRCParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_UNQUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'requires'", "'excludes'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'Modules'", "'{'", "';'", "'}'", "'.'", "'['", "']'", "':'", "','", "'Transformations'", "'modules'", "'impacts'", "'('", "')'", "'Dependencies'", "'Apply'", "'or'", "'and'", "'-'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int EOF=-1;
    public static final int T__19=19;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_UNQUOTED_STRING=7;
    public static final int RULE_INT=6;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_STRING=5;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=10;

    // delegates
    // delegators


        public InternalTRCParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalTRCParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalTRCParser.tokenNames; }
    public String getGrammarFileName() { return "../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g"; }


     
     	private TRCGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(TRCGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleTrcSpecification"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:61:1: entryRuleTrcSpecification : ruleTrcSpecification EOF ;
    public final void entryRuleTrcSpecification() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:62:1: ( ruleTrcSpecification EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:63:1: ruleTrcSpecification EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrcSpecificationRule()); 
            }
            pushFollow(FOLLOW_ruleTrcSpecification_in_entryRuleTrcSpecification67);
            ruleTrcSpecification();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrcSpecificationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrcSpecification74); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTrcSpecification"


    // $ANTLR start "ruleTrcSpecification"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:70:1: ruleTrcSpecification : ( ( rule__TrcSpecification__Group__0 ) ) ;
    public final void ruleTrcSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:74:2: ( ( ( rule__TrcSpecification__Group__0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:75:1: ( ( rule__TrcSpecification__Group__0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:75:1: ( ( rule__TrcSpecification__Group__0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:76:1: ( rule__TrcSpecification__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrcSpecificationAccess().getGroup()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:77:1: ( rule__TrcSpecification__Group__0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:77:2: rule__TrcSpecification__Group__0
            {
            pushFollow(FOLLOW_rule__TrcSpecification__Group__0_in_ruleTrcSpecification100);
            rule__TrcSpecification__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrcSpecificationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrcSpecification"


    // $ANTLR start "entryRuleTrcRule"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:89:1: entryRuleTrcRule : ruleTrcRule EOF ;
    public final void entryRuleTrcRule() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:90:1: ( ruleTrcRule EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:91:1: ruleTrcRule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrcRuleRule()); 
            }
            pushFollow(FOLLOW_ruleTrcRule_in_entryRuleTrcRule127);
            ruleTrcRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrcRuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrcRule134); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTrcRule"


    // $ANTLR start "ruleTrcRule"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:98:1: ruleTrcRule : ( ( rule__TrcRule__NameAssignment ) ) ;
    public final void ruleTrcRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:102:2: ( ( ( rule__TrcRule__NameAssignment ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:103:1: ( ( rule__TrcRule__NameAssignment ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:103:1: ( ( rule__TrcRule__NameAssignment ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:104:1: ( rule__TrcRule__NameAssignment )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrcRuleAccess().getNameAssignment()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:105:1: ( rule__TrcRule__NameAssignment )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:105:2: rule__TrcRule__NameAssignment
            {
            pushFollow(FOLLOW_rule__TrcRule__NameAssignment_in_ruleTrcRule160);
            rule__TrcRule__NameAssignment();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrcRuleAccess().getNameAssignment()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTrcRule"


    // $ANTLR start "entryRuleModuleList"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:117:1: entryRuleModuleList : ruleModuleList EOF ;
    public final void entryRuleModuleList() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:118:1: ( ruleModuleList EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:119:1: ruleModuleList EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleListRule()); 
            }
            pushFollow(FOLLOW_ruleModuleList_in_entryRuleModuleList187);
            ruleModuleList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleListRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModuleList194); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModuleList"


    // $ANTLR start "ruleModuleList"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:126:1: ruleModuleList : ( ( rule__ModuleList__Group__0 ) ) ;
    public final void ruleModuleList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:130:2: ( ( ( rule__ModuleList__Group__0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:131:1: ( ( rule__ModuleList__Group__0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:131:1: ( ( rule__ModuleList__Group__0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:132:1: ( rule__ModuleList__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleListAccess().getGroup()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:133:1: ( rule__ModuleList__Group__0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:133:2: rule__ModuleList__Group__0
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__0_in_ruleModuleList220);
            rule__ModuleList__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleListAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModuleList"


    // $ANTLR start "entryRuleQualifiedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:145:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:146:1: ( ruleQualifiedName EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:147:1: ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName247);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName254); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:154:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:158:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:159:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:159:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:160:1: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:161:1: ( rule__QualifiedName__Group__0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:161:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName280);
            rule__QualifiedName__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleModule"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:173:1: entryRuleModule : ruleModule EOF ;
    public final void entryRuleModule() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:174:1: ( ruleModule EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:175:1: ruleModule EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleRule()); 
            }
            pushFollow(FOLLOW_ruleModule_in_entryRuleModule307);
            ruleModule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModule314); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:182:1: ruleModule : ( ( rule__Module__Group__0 ) ) ;
    public final void ruleModule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:186:2: ( ( ( rule__Module__Group__0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:187:1: ( ( rule__Module__Group__0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:187:1: ( ( rule__Module__Group__0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:188:1: ( rule__Module__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getGroup()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:189:1: ( rule__Module__Group__0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:189:2: rule__Module__Group__0
            {
            pushFollow(FOLLOW_rule__Module__Group__0_in_ruleModule340);
            rule__Module__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleTransformationList"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:201:1: entryRuleTransformationList : ruleTransformationList EOF ;
    public final void entryRuleTransformationList() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:202:1: ( ruleTransformationList EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:203:1: ruleTransformationList EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationListRule()); 
            }
            pushFollow(FOLLOW_ruleTransformationList_in_entryRuleTransformationList367);
            ruleTransformationList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationListRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationList374); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransformationList"


    // $ANTLR start "ruleTransformationList"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:210:1: ruleTransformationList : ( ( rule__TransformationList__Group__0 ) ) ;
    public final void ruleTransformationList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:214:2: ( ( ( rule__TransformationList__Group__0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:215:1: ( ( rule__TransformationList__Group__0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:215:1: ( ( rule__TransformationList__Group__0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:216:1: ( rule__TransformationList__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationListAccess().getGroup()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:217:1: ( rule__TransformationList__Group__0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:217:2: rule__TransformationList__Group__0
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__0_in_ruleTransformationList400);
            rule__TransformationList__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationListAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransformationList"


    // $ANTLR start "entryRuleTransformation"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:229:1: entryRuleTransformation : ruleTransformation EOF ;
    public final void entryRuleTransformation() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:230:1: ( ruleTransformation EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:231:1: ruleTransformation EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationRule()); 
            }
            pushFollow(FOLLOW_ruleTransformation_in_entryRuleTransformation427);
            ruleTransformation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformation434); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransformation"


    // $ANTLR start "ruleTransformation"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:238:1: ruleTransformation : ( ( rule__Transformation__Group__0 ) ) ;
    public final void ruleTransformation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:242:2: ( ( ( rule__Transformation__Group__0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:243:1: ( ( rule__Transformation__Group__0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:243:1: ( ( rule__Transformation__Group__0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:244:1: ( rule__Transformation__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getGroup()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:245:1: ( rule__Transformation__Group__0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:245:2: rule__Transformation__Group__0
            {
            pushFollow(FOLLOW_rule__Transformation__Group__0_in_ruleTransformation460);
            rule__Transformation__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransformation"


    // $ANTLR start "entryRuleTransformationImpact"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:257:1: entryRuleTransformationImpact : ruleTransformationImpact EOF ;
    public final void entryRuleTransformationImpact() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:258:1: ( ruleTransformationImpact EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:259:1: ruleTransformationImpact EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationImpactRule()); 
            }
            pushFollow(FOLLOW_ruleTransformationImpact_in_entryRuleTransformationImpact487);
            ruleTransformationImpact();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationImpactRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationImpact494); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransformationImpact"


    // $ANTLR start "ruleTransformationImpact"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:266:1: ruleTransformationImpact : ( ( rule__TransformationImpact__Group__0 ) ) ;
    public final void ruleTransformationImpact() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:270:2: ( ( ( rule__TransformationImpact__Group__0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:271:1: ( ( rule__TransformationImpact__Group__0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:271:1: ( ( rule__TransformationImpact__Group__0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:272:1: ( rule__TransformationImpact__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationImpactAccess().getGroup()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:273:1: ( rule__TransformationImpact__Group__0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:273:2: rule__TransformationImpact__Group__0
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group__0_in_ruleTransformationImpact520);
            rule__TransformationImpact__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationImpactAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransformationImpact"


    // $ANTLR start "entryRuleTransformationDependencyList"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:285:1: entryRuleTransformationDependencyList : ruleTransformationDependencyList EOF ;
    public final void entryRuleTransformationDependencyList() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:286:1: ( ruleTransformationDependencyList EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:287:1: ruleTransformationDependencyList EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyListRule()); 
            }
            pushFollow(FOLLOW_ruleTransformationDependencyList_in_entryRuleTransformationDependencyList547);
            ruleTransformationDependencyList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyListRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationDependencyList554); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransformationDependencyList"


    // $ANTLR start "ruleTransformationDependencyList"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:294:1: ruleTransformationDependencyList : ( ( rule__TransformationDependencyList__Group__0 ) ) ;
    public final void ruleTransformationDependencyList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:298:2: ( ( ( rule__TransformationDependencyList__Group__0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:299:1: ( ( rule__TransformationDependencyList__Group__0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:299:1: ( ( rule__TransformationDependencyList__Group__0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:300:1: ( rule__TransformationDependencyList__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyListAccess().getGroup()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:301:1: ( rule__TransformationDependencyList__Group__0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:301:2: rule__TransformationDependencyList__Group__0
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__0_in_ruleTransformationDependencyList580);
            rule__TransformationDependencyList__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyListAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransformationDependencyList"


    // $ANTLR start "entryRuleTransformationDependency"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:313:1: entryRuleTransformationDependency : ruleTransformationDependency EOF ;
    public final void entryRuleTransformationDependency() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:314:1: ( ruleTransformationDependency EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:315:1: ruleTransformationDependency EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyRule()); 
            }
            pushFollow(FOLLOW_ruleTransformationDependency_in_entryRuleTransformationDependency607);
            ruleTransformationDependency();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationDependency614); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleTransformationDependency"


    // $ANTLR start "ruleTransformationDependency"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:322:1: ruleTransformationDependency : ( ( rule__TransformationDependency__Group__0 ) ) ;
    public final void ruleTransformationDependency() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:326:2: ( ( ( rule__TransformationDependency__Group__0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:327:1: ( ( rule__TransformationDependency__Group__0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:327:1: ( ( rule__TransformationDependency__Group__0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:328:1: ( rule__TransformationDependency__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getGroup()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:329:1: ( rule__TransformationDependency__Group__0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:329:2: rule__TransformationDependency__Group__0
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__0_in_ruleTransformationDependency640);
            rule__TransformationDependency__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleTransformationDependency"


    // $ANTLR start "entryRuleRuleDependencyDisjunction"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:341:1: entryRuleRuleDependencyDisjunction : ruleRuleDependencyDisjunction EOF ;
    public final void entryRuleRuleDependencyDisjunction() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:342:1: ( ruleRuleDependencyDisjunction EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:343:1: ruleRuleDependencyDisjunction EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyDisjunctionRule()); 
            }
            pushFollow(FOLLOW_ruleRuleDependencyDisjunction_in_entryRuleRuleDependencyDisjunction667);
            ruleRuleDependencyDisjunction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyDisjunctionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDependencyDisjunction674); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRuleDependencyDisjunction"


    // $ANTLR start "ruleRuleDependencyDisjunction"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:350:1: ruleRuleDependencyDisjunction : ( ( rule__RuleDependencyDisjunction__Group__0 ) ) ;
    public final void ruleRuleDependencyDisjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:354:2: ( ( ( rule__RuleDependencyDisjunction__Group__0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:355:1: ( ( rule__RuleDependencyDisjunction__Group__0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:355:1: ( ( rule__RuleDependencyDisjunction__Group__0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:356:1: ( rule__RuleDependencyDisjunction__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyDisjunctionAccess().getGroup()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:357:1: ( rule__RuleDependencyDisjunction__Group__0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:357:2: rule__RuleDependencyDisjunction__Group__0
            {
            pushFollow(FOLLOW_rule__RuleDependencyDisjunction__Group__0_in_ruleRuleDependencyDisjunction700);
            rule__RuleDependencyDisjunction__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyDisjunctionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRuleDependencyDisjunction"


    // $ANTLR start "entryRuleRuleDependencyComposite"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:369:1: entryRuleRuleDependencyComposite : ruleRuleDependencyComposite EOF ;
    public final void entryRuleRuleDependencyComposite() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:370:1: ( ruleRuleDependencyComposite EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:371:1: ruleRuleDependencyComposite EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyCompositeRule()); 
            }
            pushFollow(FOLLOW_ruleRuleDependencyComposite_in_entryRuleRuleDependencyComposite727);
            ruleRuleDependencyComposite();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyCompositeRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDependencyComposite734); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRuleDependencyComposite"


    // $ANTLR start "ruleRuleDependencyComposite"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:378:1: ruleRuleDependencyComposite : ( ( rule__RuleDependencyComposite__Alternatives ) ) ;
    public final void ruleRuleDependencyComposite() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:382:2: ( ( ( rule__RuleDependencyComposite__Alternatives ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:383:1: ( ( rule__RuleDependencyComposite__Alternatives ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:383:1: ( ( rule__RuleDependencyComposite__Alternatives ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:384:1: ( rule__RuleDependencyComposite__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyCompositeAccess().getAlternatives()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:385:1: ( rule__RuleDependencyComposite__Alternatives )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:385:2: rule__RuleDependencyComposite__Alternatives
            {
            pushFollow(FOLLOW_rule__RuleDependencyComposite__Alternatives_in_ruleRuleDependencyComposite760);
            rule__RuleDependencyComposite__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyCompositeAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRuleDependencyComposite"


    // $ANTLR start "entryRuleRuleDependencyConjunction"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:397:1: entryRuleRuleDependencyConjunction : ruleRuleDependencyConjunction EOF ;
    public final void entryRuleRuleDependencyConjunction() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:398:1: ( ruleRuleDependencyConjunction EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:399:1: ruleRuleDependencyConjunction EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyConjunctionRule()); 
            }
            pushFollow(FOLLOW_ruleRuleDependencyConjunction_in_entryRuleRuleDependencyConjunction787);
            ruleRuleDependencyConjunction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyConjunctionRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDependencyConjunction794); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRuleDependencyConjunction"


    // $ANTLR start "ruleRuleDependencyConjunction"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:406:1: ruleRuleDependencyConjunction : ( ( rule__RuleDependencyConjunction__Group__0 ) ) ;
    public final void ruleRuleDependencyConjunction() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:410:2: ( ( ( rule__RuleDependencyConjunction__Group__0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:411:1: ( ( rule__RuleDependencyConjunction__Group__0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:411:1: ( ( rule__RuleDependencyConjunction__Group__0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:412:1: ( rule__RuleDependencyConjunction__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyConjunctionAccess().getGroup()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:413:1: ( rule__RuleDependencyConjunction__Group__0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:413:2: rule__RuleDependencyConjunction__Group__0
            {
            pushFollow(FOLLOW_rule__RuleDependencyConjunction__Group__0_in_ruleRuleDependencyConjunction820);
            rule__RuleDependencyConjunction__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyConjunctionAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRuleDependencyConjunction"


    // $ANTLR start "entryRuleAbstractRuleDependency"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:425:1: entryRuleAbstractRuleDependency : ruleAbstractRuleDependency EOF ;
    public final void entryRuleAbstractRuleDependency() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:426:1: ( ruleAbstractRuleDependency EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:427:1: ruleAbstractRuleDependency EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractRuleDependencyRule()); 
            }
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_entryRuleAbstractRuleDependency847);
            ruleAbstractRuleDependency();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractRuleDependencyRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRuleDependency854); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleAbstractRuleDependency"


    // $ANTLR start "ruleAbstractRuleDependency"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:434:1: ruleAbstractRuleDependency : ( ( rule__AbstractRuleDependency__Alternatives ) ) ;
    public final void ruleAbstractRuleDependency() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:438:2: ( ( ( rule__AbstractRuleDependency__Alternatives ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:439:1: ( ( rule__AbstractRuleDependency__Alternatives ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:439:1: ( ( rule__AbstractRuleDependency__Alternatives ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:440:1: ( rule__AbstractRuleDependency__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getAbstractRuleDependencyAccess().getAlternatives()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:441:1: ( rule__AbstractRuleDependency__Alternatives )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:441:2: rule__AbstractRuleDependency__Alternatives
            {
            pushFollow(FOLLOW_rule__AbstractRuleDependency__Alternatives_in_ruleAbstractRuleDependency880);
            rule__AbstractRuleDependency__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getAbstractRuleDependencyAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleAbstractRuleDependency"


    // $ANTLR start "entryRuleRuleDependency"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:453:1: entryRuleRuleDependency : ruleRuleDependency EOF ;
    public final void entryRuleRuleDependency() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:454:1: ( ruleRuleDependency EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:455:1: ruleRuleDependency EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyRule()); 
            }
            pushFollow(FOLLOW_ruleRuleDependency_in_entryRuleRuleDependency907);
            ruleRuleDependency();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDependency914); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleRuleDependency"


    // $ANTLR start "ruleRuleDependency"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:462:1: ruleRuleDependency : ( ( rule__RuleDependency__Group__0 ) ) ;
    public final void ruleRuleDependency() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:466:2: ( ( ( rule__RuleDependency__Group__0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:467:1: ( ( rule__RuleDependency__Group__0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:467:1: ( ( rule__RuleDependency__Group__0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:468:1: ( rule__RuleDependency__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getGroup()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:469:1: ( rule__RuleDependency__Group__0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:469:2: rule__RuleDependency__Group__0
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group__0_in_ruleRuleDependency940);
            rule__RuleDependency__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleRuleDependency"


    // $ANTLR start "entryRuleEString"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:485:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:486:1: ( ruleEString EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:487:1: ruleEString EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEStringRule()); 
            }
            pushFollow(FOLLOW_ruleEString_in_entryRuleEString971);
            ruleEString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEStringRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEString978); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:494:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:498:2: ( ( ( rule__EString__Alternatives ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:499:1: ( ( rule__EString__Alternatives ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:499:1: ( ( rule__EString__Alternatives ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:500:1: ( rule__EString__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEStringAccess().getAlternatives()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:501:1: ( rule__EString__Alternatives )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:501:2: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_rule__EString__Alternatives_in_ruleEString1004);
            rule__EString__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEStringAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleEInt"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:513:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:514:1: ( ruleEInt EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:515:1: ruleEInt EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEIntRule()); 
            }
            pushFollow(FOLLOW_ruleEInt_in_entryRuleEInt1031);
            ruleEInt();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEIntRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEInt1038); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:522:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:526:2: ( ( ( rule__EInt__Group__0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:527:1: ( ( rule__EInt__Group__0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:527:1: ( ( rule__EInt__Group__0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:528:1: ( rule__EInt__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEIntAccess().getGroup()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:529:1: ( rule__EInt__Group__0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:529:2: rule__EInt__Group__0
            {
            pushFollow(FOLLOW_rule__EInt__Group__0_in_ruleEInt1064);
            rule__EInt__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEIntAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleEssentialOCLUnrestrictedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:543:1: entryRuleEssentialOCLUnrestrictedName : ruleEssentialOCLUnrestrictedName EOF ;
    public final void entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:544:1: ( ruleEssentialOCLUnrestrictedName EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:545:1: ruleEssentialOCLUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEssentialOCLUnrestrictedNameRule()); 
            }
            pushFollow(FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName1093);
            ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEssentialOCLUnrestrictedNameRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName1100); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEssentialOCLUnrestrictedName"


    // $ANTLR start "ruleEssentialOCLUnrestrictedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:552:1: ruleEssentialOCLUnrestrictedName : ( ruleIdentifier ) ;
    public final void ruleEssentialOCLUnrestrictedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:556:2: ( ( ruleIdentifier ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:557:1: ( ruleIdentifier )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:557:1: ( ruleIdentifier )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:558:1: ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName1126);
            ruleIdentifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEssentialOCLUnrestrictedName"


    // $ANTLR start "entryRuleIdentifier"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:571:1: entryRuleIdentifier : ruleIdentifier EOF ;
    public final void entryRuleIdentifier() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:572:1: ( ruleIdentifier EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:573:1: ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier1152);
            ruleIdentifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIdentifierRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier1159); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:580:1: ruleIdentifier : ( RULE_ID ) ;
    public final void ruleIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:584:2: ( ( RULE_ID ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:585:1: ( RULE_ID )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:585:1: ( RULE_ID )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:586:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getIdentifierAccess().getIDTerminalRuleCall()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdentifier1185); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getIdentifierAccess().getIDTerminalRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleUnrestrictedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:599:1: entryRuleUnrestrictedName : ruleUnrestrictedName EOF ;
    public final void entryRuleUnrestrictedName() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:600:1: ( ruleUnrestrictedName EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:601:1: ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName1211);
            ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnrestrictedNameRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnrestrictedName1218); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleUnrestrictedName"


    // $ANTLR start "ruleUnrestrictedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:608:1: ruleUnrestrictedName : ( ruleEssentialOCLUnrestrictedName ) ;
    public final void ruleUnrestrictedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:612:2: ( ( ruleEssentialOCLUnrestrictedName ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:613:1: ( ruleEssentialOCLUnrestrictedName )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:613:1: ( ruleEssentialOCLUnrestrictedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:614:1: ruleEssentialOCLUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall()); 
            }
            pushFollow(FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName1244);
            ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleUnrestrictedName"


    // $ANTLR start "entryRuleEssentialOCLUnreservedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:633:1: entryRuleEssentialOCLUnreservedName : ruleEssentialOCLUnreservedName EOF ;
    public final void entryRuleEssentialOCLUnreservedName() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:634:1: ( ruleEssentialOCLUnreservedName EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:635:1: ruleEssentialOCLUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEssentialOCLUnreservedNameRule()); 
            }
            pushFollow(FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName1276);
            ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEssentialOCLUnreservedNameRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName1283); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleEssentialOCLUnreservedName"


    // $ANTLR start "ruleEssentialOCLUnreservedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:642:1: ruleEssentialOCLUnreservedName : ( ( rule__EssentialOCLUnreservedName__Alternatives ) ) ;
    public final void ruleEssentialOCLUnreservedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:646:2: ( ( ( rule__EssentialOCLUnreservedName__Alternatives ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:647:1: ( ( rule__EssentialOCLUnreservedName__Alternatives ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:647:1: ( ( rule__EssentialOCLUnreservedName__Alternatives ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:648:1: ( rule__EssentialOCLUnreservedName__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEssentialOCLUnreservedNameAccess().getAlternatives()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:649:1: ( rule__EssentialOCLUnreservedName__Alternatives )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:649:2: rule__EssentialOCLUnreservedName__Alternatives
            {
            pushFollow(FOLLOW_rule__EssentialOCLUnreservedName__Alternatives_in_ruleEssentialOCLUnreservedName1309);
            rule__EssentialOCLUnreservedName__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEssentialOCLUnreservedNameAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleEssentialOCLUnreservedName"


    // $ANTLR start "entryRulePrimitiveTypeIdentifier"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:661:1: entryRulePrimitiveTypeIdentifier : rulePrimitiveTypeIdentifier EOF ;
    public final void entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:662:1: ( rulePrimitiveTypeIdentifier EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:663:1: rulePrimitiveTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeIdentifierRule()); 
            }
            pushFollow(FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier1336);
            rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveTypeIdentifierRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier1343); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRulePrimitiveTypeIdentifier"


    // $ANTLR start "rulePrimitiveTypeIdentifier"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:670:1: rulePrimitiveTypeIdentifier : ( ( rule__PrimitiveTypeIdentifier__Alternatives ) ) ;
    public final void rulePrimitiveTypeIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:674:2: ( ( ( rule__PrimitiveTypeIdentifier__Alternatives ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:675:1: ( ( rule__PrimitiveTypeIdentifier__Alternatives ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:675:1: ( ( rule__PrimitiveTypeIdentifier__Alternatives ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:676:1: ( rule__PrimitiveTypeIdentifier__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getPrimitiveTypeIdentifierAccess().getAlternatives()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:677:1: ( rule__PrimitiveTypeIdentifier__Alternatives )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:677:2: rule__PrimitiveTypeIdentifier__Alternatives
            {
            pushFollow(FOLLOW_rule__PrimitiveTypeIdentifier__Alternatives_in_rulePrimitiveTypeIdentifier1369);
            rule__PrimitiveTypeIdentifier__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getPrimitiveTypeIdentifierAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rulePrimitiveTypeIdentifier"


    // $ANTLR start "entryRuleCollectionTypeIdentifier"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:689:1: entryRuleCollectionTypeIdentifier : ruleCollectionTypeIdentifier EOF ;
    public final void entryRuleCollectionTypeIdentifier() throws RecognitionException {
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:690:1: ( ruleCollectionTypeIdentifier EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:691:1: ruleCollectionTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionTypeIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier1396);
            ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionTypeIdentifierRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier1403); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleCollectionTypeIdentifier"


    // $ANTLR start "ruleCollectionTypeIdentifier"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:698:1: ruleCollectionTypeIdentifier : ( ( rule__CollectionTypeIdentifier__Alternatives ) ) ;
    public final void ruleCollectionTypeIdentifier() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:702:2: ( ( ( rule__CollectionTypeIdentifier__Alternatives ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:703:1: ( ( rule__CollectionTypeIdentifier__Alternatives ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:703:1: ( ( rule__CollectionTypeIdentifier__Alternatives ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:704:1: ( rule__CollectionTypeIdentifier__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getCollectionTypeIdentifierAccess().getAlternatives()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:705:1: ( rule__CollectionTypeIdentifier__Alternatives )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:705:2: rule__CollectionTypeIdentifier__Alternatives
            {
            pushFollow(FOLLOW_rule__CollectionTypeIdentifier__Alternatives_in_ruleCollectionTypeIdentifier1429);
            rule__CollectionTypeIdentifier__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getCollectionTypeIdentifierAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleCollectionTypeIdentifier"


    // $ANTLR start "rule__RuleDependencyComposite__Alternatives"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:717:1: rule__RuleDependencyComposite__Alternatives : ( ( ( rule__RuleDependencyComposite__Group_0__0 ) ) | ( ( rule__RuleDependencyComposite__Group_1__0 ) ) );
    public final void rule__RuleDependencyComposite__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:721:1: ( ( ( rule__RuleDependencyComposite__Group_0__0 ) ) | ( ( rule__RuleDependencyComposite__Group_1__0 ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==40) ) {
                int LA1_1 = input.LA(2);

                if ( (synpred1_InternalTRC()) ) {
                    alt1=1;
                }
                else if ( (true) ) {
                    alt1=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return ;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 1, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:722:1: ( ( rule__RuleDependencyComposite__Group_0__0 ) )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:722:1: ( ( rule__RuleDependencyComposite__Group_0__0 ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:723:1: ( rule__RuleDependencyComposite__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRuleDependencyCompositeAccess().getGroup_0()); 
                    }
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:724:1: ( rule__RuleDependencyComposite__Group_0__0 )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:724:2: rule__RuleDependencyComposite__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__RuleDependencyComposite__Group_0__0_in_rule__RuleDependencyComposite__Alternatives1465);
                    rule__RuleDependencyComposite__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRuleDependencyCompositeAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:728:6: ( ( rule__RuleDependencyComposite__Group_1__0 ) )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:728:6: ( ( rule__RuleDependencyComposite__Group_1__0 ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:729:1: ( rule__RuleDependencyComposite__Group_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRuleDependencyCompositeAccess().getGroup_1()); 
                    }
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:730:1: ( rule__RuleDependencyComposite__Group_1__0 )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:730:2: rule__RuleDependencyComposite__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__RuleDependencyComposite__Group_1__0_in_rule__RuleDependencyComposite__Alternatives1483);
                    rule__RuleDependencyComposite__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRuleDependencyCompositeAccess().getGroup_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyComposite__Alternatives"


    // $ANTLR start "rule__AbstractRuleDependency__Alternatives"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:739:1: rule__AbstractRuleDependency__Alternatives : ( ( ruleRuleDependencyComposite ) | ( ruleRuleDependency ) );
    public final void rule__AbstractRuleDependency__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:743:1: ( ( ruleRuleDependencyComposite ) | ( ruleRuleDependency ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==40) ) {
                alt2=1;
            }
            else if ( ((LA2_0>=12 && LA2_0<=13)) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:744:1: ( ruleRuleDependencyComposite )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:744:1: ( ruleRuleDependencyComposite )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:745:1: ruleRuleDependencyComposite
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAbstractRuleDependencyAccess().getRuleDependencyCompositeParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleRuleDependencyComposite_in_rule__AbstractRuleDependency__Alternatives1516);
                    ruleRuleDependencyComposite();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAbstractRuleDependencyAccess().getRuleDependencyCompositeParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:750:6: ( ruleRuleDependency )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:750:6: ( ruleRuleDependency )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:751:1: ruleRuleDependency
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getAbstractRuleDependencyAccess().getRuleDependencyParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleRuleDependency_in_rule__AbstractRuleDependency__Alternatives1533);
                    ruleRuleDependency();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getAbstractRuleDependencyAccess().getRuleDependencyParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__AbstractRuleDependency__Alternatives"


    // $ANTLR start "rule__RuleDependency__TypeAlternatives_0_0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:761:1: rule__RuleDependency__TypeAlternatives_0_0 : ( ( 'requires' ) | ( 'excludes' ) );
    public final void rule__RuleDependency__TypeAlternatives_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:765:1: ( ( 'requires' ) | ( 'excludes' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) ) {
                alt3=1;
            }
            else if ( (LA3_0==13) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:766:1: ( 'requires' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:766:1: ( 'requires' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:767:1: 'requires'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRuleDependencyAccess().getTypeRequiresKeyword_0_0_0()); 
                    }
                    match(input,12,FOLLOW_12_in_rule__RuleDependency__TypeAlternatives_0_01566); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRuleDependencyAccess().getTypeRequiresKeyword_0_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:774:6: ( 'excludes' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:774:6: ( 'excludes' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:775:1: 'excludes'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getRuleDependencyAccess().getTypeExcludesKeyword_0_0_1()); 
                    }
                    match(input,13,FOLLOW_13_in_rule__RuleDependency__TypeAlternatives_0_01586); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getRuleDependencyAccess().getTypeExcludesKeyword_0_0_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__TypeAlternatives_0_0"


    // $ANTLR start "rule__EString__Alternatives"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:787:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:791:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_STRING) ) {
                alt4=1;
            }
            else if ( (LA4_0==RULE_ID) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:792:1: ( RULE_STRING )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:792:1: ( RULE_STRING )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:793:1: RULE_STRING
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    }
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EString__Alternatives1620); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:798:6: ( RULE_ID )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:798:6: ( RULE_ID )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:799:1: RULE_ID
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    }
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EString__Alternatives1637); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EString__Alternatives"


    // $ANTLR start "rule__EssentialOCLUnreservedName__Alternatives"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:810:1: rule__EssentialOCLUnreservedName__Alternatives : ( ( ruleUnrestrictedName ) | ( ruleCollectionTypeIdentifier ) | ( rulePrimitiveTypeIdentifier ) | ( 'Tuple' ) );
    public final void rule__EssentialOCLUnreservedName__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:814:1: ( ( ruleUnrestrictedName ) | ( ruleCollectionTypeIdentifier ) | ( rulePrimitiveTypeIdentifier ) | ( 'Tuple' ) )
            int alt5=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt5=1;
                }
                break;
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
                {
                alt5=2;
                }
                break;
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                {
                alt5=3;
                }
                break;
            case 14:
                {
                alt5=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }

            switch (alt5) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:815:1: ( ruleUnrestrictedName )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:815:1: ( ruleUnrestrictedName )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:816:1: ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleUnrestrictedName_in_rule__EssentialOCLUnreservedName__Alternatives1670);
                    ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:821:6: ( ruleCollectionTypeIdentifier )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:821:6: ( ruleCollectionTypeIdentifier )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:822:1: ruleCollectionTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleCollectionTypeIdentifier_in_rule__EssentialOCLUnreservedName__Alternatives1687);
                    ruleCollectionTypeIdentifier();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:827:6: ( rulePrimitiveTypeIdentifier )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:827:6: ( rulePrimitiveTypeIdentifier )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:828:1: rulePrimitiveTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); 
                    }
                    pushFollow(FOLLOW_rulePrimitiveTypeIdentifier_in_rule__EssentialOCLUnreservedName__Alternatives1704);
                    rulePrimitiveTypeIdentifier();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:833:6: ( 'Tuple' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:833:6: ( 'Tuple' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:834:1: 'Tuple'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getEssentialOCLUnreservedNameAccess().getTupleKeyword_3()); 
                    }
                    match(input,14,FOLLOW_14_in_rule__EssentialOCLUnreservedName__Alternatives1722); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getEssentialOCLUnreservedNameAccess().getTupleKeyword_3()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EssentialOCLUnreservedName__Alternatives"


    // $ANTLR start "rule__PrimitiveTypeIdentifier__Alternatives"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:846:1: rule__PrimitiveTypeIdentifier__Alternatives : ( ( 'Boolean' ) | ( 'Integer' ) | ( 'Real' ) | ( 'String' ) | ( 'UnlimitedNatural' ) | ( 'OclAny' ) | ( 'OclInvalid' ) | ( 'OclVoid' ) );
    public final void rule__PrimitiveTypeIdentifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:850:1: ( ( 'Boolean' ) | ( 'Integer' ) | ( 'Real' ) | ( 'String' ) | ( 'UnlimitedNatural' ) | ( 'OclAny' ) | ( 'OclInvalid' ) | ( 'OclVoid' ) )
            int alt6=8;
            switch ( input.LA(1) ) {
            case 15:
                {
                alt6=1;
                }
                break;
            case 16:
                {
                alt6=2;
                }
                break;
            case 17:
                {
                alt6=3;
                }
                break;
            case 18:
                {
                alt6=4;
                }
                break;
            case 19:
                {
                alt6=5;
                }
                break;
            case 20:
                {
                alt6=6;
                }
                break;
            case 21:
                {
                alt6=7;
                }
                break;
            case 22:
                {
                alt6=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:851:1: ( 'Boolean' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:851:1: ( 'Boolean' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:852:1: 'Boolean'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                    }
                    match(input,15,FOLLOW_15_in_rule__PrimitiveTypeIdentifier__Alternatives1757); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:859:6: ( 'Integer' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:859:6: ( 'Integer' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:860:1: 'Integer'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                    }
                    match(input,16,FOLLOW_16_in_rule__PrimitiveTypeIdentifier__Alternatives1777); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:867:6: ( 'Real' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:867:6: ( 'Real' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:868:1: 'Real'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                    }
                    match(input,17,FOLLOW_17_in_rule__PrimitiveTypeIdentifier__Alternatives1797); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:875:6: ( 'String' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:875:6: ( 'String' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:876:1: 'String'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                    }
                    match(input,18,FOLLOW_18_in_rule__PrimitiveTypeIdentifier__Alternatives1817); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:883:6: ( 'UnlimitedNatural' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:883:6: ( 'UnlimitedNatural' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:884:1: 'UnlimitedNatural'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                    }
                    match(input,19,FOLLOW_19_in_rule__PrimitiveTypeIdentifier__Alternatives1837); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                    }

                    }


                    }
                    break;
                case 6 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:891:6: ( 'OclAny' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:891:6: ( 'OclAny' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:892:1: 'OclAny'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                    }
                    match(input,20,FOLLOW_20_in_rule__PrimitiveTypeIdentifier__Alternatives1857); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                    }

                    }


                    }
                    break;
                case 7 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:899:6: ( 'OclInvalid' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:899:6: ( 'OclInvalid' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:900:1: 'OclInvalid'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                    }
                    match(input,21,FOLLOW_21_in_rule__PrimitiveTypeIdentifier__Alternatives1877); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                    }

                    }


                    }
                    break;
                case 8 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:907:6: ( 'OclVoid' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:907:6: ( 'OclVoid' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:908:1: 'OclVoid'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclVoidKeyword_7()); 
                    }
                    match(input,22,FOLLOW_22_in_rule__PrimitiveTypeIdentifier__Alternatives1897); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getPrimitiveTypeIdentifierAccess().getOclVoidKeyword_7()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__PrimitiveTypeIdentifier__Alternatives"


    // $ANTLR start "rule__CollectionTypeIdentifier__Alternatives"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:920:1: rule__CollectionTypeIdentifier__Alternatives : ( ( 'Set' ) | ( 'Bag' ) | ( 'Sequence' ) | ( 'Collection' ) | ( 'OrderedSet' ) );
    public final void rule__CollectionTypeIdentifier__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:924:1: ( ( 'Set' ) | ( 'Bag' ) | ( 'Sequence' ) | ( 'Collection' ) | ( 'OrderedSet' ) )
            int alt7=5;
            switch ( input.LA(1) ) {
            case 23:
                {
                alt7=1;
                }
                break;
            case 24:
                {
                alt7=2;
                }
                break;
            case 25:
                {
                alt7=3;
                }
                break;
            case 26:
                {
                alt7=4;
                }
                break;
            case 27:
                {
                alt7=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:925:1: ( 'Set' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:925:1: ( 'Set' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:926:1: 'Set'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                    }
                    match(input,23,FOLLOW_23_in_rule__CollectionTypeIdentifier__Alternatives1932); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:933:6: ( 'Bag' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:933:6: ( 'Bag' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:934:1: 'Bag'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                    }
                    match(input,24,FOLLOW_24_in_rule__CollectionTypeIdentifier__Alternatives1952); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                    }

                    }


                    }
                    break;
                case 3 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:941:6: ( 'Sequence' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:941:6: ( 'Sequence' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:942:1: 'Sequence'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                    }
                    match(input,25,FOLLOW_25_in_rule__CollectionTypeIdentifier__Alternatives1972); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                    }

                    }


                    }
                    break;
                case 4 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:949:6: ( 'Collection' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:949:6: ( 'Collection' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:950:1: 'Collection'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                    }
                    match(input,26,FOLLOW_26_in_rule__CollectionTypeIdentifier__Alternatives1992); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                    }

                    }


                    }
                    break;
                case 5 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:957:6: ( 'OrderedSet' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:957:6: ( 'OrderedSet' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:958:1: 'OrderedSet'
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getCollectionTypeIdentifierAccess().getOrderedSetKeyword_4()); 
                    }
                    match(input,27,FOLLOW_27_in_rule__CollectionTypeIdentifier__Alternatives2012); if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getCollectionTypeIdentifierAccess().getOrderedSetKeyword_4()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__CollectionTypeIdentifier__Alternatives"


    // $ANTLR start "rule__TrcSpecification__Group__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:972:1: rule__TrcSpecification__Group__0 : rule__TrcSpecification__Group__0__Impl rule__TrcSpecification__Group__1 ;
    public final void rule__TrcSpecification__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:976:1: ( rule__TrcSpecification__Group__0__Impl rule__TrcSpecification__Group__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:977:2: rule__TrcSpecification__Group__0__Impl rule__TrcSpecification__Group__1
            {
            pushFollow(FOLLOW_rule__TrcSpecification__Group__0__Impl_in_rule__TrcSpecification__Group__02044);
            rule__TrcSpecification__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TrcSpecification__Group__1_in_rule__TrcSpecification__Group__02047);
            rule__TrcSpecification__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrcSpecification__Group__0"


    // $ANTLR start "rule__TrcSpecification__Group__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:984:1: rule__TrcSpecification__Group__0__Impl : ( ( rule__TrcSpecification__ModuleListAssignment_0 ) ) ;
    public final void rule__TrcSpecification__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:988:1: ( ( ( rule__TrcSpecification__ModuleListAssignment_0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:989:1: ( ( rule__TrcSpecification__ModuleListAssignment_0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:989:1: ( ( rule__TrcSpecification__ModuleListAssignment_0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:990:1: ( rule__TrcSpecification__ModuleListAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrcSpecificationAccess().getModuleListAssignment_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:991:1: ( rule__TrcSpecification__ModuleListAssignment_0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:991:2: rule__TrcSpecification__ModuleListAssignment_0
            {
            pushFollow(FOLLOW_rule__TrcSpecification__ModuleListAssignment_0_in_rule__TrcSpecification__Group__0__Impl2074);
            rule__TrcSpecification__ModuleListAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrcSpecificationAccess().getModuleListAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrcSpecification__Group__0__Impl"


    // $ANTLR start "rule__TrcSpecification__Group__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1001:1: rule__TrcSpecification__Group__1 : rule__TrcSpecification__Group__1__Impl rule__TrcSpecification__Group__2 ;
    public final void rule__TrcSpecification__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1005:1: ( rule__TrcSpecification__Group__1__Impl rule__TrcSpecification__Group__2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1006:2: rule__TrcSpecification__Group__1__Impl rule__TrcSpecification__Group__2
            {
            pushFollow(FOLLOW_rule__TrcSpecification__Group__1__Impl_in_rule__TrcSpecification__Group__12104);
            rule__TrcSpecification__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TrcSpecification__Group__2_in_rule__TrcSpecification__Group__12107);
            rule__TrcSpecification__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrcSpecification__Group__1"


    // $ANTLR start "rule__TrcSpecification__Group__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1013:1: rule__TrcSpecification__Group__1__Impl : ( ( rule__TrcSpecification__TransformationListAssignment_1 ) ) ;
    public final void rule__TrcSpecification__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1017:1: ( ( ( rule__TrcSpecification__TransformationListAssignment_1 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1018:1: ( ( rule__TrcSpecification__TransformationListAssignment_1 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1018:1: ( ( rule__TrcSpecification__TransformationListAssignment_1 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1019:1: ( rule__TrcSpecification__TransformationListAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrcSpecificationAccess().getTransformationListAssignment_1()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1020:1: ( rule__TrcSpecification__TransformationListAssignment_1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1020:2: rule__TrcSpecification__TransformationListAssignment_1
            {
            pushFollow(FOLLOW_rule__TrcSpecification__TransformationListAssignment_1_in_rule__TrcSpecification__Group__1__Impl2134);
            rule__TrcSpecification__TransformationListAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrcSpecificationAccess().getTransformationListAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrcSpecification__Group__1__Impl"


    // $ANTLR start "rule__TrcSpecification__Group__2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1030:1: rule__TrcSpecification__Group__2 : rule__TrcSpecification__Group__2__Impl ;
    public final void rule__TrcSpecification__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1034:1: ( rule__TrcSpecification__Group__2__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1035:2: rule__TrcSpecification__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TrcSpecification__Group__2__Impl_in_rule__TrcSpecification__Group__22164);
            rule__TrcSpecification__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrcSpecification__Group__2"


    // $ANTLR start "rule__TrcSpecification__Group__2__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1041:1: rule__TrcSpecification__Group__2__Impl : ( ( rule__TrcSpecification__DependencyListAssignment_2 ) ) ;
    public final void rule__TrcSpecification__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1045:1: ( ( ( rule__TrcSpecification__DependencyListAssignment_2 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1046:1: ( ( rule__TrcSpecification__DependencyListAssignment_2 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1046:1: ( ( rule__TrcSpecification__DependencyListAssignment_2 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1047:1: ( rule__TrcSpecification__DependencyListAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrcSpecificationAccess().getDependencyListAssignment_2()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1048:1: ( rule__TrcSpecification__DependencyListAssignment_2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1048:2: rule__TrcSpecification__DependencyListAssignment_2
            {
            pushFollow(FOLLOW_rule__TrcSpecification__DependencyListAssignment_2_in_rule__TrcSpecification__Group__2__Impl2191);
            rule__TrcSpecification__DependencyListAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrcSpecificationAccess().getDependencyListAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrcSpecification__Group__2__Impl"


    // $ANTLR start "rule__ModuleList__Group__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1064:1: rule__ModuleList__Group__0 : rule__ModuleList__Group__0__Impl rule__ModuleList__Group__1 ;
    public final void rule__ModuleList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1068:1: ( rule__ModuleList__Group__0__Impl rule__ModuleList__Group__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1069:2: rule__ModuleList__Group__0__Impl rule__ModuleList__Group__1
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__0__Impl_in_rule__ModuleList__Group__02227);
            rule__ModuleList__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ModuleList__Group__1_in_rule__ModuleList__Group__02230);
            rule__ModuleList__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group__0"


    // $ANTLR start "rule__ModuleList__Group__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1076:1: rule__ModuleList__Group__0__Impl : ( 'Modules' ) ;
    public final void rule__ModuleList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1080:1: ( ( 'Modules' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1081:1: ( 'Modules' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1081:1: ( 'Modules' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1082:1: 'Modules'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleListAccess().getModulesKeyword_0()); 
            }
            match(input,28,FOLLOW_28_in_rule__ModuleList__Group__0__Impl2258); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleListAccess().getModulesKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group__0__Impl"


    // $ANTLR start "rule__ModuleList__Group__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1095:1: rule__ModuleList__Group__1 : rule__ModuleList__Group__1__Impl rule__ModuleList__Group__2 ;
    public final void rule__ModuleList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1099:1: ( rule__ModuleList__Group__1__Impl rule__ModuleList__Group__2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1100:2: rule__ModuleList__Group__1__Impl rule__ModuleList__Group__2
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__1__Impl_in_rule__ModuleList__Group__12289);
            rule__ModuleList__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ModuleList__Group__2_in_rule__ModuleList__Group__12292);
            rule__ModuleList__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group__1"


    // $ANTLR start "rule__ModuleList__Group__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1107:1: rule__ModuleList__Group__1__Impl : ( '{' ) ;
    public final void rule__ModuleList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1111:1: ( ( '{' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1112:1: ( '{' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1112:1: ( '{' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1113:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleListAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,29,FOLLOW_29_in_rule__ModuleList__Group__1__Impl2320); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleListAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group__1__Impl"


    // $ANTLR start "rule__ModuleList__Group__2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1126:1: rule__ModuleList__Group__2 : rule__ModuleList__Group__2__Impl rule__ModuleList__Group__3 ;
    public final void rule__ModuleList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1130:1: ( rule__ModuleList__Group__2__Impl rule__ModuleList__Group__3 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1131:2: rule__ModuleList__Group__2__Impl rule__ModuleList__Group__3
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__2__Impl_in_rule__ModuleList__Group__22351);
            rule__ModuleList__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ModuleList__Group__3_in_rule__ModuleList__Group__22354);
            rule__ModuleList__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group__2"


    // $ANTLR start "rule__ModuleList__Group__2__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1138:1: rule__ModuleList__Group__2__Impl : ( ( rule__ModuleList__ModulesAssignment_2 ) ) ;
    public final void rule__ModuleList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1142:1: ( ( ( rule__ModuleList__ModulesAssignment_2 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1143:1: ( ( rule__ModuleList__ModulesAssignment_2 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1143:1: ( ( rule__ModuleList__ModulesAssignment_2 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1144:1: ( rule__ModuleList__ModulesAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleListAccess().getModulesAssignment_2()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1145:1: ( rule__ModuleList__ModulesAssignment_2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1145:2: rule__ModuleList__ModulesAssignment_2
            {
            pushFollow(FOLLOW_rule__ModuleList__ModulesAssignment_2_in_rule__ModuleList__Group__2__Impl2381);
            rule__ModuleList__ModulesAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleListAccess().getModulesAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group__2__Impl"


    // $ANTLR start "rule__ModuleList__Group__3"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1155:1: rule__ModuleList__Group__3 : rule__ModuleList__Group__3__Impl rule__ModuleList__Group__4 ;
    public final void rule__ModuleList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1159:1: ( rule__ModuleList__Group__3__Impl rule__ModuleList__Group__4 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1160:2: rule__ModuleList__Group__3__Impl rule__ModuleList__Group__4
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__3__Impl_in_rule__ModuleList__Group__32411);
            rule__ModuleList__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ModuleList__Group__4_in_rule__ModuleList__Group__32414);
            rule__ModuleList__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group__3"


    // $ANTLR start "rule__ModuleList__Group__3__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1167:1: rule__ModuleList__Group__3__Impl : ( ';' ) ;
    public final void rule__ModuleList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1171:1: ( ( ';' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1172:1: ( ';' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1172:1: ( ';' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1173:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleListAccess().getSemicolonKeyword_3()); 
            }
            match(input,30,FOLLOW_30_in_rule__ModuleList__Group__3__Impl2442); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleListAccess().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group__3__Impl"


    // $ANTLR start "rule__ModuleList__Group__4"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1186:1: rule__ModuleList__Group__4 : rule__ModuleList__Group__4__Impl rule__ModuleList__Group__5 ;
    public final void rule__ModuleList__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1190:1: ( rule__ModuleList__Group__4__Impl rule__ModuleList__Group__5 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1191:2: rule__ModuleList__Group__4__Impl rule__ModuleList__Group__5
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__4__Impl_in_rule__ModuleList__Group__42473);
            rule__ModuleList__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ModuleList__Group__5_in_rule__ModuleList__Group__42476);
            rule__ModuleList__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group__4"


    // $ANTLR start "rule__ModuleList__Group__4__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1198:1: rule__ModuleList__Group__4__Impl : ( ( rule__ModuleList__Group_4__0 )* ) ;
    public final void rule__ModuleList__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1202:1: ( ( ( rule__ModuleList__Group_4__0 )* ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1203:1: ( ( rule__ModuleList__Group_4__0 )* )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1203:1: ( ( rule__ModuleList__Group_4__0 )* )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1204:1: ( rule__ModuleList__Group_4__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleListAccess().getGroup_4()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1205:1: ( rule__ModuleList__Group_4__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( ((LA8_0>=RULE_ID && LA8_0<=RULE_STRING)) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1205:2: rule__ModuleList__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__ModuleList__Group_4__0_in_rule__ModuleList__Group__4__Impl2503);
            	    rule__ModuleList__Group_4__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleListAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group__4__Impl"


    // $ANTLR start "rule__ModuleList__Group__5"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1215:1: rule__ModuleList__Group__5 : rule__ModuleList__Group__5__Impl ;
    public final void rule__ModuleList__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1219:1: ( rule__ModuleList__Group__5__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1220:2: rule__ModuleList__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__5__Impl_in_rule__ModuleList__Group__52534);
            rule__ModuleList__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group__5"


    // $ANTLR start "rule__ModuleList__Group__5__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1226:1: rule__ModuleList__Group__5__Impl : ( '}' ) ;
    public final void rule__ModuleList__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1230:1: ( ( '}' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1231:1: ( '}' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1231:1: ( '}' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1232:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleListAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,31,FOLLOW_31_in_rule__ModuleList__Group__5__Impl2562); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleListAccess().getRightCurlyBracketKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group__5__Impl"


    // $ANTLR start "rule__ModuleList__Group_4__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1257:1: rule__ModuleList__Group_4__0 : rule__ModuleList__Group_4__0__Impl rule__ModuleList__Group_4__1 ;
    public final void rule__ModuleList__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1261:1: ( rule__ModuleList__Group_4__0__Impl rule__ModuleList__Group_4__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1262:2: rule__ModuleList__Group_4__0__Impl rule__ModuleList__Group_4__1
            {
            pushFollow(FOLLOW_rule__ModuleList__Group_4__0__Impl_in_rule__ModuleList__Group_4__02605);
            rule__ModuleList__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ModuleList__Group_4__1_in_rule__ModuleList__Group_4__02608);
            rule__ModuleList__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group_4__0"


    // $ANTLR start "rule__ModuleList__Group_4__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1269:1: rule__ModuleList__Group_4__0__Impl : ( ( rule__ModuleList__ModulesAssignment_4_0 ) ) ;
    public final void rule__ModuleList__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1273:1: ( ( ( rule__ModuleList__ModulesAssignment_4_0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1274:1: ( ( rule__ModuleList__ModulesAssignment_4_0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1274:1: ( ( rule__ModuleList__ModulesAssignment_4_0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1275:1: ( rule__ModuleList__ModulesAssignment_4_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleListAccess().getModulesAssignment_4_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1276:1: ( rule__ModuleList__ModulesAssignment_4_0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1276:2: rule__ModuleList__ModulesAssignment_4_0
            {
            pushFollow(FOLLOW_rule__ModuleList__ModulesAssignment_4_0_in_rule__ModuleList__Group_4__0__Impl2635);
            rule__ModuleList__ModulesAssignment_4_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleListAccess().getModulesAssignment_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group_4__0__Impl"


    // $ANTLR start "rule__ModuleList__Group_4__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1286:1: rule__ModuleList__Group_4__1 : rule__ModuleList__Group_4__1__Impl ;
    public final void rule__ModuleList__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1290:1: ( rule__ModuleList__Group_4__1__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1291:2: rule__ModuleList__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__ModuleList__Group_4__1__Impl_in_rule__ModuleList__Group_4__12665);
            rule__ModuleList__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group_4__1"


    // $ANTLR start "rule__ModuleList__Group_4__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1297:1: rule__ModuleList__Group_4__1__Impl : ( ';' ) ;
    public final void rule__ModuleList__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1301:1: ( ( ';' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1302:1: ( ';' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1302:1: ( ';' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1303:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleListAccess().getSemicolonKeyword_4_1()); 
            }
            match(input,30,FOLLOW_30_in_rule__ModuleList__Group_4__1__Impl2693); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleListAccess().getSemicolonKeyword_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group_4__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1320:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1324:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1325:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02728);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02731);
            rule__QualifiedName__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1332:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1336:1: ( ( RULE_ID ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1337:1: ( RULE_ID )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1337:1: ( RULE_ID )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1338:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl2758); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1349:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1353:1: ( rule__QualifiedName__Group__1__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1354:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12787);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1360:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1364:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1365:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1365:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1366:1: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1367:1: ( rule__QualifiedName__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==32) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1367:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl2814);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1381:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1385:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1386:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__02849);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__02852);
            rule__QualifiedName__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1393:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1397:1: ( ( '.' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1398:1: ( '.' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1398:1: ( '.' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1399:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            match(input,32,FOLLOW_32_in_rule__QualifiedName__Group_1__0__Impl2880); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1412:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1416:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1417:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__12911);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1423:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1427:1: ( ( RULE_ID ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1428:1: ( RULE_ID )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1428:1: ( RULE_ID )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1429:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl2938); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__Module__Group__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1444:1: rule__Module__Group__0 : rule__Module__Group__0__Impl rule__Module__Group__1 ;
    public final void rule__Module__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1448:1: ( rule__Module__Group__0__Impl rule__Module__Group__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1449:2: rule__Module__Group__0__Impl rule__Module__Group__1
            {
            pushFollow(FOLLOW_rule__Module__Group__0__Impl_in_rule__Module__Group__02971);
            rule__Module__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__1_in_rule__Module__Group__02974);
            rule__Module__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__0"


    // $ANTLR start "rule__Module__Group__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1456:1: rule__Module__Group__0__Impl : ( ( rule__Module__NameAssignment_0 ) ) ;
    public final void rule__Module__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1460:1: ( ( ( rule__Module__NameAssignment_0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1461:1: ( ( rule__Module__NameAssignment_0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1461:1: ( ( rule__Module__NameAssignment_0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1462:1: ( rule__Module__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getNameAssignment_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1463:1: ( rule__Module__NameAssignment_0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1463:2: rule__Module__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Module__NameAssignment_0_in_rule__Module__Group__0__Impl3001);
            rule__Module__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getNameAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__0__Impl"


    // $ANTLR start "rule__Module__Group__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1473:1: rule__Module__Group__1 : rule__Module__Group__1__Impl rule__Module__Group__2 ;
    public final void rule__Module__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1477:1: ( rule__Module__Group__1__Impl rule__Module__Group__2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1478:2: rule__Module__Group__1__Impl rule__Module__Group__2
            {
            pushFollow(FOLLOW_rule__Module__Group__1__Impl_in_rule__Module__Group__13031);
            rule__Module__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__2_in_rule__Module__Group__13034);
            rule__Module__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__1"


    // $ANTLR start "rule__Module__Group__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1485:1: rule__Module__Group__1__Impl : ( '[' ) ;
    public final void rule__Module__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1489:1: ( ( '[' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1490:1: ( '[' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1490:1: ( '[' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1491:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getLeftSquareBracketKeyword_1()); 
            }
            match(input,33,FOLLOW_33_in_rule__Module__Group__1__Impl3062); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getLeftSquareBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__1__Impl"


    // $ANTLR start "rule__Module__Group__2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1504:1: rule__Module__Group__2 : rule__Module__Group__2__Impl rule__Module__Group__3 ;
    public final void rule__Module__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1508:1: ( rule__Module__Group__2__Impl rule__Module__Group__3 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1509:2: rule__Module__Group__2__Impl rule__Module__Group__3
            {
            pushFollow(FOLLOW_rule__Module__Group__2__Impl_in_rule__Module__Group__23093);
            rule__Module__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__3_in_rule__Module__Group__23096);
            rule__Module__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__2"


    // $ANTLR start "rule__Module__Group__2__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1516:1: rule__Module__Group__2__Impl : ( ( rule__Module__PathAssignment_2 ) ) ;
    public final void rule__Module__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1520:1: ( ( ( rule__Module__PathAssignment_2 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1521:1: ( ( rule__Module__PathAssignment_2 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1521:1: ( ( rule__Module__PathAssignment_2 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1522:1: ( rule__Module__PathAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getPathAssignment_2()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1523:1: ( rule__Module__PathAssignment_2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1523:2: rule__Module__PathAssignment_2
            {
            pushFollow(FOLLOW_rule__Module__PathAssignment_2_in_rule__Module__Group__2__Impl3123);
            rule__Module__PathAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getPathAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__2__Impl"


    // $ANTLR start "rule__Module__Group__3"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1533:1: rule__Module__Group__3 : rule__Module__Group__3__Impl rule__Module__Group__4 ;
    public final void rule__Module__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1537:1: ( rule__Module__Group__3__Impl rule__Module__Group__4 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1538:2: rule__Module__Group__3__Impl rule__Module__Group__4
            {
            pushFollow(FOLLOW_rule__Module__Group__3__Impl_in_rule__Module__Group__33153);
            rule__Module__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group__4_in_rule__Module__Group__33156);
            rule__Module__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__3"


    // $ANTLR start "rule__Module__Group__3__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1545:1: rule__Module__Group__3__Impl : ( ']' ) ;
    public final void rule__Module__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1549:1: ( ( ']' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1550:1: ( ']' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1550:1: ( ']' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1551:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getRightSquareBracketKeyword_3()); 
            }
            match(input,34,FOLLOW_34_in_rule__Module__Group__3__Impl3184); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getRightSquareBracketKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__3__Impl"


    // $ANTLR start "rule__Module__Group__4"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1564:1: rule__Module__Group__4 : rule__Module__Group__4__Impl ;
    public final void rule__Module__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1568:1: ( rule__Module__Group__4__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1569:2: rule__Module__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__Module__Group__4__Impl_in_rule__Module__Group__43215);
            rule__Module__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__4"


    // $ANTLR start "rule__Module__Group__4__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1575:1: rule__Module__Group__4__Impl : ( ( rule__Module__Group_4__0 )? ) ;
    public final void rule__Module__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1579:1: ( ( ( rule__Module__Group_4__0 )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1580:1: ( ( rule__Module__Group_4__0 )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1580:1: ( ( rule__Module__Group_4__0 )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1581:1: ( rule__Module__Group_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getGroup_4()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1582:1: ( rule__Module__Group_4__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==35) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1582:2: rule__Module__Group_4__0
                    {
                    pushFollow(FOLLOW_rule__Module__Group_4__0_in_rule__Module__Group__4__Impl3242);
                    rule__Module__Group_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__4__Impl"


    // $ANTLR start "rule__Module__Group_4__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1602:1: rule__Module__Group_4__0 : rule__Module__Group_4__0__Impl rule__Module__Group_4__1 ;
    public final void rule__Module__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1606:1: ( rule__Module__Group_4__0__Impl rule__Module__Group_4__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1607:2: rule__Module__Group_4__0__Impl rule__Module__Group_4__1
            {
            pushFollow(FOLLOW_rule__Module__Group_4__0__Impl_in_rule__Module__Group_4__03283);
            rule__Module__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group_4__1_in_rule__Module__Group_4__03286);
            rule__Module__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_4__0"


    // $ANTLR start "rule__Module__Group_4__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1614:1: rule__Module__Group_4__0__Impl : ( ':' ) ;
    public final void rule__Module__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1618:1: ( ( ':' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1619:1: ( ':' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1619:1: ( ':' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1620:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getColonKeyword_4_0()); 
            }
            match(input,35,FOLLOW_35_in_rule__Module__Group_4__0__Impl3314); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getColonKeyword_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_4__0__Impl"


    // $ANTLR start "rule__Module__Group_4__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1633:1: rule__Module__Group_4__1 : rule__Module__Group_4__1__Impl rule__Module__Group_4__2 ;
    public final void rule__Module__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1637:1: ( rule__Module__Group_4__1__Impl rule__Module__Group_4__2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1638:2: rule__Module__Group_4__1__Impl rule__Module__Group_4__2
            {
            pushFollow(FOLLOW_rule__Module__Group_4__1__Impl_in_rule__Module__Group_4__13345);
            rule__Module__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group_4__2_in_rule__Module__Group_4__13348);
            rule__Module__Group_4__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_4__1"


    // $ANTLR start "rule__Module__Group_4__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1645:1: rule__Module__Group_4__1__Impl : ( ( rule__Module__RulesAssignment_4_1 ) ) ;
    public final void rule__Module__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1649:1: ( ( ( rule__Module__RulesAssignment_4_1 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1650:1: ( ( rule__Module__RulesAssignment_4_1 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1650:1: ( ( rule__Module__RulesAssignment_4_1 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1651:1: ( rule__Module__RulesAssignment_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getRulesAssignment_4_1()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1652:1: ( rule__Module__RulesAssignment_4_1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1652:2: rule__Module__RulesAssignment_4_1
            {
            pushFollow(FOLLOW_rule__Module__RulesAssignment_4_1_in_rule__Module__Group_4__1__Impl3375);
            rule__Module__RulesAssignment_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getRulesAssignment_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_4__1__Impl"


    // $ANTLR start "rule__Module__Group_4__2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1662:1: rule__Module__Group_4__2 : rule__Module__Group_4__2__Impl ;
    public final void rule__Module__Group_4__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1666:1: ( rule__Module__Group_4__2__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1667:2: rule__Module__Group_4__2__Impl
            {
            pushFollow(FOLLOW_rule__Module__Group_4__2__Impl_in_rule__Module__Group_4__23405);
            rule__Module__Group_4__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_4__2"


    // $ANTLR start "rule__Module__Group_4__2__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1673:1: rule__Module__Group_4__2__Impl : ( ( rule__Module__Group_4_2__0 )* ) ;
    public final void rule__Module__Group_4__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1677:1: ( ( ( rule__Module__Group_4_2__0 )* ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1678:1: ( ( rule__Module__Group_4_2__0 )* )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1678:1: ( ( rule__Module__Group_4_2__0 )* )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1679:1: ( rule__Module__Group_4_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getGroup_4_2()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1680:1: ( rule__Module__Group_4_2__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==36) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1680:2: rule__Module__Group_4_2__0
            	    {
            	    pushFollow(FOLLOW_rule__Module__Group_4_2__0_in_rule__Module__Group_4__2__Impl3432);
            	    rule__Module__Group_4_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getGroup_4_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_4__2__Impl"


    // $ANTLR start "rule__Module__Group_4_2__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1696:1: rule__Module__Group_4_2__0 : rule__Module__Group_4_2__0__Impl rule__Module__Group_4_2__1 ;
    public final void rule__Module__Group_4_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1700:1: ( rule__Module__Group_4_2__0__Impl rule__Module__Group_4_2__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1701:2: rule__Module__Group_4_2__0__Impl rule__Module__Group_4_2__1
            {
            pushFollow(FOLLOW_rule__Module__Group_4_2__0__Impl_in_rule__Module__Group_4_2__03469);
            rule__Module__Group_4_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Module__Group_4_2__1_in_rule__Module__Group_4_2__03472);
            rule__Module__Group_4_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_4_2__0"


    // $ANTLR start "rule__Module__Group_4_2__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1708:1: rule__Module__Group_4_2__0__Impl : ( ',' ) ;
    public final void rule__Module__Group_4_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1712:1: ( ( ',' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1713:1: ( ',' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1713:1: ( ',' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1714:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getCommaKeyword_4_2_0()); 
            }
            match(input,36,FOLLOW_36_in_rule__Module__Group_4_2__0__Impl3500); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getCommaKeyword_4_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_4_2__0__Impl"


    // $ANTLR start "rule__Module__Group_4_2__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1727:1: rule__Module__Group_4_2__1 : rule__Module__Group_4_2__1__Impl ;
    public final void rule__Module__Group_4_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1731:1: ( rule__Module__Group_4_2__1__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1732:2: rule__Module__Group_4_2__1__Impl
            {
            pushFollow(FOLLOW_rule__Module__Group_4_2__1__Impl_in_rule__Module__Group_4_2__13531);
            rule__Module__Group_4_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_4_2__1"


    // $ANTLR start "rule__Module__Group_4_2__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1738:1: rule__Module__Group_4_2__1__Impl : ( ( rule__Module__RulesAssignment_4_2_1 ) ) ;
    public final void rule__Module__Group_4_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1742:1: ( ( ( rule__Module__RulesAssignment_4_2_1 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1743:1: ( ( rule__Module__RulesAssignment_4_2_1 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1743:1: ( ( rule__Module__RulesAssignment_4_2_1 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1744:1: ( rule__Module__RulesAssignment_4_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getRulesAssignment_4_2_1()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1745:1: ( rule__Module__RulesAssignment_4_2_1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1745:2: rule__Module__RulesAssignment_4_2_1
            {
            pushFollow(FOLLOW_rule__Module__RulesAssignment_4_2_1_in_rule__Module__Group_4_2__1__Impl3558);
            rule__Module__RulesAssignment_4_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getRulesAssignment_4_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_4_2__1__Impl"


    // $ANTLR start "rule__TransformationList__Group__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1759:1: rule__TransformationList__Group__0 : rule__TransformationList__Group__0__Impl rule__TransformationList__Group__1 ;
    public final void rule__TransformationList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1763:1: ( rule__TransformationList__Group__0__Impl rule__TransformationList__Group__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1764:2: rule__TransformationList__Group__0__Impl rule__TransformationList__Group__1
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__0__Impl_in_rule__TransformationList__Group__03592);
            rule__TransformationList__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationList__Group__1_in_rule__TransformationList__Group__03595);
            rule__TransformationList__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationList__Group__0"


    // $ANTLR start "rule__TransformationList__Group__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1771:1: rule__TransformationList__Group__0__Impl : ( 'Transformations' ) ;
    public final void rule__TransformationList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1775:1: ( ( 'Transformations' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1776:1: ( 'Transformations' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1776:1: ( 'Transformations' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1777:1: 'Transformations'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationListAccess().getTransformationsKeyword_0()); 
            }
            match(input,37,FOLLOW_37_in_rule__TransformationList__Group__0__Impl3623); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationListAccess().getTransformationsKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationList__Group__0__Impl"


    // $ANTLR start "rule__TransformationList__Group__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1790:1: rule__TransformationList__Group__1 : rule__TransformationList__Group__1__Impl rule__TransformationList__Group__2 ;
    public final void rule__TransformationList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1794:1: ( rule__TransformationList__Group__1__Impl rule__TransformationList__Group__2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1795:2: rule__TransformationList__Group__1__Impl rule__TransformationList__Group__2
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__1__Impl_in_rule__TransformationList__Group__13654);
            rule__TransformationList__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationList__Group__2_in_rule__TransformationList__Group__13657);
            rule__TransformationList__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationList__Group__1"


    // $ANTLR start "rule__TransformationList__Group__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1802:1: rule__TransformationList__Group__1__Impl : ( '{' ) ;
    public final void rule__TransformationList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1806:1: ( ( '{' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1807:1: ( '{' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1807:1: ( '{' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1808:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationListAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,29,FOLLOW_29_in_rule__TransformationList__Group__1__Impl3685); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationListAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationList__Group__1__Impl"


    // $ANTLR start "rule__TransformationList__Group__2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1821:1: rule__TransformationList__Group__2 : rule__TransformationList__Group__2__Impl rule__TransformationList__Group__3 ;
    public final void rule__TransformationList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1825:1: ( rule__TransformationList__Group__2__Impl rule__TransformationList__Group__3 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1826:2: rule__TransformationList__Group__2__Impl rule__TransformationList__Group__3
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__2__Impl_in_rule__TransformationList__Group__23716);
            rule__TransformationList__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationList__Group__3_in_rule__TransformationList__Group__23719);
            rule__TransformationList__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationList__Group__2"


    // $ANTLR start "rule__TransformationList__Group__2__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1833:1: rule__TransformationList__Group__2__Impl : ( ( rule__TransformationList__TransformationsAssignment_2 ) ) ;
    public final void rule__TransformationList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1837:1: ( ( ( rule__TransformationList__TransformationsAssignment_2 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1838:1: ( ( rule__TransformationList__TransformationsAssignment_2 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1838:1: ( ( rule__TransformationList__TransformationsAssignment_2 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1839:1: ( rule__TransformationList__TransformationsAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationListAccess().getTransformationsAssignment_2()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1840:1: ( rule__TransformationList__TransformationsAssignment_2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1840:2: rule__TransformationList__TransformationsAssignment_2
            {
            pushFollow(FOLLOW_rule__TransformationList__TransformationsAssignment_2_in_rule__TransformationList__Group__2__Impl3746);
            rule__TransformationList__TransformationsAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationListAccess().getTransformationsAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationList__Group__2__Impl"


    // $ANTLR start "rule__TransformationList__Group__3"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1850:1: rule__TransformationList__Group__3 : rule__TransformationList__Group__3__Impl rule__TransformationList__Group__4 ;
    public final void rule__TransformationList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1854:1: ( rule__TransformationList__Group__3__Impl rule__TransformationList__Group__4 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1855:2: rule__TransformationList__Group__3__Impl rule__TransformationList__Group__4
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__3__Impl_in_rule__TransformationList__Group__33776);
            rule__TransformationList__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationList__Group__4_in_rule__TransformationList__Group__33779);
            rule__TransformationList__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationList__Group__3"


    // $ANTLR start "rule__TransformationList__Group__3__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1862:1: rule__TransformationList__Group__3__Impl : ( ( rule__TransformationList__Group_3__0 )* ) ;
    public final void rule__TransformationList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1866:1: ( ( ( rule__TransformationList__Group_3__0 )* ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1867:1: ( ( rule__TransformationList__Group_3__0 )* )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1867:1: ( ( rule__TransformationList__Group_3__0 )* )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1868:1: ( rule__TransformationList__Group_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationListAccess().getGroup_3()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1869:1: ( rule__TransformationList__Group_3__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==36) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1869:2: rule__TransformationList__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__TransformationList__Group_3__0_in_rule__TransformationList__Group__3__Impl3806);
            	    rule__TransformationList__Group_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationListAccess().getGroup_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationList__Group__3__Impl"


    // $ANTLR start "rule__TransformationList__Group__4"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1879:1: rule__TransformationList__Group__4 : rule__TransformationList__Group__4__Impl ;
    public final void rule__TransformationList__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1883:1: ( rule__TransformationList__Group__4__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1884:2: rule__TransformationList__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__4__Impl_in_rule__TransformationList__Group__43837);
            rule__TransformationList__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationList__Group__4"


    // $ANTLR start "rule__TransformationList__Group__4__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1890:1: rule__TransformationList__Group__4__Impl : ( '}' ) ;
    public final void rule__TransformationList__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1894:1: ( ( '}' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1895:1: ( '}' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1895:1: ( '}' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1896:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationListAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,31,FOLLOW_31_in_rule__TransformationList__Group__4__Impl3865); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationListAccess().getRightCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationList__Group__4__Impl"


    // $ANTLR start "rule__TransformationList__Group_3__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1919:1: rule__TransformationList__Group_3__0 : rule__TransformationList__Group_3__0__Impl rule__TransformationList__Group_3__1 ;
    public final void rule__TransformationList__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1923:1: ( rule__TransformationList__Group_3__0__Impl rule__TransformationList__Group_3__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1924:2: rule__TransformationList__Group_3__0__Impl rule__TransformationList__Group_3__1
            {
            pushFollow(FOLLOW_rule__TransformationList__Group_3__0__Impl_in_rule__TransformationList__Group_3__03906);
            rule__TransformationList__Group_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationList__Group_3__1_in_rule__TransformationList__Group_3__03909);
            rule__TransformationList__Group_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationList__Group_3__0"


    // $ANTLR start "rule__TransformationList__Group_3__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1931:1: rule__TransformationList__Group_3__0__Impl : ( ',' ) ;
    public final void rule__TransformationList__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1935:1: ( ( ',' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1936:1: ( ',' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1936:1: ( ',' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1937:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationListAccess().getCommaKeyword_3_0()); 
            }
            match(input,36,FOLLOW_36_in_rule__TransformationList__Group_3__0__Impl3937); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationListAccess().getCommaKeyword_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationList__Group_3__0__Impl"


    // $ANTLR start "rule__TransformationList__Group_3__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1950:1: rule__TransformationList__Group_3__1 : rule__TransformationList__Group_3__1__Impl ;
    public final void rule__TransformationList__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1954:1: ( rule__TransformationList__Group_3__1__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1955:2: rule__TransformationList__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__TransformationList__Group_3__1__Impl_in_rule__TransformationList__Group_3__13968);
            rule__TransformationList__Group_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationList__Group_3__1"


    // $ANTLR start "rule__TransformationList__Group_3__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1961:1: rule__TransformationList__Group_3__1__Impl : ( ( rule__TransformationList__TransformationsAssignment_3_1 ) ) ;
    public final void rule__TransformationList__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1965:1: ( ( ( rule__TransformationList__TransformationsAssignment_3_1 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1966:1: ( ( rule__TransformationList__TransformationsAssignment_3_1 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1966:1: ( ( rule__TransformationList__TransformationsAssignment_3_1 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1967:1: ( rule__TransformationList__TransformationsAssignment_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationListAccess().getTransformationsAssignment_3_1()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1968:1: ( rule__TransformationList__TransformationsAssignment_3_1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1968:2: rule__TransformationList__TransformationsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__TransformationList__TransformationsAssignment_3_1_in_rule__TransformationList__Group_3__1__Impl3995);
            rule__TransformationList__TransformationsAssignment_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationListAccess().getTransformationsAssignment_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationList__Group_3__1__Impl"


    // $ANTLR start "rule__Transformation__Group__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1982:1: rule__Transformation__Group__0 : rule__Transformation__Group__0__Impl rule__Transformation__Group__1 ;
    public final void rule__Transformation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1986:1: ( rule__Transformation__Group__0__Impl rule__Transformation__Group__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1987:2: rule__Transformation__Group__0__Impl rule__Transformation__Group__1
            {
            pushFollow(FOLLOW_rule__Transformation__Group__0__Impl_in_rule__Transformation__Group__04029);
            rule__Transformation__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Transformation__Group__1_in_rule__Transformation__Group__04032);
            rule__Transformation__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group__0"


    // $ANTLR start "rule__Transformation__Group__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1994:1: rule__Transformation__Group__0__Impl : ( ( rule__Transformation__NameAssignment_0 ) ) ;
    public final void rule__Transformation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1998:1: ( ( ( rule__Transformation__NameAssignment_0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1999:1: ( ( rule__Transformation__NameAssignment_0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:1999:1: ( ( rule__Transformation__NameAssignment_0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2000:1: ( rule__Transformation__NameAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getNameAssignment_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2001:1: ( rule__Transformation__NameAssignment_0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2001:2: rule__Transformation__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Transformation__NameAssignment_0_in_rule__Transformation__Group__0__Impl4059);
            rule__Transformation__NameAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getNameAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group__0__Impl"


    // $ANTLR start "rule__Transformation__Group__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2011:1: rule__Transformation__Group__1 : rule__Transformation__Group__1__Impl rule__Transformation__Group__2 ;
    public final void rule__Transformation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2015:1: ( rule__Transformation__Group__1__Impl rule__Transformation__Group__2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2016:2: rule__Transformation__Group__1__Impl rule__Transformation__Group__2
            {
            pushFollow(FOLLOW_rule__Transformation__Group__1__Impl_in_rule__Transformation__Group__14089);
            rule__Transformation__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Transformation__Group__2_in_rule__Transformation__Group__14092);
            rule__Transformation__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group__1"


    // $ANTLR start "rule__Transformation__Group__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2023:1: rule__Transformation__Group__1__Impl : ( '{' ) ;
    public final void rule__Transformation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2027:1: ( ( '{' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2028:1: ( '{' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2028:1: ( '{' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2029:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,29,FOLLOW_29_in_rule__Transformation__Group__1__Impl4120); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group__1__Impl"


    // $ANTLR start "rule__Transformation__Group__2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2042:1: rule__Transformation__Group__2 : rule__Transformation__Group__2__Impl rule__Transformation__Group__3 ;
    public final void rule__Transformation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2046:1: ( rule__Transformation__Group__2__Impl rule__Transformation__Group__3 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2047:2: rule__Transformation__Group__2__Impl rule__Transformation__Group__3
            {
            pushFollow(FOLLOW_rule__Transformation__Group__2__Impl_in_rule__Transformation__Group__24151);
            rule__Transformation__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Transformation__Group__3_in_rule__Transformation__Group__24154);
            rule__Transformation__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group__2"


    // $ANTLR start "rule__Transformation__Group__2__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2054:1: rule__Transformation__Group__2__Impl : ( 'modules' ) ;
    public final void rule__Transformation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2058:1: ( ( 'modules' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2059:1: ( 'modules' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2059:1: ( 'modules' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2060:1: 'modules'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getModulesKeyword_2()); 
            }
            match(input,38,FOLLOW_38_in_rule__Transformation__Group__2__Impl4182); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getModulesKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group__2__Impl"


    // $ANTLR start "rule__Transformation__Group__3"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2073:1: rule__Transformation__Group__3 : rule__Transformation__Group__3__Impl rule__Transformation__Group__4 ;
    public final void rule__Transformation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2077:1: ( rule__Transformation__Group__3__Impl rule__Transformation__Group__4 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2078:2: rule__Transformation__Group__3__Impl rule__Transformation__Group__4
            {
            pushFollow(FOLLOW_rule__Transformation__Group__3__Impl_in_rule__Transformation__Group__34213);
            rule__Transformation__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Transformation__Group__4_in_rule__Transformation__Group__34216);
            rule__Transformation__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group__3"


    // $ANTLR start "rule__Transformation__Group__3__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2085:1: rule__Transformation__Group__3__Impl : ( ':' ) ;
    public final void rule__Transformation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2089:1: ( ( ':' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2090:1: ( ':' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2090:1: ( ':' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2091:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getColonKeyword_3()); 
            }
            match(input,35,FOLLOW_35_in_rule__Transformation__Group__3__Impl4244); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getColonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group__3__Impl"


    // $ANTLR start "rule__Transformation__Group__4"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2104:1: rule__Transformation__Group__4 : rule__Transformation__Group__4__Impl rule__Transformation__Group__5 ;
    public final void rule__Transformation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2108:1: ( rule__Transformation__Group__4__Impl rule__Transformation__Group__5 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2109:2: rule__Transformation__Group__4__Impl rule__Transformation__Group__5
            {
            pushFollow(FOLLOW_rule__Transformation__Group__4__Impl_in_rule__Transformation__Group__44275);
            rule__Transformation__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Transformation__Group__5_in_rule__Transformation__Group__44278);
            rule__Transformation__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group__4"


    // $ANTLR start "rule__Transformation__Group__4__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2116:1: rule__Transformation__Group__4__Impl : ( ( rule__Transformation__ModulesAssignment_4 ) ) ;
    public final void rule__Transformation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2120:1: ( ( ( rule__Transformation__ModulesAssignment_4 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2121:1: ( ( rule__Transformation__ModulesAssignment_4 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2121:1: ( ( rule__Transformation__ModulesAssignment_4 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2122:1: ( rule__Transformation__ModulesAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getModulesAssignment_4()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2123:1: ( rule__Transformation__ModulesAssignment_4 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2123:2: rule__Transformation__ModulesAssignment_4
            {
            pushFollow(FOLLOW_rule__Transformation__ModulesAssignment_4_in_rule__Transformation__Group__4__Impl4305);
            rule__Transformation__ModulesAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getModulesAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group__4__Impl"


    // $ANTLR start "rule__Transformation__Group__5"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2133:1: rule__Transformation__Group__5 : rule__Transformation__Group__5__Impl rule__Transformation__Group__6 ;
    public final void rule__Transformation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2137:1: ( rule__Transformation__Group__5__Impl rule__Transformation__Group__6 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2138:2: rule__Transformation__Group__5__Impl rule__Transformation__Group__6
            {
            pushFollow(FOLLOW_rule__Transformation__Group__5__Impl_in_rule__Transformation__Group__54335);
            rule__Transformation__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Transformation__Group__6_in_rule__Transformation__Group__54338);
            rule__Transformation__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group__5"


    // $ANTLR start "rule__Transformation__Group__5__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2145:1: rule__Transformation__Group__5__Impl : ( ( rule__Transformation__Group_5__0 )* ) ;
    public final void rule__Transformation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2149:1: ( ( ( rule__Transformation__Group_5__0 )* ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2150:1: ( ( rule__Transformation__Group_5__0 )* )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2150:1: ( ( rule__Transformation__Group_5__0 )* )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2151:1: ( rule__Transformation__Group_5__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getGroup_5()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2152:1: ( rule__Transformation__Group_5__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==36) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2152:2: rule__Transformation__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__Transformation__Group_5__0_in_rule__Transformation__Group__5__Impl4365);
            	    rule__Transformation__Group_5__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getGroup_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group__5__Impl"


    // $ANTLR start "rule__Transformation__Group__6"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2162:1: rule__Transformation__Group__6 : rule__Transformation__Group__6__Impl rule__Transformation__Group__7 ;
    public final void rule__Transformation__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2166:1: ( rule__Transformation__Group__6__Impl rule__Transformation__Group__7 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2167:2: rule__Transformation__Group__6__Impl rule__Transformation__Group__7
            {
            pushFollow(FOLLOW_rule__Transformation__Group__6__Impl_in_rule__Transformation__Group__64396);
            rule__Transformation__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Transformation__Group__7_in_rule__Transformation__Group__64399);
            rule__Transformation__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group__6"


    // $ANTLR start "rule__Transformation__Group__6__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2174:1: rule__Transformation__Group__6__Impl : ( ( rule__Transformation__Group_6__0 )? ) ;
    public final void rule__Transformation__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2178:1: ( ( ( rule__Transformation__Group_6__0 )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2179:1: ( ( rule__Transformation__Group_6__0 )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2179:1: ( ( rule__Transformation__Group_6__0 )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2180:1: ( rule__Transformation__Group_6__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getGroup_6()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2181:1: ( rule__Transformation__Group_6__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==39) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2181:2: rule__Transformation__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__Transformation__Group_6__0_in_rule__Transformation__Group__6__Impl4426);
                    rule__Transformation__Group_6__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getGroup_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group__6__Impl"


    // $ANTLR start "rule__Transformation__Group__7"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2191:1: rule__Transformation__Group__7 : rule__Transformation__Group__7__Impl ;
    public final void rule__Transformation__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2195:1: ( rule__Transformation__Group__7__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2196:2: rule__Transformation__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__Transformation__Group__7__Impl_in_rule__Transformation__Group__74457);
            rule__Transformation__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group__7"


    // $ANTLR start "rule__Transformation__Group__7__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2202:1: rule__Transformation__Group__7__Impl : ( '}' ) ;
    public final void rule__Transformation__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2206:1: ( ( '}' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2207:1: ( '}' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2207:1: ( '}' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2208:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_7()); 
            }
            match(input,31,FOLLOW_31_in_rule__Transformation__Group__7__Impl4485); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group__7__Impl"


    // $ANTLR start "rule__Transformation__Group_5__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2237:1: rule__Transformation__Group_5__0 : rule__Transformation__Group_5__0__Impl rule__Transformation__Group_5__1 ;
    public final void rule__Transformation__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2241:1: ( rule__Transformation__Group_5__0__Impl rule__Transformation__Group_5__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2242:2: rule__Transformation__Group_5__0__Impl rule__Transformation__Group_5__1
            {
            pushFollow(FOLLOW_rule__Transformation__Group_5__0__Impl_in_rule__Transformation__Group_5__04532);
            rule__Transformation__Group_5__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Transformation__Group_5__1_in_rule__Transformation__Group_5__04535);
            rule__Transformation__Group_5__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group_5__0"


    // $ANTLR start "rule__Transformation__Group_5__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2249:1: rule__Transformation__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Transformation__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2253:1: ( ( ',' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2254:1: ( ',' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2254:1: ( ',' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2255:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getCommaKeyword_5_0()); 
            }
            match(input,36,FOLLOW_36_in_rule__Transformation__Group_5__0__Impl4563); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getCommaKeyword_5_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group_5__0__Impl"


    // $ANTLR start "rule__Transformation__Group_5__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2268:1: rule__Transformation__Group_5__1 : rule__Transformation__Group_5__1__Impl ;
    public final void rule__Transformation__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2272:1: ( rule__Transformation__Group_5__1__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2273:2: rule__Transformation__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__Transformation__Group_5__1__Impl_in_rule__Transformation__Group_5__14594);
            rule__Transformation__Group_5__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group_5__1"


    // $ANTLR start "rule__Transformation__Group_5__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2279:1: rule__Transformation__Group_5__1__Impl : ( ( rule__Transformation__ModulesAssignment_5_1 ) ) ;
    public final void rule__Transformation__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2283:1: ( ( ( rule__Transformation__ModulesAssignment_5_1 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2284:1: ( ( rule__Transformation__ModulesAssignment_5_1 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2284:1: ( ( rule__Transformation__ModulesAssignment_5_1 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2285:1: ( rule__Transformation__ModulesAssignment_5_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getModulesAssignment_5_1()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2286:1: ( rule__Transformation__ModulesAssignment_5_1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2286:2: rule__Transformation__ModulesAssignment_5_1
            {
            pushFollow(FOLLOW_rule__Transformation__ModulesAssignment_5_1_in_rule__Transformation__Group_5__1__Impl4621);
            rule__Transformation__ModulesAssignment_5_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getModulesAssignment_5_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group_5__1__Impl"


    // $ANTLR start "rule__Transformation__Group_6__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2300:1: rule__Transformation__Group_6__0 : rule__Transformation__Group_6__0__Impl rule__Transformation__Group_6__1 ;
    public final void rule__Transformation__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2304:1: ( rule__Transformation__Group_6__0__Impl rule__Transformation__Group_6__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2305:2: rule__Transformation__Group_6__0__Impl rule__Transformation__Group_6__1
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6__0__Impl_in_rule__Transformation__Group_6__04655);
            rule__Transformation__Group_6__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Transformation__Group_6__1_in_rule__Transformation__Group_6__04658);
            rule__Transformation__Group_6__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group_6__0"


    // $ANTLR start "rule__Transformation__Group_6__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2312:1: rule__Transformation__Group_6__0__Impl : ( 'impacts' ) ;
    public final void rule__Transformation__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2316:1: ( ( 'impacts' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2317:1: ( 'impacts' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2317:1: ( 'impacts' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2318:1: 'impacts'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getImpactsKeyword_6_0()); 
            }
            match(input,39,FOLLOW_39_in_rule__Transformation__Group_6__0__Impl4686); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getImpactsKeyword_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group_6__0__Impl"


    // $ANTLR start "rule__Transformation__Group_6__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2331:1: rule__Transformation__Group_6__1 : rule__Transformation__Group_6__1__Impl rule__Transformation__Group_6__2 ;
    public final void rule__Transformation__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2335:1: ( rule__Transformation__Group_6__1__Impl rule__Transformation__Group_6__2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2336:2: rule__Transformation__Group_6__1__Impl rule__Transformation__Group_6__2
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6__1__Impl_in_rule__Transformation__Group_6__14717);
            rule__Transformation__Group_6__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Transformation__Group_6__2_in_rule__Transformation__Group_6__14720);
            rule__Transformation__Group_6__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group_6__1"


    // $ANTLR start "rule__Transformation__Group_6__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2343:1: rule__Transformation__Group_6__1__Impl : ( ':' ) ;
    public final void rule__Transformation__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2347:1: ( ( ':' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2348:1: ( ':' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2348:1: ( ':' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2349:1: ':'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getColonKeyword_6_1()); 
            }
            match(input,35,FOLLOW_35_in_rule__Transformation__Group_6__1__Impl4748); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getColonKeyword_6_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group_6__1__Impl"


    // $ANTLR start "rule__Transformation__Group_6__2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2362:1: rule__Transformation__Group_6__2 : rule__Transformation__Group_6__2__Impl rule__Transformation__Group_6__3 ;
    public final void rule__Transformation__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2366:1: ( rule__Transformation__Group_6__2__Impl rule__Transformation__Group_6__3 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2367:2: rule__Transformation__Group_6__2__Impl rule__Transformation__Group_6__3
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6__2__Impl_in_rule__Transformation__Group_6__24779);
            rule__Transformation__Group_6__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Transformation__Group_6__3_in_rule__Transformation__Group_6__24782);
            rule__Transformation__Group_6__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group_6__2"


    // $ANTLR start "rule__Transformation__Group_6__2__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2374:1: rule__Transformation__Group_6__2__Impl : ( ( rule__Transformation__ImpactsAssignment_6_2 ) ) ;
    public final void rule__Transformation__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2378:1: ( ( ( rule__Transformation__ImpactsAssignment_6_2 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2379:1: ( ( rule__Transformation__ImpactsAssignment_6_2 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2379:1: ( ( rule__Transformation__ImpactsAssignment_6_2 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2380:1: ( rule__Transformation__ImpactsAssignment_6_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getImpactsAssignment_6_2()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2381:1: ( rule__Transformation__ImpactsAssignment_6_2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2381:2: rule__Transformation__ImpactsAssignment_6_2
            {
            pushFollow(FOLLOW_rule__Transformation__ImpactsAssignment_6_2_in_rule__Transformation__Group_6__2__Impl4809);
            rule__Transformation__ImpactsAssignment_6_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getImpactsAssignment_6_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group_6__2__Impl"


    // $ANTLR start "rule__Transformation__Group_6__3"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2391:1: rule__Transformation__Group_6__3 : rule__Transformation__Group_6__3__Impl ;
    public final void rule__Transformation__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2395:1: ( rule__Transformation__Group_6__3__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2396:2: rule__Transformation__Group_6__3__Impl
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6__3__Impl_in_rule__Transformation__Group_6__34839);
            rule__Transformation__Group_6__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group_6__3"


    // $ANTLR start "rule__Transformation__Group_6__3__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2402:1: rule__Transformation__Group_6__3__Impl : ( ( rule__Transformation__Group_6_3__0 )* ) ;
    public final void rule__Transformation__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2406:1: ( ( ( rule__Transformation__Group_6_3__0 )* ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2407:1: ( ( rule__Transformation__Group_6_3__0 )* )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2407:1: ( ( rule__Transformation__Group_6_3__0 )* )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2408:1: ( rule__Transformation__Group_6_3__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getGroup_6_3()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2409:1: ( rule__Transformation__Group_6_3__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==36) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2409:2: rule__Transformation__Group_6_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Transformation__Group_6_3__0_in_rule__Transformation__Group_6__3__Impl4866);
            	    rule__Transformation__Group_6_3__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getGroup_6_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group_6__3__Impl"


    // $ANTLR start "rule__Transformation__Group_6_3__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2427:1: rule__Transformation__Group_6_3__0 : rule__Transformation__Group_6_3__0__Impl rule__Transformation__Group_6_3__1 ;
    public final void rule__Transformation__Group_6_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2431:1: ( rule__Transformation__Group_6_3__0__Impl rule__Transformation__Group_6_3__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2432:2: rule__Transformation__Group_6_3__0__Impl rule__Transformation__Group_6_3__1
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6_3__0__Impl_in_rule__Transformation__Group_6_3__04905);
            rule__Transformation__Group_6_3__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__Transformation__Group_6_3__1_in_rule__Transformation__Group_6_3__04908);
            rule__Transformation__Group_6_3__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group_6_3__0"


    // $ANTLR start "rule__Transformation__Group_6_3__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2439:1: rule__Transformation__Group_6_3__0__Impl : ( ',' ) ;
    public final void rule__Transformation__Group_6_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2443:1: ( ( ',' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2444:1: ( ',' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2444:1: ( ',' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2445:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getCommaKeyword_6_3_0()); 
            }
            match(input,36,FOLLOW_36_in_rule__Transformation__Group_6_3__0__Impl4936); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getCommaKeyword_6_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group_6_3__0__Impl"


    // $ANTLR start "rule__Transformation__Group_6_3__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2458:1: rule__Transformation__Group_6_3__1 : rule__Transformation__Group_6_3__1__Impl ;
    public final void rule__Transformation__Group_6_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2462:1: ( rule__Transformation__Group_6_3__1__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2463:2: rule__Transformation__Group_6_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6_3__1__Impl_in_rule__Transformation__Group_6_3__14967);
            rule__Transformation__Group_6_3__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group_6_3__1"


    // $ANTLR start "rule__Transformation__Group_6_3__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2469:1: rule__Transformation__Group_6_3__1__Impl : ( ( rule__Transformation__ImpactsAssignment_6_3_1 ) ) ;
    public final void rule__Transformation__Group_6_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2473:1: ( ( ( rule__Transformation__ImpactsAssignment_6_3_1 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2474:1: ( ( rule__Transformation__ImpactsAssignment_6_3_1 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2474:1: ( ( rule__Transformation__ImpactsAssignment_6_3_1 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2475:1: ( rule__Transformation__ImpactsAssignment_6_3_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getImpactsAssignment_6_3_1()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2476:1: ( rule__Transformation__ImpactsAssignment_6_3_1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2476:2: rule__Transformation__ImpactsAssignment_6_3_1
            {
            pushFollow(FOLLOW_rule__Transformation__ImpactsAssignment_6_3_1_in_rule__Transformation__Group_6_3__1__Impl4994);
            rule__Transformation__ImpactsAssignment_6_3_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getImpactsAssignment_6_3_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__Group_6_3__1__Impl"


    // $ANTLR start "rule__TransformationImpact__Group__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2490:1: rule__TransformationImpact__Group__0 : rule__TransformationImpact__Group__0__Impl rule__TransformationImpact__Group__1 ;
    public final void rule__TransformationImpact__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2494:1: ( rule__TransformationImpact__Group__0__Impl rule__TransformationImpact__Group__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2495:2: rule__TransformationImpact__Group__0__Impl rule__TransformationImpact__Group__1
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group__0__Impl_in_rule__TransformationImpact__Group__05028);
            rule__TransformationImpact__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationImpact__Group__1_in_rule__TransformationImpact__Group__05031);
            rule__TransformationImpact__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationImpact__Group__0"


    // $ANTLR start "rule__TransformationImpact__Group__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2502:1: rule__TransformationImpact__Group__0__Impl : ( '(' ) ;
    public final void rule__TransformationImpact__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2506:1: ( ( '(' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2507:1: ( '(' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2507:1: ( '(' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2508:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationImpactAccess().getLeftParenthesisKeyword_0()); 
            }
            match(input,40,FOLLOW_40_in_rule__TransformationImpact__Group__0__Impl5059); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationImpactAccess().getLeftParenthesisKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationImpact__Group__0__Impl"


    // $ANTLR start "rule__TransformationImpact__Group__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2521:1: rule__TransformationImpact__Group__1 : rule__TransformationImpact__Group__1__Impl rule__TransformationImpact__Group__2 ;
    public final void rule__TransformationImpact__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2525:1: ( rule__TransformationImpact__Group__1__Impl rule__TransformationImpact__Group__2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2526:2: rule__TransformationImpact__Group__1__Impl rule__TransformationImpact__Group__2
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group__1__Impl_in_rule__TransformationImpact__Group__15090);
            rule__TransformationImpact__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationImpact__Group__2_in_rule__TransformationImpact__Group__15093);
            rule__TransformationImpact__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationImpact__Group__1"


    // $ANTLR start "rule__TransformationImpact__Group__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2533:1: rule__TransformationImpact__Group__1__Impl : ( ( rule__TransformationImpact__Group_1__0 )? ) ;
    public final void rule__TransformationImpact__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2537:1: ( ( ( rule__TransformationImpact__Group_1__0 )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2538:1: ( ( rule__TransformationImpact__Group_1__0 )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2538:1: ( ( rule__TransformationImpact__Group_1__0 )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2539:1: ( rule__TransformationImpact__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationImpactAccess().getGroup_1()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2540:1: ( rule__TransformationImpact__Group_1__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=RULE_ID && LA16_0<=RULE_STRING)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2540:2: rule__TransformationImpact__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__TransformationImpact__Group_1__0_in_rule__TransformationImpact__Group__1__Impl5120);
                    rule__TransformationImpact__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationImpactAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationImpact__Group__1__Impl"


    // $ANTLR start "rule__TransformationImpact__Group__2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2550:1: rule__TransformationImpact__Group__2 : rule__TransformationImpact__Group__2__Impl rule__TransformationImpact__Group__3 ;
    public final void rule__TransformationImpact__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2554:1: ( rule__TransformationImpact__Group__2__Impl rule__TransformationImpact__Group__3 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2555:2: rule__TransformationImpact__Group__2__Impl rule__TransformationImpact__Group__3
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group__2__Impl_in_rule__TransformationImpact__Group__25151);
            rule__TransformationImpact__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationImpact__Group__3_in_rule__TransformationImpact__Group__25154);
            rule__TransformationImpact__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationImpact__Group__2"


    // $ANTLR start "rule__TransformationImpact__Group__2__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2562:1: rule__TransformationImpact__Group__2__Impl : ( ( rule__TransformationImpact__ImpactValueAssignment_2 ) ) ;
    public final void rule__TransformationImpact__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2566:1: ( ( ( rule__TransformationImpact__ImpactValueAssignment_2 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2567:1: ( ( rule__TransformationImpact__ImpactValueAssignment_2 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2567:1: ( ( rule__TransformationImpact__ImpactValueAssignment_2 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2568:1: ( rule__TransformationImpact__ImpactValueAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationImpactAccess().getImpactValueAssignment_2()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2569:1: ( rule__TransformationImpact__ImpactValueAssignment_2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2569:2: rule__TransformationImpact__ImpactValueAssignment_2
            {
            pushFollow(FOLLOW_rule__TransformationImpact__ImpactValueAssignment_2_in_rule__TransformationImpact__Group__2__Impl5181);
            rule__TransformationImpact__ImpactValueAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationImpactAccess().getImpactValueAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationImpact__Group__2__Impl"


    // $ANTLR start "rule__TransformationImpact__Group__3"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2579:1: rule__TransformationImpact__Group__3 : rule__TransformationImpact__Group__3__Impl ;
    public final void rule__TransformationImpact__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2583:1: ( rule__TransformationImpact__Group__3__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2584:2: rule__TransformationImpact__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group__3__Impl_in_rule__TransformationImpact__Group__35211);
            rule__TransformationImpact__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationImpact__Group__3"


    // $ANTLR start "rule__TransformationImpact__Group__3__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2590:1: rule__TransformationImpact__Group__3__Impl : ( ')' ) ;
    public final void rule__TransformationImpact__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2594:1: ( ( ')' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2595:1: ( ')' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2595:1: ( ')' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2596:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationImpactAccess().getRightParenthesisKeyword_3()); 
            }
            match(input,41,FOLLOW_41_in_rule__TransformationImpact__Group__3__Impl5239); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationImpactAccess().getRightParenthesisKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationImpact__Group__3__Impl"


    // $ANTLR start "rule__TransformationImpact__Group_1__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2617:1: rule__TransformationImpact__Group_1__0 : rule__TransformationImpact__Group_1__0__Impl rule__TransformationImpact__Group_1__1 ;
    public final void rule__TransformationImpact__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2621:1: ( rule__TransformationImpact__Group_1__0__Impl rule__TransformationImpact__Group_1__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2622:2: rule__TransformationImpact__Group_1__0__Impl rule__TransformationImpact__Group_1__1
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group_1__0__Impl_in_rule__TransformationImpact__Group_1__05278);
            rule__TransformationImpact__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationImpact__Group_1__1_in_rule__TransformationImpact__Group_1__05281);
            rule__TransformationImpact__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationImpact__Group_1__0"


    // $ANTLR start "rule__TransformationImpact__Group_1__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2629:1: rule__TransformationImpact__Group_1__0__Impl : ( ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 ) ) ;
    public final void rule__TransformationImpact__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2633:1: ( ( ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2634:1: ( ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2634:1: ( ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2635:1: ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationImpactAccess().getQualityAttributeNameAssignment_1_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2636:1: ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2636:2: rule__TransformationImpact__QualityAttributeNameAssignment_1_0
            {
            pushFollow(FOLLOW_rule__TransformationImpact__QualityAttributeNameAssignment_1_0_in_rule__TransformationImpact__Group_1__0__Impl5308);
            rule__TransformationImpact__QualityAttributeNameAssignment_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationImpactAccess().getQualityAttributeNameAssignment_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationImpact__Group_1__0__Impl"


    // $ANTLR start "rule__TransformationImpact__Group_1__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2646:1: rule__TransformationImpact__Group_1__1 : rule__TransformationImpact__Group_1__1__Impl ;
    public final void rule__TransformationImpact__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2650:1: ( rule__TransformationImpact__Group_1__1__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2651:2: rule__TransformationImpact__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group_1__1__Impl_in_rule__TransformationImpact__Group_1__15338);
            rule__TransformationImpact__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationImpact__Group_1__1"


    // $ANTLR start "rule__TransformationImpact__Group_1__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2657:1: rule__TransformationImpact__Group_1__1__Impl : ( ',' ) ;
    public final void rule__TransformationImpact__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2661:1: ( ( ',' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2662:1: ( ',' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2662:1: ( ',' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2663:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationImpactAccess().getCommaKeyword_1_1()); 
            }
            match(input,36,FOLLOW_36_in_rule__TransformationImpact__Group_1__1__Impl5366); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationImpactAccess().getCommaKeyword_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationImpact__Group_1__1__Impl"


    // $ANTLR start "rule__TransformationDependencyList__Group__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2680:1: rule__TransformationDependencyList__Group__0 : rule__TransformationDependencyList__Group__0__Impl rule__TransformationDependencyList__Group__1 ;
    public final void rule__TransformationDependencyList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2684:1: ( rule__TransformationDependencyList__Group__0__Impl rule__TransformationDependencyList__Group__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2685:2: rule__TransformationDependencyList__Group__0__Impl rule__TransformationDependencyList__Group__1
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__0__Impl_in_rule__TransformationDependencyList__Group__05401);
            rule__TransformationDependencyList__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__1_in_rule__TransformationDependencyList__Group__05404);
            rule__TransformationDependencyList__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group__0"


    // $ANTLR start "rule__TransformationDependencyList__Group__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2692:1: rule__TransformationDependencyList__Group__0__Impl : ( 'Dependencies' ) ;
    public final void rule__TransformationDependencyList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2696:1: ( ( 'Dependencies' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2697:1: ( 'Dependencies' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2697:1: ( 'Dependencies' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2698:1: 'Dependencies'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyListAccess().getDependenciesKeyword_0()); 
            }
            match(input,42,FOLLOW_42_in_rule__TransformationDependencyList__Group__0__Impl5432); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyListAccess().getDependenciesKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group__0__Impl"


    // $ANTLR start "rule__TransformationDependencyList__Group__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2711:1: rule__TransformationDependencyList__Group__1 : rule__TransformationDependencyList__Group__1__Impl rule__TransformationDependencyList__Group__2 ;
    public final void rule__TransformationDependencyList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2715:1: ( rule__TransformationDependencyList__Group__1__Impl rule__TransformationDependencyList__Group__2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2716:2: rule__TransformationDependencyList__Group__1__Impl rule__TransformationDependencyList__Group__2
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__1__Impl_in_rule__TransformationDependencyList__Group__15463);
            rule__TransformationDependencyList__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__2_in_rule__TransformationDependencyList__Group__15466);
            rule__TransformationDependencyList__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group__1"


    // $ANTLR start "rule__TransformationDependencyList__Group__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2723:1: rule__TransformationDependencyList__Group__1__Impl : ( '{' ) ;
    public final void rule__TransformationDependencyList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2727:1: ( ( '{' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2728:1: ( '{' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2728:1: ( '{' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2729:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyListAccess().getLeftCurlyBracketKeyword_1()); 
            }
            match(input,29,FOLLOW_29_in_rule__TransformationDependencyList__Group__1__Impl5494); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyListAccess().getLeftCurlyBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group__1__Impl"


    // $ANTLR start "rule__TransformationDependencyList__Group__2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2742:1: rule__TransformationDependencyList__Group__2 : rule__TransformationDependencyList__Group__2__Impl rule__TransformationDependencyList__Group__3 ;
    public final void rule__TransformationDependencyList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2746:1: ( rule__TransformationDependencyList__Group__2__Impl rule__TransformationDependencyList__Group__3 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2747:2: rule__TransformationDependencyList__Group__2__Impl rule__TransformationDependencyList__Group__3
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__2__Impl_in_rule__TransformationDependencyList__Group__25525);
            rule__TransformationDependencyList__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__3_in_rule__TransformationDependencyList__Group__25528);
            rule__TransformationDependencyList__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group__2"


    // $ANTLR start "rule__TransformationDependencyList__Group__2__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2754:1: rule__TransformationDependencyList__Group__2__Impl : ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_2 ) ) ;
    public final void rule__TransformationDependencyList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2758:1: ( ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_2 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2759:1: ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_2 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2759:1: ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_2 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2760:1: ( rule__TransformationDependencyList__TransformationDependenciesAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesAssignment_2()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2761:1: ( rule__TransformationDependencyList__TransformationDependenciesAssignment_2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2761:2: rule__TransformationDependencyList__TransformationDependenciesAssignment_2
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__TransformationDependenciesAssignment_2_in_rule__TransformationDependencyList__Group__2__Impl5555);
            rule__TransformationDependencyList__TransformationDependenciesAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group__2__Impl"


    // $ANTLR start "rule__TransformationDependencyList__Group__3"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2771:1: rule__TransformationDependencyList__Group__3 : rule__TransformationDependencyList__Group__3__Impl rule__TransformationDependencyList__Group__4 ;
    public final void rule__TransformationDependencyList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2775:1: ( rule__TransformationDependencyList__Group__3__Impl rule__TransformationDependencyList__Group__4 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2776:2: rule__TransformationDependencyList__Group__3__Impl rule__TransformationDependencyList__Group__4
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__3__Impl_in_rule__TransformationDependencyList__Group__35585);
            rule__TransformationDependencyList__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__4_in_rule__TransformationDependencyList__Group__35588);
            rule__TransformationDependencyList__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group__3"


    // $ANTLR start "rule__TransformationDependencyList__Group__3__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2783:1: rule__TransformationDependencyList__Group__3__Impl : ( ';' ) ;
    public final void rule__TransformationDependencyList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2787:1: ( ( ';' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2788:1: ( ';' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2788:1: ( ';' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2789:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyListAccess().getSemicolonKeyword_3()); 
            }
            match(input,30,FOLLOW_30_in_rule__TransformationDependencyList__Group__3__Impl5616); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyListAccess().getSemicolonKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group__3__Impl"


    // $ANTLR start "rule__TransformationDependencyList__Group__4"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2802:1: rule__TransformationDependencyList__Group__4 : rule__TransformationDependencyList__Group__4__Impl rule__TransformationDependencyList__Group__5 ;
    public final void rule__TransformationDependencyList__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2806:1: ( rule__TransformationDependencyList__Group__4__Impl rule__TransformationDependencyList__Group__5 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2807:2: rule__TransformationDependencyList__Group__4__Impl rule__TransformationDependencyList__Group__5
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__4__Impl_in_rule__TransformationDependencyList__Group__45647);
            rule__TransformationDependencyList__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__5_in_rule__TransformationDependencyList__Group__45650);
            rule__TransformationDependencyList__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group__4"


    // $ANTLR start "rule__TransformationDependencyList__Group__4__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2814:1: rule__TransformationDependencyList__Group__4__Impl : ( ( rule__TransformationDependencyList__Group_4__0 )* ) ;
    public final void rule__TransformationDependencyList__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2818:1: ( ( ( rule__TransformationDependencyList__Group_4__0 )* ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2819:1: ( ( rule__TransformationDependencyList__Group_4__0 )* )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2819:1: ( ( rule__TransformationDependencyList__Group_4__0 )* )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2820:1: ( rule__TransformationDependencyList__Group_4__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyListAccess().getGroup_4()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2821:1: ( rule__TransformationDependencyList__Group_4__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==43) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2821:2: rule__TransformationDependencyList__Group_4__0
            	    {
            	    pushFollow(FOLLOW_rule__TransformationDependencyList__Group_4__0_in_rule__TransformationDependencyList__Group__4__Impl5677);
            	    rule__TransformationDependencyList__Group_4__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyListAccess().getGroup_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group__4__Impl"


    // $ANTLR start "rule__TransformationDependencyList__Group__5"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2831:1: rule__TransformationDependencyList__Group__5 : rule__TransformationDependencyList__Group__5__Impl ;
    public final void rule__TransformationDependencyList__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2835:1: ( rule__TransformationDependencyList__Group__5__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2836:2: rule__TransformationDependencyList__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__5__Impl_in_rule__TransformationDependencyList__Group__55708);
            rule__TransformationDependencyList__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group__5"


    // $ANTLR start "rule__TransformationDependencyList__Group__5__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2842:1: rule__TransformationDependencyList__Group__5__Impl : ( '}' ) ;
    public final void rule__TransformationDependencyList__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2846:1: ( ( '}' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2847:1: ( '}' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2847:1: ( '}' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2848:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyListAccess().getRightCurlyBracketKeyword_5()); 
            }
            match(input,31,FOLLOW_31_in_rule__TransformationDependencyList__Group__5__Impl5736); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyListAccess().getRightCurlyBracketKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group__5__Impl"


    // $ANTLR start "rule__TransformationDependencyList__Group_4__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2873:1: rule__TransformationDependencyList__Group_4__0 : rule__TransformationDependencyList__Group_4__0__Impl rule__TransformationDependencyList__Group_4__1 ;
    public final void rule__TransformationDependencyList__Group_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2877:1: ( rule__TransformationDependencyList__Group_4__0__Impl rule__TransformationDependencyList__Group_4__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2878:2: rule__TransformationDependencyList__Group_4__0__Impl rule__TransformationDependencyList__Group_4__1
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group_4__0__Impl_in_rule__TransformationDependencyList__Group_4__05779);
            rule__TransformationDependencyList__Group_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group_4__1_in_rule__TransformationDependencyList__Group_4__05782);
            rule__TransformationDependencyList__Group_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group_4__0"


    // $ANTLR start "rule__TransformationDependencyList__Group_4__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2885:1: rule__TransformationDependencyList__Group_4__0__Impl : ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4_0 ) ) ;
    public final void rule__TransformationDependencyList__Group_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2889:1: ( ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4_0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2890:1: ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4_0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2890:1: ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4_0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2891:1: ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesAssignment_4_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2892:1: ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4_0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2892:2: rule__TransformationDependencyList__TransformationDependenciesAssignment_4_0
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__TransformationDependenciesAssignment_4_0_in_rule__TransformationDependencyList__Group_4__0__Impl5809);
            rule__TransformationDependencyList__TransformationDependenciesAssignment_4_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesAssignment_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group_4__0__Impl"


    // $ANTLR start "rule__TransformationDependencyList__Group_4__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2902:1: rule__TransformationDependencyList__Group_4__1 : rule__TransformationDependencyList__Group_4__1__Impl ;
    public final void rule__TransformationDependencyList__Group_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2906:1: ( rule__TransformationDependencyList__Group_4__1__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2907:2: rule__TransformationDependencyList__Group_4__1__Impl
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group_4__1__Impl_in_rule__TransformationDependencyList__Group_4__15839);
            rule__TransformationDependencyList__Group_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group_4__1"


    // $ANTLR start "rule__TransformationDependencyList__Group_4__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2913:1: rule__TransformationDependencyList__Group_4__1__Impl : ( ';' ) ;
    public final void rule__TransformationDependencyList__Group_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2917:1: ( ( ';' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2918:1: ( ';' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2918:1: ( ';' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2919:1: ';'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyListAccess().getSemicolonKeyword_4_1()); 
            }
            match(input,30,FOLLOW_30_in_rule__TransformationDependencyList__Group_4__1__Impl5867); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyListAccess().getSemicolonKeyword_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group_4__1__Impl"


    // $ANTLR start "rule__TransformationDependency__Group__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2936:1: rule__TransformationDependency__Group__0 : rule__TransformationDependency__Group__0__Impl rule__TransformationDependency__Group__1 ;
    public final void rule__TransformationDependency__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2940:1: ( rule__TransformationDependency__Group__0__Impl rule__TransformationDependency__Group__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2941:2: rule__TransformationDependency__Group__0__Impl rule__TransformationDependency__Group__1
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__0__Impl_in_rule__TransformationDependency__Group__05902);
            rule__TransformationDependency__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependency__Group__1_in_rule__TransformationDependency__Group__05905);
            rule__TransformationDependency__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__0"


    // $ANTLR start "rule__TransformationDependency__Group__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2948:1: rule__TransformationDependency__Group__0__Impl : ( 'Apply' ) ;
    public final void rule__TransformationDependency__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2952:1: ( ( 'Apply' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2953:1: ( 'Apply' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2953:1: ( 'Apply' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2954:1: 'Apply'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getApplyKeyword_0()); 
            }
            match(input,43,FOLLOW_43_in_rule__TransformationDependency__Group__0__Impl5933); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getApplyKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__0__Impl"


    // $ANTLR start "rule__TransformationDependency__Group__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2967:1: rule__TransformationDependency__Group__1 : rule__TransformationDependency__Group__1__Impl rule__TransformationDependency__Group__2 ;
    public final void rule__TransformationDependency__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2971:1: ( rule__TransformationDependency__Group__1__Impl rule__TransformationDependency__Group__2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2972:2: rule__TransformationDependency__Group__1__Impl rule__TransformationDependency__Group__2
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__1__Impl_in_rule__TransformationDependency__Group__15964);
            rule__TransformationDependency__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependency__Group__2_in_rule__TransformationDependency__Group__15967);
            rule__TransformationDependency__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__1"


    // $ANTLR start "rule__TransformationDependency__Group__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2979:1: rule__TransformationDependency__Group__1__Impl : ( '(' ) ;
    public final void rule__TransformationDependency__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2983:1: ( ( '(' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2984:1: ( '(' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2984:1: ( '(' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2985:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,40,FOLLOW_40_in_rule__TransformationDependency__Group__1__Impl5995); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getLeftParenthesisKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__1__Impl"


    // $ANTLR start "rule__TransformationDependency__Group__2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:2998:1: rule__TransformationDependency__Group__2 : rule__TransformationDependency__Group__2__Impl rule__TransformationDependency__Group__3 ;
    public final void rule__TransformationDependency__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3002:1: ( rule__TransformationDependency__Group__2__Impl rule__TransformationDependency__Group__3 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3003:2: rule__TransformationDependency__Group__2__Impl rule__TransformationDependency__Group__3
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__2__Impl_in_rule__TransformationDependency__Group__26026);
            rule__TransformationDependency__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependency__Group__3_in_rule__TransformationDependency__Group__26029);
            rule__TransformationDependency__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__2"


    // $ANTLR start "rule__TransformationDependency__Group__2__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3010:1: rule__TransformationDependency__Group__2__Impl : ( ( rule__TransformationDependency__AppliedTransformationAssignment_2 ) ) ;
    public final void rule__TransformationDependency__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3014:1: ( ( ( rule__TransformationDependency__AppliedTransformationAssignment_2 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3015:1: ( ( rule__TransformationDependency__AppliedTransformationAssignment_2 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3015:1: ( ( rule__TransformationDependency__AppliedTransformationAssignment_2 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3016:1: ( rule__TransformationDependency__AppliedTransformationAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationAssignment_2()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3017:1: ( rule__TransformationDependency__AppliedTransformationAssignment_2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3017:2: rule__TransformationDependency__AppliedTransformationAssignment_2
            {
            pushFollow(FOLLOW_rule__TransformationDependency__AppliedTransformationAssignment_2_in_rule__TransformationDependency__Group__2__Impl6056);
            rule__TransformationDependency__AppliedTransformationAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__2__Impl"


    // $ANTLR start "rule__TransformationDependency__Group__3"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3027:1: rule__TransformationDependency__Group__3 : rule__TransformationDependency__Group__3__Impl rule__TransformationDependency__Group__4 ;
    public final void rule__TransformationDependency__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3031:1: ( rule__TransformationDependency__Group__3__Impl rule__TransformationDependency__Group__4 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3032:2: rule__TransformationDependency__Group__3__Impl rule__TransformationDependency__Group__4
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__3__Impl_in_rule__TransformationDependency__Group__36086);
            rule__TransformationDependency__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependency__Group__4_in_rule__TransformationDependency__Group__36089);
            rule__TransformationDependency__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__3"


    // $ANTLR start "rule__TransformationDependency__Group__3__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3039:1: rule__TransformationDependency__Group__3__Impl : ( '.' ) ;
    public final void rule__TransformationDependency__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3043:1: ( ( '.' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3044:1: ( '.' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3044:1: ( '.' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3045:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getFullStopKeyword_3()); 
            }
            match(input,32,FOLLOW_32_in_rule__TransformationDependency__Group__3__Impl6117); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getFullStopKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__3__Impl"


    // $ANTLR start "rule__TransformationDependency__Group__4"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3058:1: rule__TransformationDependency__Group__4 : rule__TransformationDependency__Group__4__Impl rule__TransformationDependency__Group__5 ;
    public final void rule__TransformationDependency__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3062:1: ( rule__TransformationDependency__Group__4__Impl rule__TransformationDependency__Group__5 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3063:2: rule__TransformationDependency__Group__4__Impl rule__TransformationDependency__Group__5
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__4__Impl_in_rule__TransformationDependency__Group__46148);
            rule__TransformationDependency__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependency__Group__5_in_rule__TransformationDependency__Group__46151);
            rule__TransformationDependency__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__4"


    // $ANTLR start "rule__TransformationDependency__Group__4__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3070:1: rule__TransformationDependency__Group__4__Impl : ( ( rule__TransformationDependency__AppliedRuleAssignment_4 ) ) ;
    public final void rule__TransformationDependency__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3074:1: ( ( ( rule__TransformationDependency__AppliedRuleAssignment_4 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3075:1: ( ( rule__TransformationDependency__AppliedRuleAssignment_4 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3075:1: ( ( rule__TransformationDependency__AppliedRuleAssignment_4 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3076:1: ( rule__TransformationDependency__AppliedRuleAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getAppliedRuleAssignment_4()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3077:1: ( rule__TransformationDependency__AppliedRuleAssignment_4 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3077:2: rule__TransformationDependency__AppliedRuleAssignment_4
            {
            pushFollow(FOLLOW_rule__TransformationDependency__AppliedRuleAssignment_4_in_rule__TransformationDependency__Group__4__Impl6178);
            rule__TransformationDependency__AppliedRuleAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getAppliedRuleAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__4__Impl"


    // $ANTLR start "rule__TransformationDependency__Group__5"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3087:1: rule__TransformationDependency__Group__5 : rule__TransformationDependency__Group__5__Impl rule__TransformationDependency__Group__6 ;
    public final void rule__TransformationDependency__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3091:1: ( rule__TransformationDependency__Group__5__Impl rule__TransformationDependency__Group__6 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3092:2: rule__TransformationDependency__Group__5__Impl rule__TransformationDependency__Group__6
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__5__Impl_in_rule__TransformationDependency__Group__56208);
            rule__TransformationDependency__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependency__Group__6_in_rule__TransformationDependency__Group__56211);
            rule__TransformationDependency__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__5"


    // $ANTLR start "rule__TransformationDependency__Group__5__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3099:1: rule__TransformationDependency__Group__5__Impl : ( ',' ) ;
    public final void rule__TransformationDependency__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3103:1: ( ( ',' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3104:1: ( ',' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3104:1: ( ',' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3105:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getCommaKeyword_5()); 
            }
            match(input,36,FOLLOW_36_in_rule__TransformationDependency__Group__5__Impl6239); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getCommaKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__5__Impl"


    // $ANTLR start "rule__TransformationDependency__Group__6"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3118:1: rule__TransformationDependency__Group__6 : rule__TransformationDependency__Group__6__Impl rule__TransformationDependency__Group__7 ;
    public final void rule__TransformationDependency__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3122:1: ( rule__TransformationDependency__Group__6__Impl rule__TransformationDependency__Group__7 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3123:2: rule__TransformationDependency__Group__6__Impl rule__TransformationDependency__Group__7
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__6__Impl_in_rule__TransformationDependency__Group__66270);
            rule__TransformationDependency__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependency__Group__7_in_rule__TransformationDependency__Group__66273);
            rule__TransformationDependency__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__6"


    // $ANTLR start "rule__TransformationDependency__Group__6__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3130:1: rule__TransformationDependency__Group__6__Impl : ( '{' ) ;
    public final void rule__TransformationDependency__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3134:1: ( ( '{' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3135:1: ( '{' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3135:1: ( '{' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3136:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getLeftCurlyBracketKeyword_6()); 
            }
            match(input,29,FOLLOW_29_in_rule__TransformationDependency__Group__6__Impl6301); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getLeftCurlyBracketKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__6__Impl"


    // $ANTLR start "rule__TransformationDependency__Group__7"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3149:1: rule__TransformationDependency__Group__7 : rule__TransformationDependency__Group__7__Impl rule__TransformationDependency__Group__8 ;
    public final void rule__TransformationDependency__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3153:1: ( rule__TransformationDependency__Group__7__Impl rule__TransformationDependency__Group__8 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3154:2: rule__TransformationDependency__Group__7__Impl rule__TransformationDependency__Group__8
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__7__Impl_in_rule__TransformationDependency__Group__76332);
            rule__TransformationDependency__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependency__Group__8_in_rule__TransformationDependency__Group__76335);
            rule__TransformationDependency__Group__8();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__7"


    // $ANTLR start "rule__TransformationDependency__Group__7__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3161:1: rule__TransformationDependency__Group__7__Impl : ( ( rule__TransformationDependency__VariableIdAssignment_7 ) ) ;
    public final void rule__TransformationDependency__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3165:1: ( ( ( rule__TransformationDependency__VariableIdAssignment_7 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3166:1: ( ( rule__TransformationDependency__VariableIdAssignment_7 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3166:1: ( ( rule__TransformationDependency__VariableIdAssignment_7 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3167:1: ( rule__TransformationDependency__VariableIdAssignment_7 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getVariableIdAssignment_7()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3168:1: ( rule__TransformationDependency__VariableIdAssignment_7 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3168:2: rule__TransformationDependency__VariableIdAssignment_7
            {
            pushFollow(FOLLOW_rule__TransformationDependency__VariableIdAssignment_7_in_rule__TransformationDependency__Group__7__Impl6362);
            rule__TransformationDependency__VariableIdAssignment_7();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getVariableIdAssignment_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__7__Impl"


    // $ANTLR start "rule__TransformationDependency__Group__8"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3178:1: rule__TransformationDependency__Group__8 : rule__TransformationDependency__Group__8__Impl rule__TransformationDependency__Group__9 ;
    public final void rule__TransformationDependency__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3182:1: ( rule__TransformationDependency__Group__8__Impl rule__TransformationDependency__Group__9 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3183:2: rule__TransformationDependency__Group__8__Impl rule__TransformationDependency__Group__9
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__8__Impl_in_rule__TransformationDependency__Group__86392);
            rule__TransformationDependency__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependency__Group__9_in_rule__TransformationDependency__Group__86395);
            rule__TransformationDependency__Group__9();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__8"


    // $ANTLR start "rule__TransformationDependency__Group__8__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3190:1: rule__TransformationDependency__Group__8__Impl : ( ( rule__TransformationDependency__Group_8__0 )* ) ;
    public final void rule__TransformationDependency__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3194:1: ( ( ( rule__TransformationDependency__Group_8__0 )* ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3195:1: ( ( rule__TransformationDependency__Group_8__0 )* )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3195:1: ( ( rule__TransformationDependency__Group_8__0 )* )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3196:1: ( rule__TransformationDependency__Group_8__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getGroup_8()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3197:1: ( rule__TransformationDependency__Group_8__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==36) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3197:2: rule__TransformationDependency__Group_8__0
            	    {
            	    pushFollow(FOLLOW_rule__TransformationDependency__Group_8__0_in_rule__TransformationDependency__Group__8__Impl6422);
            	    rule__TransformationDependency__Group_8__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getGroup_8()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__8__Impl"


    // $ANTLR start "rule__TransformationDependency__Group__9"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3207:1: rule__TransformationDependency__Group__9 : rule__TransformationDependency__Group__9__Impl rule__TransformationDependency__Group__10 ;
    public final void rule__TransformationDependency__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3211:1: ( rule__TransformationDependency__Group__9__Impl rule__TransformationDependency__Group__10 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3212:2: rule__TransformationDependency__Group__9__Impl rule__TransformationDependency__Group__10
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__9__Impl_in_rule__TransformationDependency__Group__96453);
            rule__TransformationDependency__Group__9__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependency__Group__10_in_rule__TransformationDependency__Group__96456);
            rule__TransformationDependency__Group__10();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__9"


    // $ANTLR start "rule__TransformationDependency__Group__9__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3219:1: rule__TransformationDependency__Group__9__Impl : ( '}' ) ;
    public final void rule__TransformationDependency__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3223:1: ( ( '}' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3224:1: ( '}' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3224:1: ( '}' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3225:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getRightCurlyBracketKeyword_9()); 
            }
            match(input,31,FOLLOW_31_in_rule__TransformationDependency__Group__9__Impl6484); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getRightCurlyBracketKeyword_9()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__9__Impl"


    // $ANTLR start "rule__TransformationDependency__Group__10"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3238:1: rule__TransformationDependency__Group__10 : rule__TransformationDependency__Group__10__Impl rule__TransformationDependency__Group__11 ;
    public final void rule__TransformationDependency__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3242:1: ( rule__TransformationDependency__Group__10__Impl rule__TransformationDependency__Group__11 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3243:2: rule__TransformationDependency__Group__10__Impl rule__TransformationDependency__Group__11
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__10__Impl_in_rule__TransformationDependency__Group__106515);
            rule__TransformationDependency__Group__10__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependency__Group__11_in_rule__TransformationDependency__Group__106518);
            rule__TransformationDependency__Group__11();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__10"


    // $ANTLR start "rule__TransformationDependency__Group__10__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3250:1: rule__TransformationDependency__Group__10__Impl : ( ')' ) ;
    public final void rule__TransformationDependency__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3254:1: ( ( ')' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3255:1: ( ')' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3255:1: ( ')' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3256:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getRightParenthesisKeyword_10()); 
            }
            match(input,41,FOLLOW_41_in_rule__TransformationDependency__Group__10__Impl6546); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getRightParenthesisKeyword_10()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__10__Impl"


    // $ANTLR start "rule__TransformationDependency__Group__11"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3269:1: rule__TransformationDependency__Group__11 : rule__TransformationDependency__Group__11__Impl rule__TransformationDependency__Group__12 ;
    public final void rule__TransformationDependency__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3273:1: ( rule__TransformationDependency__Group__11__Impl rule__TransformationDependency__Group__12 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3274:2: rule__TransformationDependency__Group__11__Impl rule__TransformationDependency__Group__12
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__11__Impl_in_rule__TransformationDependency__Group__116577);
            rule__TransformationDependency__Group__11__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependency__Group__12_in_rule__TransformationDependency__Group__116580);
            rule__TransformationDependency__Group__12();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__11"


    // $ANTLR start "rule__TransformationDependency__Group__11__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3281:1: rule__TransformationDependency__Group__11__Impl : ( '[' ) ;
    public final void rule__TransformationDependency__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3285:1: ( ( '[' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3286:1: ( '[' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3286:1: ( '[' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3287:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getLeftSquareBracketKeyword_11()); 
            }
            match(input,33,FOLLOW_33_in_rule__TransformationDependency__Group__11__Impl6608); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getLeftSquareBracketKeyword_11()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__11__Impl"


    // $ANTLR start "rule__TransformationDependency__Group__12"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3300:1: rule__TransformationDependency__Group__12 : rule__TransformationDependency__Group__12__Impl rule__TransformationDependency__Group__13 ;
    public final void rule__TransformationDependency__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3304:1: ( rule__TransformationDependency__Group__12__Impl rule__TransformationDependency__Group__13 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3305:2: rule__TransformationDependency__Group__12__Impl rule__TransformationDependency__Group__13
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__12__Impl_in_rule__TransformationDependency__Group__126639);
            rule__TransformationDependency__Group__12__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependency__Group__13_in_rule__TransformationDependency__Group__126642);
            rule__TransformationDependency__Group__13();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__12"


    // $ANTLR start "rule__TransformationDependency__Group__12__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3312:1: rule__TransformationDependency__Group__12__Impl : ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12 ) ) ;
    public final void rule__TransformationDependency__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3316:1: ( ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3317:1: ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3317:1: ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3318:1: ( rule__TransformationDependency__RequiredTransformationsAssignment_12 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAssignment_12()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3319:1: ( rule__TransformationDependency__RequiredTransformationsAssignment_12 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3319:2: rule__TransformationDependency__RequiredTransformationsAssignment_12
            {
            pushFollow(FOLLOW_rule__TransformationDependency__RequiredTransformationsAssignment_12_in_rule__TransformationDependency__Group__12__Impl6669);
            rule__TransformationDependency__RequiredTransformationsAssignment_12();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAssignment_12()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__12__Impl"


    // $ANTLR start "rule__TransformationDependency__Group__13"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3329:1: rule__TransformationDependency__Group__13 : rule__TransformationDependency__Group__13__Impl ;
    public final void rule__TransformationDependency__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3333:1: ( rule__TransformationDependency__Group__13__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3334:2: rule__TransformationDependency__Group__13__Impl
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__13__Impl_in_rule__TransformationDependency__Group__136699);
            rule__TransformationDependency__Group__13__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__13"


    // $ANTLR start "rule__TransformationDependency__Group__13__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3340:1: rule__TransformationDependency__Group__13__Impl : ( ']' ) ;
    public final void rule__TransformationDependency__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3344:1: ( ( ']' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3345:1: ( ']' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3345:1: ( ']' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3346:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getRightSquareBracketKeyword_13()); 
            }
            match(input,34,FOLLOW_34_in_rule__TransformationDependency__Group__13__Impl6727); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getRightSquareBracketKeyword_13()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__13__Impl"


    // $ANTLR start "rule__TransformationDependency__Group_8__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3387:1: rule__TransformationDependency__Group_8__0 : rule__TransformationDependency__Group_8__0__Impl rule__TransformationDependency__Group_8__1 ;
    public final void rule__TransformationDependency__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3391:1: ( rule__TransformationDependency__Group_8__0__Impl rule__TransformationDependency__Group_8__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3392:2: rule__TransformationDependency__Group_8__0__Impl rule__TransformationDependency__Group_8__1
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group_8__0__Impl_in_rule__TransformationDependency__Group_8__06786);
            rule__TransformationDependency__Group_8__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__TransformationDependency__Group_8__1_in_rule__TransformationDependency__Group_8__06789);
            rule__TransformationDependency__Group_8__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group_8__0"


    // $ANTLR start "rule__TransformationDependency__Group_8__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3399:1: rule__TransformationDependency__Group_8__0__Impl : ( ',' ) ;
    public final void rule__TransformationDependency__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3403:1: ( ( ',' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3404:1: ( ',' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3404:1: ( ',' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3405:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getCommaKeyword_8_0()); 
            }
            match(input,36,FOLLOW_36_in_rule__TransformationDependency__Group_8__0__Impl6817); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getCommaKeyword_8_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group_8__0__Impl"


    // $ANTLR start "rule__TransformationDependency__Group_8__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3418:1: rule__TransformationDependency__Group_8__1 : rule__TransformationDependency__Group_8__1__Impl ;
    public final void rule__TransformationDependency__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3422:1: ( rule__TransformationDependency__Group_8__1__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3423:2: rule__TransformationDependency__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group_8__1__Impl_in_rule__TransformationDependency__Group_8__16848);
            rule__TransformationDependency__Group_8__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group_8__1"


    // $ANTLR start "rule__TransformationDependency__Group_8__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3429:1: rule__TransformationDependency__Group_8__1__Impl : ( ( rule__TransformationDependency__VariableIdAssignment_8_1 ) ) ;
    public final void rule__TransformationDependency__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3433:1: ( ( ( rule__TransformationDependency__VariableIdAssignment_8_1 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3434:1: ( ( rule__TransformationDependency__VariableIdAssignment_8_1 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3434:1: ( ( rule__TransformationDependency__VariableIdAssignment_8_1 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3435:1: ( rule__TransformationDependency__VariableIdAssignment_8_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getVariableIdAssignment_8_1()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3436:1: ( rule__TransformationDependency__VariableIdAssignment_8_1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3436:2: rule__TransformationDependency__VariableIdAssignment_8_1
            {
            pushFollow(FOLLOW_rule__TransformationDependency__VariableIdAssignment_8_1_in_rule__TransformationDependency__Group_8__1__Impl6875);
            rule__TransformationDependency__VariableIdAssignment_8_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getVariableIdAssignment_8_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group_8__1__Impl"


    // $ANTLR start "rule__RuleDependencyDisjunction__Group__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3450:1: rule__RuleDependencyDisjunction__Group__0 : rule__RuleDependencyDisjunction__Group__0__Impl rule__RuleDependencyDisjunction__Group__1 ;
    public final void rule__RuleDependencyDisjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3454:1: ( rule__RuleDependencyDisjunction__Group__0__Impl rule__RuleDependencyDisjunction__Group__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3455:2: rule__RuleDependencyDisjunction__Group__0__Impl rule__RuleDependencyDisjunction__Group__1
            {
            pushFollow(FOLLOW_rule__RuleDependencyDisjunction__Group__0__Impl_in_rule__RuleDependencyDisjunction__Group__06909);
            rule__RuleDependencyDisjunction__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependencyDisjunction__Group__1_in_rule__RuleDependencyDisjunction__Group__06912);
            rule__RuleDependencyDisjunction__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyDisjunction__Group__0"


    // $ANTLR start "rule__RuleDependencyDisjunction__Group__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3462:1: rule__RuleDependencyDisjunction__Group__0__Impl : ( ( rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_0 ) ) ;
    public final void rule__RuleDependencyDisjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3466:1: ( ( ( rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3467:1: ( ( rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3467:1: ( ( rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3468:1: ( rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyDisjunctionAccess().getRequiredTransformationsAssignment_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3469:1: ( rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3469:2: rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_0
            {
            pushFollow(FOLLOW_rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_0_in_rule__RuleDependencyDisjunction__Group__0__Impl6939);
            rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyDisjunctionAccess().getRequiredTransformationsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyDisjunction__Group__0__Impl"


    // $ANTLR start "rule__RuleDependencyDisjunction__Group__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3479:1: rule__RuleDependencyDisjunction__Group__1 : rule__RuleDependencyDisjunction__Group__1__Impl ;
    public final void rule__RuleDependencyDisjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3483:1: ( rule__RuleDependencyDisjunction__Group__1__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3484:2: rule__RuleDependencyDisjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RuleDependencyDisjunction__Group__1__Impl_in_rule__RuleDependencyDisjunction__Group__16969);
            rule__RuleDependencyDisjunction__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyDisjunction__Group__1"


    // $ANTLR start "rule__RuleDependencyDisjunction__Group__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3490:1: rule__RuleDependencyDisjunction__Group__1__Impl : ( ( ( rule__RuleDependencyDisjunction__Group_1__0 ) ) ( ( rule__RuleDependencyDisjunction__Group_1__0 )* ) ) ;
    public final void rule__RuleDependencyDisjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3494:1: ( ( ( ( rule__RuleDependencyDisjunction__Group_1__0 ) ) ( ( rule__RuleDependencyDisjunction__Group_1__0 )* ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3495:1: ( ( ( rule__RuleDependencyDisjunction__Group_1__0 ) ) ( ( rule__RuleDependencyDisjunction__Group_1__0 )* ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3495:1: ( ( ( rule__RuleDependencyDisjunction__Group_1__0 ) ) ( ( rule__RuleDependencyDisjunction__Group_1__0 )* ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3496:1: ( ( rule__RuleDependencyDisjunction__Group_1__0 ) ) ( ( rule__RuleDependencyDisjunction__Group_1__0 )* )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3496:1: ( ( rule__RuleDependencyDisjunction__Group_1__0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3497:1: ( rule__RuleDependencyDisjunction__Group_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyDisjunctionAccess().getGroup_1()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3498:1: ( rule__RuleDependencyDisjunction__Group_1__0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3498:2: rule__RuleDependencyDisjunction__Group_1__0
            {
            pushFollow(FOLLOW_rule__RuleDependencyDisjunction__Group_1__0_in_rule__RuleDependencyDisjunction__Group__1__Impl6998);
            rule__RuleDependencyDisjunction__Group_1__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyDisjunctionAccess().getGroup_1()); 
            }

            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3501:1: ( ( rule__RuleDependencyDisjunction__Group_1__0 )* )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3502:1: ( rule__RuleDependencyDisjunction__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyDisjunctionAccess().getGroup_1()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3503:1: ( rule__RuleDependencyDisjunction__Group_1__0 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( (LA19_0==44) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3503:2: rule__RuleDependencyDisjunction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__RuleDependencyDisjunction__Group_1__0_in_rule__RuleDependencyDisjunction__Group__1__Impl7010);
            	    rule__RuleDependencyDisjunction__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyDisjunctionAccess().getGroup_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyDisjunction__Group__1__Impl"


    // $ANTLR start "rule__RuleDependencyDisjunction__Group_1__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3518:1: rule__RuleDependencyDisjunction__Group_1__0 : rule__RuleDependencyDisjunction__Group_1__0__Impl rule__RuleDependencyDisjunction__Group_1__1 ;
    public final void rule__RuleDependencyDisjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3522:1: ( rule__RuleDependencyDisjunction__Group_1__0__Impl rule__RuleDependencyDisjunction__Group_1__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3523:2: rule__RuleDependencyDisjunction__Group_1__0__Impl rule__RuleDependencyDisjunction__Group_1__1
            {
            pushFollow(FOLLOW_rule__RuleDependencyDisjunction__Group_1__0__Impl_in_rule__RuleDependencyDisjunction__Group_1__07047);
            rule__RuleDependencyDisjunction__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependencyDisjunction__Group_1__1_in_rule__RuleDependencyDisjunction__Group_1__07050);
            rule__RuleDependencyDisjunction__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyDisjunction__Group_1__0"


    // $ANTLR start "rule__RuleDependencyDisjunction__Group_1__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3530:1: rule__RuleDependencyDisjunction__Group_1__0__Impl : ( 'or' ) ;
    public final void rule__RuleDependencyDisjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3534:1: ( ( 'or' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3535:1: ( 'or' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3535:1: ( 'or' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3536:1: 'or'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyDisjunctionAccess().getOrKeyword_1_0()); 
            }
            match(input,44,FOLLOW_44_in_rule__RuleDependencyDisjunction__Group_1__0__Impl7078); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyDisjunctionAccess().getOrKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyDisjunction__Group_1__0__Impl"


    // $ANTLR start "rule__RuleDependencyDisjunction__Group_1__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3549:1: rule__RuleDependencyDisjunction__Group_1__1 : rule__RuleDependencyDisjunction__Group_1__1__Impl ;
    public final void rule__RuleDependencyDisjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3553:1: ( rule__RuleDependencyDisjunction__Group_1__1__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3554:2: rule__RuleDependencyDisjunction__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__RuleDependencyDisjunction__Group_1__1__Impl_in_rule__RuleDependencyDisjunction__Group_1__17109);
            rule__RuleDependencyDisjunction__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyDisjunction__Group_1__1"


    // $ANTLR start "rule__RuleDependencyDisjunction__Group_1__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3560:1: rule__RuleDependencyDisjunction__Group_1__1__Impl : ( ( rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_1_1 ) ) ;
    public final void rule__RuleDependencyDisjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3564:1: ( ( ( rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_1_1 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3565:1: ( ( rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_1_1 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3565:1: ( ( rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_1_1 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3566:1: ( rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyDisjunctionAccess().getRequiredTransformationsAssignment_1_1()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3567:1: ( rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_1_1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3567:2: rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_1_1_in_rule__RuleDependencyDisjunction__Group_1__1__Impl7136);
            rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyDisjunctionAccess().getRequiredTransformationsAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyDisjunction__Group_1__1__Impl"


    // $ANTLR start "rule__RuleDependencyComposite__Group_0__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3581:1: rule__RuleDependencyComposite__Group_0__0 : rule__RuleDependencyComposite__Group_0__0__Impl rule__RuleDependencyComposite__Group_0__1 ;
    public final void rule__RuleDependencyComposite__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3585:1: ( rule__RuleDependencyComposite__Group_0__0__Impl rule__RuleDependencyComposite__Group_0__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3586:2: rule__RuleDependencyComposite__Group_0__0__Impl rule__RuleDependencyComposite__Group_0__1
            {
            pushFollow(FOLLOW_rule__RuleDependencyComposite__Group_0__0__Impl_in_rule__RuleDependencyComposite__Group_0__07170);
            rule__RuleDependencyComposite__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependencyComposite__Group_0__1_in_rule__RuleDependencyComposite__Group_0__07173);
            rule__RuleDependencyComposite__Group_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyComposite__Group_0__0"


    // $ANTLR start "rule__RuleDependencyComposite__Group_0__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3593:1: rule__RuleDependencyComposite__Group_0__0__Impl : ( '(' ) ;
    public final void rule__RuleDependencyComposite__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3597:1: ( ( '(' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3598:1: ( '(' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3598:1: ( '(' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3599:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyCompositeAccess().getLeftParenthesisKeyword_0_0()); 
            }
            match(input,40,FOLLOW_40_in_rule__RuleDependencyComposite__Group_0__0__Impl7201); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyCompositeAccess().getLeftParenthesisKeyword_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyComposite__Group_0__0__Impl"


    // $ANTLR start "rule__RuleDependencyComposite__Group_0__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3612:1: rule__RuleDependencyComposite__Group_0__1 : rule__RuleDependencyComposite__Group_0__1__Impl rule__RuleDependencyComposite__Group_0__2 ;
    public final void rule__RuleDependencyComposite__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3616:1: ( rule__RuleDependencyComposite__Group_0__1__Impl rule__RuleDependencyComposite__Group_0__2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3617:2: rule__RuleDependencyComposite__Group_0__1__Impl rule__RuleDependencyComposite__Group_0__2
            {
            pushFollow(FOLLOW_rule__RuleDependencyComposite__Group_0__1__Impl_in_rule__RuleDependencyComposite__Group_0__17232);
            rule__RuleDependencyComposite__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependencyComposite__Group_0__2_in_rule__RuleDependencyComposite__Group_0__17235);
            rule__RuleDependencyComposite__Group_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyComposite__Group_0__1"


    // $ANTLR start "rule__RuleDependencyComposite__Group_0__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3624:1: rule__RuleDependencyComposite__Group_0__1__Impl : ( ruleRuleDependencyConjunction ) ;
    public final void rule__RuleDependencyComposite__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3628:1: ( ( ruleRuleDependencyConjunction ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3629:1: ( ruleRuleDependencyConjunction )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3629:1: ( ruleRuleDependencyConjunction )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3630:1: ruleRuleDependencyConjunction
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyCompositeAccess().getRuleDependencyConjunctionParserRuleCall_0_1()); 
            }
            pushFollow(FOLLOW_ruleRuleDependencyConjunction_in_rule__RuleDependencyComposite__Group_0__1__Impl7262);
            ruleRuleDependencyConjunction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyCompositeAccess().getRuleDependencyConjunctionParserRuleCall_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyComposite__Group_0__1__Impl"


    // $ANTLR start "rule__RuleDependencyComposite__Group_0__2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3641:1: rule__RuleDependencyComposite__Group_0__2 : rule__RuleDependencyComposite__Group_0__2__Impl ;
    public final void rule__RuleDependencyComposite__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3645:1: ( rule__RuleDependencyComposite__Group_0__2__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3646:2: rule__RuleDependencyComposite__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__RuleDependencyComposite__Group_0__2__Impl_in_rule__RuleDependencyComposite__Group_0__27291);
            rule__RuleDependencyComposite__Group_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyComposite__Group_0__2"


    // $ANTLR start "rule__RuleDependencyComposite__Group_0__2__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3652:1: rule__RuleDependencyComposite__Group_0__2__Impl : ( ')' ) ;
    public final void rule__RuleDependencyComposite__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3656:1: ( ( ')' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3657:1: ( ')' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3657:1: ( ')' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3658:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyCompositeAccess().getRightParenthesisKeyword_0_2()); 
            }
            match(input,41,FOLLOW_41_in_rule__RuleDependencyComposite__Group_0__2__Impl7319); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyCompositeAccess().getRightParenthesisKeyword_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyComposite__Group_0__2__Impl"


    // $ANTLR start "rule__RuleDependencyComposite__Group_1__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3677:1: rule__RuleDependencyComposite__Group_1__0 : rule__RuleDependencyComposite__Group_1__0__Impl rule__RuleDependencyComposite__Group_1__1 ;
    public final void rule__RuleDependencyComposite__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3681:1: ( rule__RuleDependencyComposite__Group_1__0__Impl rule__RuleDependencyComposite__Group_1__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3682:2: rule__RuleDependencyComposite__Group_1__0__Impl rule__RuleDependencyComposite__Group_1__1
            {
            pushFollow(FOLLOW_rule__RuleDependencyComposite__Group_1__0__Impl_in_rule__RuleDependencyComposite__Group_1__07356);
            rule__RuleDependencyComposite__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependencyComposite__Group_1__1_in_rule__RuleDependencyComposite__Group_1__07359);
            rule__RuleDependencyComposite__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyComposite__Group_1__0"


    // $ANTLR start "rule__RuleDependencyComposite__Group_1__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3689:1: rule__RuleDependencyComposite__Group_1__0__Impl : ( '(' ) ;
    public final void rule__RuleDependencyComposite__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3693:1: ( ( '(' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3694:1: ( '(' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3694:1: ( '(' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3695:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyCompositeAccess().getLeftParenthesisKeyword_1_0()); 
            }
            match(input,40,FOLLOW_40_in_rule__RuleDependencyComposite__Group_1__0__Impl7387); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyCompositeAccess().getLeftParenthesisKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyComposite__Group_1__0__Impl"


    // $ANTLR start "rule__RuleDependencyComposite__Group_1__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3708:1: rule__RuleDependencyComposite__Group_1__1 : rule__RuleDependencyComposite__Group_1__1__Impl rule__RuleDependencyComposite__Group_1__2 ;
    public final void rule__RuleDependencyComposite__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3712:1: ( rule__RuleDependencyComposite__Group_1__1__Impl rule__RuleDependencyComposite__Group_1__2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3713:2: rule__RuleDependencyComposite__Group_1__1__Impl rule__RuleDependencyComposite__Group_1__2
            {
            pushFollow(FOLLOW_rule__RuleDependencyComposite__Group_1__1__Impl_in_rule__RuleDependencyComposite__Group_1__17418);
            rule__RuleDependencyComposite__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependencyComposite__Group_1__2_in_rule__RuleDependencyComposite__Group_1__17421);
            rule__RuleDependencyComposite__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyComposite__Group_1__1"


    // $ANTLR start "rule__RuleDependencyComposite__Group_1__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3720:1: rule__RuleDependencyComposite__Group_1__1__Impl : ( ruleRuleDependencyDisjunction ) ;
    public final void rule__RuleDependencyComposite__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3724:1: ( ( ruleRuleDependencyDisjunction ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3725:1: ( ruleRuleDependencyDisjunction )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3725:1: ( ruleRuleDependencyDisjunction )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3726:1: ruleRuleDependencyDisjunction
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyCompositeAccess().getRuleDependencyDisjunctionParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_ruleRuleDependencyDisjunction_in_rule__RuleDependencyComposite__Group_1__1__Impl7448);
            ruleRuleDependencyDisjunction();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyCompositeAccess().getRuleDependencyDisjunctionParserRuleCall_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyComposite__Group_1__1__Impl"


    // $ANTLR start "rule__RuleDependencyComposite__Group_1__2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3737:1: rule__RuleDependencyComposite__Group_1__2 : rule__RuleDependencyComposite__Group_1__2__Impl ;
    public final void rule__RuleDependencyComposite__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3741:1: ( rule__RuleDependencyComposite__Group_1__2__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3742:2: rule__RuleDependencyComposite__Group_1__2__Impl
            {
            pushFollow(FOLLOW_rule__RuleDependencyComposite__Group_1__2__Impl_in_rule__RuleDependencyComposite__Group_1__27477);
            rule__RuleDependencyComposite__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyComposite__Group_1__2"


    // $ANTLR start "rule__RuleDependencyComposite__Group_1__2__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3748:1: rule__RuleDependencyComposite__Group_1__2__Impl : ( ')' ) ;
    public final void rule__RuleDependencyComposite__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3752:1: ( ( ')' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3753:1: ( ')' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3753:1: ( ')' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3754:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyCompositeAccess().getRightParenthesisKeyword_1_2()); 
            }
            match(input,41,FOLLOW_41_in_rule__RuleDependencyComposite__Group_1__2__Impl7505); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyCompositeAccess().getRightParenthesisKeyword_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyComposite__Group_1__2__Impl"


    // $ANTLR start "rule__RuleDependencyConjunction__Group__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3773:1: rule__RuleDependencyConjunction__Group__0 : rule__RuleDependencyConjunction__Group__0__Impl rule__RuleDependencyConjunction__Group__1 ;
    public final void rule__RuleDependencyConjunction__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3777:1: ( rule__RuleDependencyConjunction__Group__0__Impl rule__RuleDependencyConjunction__Group__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3778:2: rule__RuleDependencyConjunction__Group__0__Impl rule__RuleDependencyConjunction__Group__1
            {
            pushFollow(FOLLOW_rule__RuleDependencyConjunction__Group__0__Impl_in_rule__RuleDependencyConjunction__Group__07542);
            rule__RuleDependencyConjunction__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependencyConjunction__Group__1_in_rule__RuleDependencyConjunction__Group__07545);
            rule__RuleDependencyConjunction__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyConjunction__Group__0"


    // $ANTLR start "rule__RuleDependencyConjunction__Group__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3785:1: rule__RuleDependencyConjunction__Group__0__Impl : ( ( rule__RuleDependencyConjunction__RequiredTransformationsAssignment_0 ) ) ;
    public final void rule__RuleDependencyConjunction__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3789:1: ( ( ( rule__RuleDependencyConjunction__RequiredTransformationsAssignment_0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3790:1: ( ( rule__RuleDependencyConjunction__RequiredTransformationsAssignment_0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3790:1: ( ( rule__RuleDependencyConjunction__RequiredTransformationsAssignment_0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3791:1: ( rule__RuleDependencyConjunction__RequiredTransformationsAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyConjunctionAccess().getRequiredTransformationsAssignment_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3792:1: ( rule__RuleDependencyConjunction__RequiredTransformationsAssignment_0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3792:2: rule__RuleDependencyConjunction__RequiredTransformationsAssignment_0
            {
            pushFollow(FOLLOW_rule__RuleDependencyConjunction__RequiredTransformationsAssignment_0_in_rule__RuleDependencyConjunction__Group__0__Impl7572);
            rule__RuleDependencyConjunction__RequiredTransformationsAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyConjunctionAccess().getRequiredTransformationsAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyConjunction__Group__0__Impl"


    // $ANTLR start "rule__RuleDependencyConjunction__Group__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3802:1: rule__RuleDependencyConjunction__Group__1 : rule__RuleDependencyConjunction__Group__1__Impl ;
    public final void rule__RuleDependencyConjunction__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3806:1: ( rule__RuleDependencyConjunction__Group__1__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3807:2: rule__RuleDependencyConjunction__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__RuleDependencyConjunction__Group__1__Impl_in_rule__RuleDependencyConjunction__Group__17602);
            rule__RuleDependencyConjunction__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyConjunction__Group__1"


    // $ANTLR start "rule__RuleDependencyConjunction__Group__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3813:1: rule__RuleDependencyConjunction__Group__1__Impl : ( ( ( rule__RuleDependencyConjunction__Group_1__0 ) ) ( ( rule__RuleDependencyConjunction__Group_1__0 )* ) ) ;
    public final void rule__RuleDependencyConjunction__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3817:1: ( ( ( ( rule__RuleDependencyConjunction__Group_1__0 ) ) ( ( rule__RuleDependencyConjunction__Group_1__0 )* ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3818:1: ( ( ( rule__RuleDependencyConjunction__Group_1__0 ) ) ( ( rule__RuleDependencyConjunction__Group_1__0 )* ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3818:1: ( ( ( rule__RuleDependencyConjunction__Group_1__0 ) ) ( ( rule__RuleDependencyConjunction__Group_1__0 )* ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3819:1: ( ( rule__RuleDependencyConjunction__Group_1__0 ) ) ( ( rule__RuleDependencyConjunction__Group_1__0 )* )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3819:1: ( ( rule__RuleDependencyConjunction__Group_1__0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3820:1: ( rule__RuleDependencyConjunction__Group_1__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyConjunctionAccess().getGroup_1()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3821:1: ( rule__RuleDependencyConjunction__Group_1__0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3821:2: rule__RuleDependencyConjunction__Group_1__0
            {
            pushFollow(FOLLOW_rule__RuleDependencyConjunction__Group_1__0_in_rule__RuleDependencyConjunction__Group__1__Impl7631);
            rule__RuleDependencyConjunction__Group_1__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyConjunctionAccess().getGroup_1()); 
            }

            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3824:1: ( ( rule__RuleDependencyConjunction__Group_1__0 )* )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3825:1: ( rule__RuleDependencyConjunction__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyConjunctionAccess().getGroup_1()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3826:1: ( rule__RuleDependencyConjunction__Group_1__0 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==45) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3826:2: rule__RuleDependencyConjunction__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__RuleDependencyConjunction__Group_1__0_in_rule__RuleDependencyConjunction__Group__1__Impl7643);
            	    rule__RuleDependencyConjunction__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyConjunctionAccess().getGroup_1()); 
            }

            }


            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyConjunction__Group__1__Impl"


    // $ANTLR start "rule__RuleDependencyConjunction__Group_1__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3841:1: rule__RuleDependencyConjunction__Group_1__0 : rule__RuleDependencyConjunction__Group_1__0__Impl rule__RuleDependencyConjunction__Group_1__1 ;
    public final void rule__RuleDependencyConjunction__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3845:1: ( rule__RuleDependencyConjunction__Group_1__0__Impl rule__RuleDependencyConjunction__Group_1__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3846:2: rule__RuleDependencyConjunction__Group_1__0__Impl rule__RuleDependencyConjunction__Group_1__1
            {
            pushFollow(FOLLOW_rule__RuleDependencyConjunction__Group_1__0__Impl_in_rule__RuleDependencyConjunction__Group_1__07680);
            rule__RuleDependencyConjunction__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependencyConjunction__Group_1__1_in_rule__RuleDependencyConjunction__Group_1__07683);
            rule__RuleDependencyConjunction__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyConjunction__Group_1__0"


    // $ANTLR start "rule__RuleDependencyConjunction__Group_1__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3853:1: rule__RuleDependencyConjunction__Group_1__0__Impl : ( 'and' ) ;
    public final void rule__RuleDependencyConjunction__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3857:1: ( ( 'and' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3858:1: ( 'and' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3858:1: ( 'and' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3859:1: 'and'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyConjunctionAccess().getAndKeyword_1_0()); 
            }
            match(input,45,FOLLOW_45_in_rule__RuleDependencyConjunction__Group_1__0__Impl7711); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyConjunctionAccess().getAndKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyConjunction__Group_1__0__Impl"


    // $ANTLR start "rule__RuleDependencyConjunction__Group_1__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3872:1: rule__RuleDependencyConjunction__Group_1__1 : rule__RuleDependencyConjunction__Group_1__1__Impl ;
    public final void rule__RuleDependencyConjunction__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3876:1: ( rule__RuleDependencyConjunction__Group_1__1__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3877:2: rule__RuleDependencyConjunction__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__RuleDependencyConjunction__Group_1__1__Impl_in_rule__RuleDependencyConjunction__Group_1__17742);
            rule__RuleDependencyConjunction__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyConjunction__Group_1__1"


    // $ANTLR start "rule__RuleDependencyConjunction__Group_1__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3883:1: rule__RuleDependencyConjunction__Group_1__1__Impl : ( ( rule__RuleDependencyConjunction__RequiredTransformationsAssignment_1_1 ) ) ;
    public final void rule__RuleDependencyConjunction__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3887:1: ( ( ( rule__RuleDependencyConjunction__RequiredTransformationsAssignment_1_1 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3888:1: ( ( rule__RuleDependencyConjunction__RequiredTransformationsAssignment_1_1 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3888:1: ( ( rule__RuleDependencyConjunction__RequiredTransformationsAssignment_1_1 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3889:1: ( rule__RuleDependencyConjunction__RequiredTransformationsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyConjunctionAccess().getRequiredTransformationsAssignment_1_1()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3890:1: ( rule__RuleDependencyConjunction__RequiredTransformationsAssignment_1_1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3890:2: rule__RuleDependencyConjunction__RequiredTransformationsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__RuleDependencyConjunction__RequiredTransformationsAssignment_1_1_in_rule__RuleDependencyConjunction__Group_1__1__Impl7769);
            rule__RuleDependencyConjunction__RequiredTransformationsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyConjunctionAccess().getRequiredTransformationsAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyConjunction__Group_1__1__Impl"


    // $ANTLR start "rule__RuleDependency__Group__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3904:1: rule__RuleDependency__Group__0 : rule__RuleDependency__Group__0__Impl rule__RuleDependency__Group__1 ;
    public final void rule__RuleDependency__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3908:1: ( rule__RuleDependency__Group__0__Impl rule__RuleDependency__Group__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3909:2: rule__RuleDependency__Group__0__Impl rule__RuleDependency__Group__1
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group__0__Impl_in_rule__RuleDependency__Group__07803);
            rule__RuleDependency__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependency__Group__1_in_rule__RuleDependency__Group__07806);
            rule__RuleDependency__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__0"


    // $ANTLR start "rule__RuleDependency__Group__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3916:1: rule__RuleDependency__Group__0__Impl : ( ( rule__RuleDependency__TypeAssignment_0 ) ) ;
    public final void rule__RuleDependency__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3920:1: ( ( ( rule__RuleDependency__TypeAssignment_0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3921:1: ( ( rule__RuleDependency__TypeAssignment_0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3921:1: ( ( rule__RuleDependency__TypeAssignment_0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3922:1: ( rule__RuleDependency__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getTypeAssignment_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3923:1: ( rule__RuleDependency__TypeAssignment_0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3923:2: rule__RuleDependency__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__RuleDependency__TypeAssignment_0_in_rule__RuleDependency__Group__0__Impl7833);
            rule__RuleDependency__TypeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getTypeAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__0__Impl"


    // $ANTLR start "rule__RuleDependency__Group__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3933:1: rule__RuleDependency__Group__1 : rule__RuleDependency__Group__1__Impl rule__RuleDependency__Group__2 ;
    public final void rule__RuleDependency__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3937:1: ( rule__RuleDependency__Group__1__Impl rule__RuleDependency__Group__2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3938:2: rule__RuleDependency__Group__1__Impl rule__RuleDependency__Group__2
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group__1__Impl_in_rule__RuleDependency__Group__17863);
            rule__RuleDependency__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependency__Group__2_in_rule__RuleDependency__Group__17866);
            rule__RuleDependency__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__1"


    // $ANTLR start "rule__RuleDependency__Group__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3945:1: rule__RuleDependency__Group__1__Impl : ( '(' ) ;
    public final void rule__RuleDependency__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3949:1: ( ( '(' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3950:1: ( '(' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3950:1: ( '(' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3951:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getLeftParenthesisKeyword_1()); 
            }
            match(input,40,FOLLOW_40_in_rule__RuleDependency__Group__1__Impl7894); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getLeftParenthesisKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__1__Impl"


    // $ANTLR start "rule__RuleDependency__Group__2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3964:1: rule__RuleDependency__Group__2 : rule__RuleDependency__Group__2__Impl rule__RuleDependency__Group__3 ;
    public final void rule__RuleDependency__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3968:1: ( rule__RuleDependency__Group__2__Impl rule__RuleDependency__Group__3 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3969:2: rule__RuleDependency__Group__2__Impl rule__RuleDependency__Group__3
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group__2__Impl_in_rule__RuleDependency__Group__27925);
            rule__RuleDependency__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependency__Group__3_in_rule__RuleDependency__Group__27928);
            rule__RuleDependency__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__2"


    // $ANTLR start "rule__RuleDependency__Group__2__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3976:1: rule__RuleDependency__Group__2__Impl : ( ( rule__RuleDependency__RequiredTransformationAssignment_2 ) ) ;
    public final void rule__RuleDependency__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3980:1: ( ( ( rule__RuleDependency__RequiredTransformationAssignment_2 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3981:1: ( ( rule__RuleDependency__RequiredTransformationAssignment_2 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3981:1: ( ( rule__RuleDependency__RequiredTransformationAssignment_2 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3982:1: ( rule__RuleDependency__RequiredTransformationAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getRequiredTransformationAssignment_2()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3983:1: ( rule__RuleDependency__RequiredTransformationAssignment_2 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3983:2: rule__RuleDependency__RequiredTransformationAssignment_2
            {
            pushFollow(FOLLOW_rule__RuleDependency__RequiredTransformationAssignment_2_in_rule__RuleDependency__Group__2__Impl7955);
            rule__RuleDependency__RequiredTransformationAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getRequiredTransformationAssignment_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__2__Impl"


    // $ANTLR start "rule__RuleDependency__Group__3"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3993:1: rule__RuleDependency__Group__3 : rule__RuleDependency__Group__3__Impl rule__RuleDependency__Group__4 ;
    public final void rule__RuleDependency__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3997:1: ( rule__RuleDependency__Group__3__Impl rule__RuleDependency__Group__4 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:3998:2: rule__RuleDependency__Group__3__Impl rule__RuleDependency__Group__4
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group__3__Impl_in_rule__RuleDependency__Group__37985);
            rule__RuleDependency__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependency__Group__4_in_rule__RuleDependency__Group__37988);
            rule__RuleDependency__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__3"


    // $ANTLR start "rule__RuleDependency__Group__3__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4005:1: rule__RuleDependency__Group__3__Impl : ( '.' ) ;
    public final void rule__RuleDependency__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4009:1: ( ( '.' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4010:1: ( '.' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4010:1: ( '.' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4011:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getFullStopKeyword_3()); 
            }
            match(input,32,FOLLOW_32_in_rule__RuleDependency__Group__3__Impl8016); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getFullStopKeyword_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__3__Impl"


    // $ANTLR start "rule__RuleDependency__Group__4"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4024:1: rule__RuleDependency__Group__4 : rule__RuleDependency__Group__4__Impl rule__RuleDependency__Group__5 ;
    public final void rule__RuleDependency__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4028:1: ( rule__RuleDependency__Group__4__Impl rule__RuleDependency__Group__5 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4029:2: rule__RuleDependency__Group__4__Impl rule__RuleDependency__Group__5
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group__4__Impl_in_rule__RuleDependency__Group__48047);
            rule__RuleDependency__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependency__Group__5_in_rule__RuleDependency__Group__48050);
            rule__RuleDependency__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__4"


    // $ANTLR start "rule__RuleDependency__Group__4__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4036:1: rule__RuleDependency__Group__4__Impl : ( ( rule__RuleDependency__RequiredRuleAssignment_4 ) ) ;
    public final void rule__RuleDependency__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4040:1: ( ( ( rule__RuleDependency__RequiredRuleAssignment_4 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4041:1: ( ( rule__RuleDependency__RequiredRuleAssignment_4 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4041:1: ( ( rule__RuleDependency__RequiredRuleAssignment_4 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4042:1: ( rule__RuleDependency__RequiredRuleAssignment_4 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getRequiredRuleAssignment_4()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4043:1: ( rule__RuleDependency__RequiredRuleAssignment_4 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4043:2: rule__RuleDependency__RequiredRuleAssignment_4
            {
            pushFollow(FOLLOW_rule__RuleDependency__RequiredRuleAssignment_4_in_rule__RuleDependency__Group__4__Impl8077);
            rule__RuleDependency__RequiredRuleAssignment_4();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getRequiredRuleAssignment_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__4__Impl"


    // $ANTLR start "rule__RuleDependency__Group__5"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4053:1: rule__RuleDependency__Group__5 : rule__RuleDependency__Group__5__Impl rule__RuleDependency__Group__6 ;
    public final void rule__RuleDependency__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4057:1: ( rule__RuleDependency__Group__5__Impl rule__RuleDependency__Group__6 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4058:2: rule__RuleDependency__Group__5__Impl rule__RuleDependency__Group__6
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group__5__Impl_in_rule__RuleDependency__Group__58107);
            rule__RuleDependency__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependency__Group__6_in_rule__RuleDependency__Group__58110);
            rule__RuleDependency__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__5"


    // $ANTLR start "rule__RuleDependency__Group__5__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4065:1: rule__RuleDependency__Group__5__Impl : ( ',' ) ;
    public final void rule__RuleDependency__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4069:1: ( ( ',' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4070:1: ( ',' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4070:1: ( ',' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4071:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getCommaKeyword_5()); 
            }
            match(input,36,FOLLOW_36_in_rule__RuleDependency__Group__5__Impl8138); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getCommaKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__5__Impl"


    // $ANTLR start "rule__RuleDependency__Group__6"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4084:1: rule__RuleDependency__Group__6 : rule__RuleDependency__Group__6__Impl rule__RuleDependency__Group__7 ;
    public final void rule__RuleDependency__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4088:1: ( rule__RuleDependency__Group__6__Impl rule__RuleDependency__Group__7 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4089:2: rule__RuleDependency__Group__6__Impl rule__RuleDependency__Group__7
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group__6__Impl_in_rule__RuleDependency__Group__68169);
            rule__RuleDependency__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependency__Group__7_in_rule__RuleDependency__Group__68172);
            rule__RuleDependency__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__6"


    // $ANTLR start "rule__RuleDependency__Group__6__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4096:1: rule__RuleDependency__Group__6__Impl : ( '{' ) ;
    public final void rule__RuleDependency__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4100:1: ( ( '{' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4101:1: ( '{' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4101:1: ( '{' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4102:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getLeftCurlyBracketKeyword_6()); 
            }
            match(input,29,FOLLOW_29_in_rule__RuleDependency__Group__6__Impl8200); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getLeftCurlyBracketKeyword_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__6__Impl"


    // $ANTLR start "rule__RuleDependency__Group__7"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4115:1: rule__RuleDependency__Group__7 : rule__RuleDependency__Group__7__Impl rule__RuleDependency__Group__8 ;
    public final void rule__RuleDependency__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4119:1: ( rule__RuleDependency__Group__7__Impl rule__RuleDependency__Group__8 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4120:2: rule__RuleDependency__Group__7__Impl rule__RuleDependency__Group__8
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group__7__Impl_in_rule__RuleDependency__Group__78231);
            rule__RuleDependency__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependency__Group__8_in_rule__RuleDependency__Group__78234);
            rule__RuleDependency__Group__8();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__7"


    // $ANTLR start "rule__RuleDependency__Group__7__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4127:1: rule__RuleDependency__Group__7__Impl : ( ( rule__RuleDependency__FieldNamesAssignment_7 ) ) ;
    public final void rule__RuleDependency__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4131:1: ( ( ( rule__RuleDependency__FieldNamesAssignment_7 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4132:1: ( ( rule__RuleDependency__FieldNamesAssignment_7 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4132:1: ( ( rule__RuleDependency__FieldNamesAssignment_7 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4133:1: ( rule__RuleDependency__FieldNamesAssignment_7 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getFieldNamesAssignment_7()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4134:1: ( rule__RuleDependency__FieldNamesAssignment_7 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4134:2: rule__RuleDependency__FieldNamesAssignment_7
            {
            pushFollow(FOLLOW_rule__RuleDependency__FieldNamesAssignment_7_in_rule__RuleDependency__Group__7__Impl8261);
            rule__RuleDependency__FieldNamesAssignment_7();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getFieldNamesAssignment_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__7__Impl"


    // $ANTLR start "rule__RuleDependency__Group__8"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4144:1: rule__RuleDependency__Group__8 : rule__RuleDependency__Group__8__Impl rule__RuleDependency__Group__9 ;
    public final void rule__RuleDependency__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4148:1: ( rule__RuleDependency__Group__8__Impl rule__RuleDependency__Group__9 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4149:2: rule__RuleDependency__Group__8__Impl rule__RuleDependency__Group__9
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group__8__Impl_in_rule__RuleDependency__Group__88291);
            rule__RuleDependency__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependency__Group__9_in_rule__RuleDependency__Group__88294);
            rule__RuleDependency__Group__9();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__8"


    // $ANTLR start "rule__RuleDependency__Group__8__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4156:1: rule__RuleDependency__Group__8__Impl : ( ( rule__RuleDependency__Group_8__0 )* ) ;
    public final void rule__RuleDependency__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4160:1: ( ( ( rule__RuleDependency__Group_8__0 )* ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4161:1: ( ( rule__RuleDependency__Group_8__0 )* )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4161:1: ( ( rule__RuleDependency__Group_8__0 )* )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4162:1: ( rule__RuleDependency__Group_8__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getGroup_8()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4163:1: ( rule__RuleDependency__Group_8__0 )*
            loop21:
            do {
                int alt21=2;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==36) ) {
                    alt21=1;
                }


                switch (alt21) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4163:2: rule__RuleDependency__Group_8__0
            	    {
            	    pushFollow(FOLLOW_rule__RuleDependency__Group_8__0_in_rule__RuleDependency__Group__8__Impl8321);
            	    rule__RuleDependency__Group_8__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop21;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getGroup_8()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__8__Impl"


    // $ANTLR start "rule__RuleDependency__Group__9"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4173:1: rule__RuleDependency__Group__9 : rule__RuleDependency__Group__9__Impl rule__RuleDependency__Group__10 ;
    public final void rule__RuleDependency__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4177:1: ( rule__RuleDependency__Group__9__Impl rule__RuleDependency__Group__10 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4178:2: rule__RuleDependency__Group__9__Impl rule__RuleDependency__Group__10
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group__9__Impl_in_rule__RuleDependency__Group__98352);
            rule__RuleDependency__Group__9__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependency__Group__10_in_rule__RuleDependency__Group__98355);
            rule__RuleDependency__Group__10();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__9"


    // $ANTLR start "rule__RuleDependency__Group__9__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4185:1: rule__RuleDependency__Group__9__Impl : ( '}' ) ;
    public final void rule__RuleDependency__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4189:1: ( ( '}' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4190:1: ( '}' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4190:1: ( '}' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4191:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getRightCurlyBracketKeyword_9()); 
            }
            match(input,31,FOLLOW_31_in_rule__RuleDependency__Group__9__Impl8383); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getRightCurlyBracketKeyword_9()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__9__Impl"


    // $ANTLR start "rule__RuleDependency__Group__10"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4204:1: rule__RuleDependency__Group__10 : rule__RuleDependency__Group__10__Impl ;
    public final void rule__RuleDependency__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4208:1: ( rule__RuleDependency__Group__10__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4209:2: rule__RuleDependency__Group__10__Impl
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group__10__Impl_in_rule__RuleDependency__Group__108414);
            rule__RuleDependency__Group__10__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__10"


    // $ANTLR start "rule__RuleDependency__Group__10__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4215:1: rule__RuleDependency__Group__10__Impl : ( ')' ) ;
    public final void rule__RuleDependency__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4219:1: ( ( ')' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4220:1: ( ')' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4220:1: ( ')' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4221:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getRightParenthesisKeyword_10()); 
            }
            match(input,41,FOLLOW_41_in_rule__RuleDependency__Group__10__Impl8442); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getRightParenthesisKeyword_10()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group__10__Impl"


    // $ANTLR start "rule__RuleDependency__Group_8__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4256:1: rule__RuleDependency__Group_8__0 : rule__RuleDependency__Group_8__0__Impl rule__RuleDependency__Group_8__1 ;
    public final void rule__RuleDependency__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4260:1: ( rule__RuleDependency__Group_8__0__Impl rule__RuleDependency__Group_8__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4261:2: rule__RuleDependency__Group_8__0__Impl rule__RuleDependency__Group_8__1
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_8__0__Impl_in_rule__RuleDependency__Group_8__08495);
            rule__RuleDependency__Group_8__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__RuleDependency__Group_8__1_in_rule__RuleDependency__Group_8__08498);
            rule__RuleDependency__Group_8__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group_8__0"


    // $ANTLR start "rule__RuleDependency__Group_8__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4268:1: rule__RuleDependency__Group_8__0__Impl : ( ',' ) ;
    public final void rule__RuleDependency__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4272:1: ( ( ',' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4273:1: ( ',' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4273:1: ( ',' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4274:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getCommaKeyword_8_0()); 
            }
            match(input,36,FOLLOW_36_in_rule__RuleDependency__Group_8__0__Impl8526); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getCommaKeyword_8_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group_8__0__Impl"


    // $ANTLR start "rule__RuleDependency__Group_8__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4287:1: rule__RuleDependency__Group_8__1 : rule__RuleDependency__Group_8__1__Impl ;
    public final void rule__RuleDependency__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4291:1: ( rule__RuleDependency__Group_8__1__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4292:2: rule__RuleDependency__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_8__1__Impl_in_rule__RuleDependency__Group_8__18557);
            rule__RuleDependency__Group_8__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group_8__1"


    // $ANTLR start "rule__RuleDependency__Group_8__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4298:1: rule__RuleDependency__Group_8__1__Impl : ( ( rule__RuleDependency__FieldNamesAssignment_8_1 ) ) ;
    public final void rule__RuleDependency__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4302:1: ( ( ( rule__RuleDependency__FieldNamesAssignment_8_1 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4303:1: ( ( rule__RuleDependency__FieldNamesAssignment_8_1 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4303:1: ( ( rule__RuleDependency__FieldNamesAssignment_8_1 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4304:1: ( rule__RuleDependency__FieldNamesAssignment_8_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getFieldNamesAssignment_8_1()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4305:1: ( rule__RuleDependency__FieldNamesAssignment_8_1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4305:2: rule__RuleDependency__FieldNamesAssignment_8_1
            {
            pushFollow(FOLLOW_rule__RuleDependency__FieldNamesAssignment_8_1_in_rule__RuleDependency__Group_8__1__Impl8584);
            rule__RuleDependency__FieldNamesAssignment_8_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getFieldNamesAssignment_8_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group_8__1__Impl"


    // $ANTLR start "rule__EInt__Group__0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4319:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4323:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4324:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
            {
            pushFollow(FOLLOW_rule__EInt__Group__0__Impl_in_rule__EInt__Group__08618);
            rule__EInt__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__EInt__Group__1_in_rule__EInt__Group__08621);
            rule__EInt__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0"


    // $ANTLR start "rule__EInt__Group__0__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4331:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4335:1: ( ( ( '-' )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4336:1: ( ( '-' )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4336:1: ( ( '-' )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4337:1: ( '-' )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4338:1: ( '-' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==46) ) {
                alt22=1;
            }
            switch (alt22) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4339:2: '-'
                    {
                    match(input,46,FOLLOW_46_in_rule__EInt__Group__0__Impl8650); if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__0__Impl"


    // $ANTLR start "rule__EInt__Group__1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4350:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4354:1: ( rule__EInt__Group__1__Impl )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4355:2: rule__EInt__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EInt__Group__1__Impl_in_rule__EInt__Group__18683);
            rule__EInt__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1"


    // $ANTLR start "rule__EInt__Group__1__Impl"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4361:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4365:1: ( ( RULE_INT ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4366:1: ( RULE_INT )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4366:1: ( RULE_INT )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4367:1: RULE_INT
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
            }
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__EInt__Group__1__Impl8710); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__EInt__Group__1__Impl"


    // $ANTLR start "rule__TrcSpecification__ModuleListAssignment_0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4383:1: rule__TrcSpecification__ModuleListAssignment_0 : ( ruleModuleList ) ;
    public final void rule__TrcSpecification__ModuleListAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4387:1: ( ( ruleModuleList ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4388:1: ( ruleModuleList )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4388:1: ( ruleModuleList )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4389:1: ruleModuleList
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrcSpecificationAccess().getModuleListModuleListParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleModuleList_in_rule__TrcSpecification__ModuleListAssignment_08748);
            ruleModuleList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrcSpecificationAccess().getModuleListModuleListParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrcSpecification__ModuleListAssignment_0"


    // $ANTLR start "rule__TrcSpecification__TransformationListAssignment_1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4398:1: rule__TrcSpecification__TransformationListAssignment_1 : ( ruleTransformationList ) ;
    public final void rule__TrcSpecification__TransformationListAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4402:1: ( ( ruleTransformationList ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4403:1: ( ruleTransformationList )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4403:1: ( ruleTransformationList )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4404:1: ruleTransformationList
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrcSpecificationAccess().getTransformationListTransformationListParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleTransformationList_in_rule__TrcSpecification__TransformationListAssignment_18779);
            ruleTransformationList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrcSpecificationAccess().getTransformationListTransformationListParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrcSpecification__TransformationListAssignment_1"


    // $ANTLR start "rule__TrcSpecification__DependencyListAssignment_2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4413:1: rule__TrcSpecification__DependencyListAssignment_2 : ( ruleTransformationDependencyList ) ;
    public final void rule__TrcSpecification__DependencyListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4417:1: ( ( ruleTransformationDependencyList ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4418:1: ( ruleTransformationDependencyList )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4418:1: ( ruleTransformationDependencyList )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4419:1: ruleTransformationDependencyList
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrcSpecificationAccess().getDependencyListTransformationDependencyListParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleTransformationDependencyList_in_rule__TrcSpecification__DependencyListAssignment_28810);
            ruleTransformationDependencyList();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrcSpecificationAccess().getDependencyListTransformationDependencyListParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrcSpecification__DependencyListAssignment_2"


    // $ANTLR start "rule__TrcRule__NameAssignment"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4428:1: rule__TrcRule__NameAssignment : ( ruleEString ) ;
    public final void rule__TrcRule__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4432:1: ( ( ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4433:1: ( ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4433:1: ( ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4434:1: ruleEString
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTrcRuleAccess().getNameEStringParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleEString_in_rule__TrcRule__NameAssignment8841);
            ruleEString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTrcRuleAccess().getNameEStringParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrcRule__NameAssignment"


    // $ANTLR start "rule__ModuleList__ModulesAssignment_2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4443:1: rule__ModuleList__ModulesAssignment_2 : ( ruleModule ) ;
    public final void rule__ModuleList__ModulesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4447:1: ( ( ruleModule ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4448:1: ( ruleModule )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4448:1: ( ruleModule )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4449:1: ruleModule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleListAccess().getModulesModuleParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleModule_in_rule__ModuleList__ModulesAssignment_28872);
            ruleModule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleListAccess().getModulesModuleParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__ModulesAssignment_2"


    // $ANTLR start "rule__ModuleList__ModulesAssignment_4_0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4458:1: rule__ModuleList__ModulesAssignment_4_0 : ( ruleModule ) ;
    public final void rule__ModuleList__ModulesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4462:1: ( ( ruleModule ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4463:1: ( ruleModule )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4463:1: ( ruleModule )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4464:1: ruleModule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleListAccess().getModulesModuleParserRuleCall_4_0_0()); 
            }
            pushFollow(FOLLOW_ruleModule_in_rule__ModuleList__ModulesAssignment_4_08903);
            ruleModule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleListAccess().getModulesModuleParserRuleCall_4_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__ModulesAssignment_4_0"


    // $ANTLR start "rule__Module__NameAssignment_0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4473:1: rule__Module__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Module__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4477:1: ( ( ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4478:1: ( ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4478:1: ( ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4479:1: ruleEString
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getNameEStringParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleEString_in_rule__Module__NameAssignment_08934);
            ruleEString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getNameEStringParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__NameAssignment_0"


    // $ANTLR start "rule__Module__PathAssignment_2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4488:1: rule__Module__PathAssignment_2 : ( ruleEString ) ;
    public final void rule__Module__PathAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4492:1: ( ( ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4493:1: ( ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4493:1: ( ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4494:1: ruleEString
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getPathEStringParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleEString_in_rule__Module__PathAssignment_28965);
            ruleEString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getPathEStringParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__PathAssignment_2"


    // $ANTLR start "rule__Module__RulesAssignment_4_1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4503:1: rule__Module__RulesAssignment_4_1 : ( ruleTrcRule ) ;
    public final void rule__Module__RulesAssignment_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4507:1: ( ( ruleTrcRule ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4508:1: ( ruleTrcRule )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4508:1: ( ruleTrcRule )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4509:1: ruleTrcRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getRulesTrcRuleParserRuleCall_4_1_0()); 
            }
            pushFollow(FOLLOW_ruleTrcRule_in_rule__Module__RulesAssignment_4_18996);
            ruleTrcRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getRulesTrcRuleParserRuleCall_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__RulesAssignment_4_1"


    // $ANTLR start "rule__Module__RulesAssignment_4_2_1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4518:1: rule__Module__RulesAssignment_4_2_1 : ( ruleTrcRule ) ;
    public final void rule__Module__RulesAssignment_4_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4522:1: ( ( ruleTrcRule ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4523:1: ( ruleTrcRule )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4523:1: ( ruleTrcRule )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4524:1: ruleTrcRule
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getModuleAccess().getRulesTrcRuleParserRuleCall_4_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleTrcRule_in_rule__Module__RulesAssignment_4_2_19027);
            ruleTrcRule();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getModuleAccess().getRulesTrcRuleParserRuleCall_4_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__RulesAssignment_4_2_1"


    // $ANTLR start "rule__TransformationList__TransformationsAssignment_2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4533:1: rule__TransformationList__TransformationsAssignment_2 : ( ruleTransformation ) ;
    public final void rule__TransformationList__TransformationsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4537:1: ( ( ruleTransformation ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4538:1: ( ruleTransformation )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4538:1: ( ruleTransformation )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4539:1: ruleTransformation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationListAccess().getTransformationsTransformationParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleTransformation_in_rule__TransformationList__TransformationsAssignment_29058);
            ruleTransformation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationListAccess().getTransformationsTransformationParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationList__TransformationsAssignment_2"


    // $ANTLR start "rule__TransformationList__TransformationsAssignment_3_1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4548:1: rule__TransformationList__TransformationsAssignment_3_1 : ( ruleTransformation ) ;
    public final void rule__TransformationList__TransformationsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4552:1: ( ( ruleTransformation ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4553:1: ( ruleTransformation )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4553:1: ( ruleTransformation )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4554:1: ruleTransformation
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationListAccess().getTransformationsTransformationParserRuleCall_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleTransformation_in_rule__TransformationList__TransformationsAssignment_3_19089);
            ruleTransformation();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationListAccess().getTransformationsTransformationParserRuleCall_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationList__TransformationsAssignment_3_1"


    // $ANTLR start "rule__Transformation__NameAssignment_0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4563:1: rule__Transformation__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Transformation__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4567:1: ( ( ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4568:1: ( ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4568:1: ( ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4569:1: ruleEString
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getNameEStringParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleEString_in_rule__Transformation__NameAssignment_09120);
            ruleEString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getNameEStringParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__NameAssignment_0"


    // $ANTLR start "rule__Transformation__ModulesAssignment_4"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4578:1: rule__Transformation__ModulesAssignment_4 : ( ( RULE_ID ) ) ;
    public final void rule__Transformation__ModulesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4582:1: ( ( ( RULE_ID ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4583:1: ( ( RULE_ID ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4583:1: ( ( RULE_ID ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4584:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getModulesModuleCrossReference_4_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4585:1: ( RULE_ID )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4586:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getModulesModuleIDTerminalRuleCall_4_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Transformation__ModulesAssignment_49155); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getModulesModuleIDTerminalRuleCall_4_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getModulesModuleCrossReference_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__ModulesAssignment_4"


    // $ANTLR start "rule__Transformation__ModulesAssignment_5_1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4597:1: rule__Transformation__ModulesAssignment_5_1 : ( ( RULE_ID ) ) ;
    public final void rule__Transformation__ModulesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4601:1: ( ( ( RULE_ID ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4602:1: ( ( RULE_ID ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4602:1: ( ( RULE_ID ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4603:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getModulesModuleCrossReference_5_1_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4604:1: ( RULE_ID )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4605:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getModulesModuleIDTerminalRuleCall_5_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__Transformation__ModulesAssignment_5_19194); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getModulesModuleIDTerminalRuleCall_5_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getModulesModuleCrossReference_5_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__ModulesAssignment_5_1"


    // $ANTLR start "rule__Transformation__ImpactsAssignment_6_2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4616:1: rule__Transformation__ImpactsAssignment_6_2 : ( ruleTransformationImpact ) ;
    public final void rule__Transformation__ImpactsAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4620:1: ( ( ruleTransformationImpact ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4621:1: ( ruleTransformationImpact )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4621:1: ( ruleTransformationImpact )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4622:1: ruleTransformationImpact
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getImpactsTransformationImpactParserRuleCall_6_2_0()); 
            }
            pushFollow(FOLLOW_ruleTransformationImpact_in_rule__Transformation__ImpactsAssignment_6_29229);
            ruleTransformationImpact();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getImpactsTransformationImpactParserRuleCall_6_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__ImpactsAssignment_6_2"


    // $ANTLR start "rule__Transformation__ImpactsAssignment_6_3_1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4631:1: rule__Transformation__ImpactsAssignment_6_3_1 : ( ruleTransformationImpact ) ;
    public final void rule__Transformation__ImpactsAssignment_6_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4635:1: ( ( ruleTransformationImpact ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4636:1: ( ruleTransformationImpact )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4636:1: ( ruleTransformationImpact )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4637:1: ruleTransformationImpact
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationAccess().getImpactsTransformationImpactParserRuleCall_6_3_1_0()); 
            }
            pushFollow(FOLLOW_ruleTransformationImpact_in_rule__Transformation__ImpactsAssignment_6_3_19260);
            ruleTransformationImpact();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationAccess().getImpactsTransformationImpactParserRuleCall_6_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Transformation__ImpactsAssignment_6_3_1"


    // $ANTLR start "rule__TransformationImpact__QualityAttributeNameAssignment_1_0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4646:1: rule__TransformationImpact__QualityAttributeNameAssignment_1_0 : ( ruleEString ) ;
    public final void rule__TransformationImpact__QualityAttributeNameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4650:1: ( ( ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4651:1: ( ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4651:1: ( ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4652:1: ruleEString
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationImpactAccess().getQualityAttributeNameEStringParserRuleCall_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleEString_in_rule__TransformationImpact__QualityAttributeNameAssignment_1_09291);
            ruleEString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationImpactAccess().getQualityAttributeNameEStringParserRuleCall_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationImpact__QualityAttributeNameAssignment_1_0"


    // $ANTLR start "rule__TransformationImpact__ImpactValueAssignment_2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4661:1: rule__TransformationImpact__ImpactValueAssignment_2 : ( ruleEInt ) ;
    public final void rule__TransformationImpact__ImpactValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4665:1: ( ( ruleEInt ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4666:1: ( ruleEInt )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4666:1: ( ruleEInt )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4667:1: ruleEInt
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationImpactAccess().getImpactValueEIntParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleEInt_in_rule__TransformationImpact__ImpactValueAssignment_29322);
            ruleEInt();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationImpactAccess().getImpactValueEIntParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationImpact__ImpactValueAssignment_2"


    // $ANTLR start "rule__TransformationDependencyList__TransformationDependenciesAssignment_2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4676:1: rule__TransformationDependencyList__TransformationDependenciesAssignment_2 : ( ruleTransformationDependency ) ;
    public final void rule__TransformationDependencyList__TransformationDependenciesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4680:1: ( ( ruleTransformationDependency ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4681:1: ( ruleTransformationDependency )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4681:1: ( ruleTransformationDependency )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4682:1: ruleTransformationDependency
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesTransformationDependencyParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleTransformationDependency_in_rule__TransformationDependencyList__TransformationDependenciesAssignment_29353);
            ruleTransformationDependency();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesTransformationDependencyParserRuleCall_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__TransformationDependenciesAssignment_2"


    // $ANTLR start "rule__TransformationDependencyList__TransformationDependenciesAssignment_4_0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4691:1: rule__TransformationDependencyList__TransformationDependenciesAssignment_4_0 : ( ruleTransformationDependency ) ;
    public final void rule__TransformationDependencyList__TransformationDependenciesAssignment_4_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4695:1: ( ( ruleTransformationDependency ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4696:1: ( ruleTransformationDependency )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4696:1: ( ruleTransformationDependency )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4697:1: ruleTransformationDependency
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesTransformationDependencyParserRuleCall_4_0_0()); 
            }
            pushFollow(FOLLOW_ruleTransformationDependency_in_rule__TransformationDependencyList__TransformationDependenciesAssignment_4_09384);
            ruleTransformationDependency();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesTransformationDependencyParserRuleCall_4_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__TransformationDependenciesAssignment_4_0"


    // $ANTLR start "rule__TransformationDependency__AppliedTransformationAssignment_2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4706:1: rule__TransformationDependency__AppliedTransformationAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__TransformationDependency__AppliedTransformationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4710:1: ( ( ( ruleEString ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4711:1: ( ( ruleEString ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4711:1: ( ( ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4712:1: ( ruleEString )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationTransformationCrossReference_2_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4713:1: ( ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4714:1: ruleEString
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationTransformationEStringParserRuleCall_2_0_1()); 
            }
            pushFollow(FOLLOW_ruleEString_in_rule__TransformationDependency__AppliedTransformationAssignment_29419);
            ruleEString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationTransformationEStringParserRuleCall_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationTransformationCrossReference_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__AppliedTransformationAssignment_2"


    // $ANTLR start "rule__TransformationDependency__AppliedRuleAssignment_4"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4725:1: rule__TransformationDependency__AppliedRuleAssignment_4 : ( ( ruleQualifiedName ) ) ;
    public final void rule__TransformationDependency__AppliedRuleAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4729:1: ( ( ( ruleQualifiedName ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4730:1: ( ( ruleQualifiedName ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4730:1: ( ( ruleQualifiedName ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4731:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getAppliedRuleTrcRuleCrossReference_4_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4732:1: ( ruleQualifiedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4733:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getAppliedRuleTrcRuleQualifiedNameParserRuleCall_4_0_1()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TransformationDependency__AppliedRuleAssignment_49458);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getAppliedRuleTrcRuleQualifiedNameParserRuleCall_4_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getAppliedRuleTrcRuleCrossReference_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__AppliedRuleAssignment_4"


    // $ANTLR start "rule__TransformationDependency__VariableIdAssignment_7"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4744:1: rule__TransformationDependency__VariableIdAssignment_7 : ( ruleEString ) ;
    public final void rule__TransformationDependency__VariableIdAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4748:1: ( ( ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4749:1: ( ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4749:1: ( ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4750:1: ruleEString
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getVariableIdEStringParserRuleCall_7_0()); 
            }
            pushFollow(FOLLOW_ruleEString_in_rule__TransformationDependency__VariableIdAssignment_79493);
            ruleEString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getVariableIdEStringParserRuleCall_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__VariableIdAssignment_7"


    // $ANTLR start "rule__TransformationDependency__VariableIdAssignment_8_1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4759:1: rule__TransformationDependency__VariableIdAssignment_8_1 : ( ruleEString ) ;
    public final void rule__TransformationDependency__VariableIdAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4763:1: ( ( ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4764:1: ( ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4764:1: ( ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4765:1: ruleEString
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getVariableIdEStringParserRuleCall_8_1_0()); 
            }
            pushFollow(FOLLOW_ruleEString_in_rule__TransformationDependency__VariableIdAssignment_8_19524);
            ruleEString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getVariableIdEStringParserRuleCall_8_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__VariableIdAssignment_8_1"


    // $ANTLR start "rule__TransformationDependency__RequiredTransformationsAssignment_12"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4774:1: rule__TransformationDependency__RequiredTransformationsAssignment_12 : ( ruleAbstractRuleDependency ) ;
    public final void rule__TransformationDependency__RequiredTransformationsAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4778:1: ( ( ruleAbstractRuleDependency ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4779:1: ( ruleAbstractRuleDependency )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4779:1: ( ruleAbstractRuleDependency )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4780:1: ruleAbstractRuleDependency
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_0()); 
            }
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_rule__TransformationDependency__RequiredTransformationsAssignment_129555);
            ruleAbstractRuleDependency();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__RequiredTransformationsAssignment_12"


    // $ANTLR start "rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4789:1: rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_0 : ( ruleAbstractRuleDependency ) ;
    public final void rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4793:1: ( ( ruleAbstractRuleDependency ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4794:1: ( ruleAbstractRuleDependency )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4794:1: ( ruleAbstractRuleDependency )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4795:1: ruleAbstractRuleDependency
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyDisjunctionAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_09586);
            ruleAbstractRuleDependency();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyDisjunctionAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_0"


    // $ANTLR start "rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_1_1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4804:1: rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_1_1 : ( ruleAbstractRuleDependency ) ;
    public final void rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4808:1: ( ( ruleAbstractRuleDependency ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4809:1: ( ruleAbstractRuleDependency )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4809:1: ( ruleAbstractRuleDependency )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4810:1: ruleAbstractRuleDependency
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyDisjunctionAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_1_19617);
            ruleAbstractRuleDependency();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyDisjunctionAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_1_1"


    // $ANTLR start "rule__RuleDependencyConjunction__RequiredTransformationsAssignment_0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4819:1: rule__RuleDependencyConjunction__RequiredTransformationsAssignment_0 : ( ruleAbstractRuleDependency ) ;
    public final void rule__RuleDependencyConjunction__RequiredTransformationsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4823:1: ( ( ruleAbstractRuleDependency ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4824:1: ( ruleAbstractRuleDependency )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4824:1: ( ruleAbstractRuleDependency )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4825:1: ruleAbstractRuleDependency
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyConjunctionAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_rule__RuleDependencyConjunction__RequiredTransformationsAssignment_09648);
            ruleAbstractRuleDependency();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyConjunctionAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyConjunction__RequiredTransformationsAssignment_0"


    // $ANTLR start "rule__RuleDependencyConjunction__RequiredTransformationsAssignment_1_1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4834:1: rule__RuleDependencyConjunction__RequiredTransformationsAssignment_1_1 : ( ruleAbstractRuleDependency ) ;
    public final void rule__RuleDependencyConjunction__RequiredTransformationsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4838:1: ( ( ruleAbstractRuleDependency ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4839:1: ( ruleAbstractRuleDependency )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4839:1: ( ruleAbstractRuleDependency )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4840:1: ruleAbstractRuleDependency
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyConjunctionAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_rule__RuleDependencyConjunction__RequiredTransformationsAssignment_1_19679);
            ruleAbstractRuleDependency();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyConjunctionAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependencyConjunction__RequiredTransformationsAssignment_1_1"


    // $ANTLR start "rule__RuleDependency__TypeAssignment_0"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4849:1: rule__RuleDependency__TypeAssignment_0 : ( ( rule__RuleDependency__TypeAlternatives_0_0 ) ) ;
    public final void rule__RuleDependency__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4853:1: ( ( ( rule__RuleDependency__TypeAlternatives_0_0 ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4854:1: ( ( rule__RuleDependency__TypeAlternatives_0_0 ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4854:1: ( ( rule__RuleDependency__TypeAlternatives_0_0 ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4855:1: ( rule__RuleDependency__TypeAlternatives_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getTypeAlternatives_0_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4856:1: ( rule__RuleDependency__TypeAlternatives_0_0 )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4856:2: rule__RuleDependency__TypeAlternatives_0_0
            {
            pushFollow(FOLLOW_rule__RuleDependency__TypeAlternatives_0_0_in_rule__RuleDependency__TypeAssignment_09710);
            rule__RuleDependency__TypeAlternatives_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getTypeAlternatives_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__TypeAssignment_0"


    // $ANTLR start "rule__RuleDependency__RequiredTransformationAssignment_2"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4865:1: rule__RuleDependency__RequiredTransformationAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__RuleDependency__RequiredTransformationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4869:1: ( ( ( ruleEString ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4870:1: ( ( ruleEString ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4870:1: ( ( ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4871:1: ( ruleEString )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getRequiredTransformationTransformationCrossReference_2_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4872:1: ( ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4873:1: ruleEString
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getRequiredTransformationTransformationEStringParserRuleCall_2_0_1()); 
            }
            pushFollow(FOLLOW_ruleEString_in_rule__RuleDependency__RequiredTransformationAssignment_29747);
            ruleEString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getRequiredTransformationTransformationEStringParserRuleCall_2_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getRequiredTransformationTransformationCrossReference_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__RequiredTransformationAssignment_2"


    // $ANTLR start "rule__RuleDependency__RequiredRuleAssignment_4"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4884:1: rule__RuleDependency__RequiredRuleAssignment_4 : ( ( ruleQualifiedName ) ) ;
    public final void rule__RuleDependency__RequiredRuleAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4888:1: ( ( ( ruleQualifiedName ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4889:1: ( ( ruleQualifiedName ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4889:1: ( ( ruleQualifiedName ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4890:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getRequiredRuleTrcRuleCrossReference_4_0()); 
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4891:1: ( ruleQualifiedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4892:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getRequiredRuleTrcRuleQualifiedNameParserRuleCall_4_0_1()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__RuleDependency__RequiredRuleAssignment_49786);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getRequiredRuleTrcRuleQualifiedNameParserRuleCall_4_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getRequiredRuleTrcRuleCrossReference_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__RequiredRuleAssignment_4"


    // $ANTLR start "rule__RuleDependency__FieldNamesAssignment_7"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4903:1: rule__RuleDependency__FieldNamesAssignment_7 : ( ruleEString ) ;
    public final void rule__RuleDependency__FieldNamesAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4907:1: ( ( ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4908:1: ( ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4908:1: ( ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4909:1: ruleEString
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getFieldNamesEStringParserRuleCall_7_0()); 
            }
            pushFollow(FOLLOW_ruleEString_in_rule__RuleDependency__FieldNamesAssignment_79821);
            ruleEString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getFieldNamesEStringParserRuleCall_7_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__FieldNamesAssignment_7"


    // $ANTLR start "rule__RuleDependency__FieldNamesAssignment_8_1"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4918:1: rule__RuleDependency__FieldNamesAssignment_8_1 : ( ruleEString ) ;
    public final void rule__RuleDependency__FieldNamesAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4922:1: ( ( ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4923:1: ( ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4923:1: ( ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:4924:1: ruleEString
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getRuleDependencyAccess().getFieldNamesEStringParserRuleCall_8_1_0()); 
            }
            pushFollow(FOLLOW_ruleEString_in_rule__RuleDependency__FieldNamesAssignment_8_19852);
            ruleEString();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getRuleDependencyAccess().getFieldNamesEStringParserRuleCall_8_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__FieldNamesAssignment_8_1"

    // $ANTLR start synpred1_InternalTRC
    public final void synpred1_InternalTRC_fragment() throws RecognitionException {   
        // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:722:1: ( ( ( rule__RuleDependencyComposite__Group_0__0 ) ) )
        // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:722:1: ( ( rule__RuleDependencyComposite__Group_0__0 ) )
        {
        // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:722:1: ( ( rule__RuleDependencyComposite__Group_0__0 ) )
        // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:723:1: ( rule__RuleDependencyComposite__Group_0__0 )
        {
        if ( state.backtracking==0 ) {
           before(grammarAccess.getRuleDependencyCompositeAccess().getGroup_0()); 
        }
        // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:724:1: ( rule__RuleDependencyComposite__Group_0__0 )
        // ../fr.tpt.aadl.ramses.transformation.trc.xtext.ui/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/ui/contentassist/antlr/internal/InternalTRC.g:724:2: rule__RuleDependencyComposite__Group_0__0
        {
        pushFollow(FOLLOW_rule__RuleDependencyComposite__Group_0__0_in_synpred1_InternalTRC1465);
        rule__RuleDependencyComposite__Group_0__0();

        state._fsp--;
        if (state.failed) return ;

        }


        }


        }
    }
    // $ANTLR end synpred1_InternalTRC

    // Delegated rules

    public final boolean synpred1_InternalTRC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalTRC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleTrcSpecification_in_entryRuleTrcSpecification67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrcSpecification74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__0_in_ruleTrcSpecification100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrcRule_in_entryRuleTrcRule127 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrcRule134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcRule__NameAssignment_in_ruleTrcRule160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModuleList_in_entryRuleModuleList187 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModuleList194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__0_in_ruleModuleList220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__0_in_ruleModule340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationList_in_entryRuleTransformationList367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationList374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__0_in_ruleTransformationList400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformation_in_entryRuleTransformation427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformation434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__0_in_ruleTransformation460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_entryRuleTransformationImpact487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationImpact494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__0_in_ruleTransformationImpact520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependencyList_in_entryRuleTransformationDependencyList547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationDependencyList554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__0_in_ruleTransformationDependencyList580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_entryRuleTransformationDependency607 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationDependency614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__0_in_ruleTransformationDependency640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependencyDisjunction_in_entryRuleRuleDependencyDisjunction667 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDependencyDisjunction674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyDisjunction__Group__0_in_ruleRuleDependencyDisjunction700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependencyComposite_in_entryRuleRuleDependencyComposite727 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDependencyComposite734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyComposite__Alternatives_in_ruleRuleDependencyComposite760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependencyConjunction_in_entryRuleRuleDependencyConjunction787 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDependencyConjunction794 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyConjunction__Group__0_in_ruleRuleDependencyConjunction820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_entryRuleAbstractRuleDependency847 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRuleDependency854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__AbstractRuleDependency__Alternatives_in_ruleAbstractRuleDependency880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependency_in_entryRuleRuleDependency907 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDependency914 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__0_in_ruleRuleDependency940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_entryRuleEString971 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEString978 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EString__Alternatives_in_ruleEString1004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt1031 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEInt1038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EInt__Group__0_in_ruleEInt1064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName1093 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName1100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName1126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier1152 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier1159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier1185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName1211 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName1218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName1244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName1276 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName1283 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EssentialOCLUnreservedName__Alternatives_in_ruleEssentialOCLUnreservedName1309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier1336 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier1343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__PrimitiveTypeIdentifier__Alternatives_in_rulePrimitiveTypeIdentifier1369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier1396 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier1403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__CollectionTypeIdentifier__Alternatives_in_ruleCollectionTypeIdentifier1429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyComposite__Group_0__0_in_rule__RuleDependencyComposite__Alternatives1465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyComposite__Group_1__0_in_rule__RuleDependencyComposite__Alternatives1483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependencyComposite_in_rule__AbstractRuleDependency__Alternatives1516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependency_in_rule__AbstractRuleDependency__Alternatives1533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__RuleDependency__TypeAlternatives_0_01566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__RuleDependency__TypeAlternatives_0_01586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EString__Alternatives1620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EString__Alternatives1637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnrestrictedName_in_rule__EssentialOCLUnreservedName__Alternatives1670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_rule__EssentialOCLUnreservedName__Alternatives1687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_rule__EssentialOCLUnreservedName__Alternatives1704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__EssentialOCLUnreservedName__Alternatives1722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__PrimitiveTypeIdentifier__Alternatives1757 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__PrimitiveTypeIdentifier__Alternatives1777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__PrimitiveTypeIdentifier__Alternatives1797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__PrimitiveTypeIdentifier__Alternatives1817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__PrimitiveTypeIdentifier__Alternatives1837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__PrimitiveTypeIdentifier__Alternatives1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__PrimitiveTypeIdentifier__Alternatives1877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__PrimitiveTypeIdentifier__Alternatives1897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__CollectionTypeIdentifier__Alternatives1932 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__CollectionTypeIdentifier__Alternatives1952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__CollectionTypeIdentifier__Alternatives1972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__CollectionTypeIdentifier__Alternatives1992 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__CollectionTypeIdentifier__Alternatives2012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__0__Impl_in_rule__TrcSpecification__Group__02044 = new BitSet(new long[]{0x0000002000000000L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__1_in_rule__TrcSpecification__Group__02047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__ModuleListAssignment_0_in_rule__TrcSpecification__Group__0__Impl2074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__1__Impl_in_rule__TrcSpecification__Group__12104 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__2_in_rule__TrcSpecification__Group__12107 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__TransformationListAssignment_1_in_rule__TrcSpecification__Group__1__Impl2134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__2__Impl_in_rule__TrcSpecification__Group__22164 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__DependencyListAssignment_2_in_rule__TrcSpecification__Group__2__Impl2191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__0__Impl_in_rule__ModuleList__Group__02227 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__1_in_rule__ModuleList__Group__02230 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ModuleList__Group__0__Impl2258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__1__Impl_in_rule__ModuleList__Group__12289 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__2_in_rule__ModuleList__Group__12292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__ModuleList__Group__1__Impl2320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__2__Impl_in_rule__ModuleList__Group__22351 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__3_in_rule__ModuleList__Group__22354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__ModulesAssignment_2_in_rule__ModuleList__Group__2__Impl2381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__3__Impl_in_rule__ModuleList__Group__32411 = new BitSet(new long[]{0x0000000080000030L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__4_in_rule__ModuleList__Group__32414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ModuleList__Group__3__Impl2442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__4__Impl_in_rule__ModuleList__Group__42473 = new BitSet(new long[]{0x0000000080000030L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__5_in_rule__ModuleList__Group__42476 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group_4__0_in_rule__ModuleList__Group__4__Impl2503 = new BitSet(new long[]{0x0000000000000032L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__5__Impl_in_rule__ModuleList__Group__52534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__ModuleList__Group__5__Impl2562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group_4__0__Impl_in_rule__ModuleList__Group_4__02605 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__ModuleList__Group_4__1_in_rule__ModuleList__Group_4__02608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__ModulesAssignment_4_0_in_rule__ModuleList__Group_4__0__Impl2635 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group_4__1__Impl_in_rule__ModuleList__Group_4__12665 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__ModuleList__Group_4__1__Impl2693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02728 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl2758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl2814 = new BitSet(new long[]{0x0000000100000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__02849 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__02852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__QualifiedName__Group_1__0__Impl2880 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__12911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl2938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__0__Impl_in_rule__Module__Group__02971 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__Module__Group__1_in_rule__Module__Group__02974 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__NameAssignment_0_in_rule__Module__Group__0__Impl3001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__1__Impl_in_rule__Module__Group__13031 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Module__Group__2_in_rule__Module__Group__13034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__Module__Group__1__Impl3062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__2__Impl_in_rule__Module__Group__23093 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__Module__Group__3_in_rule__Module__Group__23096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__PathAssignment_2_in_rule__Module__Group__2__Impl3123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__3__Impl_in_rule__Module__Group__33153 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Module__Group__4_in_rule__Module__Group__33156 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__Module__Group__3__Impl3184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__4__Impl_in_rule__Module__Group__43215 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_4__0_in_rule__Module__Group__4__Impl3242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_4__0__Impl_in_rule__Module__Group_4__03283 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Module__Group_4__1_in_rule__Module__Group_4__03286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Module__Group_4__0__Impl3314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_4__1__Impl_in_rule__Module__Group_4__13345 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Module__Group_4__2_in_rule__Module__Group_4__13348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__RulesAssignment_4_1_in_rule__Module__Group_4__1__Impl3375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_4__2__Impl_in_rule__Module__Group_4__23405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_4_2__0_in_rule__Module__Group_4__2__Impl3432 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_4_2__0__Impl_in_rule__Module__Group_4_2__03469 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Module__Group_4_2__1_in_rule__Module__Group_4_2__03472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Module__Group_4_2__0__Impl3500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_4_2__1__Impl_in_rule__Module__Group_4_2__13531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__RulesAssignment_4_2_1_in_rule__Module__Group_4_2__1__Impl3558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__0__Impl_in_rule__TransformationList__Group__03592 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__1_in_rule__TransformationList__Group__03595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rule__TransformationList__Group__0__Impl3623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__1__Impl_in_rule__TransformationList__Group__13654 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__2_in_rule__TransformationList__Group__13657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__TransformationList__Group__1__Impl3685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__2__Impl_in_rule__TransformationList__Group__23716 = new BitSet(new long[]{0x0000001080000000L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__3_in_rule__TransformationList__Group__23719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__TransformationsAssignment_2_in_rule__TransformationList__Group__2__Impl3746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__3__Impl_in_rule__TransformationList__Group__33776 = new BitSet(new long[]{0x0000001080000000L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__4_in_rule__TransformationList__Group__33779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group_3__0_in_rule__TransformationList__Group__3__Impl3806 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__4__Impl_in_rule__TransformationList__Group__43837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__TransformationList__Group__4__Impl3865 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group_3__0__Impl_in_rule__TransformationList__Group_3__03906 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationList__Group_3__1_in_rule__TransformationList__Group_3__03909 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__TransformationList__Group_3__0__Impl3937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group_3__1__Impl_in_rule__TransformationList__Group_3__13968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__TransformationsAssignment_3_1_in_rule__TransformationList__Group_3__1__Impl3995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__0__Impl_in_rule__Transformation__Group__04029 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__1_in_rule__Transformation__Group__04032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__NameAssignment_0_in_rule__Transformation__Group__0__Impl4059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__1__Impl_in_rule__Transformation__Group__14089 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__2_in_rule__Transformation__Group__14092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__Transformation__Group__1__Impl4120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__2__Impl_in_rule__Transformation__Group__24151 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__3_in_rule__Transformation__Group__24154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rule__Transformation__Group__2__Impl4182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__3__Impl_in_rule__Transformation__Group__34213 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Transformation__Group__4_in_rule__Transformation__Group__34216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Transformation__Group__3__Impl4244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__4__Impl_in_rule__Transformation__Group__44275 = new BitSet(new long[]{0x0000009080000000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__5_in_rule__Transformation__Group__44278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__ModulesAssignment_4_in_rule__Transformation__Group__4__Impl4305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__5__Impl_in_rule__Transformation__Group__54335 = new BitSet(new long[]{0x0000009080000000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__6_in_rule__Transformation__Group__54338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_5__0_in_rule__Transformation__Group__5__Impl4365 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__6__Impl_in_rule__Transformation__Group__64396 = new BitSet(new long[]{0x0000009080000000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__7_in_rule__Transformation__Group__64399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__0_in_rule__Transformation__Group__6__Impl4426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__7__Impl_in_rule__Transformation__Group__74457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__Transformation__Group__7__Impl4485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_5__0__Impl_in_rule__Transformation__Group_5__04532 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__Transformation__Group_5__1_in_rule__Transformation__Group_5__04535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Transformation__Group_5__0__Impl4563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_5__1__Impl_in_rule__Transformation__Group_5__14594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__ModulesAssignment_5_1_in_rule__Transformation__Group_5__1__Impl4621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__0__Impl_in_rule__Transformation__Group_6__04655 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__1_in_rule__Transformation__Group_6__04658 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rule__Transformation__Group_6__0__Impl4686 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__1__Impl_in_rule__Transformation__Group_6__14717 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__2_in_rule__Transformation__Group_6__14720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rule__Transformation__Group_6__1__Impl4748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__2__Impl_in_rule__Transformation__Group_6__24779 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__3_in_rule__Transformation__Group_6__24782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__ImpactsAssignment_6_2_in_rule__Transformation__Group_6__2__Impl4809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__3__Impl_in_rule__Transformation__Group_6__34839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6_3__0_in_rule__Transformation__Group_6__3__Impl4866 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6_3__0__Impl_in_rule__Transformation__Group_6_3__04905 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6_3__1_in_rule__Transformation__Group_6_3__04908 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__Transformation__Group_6_3__0__Impl4936 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6_3__1__Impl_in_rule__Transformation__Group_6_3__14967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__ImpactsAssignment_6_3_1_in_rule__Transformation__Group_6_3__1__Impl4994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__0__Impl_in_rule__TransformationImpact__Group__05028 = new BitSet(new long[]{0x0000400000000070L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__1_in_rule__TransformationImpact__Group__05031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__TransformationImpact__Group__0__Impl5059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__1__Impl_in_rule__TransformationImpact__Group__15090 = new BitSet(new long[]{0x0000400000000070L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__2_in_rule__TransformationImpact__Group__15093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group_1__0_in_rule__TransformationImpact__Group__1__Impl5120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__2__Impl_in_rule__TransformationImpact__Group__25151 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__3_in_rule__TransformationImpact__Group__25154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__ImpactValueAssignment_2_in_rule__TransformationImpact__Group__2__Impl5181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__3__Impl_in_rule__TransformationImpact__Group__35211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__TransformationImpact__Group__3__Impl5239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group_1__0__Impl_in_rule__TransformationImpact__Group_1__05278 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group_1__1_in_rule__TransformationImpact__Group_1__05281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__QualityAttributeNameAssignment_1_0_in_rule__TransformationImpact__Group_1__0__Impl5308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group_1__1__Impl_in_rule__TransformationImpact__Group_1__15338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__TransformationImpact__Group_1__1__Impl5366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__0__Impl_in_rule__TransformationDependencyList__Group__05401 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__1_in_rule__TransformationDependencyList__Group__05404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_rule__TransformationDependencyList__Group__0__Impl5432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__1__Impl_in_rule__TransformationDependencyList__Group__15463 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__2_in_rule__TransformationDependencyList__Group__15466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__TransformationDependencyList__Group__1__Impl5494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__2__Impl_in_rule__TransformationDependencyList__Group__25525 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__3_in_rule__TransformationDependencyList__Group__25528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__TransformationDependenciesAssignment_2_in_rule__TransformationDependencyList__Group__2__Impl5555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__3__Impl_in_rule__TransformationDependencyList__Group__35585 = new BitSet(new long[]{0x0000080080000000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__4_in_rule__TransformationDependencyList__Group__35588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__TransformationDependencyList__Group__3__Impl5616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__4__Impl_in_rule__TransformationDependencyList__Group__45647 = new BitSet(new long[]{0x0000080080000000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__5_in_rule__TransformationDependencyList__Group__45650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group_4__0_in_rule__TransformationDependencyList__Group__4__Impl5677 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__5__Impl_in_rule__TransformationDependencyList__Group__55708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__TransformationDependencyList__Group__5__Impl5736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group_4__0__Impl_in_rule__TransformationDependencyList__Group_4__05779 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group_4__1_in_rule__TransformationDependencyList__Group_4__05782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__TransformationDependenciesAssignment_4_0_in_rule__TransformationDependencyList__Group_4__0__Impl5809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group_4__1__Impl_in_rule__TransformationDependencyList__Group_4__15839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__TransformationDependencyList__Group_4__1__Impl5867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__0__Impl_in_rule__TransformationDependency__Group__05902 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__1_in_rule__TransformationDependency__Group__05905 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_rule__TransformationDependency__Group__0__Impl5933 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__1__Impl_in_rule__TransformationDependency__Group__15964 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__2_in_rule__TransformationDependency__Group__15967 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__TransformationDependency__Group__1__Impl5995 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__2__Impl_in_rule__TransformationDependency__Group__26026 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__3_in_rule__TransformationDependency__Group__26029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__AppliedTransformationAssignment_2_in_rule__TransformationDependency__Group__2__Impl6056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__3__Impl_in_rule__TransformationDependency__Group__36086 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__4_in_rule__TransformationDependency__Group__36089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__TransformationDependency__Group__3__Impl6117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__4__Impl_in_rule__TransformationDependency__Group__46148 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__5_in_rule__TransformationDependency__Group__46151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__AppliedRuleAssignment_4_in_rule__TransformationDependency__Group__4__Impl6178 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__5__Impl_in_rule__TransformationDependency__Group__56208 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__6_in_rule__TransformationDependency__Group__56211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__TransformationDependency__Group__5__Impl6239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__6__Impl_in_rule__TransformationDependency__Group__66270 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__7_in_rule__TransformationDependency__Group__66273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__TransformationDependency__Group__6__Impl6301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__7__Impl_in_rule__TransformationDependency__Group__76332 = new BitSet(new long[]{0x0000001080000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__8_in_rule__TransformationDependency__Group__76335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__VariableIdAssignment_7_in_rule__TransformationDependency__Group__7__Impl6362 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__8__Impl_in_rule__TransformationDependency__Group__86392 = new BitSet(new long[]{0x0000001080000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__9_in_rule__TransformationDependency__Group__86395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_8__0_in_rule__TransformationDependency__Group__8__Impl6422 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__9__Impl_in_rule__TransformationDependency__Group__96453 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__10_in_rule__TransformationDependency__Group__96456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__TransformationDependency__Group__9__Impl6484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__10__Impl_in_rule__TransformationDependency__Group__106515 = new BitSet(new long[]{0x0000000200000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__11_in_rule__TransformationDependency__Group__106518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__TransformationDependency__Group__10__Impl6546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__11__Impl_in_rule__TransformationDependency__Group__116577 = new BitSet(new long[]{0x0000010000003000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__12_in_rule__TransformationDependency__Group__116580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__TransformationDependency__Group__11__Impl6608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__12__Impl_in_rule__TransformationDependency__Group__126639 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__13_in_rule__TransformationDependency__Group__126642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__RequiredTransformationsAssignment_12_in_rule__TransformationDependency__Group__12__Impl6669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__13__Impl_in_rule__TransformationDependency__Group__136699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rule__TransformationDependency__Group__13__Impl6727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_8__0__Impl_in_rule__TransformationDependency__Group_8__06786 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_8__1_in_rule__TransformationDependency__Group_8__06789 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__TransformationDependency__Group_8__0__Impl6817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_8__1__Impl_in_rule__TransformationDependency__Group_8__16848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__VariableIdAssignment_8_1_in_rule__TransformationDependency__Group_8__1__Impl6875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyDisjunction__Group__0__Impl_in_rule__RuleDependencyDisjunction__Group__06909 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_rule__RuleDependencyDisjunction__Group__1_in_rule__RuleDependencyDisjunction__Group__06912 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_0_in_rule__RuleDependencyDisjunction__Group__0__Impl6939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyDisjunction__Group__1__Impl_in_rule__RuleDependencyDisjunction__Group__16969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyDisjunction__Group_1__0_in_rule__RuleDependencyDisjunction__Group__1__Impl6998 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyDisjunction__Group_1__0_in_rule__RuleDependencyDisjunction__Group__1__Impl7010 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyDisjunction__Group_1__0__Impl_in_rule__RuleDependencyDisjunction__Group_1__07047 = new BitSet(new long[]{0x0000010000003000L});
    public static final BitSet FOLLOW_rule__RuleDependencyDisjunction__Group_1__1_in_rule__RuleDependencyDisjunction__Group_1__07050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_rule__RuleDependencyDisjunction__Group_1__0__Impl7078 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyDisjunction__Group_1__1__Impl_in_rule__RuleDependencyDisjunction__Group_1__17109 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_1_1_in_rule__RuleDependencyDisjunction__Group_1__1__Impl7136 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyComposite__Group_0__0__Impl_in_rule__RuleDependencyComposite__Group_0__07170 = new BitSet(new long[]{0x0000010000003000L});
    public static final BitSet FOLLOW_rule__RuleDependencyComposite__Group_0__1_in_rule__RuleDependencyComposite__Group_0__07173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__RuleDependencyComposite__Group_0__0__Impl7201 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyComposite__Group_0__1__Impl_in_rule__RuleDependencyComposite__Group_0__17232 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__RuleDependencyComposite__Group_0__2_in_rule__RuleDependencyComposite__Group_0__17235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependencyConjunction_in_rule__RuleDependencyComposite__Group_0__1__Impl7262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyComposite__Group_0__2__Impl_in_rule__RuleDependencyComposite__Group_0__27291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__RuleDependencyComposite__Group_0__2__Impl7319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyComposite__Group_1__0__Impl_in_rule__RuleDependencyComposite__Group_1__07356 = new BitSet(new long[]{0x0000010000003000L});
    public static final BitSet FOLLOW_rule__RuleDependencyComposite__Group_1__1_in_rule__RuleDependencyComposite__Group_1__07359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__RuleDependencyComposite__Group_1__0__Impl7387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyComposite__Group_1__1__Impl_in_rule__RuleDependencyComposite__Group_1__17418 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__RuleDependencyComposite__Group_1__2_in_rule__RuleDependencyComposite__Group_1__17421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependencyDisjunction_in_rule__RuleDependencyComposite__Group_1__1__Impl7448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyComposite__Group_1__2__Impl_in_rule__RuleDependencyComposite__Group_1__27477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__RuleDependencyComposite__Group_1__2__Impl7505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyConjunction__Group__0__Impl_in_rule__RuleDependencyConjunction__Group__07542 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_rule__RuleDependencyConjunction__Group__1_in_rule__RuleDependencyConjunction__Group__07545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyConjunction__RequiredTransformationsAssignment_0_in_rule__RuleDependencyConjunction__Group__0__Impl7572 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyConjunction__Group__1__Impl_in_rule__RuleDependencyConjunction__Group__17602 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyConjunction__Group_1__0_in_rule__RuleDependencyConjunction__Group__1__Impl7631 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyConjunction__Group_1__0_in_rule__RuleDependencyConjunction__Group__1__Impl7643 = new BitSet(new long[]{0x0000200000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyConjunction__Group_1__0__Impl_in_rule__RuleDependencyConjunction__Group_1__07680 = new BitSet(new long[]{0x0000010000003000L});
    public static final BitSet FOLLOW_rule__RuleDependencyConjunction__Group_1__1_in_rule__RuleDependencyConjunction__Group_1__07683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_rule__RuleDependencyConjunction__Group_1__0__Impl7711 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyConjunction__Group_1__1__Impl_in_rule__RuleDependencyConjunction__Group_1__17742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyConjunction__RequiredTransformationsAssignment_1_1_in_rule__RuleDependencyConjunction__Group_1__1__Impl7769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__0__Impl_in_rule__RuleDependency__Group__07803 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__1_in_rule__RuleDependency__Group__07806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__TypeAssignment_0_in_rule__RuleDependency__Group__0__Impl7833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__1__Impl_in_rule__RuleDependency__Group__17863 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__2_in_rule__RuleDependency__Group__17866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rule__RuleDependency__Group__1__Impl7894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__2__Impl_in_rule__RuleDependency__Group__27925 = new BitSet(new long[]{0x0000000100000000L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__3_in_rule__RuleDependency__Group__27928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__RequiredTransformationAssignment_2_in_rule__RuleDependency__Group__2__Impl7955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__3__Impl_in_rule__RuleDependency__Group__37985 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__4_in_rule__RuleDependency__Group__37988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__RuleDependency__Group__3__Impl8016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__4__Impl_in_rule__RuleDependency__Group__48047 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__5_in_rule__RuleDependency__Group__48050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__RequiredRuleAssignment_4_in_rule__RuleDependency__Group__4__Impl8077 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__5__Impl_in_rule__RuleDependency__Group__58107 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__6_in_rule__RuleDependency__Group__58110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__RuleDependency__Group__5__Impl8138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__6__Impl_in_rule__RuleDependency__Group__68169 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__7_in_rule__RuleDependency__Group__68172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__RuleDependency__Group__6__Impl8200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__7__Impl_in_rule__RuleDependency__Group__78231 = new BitSet(new long[]{0x0000001080000000L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__8_in_rule__RuleDependency__Group__78234 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__FieldNamesAssignment_7_in_rule__RuleDependency__Group__7__Impl8261 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__8__Impl_in_rule__RuleDependency__Group__88291 = new BitSet(new long[]{0x0000001080000000L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__9_in_rule__RuleDependency__Group__88294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_8__0_in_rule__RuleDependency__Group__8__Impl8321 = new BitSet(new long[]{0x0000001000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__9__Impl_in_rule__RuleDependency__Group__98352 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__10_in_rule__RuleDependency__Group__98355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__RuleDependency__Group__9__Impl8383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group__10__Impl_in_rule__RuleDependency__Group__108414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rule__RuleDependency__Group__10__Impl8442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_8__0__Impl_in_rule__RuleDependency__Group_8__08495 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_8__1_in_rule__RuleDependency__Group_8__08498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rule__RuleDependency__Group_8__0__Impl8526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_8__1__Impl_in_rule__RuleDependency__Group_8__18557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__FieldNamesAssignment_8_1_in_rule__RuleDependency__Group_8__1__Impl8584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EInt__Group__0__Impl_in_rule__EInt__Group__08618 = new BitSet(new long[]{0x0000400000000070L});
    public static final BitSet FOLLOW_rule__EInt__Group__1_in_rule__EInt__Group__08621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rule__EInt__Group__0__Impl8650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EInt__Group__1__Impl_in_rule__EInt__Group__18683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__EInt__Group__1__Impl8710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModuleList_in_rule__TrcSpecification__ModuleListAssignment_08748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationList_in_rule__TrcSpecification__TransformationListAssignment_18779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependencyList_in_rule__TrcSpecification__DependencyListAssignment_28810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TrcRule__NameAssignment8841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModule_in_rule__ModuleList__ModulesAssignment_28872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModule_in_rule__ModuleList__ModulesAssignment_4_08903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__Module__NameAssignment_08934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__Module__PathAssignment_28965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrcRule_in_rule__Module__RulesAssignment_4_18996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrcRule_in_rule__Module__RulesAssignment_4_2_19027 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformation_in_rule__TransformationList__TransformationsAssignment_29058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformation_in_rule__TransformationList__TransformationsAssignment_3_19089 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__Transformation__NameAssignment_09120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Transformation__ModulesAssignment_49155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__Transformation__ModulesAssignment_5_19194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_rule__Transformation__ImpactsAssignment_6_29229 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_rule__Transformation__ImpactsAssignment_6_3_19260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TransformationImpact__QualityAttributeNameAssignment_1_09291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_rule__TransformationImpact__ImpactValueAssignment_29322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_rule__TransformationDependencyList__TransformationDependenciesAssignment_29353 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_rule__TransformationDependencyList__TransformationDependenciesAssignment_4_09384 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TransformationDependency__AppliedTransformationAssignment_29419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TransformationDependency__AppliedRuleAssignment_49458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TransformationDependency__VariableIdAssignment_79493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TransformationDependency__VariableIdAssignment_8_19524 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_rule__TransformationDependency__RequiredTransformationsAssignment_129555 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_09586 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_rule__RuleDependencyDisjunction__RequiredTransformationsAssignment_1_19617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_rule__RuleDependencyConjunction__RequiredTransformationsAssignment_09648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_rule__RuleDependencyConjunction__RequiredTransformationsAssignment_1_19679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__TypeAlternatives_0_0_in_rule__RuleDependency__TypeAssignment_09710 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__RuleDependency__RequiredTransformationAssignment_29747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__RuleDependency__RequiredRuleAssignment_49786 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__RuleDependency__FieldNamesAssignment_79821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__RuleDependency__FieldNamesAssignment_8_19852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependencyComposite__Group_0__0_in_synpred1_InternalTRC1465 = new BitSet(new long[]{0x0000000000000002L});

}