package org.trc.xtext.dsl.ui.contentassist.antlr.internal; 

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
import org.trc.xtext.dsl.services.DslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDslParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'and'", "'or'", "'from'", "';'", "'Modules'", "'{'", "'}'", "'::'", "':'", "','", "'Transformations'", "'modules'", "'impacts'", "'('", "')'", "'Dependencies'", "'Apply'", "'.'", "'['", "']'", "'requires'", "'excludes'", "'-'"
    };
    public static final int RULE_ID=5;
    public static final int T__29=29;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=4;
    public static final int T__32=32;
    public static final int T__33=33;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int RULE_INT=6;
    public static final int RULE_WS=9;

    // delegates
    // delegators


        public InternalDslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalDslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalDslParser.tokenNames; }
    public String getGrammarFileName() { return "../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g"; }


     
     	private DslGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(DslGrammarAccess grammarAccess) {
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:60:1: entryRuleTrcSpecification : ruleTrcSpecification EOF ;
    public final void entryRuleTrcSpecification() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:61:1: ( ruleTrcSpecification EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:62:1: ruleTrcSpecification EOF
            {
             before(grammarAccess.getTrcSpecificationRule()); 
            pushFollow(FOLLOW_ruleTrcSpecification_in_entryRuleTrcSpecification61);
            ruleTrcSpecification();

            state._fsp--;

             after(grammarAccess.getTrcSpecificationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrcSpecification68); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:69:1: ruleTrcSpecification : ( ( rule__TrcSpecification__Group__0 ) ) ;
    public final void ruleTrcSpecification() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:73:2: ( ( ( rule__TrcSpecification__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:74:1: ( ( rule__TrcSpecification__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:74:1: ( ( rule__TrcSpecification__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:75:1: ( rule__TrcSpecification__Group__0 )
            {
             before(grammarAccess.getTrcSpecificationAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:76:1: ( rule__TrcSpecification__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:76:2: rule__TrcSpecification__Group__0
            {
            pushFollow(FOLLOW_rule__TrcSpecification__Group__0_in_ruleTrcSpecification94);
            rule__TrcSpecification__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTrcSpecificationAccess().getGroup()); 

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


    // $ANTLR start "entryRuleFrom"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:88:1: entryRuleFrom : ruleFrom EOF ;
    public final void entryRuleFrom() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:89:1: ( ruleFrom EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:90:1: ruleFrom EOF
            {
             before(grammarAccess.getFromRule()); 
            pushFollow(FOLLOW_ruleFrom_in_entryRuleFrom121);
            ruleFrom();

            state._fsp--;

             after(grammarAccess.getFromRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFrom128); 

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
    // $ANTLR end "entryRuleFrom"


    // $ANTLR start "ruleFrom"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:97:1: ruleFrom : ( ( rule__From__Group__0 ) ) ;
    public final void ruleFrom() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:101:2: ( ( ( rule__From__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:102:1: ( ( rule__From__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:102:1: ( ( rule__From__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:103:1: ( rule__From__Group__0 )
            {
             before(grammarAccess.getFromAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:104:1: ( rule__From__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:104:2: rule__From__Group__0
            {
            pushFollow(FOLLOW_rule__From__Group__0_in_ruleFrom154);
            rule__From__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getFromAccess().getGroup()); 

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
    // $ANTLR end "ruleFrom"


    // $ANTLR start "entryRuleRules"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:116:1: entryRuleRules : ruleRules EOF ;
    public final void entryRuleRules() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:117:1: ( ruleRules EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:118:1: ruleRules EOF
            {
             before(grammarAccess.getRulesRule()); 
            pushFollow(FOLLOW_ruleRules_in_entryRuleRules181);
            ruleRules();

            state._fsp--;

             after(grammarAccess.getRulesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRules188); 

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
    // $ANTLR end "entryRuleRules"


    // $ANTLR start "ruleRules"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:125:1: ruleRules : ( ( rule__Rules__NameAssignment ) ) ;
    public final void ruleRules() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:129:2: ( ( ( rule__Rules__NameAssignment ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:130:1: ( ( rule__Rules__NameAssignment ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:130:1: ( ( rule__Rules__NameAssignment ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:131:1: ( rule__Rules__NameAssignment )
            {
             before(grammarAccess.getRulesAccess().getNameAssignment()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:132:1: ( rule__Rules__NameAssignment )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:132:2: rule__Rules__NameAssignment
            {
            pushFollow(FOLLOW_rule__Rules__NameAssignment_in_ruleRules214);
            rule__Rules__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getRulesAccess().getNameAssignment()); 

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
    // $ANTLR end "ruleRules"


    // $ANTLR start "entryRuleModuleList"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:146:1: entryRuleModuleList : ruleModuleList EOF ;
    public final void entryRuleModuleList() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:147:1: ( ruleModuleList EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:148:1: ruleModuleList EOF
            {
             before(grammarAccess.getModuleListRule()); 
            pushFollow(FOLLOW_ruleModuleList_in_entryRuleModuleList243);
            ruleModuleList();

            state._fsp--;

             after(grammarAccess.getModuleListRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModuleList250); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:155:1: ruleModuleList : ( ( rule__ModuleList__Group__0 ) ) ;
    public final void ruleModuleList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:159:2: ( ( ( rule__ModuleList__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:160:1: ( ( rule__ModuleList__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:160:1: ( ( rule__ModuleList__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:161:1: ( rule__ModuleList__Group__0 )
            {
             before(grammarAccess.getModuleListAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:162:1: ( rule__ModuleList__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:162:2: rule__ModuleList__Group__0
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__0_in_ruleModuleList276);
            rule__ModuleList__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModuleListAccess().getGroup()); 

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


    // $ANTLR start "entryRuleModules"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:174:1: entryRuleModules : ruleModules EOF ;
    public final void entryRuleModules() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:175:1: ( ruleModules EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:176:1: ruleModules EOF
            {
             before(grammarAccess.getModulesRule()); 
            pushFollow(FOLLOW_ruleModules_in_entryRuleModules303);
            ruleModules();

            state._fsp--;

             after(grammarAccess.getModulesRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModules310); 

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
    // $ANTLR end "entryRuleModules"


    // $ANTLR start "ruleModules"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:183:1: ruleModules : ( ( rule__Modules__Group__0 ) ) ;
    public final void ruleModules() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:187:2: ( ( ( rule__Modules__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:188:1: ( ( rule__Modules__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:188:1: ( ( rule__Modules__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:189:1: ( rule__Modules__Group__0 )
            {
             before(grammarAccess.getModulesAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:190:1: ( rule__Modules__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:190:2: rule__Modules__Group__0
            {
            pushFollow(FOLLOW_rule__Modules__Group__0_in_ruleModules336);
            rule__Modules__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModulesAccess().getGroup()); 

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
    // $ANTLR end "ruleModules"


    // $ANTLR start "entryRuleTransformationList"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:202:1: entryRuleTransformationList : ruleTransformationList EOF ;
    public final void entryRuleTransformationList() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:203:1: ( ruleTransformationList EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:204:1: ruleTransformationList EOF
            {
             before(grammarAccess.getTransformationListRule()); 
            pushFollow(FOLLOW_ruleTransformationList_in_entryRuleTransformationList363);
            ruleTransformationList();

            state._fsp--;

             after(grammarAccess.getTransformationListRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationList370); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:211:1: ruleTransformationList : ( ( rule__TransformationList__Group__0 ) ) ;
    public final void ruleTransformationList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:215:2: ( ( ( rule__TransformationList__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:216:1: ( ( rule__TransformationList__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:216:1: ( ( rule__TransformationList__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:217:1: ( rule__TransformationList__Group__0 )
            {
             before(grammarAccess.getTransformationListAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:218:1: ( rule__TransformationList__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:218:2: rule__TransformationList__Group__0
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__0_in_ruleTransformationList396);
            rule__TransformationList__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTransformationListAccess().getGroup()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:230:1: entryRuleTransformation : ruleTransformation EOF ;
    public final void entryRuleTransformation() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:231:1: ( ruleTransformation EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:232:1: ruleTransformation EOF
            {
             before(grammarAccess.getTransformationRule()); 
            pushFollow(FOLLOW_ruleTransformation_in_entryRuleTransformation423);
            ruleTransformation();

            state._fsp--;

             after(grammarAccess.getTransformationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformation430); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:239:1: ruleTransformation : ( ( rule__Transformation__Group__0 ) ) ;
    public final void ruleTransformation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:243:2: ( ( ( rule__Transformation__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:244:1: ( ( rule__Transformation__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:244:1: ( ( rule__Transformation__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:245:1: ( rule__Transformation__Group__0 )
            {
             before(grammarAccess.getTransformationAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:246:1: ( rule__Transformation__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:246:2: rule__Transformation__Group__0
            {
            pushFollow(FOLLOW_rule__Transformation__Group__0_in_ruleTransformation456);
            rule__Transformation__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTransformationAccess().getGroup()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:258:1: entryRuleTransformationImpact : ruleTransformationImpact EOF ;
    public final void entryRuleTransformationImpact() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:259:1: ( ruleTransformationImpact EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:260:1: ruleTransformationImpact EOF
            {
             before(grammarAccess.getTransformationImpactRule()); 
            pushFollow(FOLLOW_ruleTransformationImpact_in_entryRuleTransformationImpact483);
            ruleTransformationImpact();

            state._fsp--;

             after(grammarAccess.getTransformationImpactRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationImpact490); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:267:1: ruleTransformationImpact : ( ( rule__TransformationImpact__Group__0 ) ) ;
    public final void ruleTransformationImpact() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:271:2: ( ( ( rule__TransformationImpact__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:272:1: ( ( rule__TransformationImpact__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:272:1: ( ( rule__TransformationImpact__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:273:1: ( rule__TransformationImpact__Group__0 )
            {
             before(grammarAccess.getTransformationImpactAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:274:1: ( rule__TransformationImpact__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:274:2: rule__TransformationImpact__Group__0
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group__0_in_ruleTransformationImpact516);
            rule__TransformationImpact__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTransformationImpactAccess().getGroup()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:286:1: entryRuleTransformationDependencyList : ruleTransformationDependencyList EOF ;
    public final void entryRuleTransformationDependencyList() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:287:1: ( ruleTransformationDependencyList EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:288:1: ruleTransformationDependencyList EOF
            {
             before(grammarAccess.getTransformationDependencyListRule()); 
            pushFollow(FOLLOW_ruleTransformationDependencyList_in_entryRuleTransformationDependencyList543);
            ruleTransformationDependencyList();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyListRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationDependencyList550); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:295:1: ruleTransformationDependencyList : ( ( rule__TransformationDependencyList__Group__0 ) ) ;
    public final void ruleTransformationDependencyList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:299:2: ( ( ( rule__TransformationDependencyList__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:300:1: ( ( rule__TransformationDependencyList__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:300:1: ( ( rule__TransformationDependencyList__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:301:1: ( rule__TransformationDependencyList__Group__0 )
            {
             before(grammarAccess.getTransformationDependencyListAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:302:1: ( rule__TransformationDependencyList__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:302:2: rule__TransformationDependencyList__Group__0
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__0_in_ruleTransformationDependencyList576);
            rule__TransformationDependencyList__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTransformationDependencyListAccess().getGroup()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:314:1: entryRuleTransformationDependency : ruleTransformationDependency EOF ;
    public final void entryRuleTransformationDependency() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:315:1: ( ruleTransformationDependency EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:316:1: ruleTransformationDependency EOF
            {
             before(grammarAccess.getTransformationDependencyRule()); 
            pushFollow(FOLLOW_ruleTransformationDependency_in_entryRuleTransformationDependency603);
            ruleTransformationDependency();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationDependency610); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:323:1: ruleTransformationDependency : ( ( rule__TransformationDependency__Group__0 ) ) ;
    public final void ruleTransformationDependency() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:327:2: ( ( ( rule__TransformationDependency__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:328:1: ( ( rule__TransformationDependency__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:328:1: ( ( rule__TransformationDependency__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:329:1: ( rule__TransformationDependency__Group__0 )
            {
             before(grammarAccess.getTransformationDependencyAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:330:1: ( rule__TransformationDependency__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:330:2: rule__TransformationDependency__Group__0
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__0_in_ruleTransformationDependency636);
            rule__TransformationDependency__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getTransformationDependencyAccess().getGroup()); 

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


    // $ANTLR start "entryRuleAbstractRuleDependency"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:342:1: entryRuleAbstractRuleDependency : ruleAbstractRuleDependency EOF ;
    public final void entryRuleAbstractRuleDependency() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:343:1: ( ruleAbstractRuleDependency EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:344:1: ruleAbstractRuleDependency EOF
            {
             before(grammarAccess.getAbstractRuleDependencyRule()); 
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_entryRuleAbstractRuleDependency663);
            ruleAbstractRuleDependency();

            state._fsp--;

             after(grammarAccess.getAbstractRuleDependencyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRuleDependency670); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:351:1: ruleAbstractRuleDependency : ( ruleRuleDependency ) ;
    public final void ruleAbstractRuleDependency() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:355:2: ( ( ruleRuleDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:356:1: ( ruleRuleDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:356:1: ( ruleRuleDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:357:1: ruleRuleDependency
            {
             before(grammarAccess.getAbstractRuleDependencyAccess().getRuleDependencyParserRuleCall()); 
            pushFollow(FOLLOW_ruleRuleDependency_in_ruleAbstractRuleDependency696);
            ruleRuleDependency();

            state._fsp--;

             after(grammarAccess.getAbstractRuleDependencyAccess().getRuleDependencyParserRuleCall()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:374:1: entryRuleRuleDependency : ruleRuleDependency EOF ;
    public final void entryRuleRuleDependency() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:375:1: ( ruleRuleDependency EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:376:1: ruleRuleDependency EOF
            {
             before(grammarAccess.getRuleDependencyRule()); 
            pushFollow(FOLLOW_ruleRuleDependency_in_entryRuleRuleDependency726);
            ruleRuleDependency();

            state._fsp--;

             after(grammarAccess.getRuleDependencyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDependency733); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:383:1: ruleRuleDependency : ( ( rule__RuleDependency__Alternatives ) ) ;
    public final void ruleRuleDependency() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:387:2: ( ( ( rule__RuleDependency__Alternatives ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:388:1: ( ( rule__RuleDependency__Alternatives ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:388:1: ( ( rule__RuleDependency__Alternatives ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:389:1: ( rule__RuleDependency__Alternatives )
            {
             before(grammarAccess.getRuleDependencyAccess().getAlternatives()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:390:1: ( rule__RuleDependency__Alternatives )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:390:2: rule__RuleDependency__Alternatives
            {
            pushFollow(FOLLOW_rule__RuleDependency__Alternatives_in_ruleRuleDependency759);
            rule__RuleDependency__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getRuleDependencyAccess().getAlternatives()); 

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


    // $ANTLR start "entryRulerequiresDependency"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:402:1: entryRulerequiresDependency : rulerequiresDependency EOF ;
    public final void entryRulerequiresDependency() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:403:1: ( rulerequiresDependency EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:404:1: rulerequiresDependency EOF
            {
             before(grammarAccess.getRequiresDependencyRule()); 
            pushFollow(FOLLOW_rulerequiresDependency_in_entryRulerequiresDependency786);
            rulerequiresDependency();

            state._fsp--;

             after(grammarAccess.getRequiresDependencyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulerequiresDependency793); 

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
    // $ANTLR end "entryRulerequiresDependency"


    // $ANTLR start "rulerequiresDependency"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:411:1: rulerequiresDependency : ( ( rule__RequiresDependency__Group__0 ) ) ;
    public final void rulerequiresDependency() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:415:2: ( ( ( rule__RequiresDependency__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:416:1: ( ( rule__RequiresDependency__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:416:1: ( ( rule__RequiresDependency__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:417:1: ( rule__RequiresDependency__Group__0 )
            {
             before(grammarAccess.getRequiresDependencyAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:418:1: ( rule__RequiresDependency__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:418:2: rule__RequiresDependency__Group__0
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__0_in_rulerequiresDependency819);
            rule__RequiresDependency__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getRequiresDependencyAccess().getGroup()); 

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
    // $ANTLR end "rulerequiresDependency"


    // $ANTLR start "entryRuleexcludeDependency"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:430:1: entryRuleexcludeDependency : ruleexcludeDependency EOF ;
    public final void entryRuleexcludeDependency() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:431:1: ( ruleexcludeDependency EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:432:1: ruleexcludeDependency EOF
            {
             before(grammarAccess.getExcludeDependencyRule()); 
            pushFollow(FOLLOW_ruleexcludeDependency_in_entryRuleexcludeDependency846);
            ruleexcludeDependency();

            state._fsp--;

             after(grammarAccess.getExcludeDependencyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleexcludeDependency853); 

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
    // $ANTLR end "entryRuleexcludeDependency"


    // $ANTLR start "ruleexcludeDependency"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:439:1: ruleexcludeDependency : ( ( rule__ExcludeDependency__Group__0 ) ) ;
    public final void ruleexcludeDependency() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:443:2: ( ( ( rule__ExcludeDependency__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:444:1: ( ( rule__ExcludeDependency__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:444:1: ( ( rule__ExcludeDependency__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:445:1: ( rule__ExcludeDependency__Group__0 )
            {
             before(grammarAccess.getExcludeDependencyAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:446:1: ( rule__ExcludeDependency__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:446:2: rule__ExcludeDependency__Group__0
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__0_in_ruleexcludeDependency879);
            rule__ExcludeDependency__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getExcludeDependencyAccess().getGroup()); 

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
    // $ANTLR end "ruleexcludeDependency"


    // $ANTLR start "entryRuleEString"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:462:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:463:1: ( ruleEString EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:464:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_ruleEString_in_entryRuleEString910);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEString917); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:471:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:475:2: ( ( ( rule__EString__Alternatives ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:476:1: ( ( rule__EString__Alternatives ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:476:1: ( ( rule__EString__Alternatives ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:477:1: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:478:1: ( rule__EString__Alternatives )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:478:2: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_rule__EString__Alternatives_in_ruleEString943);
            rule__EString__Alternatives();

            state._fsp--;


            }

             after(grammarAccess.getEStringAccess().getAlternatives()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:490:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:491:1: ( ruleEInt EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:492:1: ruleEInt EOF
            {
             before(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_ruleEInt_in_entryRuleEInt970);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getEIntRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEInt977); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:499:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:503:2: ( ( ( rule__EInt__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:504:1: ( ( rule__EInt__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:504:1: ( ( rule__EInt__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:505:1: ( rule__EInt__Group__0 )
            {
             before(grammarAccess.getEIntAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:506:1: ( rule__EInt__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:506:2: rule__EInt__Group__0
            {
            pushFollow(FOLLOW_rule__EInt__Group__0_in_ruleEInt1003);
            rule__EInt__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getEIntAccess().getGroup()); 

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


    // $ANTLR start "rule__TransformationDependency__Alternatives_13"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:520:1: rule__TransformationDependency__Alternatives_13 : ( ( 'and' ) | ( 'or' ) );
    public final void rule__TransformationDependency__Alternatives_13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:524:1: ( ( 'and' ) | ( 'or' ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==11) ) {
                alt1=1;
            }
            else if ( (LA1_0==12) ) {
                alt1=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:525:1: ( 'and' )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:525:1: ( 'and' )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:526:1: 'and'
                    {
                     before(grammarAccess.getTransformationDependencyAccess().getAndKeyword_13_0()); 
                    match(input,11,FOLLOW_11_in_rule__TransformationDependency__Alternatives_131042); 
                     after(grammarAccess.getTransformationDependencyAccess().getAndKeyword_13_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:533:6: ( 'or' )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:533:6: ( 'or' )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:534:1: 'or'
                    {
                     before(grammarAccess.getTransformationDependencyAccess().getOrKeyword_13_1()); 
                    match(input,12,FOLLOW_12_in_rule__TransformationDependency__Alternatives_131062); 
                     after(grammarAccess.getTransformationDependencyAccess().getOrKeyword_13_1()); 

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
    // $ANTLR end "rule__TransformationDependency__Alternatives_13"


    // $ANTLR start "rule__RuleDependency__Alternatives"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:546:1: rule__RuleDependency__Alternatives : ( ( ( rule__RuleDependency__Group_0__0 ) ) | ( ( rule__RuleDependency__Group_1__0 ) ) );
    public final void rule__RuleDependency__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:550:1: ( ( ( rule__RuleDependency__Group_0__0 ) ) | ( ( rule__RuleDependency__Group_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==31) ) {
                alt2=1;
            }
            else if ( (LA2_0==32) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:551:1: ( ( rule__RuleDependency__Group_0__0 ) )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:551:1: ( ( rule__RuleDependency__Group_0__0 ) )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:552:1: ( rule__RuleDependency__Group_0__0 )
                    {
                     before(grammarAccess.getRuleDependencyAccess().getGroup_0()); 
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:553:1: ( rule__RuleDependency__Group_0__0 )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:553:2: rule__RuleDependency__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__RuleDependency__Group_0__0_in_rule__RuleDependency__Alternatives1096);
                    rule__RuleDependency__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getRuleDependencyAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:557:6: ( ( rule__RuleDependency__Group_1__0 ) )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:557:6: ( ( rule__RuleDependency__Group_1__0 ) )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:558:1: ( rule__RuleDependency__Group_1__0 )
                    {
                     before(grammarAccess.getRuleDependencyAccess().getGroup_1()); 
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:559:1: ( rule__RuleDependency__Group_1__0 )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:559:2: rule__RuleDependency__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__RuleDependency__Group_1__0_in_rule__RuleDependency__Alternatives1114);
                    rule__RuleDependency__Group_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getRuleDependencyAccess().getGroup_1()); 

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
    // $ANTLR end "rule__RuleDependency__Alternatives"


    // $ANTLR start "rule__RuleDependency__Alternatives_0_2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:568:1: rule__RuleDependency__Alternatives_0_2 : ( ( 'and' ) | ( 'or' ) );
    public final void rule__RuleDependency__Alternatives_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:572:1: ( ( 'and' ) | ( 'or' ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==11) ) {
                alt3=1;
            }
            else if ( (LA3_0==12) ) {
                alt3=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:573:1: ( 'and' )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:573:1: ( 'and' )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:574:1: 'and'
                    {
                     before(grammarAccess.getRuleDependencyAccess().getAndKeyword_0_2_0()); 
                    match(input,11,FOLLOW_11_in_rule__RuleDependency__Alternatives_0_21148); 
                     after(grammarAccess.getRuleDependencyAccess().getAndKeyword_0_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:581:6: ( 'or' )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:581:6: ( 'or' )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:582:1: 'or'
                    {
                     before(grammarAccess.getRuleDependencyAccess().getOrKeyword_0_2_1()); 
                    match(input,12,FOLLOW_12_in_rule__RuleDependency__Alternatives_0_21168); 
                     after(grammarAccess.getRuleDependencyAccess().getOrKeyword_0_2_1()); 

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
    // $ANTLR end "rule__RuleDependency__Alternatives_0_2"


    // $ANTLR start "rule__RuleDependency__Alternatives_1_2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:594:1: rule__RuleDependency__Alternatives_1_2 : ( ( 'and' ) | ( 'or' ) );
    public final void rule__RuleDependency__Alternatives_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:598:1: ( ( 'and' ) | ( 'or' ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==11) ) {
                alt4=1;
            }
            else if ( (LA4_0==12) ) {
                alt4=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:599:1: ( 'and' )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:599:1: ( 'and' )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:600:1: 'and'
                    {
                     before(grammarAccess.getRuleDependencyAccess().getAndKeyword_1_2_0()); 
                    match(input,11,FOLLOW_11_in_rule__RuleDependency__Alternatives_1_21203); 
                     after(grammarAccess.getRuleDependencyAccess().getAndKeyword_1_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:607:6: ( 'or' )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:607:6: ( 'or' )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:608:1: 'or'
                    {
                     before(grammarAccess.getRuleDependencyAccess().getOrKeyword_1_2_1()); 
                    match(input,12,FOLLOW_12_in_rule__RuleDependency__Alternatives_1_21223); 
                     after(grammarAccess.getRuleDependencyAccess().getOrKeyword_1_2_1()); 

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
    // $ANTLR end "rule__RuleDependency__Alternatives_1_2"


    // $ANTLR start "rule__EString__Alternatives"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:620:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:624:1: ( ( RULE_STRING ) | ( RULE_ID ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==RULE_STRING) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:625:1: ( RULE_STRING )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:625:1: ( RULE_STRING )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:626:1: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EString__Alternatives1257); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:631:6: ( RULE_ID )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:631:6: ( RULE_ID )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:632:1: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EString__Alternatives1274); 
                     after(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 

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


    // $ANTLR start "rule__TrcSpecification__Group__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:645:1: rule__TrcSpecification__Group__0 : rule__TrcSpecification__Group__0__Impl rule__TrcSpecification__Group__1 ;
    public final void rule__TrcSpecification__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:649:1: ( rule__TrcSpecification__Group__0__Impl rule__TrcSpecification__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:650:2: rule__TrcSpecification__Group__0__Impl rule__TrcSpecification__Group__1
            {
            pushFollow(FOLLOW_rule__TrcSpecification__Group__0__Impl_in_rule__TrcSpecification__Group__01305);
            rule__TrcSpecification__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TrcSpecification__Group__1_in_rule__TrcSpecification__Group__01308);
            rule__TrcSpecification__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:657:1: rule__TrcSpecification__Group__0__Impl : ( ( rule__TrcSpecification__FromsAssignment_0 )* ) ;
    public final void rule__TrcSpecification__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:661:1: ( ( ( rule__TrcSpecification__FromsAssignment_0 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:662:1: ( ( rule__TrcSpecification__FromsAssignment_0 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:662:1: ( ( rule__TrcSpecification__FromsAssignment_0 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:663:1: ( rule__TrcSpecification__FromsAssignment_0 )*
            {
             before(grammarAccess.getTrcSpecificationAccess().getFromsAssignment_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:664:1: ( rule__TrcSpecification__FromsAssignment_0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==13) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:664:2: rule__TrcSpecification__FromsAssignment_0
            	    {
            	    pushFollow(FOLLOW_rule__TrcSpecification__FromsAssignment_0_in_rule__TrcSpecification__Group__0__Impl1335);
            	    rule__TrcSpecification__FromsAssignment_0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

             after(grammarAccess.getTrcSpecificationAccess().getFromsAssignment_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:674:1: rule__TrcSpecification__Group__1 : rule__TrcSpecification__Group__1__Impl rule__TrcSpecification__Group__2 ;
    public final void rule__TrcSpecification__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:678:1: ( rule__TrcSpecification__Group__1__Impl rule__TrcSpecification__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:679:2: rule__TrcSpecification__Group__1__Impl rule__TrcSpecification__Group__2
            {
            pushFollow(FOLLOW_rule__TrcSpecification__Group__1__Impl_in_rule__TrcSpecification__Group__11366);
            rule__TrcSpecification__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TrcSpecification__Group__2_in_rule__TrcSpecification__Group__11369);
            rule__TrcSpecification__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:686:1: rule__TrcSpecification__Group__1__Impl : ( ( rule__TrcSpecification__ModuleListAssignment_1 ) ) ;
    public final void rule__TrcSpecification__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:690:1: ( ( ( rule__TrcSpecification__ModuleListAssignment_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:691:1: ( ( rule__TrcSpecification__ModuleListAssignment_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:691:1: ( ( rule__TrcSpecification__ModuleListAssignment_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:692:1: ( rule__TrcSpecification__ModuleListAssignment_1 )
            {
             before(grammarAccess.getTrcSpecificationAccess().getModuleListAssignment_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:693:1: ( rule__TrcSpecification__ModuleListAssignment_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:693:2: rule__TrcSpecification__ModuleListAssignment_1
            {
            pushFollow(FOLLOW_rule__TrcSpecification__ModuleListAssignment_1_in_rule__TrcSpecification__Group__1__Impl1396);
            rule__TrcSpecification__ModuleListAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getTrcSpecificationAccess().getModuleListAssignment_1()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:703:1: rule__TrcSpecification__Group__2 : rule__TrcSpecification__Group__2__Impl rule__TrcSpecification__Group__3 ;
    public final void rule__TrcSpecification__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:707:1: ( rule__TrcSpecification__Group__2__Impl rule__TrcSpecification__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:708:2: rule__TrcSpecification__Group__2__Impl rule__TrcSpecification__Group__3
            {
            pushFollow(FOLLOW_rule__TrcSpecification__Group__2__Impl_in_rule__TrcSpecification__Group__21426);
            rule__TrcSpecification__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TrcSpecification__Group__3_in_rule__TrcSpecification__Group__21429);
            rule__TrcSpecification__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:715:1: rule__TrcSpecification__Group__2__Impl : ( ( rule__TrcSpecification__TransformationListAssignment_2 ) ) ;
    public final void rule__TrcSpecification__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:719:1: ( ( ( rule__TrcSpecification__TransformationListAssignment_2 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:720:1: ( ( rule__TrcSpecification__TransformationListAssignment_2 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:720:1: ( ( rule__TrcSpecification__TransformationListAssignment_2 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:721:1: ( rule__TrcSpecification__TransformationListAssignment_2 )
            {
             before(grammarAccess.getTrcSpecificationAccess().getTransformationListAssignment_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:722:1: ( rule__TrcSpecification__TransformationListAssignment_2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:722:2: rule__TrcSpecification__TransformationListAssignment_2
            {
            pushFollow(FOLLOW_rule__TrcSpecification__TransformationListAssignment_2_in_rule__TrcSpecification__Group__2__Impl1456);
            rule__TrcSpecification__TransformationListAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTrcSpecificationAccess().getTransformationListAssignment_2()); 

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


    // $ANTLR start "rule__TrcSpecification__Group__3"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:732:1: rule__TrcSpecification__Group__3 : rule__TrcSpecification__Group__3__Impl ;
    public final void rule__TrcSpecification__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:736:1: ( rule__TrcSpecification__Group__3__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:737:2: rule__TrcSpecification__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TrcSpecification__Group__3__Impl_in_rule__TrcSpecification__Group__31486);
            rule__TrcSpecification__Group__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TrcSpecification__Group__3"


    // $ANTLR start "rule__TrcSpecification__Group__3__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:743:1: rule__TrcSpecification__Group__3__Impl : ( ( rule__TrcSpecification__DependencyListAssignment_3 ) ) ;
    public final void rule__TrcSpecification__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:747:1: ( ( ( rule__TrcSpecification__DependencyListAssignment_3 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:748:1: ( ( rule__TrcSpecification__DependencyListAssignment_3 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:748:1: ( ( rule__TrcSpecification__DependencyListAssignment_3 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:749:1: ( rule__TrcSpecification__DependencyListAssignment_3 )
            {
             before(grammarAccess.getTrcSpecificationAccess().getDependencyListAssignment_3()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:750:1: ( rule__TrcSpecification__DependencyListAssignment_3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:750:2: rule__TrcSpecification__DependencyListAssignment_3
            {
            pushFollow(FOLLOW_rule__TrcSpecification__DependencyListAssignment_3_in_rule__TrcSpecification__Group__3__Impl1513);
            rule__TrcSpecification__DependencyListAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getTrcSpecificationAccess().getDependencyListAssignment_3()); 

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
    // $ANTLR end "rule__TrcSpecification__Group__3__Impl"


    // $ANTLR start "rule__From__Group__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:768:1: rule__From__Group__0 : rule__From__Group__0__Impl rule__From__Group__1 ;
    public final void rule__From__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:772:1: ( rule__From__Group__0__Impl rule__From__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:773:2: rule__From__Group__0__Impl rule__From__Group__1
            {
            pushFollow(FOLLOW_rule__From__Group__0__Impl_in_rule__From__Group__01551);
            rule__From__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__From__Group__1_in_rule__From__Group__01554);
            rule__From__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__From__Group__0"


    // $ANTLR start "rule__From__Group__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:780:1: rule__From__Group__0__Impl : ( 'from' ) ;
    public final void rule__From__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:784:1: ( ( 'from' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:785:1: ( 'from' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:785:1: ( 'from' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:786:1: 'from'
            {
             before(grammarAccess.getFromAccess().getFromKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__From__Group__0__Impl1582); 
             after(grammarAccess.getFromAccess().getFromKeyword_0()); 

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
    // $ANTLR end "rule__From__Group__0__Impl"


    // $ANTLR start "rule__From__Group__1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:799:1: rule__From__Group__1 : rule__From__Group__1__Impl rule__From__Group__2 ;
    public final void rule__From__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:803:1: ( rule__From__Group__1__Impl rule__From__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:804:2: rule__From__Group__1__Impl rule__From__Group__2
            {
            pushFollow(FOLLOW_rule__From__Group__1__Impl_in_rule__From__Group__11613);
            rule__From__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__From__Group__2_in_rule__From__Group__11616);
            rule__From__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__From__Group__1"


    // $ANTLR start "rule__From__Group__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:811:1: rule__From__Group__1__Impl : ( ( rule__From__ImportURIAssignment_1 ) ) ;
    public final void rule__From__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:815:1: ( ( ( rule__From__ImportURIAssignment_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:816:1: ( ( rule__From__ImportURIAssignment_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:816:1: ( ( rule__From__ImportURIAssignment_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:817:1: ( rule__From__ImportURIAssignment_1 )
            {
             before(grammarAccess.getFromAccess().getImportURIAssignment_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:818:1: ( rule__From__ImportURIAssignment_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:818:2: rule__From__ImportURIAssignment_1
            {
            pushFollow(FOLLOW_rule__From__ImportURIAssignment_1_in_rule__From__Group__1__Impl1643);
            rule__From__ImportURIAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getFromAccess().getImportURIAssignment_1()); 

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
    // $ANTLR end "rule__From__Group__1__Impl"


    // $ANTLR start "rule__From__Group__2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:828:1: rule__From__Group__2 : rule__From__Group__2__Impl ;
    public final void rule__From__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:832:1: ( rule__From__Group__2__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:833:2: rule__From__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__From__Group__2__Impl_in_rule__From__Group__21673);
            rule__From__Group__2__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__From__Group__2"


    // $ANTLR start "rule__From__Group__2__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:839:1: rule__From__Group__2__Impl : ( ';' ) ;
    public final void rule__From__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:843:1: ( ( ';' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:844:1: ( ';' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:844:1: ( ';' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:845:1: ';'
            {
             before(grammarAccess.getFromAccess().getSemicolonKeyword_2()); 
            match(input,14,FOLLOW_14_in_rule__From__Group__2__Impl1701); 
             after(grammarAccess.getFromAccess().getSemicolonKeyword_2()); 

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
    // $ANTLR end "rule__From__Group__2__Impl"


    // $ANTLR start "rule__ModuleList__Group__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:866:1: rule__ModuleList__Group__0 : rule__ModuleList__Group__0__Impl rule__ModuleList__Group__1 ;
    public final void rule__ModuleList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:870:1: ( rule__ModuleList__Group__0__Impl rule__ModuleList__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:871:2: rule__ModuleList__Group__0__Impl rule__ModuleList__Group__1
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__0__Impl_in_rule__ModuleList__Group__01740);
            rule__ModuleList__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModuleList__Group__1_in_rule__ModuleList__Group__01743);
            rule__ModuleList__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:878:1: rule__ModuleList__Group__0__Impl : ( () ) ;
    public final void rule__ModuleList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:882:1: ( ( () ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:883:1: ( () )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:883:1: ( () )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:884:1: ()
            {
             before(grammarAccess.getModuleListAccess().getModuleListAction_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:885:1: ()
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:887:1: 
            {
            }

             after(grammarAccess.getModuleListAccess().getModuleListAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group__0__Impl"


    // $ANTLR start "rule__ModuleList__Group__1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:897:1: rule__ModuleList__Group__1 : rule__ModuleList__Group__1__Impl rule__ModuleList__Group__2 ;
    public final void rule__ModuleList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:901:1: ( rule__ModuleList__Group__1__Impl rule__ModuleList__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:902:2: rule__ModuleList__Group__1__Impl rule__ModuleList__Group__2
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__1__Impl_in_rule__ModuleList__Group__11801);
            rule__ModuleList__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModuleList__Group__2_in_rule__ModuleList__Group__11804);
            rule__ModuleList__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:909:1: rule__ModuleList__Group__1__Impl : ( 'Modules' ) ;
    public final void rule__ModuleList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:913:1: ( ( 'Modules' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:914:1: ( 'Modules' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:914:1: ( 'Modules' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:915:1: 'Modules'
            {
             before(grammarAccess.getModuleListAccess().getModulesKeyword_1()); 
            match(input,15,FOLLOW_15_in_rule__ModuleList__Group__1__Impl1832); 
             after(grammarAccess.getModuleListAccess().getModulesKeyword_1()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:928:1: rule__ModuleList__Group__2 : rule__ModuleList__Group__2__Impl rule__ModuleList__Group__3 ;
    public final void rule__ModuleList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:932:1: ( rule__ModuleList__Group__2__Impl rule__ModuleList__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:933:2: rule__ModuleList__Group__2__Impl rule__ModuleList__Group__3
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__2__Impl_in_rule__ModuleList__Group__21863);
            rule__ModuleList__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModuleList__Group__3_in_rule__ModuleList__Group__21866);
            rule__ModuleList__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:940:1: rule__ModuleList__Group__2__Impl : ( '{' ) ;
    public final void rule__ModuleList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:944:1: ( ( '{' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:945:1: ( '{' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:945:1: ( '{' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:946:1: '{'
            {
             before(grammarAccess.getModuleListAccess().getLeftCurlyBracketKeyword_2()); 
            match(input,16,FOLLOW_16_in_rule__ModuleList__Group__2__Impl1894); 
             after(grammarAccess.getModuleListAccess().getLeftCurlyBracketKeyword_2()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:959:1: rule__ModuleList__Group__3 : rule__ModuleList__Group__3__Impl rule__ModuleList__Group__4 ;
    public final void rule__ModuleList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:963:1: ( rule__ModuleList__Group__3__Impl rule__ModuleList__Group__4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:964:2: rule__ModuleList__Group__3__Impl rule__ModuleList__Group__4
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__3__Impl_in_rule__ModuleList__Group__31925);
            rule__ModuleList__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModuleList__Group__4_in_rule__ModuleList__Group__31928);
            rule__ModuleList__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:971:1: rule__ModuleList__Group__3__Impl : ( ( rule__ModuleList__Group_3__0 )? ) ;
    public final void rule__ModuleList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:975:1: ( ( ( rule__ModuleList__Group_3__0 )? ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:976:1: ( ( rule__ModuleList__Group_3__0 )? )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:976:1: ( ( rule__ModuleList__Group_3__0 )? )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:977:1: ( rule__ModuleList__Group_3__0 )?
            {
             before(grammarAccess.getModuleListAccess().getGroup_3()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:978:1: ( rule__ModuleList__Group_3__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( ((LA7_0>=RULE_STRING && LA7_0<=RULE_ID)) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:978:2: rule__ModuleList__Group_3__0
                    {
                    pushFollow(FOLLOW_rule__ModuleList__Group_3__0_in_rule__ModuleList__Group__3__Impl1955);
                    rule__ModuleList__Group_3__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModuleListAccess().getGroup_3()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:988:1: rule__ModuleList__Group__4 : rule__ModuleList__Group__4__Impl ;
    public final void rule__ModuleList__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:992:1: ( rule__ModuleList__Group__4__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:993:2: rule__ModuleList__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__4__Impl_in_rule__ModuleList__Group__41986);
            rule__ModuleList__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:999:1: rule__ModuleList__Group__4__Impl : ( '}' ) ;
    public final void rule__ModuleList__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1003:1: ( ( '}' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1004:1: ( '}' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1004:1: ( '}' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1005:1: '}'
            {
             before(grammarAccess.getModuleListAccess().getRightCurlyBracketKeyword_4()); 
            match(input,17,FOLLOW_17_in_rule__ModuleList__Group__4__Impl2014); 
             after(grammarAccess.getModuleListAccess().getRightCurlyBracketKeyword_4()); 

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


    // $ANTLR start "rule__ModuleList__Group_3__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1028:1: rule__ModuleList__Group_3__0 : rule__ModuleList__Group_3__0__Impl rule__ModuleList__Group_3__1 ;
    public final void rule__ModuleList__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1032:1: ( rule__ModuleList__Group_3__0__Impl rule__ModuleList__Group_3__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1033:2: rule__ModuleList__Group_3__0__Impl rule__ModuleList__Group_3__1
            {
            pushFollow(FOLLOW_rule__ModuleList__Group_3__0__Impl_in_rule__ModuleList__Group_3__02055);
            rule__ModuleList__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModuleList__Group_3__1_in_rule__ModuleList__Group_3__02058);
            rule__ModuleList__Group_3__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group_3__0"


    // $ANTLR start "rule__ModuleList__Group_3__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1040:1: rule__ModuleList__Group_3__0__Impl : ( ( rule__ModuleList__ModulesAssignment_3_0 ) ) ;
    public final void rule__ModuleList__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1044:1: ( ( ( rule__ModuleList__ModulesAssignment_3_0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1045:1: ( ( rule__ModuleList__ModulesAssignment_3_0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1045:1: ( ( rule__ModuleList__ModulesAssignment_3_0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1046:1: ( rule__ModuleList__ModulesAssignment_3_0 )
            {
             before(grammarAccess.getModuleListAccess().getModulesAssignment_3_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1047:1: ( rule__ModuleList__ModulesAssignment_3_0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1047:2: rule__ModuleList__ModulesAssignment_3_0
            {
            pushFollow(FOLLOW_rule__ModuleList__ModulesAssignment_3_0_in_rule__ModuleList__Group_3__0__Impl2085);
            rule__ModuleList__ModulesAssignment_3_0();

            state._fsp--;


            }

             after(grammarAccess.getModuleListAccess().getModulesAssignment_3_0()); 

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
    // $ANTLR end "rule__ModuleList__Group_3__0__Impl"


    // $ANTLR start "rule__ModuleList__Group_3__1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1057:1: rule__ModuleList__Group_3__1 : rule__ModuleList__Group_3__1__Impl ;
    public final void rule__ModuleList__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1061:1: ( rule__ModuleList__Group_3__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1062:2: rule__ModuleList__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__ModuleList__Group_3__1__Impl_in_rule__ModuleList__Group_3__12115);
            rule__ModuleList__Group_3__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group_3__1"


    // $ANTLR start "rule__ModuleList__Group_3__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1068:1: rule__ModuleList__Group_3__1__Impl : ( ( rule__ModuleList__Group_3_1__0 )* ) ;
    public final void rule__ModuleList__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1072:1: ( ( ( rule__ModuleList__Group_3_1__0 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1073:1: ( ( rule__ModuleList__Group_3_1__0 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1073:1: ( ( rule__ModuleList__Group_3_1__0 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1074:1: ( rule__ModuleList__Group_3_1__0 )*
            {
             before(grammarAccess.getModuleListAccess().getGroup_3_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1075:1: ( rule__ModuleList__Group_3_1__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==14) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1075:2: rule__ModuleList__Group_3_1__0
            	    {
            	    pushFollow(FOLLOW_rule__ModuleList__Group_3_1__0_in_rule__ModuleList__Group_3__1__Impl2142);
            	    rule__ModuleList__Group_3_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

             after(grammarAccess.getModuleListAccess().getGroup_3_1()); 

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
    // $ANTLR end "rule__ModuleList__Group_3__1__Impl"


    // $ANTLR start "rule__ModuleList__Group_3_1__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1089:1: rule__ModuleList__Group_3_1__0 : rule__ModuleList__Group_3_1__0__Impl rule__ModuleList__Group_3_1__1 ;
    public final void rule__ModuleList__Group_3_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1093:1: ( rule__ModuleList__Group_3_1__0__Impl rule__ModuleList__Group_3_1__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1094:2: rule__ModuleList__Group_3_1__0__Impl rule__ModuleList__Group_3_1__1
            {
            pushFollow(FOLLOW_rule__ModuleList__Group_3_1__0__Impl_in_rule__ModuleList__Group_3_1__02177);
            rule__ModuleList__Group_3_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModuleList__Group_3_1__1_in_rule__ModuleList__Group_3_1__02180);
            rule__ModuleList__Group_3_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group_3_1__0"


    // $ANTLR start "rule__ModuleList__Group_3_1__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1101:1: rule__ModuleList__Group_3_1__0__Impl : ( ';' ) ;
    public final void rule__ModuleList__Group_3_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1105:1: ( ( ';' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1106:1: ( ';' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1106:1: ( ';' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1107:1: ';'
            {
             before(grammarAccess.getModuleListAccess().getSemicolonKeyword_3_1_0()); 
            match(input,14,FOLLOW_14_in_rule__ModuleList__Group_3_1__0__Impl2208); 
             after(grammarAccess.getModuleListAccess().getSemicolonKeyword_3_1_0()); 

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
    // $ANTLR end "rule__ModuleList__Group_3_1__0__Impl"


    // $ANTLR start "rule__ModuleList__Group_3_1__1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1120:1: rule__ModuleList__Group_3_1__1 : rule__ModuleList__Group_3_1__1__Impl ;
    public final void rule__ModuleList__Group_3_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1124:1: ( rule__ModuleList__Group_3_1__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1125:2: rule__ModuleList__Group_3_1__1__Impl
            {
            pushFollow(FOLLOW_rule__ModuleList__Group_3_1__1__Impl_in_rule__ModuleList__Group_3_1__12239);
            rule__ModuleList__Group_3_1__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__Group_3_1__1"


    // $ANTLR start "rule__ModuleList__Group_3_1__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1131:1: rule__ModuleList__Group_3_1__1__Impl : ( ( rule__ModuleList__ModulesAssignment_3_1_1 ) ) ;
    public final void rule__ModuleList__Group_3_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1135:1: ( ( ( rule__ModuleList__ModulesAssignment_3_1_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1136:1: ( ( rule__ModuleList__ModulesAssignment_3_1_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1136:1: ( ( rule__ModuleList__ModulesAssignment_3_1_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1137:1: ( rule__ModuleList__ModulesAssignment_3_1_1 )
            {
             before(grammarAccess.getModuleListAccess().getModulesAssignment_3_1_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1138:1: ( rule__ModuleList__ModulesAssignment_3_1_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1138:2: rule__ModuleList__ModulesAssignment_3_1_1
            {
            pushFollow(FOLLOW_rule__ModuleList__ModulesAssignment_3_1_1_in_rule__ModuleList__Group_3_1__1__Impl2266);
            rule__ModuleList__ModulesAssignment_3_1_1();

            state._fsp--;


            }

             after(grammarAccess.getModuleListAccess().getModulesAssignment_3_1_1()); 

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
    // $ANTLR end "rule__ModuleList__Group_3_1__1__Impl"


    // $ANTLR start "rule__Modules__Group__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1152:1: rule__Modules__Group__0 : rule__Modules__Group__0__Impl rule__Modules__Group__1 ;
    public final void rule__Modules__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1156:1: ( rule__Modules__Group__0__Impl rule__Modules__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1157:2: rule__Modules__Group__0__Impl rule__Modules__Group__1
            {
            pushFollow(FOLLOW_rule__Modules__Group__0__Impl_in_rule__Modules__Group__02300);
            rule__Modules__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Modules__Group__1_in_rule__Modules__Group__02303);
            rule__Modules__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modules__Group__0"


    // $ANTLR start "rule__Modules__Group__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1164:1: rule__Modules__Group__0__Impl : ( ( rule__Modules__PathAssignment_0 ) ) ;
    public final void rule__Modules__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1168:1: ( ( ( rule__Modules__PathAssignment_0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1169:1: ( ( rule__Modules__PathAssignment_0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1169:1: ( ( rule__Modules__PathAssignment_0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1170:1: ( rule__Modules__PathAssignment_0 )
            {
             before(grammarAccess.getModulesAccess().getPathAssignment_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1171:1: ( rule__Modules__PathAssignment_0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1171:2: rule__Modules__PathAssignment_0
            {
            pushFollow(FOLLOW_rule__Modules__PathAssignment_0_in_rule__Modules__Group__0__Impl2330);
            rule__Modules__PathAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getModulesAccess().getPathAssignment_0()); 

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
    // $ANTLR end "rule__Modules__Group__0__Impl"


    // $ANTLR start "rule__Modules__Group__1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1181:1: rule__Modules__Group__1 : rule__Modules__Group__1__Impl rule__Modules__Group__2 ;
    public final void rule__Modules__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1185:1: ( rule__Modules__Group__1__Impl rule__Modules__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1186:2: rule__Modules__Group__1__Impl rule__Modules__Group__2
            {
            pushFollow(FOLLOW_rule__Modules__Group__1__Impl_in_rule__Modules__Group__12360);
            rule__Modules__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Modules__Group__2_in_rule__Modules__Group__12363);
            rule__Modules__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modules__Group__1"


    // $ANTLR start "rule__Modules__Group__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1193:1: rule__Modules__Group__1__Impl : ( '::' ) ;
    public final void rule__Modules__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1197:1: ( ( '::' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1198:1: ( '::' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1198:1: ( '::' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1199:1: '::'
            {
             before(grammarAccess.getModulesAccess().getColonColonKeyword_1()); 
            match(input,18,FOLLOW_18_in_rule__Modules__Group__1__Impl2391); 
             after(grammarAccess.getModulesAccess().getColonColonKeyword_1()); 

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
    // $ANTLR end "rule__Modules__Group__1__Impl"


    // $ANTLR start "rule__Modules__Group__2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1212:1: rule__Modules__Group__2 : rule__Modules__Group__2__Impl rule__Modules__Group__3 ;
    public final void rule__Modules__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1216:1: ( rule__Modules__Group__2__Impl rule__Modules__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1217:2: rule__Modules__Group__2__Impl rule__Modules__Group__3
            {
            pushFollow(FOLLOW_rule__Modules__Group__2__Impl_in_rule__Modules__Group__22422);
            rule__Modules__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Modules__Group__3_in_rule__Modules__Group__22425);
            rule__Modules__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modules__Group__2"


    // $ANTLR start "rule__Modules__Group__2__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1224:1: rule__Modules__Group__2__Impl : ( ( rule__Modules__NameAssignment_2 ) ) ;
    public final void rule__Modules__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1228:1: ( ( ( rule__Modules__NameAssignment_2 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1229:1: ( ( rule__Modules__NameAssignment_2 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1229:1: ( ( rule__Modules__NameAssignment_2 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1230:1: ( rule__Modules__NameAssignment_2 )
            {
             before(grammarAccess.getModulesAccess().getNameAssignment_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1231:1: ( rule__Modules__NameAssignment_2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1231:2: rule__Modules__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__Modules__NameAssignment_2_in_rule__Modules__Group__2__Impl2452);
            rule__Modules__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getModulesAccess().getNameAssignment_2()); 

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
    // $ANTLR end "rule__Modules__Group__2__Impl"


    // $ANTLR start "rule__Modules__Group__3"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1241:1: rule__Modules__Group__3 : rule__Modules__Group__3__Impl rule__Modules__Group__4 ;
    public final void rule__Modules__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1245:1: ( rule__Modules__Group__3__Impl rule__Modules__Group__4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1246:2: rule__Modules__Group__3__Impl rule__Modules__Group__4
            {
            pushFollow(FOLLOW_rule__Modules__Group__3__Impl_in_rule__Modules__Group__32482);
            rule__Modules__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Modules__Group__4_in_rule__Modules__Group__32485);
            rule__Modules__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modules__Group__3"


    // $ANTLR start "rule__Modules__Group__3__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1253:1: rule__Modules__Group__3__Impl : ( ':' ) ;
    public final void rule__Modules__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1257:1: ( ( ':' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1258:1: ( ':' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1258:1: ( ':' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1259:1: ':'
            {
             before(grammarAccess.getModulesAccess().getColonKeyword_3()); 
            match(input,19,FOLLOW_19_in_rule__Modules__Group__3__Impl2513); 
             after(grammarAccess.getModulesAccess().getColonKeyword_3()); 

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
    // $ANTLR end "rule__Modules__Group__3__Impl"


    // $ANTLR start "rule__Modules__Group__4"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1272:1: rule__Modules__Group__4 : rule__Modules__Group__4__Impl rule__Modules__Group__5 ;
    public final void rule__Modules__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1276:1: ( rule__Modules__Group__4__Impl rule__Modules__Group__5 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1277:2: rule__Modules__Group__4__Impl rule__Modules__Group__5
            {
            pushFollow(FOLLOW_rule__Modules__Group__4__Impl_in_rule__Modules__Group__42544);
            rule__Modules__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Modules__Group__5_in_rule__Modules__Group__42547);
            rule__Modules__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modules__Group__4"


    // $ANTLR start "rule__Modules__Group__4__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1284:1: rule__Modules__Group__4__Impl : ( ( rule__Modules__RuleNameAssignment_4 ) ) ;
    public final void rule__Modules__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1288:1: ( ( ( rule__Modules__RuleNameAssignment_4 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1289:1: ( ( rule__Modules__RuleNameAssignment_4 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1289:1: ( ( rule__Modules__RuleNameAssignment_4 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1290:1: ( rule__Modules__RuleNameAssignment_4 )
            {
             before(grammarAccess.getModulesAccess().getRuleNameAssignment_4()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1291:1: ( rule__Modules__RuleNameAssignment_4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1291:2: rule__Modules__RuleNameAssignment_4
            {
            pushFollow(FOLLOW_rule__Modules__RuleNameAssignment_4_in_rule__Modules__Group__4__Impl2574);
            rule__Modules__RuleNameAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getModulesAccess().getRuleNameAssignment_4()); 

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
    // $ANTLR end "rule__Modules__Group__4__Impl"


    // $ANTLR start "rule__Modules__Group__5"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1301:1: rule__Modules__Group__5 : rule__Modules__Group__5__Impl ;
    public final void rule__Modules__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1305:1: ( rule__Modules__Group__5__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1306:2: rule__Modules__Group__5__Impl
            {
            pushFollow(FOLLOW_rule__Modules__Group__5__Impl_in_rule__Modules__Group__52604);
            rule__Modules__Group__5__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modules__Group__5"


    // $ANTLR start "rule__Modules__Group__5__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1312:1: rule__Modules__Group__5__Impl : ( ( rule__Modules__Group_5__0 )* ) ;
    public final void rule__Modules__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1316:1: ( ( ( rule__Modules__Group_5__0 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1317:1: ( ( rule__Modules__Group_5__0 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1317:1: ( ( rule__Modules__Group_5__0 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1318:1: ( rule__Modules__Group_5__0 )*
            {
             before(grammarAccess.getModulesAccess().getGroup_5()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1319:1: ( rule__Modules__Group_5__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==20) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1319:2: rule__Modules__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__Modules__Group_5__0_in_rule__Modules__Group__5__Impl2631);
            	    rule__Modules__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getModulesAccess().getGroup_5()); 

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
    // $ANTLR end "rule__Modules__Group__5__Impl"


    // $ANTLR start "rule__Modules__Group_5__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1341:1: rule__Modules__Group_5__0 : rule__Modules__Group_5__0__Impl rule__Modules__Group_5__1 ;
    public final void rule__Modules__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1345:1: ( rule__Modules__Group_5__0__Impl rule__Modules__Group_5__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1346:2: rule__Modules__Group_5__0__Impl rule__Modules__Group_5__1
            {
            pushFollow(FOLLOW_rule__Modules__Group_5__0__Impl_in_rule__Modules__Group_5__02674);
            rule__Modules__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Modules__Group_5__1_in_rule__Modules__Group_5__02677);
            rule__Modules__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modules__Group_5__0"


    // $ANTLR start "rule__Modules__Group_5__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1353:1: rule__Modules__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Modules__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1357:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1358:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1358:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1359:1: ','
            {
             before(grammarAccess.getModulesAccess().getCommaKeyword_5_0()); 
            match(input,20,FOLLOW_20_in_rule__Modules__Group_5__0__Impl2705); 
             after(grammarAccess.getModulesAccess().getCommaKeyword_5_0()); 

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
    // $ANTLR end "rule__Modules__Group_5__0__Impl"


    // $ANTLR start "rule__Modules__Group_5__1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1372:1: rule__Modules__Group_5__1 : rule__Modules__Group_5__1__Impl ;
    public final void rule__Modules__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1376:1: ( rule__Modules__Group_5__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1377:2: rule__Modules__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__Modules__Group_5__1__Impl_in_rule__Modules__Group_5__12736);
            rule__Modules__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Modules__Group_5__1"


    // $ANTLR start "rule__Modules__Group_5__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1383:1: rule__Modules__Group_5__1__Impl : ( ( rule__Modules__RuleNameAssignment_5_1 ) ) ;
    public final void rule__Modules__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1387:1: ( ( ( rule__Modules__RuleNameAssignment_5_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1388:1: ( ( rule__Modules__RuleNameAssignment_5_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1388:1: ( ( rule__Modules__RuleNameAssignment_5_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1389:1: ( rule__Modules__RuleNameAssignment_5_1 )
            {
             before(grammarAccess.getModulesAccess().getRuleNameAssignment_5_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1390:1: ( rule__Modules__RuleNameAssignment_5_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1390:2: rule__Modules__RuleNameAssignment_5_1
            {
            pushFollow(FOLLOW_rule__Modules__RuleNameAssignment_5_1_in_rule__Modules__Group_5__1__Impl2763);
            rule__Modules__RuleNameAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getModulesAccess().getRuleNameAssignment_5_1()); 

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
    // $ANTLR end "rule__Modules__Group_5__1__Impl"


    // $ANTLR start "rule__TransformationList__Group__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1404:1: rule__TransformationList__Group__0 : rule__TransformationList__Group__0__Impl rule__TransformationList__Group__1 ;
    public final void rule__TransformationList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1408:1: ( rule__TransformationList__Group__0__Impl rule__TransformationList__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1409:2: rule__TransformationList__Group__0__Impl rule__TransformationList__Group__1
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__0__Impl_in_rule__TransformationList__Group__02797);
            rule__TransformationList__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationList__Group__1_in_rule__TransformationList__Group__02800);
            rule__TransformationList__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1416:1: rule__TransformationList__Group__0__Impl : ( 'Transformations' ) ;
    public final void rule__TransformationList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1420:1: ( ( 'Transformations' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1421:1: ( 'Transformations' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1421:1: ( 'Transformations' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1422:1: 'Transformations'
            {
             before(grammarAccess.getTransformationListAccess().getTransformationsKeyword_0()); 
            match(input,21,FOLLOW_21_in_rule__TransformationList__Group__0__Impl2828); 
             after(grammarAccess.getTransformationListAccess().getTransformationsKeyword_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1435:1: rule__TransformationList__Group__1 : rule__TransformationList__Group__1__Impl rule__TransformationList__Group__2 ;
    public final void rule__TransformationList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1439:1: ( rule__TransformationList__Group__1__Impl rule__TransformationList__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1440:2: rule__TransformationList__Group__1__Impl rule__TransformationList__Group__2
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__1__Impl_in_rule__TransformationList__Group__12859);
            rule__TransformationList__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationList__Group__2_in_rule__TransformationList__Group__12862);
            rule__TransformationList__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1447:1: rule__TransformationList__Group__1__Impl : ( '{' ) ;
    public final void rule__TransformationList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1451:1: ( ( '{' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1452:1: ( '{' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1452:1: ( '{' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1453:1: '{'
            {
             before(grammarAccess.getTransformationListAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,16,FOLLOW_16_in_rule__TransformationList__Group__1__Impl2890); 
             after(grammarAccess.getTransformationListAccess().getLeftCurlyBracketKeyword_1()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1466:1: rule__TransformationList__Group__2 : rule__TransformationList__Group__2__Impl rule__TransformationList__Group__3 ;
    public final void rule__TransformationList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1470:1: ( rule__TransformationList__Group__2__Impl rule__TransformationList__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1471:2: rule__TransformationList__Group__2__Impl rule__TransformationList__Group__3
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__2__Impl_in_rule__TransformationList__Group__22921);
            rule__TransformationList__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationList__Group__3_in_rule__TransformationList__Group__22924);
            rule__TransformationList__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1478:1: rule__TransformationList__Group__2__Impl : ( ( rule__TransformationList__TransformationsAssignment_2 ) ) ;
    public final void rule__TransformationList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1482:1: ( ( ( rule__TransformationList__TransformationsAssignment_2 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1483:1: ( ( rule__TransformationList__TransformationsAssignment_2 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1483:1: ( ( rule__TransformationList__TransformationsAssignment_2 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1484:1: ( rule__TransformationList__TransformationsAssignment_2 )
            {
             before(grammarAccess.getTransformationListAccess().getTransformationsAssignment_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1485:1: ( rule__TransformationList__TransformationsAssignment_2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1485:2: rule__TransformationList__TransformationsAssignment_2
            {
            pushFollow(FOLLOW_rule__TransformationList__TransformationsAssignment_2_in_rule__TransformationList__Group__2__Impl2951);
            rule__TransformationList__TransformationsAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTransformationListAccess().getTransformationsAssignment_2()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1495:1: rule__TransformationList__Group__3 : rule__TransformationList__Group__3__Impl rule__TransformationList__Group__4 ;
    public final void rule__TransformationList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1499:1: ( rule__TransformationList__Group__3__Impl rule__TransformationList__Group__4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1500:2: rule__TransformationList__Group__3__Impl rule__TransformationList__Group__4
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__3__Impl_in_rule__TransformationList__Group__32981);
            rule__TransformationList__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationList__Group__4_in_rule__TransformationList__Group__32984);
            rule__TransformationList__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1507:1: rule__TransformationList__Group__3__Impl : ( ( rule__TransformationList__Group_3__0 )* ) ;
    public final void rule__TransformationList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1511:1: ( ( ( rule__TransformationList__Group_3__0 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1512:1: ( ( rule__TransformationList__Group_3__0 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1512:1: ( ( rule__TransformationList__Group_3__0 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1513:1: ( rule__TransformationList__Group_3__0 )*
            {
             before(grammarAccess.getTransformationListAccess().getGroup_3()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1514:1: ( rule__TransformationList__Group_3__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==20) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1514:2: rule__TransformationList__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__TransformationList__Group_3__0_in_rule__TransformationList__Group__3__Impl3011);
            	    rule__TransformationList__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

             after(grammarAccess.getTransformationListAccess().getGroup_3()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1524:1: rule__TransformationList__Group__4 : rule__TransformationList__Group__4__Impl ;
    public final void rule__TransformationList__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1528:1: ( rule__TransformationList__Group__4__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1529:2: rule__TransformationList__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__4__Impl_in_rule__TransformationList__Group__43042);
            rule__TransformationList__Group__4__Impl();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1535:1: rule__TransformationList__Group__4__Impl : ( '}' ) ;
    public final void rule__TransformationList__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1539:1: ( ( '}' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1540:1: ( '}' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1540:1: ( '}' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1541:1: '}'
            {
             before(grammarAccess.getTransformationListAccess().getRightCurlyBracketKeyword_4()); 
            match(input,17,FOLLOW_17_in_rule__TransformationList__Group__4__Impl3070); 
             after(grammarAccess.getTransformationListAccess().getRightCurlyBracketKeyword_4()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1564:1: rule__TransformationList__Group_3__0 : rule__TransformationList__Group_3__0__Impl rule__TransformationList__Group_3__1 ;
    public final void rule__TransformationList__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1568:1: ( rule__TransformationList__Group_3__0__Impl rule__TransformationList__Group_3__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1569:2: rule__TransformationList__Group_3__0__Impl rule__TransformationList__Group_3__1
            {
            pushFollow(FOLLOW_rule__TransformationList__Group_3__0__Impl_in_rule__TransformationList__Group_3__03111);
            rule__TransformationList__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationList__Group_3__1_in_rule__TransformationList__Group_3__03114);
            rule__TransformationList__Group_3__1();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1576:1: rule__TransformationList__Group_3__0__Impl : ( ',' ) ;
    public final void rule__TransformationList__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1580:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1581:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1581:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1582:1: ','
            {
             before(grammarAccess.getTransformationListAccess().getCommaKeyword_3_0()); 
            match(input,20,FOLLOW_20_in_rule__TransformationList__Group_3__0__Impl3142); 
             after(grammarAccess.getTransformationListAccess().getCommaKeyword_3_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1595:1: rule__TransformationList__Group_3__1 : rule__TransformationList__Group_3__1__Impl ;
    public final void rule__TransformationList__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1599:1: ( rule__TransformationList__Group_3__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1600:2: rule__TransformationList__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__TransformationList__Group_3__1__Impl_in_rule__TransformationList__Group_3__13173);
            rule__TransformationList__Group_3__1__Impl();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1606:1: rule__TransformationList__Group_3__1__Impl : ( ( rule__TransformationList__TransformationsAssignment_3_1 ) ) ;
    public final void rule__TransformationList__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1610:1: ( ( ( rule__TransformationList__TransformationsAssignment_3_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1611:1: ( ( rule__TransformationList__TransformationsAssignment_3_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1611:1: ( ( rule__TransformationList__TransformationsAssignment_3_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1612:1: ( rule__TransformationList__TransformationsAssignment_3_1 )
            {
             before(grammarAccess.getTransformationListAccess().getTransformationsAssignment_3_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1613:1: ( rule__TransformationList__TransformationsAssignment_3_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1613:2: rule__TransformationList__TransformationsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__TransformationList__TransformationsAssignment_3_1_in_rule__TransformationList__Group_3__1__Impl3200);
            rule__TransformationList__TransformationsAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTransformationListAccess().getTransformationsAssignment_3_1()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1627:1: rule__Transformation__Group__0 : rule__Transformation__Group__0__Impl rule__Transformation__Group__1 ;
    public final void rule__Transformation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1631:1: ( rule__Transformation__Group__0__Impl rule__Transformation__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1632:2: rule__Transformation__Group__0__Impl rule__Transformation__Group__1
            {
            pushFollow(FOLLOW_rule__Transformation__Group__0__Impl_in_rule__Transformation__Group__03234);
            rule__Transformation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group__1_in_rule__Transformation__Group__03237);
            rule__Transformation__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1639:1: rule__Transformation__Group__0__Impl : ( ( rule__Transformation__NameAssignment_0 ) ) ;
    public final void rule__Transformation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1643:1: ( ( ( rule__Transformation__NameAssignment_0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1644:1: ( ( rule__Transformation__NameAssignment_0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1644:1: ( ( rule__Transformation__NameAssignment_0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1645:1: ( rule__Transformation__NameAssignment_0 )
            {
             before(grammarAccess.getTransformationAccess().getNameAssignment_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1646:1: ( rule__Transformation__NameAssignment_0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1646:2: rule__Transformation__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Transformation__NameAssignment_0_in_rule__Transformation__Group__0__Impl3264);
            rule__Transformation__NameAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTransformationAccess().getNameAssignment_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1656:1: rule__Transformation__Group__1 : rule__Transformation__Group__1__Impl rule__Transformation__Group__2 ;
    public final void rule__Transformation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1660:1: ( rule__Transformation__Group__1__Impl rule__Transformation__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1661:2: rule__Transformation__Group__1__Impl rule__Transformation__Group__2
            {
            pushFollow(FOLLOW_rule__Transformation__Group__1__Impl_in_rule__Transformation__Group__13294);
            rule__Transformation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group__2_in_rule__Transformation__Group__13297);
            rule__Transformation__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1668:1: rule__Transformation__Group__1__Impl : ( '{' ) ;
    public final void rule__Transformation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1672:1: ( ( '{' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1673:1: ( '{' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1673:1: ( '{' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1674:1: '{'
            {
             before(grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,16,FOLLOW_16_in_rule__Transformation__Group__1__Impl3325); 
             after(grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_1()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1687:1: rule__Transformation__Group__2 : rule__Transformation__Group__2__Impl rule__Transformation__Group__3 ;
    public final void rule__Transformation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1691:1: ( rule__Transformation__Group__2__Impl rule__Transformation__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1692:2: rule__Transformation__Group__2__Impl rule__Transformation__Group__3
            {
            pushFollow(FOLLOW_rule__Transformation__Group__2__Impl_in_rule__Transformation__Group__23356);
            rule__Transformation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group__3_in_rule__Transformation__Group__23359);
            rule__Transformation__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1699:1: rule__Transformation__Group__2__Impl : ( 'modules' ) ;
    public final void rule__Transformation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1703:1: ( ( 'modules' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1704:1: ( 'modules' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1704:1: ( 'modules' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1705:1: 'modules'
            {
             before(grammarAccess.getTransformationAccess().getModulesKeyword_2()); 
            match(input,22,FOLLOW_22_in_rule__Transformation__Group__2__Impl3387); 
             after(grammarAccess.getTransformationAccess().getModulesKeyword_2()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1718:1: rule__Transformation__Group__3 : rule__Transformation__Group__3__Impl rule__Transformation__Group__4 ;
    public final void rule__Transformation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1722:1: ( rule__Transformation__Group__3__Impl rule__Transformation__Group__4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1723:2: rule__Transformation__Group__3__Impl rule__Transformation__Group__4
            {
            pushFollow(FOLLOW_rule__Transformation__Group__3__Impl_in_rule__Transformation__Group__33418);
            rule__Transformation__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group__4_in_rule__Transformation__Group__33421);
            rule__Transformation__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1730:1: rule__Transformation__Group__3__Impl : ( ':' ) ;
    public final void rule__Transformation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1734:1: ( ( ':' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1735:1: ( ':' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1735:1: ( ':' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1736:1: ':'
            {
             before(grammarAccess.getTransformationAccess().getColonKeyword_3()); 
            match(input,19,FOLLOW_19_in_rule__Transformation__Group__3__Impl3449); 
             after(grammarAccess.getTransformationAccess().getColonKeyword_3()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1749:1: rule__Transformation__Group__4 : rule__Transformation__Group__4__Impl rule__Transformation__Group__5 ;
    public final void rule__Transformation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1753:1: ( rule__Transformation__Group__4__Impl rule__Transformation__Group__5 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1754:2: rule__Transformation__Group__4__Impl rule__Transformation__Group__5
            {
            pushFollow(FOLLOW_rule__Transformation__Group__4__Impl_in_rule__Transformation__Group__43480);
            rule__Transformation__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group__5_in_rule__Transformation__Group__43483);
            rule__Transformation__Group__5();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1761:1: rule__Transformation__Group__4__Impl : ( ( rule__Transformation__ModulesAssignment_4 ) ) ;
    public final void rule__Transformation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1765:1: ( ( ( rule__Transformation__ModulesAssignment_4 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1766:1: ( ( rule__Transformation__ModulesAssignment_4 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1766:1: ( ( rule__Transformation__ModulesAssignment_4 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1767:1: ( rule__Transformation__ModulesAssignment_4 )
            {
             before(grammarAccess.getTransformationAccess().getModulesAssignment_4()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1768:1: ( rule__Transformation__ModulesAssignment_4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1768:2: rule__Transformation__ModulesAssignment_4
            {
            pushFollow(FOLLOW_rule__Transformation__ModulesAssignment_4_in_rule__Transformation__Group__4__Impl3510);
            rule__Transformation__ModulesAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTransformationAccess().getModulesAssignment_4()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1778:1: rule__Transformation__Group__5 : rule__Transformation__Group__5__Impl rule__Transformation__Group__6 ;
    public final void rule__Transformation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1782:1: ( rule__Transformation__Group__5__Impl rule__Transformation__Group__6 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1783:2: rule__Transformation__Group__5__Impl rule__Transformation__Group__6
            {
            pushFollow(FOLLOW_rule__Transformation__Group__5__Impl_in_rule__Transformation__Group__53540);
            rule__Transformation__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group__6_in_rule__Transformation__Group__53543);
            rule__Transformation__Group__6();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1790:1: rule__Transformation__Group__5__Impl : ( ( rule__Transformation__Group_5__0 )* ) ;
    public final void rule__Transformation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1794:1: ( ( ( rule__Transformation__Group_5__0 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1795:1: ( ( rule__Transformation__Group_5__0 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1795:1: ( ( rule__Transformation__Group_5__0 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1796:1: ( rule__Transformation__Group_5__0 )*
            {
             before(grammarAccess.getTransformationAccess().getGroup_5()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1797:1: ( rule__Transformation__Group_5__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==20) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1797:2: rule__Transformation__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__Transformation__Group_5__0_in_rule__Transformation__Group__5__Impl3570);
            	    rule__Transformation__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getTransformationAccess().getGroup_5()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1807:1: rule__Transformation__Group__6 : rule__Transformation__Group__6__Impl rule__Transformation__Group__7 ;
    public final void rule__Transformation__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1811:1: ( rule__Transformation__Group__6__Impl rule__Transformation__Group__7 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1812:2: rule__Transformation__Group__6__Impl rule__Transformation__Group__7
            {
            pushFollow(FOLLOW_rule__Transformation__Group__6__Impl_in_rule__Transformation__Group__63601);
            rule__Transformation__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group__7_in_rule__Transformation__Group__63604);
            rule__Transformation__Group__7();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1819:1: rule__Transformation__Group__6__Impl : ( ( rule__Transformation__Group_6__0 )? ) ;
    public final void rule__Transformation__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1823:1: ( ( ( rule__Transformation__Group_6__0 )? ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1824:1: ( ( rule__Transformation__Group_6__0 )? )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1824:1: ( ( rule__Transformation__Group_6__0 )? )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1825:1: ( rule__Transformation__Group_6__0 )?
            {
             before(grammarAccess.getTransformationAccess().getGroup_6()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1826:1: ( rule__Transformation__Group_6__0 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==23) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1826:2: rule__Transformation__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__Transformation__Group_6__0_in_rule__Transformation__Group__6__Impl3631);
                    rule__Transformation__Group_6__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransformationAccess().getGroup_6()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1836:1: rule__Transformation__Group__7 : rule__Transformation__Group__7__Impl ;
    public final void rule__Transformation__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1840:1: ( rule__Transformation__Group__7__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1841:2: rule__Transformation__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__Transformation__Group__7__Impl_in_rule__Transformation__Group__73662);
            rule__Transformation__Group__7__Impl();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1847:1: rule__Transformation__Group__7__Impl : ( '}' ) ;
    public final void rule__Transformation__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1851:1: ( ( '}' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1852:1: ( '}' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1852:1: ( '}' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1853:1: '}'
            {
             before(grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_7()); 
            match(input,17,FOLLOW_17_in_rule__Transformation__Group__7__Impl3690); 
             after(grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_7()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1882:1: rule__Transformation__Group_5__0 : rule__Transformation__Group_5__0__Impl rule__Transformation__Group_5__1 ;
    public final void rule__Transformation__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1886:1: ( rule__Transformation__Group_5__0__Impl rule__Transformation__Group_5__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1887:2: rule__Transformation__Group_5__0__Impl rule__Transformation__Group_5__1
            {
            pushFollow(FOLLOW_rule__Transformation__Group_5__0__Impl_in_rule__Transformation__Group_5__03737);
            rule__Transformation__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group_5__1_in_rule__Transformation__Group_5__03740);
            rule__Transformation__Group_5__1();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1894:1: rule__Transformation__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Transformation__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1898:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1899:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1899:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1900:1: ','
            {
             before(grammarAccess.getTransformationAccess().getCommaKeyword_5_0()); 
            match(input,20,FOLLOW_20_in_rule__Transformation__Group_5__0__Impl3768); 
             after(grammarAccess.getTransformationAccess().getCommaKeyword_5_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1913:1: rule__Transformation__Group_5__1 : rule__Transformation__Group_5__1__Impl ;
    public final void rule__Transformation__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1917:1: ( rule__Transformation__Group_5__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1918:2: rule__Transformation__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__Transformation__Group_5__1__Impl_in_rule__Transformation__Group_5__13799);
            rule__Transformation__Group_5__1__Impl();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1924:1: rule__Transformation__Group_5__1__Impl : ( ( rule__Transformation__ModulesAssignment_5_1 ) ) ;
    public final void rule__Transformation__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1928:1: ( ( ( rule__Transformation__ModulesAssignment_5_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1929:1: ( ( rule__Transformation__ModulesAssignment_5_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1929:1: ( ( rule__Transformation__ModulesAssignment_5_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1930:1: ( rule__Transformation__ModulesAssignment_5_1 )
            {
             before(grammarAccess.getTransformationAccess().getModulesAssignment_5_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1931:1: ( rule__Transformation__ModulesAssignment_5_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1931:2: rule__Transformation__ModulesAssignment_5_1
            {
            pushFollow(FOLLOW_rule__Transformation__ModulesAssignment_5_1_in_rule__Transformation__Group_5__1__Impl3826);
            rule__Transformation__ModulesAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getTransformationAccess().getModulesAssignment_5_1()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1945:1: rule__Transformation__Group_6__0 : rule__Transformation__Group_6__0__Impl rule__Transformation__Group_6__1 ;
    public final void rule__Transformation__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1949:1: ( rule__Transformation__Group_6__0__Impl rule__Transformation__Group_6__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1950:2: rule__Transformation__Group_6__0__Impl rule__Transformation__Group_6__1
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6__0__Impl_in_rule__Transformation__Group_6__03860);
            rule__Transformation__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group_6__1_in_rule__Transformation__Group_6__03863);
            rule__Transformation__Group_6__1();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1957:1: rule__Transformation__Group_6__0__Impl : ( 'impacts' ) ;
    public final void rule__Transformation__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1961:1: ( ( 'impacts' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1962:1: ( 'impacts' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1962:1: ( 'impacts' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1963:1: 'impacts'
            {
             before(grammarAccess.getTransformationAccess().getImpactsKeyword_6_0()); 
            match(input,23,FOLLOW_23_in_rule__Transformation__Group_6__0__Impl3891); 
             after(grammarAccess.getTransformationAccess().getImpactsKeyword_6_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1976:1: rule__Transformation__Group_6__1 : rule__Transformation__Group_6__1__Impl rule__Transformation__Group_6__2 ;
    public final void rule__Transformation__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1980:1: ( rule__Transformation__Group_6__1__Impl rule__Transformation__Group_6__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1981:2: rule__Transformation__Group_6__1__Impl rule__Transformation__Group_6__2
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6__1__Impl_in_rule__Transformation__Group_6__13922);
            rule__Transformation__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group_6__2_in_rule__Transformation__Group_6__13925);
            rule__Transformation__Group_6__2();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1988:1: rule__Transformation__Group_6__1__Impl : ( ':' ) ;
    public final void rule__Transformation__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1992:1: ( ( ':' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1993:1: ( ':' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1993:1: ( ':' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1994:1: ':'
            {
             before(grammarAccess.getTransformationAccess().getColonKeyword_6_1()); 
            match(input,19,FOLLOW_19_in_rule__Transformation__Group_6__1__Impl3953); 
             after(grammarAccess.getTransformationAccess().getColonKeyword_6_1()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2007:1: rule__Transformation__Group_6__2 : rule__Transformation__Group_6__2__Impl rule__Transformation__Group_6__3 ;
    public final void rule__Transformation__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2011:1: ( rule__Transformation__Group_6__2__Impl rule__Transformation__Group_6__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2012:2: rule__Transformation__Group_6__2__Impl rule__Transformation__Group_6__3
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6__2__Impl_in_rule__Transformation__Group_6__23984);
            rule__Transformation__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group_6__3_in_rule__Transformation__Group_6__23987);
            rule__Transformation__Group_6__3();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2019:1: rule__Transformation__Group_6__2__Impl : ( ( rule__Transformation__ImpactsAssignment_6_2 ) ) ;
    public final void rule__Transformation__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2023:1: ( ( ( rule__Transformation__ImpactsAssignment_6_2 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2024:1: ( ( rule__Transformation__ImpactsAssignment_6_2 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2024:1: ( ( rule__Transformation__ImpactsAssignment_6_2 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2025:1: ( rule__Transformation__ImpactsAssignment_6_2 )
            {
             before(grammarAccess.getTransformationAccess().getImpactsAssignment_6_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2026:1: ( rule__Transformation__ImpactsAssignment_6_2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2026:2: rule__Transformation__ImpactsAssignment_6_2
            {
            pushFollow(FOLLOW_rule__Transformation__ImpactsAssignment_6_2_in_rule__Transformation__Group_6__2__Impl4014);
            rule__Transformation__ImpactsAssignment_6_2();

            state._fsp--;


            }

             after(grammarAccess.getTransformationAccess().getImpactsAssignment_6_2()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2036:1: rule__Transformation__Group_6__3 : rule__Transformation__Group_6__3__Impl ;
    public final void rule__Transformation__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2040:1: ( rule__Transformation__Group_6__3__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2041:2: rule__Transformation__Group_6__3__Impl
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6__3__Impl_in_rule__Transformation__Group_6__34044);
            rule__Transformation__Group_6__3__Impl();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2047:1: rule__Transformation__Group_6__3__Impl : ( ( rule__Transformation__Group_6_3__0 )* ) ;
    public final void rule__Transformation__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2051:1: ( ( ( rule__Transformation__Group_6_3__0 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2052:1: ( ( rule__Transformation__Group_6_3__0 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2052:1: ( ( rule__Transformation__Group_6_3__0 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2053:1: ( rule__Transformation__Group_6_3__0 )*
            {
             before(grammarAccess.getTransformationAccess().getGroup_6_3()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2054:1: ( rule__Transformation__Group_6_3__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==20) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2054:2: rule__Transformation__Group_6_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Transformation__Group_6_3__0_in_rule__Transformation__Group_6__3__Impl4071);
            	    rule__Transformation__Group_6_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

             after(grammarAccess.getTransformationAccess().getGroup_6_3()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2072:1: rule__Transformation__Group_6_3__0 : rule__Transformation__Group_6_3__0__Impl rule__Transformation__Group_6_3__1 ;
    public final void rule__Transformation__Group_6_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2076:1: ( rule__Transformation__Group_6_3__0__Impl rule__Transformation__Group_6_3__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2077:2: rule__Transformation__Group_6_3__0__Impl rule__Transformation__Group_6_3__1
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6_3__0__Impl_in_rule__Transformation__Group_6_3__04110);
            rule__Transformation__Group_6_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group_6_3__1_in_rule__Transformation__Group_6_3__04113);
            rule__Transformation__Group_6_3__1();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2084:1: rule__Transformation__Group_6_3__0__Impl : ( ',' ) ;
    public final void rule__Transformation__Group_6_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2088:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2089:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2089:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2090:1: ','
            {
             before(grammarAccess.getTransformationAccess().getCommaKeyword_6_3_0()); 
            match(input,20,FOLLOW_20_in_rule__Transformation__Group_6_3__0__Impl4141); 
             after(grammarAccess.getTransformationAccess().getCommaKeyword_6_3_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2103:1: rule__Transformation__Group_6_3__1 : rule__Transformation__Group_6_3__1__Impl ;
    public final void rule__Transformation__Group_6_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2107:1: ( rule__Transformation__Group_6_3__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2108:2: rule__Transformation__Group_6_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6_3__1__Impl_in_rule__Transformation__Group_6_3__14172);
            rule__Transformation__Group_6_3__1__Impl();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2114:1: rule__Transformation__Group_6_3__1__Impl : ( ( rule__Transformation__ImpactsAssignment_6_3_1 ) ) ;
    public final void rule__Transformation__Group_6_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2118:1: ( ( ( rule__Transformation__ImpactsAssignment_6_3_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2119:1: ( ( rule__Transformation__ImpactsAssignment_6_3_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2119:1: ( ( rule__Transformation__ImpactsAssignment_6_3_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2120:1: ( rule__Transformation__ImpactsAssignment_6_3_1 )
            {
             before(grammarAccess.getTransformationAccess().getImpactsAssignment_6_3_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2121:1: ( rule__Transformation__ImpactsAssignment_6_3_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2121:2: rule__Transformation__ImpactsAssignment_6_3_1
            {
            pushFollow(FOLLOW_rule__Transformation__ImpactsAssignment_6_3_1_in_rule__Transformation__Group_6_3__1__Impl4199);
            rule__Transformation__ImpactsAssignment_6_3_1();

            state._fsp--;


            }

             after(grammarAccess.getTransformationAccess().getImpactsAssignment_6_3_1()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2135:1: rule__TransformationImpact__Group__0 : rule__TransformationImpact__Group__0__Impl rule__TransformationImpact__Group__1 ;
    public final void rule__TransformationImpact__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2139:1: ( rule__TransformationImpact__Group__0__Impl rule__TransformationImpact__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2140:2: rule__TransformationImpact__Group__0__Impl rule__TransformationImpact__Group__1
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group__0__Impl_in_rule__TransformationImpact__Group__04233);
            rule__TransformationImpact__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationImpact__Group__1_in_rule__TransformationImpact__Group__04236);
            rule__TransformationImpact__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2147:1: rule__TransformationImpact__Group__0__Impl : ( '(' ) ;
    public final void rule__TransformationImpact__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2151:1: ( ( '(' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2152:1: ( '(' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2152:1: ( '(' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2153:1: '('
            {
             before(grammarAccess.getTransformationImpactAccess().getLeftParenthesisKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__TransformationImpact__Group__0__Impl4264); 
             after(grammarAccess.getTransformationImpactAccess().getLeftParenthesisKeyword_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2166:1: rule__TransformationImpact__Group__1 : rule__TransformationImpact__Group__1__Impl rule__TransformationImpact__Group__2 ;
    public final void rule__TransformationImpact__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2170:1: ( rule__TransformationImpact__Group__1__Impl rule__TransformationImpact__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2171:2: rule__TransformationImpact__Group__1__Impl rule__TransformationImpact__Group__2
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group__1__Impl_in_rule__TransformationImpact__Group__14295);
            rule__TransformationImpact__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationImpact__Group__2_in_rule__TransformationImpact__Group__14298);
            rule__TransformationImpact__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2178:1: rule__TransformationImpact__Group__1__Impl : ( ( rule__TransformationImpact__Group_1__0 )? ) ;
    public final void rule__TransformationImpact__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2182:1: ( ( ( rule__TransformationImpact__Group_1__0 )? ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2183:1: ( ( rule__TransformationImpact__Group_1__0 )? )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2183:1: ( ( rule__TransformationImpact__Group_1__0 )? )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2184:1: ( rule__TransformationImpact__Group_1__0 )?
            {
             before(grammarAccess.getTransformationImpactAccess().getGroup_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2185:1: ( rule__TransformationImpact__Group_1__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( ((LA14_0>=RULE_STRING && LA14_0<=RULE_ID)) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2185:2: rule__TransformationImpact__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__TransformationImpact__Group_1__0_in_rule__TransformationImpact__Group__1__Impl4325);
                    rule__TransformationImpact__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransformationImpactAccess().getGroup_1()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2195:1: rule__TransformationImpact__Group__2 : rule__TransformationImpact__Group__2__Impl rule__TransformationImpact__Group__3 ;
    public final void rule__TransformationImpact__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2199:1: ( rule__TransformationImpact__Group__2__Impl rule__TransformationImpact__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2200:2: rule__TransformationImpact__Group__2__Impl rule__TransformationImpact__Group__3
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group__2__Impl_in_rule__TransformationImpact__Group__24356);
            rule__TransformationImpact__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationImpact__Group__3_in_rule__TransformationImpact__Group__24359);
            rule__TransformationImpact__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2207:1: rule__TransformationImpact__Group__2__Impl : ( ( rule__TransformationImpact__ImpactValueAssignment_2 ) ) ;
    public final void rule__TransformationImpact__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2211:1: ( ( ( rule__TransformationImpact__ImpactValueAssignment_2 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2212:1: ( ( rule__TransformationImpact__ImpactValueAssignment_2 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2212:1: ( ( rule__TransformationImpact__ImpactValueAssignment_2 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2213:1: ( rule__TransformationImpact__ImpactValueAssignment_2 )
            {
             before(grammarAccess.getTransformationImpactAccess().getImpactValueAssignment_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2214:1: ( rule__TransformationImpact__ImpactValueAssignment_2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2214:2: rule__TransformationImpact__ImpactValueAssignment_2
            {
            pushFollow(FOLLOW_rule__TransformationImpact__ImpactValueAssignment_2_in_rule__TransformationImpact__Group__2__Impl4386);
            rule__TransformationImpact__ImpactValueAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTransformationImpactAccess().getImpactValueAssignment_2()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2224:1: rule__TransformationImpact__Group__3 : rule__TransformationImpact__Group__3__Impl ;
    public final void rule__TransformationImpact__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2228:1: ( rule__TransformationImpact__Group__3__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2229:2: rule__TransformationImpact__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group__3__Impl_in_rule__TransformationImpact__Group__34416);
            rule__TransformationImpact__Group__3__Impl();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2235:1: rule__TransformationImpact__Group__3__Impl : ( ')' ) ;
    public final void rule__TransformationImpact__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2239:1: ( ( ')' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2240:1: ( ')' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2240:1: ( ')' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2241:1: ')'
            {
             before(grammarAccess.getTransformationImpactAccess().getRightParenthesisKeyword_3()); 
            match(input,25,FOLLOW_25_in_rule__TransformationImpact__Group__3__Impl4444); 
             after(grammarAccess.getTransformationImpactAccess().getRightParenthesisKeyword_3()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2262:1: rule__TransformationImpact__Group_1__0 : rule__TransformationImpact__Group_1__0__Impl rule__TransformationImpact__Group_1__1 ;
    public final void rule__TransformationImpact__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2266:1: ( rule__TransformationImpact__Group_1__0__Impl rule__TransformationImpact__Group_1__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2267:2: rule__TransformationImpact__Group_1__0__Impl rule__TransformationImpact__Group_1__1
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group_1__0__Impl_in_rule__TransformationImpact__Group_1__04483);
            rule__TransformationImpact__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationImpact__Group_1__1_in_rule__TransformationImpact__Group_1__04486);
            rule__TransformationImpact__Group_1__1();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2274:1: rule__TransformationImpact__Group_1__0__Impl : ( ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 ) ) ;
    public final void rule__TransformationImpact__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2278:1: ( ( ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2279:1: ( ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2279:1: ( ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2280:1: ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 )
            {
             before(grammarAccess.getTransformationImpactAccess().getQualityAttributeNameAssignment_1_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2281:1: ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2281:2: rule__TransformationImpact__QualityAttributeNameAssignment_1_0
            {
            pushFollow(FOLLOW_rule__TransformationImpact__QualityAttributeNameAssignment_1_0_in_rule__TransformationImpact__Group_1__0__Impl4513);
            rule__TransformationImpact__QualityAttributeNameAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTransformationImpactAccess().getQualityAttributeNameAssignment_1_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2291:1: rule__TransformationImpact__Group_1__1 : rule__TransformationImpact__Group_1__1__Impl ;
    public final void rule__TransformationImpact__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2295:1: ( rule__TransformationImpact__Group_1__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2296:2: rule__TransformationImpact__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group_1__1__Impl_in_rule__TransformationImpact__Group_1__14543);
            rule__TransformationImpact__Group_1__1__Impl();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2302:1: rule__TransformationImpact__Group_1__1__Impl : ( ',' ) ;
    public final void rule__TransformationImpact__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2306:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2307:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2307:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2308:1: ','
            {
             before(grammarAccess.getTransformationImpactAccess().getCommaKeyword_1_1()); 
            match(input,20,FOLLOW_20_in_rule__TransformationImpact__Group_1__1__Impl4571); 
             after(grammarAccess.getTransformationImpactAccess().getCommaKeyword_1_1()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2325:1: rule__TransformationDependencyList__Group__0 : rule__TransformationDependencyList__Group__0__Impl rule__TransformationDependencyList__Group__1 ;
    public final void rule__TransformationDependencyList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2329:1: ( rule__TransformationDependencyList__Group__0__Impl rule__TransformationDependencyList__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2330:2: rule__TransformationDependencyList__Group__0__Impl rule__TransformationDependencyList__Group__1
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__0__Impl_in_rule__TransformationDependencyList__Group__04606);
            rule__TransformationDependencyList__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__1_in_rule__TransformationDependencyList__Group__04609);
            rule__TransformationDependencyList__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2337:1: rule__TransformationDependencyList__Group__0__Impl : ( 'Dependencies' ) ;
    public final void rule__TransformationDependencyList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2341:1: ( ( 'Dependencies' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2342:1: ( 'Dependencies' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2342:1: ( 'Dependencies' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2343:1: 'Dependencies'
            {
             before(grammarAccess.getTransformationDependencyListAccess().getDependenciesKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__TransformationDependencyList__Group__0__Impl4637); 
             after(grammarAccess.getTransformationDependencyListAccess().getDependenciesKeyword_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2356:1: rule__TransformationDependencyList__Group__1 : rule__TransformationDependencyList__Group__1__Impl rule__TransformationDependencyList__Group__2 ;
    public final void rule__TransformationDependencyList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2360:1: ( rule__TransformationDependencyList__Group__1__Impl rule__TransformationDependencyList__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2361:2: rule__TransformationDependencyList__Group__1__Impl rule__TransformationDependencyList__Group__2
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__1__Impl_in_rule__TransformationDependencyList__Group__14668);
            rule__TransformationDependencyList__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__2_in_rule__TransformationDependencyList__Group__14671);
            rule__TransformationDependencyList__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2368:1: rule__TransformationDependencyList__Group__1__Impl : ( '{' ) ;
    public final void rule__TransformationDependencyList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2372:1: ( ( '{' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2373:1: ( '{' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2373:1: ( '{' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2374:1: '{'
            {
             before(grammarAccess.getTransformationDependencyListAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,16,FOLLOW_16_in_rule__TransformationDependencyList__Group__1__Impl4699); 
             after(grammarAccess.getTransformationDependencyListAccess().getLeftCurlyBracketKeyword_1()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2387:1: rule__TransformationDependencyList__Group__2 : rule__TransformationDependencyList__Group__2__Impl rule__TransformationDependencyList__Group__3 ;
    public final void rule__TransformationDependencyList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2391:1: ( rule__TransformationDependencyList__Group__2__Impl rule__TransformationDependencyList__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2392:2: rule__TransformationDependencyList__Group__2__Impl rule__TransformationDependencyList__Group__3
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__2__Impl_in_rule__TransformationDependencyList__Group__24730);
            rule__TransformationDependencyList__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__3_in_rule__TransformationDependencyList__Group__24733);
            rule__TransformationDependencyList__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2399:1: rule__TransformationDependencyList__Group__2__Impl : ( ( rule__TransformationDependencyList__NameAssignment_2 ) ) ;
    public final void rule__TransformationDependencyList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2403:1: ( ( ( rule__TransformationDependencyList__NameAssignment_2 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2404:1: ( ( rule__TransformationDependencyList__NameAssignment_2 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2404:1: ( ( rule__TransformationDependencyList__NameAssignment_2 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2405:1: ( rule__TransformationDependencyList__NameAssignment_2 )
            {
             before(grammarAccess.getTransformationDependencyListAccess().getNameAssignment_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2406:1: ( rule__TransformationDependencyList__NameAssignment_2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2406:2: rule__TransformationDependencyList__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__NameAssignment_2_in_rule__TransformationDependencyList__Group__2__Impl4760);
            rule__TransformationDependencyList__NameAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTransformationDependencyListAccess().getNameAssignment_2()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2416:1: rule__TransformationDependencyList__Group__3 : rule__TransformationDependencyList__Group__3__Impl rule__TransformationDependencyList__Group__4 ;
    public final void rule__TransformationDependencyList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2420:1: ( rule__TransformationDependencyList__Group__3__Impl rule__TransformationDependencyList__Group__4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2421:2: rule__TransformationDependencyList__Group__3__Impl rule__TransformationDependencyList__Group__4
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__3__Impl_in_rule__TransformationDependencyList__Group__34790);
            rule__TransformationDependencyList__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__4_in_rule__TransformationDependencyList__Group__34793);
            rule__TransformationDependencyList__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2428:1: rule__TransformationDependencyList__Group__3__Impl : ( '{' ) ;
    public final void rule__TransformationDependencyList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2432:1: ( ( '{' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2433:1: ( '{' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2433:1: ( '{' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2434:1: '{'
            {
             before(grammarAccess.getTransformationDependencyListAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,16,FOLLOW_16_in_rule__TransformationDependencyList__Group__3__Impl4821); 
             after(grammarAccess.getTransformationDependencyListAccess().getLeftCurlyBracketKeyword_3()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2447:1: rule__TransformationDependencyList__Group__4 : rule__TransformationDependencyList__Group__4__Impl rule__TransformationDependencyList__Group__5 ;
    public final void rule__TransformationDependencyList__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2451:1: ( rule__TransformationDependencyList__Group__4__Impl rule__TransformationDependencyList__Group__5 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2452:2: rule__TransformationDependencyList__Group__4__Impl rule__TransformationDependencyList__Group__5
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__4__Impl_in_rule__TransformationDependencyList__Group__44852);
            rule__TransformationDependencyList__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__5_in_rule__TransformationDependencyList__Group__44855);
            rule__TransformationDependencyList__Group__5();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2459:1: rule__TransformationDependencyList__Group__4__Impl : ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4 ) ) ;
    public final void rule__TransformationDependencyList__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2463:1: ( ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2464:1: ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2464:1: ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2465:1: ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4 )
            {
             before(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesAssignment_4()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2466:1: ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2466:2: rule__TransformationDependencyList__TransformationDependenciesAssignment_4
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__TransformationDependenciesAssignment_4_in_rule__TransformationDependencyList__Group__4__Impl4882);
            rule__TransformationDependencyList__TransformationDependenciesAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesAssignment_4()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2476:1: rule__TransformationDependencyList__Group__5 : rule__TransformationDependencyList__Group__5__Impl rule__TransformationDependencyList__Group__6 ;
    public final void rule__TransformationDependencyList__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2480:1: ( rule__TransformationDependencyList__Group__5__Impl rule__TransformationDependencyList__Group__6 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2481:2: rule__TransformationDependencyList__Group__5__Impl rule__TransformationDependencyList__Group__6
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__5__Impl_in_rule__TransformationDependencyList__Group__54912);
            rule__TransformationDependencyList__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__6_in_rule__TransformationDependencyList__Group__54915);
            rule__TransformationDependencyList__Group__6();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2488:1: rule__TransformationDependencyList__Group__5__Impl : ( ( rule__TransformationDependencyList__Group_5__0 )* ) ;
    public final void rule__TransformationDependencyList__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2492:1: ( ( ( rule__TransformationDependencyList__Group_5__0 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2493:1: ( ( rule__TransformationDependencyList__Group_5__0 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2493:1: ( ( rule__TransformationDependencyList__Group_5__0 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2494:1: ( rule__TransformationDependencyList__Group_5__0 )*
            {
             before(grammarAccess.getTransformationDependencyListAccess().getGroup_5()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2495:1: ( rule__TransformationDependencyList__Group_5__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==14) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2495:2: rule__TransformationDependencyList__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__TransformationDependencyList__Group_5__0_in_rule__TransformationDependencyList__Group__5__Impl4942);
            	    rule__TransformationDependencyList__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

             after(grammarAccess.getTransformationDependencyListAccess().getGroup_5()); 

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


    // $ANTLR start "rule__TransformationDependencyList__Group__6"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2505:1: rule__TransformationDependencyList__Group__6 : rule__TransformationDependencyList__Group__6__Impl rule__TransformationDependencyList__Group__7 ;
    public final void rule__TransformationDependencyList__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2509:1: ( rule__TransformationDependencyList__Group__6__Impl rule__TransformationDependencyList__Group__7 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2510:2: rule__TransformationDependencyList__Group__6__Impl rule__TransformationDependencyList__Group__7
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__6__Impl_in_rule__TransformationDependencyList__Group__64973);
            rule__TransformationDependencyList__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__7_in_rule__TransformationDependencyList__Group__64976);
            rule__TransformationDependencyList__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group__6"


    // $ANTLR start "rule__TransformationDependencyList__Group__6__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2517:1: rule__TransformationDependencyList__Group__6__Impl : ( '}' ) ;
    public final void rule__TransformationDependencyList__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2521:1: ( ( '}' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2522:1: ( '}' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2522:1: ( '}' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2523:1: '}'
            {
             before(grammarAccess.getTransformationDependencyListAccess().getRightCurlyBracketKeyword_6()); 
            match(input,17,FOLLOW_17_in_rule__TransformationDependencyList__Group__6__Impl5004); 
             after(grammarAccess.getTransformationDependencyListAccess().getRightCurlyBracketKeyword_6()); 

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
    // $ANTLR end "rule__TransformationDependencyList__Group__6__Impl"


    // $ANTLR start "rule__TransformationDependencyList__Group__7"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2536:1: rule__TransformationDependencyList__Group__7 : rule__TransformationDependencyList__Group__7__Impl ;
    public final void rule__TransformationDependencyList__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2540:1: ( rule__TransformationDependencyList__Group__7__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2541:2: rule__TransformationDependencyList__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__7__Impl_in_rule__TransformationDependencyList__Group__75035);
            rule__TransformationDependencyList__Group__7__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group__7"


    // $ANTLR start "rule__TransformationDependencyList__Group__7__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2547:1: rule__TransformationDependencyList__Group__7__Impl : ( '}' ) ;
    public final void rule__TransformationDependencyList__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2551:1: ( ( '}' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2552:1: ( '}' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2552:1: ( '}' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2553:1: '}'
            {
             before(grammarAccess.getTransformationDependencyListAccess().getRightCurlyBracketKeyword_7()); 
            match(input,17,FOLLOW_17_in_rule__TransformationDependencyList__Group__7__Impl5063); 
             after(grammarAccess.getTransformationDependencyListAccess().getRightCurlyBracketKeyword_7()); 

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
    // $ANTLR end "rule__TransformationDependencyList__Group__7__Impl"


    // $ANTLR start "rule__TransformationDependencyList__Group_5__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2582:1: rule__TransformationDependencyList__Group_5__0 : rule__TransformationDependencyList__Group_5__0__Impl rule__TransformationDependencyList__Group_5__1 ;
    public final void rule__TransformationDependencyList__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2586:1: ( rule__TransformationDependencyList__Group_5__0__Impl rule__TransformationDependencyList__Group_5__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2587:2: rule__TransformationDependencyList__Group_5__0__Impl rule__TransformationDependencyList__Group_5__1
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group_5__0__Impl_in_rule__TransformationDependencyList__Group_5__05110);
            rule__TransformationDependencyList__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependencyList__Group_5__1_in_rule__TransformationDependencyList__Group_5__05113);
            rule__TransformationDependencyList__Group_5__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group_5__0"


    // $ANTLR start "rule__TransformationDependencyList__Group_5__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2594:1: rule__TransformationDependencyList__Group_5__0__Impl : ( ';' ) ;
    public final void rule__TransformationDependencyList__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2598:1: ( ( ';' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2599:1: ( ';' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2599:1: ( ';' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2600:1: ';'
            {
             before(grammarAccess.getTransformationDependencyListAccess().getSemicolonKeyword_5_0()); 
            match(input,14,FOLLOW_14_in_rule__TransformationDependencyList__Group_5__0__Impl5141); 
             after(grammarAccess.getTransformationDependencyListAccess().getSemicolonKeyword_5_0()); 

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
    // $ANTLR end "rule__TransformationDependencyList__Group_5__0__Impl"


    // $ANTLR start "rule__TransformationDependencyList__Group_5__1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2613:1: rule__TransformationDependencyList__Group_5__1 : rule__TransformationDependencyList__Group_5__1__Impl ;
    public final void rule__TransformationDependencyList__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2617:1: ( rule__TransformationDependencyList__Group_5__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2618:2: rule__TransformationDependencyList__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group_5__1__Impl_in_rule__TransformationDependencyList__Group_5__15172);
            rule__TransformationDependencyList__Group_5__1__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependencyList__Group_5__1"


    // $ANTLR start "rule__TransformationDependencyList__Group_5__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2624:1: rule__TransformationDependencyList__Group_5__1__Impl : ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1 ) ) ;
    public final void rule__TransformationDependencyList__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2628:1: ( ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2629:1: ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2629:1: ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2630:1: ( rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1 )
            {
             before(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesAssignment_5_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2631:1: ( rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2631:2: rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1_in_rule__TransformationDependencyList__Group_5__1__Impl5199);
            rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1();

            state._fsp--;


            }

             after(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesAssignment_5_1()); 

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
    // $ANTLR end "rule__TransformationDependencyList__Group_5__1__Impl"


    // $ANTLR start "rule__TransformationDependency__Group__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2645:1: rule__TransformationDependency__Group__0 : rule__TransformationDependency__Group__0__Impl rule__TransformationDependency__Group__1 ;
    public final void rule__TransformationDependency__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2649:1: ( rule__TransformationDependency__Group__0__Impl rule__TransformationDependency__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2650:2: rule__TransformationDependency__Group__0__Impl rule__TransformationDependency__Group__1
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__0__Impl_in_rule__TransformationDependency__Group__05233);
            rule__TransformationDependency__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__1_in_rule__TransformationDependency__Group__05236);
            rule__TransformationDependency__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2657:1: rule__TransformationDependency__Group__0__Impl : ( 'Apply' ) ;
    public final void rule__TransformationDependency__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2661:1: ( ( 'Apply' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2662:1: ( 'Apply' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2662:1: ( 'Apply' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2663:1: 'Apply'
            {
             before(grammarAccess.getTransformationDependencyAccess().getApplyKeyword_0()); 
            match(input,27,FOLLOW_27_in_rule__TransformationDependency__Group__0__Impl5264); 
             after(grammarAccess.getTransformationDependencyAccess().getApplyKeyword_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2676:1: rule__TransformationDependency__Group__1 : rule__TransformationDependency__Group__1__Impl rule__TransformationDependency__Group__2 ;
    public final void rule__TransformationDependency__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2680:1: ( rule__TransformationDependency__Group__1__Impl rule__TransformationDependency__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2681:2: rule__TransformationDependency__Group__1__Impl rule__TransformationDependency__Group__2
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__1__Impl_in_rule__TransformationDependency__Group__15295);
            rule__TransformationDependency__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__2_in_rule__TransformationDependency__Group__15298);
            rule__TransformationDependency__Group__2();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2688:1: rule__TransformationDependency__Group__1__Impl : ( '(' ) ;
    public final void rule__TransformationDependency__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2692:1: ( ( '(' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2693:1: ( '(' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2693:1: ( '(' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2694:1: '('
            {
             before(grammarAccess.getTransformationDependencyAccess().getLeftParenthesisKeyword_1()); 
            match(input,24,FOLLOW_24_in_rule__TransformationDependency__Group__1__Impl5326); 
             after(grammarAccess.getTransformationDependencyAccess().getLeftParenthesisKeyword_1()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2707:1: rule__TransformationDependency__Group__2 : rule__TransformationDependency__Group__2__Impl rule__TransformationDependency__Group__3 ;
    public final void rule__TransformationDependency__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2711:1: ( rule__TransformationDependency__Group__2__Impl rule__TransformationDependency__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2712:2: rule__TransformationDependency__Group__2__Impl rule__TransformationDependency__Group__3
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__2__Impl_in_rule__TransformationDependency__Group__25357);
            rule__TransformationDependency__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__3_in_rule__TransformationDependency__Group__25360);
            rule__TransformationDependency__Group__3();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2719:1: rule__TransformationDependency__Group__2__Impl : ( ( rule__TransformationDependency__AppliedTransformationAssignment_2 ) ) ;
    public final void rule__TransformationDependency__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2723:1: ( ( ( rule__TransformationDependency__AppliedTransformationAssignment_2 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2724:1: ( ( rule__TransformationDependency__AppliedTransformationAssignment_2 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2724:1: ( ( rule__TransformationDependency__AppliedTransformationAssignment_2 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2725:1: ( rule__TransformationDependency__AppliedTransformationAssignment_2 )
            {
             before(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationAssignment_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2726:1: ( rule__TransformationDependency__AppliedTransformationAssignment_2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2726:2: rule__TransformationDependency__AppliedTransformationAssignment_2
            {
            pushFollow(FOLLOW_rule__TransformationDependency__AppliedTransformationAssignment_2_in_rule__TransformationDependency__Group__2__Impl5387);
            rule__TransformationDependency__AppliedTransformationAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationAssignment_2()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2736:1: rule__TransformationDependency__Group__3 : rule__TransformationDependency__Group__3__Impl rule__TransformationDependency__Group__4 ;
    public final void rule__TransformationDependency__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2740:1: ( rule__TransformationDependency__Group__3__Impl rule__TransformationDependency__Group__4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2741:2: rule__TransformationDependency__Group__3__Impl rule__TransformationDependency__Group__4
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__3__Impl_in_rule__TransformationDependency__Group__35417);
            rule__TransformationDependency__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__4_in_rule__TransformationDependency__Group__35420);
            rule__TransformationDependency__Group__4();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2748:1: rule__TransformationDependency__Group__3__Impl : ( '.' ) ;
    public final void rule__TransformationDependency__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2752:1: ( ( '.' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2753:1: ( '.' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2753:1: ( '.' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2754:1: '.'
            {
             before(grammarAccess.getTransformationDependencyAccess().getFullStopKeyword_3()); 
            match(input,28,FOLLOW_28_in_rule__TransformationDependency__Group__3__Impl5448); 
             after(grammarAccess.getTransformationDependencyAccess().getFullStopKeyword_3()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2767:1: rule__TransformationDependency__Group__4 : rule__TransformationDependency__Group__4__Impl rule__TransformationDependency__Group__5 ;
    public final void rule__TransformationDependency__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2771:1: ( rule__TransformationDependency__Group__4__Impl rule__TransformationDependency__Group__5 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2772:2: rule__TransformationDependency__Group__4__Impl rule__TransformationDependency__Group__5
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__4__Impl_in_rule__TransformationDependency__Group__45479);
            rule__TransformationDependency__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__5_in_rule__TransformationDependency__Group__45482);
            rule__TransformationDependency__Group__5();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2779:1: rule__TransformationDependency__Group__4__Impl : ( ( rule__TransformationDependency__AppliedRuleAssignment_4 ) ) ;
    public final void rule__TransformationDependency__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2783:1: ( ( ( rule__TransformationDependency__AppliedRuleAssignment_4 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2784:1: ( ( rule__TransformationDependency__AppliedRuleAssignment_4 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2784:1: ( ( rule__TransformationDependency__AppliedRuleAssignment_4 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2785:1: ( rule__TransformationDependency__AppliedRuleAssignment_4 )
            {
             before(grammarAccess.getTransformationDependencyAccess().getAppliedRuleAssignment_4()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2786:1: ( rule__TransformationDependency__AppliedRuleAssignment_4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2786:2: rule__TransformationDependency__AppliedRuleAssignment_4
            {
            pushFollow(FOLLOW_rule__TransformationDependency__AppliedRuleAssignment_4_in_rule__TransformationDependency__Group__4__Impl5509);
            rule__TransformationDependency__AppliedRuleAssignment_4();

            state._fsp--;


            }

             after(grammarAccess.getTransformationDependencyAccess().getAppliedRuleAssignment_4()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2796:1: rule__TransformationDependency__Group__5 : rule__TransformationDependency__Group__5__Impl rule__TransformationDependency__Group__6 ;
    public final void rule__TransformationDependency__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2800:1: ( rule__TransformationDependency__Group__5__Impl rule__TransformationDependency__Group__6 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2801:2: rule__TransformationDependency__Group__5__Impl rule__TransformationDependency__Group__6
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__5__Impl_in_rule__TransformationDependency__Group__55539);
            rule__TransformationDependency__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__6_in_rule__TransformationDependency__Group__55542);
            rule__TransformationDependency__Group__6();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2808:1: rule__TransformationDependency__Group__5__Impl : ( ',' ) ;
    public final void rule__TransformationDependency__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2812:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2813:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2813:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2814:1: ','
            {
             before(grammarAccess.getTransformationDependencyAccess().getCommaKeyword_5()); 
            match(input,20,FOLLOW_20_in_rule__TransformationDependency__Group__5__Impl5570); 
             after(grammarAccess.getTransformationDependencyAccess().getCommaKeyword_5()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2827:1: rule__TransformationDependency__Group__6 : rule__TransformationDependency__Group__6__Impl rule__TransformationDependency__Group__7 ;
    public final void rule__TransformationDependency__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2831:1: ( rule__TransformationDependency__Group__6__Impl rule__TransformationDependency__Group__7 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2832:2: rule__TransformationDependency__Group__6__Impl rule__TransformationDependency__Group__7
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__6__Impl_in_rule__TransformationDependency__Group__65601);
            rule__TransformationDependency__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__7_in_rule__TransformationDependency__Group__65604);
            rule__TransformationDependency__Group__7();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2839:1: rule__TransformationDependency__Group__6__Impl : ( '{' ) ;
    public final void rule__TransformationDependency__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2843:1: ( ( '{' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2844:1: ( '{' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2844:1: ( '{' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2845:1: '{'
            {
             before(grammarAccess.getTransformationDependencyAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,16,FOLLOW_16_in_rule__TransformationDependency__Group__6__Impl5632); 
             after(grammarAccess.getTransformationDependencyAccess().getLeftCurlyBracketKeyword_6()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2858:1: rule__TransformationDependency__Group__7 : rule__TransformationDependency__Group__7__Impl rule__TransformationDependency__Group__8 ;
    public final void rule__TransformationDependency__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2862:1: ( rule__TransformationDependency__Group__7__Impl rule__TransformationDependency__Group__8 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2863:2: rule__TransformationDependency__Group__7__Impl rule__TransformationDependency__Group__8
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__7__Impl_in_rule__TransformationDependency__Group__75663);
            rule__TransformationDependency__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__8_in_rule__TransformationDependency__Group__75666);
            rule__TransformationDependency__Group__8();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2870:1: rule__TransformationDependency__Group__7__Impl : ( ( rule__TransformationDependency__FieldsAssignment_7 ) ) ;
    public final void rule__TransformationDependency__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2874:1: ( ( ( rule__TransformationDependency__FieldsAssignment_7 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2875:1: ( ( rule__TransformationDependency__FieldsAssignment_7 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2875:1: ( ( rule__TransformationDependency__FieldsAssignment_7 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2876:1: ( rule__TransformationDependency__FieldsAssignment_7 )
            {
             before(grammarAccess.getTransformationDependencyAccess().getFieldsAssignment_7()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2877:1: ( rule__TransformationDependency__FieldsAssignment_7 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2877:2: rule__TransformationDependency__FieldsAssignment_7
            {
            pushFollow(FOLLOW_rule__TransformationDependency__FieldsAssignment_7_in_rule__TransformationDependency__Group__7__Impl5693);
            rule__TransformationDependency__FieldsAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getTransformationDependencyAccess().getFieldsAssignment_7()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2887:1: rule__TransformationDependency__Group__8 : rule__TransformationDependency__Group__8__Impl rule__TransformationDependency__Group__9 ;
    public final void rule__TransformationDependency__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2891:1: ( rule__TransformationDependency__Group__8__Impl rule__TransformationDependency__Group__9 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2892:2: rule__TransformationDependency__Group__8__Impl rule__TransformationDependency__Group__9
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__8__Impl_in_rule__TransformationDependency__Group__85723);
            rule__TransformationDependency__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__9_in_rule__TransformationDependency__Group__85726);
            rule__TransformationDependency__Group__9();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2899:1: rule__TransformationDependency__Group__8__Impl : ( ( rule__TransformationDependency__Group_8__0 )* ) ;
    public final void rule__TransformationDependency__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2903:1: ( ( ( rule__TransformationDependency__Group_8__0 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2904:1: ( ( rule__TransformationDependency__Group_8__0 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2904:1: ( ( rule__TransformationDependency__Group_8__0 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2905:1: ( rule__TransformationDependency__Group_8__0 )*
            {
             before(grammarAccess.getTransformationDependencyAccess().getGroup_8()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2906:1: ( rule__TransformationDependency__Group_8__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==20) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2906:2: rule__TransformationDependency__Group_8__0
            	    {
            	    pushFollow(FOLLOW_rule__TransformationDependency__Group_8__0_in_rule__TransformationDependency__Group__8__Impl5753);
            	    rule__TransformationDependency__Group_8__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop16;
                }
            } while (true);

             after(grammarAccess.getTransformationDependencyAccess().getGroup_8()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2916:1: rule__TransformationDependency__Group__9 : rule__TransformationDependency__Group__9__Impl rule__TransformationDependency__Group__10 ;
    public final void rule__TransformationDependency__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2920:1: ( rule__TransformationDependency__Group__9__Impl rule__TransformationDependency__Group__10 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2921:2: rule__TransformationDependency__Group__9__Impl rule__TransformationDependency__Group__10
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__9__Impl_in_rule__TransformationDependency__Group__95784);
            rule__TransformationDependency__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__10_in_rule__TransformationDependency__Group__95787);
            rule__TransformationDependency__Group__10();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2928:1: rule__TransformationDependency__Group__9__Impl : ( '}' ) ;
    public final void rule__TransformationDependency__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2932:1: ( ( '}' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2933:1: ( '}' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2933:1: ( '}' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2934:1: '}'
            {
             before(grammarAccess.getTransformationDependencyAccess().getRightCurlyBracketKeyword_9()); 
            match(input,17,FOLLOW_17_in_rule__TransformationDependency__Group__9__Impl5815); 
             after(grammarAccess.getTransformationDependencyAccess().getRightCurlyBracketKeyword_9()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2947:1: rule__TransformationDependency__Group__10 : rule__TransformationDependency__Group__10__Impl rule__TransformationDependency__Group__11 ;
    public final void rule__TransformationDependency__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2951:1: ( rule__TransformationDependency__Group__10__Impl rule__TransformationDependency__Group__11 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2952:2: rule__TransformationDependency__Group__10__Impl rule__TransformationDependency__Group__11
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__10__Impl_in_rule__TransformationDependency__Group__105846);
            rule__TransformationDependency__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__11_in_rule__TransformationDependency__Group__105849);
            rule__TransformationDependency__Group__11();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2959:1: rule__TransformationDependency__Group__10__Impl : ( ')' ) ;
    public final void rule__TransformationDependency__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2963:1: ( ( ')' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2964:1: ( ')' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2964:1: ( ')' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2965:1: ')'
            {
             before(grammarAccess.getTransformationDependencyAccess().getRightParenthesisKeyword_10()); 
            match(input,25,FOLLOW_25_in_rule__TransformationDependency__Group__10__Impl5877); 
             after(grammarAccess.getTransformationDependencyAccess().getRightParenthesisKeyword_10()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2978:1: rule__TransformationDependency__Group__11 : rule__TransformationDependency__Group__11__Impl rule__TransformationDependency__Group__12 ;
    public final void rule__TransformationDependency__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2982:1: ( rule__TransformationDependency__Group__11__Impl rule__TransformationDependency__Group__12 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2983:2: rule__TransformationDependency__Group__11__Impl rule__TransformationDependency__Group__12
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__11__Impl_in_rule__TransformationDependency__Group__115908);
            rule__TransformationDependency__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__12_in_rule__TransformationDependency__Group__115911);
            rule__TransformationDependency__Group__12();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2990:1: rule__TransformationDependency__Group__11__Impl : ( '[' ) ;
    public final void rule__TransformationDependency__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2994:1: ( ( '[' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2995:1: ( '[' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2995:1: ( '[' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2996:1: '['
            {
             before(grammarAccess.getTransformationDependencyAccess().getLeftSquareBracketKeyword_11()); 
            match(input,29,FOLLOW_29_in_rule__TransformationDependency__Group__11__Impl5939); 
             after(grammarAccess.getTransformationDependencyAccess().getLeftSquareBracketKeyword_11()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3009:1: rule__TransformationDependency__Group__12 : rule__TransformationDependency__Group__12__Impl rule__TransformationDependency__Group__13 ;
    public final void rule__TransformationDependency__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3013:1: ( rule__TransformationDependency__Group__12__Impl rule__TransformationDependency__Group__13 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3014:2: rule__TransformationDependency__Group__12__Impl rule__TransformationDependency__Group__13
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__12__Impl_in_rule__TransformationDependency__Group__125970);
            rule__TransformationDependency__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__13_in_rule__TransformationDependency__Group__125973);
            rule__TransformationDependency__Group__13();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3021:1: rule__TransformationDependency__Group__12__Impl : ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12 ) ) ;
    public final void rule__TransformationDependency__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3025:1: ( ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3026:1: ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3026:1: ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3027:1: ( rule__TransformationDependency__RequiredTransformationsAssignment_12 )
            {
             before(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAssignment_12()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3028:1: ( rule__TransformationDependency__RequiredTransformationsAssignment_12 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3028:2: rule__TransformationDependency__RequiredTransformationsAssignment_12
            {
            pushFollow(FOLLOW_rule__TransformationDependency__RequiredTransformationsAssignment_12_in_rule__TransformationDependency__Group__12__Impl6000);
            rule__TransformationDependency__RequiredTransformationsAssignment_12();

            state._fsp--;


            }

             after(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAssignment_12()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3038:1: rule__TransformationDependency__Group__13 : rule__TransformationDependency__Group__13__Impl rule__TransformationDependency__Group__14 ;
    public final void rule__TransformationDependency__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3042:1: ( rule__TransformationDependency__Group__13__Impl rule__TransformationDependency__Group__14 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3043:2: rule__TransformationDependency__Group__13__Impl rule__TransformationDependency__Group__14
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__13__Impl_in_rule__TransformationDependency__Group__136030);
            rule__TransformationDependency__Group__13__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__14_in_rule__TransformationDependency__Group__136033);
            rule__TransformationDependency__Group__14();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3050:1: rule__TransformationDependency__Group__13__Impl : ( ( rule__TransformationDependency__Alternatives_13 )? ) ;
    public final void rule__TransformationDependency__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3054:1: ( ( ( rule__TransformationDependency__Alternatives_13 )? ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3055:1: ( ( rule__TransformationDependency__Alternatives_13 )? )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3055:1: ( ( rule__TransformationDependency__Alternatives_13 )? )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3056:1: ( rule__TransformationDependency__Alternatives_13 )?
            {
             before(grammarAccess.getTransformationDependencyAccess().getAlternatives_13()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3057:1: ( rule__TransformationDependency__Alternatives_13 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=11 && LA17_0<=12)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3057:2: rule__TransformationDependency__Alternatives_13
                    {
                    pushFollow(FOLLOW_rule__TransformationDependency__Alternatives_13_in_rule__TransformationDependency__Group__13__Impl6060);
                    rule__TransformationDependency__Alternatives_13();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTransformationDependencyAccess().getAlternatives_13()); 

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


    // $ANTLR start "rule__TransformationDependency__Group__14"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3067:1: rule__TransformationDependency__Group__14 : rule__TransformationDependency__Group__14__Impl rule__TransformationDependency__Group__15 ;
    public final void rule__TransformationDependency__Group__14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3071:1: ( rule__TransformationDependency__Group__14__Impl rule__TransformationDependency__Group__15 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3072:2: rule__TransformationDependency__Group__14__Impl rule__TransformationDependency__Group__15
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__14__Impl_in_rule__TransformationDependency__Group__146091);
            rule__TransformationDependency__Group__14__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__15_in_rule__TransformationDependency__Group__146094);
            rule__TransformationDependency__Group__15();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__14"


    // $ANTLR start "rule__TransformationDependency__Group__14__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3079:1: rule__TransformationDependency__Group__14__Impl : ( ( rule__TransformationDependency__RequiredTransformationsAssignment_14 )* ) ;
    public final void rule__TransformationDependency__Group__14__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3083:1: ( ( ( rule__TransformationDependency__RequiredTransformationsAssignment_14 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3084:1: ( ( rule__TransformationDependency__RequiredTransformationsAssignment_14 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3084:1: ( ( rule__TransformationDependency__RequiredTransformationsAssignment_14 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3085:1: ( rule__TransformationDependency__RequiredTransformationsAssignment_14 )*
            {
             before(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAssignment_14()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3086:1: ( rule__TransformationDependency__RequiredTransformationsAssignment_14 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( ((LA18_0>=31 && LA18_0<=32)) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3086:2: rule__TransformationDependency__RequiredTransformationsAssignment_14
            	    {
            	    pushFollow(FOLLOW_rule__TransformationDependency__RequiredTransformationsAssignment_14_in_rule__TransformationDependency__Group__14__Impl6121);
            	    rule__TransformationDependency__RequiredTransformationsAssignment_14();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
                }
            } while (true);

             after(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAssignment_14()); 

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
    // $ANTLR end "rule__TransformationDependency__Group__14__Impl"


    // $ANTLR start "rule__TransformationDependency__Group__15"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3096:1: rule__TransformationDependency__Group__15 : rule__TransformationDependency__Group__15__Impl ;
    public final void rule__TransformationDependency__Group__15() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3100:1: ( rule__TransformationDependency__Group__15__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3101:2: rule__TransformationDependency__Group__15__Impl
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__15__Impl_in_rule__TransformationDependency__Group__156152);
            rule__TransformationDependency__Group__15__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group__15"


    // $ANTLR start "rule__TransformationDependency__Group__15__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3107:1: rule__TransformationDependency__Group__15__Impl : ( ']' ) ;
    public final void rule__TransformationDependency__Group__15__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3111:1: ( ( ']' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3112:1: ( ']' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3112:1: ( ']' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3113:1: ']'
            {
             before(grammarAccess.getTransformationDependencyAccess().getRightSquareBracketKeyword_15()); 
            match(input,30,FOLLOW_30_in_rule__TransformationDependency__Group__15__Impl6180); 
             after(grammarAccess.getTransformationDependencyAccess().getRightSquareBracketKeyword_15()); 

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
    // $ANTLR end "rule__TransformationDependency__Group__15__Impl"


    // $ANTLR start "rule__TransformationDependency__Group_8__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3158:1: rule__TransformationDependency__Group_8__0 : rule__TransformationDependency__Group_8__0__Impl rule__TransformationDependency__Group_8__1 ;
    public final void rule__TransformationDependency__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3162:1: ( rule__TransformationDependency__Group_8__0__Impl rule__TransformationDependency__Group_8__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3163:2: rule__TransformationDependency__Group_8__0__Impl rule__TransformationDependency__Group_8__1
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group_8__0__Impl_in_rule__TransformationDependency__Group_8__06243);
            rule__TransformationDependency__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group_8__1_in_rule__TransformationDependency__Group_8__06246);
            rule__TransformationDependency__Group_8__1();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3170:1: rule__TransformationDependency__Group_8__0__Impl : ( ',' ) ;
    public final void rule__TransformationDependency__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3174:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3175:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3175:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3176:1: ','
            {
             before(grammarAccess.getTransformationDependencyAccess().getCommaKeyword_8_0()); 
            match(input,20,FOLLOW_20_in_rule__TransformationDependency__Group_8__0__Impl6274); 
             after(grammarAccess.getTransformationDependencyAccess().getCommaKeyword_8_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3189:1: rule__TransformationDependency__Group_8__1 : rule__TransformationDependency__Group_8__1__Impl ;
    public final void rule__TransformationDependency__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3193:1: ( rule__TransformationDependency__Group_8__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3194:2: rule__TransformationDependency__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group_8__1__Impl_in_rule__TransformationDependency__Group_8__16305);
            rule__TransformationDependency__Group_8__1__Impl();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3200:1: rule__TransformationDependency__Group_8__1__Impl : ( ( rule__TransformationDependency__FieldsAssignment_8_1 ) ) ;
    public final void rule__TransformationDependency__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3204:1: ( ( ( rule__TransformationDependency__FieldsAssignment_8_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3205:1: ( ( rule__TransformationDependency__FieldsAssignment_8_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3205:1: ( ( rule__TransformationDependency__FieldsAssignment_8_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3206:1: ( rule__TransformationDependency__FieldsAssignment_8_1 )
            {
             before(grammarAccess.getTransformationDependencyAccess().getFieldsAssignment_8_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3207:1: ( rule__TransformationDependency__FieldsAssignment_8_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3207:2: rule__TransformationDependency__FieldsAssignment_8_1
            {
            pushFollow(FOLLOW_rule__TransformationDependency__FieldsAssignment_8_1_in_rule__TransformationDependency__Group_8__1__Impl6332);
            rule__TransformationDependency__FieldsAssignment_8_1();

            state._fsp--;


            }

             after(grammarAccess.getTransformationDependencyAccess().getFieldsAssignment_8_1()); 

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


    // $ANTLR start "rule__RuleDependency__Group_0__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3223:1: rule__RuleDependency__Group_0__0 : rule__RuleDependency__Group_0__0__Impl rule__RuleDependency__Group_0__1 ;
    public final void rule__RuleDependency__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3227:1: ( rule__RuleDependency__Group_0__0__Impl rule__RuleDependency__Group_0__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3228:2: rule__RuleDependency__Group_0__0__Impl rule__RuleDependency__Group_0__1
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_0__0__Impl_in_rule__RuleDependency__Group_0__06368);
            rule__RuleDependency__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDependency__Group_0__1_in_rule__RuleDependency__Group_0__06371);
            rule__RuleDependency__Group_0__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group_0__0"


    // $ANTLR start "rule__RuleDependency__Group_0__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3235:1: rule__RuleDependency__Group_0__0__Impl : ( 'requires' ) ;
    public final void rule__RuleDependency__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3239:1: ( ( 'requires' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3240:1: ( 'requires' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3240:1: ( 'requires' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3241:1: 'requires'
            {
             before(grammarAccess.getRuleDependencyAccess().getRequiresKeyword_0_0()); 
            match(input,31,FOLLOW_31_in_rule__RuleDependency__Group_0__0__Impl6399); 
             after(grammarAccess.getRuleDependencyAccess().getRequiresKeyword_0_0()); 

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
    // $ANTLR end "rule__RuleDependency__Group_0__0__Impl"


    // $ANTLR start "rule__RuleDependency__Group_0__1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3254:1: rule__RuleDependency__Group_0__1 : rule__RuleDependency__Group_0__1__Impl rule__RuleDependency__Group_0__2 ;
    public final void rule__RuleDependency__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3258:1: ( rule__RuleDependency__Group_0__1__Impl rule__RuleDependency__Group_0__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3259:2: rule__RuleDependency__Group_0__1__Impl rule__RuleDependency__Group_0__2
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_0__1__Impl_in_rule__RuleDependency__Group_0__16430);
            rule__RuleDependency__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDependency__Group_0__2_in_rule__RuleDependency__Group_0__16433);
            rule__RuleDependency__Group_0__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group_0__1"


    // $ANTLR start "rule__RuleDependency__Group_0__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3266:1: rule__RuleDependency__Group_0__1__Impl : ( ( rule__RuleDependency__RdAssignment_0_1 ) ) ;
    public final void rule__RuleDependency__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3270:1: ( ( ( rule__RuleDependency__RdAssignment_0_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3271:1: ( ( rule__RuleDependency__RdAssignment_0_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3271:1: ( ( rule__RuleDependency__RdAssignment_0_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3272:1: ( rule__RuleDependency__RdAssignment_0_1 )
            {
             before(grammarAccess.getRuleDependencyAccess().getRdAssignment_0_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3273:1: ( rule__RuleDependency__RdAssignment_0_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3273:2: rule__RuleDependency__RdAssignment_0_1
            {
            pushFollow(FOLLOW_rule__RuleDependency__RdAssignment_0_1_in_rule__RuleDependency__Group_0__1__Impl6460);
            rule__RuleDependency__RdAssignment_0_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleDependencyAccess().getRdAssignment_0_1()); 

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
    // $ANTLR end "rule__RuleDependency__Group_0__1__Impl"


    // $ANTLR start "rule__RuleDependency__Group_0__2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3283:1: rule__RuleDependency__Group_0__2 : rule__RuleDependency__Group_0__2__Impl rule__RuleDependency__Group_0__3 ;
    public final void rule__RuleDependency__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3287:1: ( rule__RuleDependency__Group_0__2__Impl rule__RuleDependency__Group_0__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3288:2: rule__RuleDependency__Group_0__2__Impl rule__RuleDependency__Group_0__3
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_0__2__Impl_in_rule__RuleDependency__Group_0__26490);
            rule__RuleDependency__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDependency__Group_0__3_in_rule__RuleDependency__Group_0__26493);
            rule__RuleDependency__Group_0__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group_0__2"


    // $ANTLR start "rule__RuleDependency__Group_0__2__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3295:1: rule__RuleDependency__Group_0__2__Impl : ( ( rule__RuleDependency__Alternatives_0_2 )? ) ;
    public final void rule__RuleDependency__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3299:1: ( ( ( rule__RuleDependency__Alternatives_0_2 )? ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3300:1: ( ( rule__RuleDependency__Alternatives_0_2 )? )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3300:1: ( ( rule__RuleDependency__Alternatives_0_2 )? )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3301:1: ( rule__RuleDependency__Alternatives_0_2 )?
            {
             before(grammarAccess.getRuleDependencyAccess().getAlternatives_0_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3302:1: ( rule__RuleDependency__Alternatives_0_2 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==11) ) {
                alt19=1;
            }
            else if ( (LA19_0==12) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3302:2: rule__RuleDependency__Alternatives_0_2
                    {
                    pushFollow(FOLLOW_rule__RuleDependency__Alternatives_0_2_in_rule__RuleDependency__Group_0__2__Impl6520);
                    rule__RuleDependency__Alternatives_0_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleDependencyAccess().getAlternatives_0_2()); 

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
    // $ANTLR end "rule__RuleDependency__Group_0__2__Impl"


    // $ANTLR start "rule__RuleDependency__Group_0__3"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3312:1: rule__RuleDependency__Group_0__3 : rule__RuleDependency__Group_0__3__Impl ;
    public final void rule__RuleDependency__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3316:1: ( rule__RuleDependency__Group_0__3__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3317:2: rule__RuleDependency__Group_0__3__Impl
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_0__3__Impl_in_rule__RuleDependency__Group_0__36551);
            rule__RuleDependency__Group_0__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group_0__3"


    // $ANTLR start "rule__RuleDependency__Group_0__3__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3323:1: rule__RuleDependency__Group_0__3__Impl : ( ( rule__RuleDependency__RdAssignment_0_3 )* ) ;
    public final void rule__RuleDependency__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3327:1: ( ( ( rule__RuleDependency__RdAssignment_0_3 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3328:1: ( ( rule__RuleDependency__RdAssignment_0_3 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3328:1: ( ( rule__RuleDependency__RdAssignment_0_3 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3329:1: ( rule__RuleDependency__RdAssignment_0_3 )*
            {
             before(grammarAccess.getRuleDependencyAccess().getRdAssignment_0_3()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3330:1: ( rule__RuleDependency__RdAssignment_0_3 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( (LA20_0==24) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3330:2: rule__RuleDependency__RdAssignment_0_3
            	    {
            	    pushFollow(FOLLOW_rule__RuleDependency__RdAssignment_0_3_in_rule__RuleDependency__Group_0__3__Impl6578);
            	    rule__RuleDependency__RdAssignment_0_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getRuleDependencyAccess().getRdAssignment_0_3()); 

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
    // $ANTLR end "rule__RuleDependency__Group_0__3__Impl"


    // $ANTLR start "rule__RuleDependency__Group_1__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3348:1: rule__RuleDependency__Group_1__0 : rule__RuleDependency__Group_1__0__Impl rule__RuleDependency__Group_1__1 ;
    public final void rule__RuleDependency__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3352:1: ( rule__RuleDependency__Group_1__0__Impl rule__RuleDependency__Group_1__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3353:2: rule__RuleDependency__Group_1__0__Impl rule__RuleDependency__Group_1__1
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_1__0__Impl_in_rule__RuleDependency__Group_1__06617);
            rule__RuleDependency__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDependency__Group_1__1_in_rule__RuleDependency__Group_1__06620);
            rule__RuleDependency__Group_1__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group_1__0"


    // $ANTLR start "rule__RuleDependency__Group_1__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3360:1: rule__RuleDependency__Group_1__0__Impl : ( 'excludes' ) ;
    public final void rule__RuleDependency__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3364:1: ( ( 'excludes' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3365:1: ( 'excludes' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3365:1: ( 'excludes' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3366:1: 'excludes'
            {
             before(grammarAccess.getRuleDependencyAccess().getExcludesKeyword_1_0()); 
            match(input,32,FOLLOW_32_in_rule__RuleDependency__Group_1__0__Impl6648); 
             after(grammarAccess.getRuleDependencyAccess().getExcludesKeyword_1_0()); 

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
    // $ANTLR end "rule__RuleDependency__Group_1__0__Impl"


    // $ANTLR start "rule__RuleDependency__Group_1__1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3379:1: rule__RuleDependency__Group_1__1 : rule__RuleDependency__Group_1__1__Impl rule__RuleDependency__Group_1__2 ;
    public final void rule__RuleDependency__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3383:1: ( rule__RuleDependency__Group_1__1__Impl rule__RuleDependency__Group_1__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3384:2: rule__RuleDependency__Group_1__1__Impl rule__RuleDependency__Group_1__2
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_1__1__Impl_in_rule__RuleDependency__Group_1__16679);
            rule__RuleDependency__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDependency__Group_1__2_in_rule__RuleDependency__Group_1__16682);
            rule__RuleDependency__Group_1__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group_1__1"


    // $ANTLR start "rule__RuleDependency__Group_1__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3391:1: rule__RuleDependency__Group_1__1__Impl : ( ( rule__RuleDependency__RdAssignment_1_1 ) ) ;
    public final void rule__RuleDependency__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3395:1: ( ( ( rule__RuleDependency__RdAssignment_1_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3396:1: ( ( rule__RuleDependency__RdAssignment_1_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3396:1: ( ( rule__RuleDependency__RdAssignment_1_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3397:1: ( rule__RuleDependency__RdAssignment_1_1 )
            {
             before(grammarAccess.getRuleDependencyAccess().getRdAssignment_1_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3398:1: ( rule__RuleDependency__RdAssignment_1_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3398:2: rule__RuleDependency__RdAssignment_1_1
            {
            pushFollow(FOLLOW_rule__RuleDependency__RdAssignment_1_1_in_rule__RuleDependency__Group_1__1__Impl6709);
            rule__RuleDependency__RdAssignment_1_1();

            state._fsp--;


            }

             after(grammarAccess.getRuleDependencyAccess().getRdAssignment_1_1()); 

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
    // $ANTLR end "rule__RuleDependency__Group_1__1__Impl"


    // $ANTLR start "rule__RuleDependency__Group_1__2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3408:1: rule__RuleDependency__Group_1__2 : rule__RuleDependency__Group_1__2__Impl rule__RuleDependency__Group_1__3 ;
    public final void rule__RuleDependency__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3412:1: ( rule__RuleDependency__Group_1__2__Impl rule__RuleDependency__Group_1__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3413:2: rule__RuleDependency__Group_1__2__Impl rule__RuleDependency__Group_1__3
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_1__2__Impl_in_rule__RuleDependency__Group_1__26739);
            rule__RuleDependency__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDependency__Group_1__3_in_rule__RuleDependency__Group_1__26742);
            rule__RuleDependency__Group_1__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group_1__2"


    // $ANTLR start "rule__RuleDependency__Group_1__2__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3420:1: rule__RuleDependency__Group_1__2__Impl : ( ( rule__RuleDependency__Alternatives_1_2 )? ) ;
    public final void rule__RuleDependency__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3424:1: ( ( ( rule__RuleDependency__Alternatives_1_2 )? ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3425:1: ( ( rule__RuleDependency__Alternatives_1_2 )? )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3425:1: ( ( rule__RuleDependency__Alternatives_1_2 )? )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3426:1: ( rule__RuleDependency__Alternatives_1_2 )?
            {
             before(grammarAccess.getRuleDependencyAccess().getAlternatives_1_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3427:1: ( rule__RuleDependency__Alternatives_1_2 )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==11) ) {
                alt21=1;
            }
            else if ( (LA21_0==12) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3427:2: rule__RuleDependency__Alternatives_1_2
                    {
                    pushFollow(FOLLOW_rule__RuleDependency__Alternatives_1_2_in_rule__RuleDependency__Group_1__2__Impl6769);
                    rule__RuleDependency__Alternatives_1_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getRuleDependencyAccess().getAlternatives_1_2()); 

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
    // $ANTLR end "rule__RuleDependency__Group_1__2__Impl"


    // $ANTLR start "rule__RuleDependency__Group_1__3"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3437:1: rule__RuleDependency__Group_1__3 : rule__RuleDependency__Group_1__3__Impl ;
    public final void rule__RuleDependency__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3441:1: ( rule__RuleDependency__Group_1__3__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3442:2: rule__RuleDependency__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_1__3__Impl_in_rule__RuleDependency__Group_1__36800);
            rule__RuleDependency__Group_1__3__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RuleDependency__Group_1__3"


    // $ANTLR start "rule__RuleDependency__Group_1__3__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3448:1: rule__RuleDependency__Group_1__3__Impl : ( ( rule__RuleDependency__EdAssignment_1_3 )* ) ;
    public final void rule__RuleDependency__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3452:1: ( ( ( rule__RuleDependency__EdAssignment_1_3 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3453:1: ( ( rule__RuleDependency__EdAssignment_1_3 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3453:1: ( ( rule__RuleDependency__EdAssignment_1_3 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3454:1: ( rule__RuleDependency__EdAssignment_1_3 )*
            {
             before(grammarAccess.getRuleDependencyAccess().getEdAssignment_1_3()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3455:1: ( rule__RuleDependency__EdAssignment_1_3 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==24) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3455:2: rule__RuleDependency__EdAssignment_1_3
            	    {
            	    pushFollow(FOLLOW_rule__RuleDependency__EdAssignment_1_3_in_rule__RuleDependency__Group_1__3__Impl6827);
            	    rule__RuleDependency__EdAssignment_1_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

             after(grammarAccess.getRuleDependencyAccess().getEdAssignment_1_3()); 

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
    // $ANTLR end "rule__RuleDependency__Group_1__3__Impl"


    // $ANTLR start "rule__RequiresDependency__Group__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3473:1: rule__RequiresDependency__Group__0 : rule__RequiresDependency__Group__0__Impl rule__RequiresDependency__Group__1 ;
    public final void rule__RequiresDependency__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3477:1: ( rule__RequiresDependency__Group__0__Impl rule__RequiresDependency__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3478:2: rule__RequiresDependency__Group__0__Impl rule__RequiresDependency__Group__1
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__0__Impl_in_rule__RequiresDependency__Group__06866);
            rule__RequiresDependency__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequiresDependency__Group__1_in_rule__RequiresDependency__Group__06869);
            rule__RequiresDependency__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequiresDependency__Group__0"


    // $ANTLR start "rule__RequiresDependency__Group__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3485:1: rule__RequiresDependency__Group__0__Impl : ( '(' ) ;
    public final void rule__RequiresDependency__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3489:1: ( ( '(' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3490:1: ( '(' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3490:1: ( '(' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3491:1: '('
            {
             before(grammarAccess.getRequiresDependencyAccess().getLeftParenthesisKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__RequiresDependency__Group__0__Impl6897); 
             after(grammarAccess.getRequiresDependencyAccess().getLeftParenthesisKeyword_0()); 

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
    // $ANTLR end "rule__RequiresDependency__Group__0__Impl"


    // $ANTLR start "rule__RequiresDependency__Group__1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3504:1: rule__RequiresDependency__Group__1 : rule__RequiresDependency__Group__1__Impl rule__RequiresDependency__Group__2 ;
    public final void rule__RequiresDependency__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3508:1: ( rule__RequiresDependency__Group__1__Impl rule__RequiresDependency__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3509:2: rule__RequiresDependency__Group__1__Impl rule__RequiresDependency__Group__2
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__1__Impl_in_rule__RequiresDependency__Group__16928);
            rule__RequiresDependency__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequiresDependency__Group__2_in_rule__RequiresDependency__Group__16931);
            rule__RequiresDependency__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequiresDependency__Group__1"


    // $ANTLR start "rule__RequiresDependency__Group__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3516:1: rule__RequiresDependency__Group__1__Impl : ( ( rule__RequiresDependency__RequiredTransformationAssignment_1 ) ) ;
    public final void rule__RequiresDependency__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3520:1: ( ( ( rule__RequiresDependency__RequiredTransformationAssignment_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3521:1: ( ( rule__RequiresDependency__RequiredTransformationAssignment_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3521:1: ( ( rule__RequiresDependency__RequiredTransformationAssignment_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3522:1: ( rule__RequiresDependency__RequiredTransformationAssignment_1 )
            {
             before(grammarAccess.getRequiresDependencyAccess().getRequiredTransformationAssignment_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3523:1: ( rule__RequiresDependency__RequiredTransformationAssignment_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3523:2: rule__RequiresDependency__RequiredTransformationAssignment_1
            {
            pushFollow(FOLLOW_rule__RequiresDependency__RequiredTransformationAssignment_1_in_rule__RequiresDependency__Group__1__Impl6958);
            rule__RequiresDependency__RequiredTransformationAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getRequiresDependencyAccess().getRequiredTransformationAssignment_1()); 

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
    // $ANTLR end "rule__RequiresDependency__Group__1__Impl"


    // $ANTLR start "rule__RequiresDependency__Group__2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3533:1: rule__RequiresDependency__Group__2 : rule__RequiresDependency__Group__2__Impl rule__RequiresDependency__Group__3 ;
    public final void rule__RequiresDependency__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3537:1: ( rule__RequiresDependency__Group__2__Impl rule__RequiresDependency__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3538:2: rule__RequiresDependency__Group__2__Impl rule__RequiresDependency__Group__3
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__2__Impl_in_rule__RequiresDependency__Group__26988);
            rule__RequiresDependency__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequiresDependency__Group__3_in_rule__RequiresDependency__Group__26991);
            rule__RequiresDependency__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequiresDependency__Group__2"


    // $ANTLR start "rule__RequiresDependency__Group__2__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3545:1: rule__RequiresDependency__Group__2__Impl : ( '.' ) ;
    public final void rule__RequiresDependency__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3549:1: ( ( '.' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3550:1: ( '.' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3550:1: ( '.' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3551:1: '.'
            {
             before(grammarAccess.getRequiresDependencyAccess().getFullStopKeyword_2()); 
            match(input,28,FOLLOW_28_in_rule__RequiresDependency__Group__2__Impl7019); 
             after(grammarAccess.getRequiresDependencyAccess().getFullStopKeyword_2()); 

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
    // $ANTLR end "rule__RequiresDependency__Group__2__Impl"


    // $ANTLR start "rule__RequiresDependency__Group__3"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3564:1: rule__RequiresDependency__Group__3 : rule__RequiresDependency__Group__3__Impl rule__RequiresDependency__Group__4 ;
    public final void rule__RequiresDependency__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3568:1: ( rule__RequiresDependency__Group__3__Impl rule__RequiresDependency__Group__4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3569:2: rule__RequiresDependency__Group__3__Impl rule__RequiresDependency__Group__4
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__3__Impl_in_rule__RequiresDependency__Group__37050);
            rule__RequiresDependency__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequiresDependency__Group__4_in_rule__RequiresDependency__Group__37053);
            rule__RequiresDependency__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequiresDependency__Group__3"


    // $ANTLR start "rule__RequiresDependency__Group__3__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3576:1: rule__RequiresDependency__Group__3__Impl : ( ( rule__RequiresDependency__RequiredRuleAssignment_3 ) ) ;
    public final void rule__RequiresDependency__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3580:1: ( ( ( rule__RequiresDependency__RequiredRuleAssignment_3 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3581:1: ( ( rule__RequiresDependency__RequiredRuleAssignment_3 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3581:1: ( ( rule__RequiresDependency__RequiredRuleAssignment_3 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3582:1: ( rule__RequiresDependency__RequiredRuleAssignment_3 )
            {
             before(grammarAccess.getRequiresDependencyAccess().getRequiredRuleAssignment_3()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3583:1: ( rule__RequiresDependency__RequiredRuleAssignment_3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3583:2: rule__RequiresDependency__RequiredRuleAssignment_3
            {
            pushFollow(FOLLOW_rule__RequiresDependency__RequiredRuleAssignment_3_in_rule__RequiresDependency__Group__3__Impl7080);
            rule__RequiresDependency__RequiredRuleAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getRequiresDependencyAccess().getRequiredRuleAssignment_3()); 

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
    // $ANTLR end "rule__RequiresDependency__Group__3__Impl"


    // $ANTLR start "rule__RequiresDependency__Group__4"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3593:1: rule__RequiresDependency__Group__4 : rule__RequiresDependency__Group__4__Impl rule__RequiresDependency__Group__5 ;
    public final void rule__RequiresDependency__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3597:1: ( rule__RequiresDependency__Group__4__Impl rule__RequiresDependency__Group__5 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3598:2: rule__RequiresDependency__Group__4__Impl rule__RequiresDependency__Group__5
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__4__Impl_in_rule__RequiresDependency__Group__47110);
            rule__RequiresDependency__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequiresDependency__Group__5_in_rule__RequiresDependency__Group__47113);
            rule__RequiresDependency__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequiresDependency__Group__4"


    // $ANTLR start "rule__RequiresDependency__Group__4__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3605:1: rule__RequiresDependency__Group__4__Impl : ( ',' ) ;
    public final void rule__RequiresDependency__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3609:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3610:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3610:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3611:1: ','
            {
             before(grammarAccess.getRequiresDependencyAccess().getCommaKeyword_4()); 
            match(input,20,FOLLOW_20_in_rule__RequiresDependency__Group__4__Impl7141); 
             after(grammarAccess.getRequiresDependencyAccess().getCommaKeyword_4()); 

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
    // $ANTLR end "rule__RequiresDependency__Group__4__Impl"


    // $ANTLR start "rule__RequiresDependency__Group__5"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3624:1: rule__RequiresDependency__Group__5 : rule__RequiresDependency__Group__5__Impl rule__RequiresDependency__Group__6 ;
    public final void rule__RequiresDependency__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3628:1: ( rule__RequiresDependency__Group__5__Impl rule__RequiresDependency__Group__6 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3629:2: rule__RequiresDependency__Group__5__Impl rule__RequiresDependency__Group__6
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__5__Impl_in_rule__RequiresDependency__Group__57172);
            rule__RequiresDependency__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequiresDependency__Group__6_in_rule__RequiresDependency__Group__57175);
            rule__RequiresDependency__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequiresDependency__Group__5"


    // $ANTLR start "rule__RequiresDependency__Group__5__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3636:1: rule__RequiresDependency__Group__5__Impl : ( ( rule__RequiresDependency__FieldsAssignment_5 ) ) ;
    public final void rule__RequiresDependency__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3640:1: ( ( ( rule__RequiresDependency__FieldsAssignment_5 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3641:1: ( ( rule__RequiresDependency__FieldsAssignment_5 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3641:1: ( ( rule__RequiresDependency__FieldsAssignment_5 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3642:1: ( rule__RequiresDependency__FieldsAssignment_5 )
            {
             before(grammarAccess.getRequiresDependencyAccess().getFieldsAssignment_5()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3643:1: ( rule__RequiresDependency__FieldsAssignment_5 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3643:2: rule__RequiresDependency__FieldsAssignment_5
            {
            pushFollow(FOLLOW_rule__RequiresDependency__FieldsAssignment_5_in_rule__RequiresDependency__Group__5__Impl7202);
            rule__RequiresDependency__FieldsAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getRequiresDependencyAccess().getFieldsAssignment_5()); 

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
    // $ANTLR end "rule__RequiresDependency__Group__5__Impl"


    // $ANTLR start "rule__RequiresDependency__Group__6"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3653:1: rule__RequiresDependency__Group__6 : rule__RequiresDependency__Group__6__Impl rule__RequiresDependency__Group__7 ;
    public final void rule__RequiresDependency__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3657:1: ( rule__RequiresDependency__Group__6__Impl rule__RequiresDependency__Group__7 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3658:2: rule__RequiresDependency__Group__6__Impl rule__RequiresDependency__Group__7
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__6__Impl_in_rule__RequiresDependency__Group__67232);
            rule__RequiresDependency__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequiresDependency__Group__7_in_rule__RequiresDependency__Group__67235);
            rule__RequiresDependency__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequiresDependency__Group__6"


    // $ANTLR start "rule__RequiresDependency__Group__6__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3665:1: rule__RequiresDependency__Group__6__Impl : ( ':' ) ;
    public final void rule__RequiresDependency__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3669:1: ( ( ':' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3670:1: ( ':' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3670:1: ( ':' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3671:1: ':'
            {
             before(grammarAccess.getRequiresDependencyAccess().getColonKeyword_6()); 
            match(input,19,FOLLOW_19_in_rule__RequiresDependency__Group__6__Impl7263); 
             after(grammarAccess.getRequiresDependencyAccess().getColonKeyword_6()); 

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
    // $ANTLR end "rule__RequiresDependency__Group__6__Impl"


    // $ANTLR start "rule__RequiresDependency__Group__7"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3684:1: rule__RequiresDependency__Group__7 : rule__RequiresDependency__Group__7__Impl rule__RequiresDependency__Group__8 ;
    public final void rule__RequiresDependency__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3688:1: ( rule__RequiresDependency__Group__7__Impl rule__RequiresDependency__Group__8 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3689:2: rule__RequiresDependency__Group__7__Impl rule__RequiresDependency__Group__8
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__7__Impl_in_rule__RequiresDependency__Group__77294);
            rule__RequiresDependency__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequiresDependency__Group__8_in_rule__RequiresDependency__Group__77297);
            rule__RequiresDependency__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequiresDependency__Group__7"


    // $ANTLR start "rule__RequiresDependency__Group__7__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3696:1: rule__RequiresDependency__Group__7__Impl : ( ( rule__RequiresDependency__OclExpressionAssignment_7 ) ) ;
    public final void rule__RequiresDependency__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3700:1: ( ( ( rule__RequiresDependency__OclExpressionAssignment_7 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3701:1: ( ( rule__RequiresDependency__OclExpressionAssignment_7 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3701:1: ( ( rule__RequiresDependency__OclExpressionAssignment_7 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3702:1: ( rule__RequiresDependency__OclExpressionAssignment_7 )
            {
             before(grammarAccess.getRequiresDependencyAccess().getOclExpressionAssignment_7()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3703:1: ( rule__RequiresDependency__OclExpressionAssignment_7 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3703:2: rule__RequiresDependency__OclExpressionAssignment_7
            {
            pushFollow(FOLLOW_rule__RequiresDependency__OclExpressionAssignment_7_in_rule__RequiresDependency__Group__7__Impl7324);
            rule__RequiresDependency__OclExpressionAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getRequiresDependencyAccess().getOclExpressionAssignment_7()); 

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
    // $ANTLR end "rule__RequiresDependency__Group__7__Impl"


    // $ANTLR start "rule__RequiresDependency__Group__8"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3713:1: rule__RequiresDependency__Group__8 : rule__RequiresDependency__Group__8__Impl ;
    public final void rule__RequiresDependency__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3717:1: ( rule__RequiresDependency__Group__8__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3718:2: rule__RequiresDependency__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__8__Impl_in_rule__RequiresDependency__Group__87354);
            rule__RequiresDependency__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__RequiresDependency__Group__8"


    // $ANTLR start "rule__RequiresDependency__Group__8__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3724:1: rule__RequiresDependency__Group__8__Impl : ( ')' ) ;
    public final void rule__RequiresDependency__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3728:1: ( ( ')' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3729:1: ( ')' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3729:1: ( ')' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3730:1: ')'
            {
             before(grammarAccess.getRequiresDependencyAccess().getRightParenthesisKeyword_8()); 
            match(input,25,FOLLOW_25_in_rule__RequiresDependency__Group__8__Impl7382); 
             after(grammarAccess.getRequiresDependencyAccess().getRightParenthesisKeyword_8()); 

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
    // $ANTLR end "rule__RequiresDependency__Group__8__Impl"


    // $ANTLR start "rule__ExcludeDependency__Group__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3761:1: rule__ExcludeDependency__Group__0 : rule__ExcludeDependency__Group__0__Impl rule__ExcludeDependency__Group__1 ;
    public final void rule__ExcludeDependency__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3765:1: ( rule__ExcludeDependency__Group__0__Impl rule__ExcludeDependency__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3766:2: rule__ExcludeDependency__Group__0__Impl rule__ExcludeDependency__Group__1
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__0__Impl_in_rule__ExcludeDependency__Group__07431);
            rule__ExcludeDependency__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExcludeDependency__Group__1_in_rule__ExcludeDependency__Group__07434);
            rule__ExcludeDependency__Group__1();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExcludeDependency__Group__0"


    // $ANTLR start "rule__ExcludeDependency__Group__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3773:1: rule__ExcludeDependency__Group__0__Impl : ( '(' ) ;
    public final void rule__ExcludeDependency__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3777:1: ( ( '(' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3778:1: ( '(' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3778:1: ( '(' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3779:1: '('
            {
             before(grammarAccess.getExcludeDependencyAccess().getLeftParenthesisKeyword_0()); 
            match(input,24,FOLLOW_24_in_rule__ExcludeDependency__Group__0__Impl7462); 
             after(grammarAccess.getExcludeDependencyAccess().getLeftParenthesisKeyword_0()); 

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
    // $ANTLR end "rule__ExcludeDependency__Group__0__Impl"


    // $ANTLR start "rule__ExcludeDependency__Group__1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3792:1: rule__ExcludeDependency__Group__1 : rule__ExcludeDependency__Group__1__Impl rule__ExcludeDependency__Group__2 ;
    public final void rule__ExcludeDependency__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3796:1: ( rule__ExcludeDependency__Group__1__Impl rule__ExcludeDependency__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3797:2: rule__ExcludeDependency__Group__1__Impl rule__ExcludeDependency__Group__2
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__1__Impl_in_rule__ExcludeDependency__Group__17493);
            rule__ExcludeDependency__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExcludeDependency__Group__2_in_rule__ExcludeDependency__Group__17496);
            rule__ExcludeDependency__Group__2();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExcludeDependency__Group__1"


    // $ANTLR start "rule__ExcludeDependency__Group__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3804:1: rule__ExcludeDependency__Group__1__Impl : ( ( rule__ExcludeDependency__RequiredTransformationAssignment_1 ) ) ;
    public final void rule__ExcludeDependency__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3808:1: ( ( ( rule__ExcludeDependency__RequiredTransformationAssignment_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3809:1: ( ( rule__ExcludeDependency__RequiredTransformationAssignment_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3809:1: ( ( rule__ExcludeDependency__RequiredTransformationAssignment_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3810:1: ( rule__ExcludeDependency__RequiredTransformationAssignment_1 )
            {
             before(grammarAccess.getExcludeDependencyAccess().getRequiredTransformationAssignment_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3811:1: ( rule__ExcludeDependency__RequiredTransformationAssignment_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3811:2: rule__ExcludeDependency__RequiredTransformationAssignment_1
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__RequiredTransformationAssignment_1_in_rule__ExcludeDependency__Group__1__Impl7523);
            rule__ExcludeDependency__RequiredTransformationAssignment_1();

            state._fsp--;


            }

             after(grammarAccess.getExcludeDependencyAccess().getRequiredTransformationAssignment_1()); 

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
    // $ANTLR end "rule__ExcludeDependency__Group__1__Impl"


    // $ANTLR start "rule__ExcludeDependency__Group__2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3821:1: rule__ExcludeDependency__Group__2 : rule__ExcludeDependency__Group__2__Impl rule__ExcludeDependency__Group__3 ;
    public final void rule__ExcludeDependency__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3825:1: ( rule__ExcludeDependency__Group__2__Impl rule__ExcludeDependency__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3826:2: rule__ExcludeDependency__Group__2__Impl rule__ExcludeDependency__Group__3
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__2__Impl_in_rule__ExcludeDependency__Group__27553);
            rule__ExcludeDependency__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExcludeDependency__Group__3_in_rule__ExcludeDependency__Group__27556);
            rule__ExcludeDependency__Group__3();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExcludeDependency__Group__2"


    // $ANTLR start "rule__ExcludeDependency__Group__2__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3833:1: rule__ExcludeDependency__Group__2__Impl : ( '.' ) ;
    public final void rule__ExcludeDependency__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3837:1: ( ( '.' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3838:1: ( '.' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3838:1: ( '.' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3839:1: '.'
            {
             before(grammarAccess.getExcludeDependencyAccess().getFullStopKeyword_2()); 
            match(input,28,FOLLOW_28_in_rule__ExcludeDependency__Group__2__Impl7584); 
             after(grammarAccess.getExcludeDependencyAccess().getFullStopKeyword_2()); 

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
    // $ANTLR end "rule__ExcludeDependency__Group__2__Impl"


    // $ANTLR start "rule__ExcludeDependency__Group__3"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3852:1: rule__ExcludeDependency__Group__3 : rule__ExcludeDependency__Group__3__Impl rule__ExcludeDependency__Group__4 ;
    public final void rule__ExcludeDependency__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3856:1: ( rule__ExcludeDependency__Group__3__Impl rule__ExcludeDependency__Group__4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3857:2: rule__ExcludeDependency__Group__3__Impl rule__ExcludeDependency__Group__4
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__3__Impl_in_rule__ExcludeDependency__Group__37615);
            rule__ExcludeDependency__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExcludeDependency__Group__4_in_rule__ExcludeDependency__Group__37618);
            rule__ExcludeDependency__Group__4();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExcludeDependency__Group__3"


    // $ANTLR start "rule__ExcludeDependency__Group__3__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3864:1: rule__ExcludeDependency__Group__3__Impl : ( ( rule__ExcludeDependency__RequiredRuleAssignment_3 ) ) ;
    public final void rule__ExcludeDependency__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3868:1: ( ( ( rule__ExcludeDependency__RequiredRuleAssignment_3 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3869:1: ( ( rule__ExcludeDependency__RequiredRuleAssignment_3 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3869:1: ( ( rule__ExcludeDependency__RequiredRuleAssignment_3 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3870:1: ( rule__ExcludeDependency__RequiredRuleAssignment_3 )
            {
             before(grammarAccess.getExcludeDependencyAccess().getRequiredRuleAssignment_3()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3871:1: ( rule__ExcludeDependency__RequiredRuleAssignment_3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3871:2: rule__ExcludeDependency__RequiredRuleAssignment_3
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__RequiredRuleAssignment_3_in_rule__ExcludeDependency__Group__3__Impl7645);
            rule__ExcludeDependency__RequiredRuleAssignment_3();

            state._fsp--;


            }

             after(grammarAccess.getExcludeDependencyAccess().getRequiredRuleAssignment_3()); 

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
    // $ANTLR end "rule__ExcludeDependency__Group__3__Impl"


    // $ANTLR start "rule__ExcludeDependency__Group__4"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3881:1: rule__ExcludeDependency__Group__4 : rule__ExcludeDependency__Group__4__Impl rule__ExcludeDependency__Group__5 ;
    public final void rule__ExcludeDependency__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3885:1: ( rule__ExcludeDependency__Group__4__Impl rule__ExcludeDependency__Group__5 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3886:2: rule__ExcludeDependency__Group__4__Impl rule__ExcludeDependency__Group__5
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__4__Impl_in_rule__ExcludeDependency__Group__47675);
            rule__ExcludeDependency__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExcludeDependency__Group__5_in_rule__ExcludeDependency__Group__47678);
            rule__ExcludeDependency__Group__5();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExcludeDependency__Group__4"


    // $ANTLR start "rule__ExcludeDependency__Group__4__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3893:1: rule__ExcludeDependency__Group__4__Impl : ( ',' ) ;
    public final void rule__ExcludeDependency__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3897:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3898:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3898:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3899:1: ','
            {
             before(grammarAccess.getExcludeDependencyAccess().getCommaKeyword_4()); 
            match(input,20,FOLLOW_20_in_rule__ExcludeDependency__Group__4__Impl7706); 
             after(grammarAccess.getExcludeDependencyAccess().getCommaKeyword_4()); 

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
    // $ANTLR end "rule__ExcludeDependency__Group__4__Impl"


    // $ANTLR start "rule__ExcludeDependency__Group__5"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3912:1: rule__ExcludeDependency__Group__5 : rule__ExcludeDependency__Group__5__Impl rule__ExcludeDependency__Group__6 ;
    public final void rule__ExcludeDependency__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3916:1: ( rule__ExcludeDependency__Group__5__Impl rule__ExcludeDependency__Group__6 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3917:2: rule__ExcludeDependency__Group__5__Impl rule__ExcludeDependency__Group__6
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__5__Impl_in_rule__ExcludeDependency__Group__57737);
            rule__ExcludeDependency__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExcludeDependency__Group__6_in_rule__ExcludeDependency__Group__57740);
            rule__ExcludeDependency__Group__6();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExcludeDependency__Group__5"


    // $ANTLR start "rule__ExcludeDependency__Group__5__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3924:1: rule__ExcludeDependency__Group__5__Impl : ( ( rule__ExcludeDependency__FieldsAssignment_5 ) ) ;
    public final void rule__ExcludeDependency__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3928:1: ( ( ( rule__ExcludeDependency__FieldsAssignment_5 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3929:1: ( ( rule__ExcludeDependency__FieldsAssignment_5 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3929:1: ( ( rule__ExcludeDependency__FieldsAssignment_5 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3930:1: ( rule__ExcludeDependency__FieldsAssignment_5 )
            {
             before(grammarAccess.getExcludeDependencyAccess().getFieldsAssignment_5()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3931:1: ( rule__ExcludeDependency__FieldsAssignment_5 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3931:2: rule__ExcludeDependency__FieldsAssignment_5
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__FieldsAssignment_5_in_rule__ExcludeDependency__Group__5__Impl7767);
            rule__ExcludeDependency__FieldsAssignment_5();

            state._fsp--;


            }

             after(grammarAccess.getExcludeDependencyAccess().getFieldsAssignment_5()); 

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
    // $ANTLR end "rule__ExcludeDependency__Group__5__Impl"


    // $ANTLR start "rule__ExcludeDependency__Group__6"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3941:1: rule__ExcludeDependency__Group__6 : rule__ExcludeDependency__Group__6__Impl rule__ExcludeDependency__Group__7 ;
    public final void rule__ExcludeDependency__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3945:1: ( rule__ExcludeDependency__Group__6__Impl rule__ExcludeDependency__Group__7 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3946:2: rule__ExcludeDependency__Group__6__Impl rule__ExcludeDependency__Group__7
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__6__Impl_in_rule__ExcludeDependency__Group__67797);
            rule__ExcludeDependency__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExcludeDependency__Group__7_in_rule__ExcludeDependency__Group__67800);
            rule__ExcludeDependency__Group__7();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExcludeDependency__Group__6"


    // $ANTLR start "rule__ExcludeDependency__Group__6__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3953:1: rule__ExcludeDependency__Group__6__Impl : ( ':' ) ;
    public final void rule__ExcludeDependency__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3957:1: ( ( ':' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3958:1: ( ':' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3958:1: ( ':' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3959:1: ':'
            {
             before(grammarAccess.getExcludeDependencyAccess().getColonKeyword_6()); 
            match(input,19,FOLLOW_19_in_rule__ExcludeDependency__Group__6__Impl7828); 
             after(grammarAccess.getExcludeDependencyAccess().getColonKeyword_6()); 

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
    // $ANTLR end "rule__ExcludeDependency__Group__6__Impl"


    // $ANTLR start "rule__ExcludeDependency__Group__7"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3972:1: rule__ExcludeDependency__Group__7 : rule__ExcludeDependency__Group__7__Impl rule__ExcludeDependency__Group__8 ;
    public final void rule__ExcludeDependency__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3976:1: ( rule__ExcludeDependency__Group__7__Impl rule__ExcludeDependency__Group__8 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3977:2: rule__ExcludeDependency__Group__7__Impl rule__ExcludeDependency__Group__8
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__7__Impl_in_rule__ExcludeDependency__Group__77859);
            rule__ExcludeDependency__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExcludeDependency__Group__8_in_rule__ExcludeDependency__Group__77862);
            rule__ExcludeDependency__Group__8();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExcludeDependency__Group__7"


    // $ANTLR start "rule__ExcludeDependency__Group__7__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3984:1: rule__ExcludeDependency__Group__7__Impl : ( ( rule__ExcludeDependency__OclExpressionAssignment_7 ) ) ;
    public final void rule__ExcludeDependency__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3988:1: ( ( ( rule__ExcludeDependency__OclExpressionAssignment_7 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3989:1: ( ( rule__ExcludeDependency__OclExpressionAssignment_7 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3989:1: ( ( rule__ExcludeDependency__OclExpressionAssignment_7 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3990:1: ( rule__ExcludeDependency__OclExpressionAssignment_7 )
            {
             before(grammarAccess.getExcludeDependencyAccess().getOclExpressionAssignment_7()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3991:1: ( rule__ExcludeDependency__OclExpressionAssignment_7 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3991:2: rule__ExcludeDependency__OclExpressionAssignment_7
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__OclExpressionAssignment_7_in_rule__ExcludeDependency__Group__7__Impl7889);
            rule__ExcludeDependency__OclExpressionAssignment_7();

            state._fsp--;


            }

             after(grammarAccess.getExcludeDependencyAccess().getOclExpressionAssignment_7()); 

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
    // $ANTLR end "rule__ExcludeDependency__Group__7__Impl"


    // $ANTLR start "rule__ExcludeDependency__Group__8"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4001:1: rule__ExcludeDependency__Group__8 : rule__ExcludeDependency__Group__8__Impl ;
    public final void rule__ExcludeDependency__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4005:1: ( rule__ExcludeDependency__Group__8__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4006:2: rule__ExcludeDependency__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__8__Impl_in_rule__ExcludeDependency__Group__87919);
            rule__ExcludeDependency__Group__8__Impl();

            state._fsp--;


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ExcludeDependency__Group__8"


    // $ANTLR start "rule__ExcludeDependency__Group__8__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4012:1: rule__ExcludeDependency__Group__8__Impl : ( ')' ) ;
    public final void rule__ExcludeDependency__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4016:1: ( ( ')' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4017:1: ( ')' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4017:1: ( ')' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4018:1: ')'
            {
             before(grammarAccess.getExcludeDependencyAccess().getRightParenthesisKeyword_8()); 
            match(input,25,FOLLOW_25_in_rule__ExcludeDependency__Group__8__Impl7947); 
             after(grammarAccess.getExcludeDependencyAccess().getRightParenthesisKeyword_8()); 

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
    // $ANTLR end "rule__ExcludeDependency__Group__8__Impl"


    // $ANTLR start "rule__EInt__Group__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4049:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4053:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4054:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
            {
            pushFollow(FOLLOW_rule__EInt__Group__0__Impl_in_rule__EInt__Group__07996);
            rule__EInt__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EInt__Group__1_in_rule__EInt__Group__07999);
            rule__EInt__Group__1();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4061:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4065:1: ( ( ( '-' )? ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4066:1: ( ( '-' )? )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4066:1: ( ( '-' )? )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4067:1: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4068:1: ( '-' )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==33) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4069:2: '-'
                    {
                    match(input,33,FOLLOW_33_in_rule__EInt__Group__0__Impl8028); 

                    }
                    break;

            }

             after(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4080:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4084:1: ( rule__EInt__Group__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4085:2: rule__EInt__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EInt__Group__1__Impl_in_rule__EInt__Group__18061);
            rule__EInt__Group__1__Impl();

            state._fsp--;


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4091:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4095:1: ( ( RULE_INT ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4096:1: ( RULE_INT )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4096:1: ( RULE_INT )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4097:1: RULE_INT
            {
             before(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__EInt__Group__1__Impl8088); 
             after(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 

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


    // $ANTLR start "rule__TrcSpecification__FromsAssignment_0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4113:1: rule__TrcSpecification__FromsAssignment_0 : ( ruleFrom ) ;
    public final void rule__TrcSpecification__FromsAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4117:1: ( ( ruleFrom ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4118:1: ( ruleFrom )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4118:1: ( ruleFrom )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4119:1: ruleFrom
            {
             before(grammarAccess.getTrcSpecificationAccess().getFromsFromParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleFrom_in_rule__TrcSpecification__FromsAssignment_08126);
            ruleFrom();

            state._fsp--;

             after(grammarAccess.getTrcSpecificationAccess().getFromsFromParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__TrcSpecification__FromsAssignment_0"


    // $ANTLR start "rule__TrcSpecification__ModuleListAssignment_1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4128:1: rule__TrcSpecification__ModuleListAssignment_1 : ( ruleModuleList ) ;
    public final void rule__TrcSpecification__ModuleListAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4132:1: ( ( ruleModuleList ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4133:1: ( ruleModuleList )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4133:1: ( ruleModuleList )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4134:1: ruleModuleList
            {
             before(grammarAccess.getTrcSpecificationAccess().getModuleListModuleListParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleModuleList_in_rule__TrcSpecification__ModuleListAssignment_18157);
            ruleModuleList();

            state._fsp--;

             after(grammarAccess.getTrcSpecificationAccess().getModuleListModuleListParserRuleCall_1_0()); 

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
    // $ANTLR end "rule__TrcSpecification__ModuleListAssignment_1"


    // $ANTLR start "rule__TrcSpecification__TransformationListAssignment_2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4143:1: rule__TrcSpecification__TransformationListAssignment_2 : ( ruleTransformationList ) ;
    public final void rule__TrcSpecification__TransformationListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4147:1: ( ( ruleTransformationList ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4148:1: ( ruleTransformationList )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4148:1: ( ruleTransformationList )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4149:1: ruleTransformationList
            {
             before(grammarAccess.getTrcSpecificationAccess().getTransformationListTransformationListParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleTransformationList_in_rule__TrcSpecification__TransformationListAssignment_28188);
            ruleTransformationList();

            state._fsp--;

             after(grammarAccess.getTrcSpecificationAccess().getTransformationListTransformationListParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__TrcSpecification__TransformationListAssignment_2"


    // $ANTLR start "rule__TrcSpecification__DependencyListAssignment_3"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4158:1: rule__TrcSpecification__DependencyListAssignment_3 : ( ruleTransformationDependencyList ) ;
    public final void rule__TrcSpecification__DependencyListAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4162:1: ( ( ruleTransformationDependencyList ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4163:1: ( ruleTransformationDependencyList )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4163:1: ( ruleTransformationDependencyList )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4164:1: ruleTransformationDependencyList
            {
             before(grammarAccess.getTrcSpecificationAccess().getDependencyListTransformationDependencyListParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleTransformationDependencyList_in_rule__TrcSpecification__DependencyListAssignment_38219);
            ruleTransformationDependencyList();

            state._fsp--;

             after(grammarAccess.getTrcSpecificationAccess().getDependencyListTransformationDependencyListParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__TrcSpecification__DependencyListAssignment_3"


    // $ANTLR start "rule__From__ImportURIAssignment_1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4173:1: rule__From__ImportURIAssignment_1 : ( RULE_STRING ) ;
    public final void rule__From__ImportURIAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4177:1: ( ( RULE_STRING ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4178:1: ( RULE_STRING )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4178:1: ( RULE_STRING )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4179:1: RULE_STRING
            {
             before(grammarAccess.getFromAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__From__ImportURIAssignment_18250); 
             after(grammarAccess.getFromAccess().getImportURISTRINGTerminalRuleCall_1_0()); 

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
    // $ANTLR end "rule__From__ImportURIAssignment_1"


    // $ANTLR start "rule__Rules__NameAssignment"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4188:1: rule__Rules__NameAssignment : ( ruleEString ) ;
    public final void rule__Rules__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4192:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4193:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4193:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4194:1: ruleEString
            {
             before(grammarAccess.getRulesAccess().getNameEStringParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__Rules__NameAssignment8281);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getRulesAccess().getNameEStringParserRuleCall_0()); 

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
    // $ANTLR end "rule__Rules__NameAssignment"


    // $ANTLR start "rule__ModuleList__ModulesAssignment_3_0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4203:1: rule__ModuleList__ModulesAssignment_3_0 : ( ruleModules ) ;
    public final void rule__ModuleList__ModulesAssignment_3_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4207:1: ( ( ruleModules ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4208:1: ( ruleModules )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4208:1: ( ruleModules )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4209:1: ruleModules
            {
             before(grammarAccess.getModuleListAccess().getModulesModulesParserRuleCall_3_0_0()); 
            pushFollow(FOLLOW_ruleModules_in_rule__ModuleList__ModulesAssignment_3_08312);
            ruleModules();

            state._fsp--;

             after(grammarAccess.getModuleListAccess().getModulesModulesParserRuleCall_3_0_0()); 

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
    // $ANTLR end "rule__ModuleList__ModulesAssignment_3_0"


    // $ANTLR start "rule__ModuleList__ModulesAssignment_3_1_1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4218:1: rule__ModuleList__ModulesAssignment_3_1_1 : ( ruleModules ) ;
    public final void rule__ModuleList__ModulesAssignment_3_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4222:1: ( ( ruleModules ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4223:1: ( ruleModules )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4223:1: ( ruleModules )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4224:1: ruleModules
            {
             before(grammarAccess.getModuleListAccess().getModulesModulesParserRuleCall_3_1_1_0()); 
            pushFollow(FOLLOW_ruleModules_in_rule__ModuleList__ModulesAssignment_3_1_18343);
            ruleModules();

            state._fsp--;

             after(grammarAccess.getModuleListAccess().getModulesModulesParserRuleCall_3_1_1_0()); 

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
    // $ANTLR end "rule__ModuleList__ModulesAssignment_3_1_1"


    // $ANTLR start "rule__Modules__PathAssignment_0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4233:1: rule__Modules__PathAssignment_0 : ( ruleEString ) ;
    public final void rule__Modules__PathAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4237:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4238:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4238:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4239:1: ruleEString
            {
             before(grammarAccess.getModulesAccess().getPathEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__Modules__PathAssignment_08374);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getModulesAccess().getPathEStringParserRuleCall_0_0()); 

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
    // $ANTLR end "rule__Modules__PathAssignment_0"


    // $ANTLR start "rule__Modules__NameAssignment_2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4248:1: rule__Modules__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__Modules__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4252:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4253:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4253:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4254:1: ruleEString
            {
             before(grammarAccess.getModulesAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__Modules__NameAssignment_28405);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getModulesAccess().getNameEStringParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__Modules__NameAssignment_2"


    // $ANTLR start "rule__Modules__RuleNameAssignment_4"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4263:1: rule__Modules__RuleNameAssignment_4 : ( ruleRules ) ;
    public final void rule__Modules__RuleNameAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4267:1: ( ( ruleRules ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4268:1: ( ruleRules )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4268:1: ( ruleRules )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4269:1: ruleRules
            {
             before(grammarAccess.getModulesAccess().getRuleNameRulesParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleRules_in_rule__Modules__RuleNameAssignment_48436);
            ruleRules();

            state._fsp--;

             after(grammarAccess.getModulesAccess().getRuleNameRulesParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__Modules__RuleNameAssignment_4"


    // $ANTLR start "rule__Modules__RuleNameAssignment_5_1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4278:1: rule__Modules__RuleNameAssignment_5_1 : ( ruleRules ) ;
    public final void rule__Modules__RuleNameAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4282:1: ( ( ruleRules ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4283:1: ( ruleRules )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4283:1: ( ruleRules )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4284:1: ruleRules
            {
             before(grammarAccess.getModulesAccess().getRuleNameRulesParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleRules_in_rule__Modules__RuleNameAssignment_5_18467);
            ruleRules();

            state._fsp--;

             after(grammarAccess.getModulesAccess().getRuleNameRulesParserRuleCall_5_1_0()); 

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
    // $ANTLR end "rule__Modules__RuleNameAssignment_5_1"


    // $ANTLR start "rule__TransformationList__TransformationsAssignment_2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4293:1: rule__TransformationList__TransformationsAssignment_2 : ( ruleTransformation ) ;
    public final void rule__TransformationList__TransformationsAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4297:1: ( ( ruleTransformation ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4298:1: ( ruleTransformation )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4298:1: ( ruleTransformation )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4299:1: ruleTransformation
            {
             before(grammarAccess.getTransformationListAccess().getTransformationsTransformationParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleTransformation_in_rule__TransformationList__TransformationsAssignment_28498);
            ruleTransformation();

            state._fsp--;

             after(grammarAccess.getTransformationListAccess().getTransformationsTransformationParserRuleCall_2_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4308:1: rule__TransformationList__TransformationsAssignment_3_1 : ( ruleTransformation ) ;
    public final void rule__TransformationList__TransformationsAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4312:1: ( ( ruleTransformation ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4313:1: ( ruleTransformation )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4313:1: ( ruleTransformation )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4314:1: ruleTransformation
            {
             before(grammarAccess.getTransformationListAccess().getTransformationsTransformationParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleTransformation_in_rule__TransformationList__TransformationsAssignment_3_18529);
            ruleTransformation();

            state._fsp--;

             after(grammarAccess.getTransformationListAccess().getTransformationsTransformationParserRuleCall_3_1_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4323:1: rule__Transformation__NameAssignment_0 : ( ruleEString ) ;
    public final void rule__Transformation__NameAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4327:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4328:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4328:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4329:1: ruleEString
            {
             before(grammarAccess.getTransformationAccess().getNameEStringParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__Transformation__NameAssignment_08560);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTransformationAccess().getNameEStringParserRuleCall_0_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4338:1: rule__Transformation__ModulesAssignment_4 : ( ( ruleEString ) ) ;
    public final void rule__Transformation__ModulesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4342:1: ( ( ( ruleEString ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4343:1: ( ( ruleEString ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4343:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4344:1: ( ruleEString )
            {
             before(grammarAccess.getTransformationAccess().getModulesModulesCrossReference_4_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4345:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4346:1: ruleEString
            {
             before(grammarAccess.getTransformationAccess().getModulesModulesEStringParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleEString_in_rule__Transformation__ModulesAssignment_48595);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTransformationAccess().getModulesModulesEStringParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getTransformationAccess().getModulesModulesCrossReference_4_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4357:1: rule__Transformation__ModulesAssignment_5_1 : ( ( ruleEString ) ) ;
    public final void rule__Transformation__ModulesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4361:1: ( ( ( ruleEString ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4362:1: ( ( ruleEString ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4362:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4363:1: ( ruleEString )
            {
             before(grammarAccess.getTransformationAccess().getModulesModulesCrossReference_5_1_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4364:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4365:1: ruleEString
            {
             before(grammarAccess.getTransformationAccess().getModulesModulesEStringParserRuleCall_5_1_0_1()); 
            pushFollow(FOLLOW_ruleEString_in_rule__Transformation__ModulesAssignment_5_18634);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTransformationAccess().getModulesModulesEStringParserRuleCall_5_1_0_1()); 

            }

             after(grammarAccess.getTransformationAccess().getModulesModulesCrossReference_5_1_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4376:1: rule__Transformation__ImpactsAssignment_6_2 : ( ruleTransformationImpact ) ;
    public final void rule__Transformation__ImpactsAssignment_6_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4380:1: ( ( ruleTransformationImpact ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4381:1: ( ruleTransformationImpact )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4381:1: ( ruleTransformationImpact )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4382:1: ruleTransformationImpact
            {
             before(grammarAccess.getTransformationAccess().getImpactsTransformationImpactParserRuleCall_6_2_0()); 
            pushFollow(FOLLOW_ruleTransformationImpact_in_rule__Transformation__ImpactsAssignment_6_28669);
            ruleTransformationImpact();

            state._fsp--;

             after(grammarAccess.getTransformationAccess().getImpactsTransformationImpactParserRuleCall_6_2_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4391:1: rule__Transformation__ImpactsAssignment_6_3_1 : ( ruleTransformationImpact ) ;
    public final void rule__Transformation__ImpactsAssignment_6_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4395:1: ( ( ruleTransformationImpact ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4396:1: ( ruleTransformationImpact )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4396:1: ( ruleTransformationImpact )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4397:1: ruleTransformationImpact
            {
             before(grammarAccess.getTransformationAccess().getImpactsTransformationImpactParserRuleCall_6_3_1_0()); 
            pushFollow(FOLLOW_ruleTransformationImpact_in_rule__Transformation__ImpactsAssignment_6_3_18700);
            ruleTransformationImpact();

            state._fsp--;

             after(grammarAccess.getTransformationAccess().getImpactsTransformationImpactParserRuleCall_6_3_1_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4406:1: rule__TransformationImpact__QualityAttributeNameAssignment_1_0 : ( ruleEString ) ;
    public final void rule__TransformationImpact__QualityAttributeNameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4410:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4411:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4411:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4412:1: ruleEString
            {
             before(grammarAccess.getTransformationImpactAccess().getQualityAttributeNameEStringParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__TransformationImpact__QualityAttributeNameAssignment_1_08731);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTransformationImpactAccess().getQualityAttributeNameEStringParserRuleCall_1_0_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4421:1: rule__TransformationImpact__ImpactValueAssignment_2 : ( ruleEInt ) ;
    public final void rule__TransformationImpact__ImpactValueAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4425:1: ( ( ruleEInt ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4426:1: ( ruleEInt )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4426:1: ( ruleEInt )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4427:1: ruleEInt
            {
             before(grammarAccess.getTransformationImpactAccess().getImpactValueEIntParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleEInt_in_rule__TransformationImpact__ImpactValueAssignment_28762);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getTransformationImpactAccess().getImpactValueEIntParserRuleCall_2_0()); 

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


    // $ANTLR start "rule__TransformationDependencyList__NameAssignment_2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4436:1: rule__TransformationDependencyList__NameAssignment_2 : ( ruleEString ) ;
    public final void rule__TransformationDependencyList__NameAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4440:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4441:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4441:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4442:1: ruleEString
            {
             before(grammarAccess.getTransformationDependencyListAccess().getNameEStringParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__TransformationDependencyList__NameAssignment_28793);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyListAccess().getNameEStringParserRuleCall_2_0()); 

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
    // $ANTLR end "rule__TransformationDependencyList__NameAssignment_2"


    // $ANTLR start "rule__TransformationDependencyList__TransformationDependenciesAssignment_4"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4451:1: rule__TransformationDependencyList__TransformationDependenciesAssignment_4 : ( ruleTransformationDependency ) ;
    public final void rule__TransformationDependencyList__TransformationDependenciesAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4455:1: ( ( ruleTransformationDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4456:1: ( ruleTransformationDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4456:1: ( ruleTransformationDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4457:1: ruleTransformationDependency
            {
             before(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesTransformationDependencyParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleTransformationDependency_in_rule__TransformationDependencyList__TransformationDependenciesAssignment_48824);
            ruleTransformationDependency();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesTransformationDependencyParserRuleCall_4_0()); 

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
    // $ANTLR end "rule__TransformationDependencyList__TransformationDependenciesAssignment_4"


    // $ANTLR start "rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4466:1: rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1 : ( ruleTransformationDependency ) ;
    public final void rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4470:1: ( ( ruleTransformationDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4471:1: ( ruleTransformationDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4471:1: ( ruleTransformationDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4472:1: ruleTransformationDependency
            {
             before(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesTransformationDependencyParserRuleCall_5_1_0()); 
            pushFollow(FOLLOW_ruleTransformationDependency_in_rule__TransformationDependencyList__TransformationDependenciesAssignment_5_18855);
            ruleTransformationDependency();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesTransformationDependencyParserRuleCall_5_1_0()); 

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
    // $ANTLR end "rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1"


    // $ANTLR start "rule__TransformationDependency__AppliedTransformationAssignment_2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4481:1: rule__TransformationDependency__AppliedTransformationAssignment_2 : ( ( ruleEString ) ) ;
    public final void rule__TransformationDependency__AppliedTransformationAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4485:1: ( ( ( ruleEString ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4486:1: ( ( ruleEString ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4486:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4487:1: ( ruleEString )
            {
             before(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationTransformationCrossReference_2_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4488:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4489:1: ruleEString
            {
             before(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationTransformationEStringParserRuleCall_2_0_1()); 
            pushFollow(FOLLOW_ruleEString_in_rule__TransformationDependency__AppliedTransformationAssignment_28890);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationTransformationEStringParserRuleCall_2_0_1()); 

            }

             after(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationTransformationCrossReference_2_0()); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4500:1: rule__TransformationDependency__AppliedRuleAssignment_4 : ( ruleEString ) ;
    public final void rule__TransformationDependency__AppliedRuleAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4504:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4505:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4505:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4506:1: ruleEString
            {
             before(grammarAccess.getTransformationDependencyAccess().getAppliedRuleEStringParserRuleCall_4_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__TransformationDependency__AppliedRuleAssignment_48925);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyAccess().getAppliedRuleEStringParserRuleCall_4_0()); 

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


    // $ANTLR start "rule__TransformationDependency__FieldsAssignment_7"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4515:1: rule__TransformationDependency__FieldsAssignment_7 : ( ruleEString ) ;
    public final void rule__TransformationDependency__FieldsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4519:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4520:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4520:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4521:1: ruleEString
            {
             before(grammarAccess.getTransformationDependencyAccess().getFieldsEStringParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__TransformationDependency__FieldsAssignment_78956);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyAccess().getFieldsEStringParserRuleCall_7_0()); 

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
    // $ANTLR end "rule__TransformationDependency__FieldsAssignment_7"


    // $ANTLR start "rule__TransformationDependency__FieldsAssignment_8_1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4530:1: rule__TransformationDependency__FieldsAssignment_8_1 : ( ruleEString ) ;
    public final void rule__TransformationDependency__FieldsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4534:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4535:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4535:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4536:1: ruleEString
            {
             before(grammarAccess.getTransformationDependencyAccess().getFieldsEStringParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__TransformationDependency__FieldsAssignment_8_18987);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyAccess().getFieldsEStringParserRuleCall_8_1_0()); 

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
    // $ANTLR end "rule__TransformationDependency__FieldsAssignment_8_1"


    // $ANTLR start "rule__TransformationDependency__RequiredTransformationsAssignment_12"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4545:1: rule__TransformationDependency__RequiredTransformationsAssignment_12 : ( ruleAbstractRuleDependency ) ;
    public final void rule__TransformationDependency__RequiredTransformationsAssignment_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4549:1: ( ( ruleAbstractRuleDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4550:1: ( ruleAbstractRuleDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4550:1: ( ruleAbstractRuleDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4551:1: ruleAbstractRuleDependency
            {
             before(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_0()); 
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_rule__TransformationDependency__RequiredTransformationsAssignment_129018);
            ruleAbstractRuleDependency();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_0()); 

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


    // $ANTLR start "rule__TransformationDependency__RequiredTransformationsAssignment_14"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4560:1: rule__TransformationDependency__RequiredTransformationsAssignment_14 : ( ruleAbstractRuleDependency ) ;
    public final void rule__TransformationDependency__RequiredTransformationsAssignment_14() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4564:1: ( ( ruleAbstractRuleDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4565:1: ( ruleAbstractRuleDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4565:1: ( ruleAbstractRuleDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4566:1: ruleAbstractRuleDependency
            {
             before(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_14_0()); 
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_rule__TransformationDependency__RequiredTransformationsAssignment_149049);
            ruleAbstractRuleDependency();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_14_0()); 

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
    // $ANTLR end "rule__TransformationDependency__RequiredTransformationsAssignment_14"


    // $ANTLR start "rule__RuleDependency__RdAssignment_0_1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4579:1: rule__RuleDependency__RdAssignment_0_1 : ( rulerequiresDependency ) ;
    public final void rule__RuleDependency__RdAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4583:1: ( ( rulerequiresDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4584:1: ( rulerequiresDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4584:1: ( rulerequiresDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4585:1: rulerequiresDependency
            {
             before(grammarAccess.getRuleDependencyAccess().getRdRequiresDependencyParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_rulerequiresDependency_in_rule__RuleDependency__RdAssignment_0_19084);
            rulerequiresDependency();

            state._fsp--;

             after(grammarAccess.getRuleDependencyAccess().getRdRequiresDependencyParserRuleCall_0_1_0()); 

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
    // $ANTLR end "rule__RuleDependency__RdAssignment_0_1"


    // $ANTLR start "rule__RuleDependency__RdAssignment_0_3"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4594:1: rule__RuleDependency__RdAssignment_0_3 : ( rulerequiresDependency ) ;
    public final void rule__RuleDependency__RdAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4598:1: ( ( rulerequiresDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4599:1: ( rulerequiresDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4599:1: ( rulerequiresDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4600:1: rulerequiresDependency
            {
             before(grammarAccess.getRuleDependencyAccess().getRdRequiresDependencyParserRuleCall_0_3_0()); 
            pushFollow(FOLLOW_rulerequiresDependency_in_rule__RuleDependency__RdAssignment_0_39115);
            rulerequiresDependency();

            state._fsp--;

             after(grammarAccess.getRuleDependencyAccess().getRdRequiresDependencyParserRuleCall_0_3_0()); 

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
    // $ANTLR end "rule__RuleDependency__RdAssignment_0_3"


    // $ANTLR start "rule__RuleDependency__RdAssignment_1_1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4609:1: rule__RuleDependency__RdAssignment_1_1 : ( ruleexcludeDependency ) ;
    public final void rule__RuleDependency__RdAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4613:1: ( ( ruleexcludeDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4614:1: ( ruleexcludeDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4614:1: ( ruleexcludeDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4615:1: ruleexcludeDependency
            {
             before(grammarAccess.getRuleDependencyAccess().getRdExcludeDependencyParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleexcludeDependency_in_rule__RuleDependency__RdAssignment_1_19146);
            ruleexcludeDependency();

            state._fsp--;

             after(grammarAccess.getRuleDependencyAccess().getRdExcludeDependencyParserRuleCall_1_1_0()); 

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
    // $ANTLR end "rule__RuleDependency__RdAssignment_1_1"


    // $ANTLR start "rule__RuleDependency__EdAssignment_1_3"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4624:1: rule__RuleDependency__EdAssignment_1_3 : ( ruleexcludeDependency ) ;
    public final void rule__RuleDependency__EdAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4628:1: ( ( ruleexcludeDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4629:1: ( ruleexcludeDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4629:1: ( ruleexcludeDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4630:1: ruleexcludeDependency
            {
             before(grammarAccess.getRuleDependencyAccess().getEdExcludeDependencyParserRuleCall_1_3_0()); 
            pushFollow(FOLLOW_ruleexcludeDependency_in_rule__RuleDependency__EdAssignment_1_39177);
            ruleexcludeDependency();

            state._fsp--;

             after(grammarAccess.getRuleDependencyAccess().getEdExcludeDependencyParserRuleCall_1_3_0()); 

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
    // $ANTLR end "rule__RuleDependency__EdAssignment_1_3"


    // $ANTLR start "rule__RequiresDependency__RequiredTransformationAssignment_1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4639:1: rule__RequiresDependency__RequiredTransformationAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__RequiresDependency__RequiredTransformationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4643:1: ( ( ( ruleEString ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4644:1: ( ( ruleEString ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4644:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4645:1: ( ruleEString )
            {
             before(grammarAccess.getRequiresDependencyAccess().getRequiredTransformationTransformationCrossReference_1_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4646:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4647:1: ruleEString
            {
             before(grammarAccess.getRequiresDependencyAccess().getRequiredTransformationTransformationEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleEString_in_rule__RequiresDependency__RequiredTransformationAssignment_19212);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getRequiresDependencyAccess().getRequiredTransformationTransformationEStringParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getRequiresDependencyAccess().getRequiredTransformationTransformationCrossReference_1_0()); 

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
    // $ANTLR end "rule__RequiresDependency__RequiredTransformationAssignment_1"


    // $ANTLR start "rule__RequiresDependency__RequiredRuleAssignment_3"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4658:1: rule__RequiresDependency__RequiredRuleAssignment_3 : ( ruleEString ) ;
    public final void rule__RequiresDependency__RequiredRuleAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4662:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4663:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4663:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4664:1: ruleEString
            {
             before(grammarAccess.getRequiresDependencyAccess().getRequiredRuleEStringParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__RequiresDependency__RequiredRuleAssignment_39247);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getRequiresDependencyAccess().getRequiredRuleEStringParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__RequiresDependency__RequiredRuleAssignment_3"


    // $ANTLR start "rule__RequiresDependency__FieldsAssignment_5"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4673:1: rule__RequiresDependency__FieldsAssignment_5 : ( ruleEString ) ;
    public final void rule__RequiresDependency__FieldsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4677:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4678:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4678:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4679:1: ruleEString
            {
             before(grammarAccess.getRequiresDependencyAccess().getFieldsEStringParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__RequiresDependency__FieldsAssignment_59278);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getRequiresDependencyAccess().getFieldsEStringParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__RequiresDependency__FieldsAssignment_5"


    // $ANTLR start "rule__RequiresDependency__OclExpressionAssignment_7"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4688:1: rule__RequiresDependency__OclExpressionAssignment_7 : ( ruleEString ) ;
    public final void rule__RequiresDependency__OclExpressionAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4692:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4693:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4693:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4694:1: ruleEString
            {
             before(grammarAccess.getRequiresDependencyAccess().getOclExpressionEStringParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__RequiresDependency__OclExpressionAssignment_79309);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getRequiresDependencyAccess().getOclExpressionEStringParserRuleCall_7_0()); 

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
    // $ANTLR end "rule__RequiresDependency__OclExpressionAssignment_7"


    // $ANTLR start "rule__ExcludeDependency__RequiredTransformationAssignment_1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4703:1: rule__ExcludeDependency__RequiredTransformationAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__ExcludeDependency__RequiredTransformationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4707:1: ( ( ( ruleEString ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4708:1: ( ( ruleEString ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4708:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4709:1: ( ruleEString )
            {
             before(grammarAccess.getExcludeDependencyAccess().getRequiredTransformationTransformationCrossReference_1_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4710:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4711:1: ruleEString
            {
             before(grammarAccess.getExcludeDependencyAccess().getRequiredTransformationTransformationEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleEString_in_rule__ExcludeDependency__RequiredTransformationAssignment_19344);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExcludeDependencyAccess().getRequiredTransformationTransformationEStringParserRuleCall_1_0_1()); 

            }

             after(grammarAccess.getExcludeDependencyAccess().getRequiredTransformationTransformationCrossReference_1_0()); 

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
    // $ANTLR end "rule__ExcludeDependency__RequiredTransformationAssignment_1"


    // $ANTLR start "rule__ExcludeDependency__RequiredRuleAssignment_3"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4722:1: rule__ExcludeDependency__RequiredRuleAssignment_3 : ( ruleEString ) ;
    public final void rule__ExcludeDependency__RequiredRuleAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4726:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4727:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4727:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4728:1: ruleEString
            {
             before(grammarAccess.getExcludeDependencyAccess().getRequiredRuleEStringParserRuleCall_3_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__ExcludeDependency__RequiredRuleAssignment_39379);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExcludeDependencyAccess().getRequiredRuleEStringParserRuleCall_3_0()); 

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
    // $ANTLR end "rule__ExcludeDependency__RequiredRuleAssignment_3"


    // $ANTLR start "rule__ExcludeDependency__FieldsAssignment_5"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4737:1: rule__ExcludeDependency__FieldsAssignment_5 : ( ruleEString ) ;
    public final void rule__ExcludeDependency__FieldsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4741:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4742:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4742:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4743:1: ruleEString
            {
             before(grammarAccess.getExcludeDependencyAccess().getFieldsEStringParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__ExcludeDependency__FieldsAssignment_59410);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExcludeDependencyAccess().getFieldsEStringParserRuleCall_5_0()); 

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
    // $ANTLR end "rule__ExcludeDependency__FieldsAssignment_5"


    // $ANTLR start "rule__ExcludeDependency__OclExpressionAssignment_7"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4752:1: rule__ExcludeDependency__OclExpressionAssignment_7 : ( ruleEString ) ;
    public final void rule__ExcludeDependency__OclExpressionAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4756:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4757:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4757:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4758:1: ruleEString
            {
             before(grammarAccess.getExcludeDependencyAccess().getOclExpressionEStringParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__ExcludeDependency__OclExpressionAssignment_79441);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getExcludeDependencyAccess().getOclExpressionEStringParserRuleCall_7_0()); 

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
    // $ANTLR end "rule__ExcludeDependency__OclExpressionAssignment_7"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleTrcSpecification_in_entryRuleTrcSpecification61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrcSpecification68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__0_in_ruleTrcSpecification94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFrom_in_entryRuleFrom121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFrom128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__From__Group__0_in_ruleFrom154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRules_in_entryRuleRules181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRules188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Rules__NameAssignment_in_ruleRules214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModuleList_in_entryRuleModuleList243 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModuleList250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__0_in_ruleModuleList276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModules_in_entryRuleModules303 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModules310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Modules__Group__0_in_ruleModules336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationList_in_entryRuleTransformationList363 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationList370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__0_in_ruleTransformationList396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformation_in_entryRuleTransformation423 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformation430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__0_in_ruleTransformation456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_entryRuleTransformationImpact483 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationImpact490 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__0_in_ruleTransformationImpact516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependencyList_in_entryRuleTransformationDependencyList543 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationDependencyList550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__0_in_ruleTransformationDependencyList576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_entryRuleTransformationDependency603 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationDependency610 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__0_in_ruleTransformationDependency636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_entryRuleAbstractRuleDependency663 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRuleDependency670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependency_in_ruleAbstractRuleDependency696 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependency_in_entryRuleRuleDependency726 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDependency733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Alternatives_in_ruleRuleDependency759 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerequiresDependency_in_entryRulerequiresDependency786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerequiresDependency793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__0_in_rulerequiresDependency819 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexcludeDependency_in_entryRuleexcludeDependency846 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleexcludeDependency853 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__0_in_ruleexcludeDependency879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_entryRuleEString910 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEString917 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EString__Alternatives_in_ruleEString943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt970 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEInt977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EInt__Group__0_in_ruleEInt1003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__TransformationDependency__Alternatives_131042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__TransformationDependency__Alternatives_131062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_0__0_in_rule__RuleDependency__Alternatives1096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_1__0_in_rule__RuleDependency__Alternatives1114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__RuleDependency__Alternatives_0_21148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__RuleDependency__Alternatives_0_21168 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__RuleDependency__Alternatives_1_21203 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__RuleDependency__Alternatives_1_21223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EString__Alternatives1257 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EString__Alternatives1274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__0__Impl_in_rule__TrcSpecification__Group__01305 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__1_in_rule__TrcSpecification__Group__01308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__FromsAssignment_0_in_rule__TrcSpecification__Group__0__Impl1335 = new BitSet(new long[]{0x0000000000002002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__1__Impl_in_rule__TrcSpecification__Group__11366 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__2_in_rule__TrcSpecification__Group__11369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__ModuleListAssignment_1_in_rule__TrcSpecification__Group__1__Impl1396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__2__Impl_in_rule__TrcSpecification__Group__21426 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__3_in_rule__TrcSpecification__Group__21429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__TransformationListAssignment_2_in_rule__TrcSpecification__Group__2__Impl1456 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__3__Impl_in_rule__TrcSpecification__Group__31486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__DependencyListAssignment_3_in_rule__TrcSpecification__Group__3__Impl1513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__From__Group__0__Impl_in_rule__From__Group__01551 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__From__Group__1_in_rule__From__Group__01554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__From__Group__0__Impl1582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__From__Group__1__Impl_in_rule__From__Group__11613 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__From__Group__2_in_rule__From__Group__11616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__From__ImportURIAssignment_1_in_rule__From__Group__1__Impl1643 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__From__Group__2__Impl_in_rule__From__Group__21673 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__From__Group__2__Impl1701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__0__Impl_in_rule__ModuleList__Group__01740 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__1_in_rule__ModuleList__Group__01743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__1__Impl_in_rule__ModuleList__Group__11801 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__2_in_rule__ModuleList__Group__11804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ModuleList__Group__1__Impl1832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__2__Impl_in_rule__ModuleList__Group__21863 = new BitSet(new long[]{0x0000000000020030L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__3_in_rule__ModuleList__Group__21866 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ModuleList__Group__2__Impl1894 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__3__Impl_in_rule__ModuleList__Group__31925 = new BitSet(new long[]{0x0000000000020030L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__4_in_rule__ModuleList__Group__31928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group_3__0_in_rule__ModuleList__Group__3__Impl1955 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__4__Impl_in_rule__ModuleList__Group__41986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ModuleList__Group__4__Impl2014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group_3__0__Impl_in_rule__ModuleList__Group_3__02055 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__ModuleList__Group_3__1_in_rule__ModuleList__Group_3__02058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__ModulesAssignment_3_0_in_rule__ModuleList__Group_3__0__Impl2085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group_3__1__Impl_in_rule__ModuleList__Group_3__12115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group_3_1__0_in_rule__ModuleList__Group_3__1__Impl2142 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group_3_1__0__Impl_in_rule__ModuleList__Group_3_1__02177 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__ModuleList__Group_3_1__1_in_rule__ModuleList__Group_3_1__02180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ModuleList__Group_3_1__0__Impl2208 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group_3_1__1__Impl_in_rule__ModuleList__Group_3_1__12239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__ModulesAssignment_3_1_1_in_rule__ModuleList__Group_3_1__1__Impl2266 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Modules__Group__0__Impl_in_rule__Modules__Group__02300 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Modules__Group__1_in_rule__Modules__Group__02303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Modules__PathAssignment_0_in_rule__Modules__Group__0__Impl2330 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Modules__Group__1__Impl_in_rule__Modules__Group__12360 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Modules__Group__2_in_rule__Modules__Group__12363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Modules__Group__1__Impl2391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Modules__Group__2__Impl_in_rule__Modules__Group__22422 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Modules__Group__3_in_rule__Modules__Group__22425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Modules__NameAssignment_2_in_rule__Modules__Group__2__Impl2452 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Modules__Group__3__Impl_in_rule__Modules__Group__32482 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Modules__Group__4_in_rule__Modules__Group__32485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Modules__Group__3__Impl2513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Modules__Group__4__Impl_in_rule__Modules__Group__42544 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Modules__Group__5_in_rule__Modules__Group__42547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Modules__RuleNameAssignment_4_in_rule__Modules__Group__4__Impl2574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Modules__Group__5__Impl_in_rule__Modules__Group__52604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Modules__Group_5__0_in_rule__Modules__Group__5__Impl2631 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Modules__Group_5__0__Impl_in_rule__Modules__Group_5__02674 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Modules__Group_5__1_in_rule__Modules__Group_5__02677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Modules__Group_5__0__Impl2705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Modules__Group_5__1__Impl_in_rule__Modules__Group_5__12736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Modules__RuleNameAssignment_5_1_in_rule__Modules__Group_5__1__Impl2763 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__0__Impl_in_rule__TransformationList__Group__02797 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__1_in_rule__TransformationList__Group__02800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__TransformationList__Group__0__Impl2828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__1__Impl_in_rule__TransformationList__Group__12859 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__2_in_rule__TransformationList__Group__12862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__TransformationList__Group__1__Impl2890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__2__Impl_in_rule__TransformationList__Group__22921 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__3_in_rule__TransformationList__Group__22924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__TransformationsAssignment_2_in_rule__TransformationList__Group__2__Impl2951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__3__Impl_in_rule__TransformationList__Group__32981 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__4_in_rule__TransformationList__Group__32984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group_3__0_in_rule__TransformationList__Group__3__Impl3011 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__4__Impl_in_rule__TransformationList__Group__43042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__TransformationList__Group__4__Impl3070 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group_3__0__Impl_in_rule__TransformationList__Group_3__03111 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationList__Group_3__1_in_rule__TransformationList__Group_3__03114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__TransformationList__Group_3__0__Impl3142 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group_3__1__Impl_in_rule__TransformationList__Group_3__13173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__TransformationsAssignment_3_1_in_rule__TransformationList__Group_3__1__Impl3200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__0__Impl_in_rule__Transformation__Group__03234 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__1_in_rule__Transformation__Group__03237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__NameAssignment_0_in_rule__Transformation__Group__0__Impl3264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__1__Impl_in_rule__Transformation__Group__13294 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__2_in_rule__Transformation__Group__13297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__Transformation__Group__1__Impl3325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__2__Impl_in_rule__Transformation__Group__23356 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__3_in_rule__Transformation__Group__23359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Transformation__Group__2__Impl3387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__3__Impl_in_rule__Transformation__Group__33418 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Transformation__Group__4_in_rule__Transformation__Group__33421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Transformation__Group__3__Impl3449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__4__Impl_in_rule__Transformation__Group__43480 = new BitSet(new long[]{0x0000000000920000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__5_in_rule__Transformation__Group__43483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__ModulesAssignment_4_in_rule__Transformation__Group__4__Impl3510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__5__Impl_in_rule__Transformation__Group__53540 = new BitSet(new long[]{0x0000000000920000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__6_in_rule__Transformation__Group__53543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_5__0_in_rule__Transformation__Group__5__Impl3570 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__6__Impl_in_rule__Transformation__Group__63601 = new BitSet(new long[]{0x0000000000920000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__7_in_rule__Transformation__Group__63604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__0_in_rule__Transformation__Group__6__Impl3631 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__7__Impl_in_rule__Transformation__Group__73662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__Transformation__Group__7__Impl3690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_5__0__Impl_in_rule__Transformation__Group_5__03737 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Transformation__Group_5__1_in_rule__Transformation__Group_5__03740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Transformation__Group_5__0__Impl3768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_5__1__Impl_in_rule__Transformation__Group_5__13799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__ModulesAssignment_5_1_in_rule__Transformation__Group_5__1__Impl3826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__0__Impl_in_rule__Transformation__Group_6__03860 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__1_in_rule__Transformation__Group_6__03863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__Transformation__Group_6__0__Impl3891 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__1__Impl_in_rule__Transformation__Group_6__13922 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__2_in_rule__Transformation__Group_6__13925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Transformation__Group_6__1__Impl3953 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__2__Impl_in_rule__Transformation__Group_6__23984 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__3_in_rule__Transformation__Group_6__23987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__ImpactsAssignment_6_2_in_rule__Transformation__Group_6__2__Impl4014 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__3__Impl_in_rule__Transformation__Group_6__34044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6_3__0_in_rule__Transformation__Group_6__3__Impl4071 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6_3__0__Impl_in_rule__Transformation__Group_6_3__04110 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6_3__1_in_rule__Transformation__Group_6_3__04113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__Transformation__Group_6_3__0__Impl4141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6_3__1__Impl_in_rule__Transformation__Group_6_3__14172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__ImpactsAssignment_6_3_1_in_rule__Transformation__Group_6_3__1__Impl4199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__0__Impl_in_rule__TransformationImpact__Group__04233 = new BitSet(new long[]{0x0000000200000070L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__1_in_rule__TransformationImpact__Group__04236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__TransformationImpact__Group__0__Impl4264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__1__Impl_in_rule__TransformationImpact__Group__14295 = new BitSet(new long[]{0x0000000200000070L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__2_in_rule__TransformationImpact__Group__14298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group_1__0_in_rule__TransformationImpact__Group__1__Impl4325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__2__Impl_in_rule__TransformationImpact__Group__24356 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__3_in_rule__TransformationImpact__Group__24359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__ImpactValueAssignment_2_in_rule__TransformationImpact__Group__2__Impl4386 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__3__Impl_in_rule__TransformationImpact__Group__34416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__TransformationImpact__Group__3__Impl4444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group_1__0__Impl_in_rule__TransformationImpact__Group_1__04483 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group_1__1_in_rule__TransformationImpact__Group_1__04486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__QualityAttributeNameAssignment_1_0_in_rule__TransformationImpact__Group_1__0__Impl4513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group_1__1__Impl_in_rule__TransformationImpact__Group_1__14543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__TransformationImpact__Group_1__1__Impl4571 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__0__Impl_in_rule__TransformationDependencyList__Group__04606 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__1_in_rule__TransformationDependencyList__Group__04609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__TransformationDependencyList__Group__0__Impl4637 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__1__Impl_in_rule__TransformationDependencyList__Group__14668 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__2_in_rule__TransformationDependencyList__Group__14671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__TransformationDependencyList__Group__1__Impl4699 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__2__Impl_in_rule__TransformationDependencyList__Group__24730 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__3_in_rule__TransformationDependencyList__Group__24733 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__NameAssignment_2_in_rule__TransformationDependencyList__Group__2__Impl4760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__3__Impl_in_rule__TransformationDependencyList__Group__34790 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__4_in_rule__TransformationDependencyList__Group__34793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__TransformationDependencyList__Group__3__Impl4821 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__4__Impl_in_rule__TransformationDependencyList__Group__44852 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__5_in_rule__TransformationDependencyList__Group__44855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__TransformationDependenciesAssignment_4_in_rule__TransformationDependencyList__Group__4__Impl4882 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__5__Impl_in_rule__TransformationDependencyList__Group__54912 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__6_in_rule__TransformationDependencyList__Group__54915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group_5__0_in_rule__TransformationDependencyList__Group__5__Impl4942 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__6__Impl_in_rule__TransformationDependencyList__Group__64973 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__7_in_rule__TransformationDependencyList__Group__64976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__TransformationDependencyList__Group__6__Impl5004 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__7__Impl_in_rule__TransformationDependencyList__Group__75035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__TransformationDependencyList__Group__7__Impl5063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group_5__0__Impl_in_rule__TransformationDependencyList__Group_5__05110 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group_5__1_in_rule__TransformationDependencyList__Group_5__05113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__TransformationDependencyList__Group_5__0__Impl5141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group_5__1__Impl_in_rule__TransformationDependencyList__Group_5__15172 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1_in_rule__TransformationDependencyList__Group_5__1__Impl5199 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__0__Impl_in_rule__TransformationDependency__Group__05233 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__1_in_rule__TransformationDependency__Group__05236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__TransformationDependency__Group__0__Impl5264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__1__Impl_in_rule__TransformationDependency__Group__15295 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__2_in_rule__TransformationDependency__Group__15298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__TransformationDependency__Group__1__Impl5326 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__2__Impl_in_rule__TransformationDependency__Group__25357 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__3_in_rule__TransformationDependency__Group__25360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__AppliedTransformationAssignment_2_in_rule__TransformationDependency__Group__2__Impl5387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__3__Impl_in_rule__TransformationDependency__Group__35417 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__4_in_rule__TransformationDependency__Group__35420 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__TransformationDependency__Group__3__Impl5448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__4__Impl_in_rule__TransformationDependency__Group__45479 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__5_in_rule__TransformationDependency__Group__45482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__AppliedRuleAssignment_4_in_rule__TransformationDependency__Group__4__Impl5509 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__5__Impl_in_rule__TransformationDependency__Group__55539 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__6_in_rule__TransformationDependency__Group__55542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__TransformationDependency__Group__5__Impl5570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__6__Impl_in_rule__TransformationDependency__Group__65601 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__7_in_rule__TransformationDependency__Group__65604 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__TransformationDependency__Group__6__Impl5632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__7__Impl_in_rule__TransformationDependency__Group__75663 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__8_in_rule__TransformationDependency__Group__75666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__FieldsAssignment_7_in_rule__TransformationDependency__Group__7__Impl5693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__8__Impl_in_rule__TransformationDependency__Group__85723 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__9_in_rule__TransformationDependency__Group__85726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_8__0_in_rule__TransformationDependency__Group__8__Impl5753 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__9__Impl_in_rule__TransformationDependency__Group__95784 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__10_in_rule__TransformationDependency__Group__95787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__TransformationDependency__Group__9__Impl5815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__10__Impl_in_rule__TransformationDependency__Group__105846 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__11_in_rule__TransformationDependency__Group__105849 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__TransformationDependency__Group__10__Impl5877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__11__Impl_in_rule__TransformationDependency__Group__115908 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__12_in_rule__TransformationDependency__Group__115911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__TransformationDependency__Group__11__Impl5939 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__12__Impl_in_rule__TransformationDependency__Group__125970 = new BitSet(new long[]{0x00000001C0001800L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__13_in_rule__TransformationDependency__Group__125973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__RequiredTransformationsAssignment_12_in_rule__TransformationDependency__Group__12__Impl6000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__13__Impl_in_rule__TransformationDependency__Group__136030 = new BitSet(new long[]{0x00000001C0001800L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__14_in_rule__TransformationDependency__Group__136033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Alternatives_13_in_rule__TransformationDependency__Group__13__Impl6060 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__14__Impl_in_rule__TransformationDependency__Group__146091 = new BitSet(new long[]{0x00000001C0001800L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__15_in_rule__TransformationDependency__Group__146094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__RequiredTransformationsAssignment_14_in_rule__TransformationDependency__Group__14__Impl6121 = new BitSet(new long[]{0x0000000180000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__15__Impl_in_rule__TransformationDependency__Group__156152 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__TransformationDependency__Group__15__Impl6180 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_8__0__Impl_in_rule__TransformationDependency__Group_8__06243 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_8__1_in_rule__TransformationDependency__Group_8__06246 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__TransformationDependency__Group_8__0__Impl6274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_8__1__Impl_in_rule__TransformationDependency__Group_8__16305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__FieldsAssignment_8_1_in_rule__TransformationDependency__Group_8__1__Impl6332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_0__0__Impl_in_rule__RuleDependency__Group_0__06368 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_0__1_in_rule__RuleDependency__Group_0__06371 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__RuleDependency__Group_0__0__Impl6399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_0__1__Impl_in_rule__RuleDependency__Group_0__16430 = new BitSet(new long[]{0x0000000001001800L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_0__2_in_rule__RuleDependency__Group_0__16433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__RdAssignment_0_1_in_rule__RuleDependency__Group_0__1__Impl6460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_0__2__Impl_in_rule__RuleDependency__Group_0__26490 = new BitSet(new long[]{0x0000000001001800L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_0__3_in_rule__RuleDependency__Group_0__26493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Alternatives_0_2_in_rule__RuleDependency__Group_0__2__Impl6520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_0__3__Impl_in_rule__RuleDependency__Group_0__36551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__RdAssignment_0_3_in_rule__RuleDependency__Group_0__3__Impl6578 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_1__0__Impl_in_rule__RuleDependency__Group_1__06617 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_1__1_in_rule__RuleDependency__Group_1__06620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_rule__RuleDependency__Group_1__0__Impl6648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_1__1__Impl_in_rule__RuleDependency__Group_1__16679 = new BitSet(new long[]{0x0000000001001800L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_1__2_in_rule__RuleDependency__Group_1__16682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__RdAssignment_1_1_in_rule__RuleDependency__Group_1__1__Impl6709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_1__2__Impl_in_rule__RuleDependency__Group_1__26739 = new BitSet(new long[]{0x0000000001001800L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_1__3_in_rule__RuleDependency__Group_1__26742 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Alternatives_1_2_in_rule__RuleDependency__Group_1__2__Impl6769 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_1__3__Impl_in_rule__RuleDependency__Group_1__36800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__EdAssignment_1_3_in_rule__RuleDependency__Group_1__3__Impl6827 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__0__Impl_in_rule__RequiresDependency__Group__06866 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__1_in_rule__RequiresDependency__Group__06869 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__RequiresDependency__Group__0__Impl6897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__1__Impl_in_rule__RequiresDependency__Group__16928 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__2_in_rule__RequiresDependency__Group__16931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__RequiredTransformationAssignment_1_in_rule__RequiresDependency__Group__1__Impl6958 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__2__Impl_in_rule__RequiresDependency__Group__26988 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__3_in_rule__RequiresDependency__Group__26991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__RequiresDependency__Group__2__Impl7019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__3__Impl_in_rule__RequiresDependency__Group__37050 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__4_in_rule__RequiresDependency__Group__37053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__RequiredRuleAssignment_3_in_rule__RequiresDependency__Group__3__Impl7080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__4__Impl_in_rule__RequiresDependency__Group__47110 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__5_in_rule__RequiresDependency__Group__47113 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__RequiresDependency__Group__4__Impl7141 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__5__Impl_in_rule__RequiresDependency__Group__57172 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__6_in_rule__RequiresDependency__Group__57175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__FieldsAssignment_5_in_rule__RequiresDependency__Group__5__Impl7202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__6__Impl_in_rule__RequiresDependency__Group__67232 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__7_in_rule__RequiresDependency__Group__67235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__RequiresDependency__Group__6__Impl7263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__7__Impl_in_rule__RequiresDependency__Group__77294 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__8_in_rule__RequiresDependency__Group__77297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__OclExpressionAssignment_7_in_rule__RequiresDependency__Group__7__Impl7324 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__8__Impl_in_rule__RequiresDependency__Group__87354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__RequiresDependency__Group__8__Impl7382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__0__Impl_in_rule__ExcludeDependency__Group__07431 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__1_in_rule__ExcludeDependency__Group__07434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ExcludeDependency__Group__0__Impl7462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__1__Impl_in_rule__ExcludeDependency__Group__17493 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__2_in_rule__ExcludeDependency__Group__17496 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__RequiredTransformationAssignment_1_in_rule__ExcludeDependency__Group__1__Impl7523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__2__Impl_in_rule__ExcludeDependency__Group__27553 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__3_in_rule__ExcludeDependency__Group__27556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__ExcludeDependency__Group__2__Impl7584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__3__Impl_in_rule__ExcludeDependency__Group__37615 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__4_in_rule__ExcludeDependency__Group__37618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__RequiredRuleAssignment_3_in_rule__ExcludeDependency__Group__3__Impl7645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__4__Impl_in_rule__ExcludeDependency__Group__47675 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__5_in_rule__ExcludeDependency__Group__47678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__ExcludeDependency__Group__4__Impl7706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__5__Impl_in_rule__ExcludeDependency__Group__57737 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__6_in_rule__ExcludeDependency__Group__57740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__FieldsAssignment_5_in_rule__ExcludeDependency__Group__5__Impl7767 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__6__Impl_in_rule__ExcludeDependency__Group__67797 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__7_in_rule__ExcludeDependency__Group__67800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ExcludeDependency__Group__6__Impl7828 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__7__Impl_in_rule__ExcludeDependency__Group__77859 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__8_in_rule__ExcludeDependency__Group__77862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__OclExpressionAssignment_7_in_rule__ExcludeDependency__Group__7__Impl7889 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__8__Impl_in_rule__ExcludeDependency__Group__87919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__ExcludeDependency__Group__8__Impl7947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EInt__Group__0__Impl_in_rule__EInt__Group__07996 = new BitSet(new long[]{0x0000000200000070L});
    public static final BitSet FOLLOW_rule__EInt__Group__1_in_rule__EInt__Group__07999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_rule__EInt__Group__0__Impl8028 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EInt__Group__1__Impl_in_rule__EInt__Group__18061 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__EInt__Group__1__Impl8088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFrom_in_rule__TrcSpecification__FromsAssignment_08126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModuleList_in_rule__TrcSpecification__ModuleListAssignment_18157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationList_in_rule__TrcSpecification__TransformationListAssignment_28188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependencyList_in_rule__TrcSpecification__DependencyListAssignment_38219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__From__ImportURIAssignment_18250 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__Rules__NameAssignment8281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModules_in_rule__ModuleList__ModulesAssignment_3_08312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModules_in_rule__ModuleList__ModulesAssignment_3_1_18343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__Modules__PathAssignment_08374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__Modules__NameAssignment_28405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRules_in_rule__Modules__RuleNameAssignment_48436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRules_in_rule__Modules__RuleNameAssignment_5_18467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformation_in_rule__TransformationList__TransformationsAssignment_28498 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformation_in_rule__TransformationList__TransformationsAssignment_3_18529 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__Transformation__NameAssignment_08560 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__Transformation__ModulesAssignment_48595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__Transformation__ModulesAssignment_5_18634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_rule__Transformation__ImpactsAssignment_6_28669 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_rule__Transformation__ImpactsAssignment_6_3_18700 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TransformationImpact__QualityAttributeNameAssignment_1_08731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_rule__TransformationImpact__ImpactValueAssignment_28762 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TransformationDependencyList__NameAssignment_28793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_rule__TransformationDependencyList__TransformationDependenciesAssignment_48824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_rule__TransformationDependencyList__TransformationDependenciesAssignment_5_18855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TransformationDependency__AppliedTransformationAssignment_28890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TransformationDependency__AppliedRuleAssignment_48925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TransformationDependency__FieldsAssignment_78956 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TransformationDependency__FieldsAssignment_8_18987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_rule__TransformationDependency__RequiredTransformationsAssignment_129018 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_rule__TransformationDependency__RequiredTransformationsAssignment_149049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerequiresDependency_in_rule__RuleDependency__RdAssignment_0_19084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerequiresDependency_in_rule__RuleDependency__RdAssignment_0_39115 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexcludeDependency_in_rule__RuleDependency__RdAssignment_1_19146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexcludeDependency_in_rule__RuleDependency__EdAssignment_1_39177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__RequiresDependency__RequiredTransformationAssignment_19212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__RequiresDependency__RequiredRuleAssignment_39247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__RequiresDependency__FieldsAssignment_59278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__RequiresDependency__OclExpressionAssignment_79309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__ExcludeDependency__RequiredTransformationAssignment_19344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__ExcludeDependency__RequiredRuleAssignment_39379 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__ExcludeDependency__FieldsAssignment_59410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__ExcludeDependency__OclExpressionAssignment_79441 = new BitSet(new long[]{0x0000000000000002L});

}