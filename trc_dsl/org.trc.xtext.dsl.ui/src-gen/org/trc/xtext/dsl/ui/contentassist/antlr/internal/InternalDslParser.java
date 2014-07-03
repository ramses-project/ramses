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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'and'", "'or'", "'Modules'", "'{'", "'}'", "';'", "'.'", "':'", "','", "'Transformations'", "'modules'", "'impacts'", "'('", "')'", "'Dependencies'", "'Apply'", "'['", "']'", "'requires'", "'excludes'", "'-'"
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


    // $ANTLR start "entryRuletrcRule"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:88:1: entryRuletrcRule : ruletrcRule EOF ;
    public final void entryRuletrcRule() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:89:1: ( ruletrcRule EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:90:1: ruletrcRule EOF
            {
             before(grammarAccess.getTrcRuleRule()); 
            pushFollow(FOLLOW_ruletrcRule_in_entryRuletrcRule121);
            ruletrcRule();

            state._fsp--;

             after(grammarAccess.getTrcRuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuletrcRule128); 

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
    // $ANTLR end "entryRuletrcRule"


    // $ANTLR start "ruletrcRule"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:97:1: ruletrcRule : ( ( rule__TrcRule__NameAssignment ) ) ;
    public final void ruletrcRule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:101:2: ( ( ( rule__TrcRule__NameAssignment ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:102:1: ( ( rule__TrcRule__NameAssignment ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:102:1: ( ( rule__TrcRule__NameAssignment ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:103:1: ( rule__TrcRule__NameAssignment )
            {
             before(grammarAccess.getTrcRuleAccess().getNameAssignment()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:104:1: ( rule__TrcRule__NameAssignment )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:104:2: rule__TrcRule__NameAssignment
            {
            pushFollow(FOLLOW_rule__TrcRule__NameAssignment_in_ruletrcRule154);
            rule__TrcRule__NameAssignment();

            state._fsp--;


            }

             after(grammarAccess.getTrcRuleAccess().getNameAssignment()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruletrcRule"


    // $ANTLR start "entryRuleModuleList"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:116:1: entryRuleModuleList : ruleModuleList EOF ;
    public final void entryRuleModuleList() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:117:1: ( ruleModuleList EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:118:1: ruleModuleList EOF
            {
             before(grammarAccess.getModuleListRule()); 
            pushFollow(FOLLOW_ruleModuleList_in_entryRuleModuleList181);
            ruleModuleList();

            state._fsp--;

             after(grammarAccess.getModuleListRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModuleList188); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:125:1: ruleModuleList : ( ( rule__ModuleList__Group__0 ) ) ;
    public final void ruleModuleList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:129:2: ( ( ( rule__ModuleList__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:130:1: ( ( rule__ModuleList__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:130:1: ( ( rule__ModuleList__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:131:1: ( rule__ModuleList__Group__0 )
            {
             before(grammarAccess.getModuleListAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:132:1: ( rule__ModuleList__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:132:2: rule__ModuleList__Group__0
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__0_in_ruleModuleList214);
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


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:144:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:145:1: ( ruleQualifiedName EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:146:1: ruleQualifiedName EOF
            {
             before(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName241);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getQualifiedNameRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName248); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:153:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:157:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:158:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:158:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:159:1: ( rule__QualifiedName__Group__0 )
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:160:1: ( rule__QualifiedName__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:160:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName274);
            rule__QualifiedName__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getQualifiedNameAccess().getGroup()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:172:1: entryRuleModule : ruleModule EOF ;
    public final void entryRuleModule() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:173:1: ( ruleModule EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:174:1: ruleModule EOF
            {
             before(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_ruleModule_in_entryRuleModule301);
            ruleModule();

            state._fsp--;

             after(grammarAccess.getModuleRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModule308); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:181:1: ruleModule : ( ( rule__Module__Group__0 ) ) ;
    public final void ruleModule() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:185:2: ( ( ( rule__Module__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:186:1: ( ( rule__Module__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:186:1: ( ( rule__Module__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:187:1: ( rule__Module__Group__0 )
            {
             before(grammarAccess.getModuleAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:188:1: ( rule__Module__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:188:2: rule__Module__Group__0
            {
            pushFollow(FOLLOW_rule__Module__Group__0_in_ruleModule334);
            rule__Module__Group__0();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getGroup()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:200:1: entryRuleTransformationList : ruleTransformationList EOF ;
    public final void entryRuleTransformationList() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:201:1: ( ruleTransformationList EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:202:1: ruleTransformationList EOF
            {
             before(grammarAccess.getTransformationListRule()); 
            pushFollow(FOLLOW_ruleTransformationList_in_entryRuleTransformationList361);
            ruleTransformationList();

            state._fsp--;

             after(grammarAccess.getTransformationListRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationList368); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:209:1: ruleTransformationList : ( ( rule__TransformationList__Group__0 ) ) ;
    public final void ruleTransformationList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:213:2: ( ( ( rule__TransformationList__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:214:1: ( ( rule__TransformationList__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:214:1: ( ( rule__TransformationList__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:215:1: ( rule__TransformationList__Group__0 )
            {
             before(grammarAccess.getTransformationListAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:216:1: ( rule__TransformationList__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:216:2: rule__TransformationList__Group__0
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__0_in_ruleTransformationList394);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:228:1: entryRuleTransformation : ruleTransformation EOF ;
    public final void entryRuleTransformation() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:229:1: ( ruleTransformation EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:230:1: ruleTransformation EOF
            {
             before(grammarAccess.getTransformationRule()); 
            pushFollow(FOLLOW_ruleTransformation_in_entryRuleTransformation421);
            ruleTransformation();

            state._fsp--;

             after(grammarAccess.getTransformationRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformation428); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:237:1: ruleTransformation : ( ( rule__Transformation__Group__0 ) ) ;
    public final void ruleTransformation() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:241:2: ( ( ( rule__Transformation__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:242:1: ( ( rule__Transformation__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:242:1: ( ( rule__Transformation__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:243:1: ( rule__Transformation__Group__0 )
            {
             before(grammarAccess.getTransformationAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:244:1: ( rule__Transformation__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:244:2: rule__Transformation__Group__0
            {
            pushFollow(FOLLOW_rule__Transformation__Group__0_in_ruleTransformation454);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:256:1: entryRuleTransformationImpact : ruleTransformationImpact EOF ;
    public final void entryRuleTransformationImpact() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:257:1: ( ruleTransformationImpact EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:258:1: ruleTransformationImpact EOF
            {
             before(grammarAccess.getTransformationImpactRule()); 
            pushFollow(FOLLOW_ruleTransformationImpact_in_entryRuleTransformationImpact481);
            ruleTransformationImpact();

            state._fsp--;

             after(grammarAccess.getTransformationImpactRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationImpact488); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:265:1: ruleTransformationImpact : ( ( rule__TransformationImpact__Group__0 ) ) ;
    public final void ruleTransformationImpact() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:269:2: ( ( ( rule__TransformationImpact__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:270:1: ( ( rule__TransformationImpact__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:270:1: ( ( rule__TransformationImpact__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:271:1: ( rule__TransformationImpact__Group__0 )
            {
             before(grammarAccess.getTransformationImpactAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:272:1: ( rule__TransformationImpact__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:272:2: rule__TransformationImpact__Group__0
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group__0_in_ruleTransformationImpact514);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:284:1: entryRuleTransformationDependencyList : ruleTransformationDependencyList EOF ;
    public final void entryRuleTransformationDependencyList() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:285:1: ( ruleTransformationDependencyList EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:286:1: ruleTransformationDependencyList EOF
            {
             before(grammarAccess.getTransformationDependencyListRule()); 
            pushFollow(FOLLOW_ruleTransformationDependencyList_in_entryRuleTransformationDependencyList541);
            ruleTransformationDependencyList();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyListRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationDependencyList548); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:293:1: ruleTransformationDependencyList : ( ( rule__TransformationDependencyList__Group__0 ) ) ;
    public final void ruleTransformationDependencyList() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:297:2: ( ( ( rule__TransformationDependencyList__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:298:1: ( ( rule__TransformationDependencyList__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:298:1: ( ( rule__TransformationDependencyList__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:299:1: ( rule__TransformationDependencyList__Group__0 )
            {
             before(grammarAccess.getTransformationDependencyListAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:300:1: ( rule__TransformationDependencyList__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:300:2: rule__TransformationDependencyList__Group__0
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__0_in_ruleTransformationDependencyList574);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:312:1: entryRuleTransformationDependency : ruleTransformationDependency EOF ;
    public final void entryRuleTransformationDependency() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:313:1: ( ruleTransformationDependency EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:314:1: ruleTransformationDependency EOF
            {
             before(grammarAccess.getTransformationDependencyRule()); 
            pushFollow(FOLLOW_ruleTransformationDependency_in_entryRuleTransformationDependency601);
            ruleTransformationDependency();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationDependency608); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:321:1: ruleTransformationDependency : ( ( rule__TransformationDependency__Group__0 ) ) ;
    public final void ruleTransformationDependency() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:325:2: ( ( ( rule__TransformationDependency__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:326:1: ( ( rule__TransformationDependency__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:326:1: ( ( rule__TransformationDependency__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:327:1: ( rule__TransformationDependency__Group__0 )
            {
             before(grammarAccess.getTransformationDependencyAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:328:1: ( rule__TransformationDependency__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:328:2: rule__TransformationDependency__Group__0
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__0_in_ruleTransformationDependency634);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:340:1: entryRuleAbstractRuleDependency : ruleAbstractRuleDependency EOF ;
    public final void entryRuleAbstractRuleDependency() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:341:1: ( ruleAbstractRuleDependency EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:342:1: ruleAbstractRuleDependency EOF
            {
             before(grammarAccess.getAbstractRuleDependencyRule()); 
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_entryRuleAbstractRuleDependency661);
            ruleAbstractRuleDependency();

            state._fsp--;

             after(grammarAccess.getAbstractRuleDependencyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRuleDependency668); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:349:1: ruleAbstractRuleDependency : ( ruleRuleDependency ) ;
    public final void ruleAbstractRuleDependency() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:353:2: ( ( ruleRuleDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:354:1: ( ruleRuleDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:354:1: ( ruleRuleDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:355:1: ruleRuleDependency
            {
             before(grammarAccess.getAbstractRuleDependencyAccess().getRuleDependencyParserRuleCall()); 
            pushFollow(FOLLOW_ruleRuleDependency_in_ruleAbstractRuleDependency694);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:368:1: entryRuleRuleDependency : ruleRuleDependency EOF ;
    public final void entryRuleRuleDependency() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:369:1: ( ruleRuleDependency EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:370:1: ruleRuleDependency EOF
            {
             before(grammarAccess.getRuleDependencyRule()); 
            pushFollow(FOLLOW_ruleRuleDependency_in_entryRuleRuleDependency720);
            ruleRuleDependency();

            state._fsp--;

             after(grammarAccess.getRuleDependencyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDependency727); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:377:1: ruleRuleDependency : ( ( rule__RuleDependency__Alternatives ) ) ;
    public final void ruleRuleDependency() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:381:2: ( ( ( rule__RuleDependency__Alternatives ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:382:1: ( ( rule__RuleDependency__Alternatives ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:382:1: ( ( rule__RuleDependency__Alternatives ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:383:1: ( rule__RuleDependency__Alternatives )
            {
             before(grammarAccess.getRuleDependencyAccess().getAlternatives()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:384:1: ( rule__RuleDependency__Alternatives )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:384:2: rule__RuleDependency__Alternatives
            {
            pushFollow(FOLLOW_rule__RuleDependency__Alternatives_in_ruleRuleDependency753);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:396:1: entryRulerequiresDependency : rulerequiresDependency EOF ;
    public final void entryRulerequiresDependency() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:397:1: ( rulerequiresDependency EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:398:1: rulerequiresDependency EOF
            {
             before(grammarAccess.getRequiresDependencyRule()); 
            pushFollow(FOLLOW_rulerequiresDependency_in_entryRulerequiresDependency780);
            rulerequiresDependency();

            state._fsp--;

             after(grammarAccess.getRequiresDependencyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRulerequiresDependency787); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:405:1: rulerequiresDependency : ( ( rule__RequiresDependency__Group__0 ) ) ;
    public final void rulerequiresDependency() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:409:2: ( ( ( rule__RequiresDependency__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:410:1: ( ( rule__RequiresDependency__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:410:1: ( ( rule__RequiresDependency__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:411:1: ( rule__RequiresDependency__Group__0 )
            {
             before(grammarAccess.getRequiresDependencyAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:412:1: ( rule__RequiresDependency__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:412:2: rule__RequiresDependency__Group__0
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__0_in_rulerequiresDependency813);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:424:1: entryRuleexcludeDependency : ruleexcludeDependency EOF ;
    public final void entryRuleexcludeDependency() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:425:1: ( ruleexcludeDependency EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:426:1: ruleexcludeDependency EOF
            {
             before(grammarAccess.getExcludeDependencyRule()); 
            pushFollow(FOLLOW_ruleexcludeDependency_in_entryRuleexcludeDependency840);
            ruleexcludeDependency();

            state._fsp--;

             after(grammarAccess.getExcludeDependencyRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleexcludeDependency847); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:433:1: ruleexcludeDependency : ( ( rule__ExcludeDependency__Group__0 ) ) ;
    public final void ruleexcludeDependency() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:437:2: ( ( ( rule__ExcludeDependency__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:438:1: ( ( rule__ExcludeDependency__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:438:1: ( ( rule__ExcludeDependency__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:439:1: ( rule__ExcludeDependency__Group__0 )
            {
             before(grammarAccess.getExcludeDependencyAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:440:1: ( rule__ExcludeDependency__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:440:2: rule__ExcludeDependency__Group__0
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__0_in_ruleexcludeDependency873);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:456:1: entryRuleEString : ruleEString EOF ;
    public final void entryRuleEString() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:457:1: ( ruleEString EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:458:1: ruleEString EOF
            {
             before(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_ruleEString_in_entryRuleEString904);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getEStringRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEString911); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:465:1: ruleEString : ( ( rule__EString__Alternatives ) ) ;
    public final void ruleEString() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:469:2: ( ( ( rule__EString__Alternatives ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:470:1: ( ( rule__EString__Alternatives ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:470:1: ( ( rule__EString__Alternatives ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:471:1: ( rule__EString__Alternatives )
            {
             before(grammarAccess.getEStringAccess().getAlternatives()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:472:1: ( rule__EString__Alternatives )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:472:2: rule__EString__Alternatives
            {
            pushFollow(FOLLOW_rule__EString__Alternatives_in_ruleEString937);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:484:1: entryRuleEInt : ruleEInt EOF ;
    public final void entryRuleEInt() throws RecognitionException {
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:485:1: ( ruleEInt EOF )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:486:1: ruleEInt EOF
            {
             before(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_ruleEInt_in_entryRuleEInt964);
            ruleEInt();

            state._fsp--;

             after(grammarAccess.getEIntRule()); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEInt971); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:493:1: ruleEInt : ( ( rule__EInt__Group__0 ) ) ;
    public final void ruleEInt() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:497:2: ( ( ( rule__EInt__Group__0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:498:1: ( ( rule__EInt__Group__0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:498:1: ( ( rule__EInt__Group__0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:499:1: ( rule__EInt__Group__0 )
            {
             before(grammarAccess.getEIntAccess().getGroup()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:500:1: ( rule__EInt__Group__0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:500:2: rule__EInt__Group__0
            {
            pushFollow(FOLLOW_rule__EInt__Group__0_in_ruleEInt997);
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


    // $ANTLR start "rule__TransformationDependency__Alternatives_12"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:514:1: rule__TransformationDependency__Alternatives_12 : ( ( ( rule__TransformationDependency__Group_12_0__0 ) ) | ( ( rule__TransformationDependency__Group_12_1__0 ) ) );
    public final void rule__TransformationDependency__Alternatives_12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:518:1: ( ( ( rule__TransformationDependency__Group_12_0__0 ) ) | ( ( rule__TransformationDependency__Group_12_1__0 ) ) )
            int alt1=2;
            alt1 = dfa1.predict(input);
            switch (alt1) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:519:1: ( ( rule__TransformationDependency__Group_12_0__0 ) )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:519:1: ( ( rule__TransformationDependency__Group_12_0__0 ) )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:520:1: ( rule__TransformationDependency__Group_12_0__0 )
                    {
                     before(grammarAccess.getTransformationDependencyAccess().getGroup_12_0()); 
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:521:1: ( rule__TransformationDependency__Group_12_0__0 )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:521:2: rule__TransformationDependency__Group_12_0__0
                    {
                    pushFollow(FOLLOW_rule__TransformationDependency__Group_12_0__0_in_rule__TransformationDependency__Alternatives_121035);
                    rule__TransformationDependency__Group_12_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTransformationDependencyAccess().getGroup_12_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:525:6: ( ( rule__TransformationDependency__Group_12_1__0 ) )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:525:6: ( ( rule__TransformationDependency__Group_12_1__0 ) )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:526:1: ( rule__TransformationDependency__Group_12_1__0 )
                    {
                     before(grammarAccess.getTransformationDependencyAccess().getGroup_12_1()); 
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:527:1: ( rule__TransformationDependency__Group_12_1__0 )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:527:2: rule__TransformationDependency__Group_12_1__0
                    {
                    pushFollow(FOLLOW_rule__TransformationDependency__Group_12_1__0_in_rule__TransformationDependency__Alternatives_121053);
                    rule__TransformationDependency__Group_12_1__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getTransformationDependencyAccess().getGroup_12_1()); 

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
    // $ANTLR end "rule__TransformationDependency__Alternatives_12"


    // $ANTLR start "rule__RuleDependency__Alternatives"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:536:1: rule__RuleDependency__Alternatives : ( ( ( rule__RuleDependency__Group_0__0 ) ) | ( ( rule__RuleDependency__Group_1__0 ) ) );
    public final void rule__RuleDependency__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:540:1: ( ( ( rule__RuleDependency__Group_0__0 ) ) | ( ( rule__RuleDependency__Group_1__0 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==29) ) {
                alt2=1;
            }
            else if ( (LA2_0==30) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:541:1: ( ( rule__RuleDependency__Group_0__0 ) )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:541:1: ( ( rule__RuleDependency__Group_0__0 ) )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:542:1: ( rule__RuleDependency__Group_0__0 )
                    {
                     before(grammarAccess.getRuleDependencyAccess().getGroup_0()); 
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:543:1: ( rule__RuleDependency__Group_0__0 )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:543:2: rule__RuleDependency__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__RuleDependency__Group_0__0_in_rule__RuleDependency__Alternatives1086);
                    rule__RuleDependency__Group_0__0();

                    state._fsp--;


                    }

                     after(grammarAccess.getRuleDependencyAccess().getGroup_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:547:6: ( ( rule__RuleDependency__Group_1__0 ) )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:547:6: ( ( rule__RuleDependency__Group_1__0 ) )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:548:1: ( rule__RuleDependency__Group_1__0 )
                    {
                     before(grammarAccess.getRuleDependencyAccess().getGroup_1()); 
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:549:1: ( rule__RuleDependency__Group_1__0 )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:549:2: rule__RuleDependency__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__RuleDependency__Group_1__0_in_rule__RuleDependency__Alternatives1104);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:558:1: rule__RuleDependency__Alternatives_0_2 : ( ( 'and' ) | ( 'or' ) );
    public final void rule__RuleDependency__Alternatives_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:562:1: ( ( 'and' ) | ( 'or' ) )
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
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:563:1: ( 'and' )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:563:1: ( 'and' )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:564:1: 'and'
                    {
                     before(grammarAccess.getRuleDependencyAccess().getAndKeyword_0_2_0()); 
                    match(input,11,FOLLOW_11_in_rule__RuleDependency__Alternatives_0_21138); 
                     after(grammarAccess.getRuleDependencyAccess().getAndKeyword_0_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:571:6: ( 'or' )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:571:6: ( 'or' )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:572:1: 'or'
                    {
                     before(grammarAccess.getRuleDependencyAccess().getOrKeyword_0_2_1()); 
                    match(input,12,FOLLOW_12_in_rule__RuleDependency__Alternatives_0_21158); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:584:1: rule__RuleDependency__Alternatives_1_2 : ( ( 'and' ) | ( 'or' ) );
    public final void rule__RuleDependency__Alternatives_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:588:1: ( ( 'and' ) | ( 'or' ) )
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
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:589:1: ( 'and' )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:589:1: ( 'and' )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:590:1: 'and'
                    {
                     before(grammarAccess.getRuleDependencyAccess().getAndKeyword_1_2_0()); 
                    match(input,11,FOLLOW_11_in_rule__RuleDependency__Alternatives_1_21193); 
                     after(grammarAccess.getRuleDependencyAccess().getAndKeyword_1_2_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:597:6: ( 'or' )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:597:6: ( 'or' )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:598:1: 'or'
                    {
                     before(grammarAccess.getRuleDependencyAccess().getOrKeyword_1_2_1()); 
                    match(input,12,FOLLOW_12_in_rule__RuleDependency__Alternatives_1_21213); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:610:1: rule__EString__Alternatives : ( ( RULE_STRING ) | ( RULE_ID ) );
    public final void rule__EString__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:614:1: ( ( RULE_STRING ) | ( RULE_ID ) )
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
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:615:1: ( RULE_STRING )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:615:1: ( RULE_STRING )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:616:1: RULE_STRING
                    {
                     before(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                    match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__EString__Alternatives1247); 
                     after(grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 

                    }


                    }
                    break;
                case 2 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:621:6: ( RULE_ID )
                    {
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:621:6: ( RULE_ID )
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:622:1: RULE_ID
                    {
                     before(grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                    match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__EString__Alternatives1264); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:635:1: rule__TrcSpecification__Group__0 : rule__TrcSpecification__Group__0__Impl rule__TrcSpecification__Group__1 ;
    public final void rule__TrcSpecification__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:639:1: ( rule__TrcSpecification__Group__0__Impl rule__TrcSpecification__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:640:2: rule__TrcSpecification__Group__0__Impl rule__TrcSpecification__Group__1
            {
            pushFollow(FOLLOW_rule__TrcSpecification__Group__0__Impl_in_rule__TrcSpecification__Group__01295);
            rule__TrcSpecification__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TrcSpecification__Group__1_in_rule__TrcSpecification__Group__01298);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:647:1: rule__TrcSpecification__Group__0__Impl : ( ( rule__TrcSpecification__ModuleListAssignment_0 ) ) ;
    public final void rule__TrcSpecification__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:651:1: ( ( ( rule__TrcSpecification__ModuleListAssignment_0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:652:1: ( ( rule__TrcSpecification__ModuleListAssignment_0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:652:1: ( ( rule__TrcSpecification__ModuleListAssignment_0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:653:1: ( rule__TrcSpecification__ModuleListAssignment_0 )
            {
             before(grammarAccess.getTrcSpecificationAccess().getModuleListAssignment_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:654:1: ( rule__TrcSpecification__ModuleListAssignment_0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:654:2: rule__TrcSpecification__ModuleListAssignment_0
            {
            pushFollow(FOLLOW_rule__TrcSpecification__ModuleListAssignment_0_in_rule__TrcSpecification__Group__0__Impl1325);
            rule__TrcSpecification__ModuleListAssignment_0();

            state._fsp--;


            }

             after(grammarAccess.getTrcSpecificationAccess().getModuleListAssignment_0()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:664:1: rule__TrcSpecification__Group__1 : rule__TrcSpecification__Group__1__Impl rule__TrcSpecification__Group__2 ;
    public final void rule__TrcSpecification__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:668:1: ( rule__TrcSpecification__Group__1__Impl rule__TrcSpecification__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:669:2: rule__TrcSpecification__Group__1__Impl rule__TrcSpecification__Group__2
            {
            pushFollow(FOLLOW_rule__TrcSpecification__Group__1__Impl_in_rule__TrcSpecification__Group__11355);
            rule__TrcSpecification__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TrcSpecification__Group__2_in_rule__TrcSpecification__Group__11358);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:676:1: rule__TrcSpecification__Group__1__Impl : ( ( rule__TrcSpecification__TransformationListAssignment_1 )? ) ;
    public final void rule__TrcSpecification__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:680:1: ( ( ( rule__TrcSpecification__TransformationListAssignment_1 )? ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:681:1: ( ( rule__TrcSpecification__TransformationListAssignment_1 )? )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:681:1: ( ( rule__TrcSpecification__TransformationListAssignment_1 )? )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:682:1: ( rule__TrcSpecification__TransformationListAssignment_1 )?
            {
             before(grammarAccess.getTrcSpecificationAccess().getTransformationListAssignment_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:683:1: ( rule__TrcSpecification__TransformationListAssignment_1 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==20) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:683:2: rule__TrcSpecification__TransformationListAssignment_1
                    {
                    pushFollow(FOLLOW_rule__TrcSpecification__TransformationListAssignment_1_in_rule__TrcSpecification__Group__1__Impl1385);
                    rule__TrcSpecification__TransformationListAssignment_1();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTrcSpecificationAccess().getTransformationListAssignment_1()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:693:1: rule__TrcSpecification__Group__2 : rule__TrcSpecification__Group__2__Impl ;
    public final void rule__TrcSpecification__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:697:1: ( rule__TrcSpecification__Group__2__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:698:2: rule__TrcSpecification__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__TrcSpecification__Group__2__Impl_in_rule__TrcSpecification__Group__21416);
            rule__TrcSpecification__Group__2__Impl();

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:704:1: rule__TrcSpecification__Group__2__Impl : ( ( rule__TrcSpecification__DependencyListAssignment_2 )? ) ;
    public final void rule__TrcSpecification__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:708:1: ( ( ( rule__TrcSpecification__DependencyListAssignment_2 )? ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:709:1: ( ( rule__TrcSpecification__DependencyListAssignment_2 )? )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:709:1: ( ( rule__TrcSpecification__DependencyListAssignment_2 )? )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:710:1: ( rule__TrcSpecification__DependencyListAssignment_2 )?
            {
             before(grammarAccess.getTrcSpecificationAccess().getDependencyListAssignment_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:711:1: ( rule__TrcSpecification__DependencyListAssignment_2 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==25) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:711:2: rule__TrcSpecification__DependencyListAssignment_2
                    {
                    pushFollow(FOLLOW_rule__TrcSpecification__DependencyListAssignment_2_in_rule__TrcSpecification__Group__2__Impl1443);
                    rule__TrcSpecification__DependencyListAssignment_2();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getTrcSpecificationAccess().getDependencyListAssignment_2()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:727:1: rule__ModuleList__Group__0 : rule__ModuleList__Group__0__Impl rule__ModuleList__Group__1 ;
    public final void rule__ModuleList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:731:1: ( rule__ModuleList__Group__0__Impl rule__ModuleList__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:732:2: rule__ModuleList__Group__0__Impl rule__ModuleList__Group__1
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__0__Impl_in_rule__ModuleList__Group__01480);
            rule__ModuleList__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModuleList__Group__1_in_rule__ModuleList__Group__01483);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:739:1: rule__ModuleList__Group__0__Impl : ( 'Modules' ) ;
    public final void rule__ModuleList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:743:1: ( ( 'Modules' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:744:1: ( 'Modules' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:744:1: ( 'Modules' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:745:1: 'Modules'
            {
             before(grammarAccess.getModuleListAccess().getModulesKeyword_0()); 
            match(input,13,FOLLOW_13_in_rule__ModuleList__Group__0__Impl1511); 
             after(grammarAccess.getModuleListAccess().getModulesKeyword_0()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:758:1: rule__ModuleList__Group__1 : rule__ModuleList__Group__1__Impl rule__ModuleList__Group__2 ;
    public final void rule__ModuleList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:762:1: ( rule__ModuleList__Group__1__Impl rule__ModuleList__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:763:2: rule__ModuleList__Group__1__Impl rule__ModuleList__Group__2
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__1__Impl_in_rule__ModuleList__Group__11542);
            rule__ModuleList__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModuleList__Group__2_in_rule__ModuleList__Group__11545);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:770:1: rule__ModuleList__Group__1__Impl : ( '{' ) ;
    public final void rule__ModuleList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:774:1: ( ( '{' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:775:1: ( '{' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:775:1: ( '{' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:776:1: '{'
            {
             before(grammarAccess.getModuleListAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,14,FOLLOW_14_in_rule__ModuleList__Group__1__Impl1573); 
             after(grammarAccess.getModuleListAccess().getLeftCurlyBracketKeyword_1()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:789:1: rule__ModuleList__Group__2 : rule__ModuleList__Group__2__Impl rule__ModuleList__Group__3 ;
    public final void rule__ModuleList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:793:1: ( rule__ModuleList__Group__2__Impl rule__ModuleList__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:794:2: rule__ModuleList__Group__2__Impl rule__ModuleList__Group__3
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__2__Impl_in_rule__ModuleList__Group__21604);
            rule__ModuleList__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModuleList__Group__3_in_rule__ModuleList__Group__21607);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:801:1: rule__ModuleList__Group__2__Impl : ( ( rule__ModuleList__ModulesAssignment_2 ) ) ;
    public final void rule__ModuleList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:805:1: ( ( ( rule__ModuleList__ModulesAssignment_2 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:806:1: ( ( rule__ModuleList__ModulesAssignment_2 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:806:1: ( ( rule__ModuleList__ModulesAssignment_2 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:807:1: ( rule__ModuleList__ModulesAssignment_2 )
            {
             before(grammarAccess.getModuleListAccess().getModulesAssignment_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:808:1: ( rule__ModuleList__ModulesAssignment_2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:808:2: rule__ModuleList__ModulesAssignment_2
            {
            pushFollow(FOLLOW_rule__ModuleList__ModulesAssignment_2_in_rule__ModuleList__Group__2__Impl1634);
            rule__ModuleList__ModulesAssignment_2();

            state._fsp--;


            }

             after(grammarAccess.getModuleListAccess().getModulesAssignment_2()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:818:1: rule__ModuleList__Group__3 : rule__ModuleList__Group__3__Impl rule__ModuleList__Group__4 ;
    public final void rule__ModuleList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:822:1: ( rule__ModuleList__Group__3__Impl rule__ModuleList__Group__4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:823:2: rule__ModuleList__Group__3__Impl rule__ModuleList__Group__4
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__3__Impl_in_rule__ModuleList__Group__31664);
            rule__ModuleList__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModuleList__Group__4_in_rule__ModuleList__Group__31667);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:830:1: rule__ModuleList__Group__3__Impl : ( ( rule__ModuleList__Group_3__0 )* ) ;
    public final void rule__ModuleList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:834:1: ( ( ( rule__ModuleList__Group_3__0 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:835:1: ( ( rule__ModuleList__Group_3__0 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:835:1: ( ( rule__ModuleList__Group_3__0 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:836:1: ( rule__ModuleList__Group_3__0 )*
            {
             before(grammarAccess.getModuleListAccess().getGroup_3()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:837:1: ( rule__ModuleList__Group_3__0 )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==16) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:837:2: rule__ModuleList__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__ModuleList__Group_3__0_in_rule__ModuleList__Group__3__Impl1694);
            	    rule__ModuleList__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:847:1: rule__ModuleList__Group__4 : rule__ModuleList__Group__4__Impl ;
    public final void rule__ModuleList__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:851:1: ( rule__ModuleList__Group__4__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:852:2: rule__ModuleList__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__ModuleList__Group__4__Impl_in_rule__ModuleList__Group__41725);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:858:1: rule__ModuleList__Group__4__Impl : ( '}' ) ;
    public final void rule__ModuleList__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:862:1: ( ( '}' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:863:1: ( '}' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:863:1: ( '}' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:864:1: '}'
            {
             before(grammarAccess.getModuleListAccess().getRightCurlyBracketKeyword_4()); 
            match(input,15,FOLLOW_15_in_rule__ModuleList__Group__4__Impl1753); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:887:1: rule__ModuleList__Group_3__0 : rule__ModuleList__Group_3__0__Impl rule__ModuleList__Group_3__1 ;
    public final void rule__ModuleList__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:891:1: ( rule__ModuleList__Group_3__0__Impl rule__ModuleList__Group_3__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:892:2: rule__ModuleList__Group_3__0__Impl rule__ModuleList__Group_3__1
            {
            pushFollow(FOLLOW_rule__ModuleList__Group_3__0__Impl_in_rule__ModuleList__Group_3__01794);
            rule__ModuleList__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ModuleList__Group_3__1_in_rule__ModuleList__Group_3__01797);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:899:1: rule__ModuleList__Group_3__0__Impl : ( ';' ) ;
    public final void rule__ModuleList__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:903:1: ( ( ';' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:904:1: ( ';' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:904:1: ( ';' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:905:1: ';'
            {
             before(grammarAccess.getModuleListAccess().getSemicolonKeyword_3_0()); 
            match(input,16,FOLLOW_16_in_rule__ModuleList__Group_3__0__Impl1825); 
             after(grammarAccess.getModuleListAccess().getSemicolonKeyword_3_0()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:918:1: rule__ModuleList__Group_3__1 : rule__ModuleList__Group_3__1__Impl ;
    public final void rule__ModuleList__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:922:1: ( rule__ModuleList__Group_3__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:923:2: rule__ModuleList__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__ModuleList__Group_3__1__Impl_in_rule__ModuleList__Group_3__11856);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:929:1: rule__ModuleList__Group_3__1__Impl : ( ( rule__ModuleList__ModulesAssignment_3_1 ) ) ;
    public final void rule__ModuleList__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:933:1: ( ( ( rule__ModuleList__ModulesAssignment_3_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:934:1: ( ( rule__ModuleList__ModulesAssignment_3_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:934:1: ( ( rule__ModuleList__ModulesAssignment_3_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:935:1: ( rule__ModuleList__ModulesAssignment_3_1 )
            {
             before(grammarAccess.getModuleListAccess().getModulesAssignment_3_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:936:1: ( rule__ModuleList__ModulesAssignment_3_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:936:2: rule__ModuleList__ModulesAssignment_3_1
            {
            pushFollow(FOLLOW_rule__ModuleList__ModulesAssignment_3_1_in_rule__ModuleList__Group_3__1__Impl1883);
            rule__ModuleList__ModulesAssignment_3_1();

            state._fsp--;


            }

             after(grammarAccess.getModuleListAccess().getModulesAssignment_3_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:950:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:954:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:955:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01917);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01920);
            rule__QualifiedName__Group__1();

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
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:962:1: rule__QualifiedName__Group__0__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:966:1: ( ( RULE_ID ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:967:1: ( RULE_ID )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:967:1: ( RULE_ID )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:968:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl1947); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:979:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:983:1: ( rule__QualifiedName__Group__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:984:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11976);
            rule__QualifiedName__Group__1__Impl();

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
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:990:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:994:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:995:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:995:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:996:1: ( rule__QualifiedName__Group_1__0 )*
            {
             before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:997:1: ( rule__QualifiedName__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==17) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:997:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl2003);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

             after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1011:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1015:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1016:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__02038);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__02041);
            rule__QualifiedName__Group_1__1();

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
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1023:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1027:1: ( ( '.' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1028:1: ( '.' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1028:1: ( '.' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1029:1: '.'
            {
             before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            match(input,17,FOLLOW_17_in_rule__QualifiedName__Group_1__0__Impl2069); 
             after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1042:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1046:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1047:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__12100);
            rule__QualifiedName__Group_1__1__Impl();

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
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1053:1: rule__QualifiedName__Group_1__1__Impl : ( RULE_ID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1057:1: ( ( RULE_ID ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1058:1: ( RULE_ID )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1058:1: ( RULE_ID )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1059:1: RULE_ID
            {
             before(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl2127); 
             after(grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1074:1: rule__Module__Group__0 : rule__Module__Group__0__Impl rule__Module__Group__1 ;
    public final void rule__Module__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1078:1: ( rule__Module__Group__0__Impl rule__Module__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1079:2: rule__Module__Group__0__Impl rule__Module__Group__1
            {
            pushFollow(FOLLOW_rule__Module__Group__0__Impl_in_rule__Module__Group__02160);
            rule__Module__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Module__Group__1_in_rule__Module__Group__02163);
            rule__Module__Group__1();

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
    // $ANTLR end "rule__Module__Group__0"


    // $ANTLR start "rule__Module__Group__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1086:1: rule__Module__Group__0__Impl : ( () ) ;
    public final void rule__Module__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1090:1: ( ( () ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1091:1: ( () )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1091:1: ( () )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1092:1: ()
            {
             before(grammarAccess.getModuleAccess().getModuleAction_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1093:1: ()
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1095:1: 
            {
            }

             after(grammarAccess.getModuleAccess().getModuleAction_0()); 

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group__0__Impl"


    // $ANTLR start "rule__Module__Group__1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1105:1: rule__Module__Group__1 : rule__Module__Group__1__Impl ;
    public final void rule__Module__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1109:1: ( rule__Module__Group__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1110:2: rule__Module__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__Module__Group__1__Impl_in_rule__Module__Group__12221);
            rule__Module__Group__1__Impl();

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
    // $ANTLR end "rule__Module__Group__1"


    // $ANTLR start "rule__Module__Group__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1116:1: rule__Module__Group__1__Impl : ( ( rule__Module__Group_1__0 )? ) ;
    public final void rule__Module__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1120:1: ( ( ( rule__Module__Group_1__0 )? ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1121:1: ( ( rule__Module__Group_1__0 )? )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1121:1: ( ( rule__Module__Group_1__0 )? )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1122:1: ( rule__Module__Group_1__0 )?
            {
             before(grammarAccess.getModuleAccess().getGroup_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1123:1: ( rule__Module__Group_1__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=RULE_STRING && LA10_0<=RULE_ID)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1123:2: rule__Module__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__Module__Group_1__0_in_rule__Module__Group__1__Impl2248);
                    rule__Module__Group_1__0();

                    state._fsp--;


                    }
                    break;

            }

             after(grammarAccess.getModuleAccess().getGroup_1()); 

            }


            }

        }
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


    // $ANTLR start "rule__Module__Group_1__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1137:1: rule__Module__Group_1__0 : rule__Module__Group_1__0__Impl rule__Module__Group_1__1 ;
    public final void rule__Module__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1141:1: ( rule__Module__Group_1__0__Impl rule__Module__Group_1__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1142:2: rule__Module__Group_1__0__Impl rule__Module__Group_1__1
            {
            pushFollow(FOLLOW_rule__Module__Group_1__0__Impl_in_rule__Module__Group_1__02283);
            rule__Module__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Module__Group_1__1_in_rule__Module__Group_1__02286);
            rule__Module__Group_1__1();

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
    // $ANTLR end "rule__Module__Group_1__0"


    // $ANTLR start "rule__Module__Group_1__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1149:1: rule__Module__Group_1__0__Impl : ( ( rule__Module__NameAssignment_1_0 ) ) ;
    public final void rule__Module__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1153:1: ( ( ( rule__Module__NameAssignment_1_0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1154:1: ( ( rule__Module__NameAssignment_1_0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1154:1: ( ( rule__Module__NameAssignment_1_0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1155:1: ( rule__Module__NameAssignment_1_0 )
            {
             before(grammarAccess.getModuleAccess().getNameAssignment_1_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1156:1: ( rule__Module__NameAssignment_1_0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1156:2: rule__Module__NameAssignment_1_0
            {
            pushFollow(FOLLOW_rule__Module__NameAssignment_1_0_in_rule__Module__Group_1__0__Impl2313);
            rule__Module__NameAssignment_1_0();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getNameAssignment_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_1__0__Impl"


    // $ANTLR start "rule__Module__Group_1__1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1166:1: rule__Module__Group_1__1 : rule__Module__Group_1__1__Impl rule__Module__Group_1__2 ;
    public final void rule__Module__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1170:1: ( rule__Module__Group_1__1__Impl rule__Module__Group_1__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1171:2: rule__Module__Group_1__1__Impl rule__Module__Group_1__2
            {
            pushFollow(FOLLOW_rule__Module__Group_1__1__Impl_in_rule__Module__Group_1__12343);
            rule__Module__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Module__Group_1__2_in_rule__Module__Group_1__12346);
            rule__Module__Group_1__2();

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
    // $ANTLR end "rule__Module__Group_1__1"


    // $ANTLR start "rule__Module__Group_1__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1178:1: rule__Module__Group_1__1__Impl : ( ':' ) ;
    public final void rule__Module__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1182:1: ( ( ':' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1183:1: ( ':' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1183:1: ( ':' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1184:1: ':'
            {
             before(grammarAccess.getModuleAccess().getColonKeyword_1_1()); 
            match(input,18,FOLLOW_18_in_rule__Module__Group_1__1__Impl2374); 
             after(grammarAccess.getModuleAccess().getColonKeyword_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_1__1__Impl"


    // $ANTLR start "rule__Module__Group_1__2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1197:1: rule__Module__Group_1__2 : rule__Module__Group_1__2__Impl rule__Module__Group_1__3 ;
    public final void rule__Module__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1201:1: ( rule__Module__Group_1__2__Impl rule__Module__Group_1__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1202:2: rule__Module__Group_1__2__Impl rule__Module__Group_1__3
            {
            pushFollow(FOLLOW_rule__Module__Group_1__2__Impl_in_rule__Module__Group_1__22405);
            rule__Module__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Module__Group_1__3_in_rule__Module__Group_1__22408);
            rule__Module__Group_1__3();

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
    // $ANTLR end "rule__Module__Group_1__2"


    // $ANTLR start "rule__Module__Group_1__2__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1209:1: rule__Module__Group_1__2__Impl : ( ( rule__Module__RulesAssignment_1_2 ) ) ;
    public final void rule__Module__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1213:1: ( ( ( rule__Module__RulesAssignment_1_2 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1214:1: ( ( rule__Module__RulesAssignment_1_2 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1214:1: ( ( rule__Module__RulesAssignment_1_2 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1215:1: ( rule__Module__RulesAssignment_1_2 )
            {
             before(grammarAccess.getModuleAccess().getRulesAssignment_1_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1216:1: ( rule__Module__RulesAssignment_1_2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1216:2: rule__Module__RulesAssignment_1_2
            {
            pushFollow(FOLLOW_rule__Module__RulesAssignment_1_2_in_rule__Module__Group_1__2__Impl2435);
            rule__Module__RulesAssignment_1_2();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getRulesAssignment_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_1__2__Impl"


    // $ANTLR start "rule__Module__Group_1__3"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1226:1: rule__Module__Group_1__3 : rule__Module__Group_1__3__Impl ;
    public final void rule__Module__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1230:1: ( rule__Module__Group_1__3__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1231:2: rule__Module__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__Module__Group_1__3__Impl_in_rule__Module__Group_1__32465);
            rule__Module__Group_1__3__Impl();

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
    // $ANTLR end "rule__Module__Group_1__3"


    // $ANTLR start "rule__Module__Group_1__3__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1237:1: rule__Module__Group_1__3__Impl : ( ( rule__Module__Group_1_3__0 )* ) ;
    public final void rule__Module__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1241:1: ( ( ( rule__Module__Group_1_3__0 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1242:1: ( ( rule__Module__Group_1_3__0 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1242:1: ( ( rule__Module__Group_1_3__0 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1243:1: ( rule__Module__Group_1_3__0 )*
            {
             before(grammarAccess.getModuleAccess().getGroup_1_3()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1244:1: ( rule__Module__Group_1_3__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==19) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1244:2: rule__Module__Group_1_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Module__Group_1_3__0_in_rule__Module__Group_1__3__Impl2492);
            	    rule__Module__Group_1_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

             after(grammarAccess.getModuleAccess().getGroup_1_3()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_1__3__Impl"


    // $ANTLR start "rule__Module__Group_1_3__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1262:1: rule__Module__Group_1_3__0 : rule__Module__Group_1_3__0__Impl rule__Module__Group_1_3__1 ;
    public final void rule__Module__Group_1_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1266:1: ( rule__Module__Group_1_3__0__Impl rule__Module__Group_1_3__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1267:2: rule__Module__Group_1_3__0__Impl rule__Module__Group_1_3__1
            {
            pushFollow(FOLLOW_rule__Module__Group_1_3__0__Impl_in_rule__Module__Group_1_3__02531);
            rule__Module__Group_1_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Module__Group_1_3__1_in_rule__Module__Group_1_3__02534);
            rule__Module__Group_1_3__1();

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
    // $ANTLR end "rule__Module__Group_1_3__0"


    // $ANTLR start "rule__Module__Group_1_3__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1274:1: rule__Module__Group_1_3__0__Impl : ( ',' ) ;
    public final void rule__Module__Group_1_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1278:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1279:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1279:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1280:1: ','
            {
             before(grammarAccess.getModuleAccess().getCommaKeyword_1_3_0()); 
            match(input,19,FOLLOW_19_in_rule__Module__Group_1_3__0__Impl2562); 
             after(grammarAccess.getModuleAccess().getCommaKeyword_1_3_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_1_3__0__Impl"


    // $ANTLR start "rule__Module__Group_1_3__1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1293:1: rule__Module__Group_1_3__1 : rule__Module__Group_1_3__1__Impl ;
    public final void rule__Module__Group_1_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1297:1: ( rule__Module__Group_1_3__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1298:2: rule__Module__Group_1_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Module__Group_1_3__1__Impl_in_rule__Module__Group_1_3__12593);
            rule__Module__Group_1_3__1__Impl();

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
    // $ANTLR end "rule__Module__Group_1_3__1"


    // $ANTLR start "rule__Module__Group_1_3__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1304:1: rule__Module__Group_1_3__1__Impl : ( ( rule__Module__RulesAssignment_1_3_1 ) ) ;
    public final void rule__Module__Group_1_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1308:1: ( ( ( rule__Module__RulesAssignment_1_3_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1309:1: ( ( rule__Module__RulesAssignment_1_3_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1309:1: ( ( rule__Module__RulesAssignment_1_3_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1310:1: ( rule__Module__RulesAssignment_1_3_1 )
            {
             before(grammarAccess.getModuleAccess().getRulesAssignment_1_3_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1311:1: ( rule__Module__RulesAssignment_1_3_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1311:2: rule__Module__RulesAssignment_1_3_1
            {
            pushFollow(FOLLOW_rule__Module__RulesAssignment_1_3_1_in_rule__Module__Group_1_3__1__Impl2620);
            rule__Module__RulesAssignment_1_3_1();

            state._fsp--;


            }

             after(grammarAccess.getModuleAccess().getRulesAssignment_1_3_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__Group_1_3__1__Impl"


    // $ANTLR start "rule__TransformationList__Group__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1325:1: rule__TransformationList__Group__0 : rule__TransformationList__Group__0__Impl rule__TransformationList__Group__1 ;
    public final void rule__TransformationList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1329:1: ( rule__TransformationList__Group__0__Impl rule__TransformationList__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1330:2: rule__TransformationList__Group__0__Impl rule__TransformationList__Group__1
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__0__Impl_in_rule__TransformationList__Group__02654);
            rule__TransformationList__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationList__Group__1_in_rule__TransformationList__Group__02657);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1337:1: rule__TransformationList__Group__0__Impl : ( 'Transformations' ) ;
    public final void rule__TransformationList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1341:1: ( ( 'Transformations' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1342:1: ( 'Transformations' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1342:1: ( 'Transformations' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1343:1: 'Transformations'
            {
             before(grammarAccess.getTransformationListAccess().getTransformationsKeyword_0()); 
            match(input,20,FOLLOW_20_in_rule__TransformationList__Group__0__Impl2685); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1356:1: rule__TransformationList__Group__1 : rule__TransformationList__Group__1__Impl rule__TransformationList__Group__2 ;
    public final void rule__TransformationList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1360:1: ( rule__TransformationList__Group__1__Impl rule__TransformationList__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1361:2: rule__TransformationList__Group__1__Impl rule__TransformationList__Group__2
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__1__Impl_in_rule__TransformationList__Group__12716);
            rule__TransformationList__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationList__Group__2_in_rule__TransformationList__Group__12719);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1368:1: rule__TransformationList__Group__1__Impl : ( '{' ) ;
    public final void rule__TransformationList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1372:1: ( ( '{' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1373:1: ( '{' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1373:1: ( '{' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1374:1: '{'
            {
             before(grammarAccess.getTransformationListAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,14,FOLLOW_14_in_rule__TransformationList__Group__1__Impl2747); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1387:1: rule__TransformationList__Group__2 : rule__TransformationList__Group__2__Impl rule__TransformationList__Group__3 ;
    public final void rule__TransformationList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1391:1: ( rule__TransformationList__Group__2__Impl rule__TransformationList__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1392:2: rule__TransformationList__Group__2__Impl rule__TransformationList__Group__3
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__2__Impl_in_rule__TransformationList__Group__22778);
            rule__TransformationList__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationList__Group__3_in_rule__TransformationList__Group__22781);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1399:1: rule__TransformationList__Group__2__Impl : ( ( rule__TransformationList__TransformationsAssignment_2 ) ) ;
    public final void rule__TransformationList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1403:1: ( ( ( rule__TransformationList__TransformationsAssignment_2 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1404:1: ( ( rule__TransformationList__TransformationsAssignment_2 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1404:1: ( ( rule__TransformationList__TransformationsAssignment_2 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1405:1: ( rule__TransformationList__TransformationsAssignment_2 )
            {
             before(grammarAccess.getTransformationListAccess().getTransformationsAssignment_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1406:1: ( rule__TransformationList__TransformationsAssignment_2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1406:2: rule__TransformationList__TransformationsAssignment_2
            {
            pushFollow(FOLLOW_rule__TransformationList__TransformationsAssignment_2_in_rule__TransformationList__Group__2__Impl2808);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1416:1: rule__TransformationList__Group__3 : rule__TransformationList__Group__3__Impl rule__TransformationList__Group__4 ;
    public final void rule__TransformationList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1420:1: ( rule__TransformationList__Group__3__Impl rule__TransformationList__Group__4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1421:2: rule__TransformationList__Group__3__Impl rule__TransformationList__Group__4
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__3__Impl_in_rule__TransformationList__Group__32838);
            rule__TransformationList__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationList__Group__4_in_rule__TransformationList__Group__32841);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1428:1: rule__TransformationList__Group__3__Impl : ( ( rule__TransformationList__Group_3__0 )* ) ;
    public final void rule__TransformationList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1432:1: ( ( ( rule__TransformationList__Group_3__0 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1433:1: ( ( rule__TransformationList__Group_3__0 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1433:1: ( ( rule__TransformationList__Group_3__0 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1434:1: ( rule__TransformationList__Group_3__0 )*
            {
             before(grammarAccess.getTransformationListAccess().getGroup_3()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1435:1: ( rule__TransformationList__Group_3__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==19) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1435:2: rule__TransformationList__Group_3__0
            	    {
            	    pushFollow(FOLLOW_rule__TransformationList__Group_3__0_in_rule__TransformationList__Group__3__Impl2868);
            	    rule__TransformationList__Group_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1445:1: rule__TransformationList__Group__4 : rule__TransformationList__Group__4__Impl ;
    public final void rule__TransformationList__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1449:1: ( rule__TransformationList__Group__4__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1450:2: rule__TransformationList__Group__4__Impl
            {
            pushFollow(FOLLOW_rule__TransformationList__Group__4__Impl_in_rule__TransformationList__Group__42899);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1456:1: rule__TransformationList__Group__4__Impl : ( '}' ) ;
    public final void rule__TransformationList__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1460:1: ( ( '}' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1461:1: ( '}' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1461:1: ( '}' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1462:1: '}'
            {
             before(grammarAccess.getTransformationListAccess().getRightCurlyBracketKeyword_4()); 
            match(input,15,FOLLOW_15_in_rule__TransformationList__Group__4__Impl2927); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1485:1: rule__TransformationList__Group_3__0 : rule__TransformationList__Group_3__0__Impl rule__TransformationList__Group_3__1 ;
    public final void rule__TransformationList__Group_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1489:1: ( rule__TransformationList__Group_3__0__Impl rule__TransformationList__Group_3__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1490:2: rule__TransformationList__Group_3__0__Impl rule__TransformationList__Group_3__1
            {
            pushFollow(FOLLOW_rule__TransformationList__Group_3__0__Impl_in_rule__TransformationList__Group_3__02968);
            rule__TransformationList__Group_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationList__Group_3__1_in_rule__TransformationList__Group_3__02971);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1497:1: rule__TransformationList__Group_3__0__Impl : ( ',' ) ;
    public final void rule__TransformationList__Group_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1501:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1502:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1502:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1503:1: ','
            {
             before(grammarAccess.getTransformationListAccess().getCommaKeyword_3_0()); 
            match(input,19,FOLLOW_19_in_rule__TransformationList__Group_3__0__Impl2999); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1516:1: rule__TransformationList__Group_3__1 : rule__TransformationList__Group_3__1__Impl ;
    public final void rule__TransformationList__Group_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1520:1: ( rule__TransformationList__Group_3__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1521:2: rule__TransformationList__Group_3__1__Impl
            {
            pushFollow(FOLLOW_rule__TransformationList__Group_3__1__Impl_in_rule__TransformationList__Group_3__13030);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1527:1: rule__TransformationList__Group_3__1__Impl : ( ( rule__TransformationList__TransformationsAssignment_3_1 ) ) ;
    public final void rule__TransformationList__Group_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1531:1: ( ( ( rule__TransformationList__TransformationsAssignment_3_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1532:1: ( ( rule__TransformationList__TransformationsAssignment_3_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1532:1: ( ( rule__TransformationList__TransformationsAssignment_3_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1533:1: ( rule__TransformationList__TransformationsAssignment_3_1 )
            {
             before(grammarAccess.getTransformationListAccess().getTransformationsAssignment_3_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1534:1: ( rule__TransformationList__TransformationsAssignment_3_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1534:2: rule__TransformationList__TransformationsAssignment_3_1
            {
            pushFollow(FOLLOW_rule__TransformationList__TransformationsAssignment_3_1_in_rule__TransformationList__Group_3__1__Impl3057);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1548:1: rule__Transformation__Group__0 : rule__Transformation__Group__0__Impl rule__Transformation__Group__1 ;
    public final void rule__Transformation__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1552:1: ( rule__Transformation__Group__0__Impl rule__Transformation__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1553:2: rule__Transformation__Group__0__Impl rule__Transformation__Group__1
            {
            pushFollow(FOLLOW_rule__Transformation__Group__0__Impl_in_rule__Transformation__Group__03091);
            rule__Transformation__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group__1_in_rule__Transformation__Group__03094);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1560:1: rule__Transformation__Group__0__Impl : ( ( rule__Transformation__NameAssignment_0 ) ) ;
    public final void rule__Transformation__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1564:1: ( ( ( rule__Transformation__NameAssignment_0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1565:1: ( ( rule__Transformation__NameAssignment_0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1565:1: ( ( rule__Transformation__NameAssignment_0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1566:1: ( rule__Transformation__NameAssignment_0 )
            {
             before(grammarAccess.getTransformationAccess().getNameAssignment_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1567:1: ( rule__Transformation__NameAssignment_0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1567:2: rule__Transformation__NameAssignment_0
            {
            pushFollow(FOLLOW_rule__Transformation__NameAssignment_0_in_rule__Transformation__Group__0__Impl3121);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1577:1: rule__Transformation__Group__1 : rule__Transformation__Group__1__Impl rule__Transformation__Group__2 ;
    public final void rule__Transformation__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1581:1: ( rule__Transformation__Group__1__Impl rule__Transformation__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1582:2: rule__Transformation__Group__1__Impl rule__Transformation__Group__2
            {
            pushFollow(FOLLOW_rule__Transformation__Group__1__Impl_in_rule__Transformation__Group__13151);
            rule__Transformation__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group__2_in_rule__Transformation__Group__13154);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1589:1: rule__Transformation__Group__1__Impl : ( '{' ) ;
    public final void rule__Transformation__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1593:1: ( ( '{' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1594:1: ( '{' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1594:1: ( '{' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1595:1: '{'
            {
             before(grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,14,FOLLOW_14_in_rule__Transformation__Group__1__Impl3182); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1608:1: rule__Transformation__Group__2 : rule__Transformation__Group__2__Impl rule__Transformation__Group__3 ;
    public final void rule__Transformation__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1612:1: ( rule__Transformation__Group__2__Impl rule__Transformation__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1613:2: rule__Transformation__Group__2__Impl rule__Transformation__Group__3
            {
            pushFollow(FOLLOW_rule__Transformation__Group__2__Impl_in_rule__Transformation__Group__23213);
            rule__Transformation__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group__3_in_rule__Transformation__Group__23216);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1620:1: rule__Transformation__Group__2__Impl : ( 'modules' ) ;
    public final void rule__Transformation__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1624:1: ( ( 'modules' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1625:1: ( 'modules' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1625:1: ( 'modules' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1626:1: 'modules'
            {
             before(grammarAccess.getTransformationAccess().getModulesKeyword_2()); 
            match(input,21,FOLLOW_21_in_rule__Transformation__Group__2__Impl3244); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1639:1: rule__Transformation__Group__3 : rule__Transformation__Group__3__Impl rule__Transformation__Group__4 ;
    public final void rule__Transformation__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1643:1: ( rule__Transformation__Group__3__Impl rule__Transformation__Group__4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1644:2: rule__Transformation__Group__3__Impl rule__Transformation__Group__4
            {
            pushFollow(FOLLOW_rule__Transformation__Group__3__Impl_in_rule__Transformation__Group__33275);
            rule__Transformation__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group__4_in_rule__Transformation__Group__33278);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1651:1: rule__Transformation__Group__3__Impl : ( ':' ) ;
    public final void rule__Transformation__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1655:1: ( ( ':' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1656:1: ( ':' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1656:1: ( ':' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1657:1: ':'
            {
             before(grammarAccess.getTransformationAccess().getColonKeyword_3()); 
            match(input,18,FOLLOW_18_in_rule__Transformation__Group__3__Impl3306); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1670:1: rule__Transformation__Group__4 : rule__Transformation__Group__4__Impl rule__Transformation__Group__5 ;
    public final void rule__Transformation__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1674:1: ( rule__Transformation__Group__4__Impl rule__Transformation__Group__5 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1675:2: rule__Transformation__Group__4__Impl rule__Transformation__Group__5
            {
            pushFollow(FOLLOW_rule__Transformation__Group__4__Impl_in_rule__Transformation__Group__43337);
            rule__Transformation__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group__5_in_rule__Transformation__Group__43340);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1682:1: rule__Transformation__Group__4__Impl : ( ( rule__Transformation__ModulesAssignment_4 ) ) ;
    public final void rule__Transformation__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1686:1: ( ( ( rule__Transformation__ModulesAssignment_4 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1687:1: ( ( rule__Transformation__ModulesAssignment_4 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1687:1: ( ( rule__Transformation__ModulesAssignment_4 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1688:1: ( rule__Transformation__ModulesAssignment_4 )
            {
             before(grammarAccess.getTransformationAccess().getModulesAssignment_4()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1689:1: ( rule__Transformation__ModulesAssignment_4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1689:2: rule__Transformation__ModulesAssignment_4
            {
            pushFollow(FOLLOW_rule__Transformation__ModulesAssignment_4_in_rule__Transformation__Group__4__Impl3367);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1699:1: rule__Transformation__Group__5 : rule__Transformation__Group__5__Impl rule__Transformation__Group__6 ;
    public final void rule__Transformation__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1703:1: ( rule__Transformation__Group__5__Impl rule__Transformation__Group__6 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1704:2: rule__Transformation__Group__5__Impl rule__Transformation__Group__6
            {
            pushFollow(FOLLOW_rule__Transformation__Group__5__Impl_in_rule__Transformation__Group__53397);
            rule__Transformation__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group__6_in_rule__Transformation__Group__53400);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1711:1: rule__Transformation__Group__5__Impl : ( ( rule__Transformation__Group_5__0 )* ) ;
    public final void rule__Transformation__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1715:1: ( ( ( rule__Transformation__Group_5__0 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1716:1: ( ( rule__Transformation__Group_5__0 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1716:1: ( ( rule__Transformation__Group_5__0 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1717:1: ( rule__Transformation__Group_5__0 )*
            {
             before(grammarAccess.getTransformationAccess().getGroup_5()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1718:1: ( rule__Transformation__Group_5__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==19) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1718:2: rule__Transformation__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__Transformation__Group_5__0_in_rule__Transformation__Group__5__Impl3427);
            	    rule__Transformation__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1728:1: rule__Transformation__Group__6 : rule__Transformation__Group__6__Impl rule__Transformation__Group__7 ;
    public final void rule__Transformation__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1732:1: ( rule__Transformation__Group__6__Impl rule__Transformation__Group__7 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1733:2: rule__Transformation__Group__6__Impl rule__Transformation__Group__7
            {
            pushFollow(FOLLOW_rule__Transformation__Group__6__Impl_in_rule__Transformation__Group__63458);
            rule__Transformation__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group__7_in_rule__Transformation__Group__63461);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1740:1: rule__Transformation__Group__6__Impl : ( ( rule__Transformation__Group_6__0 )? ) ;
    public final void rule__Transformation__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1744:1: ( ( ( rule__Transformation__Group_6__0 )? ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1745:1: ( ( rule__Transformation__Group_6__0 )? )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1745:1: ( ( rule__Transformation__Group_6__0 )? )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1746:1: ( rule__Transformation__Group_6__0 )?
            {
             before(grammarAccess.getTransformationAccess().getGroup_6()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1747:1: ( rule__Transformation__Group_6__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==22) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1747:2: rule__Transformation__Group_6__0
                    {
                    pushFollow(FOLLOW_rule__Transformation__Group_6__0_in_rule__Transformation__Group__6__Impl3488);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1757:1: rule__Transformation__Group__7 : rule__Transformation__Group__7__Impl ;
    public final void rule__Transformation__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1761:1: ( rule__Transformation__Group__7__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1762:2: rule__Transformation__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__Transformation__Group__7__Impl_in_rule__Transformation__Group__73519);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1768:1: rule__Transformation__Group__7__Impl : ( '}' ) ;
    public final void rule__Transformation__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1772:1: ( ( '}' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1773:1: ( '}' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1773:1: ( '}' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1774:1: '}'
            {
             before(grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_7()); 
            match(input,15,FOLLOW_15_in_rule__Transformation__Group__7__Impl3547); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1803:1: rule__Transformation__Group_5__0 : rule__Transformation__Group_5__0__Impl rule__Transformation__Group_5__1 ;
    public final void rule__Transformation__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1807:1: ( rule__Transformation__Group_5__0__Impl rule__Transformation__Group_5__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1808:2: rule__Transformation__Group_5__0__Impl rule__Transformation__Group_5__1
            {
            pushFollow(FOLLOW_rule__Transformation__Group_5__0__Impl_in_rule__Transformation__Group_5__03594);
            rule__Transformation__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group_5__1_in_rule__Transformation__Group_5__03597);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1815:1: rule__Transformation__Group_5__0__Impl : ( ',' ) ;
    public final void rule__Transformation__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1819:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1820:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1820:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1821:1: ','
            {
             before(grammarAccess.getTransformationAccess().getCommaKeyword_5_0()); 
            match(input,19,FOLLOW_19_in_rule__Transformation__Group_5__0__Impl3625); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1834:1: rule__Transformation__Group_5__1 : rule__Transformation__Group_5__1__Impl ;
    public final void rule__Transformation__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1838:1: ( rule__Transformation__Group_5__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1839:2: rule__Transformation__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__Transformation__Group_5__1__Impl_in_rule__Transformation__Group_5__13656);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1845:1: rule__Transformation__Group_5__1__Impl : ( ( rule__Transformation__ModulesAssignment_5_1 ) ) ;
    public final void rule__Transformation__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1849:1: ( ( ( rule__Transformation__ModulesAssignment_5_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1850:1: ( ( rule__Transformation__ModulesAssignment_5_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1850:1: ( ( rule__Transformation__ModulesAssignment_5_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1851:1: ( rule__Transformation__ModulesAssignment_5_1 )
            {
             before(grammarAccess.getTransformationAccess().getModulesAssignment_5_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1852:1: ( rule__Transformation__ModulesAssignment_5_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1852:2: rule__Transformation__ModulesAssignment_5_1
            {
            pushFollow(FOLLOW_rule__Transformation__ModulesAssignment_5_1_in_rule__Transformation__Group_5__1__Impl3683);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1866:1: rule__Transformation__Group_6__0 : rule__Transformation__Group_6__0__Impl rule__Transformation__Group_6__1 ;
    public final void rule__Transformation__Group_6__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1870:1: ( rule__Transformation__Group_6__0__Impl rule__Transformation__Group_6__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1871:2: rule__Transformation__Group_6__0__Impl rule__Transformation__Group_6__1
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6__0__Impl_in_rule__Transformation__Group_6__03717);
            rule__Transformation__Group_6__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group_6__1_in_rule__Transformation__Group_6__03720);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1878:1: rule__Transformation__Group_6__0__Impl : ( 'impacts' ) ;
    public final void rule__Transformation__Group_6__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1882:1: ( ( 'impacts' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1883:1: ( 'impacts' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1883:1: ( 'impacts' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1884:1: 'impacts'
            {
             before(grammarAccess.getTransformationAccess().getImpactsKeyword_6_0()); 
            match(input,22,FOLLOW_22_in_rule__Transformation__Group_6__0__Impl3748); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1897:1: rule__Transformation__Group_6__1 : rule__Transformation__Group_6__1__Impl rule__Transformation__Group_6__2 ;
    public final void rule__Transformation__Group_6__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1901:1: ( rule__Transformation__Group_6__1__Impl rule__Transformation__Group_6__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1902:2: rule__Transformation__Group_6__1__Impl rule__Transformation__Group_6__2
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6__1__Impl_in_rule__Transformation__Group_6__13779);
            rule__Transformation__Group_6__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group_6__2_in_rule__Transformation__Group_6__13782);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1909:1: rule__Transformation__Group_6__1__Impl : ( ':' ) ;
    public final void rule__Transformation__Group_6__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1913:1: ( ( ':' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1914:1: ( ':' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1914:1: ( ':' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1915:1: ':'
            {
             before(grammarAccess.getTransformationAccess().getColonKeyword_6_1()); 
            match(input,18,FOLLOW_18_in_rule__Transformation__Group_6__1__Impl3810); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1928:1: rule__Transformation__Group_6__2 : rule__Transformation__Group_6__2__Impl rule__Transformation__Group_6__3 ;
    public final void rule__Transformation__Group_6__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1932:1: ( rule__Transformation__Group_6__2__Impl rule__Transformation__Group_6__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1933:2: rule__Transformation__Group_6__2__Impl rule__Transformation__Group_6__3
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6__2__Impl_in_rule__Transformation__Group_6__23841);
            rule__Transformation__Group_6__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group_6__3_in_rule__Transformation__Group_6__23844);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1940:1: rule__Transformation__Group_6__2__Impl : ( ( rule__Transformation__ImpactsAssignment_6_2 ) ) ;
    public final void rule__Transformation__Group_6__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1944:1: ( ( ( rule__Transformation__ImpactsAssignment_6_2 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1945:1: ( ( rule__Transformation__ImpactsAssignment_6_2 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1945:1: ( ( rule__Transformation__ImpactsAssignment_6_2 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1946:1: ( rule__Transformation__ImpactsAssignment_6_2 )
            {
             before(grammarAccess.getTransformationAccess().getImpactsAssignment_6_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1947:1: ( rule__Transformation__ImpactsAssignment_6_2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1947:2: rule__Transformation__ImpactsAssignment_6_2
            {
            pushFollow(FOLLOW_rule__Transformation__ImpactsAssignment_6_2_in_rule__Transformation__Group_6__2__Impl3871);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1957:1: rule__Transformation__Group_6__3 : rule__Transformation__Group_6__3__Impl ;
    public final void rule__Transformation__Group_6__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1961:1: ( rule__Transformation__Group_6__3__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1962:2: rule__Transformation__Group_6__3__Impl
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6__3__Impl_in_rule__Transformation__Group_6__33901);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1968:1: rule__Transformation__Group_6__3__Impl : ( ( rule__Transformation__Group_6_3__0 )* ) ;
    public final void rule__Transformation__Group_6__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1972:1: ( ( ( rule__Transformation__Group_6_3__0 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1973:1: ( ( rule__Transformation__Group_6_3__0 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1973:1: ( ( rule__Transformation__Group_6_3__0 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1974:1: ( rule__Transformation__Group_6_3__0 )*
            {
             before(grammarAccess.getTransformationAccess().getGroup_6_3()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1975:1: ( rule__Transformation__Group_6_3__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==19) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1975:2: rule__Transformation__Group_6_3__0
            	    {
            	    pushFollow(FOLLOW_rule__Transformation__Group_6_3__0_in_rule__Transformation__Group_6__3__Impl3928);
            	    rule__Transformation__Group_6_3__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop15;
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1993:1: rule__Transformation__Group_6_3__0 : rule__Transformation__Group_6_3__0__Impl rule__Transformation__Group_6_3__1 ;
    public final void rule__Transformation__Group_6_3__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1997:1: ( rule__Transformation__Group_6_3__0__Impl rule__Transformation__Group_6_3__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:1998:2: rule__Transformation__Group_6_3__0__Impl rule__Transformation__Group_6_3__1
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6_3__0__Impl_in_rule__Transformation__Group_6_3__03967);
            rule__Transformation__Group_6_3__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__Transformation__Group_6_3__1_in_rule__Transformation__Group_6_3__03970);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2005:1: rule__Transformation__Group_6_3__0__Impl : ( ',' ) ;
    public final void rule__Transformation__Group_6_3__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2009:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2010:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2010:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2011:1: ','
            {
             before(grammarAccess.getTransformationAccess().getCommaKeyword_6_3_0()); 
            match(input,19,FOLLOW_19_in_rule__Transformation__Group_6_3__0__Impl3998); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2024:1: rule__Transformation__Group_6_3__1 : rule__Transformation__Group_6_3__1__Impl ;
    public final void rule__Transformation__Group_6_3__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2028:1: ( rule__Transformation__Group_6_3__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2029:2: rule__Transformation__Group_6_3__1__Impl
            {
            pushFollow(FOLLOW_rule__Transformation__Group_6_3__1__Impl_in_rule__Transformation__Group_6_3__14029);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2035:1: rule__Transformation__Group_6_3__1__Impl : ( ( rule__Transformation__ImpactsAssignment_6_3_1 ) ) ;
    public final void rule__Transformation__Group_6_3__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2039:1: ( ( ( rule__Transformation__ImpactsAssignment_6_3_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2040:1: ( ( rule__Transformation__ImpactsAssignment_6_3_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2040:1: ( ( rule__Transformation__ImpactsAssignment_6_3_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2041:1: ( rule__Transformation__ImpactsAssignment_6_3_1 )
            {
             before(grammarAccess.getTransformationAccess().getImpactsAssignment_6_3_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2042:1: ( rule__Transformation__ImpactsAssignment_6_3_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2042:2: rule__Transformation__ImpactsAssignment_6_3_1
            {
            pushFollow(FOLLOW_rule__Transformation__ImpactsAssignment_6_3_1_in_rule__Transformation__Group_6_3__1__Impl4056);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2056:1: rule__TransformationImpact__Group__0 : rule__TransformationImpact__Group__0__Impl rule__TransformationImpact__Group__1 ;
    public final void rule__TransformationImpact__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2060:1: ( rule__TransformationImpact__Group__0__Impl rule__TransformationImpact__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2061:2: rule__TransformationImpact__Group__0__Impl rule__TransformationImpact__Group__1
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group__0__Impl_in_rule__TransformationImpact__Group__04090);
            rule__TransformationImpact__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationImpact__Group__1_in_rule__TransformationImpact__Group__04093);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2068:1: rule__TransformationImpact__Group__0__Impl : ( '(' ) ;
    public final void rule__TransformationImpact__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2072:1: ( ( '(' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2073:1: ( '(' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2073:1: ( '(' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2074:1: '('
            {
             before(grammarAccess.getTransformationImpactAccess().getLeftParenthesisKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__TransformationImpact__Group__0__Impl4121); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2087:1: rule__TransformationImpact__Group__1 : rule__TransformationImpact__Group__1__Impl rule__TransformationImpact__Group__2 ;
    public final void rule__TransformationImpact__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2091:1: ( rule__TransformationImpact__Group__1__Impl rule__TransformationImpact__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2092:2: rule__TransformationImpact__Group__1__Impl rule__TransformationImpact__Group__2
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group__1__Impl_in_rule__TransformationImpact__Group__14152);
            rule__TransformationImpact__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationImpact__Group__2_in_rule__TransformationImpact__Group__14155);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2099:1: rule__TransformationImpact__Group__1__Impl : ( ( rule__TransformationImpact__Group_1__0 )? ) ;
    public final void rule__TransformationImpact__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2103:1: ( ( ( rule__TransformationImpact__Group_1__0 )? ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2104:1: ( ( rule__TransformationImpact__Group_1__0 )? )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2104:1: ( ( rule__TransformationImpact__Group_1__0 )? )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2105:1: ( rule__TransformationImpact__Group_1__0 )?
            {
             before(grammarAccess.getTransformationImpactAccess().getGroup_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2106:1: ( rule__TransformationImpact__Group_1__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=RULE_STRING && LA16_0<=RULE_ID)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2106:2: rule__TransformationImpact__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__TransformationImpact__Group_1__0_in_rule__TransformationImpact__Group__1__Impl4182);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2116:1: rule__TransformationImpact__Group__2 : rule__TransformationImpact__Group__2__Impl rule__TransformationImpact__Group__3 ;
    public final void rule__TransformationImpact__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2120:1: ( rule__TransformationImpact__Group__2__Impl rule__TransformationImpact__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2121:2: rule__TransformationImpact__Group__2__Impl rule__TransformationImpact__Group__3
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group__2__Impl_in_rule__TransformationImpact__Group__24213);
            rule__TransformationImpact__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationImpact__Group__3_in_rule__TransformationImpact__Group__24216);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2128:1: rule__TransformationImpact__Group__2__Impl : ( ( rule__TransformationImpact__ImpactValueAssignment_2 ) ) ;
    public final void rule__TransformationImpact__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2132:1: ( ( ( rule__TransformationImpact__ImpactValueAssignment_2 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2133:1: ( ( rule__TransformationImpact__ImpactValueAssignment_2 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2133:1: ( ( rule__TransformationImpact__ImpactValueAssignment_2 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2134:1: ( rule__TransformationImpact__ImpactValueAssignment_2 )
            {
             before(grammarAccess.getTransformationImpactAccess().getImpactValueAssignment_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2135:1: ( rule__TransformationImpact__ImpactValueAssignment_2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2135:2: rule__TransformationImpact__ImpactValueAssignment_2
            {
            pushFollow(FOLLOW_rule__TransformationImpact__ImpactValueAssignment_2_in_rule__TransformationImpact__Group__2__Impl4243);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2145:1: rule__TransformationImpact__Group__3 : rule__TransformationImpact__Group__3__Impl ;
    public final void rule__TransformationImpact__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2149:1: ( rule__TransformationImpact__Group__3__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2150:2: rule__TransformationImpact__Group__3__Impl
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group__3__Impl_in_rule__TransformationImpact__Group__34273);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2156:1: rule__TransformationImpact__Group__3__Impl : ( ')' ) ;
    public final void rule__TransformationImpact__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2160:1: ( ( ')' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2161:1: ( ')' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2161:1: ( ')' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2162:1: ')'
            {
             before(grammarAccess.getTransformationImpactAccess().getRightParenthesisKeyword_3()); 
            match(input,24,FOLLOW_24_in_rule__TransformationImpact__Group__3__Impl4301); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2183:1: rule__TransformationImpact__Group_1__0 : rule__TransformationImpact__Group_1__0__Impl rule__TransformationImpact__Group_1__1 ;
    public final void rule__TransformationImpact__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2187:1: ( rule__TransformationImpact__Group_1__0__Impl rule__TransformationImpact__Group_1__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2188:2: rule__TransformationImpact__Group_1__0__Impl rule__TransformationImpact__Group_1__1
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group_1__0__Impl_in_rule__TransformationImpact__Group_1__04340);
            rule__TransformationImpact__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationImpact__Group_1__1_in_rule__TransformationImpact__Group_1__04343);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2195:1: rule__TransformationImpact__Group_1__0__Impl : ( ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 ) ) ;
    public final void rule__TransformationImpact__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2199:1: ( ( ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2200:1: ( ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2200:1: ( ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2201:1: ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 )
            {
             before(grammarAccess.getTransformationImpactAccess().getQualityAttributeNameAssignment_1_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2202:1: ( rule__TransformationImpact__QualityAttributeNameAssignment_1_0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2202:2: rule__TransformationImpact__QualityAttributeNameAssignment_1_0
            {
            pushFollow(FOLLOW_rule__TransformationImpact__QualityAttributeNameAssignment_1_0_in_rule__TransformationImpact__Group_1__0__Impl4370);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2212:1: rule__TransformationImpact__Group_1__1 : rule__TransformationImpact__Group_1__1__Impl ;
    public final void rule__TransformationImpact__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2216:1: ( rule__TransformationImpact__Group_1__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2217:2: rule__TransformationImpact__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__TransformationImpact__Group_1__1__Impl_in_rule__TransformationImpact__Group_1__14400);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2223:1: rule__TransformationImpact__Group_1__1__Impl : ( ',' ) ;
    public final void rule__TransformationImpact__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2227:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2228:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2228:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2229:1: ','
            {
             before(grammarAccess.getTransformationImpactAccess().getCommaKeyword_1_1()); 
            match(input,19,FOLLOW_19_in_rule__TransformationImpact__Group_1__1__Impl4428); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2246:1: rule__TransformationDependencyList__Group__0 : rule__TransformationDependencyList__Group__0__Impl rule__TransformationDependencyList__Group__1 ;
    public final void rule__TransformationDependencyList__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2250:1: ( rule__TransformationDependencyList__Group__0__Impl rule__TransformationDependencyList__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2251:2: rule__TransformationDependencyList__Group__0__Impl rule__TransformationDependencyList__Group__1
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__0__Impl_in_rule__TransformationDependencyList__Group__04463);
            rule__TransformationDependencyList__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__1_in_rule__TransformationDependencyList__Group__04466);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2258:1: rule__TransformationDependencyList__Group__0__Impl : ( 'Dependencies' ) ;
    public final void rule__TransformationDependencyList__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2262:1: ( ( 'Dependencies' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2263:1: ( 'Dependencies' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2263:1: ( 'Dependencies' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2264:1: 'Dependencies'
            {
             before(grammarAccess.getTransformationDependencyListAccess().getDependenciesKeyword_0()); 
            match(input,25,FOLLOW_25_in_rule__TransformationDependencyList__Group__0__Impl4494); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2277:1: rule__TransformationDependencyList__Group__1 : rule__TransformationDependencyList__Group__1__Impl rule__TransformationDependencyList__Group__2 ;
    public final void rule__TransformationDependencyList__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2281:1: ( rule__TransformationDependencyList__Group__1__Impl rule__TransformationDependencyList__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2282:2: rule__TransformationDependencyList__Group__1__Impl rule__TransformationDependencyList__Group__2
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__1__Impl_in_rule__TransformationDependencyList__Group__14525);
            rule__TransformationDependencyList__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__2_in_rule__TransformationDependencyList__Group__14528);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2289:1: rule__TransformationDependencyList__Group__1__Impl : ( '{' ) ;
    public final void rule__TransformationDependencyList__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2293:1: ( ( '{' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2294:1: ( '{' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2294:1: ( '{' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2295:1: '{'
            {
             before(grammarAccess.getTransformationDependencyListAccess().getLeftCurlyBracketKeyword_1()); 
            match(input,14,FOLLOW_14_in_rule__TransformationDependencyList__Group__1__Impl4556); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2308:1: rule__TransformationDependencyList__Group__2 : rule__TransformationDependencyList__Group__2__Impl rule__TransformationDependencyList__Group__3 ;
    public final void rule__TransformationDependencyList__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2312:1: ( rule__TransformationDependencyList__Group__2__Impl rule__TransformationDependencyList__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2313:2: rule__TransformationDependencyList__Group__2__Impl rule__TransformationDependencyList__Group__3
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__2__Impl_in_rule__TransformationDependencyList__Group__24587);
            rule__TransformationDependencyList__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__3_in_rule__TransformationDependencyList__Group__24590);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2320:1: rule__TransformationDependencyList__Group__2__Impl : ( ( rule__TransformationDependencyList__NameAssignment_2 ) ) ;
    public final void rule__TransformationDependencyList__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2324:1: ( ( ( rule__TransformationDependencyList__NameAssignment_2 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2325:1: ( ( rule__TransformationDependencyList__NameAssignment_2 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2325:1: ( ( rule__TransformationDependencyList__NameAssignment_2 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2326:1: ( rule__TransformationDependencyList__NameAssignment_2 )
            {
             before(grammarAccess.getTransformationDependencyListAccess().getNameAssignment_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2327:1: ( rule__TransformationDependencyList__NameAssignment_2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2327:2: rule__TransformationDependencyList__NameAssignment_2
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__NameAssignment_2_in_rule__TransformationDependencyList__Group__2__Impl4617);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2337:1: rule__TransformationDependencyList__Group__3 : rule__TransformationDependencyList__Group__3__Impl rule__TransformationDependencyList__Group__4 ;
    public final void rule__TransformationDependencyList__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2341:1: ( rule__TransformationDependencyList__Group__3__Impl rule__TransformationDependencyList__Group__4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2342:2: rule__TransformationDependencyList__Group__3__Impl rule__TransformationDependencyList__Group__4
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__3__Impl_in_rule__TransformationDependencyList__Group__34647);
            rule__TransformationDependencyList__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__4_in_rule__TransformationDependencyList__Group__34650);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2349:1: rule__TransformationDependencyList__Group__3__Impl : ( '{' ) ;
    public final void rule__TransformationDependencyList__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2353:1: ( ( '{' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2354:1: ( '{' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2354:1: ( '{' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2355:1: '{'
            {
             before(grammarAccess.getTransformationDependencyListAccess().getLeftCurlyBracketKeyword_3()); 
            match(input,14,FOLLOW_14_in_rule__TransformationDependencyList__Group__3__Impl4678); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2368:1: rule__TransformationDependencyList__Group__4 : rule__TransformationDependencyList__Group__4__Impl rule__TransformationDependencyList__Group__5 ;
    public final void rule__TransformationDependencyList__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2372:1: ( rule__TransformationDependencyList__Group__4__Impl rule__TransformationDependencyList__Group__5 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2373:2: rule__TransformationDependencyList__Group__4__Impl rule__TransformationDependencyList__Group__5
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__4__Impl_in_rule__TransformationDependencyList__Group__44709);
            rule__TransformationDependencyList__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__5_in_rule__TransformationDependencyList__Group__44712);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2380:1: rule__TransformationDependencyList__Group__4__Impl : ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4 ) ) ;
    public final void rule__TransformationDependencyList__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2384:1: ( ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2385:1: ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2385:1: ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2386:1: ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4 )
            {
             before(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesAssignment_4()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2387:1: ( rule__TransformationDependencyList__TransformationDependenciesAssignment_4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2387:2: rule__TransformationDependencyList__TransformationDependenciesAssignment_4
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__TransformationDependenciesAssignment_4_in_rule__TransformationDependencyList__Group__4__Impl4739);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2397:1: rule__TransformationDependencyList__Group__5 : rule__TransformationDependencyList__Group__5__Impl rule__TransformationDependencyList__Group__6 ;
    public final void rule__TransformationDependencyList__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2401:1: ( rule__TransformationDependencyList__Group__5__Impl rule__TransformationDependencyList__Group__6 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2402:2: rule__TransformationDependencyList__Group__5__Impl rule__TransformationDependencyList__Group__6
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__5__Impl_in_rule__TransformationDependencyList__Group__54769);
            rule__TransformationDependencyList__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__6_in_rule__TransformationDependencyList__Group__54772);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2409:1: rule__TransformationDependencyList__Group__5__Impl : ( ( rule__TransformationDependencyList__Group_5__0 )* ) ;
    public final void rule__TransformationDependencyList__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2413:1: ( ( ( rule__TransformationDependencyList__Group_5__0 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2414:1: ( ( rule__TransformationDependencyList__Group_5__0 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2414:1: ( ( rule__TransformationDependencyList__Group_5__0 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2415:1: ( rule__TransformationDependencyList__Group_5__0 )*
            {
             before(grammarAccess.getTransformationDependencyListAccess().getGroup_5()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2416:1: ( rule__TransformationDependencyList__Group_5__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==16) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2416:2: rule__TransformationDependencyList__Group_5__0
            	    {
            	    pushFollow(FOLLOW_rule__TransformationDependencyList__Group_5__0_in_rule__TransformationDependencyList__Group__5__Impl4799);
            	    rule__TransformationDependencyList__Group_5__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2426:1: rule__TransformationDependencyList__Group__6 : rule__TransformationDependencyList__Group__6__Impl rule__TransformationDependencyList__Group__7 ;
    public final void rule__TransformationDependencyList__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2430:1: ( rule__TransformationDependencyList__Group__6__Impl rule__TransformationDependencyList__Group__7 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2431:2: rule__TransformationDependencyList__Group__6__Impl rule__TransformationDependencyList__Group__7
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__6__Impl_in_rule__TransformationDependencyList__Group__64830);
            rule__TransformationDependencyList__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__7_in_rule__TransformationDependencyList__Group__64833);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2438:1: rule__TransformationDependencyList__Group__6__Impl : ( '}' ) ;
    public final void rule__TransformationDependencyList__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2442:1: ( ( '}' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2443:1: ( '}' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2443:1: ( '}' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2444:1: '}'
            {
             before(grammarAccess.getTransformationDependencyListAccess().getRightCurlyBracketKeyword_6()); 
            match(input,15,FOLLOW_15_in_rule__TransformationDependencyList__Group__6__Impl4861); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2457:1: rule__TransformationDependencyList__Group__7 : rule__TransformationDependencyList__Group__7__Impl ;
    public final void rule__TransformationDependencyList__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2461:1: ( rule__TransformationDependencyList__Group__7__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2462:2: rule__TransformationDependencyList__Group__7__Impl
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group__7__Impl_in_rule__TransformationDependencyList__Group__74892);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2468:1: rule__TransformationDependencyList__Group__7__Impl : ( '}' ) ;
    public final void rule__TransformationDependencyList__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2472:1: ( ( '}' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2473:1: ( '}' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2473:1: ( '}' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2474:1: '}'
            {
             before(grammarAccess.getTransformationDependencyListAccess().getRightCurlyBracketKeyword_7()); 
            match(input,15,FOLLOW_15_in_rule__TransformationDependencyList__Group__7__Impl4920); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2503:1: rule__TransformationDependencyList__Group_5__0 : rule__TransformationDependencyList__Group_5__0__Impl rule__TransformationDependencyList__Group_5__1 ;
    public final void rule__TransformationDependencyList__Group_5__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2507:1: ( rule__TransformationDependencyList__Group_5__0__Impl rule__TransformationDependencyList__Group_5__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2508:2: rule__TransformationDependencyList__Group_5__0__Impl rule__TransformationDependencyList__Group_5__1
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group_5__0__Impl_in_rule__TransformationDependencyList__Group_5__04967);
            rule__TransformationDependencyList__Group_5__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependencyList__Group_5__1_in_rule__TransformationDependencyList__Group_5__04970);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2515:1: rule__TransformationDependencyList__Group_5__0__Impl : ( ';' ) ;
    public final void rule__TransformationDependencyList__Group_5__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2519:1: ( ( ';' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2520:1: ( ';' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2520:1: ( ';' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2521:1: ';'
            {
             before(grammarAccess.getTransformationDependencyListAccess().getSemicolonKeyword_5_0()); 
            match(input,16,FOLLOW_16_in_rule__TransformationDependencyList__Group_5__0__Impl4998); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2534:1: rule__TransformationDependencyList__Group_5__1 : rule__TransformationDependencyList__Group_5__1__Impl ;
    public final void rule__TransformationDependencyList__Group_5__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2538:1: ( rule__TransformationDependencyList__Group_5__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2539:2: rule__TransformationDependencyList__Group_5__1__Impl
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__Group_5__1__Impl_in_rule__TransformationDependencyList__Group_5__15029);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2545:1: rule__TransformationDependencyList__Group_5__1__Impl : ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1 ) ) ;
    public final void rule__TransformationDependencyList__Group_5__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2549:1: ( ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2550:1: ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2550:1: ( ( rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2551:1: ( rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1 )
            {
             before(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesAssignment_5_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2552:1: ( rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2552:2: rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1
            {
            pushFollow(FOLLOW_rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1_in_rule__TransformationDependencyList__Group_5__1__Impl5056);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2566:1: rule__TransformationDependency__Group__0 : rule__TransformationDependency__Group__0__Impl rule__TransformationDependency__Group__1 ;
    public final void rule__TransformationDependency__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2570:1: ( rule__TransformationDependency__Group__0__Impl rule__TransformationDependency__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2571:2: rule__TransformationDependency__Group__0__Impl rule__TransformationDependency__Group__1
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__0__Impl_in_rule__TransformationDependency__Group__05090);
            rule__TransformationDependency__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__1_in_rule__TransformationDependency__Group__05093);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2578:1: rule__TransformationDependency__Group__0__Impl : ( 'Apply' ) ;
    public final void rule__TransformationDependency__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2582:1: ( ( 'Apply' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2583:1: ( 'Apply' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2583:1: ( 'Apply' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2584:1: 'Apply'
            {
             before(grammarAccess.getTransformationDependencyAccess().getApplyKeyword_0()); 
            match(input,26,FOLLOW_26_in_rule__TransformationDependency__Group__0__Impl5121); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2597:1: rule__TransformationDependency__Group__1 : rule__TransformationDependency__Group__1__Impl rule__TransformationDependency__Group__2 ;
    public final void rule__TransformationDependency__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2601:1: ( rule__TransformationDependency__Group__1__Impl rule__TransformationDependency__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2602:2: rule__TransformationDependency__Group__1__Impl rule__TransformationDependency__Group__2
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__1__Impl_in_rule__TransformationDependency__Group__15152);
            rule__TransformationDependency__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__2_in_rule__TransformationDependency__Group__15155);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2609:1: rule__TransformationDependency__Group__1__Impl : ( '(' ) ;
    public final void rule__TransformationDependency__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2613:1: ( ( '(' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2614:1: ( '(' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2614:1: ( '(' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2615:1: '('
            {
             before(grammarAccess.getTransformationDependencyAccess().getLeftParenthesisKeyword_1()); 
            match(input,23,FOLLOW_23_in_rule__TransformationDependency__Group__1__Impl5183); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2628:1: rule__TransformationDependency__Group__2 : rule__TransformationDependency__Group__2__Impl rule__TransformationDependency__Group__3 ;
    public final void rule__TransformationDependency__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2632:1: ( rule__TransformationDependency__Group__2__Impl rule__TransformationDependency__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2633:2: rule__TransformationDependency__Group__2__Impl rule__TransformationDependency__Group__3
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__2__Impl_in_rule__TransformationDependency__Group__25214);
            rule__TransformationDependency__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__3_in_rule__TransformationDependency__Group__25217);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2640:1: rule__TransformationDependency__Group__2__Impl : ( ( rule__TransformationDependency__AppliedTransformationAssignment_2 ) ) ;
    public final void rule__TransformationDependency__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2644:1: ( ( ( rule__TransformationDependency__AppliedTransformationAssignment_2 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2645:1: ( ( rule__TransformationDependency__AppliedTransformationAssignment_2 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2645:1: ( ( rule__TransformationDependency__AppliedTransformationAssignment_2 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2646:1: ( rule__TransformationDependency__AppliedTransformationAssignment_2 )
            {
             before(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationAssignment_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2647:1: ( rule__TransformationDependency__AppliedTransformationAssignment_2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2647:2: rule__TransformationDependency__AppliedTransformationAssignment_2
            {
            pushFollow(FOLLOW_rule__TransformationDependency__AppliedTransformationAssignment_2_in_rule__TransformationDependency__Group__2__Impl5244);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2657:1: rule__TransformationDependency__Group__3 : rule__TransformationDependency__Group__3__Impl rule__TransformationDependency__Group__4 ;
    public final void rule__TransformationDependency__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2661:1: ( rule__TransformationDependency__Group__3__Impl rule__TransformationDependency__Group__4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2662:2: rule__TransformationDependency__Group__3__Impl rule__TransformationDependency__Group__4
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__3__Impl_in_rule__TransformationDependency__Group__35274);
            rule__TransformationDependency__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__4_in_rule__TransformationDependency__Group__35277);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2669:1: rule__TransformationDependency__Group__3__Impl : ( '.' ) ;
    public final void rule__TransformationDependency__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2673:1: ( ( '.' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2674:1: ( '.' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2674:1: ( '.' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2675:1: '.'
            {
             before(grammarAccess.getTransformationDependencyAccess().getFullStopKeyword_3()); 
            match(input,17,FOLLOW_17_in_rule__TransformationDependency__Group__3__Impl5305); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2688:1: rule__TransformationDependency__Group__4 : rule__TransformationDependency__Group__4__Impl rule__TransformationDependency__Group__5 ;
    public final void rule__TransformationDependency__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2692:1: ( rule__TransformationDependency__Group__4__Impl rule__TransformationDependency__Group__5 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2693:2: rule__TransformationDependency__Group__4__Impl rule__TransformationDependency__Group__5
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__4__Impl_in_rule__TransformationDependency__Group__45336);
            rule__TransformationDependency__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__5_in_rule__TransformationDependency__Group__45339);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2700:1: rule__TransformationDependency__Group__4__Impl : ( ( rule__TransformationDependency__AppliedRuleAssignment_4 ) ) ;
    public final void rule__TransformationDependency__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2704:1: ( ( ( rule__TransformationDependency__AppliedRuleAssignment_4 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2705:1: ( ( rule__TransformationDependency__AppliedRuleAssignment_4 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2705:1: ( ( rule__TransformationDependency__AppliedRuleAssignment_4 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2706:1: ( rule__TransformationDependency__AppliedRuleAssignment_4 )
            {
             before(grammarAccess.getTransformationDependencyAccess().getAppliedRuleAssignment_4()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2707:1: ( rule__TransformationDependency__AppliedRuleAssignment_4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2707:2: rule__TransformationDependency__AppliedRuleAssignment_4
            {
            pushFollow(FOLLOW_rule__TransformationDependency__AppliedRuleAssignment_4_in_rule__TransformationDependency__Group__4__Impl5366);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2717:1: rule__TransformationDependency__Group__5 : rule__TransformationDependency__Group__5__Impl rule__TransformationDependency__Group__6 ;
    public final void rule__TransformationDependency__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2721:1: ( rule__TransformationDependency__Group__5__Impl rule__TransformationDependency__Group__6 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2722:2: rule__TransformationDependency__Group__5__Impl rule__TransformationDependency__Group__6
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__5__Impl_in_rule__TransformationDependency__Group__55396);
            rule__TransformationDependency__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__6_in_rule__TransformationDependency__Group__55399);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2729:1: rule__TransformationDependency__Group__5__Impl : ( ',' ) ;
    public final void rule__TransformationDependency__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2733:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2734:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2734:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2735:1: ','
            {
             before(grammarAccess.getTransformationDependencyAccess().getCommaKeyword_5()); 
            match(input,19,FOLLOW_19_in_rule__TransformationDependency__Group__5__Impl5427); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2748:1: rule__TransformationDependency__Group__6 : rule__TransformationDependency__Group__6__Impl rule__TransformationDependency__Group__7 ;
    public final void rule__TransformationDependency__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2752:1: ( rule__TransformationDependency__Group__6__Impl rule__TransformationDependency__Group__7 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2753:2: rule__TransformationDependency__Group__6__Impl rule__TransformationDependency__Group__7
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__6__Impl_in_rule__TransformationDependency__Group__65458);
            rule__TransformationDependency__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__7_in_rule__TransformationDependency__Group__65461);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2760:1: rule__TransformationDependency__Group__6__Impl : ( '{' ) ;
    public final void rule__TransformationDependency__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2764:1: ( ( '{' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2765:1: ( '{' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2765:1: ( '{' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2766:1: '{'
            {
             before(grammarAccess.getTransformationDependencyAccess().getLeftCurlyBracketKeyword_6()); 
            match(input,14,FOLLOW_14_in_rule__TransformationDependency__Group__6__Impl5489); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2779:1: rule__TransformationDependency__Group__7 : rule__TransformationDependency__Group__7__Impl rule__TransformationDependency__Group__8 ;
    public final void rule__TransformationDependency__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2783:1: ( rule__TransformationDependency__Group__7__Impl rule__TransformationDependency__Group__8 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2784:2: rule__TransformationDependency__Group__7__Impl rule__TransformationDependency__Group__8
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__7__Impl_in_rule__TransformationDependency__Group__75520);
            rule__TransformationDependency__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__8_in_rule__TransformationDependency__Group__75523);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2791:1: rule__TransformationDependency__Group__7__Impl : ( ( rule__TransformationDependency__FieldsAssignment_7 ) ) ;
    public final void rule__TransformationDependency__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2795:1: ( ( ( rule__TransformationDependency__FieldsAssignment_7 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2796:1: ( ( rule__TransformationDependency__FieldsAssignment_7 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2796:1: ( ( rule__TransformationDependency__FieldsAssignment_7 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2797:1: ( rule__TransformationDependency__FieldsAssignment_7 )
            {
             before(grammarAccess.getTransformationDependencyAccess().getFieldsAssignment_7()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2798:1: ( rule__TransformationDependency__FieldsAssignment_7 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2798:2: rule__TransformationDependency__FieldsAssignment_7
            {
            pushFollow(FOLLOW_rule__TransformationDependency__FieldsAssignment_7_in_rule__TransformationDependency__Group__7__Impl5550);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2808:1: rule__TransformationDependency__Group__8 : rule__TransformationDependency__Group__8__Impl rule__TransformationDependency__Group__9 ;
    public final void rule__TransformationDependency__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2812:1: ( rule__TransformationDependency__Group__8__Impl rule__TransformationDependency__Group__9 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2813:2: rule__TransformationDependency__Group__8__Impl rule__TransformationDependency__Group__9
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__8__Impl_in_rule__TransformationDependency__Group__85580);
            rule__TransformationDependency__Group__8__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__9_in_rule__TransformationDependency__Group__85583);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2820:1: rule__TransformationDependency__Group__8__Impl : ( ( rule__TransformationDependency__Group_8__0 )* ) ;
    public final void rule__TransformationDependency__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2824:1: ( ( ( rule__TransformationDependency__Group_8__0 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2825:1: ( ( rule__TransformationDependency__Group_8__0 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2825:1: ( ( rule__TransformationDependency__Group_8__0 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2826:1: ( rule__TransformationDependency__Group_8__0 )*
            {
             before(grammarAccess.getTransformationDependencyAccess().getGroup_8()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2827:1: ( rule__TransformationDependency__Group_8__0 )*
            loop18:
            do {
                int alt18=2;
                int LA18_0 = input.LA(1);

                if ( (LA18_0==19) ) {
                    alt18=1;
                }


                switch (alt18) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2827:2: rule__TransformationDependency__Group_8__0
            	    {
            	    pushFollow(FOLLOW_rule__TransformationDependency__Group_8__0_in_rule__TransformationDependency__Group__8__Impl5610);
            	    rule__TransformationDependency__Group_8__0();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop18;
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2837:1: rule__TransformationDependency__Group__9 : rule__TransformationDependency__Group__9__Impl rule__TransformationDependency__Group__10 ;
    public final void rule__TransformationDependency__Group__9() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2841:1: ( rule__TransformationDependency__Group__9__Impl rule__TransformationDependency__Group__10 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2842:2: rule__TransformationDependency__Group__9__Impl rule__TransformationDependency__Group__10
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__9__Impl_in_rule__TransformationDependency__Group__95641);
            rule__TransformationDependency__Group__9__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__10_in_rule__TransformationDependency__Group__95644);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2849:1: rule__TransformationDependency__Group__9__Impl : ( '}' ) ;
    public final void rule__TransformationDependency__Group__9__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2853:1: ( ( '}' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2854:1: ( '}' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2854:1: ( '}' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2855:1: '}'
            {
             before(grammarAccess.getTransformationDependencyAccess().getRightCurlyBracketKeyword_9()); 
            match(input,15,FOLLOW_15_in_rule__TransformationDependency__Group__9__Impl5672); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2868:1: rule__TransformationDependency__Group__10 : rule__TransformationDependency__Group__10__Impl rule__TransformationDependency__Group__11 ;
    public final void rule__TransformationDependency__Group__10() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2872:1: ( rule__TransformationDependency__Group__10__Impl rule__TransformationDependency__Group__11 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2873:2: rule__TransformationDependency__Group__10__Impl rule__TransformationDependency__Group__11
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__10__Impl_in_rule__TransformationDependency__Group__105703);
            rule__TransformationDependency__Group__10__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__11_in_rule__TransformationDependency__Group__105706);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2880:1: rule__TransformationDependency__Group__10__Impl : ( ')' ) ;
    public final void rule__TransformationDependency__Group__10__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2884:1: ( ( ')' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2885:1: ( ')' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2885:1: ( ')' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2886:1: ')'
            {
             before(grammarAccess.getTransformationDependencyAccess().getRightParenthesisKeyword_10()); 
            match(input,24,FOLLOW_24_in_rule__TransformationDependency__Group__10__Impl5734); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2899:1: rule__TransformationDependency__Group__11 : rule__TransformationDependency__Group__11__Impl rule__TransformationDependency__Group__12 ;
    public final void rule__TransformationDependency__Group__11() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2903:1: ( rule__TransformationDependency__Group__11__Impl rule__TransformationDependency__Group__12 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2904:2: rule__TransformationDependency__Group__11__Impl rule__TransformationDependency__Group__12
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__11__Impl_in_rule__TransformationDependency__Group__115765);
            rule__TransformationDependency__Group__11__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__12_in_rule__TransformationDependency__Group__115768);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2911:1: rule__TransformationDependency__Group__11__Impl : ( '[' ) ;
    public final void rule__TransformationDependency__Group__11__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2915:1: ( ( '[' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2916:1: ( '[' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2916:1: ( '[' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2917:1: '['
            {
             before(grammarAccess.getTransformationDependencyAccess().getLeftSquareBracketKeyword_11()); 
            match(input,27,FOLLOW_27_in_rule__TransformationDependency__Group__11__Impl5796); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2930:1: rule__TransformationDependency__Group__12 : rule__TransformationDependency__Group__12__Impl rule__TransformationDependency__Group__13 ;
    public final void rule__TransformationDependency__Group__12() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2934:1: ( rule__TransformationDependency__Group__12__Impl rule__TransformationDependency__Group__13 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2935:2: rule__TransformationDependency__Group__12__Impl rule__TransformationDependency__Group__13
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__12__Impl_in_rule__TransformationDependency__Group__125827);
            rule__TransformationDependency__Group__12__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group__13_in_rule__TransformationDependency__Group__125830);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2942:1: rule__TransformationDependency__Group__12__Impl : ( ( rule__TransformationDependency__Alternatives_12 ) ) ;
    public final void rule__TransformationDependency__Group__12__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2946:1: ( ( ( rule__TransformationDependency__Alternatives_12 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2947:1: ( ( rule__TransformationDependency__Alternatives_12 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2947:1: ( ( rule__TransformationDependency__Alternatives_12 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2948:1: ( rule__TransformationDependency__Alternatives_12 )
            {
             before(grammarAccess.getTransformationDependencyAccess().getAlternatives_12()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2949:1: ( rule__TransformationDependency__Alternatives_12 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2949:2: rule__TransformationDependency__Alternatives_12
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Alternatives_12_in_rule__TransformationDependency__Group__12__Impl5857);
            rule__TransformationDependency__Alternatives_12();

            state._fsp--;


            }

             after(grammarAccess.getTransformationDependencyAccess().getAlternatives_12()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2959:1: rule__TransformationDependency__Group__13 : rule__TransformationDependency__Group__13__Impl ;
    public final void rule__TransformationDependency__Group__13() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2963:1: ( rule__TransformationDependency__Group__13__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2964:2: rule__TransformationDependency__Group__13__Impl
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group__13__Impl_in_rule__TransformationDependency__Group__135887);
            rule__TransformationDependency__Group__13__Impl();

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2970:1: rule__TransformationDependency__Group__13__Impl : ( ']' ) ;
    public final void rule__TransformationDependency__Group__13__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2974:1: ( ( ']' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2975:1: ( ']' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2975:1: ( ']' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:2976:1: ']'
            {
             before(grammarAccess.getTransformationDependencyAccess().getRightSquareBracketKeyword_13()); 
            match(input,28,FOLLOW_28_in_rule__TransformationDependency__Group__13__Impl5915); 
             after(grammarAccess.getTransformationDependencyAccess().getRightSquareBracketKeyword_13()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3017:1: rule__TransformationDependency__Group_8__0 : rule__TransformationDependency__Group_8__0__Impl rule__TransformationDependency__Group_8__1 ;
    public final void rule__TransformationDependency__Group_8__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3021:1: ( rule__TransformationDependency__Group_8__0__Impl rule__TransformationDependency__Group_8__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3022:2: rule__TransformationDependency__Group_8__0__Impl rule__TransformationDependency__Group_8__1
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group_8__0__Impl_in_rule__TransformationDependency__Group_8__05974);
            rule__TransformationDependency__Group_8__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group_8__1_in_rule__TransformationDependency__Group_8__05977);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3029:1: rule__TransformationDependency__Group_8__0__Impl : ( ',' ) ;
    public final void rule__TransformationDependency__Group_8__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3033:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3034:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3034:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3035:1: ','
            {
             before(grammarAccess.getTransformationDependencyAccess().getCommaKeyword_8_0()); 
            match(input,19,FOLLOW_19_in_rule__TransformationDependency__Group_8__0__Impl6005); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3048:1: rule__TransformationDependency__Group_8__1 : rule__TransformationDependency__Group_8__1__Impl ;
    public final void rule__TransformationDependency__Group_8__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3052:1: ( rule__TransformationDependency__Group_8__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3053:2: rule__TransformationDependency__Group_8__1__Impl
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group_8__1__Impl_in_rule__TransformationDependency__Group_8__16036);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3059:1: rule__TransformationDependency__Group_8__1__Impl : ( ( rule__TransformationDependency__FieldsAssignment_8_1 ) ) ;
    public final void rule__TransformationDependency__Group_8__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3063:1: ( ( ( rule__TransformationDependency__FieldsAssignment_8_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3064:1: ( ( rule__TransformationDependency__FieldsAssignment_8_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3064:1: ( ( rule__TransformationDependency__FieldsAssignment_8_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3065:1: ( rule__TransformationDependency__FieldsAssignment_8_1 )
            {
             before(grammarAccess.getTransformationDependencyAccess().getFieldsAssignment_8_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3066:1: ( rule__TransformationDependency__FieldsAssignment_8_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3066:2: rule__TransformationDependency__FieldsAssignment_8_1
            {
            pushFollow(FOLLOW_rule__TransformationDependency__FieldsAssignment_8_1_in_rule__TransformationDependency__Group_8__1__Impl6063);
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


    // $ANTLR start "rule__TransformationDependency__Group_12_0__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3080:1: rule__TransformationDependency__Group_12_0__0 : rule__TransformationDependency__Group_12_0__0__Impl rule__TransformationDependency__Group_12_0__1 ;
    public final void rule__TransformationDependency__Group_12_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3084:1: ( rule__TransformationDependency__Group_12_0__0__Impl rule__TransformationDependency__Group_12_0__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3085:2: rule__TransformationDependency__Group_12_0__0__Impl rule__TransformationDependency__Group_12_0__1
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group_12_0__0__Impl_in_rule__TransformationDependency__Group_12_0__06097);
            rule__TransformationDependency__Group_12_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group_12_0__1_in_rule__TransformationDependency__Group_12_0__06100);
            rule__TransformationDependency__Group_12_0__1();

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
    // $ANTLR end "rule__TransformationDependency__Group_12_0__0"


    // $ANTLR start "rule__TransformationDependency__Group_12_0__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3092:1: rule__TransformationDependency__Group_12_0__0__Impl : ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12_0_0 ) ) ;
    public final void rule__TransformationDependency__Group_12_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3096:1: ( ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12_0_0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3097:1: ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12_0_0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3097:1: ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12_0_0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3098:1: ( rule__TransformationDependency__RequiredTransformationsAssignment_12_0_0 )
            {
             before(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAssignment_12_0_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3099:1: ( rule__TransformationDependency__RequiredTransformationsAssignment_12_0_0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3099:2: rule__TransformationDependency__RequiredTransformationsAssignment_12_0_0
            {
            pushFollow(FOLLOW_rule__TransformationDependency__RequiredTransformationsAssignment_12_0_0_in_rule__TransformationDependency__Group_12_0__0__Impl6127);
            rule__TransformationDependency__RequiredTransformationsAssignment_12_0_0();

            state._fsp--;


            }

             after(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAssignment_12_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group_12_0__0__Impl"


    // $ANTLR start "rule__TransformationDependency__Group_12_0__1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3109:1: rule__TransformationDependency__Group_12_0__1 : rule__TransformationDependency__Group_12_0__1__Impl rule__TransformationDependency__Group_12_0__2 ;
    public final void rule__TransformationDependency__Group_12_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3113:1: ( rule__TransformationDependency__Group_12_0__1__Impl rule__TransformationDependency__Group_12_0__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3114:2: rule__TransformationDependency__Group_12_0__1__Impl rule__TransformationDependency__Group_12_0__2
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group_12_0__1__Impl_in_rule__TransformationDependency__Group_12_0__16157);
            rule__TransformationDependency__Group_12_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group_12_0__2_in_rule__TransformationDependency__Group_12_0__16160);
            rule__TransformationDependency__Group_12_0__2();

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
    // $ANTLR end "rule__TransformationDependency__Group_12_0__1"


    // $ANTLR start "rule__TransformationDependency__Group_12_0__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3121:1: rule__TransformationDependency__Group_12_0__1__Impl : ( 'and' ) ;
    public final void rule__TransformationDependency__Group_12_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3125:1: ( ( 'and' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3126:1: ( 'and' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3126:1: ( 'and' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3127:1: 'and'
            {
             before(grammarAccess.getTransformationDependencyAccess().getAndKeyword_12_0_1()); 
            match(input,11,FOLLOW_11_in_rule__TransformationDependency__Group_12_0__1__Impl6188); 
             after(grammarAccess.getTransformationDependencyAccess().getAndKeyword_12_0_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group_12_0__1__Impl"


    // $ANTLR start "rule__TransformationDependency__Group_12_0__2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3140:1: rule__TransformationDependency__Group_12_0__2 : rule__TransformationDependency__Group_12_0__2__Impl ;
    public final void rule__TransformationDependency__Group_12_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3144:1: ( rule__TransformationDependency__Group_12_0__2__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3145:2: rule__TransformationDependency__Group_12_0__2__Impl
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group_12_0__2__Impl_in_rule__TransformationDependency__Group_12_0__26219);
            rule__TransformationDependency__Group_12_0__2__Impl();

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
    // $ANTLR end "rule__TransformationDependency__Group_12_0__2"


    // $ANTLR start "rule__TransformationDependency__Group_12_0__2__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3151:1: rule__TransformationDependency__Group_12_0__2__Impl : ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12_0_2 )* ) ;
    public final void rule__TransformationDependency__Group_12_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3155:1: ( ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12_0_2 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3156:1: ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12_0_2 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3156:1: ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12_0_2 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3157:1: ( rule__TransformationDependency__RequiredTransformationsAssignment_12_0_2 )*
            {
             before(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAssignment_12_0_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3158:1: ( rule__TransformationDependency__RequiredTransformationsAssignment_12_0_2 )*
            loop19:
            do {
                int alt19=2;
                int LA19_0 = input.LA(1);

                if ( ((LA19_0>=29 && LA19_0<=30)) ) {
                    alt19=1;
                }


                switch (alt19) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3158:2: rule__TransformationDependency__RequiredTransformationsAssignment_12_0_2
            	    {
            	    pushFollow(FOLLOW_rule__TransformationDependency__RequiredTransformationsAssignment_12_0_2_in_rule__TransformationDependency__Group_12_0__2__Impl6246);
            	    rule__TransformationDependency__RequiredTransformationsAssignment_12_0_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop19;
                }
            } while (true);

             after(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAssignment_12_0_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group_12_0__2__Impl"


    // $ANTLR start "rule__TransformationDependency__Group_12_1__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3174:1: rule__TransformationDependency__Group_12_1__0 : rule__TransformationDependency__Group_12_1__0__Impl rule__TransformationDependency__Group_12_1__1 ;
    public final void rule__TransformationDependency__Group_12_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3178:1: ( rule__TransformationDependency__Group_12_1__0__Impl rule__TransformationDependency__Group_12_1__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3179:2: rule__TransformationDependency__Group_12_1__0__Impl rule__TransformationDependency__Group_12_1__1
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group_12_1__0__Impl_in_rule__TransformationDependency__Group_12_1__06283);
            rule__TransformationDependency__Group_12_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group_12_1__1_in_rule__TransformationDependency__Group_12_1__06286);
            rule__TransformationDependency__Group_12_1__1();

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
    // $ANTLR end "rule__TransformationDependency__Group_12_1__0"


    // $ANTLR start "rule__TransformationDependency__Group_12_1__0__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3186:1: rule__TransformationDependency__Group_12_1__0__Impl : ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12_1_0 ) ) ;
    public final void rule__TransformationDependency__Group_12_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3190:1: ( ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12_1_0 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3191:1: ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12_1_0 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3191:1: ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12_1_0 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3192:1: ( rule__TransformationDependency__RequiredTransformationsAssignment_12_1_0 )
            {
             before(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAssignment_12_1_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3193:1: ( rule__TransformationDependency__RequiredTransformationsAssignment_12_1_0 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3193:2: rule__TransformationDependency__RequiredTransformationsAssignment_12_1_0
            {
            pushFollow(FOLLOW_rule__TransformationDependency__RequiredTransformationsAssignment_12_1_0_in_rule__TransformationDependency__Group_12_1__0__Impl6313);
            rule__TransformationDependency__RequiredTransformationsAssignment_12_1_0();

            state._fsp--;


            }

             after(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAssignment_12_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group_12_1__0__Impl"


    // $ANTLR start "rule__TransformationDependency__Group_12_1__1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3203:1: rule__TransformationDependency__Group_12_1__1 : rule__TransformationDependency__Group_12_1__1__Impl rule__TransformationDependency__Group_12_1__2 ;
    public final void rule__TransformationDependency__Group_12_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3207:1: ( rule__TransformationDependency__Group_12_1__1__Impl rule__TransformationDependency__Group_12_1__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3208:2: rule__TransformationDependency__Group_12_1__1__Impl rule__TransformationDependency__Group_12_1__2
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group_12_1__1__Impl_in_rule__TransformationDependency__Group_12_1__16343);
            rule__TransformationDependency__Group_12_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__TransformationDependency__Group_12_1__2_in_rule__TransformationDependency__Group_12_1__16346);
            rule__TransformationDependency__Group_12_1__2();

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
    // $ANTLR end "rule__TransformationDependency__Group_12_1__1"


    // $ANTLR start "rule__TransformationDependency__Group_12_1__1__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3215:1: rule__TransformationDependency__Group_12_1__1__Impl : ( 'or' ) ;
    public final void rule__TransformationDependency__Group_12_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3219:1: ( ( 'or' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3220:1: ( 'or' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3220:1: ( 'or' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3221:1: 'or'
            {
             before(grammarAccess.getTransformationDependencyAccess().getOrKeyword_12_1_1()); 
            match(input,12,FOLLOW_12_in_rule__TransformationDependency__Group_12_1__1__Impl6374); 
             after(grammarAccess.getTransformationDependencyAccess().getOrKeyword_12_1_1()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group_12_1__1__Impl"


    // $ANTLR start "rule__TransformationDependency__Group_12_1__2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3234:1: rule__TransformationDependency__Group_12_1__2 : rule__TransformationDependency__Group_12_1__2__Impl ;
    public final void rule__TransformationDependency__Group_12_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3238:1: ( rule__TransformationDependency__Group_12_1__2__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3239:2: rule__TransformationDependency__Group_12_1__2__Impl
            {
            pushFollow(FOLLOW_rule__TransformationDependency__Group_12_1__2__Impl_in_rule__TransformationDependency__Group_12_1__26405);
            rule__TransformationDependency__Group_12_1__2__Impl();

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
    // $ANTLR end "rule__TransformationDependency__Group_12_1__2"


    // $ANTLR start "rule__TransformationDependency__Group_12_1__2__Impl"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3245:1: rule__TransformationDependency__Group_12_1__2__Impl : ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12_1_2 )* ) ;
    public final void rule__TransformationDependency__Group_12_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3249:1: ( ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12_1_2 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3250:1: ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12_1_2 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3250:1: ( ( rule__TransformationDependency__RequiredTransformationsAssignment_12_1_2 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3251:1: ( rule__TransformationDependency__RequiredTransformationsAssignment_12_1_2 )*
            {
             before(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAssignment_12_1_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3252:1: ( rule__TransformationDependency__RequiredTransformationsAssignment_12_1_2 )*
            loop20:
            do {
                int alt20=2;
                int LA20_0 = input.LA(1);

                if ( ((LA20_0>=29 && LA20_0<=30)) ) {
                    alt20=1;
                }


                switch (alt20) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3252:2: rule__TransformationDependency__RequiredTransformationsAssignment_12_1_2
            	    {
            	    pushFollow(FOLLOW_rule__TransformationDependency__RequiredTransformationsAssignment_12_1_2_in_rule__TransformationDependency__Group_12_1__2__Impl6432);
            	    rule__TransformationDependency__RequiredTransformationsAssignment_12_1_2();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop20;
                }
            } while (true);

             after(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAssignment_12_1_2()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__Group_12_1__2__Impl"


    // $ANTLR start "rule__RuleDependency__Group_0__0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3268:1: rule__RuleDependency__Group_0__0 : rule__RuleDependency__Group_0__0__Impl rule__RuleDependency__Group_0__1 ;
    public final void rule__RuleDependency__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3272:1: ( rule__RuleDependency__Group_0__0__Impl rule__RuleDependency__Group_0__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3273:2: rule__RuleDependency__Group_0__0__Impl rule__RuleDependency__Group_0__1
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_0__0__Impl_in_rule__RuleDependency__Group_0__06469);
            rule__RuleDependency__Group_0__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDependency__Group_0__1_in_rule__RuleDependency__Group_0__06472);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3280:1: rule__RuleDependency__Group_0__0__Impl : ( 'requires' ) ;
    public final void rule__RuleDependency__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3284:1: ( ( 'requires' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3285:1: ( 'requires' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3285:1: ( 'requires' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3286:1: 'requires'
            {
             before(grammarAccess.getRuleDependencyAccess().getRequiresKeyword_0_0()); 
            match(input,29,FOLLOW_29_in_rule__RuleDependency__Group_0__0__Impl6500); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3299:1: rule__RuleDependency__Group_0__1 : rule__RuleDependency__Group_0__1__Impl rule__RuleDependency__Group_0__2 ;
    public final void rule__RuleDependency__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3303:1: ( rule__RuleDependency__Group_0__1__Impl rule__RuleDependency__Group_0__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3304:2: rule__RuleDependency__Group_0__1__Impl rule__RuleDependency__Group_0__2
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_0__1__Impl_in_rule__RuleDependency__Group_0__16531);
            rule__RuleDependency__Group_0__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDependency__Group_0__2_in_rule__RuleDependency__Group_0__16534);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3311:1: rule__RuleDependency__Group_0__1__Impl : ( ( rule__RuleDependency__RdAssignment_0_1 ) ) ;
    public final void rule__RuleDependency__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3315:1: ( ( ( rule__RuleDependency__RdAssignment_0_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3316:1: ( ( rule__RuleDependency__RdAssignment_0_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3316:1: ( ( rule__RuleDependency__RdAssignment_0_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3317:1: ( rule__RuleDependency__RdAssignment_0_1 )
            {
             before(grammarAccess.getRuleDependencyAccess().getRdAssignment_0_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3318:1: ( rule__RuleDependency__RdAssignment_0_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3318:2: rule__RuleDependency__RdAssignment_0_1
            {
            pushFollow(FOLLOW_rule__RuleDependency__RdAssignment_0_1_in_rule__RuleDependency__Group_0__1__Impl6561);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3328:1: rule__RuleDependency__Group_0__2 : rule__RuleDependency__Group_0__2__Impl rule__RuleDependency__Group_0__3 ;
    public final void rule__RuleDependency__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3332:1: ( rule__RuleDependency__Group_0__2__Impl rule__RuleDependency__Group_0__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3333:2: rule__RuleDependency__Group_0__2__Impl rule__RuleDependency__Group_0__3
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_0__2__Impl_in_rule__RuleDependency__Group_0__26591);
            rule__RuleDependency__Group_0__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDependency__Group_0__3_in_rule__RuleDependency__Group_0__26594);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3340:1: rule__RuleDependency__Group_0__2__Impl : ( ( rule__RuleDependency__Alternatives_0_2 )? ) ;
    public final void rule__RuleDependency__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3344:1: ( ( ( rule__RuleDependency__Alternatives_0_2 )? ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3345:1: ( ( rule__RuleDependency__Alternatives_0_2 )? )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3345:1: ( ( rule__RuleDependency__Alternatives_0_2 )? )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3346:1: ( rule__RuleDependency__Alternatives_0_2 )?
            {
             before(grammarAccess.getRuleDependencyAccess().getAlternatives_0_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3347:1: ( rule__RuleDependency__Alternatives_0_2 )?
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
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3347:2: rule__RuleDependency__Alternatives_0_2
                    {
                    pushFollow(FOLLOW_rule__RuleDependency__Alternatives_0_2_in_rule__RuleDependency__Group_0__2__Impl6621);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3357:1: rule__RuleDependency__Group_0__3 : rule__RuleDependency__Group_0__3__Impl ;
    public final void rule__RuleDependency__Group_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3361:1: ( rule__RuleDependency__Group_0__3__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3362:2: rule__RuleDependency__Group_0__3__Impl
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_0__3__Impl_in_rule__RuleDependency__Group_0__36652);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3368:1: rule__RuleDependency__Group_0__3__Impl : ( ( rule__RuleDependency__RdAssignment_0_3 )* ) ;
    public final void rule__RuleDependency__Group_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3372:1: ( ( ( rule__RuleDependency__RdAssignment_0_3 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3373:1: ( ( rule__RuleDependency__RdAssignment_0_3 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3373:1: ( ( rule__RuleDependency__RdAssignment_0_3 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3374:1: ( rule__RuleDependency__RdAssignment_0_3 )*
            {
             before(grammarAccess.getRuleDependencyAccess().getRdAssignment_0_3()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3375:1: ( rule__RuleDependency__RdAssignment_0_3 )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==23) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3375:2: rule__RuleDependency__RdAssignment_0_3
            	    {
            	    pushFollow(FOLLOW_rule__RuleDependency__RdAssignment_0_3_in_rule__RuleDependency__Group_0__3__Impl6679);
            	    rule__RuleDependency__RdAssignment_0_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop22;
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3393:1: rule__RuleDependency__Group_1__0 : rule__RuleDependency__Group_1__0__Impl rule__RuleDependency__Group_1__1 ;
    public final void rule__RuleDependency__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3397:1: ( rule__RuleDependency__Group_1__0__Impl rule__RuleDependency__Group_1__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3398:2: rule__RuleDependency__Group_1__0__Impl rule__RuleDependency__Group_1__1
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_1__0__Impl_in_rule__RuleDependency__Group_1__06718);
            rule__RuleDependency__Group_1__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDependency__Group_1__1_in_rule__RuleDependency__Group_1__06721);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3405:1: rule__RuleDependency__Group_1__0__Impl : ( 'excludes' ) ;
    public final void rule__RuleDependency__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3409:1: ( ( 'excludes' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3410:1: ( 'excludes' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3410:1: ( 'excludes' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3411:1: 'excludes'
            {
             before(grammarAccess.getRuleDependencyAccess().getExcludesKeyword_1_0()); 
            match(input,30,FOLLOW_30_in_rule__RuleDependency__Group_1__0__Impl6749); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3424:1: rule__RuleDependency__Group_1__1 : rule__RuleDependency__Group_1__1__Impl rule__RuleDependency__Group_1__2 ;
    public final void rule__RuleDependency__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3428:1: ( rule__RuleDependency__Group_1__1__Impl rule__RuleDependency__Group_1__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3429:2: rule__RuleDependency__Group_1__1__Impl rule__RuleDependency__Group_1__2
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_1__1__Impl_in_rule__RuleDependency__Group_1__16780);
            rule__RuleDependency__Group_1__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDependency__Group_1__2_in_rule__RuleDependency__Group_1__16783);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3436:1: rule__RuleDependency__Group_1__1__Impl : ( ( rule__RuleDependency__RdAssignment_1_1 ) ) ;
    public final void rule__RuleDependency__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3440:1: ( ( ( rule__RuleDependency__RdAssignment_1_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3441:1: ( ( rule__RuleDependency__RdAssignment_1_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3441:1: ( ( rule__RuleDependency__RdAssignment_1_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3442:1: ( rule__RuleDependency__RdAssignment_1_1 )
            {
             before(grammarAccess.getRuleDependencyAccess().getRdAssignment_1_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3443:1: ( rule__RuleDependency__RdAssignment_1_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3443:2: rule__RuleDependency__RdAssignment_1_1
            {
            pushFollow(FOLLOW_rule__RuleDependency__RdAssignment_1_1_in_rule__RuleDependency__Group_1__1__Impl6810);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3453:1: rule__RuleDependency__Group_1__2 : rule__RuleDependency__Group_1__2__Impl rule__RuleDependency__Group_1__3 ;
    public final void rule__RuleDependency__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3457:1: ( rule__RuleDependency__Group_1__2__Impl rule__RuleDependency__Group_1__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3458:2: rule__RuleDependency__Group_1__2__Impl rule__RuleDependency__Group_1__3
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_1__2__Impl_in_rule__RuleDependency__Group_1__26840);
            rule__RuleDependency__Group_1__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RuleDependency__Group_1__3_in_rule__RuleDependency__Group_1__26843);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3465:1: rule__RuleDependency__Group_1__2__Impl : ( ( rule__RuleDependency__Alternatives_1_2 )? ) ;
    public final void rule__RuleDependency__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3469:1: ( ( ( rule__RuleDependency__Alternatives_1_2 )? ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3470:1: ( ( rule__RuleDependency__Alternatives_1_2 )? )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3470:1: ( ( rule__RuleDependency__Alternatives_1_2 )? )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3471:1: ( rule__RuleDependency__Alternatives_1_2 )?
            {
             before(grammarAccess.getRuleDependencyAccess().getAlternatives_1_2()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3472:1: ( rule__RuleDependency__Alternatives_1_2 )?
            int alt23=2;
            int LA23_0 = input.LA(1);

            if ( (LA23_0==11) ) {
                alt23=1;
            }
            else if ( (LA23_0==12) ) {
                alt23=1;
            }
            switch (alt23) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3472:2: rule__RuleDependency__Alternatives_1_2
                    {
                    pushFollow(FOLLOW_rule__RuleDependency__Alternatives_1_2_in_rule__RuleDependency__Group_1__2__Impl6870);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3482:1: rule__RuleDependency__Group_1__3 : rule__RuleDependency__Group_1__3__Impl ;
    public final void rule__RuleDependency__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3486:1: ( rule__RuleDependency__Group_1__3__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3487:2: rule__RuleDependency__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__RuleDependency__Group_1__3__Impl_in_rule__RuleDependency__Group_1__36901);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3493:1: rule__RuleDependency__Group_1__3__Impl : ( ( rule__RuleDependency__EdAssignment_1_3 )* ) ;
    public final void rule__RuleDependency__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3497:1: ( ( ( rule__RuleDependency__EdAssignment_1_3 )* ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3498:1: ( ( rule__RuleDependency__EdAssignment_1_3 )* )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3498:1: ( ( rule__RuleDependency__EdAssignment_1_3 )* )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3499:1: ( rule__RuleDependency__EdAssignment_1_3 )*
            {
             before(grammarAccess.getRuleDependencyAccess().getEdAssignment_1_3()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3500:1: ( rule__RuleDependency__EdAssignment_1_3 )*
            loop24:
            do {
                int alt24=2;
                int LA24_0 = input.LA(1);

                if ( (LA24_0==23) ) {
                    alt24=1;
                }


                switch (alt24) {
            	case 1 :
            	    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3500:2: rule__RuleDependency__EdAssignment_1_3
            	    {
            	    pushFollow(FOLLOW_rule__RuleDependency__EdAssignment_1_3_in_rule__RuleDependency__Group_1__3__Impl6928);
            	    rule__RuleDependency__EdAssignment_1_3();

            	    state._fsp--;


            	    }
            	    break;

            	default :
            	    break loop24;
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3518:1: rule__RequiresDependency__Group__0 : rule__RequiresDependency__Group__0__Impl rule__RequiresDependency__Group__1 ;
    public final void rule__RequiresDependency__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3522:1: ( rule__RequiresDependency__Group__0__Impl rule__RequiresDependency__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3523:2: rule__RequiresDependency__Group__0__Impl rule__RequiresDependency__Group__1
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__0__Impl_in_rule__RequiresDependency__Group__06967);
            rule__RequiresDependency__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequiresDependency__Group__1_in_rule__RequiresDependency__Group__06970);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3530:1: rule__RequiresDependency__Group__0__Impl : ( '(' ) ;
    public final void rule__RequiresDependency__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3534:1: ( ( '(' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3535:1: ( '(' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3535:1: ( '(' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3536:1: '('
            {
             before(grammarAccess.getRequiresDependencyAccess().getLeftParenthesisKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__RequiresDependency__Group__0__Impl6998); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3549:1: rule__RequiresDependency__Group__1 : rule__RequiresDependency__Group__1__Impl rule__RequiresDependency__Group__2 ;
    public final void rule__RequiresDependency__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3553:1: ( rule__RequiresDependency__Group__1__Impl rule__RequiresDependency__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3554:2: rule__RequiresDependency__Group__1__Impl rule__RequiresDependency__Group__2
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__1__Impl_in_rule__RequiresDependency__Group__17029);
            rule__RequiresDependency__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequiresDependency__Group__2_in_rule__RequiresDependency__Group__17032);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3561:1: rule__RequiresDependency__Group__1__Impl : ( ( rule__RequiresDependency__RequiredTransformationAssignment_1 ) ) ;
    public final void rule__RequiresDependency__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3565:1: ( ( ( rule__RequiresDependency__RequiredTransformationAssignment_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3566:1: ( ( rule__RequiresDependency__RequiredTransformationAssignment_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3566:1: ( ( rule__RequiresDependency__RequiredTransformationAssignment_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3567:1: ( rule__RequiresDependency__RequiredTransformationAssignment_1 )
            {
             before(grammarAccess.getRequiresDependencyAccess().getRequiredTransformationAssignment_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3568:1: ( rule__RequiresDependency__RequiredTransformationAssignment_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3568:2: rule__RequiresDependency__RequiredTransformationAssignment_1
            {
            pushFollow(FOLLOW_rule__RequiresDependency__RequiredTransformationAssignment_1_in_rule__RequiresDependency__Group__1__Impl7059);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3578:1: rule__RequiresDependency__Group__2 : rule__RequiresDependency__Group__2__Impl rule__RequiresDependency__Group__3 ;
    public final void rule__RequiresDependency__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3582:1: ( rule__RequiresDependency__Group__2__Impl rule__RequiresDependency__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3583:2: rule__RequiresDependency__Group__2__Impl rule__RequiresDependency__Group__3
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__2__Impl_in_rule__RequiresDependency__Group__27089);
            rule__RequiresDependency__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequiresDependency__Group__3_in_rule__RequiresDependency__Group__27092);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3590:1: rule__RequiresDependency__Group__2__Impl : ( '.' ) ;
    public final void rule__RequiresDependency__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3594:1: ( ( '.' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3595:1: ( '.' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3595:1: ( '.' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3596:1: '.'
            {
             before(grammarAccess.getRequiresDependencyAccess().getFullStopKeyword_2()); 
            match(input,17,FOLLOW_17_in_rule__RequiresDependency__Group__2__Impl7120); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3609:1: rule__RequiresDependency__Group__3 : rule__RequiresDependency__Group__3__Impl rule__RequiresDependency__Group__4 ;
    public final void rule__RequiresDependency__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3613:1: ( rule__RequiresDependency__Group__3__Impl rule__RequiresDependency__Group__4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3614:2: rule__RequiresDependency__Group__3__Impl rule__RequiresDependency__Group__4
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__3__Impl_in_rule__RequiresDependency__Group__37151);
            rule__RequiresDependency__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequiresDependency__Group__4_in_rule__RequiresDependency__Group__37154);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3621:1: rule__RequiresDependency__Group__3__Impl : ( ( rule__RequiresDependency__RequiredRuleAssignment_3 ) ) ;
    public final void rule__RequiresDependency__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3625:1: ( ( ( rule__RequiresDependency__RequiredRuleAssignment_3 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3626:1: ( ( rule__RequiresDependency__RequiredRuleAssignment_3 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3626:1: ( ( rule__RequiresDependency__RequiredRuleAssignment_3 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3627:1: ( rule__RequiresDependency__RequiredRuleAssignment_3 )
            {
             before(grammarAccess.getRequiresDependencyAccess().getRequiredRuleAssignment_3()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3628:1: ( rule__RequiresDependency__RequiredRuleAssignment_3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3628:2: rule__RequiresDependency__RequiredRuleAssignment_3
            {
            pushFollow(FOLLOW_rule__RequiresDependency__RequiredRuleAssignment_3_in_rule__RequiresDependency__Group__3__Impl7181);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3638:1: rule__RequiresDependency__Group__4 : rule__RequiresDependency__Group__4__Impl rule__RequiresDependency__Group__5 ;
    public final void rule__RequiresDependency__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3642:1: ( rule__RequiresDependency__Group__4__Impl rule__RequiresDependency__Group__5 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3643:2: rule__RequiresDependency__Group__4__Impl rule__RequiresDependency__Group__5
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__4__Impl_in_rule__RequiresDependency__Group__47211);
            rule__RequiresDependency__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequiresDependency__Group__5_in_rule__RequiresDependency__Group__47214);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3650:1: rule__RequiresDependency__Group__4__Impl : ( ',' ) ;
    public final void rule__RequiresDependency__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3654:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3655:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3655:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3656:1: ','
            {
             before(grammarAccess.getRequiresDependencyAccess().getCommaKeyword_4()); 
            match(input,19,FOLLOW_19_in_rule__RequiresDependency__Group__4__Impl7242); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3669:1: rule__RequiresDependency__Group__5 : rule__RequiresDependency__Group__5__Impl rule__RequiresDependency__Group__6 ;
    public final void rule__RequiresDependency__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3673:1: ( rule__RequiresDependency__Group__5__Impl rule__RequiresDependency__Group__6 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3674:2: rule__RequiresDependency__Group__5__Impl rule__RequiresDependency__Group__6
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__5__Impl_in_rule__RequiresDependency__Group__57273);
            rule__RequiresDependency__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequiresDependency__Group__6_in_rule__RequiresDependency__Group__57276);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3681:1: rule__RequiresDependency__Group__5__Impl : ( ( rule__RequiresDependency__FieldsAssignment_5 ) ) ;
    public final void rule__RequiresDependency__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3685:1: ( ( ( rule__RequiresDependency__FieldsAssignment_5 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3686:1: ( ( rule__RequiresDependency__FieldsAssignment_5 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3686:1: ( ( rule__RequiresDependency__FieldsAssignment_5 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3687:1: ( rule__RequiresDependency__FieldsAssignment_5 )
            {
             before(grammarAccess.getRequiresDependencyAccess().getFieldsAssignment_5()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3688:1: ( rule__RequiresDependency__FieldsAssignment_5 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3688:2: rule__RequiresDependency__FieldsAssignment_5
            {
            pushFollow(FOLLOW_rule__RequiresDependency__FieldsAssignment_5_in_rule__RequiresDependency__Group__5__Impl7303);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3698:1: rule__RequiresDependency__Group__6 : rule__RequiresDependency__Group__6__Impl rule__RequiresDependency__Group__7 ;
    public final void rule__RequiresDependency__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3702:1: ( rule__RequiresDependency__Group__6__Impl rule__RequiresDependency__Group__7 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3703:2: rule__RequiresDependency__Group__6__Impl rule__RequiresDependency__Group__7
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__6__Impl_in_rule__RequiresDependency__Group__67333);
            rule__RequiresDependency__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequiresDependency__Group__7_in_rule__RequiresDependency__Group__67336);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3710:1: rule__RequiresDependency__Group__6__Impl : ( ':' ) ;
    public final void rule__RequiresDependency__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3714:1: ( ( ':' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3715:1: ( ':' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3715:1: ( ':' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3716:1: ':'
            {
             before(grammarAccess.getRequiresDependencyAccess().getColonKeyword_6()); 
            match(input,18,FOLLOW_18_in_rule__RequiresDependency__Group__6__Impl7364); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3729:1: rule__RequiresDependency__Group__7 : rule__RequiresDependency__Group__7__Impl rule__RequiresDependency__Group__8 ;
    public final void rule__RequiresDependency__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3733:1: ( rule__RequiresDependency__Group__7__Impl rule__RequiresDependency__Group__8 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3734:2: rule__RequiresDependency__Group__7__Impl rule__RequiresDependency__Group__8
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__7__Impl_in_rule__RequiresDependency__Group__77395);
            rule__RequiresDependency__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__RequiresDependency__Group__8_in_rule__RequiresDependency__Group__77398);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3741:1: rule__RequiresDependency__Group__7__Impl : ( ( rule__RequiresDependency__OclExpressionAssignment_7 ) ) ;
    public final void rule__RequiresDependency__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3745:1: ( ( ( rule__RequiresDependency__OclExpressionAssignment_7 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3746:1: ( ( rule__RequiresDependency__OclExpressionAssignment_7 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3746:1: ( ( rule__RequiresDependency__OclExpressionAssignment_7 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3747:1: ( rule__RequiresDependency__OclExpressionAssignment_7 )
            {
             before(grammarAccess.getRequiresDependencyAccess().getOclExpressionAssignment_7()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3748:1: ( rule__RequiresDependency__OclExpressionAssignment_7 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3748:2: rule__RequiresDependency__OclExpressionAssignment_7
            {
            pushFollow(FOLLOW_rule__RequiresDependency__OclExpressionAssignment_7_in_rule__RequiresDependency__Group__7__Impl7425);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3758:1: rule__RequiresDependency__Group__8 : rule__RequiresDependency__Group__8__Impl ;
    public final void rule__RequiresDependency__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3762:1: ( rule__RequiresDependency__Group__8__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3763:2: rule__RequiresDependency__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__RequiresDependency__Group__8__Impl_in_rule__RequiresDependency__Group__87455);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3769:1: rule__RequiresDependency__Group__8__Impl : ( ')' ) ;
    public final void rule__RequiresDependency__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3773:1: ( ( ')' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3774:1: ( ')' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3774:1: ( ')' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3775:1: ')'
            {
             before(grammarAccess.getRequiresDependencyAccess().getRightParenthesisKeyword_8()); 
            match(input,24,FOLLOW_24_in_rule__RequiresDependency__Group__8__Impl7483); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3806:1: rule__ExcludeDependency__Group__0 : rule__ExcludeDependency__Group__0__Impl rule__ExcludeDependency__Group__1 ;
    public final void rule__ExcludeDependency__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3810:1: ( rule__ExcludeDependency__Group__0__Impl rule__ExcludeDependency__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3811:2: rule__ExcludeDependency__Group__0__Impl rule__ExcludeDependency__Group__1
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__0__Impl_in_rule__ExcludeDependency__Group__07532);
            rule__ExcludeDependency__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExcludeDependency__Group__1_in_rule__ExcludeDependency__Group__07535);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3818:1: rule__ExcludeDependency__Group__0__Impl : ( '(' ) ;
    public final void rule__ExcludeDependency__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3822:1: ( ( '(' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3823:1: ( '(' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3823:1: ( '(' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3824:1: '('
            {
             before(grammarAccess.getExcludeDependencyAccess().getLeftParenthesisKeyword_0()); 
            match(input,23,FOLLOW_23_in_rule__ExcludeDependency__Group__0__Impl7563); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3837:1: rule__ExcludeDependency__Group__1 : rule__ExcludeDependency__Group__1__Impl rule__ExcludeDependency__Group__2 ;
    public final void rule__ExcludeDependency__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3841:1: ( rule__ExcludeDependency__Group__1__Impl rule__ExcludeDependency__Group__2 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3842:2: rule__ExcludeDependency__Group__1__Impl rule__ExcludeDependency__Group__2
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__1__Impl_in_rule__ExcludeDependency__Group__17594);
            rule__ExcludeDependency__Group__1__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExcludeDependency__Group__2_in_rule__ExcludeDependency__Group__17597);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3849:1: rule__ExcludeDependency__Group__1__Impl : ( ( rule__ExcludeDependency__RequiredTransformationAssignment_1 ) ) ;
    public final void rule__ExcludeDependency__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3853:1: ( ( ( rule__ExcludeDependency__RequiredTransformationAssignment_1 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3854:1: ( ( rule__ExcludeDependency__RequiredTransformationAssignment_1 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3854:1: ( ( rule__ExcludeDependency__RequiredTransformationAssignment_1 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3855:1: ( rule__ExcludeDependency__RequiredTransformationAssignment_1 )
            {
             before(grammarAccess.getExcludeDependencyAccess().getRequiredTransformationAssignment_1()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3856:1: ( rule__ExcludeDependency__RequiredTransformationAssignment_1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3856:2: rule__ExcludeDependency__RequiredTransformationAssignment_1
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__RequiredTransformationAssignment_1_in_rule__ExcludeDependency__Group__1__Impl7624);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3866:1: rule__ExcludeDependency__Group__2 : rule__ExcludeDependency__Group__2__Impl rule__ExcludeDependency__Group__3 ;
    public final void rule__ExcludeDependency__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3870:1: ( rule__ExcludeDependency__Group__2__Impl rule__ExcludeDependency__Group__3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3871:2: rule__ExcludeDependency__Group__2__Impl rule__ExcludeDependency__Group__3
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__2__Impl_in_rule__ExcludeDependency__Group__27654);
            rule__ExcludeDependency__Group__2__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExcludeDependency__Group__3_in_rule__ExcludeDependency__Group__27657);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3878:1: rule__ExcludeDependency__Group__2__Impl : ( '.' ) ;
    public final void rule__ExcludeDependency__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3882:1: ( ( '.' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3883:1: ( '.' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3883:1: ( '.' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3884:1: '.'
            {
             before(grammarAccess.getExcludeDependencyAccess().getFullStopKeyword_2()); 
            match(input,17,FOLLOW_17_in_rule__ExcludeDependency__Group__2__Impl7685); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3897:1: rule__ExcludeDependency__Group__3 : rule__ExcludeDependency__Group__3__Impl rule__ExcludeDependency__Group__4 ;
    public final void rule__ExcludeDependency__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3901:1: ( rule__ExcludeDependency__Group__3__Impl rule__ExcludeDependency__Group__4 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3902:2: rule__ExcludeDependency__Group__3__Impl rule__ExcludeDependency__Group__4
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__3__Impl_in_rule__ExcludeDependency__Group__37716);
            rule__ExcludeDependency__Group__3__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExcludeDependency__Group__4_in_rule__ExcludeDependency__Group__37719);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3909:1: rule__ExcludeDependency__Group__3__Impl : ( ( rule__ExcludeDependency__RequiredRuleAssignment_3 ) ) ;
    public final void rule__ExcludeDependency__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3913:1: ( ( ( rule__ExcludeDependency__RequiredRuleAssignment_3 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3914:1: ( ( rule__ExcludeDependency__RequiredRuleAssignment_3 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3914:1: ( ( rule__ExcludeDependency__RequiredRuleAssignment_3 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3915:1: ( rule__ExcludeDependency__RequiredRuleAssignment_3 )
            {
             before(grammarAccess.getExcludeDependencyAccess().getRequiredRuleAssignment_3()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3916:1: ( rule__ExcludeDependency__RequiredRuleAssignment_3 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3916:2: rule__ExcludeDependency__RequiredRuleAssignment_3
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__RequiredRuleAssignment_3_in_rule__ExcludeDependency__Group__3__Impl7746);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3926:1: rule__ExcludeDependency__Group__4 : rule__ExcludeDependency__Group__4__Impl rule__ExcludeDependency__Group__5 ;
    public final void rule__ExcludeDependency__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3930:1: ( rule__ExcludeDependency__Group__4__Impl rule__ExcludeDependency__Group__5 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3931:2: rule__ExcludeDependency__Group__4__Impl rule__ExcludeDependency__Group__5
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__4__Impl_in_rule__ExcludeDependency__Group__47776);
            rule__ExcludeDependency__Group__4__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExcludeDependency__Group__5_in_rule__ExcludeDependency__Group__47779);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3938:1: rule__ExcludeDependency__Group__4__Impl : ( ',' ) ;
    public final void rule__ExcludeDependency__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3942:1: ( ( ',' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3943:1: ( ',' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3943:1: ( ',' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3944:1: ','
            {
             before(grammarAccess.getExcludeDependencyAccess().getCommaKeyword_4()); 
            match(input,19,FOLLOW_19_in_rule__ExcludeDependency__Group__4__Impl7807); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3957:1: rule__ExcludeDependency__Group__5 : rule__ExcludeDependency__Group__5__Impl rule__ExcludeDependency__Group__6 ;
    public final void rule__ExcludeDependency__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3961:1: ( rule__ExcludeDependency__Group__5__Impl rule__ExcludeDependency__Group__6 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3962:2: rule__ExcludeDependency__Group__5__Impl rule__ExcludeDependency__Group__6
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__5__Impl_in_rule__ExcludeDependency__Group__57838);
            rule__ExcludeDependency__Group__5__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExcludeDependency__Group__6_in_rule__ExcludeDependency__Group__57841);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3969:1: rule__ExcludeDependency__Group__5__Impl : ( ( rule__ExcludeDependency__FieldsAssignment_5 ) ) ;
    public final void rule__ExcludeDependency__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3973:1: ( ( ( rule__ExcludeDependency__FieldsAssignment_5 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3974:1: ( ( rule__ExcludeDependency__FieldsAssignment_5 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3974:1: ( ( rule__ExcludeDependency__FieldsAssignment_5 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3975:1: ( rule__ExcludeDependency__FieldsAssignment_5 )
            {
             before(grammarAccess.getExcludeDependencyAccess().getFieldsAssignment_5()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3976:1: ( rule__ExcludeDependency__FieldsAssignment_5 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3976:2: rule__ExcludeDependency__FieldsAssignment_5
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__FieldsAssignment_5_in_rule__ExcludeDependency__Group__5__Impl7868);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3986:1: rule__ExcludeDependency__Group__6 : rule__ExcludeDependency__Group__6__Impl rule__ExcludeDependency__Group__7 ;
    public final void rule__ExcludeDependency__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3990:1: ( rule__ExcludeDependency__Group__6__Impl rule__ExcludeDependency__Group__7 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3991:2: rule__ExcludeDependency__Group__6__Impl rule__ExcludeDependency__Group__7
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__6__Impl_in_rule__ExcludeDependency__Group__67898);
            rule__ExcludeDependency__Group__6__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExcludeDependency__Group__7_in_rule__ExcludeDependency__Group__67901);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:3998:1: rule__ExcludeDependency__Group__6__Impl : ( ':' ) ;
    public final void rule__ExcludeDependency__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4002:1: ( ( ':' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4003:1: ( ':' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4003:1: ( ':' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4004:1: ':'
            {
             before(grammarAccess.getExcludeDependencyAccess().getColonKeyword_6()); 
            match(input,18,FOLLOW_18_in_rule__ExcludeDependency__Group__6__Impl7929); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4017:1: rule__ExcludeDependency__Group__7 : rule__ExcludeDependency__Group__7__Impl rule__ExcludeDependency__Group__8 ;
    public final void rule__ExcludeDependency__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4021:1: ( rule__ExcludeDependency__Group__7__Impl rule__ExcludeDependency__Group__8 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4022:2: rule__ExcludeDependency__Group__7__Impl rule__ExcludeDependency__Group__8
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__7__Impl_in_rule__ExcludeDependency__Group__77960);
            rule__ExcludeDependency__Group__7__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__ExcludeDependency__Group__8_in_rule__ExcludeDependency__Group__77963);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4029:1: rule__ExcludeDependency__Group__7__Impl : ( ( rule__ExcludeDependency__OclExpressionAssignment_7 ) ) ;
    public final void rule__ExcludeDependency__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4033:1: ( ( ( rule__ExcludeDependency__OclExpressionAssignment_7 ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4034:1: ( ( rule__ExcludeDependency__OclExpressionAssignment_7 ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4034:1: ( ( rule__ExcludeDependency__OclExpressionAssignment_7 ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4035:1: ( rule__ExcludeDependency__OclExpressionAssignment_7 )
            {
             before(grammarAccess.getExcludeDependencyAccess().getOclExpressionAssignment_7()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4036:1: ( rule__ExcludeDependency__OclExpressionAssignment_7 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4036:2: rule__ExcludeDependency__OclExpressionAssignment_7
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__OclExpressionAssignment_7_in_rule__ExcludeDependency__Group__7__Impl7990);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4046:1: rule__ExcludeDependency__Group__8 : rule__ExcludeDependency__Group__8__Impl ;
    public final void rule__ExcludeDependency__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4050:1: ( rule__ExcludeDependency__Group__8__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4051:2: rule__ExcludeDependency__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__ExcludeDependency__Group__8__Impl_in_rule__ExcludeDependency__Group__88020);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4057:1: rule__ExcludeDependency__Group__8__Impl : ( ')' ) ;
    public final void rule__ExcludeDependency__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4061:1: ( ( ')' ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4062:1: ( ')' )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4062:1: ( ')' )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4063:1: ')'
            {
             before(grammarAccess.getExcludeDependencyAccess().getRightParenthesisKeyword_8()); 
            match(input,24,FOLLOW_24_in_rule__ExcludeDependency__Group__8__Impl8048); 
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4094:1: rule__EInt__Group__0 : rule__EInt__Group__0__Impl rule__EInt__Group__1 ;
    public final void rule__EInt__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4098:1: ( rule__EInt__Group__0__Impl rule__EInt__Group__1 )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4099:2: rule__EInt__Group__0__Impl rule__EInt__Group__1
            {
            pushFollow(FOLLOW_rule__EInt__Group__0__Impl_in_rule__EInt__Group__08097);
            rule__EInt__Group__0__Impl();

            state._fsp--;

            pushFollow(FOLLOW_rule__EInt__Group__1_in_rule__EInt__Group__08100);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4106:1: rule__EInt__Group__0__Impl : ( ( '-' )? ) ;
    public final void rule__EInt__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4110:1: ( ( ( '-' )? ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4111:1: ( ( '-' )? )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4111:1: ( ( '-' )? )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4112:1: ( '-' )?
            {
             before(grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4113:1: ( '-' )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==31) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4114:2: '-'
                    {
                    match(input,31,FOLLOW_31_in_rule__EInt__Group__0__Impl8129); 

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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4125:1: rule__EInt__Group__1 : rule__EInt__Group__1__Impl ;
    public final void rule__EInt__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4129:1: ( rule__EInt__Group__1__Impl )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4130:2: rule__EInt__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__EInt__Group__1__Impl_in_rule__EInt__Group__18162);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4136:1: rule__EInt__Group__1__Impl : ( RULE_INT ) ;
    public final void rule__EInt__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4140:1: ( ( RULE_INT ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4141:1: ( RULE_INT )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4141:1: ( RULE_INT )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4142:1: RULE_INT
            {
             before(grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
            match(input,RULE_INT,FOLLOW_RULE_INT_in_rule__EInt__Group__1__Impl8189); 
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


    // $ANTLR start "rule__TrcSpecification__ModuleListAssignment_0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4158:1: rule__TrcSpecification__ModuleListAssignment_0 : ( ruleModuleList ) ;
    public final void rule__TrcSpecification__ModuleListAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4162:1: ( ( ruleModuleList ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4163:1: ( ruleModuleList )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4163:1: ( ruleModuleList )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4164:1: ruleModuleList
            {
             before(grammarAccess.getTrcSpecificationAccess().getModuleListModuleListParserRuleCall_0_0()); 
            pushFollow(FOLLOW_ruleModuleList_in_rule__TrcSpecification__ModuleListAssignment_08227);
            ruleModuleList();

            state._fsp--;

             after(grammarAccess.getTrcSpecificationAccess().getModuleListModuleListParserRuleCall_0_0()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4173:1: rule__TrcSpecification__TransformationListAssignment_1 : ( ruleTransformationList ) ;
    public final void rule__TrcSpecification__TransformationListAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4177:1: ( ( ruleTransformationList ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4178:1: ( ruleTransformationList )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4178:1: ( ruleTransformationList )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4179:1: ruleTransformationList
            {
             before(grammarAccess.getTrcSpecificationAccess().getTransformationListTransformationListParserRuleCall_1_0()); 
            pushFollow(FOLLOW_ruleTransformationList_in_rule__TrcSpecification__TransformationListAssignment_18258);
            ruleTransformationList();

            state._fsp--;

             after(grammarAccess.getTrcSpecificationAccess().getTransformationListTransformationListParserRuleCall_1_0()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4188:1: rule__TrcSpecification__DependencyListAssignment_2 : ( ruleTransformationDependencyList ) ;
    public final void rule__TrcSpecification__DependencyListAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4192:1: ( ( ruleTransformationDependencyList ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4193:1: ( ruleTransformationDependencyList )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4193:1: ( ruleTransformationDependencyList )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4194:1: ruleTransformationDependencyList
            {
             before(grammarAccess.getTrcSpecificationAccess().getDependencyListTransformationDependencyListParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleTransformationDependencyList_in_rule__TrcSpecification__DependencyListAssignment_28289);
            ruleTransformationDependencyList();

            state._fsp--;

             after(grammarAccess.getTrcSpecificationAccess().getDependencyListTransformationDependencyListParserRuleCall_2_0()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4203:1: rule__TrcRule__NameAssignment : ( ruleEString ) ;
    public final void rule__TrcRule__NameAssignment() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4207:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4208:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4208:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4209:1: ruleEString
            {
             before(grammarAccess.getTrcRuleAccess().getNameEStringParserRuleCall_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__TrcRule__NameAssignment8320);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTrcRuleAccess().getNameEStringParserRuleCall_0()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4218:1: rule__ModuleList__ModulesAssignment_2 : ( ruleModule ) ;
    public final void rule__ModuleList__ModulesAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4222:1: ( ( ruleModule ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4223:1: ( ruleModule )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4223:1: ( ruleModule )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4224:1: ruleModule
            {
             before(grammarAccess.getModuleListAccess().getModulesModuleParserRuleCall_2_0()); 
            pushFollow(FOLLOW_ruleModule_in_rule__ModuleList__ModulesAssignment_28351);
            ruleModule();

            state._fsp--;

             after(grammarAccess.getModuleListAccess().getModulesModuleParserRuleCall_2_0()); 

            }


            }

        }
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


    // $ANTLR start "rule__ModuleList__ModulesAssignment_3_1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4233:1: rule__ModuleList__ModulesAssignment_3_1 : ( ruleModule ) ;
    public final void rule__ModuleList__ModulesAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4237:1: ( ( ruleModule ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4238:1: ( ruleModule )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4238:1: ( ruleModule )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4239:1: ruleModule
            {
             before(grammarAccess.getModuleListAccess().getModulesModuleParserRuleCall_3_1_0()); 
            pushFollow(FOLLOW_ruleModule_in_rule__ModuleList__ModulesAssignment_3_18382);
            ruleModule();

            state._fsp--;

             after(grammarAccess.getModuleListAccess().getModulesModuleParserRuleCall_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ModuleList__ModulesAssignment_3_1"


    // $ANTLR start "rule__Module__NameAssignment_1_0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4248:1: rule__Module__NameAssignment_1_0 : ( ruleEString ) ;
    public final void rule__Module__NameAssignment_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4252:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4253:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4253:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4254:1: ruleEString
            {
             before(grammarAccess.getModuleAccess().getNameEStringParserRuleCall_1_0_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__Module__NameAssignment_1_08413);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getModuleAccess().getNameEStringParserRuleCall_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__NameAssignment_1_0"


    // $ANTLR start "rule__Module__RulesAssignment_1_2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4263:1: rule__Module__RulesAssignment_1_2 : ( ruletrcRule ) ;
    public final void rule__Module__RulesAssignment_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4267:1: ( ( ruletrcRule ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4268:1: ( ruletrcRule )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4268:1: ( ruletrcRule )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4269:1: ruletrcRule
            {
             before(grammarAccess.getModuleAccess().getRulesTrcRuleParserRuleCall_1_2_0()); 
            pushFollow(FOLLOW_ruletrcRule_in_rule__Module__RulesAssignment_1_28444);
            ruletrcRule();

            state._fsp--;

             after(grammarAccess.getModuleAccess().getRulesTrcRuleParserRuleCall_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__RulesAssignment_1_2"


    // $ANTLR start "rule__Module__RulesAssignment_1_3_1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4278:1: rule__Module__RulesAssignment_1_3_1 : ( ruletrcRule ) ;
    public final void rule__Module__RulesAssignment_1_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4282:1: ( ( ruletrcRule ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4283:1: ( ruletrcRule )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4283:1: ( ruletrcRule )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4284:1: ruletrcRule
            {
             before(grammarAccess.getModuleAccess().getRulesTrcRuleParserRuleCall_1_3_1_0()); 
            pushFollow(FOLLOW_ruletrcRule_in_rule__Module__RulesAssignment_1_3_18475);
            ruletrcRule();

            state._fsp--;

             after(grammarAccess.getModuleAccess().getRulesTrcRuleParserRuleCall_1_3_1_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__Module__RulesAssignment_1_3_1"


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
            pushFollow(FOLLOW_ruleTransformation_in_rule__TransformationList__TransformationsAssignment_28506);
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
            pushFollow(FOLLOW_ruleTransformation_in_rule__TransformationList__TransformationsAssignment_3_18537);
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
            pushFollow(FOLLOW_ruleEString_in_rule__Transformation__NameAssignment_08568);
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
             before(grammarAccess.getTransformationAccess().getModulesModuleCrossReference_4_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4345:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4346:1: ruleEString
            {
             before(grammarAccess.getTransformationAccess().getModulesModuleEStringParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleEString_in_rule__Transformation__ModulesAssignment_48603);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTransformationAccess().getModulesModuleEStringParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getTransformationAccess().getModulesModuleCrossReference_4_0()); 

            }


            }

        }
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
             before(grammarAccess.getTransformationAccess().getModulesModuleCrossReference_5_1_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4364:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4365:1: ruleEString
            {
             before(grammarAccess.getTransformationAccess().getModulesModuleEStringParserRuleCall_5_1_0_1()); 
            pushFollow(FOLLOW_ruleEString_in_rule__Transformation__ModulesAssignment_5_18642);
            ruleEString();

            state._fsp--;

             after(grammarAccess.getTransformationAccess().getModulesModuleEStringParserRuleCall_5_1_0_1()); 

            }

             after(grammarAccess.getTransformationAccess().getModulesModuleCrossReference_5_1_0()); 

            }


            }

        }
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
            pushFollow(FOLLOW_ruleTransformationImpact_in_rule__Transformation__ImpactsAssignment_6_28677);
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
            pushFollow(FOLLOW_ruleTransformationImpact_in_rule__Transformation__ImpactsAssignment_6_3_18708);
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
            pushFollow(FOLLOW_ruleEString_in_rule__TransformationImpact__QualityAttributeNameAssignment_1_08739);
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
            pushFollow(FOLLOW_ruleEInt_in_rule__TransformationImpact__ImpactValueAssignment_28770);
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
            pushFollow(FOLLOW_ruleEString_in_rule__TransformationDependencyList__NameAssignment_28801);
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
            pushFollow(FOLLOW_ruleTransformationDependency_in_rule__TransformationDependencyList__TransformationDependenciesAssignment_48832);
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
            pushFollow(FOLLOW_ruleTransformationDependency_in_rule__TransformationDependencyList__TransformationDependenciesAssignment_5_18863);
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
            pushFollow(FOLLOW_ruleEString_in_rule__TransformationDependency__AppliedTransformationAssignment_28898);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4500:1: rule__TransformationDependency__AppliedRuleAssignment_4 : ( ( ruleQualifiedName ) ) ;
    public final void rule__TransformationDependency__AppliedRuleAssignment_4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4504:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4505:1: ( ( ruleQualifiedName ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4505:1: ( ( ruleQualifiedName ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4506:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getTransformationDependencyAccess().getAppliedRuleTrcRuleCrossReference_4_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4507:1: ( ruleQualifiedName )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4508:1: ruleQualifiedName
            {
             before(grammarAccess.getTransformationDependencyAccess().getAppliedRuleTrcRuleQualifiedNameParserRuleCall_4_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__TransformationDependency__AppliedRuleAssignment_48937);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyAccess().getAppliedRuleTrcRuleQualifiedNameParserRuleCall_4_0_1()); 

            }

             after(grammarAccess.getTransformationDependencyAccess().getAppliedRuleTrcRuleCrossReference_4_0()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4519:1: rule__TransformationDependency__FieldsAssignment_7 : ( ruleEString ) ;
    public final void rule__TransformationDependency__FieldsAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4523:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4524:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4524:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4525:1: ruleEString
            {
             before(grammarAccess.getTransformationDependencyAccess().getFieldsEStringParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__TransformationDependency__FieldsAssignment_78972);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4534:1: rule__TransformationDependency__FieldsAssignment_8_1 : ( ruleEString ) ;
    public final void rule__TransformationDependency__FieldsAssignment_8_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4538:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4539:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4539:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4540:1: ruleEString
            {
             before(grammarAccess.getTransformationDependencyAccess().getFieldsEStringParserRuleCall_8_1_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__TransformationDependency__FieldsAssignment_8_19003);
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


    // $ANTLR start "rule__TransformationDependency__RequiredTransformationsAssignment_12_0_0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4549:1: rule__TransformationDependency__RequiredTransformationsAssignment_12_0_0 : ( ruleAbstractRuleDependency ) ;
    public final void rule__TransformationDependency__RequiredTransformationsAssignment_12_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4553:1: ( ( ruleAbstractRuleDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4554:1: ( ruleAbstractRuleDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4554:1: ( ruleAbstractRuleDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4555:1: ruleAbstractRuleDependency
            {
             before(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_0_0_0()); 
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_rule__TransformationDependency__RequiredTransformationsAssignment_12_0_09034);
            ruleAbstractRuleDependency();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_0_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__RequiredTransformationsAssignment_12_0_0"


    // $ANTLR start "rule__TransformationDependency__RequiredTransformationsAssignment_12_0_2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4564:1: rule__TransformationDependency__RequiredTransformationsAssignment_12_0_2 : ( ruleAbstractRuleDependency ) ;
    public final void rule__TransformationDependency__RequiredTransformationsAssignment_12_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4568:1: ( ( ruleAbstractRuleDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4569:1: ( ruleAbstractRuleDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4569:1: ( ruleAbstractRuleDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4570:1: ruleAbstractRuleDependency
            {
             before(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_0_2_0()); 
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_rule__TransformationDependency__RequiredTransformationsAssignment_12_0_29065);
            ruleAbstractRuleDependency();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_0_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__RequiredTransformationsAssignment_12_0_2"


    // $ANTLR start "rule__TransformationDependency__RequiredTransformationsAssignment_12_1_0"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4579:1: rule__TransformationDependency__RequiredTransformationsAssignment_12_1_0 : ( ruleAbstractRuleDependency ) ;
    public final void rule__TransformationDependency__RequiredTransformationsAssignment_12_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4583:1: ( ( ruleAbstractRuleDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4584:1: ( ruleAbstractRuleDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4584:1: ( ruleAbstractRuleDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4585:1: ruleAbstractRuleDependency
            {
             before(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_1_0_0()); 
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_rule__TransformationDependency__RequiredTransformationsAssignment_12_1_09096);
            ruleAbstractRuleDependency();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_1_0_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__RequiredTransformationsAssignment_12_1_0"


    // $ANTLR start "rule__TransformationDependency__RequiredTransformationsAssignment_12_1_2"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4594:1: rule__TransformationDependency__RequiredTransformationsAssignment_12_1_2 : ( ruleAbstractRuleDependency ) ;
    public final void rule__TransformationDependency__RequiredTransformationsAssignment_12_1_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4598:1: ( ( ruleAbstractRuleDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4599:1: ( ruleAbstractRuleDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4599:1: ( ruleAbstractRuleDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4600:1: ruleAbstractRuleDependency
            {
             before(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_1_2_0()); 
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_rule__TransformationDependency__RequiredTransformationsAssignment_12_1_29127);
            ruleAbstractRuleDependency();

            state._fsp--;

             after(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_1_2_0()); 

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__TransformationDependency__RequiredTransformationsAssignment_12_1_2"


    // $ANTLR start "rule__RuleDependency__RdAssignment_0_1"
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4609:1: rule__RuleDependency__RdAssignment_0_1 : ( rulerequiresDependency ) ;
    public final void rule__RuleDependency__RdAssignment_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4613:1: ( ( rulerequiresDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4614:1: ( rulerequiresDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4614:1: ( rulerequiresDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4615:1: rulerequiresDependency
            {
             before(grammarAccess.getRuleDependencyAccess().getRdRequiresDependencyParserRuleCall_0_1_0()); 
            pushFollow(FOLLOW_rulerequiresDependency_in_rule__RuleDependency__RdAssignment_0_19158);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4624:1: rule__RuleDependency__RdAssignment_0_3 : ( rulerequiresDependency ) ;
    public final void rule__RuleDependency__RdAssignment_0_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4628:1: ( ( rulerequiresDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4629:1: ( rulerequiresDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4629:1: ( rulerequiresDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4630:1: rulerequiresDependency
            {
             before(grammarAccess.getRuleDependencyAccess().getRdRequiresDependencyParserRuleCall_0_3_0()); 
            pushFollow(FOLLOW_rulerequiresDependency_in_rule__RuleDependency__RdAssignment_0_39189);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4639:1: rule__RuleDependency__RdAssignment_1_1 : ( ruleexcludeDependency ) ;
    public final void rule__RuleDependency__RdAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4643:1: ( ( ruleexcludeDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4644:1: ( ruleexcludeDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4644:1: ( ruleexcludeDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4645:1: ruleexcludeDependency
            {
             before(grammarAccess.getRuleDependencyAccess().getRdExcludeDependencyParserRuleCall_1_1_0()); 
            pushFollow(FOLLOW_ruleexcludeDependency_in_rule__RuleDependency__RdAssignment_1_19220);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4654:1: rule__RuleDependency__EdAssignment_1_3 : ( ruleexcludeDependency ) ;
    public final void rule__RuleDependency__EdAssignment_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4658:1: ( ( ruleexcludeDependency ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4659:1: ( ruleexcludeDependency )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4659:1: ( ruleexcludeDependency )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4660:1: ruleexcludeDependency
            {
             before(grammarAccess.getRuleDependencyAccess().getEdExcludeDependencyParserRuleCall_1_3_0()); 
            pushFollow(FOLLOW_ruleexcludeDependency_in_rule__RuleDependency__EdAssignment_1_39251);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4669:1: rule__RequiresDependency__RequiredTransformationAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__RequiresDependency__RequiredTransformationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4673:1: ( ( ( ruleEString ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4674:1: ( ( ruleEString ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4674:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4675:1: ( ruleEString )
            {
             before(grammarAccess.getRequiresDependencyAccess().getRequiredTransformationTransformationCrossReference_1_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4676:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4677:1: ruleEString
            {
             before(grammarAccess.getRequiresDependencyAccess().getRequiredTransformationTransformationEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleEString_in_rule__RequiresDependency__RequiredTransformationAssignment_19286);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4688:1: rule__RequiresDependency__RequiredRuleAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__RequiresDependency__RequiredRuleAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4692:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4693:1: ( ( ruleQualifiedName ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4693:1: ( ( ruleQualifiedName ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4694:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getRequiresDependencyAccess().getRequiredRuleTrcRuleCrossReference_3_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4695:1: ( ruleQualifiedName )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4696:1: ruleQualifiedName
            {
             before(grammarAccess.getRequiresDependencyAccess().getRequiredRuleTrcRuleQualifiedNameParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__RequiresDependency__RequiredRuleAssignment_39325);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getRequiresDependencyAccess().getRequiredRuleTrcRuleQualifiedNameParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getRequiresDependencyAccess().getRequiredRuleTrcRuleCrossReference_3_0()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4707:1: rule__RequiresDependency__FieldsAssignment_5 : ( ruleEString ) ;
    public final void rule__RequiresDependency__FieldsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4711:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4712:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4712:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4713:1: ruleEString
            {
             before(grammarAccess.getRequiresDependencyAccess().getFieldsEStringParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__RequiresDependency__FieldsAssignment_59360);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4722:1: rule__RequiresDependency__OclExpressionAssignment_7 : ( ruleEString ) ;
    public final void rule__RequiresDependency__OclExpressionAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4726:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4727:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4727:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4728:1: ruleEString
            {
             before(grammarAccess.getRequiresDependencyAccess().getOclExpressionEStringParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__RequiresDependency__OclExpressionAssignment_79391);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4737:1: rule__ExcludeDependency__RequiredTransformationAssignment_1 : ( ( ruleEString ) ) ;
    public final void rule__ExcludeDependency__RequiredTransformationAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4741:1: ( ( ( ruleEString ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4742:1: ( ( ruleEString ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4742:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4743:1: ( ruleEString )
            {
             before(grammarAccess.getExcludeDependencyAccess().getRequiredTransformationTransformationCrossReference_1_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4744:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4745:1: ruleEString
            {
             before(grammarAccess.getExcludeDependencyAccess().getRequiredTransformationTransformationEStringParserRuleCall_1_0_1()); 
            pushFollow(FOLLOW_ruleEString_in_rule__ExcludeDependency__RequiredTransformationAssignment_19426);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4756:1: rule__ExcludeDependency__RequiredRuleAssignment_3 : ( ( ruleQualifiedName ) ) ;
    public final void rule__ExcludeDependency__RequiredRuleAssignment_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4760:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4761:1: ( ( ruleQualifiedName ) )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4761:1: ( ( ruleQualifiedName ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4762:1: ( ruleQualifiedName )
            {
             before(grammarAccess.getExcludeDependencyAccess().getRequiredRuleTrcRuleCrossReference_3_0()); 
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4763:1: ( ruleQualifiedName )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4764:1: ruleQualifiedName
            {
             before(grammarAccess.getExcludeDependencyAccess().getRequiredRuleTrcRuleQualifiedNameParserRuleCall_3_0_1()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__ExcludeDependency__RequiredRuleAssignment_39465);
            ruleQualifiedName();

            state._fsp--;

             after(grammarAccess.getExcludeDependencyAccess().getRequiredRuleTrcRuleQualifiedNameParserRuleCall_3_0_1()); 

            }

             after(grammarAccess.getExcludeDependencyAccess().getRequiredRuleTrcRuleCrossReference_3_0()); 

            }


            }

        }
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4775:1: rule__ExcludeDependency__FieldsAssignment_5 : ( ruleEString ) ;
    public final void rule__ExcludeDependency__FieldsAssignment_5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4779:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4780:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4780:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4781:1: ruleEString
            {
             before(grammarAccess.getExcludeDependencyAccess().getFieldsEStringParserRuleCall_5_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__ExcludeDependency__FieldsAssignment_59500);
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
    // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4790:1: rule__ExcludeDependency__OclExpressionAssignment_7 : ( ruleEString ) ;
    public final void rule__ExcludeDependency__OclExpressionAssignment_7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4794:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4795:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4795:1: ( ruleEString )
            // ../org.trc.xtext.dsl.ui/src-gen/org/trc/xtext/dsl/ui/contentassist/antlr/internal/InternalDsl.g:4796:1: ruleEString
            {
             before(grammarAccess.getExcludeDependencyAccess().getOclExpressionEStringParserRuleCall_7_0()); 
            pushFollow(FOLLOW_ruleEString_in_rule__ExcludeDependency__OclExpressionAssignment_79531);
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


    protected DFA1 dfa1 = new DFA1(this);
    static final String DFA1_eotS =
        "\101\uffff";
    static final String DFA1_eofS =
        "\101\uffff";
    static final String DFA1_minS =
        "\1\35\2\27\2\4\4\21\2\5\2\21\1\5\1\4\1\5\1\4\1\21\2\22\1\21\2\22"+
        "\2\4\4\30\4\13\1\4\2\13\1\4\2\uffff\4\21\2\5\2\21\1\5\1\4\1\5\1"+
        "\4\1\21\2\22\1\21\2\22\2\4\4\30\2\13";
    static final String DFA1_maxS =
        "\1\36\2\27\2\5\4\21\2\5\2\23\4\5\1\23\2\22\1\23\2\22\2\5\4\30\2"+
        "\27\2\36\1\5\2\36\1\5\2\uffff\4\21\2\5\2\23\4\5\1\23\2\22\1\23\2"+
        "\22\2\5\4\30\2\27";
    static final String DFA1_acceptS =
        "\45\uffff\1\1\1\2\32\uffff";
    static final String DFA1_specialS =
        "\101\uffff}>";
    static final String[] DFA1_transitionS = {
            "\1\1\1\2",
            "\1\3",
            "\1\4",
            "\1\5\1\6",
            "\1\7\1\10",
            "\1\11",
            "\1\11",
            "\1\12",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15\1\uffff\1\16",
            "\1\17\1\uffff\1\20",
            "\1\21",
            "\1\22\1\23",
            "\1\24",
            "\1\25\1\26",
            "\1\15\1\uffff\1\16",
            "\1\27",
            "\1\27",
            "\1\17\1\uffff\1\20",
            "\1\30",
            "\1\30",
            "\1\31\1\32",
            "\1\33\1\34",
            "\1\35",
            "\1\35",
            "\1\36",
            "\1\36",
            "\1\37\1\40\12\uffff\1\41",
            "\1\42\1\43\12\uffff\1\44",
            "\1\45\1\46\12\uffff\1\41\4\uffff\3\45",
            "\1\45\1\46\12\uffff\1\41\4\uffff\3\46",
            "\1\47\1\50",
            "\1\45\1\46\12\uffff\1\44\4\uffff\3\45",
            "\1\45\1\46\12\uffff\1\44\4\uffff\3\46",
            "\1\51\1\52",
            "",
            "",
            "\1\53",
            "\1\53",
            "\1\54",
            "\1\54",
            "\1\55",
            "\1\56",
            "\1\57\1\uffff\1\60",
            "\1\61\1\uffff\1\62",
            "\1\63",
            "\1\64\1\65",
            "\1\66",
            "\1\67\1\70",
            "\1\57\1\uffff\1\60",
            "\1\71",
            "\1\71",
            "\1\61\1\uffff\1\62",
            "\1\72",
            "\1\72",
            "\1\73\1\74",
            "\1\75\1\76",
            "\1\77",
            "\1\77",
            "\1\100",
            "\1\100",
            "\1\45\1\46\12\uffff\1\41",
            "\1\45\1\46\12\uffff\1\44"
    };

    static final short[] DFA1_eot = DFA.unpackEncodedString(DFA1_eotS);
    static final short[] DFA1_eof = DFA.unpackEncodedString(DFA1_eofS);
    static final char[] DFA1_min = DFA.unpackEncodedStringToUnsignedChars(DFA1_minS);
    static final char[] DFA1_max = DFA.unpackEncodedStringToUnsignedChars(DFA1_maxS);
    static final short[] DFA1_accept = DFA.unpackEncodedString(DFA1_acceptS);
    static final short[] DFA1_special = DFA.unpackEncodedString(DFA1_specialS);
    static final short[][] DFA1_transition;

    static {
        int numStates = DFA1_transitionS.length;
        DFA1_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA1_transition[i] = DFA.unpackEncodedString(DFA1_transitionS[i]);
        }
    }

    class DFA1 extends DFA {

        public DFA1(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 1;
            this.eot = DFA1_eot;
            this.eof = DFA1_eof;
            this.min = DFA1_min;
            this.max = DFA1_max;
            this.accept = DFA1_accept;
            this.special = DFA1_special;
            this.transition = DFA1_transition;
        }
        public String getDescription() {
            return "514:1: rule__TransformationDependency__Alternatives_12 : ( ( ( rule__TransformationDependency__Group_12_0__0 ) ) | ( ( rule__TransformationDependency__Group_12_1__0 ) ) );";
        }
    }
 

    public static final BitSet FOLLOW_ruleTrcSpecification_in_entryRuleTrcSpecification61 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrcSpecification68 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__0_in_ruleTrcSpecification94 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletrcRule_in_entryRuletrcRule121 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletrcRule128 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcRule__NameAssignment_in_ruletrcRule154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModuleList_in_entryRuleModuleList181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModuleList188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__0_in_ruleModuleList214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName241 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule301 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__0_in_ruleModule334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationList_in_entryRuleTransformationList361 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationList368 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__0_in_ruleTransformationList394 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformation_in_entryRuleTransformation421 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformation428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__0_in_ruleTransformation454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_entryRuleTransformationImpact481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationImpact488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__0_in_ruleTransformationImpact514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependencyList_in_entryRuleTransformationDependencyList541 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationDependencyList548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__0_in_ruleTransformationDependencyList574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_entryRuleTransformationDependency601 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationDependency608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__0_in_ruleTransformationDependency634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_entryRuleAbstractRuleDependency661 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRuleDependency668 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependency_in_ruleAbstractRuleDependency694 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependency_in_entryRuleRuleDependency720 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDependency727 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Alternatives_in_ruleRuleDependency753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerequiresDependency_in_entryRulerequiresDependency780 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerequiresDependency787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__0_in_rulerequiresDependency813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexcludeDependency_in_entryRuleexcludeDependency840 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleexcludeDependency847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__0_in_ruleexcludeDependency873 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_entryRuleEString904 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEString911 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EString__Alternatives_in_ruleEString937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt964 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEInt971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EInt__Group__0_in_ruleEInt997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_12_0__0_in_rule__TransformationDependency__Alternatives_121035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_12_1__0_in_rule__TransformationDependency__Alternatives_121053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_0__0_in_rule__RuleDependency__Alternatives1086 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_1__0_in_rule__RuleDependency__Alternatives1104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__RuleDependency__Alternatives_0_21138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__RuleDependency__Alternatives_0_21158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__RuleDependency__Alternatives_1_21193 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__RuleDependency__Alternatives_1_21213 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__EString__Alternatives1247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__EString__Alternatives1264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__0__Impl_in_rule__TrcSpecification__Group__01295 = new BitSet(new long[]{0x0000000002100000L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__1_in_rule__TrcSpecification__Group__01298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__ModuleListAssignment_0_in_rule__TrcSpecification__Group__0__Impl1325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__1__Impl_in_rule__TrcSpecification__Group__11355 = new BitSet(new long[]{0x0000000002100000L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__2_in_rule__TrcSpecification__Group__11358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__TransformationListAssignment_1_in_rule__TrcSpecification__Group__1__Impl1385 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__Group__2__Impl_in_rule__TrcSpecification__Group__21416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TrcSpecification__DependencyListAssignment_2_in_rule__TrcSpecification__Group__2__Impl1443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__0__Impl_in_rule__ModuleList__Group__01480 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__1_in_rule__ModuleList__Group__01483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__ModuleList__Group__0__Impl1511 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__1__Impl_in_rule__ModuleList__Group__11542 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__2_in_rule__ModuleList__Group__11545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__ModuleList__Group__1__Impl1573 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__2__Impl_in_rule__ModuleList__Group__21604 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__3_in_rule__ModuleList__Group__21607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__ModulesAssignment_2_in_rule__ModuleList__Group__2__Impl1634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__3__Impl_in_rule__ModuleList__Group__31664 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__4_in_rule__ModuleList__Group__31667 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group_3__0_in_rule__ModuleList__Group__3__Impl1694 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group__4__Impl_in_rule__ModuleList__Group__41725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__ModuleList__Group__4__Impl1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group_3__0__Impl_in_rule__ModuleList__Group_3__01794 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__ModuleList__Group_3__1_in_rule__ModuleList__Group_3__01797 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__ModuleList__Group_3__0__Impl1825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__Group_3__1__Impl_in_rule__ModuleList__Group_3__11856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ModuleList__ModulesAssignment_3_1_in_rule__ModuleList__Group_3__1__Impl1883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__01917 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__01920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group__0__Impl1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__11976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl2003 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__02038 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__02041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__QualifiedName__Group_1__0__Impl2069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__12100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__QualifiedName__Group_1__1__Impl2127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__0__Impl_in_rule__Module__Group__02160 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Module__Group__1_in_rule__Module__Group__02163 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group__1__Impl_in_rule__Module__Group__12221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_1__0_in_rule__Module__Group__1__Impl2248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_1__0__Impl_in_rule__Module__Group_1__02283 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Module__Group_1__1_in_rule__Module__Group_1__02286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__NameAssignment_1_0_in_rule__Module__Group_1__0__Impl2313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_1__1__Impl_in_rule__Module__Group_1__12343 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Module__Group_1__2_in_rule__Module__Group_1__12346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Module__Group_1__1__Impl2374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_1__2__Impl_in_rule__Module__Group_1__22405 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Module__Group_1__3_in_rule__Module__Group_1__22408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__RulesAssignment_1_2_in_rule__Module__Group_1__2__Impl2435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_1__3__Impl_in_rule__Module__Group_1__32465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_1_3__0_in_rule__Module__Group_1__3__Impl2492 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__Module__Group_1_3__0__Impl_in_rule__Module__Group_1_3__02531 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Module__Group_1_3__1_in_rule__Module__Group_1_3__02534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Module__Group_1_3__0__Impl2562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__Group_1_3__1__Impl_in_rule__Module__Group_1_3__12593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Module__RulesAssignment_1_3_1_in_rule__Module__Group_1_3__1__Impl2620 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__0__Impl_in_rule__TransformationList__Group__02654 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__1_in_rule__TransformationList__Group__02657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__TransformationList__Group__0__Impl2685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__1__Impl_in_rule__TransformationList__Group__12716 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__2_in_rule__TransformationList__Group__12719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__TransformationList__Group__1__Impl2747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__2__Impl_in_rule__TransformationList__Group__22778 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__3_in_rule__TransformationList__Group__22781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__TransformationsAssignment_2_in_rule__TransformationList__Group__2__Impl2808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__3__Impl_in_rule__TransformationList__Group__32838 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__4_in_rule__TransformationList__Group__32841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group_3__0_in_rule__TransformationList__Group__3__Impl2868 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group__4__Impl_in_rule__TransformationList__Group__42899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__TransformationList__Group__4__Impl2927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group_3__0__Impl_in_rule__TransformationList__Group_3__02968 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationList__Group_3__1_in_rule__TransformationList__Group_3__02971 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__TransformationList__Group_3__0__Impl2999 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__Group_3__1__Impl_in_rule__TransformationList__Group_3__13030 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationList__TransformationsAssignment_3_1_in_rule__TransformationList__Group_3__1__Impl3057 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__0__Impl_in_rule__Transformation__Group__03091 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__1_in_rule__Transformation__Group__03094 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__NameAssignment_0_in_rule__Transformation__Group__0__Impl3121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__1__Impl_in_rule__Transformation__Group__13151 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__2_in_rule__Transformation__Group__13154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__Transformation__Group__1__Impl3182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__2__Impl_in_rule__Transformation__Group__23213 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__3_in_rule__Transformation__Group__23216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__Transformation__Group__2__Impl3244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__3__Impl_in_rule__Transformation__Group__33275 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Transformation__Group__4_in_rule__Transformation__Group__33278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Transformation__Group__3__Impl3306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__4__Impl_in_rule__Transformation__Group__43337 = new BitSet(new long[]{0x0000000000488000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__5_in_rule__Transformation__Group__43340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__ModulesAssignment_4_in_rule__Transformation__Group__4__Impl3367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__5__Impl_in_rule__Transformation__Group__53397 = new BitSet(new long[]{0x0000000000488000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__6_in_rule__Transformation__Group__53400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_5__0_in_rule__Transformation__Group__5__Impl3427 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__6__Impl_in_rule__Transformation__Group__63458 = new BitSet(new long[]{0x0000000000488000L});
    public static final BitSet FOLLOW_rule__Transformation__Group__7_in_rule__Transformation__Group__63461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__0_in_rule__Transformation__Group__6__Impl3488 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group__7__Impl_in_rule__Transformation__Group__73519 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__Transformation__Group__7__Impl3547 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_5__0__Impl_in_rule__Transformation__Group_5__03594 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__Transformation__Group_5__1_in_rule__Transformation__Group_5__03597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Transformation__Group_5__0__Impl3625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_5__1__Impl_in_rule__Transformation__Group_5__13656 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__ModulesAssignment_5_1_in_rule__Transformation__Group_5__1__Impl3683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__0__Impl_in_rule__Transformation__Group_6__03717 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__1_in_rule__Transformation__Group_6__03720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__Transformation__Group_6__0__Impl3748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__1__Impl_in_rule__Transformation__Group_6__13779 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__2_in_rule__Transformation__Group_6__13782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__Transformation__Group_6__1__Impl3810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__2__Impl_in_rule__Transformation__Group_6__23841 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__3_in_rule__Transformation__Group_6__23844 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__ImpactsAssignment_6_2_in_rule__Transformation__Group_6__2__Impl3871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6__3__Impl_in_rule__Transformation__Group_6__33901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6_3__0_in_rule__Transformation__Group_6__3__Impl3928 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6_3__0__Impl_in_rule__Transformation__Group_6_3__03967 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6_3__1_in_rule__Transformation__Group_6_3__03970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__Transformation__Group_6_3__0__Impl3998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__Group_6_3__1__Impl_in_rule__Transformation__Group_6_3__14029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__Transformation__ImpactsAssignment_6_3_1_in_rule__Transformation__Group_6_3__1__Impl4056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__0__Impl_in_rule__TransformationImpact__Group__04090 = new BitSet(new long[]{0x0000000080000070L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__1_in_rule__TransformationImpact__Group__04093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__TransformationImpact__Group__0__Impl4121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__1__Impl_in_rule__TransformationImpact__Group__14152 = new BitSet(new long[]{0x0000000080000070L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__2_in_rule__TransformationImpact__Group__14155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group_1__0_in_rule__TransformationImpact__Group__1__Impl4182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__2__Impl_in_rule__TransformationImpact__Group__24213 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__3_in_rule__TransformationImpact__Group__24216 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__ImpactValueAssignment_2_in_rule__TransformationImpact__Group__2__Impl4243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group__3__Impl_in_rule__TransformationImpact__Group__34273 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__TransformationImpact__Group__3__Impl4301 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group_1__0__Impl_in_rule__TransformationImpact__Group_1__04340 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group_1__1_in_rule__TransformationImpact__Group_1__04343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__QualityAttributeNameAssignment_1_0_in_rule__TransformationImpact__Group_1__0__Impl4370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationImpact__Group_1__1__Impl_in_rule__TransformationImpact__Group_1__14400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__TransformationImpact__Group_1__1__Impl4428 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__0__Impl_in_rule__TransformationDependencyList__Group__04463 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__1_in_rule__TransformationDependencyList__Group__04466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__TransformationDependencyList__Group__0__Impl4494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__1__Impl_in_rule__TransformationDependencyList__Group__14525 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__2_in_rule__TransformationDependencyList__Group__14528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__TransformationDependencyList__Group__1__Impl4556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__2__Impl_in_rule__TransformationDependencyList__Group__24587 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__3_in_rule__TransformationDependencyList__Group__24590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__NameAssignment_2_in_rule__TransformationDependencyList__Group__2__Impl4617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__3__Impl_in_rule__TransformationDependencyList__Group__34647 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__4_in_rule__TransformationDependencyList__Group__34650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__TransformationDependencyList__Group__3__Impl4678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__4__Impl_in_rule__TransformationDependencyList__Group__44709 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__5_in_rule__TransformationDependencyList__Group__44712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__TransformationDependenciesAssignment_4_in_rule__TransformationDependencyList__Group__4__Impl4739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__5__Impl_in_rule__TransformationDependencyList__Group__54769 = new BitSet(new long[]{0x0000000000018000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__6_in_rule__TransformationDependencyList__Group__54772 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group_5__0_in_rule__TransformationDependencyList__Group__5__Impl4799 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__6__Impl_in_rule__TransformationDependencyList__Group__64830 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__7_in_rule__TransformationDependencyList__Group__64833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__TransformationDependencyList__Group__6__Impl4861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group__7__Impl_in_rule__TransformationDependencyList__Group__74892 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__TransformationDependencyList__Group__7__Impl4920 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group_5__0__Impl_in_rule__TransformationDependencyList__Group_5__04967 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group_5__1_in_rule__TransformationDependencyList__Group_5__04970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__TransformationDependencyList__Group_5__0__Impl4998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__Group_5__1__Impl_in_rule__TransformationDependencyList__Group_5__15029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependencyList__TransformationDependenciesAssignment_5_1_in_rule__TransformationDependencyList__Group_5__1__Impl5056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__0__Impl_in_rule__TransformationDependency__Group__05090 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__1_in_rule__TransformationDependency__Group__05093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__TransformationDependency__Group__0__Impl5121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__1__Impl_in_rule__TransformationDependency__Group__15152 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__2_in_rule__TransformationDependency__Group__15155 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__TransformationDependency__Group__1__Impl5183 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__2__Impl_in_rule__TransformationDependency__Group__25214 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__3_in_rule__TransformationDependency__Group__25217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__AppliedTransformationAssignment_2_in_rule__TransformationDependency__Group__2__Impl5244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__3__Impl_in_rule__TransformationDependency__Group__35274 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__4_in_rule__TransformationDependency__Group__35277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__TransformationDependency__Group__3__Impl5305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__4__Impl_in_rule__TransformationDependency__Group__45336 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__5_in_rule__TransformationDependency__Group__45339 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__AppliedRuleAssignment_4_in_rule__TransformationDependency__Group__4__Impl5366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__5__Impl_in_rule__TransformationDependency__Group__55396 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__6_in_rule__TransformationDependency__Group__55399 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__TransformationDependency__Group__5__Impl5427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__6__Impl_in_rule__TransformationDependency__Group__65458 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__7_in_rule__TransformationDependency__Group__65461 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__TransformationDependency__Group__6__Impl5489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__7__Impl_in_rule__TransformationDependency__Group__75520 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__8_in_rule__TransformationDependency__Group__75523 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__FieldsAssignment_7_in_rule__TransformationDependency__Group__7__Impl5550 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__8__Impl_in_rule__TransformationDependency__Group__85580 = new BitSet(new long[]{0x0000000000088000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__9_in_rule__TransformationDependency__Group__85583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_8__0_in_rule__TransformationDependency__Group__8__Impl5610 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__9__Impl_in_rule__TransformationDependency__Group__95641 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__10_in_rule__TransformationDependency__Group__95644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__TransformationDependency__Group__9__Impl5672 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__10__Impl_in_rule__TransformationDependency__Group__105703 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__11_in_rule__TransformationDependency__Group__105706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__TransformationDependency__Group__10__Impl5734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__11__Impl_in_rule__TransformationDependency__Group__115765 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__12_in_rule__TransformationDependency__Group__115768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__TransformationDependency__Group__11__Impl5796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__12__Impl_in_rule__TransformationDependency__Group__125827 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__13_in_rule__TransformationDependency__Group__125830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Alternatives_12_in_rule__TransformationDependency__Group__12__Impl5857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group__13__Impl_in_rule__TransformationDependency__Group__135887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__TransformationDependency__Group__13__Impl5915 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_8__0__Impl_in_rule__TransformationDependency__Group_8__05974 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_8__1_in_rule__TransformationDependency__Group_8__05977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__TransformationDependency__Group_8__0__Impl6005 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_8__1__Impl_in_rule__TransformationDependency__Group_8__16036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__FieldsAssignment_8_1_in_rule__TransformationDependency__Group_8__1__Impl6063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_12_0__0__Impl_in_rule__TransformationDependency__Group_12_0__06097 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_12_0__1_in_rule__TransformationDependency__Group_12_0__06100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__RequiredTransformationsAssignment_12_0_0_in_rule__TransformationDependency__Group_12_0__0__Impl6127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_12_0__1__Impl_in_rule__TransformationDependency__Group_12_0__16157 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_12_0__2_in_rule__TransformationDependency__Group_12_0__16160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__TransformationDependency__Group_12_0__1__Impl6188 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_12_0__2__Impl_in_rule__TransformationDependency__Group_12_0__26219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__RequiredTransformationsAssignment_12_0_2_in_rule__TransformationDependency__Group_12_0__2__Impl6246 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_12_1__0__Impl_in_rule__TransformationDependency__Group_12_1__06283 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_12_1__1_in_rule__TransformationDependency__Group_12_1__06286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__RequiredTransformationsAssignment_12_1_0_in_rule__TransformationDependency__Group_12_1__0__Impl6313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_12_1__1__Impl_in_rule__TransformationDependency__Group_12_1__16343 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_12_1__2_in_rule__TransformationDependency__Group_12_1__16346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__TransformationDependency__Group_12_1__1__Impl6374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__Group_12_1__2__Impl_in_rule__TransformationDependency__Group_12_1__26405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__TransformationDependency__RequiredTransformationsAssignment_12_1_2_in_rule__TransformationDependency__Group_12_1__2__Impl6432 = new BitSet(new long[]{0x0000000060000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_0__0__Impl_in_rule__RuleDependency__Group_0__06469 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_0__1_in_rule__RuleDependency__Group_0__06472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__RuleDependency__Group_0__0__Impl6500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_0__1__Impl_in_rule__RuleDependency__Group_0__16531 = new BitSet(new long[]{0x0000000000801800L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_0__2_in_rule__RuleDependency__Group_0__16534 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__RdAssignment_0_1_in_rule__RuleDependency__Group_0__1__Impl6561 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_0__2__Impl_in_rule__RuleDependency__Group_0__26591 = new BitSet(new long[]{0x0000000000801800L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_0__3_in_rule__RuleDependency__Group_0__26594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Alternatives_0_2_in_rule__RuleDependency__Group_0__2__Impl6621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_0__3__Impl_in_rule__RuleDependency__Group_0__36652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__RdAssignment_0_3_in_rule__RuleDependency__Group_0__3__Impl6679 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_1__0__Impl_in_rule__RuleDependency__Group_1__06718 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_1__1_in_rule__RuleDependency__Group_1__06721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_rule__RuleDependency__Group_1__0__Impl6749 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_1__1__Impl_in_rule__RuleDependency__Group_1__16780 = new BitSet(new long[]{0x0000000000801800L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_1__2_in_rule__RuleDependency__Group_1__16783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__RdAssignment_1_1_in_rule__RuleDependency__Group_1__1__Impl6810 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_1__2__Impl_in_rule__RuleDependency__Group_1__26840 = new BitSet(new long[]{0x0000000000801800L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_1__3_in_rule__RuleDependency__Group_1__26843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Alternatives_1_2_in_rule__RuleDependency__Group_1__2__Impl6870 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__Group_1__3__Impl_in_rule__RuleDependency__Group_1__36901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RuleDependency__EdAssignment_1_3_in_rule__RuleDependency__Group_1__3__Impl6928 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__0__Impl_in_rule__RequiresDependency__Group__06967 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__1_in_rule__RequiresDependency__Group__06970 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__RequiresDependency__Group__0__Impl6998 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__1__Impl_in_rule__RequiresDependency__Group__17029 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__2_in_rule__RequiresDependency__Group__17032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__RequiredTransformationAssignment_1_in_rule__RequiresDependency__Group__1__Impl7059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__2__Impl_in_rule__RequiresDependency__Group__27089 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__3_in_rule__RequiresDependency__Group__27092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__RequiresDependency__Group__2__Impl7120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__3__Impl_in_rule__RequiresDependency__Group__37151 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__4_in_rule__RequiresDependency__Group__37154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__RequiredRuleAssignment_3_in_rule__RequiresDependency__Group__3__Impl7181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__4__Impl_in_rule__RequiresDependency__Group__47211 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__5_in_rule__RequiresDependency__Group__47214 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__RequiresDependency__Group__4__Impl7242 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__5__Impl_in_rule__RequiresDependency__Group__57273 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__6_in_rule__RequiresDependency__Group__57276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__FieldsAssignment_5_in_rule__RequiresDependency__Group__5__Impl7303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__6__Impl_in_rule__RequiresDependency__Group__67333 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__7_in_rule__RequiresDependency__Group__67336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__RequiresDependency__Group__6__Impl7364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__7__Impl_in_rule__RequiresDependency__Group__77395 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__8_in_rule__RequiresDependency__Group__77398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__OclExpressionAssignment_7_in_rule__RequiresDependency__Group__7__Impl7425 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__RequiresDependency__Group__8__Impl_in_rule__RequiresDependency__Group__87455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__RequiresDependency__Group__8__Impl7483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__0__Impl_in_rule__ExcludeDependency__Group__07532 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__1_in_rule__ExcludeDependency__Group__07535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__ExcludeDependency__Group__0__Impl7563 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__1__Impl_in_rule__ExcludeDependency__Group__17594 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__2_in_rule__ExcludeDependency__Group__17597 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__RequiredTransformationAssignment_1_in_rule__ExcludeDependency__Group__1__Impl7624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__2__Impl_in_rule__ExcludeDependency__Group__27654 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__3_in_rule__ExcludeDependency__Group__27657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__ExcludeDependency__Group__2__Impl7685 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__3__Impl_in_rule__ExcludeDependency__Group__37716 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__4_in_rule__ExcludeDependency__Group__37719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__RequiredRuleAssignment_3_in_rule__ExcludeDependency__Group__3__Impl7746 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__4__Impl_in_rule__ExcludeDependency__Group__47776 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__5_in_rule__ExcludeDependency__Group__47779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__ExcludeDependency__Group__4__Impl7807 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__5__Impl_in_rule__ExcludeDependency__Group__57838 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__6_in_rule__ExcludeDependency__Group__57841 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__FieldsAssignment_5_in_rule__ExcludeDependency__Group__5__Impl7868 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__6__Impl_in_rule__ExcludeDependency__Group__67898 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__7_in_rule__ExcludeDependency__Group__67901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__ExcludeDependency__Group__6__Impl7929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__7__Impl_in_rule__ExcludeDependency__Group__77960 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__8_in_rule__ExcludeDependency__Group__77963 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__OclExpressionAssignment_7_in_rule__ExcludeDependency__Group__7__Impl7990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ExcludeDependency__Group__8__Impl_in_rule__ExcludeDependency__Group__88020 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__ExcludeDependency__Group__8__Impl8048 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EInt__Group__0__Impl_in_rule__EInt__Group__08097 = new BitSet(new long[]{0x0000000080000070L});
    public static final BitSet FOLLOW_rule__EInt__Group__1_in_rule__EInt__Group__08100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_rule__EInt__Group__0__Impl8129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__EInt__Group__1__Impl_in_rule__EInt__Group__18162 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_rule__EInt__Group__1__Impl8189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModuleList_in_rule__TrcSpecification__ModuleListAssignment_08227 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationList_in_rule__TrcSpecification__TransformationListAssignment_18258 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependencyList_in_rule__TrcSpecification__DependencyListAssignment_28289 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TrcRule__NameAssignment8320 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModule_in_rule__ModuleList__ModulesAssignment_28351 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModule_in_rule__ModuleList__ModulesAssignment_3_18382 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__Module__NameAssignment_1_08413 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletrcRule_in_rule__Module__RulesAssignment_1_28444 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletrcRule_in_rule__Module__RulesAssignment_1_3_18475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformation_in_rule__TransformationList__TransformationsAssignment_28506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformation_in_rule__TransformationList__TransformationsAssignment_3_18537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__Transformation__NameAssignment_08568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__Transformation__ModulesAssignment_48603 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__Transformation__ModulesAssignment_5_18642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_rule__Transformation__ImpactsAssignment_6_28677 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_rule__Transformation__ImpactsAssignment_6_3_18708 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TransformationImpact__QualityAttributeNameAssignment_1_08739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_rule__TransformationImpact__ImpactValueAssignment_28770 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TransformationDependencyList__NameAssignment_28801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_rule__TransformationDependencyList__TransformationDependenciesAssignment_48832 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_rule__TransformationDependencyList__TransformationDependenciesAssignment_5_18863 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TransformationDependency__AppliedTransformationAssignment_28898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__TransformationDependency__AppliedRuleAssignment_48937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TransformationDependency__FieldsAssignment_78972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__TransformationDependency__FieldsAssignment_8_19003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_rule__TransformationDependency__RequiredTransformationsAssignment_12_0_09034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_rule__TransformationDependency__RequiredTransformationsAssignment_12_0_29065 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_rule__TransformationDependency__RequiredTransformationsAssignment_12_1_09096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_rule__TransformationDependency__RequiredTransformationsAssignment_12_1_29127 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerequiresDependency_in_rule__RuleDependency__RdAssignment_0_19158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerequiresDependency_in_rule__RuleDependency__RdAssignment_0_39189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexcludeDependency_in_rule__RuleDependency__RdAssignment_1_19220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexcludeDependency_in_rule__RuleDependency__EdAssignment_1_39251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__RequiresDependency__RequiredTransformationAssignment_19286 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__RequiresDependency__RequiredRuleAssignment_39325 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__RequiresDependency__FieldsAssignment_59360 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__RequiresDependency__OclExpressionAssignment_79391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__ExcludeDependency__RequiredTransformationAssignment_19426 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__ExcludeDependency__RequiredRuleAssignment_39465 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__ExcludeDependency__FieldsAssignment_59500 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_rule__ExcludeDependency__OclExpressionAssignment_79531 = new BitSet(new long[]{0x0000000000000002L});

}