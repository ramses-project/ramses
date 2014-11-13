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

@SuppressWarnings("all")
public class InternalTRCParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_UNQUOTED_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'Modules'", "'{'", "';'", "'}'", "'.'", "':'", "','", "'Transformations'", "'modules'", "'impacts'", "'('", "')'", "'Dependencies'", "'Apply'", "'['", "']'", "'and'", "'or'", "'requires'", "'excludes'", "'-'", "'true'", "'false'", "'context'", "'inv'", "'static'", "'def'", "'='", "'*'", "'+'", "'?'", "'..'", "'::'", "'Tuple'", "'Boolean'", "'Integer'", "'Real'", "'String'", "'UnlimitedNatural'", "'OclAny'", "'OclInvalid'", "'OclVoid'", "'Set'", "'Bag'", "'Sequence'", "'Collection'", "'OrderedSet'", "'/'", "'>'", "'<'", "'>='", "'<='", "'<>'", "'xor'", "'implies'", "'->'", "'self.'", "'not'", "'self'", "'let'", "'in'", "'|'", "'if'", "'then'", "'else'", "'endif'", "'invalid'", "'null'"
    };
    public static final int T__68=68;
    public static final int T__69=69;
    public static final int RULE_ID=4;
    public static final int T__66=66;
    public static final int T__67=67;
    public static final int T__64=64;
    public static final int T__29=29;
    public static final int T__65=65;
    public static final int T__28=28;
    public static final int T__62=62;
    public static final int T__27=27;
    public static final int T__63=63;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=11;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int T__61=61;
    public static final int T__60=60;
    public static final int EOF=-1;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__19=19;
    public static final int T__57=57;
    public static final int T__58=58;
    public static final int T__16=16;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__15=15;
    public static final int T__53=53;
    public static final int T__18=18;
    public static final int T__54=54;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__59=59;
    public static final int RULE_UNQUOTED_STRING=7;
    public static final int RULE_INT=6;
    public static final int T__50=50;
    public static final int T__42=42;
    public static final int T__43=43;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int RULE_SL_COMMENT=9;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int RULE_STRING=5;
    public static final int T__32=32;
    public static final int T__71=71;
    public static final int T__33=33;
    public static final int T__72=72;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__70=70;
    public static final int T__36=36;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int RULE_WS=10;
    public static final int T__76=76;
    public static final int T__75=75;
    public static final int T__74=74;
    public static final int T__73=73;
    public static final int T__79=79;
    public static final int T__78=78;
    public static final int T__77=77;

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:67:1: entryRuleTrcSpecification returns [EObject current=null] : iv_ruleTrcSpecification= ruleTrcSpecification EOF ;
    public final EObject entryRuleTrcSpecification() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTrcSpecification = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:68:2: (iv_ruleTrcSpecification= ruleTrcSpecification EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:69:2: iv_ruleTrcSpecification= ruleTrcSpecification EOF
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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:76:1: ruleTrcSpecification returns [EObject current=null] : ( ( (lv_moduleList_0_0= ruleModuleList ) ) ( (lv_transformationList_1_0= ruleTransformationList ) ) ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) ) ) ;
    public final EObject ruleTrcSpecification() throws RecognitionException {
        EObject current = null;

        EObject lv_moduleList_0_0 = null;

        EObject lv_transformationList_1_0 = null;

        EObject lv_dependencyList_2_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:79:28: ( ( ( (lv_moduleList_0_0= ruleModuleList ) ) ( (lv_transformationList_1_0= ruleTransformationList ) ) ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:80:1: ( ( (lv_moduleList_0_0= ruleModuleList ) ) ( (lv_transformationList_1_0= ruleTransformationList ) ) ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:80:1: ( ( (lv_moduleList_0_0= ruleModuleList ) ) ( (lv_transformationList_1_0= ruleTransformationList ) ) ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:80:2: ( (lv_moduleList_0_0= ruleModuleList ) ) ( (lv_transformationList_1_0= ruleTransformationList ) ) ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:80:2: ( (lv_moduleList_0_0= ruleModuleList ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:81:1: (lv_moduleList_0_0= ruleModuleList )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:81:1: (lv_moduleList_0_0= ruleModuleList )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:82:3: lv_moduleList_0_0= ruleModuleList
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

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:98:2: ( (lv_transformationList_1_0= ruleTransformationList ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:99:1: (lv_transformationList_1_0= ruleTransformationList )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:99:1: (lv_transformationList_1_0= ruleTransformationList )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:100:3: lv_transformationList_1_0= ruleTransformationList
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

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:116:2: ( (lv_dependencyList_2_0= ruleTransformationDependencyList ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:117:1: (lv_dependencyList_2_0= ruleTransformationDependencyList )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:117:1: (lv_dependencyList_2_0= ruleTransformationDependencyList )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:118:3: lv_dependencyList_2_0= ruleTransformationDependencyList
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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:142:1: entryRuletrcRule returns [EObject current=null] : iv_ruletrcRule= ruletrcRule EOF ;
    public final EObject entryRuletrcRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruletrcRule = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:143:2: (iv_ruletrcRule= ruletrcRule EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:144:2: iv_ruletrcRule= ruletrcRule EOF
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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:151:1: ruletrcRule returns [EObject current=null] : ( (lv_name_0_0= ruleEString ) ) ;
    public final EObject ruletrcRule() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:154:28: ( ( (lv_name_0_0= ruleEString ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:155:1: ( (lv_name_0_0= ruleEString ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:155:1: ( (lv_name_0_0= ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:156:1: (lv_name_0_0= ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:156:1: (lv_name_0_0= ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:157:3: lv_name_0_0= ruleEString
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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:181:1: entryRuleModuleList returns [EObject current=null] : iv_ruleModuleList= ruleModuleList EOF ;
    public final EObject entryRuleModuleList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModuleList = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:182:2: (iv_ruleModuleList= ruleModuleList EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:183:2: iv_ruleModuleList= ruleModuleList EOF
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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:190:1: ruleModuleList returns [EObject current=null] : (otherlv_0= 'Modules' otherlv_1= '{' ( (lv_modules_2_0= ruleModule ) ) (otherlv_3= ';' ( (lv_modules_4_0= ruleModule ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleModuleList() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_modules_2_0 = null;

        EObject lv_modules_4_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:193:28: ( (otherlv_0= 'Modules' otherlv_1= '{' ( (lv_modules_2_0= ruleModule ) ) (otherlv_3= ';' ( (lv_modules_4_0= ruleModule ) ) )* otherlv_5= '}' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:194:1: (otherlv_0= 'Modules' otherlv_1= '{' ( (lv_modules_2_0= ruleModule ) ) (otherlv_3= ';' ( (lv_modules_4_0= ruleModule ) ) )* otherlv_5= '}' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:194:1: (otherlv_0= 'Modules' otherlv_1= '{' ( (lv_modules_2_0= ruleModule ) ) (otherlv_3= ';' ( (lv_modules_4_0= ruleModule ) ) )* otherlv_5= '}' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:194:3: otherlv_0= 'Modules' otherlv_1= '{' ( (lv_modules_2_0= ruleModule ) ) (otherlv_3= ';' ( (lv_modules_4_0= ruleModule ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleModuleList346); 

                	newLeafNode(otherlv_0, grammarAccess.getModuleListAccess().getModulesKeyword_0());
                
            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleModuleList358); 

                	newLeafNode(otherlv_1, grammarAccess.getModuleListAccess().getLeftCurlyBracketKeyword_1());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:202:1: ( (lv_modules_2_0= ruleModule ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:203:1: (lv_modules_2_0= ruleModule )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:203:1: (lv_modules_2_0= ruleModule )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:204:3: lv_modules_2_0= ruleModule
            {
             
            	        newCompositeNode(grammarAccess.getModuleListAccess().getModulesModuleParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleModule_in_ruleModuleList379);
            lv_modules_2_0=ruleModule();

            state._fsp--;


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

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:220:2: (otherlv_3= ';' ( (lv_modules_4_0= ruleModule ) ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==14) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:220:4: otherlv_3= ';' ( (lv_modules_4_0= ruleModule ) )
            	    {
            	    otherlv_3=(Token)match(input,14,FOLLOW_14_in_ruleModuleList392); 

            	        	newLeafNode(otherlv_3, grammarAccess.getModuleListAccess().getSemicolonKeyword_3_0());
            	        
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:224:1: ( (lv_modules_4_0= ruleModule ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:225:1: (lv_modules_4_0= ruleModule )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:225:1: (lv_modules_4_0= ruleModule )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:226:3: lv_modules_4_0= ruleModule
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getModuleListAccess().getModulesModuleParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleModule_in_ruleModuleList413);
            	    lv_modules_4_0=ruleModule();

            	    state._fsp--;


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
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleModuleList427); 

                	newLeafNode(otherlv_5, grammarAccess.getModuleListAccess().getRightCurlyBracketKeyword_4());
                

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:254:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:255:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:256:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
             newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName464);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;

             current =iv_ruleQualifiedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName475); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:263:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:266:28: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:267:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:267:1: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:267:6: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName515); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0()); 
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:274:1: (kw= '.' this_ID_2= RULE_ID )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:275:2: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,16,FOLLOW_16_in_ruleQualifiedName534); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	        
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleQualifiedName549); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop2;
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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:295:1: entryRuleModule returns [EObject current=null] : iv_ruleModule= ruleModule EOF ;
    public final EObject entryRuleModule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModule = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:296:2: (iv_ruleModule= ruleModule EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:297:2: iv_ruleModule= ruleModule EOF
            {
             newCompositeNode(grammarAccess.getModuleRule()); 
            pushFollow(FOLLOW_ruleModule_in_entryRuleModule596);
            iv_ruleModule=ruleModule();

            state._fsp--;

             current =iv_ruleModule; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleModule606); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:304:1: ruleModule returns [EObject current=null] : ( () ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_rules_3_0= ruletrcRule ) ) (otherlv_4= ',' ( (lv_rules_5_0= ruletrcRule ) ) )* )? ) ;
    public final EObject ruleModule() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_1_0 = null;

        EObject lv_rules_3_0 = null;

        EObject lv_rules_5_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:307:28: ( ( () ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_rules_3_0= ruletrcRule ) ) (otherlv_4= ',' ( (lv_rules_5_0= ruletrcRule ) ) )* )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:308:1: ( () ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_rules_3_0= ruletrcRule ) ) (otherlv_4= ',' ( (lv_rules_5_0= ruletrcRule ) ) )* )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:308:1: ( () ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_rules_3_0= ruletrcRule ) ) (otherlv_4= ',' ( (lv_rules_5_0= ruletrcRule ) ) )* )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:308:2: () ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_rules_3_0= ruletrcRule ) ) (otherlv_4= ',' ( (lv_rules_5_0= ruletrcRule ) ) )* )?
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:308:2: ()
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:309:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getModuleAccess().getModuleAction_0(),
                        current);
                

            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:314:2: ( ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_rules_3_0= ruletrcRule ) ) (otherlv_4= ',' ( (lv_rules_5_0= ruletrcRule ) ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( ((LA4_0>=RULE_ID && LA4_0<=RULE_STRING)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:314:3: ( (lv_name_1_0= ruleEString ) ) otherlv_2= ':' ( (lv_rules_3_0= ruletrcRule ) ) (otherlv_4= ',' ( (lv_rules_5_0= ruletrcRule ) ) )*
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:314:3: ( (lv_name_1_0= ruleEString ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:315:1: (lv_name_1_0= ruleEString )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:315:1: (lv_name_1_0= ruleEString )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:316:3: lv_name_1_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getModuleAccess().getNameEStringParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEString_in_ruleModule662);
                    lv_name_1_0=ruleEString();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModuleRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_1_0, 
                            		"EString");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleModule674); 

                        	newLeafNode(otherlv_2, grammarAccess.getModuleAccess().getColonKeyword_1_1());
                        
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:336:1: ( (lv_rules_3_0= ruletrcRule ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:337:1: (lv_rules_3_0= ruletrcRule )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:337:1: (lv_rules_3_0= ruletrcRule )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:338:3: lv_rules_3_0= ruletrcRule
                    {
                     
                    	        newCompositeNode(grammarAccess.getModuleAccess().getRulesTrcRuleParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruletrcRule_in_ruleModule695);
                    lv_rules_3_0=ruletrcRule();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getModuleRule());
                    	        }
                           		add(
                           			current, 
                           			"rules",
                            		lv_rules_3_0, 
                            		"trcRule");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:354:2: (otherlv_4= ',' ( (lv_rules_5_0= ruletrcRule ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==18) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:354:4: otherlv_4= ',' ( (lv_rules_5_0= ruletrcRule ) )
                    	    {
                    	    otherlv_4=(Token)match(input,18,FOLLOW_18_in_ruleModule708); 

                    	        	newLeafNode(otherlv_4, grammarAccess.getModuleAccess().getCommaKeyword_1_3_0());
                    	        
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:358:1: ( (lv_rules_5_0= ruletrcRule ) )
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:359:1: (lv_rules_5_0= ruletrcRule )
                    	    {
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:359:1: (lv_rules_5_0= ruletrcRule )
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:360:3: lv_rules_5_0= ruletrcRule
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getModuleAccess().getRulesTrcRuleParserRuleCall_1_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruletrcRule_in_ruleModule729);
                    	    lv_rules_5_0=ruletrcRule();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getModuleRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"rules",
                    	            		lv_rules_5_0, 
                    	            		"trcRule");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:384:1: entryRuleTransformationList returns [EObject current=null] : iv_ruleTransformationList= ruleTransformationList EOF ;
    public final EObject entryRuleTransformationList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationList = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:385:2: (iv_ruleTransformationList= ruleTransformationList EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:386:2: iv_ruleTransformationList= ruleTransformationList EOF
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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:393:1: ruleTransformationList returns [EObject current=null] : (otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}' ) ;
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
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:396:28: ( (otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:397:1: (otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:397:1: (otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:397:3: otherlv_0= 'Transformations' otherlv_1= '{' ( (lv_transformations_2_0= ruleTransformation ) ) (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleTransformationList816); 

                	newLeafNode(otherlv_0, grammarAccess.getTransformationListAccess().getTransformationsKeyword_0());
                
            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleTransformationList828); 

                	newLeafNode(otherlv_1, grammarAccess.getTransformationListAccess().getLeftCurlyBracketKeyword_1());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:405:1: ( (lv_transformations_2_0= ruleTransformation ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:406:1: (lv_transformations_2_0= ruleTransformation )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:406:1: (lv_transformations_2_0= ruleTransformation )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:407:3: lv_transformations_2_0= ruleTransformation
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

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:423:2: (otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) ) )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==18) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:423:4: otherlv_3= ',' ( (lv_transformations_4_0= ruleTransformation ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleTransformationList862); 

            	        	newLeafNode(otherlv_3, grammarAccess.getTransformationListAccess().getCommaKeyword_3_0());
            	        
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:427:1: ( (lv_transformations_4_0= ruleTransformation ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:428:1: (lv_transformations_4_0= ruleTransformation )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:428:1: (lv_transformations_4_0= ruleTransformation )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:429:3: lv_transformations_4_0= ruleTransformation
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

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleTransformationList897); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:457:1: entryRuleTransformation returns [EObject current=null] : iv_ruleTransformation= ruleTransformation EOF ;
    public final EObject entryRuleTransformation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformation = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:458:2: (iv_ruleTransformation= ruleTransformation EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:459:2: iv_ruleTransformation= ruleTransformation EOF
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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:466:1: ruleTransformation returns [EObject current=null] : ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}' ) ;
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
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:469:28: ( ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:470:1: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:470:1: ( ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:470:2: ( (lv_name_0_0= ruleEString ) ) otherlv_1= '{' otherlv_2= 'modules' otherlv_3= ':' ( (otherlv_4= RULE_ID ) ) (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )* (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )? otherlv_12= '}'
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:470:2: ( (lv_name_0_0= ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:471:1: (lv_name_0_0= ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:471:1: (lv_name_0_0= ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:472:3: lv_name_0_0= ruleEString
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

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleTransformation1001); 

                	newLeafNode(otherlv_1, grammarAccess.getTransformationAccess().getLeftCurlyBracketKeyword_1());
                
            otherlv_2=(Token)match(input,20,FOLLOW_20_in_ruleTransformation1013); 

                	newLeafNode(otherlv_2, grammarAccess.getTransformationAccess().getModulesKeyword_2());
                
            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleTransformation1025); 

                	newLeafNode(otherlv_3, grammarAccess.getTransformationAccess().getColonKeyword_3());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:500:1: ( (otherlv_4= RULE_ID ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:501:1: (otherlv_4= RULE_ID )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:501:1: (otherlv_4= RULE_ID )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:502:3: otherlv_4= RULE_ID
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransformationRule());
            	        }
                    
            otherlv_4=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransformation1045); 

            		newLeafNode(otherlv_4, grammarAccess.getTransformationAccess().getModulesModuleCrossReference_4_0()); 
            	

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:513:2: (otherlv_5= ',' ( (otherlv_6= RULE_ID ) ) )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==18) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:513:4: otherlv_5= ',' ( (otherlv_6= RULE_ID ) )
            	    {
            	    otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleTransformation1058); 

            	        	newLeafNode(otherlv_5, grammarAccess.getTransformationAccess().getCommaKeyword_5_0());
            	        
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:517:1: ( (otherlv_6= RULE_ID ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:518:1: (otherlv_6= RULE_ID )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:518:1: (otherlv_6= RULE_ID )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:519:3: otherlv_6= RULE_ID
            	    {

            	    			if (current==null) {
            	    	            current = createModelElement(grammarAccess.getTransformationRule());
            	    	        }
            	            
            	    otherlv_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleTransformation1078); 

            	    		newLeafNode(otherlv_6, grammarAccess.getTransformationAccess().getModulesModuleCrossReference_5_1_0()); 
            	    	

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:530:4: (otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )* )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==21) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:530:6: otherlv_7= 'impacts' otherlv_8= ':' ( (lv_impacts_9_0= ruleTransformationImpact ) ) (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )*
                    {
                    otherlv_7=(Token)match(input,21,FOLLOW_21_in_ruleTransformation1093); 

                        	newLeafNode(otherlv_7, grammarAccess.getTransformationAccess().getImpactsKeyword_6_0());
                        
                    otherlv_8=(Token)match(input,17,FOLLOW_17_in_ruleTransformation1105); 

                        	newLeafNode(otherlv_8, grammarAccess.getTransformationAccess().getColonKeyword_6_1());
                        
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:538:1: ( (lv_impacts_9_0= ruleTransformationImpact ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:539:1: (lv_impacts_9_0= ruleTransformationImpact )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:539:1: (lv_impacts_9_0= ruleTransformationImpact )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:540:3: lv_impacts_9_0= ruleTransformationImpact
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransformationAccess().getImpactsTransformationImpactParserRuleCall_6_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTransformationImpact_in_ruleTransformation1126);
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

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:556:2: (otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==18) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:556:4: otherlv_10= ',' ( (lv_impacts_11_0= ruleTransformationImpact ) )
                    	    {
                    	    otherlv_10=(Token)match(input,18,FOLLOW_18_in_ruleTransformation1139); 

                    	        	newLeafNode(otherlv_10, grammarAccess.getTransformationAccess().getCommaKeyword_6_3_0());
                    	        
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:560:1: ( (lv_impacts_11_0= ruleTransformationImpact ) )
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:561:1: (lv_impacts_11_0= ruleTransformationImpact )
                    	    {
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:561:1: (lv_impacts_11_0= ruleTransformationImpact )
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:562:3: lv_impacts_11_0= ruleTransformationImpact
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getTransformationAccess().getImpactsTransformationImpactParserRuleCall_6_3_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleTransformationImpact_in_ruleTransformation1160);
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

            otherlv_12=(Token)match(input,15,FOLLOW_15_in_ruleTransformation1176); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:590:1: entryRuleTransformationImpact returns [EObject current=null] : iv_ruleTransformationImpact= ruleTransformationImpact EOF ;
    public final EObject entryRuleTransformationImpact() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationImpact = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:591:2: (iv_ruleTransformationImpact= ruleTransformationImpact EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:592:2: iv_ruleTransformationImpact= ruleTransformationImpact EOF
            {
             newCompositeNode(grammarAccess.getTransformationImpactRule()); 
            pushFollow(FOLLOW_ruleTransformationImpact_in_entryRuleTransformationImpact1212);
            iv_ruleTransformationImpact=ruleTransformationImpact();

            state._fsp--;

             current =iv_ruleTransformationImpact; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationImpact1222); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:599:1: ruleTransformationImpact returns [EObject current=null] : (otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')' ) ;
    public final EObject ruleTransformationImpact() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_qualityAttributeName_1_0 = null;

        AntlrDatatypeRuleToken lv_impactValue_3_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:602:28: ( (otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:603:1: (otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:603:1: (otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:603:3: otherlv_0= '(' ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )? ( (lv_impactValue_3_0= ruleEInt ) ) otherlv_4= ')'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleTransformationImpact1259); 

                	newLeafNode(otherlv_0, grammarAccess.getTransformationImpactAccess().getLeftParenthesisKeyword_0());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:607:1: ( ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ',' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( ((LA9_0>=RULE_ID && LA9_0<=RULE_STRING)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:607:2: ( (lv_qualityAttributeName_1_0= ruleEString ) ) otherlv_2= ','
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:607:2: ( (lv_qualityAttributeName_1_0= ruleEString ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:608:1: (lv_qualityAttributeName_1_0= ruleEString )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:608:1: (lv_qualityAttributeName_1_0= ruleEString )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:609:3: lv_qualityAttributeName_1_0= ruleEString
                    {
                     
                    	        newCompositeNode(grammarAccess.getTransformationImpactAccess().getQualityAttributeNameEStringParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEString_in_ruleTransformationImpact1281);
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

                    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleTransformationImpact1293); 

                        	newLeafNode(otherlv_2, grammarAccess.getTransformationImpactAccess().getCommaKeyword_1_1());
                        

                    }
                    break;

            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:629:3: ( (lv_impactValue_3_0= ruleEInt ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:630:1: (lv_impactValue_3_0= ruleEInt )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:630:1: (lv_impactValue_3_0= ruleEInt )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:631:3: lv_impactValue_3_0= ruleEInt
            {
             
            	        newCompositeNode(grammarAccess.getTransformationImpactAccess().getImpactValueEIntParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleEInt_in_ruleTransformationImpact1316);
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

            otherlv_4=(Token)match(input,23,FOLLOW_23_in_ruleTransformationImpact1328); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:659:1: entryRuleTransformationDependencyList returns [EObject current=null] : iv_ruleTransformationDependencyList= ruleTransformationDependencyList EOF ;
    public final EObject entryRuleTransformationDependencyList() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationDependencyList = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:660:2: (iv_ruleTransformationDependencyList= ruleTransformationDependencyList EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:661:2: iv_ruleTransformationDependencyList= ruleTransformationDependencyList EOF
            {
             newCompositeNode(grammarAccess.getTransformationDependencyListRule()); 
            pushFollow(FOLLOW_ruleTransformationDependencyList_in_entryRuleTransformationDependencyList1364);
            iv_ruleTransformationDependencyList=ruleTransformationDependencyList();

            state._fsp--;

             current =iv_ruleTransformationDependencyList; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationDependencyList1374); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:668:1: ruleTransformationDependencyList returns [EObject current=null] : (otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )* otherlv_7= '}' otherlv_8= '}' ) ;
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
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:671:28: ( (otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )* otherlv_7= '}' otherlv_8= '}' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:672:1: (otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )* otherlv_7= '}' otherlv_8= '}' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:672:1: (otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )* otherlv_7= '}' otherlv_8= '}' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:672:3: otherlv_0= 'Dependencies' otherlv_1= '{' ( (lv_name_2_0= ruleEString ) ) otherlv_3= '{' ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) ) (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )* otherlv_7= '}' otherlv_8= '}'
            {
            otherlv_0=(Token)match(input,24,FOLLOW_24_in_ruleTransformationDependencyList1411); 

                	newLeafNode(otherlv_0, grammarAccess.getTransformationDependencyListAccess().getDependenciesKeyword_0());
                
            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleTransformationDependencyList1423); 

                	newLeafNode(otherlv_1, grammarAccess.getTransformationDependencyListAccess().getLeftCurlyBracketKeyword_1());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:680:1: ( (lv_name_2_0= ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:681:1: (lv_name_2_0= ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:681:1: (lv_name_2_0= ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:682:3: lv_name_2_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyListAccess().getNameEStringParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleTransformationDependencyList1444);
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

            otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleTransformationDependencyList1456); 

                	newLeafNode(otherlv_3, grammarAccess.getTransformationDependencyListAccess().getLeftCurlyBracketKeyword_3());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:702:1: ( (lv_transformationDependencies_4_0= ruleTransformationDependency ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:703:1: (lv_transformationDependencies_4_0= ruleTransformationDependency )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:703:1: (lv_transformationDependencies_4_0= ruleTransformationDependency )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:704:3: lv_transformationDependencies_4_0= ruleTransformationDependency
            {
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesTransformationDependencyParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleTransformationDependency_in_ruleTransformationDependencyList1477);
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

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:720:2: (otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) ) )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==14) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:720:4: otherlv_5= ';' ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) )
            	    {
            	    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleTransformationDependencyList1490); 

            	        	newLeafNode(otherlv_5, grammarAccess.getTransformationDependencyListAccess().getSemicolonKeyword_5_0());
            	        
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:724:1: ( (lv_transformationDependencies_6_0= ruleTransformationDependency ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:725:1: (lv_transformationDependencies_6_0= ruleTransformationDependency )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:725:1: (lv_transformationDependencies_6_0= ruleTransformationDependency )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:726:3: lv_transformationDependencies_6_0= ruleTransformationDependency
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTransformationDependencyListAccess().getTransformationDependenciesTransformationDependencyParserRuleCall_5_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTransformationDependency_in_ruleTransformationDependencyList1511);
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

            otherlv_7=(Token)match(input,15,FOLLOW_15_in_ruleTransformationDependencyList1525); 

                	newLeafNode(otherlv_7, grammarAccess.getTransformationDependencyListAccess().getRightCurlyBracketKeyword_6());
                
            otherlv_8=(Token)match(input,15,FOLLOW_15_in_ruleTransformationDependencyList1537); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:758:1: entryRuleTransformationDependency returns [EObject current=null] : iv_ruleTransformationDependency= ruleTransformationDependency EOF ;
    public final EObject entryRuleTransformationDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTransformationDependency = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:759:2: (iv_ruleTransformationDependency= ruleTransformationDependency EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:760:2: iv_ruleTransformationDependency= ruleTransformationDependency EOF
            {
             newCompositeNode(grammarAccess.getTransformationDependencyRule()); 
            pushFollow(FOLLOW_ruleTransformationDependency_in_entryRuleTransformationDependency1573);
            iv_ruleTransformationDependency=ruleTransformationDependency();

            state._fsp--;

             current =iv_ruleTransformationDependency; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTransformationDependency1583); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:767:1: ruleTransformationDependency returns [EObject current=null] : (otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fields_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( (lv_requiredTransformations_13_0= ruleRuleDependency ) ) ( (lv_boolOP_14_0= ruleBooleanOperations ) ) ( (lv_requiredTransformations_15_0= ruleRuleDependency ) )* otherlv_16= ']' ) ;
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
        Token otherlv_16=null;
        AntlrDatatypeRuleToken lv_fields_7_0 = null;

        AntlrDatatypeRuleToken lv_fields_9_0 = null;

        EObject lv_requiredTransformations_13_0 = null;

        EObject lv_boolOP_14_0 = null;

        EObject lv_requiredTransformations_15_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:770:28: ( (otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fields_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( (lv_requiredTransformations_13_0= ruleRuleDependency ) ) ( (lv_boolOP_14_0= ruleBooleanOperations ) ) ( (lv_requiredTransformations_15_0= ruleRuleDependency ) )* otherlv_16= ']' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:771:1: (otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fields_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( (lv_requiredTransformations_13_0= ruleRuleDependency ) ) ( (lv_boolOP_14_0= ruleBooleanOperations ) ) ( (lv_requiredTransformations_15_0= ruleRuleDependency ) )* otherlv_16= ']' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:771:1: (otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fields_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( (lv_requiredTransformations_13_0= ruleRuleDependency ) ) ( (lv_boolOP_14_0= ruleBooleanOperations ) ) ( (lv_requiredTransformations_15_0= ruleRuleDependency ) )* otherlv_16= ']' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:771:3: otherlv_0= 'Apply' otherlv_1= '(' ( ( ruleEString ) ) otherlv_3= '.' ( ( ruleQualifiedName ) ) otherlv_5= ',' otherlv_6= '{' ( (lv_fields_7_0= ruleEString ) ) (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )* otherlv_10= '}' otherlv_11= ')' otherlv_12= '[' ( (lv_requiredTransformations_13_0= ruleRuleDependency ) ) ( (lv_boolOP_14_0= ruleBooleanOperations ) ) ( (lv_requiredTransformations_15_0= ruleRuleDependency ) )* otherlv_16= ']'
            {
            otherlv_0=(Token)match(input,25,FOLLOW_25_in_ruleTransformationDependency1620); 

                	newLeafNode(otherlv_0, grammarAccess.getTransformationDependencyAccess().getApplyKeyword_0());
                
            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleTransformationDependency1632); 

                	newLeafNode(otherlv_1, grammarAccess.getTransformationDependencyAccess().getLeftParenthesisKeyword_1());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:779:1: ( ( ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:780:1: ( ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:780:1: ( ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:781:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransformationDependencyRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getAppliedTransformationTransformationCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleTransformationDependency1655);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,16,FOLLOW_16_in_ruleTransformationDependency1667); 

                	newLeafNode(otherlv_3, grammarAccess.getTransformationDependencyAccess().getFullStopKeyword_3());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:798:1: ( ( ruleQualifiedName ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:799:1: ( ruleQualifiedName )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:799:1: ( ruleQualifiedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:800:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getTransformationDependencyRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getAppliedRuleTrcRuleCrossReference_4_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleTransformationDependency1690);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,18,FOLLOW_18_in_ruleTransformationDependency1702); 

                	newLeafNode(otherlv_5, grammarAccess.getTransformationDependencyAccess().getCommaKeyword_5());
                
            otherlv_6=(Token)match(input,13,FOLLOW_13_in_ruleTransformationDependency1714); 

                	newLeafNode(otherlv_6, grammarAccess.getTransformationDependencyAccess().getLeftCurlyBracketKeyword_6());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:821:1: ( (lv_fields_7_0= ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:822:1: (lv_fields_7_0= ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:822:1: (lv_fields_7_0= ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:823:3: lv_fields_7_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getFieldsEStringParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleTransformationDependency1735);
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

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:839:2: (otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) ) )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==18) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:839:4: otherlv_8= ',' ( (lv_fields_9_0= ruleEString ) )
            	    {
            	    otherlv_8=(Token)match(input,18,FOLLOW_18_in_ruleTransformationDependency1748); 

            	        	newLeafNode(otherlv_8, grammarAccess.getTransformationDependencyAccess().getCommaKeyword_8_0());
            	        
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:843:1: ( (lv_fields_9_0= ruleEString ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:844:1: (lv_fields_9_0= ruleEString )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:844:1: (lv_fields_9_0= ruleEString )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:845:3: lv_fields_9_0= ruleEString
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getFieldsEStringParserRuleCall_8_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleEString_in_ruleTransformationDependency1769);
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

            otherlv_10=(Token)match(input,15,FOLLOW_15_in_ruleTransformationDependency1783); 

                	newLeafNode(otherlv_10, grammarAccess.getTransformationDependencyAccess().getRightCurlyBracketKeyword_9());
                
            otherlv_11=(Token)match(input,23,FOLLOW_23_in_ruleTransformationDependency1795); 

                	newLeafNode(otherlv_11, grammarAccess.getTransformationDependencyAccess().getRightParenthesisKeyword_10());
                
            otherlv_12=(Token)match(input,26,FOLLOW_26_in_ruleTransformationDependency1807); 

                	newLeafNode(otherlv_12, grammarAccess.getTransformationDependencyAccess().getLeftSquareBracketKeyword_11());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:873:1: ( (lv_requiredTransformations_13_0= ruleRuleDependency ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:874:1: (lv_requiredTransformations_13_0= ruleRuleDependency )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:874:1: (lv_requiredTransformations_13_0= ruleRuleDependency )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:875:3: lv_requiredTransformations_13_0= ruleRuleDependency
            {
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsRuleDependencyParserRuleCall_12_0()); 
            	    
            pushFollow(FOLLOW_ruleRuleDependency_in_ruleTransformationDependency1828);
            lv_requiredTransformations_13_0=ruleRuleDependency();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTransformationDependencyRule());
            	        }
                   		add(
                   			current, 
                   			"requiredTransformations",
                    		lv_requiredTransformations_13_0, 
                    		"RuleDependency");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:891:2: ( (lv_boolOP_14_0= ruleBooleanOperations ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:892:1: (lv_boolOP_14_0= ruleBooleanOperations )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:892:1: (lv_boolOP_14_0= ruleBooleanOperations )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:893:3: lv_boolOP_14_0= ruleBooleanOperations
            {
             
            	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getBoolOPBooleanOperationsParserRuleCall_13_0()); 
            	    
            pushFollow(FOLLOW_ruleBooleanOperations_in_ruleTransformationDependency1849);
            lv_boolOP_14_0=ruleBooleanOperations();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTransformationDependencyRule());
            	        }
                   		set(
                   			current, 
                   			"boolOP",
                    		lv_boolOP_14_0, 
                    		"BooleanOperations");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:909:2: ( (lv_requiredTransformations_15_0= ruleRuleDependency ) )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( ((LA12_0>=30 && LA12_0<=31)) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:910:1: (lv_requiredTransformations_15_0= ruleRuleDependency )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:910:1: (lv_requiredTransformations_15_0= ruleRuleDependency )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:911:3: lv_requiredTransformations_15_0= ruleRuleDependency
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTransformationDependencyAccess().getRequiredTransformationsRuleDependencyParserRuleCall_14_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleRuleDependency_in_ruleTransformationDependency1870);
            	    lv_requiredTransformations_15_0=ruleRuleDependency();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTransformationDependencyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"requiredTransformations",
            	            		lv_requiredTransformations_15_0, 
            	            		"RuleDependency");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            otherlv_16=(Token)match(input,27,FOLLOW_27_in_ruleTransformationDependency1883); 

                	newLeafNode(otherlv_16, grammarAccess.getTransformationDependencyAccess().getRightSquareBracketKeyword_15());
                

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


    // $ANTLR start "entryRuleBooleanOperations"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:939:1: entryRuleBooleanOperations returns [EObject current=null] : iv_ruleBooleanOperations= ruleBooleanOperations EOF ;
    public final EObject entryRuleBooleanOperations() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanOperations = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:940:2: (iv_ruleBooleanOperations= ruleBooleanOperations EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:941:2: iv_ruleBooleanOperations= ruleBooleanOperations EOF
            {
             newCompositeNode(grammarAccess.getBooleanOperationsRule()); 
            pushFollow(FOLLOW_ruleBooleanOperations_in_entryRuleBooleanOperations1919);
            iv_ruleBooleanOperations=ruleBooleanOperations();

            state._fsp--;

             current =iv_ruleBooleanOperations; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanOperations1929); 

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
    // $ANTLR end "entryRuleBooleanOperations"


    // $ANTLR start "ruleBooleanOperations"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:948:1: ruleBooleanOperations returns [EObject current=null] : ( ( (lv_name_0_1= 'and' | lv_name_0_2= 'or' ) ) ) ;
    public final EObject ruleBooleanOperations() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:951:28: ( ( ( (lv_name_0_1= 'and' | lv_name_0_2= 'or' ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:952:1: ( ( (lv_name_0_1= 'and' | lv_name_0_2= 'or' ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:952:1: ( ( (lv_name_0_1= 'and' | lv_name_0_2= 'or' ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:953:1: ( (lv_name_0_1= 'and' | lv_name_0_2= 'or' ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:953:1: ( (lv_name_0_1= 'and' | lv_name_0_2= 'or' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:954:1: (lv_name_0_1= 'and' | lv_name_0_2= 'or' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:954:1: (lv_name_0_1= 'and' | lv_name_0_2= 'or' )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==28) ) {
                alt13=1;
            }
            else if ( (LA13_0==29) ) {
                alt13=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:955:3: lv_name_0_1= 'and'
                    {
                    lv_name_0_1=(Token)match(input,28,FOLLOW_28_in_ruleBooleanOperations1973); 

                            newLeafNode(lv_name_0_1, grammarAccess.getBooleanOperationsAccess().getNameAndKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBooleanOperationsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:967:8: lv_name_0_2= 'or'
                    {
                    lv_name_0_2=(Token)match(input,29,FOLLOW_29_in_ruleBooleanOperations2002); 

                            newLeafNode(lv_name_0_2, grammarAccess.getBooleanOperationsAccess().getNameOrKeyword_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBooleanOperationsRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_2, null);
                    	    

                    }
                    break;

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
    // $ANTLR end "ruleBooleanOperations"


    // $ANTLR start "entryRuleRuleDependency"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:990:1: entryRuleRuleDependency returns [EObject current=null] : iv_ruleRuleDependency= ruleRuleDependency EOF ;
    public final EObject entryRuleRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRuleDependency = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:991:2: (iv_ruleRuleDependency= ruleRuleDependency EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:992:2: iv_ruleRuleDependency= ruleRuleDependency EOF
            {
             newCompositeNode(grammarAccess.getRuleDependencyRule()); 
            pushFollow(FOLLOW_ruleRuleDependency_in_entryRuleRuleDependency2053);
            iv_ruleRuleDependency=ruleRuleDependency();

            state._fsp--;

             current =iv_ruleRuleDependency; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleRuleDependency2063); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:999:1: ruleRuleDependency returns [EObject current=null] : ( ( (lv_kw_0_0= ruleKeyWord ) ) ( (lv_red_1_0= rulerequiresOrExcludeDependency ) ) ( ( (lv_boolOP_2_0= ruleBooleanOperations ) ) ( (lv_red_3_0= rulerequiresOrExcludeDependency ) ) )? ) ;
    public final EObject ruleRuleDependency() throws RecognitionException {
        EObject current = null;

        EObject lv_kw_0_0 = null;

        EObject lv_red_1_0 = null;

        EObject lv_boolOP_2_0 = null;

        EObject lv_red_3_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1002:28: ( ( ( (lv_kw_0_0= ruleKeyWord ) ) ( (lv_red_1_0= rulerequiresOrExcludeDependency ) ) ( ( (lv_boolOP_2_0= ruleBooleanOperations ) ) ( (lv_red_3_0= rulerequiresOrExcludeDependency ) ) )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1003:1: ( ( (lv_kw_0_0= ruleKeyWord ) ) ( (lv_red_1_0= rulerequiresOrExcludeDependency ) ) ( ( (lv_boolOP_2_0= ruleBooleanOperations ) ) ( (lv_red_3_0= rulerequiresOrExcludeDependency ) ) )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1003:1: ( ( (lv_kw_0_0= ruleKeyWord ) ) ( (lv_red_1_0= rulerequiresOrExcludeDependency ) ) ( ( (lv_boolOP_2_0= ruleBooleanOperations ) ) ( (lv_red_3_0= rulerequiresOrExcludeDependency ) ) )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1003:2: ( (lv_kw_0_0= ruleKeyWord ) ) ( (lv_red_1_0= rulerequiresOrExcludeDependency ) ) ( ( (lv_boolOP_2_0= ruleBooleanOperations ) ) ( (lv_red_3_0= rulerequiresOrExcludeDependency ) ) )?
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1003:2: ( (lv_kw_0_0= ruleKeyWord ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1004:1: (lv_kw_0_0= ruleKeyWord )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1004:1: (lv_kw_0_0= ruleKeyWord )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1005:3: lv_kw_0_0= ruleKeyWord
            {
             
            	        newCompositeNode(grammarAccess.getRuleDependencyAccess().getKwKeyWordParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleKeyWord_in_ruleRuleDependency2109);
            lv_kw_0_0=ruleKeyWord();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRuleDependencyRule());
            	        }
                   		set(
                   			current, 
                   			"kw",
                    		lv_kw_0_0, 
                    		"KeyWord");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1021:2: ( (lv_red_1_0= rulerequiresOrExcludeDependency ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1022:1: (lv_red_1_0= rulerequiresOrExcludeDependency )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1022:1: (lv_red_1_0= rulerequiresOrExcludeDependency )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1023:3: lv_red_1_0= rulerequiresOrExcludeDependency
            {
             
            	        newCompositeNode(grammarAccess.getRuleDependencyAccess().getRedRequiresOrExcludeDependencyParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_rulerequiresOrExcludeDependency_in_ruleRuleDependency2130);
            lv_red_1_0=rulerequiresOrExcludeDependency();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRuleDependencyRule());
            	        }
                   		add(
                   			current, 
                   			"red",
                    		lv_red_1_0, 
                    		"requiresOrExcludeDependency");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1039:2: ( ( (lv_boolOP_2_0= ruleBooleanOperations ) ) ( (lv_red_3_0= rulerequiresOrExcludeDependency ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==28) ) {
                int LA14_1 = input.LA(2);

                if ( (LA14_1==22) ) {
                    alt14=1;
                }
            }
            else if ( (LA14_0==29) ) {
                int LA14_2 = input.LA(2);

                if ( (LA14_2==22) ) {
                    alt14=1;
                }
            }
            switch (alt14) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1039:3: ( (lv_boolOP_2_0= ruleBooleanOperations ) ) ( (lv_red_3_0= rulerequiresOrExcludeDependency ) )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1039:3: ( (lv_boolOP_2_0= ruleBooleanOperations ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1040:1: (lv_boolOP_2_0= ruleBooleanOperations )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1040:1: (lv_boolOP_2_0= ruleBooleanOperations )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1041:3: lv_boolOP_2_0= ruleBooleanOperations
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleDependencyAccess().getBoolOPBooleanOperationsParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleBooleanOperations_in_ruleRuleDependency2152);
                    lv_boolOP_2_0=ruleBooleanOperations();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleDependencyRule());
                    	        }
                           		set(
                           			current, 
                           			"boolOP",
                            		lv_boolOP_2_0, 
                            		"BooleanOperations");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1057:2: ( (lv_red_3_0= rulerequiresOrExcludeDependency ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1058:1: (lv_red_3_0= rulerequiresOrExcludeDependency )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1058:1: (lv_red_3_0= rulerequiresOrExcludeDependency )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1059:3: lv_red_3_0= rulerequiresOrExcludeDependency
                    {
                     
                    	        newCompositeNode(grammarAccess.getRuleDependencyAccess().getRedRequiresOrExcludeDependencyParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulerequiresOrExcludeDependency_in_ruleRuleDependency2173);
                    lv_red_3_0=rulerequiresOrExcludeDependency();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getRuleDependencyRule());
                    	        }
                           		add(
                           			current, 
                           			"red",
                            		lv_red_3_0, 
                            		"requiresOrExcludeDependency");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleRuleDependency"


    // $ANTLR start "entryRuleKeyWord"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1083:1: entryRuleKeyWord returns [EObject current=null] : iv_ruleKeyWord= ruleKeyWord EOF ;
    public final EObject entryRuleKeyWord() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleKeyWord = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1084:2: (iv_ruleKeyWord= ruleKeyWord EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1085:2: iv_ruleKeyWord= ruleKeyWord EOF
            {
             newCompositeNode(grammarAccess.getKeyWordRule()); 
            pushFollow(FOLLOW_ruleKeyWord_in_entryRuleKeyWord2211);
            iv_ruleKeyWord=ruleKeyWord();

            state._fsp--;

             current =iv_ruleKeyWord; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleKeyWord2221); 

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
    // $ANTLR end "entryRuleKeyWord"


    // $ANTLR start "ruleKeyWord"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1092:1: ruleKeyWord returns [EObject current=null] : ( ( (lv_name_0_1= 'requires' | lv_name_0_2= 'excludes' ) ) ) ;
    public final EObject ruleKeyWord() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1095:28: ( ( ( (lv_name_0_1= 'requires' | lv_name_0_2= 'excludes' ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1096:1: ( ( (lv_name_0_1= 'requires' | lv_name_0_2= 'excludes' ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1096:1: ( ( (lv_name_0_1= 'requires' | lv_name_0_2= 'excludes' ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1097:1: ( (lv_name_0_1= 'requires' | lv_name_0_2= 'excludes' ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1097:1: ( (lv_name_0_1= 'requires' | lv_name_0_2= 'excludes' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1098:1: (lv_name_0_1= 'requires' | lv_name_0_2= 'excludes' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1098:1: (lv_name_0_1= 'requires' | lv_name_0_2= 'excludes' )
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==30) ) {
                alt15=1;
            }
            else if ( (LA15_0==31) ) {
                alt15=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }
            switch (alt15) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1099:3: lv_name_0_1= 'requires'
                    {
                    lv_name_0_1=(Token)match(input,30,FOLLOW_30_in_ruleKeyWord2265); 

                            newLeafNode(lv_name_0_1, grammarAccess.getKeyWordAccess().getNameRequiresKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeyWordRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1111:8: lv_name_0_2= 'excludes'
                    {
                    lv_name_0_2=(Token)match(input,31,FOLLOW_31_in_ruleKeyWord2294); 

                            newLeafNode(lv_name_0_2, grammarAccess.getKeyWordAccess().getNameExcludesKeyword_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getKeyWordRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_2, null);
                    	    

                    }
                    break;

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
    // $ANTLR end "ruleKeyWord"


    // $ANTLR start "entryRulerequiresOrExcludeDependency"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1134:1: entryRulerequiresOrExcludeDependency returns [EObject current=null] : iv_rulerequiresOrExcludeDependency= rulerequiresOrExcludeDependency EOF ;
    public final EObject entryRulerequiresOrExcludeDependency() throws RecognitionException {
        EObject current = null;

        EObject iv_rulerequiresOrExcludeDependency = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1135:2: (iv_rulerequiresOrExcludeDependency= rulerequiresOrExcludeDependency EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1136:2: iv_rulerequiresOrExcludeDependency= rulerequiresOrExcludeDependency EOF
            {
             newCompositeNode(grammarAccess.getRequiresOrExcludeDependencyRule()); 
            pushFollow(FOLLOW_rulerequiresOrExcludeDependency_in_entryRulerequiresOrExcludeDependency2345);
            iv_rulerequiresOrExcludeDependency=rulerequiresOrExcludeDependency();

            state._fsp--;

             current =iv_rulerequiresOrExcludeDependency; 
            match(input,EOF,FOLLOW_EOF_in_entryRulerequiresOrExcludeDependency2355); 

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
    // $ANTLR end "entryRulerequiresOrExcludeDependency"


    // $ANTLR start "rulerequiresOrExcludeDependency"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1143:1: rulerequiresOrExcludeDependency returns [EObject current=null] : (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( ( ruleQualifiedName ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleoclExpr ) ) otherlv_8= ')' ) ;
    public final EObject rulerequiresOrExcludeDependency() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_fields_5_0 = null;

        EObject lv_oclExpression_7_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1146:28: ( (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( ( ruleQualifiedName ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleoclExpr ) ) otherlv_8= ')' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1147:1: (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( ( ruleQualifiedName ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleoclExpr ) ) otherlv_8= ')' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1147:1: (otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( ( ruleQualifiedName ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleoclExpr ) ) otherlv_8= ')' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1147:3: otherlv_0= '(' ( ( ruleEString ) ) otherlv_2= '.' ( ( ruleQualifiedName ) ) otherlv_4= ',' ( (lv_fields_5_0= ruleEString ) ) otherlv_6= ':' ( (lv_oclExpression_7_0= ruleoclExpr ) ) otherlv_8= ')'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_rulerequiresOrExcludeDependency2392); 

                	newLeafNode(otherlv_0, grammarAccess.getRequiresOrExcludeDependencyAccess().getLeftParenthesisKeyword_0());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1151:1: ( ( ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1152:1: ( ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1152:1: ( ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1153:3: ruleEString
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRequiresOrExcludeDependencyRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRequiresOrExcludeDependencyAccess().getRequiredTransformationTransformationCrossReference_1_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_rulerequiresOrExcludeDependency2415);
            ruleEString();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,16,FOLLOW_16_in_rulerequiresOrExcludeDependency2427); 

                	newLeafNode(otherlv_2, grammarAccess.getRequiresOrExcludeDependencyAccess().getFullStopKeyword_2());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1170:1: ( ( ruleQualifiedName ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1171:1: ( ruleQualifiedName )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1171:1: ( ruleQualifiedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1172:3: ruleQualifiedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getRequiresOrExcludeDependencyRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getRequiresOrExcludeDependencyAccess().getRequiredRuleTrcRuleCrossReference_3_0()); 
            	    
            pushFollow(FOLLOW_ruleQualifiedName_in_rulerequiresOrExcludeDependency2450);
            ruleQualifiedName();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,18,FOLLOW_18_in_rulerequiresOrExcludeDependency2462); 

                	newLeafNode(otherlv_4, grammarAccess.getRequiresOrExcludeDependencyAccess().getCommaKeyword_4());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1189:1: ( (lv_fields_5_0= ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1190:1: (lv_fields_5_0= ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1190:1: (lv_fields_5_0= ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1191:3: lv_fields_5_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getRequiresOrExcludeDependencyAccess().getFieldsEStringParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_rulerequiresOrExcludeDependency2483);
            lv_fields_5_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRequiresOrExcludeDependencyRule());
            	        }
                   		set(
                   			current, 
                   			"fields",
                    		lv_fields_5_0, 
                    		"EString");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,17,FOLLOW_17_in_rulerequiresOrExcludeDependency2495); 

                	newLeafNode(otherlv_6, grammarAccess.getRequiresOrExcludeDependencyAccess().getColonKeyword_6());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1211:1: ( (lv_oclExpression_7_0= ruleoclExpr ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1212:1: (lv_oclExpression_7_0= ruleoclExpr )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1212:1: (lv_oclExpression_7_0= ruleoclExpr )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1213:3: lv_oclExpression_7_0= ruleoclExpr
            {
             
            	        newCompositeNode(grammarAccess.getRequiresOrExcludeDependencyAccess().getOclExpressionOclExprParserRuleCall_7_0()); 
            	    
            pushFollow(FOLLOW_ruleoclExpr_in_rulerequiresOrExcludeDependency2516);
            lv_oclExpression_7_0=ruleoclExpr();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getRequiresOrExcludeDependencyRule());
            	        }
                   		add(
                   			current, 
                   			"oclExpression",
                    		lv_oclExpression_7_0, 
                    		"oclExpr");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_8=(Token)match(input,23,FOLLOW_23_in_rulerequiresOrExcludeDependency2528); 

                	newLeafNode(otherlv_8, grammarAccess.getRequiresOrExcludeDependencyAccess().getRightParenthesisKeyword_8());
                

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
    // $ANTLR end "rulerequiresOrExcludeDependency"


    // $ANTLR start "entryRuleoclExpr"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1241:1: entryRuleoclExpr returns [EObject current=null] : iv_ruleoclExpr= ruleoclExpr EOF ;
    public final EObject entryRuleoclExpr() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleoclExpr = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1242:2: (iv_ruleoclExpr= ruleoclExpr EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1243:2: iv_ruleoclExpr= ruleoclExpr EOF
            {
             newCompositeNode(grammarAccess.getOclExprRule()); 
            pushFollow(FOLLOW_ruleoclExpr_in_entryRuleoclExpr2564);
            iv_ruleoclExpr=ruleoclExpr();

            state._fsp--;

             current =iv_ruleoclExpr; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleoclExpr2574); 

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
    // $ANTLR end "entryRuleoclExpr"


    // $ANTLR start "ruleoclExpr"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1250:1: ruleoclExpr returns [EObject current=null] : (this_ClassifierContextDeclCS_0= ruleClassifierContextDeclCS | this_ExpressCS_1= ruleExpressCS ) ;
    public final EObject ruleoclExpr() throws RecognitionException {
        EObject current = null;

        EObject this_ClassifierContextDeclCS_0 = null;

        EObject this_ExpressCS_1 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1253:28: ( (this_ClassifierContextDeclCS_0= ruleClassifierContextDeclCS | this_ExpressCS_1= ruleExpressCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1254:1: (this_ClassifierContextDeclCS_0= ruleClassifierContextDeclCS | this_ExpressCS_1= ruleExpressCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1254:1: (this_ClassifierContextDeclCS_0= ruleClassifierContextDeclCS | this_ExpressCS_1= ruleExpressCS )
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==35) ) {
                alt16=1;
            }
            else if ( (LA16_0==32||LA16_0==69||LA16_0==71) ) {
                alt16=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 16, 0, input);

                throw nvae;
            }
            switch (alt16) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1255:5: this_ClassifierContextDeclCS_0= ruleClassifierContextDeclCS
                    {
                     
                            newCompositeNode(grammarAccess.getOclExprAccess().getClassifierContextDeclCSParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleClassifierContextDeclCS_in_ruleoclExpr2621);
                    this_ClassifierContextDeclCS_0=ruleClassifierContextDeclCS();

                    state._fsp--;

                     
                            current = this_ClassifierContextDeclCS_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1265:5: this_ExpressCS_1= ruleExpressCS
                    {
                     
                            newCompositeNode(grammarAccess.getOclExprAccess().getExpressCSParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleExpressCS_in_ruleoclExpr2648);
                    this_ExpressCS_1=ruleExpressCS();

                    state._fsp--;

                     
                            current = this_ExpressCS_1; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleoclExpr"


    // $ANTLR start "entryRuleEString"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1281:1: entryRuleEString returns [String current=null] : iv_ruleEString= ruleEString EOF ;
    public final String entryRuleEString() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEString = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1282:2: (iv_ruleEString= ruleEString EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1283:2: iv_ruleEString= ruleEString EOF
            {
             newCompositeNode(grammarAccess.getEStringRule()); 
            pushFollow(FOLLOW_ruleEString_in_entryRuleEString2684);
            iv_ruleEString=ruleEString();

            state._fsp--;

             current =iv_ruleEString.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEString2695); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1290:1: ruleEString returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) ;
    public final AntlrDatatypeRuleToken ruleEString() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_STRING_0=null;
        Token this_ID_1=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1293:28: ( (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1294:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1294:1: (this_STRING_0= RULE_STRING | this_ID_1= RULE_ID )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==RULE_STRING) ) {
                alt17=1;
            }
            else if ( (LA17_0==RULE_ID) ) {
                alt17=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1294:6: this_STRING_0= RULE_STRING
                    {
                    this_STRING_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleEString2735); 

                    		current.merge(this_STRING_0);
                        
                     
                        newLeafNode(this_STRING_0, grammarAccess.getEStringAccess().getSTRINGTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1302:10: this_ID_1= RULE_ID
                    {
                    this_ID_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleEString2761); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1317:1: entryRuleEInt returns [String current=null] : iv_ruleEInt= ruleEInt EOF ;
    public final String entryRuleEInt() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEInt = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1318:2: (iv_ruleEInt= ruleEInt EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1319:2: iv_ruleEInt= ruleEInt EOF
            {
             newCompositeNode(grammarAccess.getEIntRule()); 
            pushFollow(FOLLOW_ruleEInt_in_entryRuleEInt2807);
            iv_ruleEInt=ruleEInt();

            state._fsp--;

             current =iv_ruleEInt.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEInt2818); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1326:1: ruleEInt returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : ( (kw= '-' )? this_INT_1= RULE_INT ) ;
    public final AntlrDatatypeRuleToken ruleEInt() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        Token this_INT_1=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1329:28: ( ( (kw= '-' )? this_INT_1= RULE_INT ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1330:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1330:1: ( (kw= '-' )? this_INT_1= RULE_INT )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1330:2: (kw= '-' )? this_INT_1= RULE_INT
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1330:2: (kw= '-' )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==32) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1331:2: kw= '-'
                    {
                    kw=(Token)match(input,32,FOLLOW_32_in_ruleEInt2857); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEIntAccess().getHyphenMinusKeyword_0()); 
                        

                    }
                    break;

            }

            this_INT_1=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleEInt2874); 

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


    // $ANTLR start "entryRuleEBoolean"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1351:1: entryRuleEBoolean returns [String current=null] : iv_ruleEBoolean= ruleEBoolean EOF ;
    public final String entryRuleEBoolean() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEBoolean = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1352:2: (iv_ruleEBoolean= ruleEBoolean EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1353:2: iv_ruleEBoolean= ruleEBoolean EOF
            {
             newCompositeNode(grammarAccess.getEBooleanRule()); 
            pushFollow(FOLLOW_ruleEBoolean_in_entryRuleEBoolean2920);
            iv_ruleEBoolean=ruleEBoolean();

            state._fsp--;

             current =iv_ruleEBoolean.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEBoolean2931); 

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
    // $ANTLR end "entryRuleEBoolean"


    // $ANTLR start "ruleEBoolean"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1360:1: ruleEBoolean returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'true' | kw= 'false' ) ;
    public final AntlrDatatypeRuleToken ruleEBoolean() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1363:28: ( (kw= 'true' | kw= 'false' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1364:1: (kw= 'true' | kw= 'false' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1364:1: (kw= 'true' | kw= 'false' )
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==33) ) {
                alt19=1;
            }
            else if ( (LA19_0==34) ) {
                alt19=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 19, 0, input);

                throw nvae;
            }
            switch (alt19) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1365:2: kw= 'true'
                    {
                    kw=(Token)match(input,33,FOLLOW_33_in_ruleEBoolean2969); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEBooleanAccess().getTrueKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1372:2: kw= 'false'
                    {
                    kw=(Token)match(input,34,FOLLOW_34_in_ruleEBoolean2988); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEBooleanAccess().getFalseKeyword_1()); 
                        

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
    // $ANTLR end "ruleEBoolean"


    // $ANTLR start "entryRuleClassifierContextDeclCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1385:1: entryRuleClassifierContextDeclCS returns [EObject current=null] : iv_ruleClassifierContextDeclCS= ruleClassifierContextDeclCS EOF ;
    public final EObject entryRuleClassifierContextDeclCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleClassifierContextDeclCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1386:2: (iv_ruleClassifierContextDeclCS= ruleClassifierContextDeclCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1387:2: iv_ruleClassifierContextDeclCS= ruleClassifierContextDeclCS EOF
            {
             newCompositeNode(grammarAccess.getClassifierContextDeclCSRule()); 
            pushFollow(FOLLOW_ruleClassifierContextDeclCS_in_entryRuleClassifierContextDeclCS3028);
            iv_ruleClassifierContextDeclCS=ruleClassifierContextDeclCS();

            state._fsp--;

             current =iv_ruleClassifierContextDeclCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleClassifierContextDeclCS3038); 

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
    // $ANTLR end "entryRuleClassifierContextDeclCS"


    // $ANTLR start "ruleClassifierContextDeclCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1394:1: ruleClassifierContextDeclCS returns [EObject current=null] : (otherlv_0= 'context' ( (lv_selfName_1_0= ruleUnrestrictedName ) )? ( (otherlv_2= 'inv' ( (lv_invariants_3_0= ruleConstraintCS ) ) ) | ( (lv_definitions_4_0= ruleDefCS ) ) )+ ) ;
    public final EObject ruleClassifierContextDeclCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        AntlrDatatypeRuleToken lv_selfName_1_0 = null;

        EObject lv_invariants_3_0 = null;

        EObject lv_definitions_4_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1397:28: ( (otherlv_0= 'context' ( (lv_selfName_1_0= ruleUnrestrictedName ) )? ( (otherlv_2= 'inv' ( (lv_invariants_3_0= ruleConstraintCS ) ) ) | ( (lv_definitions_4_0= ruleDefCS ) ) )+ ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1398:1: (otherlv_0= 'context' ( (lv_selfName_1_0= ruleUnrestrictedName ) )? ( (otherlv_2= 'inv' ( (lv_invariants_3_0= ruleConstraintCS ) ) ) | ( (lv_definitions_4_0= ruleDefCS ) ) )+ )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1398:1: (otherlv_0= 'context' ( (lv_selfName_1_0= ruleUnrestrictedName ) )? ( (otherlv_2= 'inv' ( (lv_invariants_3_0= ruleConstraintCS ) ) ) | ( (lv_definitions_4_0= ruleDefCS ) ) )+ )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1398:3: otherlv_0= 'context' ( (lv_selfName_1_0= ruleUnrestrictedName ) )? ( (otherlv_2= 'inv' ( (lv_invariants_3_0= ruleConstraintCS ) ) ) | ( (lv_definitions_4_0= ruleDefCS ) ) )+
            {
            otherlv_0=(Token)match(input,35,FOLLOW_35_in_ruleClassifierContextDeclCS3075); 

                	newLeafNode(otherlv_0, grammarAccess.getClassifierContextDeclCSAccess().getContextKeyword_0());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1402:1: ( (lv_selfName_1_0= ruleUnrestrictedName ) )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==RULE_ID) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1403:1: (lv_selfName_1_0= ruleUnrestrictedName )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1403:1: (lv_selfName_1_0= ruleUnrestrictedName )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1404:3: lv_selfName_1_0= ruleUnrestrictedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getClassifierContextDeclCSAccess().getSelfNameUnrestrictedNameParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnrestrictedName_in_ruleClassifierContextDeclCS3096);
                    lv_selfName_1_0=ruleUnrestrictedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getClassifierContextDeclCSRule());
                    	        }
                           		set(
                           			current, 
                           			"selfName",
                            		lv_selfName_1_0, 
                            		"UnrestrictedName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1420:3: ( (otherlv_2= 'inv' ( (lv_invariants_3_0= ruleConstraintCS ) ) ) | ( (lv_definitions_4_0= ruleDefCS ) ) )+
            int cnt21=0;
            loop21:
            do {
                int alt21=3;
                int LA21_0 = input.LA(1);

                if ( (LA21_0==36) ) {
                    alt21=1;
                }
                else if ( ((LA21_0>=37 && LA21_0<=38)) ) {
                    alt21=2;
                }


                switch (alt21) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1420:4: (otherlv_2= 'inv' ( (lv_invariants_3_0= ruleConstraintCS ) ) )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1420:4: (otherlv_2= 'inv' ( (lv_invariants_3_0= ruleConstraintCS ) ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1420:6: otherlv_2= 'inv' ( (lv_invariants_3_0= ruleConstraintCS ) )
            	    {
            	    otherlv_2=(Token)match(input,36,FOLLOW_36_in_ruleClassifierContextDeclCS3111); 

            	        	newLeafNode(otherlv_2, grammarAccess.getClassifierContextDeclCSAccess().getInvKeyword_2_0_0());
            	        
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1424:1: ( (lv_invariants_3_0= ruleConstraintCS ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1425:1: (lv_invariants_3_0= ruleConstraintCS )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1425:1: (lv_invariants_3_0= ruleConstraintCS )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1426:3: lv_invariants_3_0= ruleConstraintCS
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getClassifierContextDeclCSAccess().getInvariantsConstraintCSParserRuleCall_2_0_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleConstraintCS_in_ruleClassifierContextDeclCS3132);
            	    lv_invariants_3_0=ruleConstraintCS();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getClassifierContextDeclCSRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"invariants",
            	            		lv_invariants_3_0, 
            	            		"ConstraintCS");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }


            	    }
            	    break;
            	case 2 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1443:6: ( (lv_definitions_4_0= ruleDefCS ) )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1443:6: ( (lv_definitions_4_0= ruleDefCS ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1444:1: (lv_definitions_4_0= ruleDefCS )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1444:1: (lv_definitions_4_0= ruleDefCS )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1445:3: lv_definitions_4_0= ruleDefCS
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getClassifierContextDeclCSAccess().getDefinitionsDefCSParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleDefCS_in_ruleClassifierContextDeclCS3160);
            	    lv_definitions_4_0=ruleDefCS();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getClassifierContextDeclCSRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"definitions",
            	            		lv_definitions_4_0, 
            	            		"DefCS");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt21 >= 1 ) break loop21;
                        EarlyExitException eee =
                            new EarlyExitException(21, input);
                        throw eee;
                }
                cnt21++;
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
    // $ANTLR end "ruleClassifierContextDeclCS"


    // $ANTLR start "entryRuleParameterCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1471:1: entryRuleParameterCS returns [EObject current=null] : iv_ruleParameterCS= ruleParameterCS EOF ;
    public final EObject entryRuleParameterCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameterCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1472:2: (iv_ruleParameterCS= ruleParameterCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1473:2: iv_ruleParameterCS= ruleParameterCS EOF
            {
             newCompositeNode(grammarAccess.getParameterCSRule()); 
            pushFollow(FOLLOW_ruleParameterCS_in_entryRuleParameterCS3200);
            iv_ruleParameterCS=ruleParameterCS();

            state._fsp--;

             current =iv_ruleParameterCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleParameterCS3210); 

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
    // $ANTLR end "entryRuleParameterCS"


    // $ANTLR start "ruleParameterCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1480:1: ruleParameterCS returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' )? ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleParameterCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1483:28: ( ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' )? ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1484:1: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' )? ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1484:1: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' )? ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1484:2: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' )? ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1484:2: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' )?
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==RULE_ID) ) {
                int LA22_1 = input.LA(2);

                if ( (LA22_1==17) ) {
                    alt22=1;
                }
            }
            switch (alt22) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1484:3: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':'
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1484:3: ( (lv_name_0_0= ruleUnrestrictedName ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1485:1: (lv_name_0_0= ruleUnrestrictedName )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1485:1: (lv_name_0_0= ruleUnrestrictedName )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1486:3: lv_name_0_0= ruleUnrestrictedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getParameterCSAccess().getNameUnrestrictedNameParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnrestrictedName_in_ruleParameterCS3257);
                    lv_name_0_0=ruleUnrestrictedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getParameterCSRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_0_0, 
                            		"UnrestrictedName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleParameterCS3269); 

                        	newLeafNode(otherlv_1, grammarAccess.getParameterCSAccess().getColonKeyword_0_1());
                        

                    }
                    break;

            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1506:3: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1507:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1507:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1508:3: lv_ownedType_2_0= ruleTypeExpCS
            {
             
            	        newCompositeNode(grammarAccess.getParameterCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeExpCS_in_ruleParameterCS3292);
            lv_ownedType_2_0=ruleTypeExpCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getParameterCSRule());
            	        }
                   		set(
                   			current, 
                   			"ownedType",
                    		lv_ownedType_2_0, 
                    		"TypeExpCS");
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
    // $ANTLR end "ruleParameterCS"


    // $ANTLR start "entryRuleConstraintCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1532:1: entryRuleConstraintCS returns [EObject current=null] : iv_ruleConstraintCS= ruleConstraintCS EOF ;
    public final EObject entryRuleConstraintCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstraintCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1533:2: (iv_ruleConstraintCS= ruleConstraintCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1534:2: iv_ruleConstraintCS= ruleConstraintCS EOF
            {
             newCompositeNode(grammarAccess.getConstraintCSRule()); 
            pushFollow(FOLLOW_ruleConstraintCS_in_entryRuleConstraintCS3328);
            iv_ruleConstraintCS=ruleConstraintCS();

            state._fsp--;

             current =iv_ruleConstraintCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstraintCS3338); 

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
    // $ANTLR end "entryRuleConstraintCS"


    // $ANTLR start "ruleConstraintCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1541:1: ruleConstraintCS returns [EObject current=null] : ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= '(' ( (lv_messageSpecification_2_0= ruleSpecificationCS ) ) otherlv_3= ')' )? )? otherlv_4= ':' ( (lv_specification_5_0= ruleSpecificationCS ) ) ( (lv_specification_6_0= ruleSpecificationCS ) )* ) ;
    public final EObject ruleConstraintCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_messageSpecification_2_0 = null;

        EObject lv_specification_5_0 = null;

        EObject lv_specification_6_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1544:28: ( ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= '(' ( (lv_messageSpecification_2_0= ruleSpecificationCS ) ) otherlv_3= ')' )? )? otherlv_4= ':' ( (lv_specification_5_0= ruleSpecificationCS ) ) ( (lv_specification_6_0= ruleSpecificationCS ) )* ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1545:1: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= '(' ( (lv_messageSpecification_2_0= ruleSpecificationCS ) ) otherlv_3= ')' )? )? otherlv_4= ':' ( (lv_specification_5_0= ruleSpecificationCS ) ) ( (lv_specification_6_0= ruleSpecificationCS ) )* )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1545:1: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= '(' ( (lv_messageSpecification_2_0= ruleSpecificationCS ) ) otherlv_3= ')' )? )? otherlv_4= ':' ( (lv_specification_5_0= ruleSpecificationCS ) ) ( (lv_specification_6_0= ruleSpecificationCS ) )* )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1545:2: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= '(' ( (lv_messageSpecification_2_0= ruleSpecificationCS ) ) otherlv_3= ')' )? )? otherlv_4= ':' ( (lv_specification_5_0= ruleSpecificationCS ) ) ( (lv_specification_6_0= ruleSpecificationCS ) )*
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1545:2: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= '(' ( (lv_messageSpecification_2_0= ruleSpecificationCS ) ) otherlv_3= ')' )? )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==RULE_ID) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1545:3: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= '(' ( (lv_messageSpecification_2_0= ruleSpecificationCS ) ) otherlv_3= ')' )?
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1545:3: ( (lv_name_0_0= ruleUnrestrictedName ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1546:1: (lv_name_0_0= ruleUnrestrictedName )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1546:1: (lv_name_0_0= ruleUnrestrictedName )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1547:3: lv_name_0_0= ruleUnrestrictedName
                    {
                     
                    	        newCompositeNode(grammarAccess.getConstraintCSAccess().getNameUnrestrictedNameParserRuleCall_0_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUnrestrictedName_in_ruleConstraintCS3385);
                    lv_name_0_0=ruleUnrestrictedName();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getConstraintCSRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_0_0, 
                            		"UnrestrictedName");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1563:2: (otherlv_1= '(' ( (lv_messageSpecification_2_0= ruleSpecificationCS ) ) otherlv_3= ')' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==22) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1563:4: otherlv_1= '(' ( (lv_messageSpecification_2_0= ruleSpecificationCS ) ) otherlv_3= ')'
                            {
                            otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleConstraintCS3398); 

                                	newLeafNode(otherlv_1, grammarAccess.getConstraintCSAccess().getLeftParenthesisKeyword_0_1_0());
                                
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1567:1: ( (lv_messageSpecification_2_0= ruleSpecificationCS ) )
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1568:1: (lv_messageSpecification_2_0= ruleSpecificationCS )
                            {
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1568:1: (lv_messageSpecification_2_0= ruleSpecificationCS )
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1569:3: lv_messageSpecification_2_0= ruleSpecificationCS
                            {
                             
                            	        newCompositeNode(grammarAccess.getConstraintCSAccess().getMessageSpecificationSpecificationCSParserRuleCall_0_1_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleSpecificationCS_in_ruleConstraintCS3419);
                            lv_messageSpecification_2_0=ruleSpecificationCS();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getConstraintCSRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"messageSpecification",
                                    		lv_messageSpecification_2_0, 
                                    		"SpecificationCS");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleConstraintCS3431); 

                                	newLeafNode(otherlv_3, grammarAccess.getConstraintCSAccess().getRightParenthesisKeyword_0_1_2());
                                

                            }
                            break;

                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,17,FOLLOW_17_in_ruleConstraintCS3447); 

                	newLeafNode(otherlv_4, grammarAccess.getConstraintCSAccess().getColonKeyword_1());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1593:1: ( (lv_specification_5_0= ruleSpecificationCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1594:1: (lv_specification_5_0= ruleSpecificationCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1594:1: (lv_specification_5_0= ruleSpecificationCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1595:3: lv_specification_5_0= ruleSpecificationCS
            {
             
            	        newCompositeNode(grammarAccess.getConstraintCSAccess().getSpecificationSpecificationCSParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleSpecificationCS_in_ruleConstraintCS3468);
            lv_specification_5_0=ruleSpecificationCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstraintCSRule());
            	        }
                   		add(
                   			current, 
                   			"specification",
                    		lv_specification_5_0, 
                    		"SpecificationCS");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1611:2: ( (lv_specification_6_0= ruleSpecificationCS ) )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==RULE_ID||LA25_0==RULE_UNQUOTED_STRING||LA25_0==16||(LA25_0>=28 && LA25_0<=29)||LA25_0==32||(LA25_0>=39 && LA25_0<=41)||(LA25_0>=59 && LA25_0<=68)||LA25_0==71) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1612:1: (lv_specification_6_0= ruleSpecificationCS )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1612:1: (lv_specification_6_0= ruleSpecificationCS )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1613:3: lv_specification_6_0= ruleSpecificationCS
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getConstraintCSAccess().getSpecificationSpecificationCSParserRuleCall_3_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleSpecificationCS_in_ruleConstraintCS3489);
            	    lv_specification_6_0=ruleSpecificationCS();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getConstraintCSRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"specification",
            	            		lv_specification_6_0, 
            	            		"SpecificationCS");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
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
    // $ANTLR end "ruleConstraintCS"


    // $ANTLR start "entryRuleEssentialOCLUnrestrictedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1637:1: entryRuleEssentialOCLUnrestrictedName returns [String current=null] : iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF ;
    public final String entryRuleEssentialOCLUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnrestrictedName = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1638:2: (iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1639:2: iv_ruleEssentialOCLUnrestrictedName= ruleEssentialOCLUnrestrictedName EOF
            {
             newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameRule()); 
            pushFollow(FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName3527);
            iv_ruleEssentialOCLUnrestrictedName=ruleEssentialOCLUnrestrictedName();

            state._fsp--;

             current =iv_ruleEssentialOCLUnrestrictedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName3538); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1646:1: ruleEssentialOCLUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_Identifier_0= ruleIdentifier ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_Identifier_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1649:28: (this_Identifier_0= ruleIdentifier )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1651:5: this_Identifier_0= ruleIdentifier
            {
             
                    newCompositeNode(grammarAccess.getEssentialOCLUnrestrictedNameAccess().getIdentifierParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName3584);
            this_Identifier_0=ruleIdentifier();

            state._fsp--;


            		current.merge(this_Identifier_0);
                
             
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
    // $ANTLR end "ruleEssentialOCLUnrestrictedName"


    // $ANTLR start "entryRuleIdentifier"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1669:1: entryRuleIdentifier returns [String current=null] : iv_ruleIdentifier= ruleIdentifier EOF ;
    public final String entryRuleIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleIdentifier = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1670:2: (iv_ruleIdentifier= ruleIdentifier EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1671:2: iv_ruleIdentifier= ruleIdentifier EOF
            {
             newCompositeNode(grammarAccess.getIdentifierRule()); 
            pushFollow(FOLLOW_ruleIdentifier_in_entryRuleIdentifier3629);
            iv_ruleIdentifier=ruleIdentifier();

            state._fsp--;

             current =iv_ruleIdentifier.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIdentifier3640); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1678:1: ruleIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1681:28: (this_ID_0= RULE_ID )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1682:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleIdentifier3679); 

            		current.merge(this_ID_0);
                
             
                newLeafNode(this_ID_0, grammarAccess.getIdentifierAccess().getIDTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleIdentifier"


    // $ANTLR start "entryRuleUnrestrictedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1697:1: entryRuleUnrestrictedName returns [String current=null] : iv_ruleUnrestrictedName= ruleUnrestrictedName EOF ;
    public final String entryRuleUnrestrictedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnrestrictedName = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1698:2: (iv_ruleUnrestrictedName= ruleUnrestrictedName EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1699:2: iv_ruleUnrestrictedName= ruleUnrestrictedName EOF
            {
             newCompositeNode(grammarAccess.getUnrestrictedNameRule()); 
            pushFollow(FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName3724);
            iv_ruleUnrestrictedName=ruleUnrestrictedName();

            state._fsp--;

             current =iv_ruleUnrestrictedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnrestrictedName3735); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1706:1: ruleUnrestrictedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName ;
    public final AntlrDatatypeRuleToken ruleUnrestrictedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnrestrictedName_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1709:28: (this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1711:5: this_EssentialOCLUnrestrictedName_0= ruleEssentialOCLUnrestrictedName
            {
             
                    newCompositeNode(grammarAccess.getUnrestrictedNameAccess().getEssentialOCLUnrestrictedNameParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName3781);
            this_EssentialOCLUnrestrictedName_0=ruleEssentialOCLUnrestrictedName();

            state._fsp--;


            		current.merge(this_EssentialOCLUnrestrictedName_0);
                
             
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
    // $ANTLR end "ruleUnrestrictedName"


    // $ANTLR start "entryRuleDefCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1729:1: entryRuleDefCS returns [EObject current=null] : iv_ruleDefCS= ruleDefCS EOF ;
    public final EObject entryRuleDefCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1730:2: (iv_ruleDefCS= ruleDefCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1731:2: iv_ruleDefCS= ruleDefCS EOF
            {
             newCompositeNode(grammarAccess.getDefCSRule()); 
            pushFollow(FOLLOW_ruleDefCS_in_entryRuleDefCS3825);
            iv_ruleDefCS=ruleDefCS();

            state._fsp--;

             current =iv_ruleDefCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefCS3835); 

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
    // $ANTLR end "entryRuleDefCS"


    // $ANTLR start "ruleDefCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1738:1: ruleDefCS returns [EObject current=null] : this_DefPropertyCS_0= ruleDefPropertyCS ;
    public final EObject ruleDefCS() throws RecognitionException {
        EObject current = null;

        EObject this_DefPropertyCS_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1741:28: (this_DefPropertyCS_0= ruleDefPropertyCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1743:5: this_DefPropertyCS_0= ruleDefPropertyCS
            {
             
                    newCompositeNode(grammarAccess.getDefCSAccess().getDefPropertyCSParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleDefPropertyCS_in_ruleDefCS3881);
            this_DefPropertyCS_0=ruleDefPropertyCS();

            state._fsp--;

             
                    current = this_DefPropertyCS_0; 
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
    // $ANTLR end "ruleDefCS"


    // $ANTLR start "entryRuleDefPropertyCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1759:1: entryRuleDefPropertyCS returns [EObject current=null] : iv_ruleDefPropertyCS= ruleDefPropertyCS EOF ;
    public final EObject entryRuleDefPropertyCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDefPropertyCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1760:2: (iv_ruleDefPropertyCS= ruleDefPropertyCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1761:2: iv_ruleDefPropertyCS= ruleDefPropertyCS EOF
            {
             newCompositeNode(grammarAccess.getDefPropertyCSRule()); 
            pushFollow(FOLLOW_ruleDefPropertyCS_in_entryRuleDefPropertyCS3915);
            iv_ruleDefPropertyCS=ruleDefPropertyCS();

            state._fsp--;

             current =iv_ruleDefPropertyCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDefPropertyCS3925); 

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
    // $ANTLR end "entryRuleDefPropertyCS"


    // $ANTLR start "ruleDefPropertyCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1768:1: ruleDefPropertyCS returns [EObject current=null] : ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'def' ( ruleUnrestrictedName )? otherlv_3= ':' ( (lv_name_4_0= ruleUnrestrictedName ) ) otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) otherlv_7= '=' ( (lv_specification_8_0= ruleSpecificationCS ) ) ) ;
    public final EObject ruleDefPropertyCS() throws RecognitionException {
        EObject current = null;

        Token lv_static_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        AntlrDatatypeRuleToken lv_name_4_0 = null;

        EObject lv_ownedType_6_0 = null;

        EObject lv_specification_8_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1771:28: ( ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'def' ( ruleUnrestrictedName )? otherlv_3= ':' ( (lv_name_4_0= ruleUnrestrictedName ) ) otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) otherlv_7= '=' ( (lv_specification_8_0= ruleSpecificationCS ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1772:1: ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'def' ( ruleUnrestrictedName )? otherlv_3= ':' ( (lv_name_4_0= ruleUnrestrictedName ) ) otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) otherlv_7= '=' ( (lv_specification_8_0= ruleSpecificationCS ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1772:1: ( ( (lv_static_0_0= 'static' ) )? otherlv_1= 'def' ( ruleUnrestrictedName )? otherlv_3= ':' ( (lv_name_4_0= ruleUnrestrictedName ) ) otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) otherlv_7= '=' ( (lv_specification_8_0= ruleSpecificationCS ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1772:2: ( (lv_static_0_0= 'static' ) )? otherlv_1= 'def' ( ruleUnrestrictedName )? otherlv_3= ':' ( (lv_name_4_0= ruleUnrestrictedName ) ) otherlv_5= ':' ( (lv_ownedType_6_0= ruleTypeExpCS ) ) otherlv_7= '=' ( (lv_specification_8_0= ruleSpecificationCS ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1772:2: ( (lv_static_0_0= 'static' ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==37) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1773:1: (lv_static_0_0= 'static' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1773:1: (lv_static_0_0= 'static' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1774:3: lv_static_0_0= 'static'
                    {
                    lv_static_0_0=(Token)match(input,37,FOLLOW_37_in_ruleDefPropertyCS3968); 

                            newLeafNode(lv_static_0_0, grammarAccess.getDefPropertyCSAccess().getStaticStaticKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDefPropertyCSRule());
                    	        }
                           		setWithLastConsumed(current, "static", true, "static");
                    	    

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,38,FOLLOW_38_in_ruleDefPropertyCS3994); 

                	newLeafNode(otherlv_1, grammarAccess.getDefPropertyCSAccess().getDefKeyword_1());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1791:1: ( ruleUnrestrictedName )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==RULE_ID) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1792:5: ruleUnrestrictedName
                    {
                     
                            newCompositeNode(grammarAccess.getDefPropertyCSAccess().getUnrestrictedNameParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleUnrestrictedName_in_ruleDefPropertyCS4011);
                    ruleUnrestrictedName();

                    state._fsp--;

                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            otherlv_3=(Token)match(input,17,FOLLOW_17_in_ruleDefPropertyCS4024); 

                	newLeafNode(otherlv_3, grammarAccess.getDefPropertyCSAccess().getColonKeyword_3());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1803:1: ( (lv_name_4_0= ruleUnrestrictedName ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1804:1: (lv_name_4_0= ruleUnrestrictedName )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1804:1: (lv_name_4_0= ruleUnrestrictedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1805:3: lv_name_4_0= ruleUnrestrictedName
            {
             
            	        newCompositeNode(grammarAccess.getDefPropertyCSAccess().getNameUnrestrictedNameParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleUnrestrictedName_in_ruleDefPropertyCS4045);
            lv_name_4_0=ruleUnrestrictedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDefPropertyCSRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_4_0, 
                    		"UnrestrictedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleDefPropertyCS4057); 

                	newLeafNode(otherlv_5, grammarAccess.getDefPropertyCSAccess().getColonKeyword_5());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1825:1: ( (lv_ownedType_6_0= ruleTypeExpCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1826:1: (lv_ownedType_6_0= ruleTypeExpCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1826:1: (lv_ownedType_6_0= ruleTypeExpCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1827:3: lv_ownedType_6_0= ruleTypeExpCS
            {
             
            	        newCompositeNode(grammarAccess.getDefPropertyCSAccess().getOwnedTypeTypeExpCSParserRuleCall_6_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeExpCS_in_ruleDefPropertyCS4078);
            lv_ownedType_6_0=ruleTypeExpCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDefPropertyCSRule());
            	        }
                   		set(
                   			current, 
                   			"ownedType",
                    		lv_ownedType_6_0, 
                    		"TypeExpCS");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_7=(Token)match(input,39,FOLLOW_39_in_ruleDefPropertyCS4090); 

                	newLeafNode(otherlv_7, grammarAccess.getDefPropertyCSAccess().getEqualsSignKeyword_7());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1847:1: ( (lv_specification_8_0= ruleSpecificationCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1848:1: (lv_specification_8_0= ruleSpecificationCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1848:1: (lv_specification_8_0= ruleSpecificationCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1849:3: lv_specification_8_0= ruleSpecificationCS
            {
             
            	        newCompositeNode(grammarAccess.getDefPropertyCSAccess().getSpecificationSpecificationCSParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_ruleSpecificationCS_in_ruleDefPropertyCS4111);
            lv_specification_8_0=ruleSpecificationCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getDefPropertyCSRule());
            	        }
                   		set(
                   			current, 
                   			"specification",
                    		lv_specification_8_0, 
                    		"SpecificationCS");
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
    // $ANTLR end "ruleDefPropertyCS"


    // $ANTLR start "entryRuleTypeExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1873:1: entryRuleTypeExpCS returns [EObject current=null] : iv_ruleTypeExpCS= ruleTypeExpCS EOF ;
    public final EObject entryRuleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1874:2: (iv_ruleTypeExpCS= ruleTypeExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1875:2: iv_ruleTypeExpCS= ruleTypeExpCS EOF
            {
             newCompositeNode(grammarAccess.getTypeExpCSRule()); 
            pushFollow(FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS4147);
            iv_ruleTypeExpCS=ruleTypeExpCS();

            state._fsp--;

             current =iv_ruleTypeExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeExpCS4157); 

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
    // $ANTLR end "entryRuleTypeExpCS"


    // $ANTLR start "ruleTypeExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1882:1: ruleTypeExpCS returns [EObject current=null] : (this_TypeNameExpCS_0= ruleTypeNameExpCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeNameExpCS_0 = null;

        EObject lv_multiplicity_1_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1885:28: ( (this_TypeNameExpCS_0= ruleTypeNameExpCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1886:1: (this_TypeNameExpCS_0= ruleTypeNameExpCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1886:1: (this_TypeNameExpCS_0= ruleTypeNameExpCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1887:5: this_TypeNameExpCS_0= ruleTypeNameExpCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )?
            {
             
                    newCompositeNode(grammarAccess.getTypeExpCSAccess().getTypeNameExpCSParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS4204);
            this_TypeNameExpCS_0=ruleTypeNameExpCS();

            state._fsp--;

             
                    current = this_TypeNameExpCS_0; 
                    afterParserOrEnumRuleCall();
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1895:1: ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==26) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1896:1: (lv_multiplicity_1_0= ruleMultiplicityCS )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1896:1: (lv_multiplicity_1_0= ruleMultiplicityCS )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1897:3: lv_multiplicity_1_0= ruleMultiplicityCS
                    {
                     
                    	        newCompositeNode(grammarAccess.getTypeExpCSAccess().getMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS4224);
                    lv_multiplicity_1_0=ruleMultiplicityCS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTypeExpCSRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplicity",
                            		lv_multiplicity_1_0, 
                            		"MultiplicityCS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

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
    // $ANTLR end "ruleTypeExpCS"


    // $ANTLR start "entryRuleMultiplicityCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1921:1: entryRuleMultiplicityCS returns [EObject current=null] : iv_ruleMultiplicityCS= ruleMultiplicityCS EOF ;
    public final EObject entryRuleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1922:2: (iv_ruleMultiplicityCS= ruleMultiplicityCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1923:2: iv_ruleMultiplicityCS= ruleMultiplicityCS EOF
            {
             newCompositeNode(grammarAccess.getMultiplicityCSRule()); 
            pushFollow(FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS4261);
            iv_ruleMultiplicityCS=ruleMultiplicityCS();

            state._fsp--;

             current =iv_ruleMultiplicityCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicityCS4271); 

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
    // $ANTLR end "entryRuleMultiplicityCS"


    // $ANTLR start "ruleMultiplicityCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1930:1: ruleMultiplicityCS returns [EObject current=null] : (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) ;
    public final EObject ruleMultiplicityCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject this_MultiplicityBoundsCS_1 = null;

        EObject this_MultiplicityStringCS_2 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1933:28: ( (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1934:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1934:1: (otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1934:3: otherlv_0= '[' (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS ) otherlv_3= ']'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleMultiplicityCS4308); 

                	newLeafNode(otherlv_0, grammarAccess.getMultiplicityCSAccess().getLeftSquareBracketKeyword_0());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1938:1: (this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS | this_MultiplicityStringCS_2= ruleMultiplicityStringCS )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==RULE_INT) ) {
                alt29=1;
            }
            else if ( ((LA29_0>=40 && LA29_0<=42)) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1939:5: this_MultiplicityBoundsCS_1= ruleMultiplicityBoundsCS
                    {
                     
                            newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityBoundsCSParserRuleCall_1_0()); 
                        
                    pushFollow(FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS4331);
                    this_MultiplicityBoundsCS_1=ruleMultiplicityBoundsCS();

                    state._fsp--;

                     
                            current = this_MultiplicityBoundsCS_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1949:5: this_MultiplicityStringCS_2= ruleMultiplicityStringCS
                    {
                     
                            newCompositeNode(grammarAccess.getMultiplicityCSAccess().getMultiplicityStringCSParserRuleCall_1_1()); 
                        
                    pushFollow(FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS4358);
                    this_MultiplicityStringCS_2=ruleMultiplicityStringCS();

                    state._fsp--;

                     
                            current = this_MultiplicityStringCS_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }

            otherlv_3=(Token)match(input,27,FOLLOW_27_in_ruleMultiplicityCS4370); 

                	newLeafNode(otherlv_3, grammarAccess.getMultiplicityCSAccess().getRightSquareBracketKeyword_2());
                

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
    // $ANTLR end "ruleMultiplicityCS"


    // $ANTLR start "entryRuleMultiplicityStringCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1969:1: entryRuleMultiplicityStringCS returns [EObject current=null] : iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF ;
    public final EObject entryRuleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityStringCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1970:2: (iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1971:2: iv_ruleMultiplicityStringCS= ruleMultiplicityStringCS EOF
            {
             newCompositeNode(grammarAccess.getMultiplicityStringCSRule()); 
            pushFollow(FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS4406);
            iv_ruleMultiplicityStringCS=ruleMultiplicityStringCS();

            state._fsp--;

             current =iv_ruleMultiplicityStringCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicityStringCS4416); 

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
    // $ANTLR end "entryRuleMultiplicityStringCS"


    // $ANTLR start "ruleMultiplicityStringCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1978:1: ruleMultiplicityStringCS returns [EObject current=null] : ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) ;
    public final EObject ruleMultiplicityStringCS() throws RecognitionException {
        EObject current = null;

        Token lv_stringBounds_0_1=null;
        Token lv_stringBounds_0_2=null;
        Token lv_stringBounds_0_3=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1981:28: ( ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1982:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1982:1: ( ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1983:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1983:1: ( (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1984:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1984:1: (lv_stringBounds_0_1= '*' | lv_stringBounds_0_2= '+' | lv_stringBounds_0_3= '?' )
            int alt30=3;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt30=1;
                }
                break;
            case 41:
                {
                alt30=2;
                }
                break;
            case 42:
                {
                alt30=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 30, 0, input);

                throw nvae;
            }

            switch (alt30) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1985:3: lv_stringBounds_0_1= '*'
                    {
                    lv_stringBounds_0_1=(Token)match(input,40,FOLLOW_40_in_ruleMultiplicityStringCS4460); 

                            newLeafNode(lv_stringBounds_0_1, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsAsteriskKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
                    	        }
                           		setWithLastConsumed(current, "stringBounds", lv_stringBounds_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:1997:8: lv_stringBounds_0_2= '+'
                    {
                    lv_stringBounds_0_2=(Token)match(input,41,FOLLOW_41_in_ruleMultiplicityStringCS4489); 

                            newLeafNode(lv_stringBounds_0_2, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsPlusSignKeyword_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
                    	        }
                           		setWithLastConsumed(current, "stringBounds", lv_stringBounds_0_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2009:8: lv_stringBounds_0_3= '?'
                    {
                    lv_stringBounds_0_3=(Token)match(input,42,FOLLOW_42_in_ruleMultiplicityStringCS4518); 

                            newLeafNode(lv_stringBounds_0_3, grammarAccess.getMultiplicityStringCSAccess().getStringBoundsQuestionMarkKeyword_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getMultiplicityStringCSRule());
                    	        }
                           		setWithLastConsumed(current, "stringBounds", lv_stringBounds_0_3, null);
                    	    

                    }
                    break;

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
    // $ANTLR end "ruleMultiplicityStringCS"


    // $ANTLR start "entryRuleMultiplicityBoundsCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2032:1: entryRuleMultiplicityBoundsCS returns [EObject current=null] : iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF ;
    public final EObject entryRuleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicityBoundsCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2033:2: (iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2034:2: iv_ruleMultiplicityBoundsCS= ruleMultiplicityBoundsCS EOF
            {
             newCompositeNode(grammarAccess.getMultiplicityBoundsCSRule()); 
            pushFollow(FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS4569);
            iv_ruleMultiplicityBoundsCS=ruleMultiplicityBoundsCS();

            state._fsp--;

             current =iv_ruleMultiplicityBoundsCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS4579); 

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
    // $ANTLR end "entryRuleMultiplicityBoundsCS"


    // $ANTLR start "ruleMultiplicityBoundsCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2041:1: ruleMultiplicityBoundsCS returns [EObject current=null] : ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) ;
    public final EObject ruleMultiplicityBoundsCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_lowerBound_0_0 = null;

        AntlrDatatypeRuleToken lv_upperBound_2_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2044:28: ( ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2045:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2045:1: ( ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2045:2: ( (lv_lowerBound_0_0= ruleLOWER ) ) (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2045:2: ( (lv_lowerBound_0_0= ruleLOWER ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2046:1: (lv_lowerBound_0_0= ruleLOWER )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2046:1: (lv_lowerBound_0_0= ruleLOWER )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2047:3: lv_lowerBound_0_0= ruleLOWER
            {
             
            	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getLowerBoundLOWERParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS4625);
            lv_lowerBound_0_0=ruleLOWER();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getMultiplicityBoundsCSRule());
            	        }
                   		set(
                   			current, 
                   			"lowerBound",
                    		lv_lowerBound_0_0, 
                    		"LOWER");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2063:2: (otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==43) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2063:4: otherlv_1= '..' ( (lv_upperBound_2_0= ruleUPPER ) )
                    {
                    otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleMultiplicityBoundsCS4638); 

                        	newLeafNode(otherlv_1, grammarAccess.getMultiplicityBoundsCSAccess().getFullStopFullStopKeyword_1_0());
                        
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2067:1: ( (lv_upperBound_2_0= ruleUPPER ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2068:1: (lv_upperBound_2_0= ruleUPPER )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2068:1: (lv_upperBound_2_0= ruleUPPER )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2069:3: lv_upperBound_2_0= ruleUPPER
                    {
                     
                    	        newCompositeNode(grammarAccess.getMultiplicityBoundsCSAccess().getUpperBoundUPPERParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS4659);
                    lv_upperBound_2_0=ruleUPPER();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getMultiplicityBoundsCSRule());
                    	        }
                           		set(
                           			current, 
                           			"upperBound",
                            		lv_upperBound_2_0, 
                            		"UPPER");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleMultiplicityBoundsCS"


    // $ANTLR start "entryRuleLOWER"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2093:1: entryRuleLOWER returns [String current=null] : iv_ruleLOWER= ruleLOWER EOF ;
    public final String entryRuleLOWER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLOWER = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2094:2: (iv_ruleLOWER= ruleLOWER EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2095:2: iv_ruleLOWER= ruleLOWER EOF
            {
             newCompositeNode(grammarAccess.getLOWERRule()); 
            pushFollow(FOLLOW_ruleLOWER_in_entryRuleLOWER4698);
            iv_ruleLOWER=ruleLOWER();

            state._fsp--;

             current =iv_ruleLOWER.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLOWER4709); 

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
    // $ANTLR end "entryRuleLOWER"


    // $ANTLR start "ruleLOWER"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2102:1: ruleLOWER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleLOWER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2105:28: (this_INT_0= RULE_INT )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2106:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleLOWER4748); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getLOWERAccess().getINTTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleLOWER"


    // $ANTLR start "entryRuleUPPER"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2121:1: entryRuleUPPER returns [String current=null] : iv_ruleUPPER= ruleUPPER EOF ;
    public final String entryRuleUPPER() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUPPER = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2122:2: (iv_ruleUPPER= ruleUPPER EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2123:2: iv_ruleUPPER= ruleUPPER EOF
            {
             newCompositeNode(grammarAccess.getUPPERRule()); 
            pushFollow(FOLLOW_ruleUPPER_in_entryRuleUPPER4793);
            iv_ruleUPPER=ruleUPPER();

            state._fsp--;

             current =iv_ruleUPPER.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUPPER4804); 

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
    // $ANTLR end "entryRuleUPPER"


    // $ANTLR start "ruleUPPER"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2130:1: ruleUPPER returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_INT_0= RULE_INT ;
    public final AntlrDatatypeRuleToken ruleUPPER() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_INT_0=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2133:28: (this_INT_0= RULE_INT )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2134:5: this_INT_0= RULE_INT
            {
            this_INT_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleUPPER4843); 

            		current.merge(this_INT_0);
                
             
                newLeafNode(this_INT_0, grammarAccess.getUPPERAccess().getINTTerminalRuleCall()); 
                

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
    // $ANTLR end "ruleUPPER"


    // $ANTLR start "entryRuleNameSpace"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2151:1: entryRuleNameSpace returns [EObject current=null] : iv_ruleNameSpace= ruleNameSpace EOF ;
    public final EObject entryRuleNameSpace() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNameSpace = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2152:2: (iv_ruleNameSpace= ruleNameSpace EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2153:2: iv_ruleNameSpace= ruleNameSpace EOF
            {
             newCompositeNode(grammarAccess.getNameSpaceRule()); 
            pushFollow(FOLLOW_ruleNameSpace_in_entryRuleNameSpace4889);
            iv_ruleNameSpace=ruleNameSpace();

            state._fsp--;

             current =iv_ruleNameSpace; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNameSpace4899); 

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
    // $ANTLR end "entryRuleNameSpace"


    // $ANTLR start "ruleNameSpace"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2160:1: ruleNameSpace returns [EObject current=null] : ( (lv_ID_0_0= ruleEString ) ) ;
    public final EObject ruleNameSpace() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_ID_0_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2163:28: ( ( (lv_ID_0_0= ruleEString ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2164:1: ( (lv_ID_0_0= ruleEString ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2164:1: ( (lv_ID_0_0= ruleEString ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2165:1: (lv_ID_0_0= ruleEString )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2165:1: (lv_ID_0_0= ruleEString )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2166:3: lv_ID_0_0= ruleEString
            {
             
            	        newCompositeNode(grammarAccess.getNameSpaceAccess().getIDEStringParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleEString_in_ruleNameSpace4944);
            lv_ID_0_0=ruleEString();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNameSpaceRule());
            	        }
                   		set(
                   			current, 
                   			"ID",
                    		lv_ID_0_0, 
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
    // $ANTLR end "ruleNameSpace"


    // $ANTLR start "entryRuleTypeNameExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2190:1: entryRuleTypeNameExpCS returns [EObject current=null] : iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF ;
    public final EObject entryRuleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeNameExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2191:2: (iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2192:2: iv_ruleTypeNameExpCS= ruleTypeNameExpCS EOF
            {
             newCompositeNode(grammarAccess.getTypeNameExpCSRule()); 
            pushFollow(FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS4979);
            iv_ruleTypeNameExpCS=ruleTypeNameExpCS();

            state._fsp--;

             current =iv_ruleTypeNameExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeNameExpCS4989); 

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
    // $ANTLR end "entryRuleTypeNameExpCS"


    // $ANTLR start "ruleTypeNameExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2199:1: ruleTypeNameExpCS returns [EObject current=null] : ( (lv_pathName_0_0= rulePathNameCS ) ) ;
    public final EObject ruleTypeNameExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_pathName_0_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2202:28: ( ( (lv_pathName_0_0= rulePathNameCS ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2203:1: ( (lv_pathName_0_0= rulePathNameCS ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2203:1: ( (lv_pathName_0_0= rulePathNameCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2204:1: (lv_pathName_0_0= rulePathNameCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2204:1: (lv_pathName_0_0= rulePathNameCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2205:3: lv_pathName_0_0= rulePathNameCS
            {
             
            	        newCompositeNode(grammarAccess.getTypeNameExpCSAccess().getPathNamePathNameCSParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS5034);
            lv_pathName_0_0=rulePathNameCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTypeNameExpCSRule());
            	        }
                   		set(
                   			current, 
                   			"pathName",
                    		lv_pathName_0_0, 
                    		"PathNameCS");
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
    // $ANTLR end "ruleTypeNameExpCS"


    // $ANTLR start "entryRulePathNameCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2229:1: entryRulePathNameCS returns [EObject current=null] : iv_rulePathNameCS= rulePathNameCS EOF ;
    public final EObject entryRulePathNameCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePathNameCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2230:2: (iv_rulePathNameCS= rulePathNameCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2231:2: iv_rulePathNameCS= rulePathNameCS EOF
            {
             newCompositeNode(grammarAccess.getPathNameCSRule()); 
            pushFollow(FOLLOW_rulePathNameCS_in_entryRulePathNameCS5069);
            iv_rulePathNameCS=rulePathNameCS();

            state._fsp--;

             current =iv_rulePathNameCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePathNameCS5079); 

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
    // $ANTLR end "entryRulePathNameCS"


    // $ANTLR start "rulePathNameCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2238:1: rulePathNameCS returns [EObject current=null] : ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) ;
    public final EObject rulePathNameCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_path_0_0 = null;

        EObject lv_path_2_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2241:28: ( ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2242:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2242:1: ( ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )* )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2242:2: ( (lv_path_0_0= ruleFirstPathElementCS ) ) (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2242:2: ( (lv_path_0_0= ruleFirstPathElementCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2243:1: (lv_path_0_0= ruleFirstPathElementCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2243:1: (lv_path_0_0= ruleFirstPathElementCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2244:3: lv_path_0_0= ruleFirstPathElementCS
            {
             
            	        newCompositeNode(grammarAccess.getPathNameCSAccess().getPathFirstPathElementCSParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS5125);
            lv_path_0_0=ruleFirstPathElementCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPathNameCSRule());
            	        }
                   		add(
                   			current, 
                   			"path",
                    		lv_path_0_0, 
                    		"FirstPathElementCS");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2260:2: (otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) ) )*
            loop32:
            do {
                int alt32=2;
                int LA32_0 = input.LA(1);

                if ( (LA32_0==44) ) {
                    alt32=1;
                }


                switch (alt32) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2260:4: otherlv_1= '::' ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    {
            	    otherlv_1=(Token)match(input,44,FOLLOW_44_in_rulePathNameCS5138); 

            	        	newLeafNode(otherlv_1, grammarAccess.getPathNameCSAccess().getColonColonKeyword_1_0());
            	        
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2264:1: ( (lv_path_2_0= ruleNextPathElementCS ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2265:1: (lv_path_2_0= ruleNextPathElementCS )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2265:1: (lv_path_2_0= ruleNextPathElementCS )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2266:3: lv_path_2_0= ruleNextPathElementCS
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getPathNameCSAccess().getPathNextPathElementCSParserRuleCall_1_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleNextPathElementCS_in_rulePathNameCS5159);
            	    lv_path_2_0=ruleNextPathElementCS();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getPathNameCSRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"path",
            	            		lv_path_2_0, 
            	            		"NextPathElementCS");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop32;
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
    // $ANTLR end "rulePathNameCS"


    // $ANTLR start "entryRuleFirstPathElementCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2290:1: entryRuleFirstPathElementCS returns [EObject current=null] : iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF ;
    public final EObject entryRuleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFirstPathElementCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2291:2: (iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2292:2: iv_ruleFirstPathElementCS= ruleFirstPathElementCS EOF
            {
             newCompositeNode(grammarAccess.getFirstPathElementCSRule()); 
            pushFollow(FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS5197);
            iv_ruleFirstPathElementCS=ruleFirstPathElementCS();

            state._fsp--;

             current =iv_ruleFirstPathElementCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFirstPathElementCS5207); 

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
    // $ANTLR end "entryRuleFirstPathElementCS"


    // $ANTLR start "ruleFirstPathElementCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2299:1: ruleFirstPathElementCS returns [EObject current=null] : ( ( ruleUnrestrictedName ) ) ;
    public final EObject ruleFirstPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2302:28: ( ( ( ruleUnrestrictedName ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2303:1: ( ( ruleUnrestrictedName ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2303:1: ( ( ruleUnrestrictedName ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2304:1: ( ruleUnrestrictedName )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2304:1: ( ruleUnrestrictedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2305:3: ruleUnrestrictedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getFirstPathElementCSRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getFirstPathElementCSAccess().getElementNamedElementCrossReference_0()); 
            	    
            pushFollow(FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS5254);
            ruleUnrestrictedName();

            state._fsp--;

             
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
    // $ANTLR end "ruleFirstPathElementCS"


    // $ANTLR start "entryRuleNextPathElementCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2326:1: entryRuleNextPathElementCS returns [EObject current=null] : iv_ruleNextPathElementCS= ruleNextPathElementCS EOF ;
    public final EObject entryRuleNextPathElementCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNextPathElementCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2327:2: (iv_ruleNextPathElementCS= ruleNextPathElementCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2328:2: iv_ruleNextPathElementCS= ruleNextPathElementCS EOF
            {
             newCompositeNode(grammarAccess.getNextPathElementCSRule()); 
            pushFollow(FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS5289);
            iv_ruleNextPathElementCS=ruleNextPathElementCS();

            state._fsp--;

             current =iv_ruleNextPathElementCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNextPathElementCS5299); 

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
    // $ANTLR end "entryRuleNextPathElementCS"


    // $ANTLR start "ruleNextPathElementCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2335:1: ruleNextPathElementCS returns [EObject current=null] : ( ( ruleUnreservedName ) ) ;
    public final EObject ruleNextPathElementCS() throws RecognitionException {
        EObject current = null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2338:28: ( ( ( ruleUnreservedName ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2339:1: ( ( ruleUnreservedName ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2339:1: ( ( ruleUnreservedName ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2340:1: ( ruleUnreservedName )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2340:1: ( ruleUnreservedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2341:3: ruleUnreservedName
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getNextPathElementCSRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getNextPathElementCSAccess().getElementNamedElementCrossReference_0()); 
            	    
            pushFollow(FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS5346);
            ruleUnreservedName();

            state._fsp--;

             
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
    // $ANTLR end "ruleNextPathElementCS"


    // $ANTLR start "entryRuleUnreservedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2362:1: entryRuleUnreservedName returns [String current=null] : iv_ruleUnreservedName= ruleUnreservedName EOF ;
    public final String entryRuleUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleUnreservedName = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2363:2: (iv_ruleUnreservedName= ruleUnreservedName EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2364:2: iv_ruleUnreservedName= ruleUnreservedName EOF
            {
             newCompositeNode(grammarAccess.getUnreservedNameRule()); 
            pushFollow(FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName5382);
            iv_ruleUnreservedName=ruleUnreservedName();

            state._fsp--;

             current =iv_ruleUnreservedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnreservedName5393); 

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
    // $ANTLR end "entryRuleUnreservedName"


    // $ANTLR start "ruleUnreservedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2371:1: ruleUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName ;
    public final AntlrDatatypeRuleToken ruleUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        AntlrDatatypeRuleToken this_EssentialOCLUnreservedName_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2374:28: (this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2376:5: this_EssentialOCLUnreservedName_0= ruleEssentialOCLUnreservedName
            {
             
                    newCompositeNode(grammarAccess.getUnreservedNameAccess().getEssentialOCLUnreservedNameParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName5439);
            this_EssentialOCLUnreservedName_0=ruleEssentialOCLUnreservedName();

            state._fsp--;


            		current.merge(this_EssentialOCLUnreservedName_0);
                
             
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
    // $ANTLR end "ruleUnreservedName"


    // $ANTLR start "entryRuleEssentialOCLUnreservedName"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2394:1: entryRuleEssentialOCLUnreservedName returns [String current=null] : iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF ;
    public final String entryRuleEssentialOCLUnreservedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleEssentialOCLUnreservedName = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2395:2: (iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2396:2: iv_ruleEssentialOCLUnreservedName= ruleEssentialOCLUnreservedName EOF
            {
             newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameRule()); 
            pushFollow(FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName5484);
            iv_ruleEssentialOCLUnreservedName=ruleEssentialOCLUnreservedName();

            state._fsp--;

             current =iv_ruleEssentialOCLUnreservedName.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName5495); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2403:1: ruleEssentialOCLUnreservedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) ;
    public final AntlrDatatypeRuleToken ruleEssentialOCLUnreservedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_UnrestrictedName_0 = null;

        AntlrDatatypeRuleToken this_CollectionTypeIdentifier_1 = null;

        AntlrDatatypeRuleToken this_PrimitiveTypeIdentifier_2 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2406:28: ( (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2407:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2407:1: (this_UnrestrictedName_0= ruleUnrestrictedName | this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier | this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier | kw= 'Tuple' )
            int alt33=4;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt33=1;
                }
                break;
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
                {
                alt33=2;
                }
                break;
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
                {
                alt33=3;
                }
                break;
            case 45:
                {
                alt33=4;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }

            switch (alt33) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2408:5: this_UnrestrictedName_0= ruleUnrestrictedName
                    {
                     
                            newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getUnrestrictedNameParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName5542);
                    this_UnrestrictedName_0=ruleUnrestrictedName();

                    state._fsp--;


                    		current.merge(this_UnrestrictedName_0);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2420:5: this_CollectionTypeIdentifier_1= ruleCollectionTypeIdentifier
                    {
                     
                            newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getCollectionTypeIdentifierParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName5575);
                    this_CollectionTypeIdentifier_1=ruleCollectionTypeIdentifier();

                    state._fsp--;


                    		current.merge(this_CollectionTypeIdentifier_1);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2432:5: this_PrimitiveTypeIdentifier_2= rulePrimitiveTypeIdentifier
                    {
                     
                            newCompositeNode(grammarAccess.getEssentialOCLUnreservedNameAccess().getPrimitiveTypeIdentifierParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName5608);
                    this_PrimitiveTypeIdentifier_2=rulePrimitiveTypeIdentifier();

                    state._fsp--;


                    		current.merge(this_PrimitiveTypeIdentifier_2);
                        
                     
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2444:2: kw= 'Tuple'
                    {
                    kw=(Token)match(input,45,FOLLOW_45_in_ruleEssentialOCLUnreservedName5632); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getEssentialOCLUnreservedNameAccess().getTupleKeyword_3()); 
                        

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
    // $ANTLR end "ruleEssentialOCLUnreservedName"


    // $ANTLR start "entryRulePrimitiveTypeIdentifier"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2457:1: entryRulePrimitiveTypeIdentifier returns [String current=null] : iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF ;
    public final String entryRulePrimitiveTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_rulePrimitiveTypeIdentifier = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2458:2: (iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2459:2: iv_rulePrimitiveTypeIdentifier= rulePrimitiveTypeIdentifier EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveTypeIdentifierRule()); 
            pushFollow(FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier5673);
            iv_rulePrimitiveTypeIdentifier=rulePrimitiveTypeIdentifier();

            state._fsp--;

             current =iv_rulePrimitiveTypeIdentifier.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier5684); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2466:1: rulePrimitiveTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) ;
    public final AntlrDatatypeRuleToken rulePrimitiveTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2469:28: ( (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2470:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2470:1: (kw= 'Boolean' | kw= 'Integer' | kw= 'Real' | kw= 'String' | kw= 'UnlimitedNatural' | kw= 'OclAny' | kw= 'OclInvalid' | kw= 'OclVoid' )
            int alt34=8;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt34=1;
                }
                break;
            case 47:
                {
                alt34=2;
                }
                break;
            case 48:
                {
                alt34=3;
                }
                break;
            case 49:
                {
                alt34=4;
                }
                break;
            case 50:
                {
                alt34=5;
                }
                break;
            case 51:
                {
                alt34=6;
                }
                break;
            case 52:
                {
                alt34=7;
                }
                break;
            case 53:
                {
                alt34=8;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2471:2: kw= 'Boolean'
                    {
                    kw=(Token)match(input,46,FOLLOW_46_in_rulePrimitiveTypeIdentifier5722); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getBooleanKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2478:2: kw= 'Integer'
                    {
                    kw=(Token)match(input,47,FOLLOW_47_in_rulePrimitiveTypeIdentifier5741); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getIntegerKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2485:2: kw= 'Real'
                    {
                    kw=(Token)match(input,48,FOLLOW_48_in_rulePrimitiveTypeIdentifier5760); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getRealKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2492:2: kw= 'String'
                    {
                    kw=(Token)match(input,49,FOLLOW_49_in_rulePrimitiveTypeIdentifier5779); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getStringKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2499:2: kw= 'UnlimitedNatural'
                    {
                    kw=(Token)match(input,50,FOLLOW_50_in_rulePrimitiveTypeIdentifier5798); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getUnlimitedNaturalKeyword_4()); 
                        

                    }
                    break;
                case 6 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2506:2: kw= 'OclAny'
                    {
                    kw=(Token)match(input,51,FOLLOW_51_in_rulePrimitiveTypeIdentifier5817); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclAnyKeyword_5()); 
                        

                    }
                    break;
                case 7 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2513:2: kw= 'OclInvalid'
                    {
                    kw=(Token)match(input,52,FOLLOW_52_in_rulePrimitiveTypeIdentifier5836); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclInvalidKeyword_6()); 
                        

                    }
                    break;
                case 8 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2520:2: kw= 'OclVoid'
                    {
                    kw=(Token)match(input,53,FOLLOW_53_in_rulePrimitiveTypeIdentifier5855); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getPrimitiveTypeIdentifierAccess().getOclVoidKeyword_7()); 
                        

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
    // $ANTLR end "rulePrimitiveTypeIdentifier"


    // $ANTLR start "entryRuleCollectionTypeIdentifier"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2533:1: entryRuleCollectionTypeIdentifier returns [String current=null] : iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF ;
    public final String entryRuleCollectionTypeIdentifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleCollectionTypeIdentifier = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2534:2: (iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2535:2: iv_ruleCollectionTypeIdentifier= ruleCollectionTypeIdentifier EOF
            {
             newCompositeNode(grammarAccess.getCollectionTypeIdentifierRule()); 
            pushFollow(FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier5896);
            iv_ruleCollectionTypeIdentifier=ruleCollectionTypeIdentifier();

            state._fsp--;

             current =iv_ruleCollectionTypeIdentifier.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier5907); 

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
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2542:1: ruleCollectionTypeIdentifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) ;
    public final AntlrDatatypeRuleToken ruleCollectionTypeIdentifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2545:28: ( (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2546:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2546:1: (kw= 'Set' | kw= 'Bag' | kw= 'Sequence' | kw= 'Collection' | kw= 'OrderedSet' )
            int alt35=5;
            switch ( input.LA(1) ) {
            case 54:
                {
                alt35=1;
                }
                break;
            case 55:
                {
                alt35=2;
                }
                break;
            case 56:
                {
                alt35=3;
                }
                break;
            case 57:
                {
                alt35=4;
                }
                break;
            case 58:
                {
                alt35=5;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }

            switch (alt35) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2547:2: kw= 'Set'
                    {
                    kw=(Token)match(input,54,FOLLOW_54_in_ruleCollectionTypeIdentifier5945); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSetKeyword_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2554:2: kw= 'Bag'
                    {
                    kw=(Token)match(input,55,FOLLOW_55_in_ruleCollectionTypeIdentifier5964); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getBagKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2561:2: kw= 'Sequence'
                    {
                    kw=(Token)match(input,56,FOLLOW_56_in_ruleCollectionTypeIdentifier5983); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getSequenceKeyword_2()); 
                        

                    }
                    break;
                case 4 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2568:2: kw= 'Collection'
                    {
                    kw=(Token)match(input,57,FOLLOW_57_in_ruleCollectionTypeIdentifier6002); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getCollectionKeyword_3()); 
                        

                    }
                    break;
                case 5 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2575:2: kw= 'OrderedSet'
                    {
                    kw=(Token)match(input,58,FOLLOW_58_in_ruleCollectionTypeIdentifier6021); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getCollectionTypeIdentifierAccess().getOrderedSetKeyword_4()); 
                        

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
    // $ANTLR end "ruleCollectionTypeIdentifier"


    // $ANTLR start "entryRuleSpecificationCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2588:1: entryRuleSpecificationCS returns [EObject current=null] : iv_ruleSpecificationCS= ruleSpecificationCS EOF ;
    public final EObject entryRuleSpecificationCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSpecificationCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2589:2: (iv_ruleSpecificationCS= ruleSpecificationCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2590:2: iv_ruleSpecificationCS= ruleSpecificationCS EOF
            {
             newCompositeNode(grammarAccess.getSpecificationCSRule()); 
            pushFollow(FOLLOW_ruleSpecificationCS_in_entryRuleSpecificationCS6061);
            iv_ruleSpecificationCS=ruleSpecificationCS();

            state._fsp--;

             current =iv_ruleSpecificationCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSpecificationCS6071); 

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
    // $ANTLR end "entryRuleSpecificationCS"


    // $ANTLR start "ruleSpecificationCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2597:1: ruleSpecificationCS returns [EObject current=null] : ( ( (lv_ownedExpression_0_0= ruleContextCs ) ) | ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) ) ) ;
    public final EObject ruleSpecificationCS() throws RecognitionException {
        EObject current = null;

        Token lv_exprString_1_0=null;
        EObject lv_ownedExpression_0_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2600:28: ( ( ( (lv_ownedExpression_0_0= ruleContextCs ) ) | ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2601:1: ( ( (lv_ownedExpression_0_0= ruleContextCs ) ) | ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2601:1: ( ( (lv_ownedExpression_0_0= ruleContextCs ) ) | ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==RULE_ID||LA36_0==16||(LA36_0>=28 && LA36_0<=29)||LA36_0==32||(LA36_0>=39 && LA36_0<=41)||(LA36_0>=59 && LA36_0<=68)||LA36_0==71) ) {
                alt36=1;
            }
            else if ( (LA36_0==RULE_UNQUOTED_STRING) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2601:2: ( (lv_ownedExpression_0_0= ruleContextCs ) )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2601:2: ( (lv_ownedExpression_0_0= ruleContextCs ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2602:1: (lv_ownedExpression_0_0= ruleContextCs )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2602:1: (lv_ownedExpression_0_0= ruleContextCs )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2603:3: lv_ownedExpression_0_0= ruleContextCs
                    {
                     
                    	        newCompositeNode(grammarAccess.getSpecificationCSAccess().getOwnedExpressionContextCsParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleContextCs_in_ruleSpecificationCS6117);
                    lv_ownedExpression_0_0=ruleContextCs();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getSpecificationCSRule());
                    	        }
                           		add(
                           			current, 
                           			"ownedExpression",
                            		lv_ownedExpression_0_0, 
                            		"ContextCs");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2620:6: ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2620:6: ( (lv_exprString_1_0= RULE_UNQUOTED_STRING ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2621:1: (lv_exprString_1_0= RULE_UNQUOTED_STRING )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2621:1: (lv_exprString_1_0= RULE_UNQUOTED_STRING )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2622:3: lv_exprString_1_0= RULE_UNQUOTED_STRING
                    {
                    lv_exprString_1_0=(Token)match(input,RULE_UNQUOTED_STRING,FOLLOW_RULE_UNQUOTED_STRING_in_ruleSpecificationCS6140); 

                    			newLeafNode(lv_exprString_1_0, grammarAccess.getSpecificationCSAccess().getExprStringUNQUOTED_STRINGTerminalRuleCall_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getSpecificationCSRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"exprString",
                            		lv_exprString_1_0, 
                            		"UNQUOTED_STRING");
                    	    

                    }


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
    // $ANTLR end "ruleSpecificationCS"


    // $ANTLR start "entryRuleEssentialOCLInfixOperatorCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2646:1: entryRuleEssentialOCLInfixOperatorCS returns [EObject current=null] : iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF ;
    public final EObject entryRuleEssentialOCLInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLInfixOperatorCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2647:2: (iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2648:2: iv_ruleEssentialOCLInfixOperatorCS= ruleEssentialOCLInfixOperatorCS EOF
            {
             newCompositeNode(grammarAccess.getEssentialOCLInfixOperatorCSRule()); 
            pushFollow(FOLLOW_ruleEssentialOCLInfixOperatorCS_in_entryRuleEssentialOCLInfixOperatorCS6181);
            iv_ruleEssentialOCLInfixOperatorCS=ruleEssentialOCLInfixOperatorCS();

            state._fsp--;

             current =iv_ruleEssentialOCLInfixOperatorCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperatorCS6191); 

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
    // $ANTLR end "entryRuleEssentialOCLInfixOperatorCS"


    // $ANTLR start "ruleEssentialOCLInfixOperatorCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2655:1: ruleEssentialOCLInfixOperatorCS returns [EObject current=null] : ( () ( ( (lv_name_1_1= '*' | lv_name_1_2= '/' | lv_name_1_3= '+' | lv_name_1_4= '-' | lv_name_1_5= '>' | lv_name_1_6= '<' | lv_name_1_7= '>=' | lv_name_1_8= '<=' | lv_name_1_9= '=' | lv_name_1_10= '<>' | lv_name_1_11= 'and' | lv_name_1_12= 'or' | lv_name_1_13= 'xor' | lv_name_1_14= 'implies' ) ) ) ) ;
    public final EObject ruleEssentialOCLInfixOperatorCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_1_1=null;
        Token lv_name_1_2=null;
        Token lv_name_1_3=null;
        Token lv_name_1_4=null;
        Token lv_name_1_5=null;
        Token lv_name_1_6=null;
        Token lv_name_1_7=null;
        Token lv_name_1_8=null;
        Token lv_name_1_9=null;
        Token lv_name_1_10=null;
        Token lv_name_1_11=null;
        Token lv_name_1_12=null;
        Token lv_name_1_13=null;
        Token lv_name_1_14=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2658:28: ( ( () ( ( (lv_name_1_1= '*' | lv_name_1_2= '/' | lv_name_1_3= '+' | lv_name_1_4= '-' | lv_name_1_5= '>' | lv_name_1_6= '<' | lv_name_1_7= '>=' | lv_name_1_8= '<=' | lv_name_1_9= '=' | lv_name_1_10= '<>' | lv_name_1_11= 'and' | lv_name_1_12= 'or' | lv_name_1_13= 'xor' | lv_name_1_14= 'implies' ) ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2659:1: ( () ( ( (lv_name_1_1= '*' | lv_name_1_2= '/' | lv_name_1_3= '+' | lv_name_1_4= '-' | lv_name_1_5= '>' | lv_name_1_6= '<' | lv_name_1_7= '>=' | lv_name_1_8= '<=' | lv_name_1_9= '=' | lv_name_1_10= '<>' | lv_name_1_11= 'and' | lv_name_1_12= 'or' | lv_name_1_13= 'xor' | lv_name_1_14= 'implies' ) ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2659:1: ( () ( ( (lv_name_1_1= '*' | lv_name_1_2= '/' | lv_name_1_3= '+' | lv_name_1_4= '-' | lv_name_1_5= '>' | lv_name_1_6= '<' | lv_name_1_7= '>=' | lv_name_1_8= '<=' | lv_name_1_9= '=' | lv_name_1_10= '<>' | lv_name_1_11= 'and' | lv_name_1_12= 'or' | lv_name_1_13= 'xor' | lv_name_1_14= 'implies' ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2659:2: () ( ( (lv_name_1_1= '*' | lv_name_1_2= '/' | lv_name_1_3= '+' | lv_name_1_4= '-' | lv_name_1_5= '>' | lv_name_1_6= '<' | lv_name_1_7= '>=' | lv_name_1_8= '<=' | lv_name_1_9= '=' | lv_name_1_10= '<>' | lv_name_1_11= 'and' | lv_name_1_12= 'or' | lv_name_1_13= 'xor' | lv_name_1_14= 'implies' ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2659:2: ()
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2660:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getEssentialOCLInfixOperatorCSAccess().getEssentialOCLInfixOperatorCSAction_0(),
                        current);
                

            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2665:2: ( ( (lv_name_1_1= '*' | lv_name_1_2= '/' | lv_name_1_3= '+' | lv_name_1_4= '-' | lv_name_1_5= '>' | lv_name_1_6= '<' | lv_name_1_7= '>=' | lv_name_1_8= '<=' | lv_name_1_9= '=' | lv_name_1_10= '<>' | lv_name_1_11= 'and' | lv_name_1_12= 'or' | lv_name_1_13= 'xor' | lv_name_1_14= 'implies' ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2666:1: ( (lv_name_1_1= '*' | lv_name_1_2= '/' | lv_name_1_3= '+' | lv_name_1_4= '-' | lv_name_1_5= '>' | lv_name_1_6= '<' | lv_name_1_7= '>=' | lv_name_1_8= '<=' | lv_name_1_9= '=' | lv_name_1_10= '<>' | lv_name_1_11= 'and' | lv_name_1_12= 'or' | lv_name_1_13= 'xor' | lv_name_1_14= 'implies' ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2666:1: ( (lv_name_1_1= '*' | lv_name_1_2= '/' | lv_name_1_3= '+' | lv_name_1_4= '-' | lv_name_1_5= '>' | lv_name_1_6= '<' | lv_name_1_7= '>=' | lv_name_1_8= '<=' | lv_name_1_9= '=' | lv_name_1_10= '<>' | lv_name_1_11= 'and' | lv_name_1_12= 'or' | lv_name_1_13= 'xor' | lv_name_1_14= 'implies' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2667:1: (lv_name_1_1= '*' | lv_name_1_2= '/' | lv_name_1_3= '+' | lv_name_1_4= '-' | lv_name_1_5= '>' | lv_name_1_6= '<' | lv_name_1_7= '>=' | lv_name_1_8= '<=' | lv_name_1_9= '=' | lv_name_1_10= '<>' | lv_name_1_11= 'and' | lv_name_1_12= 'or' | lv_name_1_13= 'xor' | lv_name_1_14= 'implies' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2667:1: (lv_name_1_1= '*' | lv_name_1_2= '/' | lv_name_1_3= '+' | lv_name_1_4= '-' | lv_name_1_5= '>' | lv_name_1_6= '<' | lv_name_1_7= '>=' | lv_name_1_8= '<=' | lv_name_1_9= '=' | lv_name_1_10= '<>' | lv_name_1_11= 'and' | lv_name_1_12= 'or' | lv_name_1_13= 'xor' | lv_name_1_14= 'implies' )
            int alt37=14;
            switch ( input.LA(1) ) {
            case 40:
                {
                alt37=1;
                }
                break;
            case 59:
                {
                alt37=2;
                }
                break;
            case 41:
                {
                alt37=3;
                }
                break;
            case 32:
                {
                alt37=4;
                }
                break;
            case 60:
                {
                alt37=5;
                }
                break;
            case 61:
                {
                alt37=6;
                }
                break;
            case 62:
                {
                alt37=7;
                }
                break;
            case 63:
                {
                alt37=8;
                }
                break;
            case 39:
                {
                alt37=9;
                }
                break;
            case 64:
                {
                alt37=10;
                }
                break;
            case 28:
                {
                alt37=11;
                }
                break;
            case 29:
                {
                alt37=12;
                }
                break;
            case 65:
                {
                alt37=13;
                }
                break;
            case 66:
                {
                alt37=14;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 37, 0, input);

                throw nvae;
            }

            switch (alt37) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2668:3: lv_name_1_1= '*'
                    {
                    lv_name_1_1=(Token)match(input,40,FOLLOW_40_in_ruleEssentialOCLInfixOperatorCS6245); 

                            newLeafNode(lv_name_1_1, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameAsteriskKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2680:8: lv_name_1_2= '/'
                    {
                    lv_name_1_2=(Token)match(input,59,FOLLOW_59_in_ruleEssentialOCLInfixOperatorCS6274); 

                            newLeafNode(lv_name_1_2, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameSolidusKeyword_1_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_2, null);
                    	    

                    }
                    break;
                case 3 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2692:8: lv_name_1_3= '+'
                    {
                    lv_name_1_3=(Token)match(input,41,FOLLOW_41_in_ruleEssentialOCLInfixOperatorCS6303); 

                            newLeafNode(lv_name_1_3, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNamePlusSignKeyword_1_0_2());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_3, null);
                    	    

                    }
                    break;
                case 4 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2704:8: lv_name_1_4= '-'
                    {
                    lv_name_1_4=(Token)match(input,32,FOLLOW_32_in_ruleEssentialOCLInfixOperatorCS6332); 

                            newLeafNode(lv_name_1_4, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameHyphenMinusKeyword_1_0_3());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_4, null);
                    	    

                    }
                    break;
                case 5 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2716:8: lv_name_1_5= '>'
                    {
                    lv_name_1_5=(Token)match(input,60,FOLLOW_60_in_ruleEssentialOCLInfixOperatorCS6361); 

                            newLeafNode(lv_name_1_5, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameGreaterThanSignKeyword_1_0_4());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_5, null);
                    	    

                    }
                    break;
                case 6 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2728:8: lv_name_1_6= '<'
                    {
                    lv_name_1_6=(Token)match(input,61,FOLLOW_61_in_ruleEssentialOCLInfixOperatorCS6390); 

                            newLeafNode(lv_name_1_6, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameLessThanSignKeyword_1_0_5());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_6, null);
                    	    

                    }
                    break;
                case 7 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2740:8: lv_name_1_7= '>='
                    {
                    lv_name_1_7=(Token)match(input,62,FOLLOW_62_in_ruleEssentialOCLInfixOperatorCS6419); 

                            newLeafNode(lv_name_1_7, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameGreaterThanSignEqualsSignKeyword_1_0_6());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_7, null);
                    	    

                    }
                    break;
                case 8 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2752:8: lv_name_1_8= '<='
                    {
                    lv_name_1_8=(Token)match(input,63,FOLLOW_63_in_ruleEssentialOCLInfixOperatorCS6448); 

                            newLeafNode(lv_name_1_8, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameLessThanSignEqualsSignKeyword_1_0_7());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_8, null);
                    	    

                    }
                    break;
                case 9 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2764:8: lv_name_1_9= '='
                    {
                    lv_name_1_9=(Token)match(input,39,FOLLOW_39_in_ruleEssentialOCLInfixOperatorCS6477); 

                            newLeafNode(lv_name_1_9, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameEqualsSignKeyword_1_0_8());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_9, null);
                    	    

                    }
                    break;
                case 10 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2776:8: lv_name_1_10= '<>'
                    {
                    lv_name_1_10=(Token)match(input,64,FOLLOW_64_in_ruleEssentialOCLInfixOperatorCS6506); 

                            newLeafNode(lv_name_1_10, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameLessThanSignGreaterThanSignKeyword_1_0_9());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_10, null);
                    	    

                    }
                    break;
                case 11 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2788:8: lv_name_1_11= 'and'
                    {
                    lv_name_1_11=(Token)match(input,28,FOLLOW_28_in_ruleEssentialOCLInfixOperatorCS6535); 

                            newLeafNode(lv_name_1_11, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameAndKeyword_1_0_10());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_11, null);
                    	    

                    }
                    break;
                case 12 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2800:8: lv_name_1_12= 'or'
                    {
                    lv_name_1_12=(Token)match(input,29,FOLLOW_29_in_ruleEssentialOCLInfixOperatorCS6564); 

                            newLeafNode(lv_name_1_12, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameOrKeyword_1_0_11());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_12, null);
                    	    

                    }
                    break;
                case 13 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2812:8: lv_name_1_13= 'xor'
                    {
                    lv_name_1_13=(Token)match(input,65,FOLLOW_65_in_ruleEssentialOCLInfixOperatorCS6593); 

                            newLeafNode(lv_name_1_13, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameXorKeyword_1_0_12());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_13, null);
                    	    

                    }
                    break;
                case 14 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2824:8: lv_name_1_14= 'implies'
                    {
                    lv_name_1_14=(Token)match(input,66,FOLLOW_66_in_ruleEssentialOCLInfixOperatorCS6622); 

                            newLeafNode(lv_name_1_14, grammarAccess.getEssentialOCLInfixOperatorCSAccess().getNameImpliesKeyword_1_0_13());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEssentialOCLInfixOperatorCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_14, null);
                    	    

                    }
                    break;

            }


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
    // $ANTLR end "ruleEssentialOCLInfixOperatorCS"


    // $ANTLR start "entryRuleBinaryOperatorCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2847:1: entryRuleBinaryOperatorCS returns [EObject current=null] : iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF ;
    public final EObject entryRuleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBinaryOperatorCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2848:2: (iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2849:2: iv_ruleBinaryOperatorCS= ruleBinaryOperatorCS EOF
            {
             newCompositeNode(grammarAccess.getBinaryOperatorCSRule()); 
            pushFollow(FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS6674);
            iv_ruleBinaryOperatorCS=ruleBinaryOperatorCS();

            state._fsp--;

             current =iv_ruleBinaryOperatorCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBinaryOperatorCS6684); 

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
    // $ANTLR end "entryRuleBinaryOperatorCS"


    // $ANTLR start "ruleBinaryOperatorCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2856:1: ruleBinaryOperatorCS returns [EObject current=null] : (this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) ;
    public final EObject ruleBinaryOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject this_EssentialOCLInfixOperatorCS_0 = null;

        EObject this_NavigationOperatorCS_1 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2859:28: ( (this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2860:1: (this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2860:1: (this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS | this_NavigationOperatorCS_1= ruleNavigationOperatorCS )
            int alt38=2;
            int LA38_0 = input.LA(1);

            if ( ((LA38_0>=28 && LA38_0<=29)||LA38_0==32||(LA38_0>=39 && LA38_0<=41)||(LA38_0>=59 && LA38_0<=66)) ) {
                alt38=1;
            }
            else if ( (LA38_0==16||LA38_0==67) ) {
                alt38=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 38, 0, input);

                throw nvae;
            }
            switch (alt38) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2861:5: this_EssentialOCLInfixOperatorCS_0= ruleEssentialOCLInfixOperatorCS
                    {
                     
                            newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getEssentialOCLInfixOperatorCSParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleEssentialOCLInfixOperatorCS_in_ruleBinaryOperatorCS6731);
                    this_EssentialOCLInfixOperatorCS_0=ruleEssentialOCLInfixOperatorCS();

                    state._fsp--;

                     
                            current = this_EssentialOCLInfixOperatorCS_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2871:5: this_NavigationOperatorCS_1= ruleNavigationOperatorCS
                    {
                     
                            newCompositeNode(grammarAccess.getBinaryOperatorCSAccess().getNavigationOperatorCSParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS6758);
                    this_NavigationOperatorCS_1=ruleNavigationOperatorCS();

                    state._fsp--;

                     
                            current = this_NavigationOperatorCS_1; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleBinaryOperatorCS"


    // $ANTLR start "entryRuleNavigationOperatorCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2887:1: entryRuleNavigationOperatorCS returns [EObject current=null] : iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF ;
    public final EObject entryRuleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigationOperatorCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2888:2: (iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2889:2: iv_ruleNavigationOperatorCS= ruleNavigationOperatorCS EOF
            {
             newCompositeNode(grammarAccess.getNavigationOperatorCSRule()); 
            pushFollow(FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS6793);
            iv_ruleNavigationOperatorCS=ruleNavigationOperatorCS();

            state._fsp--;

             current =iv_ruleNavigationOperatorCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNavigationOperatorCS6803); 

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
    // $ANTLR end "entryRuleNavigationOperatorCS"


    // $ANTLR start "ruleNavigationOperatorCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2896:1: ruleNavigationOperatorCS returns [EObject current=null] : ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) ;
    public final EObject ruleNavigationOperatorCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2899:28: ( ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2900:1: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2900:1: ( ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2901:1: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2901:1: ( (lv_name_0_1= '.' | lv_name_0_2= '->' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2902:1: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2902:1: (lv_name_0_1= '.' | lv_name_0_2= '->' )
            int alt39=2;
            int LA39_0 = input.LA(1);

            if ( (LA39_0==16) ) {
                alt39=1;
            }
            else if ( (LA39_0==67) ) {
                alt39=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }
            switch (alt39) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2903:3: lv_name_0_1= '.'
                    {
                    lv_name_0_1=(Token)match(input,16,FOLLOW_16_in_ruleNavigationOperatorCS6847); 

                            newLeafNode(lv_name_0_1, grammarAccess.getNavigationOperatorCSAccess().getNameFullStopKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getNavigationOperatorCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2915:8: lv_name_0_2= '->'
                    {
                    lv_name_0_2=(Token)match(input,67,FOLLOW_67_in_ruleNavigationOperatorCS6876); 

                            newLeafNode(lv_name_0_2, grammarAccess.getNavigationOperatorCSAccess().getNameHyphenMinusGreaterThanSignKeyword_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getNavigationOperatorCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_2, null);
                    	    

                    }
                    break;

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
    // $ANTLR end "ruleNavigationOperatorCS"


    // $ANTLR start "entryRuleContextCs"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2938:1: entryRuleContextCs returns [EObject current=null] : iv_ruleContextCs= ruleContextCs EOF ;
    public final EObject entryRuleContextCs() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleContextCs = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2939:2: (iv_ruleContextCs= ruleContextCs EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2940:2: iv_ruleContextCs= ruleContextCs EOF
            {
             newCompositeNode(grammarAccess.getContextCsRule()); 
            pushFollow(FOLLOW_ruleContextCs_in_entryRuleContextCs6927);
            iv_ruleContextCs=ruleContextCs();

            state._fsp--;

             current =iv_ruleContextCs; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleContextCs6937); 

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
    // $ANTLR end "entryRuleContextCs"


    // $ANTLR start "ruleContextCs"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2947:1: ruleContextCs returns [EObject current=null] : ( ( (lv_ownedExpression_0_0= ruleLetExpCS ) ) | ( ( (lv_B_1_0= ruleBinaryOperatorCS ) )? ( (otherlv_2= 'self.' )? this_ID_3= RULE_ID ( (lv_BO_4_0= ruleBinaryOperatorCS ) ) (otherlv_5= 'self.' )? this_ID_6= RULE_ID ) ) ) ;
    public final EObject ruleContextCs() throws RecognitionException {
        EObject current = null;

        Token otherlv_2=null;
        Token this_ID_3=null;
        Token otherlv_5=null;
        Token this_ID_6=null;
        EObject lv_ownedExpression_0_0 = null;

        EObject lv_B_1_0 = null;

        EObject lv_BO_4_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2950:28: ( ( ( (lv_ownedExpression_0_0= ruleLetExpCS ) ) | ( ( (lv_B_1_0= ruleBinaryOperatorCS ) )? ( (otherlv_2= 'self.' )? this_ID_3= RULE_ID ( (lv_BO_4_0= ruleBinaryOperatorCS ) ) (otherlv_5= 'self.' )? this_ID_6= RULE_ID ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2951:1: ( ( (lv_ownedExpression_0_0= ruleLetExpCS ) ) | ( ( (lv_B_1_0= ruleBinaryOperatorCS ) )? ( (otherlv_2= 'self.' )? this_ID_3= RULE_ID ( (lv_BO_4_0= ruleBinaryOperatorCS ) ) (otherlv_5= 'self.' )? this_ID_6= RULE_ID ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2951:1: ( ( (lv_ownedExpression_0_0= ruleLetExpCS ) ) | ( ( (lv_B_1_0= ruleBinaryOperatorCS ) )? ( (otherlv_2= 'self.' )? this_ID_3= RULE_ID ( (lv_BO_4_0= ruleBinaryOperatorCS ) ) (otherlv_5= 'self.' )? this_ID_6= RULE_ID ) ) )
            int alt43=2;
            int LA43_0 = input.LA(1);

            if ( (LA43_0==71) ) {
                alt43=1;
            }
            else if ( (LA43_0==RULE_ID||LA43_0==16||(LA43_0>=28 && LA43_0<=29)||LA43_0==32||(LA43_0>=39 && LA43_0<=41)||(LA43_0>=59 && LA43_0<=68)) ) {
                alt43=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 43, 0, input);

                throw nvae;
            }
            switch (alt43) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2951:2: ( (lv_ownedExpression_0_0= ruleLetExpCS ) )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2951:2: ( (lv_ownedExpression_0_0= ruleLetExpCS ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2952:1: (lv_ownedExpression_0_0= ruleLetExpCS )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2952:1: (lv_ownedExpression_0_0= ruleLetExpCS )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2953:3: lv_ownedExpression_0_0= ruleLetExpCS
                    {
                     
                    	        newCompositeNode(grammarAccess.getContextCsAccess().getOwnedExpressionLetExpCSParserRuleCall_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLetExpCS_in_ruleContextCs6983);
                    lv_ownedExpression_0_0=ruleLetExpCS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContextCsRule());
                    	        }
                           		add(
                           			current, 
                           			"ownedExpression",
                            		lv_ownedExpression_0_0, 
                            		"LetExpCS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2970:6: ( ( (lv_B_1_0= ruleBinaryOperatorCS ) )? ( (otherlv_2= 'self.' )? this_ID_3= RULE_ID ( (lv_BO_4_0= ruleBinaryOperatorCS ) ) (otherlv_5= 'self.' )? this_ID_6= RULE_ID ) )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2970:6: ( ( (lv_B_1_0= ruleBinaryOperatorCS ) )? ( (otherlv_2= 'self.' )? this_ID_3= RULE_ID ( (lv_BO_4_0= ruleBinaryOperatorCS ) ) (otherlv_5= 'self.' )? this_ID_6= RULE_ID ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2970:7: ( (lv_B_1_0= ruleBinaryOperatorCS ) )? ( (otherlv_2= 'self.' )? this_ID_3= RULE_ID ( (lv_BO_4_0= ruleBinaryOperatorCS ) ) (otherlv_5= 'self.' )? this_ID_6= RULE_ID )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2970:7: ( (lv_B_1_0= ruleBinaryOperatorCS ) )?
                    int alt40=2;
                    int LA40_0 = input.LA(1);

                    if ( (LA40_0==16||(LA40_0>=28 && LA40_0<=29)||LA40_0==32||(LA40_0>=39 && LA40_0<=41)||(LA40_0>=59 && LA40_0<=67)) ) {
                        alt40=1;
                    }
                    switch (alt40) {
                        case 1 :
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2971:1: (lv_B_1_0= ruleBinaryOperatorCS )
                            {
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2971:1: (lv_B_1_0= ruleBinaryOperatorCS )
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2972:3: lv_B_1_0= ruleBinaryOperatorCS
                            {
                             
                            	        newCompositeNode(grammarAccess.getContextCsAccess().getBBinaryOperatorCSParserRuleCall_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleBinaryOperatorCS_in_ruleContextCs7011);
                            lv_B_1_0=ruleBinaryOperatorCS();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getContextCsRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"B",
                                    		lv_B_1_0, 
                                    		"BinaryOperatorCS");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }
                            break;

                    }

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2988:3: ( (otherlv_2= 'self.' )? this_ID_3= RULE_ID ( (lv_BO_4_0= ruleBinaryOperatorCS ) ) (otherlv_5= 'self.' )? this_ID_6= RULE_ID )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2988:4: (otherlv_2= 'self.' )? this_ID_3= RULE_ID ( (lv_BO_4_0= ruleBinaryOperatorCS ) ) (otherlv_5= 'self.' )? this_ID_6= RULE_ID
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2988:4: (otherlv_2= 'self.' )?
                    int alt41=2;
                    int LA41_0 = input.LA(1);

                    if ( (LA41_0==68) ) {
                        alt41=1;
                    }
                    switch (alt41) {
                        case 1 :
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2988:6: otherlv_2= 'self.'
                            {
                            otherlv_2=(Token)match(input,68,FOLLOW_68_in_ruleContextCs7026); 

                                	newLeafNode(otherlv_2, grammarAccess.getContextCsAccess().getSelfKeyword_1_1_0());
                                

                            }
                            break;

                    }

                    this_ID_3=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContextCs7039); 
                     
                        newLeafNode(this_ID_3, grammarAccess.getContextCsAccess().getIDTerminalRuleCall_1_1_1()); 
                        
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2996:1: ( (lv_BO_4_0= ruleBinaryOperatorCS ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2997:1: (lv_BO_4_0= ruleBinaryOperatorCS )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2997:1: (lv_BO_4_0= ruleBinaryOperatorCS )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:2998:3: lv_BO_4_0= ruleBinaryOperatorCS
                    {
                     
                    	        newCompositeNode(grammarAccess.getContextCsAccess().getBOBinaryOperatorCSParserRuleCall_1_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_ruleBinaryOperatorCS_in_ruleContextCs7059);
                    lv_BO_4_0=ruleBinaryOperatorCS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getContextCsRule());
                    	        }
                           		set(
                           			current, 
                           			"BO",
                            		lv_BO_4_0, 
                            		"BinaryOperatorCS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3014:2: (otherlv_5= 'self.' )?
                    int alt42=2;
                    int LA42_0 = input.LA(1);

                    if ( (LA42_0==68) ) {
                        alt42=1;
                    }
                    switch (alt42) {
                        case 1 :
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3014:4: otherlv_5= 'self.'
                            {
                            otherlv_5=(Token)match(input,68,FOLLOW_68_in_ruleContextCs7072); 

                                	newLeafNode(otherlv_5, grammarAccess.getContextCsAccess().getSelfKeyword_1_1_3());
                                

                            }
                            break;

                    }

                    this_ID_6=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleContextCs7085); 
                     
                        newLeafNode(this_ID_6, grammarAccess.getContextCsAccess().getIDTerminalRuleCall_1_1_4()); 
                        

                    }


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
    // $ANTLR end "ruleContextCs"


    // $ANTLR start "entryRuleExpressCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3030:1: entryRuleExpressCS returns [EObject current=null] : iv_ruleExpressCS= ruleExpressCS EOF ;
    public final EObject entryRuleExpressCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpressCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3031:2: (iv_ruleExpressCS= ruleExpressCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3032:2: iv_ruleExpressCS= ruleExpressCS EOF
            {
             newCompositeNode(grammarAccess.getExpressCSRule()); 
            pushFollow(FOLLOW_ruleExpressCS_in_entryRuleExpressCS7122);
            iv_ruleExpressCS=ruleExpressCS();

            state._fsp--;

             current =iv_ruleExpressCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleExpressCS7132); 

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
    // $ANTLR end "entryRuleExpressCS"


    // $ANTLR start "ruleExpressCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3039:1: ruleExpressCS returns [EObject current=null] : ( ( ( ( (lv_ownedExpression_0_0= rulePrefixedExpCS ) ) ( (lv_ownedOperator_1_0= ruleBinaryOperatorCS ) ) )+ ( (lv_ownedExpression_2_0= rulePrefixedExpOrLetExpCS ) ) ) | ( ( (lv_ownedOperator_3_0= ruleEssentialOCLPrefixOperator ) ) ( (lv_ownedExpression_4_0= rulePrimaryExpOrLetExpCS ) ) ) | this_PrimaryExpOrLetExpCS_5= rulePrimaryExpOrLetExpCS ) ;
    public final EObject ruleExpressCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedExpression_0_0 = null;

        EObject lv_ownedOperator_1_0 = null;

        EObject lv_ownedExpression_2_0 = null;

        EObject lv_ownedOperator_3_0 = null;

        EObject lv_ownedExpression_4_0 = null;

        EObject this_PrimaryExpOrLetExpCS_5 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3042:28: ( ( ( ( ( (lv_ownedExpression_0_0= rulePrefixedExpCS ) ) ( (lv_ownedOperator_1_0= ruleBinaryOperatorCS ) ) )+ ( (lv_ownedExpression_2_0= rulePrefixedExpOrLetExpCS ) ) ) | ( ( (lv_ownedOperator_3_0= ruleEssentialOCLPrefixOperator ) ) ( (lv_ownedExpression_4_0= rulePrimaryExpOrLetExpCS ) ) ) | this_PrimaryExpOrLetExpCS_5= rulePrimaryExpOrLetExpCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3043:1: ( ( ( ( (lv_ownedExpression_0_0= rulePrefixedExpCS ) ) ( (lv_ownedOperator_1_0= ruleBinaryOperatorCS ) ) )+ ( (lv_ownedExpression_2_0= rulePrefixedExpOrLetExpCS ) ) ) | ( ( (lv_ownedOperator_3_0= ruleEssentialOCLPrefixOperator ) ) ( (lv_ownedExpression_4_0= rulePrimaryExpOrLetExpCS ) ) ) | this_PrimaryExpOrLetExpCS_5= rulePrimaryExpOrLetExpCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3043:1: ( ( ( ( (lv_ownedExpression_0_0= rulePrefixedExpCS ) ) ( (lv_ownedOperator_1_0= ruleBinaryOperatorCS ) ) )+ ( (lv_ownedExpression_2_0= rulePrefixedExpOrLetExpCS ) ) ) | ( ( (lv_ownedOperator_3_0= ruleEssentialOCLPrefixOperator ) ) ( (lv_ownedExpression_4_0= rulePrimaryExpOrLetExpCS ) ) ) | this_PrimaryExpOrLetExpCS_5= rulePrimaryExpOrLetExpCS )
            int alt45=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                int LA45_1 = input.LA(2);

                if ( (LA45_1==71) ) {
                    alt45=2;
                }
                else if ( (LA45_1==16||(LA45_1>=28 && LA45_1<=29)||LA45_1==32||(LA45_1>=39 && LA45_1<=41)||(LA45_1>=59 && LA45_1<=67)) ) {
                    alt45=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 1, input);

                    throw nvae;
                }
                }
                break;
            case 69:
                {
                int LA45_2 = input.LA(2);

                if ( (LA45_2==71) ) {
                    alt45=2;
                }
                else if ( (LA45_2==16||(LA45_2>=28 && LA45_2<=29)||LA45_2==32||(LA45_2>=39 && LA45_2<=41)||(LA45_2>=59 && LA45_2<=67)) ) {
                    alt45=1;
                }
                else {
                    NoViableAltException nvae =
                        new NoViableAltException("", 45, 2, input);

                    throw nvae;
                }
                }
                break;
            case 71:
                {
                alt45=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 45, 0, input);

                throw nvae;
            }

            switch (alt45) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3043:2: ( ( ( (lv_ownedExpression_0_0= rulePrefixedExpCS ) ) ( (lv_ownedOperator_1_0= ruleBinaryOperatorCS ) ) )+ ( (lv_ownedExpression_2_0= rulePrefixedExpOrLetExpCS ) ) )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3043:2: ( ( ( (lv_ownedExpression_0_0= rulePrefixedExpCS ) ) ( (lv_ownedOperator_1_0= ruleBinaryOperatorCS ) ) )+ ( (lv_ownedExpression_2_0= rulePrefixedExpOrLetExpCS ) ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3043:3: ( ( (lv_ownedExpression_0_0= rulePrefixedExpCS ) ) ( (lv_ownedOperator_1_0= ruleBinaryOperatorCS ) ) )+ ( (lv_ownedExpression_2_0= rulePrefixedExpOrLetExpCS ) )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3043:3: ( ( (lv_ownedExpression_0_0= rulePrefixedExpCS ) ) ( (lv_ownedOperator_1_0= ruleBinaryOperatorCS ) ) )+
                    int cnt44=0;
                    loop44:
                    do {
                        int alt44=2;
                        int LA44_0 = input.LA(1);

                        if ( (LA44_0==32) ) {
                            int LA44_2 = input.LA(2);

                            if ( (LA44_2==16||(LA44_2>=28 && LA44_2<=29)||LA44_2==32||(LA44_2>=39 && LA44_2<=41)||(LA44_2>=59 && LA44_2<=67)) ) {
                                alt44=1;
                            }


                        }
                        else if ( (LA44_0==69) ) {
                            int LA44_3 = input.LA(2);

                            if ( (LA44_3==16||(LA44_3>=28 && LA44_3<=29)||LA44_3==32||(LA44_3>=39 && LA44_3<=41)||(LA44_3>=59 && LA44_3<=67)) ) {
                                alt44=1;
                            }


                        }


                        switch (alt44) {
                    	case 1 :
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3043:4: ( (lv_ownedExpression_0_0= rulePrefixedExpCS ) ) ( (lv_ownedOperator_1_0= ruleBinaryOperatorCS ) )
                    	    {
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3043:4: ( (lv_ownedExpression_0_0= rulePrefixedExpCS ) )
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3044:1: (lv_ownedExpression_0_0= rulePrefixedExpCS )
                    	    {
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3044:1: (lv_ownedExpression_0_0= rulePrefixedExpCS )
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3045:3: lv_ownedExpression_0_0= rulePrefixedExpCS
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getExpressCSAccess().getOwnedExpressionPrefixedExpCSParserRuleCall_0_0_0_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_rulePrefixedExpCS_in_ruleExpressCS7180);
                    	    lv_ownedExpression_0_0=rulePrefixedExpCS();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getExpressCSRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ownedExpression",
                    	            		lv_ownedExpression_0_0, 
                    	            		"PrefixedExpCS");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }

                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3061:2: ( (lv_ownedOperator_1_0= ruleBinaryOperatorCS ) )
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3062:1: (lv_ownedOperator_1_0= ruleBinaryOperatorCS )
                    	    {
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3062:1: (lv_ownedOperator_1_0= ruleBinaryOperatorCS )
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3063:3: lv_ownedOperator_1_0= ruleBinaryOperatorCS
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getExpressCSAccess().getOwnedOperatorBinaryOperatorCSParserRuleCall_0_0_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleBinaryOperatorCS_in_ruleExpressCS7201);
                    	    lv_ownedOperator_1_0=ruleBinaryOperatorCS();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getExpressCSRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ownedOperator",
                    	            		lv_ownedOperator_1_0, 
                    	            		"BinaryOperatorCS");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    if ( cnt44 >= 1 ) break loop44;
                                EarlyExitException eee =
                                    new EarlyExitException(44, input);
                                throw eee;
                        }
                        cnt44++;
                    } while (true);

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3079:4: ( (lv_ownedExpression_2_0= rulePrefixedExpOrLetExpCS ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3080:1: (lv_ownedExpression_2_0= rulePrefixedExpOrLetExpCS )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3080:1: (lv_ownedExpression_2_0= rulePrefixedExpOrLetExpCS )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3081:3: lv_ownedExpression_2_0= rulePrefixedExpOrLetExpCS
                    {
                     
                    	        newCompositeNode(grammarAccess.getExpressCSAccess().getOwnedExpressionPrefixedExpOrLetExpCSParserRuleCall_0_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePrefixedExpOrLetExpCS_in_ruleExpressCS7224);
                    lv_ownedExpression_2_0=rulePrefixedExpOrLetExpCS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExpressCSRule());
                    	        }
                           		add(
                           			current, 
                           			"ownedExpression",
                            		lv_ownedExpression_2_0, 
                            		"PrefixedExpOrLetExpCS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3098:6: ( ( (lv_ownedOperator_3_0= ruleEssentialOCLPrefixOperator ) ) ( (lv_ownedExpression_4_0= rulePrimaryExpOrLetExpCS ) ) )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3098:6: ( ( (lv_ownedOperator_3_0= ruleEssentialOCLPrefixOperator ) ) ( (lv_ownedExpression_4_0= rulePrimaryExpOrLetExpCS ) ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3098:7: ( (lv_ownedOperator_3_0= ruleEssentialOCLPrefixOperator ) ) ( (lv_ownedExpression_4_0= rulePrimaryExpOrLetExpCS ) )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3098:7: ( (lv_ownedOperator_3_0= ruleEssentialOCLPrefixOperator ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3099:1: (lv_ownedOperator_3_0= ruleEssentialOCLPrefixOperator )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3099:1: (lv_ownedOperator_3_0= ruleEssentialOCLPrefixOperator )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3100:3: lv_ownedOperator_3_0= ruleEssentialOCLPrefixOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getExpressCSAccess().getOwnedOperatorEssentialOCLPrefixOperatorParserRuleCall_1_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEssentialOCLPrefixOperator_in_ruleExpressCS7253);
                    lv_ownedOperator_3_0=ruleEssentialOCLPrefixOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExpressCSRule());
                    	        }
                           		add(
                           			current, 
                           			"ownedOperator",
                            		lv_ownedOperator_3_0, 
                            		"EssentialOCLPrefixOperator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3116:2: ( (lv_ownedExpression_4_0= rulePrimaryExpOrLetExpCS ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3117:1: (lv_ownedExpression_4_0= rulePrimaryExpOrLetExpCS )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3117:1: (lv_ownedExpression_4_0= rulePrimaryExpOrLetExpCS )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3118:3: lv_ownedExpression_4_0= rulePrimaryExpOrLetExpCS
                    {
                     
                    	        newCompositeNode(grammarAccess.getExpressCSAccess().getOwnedExpressionPrimaryExpOrLetExpCSParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpOrLetExpCS_in_ruleExpressCS7274);
                    lv_ownedExpression_4_0=rulePrimaryExpOrLetExpCS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getExpressCSRule());
                    	        }
                           		add(
                           			current, 
                           			"ownedExpression",
                            		lv_ownedExpression_4_0, 
                            		"PrimaryExpOrLetExpCS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }


                    }
                    break;
                case 3 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3136:5: this_PrimaryExpOrLetExpCS_5= rulePrimaryExpOrLetExpCS
                    {
                     
                            newCompositeNode(grammarAccess.getExpressCSAccess().getPrimaryExpOrLetExpCSParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_rulePrimaryExpOrLetExpCS_in_ruleExpressCS7303);
                    this_PrimaryExpOrLetExpCS_5=rulePrimaryExpOrLetExpCS();

                    state._fsp--;

                     
                            current = this_PrimaryExpOrLetExpCS_5; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleExpressCS"


    // $ANTLR start "entryRulePrefixedExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3152:1: entryRulePrefixedExpCS returns [EObject current=null] : iv_rulePrefixedExpCS= rulePrefixedExpCS EOF ;
    public final EObject entryRulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3153:2: (iv_rulePrefixedExpCS= rulePrefixedExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3154:2: iv_rulePrefixedExpCS= rulePrefixedExpCS EOF
            {
             newCompositeNode(grammarAccess.getPrefixedExpCSRule()); 
            pushFollow(FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS7338);
            iv_rulePrefixedExpCS=rulePrefixedExpCS();

            state._fsp--;

             current =iv_rulePrefixedExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrefixedExpCS7348); 

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
    // $ANTLR end "entryRulePrefixedExpCS"


    // $ANTLR start "rulePrefixedExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3161:1: rulePrefixedExpCS returns [EObject current=null] : ( () ( (lv_ownedOperator_1_0= ruleEssentialOCLPrefixOperator ) ) ) ;
    public final EObject rulePrefixedExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedOperator_1_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3164:28: ( ( () ( (lv_ownedOperator_1_0= ruleEssentialOCLPrefixOperator ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3165:1: ( () ( (lv_ownedOperator_1_0= ruleEssentialOCLPrefixOperator ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3165:1: ( () ( (lv_ownedOperator_1_0= ruleEssentialOCLPrefixOperator ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3165:2: () ( (lv_ownedOperator_1_0= ruleEssentialOCLPrefixOperator ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3165:2: ()
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3166:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getPrefixedExpCSAccess().getPrefixExpCSAction_0(),
                        current);
                

            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3171:2: ( (lv_ownedOperator_1_0= ruleEssentialOCLPrefixOperator ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3172:1: (lv_ownedOperator_1_0= ruleEssentialOCLPrefixOperator )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3172:1: (lv_ownedOperator_1_0= ruleEssentialOCLPrefixOperator )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3173:3: lv_ownedOperator_1_0= ruleEssentialOCLPrefixOperator
            {
             
            	        newCompositeNode(grammarAccess.getPrefixedExpCSAccess().getOwnedOperatorEssentialOCLPrefixOperatorParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleEssentialOCLPrefixOperator_in_rulePrefixedExpCS7403);
            lv_ownedOperator_1_0=ruleEssentialOCLPrefixOperator();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPrefixedExpCSRule());
            	        }
                   		add(
                   			current, 
                   			"ownedOperator",
                    		lv_ownedOperator_1_0, 
                    		"EssentialOCLPrefixOperator");
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
    // $ANTLR end "rulePrefixedExpCS"


    // $ANTLR start "entryRuleEssentialOCLPrefixOperator"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3197:1: entryRuleEssentialOCLPrefixOperator returns [EObject current=null] : iv_ruleEssentialOCLPrefixOperator= ruleEssentialOCLPrefixOperator EOF ;
    public final EObject entryRuleEssentialOCLPrefixOperator() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEssentialOCLPrefixOperator = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3198:2: (iv_ruleEssentialOCLPrefixOperator= ruleEssentialOCLPrefixOperator EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3199:2: iv_ruleEssentialOCLPrefixOperator= ruleEssentialOCLPrefixOperator EOF
            {
             newCompositeNode(grammarAccess.getEssentialOCLPrefixOperatorRule()); 
            pushFollow(FOLLOW_ruleEssentialOCLPrefixOperator_in_entryRuleEssentialOCLPrefixOperator7439);
            iv_ruleEssentialOCLPrefixOperator=ruleEssentialOCLPrefixOperator();

            state._fsp--;

             current =iv_ruleEssentialOCLPrefixOperator; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleEssentialOCLPrefixOperator7449); 

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
    // $ANTLR end "entryRuleEssentialOCLPrefixOperator"


    // $ANTLR start "ruleEssentialOCLPrefixOperator"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3206:1: ruleEssentialOCLPrefixOperator returns [EObject current=null] : ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) ;
    public final EObject ruleEssentialOCLPrefixOperator() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_1=null;
        Token lv_name_0_2=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3209:28: ( ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3210:1: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3210:1: ( ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3211:1: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3211:1: ( (lv_name_0_1= '-' | lv_name_0_2= 'not' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3212:1: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3212:1: (lv_name_0_1= '-' | lv_name_0_2= 'not' )
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==32) ) {
                alt46=1;
            }
            else if ( (LA46_0==69) ) {
                alt46=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 46, 0, input);

                throw nvae;
            }
            switch (alt46) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3213:3: lv_name_0_1= '-'
                    {
                    lv_name_0_1=(Token)match(input,32,FOLLOW_32_in_ruleEssentialOCLPrefixOperator7493); 

                            newLeafNode(lv_name_0_1, grammarAccess.getEssentialOCLPrefixOperatorAccess().getNameHyphenMinusKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEssentialOCLPrefixOperatorRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_1, null);
                    	    

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3225:8: lv_name_0_2= 'not'
                    {
                    lv_name_0_2=(Token)match(input,69,FOLLOW_69_in_ruleEssentialOCLPrefixOperator7522); 

                            newLeafNode(lv_name_0_2, grammarAccess.getEssentialOCLPrefixOperatorAccess().getNameNotKeyword_0_1());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getEssentialOCLPrefixOperatorRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_2, null);
                    	    

                    }
                    break;

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
    // $ANTLR end "ruleEssentialOCLPrefixOperator"


    // $ANTLR start "entryRulePrefixedExpOrLetExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3248:1: entryRulePrefixedExpOrLetExpCS returns [EObject current=null] : iv_rulePrefixedExpOrLetExpCS= rulePrefixedExpOrLetExpCS EOF ;
    public final EObject entryRulePrefixedExpOrLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrefixedExpOrLetExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3249:2: (iv_rulePrefixedExpOrLetExpCS= rulePrefixedExpOrLetExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3250:2: iv_rulePrefixedExpOrLetExpCS= rulePrefixedExpOrLetExpCS EOF
            {
             newCompositeNode(grammarAccess.getPrefixedExpOrLetExpCSRule()); 
            pushFollow(FOLLOW_rulePrefixedExpOrLetExpCS_in_entryRulePrefixedExpOrLetExpCS7573);
            iv_rulePrefixedExpOrLetExpCS=rulePrefixedExpOrLetExpCS();

            state._fsp--;

             current =iv_rulePrefixedExpOrLetExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrefixedExpOrLetExpCS7583); 

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
    // $ANTLR end "entryRulePrefixedExpOrLetExpCS"


    // $ANTLR start "rulePrefixedExpOrLetExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3257:1: rulePrefixedExpOrLetExpCS returns [EObject current=null] : (this_PrimaryExpOrLetExpCS_0= rulePrimaryExpOrLetExpCS | ( () ( (lv_ownedOperator_2_0= ruleEssentialOCLPrefixOperator ) ) ( (lv_ownedExpression_3_0= rulePrimaryExpOrLetExpCS ) ) ) ) ;
    public final EObject rulePrefixedExpOrLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimaryExpOrLetExpCS_0 = null;

        EObject lv_ownedOperator_2_0 = null;

        EObject lv_ownedExpression_3_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3260:28: ( (this_PrimaryExpOrLetExpCS_0= rulePrimaryExpOrLetExpCS | ( () ( (lv_ownedOperator_2_0= ruleEssentialOCLPrefixOperator ) ) ( (lv_ownedExpression_3_0= rulePrimaryExpOrLetExpCS ) ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3261:1: (this_PrimaryExpOrLetExpCS_0= rulePrimaryExpOrLetExpCS | ( () ( (lv_ownedOperator_2_0= ruleEssentialOCLPrefixOperator ) ) ( (lv_ownedExpression_3_0= rulePrimaryExpOrLetExpCS ) ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3261:1: (this_PrimaryExpOrLetExpCS_0= rulePrimaryExpOrLetExpCS | ( () ( (lv_ownedOperator_2_0= ruleEssentialOCLPrefixOperator ) ) ( (lv_ownedExpression_3_0= rulePrimaryExpOrLetExpCS ) ) ) )
            int alt47=2;
            int LA47_0 = input.LA(1);

            if ( (LA47_0==71) ) {
                alt47=1;
            }
            else if ( (LA47_0==32||LA47_0==69) ) {
                alt47=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 47, 0, input);

                throw nvae;
            }
            switch (alt47) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3262:5: this_PrimaryExpOrLetExpCS_0= rulePrimaryExpOrLetExpCS
                    {
                     
                            newCompositeNode(grammarAccess.getPrefixedExpOrLetExpCSAccess().getPrimaryExpOrLetExpCSParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePrimaryExpOrLetExpCS_in_rulePrefixedExpOrLetExpCS7630);
                    this_PrimaryExpOrLetExpCS_0=rulePrimaryExpOrLetExpCS();

                    state._fsp--;

                     
                            current = this_PrimaryExpOrLetExpCS_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3271:6: ( () ( (lv_ownedOperator_2_0= ruleEssentialOCLPrefixOperator ) ) ( (lv_ownedExpression_3_0= rulePrimaryExpOrLetExpCS ) ) )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3271:6: ( () ( (lv_ownedOperator_2_0= ruleEssentialOCLPrefixOperator ) ) ( (lv_ownedExpression_3_0= rulePrimaryExpOrLetExpCS ) ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3271:7: () ( (lv_ownedOperator_2_0= ruleEssentialOCLPrefixOperator ) ) ( (lv_ownedExpression_3_0= rulePrimaryExpOrLetExpCS ) )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3271:7: ()
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3272:5: 
                    {

                            current = forceCreateModelElement(
                                grammarAccess.getPrefixedExpOrLetExpCSAccess().getPrefixExpCSAction_1_0(),
                                current);
                        

                    }

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3277:2: ( (lv_ownedOperator_2_0= ruleEssentialOCLPrefixOperator ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3278:1: (lv_ownedOperator_2_0= ruleEssentialOCLPrefixOperator )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3278:1: (lv_ownedOperator_2_0= ruleEssentialOCLPrefixOperator )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3279:3: lv_ownedOperator_2_0= ruleEssentialOCLPrefixOperator
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrefixedExpOrLetExpCSAccess().getOwnedOperatorEssentialOCLPrefixOperatorParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleEssentialOCLPrefixOperator_in_rulePrefixedExpOrLetExpCS7666);
                    lv_ownedOperator_2_0=ruleEssentialOCLPrefixOperator();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrefixedExpOrLetExpCSRule());
                    	        }
                           		add(
                           			current, 
                           			"ownedOperator",
                            		lv_ownedOperator_2_0, 
                            		"EssentialOCLPrefixOperator");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3295:2: ( (lv_ownedExpression_3_0= rulePrimaryExpOrLetExpCS ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3296:1: (lv_ownedExpression_3_0= rulePrimaryExpOrLetExpCS )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3296:1: (lv_ownedExpression_3_0= rulePrimaryExpOrLetExpCS )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3297:3: lv_ownedExpression_3_0= rulePrimaryExpOrLetExpCS
                    {
                     
                    	        newCompositeNode(grammarAccess.getPrefixedExpOrLetExpCSAccess().getOwnedExpressionPrimaryExpOrLetExpCSParserRuleCall_1_2_0()); 
                    	    
                    pushFollow(FOLLOW_rulePrimaryExpOrLetExpCS_in_rulePrefixedExpOrLetExpCS7687);
                    lv_ownedExpression_3_0=rulePrimaryExpOrLetExpCS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getPrefixedExpOrLetExpCSRule());
                    	        }
                           		set(
                           			current, 
                           			"ownedExpression",
                            		lv_ownedExpression_3_0, 
                            		"PrimaryExpOrLetExpCS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


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
    // $ANTLR end "rulePrefixedExpOrLetExpCS"


    // $ANTLR start "entryRuleConstructorPartCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3323:1: entryRuleConstructorPartCS returns [EObject current=null] : iv_ruleConstructorPartCS= ruleConstructorPartCS EOF ;
    public final EObject entryRuleConstructorPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleConstructorPartCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3324:2: (iv_ruleConstructorPartCS= ruleConstructorPartCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3325:2: iv_ruleConstructorPartCS= ruleConstructorPartCS EOF
            {
             newCompositeNode(grammarAccess.getConstructorPartCSRule()); 
            pushFollow(FOLLOW_ruleConstructorPartCS_in_entryRuleConstructorPartCS7726);
            iv_ruleConstructorPartCS=ruleConstructorPartCS();

            state._fsp--;

             current =iv_ruleConstructorPartCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleConstructorPartCS7736); 

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
    // $ANTLR end "entryRuleConstructorPartCS"


    // $ANTLR start "ruleConstructorPartCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3332:1: ruleConstructorPartCS returns [EObject current=null] : ( ( (lv_property_0_0= ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpressCS ) ) ) ;
    public final EObject ruleConstructorPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_property_0_0 = null;

        EObject lv_initExpression_2_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3335:28: ( ( ( (lv_property_0_0= ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpressCS ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3336:1: ( ( (lv_property_0_0= ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpressCS ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3336:1: ( ( (lv_property_0_0= ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpressCS ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3336:2: ( (lv_property_0_0= ruleUnrestrictedName ) ) otherlv_1= '=' ( (lv_initExpression_2_0= ruleExpressCS ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3336:2: ( (lv_property_0_0= ruleUnrestrictedName ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3337:1: (lv_property_0_0= ruleUnrestrictedName )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3337:1: (lv_property_0_0= ruleUnrestrictedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3338:3: lv_property_0_0= ruleUnrestrictedName
            {
             
            	        newCompositeNode(grammarAccess.getConstructorPartCSAccess().getPropertyUnrestrictedNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleUnrestrictedName_in_ruleConstructorPartCS7782);
            lv_property_0_0=ruleUnrestrictedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstructorPartCSRule());
            	        }
                   		set(
                   			current, 
                   			"property",
                    		lv_property_0_0, 
                    		"UnrestrictedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,39,FOLLOW_39_in_ruleConstructorPartCS7794); 

                	newLeafNode(otherlv_1, grammarAccess.getConstructorPartCSAccess().getEqualsSignKeyword_1());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3358:1: ( (lv_initExpression_2_0= ruleExpressCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3359:1: (lv_initExpression_2_0= ruleExpressCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3359:1: (lv_initExpression_2_0= ruleExpressCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3360:3: lv_initExpression_2_0= ruleExpressCS
            {
             
            	        newCompositeNode(grammarAccess.getConstructorPartCSAccess().getInitExpressionExpressCSParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleExpressCS_in_ruleConstructorPartCS7815);
            lv_initExpression_2_0=ruleExpressCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getConstructorPartCSRule());
            	        }
                   		set(
                   			current, 
                   			"initExpression",
                    		lv_initExpression_2_0, 
                    		"ExpressCS");
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
    // $ANTLR end "ruleConstructorPartCS"


    // $ANTLR start "entryRuleTypeLiteralWithMultiplicityCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3384:1: entryRuleTypeLiteralWithMultiplicityCS returns [EObject current=null] : iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF ;
    public final EObject entryRuleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralWithMultiplicityCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3385:2: (iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3386:2: iv_ruleTypeLiteralWithMultiplicityCS= ruleTypeLiteralWithMultiplicityCS EOF
            {
             newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSRule()); 
            pushFollow(FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS7851);
            iv_ruleTypeLiteralWithMultiplicityCS=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;

             current =iv_ruleTypeLiteralWithMultiplicityCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS7861); 

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
    // $ANTLR end "entryRuleTypeLiteralWithMultiplicityCS"


    // $ANTLR start "ruleTypeLiteralWithMultiplicityCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3393:1: ruleTypeLiteralWithMultiplicityCS returns [EObject current=null] : (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? ) ;
    public final EObject ruleTypeLiteralWithMultiplicityCS() throws RecognitionException {
        EObject current = null;

        EObject this_TypeLiteralCS_0 = null;

        EObject lv_multiplicity_1_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3396:28: ( (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3397:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3397:1: (this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3398:5: this_TypeLiteralCS_0= ruleTypeLiteralCS ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )?
            {
             
                    newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getTypeLiteralCSParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS7908);
            this_TypeLiteralCS_0=ruleTypeLiteralCS();

            state._fsp--;

             
                    current = this_TypeLiteralCS_0; 
                    afterParserOrEnumRuleCall();
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3406:1: ( (lv_multiplicity_1_0= ruleMultiplicityCS ) )?
            int alt48=2;
            int LA48_0 = input.LA(1);

            if ( (LA48_0==26) ) {
                alt48=1;
            }
            switch (alt48) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3407:1: (lv_multiplicity_1_0= ruleMultiplicityCS )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3407:1: (lv_multiplicity_1_0= ruleMultiplicityCS )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3408:3: lv_multiplicity_1_0= ruleMultiplicityCS
                    {
                     
                    	        newCompositeNode(grammarAccess.getTypeLiteralWithMultiplicityCSAccess().getMultiplicityMultiplicityCSParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS7928);
                    lv_multiplicity_1_0=ruleMultiplicityCS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTypeLiteralWithMultiplicityCSRule());
                    	        }
                           		set(
                           			current, 
                           			"multiplicity",
                            		lv_multiplicity_1_0, 
                            		"MultiplicityCS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

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
    // $ANTLR end "ruleTypeLiteralWithMultiplicityCS"


    // $ANTLR start "entryRuleTypeLiteralCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3432:1: entryRuleTypeLiteralCS returns [EObject current=null] : iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF ;
    public final EObject entryRuleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3433:2: (iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3434:2: iv_ruleTypeLiteralCS= ruleTypeLiteralCS EOF
            {
             newCompositeNode(grammarAccess.getTypeLiteralCSRule()); 
            pushFollow(FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS7965);
            iv_ruleTypeLiteralCS=ruleTypeLiteralCS();

            state._fsp--;

             current =iv_ruleTypeLiteralCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeLiteralCS7975); 

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
    // $ANTLR end "entryRuleTypeLiteralCS"


    // $ANTLR start "ruleTypeLiteralCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3441:1: ruleTypeLiteralCS returns [EObject current=null] : (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) ;
    public final EObject ruleTypeLiteralCS() throws RecognitionException {
        EObject current = null;

        EObject this_PrimitiveTypeCS_0 = null;

        EObject this_CollectionTypeCS_1 = null;

        EObject this_TupleTypeCS_2 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3444:28: ( (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3445:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3445:1: (this_PrimitiveTypeCS_0= rulePrimitiveTypeCS | this_CollectionTypeCS_1= ruleCollectionTypeCS | this_TupleTypeCS_2= ruleTupleTypeCS )
            int alt49=3;
            switch ( input.LA(1) ) {
            case 46:
            case 47:
            case 48:
            case 49:
            case 50:
            case 51:
            case 52:
            case 53:
                {
                alt49=1;
                }
                break;
            case 54:
            case 55:
            case 56:
            case 57:
            case 58:
                {
                alt49=2;
                }
                break;
            case 45:
                {
                alt49=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 49, 0, input);

                throw nvae;
            }

            switch (alt49) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3446:5: this_PrimitiveTypeCS_0= rulePrimitiveTypeCS
                    {
                     
                            newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getPrimitiveTypeCSParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS8022);
                    this_PrimitiveTypeCS_0=rulePrimitiveTypeCS();

                    state._fsp--;

                     
                            current = this_PrimitiveTypeCS_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3456:5: this_CollectionTypeCS_1= ruleCollectionTypeCS
                    {
                     
                            newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getCollectionTypeCSParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS8049);
                    this_CollectionTypeCS_1=ruleCollectionTypeCS();

                    state._fsp--;

                     
                            current = this_CollectionTypeCS_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3466:5: this_TupleTypeCS_2= ruleTupleTypeCS
                    {
                     
                            newCompositeNode(grammarAccess.getTypeLiteralCSAccess().getTupleTypeCSParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS8076);
                    this_TupleTypeCS_2=ruleTupleTypeCS();

                    state._fsp--;

                     
                            current = this_TupleTypeCS_2; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "ruleTypeLiteralCS"


    // $ANTLR start "entryRuleTupleTypeCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3482:1: entryRuleTupleTypeCS returns [EObject current=null] : iv_ruleTupleTypeCS= ruleTupleTypeCS EOF ;
    public final EObject entryRuleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleTypeCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3483:2: (iv_ruleTupleTypeCS= ruleTupleTypeCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3484:2: iv_ruleTupleTypeCS= ruleTupleTypeCS EOF
            {
             newCompositeNode(grammarAccess.getTupleTypeCSRule()); 
            pushFollow(FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS8111);
            iv_ruleTupleTypeCS=ruleTupleTypeCS();

            state._fsp--;

             current =iv_ruleTupleTypeCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTupleTypeCS8121); 

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
    // $ANTLR end "entryRuleTupleTypeCS"


    // $ANTLR start "ruleTupleTypeCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3491:1: ruleTupleTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) ;
    public final EObject ruleTupleTypeCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3494:28: ( ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3495:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3495:1: ( ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3495:2: ( (lv_name_0_0= 'Tuple' ) ) (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3495:2: ( (lv_name_0_0= 'Tuple' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3496:1: (lv_name_0_0= 'Tuple' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3496:1: (lv_name_0_0= 'Tuple' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3497:3: lv_name_0_0= 'Tuple'
            {
            lv_name_0_0=(Token)match(input,45,FOLLOW_45_in_ruleTupleTypeCS8164); 

                    newLeafNode(lv_name_0_0, grammarAccess.getTupleTypeCSAccess().getNameTupleKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getTupleTypeCSRule());
            	        }
                   		setWithLastConsumed(current, "name", lv_name_0_0, "Tuple");
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3510:2: (otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')' )?
            int alt52=2;
            int LA52_0 = input.LA(1);

            if ( (LA52_0==22) ) {
                alt52=1;
            }
            switch (alt52) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3510:4: otherlv_1= '(' ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )? otherlv_5= ')'
                    {
                    otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleTupleTypeCS8190); 

                        	newLeafNode(otherlv_1, grammarAccess.getTupleTypeCSAccess().getLeftParenthesisKeyword_1_0());
                        
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3514:1: ( ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )* )?
                    int alt51=2;
                    int LA51_0 = input.LA(1);

                    if ( (LA51_0==RULE_ID) ) {
                        alt51=1;
                    }
                    switch (alt51) {
                        case 1 :
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3514:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            {
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3514:2: ( (lv_ownedParts_2_0= ruleTuplePartCS ) )
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3515:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            {
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3515:1: (lv_ownedParts_2_0= ruleTuplePartCS )
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3516:3: lv_ownedParts_2_0= ruleTuplePartCS
                            {
                             
                            	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS8212);
                            lv_ownedParts_2_0=ruleTuplePartCS();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getTupleTypeCSRule());
                            	        }
                                   		add(
                                   			current, 
                                   			"ownedParts",
                                    		lv_ownedParts_2_0, 
                                    		"TuplePartCS");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3532:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) ) )*
                            loop50:
                            do {
                                int alt50=2;
                                int LA50_0 = input.LA(1);

                                if ( (LA50_0==18) ) {
                                    alt50=1;
                                }


                                switch (alt50) {
                            	case 1 :
                            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3532:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    {
                            	    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleTupleTypeCS8225); 

                            	        	newLeafNode(otherlv_3, grammarAccess.getTupleTypeCSAccess().getCommaKeyword_1_1_1_0());
                            	        
                            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3536:1: ( (lv_ownedParts_4_0= ruleTuplePartCS ) )
                            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3537:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    {
                            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3537:1: (lv_ownedParts_4_0= ruleTuplePartCS )
                            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3538:3: lv_ownedParts_4_0= ruleTuplePartCS
                            	    {
                            	     
                            	    	        newCompositeNode(grammarAccess.getTupleTypeCSAccess().getOwnedPartsTuplePartCSParserRuleCall_1_1_1_1_0()); 
                            	    	    
                            	    pushFollow(FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS8246);
                            	    lv_ownedParts_4_0=ruleTuplePartCS();

                            	    state._fsp--;


                            	    	        if (current==null) {
                            	    	            current = createModelElementForParent(grammarAccess.getTupleTypeCSRule());
                            	    	        }
                            	           		add(
                            	           			current, 
                            	           			"ownedParts",
                            	            		lv_ownedParts_4_0, 
                            	            		"TuplePartCS");
                            	    	        afterParserOrEnumRuleCall();
                            	    	    

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop50;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleTupleTypeCS8262); 

                        	newLeafNode(otherlv_5, grammarAccess.getTupleTypeCSAccess().getRightParenthesisKeyword_1_2());
                        

                    }
                    break;

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
    // $ANTLR end "ruleTupleTypeCS"


    // $ANTLR start "entryRuleTuplePartCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3566:1: entryRuleTuplePartCS returns [EObject current=null] : iv_ruleTuplePartCS= ruleTuplePartCS EOF ;
    public final EObject entryRuleTuplePartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTuplePartCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3567:2: (iv_ruleTuplePartCS= ruleTuplePartCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3568:2: iv_ruleTuplePartCS= ruleTuplePartCS EOF
            {
             newCompositeNode(grammarAccess.getTuplePartCSRule()); 
            pushFollow(FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS8300);
            iv_ruleTuplePartCS=ruleTuplePartCS();

            state._fsp--;

             current =iv_ruleTuplePartCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTuplePartCS8310); 

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
    // $ANTLR end "entryRuleTuplePartCS"


    // $ANTLR start "ruleTuplePartCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3575:1: ruleTuplePartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) ;
    public final EObject ruleTuplePartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3578:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3579:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3579:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3579:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3579:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3580:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3580:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3581:3: lv_name_0_0= ruleUnrestrictedName
            {
             
            	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS8356);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTuplePartCSRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"UnrestrictedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleTuplePartCS8368); 

                	newLeafNode(otherlv_1, grammarAccess.getTuplePartCSAccess().getColonKeyword_1());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3601:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3602:1: (lv_ownedType_2_0= ruleTypeExpCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3602:1: (lv_ownedType_2_0= ruleTypeExpCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3603:3: lv_ownedType_2_0= ruleTypeExpCS
            {
             
            	        newCompositeNode(grammarAccess.getTuplePartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS8389);
            lv_ownedType_2_0=ruleTypeExpCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTuplePartCSRule());
            	        }
                   		set(
                   			current, 
                   			"ownedType",
                    		lv_ownedType_2_0, 
                    		"TypeExpCS");
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
    // $ANTLR end "ruleTuplePartCS"


    // $ANTLR start "entryRulePrimitiveTypeCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3627:1: entryRulePrimitiveTypeCS returns [EObject current=null] : iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF ;
    public final EObject entryRulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveTypeCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3628:2: (iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3629:2: iv_rulePrimitiveTypeCS= rulePrimitiveTypeCS EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveTypeCSRule()); 
            pushFollow(FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS8425);
            iv_rulePrimitiveTypeCS=rulePrimitiveTypeCS();

            state._fsp--;

             current =iv_rulePrimitiveTypeCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveTypeCS8435); 

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
    // $ANTLR end "entryRulePrimitiveTypeCS"


    // $ANTLR start "rulePrimitiveTypeCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3636:1: rulePrimitiveTypeCS returns [EObject current=null] : ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) ;
    public final EObject rulePrimitiveTypeCS() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3639:28: ( ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3640:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3640:1: ( (lv_name_0_0= rulePrimitiveTypeIdentifier ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3641:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3641:1: (lv_name_0_0= rulePrimitiveTypeIdentifier )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3642:3: lv_name_0_0= rulePrimitiveTypeIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getPrimitiveTypeCSAccess().getNamePrimitiveTypeIdentifierParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS8480);
            lv_name_0_0=rulePrimitiveTypeIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getPrimitiveTypeCSRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"PrimitiveTypeIdentifier");
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
    // $ANTLR end "rulePrimitiveTypeCS"


    // $ANTLR start "entryRuleTypeLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3666:1: entryRuleTypeLiteralExpCS returns [EObject current=null] : iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF ;
    public final EObject entryRuleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeLiteralExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3667:2: (iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3668:2: iv_ruleTypeLiteralExpCS= ruleTypeLiteralExpCS EOF
            {
             newCompositeNode(grammarAccess.getTypeLiteralExpCSRule()); 
            pushFollow(FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS8515);
            iv_ruleTypeLiteralExpCS=ruleTypeLiteralExpCS();

            state._fsp--;

             current =iv_ruleTypeLiteralExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTypeLiteralExpCS8525); 

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
    // $ANTLR end "entryRuleTypeLiteralExpCS"


    // $ANTLR start "ruleTypeLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3675:1: ruleTypeLiteralExpCS returns [EObject current=null] : ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) ;
    public final EObject ruleTypeLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_ownedType_0_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3678:28: ( ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3679:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3679:1: ( (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3680:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3680:1: (lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3681:3: lv_ownedType_0_0= ruleTypeLiteralWithMultiplicityCS
            {
             
            	        newCompositeNode(grammarAccess.getTypeLiteralExpCSAccess().getOwnedTypeTypeLiteralWithMultiplicityCSParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS8570);
            lv_ownedType_0_0=ruleTypeLiteralWithMultiplicityCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTypeLiteralExpCSRule());
            	        }
                   		set(
                   			current, 
                   			"ownedType",
                    		lv_ownedType_0_0, 
                    		"TypeLiteralWithMultiplicityCS");
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
    // $ANTLR end "ruleTypeLiteralExpCS"


    // $ANTLR start "entryRuleCollectionLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3705:1: entryRuleCollectionLiteralExpCS returns [EObject current=null] : iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF ;
    public final EObject entryRuleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3706:2: (iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3707:2: iv_ruleCollectionLiteralExpCS= ruleCollectionLiteralExpCS EOF
            {
             newCompositeNode(grammarAccess.getCollectionLiteralExpCSRule()); 
            pushFollow(FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS8605);
            iv_ruleCollectionLiteralExpCS=ruleCollectionLiteralExpCS();

            state._fsp--;

             current =iv_ruleCollectionLiteralExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS8615); 

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
    // $ANTLR end "entryRuleCollectionLiteralExpCS"


    // $ANTLR start "ruleCollectionLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3714:1: ruleCollectionLiteralExpCS returns [EObject current=null] : ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleCollectionLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedType_0_0 = null;

        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3717:28: ( ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3718:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3718:1: ( ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3718:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) ) otherlv_1= '{' ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )? otherlv_5= '}'
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3718:2: ( (lv_ownedType_0_0= ruleCollectionTypeCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3719:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3719:1: (lv_ownedType_0_0= ruleCollectionTypeCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3720:3: lv_ownedType_0_0= ruleCollectionTypeCS
            {
             
            	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedTypeCollectionTypeCSParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS8661);
            lv_ownedType_0_0=ruleCollectionTypeCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
            	        }
                   		set(
                   			current, 
                   			"ownedType",
                    		lv_ownedType_0_0, 
                    		"CollectionTypeCS");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleCollectionLiteralExpCS8673); 

                	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3740:1: ( ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )* )?
            int alt54=2;
            int LA54_0 = input.LA(1);

            if ( (LA54_0==32||LA54_0==69||LA54_0==71) ) {
                alt54=1;
            }
            switch (alt54) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3740:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3740:2: ( (lv_ownedParts_2_0= ruleCollectionLiteralPartCS ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3741:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3741:1: (lv_ownedParts_2_0= ruleCollectionLiteralPartCS )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3742:3: lv_ownedParts_2_0= ruleCollectionLiteralPartCS
                    {
                     
                    	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS8695);
                    lv_ownedParts_2_0=ruleCollectionLiteralPartCS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
                    	        }
                           		add(
                           			current, 
                           			"ownedParts",
                            		lv_ownedParts_2_0, 
                            		"CollectionLiteralPartCS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3758:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) ) )*
                    loop53:
                    do {
                        int alt53=2;
                        int LA53_0 = input.LA(1);

                        if ( (LA53_0==18) ) {
                            alt53=1;
                        }


                        switch (alt53) {
                    	case 1 :
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3758:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    {
                    	    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleCollectionLiteralExpCS8708); 

                    	        	newLeafNode(otherlv_3, grammarAccess.getCollectionLiteralExpCSAccess().getCommaKeyword_2_1_0());
                    	        
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3762:1: ( (lv_ownedParts_4_0= ruleCollectionLiteralPartCS ) )
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3763:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    {
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3763:1: (lv_ownedParts_4_0= ruleCollectionLiteralPartCS )
                    	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3764:3: lv_ownedParts_4_0= ruleCollectionLiteralPartCS
                    	    {
                    	     
                    	    	        newCompositeNode(grammarAccess.getCollectionLiteralExpCSAccess().getOwnedPartsCollectionLiteralPartCSParserRuleCall_2_1_1_0()); 
                    	    	    
                    	    pushFollow(FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS8729);
                    	    lv_ownedParts_4_0=ruleCollectionLiteralPartCS();

                    	    state._fsp--;


                    	    	        if (current==null) {
                    	    	            current = createModelElementForParent(grammarAccess.getCollectionLiteralExpCSRule());
                    	    	        }
                    	           		add(
                    	           			current, 
                    	           			"ownedParts",
                    	            		lv_ownedParts_4_0, 
                    	            		"CollectionLiteralPartCS");
                    	    	        afterParserOrEnumRuleCall();
                    	    	    

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop53;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleCollectionLiteralExpCS8745); 

                	newLeafNode(otherlv_5, grammarAccess.getCollectionLiteralExpCSAccess().getRightCurlyBracketKeyword_3());
                

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
    // $ANTLR end "ruleCollectionLiteralExpCS"


    // $ANTLR start "entryRuleCollectionLiteralPartCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3792:1: entryRuleCollectionLiteralPartCS returns [EObject current=null] : iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF ;
    public final EObject entryRuleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionLiteralPartCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3793:2: (iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3794:2: iv_ruleCollectionLiteralPartCS= ruleCollectionLiteralPartCS EOF
            {
             newCompositeNode(grammarAccess.getCollectionLiteralPartCSRule()); 
            pushFollow(FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS8781);
            iv_ruleCollectionLiteralPartCS=ruleCollectionLiteralPartCS();

            state._fsp--;

             current =iv_ruleCollectionLiteralPartCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS8791); 

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
    // $ANTLR end "entryRuleCollectionLiteralPartCS"


    // $ANTLR start "ruleCollectionLiteralPartCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3801:1: ruleCollectionLiteralPartCS returns [EObject current=null] : ( ( (lv_expressionCS_0_0= ruleExpressCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpressCS ) ) )? ) ;
    public final EObject ruleCollectionLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expressionCS_0_0 = null;

        EObject lv_lastExpressionCS_2_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3804:28: ( ( ( (lv_expressionCS_0_0= ruleExpressCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpressCS ) ) )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3805:1: ( ( (lv_expressionCS_0_0= ruleExpressCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpressCS ) ) )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3805:1: ( ( (lv_expressionCS_0_0= ruleExpressCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpressCS ) ) )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3805:2: ( (lv_expressionCS_0_0= ruleExpressCS ) ) (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpressCS ) ) )?
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3805:2: ( (lv_expressionCS_0_0= ruleExpressCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3806:1: (lv_expressionCS_0_0= ruleExpressCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3806:1: (lv_expressionCS_0_0= ruleExpressCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3807:3: lv_expressionCS_0_0= ruleExpressCS
            {
             
            	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getExpressionCSExpressCSParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleExpressCS_in_ruleCollectionLiteralPartCS8837);
            lv_expressionCS_0_0=ruleExpressCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
            	        }
                   		set(
                   			current, 
                   			"expressionCS",
                    		lv_expressionCS_0_0, 
                    		"ExpressCS");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3823:2: (otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpressCS ) ) )?
            int alt55=2;
            int LA55_0 = input.LA(1);

            if ( (LA55_0==43) ) {
                alt55=1;
            }
            switch (alt55) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3823:4: otherlv_1= '..' ( (lv_lastExpressionCS_2_0= ruleExpressCS ) )
                    {
                    otherlv_1=(Token)match(input,43,FOLLOW_43_in_ruleCollectionLiteralPartCS8850); 

                        	newLeafNode(otherlv_1, grammarAccess.getCollectionLiteralPartCSAccess().getFullStopFullStopKeyword_1_0());
                        
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3827:1: ( (lv_lastExpressionCS_2_0= ruleExpressCS ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3828:1: (lv_lastExpressionCS_2_0= ruleExpressCS )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3828:1: (lv_lastExpressionCS_2_0= ruleExpressCS )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3829:3: lv_lastExpressionCS_2_0= ruleExpressCS
                    {
                     
                    	        newCompositeNode(grammarAccess.getCollectionLiteralPartCSAccess().getLastExpressionCSExpressCSParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleExpressCS_in_ruleCollectionLiteralPartCS8871);
                    lv_lastExpressionCS_2_0=ruleExpressCS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCollectionLiteralPartCSRule());
                    	        }
                           		set(
                           			current, 
                           			"lastExpressionCS",
                            		lv_lastExpressionCS_2_0, 
                            		"ExpressCS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

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
    // $ANTLR end "ruleCollectionLiteralPartCS"


    // $ANTLR start "entryRuleCollectionTypeCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3853:1: entryRuleCollectionTypeCS returns [EObject current=null] : iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF ;
    public final EObject entryRuleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCollectionTypeCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3854:2: (iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3855:2: iv_ruleCollectionTypeCS= ruleCollectionTypeCS EOF
            {
             newCompositeNode(grammarAccess.getCollectionTypeCSRule()); 
            pushFollow(FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS8909);
            iv_ruleCollectionTypeCS=ruleCollectionTypeCS();

            state._fsp--;

             current =iv_ruleCollectionTypeCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCollectionTypeCS8919); 

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
    // $ANTLR end "entryRuleCollectionTypeCS"


    // $ANTLR start "ruleCollectionTypeCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3862:1: ruleCollectionTypeCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) ;
    public final EObject ruleCollectionTypeCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3865:28: ( ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3866:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3866:1: ( ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3866:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) ) (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3866:2: ( (lv_name_0_0= ruleCollectionTypeIdentifier ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3867:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3867:1: (lv_name_0_0= ruleCollectionTypeIdentifier )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3868:3: lv_name_0_0= ruleCollectionTypeIdentifier
            {
             
            	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getNameCollectionTypeIdentifierParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS8965);
            lv_name_0_0=ruleCollectionTypeIdentifier();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"CollectionTypeIdentifier");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3884:2: (otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')' )?
            int alt56=2;
            int LA56_0 = input.LA(1);

            if ( (LA56_0==22) ) {
                alt56=1;
            }
            switch (alt56) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3884:4: otherlv_1= '(' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) otherlv_3= ')'
                    {
                    otherlv_1=(Token)match(input,22,FOLLOW_22_in_ruleCollectionTypeCS8978); 

                        	newLeafNode(otherlv_1, grammarAccess.getCollectionTypeCSAccess().getLeftParenthesisKeyword_1_0());
                        
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3888:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3889:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3889:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3890:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                     
                    	        newCompositeNode(grammarAccess.getCollectionTypeCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS8999);
                    lv_ownedType_2_0=ruleTypeExpCS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getCollectionTypeCSRule());
                    	        }
                           		set(
                           			current, 
                           			"ownedType",
                            		lv_ownedType_2_0, 
                            		"TypeExpCS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    otherlv_3=(Token)match(input,23,FOLLOW_23_in_ruleCollectionTypeCS9011); 

                        	newLeafNode(otherlv_3, grammarAccess.getCollectionTypeCSAccess().getRightParenthesisKeyword_1_2());
                        

                    }
                    break;

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
    // $ANTLR end "ruleCollectionTypeCS"


    // $ANTLR start "entryRuleNestedExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3918:1: entryRuleNestedExpCS returns [EObject current=null] : iv_ruleNestedExpCS= ruleNestedExpCS EOF ;
    public final EObject entryRuleNestedExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNestedExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3919:2: (iv_ruleNestedExpCS= ruleNestedExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3920:2: iv_ruleNestedExpCS= ruleNestedExpCS EOF
            {
             newCompositeNode(grammarAccess.getNestedExpCSRule()); 
            pushFollow(FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS9049);
            iv_ruleNestedExpCS=ruleNestedExpCS();

            state._fsp--;

             current =iv_ruleNestedExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNestedExpCS9059); 

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
    // $ANTLR end "entryRuleNestedExpCS"


    // $ANTLR start "ruleNestedExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3927:1: ruleNestedExpCS returns [EObject current=null] : (otherlv_0= '(' ( (lv_source_1_0= ruleExpressCS ) ) otherlv_2= ')' ) ;
    public final EObject ruleNestedExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_source_1_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3930:28: ( (otherlv_0= '(' ( (lv_source_1_0= ruleExpressCS ) ) otherlv_2= ')' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3931:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpressCS ) ) otherlv_2= ')' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3931:1: (otherlv_0= '(' ( (lv_source_1_0= ruleExpressCS ) ) otherlv_2= ')' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3931:3: otherlv_0= '(' ( (lv_source_1_0= ruleExpressCS ) ) otherlv_2= ')'
            {
            otherlv_0=(Token)match(input,22,FOLLOW_22_in_ruleNestedExpCS9096); 

                	newLeafNode(otherlv_0, grammarAccess.getNestedExpCSAccess().getLeftParenthesisKeyword_0());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3935:1: ( (lv_source_1_0= ruleExpressCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3936:1: (lv_source_1_0= ruleExpressCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3936:1: (lv_source_1_0= ruleExpressCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3937:3: lv_source_1_0= ruleExpressCS
            {
             
            	        newCompositeNode(grammarAccess.getNestedExpCSAccess().getSourceExpressCSParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpressCS_in_ruleNestedExpCS9117);
            lv_source_1_0=ruleExpressCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNestedExpCSRule());
            	        }
                   		set(
                   			current, 
                   			"source",
                    		lv_source_1_0, 
                    		"ExpressCS");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,23,FOLLOW_23_in_ruleNestedExpCS9129); 

                	newLeafNode(otherlv_2, grammarAccess.getNestedExpCSAccess().getRightParenthesisKeyword_2());
                

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
    // $ANTLR end "ruleNestedExpCS"


    // $ANTLR start "entryRuleSelfExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3965:1: entryRuleSelfExpCS returns [EObject current=null] : iv_ruleSelfExpCS= ruleSelfExpCS EOF ;
    public final EObject entryRuleSelfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSelfExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3966:2: (iv_ruleSelfExpCS= ruleSelfExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3967:2: iv_ruleSelfExpCS= ruleSelfExpCS EOF
            {
             newCompositeNode(grammarAccess.getSelfExpCSRule()); 
            pushFollow(FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS9165);
            iv_ruleSelfExpCS=ruleSelfExpCS();

            state._fsp--;

             current =iv_ruleSelfExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleSelfExpCS9175); 

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
    // $ANTLR end "entryRuleSelfExpCS"


    // $ANTLR start "ruleSelfExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3974:1: ruleSelfExpCS returns [EObject current=null] : ( () otherlv_1= 'self' ) ;
    public final EObject ruleSelfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3977:28: ( ( () otherlv_1= 'self' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3978:1: ( () otherlv_1= 'self' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3978:1: ( () otherlv_1= 'self' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3978:2: () otherlv_1= 'self'
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3978:2: ()
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3979:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getSelfExpCSAccess().getSelfExpCSAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,70,FOLLOW_70_in_ruleSelfExpCS9221); 

                	newLeafNode(otherlv_1, grammarAccess.getSelfExpCSAccess().getSelfKeyword_1());
                

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
    // $ANTLR end "ruleSelfExpCS"


    // $ANTLR start "entryRulePrimaryExpOrLetExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3996:1: entryRulePrimaryExpOrLetExpCS returns [EObject current=null] : iv_rulePrimaryExpOrLetExpCS= rulePrimaryExpOrLetExpCS EOF ;
    public final EObject entryRulePrimaryExpOrLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimaryExpOrLetExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3997:2: (iv_rulePrimaryExpOrLetExpCS= rulePrimaryExpOrLetExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:3998:2: iv_rulePrimaryExpOrLetExpCS= rulePrimaryExpOrLetExpCS EOF
            {
             newCompositeNode(grammarAccess.getPrimaryExpOrLetExpCSRule()); 
            pushFollow(FOLLOW_rulePrimaryExpOrLetExpCS_in_entryRulePrimaryExpOrLetExpCS9257);
            iv_rulePrimaryExpOrLetExpCS=rulePrimaryExpOrLetExpCS();

            state._fsp--;

             current =iv_rulePrimaryExpOrLetExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimaryExpOrLetExpCS9267); 

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
    // $ANTLR end "entryRulePrimaryExpOrLetExpCS"


    // $ANTLR start "rulePrimaryExpOrLetExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4005:1: rulePrimaryExpOrLetExpCS returns [EObject current=null] : this_LetExpCS_0= ruleLetExpCS ;
    public final EObject rulePrimaryExpOrLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_LetExpCS_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4008:28: (this_LetExpCS_0= ruleLetExpCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4010:5: this_LetExpCS_0= ruleLetExpCS
            {
             
                    newCompositeNode(grammarAccess.getPrimaryExpOrLetExpCSAccess().getLetExpCSParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleLetExpCS_in_rulePrimaryExpOrLetExpCS9313);
            this_LetExpCS_0=ruleLetExpCS();

            state._fsp--;

             
                    current = this_LetExpCS_0; 
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
    // $ANTLR end "rulePrimaryExpOrLetExpCS"


    // $ANTLR start "entryRuleLetExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4026:1: entryRuleLetExpCS returns [EObject current=null] : iv_ruleLetExpCS= ruleLetExpCS EOF ;
    public final EObject entryRuleLetExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4027:2: (iv_ruleLetExpCS= ruleLetExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4028:2: iv_ruleLetExpCS= ruleLetExpCS EOF
            {
             newCompositeNode(grammarAccess.getLetExpCSRule()); 
            pushFollow(FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS9347);
            iv_ruleLetExpCS=ruleLetExpCS();

            state._fsp--;

             current =iv_ruleLetExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetExpCS9357); 

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
    // $ANTLR end "entryRuleLetExpCS"


    // $ANTLR start "ruleLetExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4035:1: ruleLetExpCS returns [EObject current=null] : (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpressCS ) ) ) ;
    public final EObject ruleLetExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_variable_1_0 = null;

        EObject lv_variable_3_0 = null;

        EObject lv_in_5_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4038:28: ( (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpressCS ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4039:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpressCS ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4039:1: (otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpressCS ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4039:3: otherlv_0= 'let' ( (lv_variable_1_0= ruleLetVariableCS ) ) (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )* otherlv_4= 'in' ( (lv_in_5_0= ruleExpressCS ) )
            {
            otherlv_0=(Token)match(input,71,FOLLOW_71_in_ruleLetExpCS9394); 

                	newLeafNode(otherlv_0, grammarAccess.getLetExpCSAccess().getLetKeyword_0());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4043:1: ( (lv_variable_1_0= ruleLetVariableCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4044:1: (lv_variable_1_0= ruleLetVariableCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4044:1: (lv_variable_1_0= ruleLetVariableCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4045:3: lv_variable_1_0= ruleLetVariableCS
            {
             
            	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleLetVariableCS_in_ruleLetExpCS9415);
            lv_variable_1_0=ruleLetVariableCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
            	        }
                   		add(
                   			current, 
                   			"variable",
                    		lv_variable_1_0, 
                    		"LetVariableCS");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4061:2: (otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==18) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4061:4: otherlv_2= ',' ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    {
            	    otherlv_2=(Token)match(input,18,FOLLOW_18_in_ruleLetExpCS9428); 

            	        	newLeafNode(otherlv_2, grammarAccess.getLetExpCSAccess().getCommaKeyword_2_0());
            	        
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4065:1: ( (lv_variable_3_0= ruleLetVariableCS ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4066:1: (lv_variable_3_0= ruleLetVariableCS )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4066:1: (lv_variable_3_0= ruleLetVariableCS )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4067:3: lv_variable_3_0= ruleLetVariableCS
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getLetExpCSAccess().getVariableLetVariableCSParserRuleCall_2_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleLetVariableCS_in_ruleLetExpCS9449);
            	    lv_variable_3_0=ruleLetVariableCS();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"variable",
            	            		lv_variable_3_0, 
            	            		"LetVariableCS");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
                }
            } while (true);

            otherlv_4=(Token)match(input,72,FOLLOW_72_in_ruleLetExpCS9463); 

                	newLeafNode(otherlv_4, grammarAccess.getLetExpCSAccess().getInKeyword_3());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4087:1: ( (lv_in_5_0= ruleExpressCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4088:1: (lv_in_5_0= ruleExpressCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4088:1: (lv_in_5_0= ruleExpressCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4089:3: lv_in_5_0= ruleExpressCS
            {
             
            	        newCompositeNode(grammarAccess.getLetExpCSAccess().getInExpressCSParserRuleCall_4_0()); 
            	    
            pushFollow(FOLLOW_ruleExpressCS_in_ruleLetExpCS9484);
            lv_in_5_0=ruleExpressCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLetExpCSRule());
            	        }
                   		set(
                   			current, 
                   			"in",
                    		lv_in_5_0, 
                    		"ExpressCS");
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
    // $ANTLR end "ruleLetExpCS"


    // $ANTLR start "entryRuleLetVariableCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4113:1: entryRuleLetVariableCS returns [EObject current=null] : iv_ruleLetVariableCS= ruleLetVariableCS EOF ;
    public final EObject entryRuleLetVariableCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetVariableCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4114:2: (iv_ruleLetVariableCS= ruleLetVariableCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4115:2: iv_ruleLetVariableCS= ruleLetVariableCS EOF
            {
             newCompositeNode(grammarAccess.getLetVariableCSRule()); 
            pushFollow(FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS9520);
            iv_ruleLetVariableCS=ruleLetVariableCS();

            state._fsp--;

             current =iv_ruleLetVariableCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLetVariableCS9530); 

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
    // $ANTLR end "entryRuleLetVariableCS"


    // $ANTLR start "ruleLetVariableCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4122:1: ruleLetVariableCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpressCS ) ) ) ;
    public final EObject ruleLetVariableCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4125:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpressCS ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4126:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpressCS ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4126:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpressCS ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4126:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpressCS ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4126:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4127:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4127:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4128:3: lv_name_0_0= ruleUnrestrictedName
            {
             
            	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS9576);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"UnrestrictedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4144:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt58=2;
            int LA58_0 = input.LA(1);

            if ( (LA58_0==17) ) {
                alt58=1;
            }
            switch (alt58) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4144:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleLetVariableCS9589); 

                        	newLeafNode(otherlv_1, grammarAccess.getLetVariableCSAccess().getColonKeyword_1_0());
                        
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4148:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4149:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4149:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4150:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                     
                    	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS9610);
                    lv_ownedType_2_0=ruleTypeExpCS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
                    	        }
                           		set(
                           			current, 
                           			"ownedType",
                            		lv_ownedType_2_0, 
                            		"TypeExpCS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,39,FOLLOW_39_in_ruleLetVariableCS9624); 

                	newLeafNode(otherlv_3, grammarAccess.getLetVariableCSAccess().getEqualsSignKeyword_2());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4170:1: ( (lv_initExpression_4_0= ruleExpressCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4171:1: (lv_initExpression_4_0= ruleExpressCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4171:1: (lv_initExpression_4_0= ruleExpressCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4172:3: lv_initExpression_4_0= ruleExpressCS
            {
             
            	        newCompositeNode(grammarAccess.getLetVariableCSAccess().getInitExpressionExpressCSParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpressCS_in_ruleLetVariableCS9645);
            lv_initExpression_4_0=ruleExpressCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLetVariableCSRule());
            	        }
                   		set(
                   			current, 
                   			"initExpression",
                    		lv_initExpression_4_0, 
                    		"ExpressCS");
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
    // $ANTLR end "ruleLetVariableCS"


    // $ANTLR start "entryRuleNavigatingArgCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4196:1: entryRuleNavigatingArgCS returns [EObject current=null] : iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF ;
    public final EObject entryRuleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4197:2: (iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4198:2: iv_ruleNavigatingArgCS= ruleNavigatingArgCS EOF
            {
             newCompositeNode(grammarAccess.getNavigatingArgCSRule()); 
            pushFollow(FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS9681);
            iv_ruleNavigatingArgCS=ruleNavigatingArgCS();

            state._fsp--;

             current =iv_ruleNavigatingArgCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNavigatingArgCS9691); 

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
    // $ANTLR end "entryRuleNavigatingArgCS"


    // $ANTLR start "ruleNavigatingArgCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4205:1: ruleNavigatingArgCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpressCS ) ) )? )? ) ;
    public final EObject ruleNavigatingArgCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_init_4_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4208:28: ( ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpressCS ) ) )? )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4209:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpressCS ) ) )? )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4209:1: ( ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpressCS ) ) )? )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4209:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpressCS ) ) )? )?
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4209:2: ( (lv_name_0_0= ruleNavigatingArgExpCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4210:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4210:1: (lv_name_0_0= ruleNavigatingArgExpCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4211:3: lv_name_0_0= ruleNavigatingArgExpCS
            {
             
            	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS9737);
            lv_name_0_0=ruleNavigatingArgExpCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"NavigatingArgExpCS");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4227:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpressCS ) ) )? )?
            int alt60=2;
            int LA60_0 = input.LA(1);

            if ( (LA60_0==17) ) {
                alt60=1;
            }
            switch (alt60) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4227:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) (otherlv_3= '=' ( (lv_init_4_0= ruleExpressCS ) ) )?
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleNavigatingArgCS9750); 

                        	newLeafNode(otherlv_1, grammarAccess.getNavigatingArgCSAccess().getColonKeyword_1_0());
                        
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4231:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4232:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4232:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4233:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                     
                    	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS9771);
                    lv_ownedType_2_0=ruleTypeExpCS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                    	        }
                           		set(
                           			current, 
                           			"ownedType",
                            		lv_ownedType_2_0, 
                            		"TypeExpCS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4249:2: (otherlv_3= '=' ( (lv_init_4_0= ruleExpressCS ) ) )?
                    int alt59=2;
                    int LA59_0 = input.LA(1);

                    if ( (LA59_0==39) ) {
                        alt59=1;
                    }
                    switch (alt59) {
                        case 1 :
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4249:4: otherlv_3= '=' ( (lv_init_4_0= ruleExpressCS ) )
                            {
                            otherlv_3=(Token)match(input,39,FOLLOW_39_in_ruleNavigatingArgCS9784); 

                                	newLeafNode(otherlv_3, grammarAccess.getNavigatingArgCSAccess().getEqualsSignKeyword_1_2_0());
                                
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4253:1: ( (lv_init_4_0= ruleExpressCS ) )
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4254:1: (lv_init_4_0= ruleExpressCS )
                            {
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4254:1: (lv_init_4_0= ruleExpressCS )
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4255:3: lv_init_4_0= ruleExpressCS
                            {
                             
                            	        newCompositeNode(grammarAccess.getNavigatingArgCSAccess().getInitExpressCSParserRuleCall_1_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleExpressCS_in_ruleNavigatingArgCS9805);
                            lv_init_4_0=ruleExpressCS();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getNavigatingArgCSRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"init",
                                    		lv_init_4_0, 
                                    		"ExpressCS");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

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
    // $ANTLR end "ruleNavigatingArgCS"


    // $ANTLR start "entryRuleNavigatingBarArgCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4279:1: entryRuleNavigatingBarArgCS returns [EObject current=null] : iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF ;
    public final EObject entryRuleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingBarArgCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4280:2: (iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4281:2: iv_ruleNavigatingBarArgCS= ruleNavigatingBarArgCS EOF
            {
             newCompositeNode(grammarAccess.getNavigatingBarArgCSRule()); 
            pushFollow(FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS9845);
            iv_ruleNavigatingBarArgCS=ruleNavigatingBarArgCS();

            state._fsp--;

             current =iv_ruleNavigatingBarArgCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNavigatingBarArgCS9855); 

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
    // $ANTLR end "entryRuleNavigatingBarArgCS"


    // $ANTLR start "ruleNavigatingBarArgCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4288:1: ruleNavigatingBarArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )? ) ;
    public final EObject ruleNavigatingBarArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_name_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_init_5_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4291:28: ( ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4292:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4292:1: ( ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4292:2: ( (lv_prefix_0_0= '|' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )?
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4292:2: ( (lv_prefix_0_0= '|' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4293:1: (lv_prefix_0_0= '|' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4293:1: (lv_prefix_0_0= '|' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4294:3: lv_prefix_0_0= '|'
            {
            lv_prefix_0_0=(Token)match(input,73,FOLLOW_73_in_ruleNavigatingBarArgCS9898); 

                    newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingBarArgCSAccess().getPrefixVerticalLineKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNavigatingBarArgCSRule());
            	        }
                   		setWithLastConsumed(current, "prefix", lv_prefix_0_0, "|");
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4307:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4308:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4308:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4309:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
             
            	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS9932);
            lv_name_1_0=ruleNavigatingArgExpCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"NavigatingArgExpCS");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4325:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==17) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4325:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleNavigatingBarArgCS9945); 

                        	newLeafNode(otherlv_2, grammarAccess.getNavigatingBarArgCSAccess().getColonKeyword_2_0());
                        
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4329:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4330:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4330:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4331:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                     
                    	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS9966);
                    lv_ownedType_3_0=ruleTypeExpCS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
                    	        }
                           		set(
                           			current, 
                           			"ownedType",
                            		lv_ownedType_3_0, 
                            		"TypeExpCS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4347:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )?
                    int alt61=2;
                    int LA61_0 = input.LA(1);

                    if ( (LA61_0==39) ) {
                        alt61=1;
                    }
                    switch (alt61) {
                        case 1 :
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4347:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) )
                            {
                            otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleNavigatingBarArgCS9979); 

                                	newLeafNode(otherlv_4, grammarAccess.getNavigatingBarArgCSAccess().getEqualsSignKeyword_2_2_0());
                                
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4351:1: ( (lv_init_5_0= ruleExpressCS ) )
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4352:1: (lv_init_5_0= ruleExpressCS )
                            {
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4352:1: (lv_init_5_0= ruleExpressCS )
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4353:3: lv_init_5_0= ruleExpressCS
                            {
                             
                            	        newCompositeNode(grammarAccess.getNavigatingBarArgCSAccess().getInitExpressCSParserRuleCall_2_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleExpressCS_in_ruleNavigatingBarArgCS10000);
                            lv_init_5_0=ruleExpressCS();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getNavigatingBarArgCSRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"init",
                                    		lv_init_5_0, 
                                    		"ExpressCS");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

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
    // $ANTLR end "ruleNavigatingBarArgCS"


    // $ANTLR start "entryRuleNavigatingSemiArgCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4377:1: entryRuleNavigatingSemiArgCS returns [EObject current=null] : iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF ;
    public final EObject entryRuleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingSemiArgCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4378:2: (iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4379:2: iv_ruleNavigatingSemiArgCS= ruleNavigatingSemiArgCS EOF
            {
             newCompositeNode(grammarAccess.getNavigatingSemiArgCSRule()); 
            pushFollow(FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS10040);
            iv_ruleNavigatingSemiArgCS=ruleNavigatingSemiArgCS();

            state._fsp--;

             current =iv_ruleNavigatingSemiArgCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS10050); 

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
    // $ANTLR end "entryRuleNavigatingSemiArgCS"


    // $ANTLR start "ruleNavigatingSemiArgCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4386:1: ruleNavigatingSemiArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )? ) ;
    public final EObject ruleNavigatingSemiArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_name_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_init_5_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4389:28: ( ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4390:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4390:1: ( ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4390:2: ( (lv_prefix_0_0= ';' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )?
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4390:2: ( (lv_prefix_0_0= ';' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4391:1: (lv_prefix_0_0= ';' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4391:1: (lv_prefix_0_0= ';' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4392:3: lv_prefix_0_0= ';'
            {
            lv_prefix_0_0=(Token)match(input,14,FOLLOW_14_in_ruleNavigatingSemiArgCS10093); 

                    newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingSemiArgCSAccess().getPrefixSemicolonKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNavigatingSemiArgCSRule());
            	        }
                   		setWithLastConsumed(current, "prefix", lv_prefix_0_0, ";");
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4405:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4406:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4406:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4407:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
             
            	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS10127);
            lv_name_1_0=ruleNavigatingArgExpCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"NavigatingArgExpCS");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4423:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==17) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4423:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleNavigatingSemiArgCS10140); 

                        	newLeafNode(otherlv_2, grammarAccess.getNavigatingSemiArgCSAccess().getColonKeyword_2_0());
                        
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4427:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4428:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4428:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4429:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                     
                    	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS10161);
                    lv_ownedType_3_0=ruleTypeExpCS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
                    	        }
                           		set(
                           			current, 
                           			"ownedType",
                            		lv_ownedType_3_0, 
                            		"TypeExpCS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4445:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )?
                    int alt63=2;
                    int LA63_0 = input.LA(1);

                    if ( (LA63_0==39) ) {
                        alt63=1;
                    }
                    switch (alt63) {
                        case 1 :
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4445:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) )
                            {
                            otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleNavigatingSemiArgCS10174); 

                                	newLeafNode(otherlv_4, grammarAccess.getNavigatingSemiArgCSAccess().getEqualsSignKeyword_2_2_0());
                                
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4449:1: ( (lv_init_5_0= ruleExpressCS ) )
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4450:1: (lv_init_5_0= ruleExpressCS )
                            {
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4450:1: (lv_init_5_0= ruleExpressCS )
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4451:3: lv_init_5_0= ruleExpressCS
                            {
                             
                            	        newCompositeNode(grammarAccess.getNavigatingSemiArgCSAccess().getInitExpressCSParserRuleCall_2_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleExpressCS_in_ruleNavigatingSemiArgCS10195);
                            lv_init_5_0=ruleExpressCS();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getNavigatingSemiArgCSRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"init",
                                    		lv_init_5_0, 
                                    		"ExpressCS");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

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
    // $ANTLR end "ruleNavigatingSemiArgCS"


    // $ANTLR start "entryRuleNavigatingArgExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4475:1: entryRuleNavigatingArgExpCS returns [EObject current=null] : iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF ;
    public final EObject entryRuleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingArgExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4476:2: (iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4477:2: iv_ruleNavigatingArgExpCS= ruleNavigatingArgExpCS EOF
            {
             newCompositeNode(grammarAccess.getNavigatingArgExpCSRule()); 
            pushFollow(FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS10235);
            iv_ruleNavigatingArgExpCS=ruleNavigatingArgExpCS();

            state._fsp--;

             current =iv_ruleNavigatingArgExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNavigatingArgExpCS10245); 

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
    // $ANTLR end "entryRuleNavigatingArgExpCS"


    // $ANTLR start "ruleNavigatingArgExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4484:1: ruleNavigatingArgExpCS returns [EObject current=null] : this_ExpressCS_0= ruleExpressCS ;
    public final EObject ruleNavigatingArgExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_ExpressCS_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4487:28: (this_ExpressCS_0= ruleExpressCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4489:5: this_ExpressCS_0= ruleExpressCS
            {
             
                    newCompositeNode(grammarAccess.getNavigatingArgExpCSAccess().getExpressCSParserRuleCall()); 
                
            pushFollow(FOLLOW_ruleExpressCS_in_ruleNavigatingArgExpCS10291);
            this_ExpressCS_0=ruleExpressCS();

            state._fsp--;

             
                    current = this_ExpressCS_0; 
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
    // $ANTLR end "ruleNavigatingArgExpCS"


    // $ANTLR start "entryRuleNavigatingCommaArgCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4505:1: entryRuleNavigatingCommaArgCS returns [EObject current=null] : iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF ;
    public final EObject entryRuleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNavigatingCommaArgCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4506:2: (iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4507:2: iv_ruleNavigatingCommaArgCS= ruleNavigatingCommaArgCS EOF
            {
             newCompositeNode(grammarAccess.getNavigatingCommaArgCSRule()); 
            pushFollow(FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS10325);
            iv_ruleNavigatingCommaArgCS=ruleNavigatingCommaArgCS();

            state._fsp--;

             current =iv_ruleNavigatingCommaArgCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS10335); 

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
    // $ANTLR end "entryRuleNavigatingCommaArgCS"


    // $ANTLR start "ruleNavigatingCommaArgCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4514:1: ruleNavigatingCommaArgCS returns [EObject current=null] : ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )? ) ;
    public final EObject ruleNavigatingCommaArgCS() throws RecognitionException {
        EObject current = null;

        Token lv_prefix_0_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_name_1_0 = null;

        EObject lv_ownedType_3_0 = null;

        EObject lv_init_5_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4517:28: ( ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )? ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4518:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )? )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4518:1: ( ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )? )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4518:2: ( (lv_prefix_0_0= ',' ) ) ( (lv_name_1_0= ruleNavigatingArgExpCS ) ) (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )?
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4518:2: ( (lv_prefix_0_0= ',' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4519:1: (lv_prefix_0_0= ',' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4519:1: (lv_prefix_0_0= ',' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4520:3: lv_prefix_0_0= ','
            {
            lv_prefix_0_0=(Token)match(input,18,FOLLOW_18_in_ruleNavigatingCommaArgCS10378); 

                    newLeafNode(lv_prefix_0_0, grammarAccess.getNavigatingCommaArgCSAccess().getPrefixCommaKeyword_0_0());
                

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNavigatingCommaArgCSRule());
            	        }
                   		setWithLastConsumed(current, "prefix", lv_prefix_0_0, ",");
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4533:2: ( (lv_name_1_0= ruleNavigatingArgExpCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4534:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4534:1: (lv_name_1_0= ruleNavigatingArgExpCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4535:3: lv_name_1_0= ruleNavigatingArgExpCS
            {
             
            	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getNameNavigatingArgExpCSParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS10412);
            lv_name_1_0=ruleNavigatingArgExpCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_1_0, 
                    		"NavigatingArgExpCS");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4551:2: (otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )? )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==17) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4551:4: otherlv_2= ':' ( (lv_ownedType_3_0= ruleTypeExpCS ) ) (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )?
                    {
                    otherlv_2=(Token)match(input,17,FOLLOW_17_in_ruleNavigatingCommaArgCS10425); 

                        	newLeafNode(otherlv_2, grammarAccess.getNavigatingCommaArgCSAccess().getColonKeyword_2_0());
                        
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4555:1: ( (lv_ownedType_3_0= ruleTypeExpCS ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4556:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4556:1: (lv_ownedType_3_0= ruleTypeExpCS )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4557:3: lv_ownedType_3_0= ruleTypeExpCS
                    {
                     
                    	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getOwnedTypeTypeExpCSParserRuleCall_2_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS10446);
                    lv_ownedType_3_0=ruleTypeExpCS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
                    	        }
                           		set(
                           			current, 
                           			"ownedType",
                            		lv_ownedType_3_0, 
                            		"TypeExpCS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4573:2: (otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) ) )?
                    int alt65=2;
                    int LA65_0 = input.LA(1);

                    if ( (LA65_0==39) ) {
                        alt65=1;
                    }
                    switch (alt65) {
                        case 1 :
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4573:4: otherlv_4= '=' ( (lv_init_5_0= ruleExpressCS ) )
                            {
                            otherlv_4=(Token)match(input,39,FOLLOW_39_in_ruleNavigatingCommaArgCS10459); 

                                	newLeafNode(otherlv_4, grammarAccess.getNavigatingCommaArgCSAccess().getEqualsSignKeyword_2_2_0());
                                
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4577:1: ( (lv_init_5_0= ruleExpressCS ) )
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4578:1: (lv_init_5_0= ruleExpressCS )
                            {
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4578:1: (lv_init_5_0= ruleExpressCS )
                            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4579:3: lv_init_5_0= ruleExpressCS
                            {
                             
                            	        newCompositeNode(grammarAccess.getNavigatingCommaArgCSAccess().getInitExpressCSParserRuleCall_2_2_1_0()); 
                            	    
                            pushFollow(FOLLOW_ruleExpressCS_in_ruleNavigatingCommaArgCS10480);
                            lv_init_5_0=ruleExpressCS();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getNavigatingCommaArgCSRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"init",
                                    		lv_init_5_0, 
                                    		"ExpressCS");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }


                            }
                            break;

                    }


                    }
                    break;

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
    // $ANTLR end "ruleNavigatingCommaArgCS"


    // $ANTLR start "entryRuleIfExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4603:1: entryRuleIfExpCS returns [EObject current=null] : iv_ruleIfExpCS= ruleIfExpCS EOF ;
    public final EObject entryRuleIfExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4604:2: (iv_ruleIfExpCS= ruleIfExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4605:2: iv_ruleIfExpCS= ruleIfExpCS EOF
            {
             newCompositeNode(grammarAccess.getIfExpCSRule()); 
            pushFollow(FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS10520);
            iv_ruleIfExpCS=ruleIfExpCS();

            state._fsp--;

             current =iv_ruleIfExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleIfExpCS10530); 

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
    // $ANTLR end "entryRuleIfExpCS"


    // $ANTLR start "ruleIfExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4612:1: ruleIfExpCS returns [EObject current=null] : (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpressCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpressCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpressCS ) ) otherlv_6= 'endif' ) ;
    public final EObject ruleIfExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        EObject lv_condition_1_0 = null;

        EObject lv_thenExpression_3_0 = null;

        EObject lv_elseExpression_5_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4615:28: ( (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpressCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpressCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpressCS ) ) otherlv_6= 'endif' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4616:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpressCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpressCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpressCS ) ) otherlv_6= 'endif' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4616:1: (otherlv_0= 'if' ( (lv_condition_1_0= ruleExpressCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpressCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpressCS ) ) otherlv_6= 'endif' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4616:3: otherlv_0= 'if' ( (lv_condition_1_0= ruleExpressCS ) ) otherlv_2= 'then' ( (lv_thenExpression_3_0= ruleExpressCS ) ) otherlv_4= 'else' ( (lv_elseExpression_5_0= ruleExpressCS ) ) otherlv_6= 'endif'
            {
            otherlv_0=(Token)match(input,74,FOLLOW_74_in_ruleIfExpCS10567); 

                	newLeafNode(otherlv_0, grammarAccess.getIfExpCSAccess().getIfKeyword_0());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4620:1: ( (lv_condition_1_0= ruleExpressCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4621:1: (lv_condition_1_0= ruleExpressCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4621:1: (lv_condition_1_0= ruleExpressCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4622:3: lv_condition_1_0= ruleExpressCS
            {
             
            	        newCompositeNode(grammarAccess.getIfExpCSAccess().getConditionExpressCSParserRuleCall_1_0()); 
            	    
            pushFollow(FOLLOW_ruleExpressCS_in_ruleIfExpCS10588);
            lv_condition_1_0=ruleExpressCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
            	        }
                   		set(
                   			current, 
                   			"condition",
                    		lv_condition_1_0, 
                    		"ExpressCS");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_2=(Token)match(input,75,FOLLOW_75_in_ruleIfExpCS10600); 

                	newLeafNode(otherlv_2, grammarAccess.getIfExpCSAccess().getThenKeyword_2());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4642:1: ( (lv_thenExpression_3_0= ruleExpressCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4643:1: (lv_thenExpression_3_0= ruleExpressCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4643:1: (lv_thenExpression_3_0= ruleExpressCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4644:3: lv_thenExpression_3_0= ruleExpressCS
            {
             
            	        newCompositeNode(grammarAccess.getIfExpCSAccess().getThenExpressionExpressCSParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpressCS_in_ruleIfExpCS10621);
            lv_thenExpression_3_0=ruleExpressCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
            	        }
                   		set(
                   			current, 
                   			"thenExpression",
                    		lv_thenExpression_3_0, 
                    		"ExpressCS");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_4=(Token)match(input,76,FOLLOW_76_in_ruleIfExpCS10633); 

                	newLeafNode(otherlv_4, grammarAccess.getIfExpCSAccess().getElseKeyword_4());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4664:1: ( (lv_elseExpression_5_0= ruleExpressCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4665:1: (lv_elseExpression_5_0= ruleExpressCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4665:1: (lv_elseExpression_5_0= ruleExpressCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4666:3: lv_elseExpression_5_0= ruleExpressCS
            {
             
            	        newCompositeNode(grammarAccess.getIfExpCSAccess().getElseExpressionExpressCSParserRuleCall_5_0()); 
            	    
            pushFollow(FOLLOW_ruleExpressCS_in_ruleIfExpCS10654);
            lv_elseExpression_5_0=ruleExpressCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getIfExpCSRule());
            	        }
                   		set(
                   			current, 
                   			"elseExpression",
                    		lv_elseExpression_5_0, 
                    		"ExpressCS");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_6=(Token)match(input,77,FOLLOW_77_in_ruleIfExpCS10666); 

                	newLeafNode(otherlv_6, grammarAccess.getIfExpCSAccess().getEndifKeyword_6());
                

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
    // $ANTLR end "ruleIfExpCS"


    // $ANTLR start "entryRuleTupleLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4694:1: entryRuleTupleLiteralExpCS returns [EObject current=null] : iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF ;
    public final EObject entryRuleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4695:2: (iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4696:2: iv_ruleTupleLiteralExpCS= ruleTupleLiteralExpCS EOF
            {
             newCompositeNode(grammarAccess.getTupleLiteralExpCSRule()); 
            pushFollow(FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS10702);
            iv_ruleTupleLiteralExpCS=ruleTupleLiteralExpCS();

            state._fsp--;

             current =iv_ruleTupleLiteralExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTupleLiteralExpCS10712); 

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
    // $ANTLR end "entryRuleTupleLiteralExpCS"


    // $ANTLR start "ruleTupleLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4703:1: ruleTupleLiteralExpCS returns [EObject current=null] : (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) ;
    public final EObject ruleTupleLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_ownedParts_2_0 = null;

        EObject lv_ownedParts_4_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4706:28: ( (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4707:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4707:1: (otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4707:3: otherlv_0= 'Tuple' otherlv_1= '{' ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) ) (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )* otherlv_5= '}'
            {
            otherlv_0=(Token)match(input,45,FOLLOW_45_in_ruleTupleLiteralExpCS10749); 

                	newLeafNode(otherlv_0, grammarAccess.getTupleLiteralExpCSAccess().getTupleKeyword_0());
                
            otherlv_1=(Token)match(input,13,FOLLOW_13_in_ruleTupleLiteralExpCS10761); 

                	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralExpCSAccess().getLeftCurlyBracketKeyword_1());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4715:1: ( (lv_ownedParts_2_0= ruleTupleLiteralPartCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4716:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4716:1: (lv_ownedParts_2_0= ruleTupleLiteralPartCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4717:3: lv_ownedParts_2_0= ruleTupleLiteralPartCS
            {
             
            	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_2_0()); 
            	    
            pushFollow(FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS10782);
            lv_ownedParts_2_0=ruleTupleLiteralPartCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTupleLiteralExpCSRule());
            	        }
                   		add(
                   			current, 
                   			"ownedParts",
                    		lv_ownedParts_2_0, 
                    		"TupleLiteralPartCS");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4733:2: (otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) ) )*
            loop67:
            do {
                int alt67=2;
                int LA67_0 = input.LA(1);

                if ( (LA67_0==18) ) {
                    alt67=1;
                }


                switch (alt67) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4733:4: otherlv_3= ',' ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    {
            	    otherlv_3=(Token)match(input,18,FOLLOW_18_in_ruleTupleLiteralExpCS10795); 

            	        	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralExpCSAccess().getCommaKeyword_3_0());
            	        
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4737:1: ( (lv_ownedParts_4_0= ruleTupleLiteralPartCS ) )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4738:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4738:1: (lv_ownedParts_4_0= ruleTupleLiteralPartCS )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4739:3: lv_ownedParts_4_0= ruleTupleLiteralPartCS
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTupleLiteralExpCSAccess().getOwnedPartsTupleLiteralPartCSParserRuleCall_3_1_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS10816);
            	    lv_ownedParts_4_0=ruleTupleLiteralPartCS();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTupleLiteralExpCSRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"ownedParts",
            	            		lv_ownedParts_4_0, 
            	            		"TupleLiteralPartCS");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop67;
                }
            } while (true);

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleTupleLiteralExpCS10830); 

                	newLeafNode(otherlv_5, grammarAccess.getTupleLiteralExpCSAccess().getRightCurlyBracketKeyword_4());
                

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
    // $ANTLR end "ruleTupleLiteralExpCS"


    // $ANTLR start "entryRuleTupleLiteralPartCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4767:1: entryRuleTupleLiteralPartCS returns [EObject current=null] : iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF ;
    public final EObject entryRuleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTupleLiteralPartCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4768:2: (iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4769:2: iv_ruleTupleLiteralPartCS= ruleTupleLiteralPartCS EOF
            {
             newCompositeNode(grammarAccess.getTupleLiteralPartCSRule()); 
            pushFollow(FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS10866);
            iv_ruleTupleLiteralPartCS=ruleTupleLiteralPartCS();

            state._fsp--;

             current =iv_ruleTupleLiteralPartCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTupleLiteralPartCS10876); 

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
    // $ANTLR end "entryRuleTupleLiteralPartCS"


    // $ANTLR start "ruleTupleLiteralPartCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4776:1: ruleTupleLiteralPartCS returns [EObject current=null] : ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpressCS ) ) ) ;
    public final EObject ruleTupleLiteralPartCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_ownedType_2_0 = null;

        EObject lv_initExpression_4_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4779:28: ( ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpressCS ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4780:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpressCS ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4780:1: ( ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpressCS ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4780:2: ( (lv_name_0_0= ruleUnrestrictedName ) ) (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )? otherlv_3= '=' ( (lv_initExpression_4_0= ruleExpressCS ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4780:2: ( (lv_name_0_0= ruleUnrestrictedName ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4781:1: (lv_name_0_0= ruleUnrestrictedName )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4781:1: (lv_name_0_0= ruleUnrestrictedName )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4782:3: lv_name_0_0= ruleUnrestrictedName
            {
             
            	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getNameUnrestrictedNameParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS10922);
            lv_name_0_0=ruleUnrestrictedName();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"UnrestrictedName");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4798:2: (otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) ) )?
            int alt68=2;
            int LA68_0 = input.LA(1);

            if ( (LA68_0==17) ) {
                alt68=1;
            }
            switch (alt68) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4798:4: otherlv_1= ':' ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    {
                    otherlv_1=(Token)match(input,17,FOLLOW_17_in_ruleTupleLiteralPartCS10935); 

                        	newLeafNode(otherlv_1, grammarAccess.getTupleLiteralPartCSAccess().getColonKeyword_1_0());
                        
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4802:1: ( (lv_ownedType_2_0= ruleTypeExpCS ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4803:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4803:1: (lv_ownedType_2_0= ruleTypeExpCS )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4804:3: lv_ownedType_2_0= ruleTypeExpCS
                    {
                     
                    	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getOwnedTypeTypeExpCSParserRuleCall_1_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS10956);
                    lv_ownedType_2_0=ruleTypeExpCS();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
                    	        }
                           		set(
                           			current, 
                           			"ownedType",
                            		lv_ownedType_2_0, 
                            		"TypeExpCS");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,39,FOLLOW_39_in_ruleTupleLiteralPartCS10970); 

                	newLeafNode(otherlv_3, grammarAccess.getTupleLiteralPartCSAccess().getEqualsSignKeyword_2());
                
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4824:1: ( (lv_initExpression_4_0= ruleExpressCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4825:1: (lv_initExpression_4_0= ruleExpressCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4825:1: (lv_initExpression_4_0= ruleExpressCS )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4826:3: lv_initExpression_4_0= ruleExpressCS
            {
             
            	        newCompositeNode(grammarAccess.getTupleLiteralPartCSAccess().getInitExpressionExpressCSParserRuleCall_3_0()); 
            	    
            pushFollow(FOLLOW_ruleExpressCS_in_ruleTupleLiteralPartCS10991);
            lv_initExpression_4_0=ruleExpressCS();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getTupleLiteralPartCSRule());
            	        }
                   		set(
                   			current, 
                   			"initExpression",
                    		lv_initExpression_4_0, 
                    		"ExpressCS");
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
    // $ANTLR end "ruleTupleLiteralPartCS"


    // $ANTLR start "entryRulePrimitiveLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4850:1: entryRulePrimitiveLiteralExpCS returns [EObject current=null] : iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF ;
    public final EObject entryRulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_rulePrimitiveLiteralExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4851:2: (iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4852:2: iv_rulePrimitiveLiteralExpCS= rulePrimitiveLiteralExpCS EOF
            {
             newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSRule()); 
            pushFollow(FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS11027);
            iv_rulePrimitiveLiteralExpCS=rulePrimitiveLiteralExpCS();

            state._fsp--;

             current =iv_rulePrimitiveLiteralExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS11037); 

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
    // $ANTLR end "entryRulePrimitiveLiteralExpCS"


    // $ANTLR start "rulePrimitiveLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4859:1: rulePrimitiveLiteralExpCS returns [EObject current=null] : (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) ;
    public final EObject rulePrimitiveLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject this_NumberLiteralExpCS_0 = null;

        EObject this_StringLiteralExpCS_1 = null;

        EObject this_BooleanLiteralExpCS_2 = null;

        EObject this_UnlimitedNaturalLiteralExpCS_3 = null;

        EObject this_InvalidLiteralExpCS_4 = null;

        EObject this_NullLiteralExpCS_5 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4862:28: ( (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4863:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4863:1: (this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS | this_StringLiteralExpCS_1= ruleStringLiteralExpCS | this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS | this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS | this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS | this_NullLiteralExpCS_5= ruleNullLiteralExpCS )
            int alt69=6;
            switch ( input.LA(1) ) {
            case RULE_INT:
                {
                alt69=1;
                }
                break;
            case RULE_ID:
                {
                alt69=2;
                }
                break;
            case 33:
            case 34:
                {
                alt69=3;
                }
                break;
            case 40:
                {
                alt69=4;
                }
                break;
            case 78:
                {
                alt69=5;
                }
                break;
            case 79:
                {
                alt69=6;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 69, 0, input);

                throw nvae;
            }

            switch (alt69) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4864:5: this_NumberLiteralExpCS_0= ruleNumberLiteralExpCS
                    {
                     
                            newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNumberLiteralExpCSParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS11084);
                    this_NumberLiteralExpCS_0=ruleNumberLiteralExpCS();

                    state._fsp--;

                     
                            current = this_NumberLiteralExpCS_0; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4874:5: this_StringLiteralExpCS_1= ruleStringLiteralExpCS
                    {
                     
                            newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getStringLiteralExpCSParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS11111);
                    this_StringLiteralExpCS_1=ruleStringLiteralExpCS();

                    state._fsp--;

                     
                            current = this_StringLiteralExpCS_1; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 3 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4884:5: this_BooleanLiteralExpCS_2= ruleBooleanLiteralExpCS
                    {
                     
                            newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getBooleanLiteralExpCSParserRuleCall_2()); 
                        
                    pushFollow(FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS11138);
                    this_BooleanLiteralExpCS_2=ruleBooleanLiteralExpCS();

                    state._fsp--;

                     
                            current = this_BooleanLiteralExpCS_2; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 4 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4894:5: this_UnlimitedNaturalLiteralExpCS_3= ruleUnlimitedNaturalLiteralExpCS
                    {
                     
                            newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSParserRuleCall_3()); 
                        
                    pushFollow(FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS11165);
                    this_UnlimitedNaturalLiteralExpCS_3=ruleUnlimitedNaturalLiteralExpCS();

                    state._fsp--;

                     
                            current = this_UnlimitedNaturalLiteralExpCS_3; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 5 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4904:5: this_InvalidLiteralExpCS_4= ruleInvalidLiteralExpCS
                    {
                     
                            newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getInvalidLiteralExpCSParserRuleCall_4()); 
                        
                    pushFollow(FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS11192);
                    this_InvalidLiteralExpCS_4=ruleInvalidLiteralExpCS();

                    state._fsp--;

                     
                            current = this_InvalidLiteralExpCS_4; 
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 6 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4914:5: this_NullLiteralExpCS_5= ruleNullLiteralExpCS
                    {
                     
                            newCompositeNode(grammarAccess.getPrimitiveLiteralExpCSAccess().getNullLiteralExpCSParserRuleCall_5()); 
                        
                    pushFollow(FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS11219);
                    this_NullLiteralExpCS_5=ruleNullLiteralExpCS();

                    state._fsp--;

                     
                            current = this_NullLiteralExpCS_5; 
                            afterParserOrEnumRuleCall();
                        

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
    // $ANTLR end "rulePrimitiveLiteralExpCS"


    // $ANTLR start "entryRuleNumberLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4930:1: entryRuleNumberLiteralExpCS returns [EObject current=null] : iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF ;
    public final EObject entryRuleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNumberLiteralExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4931:2: (iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4932:2: iv_ruleNumberLiteralExpCS= ruleNumberLiteralExpCS EOF
            {
             newCompositeNode(grammarAccess.getNumberLiteralExpCSRule()); 
            pushFollow(FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS11254);
            iv_ruleNumberLiteralExpCS=ruleNumberLiteralExpCS();

            state._fsp--;

             current =iv_ruleNumberLiteralExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNumberLiteralExpCS11264); 

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
    // $ANTLR end "entryRuleNumberLiteralExpCS"


    // $ANTLR start "ruleNumberLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4939:1: ruleNumberLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) ;
    public final EObject ruleNumberLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject lv_name_0_0 = null;


         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4942:28: ( ( (lv_name_0_0= ruleNUMBER_LITERAL ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4943:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4943:1: ( (lv_name_0_0= ruleNUMBER_LITERAL ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4944:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4944:1: (lv_name_0_0= ruleNUMBER_LITERAL )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4945:3: lv_name_0_0= ruleNUMBER_LITERAL
            {
             
            	        newCompositeNode(grammarAccess.getNumberLiteralExpCSAccess().getNameNUMBER_LITERALParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS11309);
            lv_name_0_0=ruleNUMBER_LITERAL();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getNumberLiteralExpCSRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"NUMBER_LITERAL");
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
    // $ANTLR end "ruleNumberLiteralExpCS"


    // $ANTLR start "entryRuleNUMBER_LITERAL"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4969:1: entryRuleNUMBER_LITERAL returns [EObject current=null] : iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF ;
    public final EObject entryRuleNUMBER_LITERAL() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNUMBER_LITERAL = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4970:2: (iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4971:2: iv_ruleNUMBER_LITERAL= ruleNUMBER_LITERAL EOF
            {
             newCompositeNode(grammarAccess.getNUMBER_LITERALRule()); 
            pushFollow(FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL11344);
            iv_ruleNUMBER_LITERAL=ruleNUMBER_LITERAL();

            state._fsp--;

             current =iv_ruleNUMBER_LITERAL; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNUMBER_LITERAL11354); 

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
    // $ANTLR end "entryRuleNUMBER_LITERAL"


    // $ANTLR start "ruleNUMBER_LITERAL"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4978:1: ruleNUMBER_LITERAL returns [EObject current=null] : ( (lv_number_0_0= RULE_INT ) ) ;
    public final EObject ruleNUMBER_LITERAL() throws RecognitionException {
        EObject current = null;

        Token lv_number_0_0=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4981:28: ( ( (lv_number_0_0= RULE_INT ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4982:1: ( (lv_number_0_0= RULE_INT ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4982:1: ( (lv_number_0_0= RULE_INT ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4983:1: (lv_number_0_0= RULE_INT )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4983:1: (lv_number_0_0= RULE_INT )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:4984:3: lv_number_0_0= RULE_INT
            {
            lv_number_0_0=(Token)match(input,RULE_INT,FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL11395); 

            			newLeafNode(lv_number_0_0, grammarAccess.getNUMBER_LITERALAccess().getNumberINTTerminalRuleCall_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getNUMBER_LITERALRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"number",
                    		lv_number_0_0, 
                    		"INT");
            	    

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
    // $ANTLR end "ruleNUMBER_LITERAL"


    // $ANTLR start "entryRuleStringLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5008:1: entryRuleStringLiteralExpCS returns [EObject current=null] : iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF ;
    public final EObject entryRuleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStringLiteralExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5009:2: (iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5010:2: iv_ruleStringLiteralExpCS= ruleStringLiteralExpCS EOF
            {
             newCompositeNode(grammarAccess.getStringLiteralExpCSRule()); 
            pushFollow(FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS11435);
            iv_ruleStringLiteralExpCS=ruleStringLiteralExpCS();

            state._fsp--;

             current =iv_ruleStringLiteralExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleStringLiteralExpCS11445); 

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
    // $ANTLR end "entryRuleStringLiteralExpCS"


    // $ANTLR start "ruleStringLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5017:1: ruleStringLiteralExpCS returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) )+ ;
    public final EObject ruleStringLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5020:28: ( ( (lv_name_0_0= RULE_ID ) )+ )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5021:1: ( (lv_name_0_0= RULE_ID ) )+
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5021:1: ( (lv_name_0_0= RULE_ID ) )+
            int cnt70=0;
            loop70:
            do {
                int alt70=2;
                int LA70_0 = input.LA(1);

                if ( (LA70_0==RULE_ID) ) {
                    alt70=1;
                }


                switch (alt70) {
            	case 1 :
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5022:1: (lv_name_0_0= RULE_ID )
            	    {
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5022:1: (lv_name_0_0= RULE_ID )
            	    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5023:3: lv_name_0_0= RULE_ID
            	    {
            	    lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleStringLiteralExpCS11486); 

            	    			newLeafNode(lv_name_0_0, grammarAccess.getStringLiteralExpCSAccess().getNameIDTerminalRuleCall_0()); 
            	    		

            	    	        if (current==null) {
            	    	            current = createModelElement(grammarAccess.getStringLiteralExpCSRule());
            	    	        }
            	           		addWithLastConsumed(
            	           			current, 
            	           			"name",
            	            		lv_name_0_0, 
            	            		"ID");
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    if ( cnt70 >= 1 ) break loop70;
                        EarlyExitException eee =
                            new EarlyExitException(70, input);
                        throw eee;
                }
                cnt70++;
            } while (true);


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
    // $ANTLR end "ruleStringLiteralExpCS"


    // $ANTLR start "entryRuleBooleanLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5047:1: entryRuleBooleanLiteralExpCS returns [EObject current=null] : iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF ;
    public final EObject entryRuleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBooleanLiteralExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5048:2: (iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5049:2: iv_ruleBooleanLiteralExpCS= ruleBooleanLiteralExpCS EOF
            {
             newCompositeNode(grammarAccess.getBooleanLiteralExpCSRule()); 
            pushFollow(FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS11527);
            iv_ruleBooleanLiteralExpCS=ruleBooleanLiteralExpCS();

            state._fsp--;

             current =iv_ruleBooleanLiteralExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS11537); 

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
    // $ANTLR end "entryRuleBooleanLiteralExpCS"


    // $ANTLR start "ruleBooleanLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5056:1: ruleBooleanLiteralExpCS returns [EObject current=null] : ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) ;
    public final EObject ruleBooleanLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token lv_name_1_0=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5059:28: ( ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5060:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5060:1: ( ( (lv_name_0_0= 'true' ) ) | ( (lv_name_1_0= 'false' ) ) )
            int alt71=2;
            int LA71_0 = input.LA(1);

            if ( (LA71_0==33) ) {
                alt71=1;
            }
            else if ( (LA71_0==34) ) {
                alt71=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 71, 0, input);

                throw nvae;
            }
            switch (alt71) {
                case 1 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5060:2: ( (lv_name_0_0= 'true' ) )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5060:2: ( (lv_name_0_0= 'true' ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5061:1: (lv_name_0_0= 'true' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5061:1: (lv_name_0_0= 'true' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5062:3: lv_name_0_0= 'true'
                    {
                    lv_name_0_0=(Token)match(input,33,FOLLOW_33_in_ruleBooleanLiteralExpCS11580); 

                            newLeafNode(lv_name_0_0, grammarAccess.getBooleanLiteralExpCSAccess().getNameTrueKeyword_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_0_0, "true");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5076:6: ( (lv_name_1_0= 'false' ) )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5076:6: ( (lv_name_1_0= 'false' ) )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5077:1: (lv_name_1_0= 'false' )
                    {
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5077:1: (lv_name_1_0= 'false' )
                    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5078:3: lv_name_1_0= 'false'
                    {
                    lv_name_1_0=(Token)match(input,34,FOLLOW_34_in_ruleBooleanLiteralExpCS11617); 

                            newLeafNode(lv_name_1_0, grammarAccess.getBooleanLiteralExpCSAccess().getNameFalseKeyword_1_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getBooleanLiteralExpCSRule());
                    	        }
                           		setWithLastConsumed(current, "name", lv_name_1_0, "false");
                    	    

                    }


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
    // $ANTLR end "ruleBooleanLiteralExpCS"


    // $ANTLR start "entryRuleUnlimitedNaturalLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5099:1: entryRuleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF ;
    public final EObject entryRuleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleUnlimitedNaturalLiteralExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5100:2: (iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5101:2: iv_ruleUnlimitedNaturalLiteralExpCS= ruleUnlimitedNaturalLiteralExpCS EOF
            {
             newCompositeNode(grammarAccess.getUnlimitedNaturalLiteralExpCSRule()); 
            pushFollow(FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS11666);
            iv_ruleUnlimitedNaturalLiteralExpCS=ruleUnlimitedNaturalLiteralExpCS();

            state._fsp--;

             current =iv_ruleUnlimitedNaturalLiteralExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS11676); 

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
    // $ANTLR end "entryRuleUnlimitedNaturalLiteralExpCS"


    // $ANTLR start "ruleUnlimitedNaturalLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5108:1: ruleUnlimitedNaturalLiteralExpCS returns [EObject current=null] : ( () otherlv_1= '*' ) ;
    public final EObject ruleUnlimitedNaturalLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5111:28: ( ( () otherlv_1= '*' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5112:1: ( () otherlv_1= '*' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5112:1: ( () otherlv_1= '*' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5112:2: () otherlv_1= '*'
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5112:2: ()
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5113:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getUnlimitedNaturalLiteralExpCSAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,40,FOLLOW_40_in_ruleUnlimitedNaturalLiteralExpCS11722); 

                	newLeafNode(otherlv_1, grammarAccess.getUnlimitedNaturalLiteralExpCSAccess().getAsteriskKeyword_1());
                

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
    // $ANTLR end "ruleUnlimitedNaturalLiteralExpCS"


    // $ANTLR start "entryRuleInvalidLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5130:1: entryRuleInvalidLiteralExpCS returns [EObject current=null] : iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF ;
    public final EObject entryRuleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleInvalidLiteralExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5131:2: (iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5132:2: iv_ruleInvalidLiteralExpCS= ruleInvalidLiteralExpCS EOF
            {
             newCompositeNode(grammarAccess.getInvalidLiteralExpCSRule()); 
            pushFollow(FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS11758);
            iv_ruleInvalidLiteralExpCS=ruleInvalidLiteralExpCS();

            state._fsp--;

             current =iv_ruleInvalidLiteralExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS11768); 

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
    // $ANTLR end "entryRuleInvalidLiteralExpCS"


    // $ANTLR start "ruleInvalidLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5139:1: ruleInvalidLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'invalid' ) ;
    public final EObject ruleInvalidLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5142:28: ( ( () otherlv_1= 'invalid' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5143:1: ( () otherlv_1= 'invalid' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5143:1: ( () otherlv_1= 'invalid' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5143:2: () otherlv_1= 'invalid'
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5143:2: ()
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5144:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getInvalidLiteralExpCSAccess().getInvalidLiteralExpCSAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,78,FOLLOW_78_in_ruleInvalidLiteralExpCS11814); 

                	newLeafNode(otherlv_1, grammarAccess.getInvalidLiteralExpCSAccess().getInvalidKeyword_1());
                

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
    // $ANTLR end "ruleInvalidLiteralExpCS"


    // $ANTLR start "entryRuleNullLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5161:1: entryRuleNullLiteralExpCS returns [EObject current=null] : iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF ;
    public final EObject entryRuleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleNullLiteralExpCS = null;


        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5162:2: (iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5163:2: iv_ruleNullLiteralExpCS= ruleNullLiteralExpCS EOF
            {
             newCompositeNode(grammarAccess.getNullLiteralExpCSRule()); 
            pushFollow(FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS11850);
            iv_ruleNullLiteralExpCS=ruleNullLiteralExpCS();

            state._fsp--;

             current =iv_ruleNullLiteralExpCS; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleNullLiteralExpCS11860); 

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
    // $ANTLR end "entryRuleNullLiteralExpCS"


    // $ANTLR start "ruleNullLiteralExpCS"
    // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5170:1: ruleNullLiteralExpCS returns [EObject current=null] : ( () otherlv_1= 'null' ) ;
    public final EObject ruleNullLiteralExpCS() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;

         enterRule(); 
            
        try {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5173:28: ( ( () otherlv_1= 'null' ) )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5174:1: ( () otherlv_1= 'null' )
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5174:1: ( () otherlv_1= 'null' )
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5174:2: () otherlv_1= 'null'
            {
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5174:2: ()
            // ../fr.tpt.aadl.ramses.transformation.trc.xtext/src-gen/fr/tpt/aadl/ramses/transformation/trc/xtext/parser/antlr/internal/InternalTRC.g:5175:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getNullLiteralExpCSAccess().getNullLiteralExpCSAction_0(),
                        current);
                

            }

            otherlv_1=(Token)match(input,79,FOLLOW_79_in_ruleNullLiteralExpCS11906); 

                	newLeafNode(otherlv_1, grammarAccess.getNullLiteralExpCSAccess().getNullKeyword_1());
                

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
    // $ANTLR end "ruleNullLiteralExpCS"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleTrcSpecification_in_entryRuleTrcSpecification75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTrcSpecification85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModuleList_in_ruleTrcSpecification131 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_ruleTransformationList_in_ruleTrcSpecification152 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_ruleTransformationDependencyList_in_ruleTrcSpecification173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruletrcRule_in_entryRuletrcRule209 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuletrcRule219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_ruletrcRule264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleModuleList_in_entryRuleModuleList299 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModuleList309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleModuleList346 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleModuleList358 = new BitSet(new long[]{0x000000000000C030L});
    public static final BitSet FOLLOW_ruleModule_in_ruleModuleList379 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleModuleList392 = new BitSet(new long[]{0x000000000000C030L});
    public static final BitSet FOLLOW_ruleModule_in_ruleModuleList413 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleModuleList427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName464 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName515 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleQualifiedName534 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleQualifiedName549 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_ruleModule_in_entryRuleModule596 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleModule606 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_ruleModule662 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleModule674 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruletrcRule_in_ruleModule695 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_18_in_ruleModule708 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruletrcRule_in_ruleModule729 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_ruleTransformationList_in_entryRuleTransformationList769 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationList779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleTransformationList816 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTransformationList828 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTransformation_in_ruleTransformationList849 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_18_in_ruleTransformationList862 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleTransformation_in_ruleTransformationList883 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_ruleTransformationList897 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformation_in_entryRuleTransformation933 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformation943 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformation989 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTransformation1001 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_20_in_ruleTransformation1013 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTransformation1025 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransformation1045 = new BitSet(new long[]{0x0000000000248000L});
    public static final BitSet FOLLOW_18_in_ruleTransformation1058 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleTransformation1078 = new BitSet(new long[]{0x0000000000248000L});
    public static final BitSet FOLLOW_21_in_ruleTransformation1093 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTransformation1105 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_ruleTransformation1126 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_18_in_ruleTransformation1139 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_ruleTransformation1160 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_ruleTransformation1176 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationImpact_in_entryRuleTransformationImpact1212 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationImpact1222 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleTransformationImpact1259 = new BitSet(new long[]{0x0000000100000070L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationImpact1281 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTransformationImpact1293 = new BitSet(new long[]{0x0000000100000070L});
    public static final BitSet FOLLOW_ruleEInt_in_ruleTransformationImpact1316 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleTransformationImpact1328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependencyList_in_entryRuleTransformationDependencyList1364 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationDependencyList1374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_ruleTransformationDependencyList1411 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTransformationDependencyList1423 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationDependencyList1444 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTransformationDependencyList1456 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_ruleTransformationDependencyList1477 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_14_in_ruleTransformationDependencyList1490 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_ruleTransformationDependencyList1511 = new BitSet(new long[]{0x000000000000C000L});
    public static final BitSet FOLLOW_15_in_ruleTransformationDependencyList1525 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleTransformationDependencyList1537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTransformationDependency_in_entryRuleTransformationDependency1573 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTransformationDependency1583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleTransformationDependency1620 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_22_in_ruleTransformationDependency1632 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationDependency1655 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_ruleTransformationDependency1667 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleTransformationDependency1690 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_ruleTransformationDependency1702 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTransformationDependency1714 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationDependency1735 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_18_in_ruleTransformationDependency1748 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_ruleTransformationDependency1769 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_ruleTransformationDependency1783 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleTransformationDependency1795 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleTransformationDependency1807 = new BitSet(new long[]{0x00000000C0000000L});
    public static final BitSet FOLLOW_ruleRuleDependency_in_ruleTransformationDependency1828 = new BitSet(new long[]{0x0000000030000000L});
    public static final BitSet FOLLOW_ruleBooleanOperations_in_ruleTransformationDependency1849 = new BitSet(new long[]{0x00000000C8000000L});
    public static final BitSet FOLLOW_ruleRuleDependency_in_ruleTransformationDependency1870 = new BitSet(new long[]{0x00000000C8000000L});
    public static final BitSet FOLLOW_27_in_ruleTransformationDependency1883 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanOperations_in_entryRuleBooleanOperations1919 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanOperations1929 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleBooleanOperations1973 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleBooleanOperations2002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleRuleDependency_in_entryRuleRuleDependency2053 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleRuleDependency2063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyWord_in_ruleRuleDependency2109 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rulerequiresOrExcludeDependency_in_ruleRuleDependency2130 = new BitSet(new long[]{0x0000000030000002L});
    public static final BitSet FOLLOW_ruleBooleanOperations_in_ruleRuleDependency2152 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rulerequiresOrExcludeDependency_in_ruleRuleDependency2173 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleKeyWord_in_entryRuleKeyWord2211 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleKeyWord2221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_30_in_ruleKeyWord2265 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_31_in_ruleKeyWord2294 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulerequiresOrExcludeDependency_in_entryRulerequiresOrExcludeDependency2345 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulerequiresOrExcludeDependency2355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rulerequiresOrExcludeDependency2392 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_rulerequiresOrExcludeDependency2415 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_16_in_rulerequiresOrExcludeDependency2427 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rulerequiresOrExcludeDependency2450 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_18_in_rulerequiresOrExcludeDependency2462 = new BitSet(new long[]{0x0000000000000030L});
    public static final BitSet FOLLOW_ruleEString_in_rulerequiresOrExcludeDependency2483 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_rulerequiresOrExcludeDependency2495 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleoclExpr_in_rulerequiresOrExcludeDependency2516 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_rulerequiresOrExcludeDependency2528 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleoclExpr_in_entryRuleoclExpr2564 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleoclExpr2574 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassifierContextDeclCS_in_ruleoclExpr2621 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressCS_in_ruleoclExpr2648 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_entryRuleEString2684 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEString2695 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleEString2735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleEString2761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEInt_in_entryRuleEInt2807 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEInt2818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleEInt2857 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleEInt2874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEBoolean_in_entryRuleEBoolean2920 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEBoolean2931 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleEBoolean2969 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleEBoolean2988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleClassifierContextDeclCS_in_entryRuleClassifierContextDeclCS3028 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleClassifierContextDeclCS3038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_35_in_ruleClassifierContextDeclCS3075 = new BitSet(new long[]{0x0000007000000010L});
    public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleClassifierContextDeclCS3096 = new BitSet(new long[]{0x0000007000000010L});
    public static final BitSet FOLLOW_36_in_ruleClassifierContextDeclCS3111 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleConstraintCS_in_ruleClassifierContextDeclCS3132 = new BitSet(new long[]{0x0000007000000012L});
    public static final BitSet FOLLOW_ruleDefCS_in_ruleClassifierContextDeclCS3160 = new BitSet(new long[]{0x0000007000000012L});
    public static final BitSet FOLLOW_ruleParameterCS_in_entryRuleParameterCS3200 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleParameterCS3210 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleParameterCS3257 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleParameterCS3269 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleParameterCS3292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstraintCS_in_entryRuleConstraintCS3328 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstraintCS3338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleConstraintCS3385 = new BitSet(new long[]{0x0000000000420000L});
    public static final BitSet FOLLOW_22_in_ruleConstraintCS3398 = new BitSet(new long[]{0xF800038930010090L,0x00000000000000BFL});
    public static final BitSet FOLLOW_ruleSpecificationCS_in_ruleConstraintCS3419 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleConstraintCS3431 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleConstraintCS3447 = new BitSet(new long[]{0xF800038930010090L,0x00000000000000BFL});
    public static final BitSet FOLLOW_ruleSpecificationCS_in_ruleConstraintCS3468 = new BitSet(new long[]{0xF800038930010092L,0x00000000000000BFL});
    public static final BitSet FOLLOW_ruleSpecificationCS_in_ruleConstraintCS3489 = new BitSet(new long[]{0xF800038930010092L,0x00000000000000BFL});
    public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_entryRuleEssentialOCLUnrestrictedName3527 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnrestrictedName3538 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_ruleEssentialOCLUnrestrictedName3584 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIdentifier_in_entryRuleIdentifier3629 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIdentifier3640 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleIdentifier3679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnrestrictedName_in_entryRuleUnrestrictedName3724 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnrestrictedName3735 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEssentialOCLUnrestrictedName_in_ruleUnrestrictedName3781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefCS_in_entryRuleDefCS3825 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefCS3835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefPropertyCS_in_ruleDefCS3881 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDefPropertyCS_in_entryRuleDefPropertyCS3915 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDefPropertyCS3925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_37_in_ruleDefPropertyCS3968 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_38_in_ruleDefPropertyCS3994 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDefPropertyCS4011 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleDefPropertyCS4024 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleDefPropertyCS4045 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleDefPropertyCS4057 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleDefPropertyCS4078 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleDefPropertyCS4090 = new BitSet(new long[]{0xF800038930010090L,0x00000000000000BFL});
    public static final BitSet FOLLOW_ruleSpecificationCS_in_ruleDefPropertyCS4111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeExpCS_in_entryRuleTypeExpCS4147 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeExpCS4157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNameExpCS_in_ruleTypeExpCS4204 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeExpCS4224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityCS_in_entryRuleMultiplicityCS4261 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityCS4271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleMultiplicityCS4308 = new BitSet(new long[]{0x0000070000000040L});
    public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_ruleMultiplicityCS4331 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_ruleMultiplicityCS4358 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleMultiplicityCS4370 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityStringCS_in_entryRuleMultiplicityStringCS4406 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityStringCS4416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleMultiplicityStringCS4460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleMultiplicityStringCS4489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_42_in_ruleMultiplicityStringCS4518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleMultiplicityBoundsCS_in_entryRuleMultiplicityBoundsCS4569 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleMultiplicityBoundsCS4579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLOWER_in_ruleMultiplicityBoundsCS4625 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleMultiplicityBoundsCS4638 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_ruleUPPER_in_ruleMultiplicityBoundsCS4659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLOWER_in_entryRuleLOWER4698 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLOWER4709 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleLOWER4748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUPPER_in_entryRuleUPPER4793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUPPER4804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleUPPER4843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNameSpace_in_entryRuleNameSpace4889 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNameSpace4899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEString_in_ruleNameSpace4944 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeNameExpCS_in_entryRuleTypeNameExpCS4979 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeNameExpCS4989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePathNameCS_in_ruleTypeNameExpCS5034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePathNameCS_in_entryRulePathNameCS5069 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePathNameCS5079 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFirstPathElementCS_in_rulePathNameCS5125 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_44_in_rulePathNameCS5138 = new BitSet(new long[]{0x07FFE00000000010L});
    public static final BitSet FOLLOW_ruleNextPathElementCS_in_rulePathNameCS5159 = new BitSet(new long[]{0x0000100000000002L});
    public static final BitSet FOLLOW_ruleFirstPathElementCS_in_entryRuleFirstPathElementCS5197 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFirstPathElementCS5207 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleFirstPathElementCS5254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNextPathElementCS_in_entryRuleNextPathElementCS5289 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNextPathElementCS5299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnreservedName_in_ruleNextPathElementCS5346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnreservedName_in_entryRuleUnreservedName5382 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnreservedName5393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_ruleUnreservedName5439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEssentialOCLUnreservedName_in_entryRuleEssentialOCLUnreservedName5484 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLUnreservedName5495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleEssentialOCLUnreservedName5542 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleEssentialOCLUnreservedName5575 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_ruleEssentialOCLUnreservedName5608 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleEssentialOCLUnreservedName5632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_entryRulePrimitiveTypeIdentifier5673 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeIdentifier5684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_46_in_rulePrimitiveTypeIdentifier5722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_47_in_rulePrimitiveTypeIdentifier5741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_48_in_rulePrimitiveTypeIdentifier5760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_49_in_rulePrimitiveTypeIdentifier5779 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_50_in_rulePrimitiveTypeIdentifier5798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_51_in_rulePrimitiveTypeIdentifier5817 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_52_in_rulePrimitiveTypeIdentifier5836 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_53_in_rulePrimitiveTypeIdentifier5855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_entryRuleCollectionTypeIdentifier5896 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeIdentifier5907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_54_in_ruleCollectionTypeIdentifier5945 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_55_in_ruleCollectionTypeIdentifier5964 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_56_in_ruleCollectionTypeIdentifier5983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_57_in_ruleCollectionTypeIdentifier6002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_58_in_ruleCollectionTypeIdentifier6021 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSpecificationCS_in_entryRuleSpecificationCS6061 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSpecificationCS6071 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextCs_in_ruleSpecificationCS6117 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_UNQUOTED_STRING_in_ruleSpecificationCS6140 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEssentialOCLInfixOperatorCS_in_entryRuleEssentialOCLInfixOperatorCS6181 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLInfixOperatorCS6191 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleEssentialOCLInfixOperatorCS6245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_59_in_ruleEssentialOCLInfixOperatorCS6274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_41_in_ruleEssentialOCLInfixOperatorCS6303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleEssentialOCLInfixOperatorCS6332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_60_in_ruleEssentialOCLInfixOperatorCS6361 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_61_in_ruleEssentialOCLInfixOperatorCS6390 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_62_in_ruleEssentialOCLInfixOperatorCS6419 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_63_in_ruleEssentialOCLInfixOperatorCS6448 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_39_in_ruleEssentialOCLInfixOperatorCS6477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_64_in_ruleEssentialOCLInfixOperatorCS6506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleEssentialOCLInfixOperatorCS6535 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_ruleEssentialOCLInfixOperatorCS6564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_65_in_ruleEssentialOCLInfixOperatorCS6593 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_66_in_ruleEssentialOCLInfixOperatorCS6622 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_entryRuleBinaryOperatorCS6674 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBinaryOperatorCS6684 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEssentialOCLInfixOperatorCS_in_ruleBinaryOperatorCS6731 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_ruleBinaryOperatorCS6758 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNavigationOperatorCS_in_entryRuleNavigationOperatorCS6793 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNavigationOperatorCS6803 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleNavigationOperatorCS6847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_67_in_ruleNavigationOperatorCS6876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleContextCs_in_entryRuleContextCs6927 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleContextCs6937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_ruleContextCs6983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleContextCs7011 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleContextCs7026 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContextCs7039 = new BitSet(new long[]{0xF800038130010000L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleContextCs7059 = new BitSet(new long[]{0x0000000000000010L,0x0000000000000010L});
    public static final BitSet FOLLOW_68_in_ruleContextCs7072 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleContextCs7085 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressCS_in_entryRuleExpressCS7122 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleExpressCS7132 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixedExpCS_in_ruleExpressCS7180 = new BitSet(new long[]{0xF800038130010000L,0x000000000000000FL});
    public static final BitSet FOLLOW_ruleBinaryOperatorCS_in_ruleExpressCS7201 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_rulePrefixedExpOrLetExpCS_in_ruleExpressCS7224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEssentialOCLPrefixOperator_in_ruleExpressCS7253 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_rulePrimaryExpOrLetExpCS_in_ruleExpressCS7274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpOrLetExpCS_in_ruleExpressCS7303 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixedExpCS_in_entryRulePrefixedExpCS7338 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrefixedExpCS7348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEssentialOCLPrefixOperator_in_rulePrefixedExpCS7403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEssentialOCLPrefixOperator_in_entryRuleEssentialOCLPrefixOperator7439 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleEssentialOCLPrefixOperator7449 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_32_in_ruleEssentialOCLPrefixOperator7493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_69_in_ruleEssentialOCLPrefixOperator7522 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrefixedExpOrLetExpCS_in_entryRulePrefixedExpOrLetExpCS7573 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrefixedExpOrLetExpCS7583 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpOrLetExpCS_in_rulePrefixedExpOrLetExpCS7630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleEssentialOCLPrefixOperator_in_rulePrefixedExpOrLetExpCS7666 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_rulePrimaryExpOrLetExpCS_in_rulePrefixedExpOrLetExpCS7687 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleConstructorPartCS_in_entryRuleConstructorPartCS7726 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleConstructorPartCS7736 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleConstructorPartCS7782 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleConstructorPartCS7794 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleExpressCS_in_ruleConstructorPartCS7815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_entryRuleTypeLiteralWithMultiplicityCS7851 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralWithMultiplicityCS7861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeLiteralCS_in_ruleTypeLiteralWithMultiplicityCS7908 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_ruleMultiplicityCS_in_ruleTypeLiteralWithMultiplicityCS7928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeLiteralCS_in_entryRuleTypeLiteralCS7965 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralCS7975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_ruleTypeLiteralCS8022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleTypeLiteralCS8049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleTypeCS_in_ruleTypeLiteralCS8076 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleTypeCS_in_entryRuleTupleTypeCS8111 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTupleTypeCS8121 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleTupleTypeCS8164 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleTupleTypeCS8190 = new BitSet(new long[]{0x0000000000800010L});
    public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS8212 = new BitSet(new long[]{0x0000000000840000L});
    public static final BitSet FOLLOW_18_in_ruleTupleTypeCS8225 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTuplePartCS_in_ruleTupleTypeCS8246 = new BitSet(new long[]{0x0000000000840000L});
    public static final BitSet FOLLOW_23_in_ruleTupleTypeCS8262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTuplePartCS_in_entryRuleTuplePartCS8300 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTuplePartCS8310 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTuplePartCS8356 = new BitSet(new long[]{0x0000000000020000L});
    public static final BitSet FOLLOW_17_in_ruleTuplePartCS8368 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTuplePartCS8389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeCS_in_entryRulePrimitiveTypeCS8425 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveTypeCS8435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveTypeIdentifier_in_rulePrimitiveTypeCS8480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeLiteralExpCS_in_entryRuleTypeLiteralExpCS8515 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTypeLiteralExpCS8525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTypeLiteralWithMultiplicityCS_in_ruleTypeLiteralExpCS8570 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionLiteralExpCS_in_entryRuleCollectionLiteralExpCS8605 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralExpCS8615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeCS_in_ruleCollectionLiteralExpCS8661 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleCollectionLiteralExpCS8673 = new BitSet(new long[]{0x0000000900008000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS8695 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_18_in_ruleCollectionLiteralExpCS8708 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_ruleCollectionLiteralExpCS8729 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_ruleCollectionLiteralExpCS8745 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionLiteralPartCS_in_entryRuleCollectionLiteralPartCS8781 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionLiteralPartCS8791 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressCS_in_ruleCollectionLiteralPartCS8837 = new BitSet(new long[]{0x0000080000000002L});
    public static final BitSet FOLLOW_43_in_ruleCollectionLiteralPartCS8850 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleExpressCS_in_ruleCollectionLiteralPartCS8871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeCS_in_entryRuleCollectionTypeCS8909 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCollectionTypeCS8919 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleCollectionTypeIdentifier_in_ruleCollectionTypeCS8965 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleCollectionTypeCS8978 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleCollectionTypeCS8999 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleCollectionTypeCS9011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNestedExpCS_in_entryRuleNestedExpCS9049 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNestedExpCS9059 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_ruleNestedExpCS9096 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleExpressCS_in_ruleNestedExpCS9117 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleNestedExpCS9129 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleSelfExpCS_in_entryRuleSelfExpCS9165 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleSelfExpCS9175 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_70_in_ruleSelfExpCS9221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimaryExpOrLetExpCS_in_entryRulePrimaryExpOrLetExpCS9257 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimaryExpOrLetExpCS9267 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_rulePrimaryExpOrLetExpCS9313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetExpCS_in_entryRuleLetExpCS9347 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetExpCS9357 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_71_in_ruleLetExpCS9394 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS9415 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000100L});
    public static final BitSet FOLLOW_18_in_ruleLetExpCS9428 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleLetVariableCS_in_ruleLetExpCS9449 = new BitSet(new long[]{0x0000000000040000L,0x0000000000000100L});
    public static final BitSet FOLLOW_72_in_ruleLetExpCS9463 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleExpressCS_in_ruleLetExpCS9484 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLetVariableCS_in_entryRuleLetVariableCS9520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLetVariableCS9530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleLetVariableCS9576 = new BitSet(new long[]{0x0000008000020000L});
    public static final BitSet FOLLOW_17_in_ruleLetVariableCS9589 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleLetVariableCS9610 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleLetVariableCS9624 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleExpressCS_in_ruleLetVariableCS9645 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNavigatingArgCS_in_entryRuleNavigatingArgCS9681 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgCS9691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingArgCS9737 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleNavigatingArgCS9750 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingArgCS9771 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleNavigatingArgCS9784 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleExpressCS_in_ruleNavigatingArgCS9805 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNavigatingBarArgCS_in_entryRuleNavigatingBarArgCS9845 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingBarArgCS9855 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_73_in_ruleNavigatingBarArgCS9898 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingBarArgCS9932 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleNavigatingBarArgCS9945 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingBarArgCS9966 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleNavigatingBarArgCS9979 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleExpressCS_in_ruleNavigatingBarArgCS10000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNavigatingSemiArgCS_in_entryRuleNavigatingSemiArgCS10040 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingSemiArgCS10050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_ruleNavigatingSemiArgCS10093 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingSemiArgCS10127 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleNavigatingSemiArgCS10140 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingSemiArgCS10161 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleNavigatingSemiArgCS10174 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleExpressCS_in_ruleNavigatingSemiArgCS10195 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_entryRuleNavigatingArgExpCS10235 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingArgExpCS10245 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleExpressCS_in_ruleNavigatingArgExpCS10291 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNavigatingCommaArgCS_in_entryRuleNavigatingCommaArgCS10325 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNavigatingCommaArgCS10335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleNavigatingCommaArgCS10378 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleNavigatingArgExpCS_in_ruleNavigatingCommaArgCS10412 = new BitSet(new long[]{0x0000000000020002L});
    public static final BitSet FOLLOW_17_in_ruleNavigatingCommaArgCS10425 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleNavigatingCommaArgCS10446 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_39_in_ruleNavigatingCommaArgCS10459 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleExpressCS_in_ruleNavigatingCommaArgCS10480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleIfExpCS_in_entryRuleIfExpCS10520 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleIfExpCS10530 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_74_in_ruleIfExpCS10567 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleExpressCS_in_ruleIfExpCS10588 = new BitSet(new long[]{0x0000000000000000L,0x0000000000000800L});
    public static final BitSet FOLLOW_75_in_ruleIfExpCS10600 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleExpressCS_in_ruleIfExpCS10621 = new BitSet(new long[]{0x0000000000000000L,0x0000000000001000L});
    public static final BitSet FOLLOW_76_in_ruleIfExpCS10633 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleExpressCS_in_ruleIfExpCS10654 = new BitSet(new long[]{0x0000000000000000L,0x0000000000002000L});
    public static final BitSet FOLLOW_77_in_ruleIfExpCS10666 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleLiteralExpCS_in_entryRuleTupleLiteralExpCS10702 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralExpCS10712 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_45_in_ruleTupleLiteralExpCS10749 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_13_in_ruleTupleLiteralExpCS10761 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS10782 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_18_in_ruleTupleLiteralExpCS10795 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_ruleTupleLiteralExpCS10816 = new BitSet(new long[]{0x0000000000048000L});
    public static final BitSet FOLLOW_15_in_ruleTupleLiteralExpCS10830 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTupleLiteralPartCS_in_entryRuleTupleLiteralPartCS10866 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTupleLiteralPartCS10876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnrestrictedName_in_ruleTupleLiteralPartCS10922 = new BitSet(new long[]{0x0000008000020000L});
    public static final BitSet FOLLOW_17_in_ruleTupleLiteralPartCS10935 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleTypeExpCS_in_ruleTupleLiteralPartCS10956 = new BitSet(new long[]{0x0000008000000000L});
    public static final BitSet FOLLOW_39_in_ruleTupleLiteralPartCS10970 = new BitSet(new long[]{0x0000000900000000L,0x00000000000000A0L});
    public static final BitSet FOLLOW_ruleExpressCS_in_ruleTupleLiteralPartCS10991 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rulePrimitiveLiteralExpCS_in_entryRulePrimitiveLiteralExpCS11027 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRulePrimitiveLiteralExpCS11037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_rulePrimitiveLiteralExpCS11084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_rulePrimitiveLiteralExpCS11111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_rulePrimitiveLiteralExpCS11138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_rulePrimitiveLiteralExpCS11165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_rulePrimitiveLiteralExpCS11192 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_rulePrimitiveLiteralExpCS11219 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNumberLiteralExpCS_in_entryRuleNumberLiteralExpCS11254 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNumberLiteralExpCS11264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_ruleNumberLiteralExpCS11309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNUMBER_LITERAL_in_entryRuleNUMBER_LITERAL11344 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNUMBER_LITERAL11354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_INT_in_ruleNUMBER_LITERAL11395 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleStringLiteralExpCS_in_entryRuleStringLiteralExpCS11435 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleStringLiteralExpCS11445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleStringLiteralExpCS11486 = new BitSet(new long[]{0x0000000000000012L});
    public static final BitSet FOLLOW_ruleBooleanLiteralExpCS_in_entryRuleBooleanLiteralExpCS11527 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleBooleanLiteralExpCS11537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_33_in_ruleBooleanLiteralExpCS11580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_34_in_ruleBooleanLiteralExpCS11617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleUnlimitedNaturalLiteralExpCS_in_entryRuleUnlimitedNaturalLiteralExpCS11666 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleUnlimitedNaturalLiteralExpCS11676 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_40_in_ruleUnlimitedNaturalLiteralExpCS11722 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleInvalidLiteralExpCS_in_entryRuleInvalidLiteralExpCS11758 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleInvalidLiteralExpCS11768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_78_in_ruleInvalidLiteralExpCS11814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleNullLiteralExpCS_in_entryRuleNullLiteralExpCS11850 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleNullLiteralExpCS11860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_79_in_ruleNullLiteralExpCS11906 = new BitSet(new long[]{0x0000000000000002L});

}