package org.trc.xtext.dsl.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.trc.xtext.dsl.services.DslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalDslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Modules'", "'{'", "';'", "'}'", "'.'", "':'", "','", "'Transformations'", "'modules'", "'impacts'", "'('", "')'", "'Dependencies'", "'Apply'", "'['", "'and'", "'or'", "']'", "'requires'", "'excludes'", "'-'"
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
    public static final int RULE_ANY_OTHER=10;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=8;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__30=30;
    public static final int T__19=19;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
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
    public String getGrammarFileName() { return "../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g"; }



     	private DslGrammarAccess grammarAccess;
     	
        public InternalDslParser(TokenStream input, DslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "TrcSpecification";	
       	}
       	
       	@Override
       	protected DslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleTrcSpecification"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:67:1: entryRuleTrcSpecification returns [EObject current=null] : iv_ruleTrcSpecification= ruleTrcSpecification EOF ;
    public final EObject entryRuleTrcSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrcSpecification = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:68:2: (iv_ruleTrcSpecification= ruleTrcSpecification EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:69:2: iv_ruleTrcSpecification= ruleTrcSpecification EOF
            {
             newCompositeNode(grammarAccess.getTrcSpecificationRule()); 
            pushFollow(FOLLOW_ruleTrcSpecification_in_entryRuleTrcSpecification75);
            iv_ruleTrcSpecification=ruleTrcSpecification();

            state._fsp--;

             current =iv_ruleTrcSpecification; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTrcSpecification85); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:76:1: ruleTrcSpecification returns [EObject current=null] : ( ( (lv_moduleList_0_0= ruleModuleList ) ) ( (lv_transformationList_1_0= ruleTransformationList ) ) ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) ) ) ;
    public final EObject ruleTrcSpecification() throws RecognitionException {
        EObject current = null;

        EObject lv_moduleList_0_0 = null;

        EObject lv_transformationList_1_0 = null;

        EObject lv_dependencyList_2_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:79:28: ( ( ( (lv_moduleList_0_0= ruleModuleList ) ) ( (lv_transformationList_1_0= ruleTransformationList ) ) ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) ) ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:80:1: ( ( (lv_moduleList_0_0= ruleModuleList ) ) ( (lv_transformationList_1_0= ruleTransformationList ) ) ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) ) )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:80:1: ( ( (lv_moduleList_0_0= ruleModuleList ) ) ( (lv_transformationList_1_0= ruleTransformationList ) ) ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:80:2: ( (lv_moduleList_0_0= ruleModuleList ) ) ( (lv_transformationList_1_0= ruleTransformationList ) ) ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:80:2: ( (lv_moduleList_0_0= ruleModuleList ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:81:1: (lv_moduleList_0_0= ruleModuleList )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:81:1: (lv_moduleList_0_0= ruleModuleList )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:82:3: lv_moduleList_0_0= ruleModuleList
            {
             
            	        newCompositeNode(grammarAccess.getTrcSpecificationAccess().getModuleListModuleListParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleModuleList_in_ruleTrcSpecification131);
            lv_moduleList_0_0=ruleModuleList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTrcSpecificationRule());
            	        }
                   		add(
                   			current, 
                   			"moduleList",
                    		lv_moduleList_0_0, 
                    		"ModuleList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:98:2: ( (lv_transformationList_1_0= ruleTransformationList ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:99:1: (lv_transformationList_1_0= ruleTransformationList )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:99:1: (lv_transformationList_1_0= ruleTransformationList )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:100:3: lv_transformationList_1_0= ruleTransformationList
            {
             
            	        newCompositeNode(grammarAccess.getTrcSpecificationAccess().getTransformationListTransformationListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleTransformationList_in_ruleTrcSpecification152);
            lv_transformationList_1_0=ruleTransformationList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTrcSpecificationRule());
            	        }
                   		add(
                   			current, 
                   			"transformationList",
                    		lv_transformationList_1_0, 
                    		"TransformationList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:116:2: ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:117:1: (lv_dependencyList_2_0= ruleTransformationDependencyList )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:117:1: (lv_dependencyList_2_0= ruleTransformationDependencyList )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:118:3: lv_dependencyList_2_0= ruleTransformationDependencyList
            {
             
            	        newCompositeNode(grammarAccess.getTrcSpecificationAccess().getDependencyListTransformationDependencyListParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleTransformationDependencyList_in_ruleTrcSpecification173);
            lv_dependencyList_2_0=ruleTransformationDependencyList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTrcSpecificationRule());
            	        }
                   		add(
                   			current, 
                   			"dependencyList",
                    		lv_dependencyList_2_0, 
                    		"TransformationDependencyList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuletrcRule"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:142:1: entryRuletrcRule returns [EObject current=null] : iv_ruletrcRule= ruletrcRule EOF ;
    public final EObject entryRuletrcRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletrcRule = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:143:2: (iv_ruletrcRule= ruletrcRule EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:144:2: iv_ruletrcRule= ruletrcRule EOF
            {
             newCompositeNode(grammarAccess.getTrcRuleRule()); 
            pushFollow(FOLLOW_ruletrcRule_in_entryRuletrcRule209);
            iv_ruletrcRule=ruletrcRule();

            state._fsp--;

             current =iv_ruletrcRule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuletrcRule219); 

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
    // $ANTLR end "entryRuletrcRule"


    // $ANTLR start "ruletrcRule"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:151:1: ruletrcRule returns [EObject current=null] : ( (lv_name_0_0= ruleEString ) ) ;
    public final EObject ruletrcRule() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:154:28: ( ( (lv_name_0_0= ruleEString ) ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:155:1: ( (lv_name_0_0= ruleEString ) )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:155:1: ( (lv_name_0_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:156:1: (lv_name_0_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:156:1: (lv_name_0_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:157:3: lv_name_0_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTrcRuleAccess().getNameEStringParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruletrcRule264);
            lv_name_0_0=ruleEString();

            state._fsp--;


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

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruletrcRule"


    // $ANTLR start "entryRuleModuleList"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:181:1: entryRuleModuleList returns [EObject current=null] : iv_ruleModuleList= ruleModuleList EOF ;
    public final EObject entryRuleModuleList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleList = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:182:2: (iv_ruleModuleList= ruleModuleList EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:183:2: iv_ruleModuleList= ruleModuleList EOF
            {
             newCompositeNode(grammarAccess.getModuleListRule()); 
            pushFollow(FOLLOW_ruleModuleList_in_entryRuleModuleList299);
            iv_ruleModuleList=ruleModuleList();

            state._fsp--;

             current =iv_ruleModuleList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModuleList309); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:190:1: ruleModuleList returns [EObject current=null] : ( () otherlv_1= 'Modules' otherlv_2= '{' ( ( (lv_modules_3_0= ruleModule ) ) (otherlv_4= ';' ( (lv_modules_5_0= ruleModule ) ) )* )? otherlv_6= '}' ) ;
    public final EObject ruleModuleList() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_modules_3_0 = null;

        EObject lv_modules_5_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:193:28: ( ( () otherlv_1= 'Modules' otherlv_2= '{' ( ( (lv_modules_3_0= ruleModule ) ) (otherlv_4= ';' ( (lv_modules_5_0= ruleModule ) ) )* )? otherlv_6= '}' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:194:1: ( () otherlv_1= 'Modules' otherlv_2= '{' ( ( (lv_modules_3_0= ruleModule ) ) (otherlv_4= ';' ( (lv_modules_5_0= ruleModule ) ) )* )? otherlv_6= '}' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:194:1: ( () otherlv_1= 'Modules' otherlv_2= '{' ( ( (lv_modules_3_0= ruleModule ) ) (otherlv_4= ';' ( (lv_modules_5_0= ruleModule ) ) )* )? otherlv_6= '}' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:194:2: () otherlv_1= 'Modules' otherlv_2= '{' ( ( (lv_modules_3_0= ruleModule ) ) (otherlv_4= ';' ( (lv_modules_5_0= ruleModule ) ) )* )? otherlv_6= '}'
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:194:2: ()
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:195:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModuleListAccess().getModuleListAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,11,FOLLOW_11_in_ruleModuleList355); 

                	newLeafNode(otherlv_1, grammarAccess.getModuleListAccess().getModulesKeyword_1());
                
            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleModuleList367); 

                	newLeafNode(otherlv_2, grammarAccess.getModuleListAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:208:1: ( ( (lv_modules_3_0= ruleModule ) ) (otherlv_4= ';' ( (lv_modules_5_0= ruleModule ) ) )* )?
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( ((LA2_0>=RULE_ID && LA2_0<=RULE_STRING)) ) {
                alt2=1;
            }
            switch (alt2) {
                case 1 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:208:2: ( (lv_modules_3_0= ruleModule ) ) (otherlv_4= ';' ( (lv_modules_5_0= ruleModule ) ) )*
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:208:2: ( (lv_modules_3_0= ruleModule ) )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:209:1: (lv_modules_3_0= ruleModule )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:209:1: (lv_modules_3_0= ruleModule )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:210:3: lv_modules_3_0= ruleModule
                    {
                     
                    	        newCompositeNode(grammarAccess.getModuleListAccess().getModulesModuleParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleModule_in_ruleModuleList389);
                    lv_modules_3_0=ruleModule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModuleListRule());
                    	        }
                           		add(
                           			current, 
                           			"modules",
                            		lv_modules_3_0, 
                            		"Module");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:226:2: (otherlv_4= ';' ( (lv_modules_5_0= ruleModule ) ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==13) ) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:226:4: otherlv_4= ';' ( (lv_modules_5_0= ruleModule ) )
                    	    {
                    	    otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleModuleList402); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getModuleListAccess().getSemicolonKeyword_3_1_0());
                    	        
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:230:1: ( (lv_modules_5_0= ruleModule ) )
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:231:1: (lv_modules_5_0= ruleModule )
                    	    {
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:231:1: (lv_modules_5_0= ruleModule )
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:232:3: lv_modules_5_0= ruleModule
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModuleListAccess().getModulesModuleParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleModule_in_ruleModuleList423);
                    	    lv_modules_5_0=ruleModule();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModuleListRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"modules",
                    	            		lv_modules_5_0, 
                    	            		"Module");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleModuleList439); 

                	newLeafNode(otherlv_6, grammarAccess.getModuleListAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:260:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:261:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:262:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName476);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName487); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:269:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:272:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:273:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:273:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:273:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName527); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:280:1: (kw= '.' this_ID_2= RULE_ID )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==15) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:281:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,15,FOLLOW_15_in_ruleQualifiedName546); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName561); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);


            }


            }

             leaveRule(); 
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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:301:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:302:2: (iv_ruleModule= ruleModule EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:303:2: iv_ruleModule= ruleModule EOF
            {
             newCompositeNode(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_ruleModule_in_entryRuleModule608);
            iv_ruleModule=ruleModule();

            state._fsp--;

             current =iv_ruleModule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModule618); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:310:1: ruleModule returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_rules_2_0= ruletrcRule ) ) (otherlv_3= ',' ( (lv_rules_4_0= ruletrcRule ) ) )* ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_rules_2_0 = null;

        EObject lv_rules_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:313:28: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_rules_2_0= ruletrcRule ) ) (otherlv_3= ',' ( (lv_rules_4_0= ruletrcRule ) ) )* ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:314:1: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_rules_2_0= ruletrcRule ) ) (otherlv_3= ',' ( (lv_rules_4_0= ruletrcRule ) ) )* )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:314:1: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_rules_2_0= ruletrcRule ) ) (otherlv_3= ',' ( (lv_rules_4_0= ruletrcRule ) ) )* )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:314:2: ( (lv_name_0_0= ruleEString ) ) otherlv_1= ':' ( (lv_rules_2_0= ruletrcRule ) ) (otherlv_3= ',' ( (lv_rules_4_0= ruletrcRule ) ) )*
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:314:2: ( (lv_name_0_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:315:1: (lv_name_0_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:315:1: (lv_name_0_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:316:3: lv_name_0_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getModuleAccess().getNameEStringParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleModule664);
            lv_name_0_0=ruleEString();

            state._fsp--;


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

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleModule676); 

                	newLeafNode(otherlv_1, grammarAccess.getModuleAccess().getColonKeyword_1());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:336:1: ( (lv_rules_2_0= ruletrcRule ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:337:1: (lv_rules_2_0= ruletrcRule )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:337:1: (lv_rules_2_0= ruletrcRule )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:338:3: lv_rules_2_0= ruletrcRule
            {
             
            	        newCompositeNode(grammarAccess.getModuleAccess().getRulesTrcRuleParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruletrcRule_in_ruleModule697);
            lv_rules_2_0=ruletrcRule();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	        }
                   		add(
                   			current, 
                   			"rules",
                    		lv_rules_2_0, 
                    		"trcRule");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:354:2: (otherlv_3= ',' ( (lv_rules_4_0= ruletrcRule ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==17) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:354:4: otherlv_3= ',' ( (lv_rules_4_0= ruletrcRule ) )
            	    {
            	    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleModule710); 

            	        	newLeafNode(otherlv_3, grammarAccess.getModuleAccess().getCommaKeyword_3_0());
            	        
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:358:1: ( (lv_rules_4_0= ruletrcRule ) )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:359:1: (lv_rules_4_0= ruletrcRule )
            	    {
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:359:1: (lv_rules_4_0= ruletrcRule )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:360:3: lv_rules_4_0= ruletrcRule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModuleAccess().getRulesTrcRuleParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruletrcRule_in_ruleModule731);
            	    lv_rules_4_0=ruletrcRule();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModuleRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"rules",
            	            		lv_rules_4_0, 
            	            		"trcRule");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop4;
                }
            } while (true);


            }


            }

             leaveRule(); 
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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:384:1: entryRuleTransformationList returns [EObject current=null] : iv_ruleTransformationList= ruleTransformationList EOF ;
    public final EObject entryRuleTransformationList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationList = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:385:2: (iv_ruleTransformationList= ruleTransformationList EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:386:2: iv_ruleTransformationList= ruleTransformationList EOF
            {
             newCompositeNode(grammarAccess.getTransformationListRule()); 
            pushFollow(FOLLOW_ruleTransformationList_in_entryRuleTransformationList769);
            iv_ruleTransformationList=ruleTransformationList();

            state._fsp--;

             current =iv_ruleTransformationList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationList779); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:393:1: ruleTransformationList returns [EObject current=null] : (otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}' ) ;
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
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:396:28: ( (otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:397:1: (otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:397:1: (otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:397:3: otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleTransformationList816); 

                	newLeafNode(otherlv_0, grammarAccess.getTransformationListAccess().getTransformationsKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleTransformationList828); 

                	newLeafNode(otherlv_1, grammarAccess.getTransformationListAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:405:1: ( (lv_transformations_2_0= ruleTransformation ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:406:1: (lv_transformations_2_0= ruleTransformation )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:406:1: (lv_transformations_2_0= ruleTransformation )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:407:3: lv_transformations_2_0= ruleTransformation
            {
             
            	        newCompositeNode(grammarAccess.getTransformationListAccess().getTransformationsTransformationParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleTransformation_in_ruleTransformationList849);
            lv_transformations_2_0=ruleTransformation();

            state._fsp--;


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

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:423:2: (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==17) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:423:4: otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) )
            	    {
            	    otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleTransformationList862); 

            	        	newLeafNode(otherlv_3, grammarAccess.getTransformationListAccess().getCommaKeyword_3_0());
            	        
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:427:1: ( (lv_transformations_4_0= ruleTransformation ) )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:428:1: (lv_transformations_4_0= ruleTransformation )
            	    {
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:428:1: (lv_transformations_4_0= ruleTransformation )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:429:3: lv_transformations_4_0= ruleTransformation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTransformationListAccess().getTransformationsTransformationParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransformation_in_ruleTransformationList883);
            	    lv_transformations_4_0=ruleTransformation();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleTransformationList897); 

                	newLeafNode(otherlv_5, grammarAccess.getTransformationListAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:457:1: entryRuleTransformation returns [EObject current=null] : iv_ruleTransformation= ruleTransformation EOF ;
    public final EObject entryRuleTransformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformation = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:458:2: (iv_ruleTransformation= ruleTransformation EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:459:2: iv_ruleTransformation= ruleTransformation EOF
            {
             newCompositeNode(grammarAccess.getTransformationRule()); 
            pushFollow(FOLLOW_ruleTransformation_in_entryRuleTransformation933);
            iv_ruleTransformation=ruleTransformation();

            state._fsp--;

             current =iv_ruleTransformation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformation943); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:466:1: ruleTransformation returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}' ) ;
    public final EObject ruleTransformation() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_impacts_9_0 = null;

        EObject lv_impacts_11_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:469:28: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:470:1: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:470:1: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:470:2: ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}'
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:470:2: ( (lv_name_0_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:471:1: (lv_name_0_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:471:1: (lv_name_0_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:472:3: lv_name_0_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTransformationAccess().getNameEStringParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleTransformation989);
            lv_name_0_0=ruleEString();

            state._fsp--;


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

            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleTransformation1001); 

                	newLeafNode(otherlv_1, grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,19,FOLLOW_19_in_ruleTransformation1013); 

                	newLeafNode(otherlv_2, grammarAccess.getTransformationAccess().getModulesKeyword_2());
                
            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleTransformation1025); 

                	newLeafNode(otherlv_3, grammarAccess.getTransformationAccess().getColonKeyword_3());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:500:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:501:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:501:1: ( ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:502:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransformationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTransformationAccess().getModulesModuleCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleTransformation1048);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:515:2: (otherlv_5= ',' ( ( ruleEString ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==17) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:515:4: otherlv_5= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleTransformation1061); 

            	        	newLeafNode(otherlv_5, grammarAccess.getTransformationAccess().getCommaKeyword_5_0());
            	        
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:519:1: ( ( ruleEString ) )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:520:1: ( ruleEString )
            	    {
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:520:1: ( ruleEString )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:521:3: ruleEString
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getTransformationRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getTransformationAccess().getModulesModuleCrossReference_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEString_in_ruleTransformation1084);
            	    ruleEString();

            	    state._fsp--;

            	     
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:534:4: (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:534:6: otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )*
                    {
                    otherlv_7=(Token)match(input,20,FOLLOW_20_in_ruleTransformation1099); 

                        	newLeafNode(otherlv_7, grammarAccess.getTransformationAccess().getImpactsKeyword_6_0());
                        
                    otherlv_8=(Token)match(input,16,FOLLOW_16_in_ruleTransformation1111); 

                        	newLeafNode(otherlv_8, grammarAccess.getTransformationAccess().getColonKeyword_6_1());
                        
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:542:1: ( (lv_impacts_9_0= ruleTransformationImpact ) )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:543:1: (lv_impacts_9_0= ruleTransformationImpact )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:543:1: (lv_impacts_9_0= ruleTransformationImpact )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:544:3: lv_impacts_9_0= ruleTransformationImpact
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransformationAccess().getImpactsTransformationImpactParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTransformationImpact_in_ruleTransformation1132);
                    lv_impacts_9_0=ruleTransformationImpact();

                    state._fsp--;


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

                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:560:2: (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==17) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:560:4: otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) )
                    	    {
                    	    otherlv_10=(Token)match(input,17,FOLLOW_17_in_ruleTransformation1145); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getTransformationAccess().getCommaKeyword_6_3_0());
                    	        
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:564:1: ( (lv_impacts_11_0= ruleTransformationImpact ) )
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:565:1: (lv_impacts_11_0= ruleTransformationImpact )
                    	    {
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:565:1: (lv_impacts_11_0= ruleTransformationImpact )
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:566:3: lv_impacts_11_0= ruleTransformationImpact
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTransformationAccess().getImpactsTransformationImpactParserRuleCall_6_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTransformationImpact_in_ruleTransformation1166);
                    	    lv_impacts_11_0=ruleTransformationImpact();

                    	    state._fsp--;


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
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,14,FOLLOW_14_in_ruleTransformation1182); 

                	newLeafNode(otherlv_12, grammarAccess.getTransformationAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:594:1: entryRuleTransformationImpact returns [EObject current=null] : iv_ruleTransformationImpact= ruleTransformationImpact EOF ;
    public final EObject entryRuleTransformationImpact() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationImpact = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:595:2: (iv_ruleTransformationImpact= ruleTransformationImpact EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:596:2: iv_ruleTransformationImpact= ruleTransformationImpact EOF
            {
             newCompositeNode(grammarAccess.getTransformationImpactRule()); 
            pushFollow(FOLLOW_ruleTransformationImpact_in_entryRuleTransformationImpact1218);
            iv_ruleTransformationImpact=ruleTransformationImpact();

            state._fsp--;

             current =iv_ruleTransformationImpact; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationImpact1228); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:603:1: ruleTransformationImpact returns [EObject current=null] : (otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')' ) ;
    public final EObject ruleTransformationImpact() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_qualityAttributeName_1_0 = null;

        AntlrDatatypeRuleToken lv_impactValue_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:606:28: ( (otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:607:1: (otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:607:1: (otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:607:3: otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleTransformationImpact1265); 

                	newLeafNode(otherlv_0, grammarAccess.getTransformationImpactAccess().getLeftParenthesisKeyword_0());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:611:1: ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=RULE_ID && LA9_0<=RULE_STRING)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:611:2: ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ','
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:611:2: ( (lv_qualityAttributeName_1_0= ruleEString ) )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:612:1: (lv_qualityAttributeName_1_0= ruleEString )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:612:1: (lv_qualityAttributeName_1_0= ruleEString )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:613:3: lv_qualityAttributeName_1_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransformationImpactAccess().getQualityAttributeNameEStringParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEString_in_ruleTransformationImpact1287);
                    lv_qualityAttributeName_1_0=ruleEString();

                    state._fsp--;


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

                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleTransformationImpact1299); 

                        	newLeafNode(otherlv_2, grammarAccess.getTransformationImpactAccess().getCommaKeyword_1_1());
                        

                    }
                    break;

            }

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:633:3: ( (lv_impactValue_3_0= ruleEInt ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:634:1: (lv_impactValue_3_0= ruleEInt )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:634:1: (lv_impactValue_3_0= ruleEInt )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:635:3: lv_impactValue_3_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getTransformationImpactAccess().getImpactValueEIntParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleEInt_in_ruleTransformationImpact1322);
            lv_impactValue_3_0=ruleEInt();

            state._fsp--;


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

            otherlv_4=(Token)match(input,22,FOLLOW_22_in_ruleTransformationImpact1334); 

                	newLeafNode(otherlv_4, grammarAccess.getTransformationImpactAccess().getRightParenthesisKeyword_3());
                

            }


            }

             leaveRule(); 
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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:663:1: entryRuleTransformationDependencyList returns [EObject current=null] : iv_ruleTransformationDependencyList= ruleTransformationDependencyList EOF ;
    public final EObject entryRuleTransformationDependencyList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationDependencyList = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:664:2: (iv_ruleTransformationDependencyList= ruleTransformationDependencyList EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:665:2: iv_ruleTransformationDependencyList= ruleTransformationDependencyList EOF
            {
             newCompositeNode(grammarAccess.getTransformationDependencyListRule()); 
            pushFollow(FOLLOW_ruleTransformationDependencyList_in_entryRuleTransformationDependencyList1370);
            iv_ruleTransformationDependencyList=ruleTransformationDependencyList();

            state._fsp--;

             current =iv_ruleTransformationDependencyList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationDependencyList1380); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:672:1: ruleTransformationDependencyList returns [EObject current=null] : (otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )* otherlv_7= '}' otherlv_8= '}' ) ;
    public final EObject ruleTransformationDependencyList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_transformationDependencies_4_0 = null;

        EObject lv_transformationDependencies_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:675:28: ( (otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )* otherlv_7= '}' otherlv_8= '}' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:676:1: (otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )* otherlv_7= '}' otherlv_8= '}' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:676:1: (otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )* otherlv_7= '}' otherlv_8= '}' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:676:3: otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )* otherlv_7= '}' otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleTransformationDependencyList1417); 

                	newLeafNode(otherlv_0, grammarAccess.getTransformationDependencyListAccess().getDependenciesKeyword_0());
                
            otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleTransformationDependencyList1429); 

                	newLeafNode(otherlv_1, grammarAccess.getTransformationDependencyListAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:684:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:685:1: (lv_name_2_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:685:1: (lv_name_2_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:686:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyListAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleTransformationDependencyList1450);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTransformationDependencyListRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,12,FOLLOW_12_in_ruleTransformationDependencyList1462); 

                	newLeafNode(otherlv_3, grammarAccess.getTransformationDependencyListAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:706:1: ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:707:1: (lv_transformationDependencies_4_0= ruleTransformationDependency )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:707:1: (lv_transformationDependencies_4_0= ruleTransformationDependency )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:708:3: lv_transformationDependencies_4_0= ruleTransformationDependency
            {
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesTransformationDependencyParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleTransformationDependency_in_ruleTransformationDependencyList1483);
            lv_transformationDependencies_4_0=ruleTransformationDependency();

            state._fsp--;


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

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:724:2: (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==13) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:724:4: otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) )
            	    {
            	    otherlv_5=(Token)match(input,13,FOLLOW_13_in_ruleTransformationDependencyList1496); 

            	        	newLeafNode(otherlv_5, grammarAccess.getTransformationDependencyListAccess().getSemicolonKeyword_5_0());
            	        
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:728:1: ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:729:1: (lv_transformationDependencies_6_0= ruleTransformationDependency )
            	    {
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:729:1: (lv_transformationDependencies_6_0= ruleTransformationDependency )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:730:3: lv_transformationDependencies_6_0= ruleTransformationDependency
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesTransformationDependencyParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransformationDependency_in_ruleTransformationDependencyList1517);
            	    lv_transformationDependencies_6_0=ruleTransformationDependency();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTransformationDependencyListRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"transformationDependencies",
            	            		lv_transformationDependencies_6_0, 
            	            		"TransformationDependency");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            otherlv_7=(Token)match(input,14,FOLLOW_14_in_ruleTransformationDependencyList1531); 

                	newLeafNode(otherlv_7, grammarAccess.getTransformationDependencyListAccess().getRightCurlyBracketKeyword_6());
                
            otherlv_8=(Token)match(input,14,FOLLOW_14_in_ruleTransformationDependencyList1543); 

                	newLeafNode(otherlv_8, grammarAccess.getTransformationDependencyListAccess().getRightCurlyBracketKeyword_7());
                

            }


            }

             leaveRule(); 
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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:762:1: entryRuleTransformationDependency returns [EObject current=null] : iv_ruleTransformationDependency= ruleTransformationDependency EOF ;
    public final EObject entryRuleTransformationDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationDependency = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:763:2: (iv_ruleTransformationDependency= ruleTransformationDependency EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:764:2: iv_ruleTransformationDependency= ruleTransformationDependency EOF
            {
             newCompositeNode(grammarAccess.getTransformationDependencyRule()); 
            pushFollow(FOLLOW_ruleTransformationDependency_in_entryRuleTransformationDependency1579);
            iv_ruleTransformationDependency=ruleTransformationDependency();

            state._fsp--;

             current =iv_ruleTransformationDependency; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationDependency1589); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:771:1: ruleTransformationDependency returns [EObject current=null] : (otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fields_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( ( ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) otherlv_14= 'and' ( (lv_requiredTransformations_15_0= ruleAbstractRuleDependency ) )* ) | ( ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) ) otherlv_17= 'or' ( (lv_requiredTransformations_18_0= ruleAbstractRuleDependency ) )* ) ) otherlv_19= ']' ) ;
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
        Token otherlv_17=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_fields_7_0 = null;

        AntlrDatatypeRuleToken lv_fields_9_0 = null;

        EObject lv_requiredTransformations_13_0 = null;

        EObject lv_requiredTransformations_15_0 = null;

        EObject lv_requiredTransformations_16_0 = null;

        EObject lv_requiredTransformations_18_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:774:28: ( (otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fields_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( ( ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) otherlv_14= 'and' ( (lv_requiredTransformations_15_0= ruleAbstractRuleDependency ) )* ) | ( ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) ) otherlv_17= 'or' ( (lv_requiredTransformations_18_0= ruleAbstractRuleDependency ) )* ) ) otherlv_19= ']' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:775:1: (otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fields_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( ( ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) otherlv_14= 'and' ( (lv_requiredTransformations_15_0= ruleAbstractRuleDependency ) )* ) | ( ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) ) otherlv_17= 'or' ( (lv_requiredTransformations_18_0= ruleAbstractRuleDependency ) )* ) ) otherlv_19= ']' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:775:1: (otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fields_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( ( ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) otherlv_14= 'and' ( (lv_requiredTransformations_15_0= ruleAbstractRuleDependency ) )* ) | ( ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) ) otherlv_17= 'or' ( (lv_requiredTransformations_18_0= ruleAbstractRuleDependency ) )* ) ) otherlv_19= ']' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:775:3: otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fields_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( ( ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) otherlv_14= 'and' ( (lv_requiredTransformations_15_0= ruleAbstractRuleDependency ) )* ) | ( ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) ) otherlv_17= 'or' ( (lv_requiredTransformations_18_0= ruleAbstractRuleDependency ) )* ) ) otherlv_19= ']'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleTransformationDependency1626); 

                	newLeafNode(otherlv_0, grammarAccess.getTransformationDependencyAccess().getApplyKeyword_0());
                
            otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleTransformationDependency1638); 

                	newLeafNode(otherlv_1, grammarAccess.getTransformationDependencyAccess().getLeftParenthesisKeyword_1());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:783:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:784:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:784:1: ( ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:785:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransformationDependencyRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationTransformationCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleTransformationDependency1661);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,15,FOLLOW_15_in_ruleTransformationDependency1673); 

                	newLeafNode(otherlv_3, grammarAccess.getTransformationDependencyAccess().getFullStopKeyword_3());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:802:1: ( ( ruleQualifiedName ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:803:1: ( ruleQualifiedName )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:803:1: ( ruleQualifiedName )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:804:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransformationDependencyRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getAppliedRuleTrcRuleCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTransformationDependency1696);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleTransformationDependency1708); 

                	newLeafNode(otherlv_5, grammarAccess.getTransformationDependencyAccess().getCommaKeyword_5());
                
            otherlv_6=(Token)match(input,12,FOLLOW_12_in_ruleTransformationDependency1720); 

                	newLeafNode(otherlv_6, grammarAccess.getTransformationDependencyAccess().getLeftCurlyBracketKeyword_6());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:825:1: ( (lv_fields_7_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:826:1: (lv_fields_7_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:826:1: (lv_fields_7_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:827:3: lv_fields_7_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getFieldsEStringParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleTransformationDependency1741);
            lv_fields_7_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTransformationDependencyRule());
            	        }
                   		add(
                   			current, 
                   			"fields",
                    		lv_fields_7_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:843:2: (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==17) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:843:4: otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) )
            	    {
            	    otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleTransformationDependency1754); 

            	        	newLeafNode(otherlv_8, grammarAccess.getTransformationDependencyAccess().getCommaKeyword_8_0());
            	        
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:847:1: ( (lv_fields_9_0= ruleEString ) )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:848:1: (lv_fields_9_0= ruleEString )
            	    {
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:848:1: (lv_fields_9_0= ruleEString )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:849:3: lv_fields_9_0= ruleEString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getFieldsEStringParserRuleCall_8_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEString_in_ruleTransformationDependency1775);
            	    lv_fields_9_0=ruleEString();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTransformationDependencyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"fields",
            	            		lv_fields_9_0, 
            	            		"EString");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop11;
                }
            } while (true);

            otherlv_10=(Token)match(input,14,FOLLOW_14_in_ruleTransformationDependency1789); 

                	newLeafNode(otherlv_10, grammarAccess.getTransformationDependencyAccess().getRightCurlyBracketKeyword_9());
                
            otherlv_11=(Token)match(input,22,FOLLOW_22_in_ruleTransformationDependency1801); 

                	newLeafNode(otherlv_11, grammarAccess.getTransformationDependencyAccess().getRightParenthesisKeyword_10());
                
            otherlv_12=(Token)match(input,25,FOLLOW_25_in_ruleTransformationDependency1813); 

                	newLeafNode(otherlv_12, grammarAccess.getTransformationDependencyAccess().getLeftSquareBracketKeyword_11());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:877:1: ( ( ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) otherlv_14= 'and' ( (lv_requiredTransformations_15_0= ruleAbstractRuleDependency ) )* ) | ( ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) ) otherlv_17= 'or' ( (lv_requiredTransformations_18_0= ruleAbstractRuleDependency ) )* ) )
            int alt14=2;
            alt14 = dfa14.predict(input);
            switch (alt14) {
                case 1 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:877:2: ( ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) otherlv_14= 'and' ( (lv_requiredTransformations_15_0= ruleAbstractRuleDependency ) )* )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:877:2: ( ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) otherlv_14= 'and' ( (lv_requiredTransformations_15_0= ruleAbstractRuleDependency ) )* )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:877:3: ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) otherlv_14= 'and' ( (lv_requiredTransformations_15_0= ruleAbstractRuleDependency ) )*
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:877:3: ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:878:1: (lv_requiredTransformations_13_0= ruleAbstractRuleDependency )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:878:1: (lv_requiredTransformations_13_0= ruleAbstractRuleDependency )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:879:3: lv_requiredTransformations_13_0= ruleAbstractRuleDependency
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAbstractRuleDependency_in_ruleTransformationDependency1836);
                    lv_requiredTransformations_13_0=ruleAbstractRuleDependency();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTransformationDependencyRule());
                    	        }
                           		add(
                           			current, 
                           			"requiredTransformations",
                            		lv_requiredTransformations_13_0, 
                            		"AbstractRuleDependency");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_14=(Token)match(input,26,FOLLOW_26_in_ruleTransformationDependency1848); 

                        	newLeafNode(otherlv_14, grammarAccess.getTransformationDependencyAccess().getAndKeyword_12_0_1());
                        
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:899:1: ( (lv_requiredTransformations_15_0= ruleAbstractRuleDependency ) )*
                    loop12:
                    do {
                        int alt12=2;
                        int LA12_0 = input.LA(1);

                        if ( ((LA12_0>=29 && LA12_0<=30)) ) {
                            alt12=1;
                        }


                        switch (alt12) {
                    	case 1 :
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:900:1: (lv_requiredTransformations_15_0= ruleAbstractRuleDependency )
                    	    {
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:900:1: (lv_requiredTransformations_15_0= ruleAbstractRuleDependency )
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:901:3: lv_requiredTransformations_15_0= ruleAbstractRuleDependency
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_0_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAbstractRuleDependency_in_ruleTransformationDependency1869);
                    	    lv_requiredTransformations_15_0=ruleAbstractRuleDependency();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTransformationDependencyRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"requiredTransformations",
                    	            		lv_requiredTransformations_15_0, 
                    	            		"AbstractRuleDependency");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop12;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:918:6: ( ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) ) otherlv_17= 'or' ( (lv_requiredTransformations_18_0= ruleAbstractRuleDependency ) )* )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:918:6: ( ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) ) otherlv_17= 'or' ( (lv_requiredTransformations_18_0= ruleAbstractRuleDependency ) )* )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:918:7: ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) ) otherlv_17= 'or' ( (lv_requiredTransformations_18_0= ruleAbstractRuleDependency ) )*
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:918:7: ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:919:1: (lv_requiredTransformations_16_0= ruleAbstractRuleDependency )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:919:1: (lv_requiredTransformations_16_0= ruleAbstractRuleDependency )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:920:3: lv_requiredTransformations_16_0= ruleAbstractRuleDependency
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleAbstractRuleDependency_in_ruleTransformationDependency1899);
                    lv_requiredTransformations_16_0=ruleAbstractRuleDependency();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTransformationDependencyRule());
                    	        }
                           		add(
                           			current, 
                           			"requiredTransformations",
                            		lv_requiredTransformations_16_0, 
                            		"AbstractRuleDependency");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_17=(Token)match(input,27,FOLLOW_27_in_ruleTransformationDependency1911); 

                        	newLeafNode(otherlv_17, grammarAccess.getTransformationDependencyAccess().getOrKeyword_12_1_1());
                        
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:940:1: ( (lv_requiredTransformations_18_0= ruleAbstractRuleDependency ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( ((LA13_0>=29 && LA13_0<=30)) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:941:1: (lv_requiredTransformations_18_0= ruleAbstractRuleDependency )
                    	    {
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:941:1: (lv_requiredTransformations_18_0= ruleAbstractRuleDependency )
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:942:3: lv_requiredTransformations_18_0= ruleAbstractRuleDependency
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_1_2_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleAbstractRuleDependency_in_ruleTransformationDependency1932);
                    	    lv_requiredTransformations_18_0=ruleAbstractRuleDependency();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getTransformationDependencyRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"requiredTransformations",
                    	            		lv_requiredTransformations_18_0, 
                    	            		"AbstractRuleDependency");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }


                    }
                    break;

            }

            otherlv_19=(Token)match(input,28,FOLLOW_28_in_ruleTransformationDependency1947); 

                	newLeafNode(otherlv_19, grammarAccess.getTransformationDependencyAccess().getRightSquareBracketKeyword_13());
                

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRuleAbstractRuleDependency"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:970:1: entryRuleAbstractRuleDependency returns [EObject current=null] : iv_ruleAbstractRuleDependency= ruleAbstractRuleDependency EOF ;
    public final EObject entryRuleAbstractRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRuleDependency = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:971:2: (iv_ruleAbstractRuleDependency= ruleAbstractRuleDependency EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:972:2: iv_ruleAbstractRuleDependency= ruleAbstractRuleDependency EOF
            {
             newCompositeNode(grammarAccess.getAbstractRuleDependencyRule()); 
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_entryRuleAbstractRuleDependency1983);
            iv_ruleAbstractRuleDependency=ruleAbstractRuleDependency();

            state._fsp--;

             current =iv_ruleAbstractRuleDependency; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRuleDependency1993); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:979:1: ruleAbstractRuleDependency returns [EObject current=null] : this_RuleDependency_0= ruleRuleDependency ;
    public final EObject ruleAbstractRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject this_RuleDependency_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:982:28: (this_RuleDependency_0= ruleRuleDependency )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:984:5: this_RuleDependency_0= ruleRuleDependency
            {
             
                    newCompositeNode(grammarAccess.getAbstractRuleDependencyAccess().getRuleDependencyParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleRuleDependency_in_ruleAbstractRuleDependency2039);
            this_RuleDependency_0=ruleRuleDependency();

            state._fsp--;

             
                    current = this_RuleDependency_0; 
                    afterParserOrEnumRuleCall();
                

            }

             leaveRule(); 
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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1000:1: entryRuleRuleDependency returns [EObject current=null] : iv_ruleRuleDependency= ruleRuleDependency EOF ;
    public final EObject entryRuleRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDependency = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1001:2: (iv_ruleRuleDependency= ruleRuleDependency EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1002:2: iv_ruleRuleDependency= ruleRuleDependency EOF
            {
             newCompositeNode(grammarAccess.getRuleDependencyRule()); 
            pushFollow(FOLLOW_ruleRuleDependency_in_entryRuleRuleDependency2073);
            iv_ruleRuleDependency=ruleRuleDependency();

            state._fsp--;

             current =iv_ruleRuleDependency; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDependency2083); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1009:1: ruleRuleDependency returns [EObject current=null] : ( (otherlv_0= 'requires' ( (lv_rd_1_0= rulerequiresDependency ) ) (otherlv_2= 'and' | otherlv_3= 'or' )? ( (lv_rd_4_0= rulerequiresDependency ) )* ) | (otherlv_5= 'excludes' ( (lv_rd_6_0= ruleexcludeDependency ) ) (otherlv_7= 'and' | otherlv_8= 'or' )? ( (lv_ed_9_0= ruleexcludeDependency ) )* ) ) ;
    public final EObject ruleRuleDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        EObject lv_rd_1_0 = null;

        EObject lv_rd_4_0 = null;

        EObject lv_rd_6_0 = null;

        EObject lv_ed_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1012:28: ( ( (otherlv_0= 'requires' ( (lv_rd_1_0= rulerequiresDependency ) ) (otherlv_2= 'and' | otherlv_3= 'or' )? ( (lv_rd_4_0= rulerequiresDependency ) )* ) | (otherlv_5= 'excludes' ( (lv_rd_6_0= ruleexcludeDependency ) ) (otherlv_7= 'and' | otherlv_8= 'or' )? ( (lv_ed_9_0= ruleexcludeDependency ) )* ) ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1013:1: ( (otherlv_0= 'requires' ( (lv_rd_1_0= rulerequiresDependency ) ) (otherlv_2= 'and' | otherlv_3= 'or' )? ( (lv_rd_4_0= rulerequiresDependency ) )* ) | (otherlv_5= 'excludes' ( (lv_rd_6_0= ruleexcludeDependency ) ) (otherlv_7= 'and' | otherlv_8= 'or' )? ( (lv_ed_9_0= ruleexcludeDependency ) )* ) )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1013:1: ( (otherlv_0= 'requires' ( (lv_rd_1_0= rulerequiresDependency ) ) (otherlv_2= 'and' | otherlv_3= 'or' )? ( (lv_rd_4_0= rulerequiresDependency ) )* ) | (otherlv_5= 'excludes' ( (lv_rd_6_0= ruleexcludeDependency ) ) (otherlv_7= 'and' | otherlv_8= 'or' )? ( (lv_ed_9_0= ruleexcludeDependency ) )* ) )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==29) ) {
                alt19=1;
            }
            else if ( (LA19_0==30) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1013:2: (otherlv_0= 'requires' ( (lv_rd_1_0= rulerequiresDependency ) ) (otherlv_2= 'and' | otherlv_3= 'or' )? ( (lv_rd_4_0= rulerequiresDependency ) )* )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1013:2: (otherlv_0= 'requires' ( (lv_rd_1_0= rulerequiresDependency ) ) (otherlv_2= 'and' | otherlv_3= 'or' )? ( (lv_rd_4_0= rulerequiresDependency ) )* )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1013:4: otherlv_0= 'requires' ( (lv_rd_1_0= rulerequiresDependency ) ) (otherlv_2= 'and' | otherlv_3= 'or' )? ( (lv_rd_4_0= rulerequiresDependency ) )*
                    {
                    otherlv_0=(Token)match(input,29,FOLLOW_29_in_ruleRuleDependency2121); 

                        	newLeafNode(otherlv_0, grammarAccess.getRuleDependencyAccess().getRequiresKeyword_0_0());
                        
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1017:1: ( (lv_rd_1_0= rulerequiresDependency ) )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1018:1: (lv_rd_1_0= rulerequiresDependency )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1018:1: (lv_rd_1_0= rulerequiresDependency )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1019:3: lv_rd_1_0= rulerequiresDependency
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleDependencyAccess().getRdRequiresDependencyParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulerequiresDependency_in_ruleRuleDependency2142);
                    lv_rd_1_0=rulerequiresDependency();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleDependencyRule());
                    	        }
                           		add(
                           			current, 
                           			"rd",
                            		lv_rd_1_0, 
                            		"requiresDependency");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1035:2: (otherlv_2= 'and' | otherlv_3= 'or' )?
                    int alt15=3;
                    int LA15_0 = input.LA(1);

                    if ( (LA15_0==26) ) {
                        alt15=1;
                    }
                    else if ( (LA15_0==27) ) {
                        alt15=2;
                    }
                    switch (alt15) {
                        case 1 :
                            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1035:4: otherlv_2= 'and'
                            {
                            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleRuleDependency2155); 

                                	newLeafNode(otherlv_2, grammarAccess.getRuleDependencyAccess().getAndKeyword_0_2_0());
                                

                            }
                            break;
                        case 2 :
                            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1040:7: otherlv_3= 'or'
                            {
                            otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleRuleDependency2173); 

                                	newLeafNode(otherlv_3, grammarAccess.getRuleDependencyAccess().getOrKeyword_0_2_1());
                                

                            }
                            break;

                    }

                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1044:3: ( (lv_rd_4_0= rulerequiresDependency ) )*
                    loop16:
                    do {
                        int alt16=2;
                        int LA16_0 = input.LA(1);

                        if ( (LA16_0==21) ) {
                            alt16=1;
                        }


                        switch (alt16) {
                    	case 1 :
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1045:1: (lv_rd_4_0= rulerequiresDependency )
                    	    {
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1045:1: (lv_rd_4_0= rulerequiresDependency )
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1046:3: lv_rd_4_0= rulerequiresDependency
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getRuleDependencyAccess().getRdRequiresDependencyParserRuleCall_0_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulerequiresDependency_in_ruleRuleDependency2196);
                    	    lv_rd_4_0=rulerequiresDependency();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getRuleDependencyRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"rd",
                    	            		lv_rd_4_0, 
                    	            		"requiresDependency");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop16;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1063:6: (otherlv_5= 'excludes' ( (lv_rd_6_0= ruleexcludeDependency ) ) (otherlv_7= 'and' | otherlv_8= 'or' )? ( (lv_ed_9_0= ruleexcludeDependency ) )* )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1063:6: (otherlv_5= 'excludes' ( (lv_rd_6_0= ruleexcludeDependency ) ) (otherlv_7= 'and' | otherlv_8= 'or' )? ( (lv_ed_9_0= ruleexcludeDependency ) )* )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1063:8: otherlv_5= 'excludes' ( (lv_rd_6_0= ruleexcludeDependency ) ) (otherlv_7= 'and' | otherlv_8= 'or' )? ( (lv_ed_9_0= ruleexcludeDependency ) )*
                    {
                    otherlv_5=(Token)match(input,30,FOLLOW_30_in_ruleRuleDependency2217); 

                        	newLeafNode(otherlv_5, grammarAccess.getRuleDependencyAccess().getExcludesKeyword_1_0());
                        
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1067:1: ( (lv_rd_6_0= ruleexcludeDependency ) )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1068:1: (lv_rd_6_0= ruleexcludeDependency )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1068:1: (lv_rd_6_0= ruleexcludeDependency )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1069:3: lv_rd_6_0= ruleexcludeDependency
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleDependencyAccess().getRdExcludeDependencyParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleexcludeDependency_in_ruleRuleDependency2238);
                    lv_rd_6_0=ruleexcludeDependency();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleDependencyRule());
                    	        }
                           		add(
                           			current, 
                           			"rd",
                            		lv_rd_6_0, 
                            		"excludeDependency");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1085:2: (otherlv_7= 'and' | otherlv_8= 'or' )?
                    int alt17=3;
                    int LA17_0 = input.LA(1);

                    if ( (LA17_0==26) ) {
                        alt17=1;
                    }
                    else if ( (LA17_0==27) ) {
                        alt17=2;
                    }
                    switch (alt17) {
                        case 1 :
                            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1085:4: otherlv_7= 'and'
                            {
                            otherlv_7=(Token)match(input,26,FOLLOW_26_in_ruleRuleDependency2251); 

                                	newLeafNode(otherlv_7, grammarAccess.getRuleDependencyAccess().getAndKeyword_1_2_0());
                                

                            }
                            break;
                        case 2 :
                            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1090:7: otherlv_8= 'or'
                            {
                            otherlv_8=(Token)match(input,27,FOLLOW_27_in_ruleRuleDependency2269); 

                                	newLeafNode(otherlv_8, grammarAccess.getRuleDependencyAccess().getOrKeyword_1_2_1());
                                

                            }
                            break;

                    }

                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1094:3: ( (lv_ed_9_0= ruleexcludeDependency ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==21) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1095:1: (lv_ed_9_0= ruleexcludeDependency )
                    	    {
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1095:1: (lv_ed_9_0= ruleexcludeDependency )
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1096:3: lv_ed_9_0= ruleexcludeDependency
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getRuleDependencyAccess().getEdExcludeDependencyParserRuleCall_1_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleexcludeDependency_in_ruleRuleDependency2292);
                    	    lv_ed_9_0=ruleexcludeDependency();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getRuleDependencyRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ed",
                    	            		lv_ed_9_0, 
                    	            		"excludeDependency");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


                    }


                    }
                    break;

            }


            }

             leaveRule(); 
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


    // $ANTLR start "entryRulerequiresDependency"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1120:1: entryRulerequiresDependency returns [EObject current=null] : iv_rulerequiresDependency= rulerequiresDependency EOF ;
    public final EObject entryRulerequiresDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerequiresDependency = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1121:2: (iv_rulerequiresDependency= rulerequiresDependency EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1122:2: iv_rulerequiresDependency= rulerequiresDependency EOF
            {
             newCompositeNode(grammarAccess.getRequiresDependencyRule()); 
            pushFollow(FOLLOW_rulerequiresDependency_in_entryRulerequiresDependency2330);
            iv_rulerequiresDependency=rulerequiresDependency();

            state._fsp--;

             current =iv_rulerequiresDependency; 
            match(input,EOF,FOLLOW_EOF_in_entryRulerequiresDependency2340); 

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
    // $ANTLR end "entryRulerequiresDependency"


    // $ANTLR start "rulerequiresDependency"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1129:1: rulerequiresDependency returns [EObject current=null] : (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( ( ruleQualifiedName ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')' ) ;
    public final EObject rulerequiresDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_fields_5_0 = null;

        AntlrDatatypeRuleToken lv_oclExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1132:28: ( (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( ( ruleQualifiedName ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1133:1: (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( ( ruleQualifiedName ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1133:1: (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( ( ruleQualifiedName ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1133:3: otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( ( ruleQualifiedName ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_rulerequiresDependency2377); 

                	newLeafNode(otherlv_0, grammarAccess.getRequiresDependencyAccess().getLeftParenthesisKeyword_0());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1137:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1138:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1138:1: ( ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1139:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRequiresDependencyRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRequiresDependencyAccess().getRequiredTransformationTransformationCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_rulerequiresDependency2400);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_rulerequiresDependency2412); 

                	newLeafNode(otherlv_2, grammarAccess.getRequiresDependencyAccess().getFullStopKeyword_2());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1156:1: ( ( ruleQualifiedName ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1157:1: ( ruleQualifiedName )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1157:1: ( ruleQualifiedName )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1158:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRequiresDependencyRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRequiresDependencyAccess().getRequiredRuleTrcRuleCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_rulerequiresDependency2435);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_rulerequiresDependency2447); 

                	newLeafNode(otherlv_4, grammarAccess.getRequiresDependencyAccess().getCommaKeyword_4());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1175:1: ( (lv_fields_5_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1176:1: (lv_fields_5_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1176:1: (lv_fields_5_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1177:3: lv_fields_5_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getRequiresDependencyAccess().getFieldsEStringParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_rulerequiresDependency2468);
            lv_fields_5_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRequiresDependencyRule());
            	        }
                   		set(
                   			current, 
                   			"fields",
                    		lv_fields_5_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,16,FOLLOW_16_in_rulerequiresDependency2480); 

                	newLeafNode(otherlv_6, grammarAccess.getRequiresDependencyAccess().getColonKeyword_6());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1197:1: ( (lv_oclExpression_7_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1198:1: (lv_oclExpression_7_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1198:1: (lv_oclExpression_7_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1199:3: lv_oclExpression_7_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getRequiresDependencyAccess().getOclExpressionEStringParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_rulerequiresDependency2501);
            lv_oclExpression_7_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRequiresDependencyRule());
            	        }
                   		set(
                   			current, 
                   			"oclExpression",
                    		lv_oclExpression_7_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,22,FOLLOW_22_in_rulerequiresDependency2513); 

                	newLeafNode(otherlv_8, grammarAccess.getRequiresDependencyAccess().getRightParenthesisKeyword_8());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "rulerequiresDependency"


    // $ANTLR start "entryRuleexcludeDependency"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1227:1: entryRuleexcludeDependency returns [EObject current=null] : iv_ruleexcludeDependency= ruleexcludeDependency EOF ;
    public final EObject entryRuleexcludeDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleexcludeDependency = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1228:2: (iv_ruleexcludeDependency= ruleexcludeDependency EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1229:2: iv_ruleexcludeDependency= ruleexcludeDependency EOF
            {
             newCompositeNode(grammarAccess.getExcludeDependencyRule()); 
            pushFollow(FOLLOW_ruleexcludeDependency_in_entryRuleexcludeDependency2549);
            iv_ruleexcludeDependency=ruleexcludeDependency();

            state._fsp--;

             current =iv_ruleexcludeDependency; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleexcludeDependency2559); 

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
    // $ANTLR end "entryRuleexcludeDependency"


    // $ANTLR start "ruleexcludeDependency"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1236:1: ruleexcludeDependency returns [EObject current=null] : (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( ( ruleQualifiedName ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')' ) ;
    public final EObject ruleexcludeDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_fields_5_0 = null;

        AntlrDatatypeRuleToken lv_oclExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1239:28: ( (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( ( ruleQualifiedName ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1240:1: (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( ( ruleQualifiedName ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1240:1: (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( ( ruleQualifiedName ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1240:3: otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( ( ruleQualifiedName ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleexcludeDependency2596); 

                	newLeafNode(otherlv_0, grammarAccess.getExcludeDependencyAccess().getLeftParenthesisKeyword_0());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1244:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1245:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1245:1: ( ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1246:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getExcludeDependencyRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getExcludeDependencyAccess().getRequiredTransformationTransformationCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleexcludeDependency2619);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,15,FOLLOW_15_in_ruleexcludeDependency2631); 

                	newLeafNode(otherlv_2, grammarAccess.getExcludeDependencyAccess().getFullStopKeyword_2());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1263:1: ( ( ruleQualifiedName ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1264:1: ( ruleQualifiedName )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1264:1: ( ruleQualifiedName )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1265:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getExcludeDependencyRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getExcludeDependencyAccess().getRequiredRuleTrcRuleCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleexcludeDependency2654);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleexcludeDependency2666); 

                	newLeafNode(otherlv_4, grammarAccess.getExcludeDependencyAccess().getCommaKeyword_4());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1282:1: ( (lv_fields_5_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1283:1: (lv_fields_5_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1283:1: (lv_fields_5_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1284:3: lv_fields_5_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getExcludeDependencyAccess().getFieldsEStringParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleexcludeDependency2687);
            lv_fields_5_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExcludeDependencyRule());
            	        }
                   		set(
                   			current, 
                   			"fields",
                    		lv_fields_5_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,16,FOLLOW_16_in_ruleexcludeDependency2699); 

                	newLeafNode(otherlv_6, grammarAccess.getExcludeDependencyAccess().getColonKeyword_6());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1304:1: ( (lv_oclExpression_7_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1305:1: (lv_oclExpression_7_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1305:1: (lv_oclExpression_7_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1306:3: lv_oclExpression_7_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getExcludeDependencyAccess().getOclExpressionEStringParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleexcludeDependency2720);
            lv_oclExpression_7_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExcludeDependencyRule());
            	        }
                   		set(
                   			current, 
                   			"oclExpression",
                    		lv_oclExpression_7_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,22,FOLLOW_22_in_ruleexcludeDependency2732); 

                	newLeafNode(otherlv_8, grammarAccess.getExcludeDependencyAccess().getRightParenthesisKeyword_8());
                

            }


            }

             leaveRule(); 
        }
         
            catch (RecognitionException re) { 
                recover(input,re); 
                appendSkippedTokens();
            } 
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleexcludeDependency"


    // $ANTLR start "entryRuleEString"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1338:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1339:2: (iv_ruleEString= ruleEString EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1340:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_ruleEString_in_entryRuleEString2773);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEString2784); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1347:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1350:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1351:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1351:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_STRING) ) {
                alt20=1;
            }
            else if ( (LA20_0==RULE_ID) ) {
                alt20=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 20, 0, input);

                throw nvae;
            }
            switch (alt20) {
                case 1 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1351:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEString2824); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1359:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEString2850); 

                    		current.merge(this_ID_1);
                        
                     
                        newLeafNode(this_ID_1, grammarAccess.getEStringAccess().getIDTerminalRuleCall_1()); 
                        

                    }
                    break;

            }


            }

             leaveRule(); 
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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1374:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1375:2: (iv_ruleEInt= ruleEInt EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1376:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_ruleEInt_in_entryRuleEInt2896);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEInt2907); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1383:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1386:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1387:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1387:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1387:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1387:2: (kw= '-' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==31) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1388:2: kw= '-'
                    {
                    kw=(Token)match(input,31,FOLLOW_31_in_ruleEInt2946); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEInt2963); 

            		current.merge(this_INT_1);
                
             
                newLeafNode(this_INT_1, grammarAccess.getEIntAccess().getINTTerminalRuleCall_1()); 
                

            }


            }

             leaveRule(); 
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

    // Delegated rules


    protected DFA14 dfa14 = new DFA14(this);
    static final String DFA14_eotS =
        "\101\uffff";
    static final String DFA14_eofS =
        "\101\uffff";
    static final String DFA14_minS =
        "\1\35\2\25\2\4\4\17\2\4\2\17\4\4\1\17\2\20\1\17\2\20\2\4\4\26\4"+
        "\25\1\4\2\25\1\4\2\uffff\4\17\2\4\2\17\4\4\1\17\2\20\1\17\2\20\2"+
        "\4\4\26\2\25";
    static final String DFA14_maxS =
        "\1\36\2\25\2\5\4\17\2\4\2\21\1\4\1\5\1\4\1\5\1\21\2\20\1\21\2\20"+
        "\2\5\4\26\2\33\2\36\1\5\2\36\1\5\2\uffff\4\17\2\4\2\21\1\4\1\5\1"+
        "\4\1\5\1\21\2\20\1\21\2\20\2\5\4\26\2\33";
    static final String DFA14_acceptS =
        "\45\uffff\1\2\1\1\32\uffff";
    static final String DFA14_specialS =
        "\101\uffff}>";
    static final String[] DFA14_transitionS = {
            "\1\1\1\2",
            "\1\3",
            "\1\4",
            "\1\6\1\5",
            "\1\10\1\7",
            "\1\11",
            "\1\11",
            "\1\12",
            "\1\12",
            "\1\13",
            "\1\14",
            "\1\15\1\uffff\1\16",
            "\1\17\1\uffff\1\20",
            "\1\21",
            "\1\23\1\22",
            "\1\24",
            "\1\26\1\25",
            "\1\15\1\uffff\1\16",
            "\1\27",
            "\1\27",
            "\1\17\1\uffff\1\20",
            "\1\30",
            "\1\30",
            "\1\32\1\31",
            "\1\34\1\33",
            "\1\35",
            "\1\35",
            "\1\36",
            "\1\36",
            "\1\41\4\uffff\1\37\1\40",
            "\1\44\4\uffff\1\42\1\43",
            "\1\41\4\uffff\1\46\1\45\3\46",
            "\1\41\4\uffff\1\46\4\45",
            "\1\50\1\47",
            "\1\44\4\uffff\1\46\1\45\3\46",
            "\1\44\4\uffff\1\46\4\45",
            "\1\52\1\51",
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
            "\1\65\1\64",
            "\1\66",
            "\1\70\1\67",
            "\1\57\1\uffff\1\60",
            "\1\71",
            "\1\71",
            "\1\61\1\uffff\1\62",
            "\1\72",
            "\1\72",
            "\1\74\1\73",
            "\1\76\1\75",
            "\1\77",
            "\1\77",
            "\1\100",
            "\1\100",
            "\1\41\4\uffff\1\46\1\45",
            "\1\44\4\uffff\1\46\1\45"
    };

    static final short[] DFA14_eot = DFA.unpackEncodedString(DFA14_eotS);
    static final short[] DFA14_eof = DFA.unpackEncodedString(DFA14_eofS);
    static final char[] DFA14_min = DFA.unpackEncodedStringToUnsignedChars(DFA14_minS);
    static final char[] DFA14_max = DFA.unpackEncodedStringToUnsignedChars(DFA14_maxS);
    static final short[] DFA14_accept = DFA.unpackEncodedString(DFA14_acceptS);
    static final short[] DFA14_special = DFA.unpackEncodedString(DFA14_specialS);
    static final short[][] DFA14_transition;

    static {
        int numStates = DFA14_transitionS.length;
        DFA14_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA14_transition[i] = DFA.unpackEncodedString(DFA14_transitionS[i]);
        }
    }

    class DFA14 extends DFA {

        public DFA14(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 14;
            this.eot = DFA14_eot;
            this.eof = DFA14_eof;
            this.min = DFA14_min;
            this.max = DFA14_max;
            this.accept = DFA14_accept;
            this.special = DFA14_special;
            this.transition = DFA14_transition;
        }
        public String getDescription() {
            return "877:1: ( ( ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) otherlv_14= 'and' ( (lv_requiredTransformations_15_0= ruleAbstractRuleDependency ) )* ) | ( ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) ) otherlv_17= 'or' ( (lv_requiredTransformations_18_0= ruleAbstractRuleDependency ) )* ) )";
        }
    }
 

    public static final BitSet FOLLOW_ruleTrcSpecification_in_entryRuleTrcSpecification75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrcSpecification85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModuleList_in_ruleTrcSpecification131 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_ruleTransformationList_in_ruleTrcSpecification152 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_ruleTransformationDependencyList_in_ruleTrcSpecification173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletrcRule_in_entryRuletrcRule209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletrcRule219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_ruletrcRule264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModuleList_in_entryRuleModuleList299 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModuleList309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleModuleList355 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleModuleList367 = new BitSet(new long[]{0x0000000000004030L});
    public static final BitSet FOLLOW_ruleModule_in_ruleModuleList389 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleModuleList402 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleModule_in_ruleModuleList423 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleModuleList439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName476 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName487 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName527 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_15_in_ruleQualifiedName546 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName561 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule608 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_ruleModule664 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleModule676 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruletrcRule_in_ruleModule697 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleModule710 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruletrcRule_in_ruleModule731 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_ruleTransformationList_in_entryRuleTransformationList769 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationList779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleTransformationList816 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleTransformationList828 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTransformation_in_ruleTransformationList849 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_17_in_ruleTransformationList862 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTransformation_in_ruleTransformationList883 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_14_in_ruleTransformationList897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformation_in_entryRuleTransformation933 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformation943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformation989 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleTransformation1001 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_19_in_ruleTransformation1013 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTransformation1025 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformation1048 = new BitSet(new long[]{0x0000000000124000L});
    public static final BitSet FOLLOW_17_in_ruleTransformation1061 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformation1084 = new BitSet(new long[]{0x0000000000124000L});
    public static final BitSet FOLLOW_20_in_ruleTransformation1099 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTransformation1111 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_ruleTransformation1132 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_17_in_ruleTransformation1145 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_ruleTransformation1166 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_14_in_ruleTransformation1182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_entryRuleTransformationImpact1218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationImpact1228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleTransformationImpact1265 = new BitSet(new long[]{0x0000000080000070L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationImpact1287 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTransformationImpact1299 = new BitSet(new long[]{0x0000000080000070L});
    public static final BitSet FOLLOW_ruleEInt_in_ruleTransformationImpact1322 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTransformationImpact1334 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependencyList_in_entryRuleTransformationDependencyList1370 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationDependencyList1380 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleTransformationDependencyList1417 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleTransformationDependencyList1429 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationDependencyList1450 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleTransformationDependencyList1462 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_ruleTransformationDependencyList1483 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleTransformationDependencyList1496 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_ruleTransformationDependencyList1517 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleTransformationDependencyList1531 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTransformationDependencyList1543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_entryRuleTransformationDependency1579 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationDependency1589 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleTransformationDependency1626 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleTransformationDependency1638 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationDependency1661 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTransformationDependency1673 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTransformationDependency1696 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTransformationDependency1708 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleTransformationDependency1720 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationDependency1741 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_17_in_ruleTransformationDependency1754 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationDependency1775 = new BitSet(new long[]{0x0000000000024000L});
    public static final BitSet FOLLOW_14_in_ruleTransformationDependency1789 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTransformationDependency1801 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleTransformationDependency1813 = new BitSet(new long[]{0x0000000060000000L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_ruleTransformationDependency1836 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleTransformationDependency1848 = new BitSet(new long[]{0x0000000070000000L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_ruleTransformationDependency1869 = new BitSet(new long[]{0x0000000070000000L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_ruleTransformationDependency1899 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleTransformationDependency1911 = new BitSet(new long[]{0x0000000070000000L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_ruleTransformationDependency1932 = new BitSet(new long[]{0x0000000070000000L});
    public static final BitSet FOLLOW_28_in_ruleTransformationDependency1947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_entryRuleAbstractRuleDependency1983 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRuleDependency1993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependency_in_ruleAbstractRuleDependency2039 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependency_in_entryRuleRuleDependency2073 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDependency2083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleRuleDependency2121 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rulerequiresDependency_in_ruleRuleDependency2142 = new BitSet(new long[]{0x000000000C200002L});
    public static final BitSet FOLLOW_26_in_ruleRuleDependency2155 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_27_in_ruleRuleDependency2173 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_rulerequiresDependency_in_ruleRuleDependency2196 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_30_in_ruleRuleDependency2217 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_ruleexcludeDependency_in_ruleRuleDependency2238 = new BitSet(new long[]{0x000000000C200002L});
    public static final BitSet FOLLOW_26_in_ruleRuleDependency2251 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_27_in_ruleRuleDependency2269 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_ruleexcludeDependency_in_ruleRuleDependency2292 = new BitSet(new long[]{0x0000000000200002L});
    public static final BitSet FOLLOW_rulerequiresDependency_in_entryRulerequiresDependency2330 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerequiresDependency2340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rulerequiresDependency2377 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_rulerequiresDependency2400 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_rulerequiresDependency2412 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rulerequiresDependency2435 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_rulerequiresDependency2447 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_rulerequiresDependency2468 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulerequiresDependency2480 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_rulerequiresDependency2501 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_rulerequiresDependency2513 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexcludeDependency_in_entryRuleexcludeDependency2549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleexcludeDependency2559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleexcludeDependency2596 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleexcludeDependency2619 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleexcludeDependency2631 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleexcludeDependency2654 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleexcludeDependency2666 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleexcludeDependency2687 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleexcludeDependency2699 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleexcludeDependency2720 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleexcludeDependency2732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_entryRuleEString2773 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEString2784 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEString2824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEString2850 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt2896 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEInt2907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleEInt2946 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEInt2963 = new BitSet(new long[]{0x0000000000000002L});

}