package fr.tpt.aadl.ramses.transformation.trc.xtext.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import fr.tpt.aadl.ramses.transformation.trc.xtext.services.TRCGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalTRCParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_UNQUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Modules'", "'{'", "';'", "'}'", "'.'", "'['", "']'", "':'", "','", "'Transformations'", "'modules'", "'impacts'", "'('", "')'", "'Dependencies'", "'Apply'", "'or'", "'and'", "'requires'", "'excludes'", "'-'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'"
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
    public String getGrammarFileName() { return "../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g"; }



    /*
      This grammar contains a lot of empty actions to work around a bug in ANTLR.
      Otherwise the ANTLR tool will create synpreds that cannot be compiled in some rare cases.
    */
     
     	private TRCGrammarAccess grammarAccess;
     	
        public InternalTRCParser(TokenStream input, TRCGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "TrcSpecification";	
       	}
       	
       	@Override
       	protected TRCGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleTrcSpecification"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:73:1: entryRuleTrcSpecification returns [EObject current=null] : iv_ruleTrcSpecification= ruleTrcSpecification EOF ;
    public final EObject entryRuleTrcSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrcSpecification = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:74:2: (iv_ruleTrcSpecification= ruleTrcSpecification EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:75:2: iv_ruleTrcSpecification= ruleTrcSpecification EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTrcSpecificationRule()); 
            }
            pushFollow(FOLLOW_ruleTrcSpecification_in_entryRuleTrcSpecification81);
            iv_ruleTrcSpecification=ruleTrcSpecification();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTrcSpecification; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrcSpecification91); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrcSpecification"


    // $ANTLR start "ruleTrcSpecification"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:82:1: ruleTrcSpecification returns [EObject current=null] : ( ( (lv_moduleList_0_0= ruleModuleList ) ) ( (lv_transformationList_1_0= ruleTransformationList ) ) ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) ) ) ;
    public final EObject ruleTrcSpecification() throws RecognitionException {
        EObject current = null;

        EObject lv_moduleList_0_0 = null;

        EObject lv_transformationList_1_0 = null;

        EObject lv_dependencyList_2_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:85:28: ( ( ( (lv_moduleList_0_0= ruleModuleList ) ) ( (lv_transformationList_1_0= ruleTransformationList ) ) ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:86:1: ( ( (lv_moduleList_0_0= ruleModuleList ) ) ( (lv_transformationList_1_0= ruleTransformationList ) ) ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:86:1: ( ( (lv_moduleList_0_0= ruleModuleList ) ) ( (lv_transformationList_1_0= ruleTransformationList ) ) ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:86:2: ( (lv_moduleList_0_0= ruleModuleList ) ) ( (lv_transformationList_1_0= ruleTransformationList ) ) ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:86:2: ( (lv_moduleList_0_0= ruleModuleList ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:87:1: (lv_moduleList_0_0= ruleModuleList )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:87:1: (lv_moduleList_0_0= ruleModuleList )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:88:3: lv_moduleList_0_0= ruleModuleList
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTrcSpecificationAccess().getModuleListModuleListParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleModuleList_in_ruleTrcSpecification137);
            lv_moduleList_0_0=ruleModuleList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTrcSpecificationRule());
              	        }
                     		set(
                     			current, 
                     			"moduleList",
                      		lv_moduleList_0_0, 
                      		"ModuleList");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:104:2: ( (lv_transformationList_1_0= ruleTransformationList ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:105:1: (lv_transformationList_1_0= ruleTransformationList )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:105:1: (lv_transformationList_1_0= ruleTransformationList )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:106:3: lv_transformationList_1_0= ruleTransformationList
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTrcSpecificationAccess().getTransformationListTransformationListParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTransformationList_in_ruleTrcSpecification158);
            lv_transformationList_1_0=ruleTransformationList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTrcSpecificationRule());
              	        }
                     		set(
                     			current, 
                     			"transformationList",
                      		lv_transformationList_1_0, 
                      		"TransformationList");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:122:2: ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:123:1: (lv_dependencyList_2_0= ruleTransformationDependencyList )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:123:1: (lv_dependencyList_2_0= ruleTransformationDependencyList )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:124:3: lv_dependencyList_2_0= ruleTransformationDependencyList
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTrcSpecificationAccess().getDependencyListTransformationDependencyListParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTransformationDependencyList_in_ruleTrcSpecification179);
            lv_dependencyList_2_0=ruleTransformationDependencyList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTrcSpecificationRule());
              	        }
                     		set(
                     			current, 
                     			"dependencyList",
                      		lv_dependencyList_2_0, 
                      		"TransformationDependencyList");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrcSpecification"


    // $ANTLR start "entryRuleTrcRule"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:148:1: entryRuleTrcRule returns [EObject current=null] : iv_ruleTrcRule= ruleTrcRule EOF ;
    public final EObject entryRuleTrcRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrcRule = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:149:2: (iv_ruleTrcRule= ruleTrcRule EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:150:2: iv_ruleTrcRule= ruleTrcRule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTrcRuleRule()); 
            }
            pushFollow(FOLLOW_ruleTrcRule_in_entryRuleTrcRule215);
            iv_ruleTrcRule=ruleTrcRule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTrcRule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrcRule225); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTrcRule"


    // $ANTLR start "ruleTrcRule"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:157:1: ruleTrcRule returns [EObject current=null] : ( (lv_name_0_0= ruleEString ) ) ;
    public final EObject ruleTrcRule() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:160:28: ( ( (lv_name_0_0= ruleEString ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:161:1: ( (lv_name_0_0= ruleEString ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:161:1: ( (lv_name_0_0= ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:162:1: (lv_name_0_0= ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:162:1: (lv_name_0_0= ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:163:3: lv_name_0_0= ruleEString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTrcRuleAccess().getNameEStringParserRuleCall_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEString_in_ruleTrcRule270);
            lv_name_0_0=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTrcRuleRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"EString");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTrcRule"


    // $ANTLR start "entryRuleModuleList"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:187:1: entryRuleModuleList returns [EObject current=null] : iv_ruleModuleList= ruleModuleList EOF ;
    public final EObject entryRuleModuleList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleList = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:188:2: (iv_ruleModuleList= ruleModuleList EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:189:2: iv_ruleModuleList= ruleModuleList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModuleListRule()); 
            }
            pushFollow(FOLLOW_ruleModuleList_in_entryRuleModuleList305);
            iv_ruleModuleList=ruleModuleList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModuleList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModuleList315); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModuleList"


    // $ANTLR start "ruleModuleList"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:196:1: ruleModuleList returns [EObject current=null] : (otherlv_0= 'Modules' otherlv_1= '{' ( (lv_modules_2_0= ruleModule ) ) otherlv_3= ';' ( ( (lv_modules_4_0= ruleModule ) ) otherlv_5= ';' )* otherlv_6= '}' ) ;
    public final EObject ruleModuleList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_modules_2_0 = null;

        EObject lv_modules_4_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:199:28: ( (otherlv_0= 'Modules' otherlv_1= '{' ( (lv_modules_2_0= ruleModule ) ) otherlv_3= ';' ( ( (lv_modules_4_0= ruleModule ) ) otherlv_5= ';' )* otherlv_6= '}' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:200:1: (otherlv_0= 'Modules' otherlv_1= '{' ( (lv_modules_2_0= ruleModule ) ) otherlv_3= ';' ( ( (lv_modules_4_0= ruleModule ) ) otherlv_5= ';' )* otherlv_6= '}' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:200:1: (otherlv_0= 'Modules' otherlv_1= '{' ( (lv_modules_2_0= ruleModule ) ) otherlv_3= ';' ( ( (lv_modules_4_0= ruleModule ) ) otherlv_5= ';' )* otherlv_6= '}' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:200:3: otherlv_0= 'Modules' otherlv_1= '{' ( (lv_modules_2_0= ruleModule ) ) otherlv_3= ';' ( ( (lv_modules_4_0= ruleModule ) ) otherlv_5= ';' )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleModuleList352); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getModuleListAccess().getModulesKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleModuleList364); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getModuleListAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:208:1: ( (lv_modules_2_0= ruleModule ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:209:1: (lv_modules_2_0= ruleModule )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:209:1: (lv_modules_2_0= ruleModule )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:210:3: lv_modules_2_0= ruleModule
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleListAccess().getModulesModuleParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleModule_in_ruleModuleList385);
            lv_modules_2_0=ruleModule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModuleListRule());
              	        }
                     		add(
                     			current, 
                     			"modules",
                      		lv_modules_2_0, 
                      		"Module");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleModuleList397); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getModuleListAccess().getSemicolonKeyword_3());
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:230:1: ( ( (lv_modules_4_0= ruleModule ) ) otherlv_5= ';' )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( ((LA1_0>=RULE_ID && LA1_0<=RULE_STRING)) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:230:2: ( (lv_modules_4_0= ruleModule ) ) otherlv_5= ';'
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:230:2: ( (lv_modules_4_0= ruleModule ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:231:1: (lv_modules_4_0= ruleModule )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:231:1: (lv_modules_4_0= ruleModule )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:232:3: lv_modules_4_0= ruleModule
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getModuleListAccess().getModulesModuleParserRuleCall_4_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleModule_in_ruleModuleList419);
            	    lv_modules_4_0=ruleModule();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getModuleListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"modules",
            	              		lv_modules_4_0, 
            	              		"Module");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleModuleList431); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getModuleListAccess().getSemicolonKeyword_4_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleModuleList445); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getModuleListAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModuleList"


    // $ANTLR start "entryRuleQualifiedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:264:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:265:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:266:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName482);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName493); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:273:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:276:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:277:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:277:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:277:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName533); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:284:1: (kw= '.' this_ID_2= RULE_ID )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:285:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,16,FOLLOW_16_in_ruleQualifiedName552); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName567); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	          newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleModule"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:305:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:306:2: (iv_ruleModule= ruleModule EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:307:2: iv_ruleModule= ruleModule EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getModuleRule()); 
            }
            pushFollow(FOLLOW_ruleModule_in_entryRuleModule614);
            iv_ruleModule=ruleModule();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleModule; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleModule624); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleModule"


    // $ANTLR start "ruleModule"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:314:1: ruleModule returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '[' ( (lv_path_2_0= ruleEString ) ) otherlv_3= ']' (otherlv_4= ':' ( (lv_rules_5_0= ruleTrcRule ) ) (otherlv_6= ',' ( (lv_rules_7_0= ruleTrcRule ) ) )* )? ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        AntlrDatatypeRuleToken lv_path_2_0 = null;

        EObject lv_rules_5_0 = null;

        EObject lv_rules_7_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:317:28: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '[' ( (lv_path_2_0= ruleEString ) ) otherlv_3= ']' (otherlv_4= ':' ( (lv_rules_5_0= ruleTrcRule ) ) (otherlv_6= ',' ( (lv_rules_7_0= ruleTrcRule ) ) )* )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:318:1: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '[' ( (lv_path_2_0= ruleEString ) ) otherlv_3= ']' (otherlv_4= ':' ( (lv_rules_5_0= ruleTrcRule ) ) (otherlv_6= ',' ( (lv_rules_7_0= ruleTrcRule ) ) )* )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:318:1: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '[' ( (lv_path_2_0= ruleEString ) ) otherlv_3= ']' (otherlv_4= ':' ( (lv_rules_5_0= ruleTrcRule ) ) (otherlv_6= ',' ( (lv_rules_7_0= ruleTrcRule ) ) )* )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:318:2: ( (lv_name_0_0= ruleEString ) ) otherlv_1= '[' ( (lv_path_2_0= ruleEString ) ) otherlv_3= ']' (otherlv_4= ':' ( (lv_rules_5_0= ruleTrcRule ) ) (otherlv_6= ',' ( (lv_rules_7_0= ruleTrcRule ) ) )* )?
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:318:2: ( (lv_name_0_0= ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:319:1: (lv_name_0_0= ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:319:1: (lv_name_0_0= ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:320:3: lv_name_0_0= ruleEString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleAccess().getNameEStringParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEString_in_ruleModule670);
            lv_name_0_0=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModuleRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"EString");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleModule682); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getModuleAccess().getLeftSquareBracketKeyword_1());
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:340:1: ( (lv_path_2_0= ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:341:1: (lv_path_2_0= ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:341:1: (lv_path_2_0= ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:342:3: lv_path_2_0= ruleEString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getModuleAccess().getPathEStringParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEString_in_ruleModule703);
            lv_path_2_0=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getModuleRule());
              	        }
                     		set(
                     			current, 
                     			"path",
                      		lv_path_2_0, 
                      		"EString");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleModule715); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getModuleAccess().getRightSquareBracketKeyword_3());
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:362:1: (otherlv_4= ':' ( (lv_rules_5_0= ruleTrcRule ) ) (otherlv_6= ',' ( (lv_rules_7_0= ruleTrcRule ) ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==19) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:362:3: otherlv_4= ':' ( (lv_rules_5_0= ruleTrcRule ) ) (otherlv_6= ',' ( (lv_rules_7_0= ruleTrcRule ) ) )*
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_19_in_ruleModule728); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getModuleAccess().getColonKeyword_4_0());
                          
                    }
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:366:1: ( (lv_rules_5_0= ruleTrcRule ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:367:1: (lv_rules_5_0= ruleTrcRule )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:367:1: (lv_rules_5_0= ruleTrcRule )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:368:3: lv_rules_5_0= ruleTrcRule
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getModuleAccess().getRulesTrcRuleParserRuleCall_4_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTrcRule_in_ruleModule749);
                    lv_rules_5_0=ruleTrcRule();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getModuleRule());
                      	        }
                             		add(
                             			current, 
                             			"rules",
                              		lv_rules_5_0, 
                              		"TrcRule");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:384:2: (otherlv_6= ',' ( (lv_rules_7_0= ruleTrcRule ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==20) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:384:4: otherlv_6= ',' ( (lv_rules_7_0= ruleTrcRule ) )
                    	    {
                    	    otherlv_6=(Token)match(input,20,FOLLOW_20_in_ruleModule762); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_6, grammarAccess.getModuleAccess().getCommaKeyword_4_2_0());
                    	          
                    	    }
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:388:1: ( (lv_rules_7_0= ruleTrcRule ) )
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:389:1: (lv_rules_7_0= ruleTrcRule )
                    	    {
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:389:1: (lv_rules_7_0= ruleTrcRule )
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:390:3: lv_rules_7_0= ruleTrcRule
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getModuleAccess().getRulesTrcRuleParserRuleCall_4_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTrcRule_in_ruleModule783);
                    	    lv_rules_7_0=ruleTrcRule();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getModuleRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"rules",
                    	              		lv_rules_7_0, 
                    	              		"TrcRule");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleModule"


    // $ANTLR start "entryRuleTransformationList"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:414:1: entryRuleTransformationList returns [EObject current=null] : iv_ruleTransformationList= ruleTransformationList EOF ;
    public final EObject entryRuleTransformationList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationList = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:415:2: (iv_ruleTransformationList= ruleTransformationList EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:416:2: iv_ruleTransformationList= ruleTransformationList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransformationListRule()); 
            }
            pushFollow(FOLLOW_ruleTransformationList_in_entryRuleTransformationList823);
            iv_ruleTransformationList=ruleTransformationList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransformationList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationList833); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransformationList"


    // $ANTLR start "ruleTransformationList"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:423:1: ruleTransformationList returns [EObject current=null] : (otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleTransformationList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_transformations_2_0 = null;

        EObject lv_transformations_4_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:426:28: ( (otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:427:1: (otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:427:1: (otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:427:3: otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleTransformationList870); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTransformationListAccess().getTransformationsKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleTransformationList882); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTransformationListAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:435:1: ( (lv_transformations_2_0= ruleTransformation ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:436:1: (lv_transformations_2_0= ruleTransformation )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:436:1: (lv_transformations_2_0= ruleTransformation )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:437:3: lv_transformations_2_0= ruleTransformation
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransformationListAccess().getTransformationsTransformationParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTransformation_in_ruleTransformationList903);
            lv_transformations_2_0=ruleTransformation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTransformationListRule());
              	        }
                     		add(
                     			current, 
                     			"transformations",
                      		lv_transformations_2_0, 
                      		"Transformation");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:453:2: (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==20) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:453:4: otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) )
            	    {
            	    otherlv_3=(Token)match(input,20,FOLLOW_20_in_ruleTransformationList916); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_3, grammarAccess.getTransformationListAccess().getCommaKeyword_3_0());
            	          
            	    }
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:457:1: ( (lv_transformations_4_0= ruleTransformation ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:458:1: (lv_transformations_4_0= ruleTransformation )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:458:1: (lv_transformations_4_0= ruleTransformation )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:459:3: lv_transformations_4_0= ruleTransformation
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTransformationListAccess().getTransformationsTransformationParserRuleCall_3_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTransformation_in_ruleTransformationList937);
            	    lv_transformations_4_0=ruleTransformation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTransformationListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"transformations",
            	              		lv_transformations_4_0, 
            	              		"Transformation");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleTransformationList951); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getTransformationListAccess().getRightCurlyBracketKeyword_4());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransformationList"


    // $ANTLR start "entryRuleTransformation"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:487:1: entryRuleTransformation returns [EObject current=null] : iv_ruleTransformation= ruleTransformation EOF ;
    public final EObject entryRuleTransformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformation = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:488:2: (iv_ruleTransformation= ruleTransformation EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:489:2: iv_ruleTransformation= ruleTransformation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransformationRule()); 
            }
            pushFollow(FOLLOW_ruleTransformation_in_entryRuleTransformation987);
            iv_ruleTransformation=ruleTransformation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransformation; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformation997); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransformation"


    // $ANTLR start "ruleTransformation"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:496:1: ruleTransformation returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}' ) ;
    public final EObject ruleTransformation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_impacts_9_0 = null;

        EObject lv_impacts_11_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:499:28: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:500:1: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:500:1: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:500:2: ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}'
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:500:2: ( (lv_name_0_0= ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:501:1: (lv_name_0_0= ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:501:1: (lv_name_0_0= ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:502:3: lv_name_0_0= ruleEString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransformationAccess().getNameEStringParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEString_in_ruleTransformation1043);
            lv_name_0_0=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTransformationRule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_0_0, 
                      		"EString");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleTransformation1055); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,22,FOLLOW_22_in_ruleTransformation1067); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getTransformationAccess().getModulesKeyword_2());
                  
            }
            otherlv_3=(Token)match(input,19,FOLLOW_19_in_ruleTransformation1079); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTransformationAccess().getColonKeyword_3());
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:530:1: ( (otherlv_4= RULE_ID ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:531:1: (otherlv_4= RULE_ID )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:531:1: (otherlv_4= RULE_ID )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:532:3: otherlv_4= RULE_ID
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTransformationRule());
              	        }
                      
            }
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransformation1103); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_4, grammarAccess.getTransformationAccess().getModulesModuleCrossReference_4_0()); 
              	
            }

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:546:2: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==20) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:546:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleTransformation1116); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getTransformationAccess().getCommaKeyword_5_0());
            	          
            	    }
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:550:1: ( (otherlv_6= RULE_ID ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:551:1: (otherlv_6= RULE_ID )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:551:1: (otherlv_6= RULE_ID )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:552:3: otherlv_6= RULE_ID
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      		  /* */ 
            	      		
            	    }
            	    if ( state.backtracking==0 ) {

            	      			if (current==null) {
            	      	            current = createModelElement(grammarAccess.getTransformationRule());
            	      	        }
            	              
            	    }
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransformation1140); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		newLeafNode(otherlv_6, grammarAccess.getTransformationAccess().getModulesModuleCrossReference_5_1_0()); 
            	      	
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:566:4: (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==23) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:566:6: otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )*
                    {
                    otherlv_7=(Token)match(input,23,FOLLOW_23_in_ruleTransformation1155); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getTransformationAccess().getImpactsKeyword_6_0());
                          
                    }
                    otherlv_8=(Token)match(input,19,FOLLOW_19_in_ruleTransformation1167); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getTransformationAccess().getColonKeyword_6_1());
                          
                    }
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:574:1: ( (lv_impacts_9_0= ruleTransformationImpact ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:575:1: (lv_impacts_9_0= ruleTransformationImpact )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:575:1: (lv_impacts_9_0= ruleTransformationImpact )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:576:3: lv_impacts_9_0= ruleTransformationImpact
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransformationAccess().getImpactsTransformationImpactParserRuleCall_6_2_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleTransformationImpact_in_ruleTransformation1188);
                    lv_impacts_9_0=ruleTransformationImpact();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTransformationRule());
                      	        }
                             		add(
                             			current, 
                             			"impacts",
                              		lv_impacts_9_0, 
                              		"TransformationImpact");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:592:2: (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==20) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:592:4: otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) )
                    	    {
                    	    otherlv_10=(Token)match(input,20,FOLLOW_20_in_ruleTransformation1201); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_10, grammarAccess.getTransformationAccess().getCommaKeyword_6_3_0());
                    	          
                    	    }
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:596:1: ( (lv_impacts_11_0= ruleTransformationImpact ) )
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:597:1: (lv_impacts_11_0= ruleTransformationImpact )
                    	    {
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:597:1: (lv_impacts_11_0= ruleTransformationImpact )
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:598:3: lv_impacts_11_0= ruleTransformationImpact
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getTransformationAccess().getImpactsTransformationImpactParserRuleCall_6_3_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleTransformationImpact_in_ruleTransformation1222);
                    	    lv_impacts_11_0=ruleTransformationImpact();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getTransformationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"impacts",
                    	              		lv_impacts_11_0, 
                    	              		"TransformationImpact");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,15,FOLLOW_15_in_ruleTransformation1238); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_7());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransformation"


    // $ANTLR start "entryRuleTransformationImpact"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:626:1: entryRuleTransformationImpact returns [EObject current=null] : iv_ruleTransformationImpact= ruleTransformationImpact EOF ;
    public final EObject entryRuleTransformationImpact() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationImpact = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:627:2: (iv_ruleTransformationImpact= ruleTransformationImpact EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:628:2: iv_ruleTransformationImpact= ruleTransformationImpact EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransformationImpactRule()); 
            }
            pushFollow(FOLLOW_ruleTransformationImpact_in_entryRuleTransformationImpact1274);
            iv_ruleTransformationImpact=ruleTransformationImpact();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransformationImpact; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationImpact1284); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransformationImpact"


    // $ANTLR start "ruleTransformationImpact"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:635:1: ruleTransformationImpact returns [EObject current=null] : (otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')' ) ;
    public final EObject ruleTransformationImpact() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_qualityAttributeName_1_0 = null;

        AntlrDatatypeRuleToken lv_impactValue_3_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:638:28: ( (otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:639:1: (otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:639:1: (otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:639:3: otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleTransformationImpact1321); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTransformationImpactAccess().getLeftParenthesisKeyword_0());
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:643:1: ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=RULE_ID && LA9_0<=RULE_STRING)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:643:2: ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ','
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:643:2: ( (lv_qualityAttributeName_1_0= ruleEString ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:644:1: (lv_qualityAttributeName_1_0= ruleEString )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:644:1: (lv_qualityAttributeName_1_0= ruleEString )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:645:3: lv_qualityAttributeName_1_0= ruleEString
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getTransformationImpactAccess().getQualityAttributeNameEStringParserRuleCall_1_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleEString_in_ruleTransformationImpact1343);
                    lv_qualityAttributeName_1_0=ruleEString();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getTransformationImpactRule());
                      	        }
                             		set(
                             			current, 
                             			"qualityAttributeName",
                              		lv_qualityAttributeName_1_0, 
                              		"EString");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleTransformationImpact1355); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getTransformationImpactAccess().getCommaKeyword_1_1());
                          
                    }

                    }
                    break;

            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:665:3: ( (lv_impactValue_3_0= ruleEInt ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:666:1: (lv_impactValue_3_0= ruleEInt )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:666:1: (lv_impactValue_3_0= ruleEInt )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:667:3: lv_impactValue_3_0= ruleEInt
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransformationImpactAccess().getImpactValueEIntParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEInt_in_ruleTransformationImpact1378);
            lv_impactValue_3_0=ruleEInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTransformationImpactRule());
              	        }
                     		set(
                     			current, 
                     			"impactValue",
                      		lv_impactValue_3_0, 
                      		"EInt");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_4=(Token)match(input,25,FOLLOW_25_in_ruleTransformationImpact1390); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_4, grammarAccess.getTransformationImpactAccess().getRightParenthesisKeyword_3());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransformationImpact"


    // $ANTLR start "entryRuleTransformationDependencyList"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:695:1: entryRuleTransformationDependencyList returns [EObject current=null] : iv_ruleTransformationDependencyList= ruleTransformationDependencyList EOF ;
    public final EObject entryRuleTransformationDependencyList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationDependencyList = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:696:2: (iv_ruleTransformationDependencyList= ruleTransformationDependencyList EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:697:2: iv_ruleTransformationDependencyList= ruleTransformationDependencyList EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransformationDependencyListRule()); 
            }
            pushFollow(FOLLOW_ruleTransformationDependencyList_in_entryRuleTransformationDependencyList1426);
            iv_ruleTransformationDependencyList=ruleTransformationDependencyList();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransformationDependencyList; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationDependencyList1436); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransformationDependencyList"


    // $ANTLR start "ruleTransformationDependencyList"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:704:1: ruleTransformationDependencyList returns [EObject current=null] : (otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_transformationDependencies_2_0= ruleTransformationDependency ) ) otherlv_3= ';' ( ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) otherlv_5= ';' )* otherlv_6= '}' ) ;
    public final EObject ruleTransformationDependencyList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        EObject lv_transformationDependencies_2_0 = null;

        EObject lv_transformationDependencies_4_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:707:28: ( (otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_transformationDependencies_2_0= ruleTransformationDependency ) ) otherlv_3= ';' ( ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) otherlv_5= ';' )* otherlv_6= '}' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:708:1: (otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_transformationDependencies_2_0= ruleTransformationDependency ) ) otherlv_3= ';' ( ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) otherlv_5= ';' )* otherlv_6= '}' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:708:1: (otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_transformationDependencies_2_0= ruleTransformationDependency ) ) otherlv_3= ';' ( ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) otherlv_5= ';' )* otherlv_6= '}' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:708:3: otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_transformationDependencies_2_0= ruleTransformationDependency ) ) otherlv_3= ';' ( ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) otherlv_5= ';' )* otherlv_6= '}'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleTransformationDependencyList1473); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTransformationDependencyListAccess().getDependenciesKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleTransformationDependencyList1485); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTransformationDependencyListAccess().getLeftCurlyBracketKeyword_1());
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:716:1: ( (lv_transformationDependencies_2_0= ruleTransformationDependency ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:717:1: (lv_transformationDependencies_2_0= ruleTransformationDependency )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:717:1: (lv_transformationDependencies_2_0= ruleTransformationDependency )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:718:3: lv_transformationDependencies_2_0= ruleTransformationDependency
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesTransformationDependencyParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleTransformationDependency_in_ruleTransformationDependencyList1506);
            lv_transformationDependencies_2_0=ruleTransformationDependency();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTransformationDependencyListRule());
              	        }
                     		add(
                     			current, 
                     			"transformationDependencies",
                      		lv_transformationDependencies_2_0, 
                      		"TransformationDependency");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleTransformationDependencyList1518); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTransformationDependencyListAccess().getSemicolonKeyword_3());
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:738:1: ( ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) otherlv_5= ';' )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==27) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:738:2: ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) otherlv_5= ';'
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:738:2: ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:739:1: (lv_transformationDependencies_4_0= ruleTransformationDependency )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:739:1: (lv_transformationDependencies_4_0= ruleTransformationDependency )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:740:3: lv_transformationDependencies_4_0= ruleTransformationDependency
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesTransformationDependencyParserRuleCall_4_0_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleTransformationDependency_in_ruleTransformationDependencyList1540);
            	    lv_transformationDependencies_4_0=ruleTransformationDependency();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTransformationDependencyListRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"transformationDependencies",
            	              		lv_transformationDependencies_4_0, 
            	              		"TransformationDependency");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }

            	    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleTransformationDependencyList1552); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_5, grammarAccess.getTransformationDependencyListAccess().getSemicolonKeyword_4_1());
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleTransformationDependencyList1566); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getTransformationDependencyListAccess().getRightCurlyBracketKeyword_5());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransformationDependencyList"


    // $ANTLR start "entryRuleTransformationDependency"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:772:1: entryRuleTransformationDependency returns [EObject current=null] : iv_ruleTransformationDependency= ruleTransformationDependency EOF ;
    public final EObject entryRuleTransformationDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationDependency = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:773:2: (iv_ruleTransformationDependency= ruleTransformationDependency EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:774:2: iv_ruleTransformationDependency= ruleTransformationDependency EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTransformationDependencyRule()); 
            }
            pushFollow(FOLLOW_ruleTransformationDependency_in_entryRuleTransformationDependency1602);
            iv_ruleTransformationDependency=ruleTransformationDependency();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTransformationDependency; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationDependency1612); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleTransformationDependency"


    // $ANTLR start "ruleTransformationDependency"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:781:1: ruleTransformationDependency returns [EObject current=null] : (otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_variableId_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_variableId_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) otherlv_14= ']' ) ;
    public final EObject ruleTransformationDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_14=null;
        AntlrDatatypeRuleToken lv_variableId_7_0 = null;

        AntlrDatatypeRuleToken lv_variableId_9_0 = null;

        EObject lv_requiredTransformations_13_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:784:28: ( (otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_variableId_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_variableId_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) otherlv_14= ']' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:785:1: (otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_variableId_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_variableId_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) otherlv_14= ']' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:785:1: (otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_variableId_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_variableId_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) otherlv_14= ']' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:785:3: otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_variableId_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_variableId_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) otherlv_14= ']'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_27_in_ruleTransformationDependency1649); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getTransformationDependencyAccess().getApplyKeyword_0());
                  
            }
            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleTransformationDependency1661); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getTransformationDependencyAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:793:1: ( ( ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:794:1: ( ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:794:1: ( ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:795:3: ruleEString
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTransformationDependencyRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationTransformationCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEString_in_ruleTransformationDependency1688);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleTransformationDependency1700); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getTransformationDependencyAccess().getFullStopKeyword_3());
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:815:1: ( ( ruleQualifiedName ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:816:1: ( ruleQualifiedName )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:816:1: ( ruleQualifiedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:817:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getTransformationDependencyRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getAppliedRuleTrcRuleCrossReference_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTransformationDependency1727);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleTransformationDependency1739); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getTransformationDependencyAccess().getCommaKeyword_5());
                  
            }
            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleTransformationDependency1751); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getTransformationDependencyAccess().getLeftCurlyBracketKeyword_6());
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:841:1: ( (lv_variableId_7_0= ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:842:1: (lv_variableId_7_0= ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:842:1: (lv_variableId_7_0= ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:843:3: lv_variableId_7_0= ruleEString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getVariableIdEStringParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEString_in_ruleTransformationDependency1772);
            lv_variableId_7_0=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTransformationDependencyRule());
              	        }
                     		add(
                     			current, 
                     			"variableId",
                      		lv_variableId_7_0, 
                      		"EString");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:859:2: (otherlv_8= ',' ( (lv_variableId_9_0= ruleEString ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==20) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:859:4: otherlv_8= ',' ( (lv_variableId_9_0= ruleEString ) )
            	    {
            	    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleTransformationDependency1785); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_8, grammarAccess.getTransformationDependencyAccess().getCommaKeyword_8_0());
            	          
            	    }
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:863:1: ( (lv_variableId_9_0= ruleEString ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:864:1: (lv_variableId_9_0= ruleEString )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:864:1: (lv_variableId_9_0= ruleEString )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:865:3: lv_variableId_9_0= ruleEString
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getVariableIdEStringParserRuleCall_8_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEString_in_ruleTransformationDependency1806);
            	    lv_variableId_9_0=ruleEString();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getTransformationDependencyRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"variableId",
            	              		lv_variableId_9_0, 
            	              		"EString");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_10=(Token)match(input,15,FOLLOW_15_in_ruleTransformationDependency1820); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getTransformationDependencyAccess().getRightCurlyBracketKeyword_9());
                  
            }
            otherlv_11=(Token)match(input,25,FOLLOW_25_in_ruleTransformationDependency1832); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getTransformationDependencyAccess().getRightParenthesisKeyword_10());
                  
            }
            otherlv_12=(Token)match(input,17,FOLLOW_17_in_ruleTransformationDependency1844); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_12, grammarAccess.getTransformationDependencyAccess().getLeftSquareBracketKeyword_11());
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:893:1: ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:894:1: (lv_requiredTransformations_13_0= ruleAbstractRuleDependency )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:894:1: (lv_requiredTransformations_13_0= ruleAbstractRuleDependency )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:895:3: lv_requiredTransformations_13_0= ruleAbstractRuleDependency
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_ruleTransformationDependency1865);
            lv_requiredTransformations_13_0=ruleAbstractRuleDependency();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getTransformationDependencyRule());
              	        }
                     		set(
                     			current, 
                     			"requiredTransformations",
                      		lv_requiredTransformations_13_0, 
                      		"AbstractRuleDependency");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_14=(Token)match(input,18,FOLLOW_18_in_ruleTransformationDependency1877); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_14, grammarAccess.getTransformationDependencyAccess().getRightSquareBracketKeyword_13());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleTransformationDependency"


    // $ANTLR start "entryRuleRuleDependencyDisjunction"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:923:1: entryRuleRuleDependencyDisjunction returns [EObject current=null] : iv_ruleRuleDependencyDisjunction= ruleRuleDependencyDisjunction EOF ;
    public final EObject entryRuleRuleDependencyDisjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDependencyDisjunction = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:924:2: (iv_ruleRuleDependencyDisjunction= ruleRuleDependencyDisjunction EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:925:2: iv_ruleRuleDependencyDisjunction= ruleRuleDependencyDisjunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleDependencyDisjunctionRule()); 
            }
            pushFollow(FOLLOW_ruleRuleDependencyDisjunction_in_entryRuleRuleDependencyDisjunction1913);
            iv_ruleRuleDependencyDisjunction=ruleRuleDependencyDisjunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleDependencyDisjunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDependencyDisjunction1923); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleDependencyDisjunction"


    // $ANTLR start "ruleRuleDependencyDisjunction"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:932:1: ruleRuleDependencyDisjunction returns [EObject current=null] : ( ( (lv_requiredTransformations_0_0= ruleAbstractRuleDependency ) ) (otherlv_1= 'or' ( (lv_requiredTransformations_2_0= ruleAbstractRuleDependency ) ) )+ ) ;
    public final EObject ruleRuleDependencyDisjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_requiredTransformations_0_0 = null;

        EObject lv_requiredTransformations_2_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:935:28: ( ( ( (lv_requiredTransformations_0_0= ruleAbstractRuleDependency ) ) (otherlv_1= 'or' ( (lv_requiredTransformations_2_0= ruleAbstractRuleDependency ) ) )+ ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:936:1: ( ( (lv_requiredTransformations_0_0= ruleAbstractRuleDependency ) ) (otherlv_1= 'or' ( (lv_requiredTransformations_2_0= ruleAbstractRuleDependency ) ) )+ )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:936:1: ( ( (lv_requiredTransformations_0_0= ruleAbstractRuleDependency ) ) (otherlv_1= 'or' ( (lv_requiredTransformations_2_0= ruleAbstractRuleDependency ) ) )+ )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:936:2: ( (lv_requiredTransformations_0_0= ruleAbstractRuleDependency ) ) (otherlv_1= 'or' ( (lv_requiredTransformations_2_0= ruleAbstractRuleDependency ) ) )+
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:936:2: ( (lv_requiredTransformations_0_0= ruleAbstractRuleDependency ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:937:1: (lv_requiredTransformations_0_0= ruleAbstractRuleDependency )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:937:1: (lv_requiredTransformations_0_0= ruleAbstractRuleDependency )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:938:3: lv_requiredTransformations_0_0= ruleAbstractRuleDependency
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRuleDependencyDisjunctionAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_ruleRuleDependencyDisjunction1969);
            lv_requiredTransformations_0_0=ruleAbstractRuleDependency();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRuleDependencyDisjunctionRule());
              	        }
                     		add(
                     			current, 
                     			"requiredTransformations",
                      		lv_requiredTransformations_0_0, 
                      		"AbstractRuleDependency");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:954:2: (otherlv_1= 'or' ( (lv_requiredTransformations_2_0= ruleAbstractRuleDependency ) ) )+
            int cnt12=0;
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==28) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:954:4: otherlv_1= 'or' ( (lv_requiredTransformations_2_0= ruleAbstractRuleDependency ) )
            	    {
            	    otherlv_1=(Token)match(input,28,FOLLOW_28_in_ruleRuleDependencyDisjunction1982); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getRuleDependencyDisjunctionAccess().getOrKeyword_1_0());
            	          
            	    }
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:958:1: ( (lv_requiredTransformations_2_0= ruleAbstractRuleDependency ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:959:1: (lv_requiredTransformations_2_0= ruleAbstractRuleDependency )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:959:1: (lv_requiredTransformations_2_0= ruleAbstractRuleDependency )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:960:3: lv_requiredTransformations_2_0= ruleAbstractRuleDependency
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRuleDependencyDisjunctionAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAbstractRuleDependency_in_ruleRuleDependencyDisjunction2003);
            	    lv_requiredTransformations_2_0=ruleAbstractRuleDependency();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRuleDependencyDisjunctionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"requiredTransformations",
            	              		lv_requiredTransformations_2_0, 
            	              		"AbstractRuleDependency");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt12 >= 1 ) break loop12;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(12, input);
                        throw eee;
                }
                cnt12++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleDependencyDisjunction"


    // $ANTLR start "entryRuleRuleDependencyComposite"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:984:1: entryRuleRuleDependencyComposite returns [EObject current=null] : iv_ruleRuleDependencyComposite= ruleRuleDependencyComposite EOF ;
    public final EObject entryRuleRuleDependencyComposite() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDependencyComposite = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:985:2: (iv_ruleRuleDependencyComposite= ruleRuleDependencyComposite EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:986:2: iv_ruleRuleDependencyComposite= ruleRuleDependencyComposite EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleDependencyCompositeRule()); 
            }
            pushFollow(FOLLOW_ruleRuleDependencyComposite_in_entryRuleRuleDependencyComposite2041);
            iv_ruleRuleDependencyComposite=ruleRuleDependencyComposite();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleDependencyComposite; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDependencyComposite2051); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleDependencyComposite"


    // $ANTLR start "ruleRuleDependencyComposite"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:993:1: ruleRuleDependencyComposite returns [EObject current=null] : ( (otherlv_0= '(' this_RuleDependencyConjunction_1= ruleRuleDependencyConjunction otherlv_2= ')' ) | (otherlv_3= '(' this_RuleDependencyDisjunction_4= ruleRuleDependencyDisjunction otherlv_5= ')' ) ) ;
    public final EObject ruleRuleDependencyComposite() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject this_RuleDependencyConjunction_1 = null;

        EObject this_RuleDependencyDisjunction_4 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:996:28: ( ( (otherlv_0= '(' this_RuleDependencyConjunction_1= ruleRuleDependencyConjunction otherlv_2= ')' ) | (otherlv_3= '(' this_RuleDependencyDisjunction_4= ruleRuleDependencyDisjunction otherlv_5= ')' ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:997:1: ( (otherlv_0= '(' this_RuleDependencyConjunction_1= ruleRuleDependencyConjunction otherlv_2= ')' ) | (otherlv_3= '(' this_RuleDependencyDisjunction_4= ruleRuleDependencyDisjunction otherlv_5= ')' ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:997:1: ( (otherlv_0= '(' this_RuleDependencyConjunction_1= ruleRuleDependencyConjunction otherlv_2= ')' ) | (otherlv_3= '(' this_RuleDependencyDisjunction_4= ruleRuleDependencyDisjunction otherlv_5= ')' ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                int LA13_1 = input.LA(2);

                if ( (synpred13_InternalTRC()) ) {
                    alt13=1;
                }
                else if ( (true) ) {
                    alt13=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 13, 1, input);

                    throw nvae;
                }
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:997:2: (otherlv_0= '(' this_RuleDependencyConjunction_1= ruleRuleDependencyConjunction otherlv_2= ')' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:997:2: (otherlv_0= '(' this_RuleDependencyConjunction_1= ruleRuleDependencyConjunction otherlv_2= ')' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:997:4: otherlv_0= '(' this_RuleDependencyConjunction_1= ruleRuleDependencyConjunction otherlv_2= ')'
                    {
                    otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleRuleDependencyComposite2089); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getRuleDependencyCompositeAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRuleDependencyCompositeAccess().getRuleDependencyConjunctionParserRuleCall_0_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRuleDependencyConjunction_in_ruleRuleDependencyComposite2114);
                    this_RuleDependencyConjunction_1=ruleRuleDependencyConjunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RuleDependencyConjunction_1; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_2=(Token)match(input,25,FOLLOW_25_in_ruleRuleDependencyComposite2125); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getRuleDependencyCompositeAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1018:6: (otherlv_3= '(' this_RuleDependencyDisjunction_4= ruleRuleDependencyDisjunction otherlv_5= ')' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1018:6: (otherlv_3= '(' this_RuleDependencyDisjunction_4= ruleRuleDependencyDisjunction otherlv_5= ')' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1018:8: otherlv_3= '(' this_RuleDependencyDisjunction_4= ruleRuleDependencyDisjunction otherlv_5= ')'
                    {
                    otherlv_3=(Token)match(input,24,FOLLOW_24_in_ruleRuleDependencyComposite2145); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_3, grammarAccess.getRuleDependencyCompositeAccess().getLeftParenthesisKeyword_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getRuleDependencyCompositeAccess().getRuleDependencyDisjunctionParserRuleCall_1_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRuleDependencyDisjunction_in_ruleRuleDependencyComposite2170);
                    this_RuleDependencyDisjunction_4=ruleRuleDependencyDisjunction();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RuleDependencyDisjunction_4; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleRuleDependencyComposite2181); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getRuleDependencyCompositeAccess().getRightParenthesisKeyword_1_2());
                          
                    }

                    }


                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleDependencyComposite"


    // $ANTLR start "entryRuleRuleDependencyConjunction"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1046:1: entryRuleRuleDependencyConjunction returns [EObject current=null] : iv_ruleRuleDependencyConjunction= ruleRuleDependencyConjunction EOF ;
    public final EObject entryRuleRuleDependencyConjunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDependencyConjunction = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1047:2: (iv_ruleRuleDependencyConjunction= ruleRuleDependencyConjunction EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1048:2: iv_ruleRuleDependencyConjunction= ruleRuleDependencyConjunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleDependencyConjunctionRule()); 
            }
            pushFollow(FOLLOW_ruleRuleDependencyConjunction_in_entryRuleRuleDependencyConjunction2218);
            iv_ruleRuleDependencyConjunction=ruleRuleDependencyConjunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleDependencyConjunction; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDependencyConjunction2228); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleDependencyConjunction"


    // $ANTLR start "ruleRuleDependencyConjunction"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1055:1: ruleRuleDependencyConjunction returns [EObject current=null] : ( ( (lv_requiredTransformations_0_0= ruleAbstractRuleDependency ) ) (otherlv_1= 'and' ( (lv_requiredTransformations_2_0= ruleAbstractRuleDependency ) ) )+ ) ;
    public final EObject ruleRuleDependencyConjunction() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_requiredTransformations_0_0 = null;

        EObject lv_requiredTransformations_2_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1058:28: ( ( ( (lv_requiredTransformations_0_0= ruleAbstractRuleDependency ) ) (otherlv_1= 'and' ( (lv_requiredTransformations_2_0= ruleAbstractRuleDependency ) ) )+ ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1059:1: ( ( (lv_requiredTransformations_0_0= ruleAbstractRuleDependency ) ) (otherlv_1= 'and' ( (lv_requiredTransformations_2_0= ruleAbstractRuleDependency ) ) )+ )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1059:1: ( ( (lv_requiredTransformations_0_0= ruleAbstractRuleDependency ) ) (otherlv_1= 'and' ( (lv_requiredTransformations_2_0= ruleAbstractRuleDependency ) ) )+ )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1059:2: ( (lv_requiredTransformations_0_0= ruleAbstractRuleDependency ) ) (otherlv_1= 'and' ( (lv_requiredTransformations_2_0= ruleAbstractRuleDependency ) ) )+
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1059:2: ( (lv_requiredTransformations_0_0= ruleAbstractRuleDependency ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1060:1: (lv_requiredTransformations_0_0= ruleAbstractRuleDependency )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1060:1: (lv_requiredTransformations_0_0= ruleAbstractRuleDependency )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1061:3: lv_requiredTransformations_0_0= ruleAbstractRuleDependency
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRuleDependencyConjunctionAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_ruleRuleDependencyConjunction2274);
            lv_requiredTransformations_0_0=ruleAbstractRuleDependency();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRuleDependencyConjunctionRule());
              	        }
                     		add(
                     			current, 
                     			"requiredTransformations",
                      		lv_requiredTransformations_0_0, 
                      		"AbstractRuleDependency");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1077:2: (otherlv_1= 'and' ( (lv_requiredTransformations_2_0= ruleAbstractRuleDependency ) ) )+
            int cnt14=0;
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==29) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1077:4: otherlv_1= 'and' ( (lv_requiredTransformations_2_0= ruleAbstractRuleDependency ) )
            	    {
            	    otherlv_1=(Token)match(input,29,FOLLOW_29_in_ruleRuleDependencyConjunction2287); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_1, grammarAccess.getRuleDependencyConjunctionAccess().getAndKeyword_1_0());
            	          
            	    }
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1081:1: ( (lv_requiredTransformations_2_0= ruleAbstractRuleDependency ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1082:1: (lv_requiredTransformations_2_0= ruleAbstractRuleDependency )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1082:1: (lv_requiredTransformations_2_0= ruleAbstractRuleDependency )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1083:3: lv_requiredTransformations_2_0= ruleAbstractRuleDependency
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRuleDependencyConjunctionAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_1_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleAbstractRuleDependency_in_ruleRuleDependencyConjunction2308);
            	    lv_requiredTransformations_2_0=ruleAbstractRuleDependency();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRuleDependencyConjunctionRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"requiredTransformations",
            	              		lv_requiredTransformations_2_0, 
            	              		"AbstractRuleDependency");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt14 >= 1 ) break loop14;
            	    if (state.backtracking>0) {state.failed=true; return current;}
                        EarlyExitException eee =
                            new EarlyExitException(14, input);
                        throw eee;
                }
                cnt14++;
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleDependencyConjunction"


    // $ANTLR start "entryRuleAbstractRuleDependency"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1107:1: entryRuleAbstractRuleDependency returns [EObject current=null] : iv_ruleAbstractRuleDependency= ruleAbstractRuleDependency EOF ;
    public final EObject entryRuleAbstractRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRuleDependency = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1108:2: (iv_ruleAbstractRuleDependency= ruleAbstractRuleDependency EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1109:2: iv_ruleAbstractRuleDependency= ruleAbstractRuleDependency EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAbstractRuleDependencyRule()); 
            }
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_entryRuleAbstractRuleDependency2346);
            iv_ruleAbstractRuleDependency=ruleAbstractRuleDependency();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAbstractRuleDependency; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRuleDependency2356); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleAbstractRuleDependency"


    // $ANTLR start "ruleAbstractRuleDependency"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1116:1: ruleAbstractRuleDependency returns [EObject current=null] : (this_RuleDependencyComposite_0= ruleRuleDependencyComposite | this_RuleDependency_1= ruleRuleDependency ) ;
    public final EObject ruleAbstractRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject this_RuleDependencyComposite_0 = null;

        EObject this_RuleDependency_1 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1119:28: ( (this_RuleDependencyComposite_0= ruleRuleDependencyComposite | this_RuleDependency_1= ruleRuleDependency ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1120:1: (this_RuleDependencyComposite_0= ruleRuleDependencyComposite | this_RuleDependency_1= ruleRuleDependency )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1120:1: (this_RuleDependencyComposite_0= ruleRuleDependencyComposite | this_RuleDependency_1= ruleRuleDependency )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==24) ) {
                alt15=1;
            }
            else if ( ((LA15_0>=30 && LA15_0<=31)) ) {
                alt15=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1121:2: this_RuleDependencyComposite_0= ruleRuleDependencyComposite
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAbstractRuleDependencyAccess().getRuleDependencyCompositeParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRuleDependencyComposite_in_ruleAbstractRuleDependency2406);
                    this_RuleDependencyComposite_0=ruleRuleDependencyComposite();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RuleDependencyComposite_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1134:2: this_RuleDependency_1= ruleRuleDependency
                    {
                    if ( state.backtracking==0 ) {
                       
                      	  /* */ 
                      	
                    }
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getAbstractRuleDependencyAccess().getRuleDependencyParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleRuleDependency_in_ruleAbstractRuleDependency2436);
                    this_RuleDependency_1=ruleRuleDependency();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_RuleDependency_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleAbstractRuleDependency"


    // $ANTLR start "entryRuleRuleDependency"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1153:1: entryRuleRuleDependency returns [EObject current=null] : iv_ruleRuleDependency= ruleRuleDependency EOF ;
    public final EObject entryRuleRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDependency = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1154:2: (iv_ruleRuleDependency= ruleRuleDependency EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1155:2: iv_ruleRuleDependency= ruleRuleDependency EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getRuleDependencyRule()); 
            }
            pushFollow(FOLLOW_ruleRuleDependency_in_entryRuleRuleDependency2471);
            iv_ruleRuleDependency=ruleRuleDependency();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleRuleDependency; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDependency2481); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleRuleDependency"


    // $ANTLR start "ruleRuleDependency"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1162:1: ruleRuleDependency returns [EObject current=null] : ( ( ( (lv_type_0_1= 'requires' | lv_type_0_2= 'excludes' ) ) ) otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fieldNames_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fieldNames_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' ) ;
    public final EObject ruleRuleDependency() throws RecognitionException {
        EObject current = null;

        Token lv_type_0_1=null;
        Token lv_type_0_2=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        AntlrDatatypeRuleToken lv_fieldNames_7_0 = null;

        AntlrDatatypeRuleToken lv_fieldNames_9_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1165:28: ( ( ( ( (lv_type_0_1= 'requires' | lv_type_0_2= 'excludes' ) ) ) otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fieldNames_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fieldNames_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1166:1: ( ( ( (lv_type_0_1= 'requires' | lv_type_0_2= 'excludes' ) ) ) otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fieldNames_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fieldNames_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1166:1: ( ( ( (lv_type_0_1= 'requires' | lv_type_0_2= 'excludes' ) ) ) otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fieldNames_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fieldNames_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1166:2: ( ( (lv_type_0_1= 'requires' | lv_type_0_2= 'excludes' ) ) ) otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fieldNames_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fieldNames_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')'
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1166:2: ( ( (lv_type_0_1= 'requires' | lv_type_0_2= 'excludes' ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1167:1: ( (lv_type_0_1= 'requires' | lv_type_0_2= 'excludes' ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1167:1: ( (lv_type_0_1= 'requires' | lv_type_0_2= 'excludes' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1168:1: (lv_type_0_1= 'requires' | lv_type_0_2= 'excludes' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1168:1: (lv_type_0_1= 'requires' | lv_type_0_2= 'excludes' )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==30) ) {
                alt16=1;
            }
            else if ( (LA16_0==31) ) {
                alt16=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1169:3: lv_type_0_1= 'requires'
                    {
                    lv_type_0_1=(Token)match(input,30,FOLLOW_30_in_ruleRuleDependency2526); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_1, grammarAccess.getRuleDependencyAccess().getTypeRequiresKeyword_0_0_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getRuleDependencyRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_1, null);
                      	    
                    }

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1181:8: lv_type_0_2= 'excludes'
                    {
                    lv_type_0_2=(Token)match(input,31,FOLLOW_31_in_ruleRuleDependency2555); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_type_0_2, grammarAccess.getRuleDependencyAccess().getTypeExcludesKeyword_0_0_1());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getRuleDependencyRule());
                      	        }
                             		setWithLastConsumed(current, "type", lv_type_0_2, null);
                      	    
                    }

                    }
                    break;

            }


            }


            }

            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleRuleDependency2583); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getRuleDependencyAccess().getLeftParenthesisKeyword_1());
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1200:1: ( ( ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1201:1: ( ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1201:1: ( ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1202:3: ruleEString
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getRuleDependencyRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRuleDependencyAccess().getRequiredTransformationTransformationCrossReference_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEString_in_ruleRuleDependency2610);
            ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleRuleDependency2622); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_3, grammarAccess.getRuleDependencyAccess().getFullStopKeyword_3());
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1222:1: ( ( ruleQualifiedName ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1223:1: ( ruleQualifiedName )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1223:1: ( ruleQualifiedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1224:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               
              		  /* */ 
              		
            }
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getRuleDependencyRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRuleDependencyAccess().getRequiredRuleTrcRuleCrossReference_4_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleRuleDependency2649);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_5=(Token)match(input,20,FOLLOW_20_in_ruleRuleDependency2661); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getRuleDependencyAccess().getCommaKeyword_5());
                  
            }
            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleRuleDependency2673); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_6, grammarAccess.getRuleDependencyAccess().getLeftCurlyBracketKeyword_6());
                  
            }
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1248:1: ( (lv_fieldNames_7_0= ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1249:1: (lv_fieldNames_7_0= ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1249:1: (lv_fieldNames_7_0= ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1250:3: lv_fieldNames_7_0= ruleEString
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getRuleDependencyAccess().getFieldNamesEStringParserRuleCall_7_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleEString_in_ruleRuleDependency2694);
            lv_fieldNames_7_0=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getRuleDependencyRule());
              	        }
                     		add(
                     			current, 
                     			"fieldNames",
                      		lv_fieldNames_7_0, 
                      		"EString");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1266:2: (otherlv_8= ',' ( (lv_fieldNames_9_0= ruleEString ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==20) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1266:4: otherlv_8= ',' ( (lv_fieldNames_9_0= ruleEString ) )
            	    {
            	    otherlv_8=(Token)match(input,20,FOLLOW_20_in_ruleRuleDependency2707); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	          	newLeafNode(otherlv_8, grammarAccess.getRuleDependencyAccess().getCommaKeyword_8_0());
            	          
            	    }
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1270:1: ( (lv_fieldNames_9_0= ruleEString ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1271:1: (lv_fieldNames_9_0= ruleEString )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1271:1: (lv_fieldNames_9_0= ruleEString )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1272:3: lv_fieldNames_9_0= ruleEString
            	    {
            	    if ( state.backtracking==0 ) {
            	       
            	      	        newCompositeNode(grammarAccess.getRuleDependencyAccess().getFieldNamesEStringParserRuleCall_8_1_0()); 
            	      	    
            	    }
            	    pushFollow(FOLLOW_ruleEString_in_ruleRuleDependency2728);
            	    lv_fieldNames_9_0=ruleEString();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      	        if (current==null) {
            	      	            current = createModelElementForParent(grammarAccess.getRuleDependencyRule());
            	      	        }
            	             		add(
            	             			current, 
            	             			"fieldNames",
            	              		lv_fieldNames_9_0, 
            	              		"EString");
            	      	        afterParserOrEnumRuleCall();
            	      	    
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_10=(Token)match(input,15,FOLLOW_15_in_ruleRuleDependency2742); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getRuleDependencyAccess().getRightCurlyBracketKeyword_9());
                  
            }
            otherlv_11=(Token)match(input,25,FOLLOW_25_in_ruleRuleDependency2754); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_11, grammarAccess.getRuleDependencyAccess().getRightParenthesisKeyword_10());
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleRuleDependency"


    // $ANTLR start "entryRuleEString"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1308:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1309:2: (iv_ruleEString= ruleEString EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1310:2: iv_ruleEString= ruleEString EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEStringRule()); 
            }
            pushFollow(FOLLOW_ruleEString_in_entryRuleEString2795);
            iv_ruleEString=ruleEString();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEString.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEString2806); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEString"


    // $ANTLR start "ruleEString"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1317:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1320:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1321:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1321:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==RULE_STRING) ) {
                alt18=1;
            }
            else if ( (LA18_0==RULE_ID) ) {
                alt18=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1321:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEString2846); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_STRING_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1329:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEString2872); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_ID_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                          newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEString"


    // $ANTLR start "entryRuleEInt"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1344:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1345:2: (iv_ruleEInt= ruleEInt EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1346:2: iv_ruleEInt= ruleEInt EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEIntRule()); 
            }
            pushFollow(FOLLOW_ruleEInt_in_entryRuleEInt2918);
            iv_ruleEInt=ruleEInt();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEInt.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEInt2929); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEInt"


    // $ANTLR start "ruleEInt"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1353:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1356:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1357:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1357:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1357:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1357:2: (kw= '-' )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==32) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1358:2: kw= '-'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleEInt2968); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
                          
                    }

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEInt2985); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_INT_1);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEInt"


    // $ANTLR start "entryRuleEssentialOCLUnrestrictedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1380:1: entryRuleEssentialOCLUnrestrictedName returns [String current=null] : iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF ;
    public final String entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedName = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1381:2: (iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1382:2: iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule()); 
            }
            pushFollow(FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName3033);
            iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnrestrictedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName3044); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLUnrestrictedName"


    // $ANTLR start "ruleEssentialOCLUnrestrictedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1389:1: ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1392:28: (this_Identifier_0= ruleIdentifier )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1394:5: this_Identifier_0= ruleIdentifier
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName3090);
            this_Identifier_0=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_Identifier_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEssentialOCLUnrestrictedName"


    // $ANTLR start "entryRuleIdentifier"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1412:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1413:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1414:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier3135);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier3146); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleIdentifier"


    // $ANTLR start "ruleIdentifier"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1421:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1424:28: (this_ID_0= RULE_ID )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1425:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdentifier3185); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleUnrestrictedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1440:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1441:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1442:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getUnrestrictedNameRule()); 
            }
            pushFollow(FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName3230);
            iv_ruleUnrestrictedName=ruleUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleUnrestrictedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnrestrictedName3241); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleUnrestrictedName"


    // $ANTLR start "ruleUnrestrictedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1449:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1452:28: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1454:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall()); 
                  
            }
            pushFollow(FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName3287);
            this_EssentialOCLUnrestrictedName_0=ruleEssentialOCLUnrestrictedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_EssentialOCLUnrestrictedName_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleUnrestrictedName"


    // $ANTLR start "entryRuleEssentialOCLUnreservedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1478:1: entryRuleEssentialOCLUnreservedName returns [String current=null] : iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF ;
    public final String entryRuleEssentialOCLUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnreservedName = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1479:2: (iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1480:2: iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule()); 
            }
            pushFollow(FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName3338);
            iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEssentialOCLUnreservedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName3349); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleEssentialOCLUnreservedName"


    // $ANTLR start "ruleEssentialOCLUnreservedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1487:1: ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;

        AntlrDatatypeRuleToken this_CollectionTypeIdentifier_1 = null;

        AntlrDatatypeRuleToken this_PrimitiveTypeIdentifier_2 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1490:28: ( (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1491:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1491:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            int alt20=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt20=1;
                }
                break;
            case 42:
            case 43:
            case 44:
            case 45:
            case 46:
                {
                alt20=2;
                }
                break;
            case 34:
            case 35:
            case 36:
            case 37:
            case 38:
            case 39:
            case 40:
            case 41:
                {
                alt20=3;
                }
                break;
            case 33:
                {
                alt20=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }

            switch (alt20) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1492:5: this_UnrestrictedName_0= ruleUnrestrictedName
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName3396);
                    this_UnrestrictedName_0=ruleUnrestrictedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_UnrestrictedName_0);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1504:5: this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName3429);
                    this_CollectionTypeIdentifier_1=ruleCollectionTypeIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_CollectionTypeIdentifier_1);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 3 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1516:5: this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); 
                          
                    }
                    pushFollow(FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName3462);
                    this_PrimitiveTypeIdentifier_2=rulePrimitiveTypeIdentifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      		current.merge(this_PrimitiveTypeIdentifier_2);
                          
                    }
                    if ( state.backtracking==0 ) {
                       
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 4 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1528:2: kw= 'Tuple'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleEssentialOCLUnreservedName3486); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getTupleKeyword_3()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleEssentialOCLUnreservedName"


    // $ANTLR start "entryRulePrimitiveTypeIdentifier"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1541:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
    public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1542:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1543:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); 
            }
            pushFollow(FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier3527);
            iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_rulePrimitiveTypeIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier3538); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRulePrimitiveTypeIdentifier"


    // $ANTLR start "rulePrimitiveTypeIdentifier"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1550:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1553:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1554:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1554:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            int alt21=8;
            switch ( input.LA(1) ) {
            case 34:
                {
                alt21=1;
                }
                break;
            case 35:
                {
                alt21=2;
                }
                break;
            case 36:
                {
                alt21=3;
                }
                break;
            case 37:
                {
                alt21=4;
                }
                break;
            case 38:
                {
                alt21=5;
                }
                break;
            case 39:
                {
                alt21=6;
                }
                break;
            case 40:
                {
                alt21=7;
                }
                break;
            case 41:
                {
                alt21=8;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 21, 0, input);

                throw nvae;
            }

            switch (alt21) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1555:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_rulePrimitiveTypeIdentifier3576); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1562:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,35,FOLLOW_35_in_rulePrimitiveTypeIdentifier3595); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1569:2: kw= 'Real'
                    {
                    kw=(Token)match(input,36,FOLLOW_36_in_rulePrimitiveTypeIdentifier3614); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1576:2: kw= 'String'
                    {
                    kw=(Token)match(input,37,FOLLOW_37_in_rulePrimitiveTypeIdentifier3633); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1583:2: kw= 'UnlimitedNatural'
                    {
                    kw=(Token)match(input,38,FOLLOW_38_in_rulePrimitiveTypeIdentifier3652); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                          
                    }

                    }
                    break;
                case 6 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1590:2: kw= 'OclAny'
                    {
                    kw=(Token)match(input,39,FOLLOW_39_in_rulePrimitiveTypeIdentifier3671); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                          
                    }

                    }
                    break;
                case 7 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1597:2: kw= 'OclInvalid'
                    {
                    kw=(Token)match(input,40,FOLLOW_40_in_rulePrimitiveTypeIdentifier3690); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                          
                    }

                    }
                    break;
                case 8 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1604:2: kw= 'OclVoid'
                    {
                    kw=(Token)match(input,41,FOLLOW_41_in_rulePrimitiveTypeIdentifier3709); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclVoidKeyword_7()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulePrimitiveTypeIdentifier"


    // $ANTLR start "entryRuleCollectionTypeIdentifier"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1617:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1618:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1619:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); 
            }
            pushFollow(FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier3750);
            iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCollectionTypeIdentifier.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier3761); if (state.failed) return current;

            }

        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCollectionTypeIdentifier"


    // $ANTLR start "ruleCollectionTypeIdentifier"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1626:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1629:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1630:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1630:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            int alt22=5;
            switch ( input.LA(1) ) {
            case 42:
                {
                alt22=1;
                }
                break;
            case 43:
                {
                alt22=2;
                }
                break;
            case 44:
                {
                alt22=3;
                }
                break;
            case 45:
                {
                alt22=4;
                }
                break;
            case 46:
                {
                alt22=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }

            switch (alt22) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1631:2: kw= 'Set'
                    {
                    kw=(Token)match(input,42,FOLLOW_42_in_ruleCollectionTypeIdentifier3799); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                          
                    }

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1638:2: kw= 'Bag'
                    {
                    kw=(Token)match(input,43,FOLLOW_43_in_ruleCollectionTypeIdentifier3818); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                          
                    }

                    }
                    break;
                case 3 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1645:2: kw= 'Sequence'
                    {
                    kw=(Token)match(input,44,FOLLOW_44_in_ruleCollectionTypeIdentifier3837); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                          
                    }

                    }
                    break;
                case 4 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1652:2: kw= 'Collection'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleCollectionTypeIdentifier3856); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                          
                    }

                    }
                    break;
                case 5 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1659:2: kw= 'OrderedSet'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_ruleCollectionTypeIdentifier3875); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              current.merge(kw);
                              newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getOrderedSetKeyword_4()); 
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
            }
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCollectionTypeIdentifier"

    // $ANTLR start synpred13_InternalTRC
    public final void synpred13_InternalTRC_fragment() throws RecognitionException {   
        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject this_RuleDependencyConjunction_1 = null;


        // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:997:2: ( (otherlv_0= '(' this_RuleDependencyConjunction_1= ruleRuleDependencyConjunction otherlv_2= ')' ) )
        // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:997:2: (otherlv_0= '(' this_RuleDependencyConjunction_1= ruleRuleDependencyConjunction otherlv_2= ')' )
        {
        // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:997:2: (otherlv_0= '(' this_RuleDependencyConjunction_1= ruleRuleDependencyConjunction otherlv_2= ')' )
        // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:997:4: otherlv_0= '(' this_RuleDependencyConjunction_1= ruleRuleDependencyConjunction otherlv_2= ')'
        {
        otherlv_0=(Token)match(input,24,FOLLOW_24_in_synpred13_InternalTRC2089); if (state.failed) return ;
        pushFollow(FOLLOW_ruleRuleDependencyConjunction_in_synpred13_InternalTRC2114);
        this_RuleDependencyConjunction_1=ruleRuleDependencyConjunction();

        state._fsp--;
        if (state.failed) return ;
        otherlv_2=(Token)match(input,25,FOLLOW_25_in_synpred13_InternalTRC2125); if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred13_InternalTRC

    // Delegated rules

    public final boolean synpred13_InternalTRC() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred13_InternalTRC_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleTrcSpecification_in_entryRuleTrcSpecification81 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrcSpecification91 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModuleList_in_ruleTrcSpecification137 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ruleTransformationList_in_ruleTrcSpecification158 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_ruleTransformationDependencyList_in_ruleTrcSpecification179 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTrcRule_in_entryRuleTrcRule215 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrcRule225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTrcRule270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModuleList_in_entryRuleModuleList305 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModuleList315 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleModuleList352 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleModuleList364 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleModule_in_ruleModuleList385 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleModuleList397 = new BitSet(new long[]{0x0000000000008030L});
    public static final BitSet FOLLOW_ruleModule_in_ruleModuleList419 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleModuleList431 = new BitSet(new long[]{0x0000000000008030L});
    public static final BitSet FOLLOW_15_in_ruleModuleList445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName482 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName533 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleQualifiedName552 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName567 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule614 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_ruleModule670 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleModule682 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleModule703 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleModule715 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleModule728 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTrcRule_in_ruleModule749 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_20_in_ruleModule762 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTrcRule_in_ruleModule783 = new BitSet(new long[]{0x0000000000100002L});
    public static final BitSet FOLLOW_ruleTransformationList_in_entryRuleTransformationList823 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationList833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleTransformationList870 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTransformationList882 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTransformation_in_ruleTransformationList903 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleTransformationList916 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTransformation_in_ruleTransformationList937 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_15_in_ruleTransformationList951 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformation_in_entryRuleTransformation987 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformation997 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformation1043 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTransformation1055 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTransformation1067 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleTransformation1079 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransformation1103 = new BitSet(new long[]{0x0000000000908000L});
    public static final BitSet FOLLOW_20_in_ruleTransformation1116 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransformation1140 = new BitSet(new long[]{0x0000000000908000L});
    public static final BitSet FOLLOW_23_in_ruleTransformation1155 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleTransformation1167 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_ruleTransformation1188 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleTransformation1201 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_ruleTransformation1222 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_15_in_ruleTransformation1238 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_entryRuleTransformationImpact1274 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationImpact1284 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleTransformationImpact1321 = new BitSet(new long[]{0x0000000100000070L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationImpact1343 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleTransformationImpact1355 = new BitSet(new long[]{0x0000000100000070L});
    public static final BitSet FOLLOW_ruleEInt_in_ruleTransformationImpact1378 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleTransformationImpact1390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependencyList_in_entryRuleTransformationDependencyList1426 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationDependencyList1436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleTransformationDependencyList1473 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTransformationDependencyList1485 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_ruleTransformationDependencyList1506 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTransformationDependencyList1518 = new BitSet(new long[]{0x0000000008008000L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_ruleTransformationDependencyList1540 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTransformationDependencyList1552 = new BitSet(new long[]{0x0000000008008000L});
    public static final BitSet FOLLOW_15_in_ruleTransformationDependencyList1566 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_entryRuleTransformationDependency1602 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationDependency1612 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_ruleTransformationDependency1649 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleTransformationDependency1661 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationDependency1688 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTransformationDependency1700 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTransformationDependency1727 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleTransformationDependency1739 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTransformationDependency1751 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationDependency1772 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleTransformationDependency1785 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationDependency1806 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_15_in_ruleTransformationDependency1820 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleTransformationDependency1832 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTransformationDependency1844 = new BitSet(new long[]{0x00000000C1000000L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_ruleTransformationDependency1865 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTransformationDependency1877 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependencyDisjunction_in_entryRuleRuleDependencyDisjunction1913 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDependencyDisjunction1923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_ruleRuleDependencyDisjunction1969 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_28_in_ruleRuleDependencyDisjunction1982 = new BitSet(new long[]{0x00000000C1000000L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_ruleRuleDependencyDisjunction2003 = new BitSet(new long[]{0x0000000010000002L});
    public static final BitSet FOLLOW_ruleRuleDependencyComposite_in_entryRuleRuleDependencyComposite2041 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDependencyComposite2051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleRuleDependencyComposite2089 = new BitSet(new long[]{0x00000000C1000000L});
    public static final BitSet FOLLOW_ruleRuleDependencyConjunction_in_ruleRuleDependencyComposite2114 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleRuleDependencyComposite2125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleRuleDependencyComposite2145 = new BitSet(new long[]{0x00000000C1000000L});
    public static final BitSet FOLLOW_ruleRuleDependencyDisjunction_in_ruleRuleDependencyComposite2170 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleRuleDependencyComposite2181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependencyConjunction_in_entryRuleRuleDependencyConjunction2218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDependencyConjunction2228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_ruleRuleDependencyConjunction2274 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_29_in_ruleRuleDependencyConjunction2287 = new BitSet(new long[]{0x00000000C1000000L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_ruleRuleDependencyConjunction2308 = new BitSet(new long[]{0x0000000020000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_entryRuleAbstractRuleDependency2346 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRuleDependency2356 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependencyComposite_in_ruleAbstractRuleDependency2406 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependency_in_ruleAbstractRuleDependency2436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependency_in_entryRuleRuleDependency2471 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDependency2481 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleRuleDependency2526 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_31_in_ruleRuleDependency2555 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleRuleDependency2583 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleRuleDependency2610 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleRuleDependency2622 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleRuleDependency2649 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleRuleDependency2661 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleRuleDependency2673 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleRuleDependency2694 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_20_in_ruleRuleDependency2707 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleRuleDependency2728 = new BitSet(new long[]{0x0000000000108000L});
    public static final BitSet FOLLOW_15_in_ruleRuleDependency2742 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleRuleDependency2754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_entryRuleEString2795 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEString2806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEString2846 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEString2872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt2918 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEInt2929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleEInt2968 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEInt2985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName3033 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName3044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName3090 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier3135 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier3146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier3185 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName3230 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName3241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName3287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName3338 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName3349 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName3396 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName3429 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName3462 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleEssentialOCLUnreservedName3486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier3527 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier3538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_rulePrimitiveTypeIdentifier3576 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_rulePrimitiveTypeIdentifier3595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_36_in_rulePrimitiveTypeIdentifier3614 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_rulePrimitiveTypeIdentifier3633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_38_in_rulePrimitiveTypeIdentifier3652 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_rulePrimitiveTypeIdentifier3671 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_rulePrimitiveTypeIdentifier3690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_rulePrimitiveTypeIdentifier3709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier3750 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier3761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleCollectionTypeIdentifier3799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_43_in_ruleCollectionTypeIdentifier3818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_44_in_ruleCollectionTypeIdentifier3837 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleCollectionTypeIdentifier3856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_ruleCollectionTypeIdentifier3875 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_synpred13_InternalTRC2089 = new BitSet(new long[]{0x00000000C1000000L});
    public static final BitSet FOLLOW_ruleRuleDependencyConjunction_in_synpred13_InternalTRC2114 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_synpred13_InternalTRC2125 = new BitSet(new long[]{0x0000000000000002L});

}