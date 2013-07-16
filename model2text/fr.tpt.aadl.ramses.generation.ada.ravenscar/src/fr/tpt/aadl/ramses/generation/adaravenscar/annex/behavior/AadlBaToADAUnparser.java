package fr.tpt.aadl.ramses.generation.adaravenscar.annex.behavior;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.AbstractEnumerator;
import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.ParameterConnectionEnd;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramSubcomponentType;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.UnparseText;

import fr.tpt.aadl.annex.behavior.aadlba.Any;
import fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSequence;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSet;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorBooleanLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorElement;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorEnumerationLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorIntegerLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorRealLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorStringLiteral;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable;
import fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator;
import fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator;
import fr.tpt.aadl.annex.behavior.aadlba.CalledSubprogramHolder;
import fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference;
import fr.tpt.aadl.annex.behavior.aadlba.DataSubcomponentHolder;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerConditionStop;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression;
import fr.tpt.aadl.annex.behavior.aadlba.ElementHolder;
import fr.tpt.aadl.annex.behavior.aadlba.ElementValues;
import fr.tpt.aadl.annex.behavior.aadlba.ElseStatement;
import fr.tpt.aadl.annex.behavior.aadlba.Factor;
import fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement;
import fr.tpt.aadl.annex.behavior.aadlba.IfStatement;
import fr.tpt.aadl.annex.behavior.aadlba.IndexableElement;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerRange;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable;
import fr.tpt.aadl.annex.behavior.aadlba.LockAction;
import fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator;
import fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator;
import fr.tpt.aadl.annex.behavior.aadlba.Otherwise;
import fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel;
import fr.tpt.aadl.annex.behavior.aadlba.PortCountValue;
import fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction;
import fr.tpt.aadl.annex.behavior.aadlba.PortDequeueValue;
import fr.tpt.aadl.annex.behavior.aadlba.PortFreezeAction;
import fr.tpt.aadl.annex.behavior.aadlba.PortFreshValue;
import fr.tpt.aadl.annex.behavior.aadlba.PortSendAction;
import fr.tpt.aadl.annex.behavior.aadlba.Relation;
import fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator;
import fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression;
import fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction;
import fr.tpt.aadl.annex.behavior.aadlba.Term;
import fr.tpt.aadl.annex.behavior.aadlba.TimedAction;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryAddingOperator;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator;
import fr.tpt.aadl.annex.behavior.aadlba.UnlockAction;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression;
import fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement;
import fr.tpt.aadl.annex.behavior.aadlba.util.AadlBaSwitch;
import fr.tpt.aadl.annex.behavior.analyzers.TypeHolder;
import fr.tpt.aadl.annex.behavior.unparser.AadlBaUnparser;
import fr.tpt.aadl.annex.behavior.utils.AadlBaUtils;
import fr.tpt.aadl.annex.behavior.utils.AadlBaVisitors;
import fr.tpt.aadl.annex.behavior.utils.DimensionException;
import fr.tpt.aadl.ramses.generation.adaravenscar.GenerationUtilsADA;
import fr.tpt.aadl.ramses.generation.adaravenscar.annex.behavior.AadlBaToADAUnparser;
import fr.tpt.aadl.ramses.generation.target.specific.GeneratorUtils;
import fr.tpt.aadl.utils.Aadl2Utils;
import fr.tpt.aadl.utils.PropertyUtils;


public class AadlBaToADAUnparser extends AadlBaUnparser
{
	protected Map<DataAccess, String> _dataAccessMapping = null ;
	  protected UnparseText _adbFileContent = null ;
	  protected UnparseText _adsFileContent = null ;
	  protected List<String> _additionalADS = new ArrayList<String>() ;
	  private NamedElement _owner ;
	  
	  public AadlBaToADAUnparser(AnnexSubclause subclause,
	                           String indent,
	                           Map<DataAccess, String> dataAccessMapping)
	  {
	    super(subclause, indent) ;
	    _dataAccessMapping = dataAccessMapping ;
	  }

	  public AadlBaToADAUnparser()
	  {
	    super() ;
	  }

	  public void setDataAccessMapping(Map<DataAccess, String> dataAccessMapping)
	  {
	    _dataAccessMapping = dataAccessMapping ;
	  }
	  
	  public String getCContent()
	  {
	    return _adbFileContent.getParseOutput() ;
	  }

	  public String getHContent()
	  {
	    return _adsFileContent.getParseOutput() ;
	  }

	  public List<String> getAdditionalHeaders()
	  {
	    return _additionalADS ;
	  }

