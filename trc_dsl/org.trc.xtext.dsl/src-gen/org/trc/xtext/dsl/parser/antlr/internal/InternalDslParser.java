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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_STRING", "RULE_ID", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'from'", "';'", "'Modules'", "'{'", "'}'", "'::'", "':'", "','", "'Transformations'", "'modules'", "'impacts'", "'('", "')'", "'Dependencies'", "'Apply'", "'.'", "'['", "'and'", "'or'", "']'", "'requires'", "'excludes'", "'-'"
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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:76:1: ruleTrcSpecification returns [EObject current=null] : ( ( (lv_froms_0_0= ruleFrom ) )* ( (lv_moduleList_1_0= ruleModuleList ) ) ( (lv_transformationList_2_0= ruleTransformationList ) ) ( (lv_dependencyList_3_0= ruleTransformationDependencyList ) ) ) ;
    public final EObject ruleTrcSpecification() throws RecognitionException {
        EObject current = null;

        EObject lv_froms_0_0 = null;

        EObject lv_moduleList_1_0 = null;

        EObject lv_transformationList_2_0 = null;

        EObject lv_dependencyList_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:79:28: ( ( ( (lv_froms_0_0= ruleFrom ) )* ( (lv_moduleList_1_0= ruleModuleList ) ) ( (lv_transformationList_2_0= ruleTransformationList ) ) ( (lv_dependencyList_3_0= ruleTransformationDependencyList ) ) ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:80:1: ( ( (lv_froms_0_0= ruleFrom ) )* ( (lv_moduleList_1_0= ruleModuleList ) ) ( (lv_transformationList_2_0= ruleTransformationList ) ) ( (lv_dependencyList_3_0= ruleTransformationDependencyList ) ) )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:80:1: ( ( (lv_froms_0_0= ruleFrom ) )* ( (lv_moduleList_1_0= ruleModuleList ) ) ( (lv_transformationList_2_0= ruleTransformationList ) ) ( (lv_dependencyList_3_0= ruleTransformationDependencyList ) ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:80:2: ( (lv_froms_0_0= ruleFrom ) )* ( (lv_moduleList_1_0= ruleModuleList ) ) ( (lv_transformationList_2_0= ruleTransformationList ) ) ( (lv_dependencyList_3_0= ruleTransformationDependencyList ) )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:80:2: ( (lv_froms_0_0= ruleFrom ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:81:1: (lv_froms_0_0= ruleFrom )
            	    {
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:81:1: (lv_froms_0_0= ruleFrom )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:82:3: lv_froms_0_0= ruleFrom
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTrcSpecificationAccess().getFromsFromParserRuleCall_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleFrom_in_ruleTrcSpecification131);
            	    lv_froms_0_0=ruleFrom();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTrcSpecificationRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"froms",
            	            		lv_froms_0_0, 
            	            		"From");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:98:3: ( (lv_moduleList_1_0= ruleModuleList ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:99:1: (lv_moduleList_1_0= ruleModuleList )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:99:1: (lv_moduleList_1_0= ruleModuleList )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:100:3: lv_moduleList_1_0= ruleModuleList
            {
             
            	        newCompositeNode(grammarAccess.getTrcSpecificationAccess().getModuleListModuleListParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleModuleList_in_ruleTrcSpecification153);
            lv_moduleList_1_0=ruleModuleList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTrcSpecificationRule());
            	        }
                   		add(
                   			current, 
                   			"moduleList",
                    		lv_moduleList_1_0, 
                    		"ModuleList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:116:2: ( (lv_transformationList_2_0= ruleTransformationList ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:117:1: (lv_transformationList_2_0= ruleTransformationList )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:117:1: (lv_transformationList_2_0= ruleTransformationList )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:118:3: lv_transformationList_2_0= ruleTransformationList
            {
             
            	        newCompositeNode(grammarAccess.getTrcSpecificationAccess().getTransformationListTransformationListParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleTransformationList_in_ruleTrcSpecification174);
            lv_transformationList_2_0=ruleTransformationList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTrcSpecificationRule());
            	        }
                   		add(
                   			current, 
                   			"transformationList",
                    		lv_transformationList_2_0, 
                    		"TransformationList");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:134:2: ( (lv_dependencyList_3_0= ruleTransformationDependencyList ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:135:1: (lv_dependencyList_3_0= ruleTransformationDependencyList )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:135:1: (lv_dependencyList_3_0= ruleTransformationDependencyList )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:136:3: lv_dependencyList_3_0= ruleTransformationDependencyList
            {
             
            	        newCompositeNode(grammarAccess.getTrcSpecificationAccess().getDependencyListTransformationDependencyListParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleTransformationDependencyList_in_ruleTrcSpecification195);
            lv_dependencyList_3_0=ruleTransformationDependencyList();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTrcSpecificationRule());
            	        }
                   		add(
                   			current, 
                   			"dependencyList",
                    		lv_dependencyList_3_0, 
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


    // $ANTLR start "entryRuleFrom"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:160:1: entryRuleFrom returns [EObject current=null] : iv_ruleFrom= ruleFrom EOF ;
    public final EObject entryRuleFrom() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFrom = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:161:2: (iv_ruleFrom= ruleFrom EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:162:2: iv_ruleFrom= ruleFrom EOF
            {
             newCompositeNode(grammarAccess.getFromRule()); 
            pushFollow(FOLLOW_ruleFrom_in_entryRuleFrom231);
            iv_ruleFrom=ruleFrom();

            state._fsp--;

             current =iv_ruleFrom; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFrom241); 

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
    // $ANTLR end "entryRuleFrom"


    // $ANTLR start "ruleFrom"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:169:1: ruleFrom returns [EObject current=null] : (otherlv_0= 'from' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' ) ;
    public final EObject ruleFrom() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_importURI_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:172:28: ( (otherlv_0= 'from' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:173:1: (otherlv_0= 'from' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:173:1: (otherlv_0= 'from' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:173:3: otherlv_0= 'from' ( (lv_importURI_1_0= RULE_STRING ) ) otherlv_2= ';'
            {
            otherlv_0=(Token)match(input,11,FOLLOW_11_in_ruleFrom278); 

                	newLeafNode(otherlv_0, grammarAccess.getFromAccess().getFromKeyword_0());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:177:1: ( (lv_importURI_1_0= RULE_STRING ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:178:1: (lv_importURI_1_0= RULE_STRING )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:178:1: (lv_importURI_1_0= RULE_STRING )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:179:3: lv_importURI_1_0= RULE_STRING
            {
            lv_importURI_1_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleFrom295); 

            			newLeafNode(lv_importURI_1_0, grammarAccess.getFromAccess().getImportURISTRINGTerminalRuleCall_1_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getFromRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"importURI",
                    		lv_importURI_1_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_12_in_ruleFrom312); 

                	newLeafNode(otherlv_2, grammarAccess.getFromAccess().getSemicolonKeyword_2());
                

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
    // $ANTLR end "ruleFrom"


    // $ANTLR start "entryRuleRules"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:207:1: entryRuleRules returns [EObject current=null] : iv_ruleRules= ruleRules EOF ;
    public final EObject entryRuleRules() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRules = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:208:2: (iv_ruleRules= ruleRules EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:209:2: iv_ruleRules= ruleRules EOF
            {
             newCompositeNode(grammarAccess.getRulesRule()); 
            pushFollow(FOLLOW_ruleRules_in_entryRuleRules348);
            iv_ruleRules=ruleRules();

            state._fsp--;

             current =iv_ruleRules; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRules358); 

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
    // $ANTLR end "entryRuleRules"


    // $ANTLR start "ruleRules"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:216:1: ruleRules returns [EObject current=null] : ( (lv_name_0_0= ruleEString ) ) ;
    public final EObject ruleRules() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:219:28: ( ( (lv_name_0_0= ruleEString ) ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:220:1: ( (lv_name_0_0= ruleEString ) )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:220:1: ( (lv_name_0_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:221:1: (lv_name_0_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:221:1: (lv_name_0_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:222:3: lv_name_0_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getRulesAccess().getNameEStringParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleRules403);
            lv_name_0_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRulesRule());
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
    // $ANTLR end "ruleRules"


    // $ANTLR start "entryRuleModuleList"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:248:1: entryRuleModuleList returns [EObject current=null] : iv_ruleModuleList= ruleModuleList EOF ;
    public final EObject entryRuleModuleList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleList = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:249:2: (iv_ruleModuleList= ruleModuleList EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:250:2: iv_ruleModuleList= ruleModuleList EOF
            {
             newCompositeNode(grammarAccess.getModuleListRule()); 
            pushFollow(FOLLOW_ruleModuleList_in_entryRuleModuleList440);
            iv_ruleModuleList=ruleModuleList();

            state._fsp--;

             current =iv_ruleModuleList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModuleList450); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:257:1: ruleModuleList returns [EObject current=null] : ( () otherlv_1= 'Modules' otherlv_2= '{' ( ( (lv_modules_3_0= ruleModules ) ) (otherlv_4= ';' ( (lv_modules_5_0= ruleModules ) ) )* )? otherlv_6= '}' ) ;
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
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:260:28: ( ( () otherlv_1= 'Modules' otherlv_2= '{' ( ( (lv_modules_3_0= ruleModules ) ) (otherlv_4= ';' ( (lv_modules_5_0= ruleModules ) ) )* )? otherlv_6= '}' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:261:1: ( () otherlv_1= 'Modules' otherlv_2= '{' ( ( (lv_modules_3_0= ruleModules ) ) (otherlv_4= ';' ( (lv_modules_5_0= ruleModules ) ) )* )? otherlv_6= '}' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:261:1: ( () otherlv_1= 'Modules' otherlv_2= '{' ( ( (lv_modules_3_0= ruleModules ) ) (otherlv_4= ';' ( (lv_modules_5_0= ruleModules ) ) )* )? otherlv_6= '}' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:261:2: () otherlv_1= 'Modules' otherlv_2= '{' ( ( (lv_modules_3_0= ruleModules ) ) (otherlv_4= ';' ( (lv_modules_5_0= ruleModules ) ) )* )? otherlv_6= '}'
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:261:2: ()
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:262:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModuleListAccess().getModuleListAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleModuleList496); 

                	newLeafNode(otherlv_1, grammarAccess.getModuleListAccess().getModulesKeyword_1());
                
            otherlv_2=(Token)match(input,14,FOLLOW_14_in_ruleModuleList508); 

                	newLeafNode(otherlv_2, grammarAccess.getModuleListAccess().getLeftCurlyBracketKeyword_2());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:275:1: ( ( (lv_modules_3_0= ruleModules ) ) (otherlv_4= ';' ( (lv_modules_5_0= ruleModules ) ) )* )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( ((LA3_0>=RULE_STRING && LA3_0<=RULE_ID)) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:275:2: ( (lv_modules_3_0= ruleModules ) ) (otherlv_4= ';' ( (lv_modules_5_0= ruleModules ) ) )*
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:275:2: ( (lv_modules_3_0= ruleModules ) )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:276:1: (lv_modules_3_0= ruleModules )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:276:1: (lv_modules_3_0= ruleModules )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:277:3: lv_modules_3_0= ruleModules
                    {
                     
                    	        newCompositeNode(grammarAccess.getModuleListAccess().getModulesModulesParserRuleCall_3_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleModules_in_ruleModuleList530);
                    lv_modules_3_0=ruleModules();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModuleListRule());
                    	        }
                           		add(
                           			current, 
                           			"modules",
                            		lv_modules_3_0, 
                            		"Modules");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:293:2: (otherlv_4= ';' ( (lv_modules_5_0= ruleModules ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==12) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:293:4: otherlv_4= ';' ( (lv_modules_5_0= ruleModules ) )
                    	    {
                    	    otherlv_4=(Token)match(input,12,FOLLOW_12_in_ruleModuleList543); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getModuleListAccess().getSemicolonKeyword_3_1_0());
                    	        
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:297:1: ( (lv_modules_5_0= ruleModules ) )
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:298:1: (lv_modules_5_0= ruleModules )
                    	    {
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:298:1: (lv_modules_5_0= ruleModules )
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:299:3: lv_modules_5_0= ruleModules
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModuleListAccess().getModulesModulesParserRuleCall_3_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleModules_in_ruleModuleList564);
                    	    lv_modules_5_0=ruleModules();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModuleListRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"modules",
                    	            		lv_modules_5_0, 
                    	            		"Modules");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop2;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,15,FOLLOW_15_in_ruleModuleList580); 

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


    // $ANTLR start "entryRuleModules"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:327:1: entryRuleModules returns [EObject current=null] : iv_ruleModules= ruleModules EOF ;
    public final EObject entryRuleModules() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModules = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:328:2: (iv_ruleModules= ruleModules EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:329:2: iv_ruleModules= ruleModules EOF
            {
             newCompositeNode(grammarAccess.getModulesRule()); 
            pushFollow(FOLLOW_ruleModules_in_entryRuleModules616);
            iv_ruleModules=ruleModules();

            state._fsp--;

             current =iv_ruleModules; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModules626); 

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
    // $ANTLR end "entryRuleModules"


    // $ANTLR start "ruleModules"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:336:1: ruleModules returns [EObject current=null] : ( ( (lv_path_0_0= ruleEString ) ) otherlv_1= '::' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_ruleName_4_0= ruleRules ) ) (otherlv_5= ',' ( (lv_ruleName_6_0= ruleRules ) ) )* ) ;
    public final EObject ruleModules() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        AntlrDatatypeRuleToken lv_path_0_0 = null;

        AntlrDatatypeRuleToken lv_name_2_0 = null;

        EObject lv_ruleName_4_0 = null;

        EObject lv_ruleName_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:339:28: ( ( ( (lv_path_0_0= ruleEString ) ) otherlv_1= '::' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_ruleName_4_0= ruleRules ) ) (otherlv_5= ',' ( (lv_ruleName_6_0= ruleRules ) ) )* ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:340:1: ( ( (lv_path_0_0= ruleEString ) ) otherlv_1= '::' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_ruleName_4_0= ruleRules ) ) (otherlv_5= ',' ( (lv_ruleName_6_0= ruleRules ) ) )* )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:340:1: ( ( (lv_path_0_0= ruleEString ) ) otherlv_1= '::' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_ruleName_4_0= ruleRules ) ) (otherlv_5= ',' ( (lv_ruleName_6_0= ruleRules ) ) )* )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:340:2: ( (lv_path_0_0= ruleEString ) ) otherlv_1= '::' ( (lv_name_2_0= ruleEString ) ) otherlv_3= ':' ( (lv_ruleName_4_0= ruleRules ) ) (otherlv_5= ',' ( (lv_ruleName_6_0= ruleRules ) ) )*
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:340:2: ( (lv_path_0_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:341:1: (lv_path_0_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:341:1: (lv_path_0_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:342:3: lv_path_0_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getModulesAccess().getPathEStringParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleModules672);
            lv_path_0_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModulesRule());
            	        }
                   		set(
                   			current, 
                   			"path",
                    		lv_path_0_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleModules684); 

                	newLeafNode(otherlv_1, grammarAccess.getModulesAccess().getColonColonKeyword_1());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:362:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:363:1: (lv_name_2_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:363:1: (lv_name_2_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:364:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getModulesAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleModules705);
            lv_name_2_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModulesRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_2_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleModules717); 

                	newLeafNode(otherlv_3, grammarAccess.getModulesAccess().getColonKeyword_3());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:384:1: ( (lv_ruleName_4_0= ruleRules ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:385:1: (lv_ruleName_4_0= ruleRules )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:385:1: (lv_ruleName_4_0= ruleRules )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:386:3: lv_ruleName_4_0= ruleRules
            {
             
            	        newCompositeNode(grammarAccess.getModulesAccess().getRuleNameRulesParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleRules_in_ruleModules738);
            lv_ruleName_4_0=ruleRules();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getModulesRule());
            	        }
                   		add(
                   			current, 
                   			"ruleName",
                    		lv_ruleName_4_0, 
                    		"Rules");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:402:2: (otherlv_5= ',' ( (lv_ruleName_6_0= ruleRules ) ) )*
            loop4:
            do {
                int alt4=2;
                int LA4_0 = input.LA(1);

                if ( (LA4_0==18) ) {
                    alt4=1;
                }


                switch (alt4) {
            	case 1 :
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:402:4: otherlv_5= ',' ( (lv_ruleName_6_0= ruleRules ) )
            	    {
            	    otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleModules751); 

            	        	newLeafNode(otherlv_5, grammarAccess.getModulesAccess().getCommaKeyword_5_0());
            	        
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:406:1: ( (lv_ruleName_6_0= ruleRules ) )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:407:1: (lv_ruleName_6_0= ruleRules )
            	    {
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:407:1: (lv_ruleName_6_0= ruleRules )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:408:3: lv_ruleName_6_0= ruleRules
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModulesAccess().getRuleNameRulesParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRules_in_ruleModules772);
            	    lv_ruleName_6_0=ruleRules();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getModulesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ruleName",
            	            		lv_ruleName_6_0, 
            	            		"Rules");
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
    // $ANTLR end "ruleModules"


    // $ANTLR start "entryRuleTransformationList"
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:432:1: entryRuleTransformationList returns [EObject current=null] : iv_ruleTransformationList= ruleTransformationList EOF ;
    public final EObject entryRuleTransformationList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationList = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:433:2: (iv_ruleTransformationList= ruleTransformationList EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:434:2: iv_ruleTransformationList= ruleTransformationList EOF
            {
             newCompositeNode(grammarAccess.getTransformationListRule()); 
            pushFollow(FOLLOW_ruleTransformationList_in_entryRuleTransformationList810);
            iv_ruleTransformationList=ruleTransformationList();

            state._fsp--;

             current =iv_ruleTransformationList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationList820); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:441:1: ruleTransformationList returns [EObject current=null] : (otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}' ) ;
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
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:444:28: ( (otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:445:1: (otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:445:1: (otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:445:3: otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleTransformationList857); 

                	newLeafNode(otherlv_0, grammarAccess.getTransformationListAccess().getTransformationsKeyword_0());
                
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleTransformationList869); 

                	newLeafNode(otherlv_1, grammarAccess.getTransformationListAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:453:1: ( (lv_transformations_2_0= ruleTransformation ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:454:1: (lv_transformations_2_0= ruleTransformation )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:454:1: (lv_transformations_2_0= ruleTransformation )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:455:3: lv_transformations_2_0= ruleTransformation
            {
             
            	        newCompositeNode(grammarAccess.getTransformationListAccess().getTransformationsTransformationParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleTransformation_in_ruleTransformationList890);
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

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:471:2: (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:471:4: otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleTransformationList903); 

            	        	newLeafNode(otherlv_3, grammarAccess.getTransformationListAccess().getCommaKeyword_3_0());
            	        
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:475:1: ( (lv_transformations_4_0= ruleTransformation ) )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:476:1: (lv_transformations_4_0= ruleTransformation )
            	    {
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:476:1: (lv_transformations_4_0= ruleTransformation )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:477:3: lv_transformations_4_0= ruleTransformation
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTransformationListAccess().getTransformationsTransformationParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransformation_in_ruleTransformationList924);
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

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleTransformationList938); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:505:1: entryRuleTransformation returns [EObject current=null] : iv_ruleTransformation= ruleTransformation EOF ;
    public final EObject entryRuleTransformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformation = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:506:2: (iv_ruleTransformation= ruleTransformation EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:507:2: iv_ruleTransformation= ruleTransformation EOF
            {
             newCompositeNode(grammarAccess.getTransformationRule()); 
            pushFollow(FOLLOW_ruleTransformation_in_entryRuleTransformation974);
            iv_ruleTransformation=ruleTransformation();

            state._fsp--;

             current =iv_ruleTransformation; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformation984); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:514:1: ruleTransformation returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}' ) ;
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
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:517:28: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:518:1: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:518:1: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:518:2: ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( ( ruleEString ) ) (otherlv_5= ',' ( ( ruleEString ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}'
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:518:2: ( (lv_name_0_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:519:1: (lv_name_0_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:519:1: (lv_name_0_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:520:3: lv_name_0_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTransformationAccess().getNameEStringParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleTransformation1030);
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

            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleTransformation1042); 

                	newLeafNode(otherlv_1, grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleTransformation1054); 

                	newLeafNode(otherlv_2, grammarAccess.getTransformationAccess().getModulesKeyword_2());
                
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleTransformation1066); 

                	newLeafNode(otherlv_3, grammarAccess.getTransformationAccess().getColonKeyword_3());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:548:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:549:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:549:1: ( ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:550:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransformationRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTransformationAccess().getModulesModulesCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleTransformation1089);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:563:2: (otherlv_5= ',' ( ( ruleEString ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:563:4: otherlv_5= ',' ( ( ruleEString ) )
            	    {
            	    otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleTransformation1102); 

            	        	newLeafNode(otherlv_5, grammarAccess.getTransformationAccess().getCommaKeyword_5_0());
            	        
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:567:1: ( ( ruleEString ) )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:568:1: ( ruleEString )
            	    {
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:568:1: ( ruleEString )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:569:3: ruleEString
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getTransformationRule());
            	    	        }
            	            
            	     
            	    	        newCompositeNode(grammarAccess.getTransformationAccess().getModulesModulesCrossReference_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEString_in_ruleTransformation1125);
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

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:582:4: (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:582:6: otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )*
                    {
                    otherlv_7=(Token)match(input,21,FOLLOW_21_in_ruleTransformation1140); 

                        	newLeafNode(otherlv_7, grammarAccess.getTransformationAccess().getImpactsKeyword_6_0());
                        
                    otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleTransformation1152); 

                        	newLeafNode(otherlv_8, grammarAccess.getTransformationAccess().getColonKeyword_6_1());
                        
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:590:1: ( (lv_impacts_9_0= ruleTransformationImpact ) )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:591:1: (lv_impacts_9_0= ruleTransformationImpact )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:591:1: (lv_impacts_9_0= ruleTransformationImpact )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:592:3: lv_impacts_9_0= ruleTransformationImpact
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransformationAccess().getImpactsTransformationImpactParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTransformationImpact_in_ruleTransformation1173);
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

                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:608:2: (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==18) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:608:4: otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) )
                    	    {
                    	    otherlv_10=(Token)match(input,18,FOLLOW_18_in_ruleTransformation1186); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getTransformationAccess().getCommaKeyword_6_3_0());
                    	        
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:612:1: ( (lv_impacts_11_0= ruleTransformationImpact ) )
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:613:1: (lv_impacts_11_0= ruleTransformationImpact )
                    	    {
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:613:1: (lv_impacts_11_0= ruleTransformationImpact )
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:614:3: lv_impacts_11_0= ruleTransformationImpact
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTransformationAccess().getImpactsTransformationImpactParserRuleCall_6_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTransformationImpact_in_ruleTransformation1207);
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

            otherlv_12=(Token)match(input,15,FOLLOW_15_in_ruleTransformation1223); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:642:1: entryRuleTransformationImpact returns [EObject current=null] : iv_ruleTransformationImpact= ruleTransformationImpact EOF ;
    public final EObject entryRuleTransformationImpact() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationImpact = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:643:2: (iv_ruleTransformationImpact= ruleTransformationImpact EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:644:2: iv_ruleTransformationImpact= ruleTransformationImpact EOF
            {
             newCompositeNode(grammarAccess.getTransformationImpactRule()); 
            pushFollow(FOLLOW_ruleTransformationImpact_in_entryRuleTransformationImpact1259);
            iv_ruleTransformationImpact=ruleTransformationImpact();

            state._fsp--;

             current =iv_ruleTransformationImpact; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationImpact1269); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:651:1: ruleTransformationImpact returns [EObject current=null] : (otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')' ) ;
    public final EObject ruleTransformationImpact() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_qualityAttributeName_1_0 = null;

        AntlrDatatypeRuleToken lv_impactValue_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:654:28: ( (otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:655:1: (otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:655:1: (otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:655:3: otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleTransformationImpact1306); 

                	newLeafNode(otherlv_0, grammarAccess.getTransformationImpactAccess().getLeftParenthesisKeyword_0());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:659:1: ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=RULE_STRING && LA9_0<=RULE_ID)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:659:2: ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ','
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:659:2: ( (lv_qualityAttributeName_1_0= ruleEString ) )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:660:1: (lv_qualityAttributeName_1_0= ruleEString )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:660:1: (lv_qualityAttributeName_1_0= ruleEString )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:661:3: lv_qualityAttributeName_1_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransformationImpactAccess().getQualityAttributeNameEStringParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEString_in_ruleTransformationImpact1328);
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

                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleTransformationImpact1340); 

                        	newLeafNode(otherlv_2, grammarAccess.getTransformationImpactAccess().getCommaKeyword_1_1());
                        

                    }
                    break;

            }

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:681:3: ( (lv_impactValue_3_0= ruleEInt ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:682:1: (lv_impactValue_3_0= ruleEInt )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:682:1: (lv_impactValue_3_0= ruleEInt )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:683:3: lv_impactValue_3_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getTransformationImpactAccess().getImpactValueEIntParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleEInt_in_ruleTransformationImpact1363);
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

            otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleTransformationImpact1375); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:711:1: entryRuleTransformationDependencyList returns [EObject current=null] : iv_ruleTransformationDependencyList= ruleTransformationDependencyList EOF ;
    public final EObject entryRuleTransformationDependencyList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationDependencyList = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:712:2: (iv_ruleTransformationDependencyList= ruleTransformationDependencyList EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:713:2: iv_ruleTransformationDependencyList= ruleTransformationDependencyList EOF
            {
             newCompositeNode(grammarAccess.getTransformationDependencyListRule()); 
            pushFollow(FOLLOW_ruleTransformationDependencyList_in_entryRuleTransformationDependencyList1411);
            iv_ruleTransformationDependencyList=ruleTransformationDependencyList();

            state._fsp--;

             current =iv_ruleTransformationDependencyList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationDependencyList1421); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:720:1: ruleTransformationDependencyList returns [EObject current=null] : (otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )* otherlv_7= '}' otherlv_8= '}' ) ;
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
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:723:28: ( (otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )* otherlv_7= '}' otherlv_8= '}' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:724:1: (otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )* otherlv_7= '}' otherlv_8= '}' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:724:1: (otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )* otherlv_7= '}' otherlv_8= '}' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:724:3: otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )* otherlv_7= '}' otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleTransformationDependencyList1458); 

                	newLeafNode(otherlv_0, grammarAccess.getTransformationDependencyListAccess().getDependenciesKeyword_0());
                
            otherlv_1=(Token)match(input,14,FOLLOW_14_in_ruleTransformationDependencyList1470); 

                	newLeafNode(otherlv_1, grammarAccess.getTransformationDependencyListAccess().getLeftCurlyBracketKeyword_1());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:732:1: ( (lv_name_2_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:733:1: (lv_name_2_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:733:1: (lv_name_2_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:734:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyListAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleTransformationDependencyList1491);
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

            otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleTransformationDependencyList1503); 

                	newLeafNode(otherlv_3, grammarAccess.getTransformationDependencyListAccess().getLeftCurlyBracketKeyword_3());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:754:1: ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:755:1: (lv_transformationDependencies_4_0= ruleTransformationDependency )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:755:1: (lv_transformationDependencies_4_0= ruleTransformationDependency )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:756:3: lv_transformationDependencies_4_0= ruleTransformationDependency
            {
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesTransformationDependencyParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleTransformationDependency_in_ruleTransformationDependencyList1524);
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

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:772:2: (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==12) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:772:4: otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) )
            	    {
            	    otherlv_5=(Token)match(input,12,FOLLOW_12_in_ruleTransformationDependencyList1537); 

            	        	newLeafNode(otherlv_5, grammarAccess.getTransformationDependencyListAccess().getSemicolonKeyword_5_0());
            	        
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:776:1: ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:777:1: (lv_transformationDependencies_6_0= ruleTransformationDependency )
            	    {
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:777:1: (lv_transformationDependencies_6_0= ruleTransformationDependency )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:778:3: lv_transformationDependencies_6_0= ruleTransformationDependency
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesTransformationDependencyParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransformationDependency_in_ruleTransformationDependencyList1558);
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

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleTransformationDependencyList1572); 

                	newLeafNode(otherlv_7, grammarAccess.getTransformationDependencyListAccess().getRightCurlyBracketKeyword_6());
                
            otherlv_8=(Token)match(input,15,FOLLOW_15_in_ruleTransformationDependencyList1584); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:810:1: entryRuleTransformationDependency returns [EObject current=null] : iv_ruleTransformationDependency= ruleTransformationDependency EOF ;
    public final EObject entryRuleTransformationDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationDependency = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:811:2: (iv_ruleTransformationDependency= ruleTransformationDependency EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:812:2: iv_ruleTransformationDependency= ruleTransformationDependency EOF
            {
             newCompositeNode(grammarAccess.getTransformationDependencyRule()); 
            pushFollow(FOLLOW_ruleTransformationDependency_in_entryRuleTransformationDependency1620);
            iv_ruleTransformationDependency=ruleTransformationDependency();

            state._fsp--;

             current =iv_ruleTransformationDependency; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationDependency1630); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:819:1: ruleTransformationDependency returns [EObject current=null] : (otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( (lv_appliedRule_4_0= ruleEString ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fields_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) (otherlv_14= 'and' | otherlv_15= 'or' )? ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) )* otherlv_17= ']' ) ;
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
        Token otherlv_15=null;
        Token otherlv_17=null;
        AntlrDatatypeRuleToken lv_appliedRule_4_0 = null;

        AntlrDatatypeRuleToken lv_fields_7_0 = null;

        AntlrDatatypeRuleToken lv_fields_9_0 = null;

        EObject lv_requiredTransformations_13_0 = null;

        EObject lv_requiredTransformations_16_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:822:28: ( (otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( (lv_appliedRule_4_0= ruleEString ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fields_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) (otherlv_14= 'and' | otherlv_15= 'or' )? ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) )* otherlv_17= ']' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:823:1: (otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( (lv_appliedRule_4_0= ruleEString ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fields_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) (otherlv_14= 'and' | otherlv_15= 'or' )? ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) )* otherlv_17= ']' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:823:1: (otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( (lv_appliedRule_4_0= ruleEString ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fields_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) (otherlv_14= 'and' | otherlv_15= 'or' )? ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) )* otherlv_17= ']' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:823:3: otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( (lv_appliedRule_4_0= ruleEString ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fields_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) ) (otherlv_14= 'and' | otherlv_15= 'or' )? ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) )* otherlv_17= ']'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleTransformationDependency1667); 

                	newLeafNode(otherlv_0, grammarAccess.getTransformationDependencyAccess().getApplyKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleTransformationDependency1679); 

                	newLeafNode(otherlv_1, grammarAccess.getTransformationDependencyAccess().getLeftParenthesisKeyword_1());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:831:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:832:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:832:1: ( ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:833:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransformationDependencyRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationTransformationCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleTransformationDependency1702);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,26,FOLLOW_26_in_ruleTransformationDependency1714); 

                	newLeafNode(otherlv_3, grammarAccess.getTransformationDependencyAccess().getFullStopKeyword_3());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:850:1: ( (lv_appliedRule_4_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:851:1: (lv_appliedRule_4_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:851:1: (lv_appliedRule_4_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:852:3: lv_appliedRule_4_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getAppliedRuleEStringParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleTransformationDependency1735);
            lv_appliedRule_4_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTransformationDependencyRule());
            	        }
                   		set(
                   			current, 
                   			"appliedRule",
                    		lv_appliedRule_4_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleTransformationDependency1747); 

                	newLeafNode(otherlv_5, grammarAccess.getTransformationDependencyAccess().getCommaKeyword_5());
                
            otherlv_6=(Token)match(input,14,FOLLOW_14_in_ruleTransformationDependency1759); 

                	newLeafNode(otherlv_6, grammarAccess.getTransformationDependencyAccess().getLeftCurlyBracketKeyword_6());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:876:1: ( (lv_fields_7_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:877:1: (lv_fields_7_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:877:1: (lv_fields_7_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:878:3: lv_fields_7_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getFieldsEStringParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleTransformationDependency1780);
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

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:894:2: (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==18) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:894:4: otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) )
            	    {
            	    otherlv_8=(Token)match(input,18,FOLLOW_18_in_ruleTransformationDependency1793); 

            	        	newLeafNode(otherlv_8, grammarAccess.getTransformationDependencyAccess().getCommaKeyword_8_0());
            	        
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:898:1: ( (lv_fields_9_0= ruleEString ) )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:899:1: (lv_fields_9_0= ruleEString )
            	    {
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:899:1: (lv_fields_9_0= ruleEString )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:900:3: lv_fields_9_0= ruleEString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getFieldsEStringParserRuleCall_8_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEString_in_ruleTransformationDependency1814);
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

            otherlv_10=(Token)match(input,15,FOLLOW_15_in_ruleTransformationDependency1828); 

                	newLeafNode(otherlv_10, grammarAccess.getTransformationDependencyAccess().getRightCurlyBracketKeyword_9());
                
            otherlv_11=(Token)match(input,23,FOLLOW_23_in_ruleTransformationDependency1840); 

                	newLeafNode(otherlv_11, grammarAccess.getTransformationDependencyAccess().getRightParenthesisKeyword_10());
                
            otherlv_12=(Token)match(input,27,FOLLOW_27_in_ruleTransformationDependency1852); 

                	newLeafNode(otherlv_12, grammarAccess.getTransformationDependencyAccess().getLeftSquareBracketKeyword_11());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:928:1: ( (lv_requiredTransformations_13_0= ruleAbstractRuleDependency ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:929:1: (lv_requiredTransformations_13_0= ruleAbstractRuleDependency )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:929:1: (lv_requiredTransformations_13_0= ruleAbstractRuleDependency )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:930:3: lv_requiredTransformations_13_0= ruleAbstractRuleDependency
            {
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_12_0()); 
            	    
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_ruleTransformationDependency1873);
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

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:946:2: (otherlv_14= 'and' | otherlv_15= 'or' )?
            int alt12=3;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==28) ) {
                alt12=1;
            }
            else if ( (LA12_0==29) ) {
                alt12=2;
            }
            switch (alt12) {
                case 1 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:946:4: otherlv_14= 'and'
                    {
                    otherlv_14=(Token)match(input,28,FOLLOW_28_in_ruleTransformationDependency1886); 

                        	newLeafNode(otherlv_14, grammarAccess.getTransformationDependencyAccess().getAndKeyword_13_0());
                        

                    }
                    break;
                case 2 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:951:7: otherlv_15= 'or'
                    {
                    otherlv_15=(Token)match(input,29,FOLLOW_29_in_ruleTransformationDependency1904); 

                        	newLeafNode(otherlv_15, grammarAccess.getTransformationDependencyAccess().getOrKeyword_13_1());
                        

                    }
                    break;

            }

            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:955:3: ( (lv_requiredTransformations_16_0= ruleAbstractRuleDependency ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( ((LA13_0>=31 && LA13_0<=32)) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:956:1: (lv_requiredTransformations_16_0= ruleAbstractRuleDependency )
            	    {
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:956:1: (lv_requiredTransformations_16_0= ruleAbstractRuleDependency )
            	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:957:3: lv_requiredTransformations_16_0= ruleAbstractRuleDependency
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsAbstractRuleDependencyParserRuleCall_14_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleAbstractRuleDependency_in_ruleTransformationDependency1927);
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
            	    break;

            	default :
            	    break loop13;
                }
            } while (true);

            otherlv_17=(Token)match(input,30,FOLLOW_30_in_ruleTransformationDependency1940); 

                	newLeafNode(otherlv_17, grammarAccess.getTransformationDependencyAccess().getRightSquareBracketKeyword_15());
                

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:985:1: entryRuleAbstractRuleDependency returns [EObject current=null] : iv_ruleAbstractRuleDependency= ruleAbstractRuleDependency EOF ;
    public final EObject entryRuleAbstractRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAbstractRuleDependency = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:986:2: (iv_ruleAbstractRuleDependency= ruleAbstractRuleDependency EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:987:2: iv_ruleAbstractRuleDependency= ruleAbstractRuleDependency EOF
            {
             newCompositeNode(grammarAccess.getAbstractRuleDependencyRule()); 
            pushFollow(FOLLOW_ruleAbstractRuleDependency_in_entryRuleAbstractRuleDependency1976);
            iv_ruleAbstractRuleDependency=ruleAbstractRuleDependency();

            state._fsp--;

             current =iv_ruleAbstractRuleDependency; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleAbstractRuleDependency1986); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:994:1: ruleAbstractRuleDependency returns [EObject current=null] : this_RuleDependency_0= ruleRuleDependency ;
    public final EObject ruleAbstractRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject this_RuleDependency_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:997:28: (this_RuleDependency_0= ruleRuleDependency )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:999:5: this_RuleDependency_0= ruleRuleDependency
            {
             
                    newCompositeNode(grammarAccess.getAbstractRuleDependencyAccess().getRuleDependencyParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleRuleDependency_in_ruleAbstractRuleDependency2032);
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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1019:1: entryRuleRuleDependency returns [EObject current=null] : iv_ruleRuleDependency= ruleRuleDependency EOF ;
    public final EObject entryRuleRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDependency = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1020:2: (iv_ruleRuleDependency= ruleRuleDependency EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1021:2: iv_ruleRuleDependency= ruleRuleDependency EOF
            {
             newCompositeNode(grammarAccess.getRuleDependencyRule()); 
            pushFollow(FOLLOW_ruleRuleDependency_in_entryRuleRuleDependency2070);
            iv_ruleRuleDependency=ruleRuleDependency();

            state._fsp--;

             current =iv_ruleRuleDependency; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDependency2080); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1028:1: ruleRuleDependency returns [EObject current=null] : ( (otherlv_0= 'requires' ( (lv_rd_1_0= rulerequiresDependency ) ) (otherlv_2= 'and' | otherlv_3= 'or' )? ( (lv_rd_4_0= rulerequiresDependency ) )* ) | (otherlv_5= 'excludes' ( (lv_rd_6_0= ruleexcludeDependency ) ) (otherlv_7= 'and' | otherlv_8= 'or' )? ( (lv_ed_9_0= ruleexcludeDependency ) )* ) ) ;
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
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1031:28: ( ( (otherlv_0= 'requires' ( (lv_rd_1_0= rulerequiresDependency ) ) (otherlv_2= 'and' | otherlv_3= 'or' )? ( (lv_rd_4_0= rulerequiresDependency ) )* ) | (otherlv_5= 'excludes' ( (lv_rd_6_0= ruleexcludeDependency ) ) (otherlv_7= 'and' | otherlv_8= 'or' )? ( (lv_ed_9_0= ruleexcludeDependency ) )* ) ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1032:1: ( (otherlv_0= 'requires' ( (lv_rd_1_0= rulerequiresDependency ) ) (otherlv_2= 'and' | otherlv_3= 'or' )? ( (lv_rd_4_0= rulerequiresDependency ) )* ) | (otherlv_5= 'excludes' ( (lv_rd_6_0= ruleexcludeDependency ) ) (otherlv_7= 'and' | otherlv_8= 'or' )? ( (lv_ed_9_0= ruleexcludeDependency ) )* ) )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1032:1: ( (otherlv_0= 'requires' ( (lv_rd_1_0= rulerequiresDependency ) ) (otherlv_2= 'and' | otherlv_3= 'or' )? ( (lv_rd_4_0= rulerequiresDependency ) )* ) | (otherlv_5= 'excludes' ( (lv_rd_6_0= ruleexcludeDependency ) ) (otherlv_7= 'and' | otherlv_8= 'or' )? ( (lv_ed_9_0= ruleexcludeDependency ) )* ) )
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==31) ) {
                alt18=1;
            }
            else if ( (LA18_0==32) ) {
                alt18=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 18, 0, input);

                throw nvae;
            }
            switch (alt18) {
                case 1 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1032:2: (otherlv_0= 'requires' ( (lv_rd_1_0= rulerequiresDependency ) ) (otherlv_2= 'and' | otherlv_3= 'or' )? ( (lv_rd_4_0= rulerequiresDependency ) )* )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1032:2: (otherlv_0= 'requires' ( (lv_rd_1_0= rulerequiresDependency ) ) (otherlv_2= 'and' | otherlv_3= 'or' )? ( (lv_rd_4_0= rulerequiresDependency ) )* )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1032:4: otherlv_0= 'requires' ( (lv_rd_1_0= rulerequiresDependency ) ) (otherlv_2= 'and' | otherlv_3= 'or' )? ( (lv_rd_4_0= rulerequiresDependency ) )*
                    {
                    otherlv_0=(Token)match(input,31,FOLLOW_31_in_ruleRuleDependency2118); 

                        	newLeafNode(otherlv_0, grammarAccess.getRuleDependencyAccess().getRequiresKeyword_0_0());
                        
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1036:1: ( (lv_rd_1_0= rulerequiresDependency ) )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1037:1: (lv_rd_1_0= rulerequiresDependency )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1037:1: (lv_rd_1_0= rulerequiresDependency )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1038:3: lv_rd_1_0= rulerequiresDependency
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleDependencyAccess().getRdRequiresDependencyParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulerequiresDependency_in_ruleRuleDependency2139);
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

                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1054:2: (otherlv_2= 'and' | otherlv_3= 'or' )?
                    int alt14=3;
                    int LA14_0 = input.LA(1);

                    if ( (LA14_0==28) ) {
                        alt14=1;
                    }
                    else if ( (LA14_0==29) ) {
                        alt14=2;
                    }
                    switch (alt14) {
                        case 1 :
                            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1054:4: otherlv_2= 'and'
                            {
                            otherlv_2=(Token)match(input,28,FOLLOW_28_in_ruleRuleDependency2152); 

                                	newLeafNode(otherlv_2, grammarAccess.getRuleDependencyAccess().getAndKeyword_0_2_0());
                                

                            }
                            break;
                        case 2 :
                            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1059:7: otherlv_3= 'or'
                            {
                            otherlv_3=(Token)match(input,29,FOLLOW_29_in_ruleRuleDependency2170); 

                                	newLeafNode(otherlv_3, grammarAccess.getRuleDependencyAccess().getOrKeyword_0_2_1());
                                

                            }
                            break;

                    }

                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1063:3: ( (lv_rd_4_0= rulerequiresDependency ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==22) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1064:1: (lv_rd_4_0= rulerequiresDependency )
                    	    {
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1064:1: (lv_rd_4_0= rulerequiresDependency )
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1065:3: lv_rd_4_0= rulerequiresDependency
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getRuleDependencyAccess().getRdRequiresDependencyParserRuleCall_0_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulerequiresDependency_in_ruleRuleDependency2193);
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
                    	    break loop15;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1082:6: (otherlv_5= 'excludes' ( (lv_rd_6_0= ruleexcludeDependency ) ) (otherlv_7= 'and' | otherlv_8= 'or' )? ( (lv_ed_9_0= ruleexcludeDependency ) )* )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1082:6: (otherlv_5= 'excludes' ( (lv_rd_6_0= ruleexcludeDependency ) ) (otherlv_7= 'and' | otherlv_8= 'or' )? ( (lv_ed_9_0= ruleexcludeDependency ) )* )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1082:8: otherlv_5= 'excludes' ( (lv_rd_6_0= ruleexcludeDependency ) ) (otherlv_7= 'and' | otherlv_8= 'or' )? ( (lv_ed_9_0= ruleexcludeDependency ) )*
                    {
                    otherlv_5=(Token)match(input,32,FOLLOW_32_in_ruleRuleDependency2214); 

                        	newLeafNode(otherlv_5, grammarAccess.getRuleDependencyAccess().getExcludesKeyword_1_0());
                        
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1086:1: ( (lv_rd_6_0= ruleexcludeDependency ) )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1087:1: (lv_rd_6_0= ruleexcludeDependency )
                    {
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1087:1: (lv_rd_6_0= ruleexcludeDependency )
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1088:3: lv_rd_6_0= ruleexcludeDependency
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleDependencyAccess().getRdExcludeDependencyParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleexcludeDependency_in_ruleRuleDependency2235);
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

                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1104:2: (otherlv_7= 'and' | otherlv_8= 'or' )?
                    int alt16=3;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==28) ) {
                        alt16=1;
                    }
                    else if ( (LA16_0==29) ) {
                        alt16=2;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1104:4: otherlv_7= 'and'
                            {
                            otherlv_7=(Token)match(input,28,FOLLOW_28_in_ruleRuleDependency2248); 

                                	newLeafNode(otherlv_7, grammarAccess.getRuleDependencyAccess().getAndKeyword_1_2_0());
                                

                            }
                            break;
                        case 2 :
                            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1109:7: otherlv_8= 'or'
                            {
                            otherlv_8=(Token)match(input,29,FOLLOW_29_in_ruleRuleDependency2266); 

                                	newLeafNode(otherlv_8, grammarAccess.getRuleDependencyAccess().getOrKeyword_1_2_1());
                                

                            }
                            break;

                    }

                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1113:3: ( (lv_ed_9_0= ruleexcludeDependency ) )*
                    loop17:
                    do {
                        int alt17=2;
                        int LA17_0 = input.LA(1);

                        if ( (LA17_0==22) ) {
                            alt17=1;
                        }


                        switch (alt17) {
                    	case 1 :
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1114:1: (lv_ed_9_0= ruleexcludeDependency )
                    	    {
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1114:1: (lv_ed_9_0= ruleexcludeDependency )
                    	    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1115:3: lv_ed_9_0= ruleexcludeDependency
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getRuleDependencyAccess().getEdExcludeDependencyParserRuleCall_1_3_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleexcludeDependency_in_ruleRuleDependency2289);
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
                    	    break loop17;
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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1139:1: entryRulerequiresDependency returns [EObject current=null] : iv_rulerequiresDependency= rulerequiresDependency EOF ;
    public final EObject entryRulerequiresDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerequiresDependency = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1140:2: (iv_rulerequiresDependency= rulerequiresDependency EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1141:2: iv_rulerequiresDependency= rulerequiresDependency EOF
            {
             newCompositeNode(grammarAccess.getRequiresDependencyRule()); 
            pushFollow(FOLLOW_rulerequiresDependency_in_entryRulerequiresDependency2327);
            iv_rulerequiresDependency=rulerequiresDependency();

            state._fsp--;

             current =iv_rulerequiresDependency; 
            match(input,EOF,FOLLOW_EOF_in_entryRulerequiresDependency2337); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1148:1: rulerequiresDependency returns [EObject current=null] : (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( (lv_requiredRule_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')' ) ;
    public final EObject rulerequiresDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_requiredRule_3_0 = null;

        AntlrDatatypeRuleToken lv_fields_5_0 = null;

        AntlrDatatypeRuleToken lv_oclExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1151:28: ( (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( (lv_requiredRule_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1152:1: (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( (lv_requiredRule_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1152:1: (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( (lv_requiredRule_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1152:3: otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( (lv_requiredRule_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_rulerequiresDependency2374); 

                	newLeafNode(otherlv_0, grammarAccess.getRequiresDependencyAccess().getLeftParenthesisKeyword_0());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1156:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1157:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1157:1: ( ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1158:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRequiresDependencyRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRequiresDependencyAccess().getRequiredTransformationTransformationCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_rulerequiresDependency2397);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_rulerequiresDependency2409); 

                	newLeafNode(otherlv_2, grammarAccess.getRequiresDependencyAccess().getFullStopKeyword_2());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1175:1: ( (lv_requiredRule_3_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1176:1: (lv_requiredRule_3_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1176:1: (lv_requiredRule_3_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1177:3: lv_requiredRule_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getRequiresDependencyAccess().getRequiredRuleEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_rulerequiresDependency2430);
            lv_requiredRule_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRequiresDependencyRule());
            	        }
                   		set(
                   			current, 
                   			"requiredRule",
                    		lv_requiredRule_3_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_rulerequiresDependency2442); 

                	newLeafNode(otherlv_4, grammarAccess.getRequiresDependencyAccess().getCommaKeyword_4());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1197:1: ( (lv_fields_5_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1198:1: (lv_fields_5_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1198:1: (lv_fields_5_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1199:3: lv_fields_5_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getRequiresDependencyAccess().getFieldsEStringParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_rulerequiresDependency2463);
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

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_rulerequiresDependency2475); 

                	newLeafNode(otherlv_6, grammarAccess.getRequiresDependencyAccess().getColonKeyword_6());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1219:1: ( (lv_oclExpression_7_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1220:1: (lv_oclExpression_7_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1220:1: (lv_oclExpression_7_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1221:3: lv_oclExpression_7_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getRequiresDependencyAccess().getOclExpressionEStringParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_rulerequiresDependency2496);
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

            otherlv_8=(Token)match(input,23,FOLLOW_23_in_rulerequiresDependency2508); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1249:1: entryRuleexcludeDependency returns [EObject current=null] : iv_ruleexcludeDependency= ruleexcludeDependency EOF ;
    public final EObject entryRuleexcludeDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleexcludeDependency = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1250:2: (iv_ruleexcludeDependency= ruleexcludeDependency EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1251:2: iv_ruleexcludeDependency= ruleexcludeDependency EOF
            {
             newCompositeNode(grammarAccess.getExcludeDependencyRule()); 
            pushFollow(FOLLOW_ruleexcludeDependency_in_entryRuleexcludeDependency2544);
            iv_ruleexcludeDependency=ruleexcludeDependency();

            state._fsp--;

             current =iv_ruleexcludeDependency; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleexcludeDependency2554); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1258:1: ruleexcludeDependency returns [EObject current=null] : (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( (lv_requiredRule_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')' ) ;
    public final EObject ruleexcludeDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_requiredRule_3_0 = null;

        AntlrDatatypeRuleToken lv_fields_5_0 = null;

        AntlrDatatypeRuleToken lv_oclExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1261:28: ( (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( (lv_requiredRule_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')' ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1262:1: (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( (lv_requiredRule_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')' )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1262:1: (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( (lv_requiredRule_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')' )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1262:3: otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( (lv_requiredRule_3_0= ruleEString ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleEString ) ) otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleexcludeDependency2591); 

                	newLeafNode(otherlv_0, grammarAccess.getExcludeDependencyAccess().getLeftParenthesisKeyword_0());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1266:1: ( ( ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1267:1: ( ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1267:1: ( ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1268:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getExcludeDependencyRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getExcludeDependencyAccess().getRequiredTransformationTransformationCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleexcludeDependency2614);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_26_in_ruleexcludeDependency2626); 

                	newLeafNode(otherlv_2, grammarAccess.getExcludeDependencyAccess().getFullStopKeyword_2());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1285:1: ( (lv_requiredRule_3_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1286:1: (lv_requiredRule_3_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1286:1: (lv_requiredRule_3_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1287:3: lv_requiredRule_3_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getExcludeDependencyAccess().getRequiredRuleEStringParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleexcludeDependency2647);
            lv_requiredRule_3_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getExcludeDependencyRule());
            	        }
                   		set(
                   			current, 
                   			"requiredRule",
                    		lv_requiredRule_3_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleexcludeDependency2659); 

                	newLeafNode(otherlv_4, grammarAccess.getExcludeDependencyAccess().getCommaKeyword_4());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1307:1: ( (lv_fields_5_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1308:1: (lv_fields_5_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1308:1: (lv_fields_5_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1309:3: lv_fields_5_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getExcludeDependencyAccess().getFieldsEStringParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleexcludeDependency2680);
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

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_ruleexcludeDependency2692); 

                	newLeafNode(otherlv_6, grammarAccess.getExcludeDependencyAccess().getColonKeyword_6());
                
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1329:1: ( (lv_oclExpression_7_0= ruleEString ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1330:1: (lv_oclExpression_7_0= ruleEString )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1330:1: (lv_oclExpression_7_0= ruleEString )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1331:3: lv_oclExpression_7_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getExcludeDependencyAccess().getOclExpressionEStringParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleexcludeDependency2713);
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

            otherlv_8=(Token)match(input,23,FOLLOW_23_in_ruleexcludeDependency2725); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1363:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1364:2: (iv_ruleEString= ruleEString EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1365:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_ruleEString_in_entryRuleEString2766);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEString2777); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1372:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1375:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1376:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1376:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==RULE_STRING) ) {
                alt19=1;
            }
            else if ( (LA19_0==RULE_ID) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1376:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEString2817); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1384:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEString2843); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1399:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1400:2: (iv_ruleEInt= ruleEInt EOF )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1401:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_ruleEInt_in_entryRuleEInt2889);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEInt2900); 

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
    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1408:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1411:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1412:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1412:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1412:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1412:2: (kw= '-' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==33) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../org.trc.xtext.dsl/src-gen/org/trc/xtext/dsl/parser/antlr/internal/InternalDsl.g:1413:2: kw= '-'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleEInt2939); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEInt2956); 

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


 

    public static final BitSet FOLLOW_ruleTrcSpecification_in_entryRuleTrcSpecification75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrcSpecification85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFrom_in_ruleTrcSpecification131 = new BitSet(new long[]{0x0000000000002800L});
    public static final BitSet FOLLOW_ruleModuleList_in_ruleTrcSpecification153 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ruleTransformationList_in_ruleTrcSpecification174 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleTransformationDependencyList_in_ruleTrcSpecification195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFrom_in_entryRuleFrom231 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFrom241 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_ruleFrom278 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleFrom295 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_12_in_ruleFrom312 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRules_in_entryRuleRules348 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRules358 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_ruleRules403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModuleList_in_entryRuleModuleList440 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModuleList450 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_ruleModuleList496 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleModuleList508 = new BitSet(new long[]{0x0000000000008030L});
    public static final BitSet FOLLOW_ruleModules_in_ruleModuleList530 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_12_in_ruleModuleList543 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleModules_in_ruleModuleList564 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_15_in_ruleModuleList580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModules_in_entryRuleModules616 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModules626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_ruleModules672 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleModules684 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleModules705 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleModules717 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleRules_in_ruleModules738 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleModules751 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleRules_in_ruleModules772 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleTransformationList_in_entryRuleTransformationList810 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationList820 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleTransformationList857 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTransformationList869 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTransformation_in_ruleTransformationList890 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_18_in_ruleTransformationList903 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTransformation_in_ruleTransformationList924 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_ruleTransformationList938 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformation_in_entryRuleTransformation974 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformation984 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformation1030 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTransformation1042 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleTransformation1054 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTransformation1066 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformation1089 = new BitSet(new long[]{0x0000000000248000L});
    public static final BitSet FOLLOW_18_in_ruleTransformation1102 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformation1125 = new BitSet(new long[]{0x0000000000248000L});
    public static final BitSet FOLLOW_21_in_ruleTransformation1140 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTransformation1152 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_ruleTransformation1173 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_18_in_ruleTransformation1186 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_ruleTransformation1207 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_ruleTransformation1223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_entryRuleTransformationImpact1259 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationImpact1269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleTransformationImpact1306 = new BitSet(new long[]{0x0000000200000070L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationImpact1328 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTransformationImpact1340 = new BitSet(new long[]{0x0000000200000070L});
    public static final BitSet FOLLOW_ruleEInt_in_ruleTransformationImpact1363 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleTransformationImpact1375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependencyList_in_entryRuleTransformationDependencyList1411 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationDependencyList1421 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleTransformationDependencyList1458 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTransformationDependencyList1470 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationDependencyList1491 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTransformationDependencyList1503 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_ruleTransformationDependencyList1524 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_12_in_ruleTransformationDependencyList1537 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_ruleTransformationDependencyList1558 = new BitSet(new long[]{0x0000000000009000L});
    public static final BitSet FOLLOW_15_in_ruleTransformationDependencyList1572 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTransformationDependencyList1584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_entryRuleTransformationDependency1620 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationDependency1630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleTransformationDependency1667 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTransformationDependency1679 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationDependency1702 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleTransformationDependency1714 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationDependency1735 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTransformationDependency1747 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_14_in_ruleTransformationDependency1759 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationDependency1780 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_18_in_ruleTransformationDependency1793 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationDependency1814 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_ruleTransformationDependency1828 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleTransformationDependency1840 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleTransformationDependency1852 = new BitSet(new long[]{0x0000000180000000L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_ruleTransformationDependency1873 = new BitSet(new long[]{0x00000001F0000000L});
    public static final BitSet FOLLOW_28_in_ruleTransformationDependency1886 = new BitSet(new long[]{0x00000001C0000000L});
    public static final BitSet FOLLOW_29_in_ruleTransformationDependency1904 = new BitSet(new long[]{0x00000001C0000000L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_ruleTransformationDependency1927 = new BitSet(new long[]{0x00000001C0000000L});
    public static final BitSet FOLLOW_30_in_ruleTransformationDependency1940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleAbstractRuleDependency_in_entryRuleAbstractRuleDependency1976 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleAbstractRuleDependency1986 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependency_in_ruleAbstractRuleDependency2032 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependency_in_entryRuleRuleDependency2070 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDependency2080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleRuleDependency2118 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rulerequiresDependency_in_ruleRuleDependency2139 = new BitSet(new long[]{0x0000000030400002L});
    public static final BitSet FOLLOW_28_in_ruleRuleDependency2152 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_29_in_ruleRuleDependency2170 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rulerequiresDependency_in_ruleRuleDependency2193 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_32_in_ruleRuleDependency2214 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleexcludeDependency_in_ruleRuleDependency2235 = new BitSet(new long[]{0x0000000030400002L});
    public static final BitSet FOLLOW_28_in_ruleRuleDependency2248 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_29_in_ruleRuleDependency2266 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleexcludeDependency_in_ruleRuleDependency2289 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rulerequiresDependency_in_entryRulerequiresDependency2327 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerequiresDependency2337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rulerequiresDependency2374 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_rulerequiresDependency2397 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_rulerequiresDependency2409 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_rulerequiresDependency2430 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulerequiresDependency2442 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_rulerequiresDependency2463 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_rulerequiresDependency2475 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_rulerequiresDependency2496 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rulerequiresDependency2508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleexcludeDependency_in_entryRuleexcludeDependency2544 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleexcludeDependency2554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleexcludeDependency2591 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleexcludeDependency2614 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleexcludeDependency2626 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleexcludeDependency2647 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleexcludeDependency2659 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleexcludeDependency2680 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleexcludeDependency2692 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleexcludeDependency2713 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleexcludeDependency2725 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_entryRuleEString2766 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEString2777 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEString2817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEString2843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt2889 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEInt2900 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleEInt2939 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEInt2956 = new BitSet(new long[]{0x0000000000000002L});

}