	  public void processEList(UnparseText aadlText,
	                           EList<?> list,
	                           String separator)
	  {
	    boolean first = true ;

	    for(Iterator<?> it = list.iterator() ; it.hasNext() ;)
	    {
	      if(!first)
	      {
	        if(separator == AadlConstants.newlineChar)
	        {
	          aadlText.addOutputNewline(AadlConstants.emptyString) ;
	        }
	        else
	        {
	          aadlText.addOutput(separator) ;
	        }
	      }

	      first = false ;
	      Object o = it.next() ;

	      if(o instanceof ElementHolder)
	      {
	        process((ElementHolder) o) ;
	      }
	      else if(o instanceof AbstractEnumerator)
	        aadlText.addOutput(((AbstractEnumerator) o).getName().toLowerCase()) ;
	      else if(o instanceof String)
	      {
	        aadlText.addOutput((String) o) ;
	      }
	      else
	      {
	        aadlText.addOutput("processEList") ;
	      }
	    }
	  }

	  public void processEList(UnparseText aadlText,
	                           final List<? extends BehaviorElement> list)
	  {
	    for(Iterator<? extends BehaviorElement> it = list.iterator() ; it.hasNext() ;)
	    {
	      process(it.next()) ;
	    }
	  }

	  public boolean resolveExistingCodeDependencies(NamedElement object)
	  {
	    try
	    {
	      NamedElement ne = object ;
	      String sourceName = PropertyUtils.getStringValue(ne, "Source_Name") ;
	      List<String> sourceText =
	            PropertyUtils.getStringListValue(ne, "Source_Text") ;
	      aadlbaText.addOutput(sourceName) ;
	      
	      for(String s : sourceText)
	      {
	        if(s.endsWith(".ads"))
	        {
	          _additionalADS.add(s) ;
	          return true;
	        }
	      }
	      throw new Exception("In component "+ne.getName()+": Source_Text " +
	      		"property should also reference a ads (.ads extension) file");
	    }
	    catch(Exception e)
	    {
	      return false ;
	    }
	  }

	  protected static String getInitialStateIdentifier(BehaviorAnnex ba)
	  {
	    for(BehaviorState s : ba.getStates())
	    {
	      if(s.isInitial())
	      {
	        return s.getName() ;
	      }
	    }

	    return null ;
	  }

	  protected static String getTargetLanguageOperator(LogicalOperator operator)
	  {
	    if(operator.equals(LogicalOperator.AND))
	    {
	      return "and" ;
	    }

	    if(operator.equals(LogicalOperator.OR))
	    {
	      return "or" ;
	    }

	    if(operator.equals(LogicalOperator.XOR))
	    {
	      return "xor" ;
	    }

	    return operator.getLiteral() ;
	  }

	  protected static String getTargetLanguageOperator(MultiplyingOperator operator)
	  {
	    if(operator.equals(MultiplyingOperator.DIVIDE))
	    {
	      return "/" ;
	    }

	    if(operator.equals(MultiplyingOperator.MULTIPLY))
	    {
	      return "*" ;
	    }

	    if(operator.equals(MultiplyingOperator.MOD))
	    {
	      return "mod" ;
	    }

	    // TODO: find mapping for REM operator
	    if(operator.equals(MultiplyingOperator.REM))
	    {
	      throw new UnsupportedOperationException() ;
	    }

	    return operator.getLiteral() ;
	  }

	  protected static String getTargetLanguageOperator(UnaryNumericOperator operator)
	  {
	    if(operator.equals(UnaryNumericOperator.ABS))
	    {
	      return "aadl_runtime_abs" ;
	    }

	    return operator.getLiteral() ;
	  }

	  protected static String getTargetLanguageOperator(BinaryNumericOperator operator)
	  {
	    if(operator.equals(UnaryNumericOperator.ABS))
	    {
	      return "aadl_runtime_exp(" ;
	    }

	    return operator.getLiteral() ;
	  }

	  protected static String getTargetLanguageOperator(UnaryBooleanOperator operator)
	  {
	    if(operator.equals(UnaryBooleanOperator.NOT))
	    {
	      return "not" ;
	    }

	    return operator.getLiteral() ;
	  }

	  protected static String getTargetLanguageOperator(RelationalOperator operator)
	  {
	    if(operator.equals(RelationalOperator.EQUAL))
	    {
	      return "=" ;
	    }

	    if(operator.equals(RelationalOperator.NOT_EQUAL))
	    {
	      return "/=" ;
	    }

	    return operator.getLiteral() ;
	  }

	  @Override
	  protected void initSwitches()
	  {
	    aadlbaSwitch = new AadlBaSwitch<String>()
	    {
	      /**
	       * Top-level method to unparse "behavior_specification"
	       * annexsubclause
	       */
	      @Override
		public String caseAnnexSubclause(AnnexSubclause object)
	      {
	        process((BehaviorAnnex) object) ;
	        return DONE ;
	      }

	      /**
	       * Unparse behaviorannex
	       */
	      @Override
		public String caseBehaviorAnnex(BehaviorAnnex object)
	      {
	    	BehaviorAnnex ba = object ;
	    	NamedElement aadlComponent = _owner ;
	    	String aadlComponentADAId =
	    		  GenerationUtilsADA.getGenerationADAIdentifier(aadlComponent
	                  .getQualifiedName()) ;
	        
	        _adbFileContent = new UnparseText() ;
	        _adsFileContent = new UnparseText() ;
	        
	        _adbFileContent.addOutputNewline(aadlComponentADAId +
	              "current_state : _BA_State_t := " + aadlComponentADAId + "_" +
	              AadlBaToADAUnparser.getInitialStateIdentifier(ba) + ";") ;
	        _adbFileContent.addOutputNewline("final : integer := 0;") ;
	        processEList(_adbFileContent, ba.getVariables()) ;
	        _adbFileContent.addOutputNewline("Main_loop:") ;
	        _adbFileContent.addOutputNewline("while (final /= 1) loop") ;
	        //_adbFileContent.addOutputNewline("{") ;
	        _adbFileContent.incrementIndent() ;
	        //_adbFileContent.addOutputNewline("switch(current_state)") ;
	        _adbFileContent.addOutputNewline("case current_state is") ;
	        //_adbFileContent.addOutputNewline("{") ;
	        _adbFileContent.incrementIndent() ;
	        //_adsFileContent.addOutputNewline("typedef enum {") ;
	        _adsFileContent.addOutputNewline("type _BA_State_t is (") ;
	        _adsFileContent.incrementIndent() ;

	        for(BehaviorState state : ba.getStates())
	        {
	          if(AadlBaVisitors.getTransitionWhereSrc
	                (state).isEmpty() == false)
	          {
	            _adbFileContent.addOutputNewline("when " + aadlComponentADAId + "_" +
	                  state.getName() + " => ") ;
	            processEList(_adbFileContent, AadlBaVisitors.
	                         getTransitionWhereSrc(state)) ;
	          }
	          
	          String stateADAId = GenerationUtilsADA.
	                getGenerationADAIdentifier(aadlComponent.getQualifiedName()+
	                                         "_"+state.getName());
	          _adsFileContent.addOutput(stateADAId);


	          if(ba.getStates().indexOf(state) < ba.getStates()
	                .size() - 1)
	          {
	            _adsFileContent.addOutput(",") ;
	          }

	          _adsFileContent.addOutputNewline("") ;
	        }

	        _adsFileContent.decrementIndent() ;
	        _adsFileContent.addOutputNewline(");") ;
	        _adsFileContent.addOutputNewline("") ;
	        
	        _adbFileContent.decrementIndent() ;
	        _adbFileContent.addOutputNewline("end case;") ;
	        _adbFileContent.decrementIndent() ;
	        _adbFileContent.addOutputNewline("end loop;") ;
	        _adbFileContent.addOutputNewline("") ;
	        
	        return DONE ;
	      }

	      /**
	       * Unparse behaviorvariable
	       */
	      @Override
		public String caseBehaviorVariable(BehaviorVariable object)
	      {
	        String sourceName ;
	        try
	        {
	          sourceName = PropertyUtils.
	                getStringValue(object.getDataClassifier(), "Source_Name") ;
	        }
	        catch (Exception e)
	        {
	          sourceName = GenerationUtilsADA.
	                getGenerationADAIdentifier(object.
	                                         getDataClassifier().getQualifiedName());
	        }
	        _adbFileContent.addOutput(sourceName);
	        _adbFileContent.addOutput(" : " + object.getName()) ;
	        caseArrayDimensions(object.getArrayDimensions()) ;
	        String init = GeneratorUtils.getInitialValue(object.getDataClassifier()) ;
	        if(!init.isEmpty())
	        {
	        	_adbFileContent.addOutput(" := "+init) ;
	        }
	        _adbFileContent.addOutputNewline(";") ;
	        return DONE ;
	      }

	      /**
	       * Unparse arraysize
	       */
	      public String caseArrayDimensions(EList<ArrayDimension> arrayDimensions)
	      {
	        for(ArrayDimension ivc : arrayDimensions)
	        {
	          _adbFileContent.addOutput("( 0 .. ") ;
	          _adbFileContent.addOutput(Long.toString(ivc.getSize().getSize() - 1));
	          _adbFileContent.addOutput(" )") ;
	        }

	        return DONE ;
	      }

	      @Override
		public String caseBehaviorEnumerationLiteral(BehaviorEnumerationLiteral object)
	      {
	        // ComponentPropertyValue is defined to refer Enumerated data
	        _adbFileContent.addOutput(object.getEnumLiteral().getValue());
	        return DONE ;
	      }

	      /**
	       * Unparse behaviorstate
	       * @object: input parameter, destination of a Behavior Transition
	       */
	      @Override
		public String caseBehaviorState(BehaviorState object)
	      {
	        NamedElement aadlComponent = _owner ;
	        String aadlComponentADAId =
	              GenerationUtilsADA.getGenerationADAIdentifier(aadlComponent
	                    .getQualifiedName()) ;
	        _adbFileContent.addOutputNewline("current_state := " + aadlComponentADAId +
	              "_" + object.getName() + ";") ;
	        //if (object.isComplete())

	        if(object.isFinal())
	        {
	          _adbFileContent.addOutputNewline("final := 1;") ;
	        }

	        //_adbFileContent.addOutputNewline("exit Main_loop when final = 1;") ;
	        return DONE ;
	      }

	      
	      /**
	       * Unparse behaviortransition
	       */
	      @Override
		public String caseBehaviorTransition(BehaviorTransition object)
	      {
	        aadlbaText = _adbFileContent ;
	        long num = object.getPriority() ;

	        _adbFileContent.addOutput("-- Transition id: " + object.getName()) ;


	        if(num != -1) // numeral
	        {
	          _adbFileContent.addOutput(" -- Priority " +
	                String.valueOf(num)) ;
	        }

	        _adbFileContent.addOutputNewline("") ;

	        if(object.getCondition() != null)
	        {
	          if(object.getCondition() instanceof Otherwise)
	          {
	            _adbFileContent.addOutput("else") ;
	            process(object.getCondition()) ;
	          }
	          else
	          {
	            _adbFileContent.addOutput("if ") ;
	            process(object.getCondition()) ;
	            _adbFileContent.addOutputNewline(" then") ;
	          }
	        }
	        else
	        {
	          _adbFileContent.addOutputNewline("if TRUE then -- no execution condition") ;
	        }

	        //_adbFileContent.addOutputNewline("{") ;
	        _adbFileContent.incrementIndent() ;

	        if(object.getActionBlock() != null)
	        {
	          process(object.getActionBlock()) ;
	        }

	        process(object.getDestinationState()) ;
	        _adbFileContent.decrementIndent() ;
	        
	        _adbFileContent.addOutputNewline("end if;") ;
	        
	        return DONE ;
	      }


	      @Override
		public String caseOtherwise(Otherwise object)
	      {
	        _adbFileContent.addOutputNewline(" --otherwise") ;
	        return DONE ;
	      }

	      /**
	       * Unparse dispatchcondition
	       */
	      @Override
		public String caseDispatchCondition(DispatchCondition object)
	      {
	        throw new UnsupportedOperationException() ;
	      }

	      @Override
		public String caseDispatchTriggerConditionStop(DispatchTriggerConditionStop object)
	      {
	        throw new UnsupportedOperationException() ;
	      }

	      @Override
		public String caseDispatchTriggerLogicalExpression(DispatchTriggerLogicalExpression object)
	      {
	        throw new UnsupportedOperationException() ;
	      }

	      @Override
		public String caseDispatchConjunction(DispatchConjunction object)
	      {
	        throw new UnsupportedOperationException() ;
	      }

	      @Override
		public String caseBehaviorActionBlock(BehaviorActionBlock object)
	      {
	        process(object.getContent()) ;

	        if(object.getTimeout() != null)
	        {
	          throw new UnsupportedOperationException() ;
	        }

	        return DONE ;
	      }

	      @Override
		public String caseBehaviorActionSequence(BehaviorActionSequence object)
	      {
	        processEList(_adbFileContent, object.getActions()) ;
	        return DONE ;
	      }

	      @Override
		public String caseBehaviorActionSet(BehaviorActionSet object)
	      {
	        throw new UnsupportedOperationException() ;
	      }

	      
	      /**
	       * Unparse elsestatement
	       */
	      @Override
		public String caseElseStatement(ElseStatement object)
	      {
	        BehaviorActions lba = object.getBehaviorActions() ;
	        _adbFileContent.addOutput("else ") ;
	        _adbFileContent.addOutputNewline("") ;
	        process(lba) ;
	        _adbFileContent.addOutputNewline("end if;") ;
	        return DONE ;
	      }
	      
	      /**
	       * Unparse ifstatement
	       */
	      @Override
		public String caseIfStatement(IfStatement object)
	      {
	        ValueExpression ve = object.getLogicalValueExpression() ;
	        BehaviorActions lba = object.getBehaviorActions() ;

	        if(object.eContainer() instanceof IfStatement)
	        {
	          _adbFileContent.addOutput("elsif ") ;
	          process(ve) ;
	          _adbFileContent.addOutput(" then") ;
	        }
	        else
	        {
	          _adbFileContent.addOutput("if ") ;
	          process(ve) ;
	          _adbFileContent.addOutput(" then") ;
	        }
	        
	        _adbFileContent.addOutputNewline("") ;
	        process(lba) ;
	        _adbFileContent.addOutputNewline("end if;") ;

	        return DONE ;
	      }

	      public String toInteger(IntegerValue integerValue)
	      {
	        if(integerValue instanceof IntegerValueConstant)
	        {
	          return Long.toString(((BehaviorIntegerLiteral) integerValue)
	                .getValue()) ;
	        }

	        if(integerValue instanceof IntegerValueVariable)
	        {
	          if(integerValue instanceof BehaviorVariable)
	          {
	            return ((BehaviorVariable) integerValue).getDataClassifier()
	                  .getName();
	          }

	          if(integerValue instanceof DataComponentReference)
	          {
	            return ((BehaviorVariable) integerValue).getDataClassifier()
	                  .getName();
	          }
	        }

	        return "" ;
	      }

	      /**
	       * Unparse fororforallstatement
	       */
	      @Override
		public String caseForOrForAllStatement(ForOrForAllStatement object)
	      {
	        ElementValues set = object.getIteratedValues() ;

	        if(set instanceof IntegerRange)
	        {
	          IntegerRange range = (IntegerRange) set ;
	          String lowerRangeValue = this.toInteger(range.getLowerIntegerValue()) ;
	          String upperRangeValue = this.toInteger(range.getUpperIntegerValue()) ;
	          _adbFileContent.addOutputNewline("iter : Integer;") ;
	          _adbFileContent.addOutputNewline("for iter in " + lowerRangeValue + " .. " + upperRangeValue + " loop") ;
	          //_adbFileContent.addOutputNewline("{") ;
	          _adbFileContent.incrementIndent() ;
	          DataClassifier iterativeVariableClassifier = object.getIterativeVariable().getDataClassifier() ;
	          try
	          {
	            resolveExistingCodeDependencies(iterativeVariableClassifier);
	          } catch(Exception e)
	          {
	            _adbFileContent.addOutput(GenerationUtilsADA.
	                                    getGenerationADAIdentifier(iterativeVariableClassifier.
	                                    getQualifiedName()));
	          }
	          
	          _adbFileContent.addOutput(" ") ;
	          _adbFileContent.addOutput(object.getIterativeVariable().getName()) ;
	          _adbFileContent.addOutputNewline(" := iter;") ;
	          process(object.getBehaviorActions()) ;
	          _adbFileContent.decrementIndent() ;
	          _adbFileContent.addOutputNewline("end loop;") ;
	        }

	        if(set instanceof DataComponentReference)
	        {
	          TypeHolder dataReferenceTypeHolder = null ;

	          try
	          {
	            dataReferenceTypeHolder =
	                  AadlBaUtils.getTypeHolder(object.getIteratedValues()) ;
	          }
	          catch(DimensionException e)
	          {
	            // TODO Auto-generated catch block
	            e.printStackTrace() ;
	          }

	          int numberOfLoop = dataReferenceTypeHolder.dimension ;

	          for(int i = 0 ; i < numberOfLoop ; i++)
	          {
	            String iteratorID = "iter" + Integer.toString(i) ;
	            //_adbFileContent.addOutputNewline("int " + iteratorID + "=0;") ;
	            _adbFileContent.addOutputNewline(iteratorID + " : Integer;") ;
	            _adbFileContent.addOutputNewline("for " + iteratorID + " in 0 .. " + Long.toString(dataReferenceTypeHolder.dimension_sizes[i] - 1) + " loop") ;
	            //_adbFileContent.addOutputNewline("{") ;
	            _adbFileContent.incrementIndent() ;
	          }

	          DataClassifier iterativeVariableClassifier = object.getIterativeVariable().getDataClassifier() ;
	          try
	          {
	            resolveExistingCodeDependencies(iterativeVariableClassifier);
	          }
	          catch(Exception e)
	          {
	            _adbFileContent.addOutput(GenerationUtilsADA.
	                                    getGenerationADAIdentifier(iterativeVariableClassifier.getQualifiedName()));
	          }
	          _adbFileContent.addOutput(" ") ;
	          _adbFileContent.addOutput(object.getIterativeVariable().getName()) ;
	          _adbFileContent.addOutput(" := ") ;
	          process(object.getIteratedValues()) ;

	          for(int i = 0 ; i < numberOfLoop ; i++)
	          {
	            String iteratorID = "iter" + Integer.toString(i) ;
	            _adbFileContent.addOutput("(") ;
	            _adbFileContent.addOutput(iteratorID) ;
	            _adbFileContent.addOutput(")") ;
	            _adbFileContent.addOutput("-- A DEBUGER") ;
	          }

	          _adbFileContent.addOutputNewline(";") ;
	          process(object.getBehaviorActions()) ;

	          for(int i = 0 ; i < numberOfLoop ; i++)
	          {
	            _adbFileContent.decrementIndent() ;
	            _adbFileContent.addOutputNewline("end loop;") ;
	          }
	        }

	        return DONE ;
	      }

	      @Override
		public String caseWhileOrDoUntilStatement(WhileOrDoUntilStatement object)
	      {
	        if(object.isDoUntil())
	        {
	          return caseDoUntilStatement(object) ;
	        }
	        else
	        {
	          return caseWhileStatement(object) ;
	        }
	      }

	      /**
	       * Unparse whilestatement
	       */
	      public String caseWhileStatement(WhileOrDoUntilStatement object)
	      {
	        //FIXME : TODO : update location reference
	        _adbFileContent.addOutput("while ") ;
	        process(object.getLogicalValueExpression()) ;
	        _adbFileContent.addOutputNewline(" loop") ;
	        //_adbFileContent.addOutputNewline("{") ;
	        _adbFileContent.incrementIndent() ;
	        process(object.getBehaviorActions()) ;
	        _adbFileContent.decrementIndent() ;
	        _adbFileContent.addOutputNewline("end loop;") ;
	        return DONE ;
	      }

	      /**
	       * Unparse dountilstatement
	       */
	      public String caseDoUntilStatement(WhileOrDoUntilStatement object)
	      {
	        //FIXME : TODO : update location reference
	        _adbFileContent.addOutputNewline("loop") ;
	        //_adbFileContent.addOutputNewline("{") ;
	        _adbFileContent.incrementIndent() ;
	        process(object.getBehaviorActions()) ;
	        _adbFileContent.decrementIndent() ;
	        //_adbFileContent.addOutputNewline("}") ;
	        _adbFileContent.addOutput("exit when ") ;
	        process(object.getLogicalValueExpression()) ;
	        _adbFileContent.addOutputNewline(";") ;
	        _adbFileContent.addOutputNewline("end loop;") ;
	        return DONE ;
	      }

	      /**
	       * Unparse integerrange
	       */
	      @Override
		public String caseIntegerRange(IntegerRange object)
	      {
	        throw new UnsupportedOperationException() ;
	      }

	      /**
	       * Unparse timedaction
	       */
	      @Override
		public String caseTimedAction(TimedAction object)
	      {
	        throw new UnsupportedOperationException() ;
	      }

	      /**
	       * Unparse assignmentaction
	       */
	      @Override
		public String caseAssignmentAction(AssignmentAction object)
	      {
	        process(object.getTarget()) ;
	        _adbFileContent.addOutput(" := ") ;

	        if(object instanceof Any)
	        {
	          throw new UnsupportedOperationException() ;
	        }
	        else
	        {
	          process(object.getValueExpression()) ;
	        }

	        _adbFileContent.addOutputNewline(";") ;
	        return DONE ;
	      }
	      
	      @Override
		public String caseCalledSubprogramHolder(CalledSubprogramHolder object)
	      {
	        aadlbaText = _adbFileContent;
	        resolveExistingCodeDependencies(object.getElement());
	        return DONE ;
	      }
	      
	      @Override
		public String caseSubprogramCallAction(SubprogramCallAction object)
	      {
	        Parameter returnParameter = null;

	        if(object.getSubprogram().getElement() != null)
	        {
	          SubprogramType st = null ;
	          SubprogramSubcomponentType sct =
	                (SubprogramSubcomponentType) object.getSubprogram().getElement() ;


	          if(sct instanceof SubprogramType)
	          {
	            st = (SubprogramType) sct ;
	          }
	          else
	          {
	            SubprogramImplementation si = (SubprogramImplementation) sct ;
	            st = si.getType() ;
	          }

	          List<Feature> ordereFeatureList = Aadl2Utils.orderFeatures(st) ;

	          for(ParameterLabel pl : object.getParameterLabels())
	          {
	            ParameterConnectionEnd pce =
	                  (ParameterConnectionEnd) ordereFeatureList.get(object
	                                                                 .getParameterLabels().indexOf(pl)) ;

	            if(pce instanceof Parameter)
	            {
	              Parameter p = (Parameter) pce ;
	              boolean isReturnParam= GenerationUtilsADA.isReturnParameter(p);
	              if(isReturnParam)
	              {
	                returnParameter = p;
	                process(pl);
	                _adbFileContent.addOutput(" := ") ;
	                break;
	              }
	            }
	          }

	          process(object.getSubprogram()) ;

	          if(st != null)
	          {
	            _adbFileContent.addOutput(" (") ;
	            boolean first = true;
	            for(ParameterLabel pl : object.getParameterLabels())
	            {
	              ParameterConnectionEnd pce =
	                    (ParameterConnectionEnd) ordereFeatureList.get(object
	                                                                   .getParameterLabels().indexOf(pl)) ;

	              if(pce instanceof Parameter)
	              {
	                Parameter p = (Parameter) pce ;
	                if(p==returnParameter)
	                  continue;
	                if(first==false)
	                  _adbFileContent.addOutput(", ") ;
	                
	                /*if(Aadl2Utils.isInOutParameter(p) ||
	                		Aadl2Utils.isOutParameter(p))
	                {
	                  _adbFileContent.addOutput("&") ;
	                }*/

	                process(pl) ;
	                first=false;
	              }
	              else if(pce instanceof DataAccess)
	              {
	                DataAccess da = (DataAccess) pce ;
	                if(first==false)
	                  _adbFileContent.addOutput(", ") ;
	                
	                /*if(da.getKind().equals(AccessType.REQUIRES))
	                {
	                  
	                  if(Aadl2Utils.isReadWriteDataAccess(da)
	                		  || Aadl2Utils.isWriteOnlyDataAccess(da))
	                  {
	                    _adbFileContent.addOutput("&") ;
	                  }
	                }*/

	                String name = null ;

	                // If a data access mapping is provided:
	                // Transforms any data access into the right data subcomponent
	                // 's name thanks to the given data access mapping.
	                if(_dataAccessMapping != null)
	                {
	                  Relation r = ((ValueExpression)pl).getRelations().get(0);
	                  Term t = r.getFirstExpression().getTerms().get(0);
	                  DataSubcomponentHolder dsh = (DataSubcomponentHolder) t.getFactors().get(0).getFirstValue();
	                  name = _dataAccessMapping.get(dsh.getElement());
	                }

	                if (name != null)
	                {
	                  _adbFileContent.addOutput(name);
	                }
	                else // Otherwise, process parameter label as usual.
	                {
	                  process(pl) ;
	                }
	                first=false;
	              }

	            }

	            _adbFileContent.addOutputNewline(");") ;
	          }
	        }
	        else
	        {
	          if(object.isSetParameterLabels())
	          {
	            _adbFileContent.addOutput(" (") ;
	            processEList(_adbFileContent, object.getParameterLabels(), ", ") ;
	            _adbFileContent.addOutputNewline(");") ;
	          }
	        }

	        return DONE ;
	      }

	      @Override
		public String caseElementHolder(ElementHolder object)
	      {
	    	NamedElement elt = object.getElement();
	    	String id;
	    	if(elt instanceof Parameter)
			{
				/*Parameter p = (Parameter) elt;
				if(Aadl2Utils.isInOutParameter(p)
						|| Aadl2Utils.isOutParameter(p))
					aadlbaText.addOutput("*");*/
				id = elt.getName();
			}
			else if (elt instanceof DataAccess)
			{
			  /*DataAccess da = (DataAccess) elt;
			  
			  if(Aadl2Utils.isReadWriteDataAccess(da)
					  || Aadl2Utils.isWriteOnlyDataAccess(da))
	  		  {
	  			aadlbaText.addOutput("*");
	  		  }*/
	  		  id = elt.getName();
			}
	    	else	
	    		id = elt.getQualifiedName();
	    	aadlbaText.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(id));
	    	if(object instanceof IndexableElement)
	    	{	
	    	  IndexableElement ie = (IndexableElement) object;
	    	  for(IntegerValue iv: ie.getArrayIndexes())
	    	  {
	    		aadlbaText.addOutput("(");
	    		process(iv);
	    		aadlbaText.addOutput(")");
	    	  }
	    	}
	        return DONE ;
	      }
	      
	      @Override
		public String casePortSendAction(PortSendAction object)
	      {
	        throw new UnsupportedOperationException() ;
	      }

	      @Override
		public String casePortFreezeAction(PortFreezeAction object)
	      {
	        throw new UnsupportedOperationException() ;
	      }

	      @Override
		public String casePortDequeueAction(PortDequeueAction object)
	      {
	        throw new UnsupportedOperationException() ;
	      }

	      @Override
		public String caseLockAction(LockAction object)
	      {
	        throw new UnsupportedOperationException() ;
	      }

	      @Override
		public String caseUnlockAction(UnlockAction object)
	      {
	        throw new UnsupportedOperationException() ;
	      }

	      /**
	       * Unparse behaviortime
	       */
	      @Override
		public String caseBehaviorTime(BehaviorTime object)
	      {
	        throw new UnsupportedOperationException() ;
	      }

	      @Override
		public String casePortDequeueValue(PortDequeueValue object)
	      {
	        throw new UnsupportedOperationException() ;
	      }

	      @Override
		public String casePortCountValue(PortCountValue object)
	      {
	        throw new UnsupportedOperationException() ;
	      }

	      @Override
		public String casePortFreshValue(PortFreshValue object)
	      {
	        throw new UnsupportedOperationException() ;
	      }

	      /**
	       * Unparse booleanliteral
	       */
	      @Override
		public String caseBehaviorBooleanLiteral(BehaviorBooleanLiteral object)
	      {
	        //FIXME : TODO : update location reference
	        if(object.isValue())
	        {
	          _adbFileContent.addOutput("TRUE") ;
	        }
	        else
	        {
	          _adbFileContent.addOutput("FALSE") ;
	        }

	        return DONE ;
	      }

	      /**
	       * Unparse stringliteral
	       */
	      @Override
		public String caseBehaviorStringLiteral(BehaviorStringLiteral object)
	      {
	        //FIXME : TODO : update location reference
	        _adbFileContent.addOutput(object.getValue()) ;
	        return DONE ;
	      }

	      @Override
		public String caseBehaviorRealLiteral(BehaviorRealLiteral object)
	      {
	        _adbFileContent.addOutput(String.valueOf(object.getValue())) ;
	        return DONE ;
	      }

	      @Override
		public String caseBehaviorIntegerLiteral(BehaviorIntegerLiteral object)
	      {
	        _adbFileContent.addOutput(Long.toString(object.getValue())) ;
	        return DONE ;
	      }
	      
	      /**
	       * Unparse valueexpression
	       */
	      @Override
		public String caseValueExpression(ValueExpression object)
	      {
	        Iterator<Relation> itRel = object.getRelations().iterator() ;
	        process(itRel.next()) ;

	        if(object.isSetLogicalOperators())
	        {
	          Iterator<LogicalOperator> itOp =
	                object.getLogicalOperators().iterator() ;

	          while(itRel.hasNext())
	          {
	            _adbFileContent.addOutput(" " +
	                  AadlBaToADAUnparser.getTargetLanguageOperator(itOp.next()) +
	                  " ") ;
	            process(itRel.next()) ;
	          }
	        }

	        return DONE ;
	      }

	      /**
	       * Unparse relation
	       */
	      @Override
		public String caseRelation(Relation object)
	      {
	        process(object.getFirstExpression()) ;

	        if(object.getSecondExpression() != null)
	        {
	          _adbFileContent.addOutput(" " +
	                AadlBaToADAUnparser.getTargetLanguageOperator(object
	                      .getRelationalOperator()) + " ") ;
	          process(object.getSecondExpression()) ;
	        }

	        return DONE ;
	      }

	      /**
	       * Unparse simpleexpression
	       */
	      @Override
		public String caseSimpleExpression(SimpleExpression object)
	      {
	        if(object.getUnaryAddingOperator()!=UnaryAddingOperator.NONE)
	        {
	          _adbFileContent.addOutput(object.getUnaryAddingOperator()
	                .getLiteral()) ;
	        }

	        Iterator<Term> itTerm = object.getTerms().iterator() ;
	        process(itTerm.next()) ;

	        if(object.isSetBinaryAddingOperators())
	        {
	          Iterator<BinaryAddingOperator> itOp =
	                object.getBinaryAddingOperators().iterator() ;

	          while(itTerm.hasNext())
	          {
	            _adbFileContent.addOutput(" " + itOp.next().getLiteral() + " ") ;
	            process(itTerm.next()) ;
	          }
	        }

	        return DONE ;
	      }

	      /**
	       * Unparse term
	       */
	      @Override
		public String caseTerm(Term object)
	      {
	        Iterator<Factor> itFact = object.getFactors().iterator() ;
	        process(itFact.next()) ;

	        if(object.isSetMultiplyingOperators())
	        {
	          Iterator<MultiplyingOperator> itOp =
	                object.getMultiplyingOperators().iterator() ;

	          while(itFact.hasNext())
	          {
	            _adbFileContent.addOutput(" " +
	                  AadlBaToADAUnparser.getTargetLanguageOperator(itOp.next()) +
	                  " ") ;
	            process(itFact.next()) ;
	          }
	        }

	        return DONE ;
	      }

	      /**
	       * Unparse factor
	       */
	      @Override
		public String caseFactor(Factor object)
	      {
	        if(object.getUnaryNumericOperator() != UnaryNumericOperator.NONE)
	        {
	          _adbFileContent.addOutput(AadlBaToADAUnparser
	                                  .getTargetLanguageOperator(object
	                                                             .getUnaryNumericOperator())) ;
	          _adbFileContent.addOutput("(") ;
	        }
	        else if(object.getUnaryBooleanOperator()!= UnaryBooleanOperator.NONE)
	        {
	          _adbFileContent.addOutput(AadlBaToADAUnparser
	                                  .getTargetLanguageOperator(object
	                                                             .getUnaryBooleanOperator())) ;
	          _adbFileContent.addOutput("(") ;
	        }



	        if(object.getFirstValue() instanceof ValueExpression)
	        {
	          _adbFileContent.addOutput("(") ;
	          process(object.getFirstValue()) ;
	          _adbFileContent.addOutput(")") ;
	        }
	        else
	        {
	          process(object.getFirstValue()) ;
	        }

	        if(object.getUnaryNumericOperator()!=UnaryNumericOperator.NONE ||
	              object.getUnaryBooleanOperator() != UnaryBooleanOperator.NONE)
	        {
	          _adbFileContent.addOutput(")") ;
	        }

	        if(object.getBinaryNumericOperator()!=BinaryNumericOperator.NONE)
	        {
	          _adbFileContent.addOutput(" " +
	                object.getBinaryNumericOperator().getLiteral() + " ") ;

	          if(object.getSecondValue() instanceof ValueExpression)
	          {
	            _adbFileContent.addOutput("(") ;
	            process(object.getSecondValue()) ;
	            _adbFileContent.addOutput(")") ;
	          }
	          else
	          {
	            process(object.getSecondValue()) ;
	          }
	        }

	        return DONE ;
	      }
	/*
	      public String caseComment(Comment object)
	      {
	        _adbFileContent.addOutputNewline("// " + object.getBody()) ;
	        return DONE ;
	      }
	*/
	    } ;
	  }

	  public void addIndent_ADB(String indent)
	  {
	    while(_adbFileContent.getIndentString().length() < indent.length())
	    {
	      _adbFileContent.incrementIndent() ;
	    }
	  }

	  public void addIndent_ADS(String indent)
	  {
	    while(_adsFileContent.getIndentString().length() < indent.length())
	    {
	      _adsFileContent.incrementIndent() ;
	    }
	  }

	  public void setOwner(NamedElement owner) {
		this._owner = owner;
	  }
}
