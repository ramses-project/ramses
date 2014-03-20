/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

/**
 * Author: Etienne Borde
 */

package fr.tpt.aadl.ramses.generation.ada.annex.behavior;

import java.util.ArrayList ;
import java.util.HashSet ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.common.util.AbstractEnumerator ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.xtext.EcoreUtil2 ;
import org.osate.aadl2.AccessType ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.ArrayDimension ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.DataAccess ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Parameter ;
import org.osate.aadl2.ParameterConnectionEnd ;
import org.osate.aadl2.PrototypeBinding ;
import org.osate.aadl2.SubprogramClassifier ;
import org.osate.aadl2.SubprogramImplementation ;
import org.osate.aadl2.SubprogramSubcomponentType ;
import org.osate.aadl2.SubprogramType ;
import org.osate.aadl2.ThreadClassifier ;
import org.osate.aadl2.modelsupport.AadlConstants ;
import org.osate.aadl2.modelsupport.UnparseText ;
import org.osate.aadl2.modelsupport.util.AadlUtil ;
import org.osate.ba.aadlba.Any ;
import org.osate.ba.aadlba.AssignmentAction ;
import org.osate.ba.aadlba.BehaviorActionBlock ;
import org.osate.ba.aadlba.BehaviorActionSequence ;
import org.osate.ba.aadlba.BehaviorActionSet ;
import org.osate.ba.aadlba.BehaviorActions ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorBooleanLiteral ;
import org.osate.ba.aadlba.BehaviorElement ;
import org.osate.ba.aadlba.BehaviorEnumerationLiteral ;
import org.osate.ba.aadlba.BehaviorIntegerLiteral ;
import org.osate.ba.aadlba.BehaviorRealLiteral ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BehaviorStringLiteral ;
import org.osate.ba.aadlba.BehaviorTime ;
import org.osate.ba.aadlba.BehaviorTransition ;
import org.osate.ba.aadlba.BehaviorVariable ;
import org.osate.ba.aadlba.BehaviorVariableHolder ;
import org.osate.ba.aadlba.BinaryAddingOperator ;
import org.osate.ba.aadlba.BinaryNumericOperator ;
import org.osate.ba.aadlba.CalledSubprogramHolder ;
import org.osate.ba.aadlba.DataAccessHolder ;
import org.osate.ba.aadlba.DataComponentReference ;
import org.osate.ba.aadlba.DataHolder ;
import org.osate.ba.aadlba.DataSubcomponentHolder ;
import org.osate.ba.aadlba.DispatchCondition ;
import org.osate.ba.aadlba.DispatchConjunction ;
import org.osate.ba.aadlba.DispatchTriggerConditionStop ;
import org.osate.ba.aadlba.DispatchTriggerLogicalExpression ;
import org.osate.ba.aadlba.ElementHolder ;
import org.osate.ba.aadlba.ElementValues ;
import org.osate.ba.aadlba.ElseStatement ;
import org.osate.ba.aadlba.Factor ;
import org.osate.ba.aadlba.ForOrForAllStatement ;
import org.osate.ba.aadlba.IfStatement ;
import org.osate.ba.aadlba.IndexableElement ;
import org.osate.ba.aadlba.IntegerRange ;
import org.osate.ba.aadlba.IntegerValue ;
import org.osate.ba.aadlba.IntegerValueConstant ;
import org.osate.ba.aadlba.IntegerValueVariable ;
import org.osate.ba.aadlba.LockAction ;
import org.osate.ba.aadlba.LogicalOperator ;
import org.osate.ba.aadlba.MultiplyingOperator ;
import org.osate.ba.aadlba.Otherwise ;
import org.osate.ba.aadlba.ParameterHolder ;
import org.osate.ba.aadlba.ParameterLabel ;
import org.osate.ba.aadlba.PortCountValue ;
import org.osate.ba.aadlba.PortDequeueAction ;
import org.osate.ba.aadlba.PortDequeueValue ;
import org.osate.ba.aadlba.PortFreezeAction ;
import org.osate.ba.aadlba.PortFreshValue ;
import org.osate.ba.aadlba.PortSendAction ;
import org.osate.ba.aadlba.Relation ;
import org.osate.ba.aadlba.RelationalOperator ;
import org.osate.ba.aadlba.SimpleExpression ;
import org.osate.ba.aadlba.SubprogramCallAction ;
import org.osate.ba.aadlba.SubprogramHolder ;
import org.osate.ba.aadlba.Term ;
import org.osate.ba.aadlba.TimedAction ;
import org.osate.ba.aadlba.UnaryAddingOperator ;
import org.osate.ba.aadlba.UnaryBooleanOperator ;
import org.osate.ba.aadlba.UnaryNumericOperator ;
import org.osate.ba.aadlba.UnlockAction ;
import org.osate.ba.aadlba.Value ;
import org.osate.ba.aadlba.ValueExpression ;
import org.osate.ba.aadlba.WhileOrDoUntilStatement ;
import org.osate.ba.aadlba.util.AadlBaSwitch ;
import org.osate.ba.analyzers.TypeHolder ;
import org.osate.ba.unparser.AadlBaUnparser ;
import org.osate.ba.utils.AadlBaUtils ;
import org.osate.ba.utils.AadlBaVisitors ;
import org.osate.ba.utils.DimensionException ;
import org.osate.utils.Aadl2Utils ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.control.support.RamsesException ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.generation.ada.AadlToADAUnparser ;
import fr.tpt.aadl.ramses.generation.ada.GenerationUtilsADA ;
import fr.tpt.aadl.ramses.generation.utils.GeneratorUtils ;


public class AadlBaToADAUnparser extends AadlBaUnparser
{
  protected Map<DataAccess, String> _dataAccessMapping = null ;
  protected UnparseText _adaFileContent = null ;
  protected UnparseText _headerFileContent = null ;
  protected Set<String> _additionalHeaders = new HashSet<String>() ;
  private NamedElement _owner ;
  private List<NamedElement> coreElementsToBeUnparsed = new ArrayList<NamedElement>();
  
  private static Logger _LOGGER = Logger.getLogger(AadlBaToADAUnparser.class) ;

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
  
  public String getADAContent()
  {
    return _adaFileContent.getParseOutput() ;
  }

  public String getADSContent()
  {
    return _headerFileContent.getParseOutput() ;
  }

  public Set<String> getAdditionalHeaders()
  {
    return _additionalHeaders ;
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
        aadlText.addOutput("processEList: oh my, oh my!!") ;
        String errMsg = "unsuported type when process EList" ;
        _LOGGER.error(errMsg);
        ServiceProvider.SYS_ERR_REP.error(errMsg, true);
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
      String msg = "unsupported operator rem" ;
      _LOGGER.fatal(msg);
      throw new UnsupportedOperationException(msg) ;
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
      public String caseAnnexSubclause(AnnexSubclause object)
      {
        process((BehaviorAnnex) object) ;
        return DONE ;
      }

      /**
       * Unparse behaviorannex
       */
      public String caseBehaviorAnnex(BehaviorAnnex object)
      {
        BehaviorAnnex ba = (BehaviorAnnex) object ;
        NamedElement aadlComponent = _owner ;
        String aadlComponentADAId = GenerationUtilsADA.getGenerationADAIdentifier(
                                             aadlComponent.getQualifiedName()) ;

        _adaFileContent = new UnparseText() ;
        _headerFileContent = new UnparseText() ;

        _adaFileContent.addOutputNewline("current_state : " +
                                         aadlComponentADAId +
                                         "_BA_State_t := " +
                                         aadlComponentADAId +
                                         "_" +
                                         AadlBaToADAUnparser.getInitialStateIdentifier(ba) +
                                         ";") ;
        processEList(_adaFileContent, ba.getVariables()) ;
        _adaFileContent.addOutputNewline("final : integer := 0;") ;
        _adaFileContent.addOutputNewline("begin") ;

        _adaFileContent.addOutputNewline("while (final /= 1) loop") ;
        _adaFileContent.incrementIndent() ;
        _adaFileContent.addOutputNewline("case current_state is") ;
        _adaFileContent.incrementIndent() ;

        _headerFileContent.addOutputNewline("type " + aadlComponentADAId +
                                            "_BA_State_t is (") ;
        _headerFileContent.incrementIndent() ;

        for(BehaviorState state : ba.getStates())
        {
          if(AadlBaVisitors.getTransitionWhereSrc(state).isEmpty() == false)
          {
            _adaFileContent.addOutputNewline("when " + aadlComponentADAId +
                                             "_" + state.getName() + " => ") ;
            processEList(_adaFileContent,
                         (ArrayList<BehaviorTransition>) AadlBaVisitors.
                                                 getTransitionWhereSrc(state)) ;
          }

          String stateADAId = GenerationUtilsADA.getGenerationADAIdentifier(
                                              aadlComponent.getQualifiedName() +
                                                    "_" + state.getName()) ;
          _headerFileContent.addOutput(stateADAId) ;

          if(ba.getStates().indexOf(state) < ba.getStates().size() - 1)
          {
            _headerFileContent.addOutput(",") ;
          }

          if(ba.getStates().indexOf(state) == ba.getStates().size() - 1)
          {
            _adaFileContent.addOutputNewline("when others =>") ;
            _adaFileContent.addOutputNewline("final := 1;") ;
          }
          _headerFileContent.addOutputNewline("") ;
        }

        _headerFileContent.decrementIndent() ;
        _headerFileContent.addOutputNewline(");") ;
        _headerFileContent.addOutputNewline("") ;
        _adaFileContent.decrementIndent() ;
        _adaFileContent.addOutputNewline("end case;") ;

        _adaFileContent.decrementIndent() ;
        _adaFileContent.addOutputNewline("end loop;") ;
        _adaFileContent.decrementIndent() ;

        return DONE ;
      }

      /**
       * Unparse behaviorvariable
       */
      public String caseBehaviorVariable(BehaviorVariable object)
      {
        String sourceName = PropertyUtils.getStringValue(object.getDataClassifier(),
                                                         "Source_Name") ;
        if(sourceName == null)
        {
          sourceName = GenerationUtilsADA.
                getGenerationADAIdentifier(object.
                                         getDataClassifier().getQualifiedName());
        }
        
        _adaFileContent.addOutput(object.getName());
        _adaFileContent.addOutput(" : " + sourceName) ;
        caseArrayDimensions(object.getArrayDimensions()) ;
        String init = GeneratorUtils.getInitialValue(object.getDataClassifier(), "ada") ;
        if(!init.isEmpty())
        {
        	_adaFileContent.addOutput(" := "+init) ;
        }
        _adaFileContent.addOutputNewline(";") ;
        coreElementsToBeUnparsed.add(object.getDataClassifier());
        return DONE ;
      }

      /**
       * Unparse arraysize
       */
      public String caseArrayDimensions(EList<ArrayDimension> arrayDimensions)
      {
        for(ArrayDimension ivc : arrayDimensions)
        {
          _adaFileContent.addOutput("(") ;
          _adaFileContent.addOutput(Long.toString(ivc.getSize().getSize()));
          _adaFileContent.addOutput(")") ;
        }

        return DONE ;
      }

      public String caseBehaviorEnumerationLiteral(BehaviorEnumerationLiteral object)
      {
        // ComponentPropertyValue is defined to refer Enumerated data
      	NamedElement component = object.getComponent();
      	if(component!=null)
      	{
      	  String sourceName = PropertyUtils.getStringValue(component, "Source_Name") ;
          if(sourceName != null)
          {
            _adaFileContent.addOutput(object.getEnumLiteral().getValue());
          }
          else
          {
            _adaFileContent.addOutput(GenerationUtilsADA.getGenerationADAIdentifier
                                      (component.getQualifiedName())+
                                      "_"+object.getEnumLiteral().getValue());
          }
      	}
      	else
      		_adaFileContent.addOutput(object.getEnumLiteral().getValue());
          
          return DONE ;
      }
      
      /**
       * Unparse DataComponentReference
       */
      public String caseDataComponentReference(DataComponentReference object)
      {
        Iterator<DataHolder> itDataHolder = object.getData().iterator() ;
        process(itDataHolder.next()) ;
        while(itDataHolder.hasNext())
        {
          _adaFileContent.addOutput(".") ;
          _adaFileContent.addOutput(((DataHolder) itDataHolder.next()).getElement()
                                                                      .getName()) ;
        }

        return DONE ;
      }

      /**
       * Unparse behaviorstate
       * @object: input parameter, destination of a Behavior Transition
       */
      public String caseBehaviorState(BehaviorState object)
      {
        NamedElement aadlComponent = _owner ;
        String aadlComponentADAId =
              GenerationUtilsADA.getGenerationADAIdentifier(aadlComponent
                    .getQualifiedName()) ;
        //if (object.isComplete())

        if(object.isFinal())
        {
          _adaFileContent.addOutputNewline("final := 1;") ;
        }
        else
        {
          _adaFileContent.addOutputNewline("current_state := " + aadlComponentADAId +
                    "_" + object.getName() + ";") ;
        }
        return DONE ;
      }

      
      /**
       * Unparse behaviortransition
       */
      public String caseBehaviorTransition(BehaviorTransition object)
      {
        aadlbaText = _adaFileContent ;
        long num = object.getPriority() ;

        _adaFileContent.addOutput("-- Transition id: " + object.getName()) ;

        if(num != -1) // numeral
        {
          _adaFileContent.addOutput(" -- Priority " +
                String.valueOf(num)) ;
        }

        _adaFileContent.addOutputNewline("") ;

        if(object.getCondition() != null)
        {
          if(object.getCondition() instanceof Otherwise)
          {
            _adaFileContent.addOutput("else") ;
            process(object.getCondition()) ;
          }
          else
          {
            _adaFileContent.addOutput("if ") ;
            process(object.getCondition()) ;
            _adaFileContent.addOutputNewline(" then") ;
          }
        }
        else
        {
          _adaFileContent.addOutputNewline("if TRUE then -- no execution condition") ;
        }

        _adaFileContent.incrementIndent() ;

        if(object.getActionBlock() != null)
        {
          process(object.getActionBlock()) ;
        }

        process((BehaviorState) object.getDestinationState()) ;
        _adaFileContent.decrementIndent() ;
        _adaFileContent.addOutputNewline("end if;") ;
        return DONE ;
      }


      public String caseOtherwise(Otherwise object)
      {
        _adaFileContent.addOutputNewline(" --otherwise") ;
        return DONE ;
      }

      /**
       * Unparse dispatchcondition
       */
      public String caseDispatchCondition(DispatchCondition object)
      {
        String msg = "unsupported caseDispatchCondition" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg) ;
      }

      public String caseDispatchTriggerConditionStop(DispatchTriggerConditionStop object)
      {
        String msg = "unsupported caseDispatchTriggerConditionStop" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg) ;
      }

      public String caseDispatchTriggerLogicalExpression(DispatchTriggerLogicalExpression object)
      {
        String msg = "unsupported caseDispatchTriggerLogicalExpression" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg) ;
      }

      public String caseDispatchConjunction(DispatchConjunction object)
      {
        String msg = "unsupported caseDispatchConjunction" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg) ;
      }

      public String caseBehaviorActionBlock(BehaviorActionBlock object)
      {
        process(object.getContent()) ;

        if(object.getTimeout() != null)
        {
          String msg = "unsupported caseBehaviorActionBlock" ;
          _LOGGER.fatal(msg);
          throw new UnsupportedOperationException(msg) ;
        }

        return DONE ;
      }

      public String caseBehaviorActionSequence(BehaviorActionSequence object)
      {
        processEList(_adaFileContent, object.getActions()) ;
        return DONE ;
      }

      public String caseBehaviorActionSet(BehaviorActionSet object)
      {
        String msg = "unsupported BehaviorActionSet unparsing" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg) ;
      }
      
      /**
       * Unparse elsestatement
       */
      public String caseElseStatement(ElseStatement object)
      {
        BehaviorActions lba = object.getBehaviorActions() ;
        _adaFileContent.addOutputNewline("else ") ;
        process(lba) ;
        _adaFileContent.addOutputNewline("end if;") ;
        return DONE ;
      }
      
      /**
       * Unparse ifstatement
       */
      public String caseIfStatement(IfStatement object)
      {
        ValueExpression ve = object.getLogicalValueExpression() ;
        BehaviorActions lba = object.getBehaviorActions() ;

        if(object.isElif())
          _adaFileContent.addOutput("elsif (") ;
        else
          _adaFileContent.addOutput("if (") ;
        
        process(ve) ;
        _adaFileContent.addOutput(") ") ;

        
        _adaFileContent.addOutputNewline(" then") ;
        process(lba) ;
        _adaFileContent.addOutputNewline("") ;
        _adaFileContent.addOutputNewline("end if;") ;
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
      public String caseForOrForAllStatement(ForOrForAllStatement object)
      {
        ElementValues set = object.getIteratedValues() ;

        if(set instanceof IntegerRange)
        {
	          IntegerRange range = (IntegerRange) set ;
	          String lowerRangeValue = this.toInteger(range.getLowerIntegerValue()) ;
	          String upperRangeValue = this.toInteger(range.getUpperIntegerValue()) ;
	          _adaFileContent.addOutputNewline("iter : Integer;") ;
	          _adaFileContent.addOutputNewline("for iter in " + lowerRangeValue +
	                                           " .. " + upperRangeValue + " loop") ;
	          _adaFileContent.incrementIndent() ;
          DataClassifier iterativeVariableClassifier = object.getIterativeVariable().
                                                           getDataClassifier() ;
          try
          {
            GenerationUtilsADA.resolveExistingCodeDependencies(iterativeVariableClassifier,
                                                               _additionalHeaders);
          } catch(Exception e)
          {
            _adaFileContent.addOutput(GenerationUtilsADA.
                                    getGenerationADAIdentifier(iterativeVariableClassifier.
                                    getQualifiedName()));
          }
          
          _adaFileContent.addOutput(" ") ;
          _adaFileContent.addOutput(object.getIterativeVariable().getName()) ;
          _adaFileContent.addOutputNewline(" := iter;") ;
          process(object.getBehaviorActions()) ;
          _adaFileContent.decrementIndent() ;
          _adaFileContent.addOutputNewline("end loop;") ;
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
            String errMsg = RamsesException.formatRethrowMessage("cannot fetch type holder for \'" + object.getIteratedValues() +
                '\'', e);
            _LOGGER.error(errMsg, e);
            ServiceProvider.SYS_ERR_REP.error(errMsg, true);
          }

          int numberOfLoop = dataReferenceTypeHolder.dimension ;

          for(int i = 0 ; i < numberOfLoop ; i++)
          {
	            String iteratorID = "iter" + Integer.toString(i) ;
	            _adaFileContent.addOutputNewline(iteratorID + " : Integer;") ;
	            _adaFileContent.addOutputNewline("for " + iteratorID + " in 0 .. " + Long.toString(dataReferenceTypeHolder.dimension_sizes[i] - 1) + " loop") ;
	            _adaFileContent.incrementIndent() ;
          }

          DataClassifier iterativeVariableClassifier = object.getIterativeVariable().getDataClassifier() ;
          try
          {
            String existing = GenerationUtilsADA.resolveExistingCodeDependencies(iterativeVariableClassifier, _additionalHeaders);
            aadlbaText.addOutput(existing);
          }
          catch(Exception e)
          {
            _adaFileContent.addOutput(GenerationUtilsADA.
                                    getGenerationADAIdentifier(iterativeVariableClassifier.getQualifiedName()));
          }
          _adaFileContent.addOutput(" ") ;
          _adaFileContent.addOutput(object.getIterativeVariable().getName()) ;
          _adaFileContent.addOutput(" := ") ;
          process(object.getIteratedValues()) ;

          for(int i = 0 ; i < numberOfLoop ; i++)
          {
	            String iteratorID = "iter" + Integer.toString(i) ;
	            _adaFileContent.addOutput("(") ;
	            _adaFileContent.addOutput(iteratorID) ;
	            _adaFileContent.addOutput(")") ;
//	            _adbFileContent.addOutput("--A DEBUGER") ;
          }

          _adaFileContent.addOutputNewline(";") ;
          process(object.getBehaviorActions()) ;

          for(int i = 0 ; i < numberOfLoop ; i++)
          {
            _adaFileContent.decrementIndent() ;
            _adaFileContent.addOutputNewline("end loop;") ;
          }	
        }

        return DONE ;
      }

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
        _adaFileContent.addOutput("while (") ;
        process(object.getLogicalValueExpression()) ;
        _adaFileContent.addOutputNewline(")") ;
        _adaFileContent.addOutputNewline("loop") ;
        _adaFileContent.incrementIndent() ;
        process(object.getBehaviorActions()) ;
        _adaFileContent.decrementIndent() ;
        _adaFileContent.addOutputNewline("end loop;") ;
        return DONE ;
      }

      /**
       * Unparse dountilstatement
       */
      public String caseDoUntilStatement(WhileOrDoUntilStatement object)
      {
    	  _adaFileContent.addOutputNewline("loop") ;
    	  _adaFileContent.incrementIndent() ;
    	  process(object.getBehaviorActions()) ;
    	  _adaFileContent.decrementIndent() ;
    	  _adaFileContent.addOutput("exit when ") ;
    	  process(object.getLogicalValueExpression()) ;
    	  _adaFileContent.addOutputNewline(";") ;
    	  _adaFileContent.addOutputNewline("end loop;") ;
    	  return DONE ;
      }

      /**
       * Unparse integerrange
       */
      public String caseIntegerRange(IntegerRange object)
      {
        String msg = "unsupported caseIntegerRange unparsing" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg) ;
      }

      /**
       * Unparse timedaction
       */
      public String caseTimedAction(TimedAction object)
      {
        String msg = "unsupported caseTimedAction unparsing" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg) ;
      }

      /**
       * Unparse assignmentaction
       */
      public String caseAssignmentAction(AssignmentAction object)
      {
        process(object.getTarget()) ;
        _adaFileContent.addOutput(" := ") ;

        if(object instanceof Any)
        {
          String msg = "unsupported caseAssignmentAction unparsing" ;
          _LOGGER.fatal(msg);
          throw new UnsupportedOperationException(msg) ;
        }
        else
        {
          process(object.getValueExpression()) ;
        }

        _adaFileContent.addOutputNewline(";") ;
        return DONE ;
      }
      
      public void manageParameterDirection(Parameter formal, ParameterLabel actual)
      {
    	  String usageP = Aadl2Utils.getParameterUsage(formal);
          if(Aadl2Utils.isInOutParameter(formal) ||
          		Aadl2Utils.isOutParameter(formal) ||
          		usageP.equalsIgnoreCase("by_reference"))
          {
            if(actual instanceof ParameterHolder)
            {
          	  ParameterHolder ph = (ParameterHolder) actual;
          	  String usage = Aadl2Utils.getParameterUsage(ph.getParameter());
          	  // in out passed to in
          	  if(!Aadl2Utils.isOutParameter(ph.getParameter()) &&
          		!Aadl2Utils.isInOutParameter(ph.getParameter())
          		&& !usage.equalsIgnoreCase("by_reference"))
          		// and ph.getParameter not by reference
          		  _adaFileContent.addOutput("") ;
          		  
            }
            else if(actual instanceof DataAccessHolder)
            {
              DataAccessHolder dah = (DataAccessHolder) actual;
              if(!Aadl2Utils.isReadWriteDataAccess(dah.getDataAccess()) &&
            		  !Aadl2Utils.isWriteOnlyDataAccess(dah.getDataAccess()))
            	  //TODO: and dah.getAccess not by reference
            	  _adaFileContent.addOutput("") ;
            }
            else if(actual instanceof ValueExpression)
            {
          	  ValueExpression ve = (ValueExpression) actual;
            	  Value v = ve.getRelations().get(0).
            			  getFirstExpression().getTerms().get(0).
            			  getFactors().get(0).
            			  getFirstValue();
          	  if(v instanceof DataAccessHolder)
          	  {
          		manageParameterDirection(formal, (ParameterLabel) v);
          	  }
          	  else if (v instanceof ParameterHolder)
          	  {
          		manageParameterDirection(formal, (ParameterLabel) v);
          	  }
          	  else
          	  {
          		_adaFileContent.addOutput("") ;
          	  }
            }
          }
          else
          {
          	// if p not by_reference
          	if(actual instanceof ParameterHolder)
            {
          	  ParameterHolder ph = (ParameterHolder) actual;
          	  String usagePH = Aadl2Utils.getParameterUsage(ph.getElement());
          	  // in to inout
          	  if(Aadl2Utils.isOutParameter(ph.getParameter()) ||
              	Aadl2Utils.isInOutParameter(ph.getParameter()) ||
              	  usagePH.equalsIgnoreCase("by_reference"))
          		  _adaFileContent.addOutput("") ;
            }
          	else if(actual instanceof DataAccessHolder)
            {
              DataAccessHolder dah = (DataAccessHolder) actual;
              if(Aadl2Utils.isReadWriteDataAccess(dah.getDataAccess()) &&
            		  Aadl2Utils.isWriteOnlyDataAccess(dah.getDataAccess()))
            	  //TODO: and dah.getAccess not by reference
            	  _adaFileContent.addOutput("") ;
            }
            else if(actual instanceof ValueExpression)
            {
          	  ValueExpression ve = (ValueExpression) actual;
            	  Value v = ve.getRelations().get(0).
            			  getFirstExpression().getTerms().get(0).
            			  getFactors().get(0).
            			  getFirstValue();
          	  if(v instanceof DataAccessHolder)
          	  {
          		manageParameterDirection(formal, (ParameterLabel) v);
          	  }
          	  else if (v instanceof ParameterHolder)
          	  {
          		manageParameterDirection(formal, (ParameterLabel) v);
          	  }
            }
          }
          return;
      }
      
      public boolean manageAccessDirection(DataAccess formal, ParameterLabel actual)
      {
    	  boolean remainingParenthesis=false;
    	  if(Aadl2Utils.isReadWriteDataAccess(formal)
        		  || Aadl2Utils.isWriteOnlyDataAccess(formal))
          {
        	if(actual instanceof DataAccessHolder)
        	{
        	  DataAccessHolder dah = (DataAccessHolder) actual;
        	  // in out passed to in
          	  if(!Aadl2Utils.isReadWriteDataAccess(dah.getDataAccess()) &&
          		!Aadl2Utils.isWriteOnlyDataAccess(dah.getDataAccess()))
          		//TODO: and dah.getAccess not by reference
          		  _adaFileContent.addOutput("") ;
        	}
        	else if(actual instanceof DataSubcomponentHolder
        			|| actual instanceof BehaviorVariableHolder)
        		_adaFileContent.addOutput("") ;
        	else if (actual instanceof DataComponentReference)
            {
          	  _adaFileContent.addOutput("(") ;
          	  remainingParenthesis=true;
            }
          }
          else
          {
        	//TODO: if da not by_reference
        	if(actual instanceof DataAccessHolder)
          	{
          		DataAccessHolder dah = (DataAccessHolder) actual;
          		// in to inout
        		if(Aadl2Utils.isWriteOnlyDataAccess(dah.getDataAccess()) ||
            		Aadl2Utils.isReadWriteDataAccess(dah.getDataAccess()))
        			_adaFileContent.addOutput("") ;
          	}
          }
    	  return remainingParenthesis;
      }
      
      public String caseCalledSubprogramHolder(CalledSubprogramHolder object)
      {
        aadlbaText = _adaFileContent;
        String referencingExistingCode = GenerationUtilsADA.resolveExistingCodeDependencies(object.getElement(), _additionalHeaders);
        if(referencingExistingCode!=null)
        	aadlbaText.addOutput(referencingExistingCode);
        else
        {
        	_adaFileContent.addOutput(GenerationUtilsADA.
        			getGenerationADAIdentifier(object.getElement().getQualifiedName()));
        }
        return DONE ;
      }
      
      public String caseSubprogramCallAction(SubprogramCallAction object)
      {
        Parameter returnParameter = null;

        if(object.getSubprogram().getElement() != null)
        {
          SubprogramType st = null ;
          SubprogramSubcomponentType sct =
                (SubprogramSubcomponentType) object.getSubprogram().getElement() ;

          AadlToADAUnparser aadlADAUnparser = AadlToADAUnparser.getAadlToADAUnparser(); 
          
          if(sct instanceof SubprogramType)
          {
            st = (SubprogramType) sct ;
          }
          else
          {
            SubprogramImplementation si = (SubprogramImplementation) sct ;
            st = si.getType() ;
          }
          additionalSubprogramsToUnparse(sct);
          List<PrototypeBinding> currentBindings = aadlADAUnparser.getCurrentPrototypeBindings(
        		  object.getSubprogram().getElement().getName());
          List<Feature> ordereFeatureList = Aadl2Utils.orderFeatures(st, currentBindings) ;

          for(ParameterLabel pl : object.getParameterLabels())
          {
            ParameterConnectionEnd pce =
                  (ParameterConnectionEnd) ordereFeatureList.get(object
                                                                 .getParameterLabels().indexOf(pl)) ;

            if(pce instanceof Parameter)
            {
              Parameter p = (Parameter) pce ;
              boolean isReturnParam = GenerationUtilsADA.isReturnParameter(p);
              if(isReturnParam)
              {
                returnParameter = p;
                process(pl);
                _adaFileContent.addOutput(" := ") ;
                break;
              }
            }
          }

          process(object.getSubprogram()) ;

          if(st != null)
          {
            _adaFileContent.addOutput(" (") ;
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
                  _adaFileContent.addOutput(", ") ;
                
                manageParameterDirection(p, pl);

                if(pl instanceof ElementHolder)
                {
                  ElementHolder eh = (ElementHolder) pl;
                  if(eh instanceof ParameterHolder
                		  || eh instanceof DataAccessHolder)
                  {
                	  _adaFileContent.addOutput(eh.getElement().getName());
                  }
                  else
                	  _adaFileContent.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(eh.getElement().getQualifiedName()));
                } 
                else if(pl instanceof ValueExpression)
                {
              	  ValueExpression ve = (ValueExpression) pl;
              	  Value v = ve.getRelations().get(0).
              			  getFirstExpression().getTerms().get(0).
              			  getFactors().get(0).
              			  getFirstValue();
              	  if(v instanceof ElementHolder)
              	  {
              		ElementHolder eh = (ElementHolder) v;
              		if(eh instanceof ParameterHolder
                  		  || eh instanceof DataAccessHolder)
              		{
                  	  _adaFileContent.addOutput(eh.getElement().getName());
              		}
                    else
                  	  _adaFileContent.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(eh.getElement().getQualifiedName()));
              	  }
              	  else if(v instanceof DataComponentReference)
              	  {
              		DataComponentReference dcr = (DataComponentReference) v;
              		boolean firstElement = true;
              		for(DataHolder dh: dcr.getData())
              		{
              		  boolean lastElement = (dcr.getData().indexOf(dh)==dcr.getData().size()-1);
              		  if(dh instanceof ParameterHolder
                            || dh instanceof DataAccessHolder
                            || firstElement == false)
              		  {
                        _adaFileContent.addOutput(dh.getElement().getName());
              		  }
                      else
                      {
                        _adaFileContent.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(dh.getElement().getQualifiedName()));
                        firstElement=false;
                      }
              		  if(paramAsPrototype(dh.getElement(), st))
          		  	  {
              			_adaFileContent.addOutput("'Address") ;
          		  	  }
              		  if(!lastElement)
              			  _adaFileContent.addOutput(".");
              		}
              	  }
                }
                else
                {
                  process(pl) ;
                }
                first=false;
                if(paramAsPrototype(p, st))
                {
              	  _adaFileContent.addOutput("'Address") ;
                }
              }
              else if(pce instanceof DataAccess)
              {
                DataAccess da = (DataAccess) pce ;
                if(first==false)
                  _adaFileContent.addOutput(", ") ;
                if(da.getKind().equals(AccessType.REQUIRES))
                {
                  manageAccessDirection(da, pl);  
                }

                String name = null ;

                // If a data access mapping is provided:
                // Transforms any data access into the right data subcomponent
                // 's name thanks to the given data access mapping.
                if(_dataAccessMapping != null)
                {
                  ElementHolder eh = null;
                  if(pl instanceof ValueExpression)
                  {
                	  Relation r = ((ValueExpression)pl).getRelations().get(0);
                	  Term t = r.getFirstExpression().getTerms().get(0);
                	  eh = (ElementHolder) t.getFactors().get(0).getFirstValue();  
                  }
                  else if(pl instanceof DataAccessHolder)
                  {
                  	eh = (ElementHolder) pl;
                  }
                  if(eh instanceof DataAccessHolder && 
                		  AadlUtil.getContainingAnnex(eh) instanceof ThreadClassifier)
                  	name = _dataAccessMapping.get((DataAccess)eh.getElement());
                  else if(eh instanceof DataSubcomponentHolder)
                  {
                  	DataSubcomponent ds = (DataSubcomponent) ((DataSubcomponentHolder) eh).getElement(); 
                  	name = GenerationUtilsADA.getGenerationADAIdentifier(ds.getQualifiedName());
                  }
                  
                }

                if(name != null)
                {
                  _adaFileContent.addOutput(name) ;
                }
                else
                // Otherwise, process parameter label as usual.
                {
                  process((ParameterLabel) pl) ;
                }
                if(paramAsPrototype(da, st))
                {
                  _adaFileContent.addOutput("'Address") ;
                }
                first = false ;
              }
            }

            _adaFileContent.addOutputNewline(");") ;
          }
        }
        else
        {
          if(object.isSetParameterLabels())
          {
            _adaFileContent.addOutput(" (") ;
            processEList(_adaFileContent, object.getParameterLabels(), ", ") ;
            _adaFileContent.addOutputNewline(");") ;
          }
        }

        return DONE ;
      }
      
      private boolean paramAsPrototype(NamedElement element,
                                       SubprogramClassifier subprogram)
      {
        if(subprogram.getExtended() == null)
          return false ;
        if(element instanceof Feature)
        {
//          Feature f = (Feature) element ;
          Classifier extendedSc = subprogram.getExtended() ;
          for(Feature extendedFeature : extendedSc.getAllFeatures())
          {
            if(false == extendedFeature.getName().equals(element.getName()))
              continue ;
            if(extendedFeature instanceof DataAccess)
            {
              DataAccess da = (DataAccess) extendedFeature ;
              if(da.getPrototype() == null)
              {
                if(subprogram.getExtended() != null)
                  return paramAsPrototype(element,
                                          (SubprogramClassifier) subprogram.getExtended()) ;
                else
                  return false ;
              }
            }
            if(extendedFeature instanceof Parameter)
            {
              Parameter da = (Parameter) extendedFeature ;
              if(da.getPrototype() == null)
              {
                if(subprogram.getExtended() != null)
                  return paramAsPrototype(element,
                                          (SubprogramClassifier) subprogram.getExtended()) ;
                else
                  return false ;
              }
            }
          }
          
          NamedElement ne = extendedSc ;
          String sourceName = PropertyUtils.getStringValue(ne, "Source_Name") ;
          if(sourceName != null)
          {
            List<String> sourceText =
                                      PropertyUtils.getStringListValue(ne,
                                                                       "Source_Text") ;
            if(sourceText != null)
            {
              for(String s : sourceText)
              {
                if(s.endsWith(".ads"))
                {
                  return true ;
                }
              }
              return false ;
            }
            else
            {
              return false ;
            }
          }
          else
          {
            return false ;
          }
        }
        return false ;
      }

      private void
          additionalSubprogramsToUnparse(SubprogramSubcomponentType sct)
      {
        AadlToADAUnparser aadlADAUnparser =
                                            AadlToADAUnparser.getAadlToADAUnparser() ;
        if(false == aadlADAUnparser.additionalUnparsing.contains(sct))
          aadlADAUnparser.additionalUnparsing.add(sct) ;
        for(AnnexSubclause as : ((SubprogramClassifier) sct).getAllAnnexSubclauses())
        {
          if(as instanceof BehaviorAnnex)
          {
            for(SubprogramHolder otherSpg : EcoreUtil2.getAllContentsOfType(as,
                                                                            SubprogramHolder.class))
            {
              if(true == aadlADAUnparser.additionalUnparsing.contains(otherSpg))
                continue ;
              aadlADAUnparser.additionalUnparsing.add(otherSpg.getSubprogram()) ;
              additionalSubprogramsToUnparse((SubprogramSubcomponentType) otherSpg.getSubprogram()) ;
            }
            return ;
          }
        }
      }

      public String caseElementHolder(ElementHolder object)
      {
        NamedElement elt = object.getElement() ;
        String id ;
        if(elt instanceof Parameter)
        {
//          Parameter p = (Parameter) elt ;
          id = elt.getName() ;

        }
        else if(elt instanceof DataAccess)
        {
//          DataAccess da = (DataAccess) elt ;

          id = elt.getName() ;
        }
        else
          id = elt.getQualifiedName() ;
        aadlbaText.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(id)) ;
        if(object instanceof IndexableElement)
        {
          IndexableElement ie = (IndexableElement) object ;
          for(IntegerValue iv : ie.getArrayIndexes())
          {
            aadlbaText.addOutput("(") ;
            process(iv) ;
            aadlbaText.addOutput(")") ;
          }
        }
        return DONE ;
      }
      
      public String casePortSendAction(PortSendAction object)
      {
        String msg = "PortSendAction unparsing not supported" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg) ;
      }

      public String casePortFreezeAction(PortFreezeAction object)
      {
        String msg = "PortFreezeAction unparsing not supported" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg) ;
      }

      public String casePortDequeueAction(PortDequeueAction object)
      {
        String msg = "PortDequeueAction unparsing not supported" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg) ;
      }

      public String caseLockAction(LockAction object)
      {
        String msg = "LockAction unparsing not supported" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg) ;
      }

      public String caseUnlockAction(UnlockAction object)
      {
        String msg = "UnlockAction unparsing not supported" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg) ;
      }

      /**
       * Unparse behaviortime
       */
      public String caseBehaviorTime(BehaviorTime object)
      {
        String msg = "BehaviorTime unparsing not supported" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg) ;
      }

      public String casePortDequeueValue(PortDequeueValue object)
      {
        String msg = "PortDequeueValue unparsing not supported" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg) ;
      }

      public String casePortCountValue(PortCountValue object)
      {
        String msg = "PortCountValue unparsing not supported" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg) ;
      }

      public String casePortFreshValue(PortFreshValue object)
      {
        String msg = "PortFreshValue unparsing not supported" ;
        _LOGGER.fatal(msg);
        throw new UnsupportedOperationException(msg) ;
      }

      /**
       * Unparse booleanliteral
       */
      public String caseBehaviorBooleanLiteral(BehaviorBooleanLiteral object)
      {
        if(object.isValue())
        {
          _adaFileContent.addOutput("TRUE") ;
        }
        else
        {
          _adaFileContent.addOutput("FALSE") ;
        }

        return DONE ;
      }

      /**
       * Unparse stringliteral
       */
      public String caseBehaviorStringLiteral(BehaviorStringLiteral object)
      {
        _adaFileContent.addOutput(object.getValue()) ;
        return DONE ;
      }

      public String caseBehaviorRealLiteral(BehaviorRealLiteral object)
      {
        _adaFileContent.addOutput(String.valueOf(object.getValue())) ;
        return DONE ;
      }

      public String caseBehaviorIntegerLiteral(BehaviorIntegerLiteral object)
      {
        _adaFileContent.addOutput(Long.toString(object.getValue())) ;
        return DONE ;
      }
      
      /**
       * Unparse valueexpression
       */
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
            _adaFileContent.addOutput(" " +
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
      public String caseRelation(Relation object)
      {
        process(object.getFirstExpression()) ;

        if(object.getSecondExpression() != null)
        {
          _adaFileContent.addOutput(" " +
                AadlBaToADAUnparser.getTargetLanguageOperator(object
                      .getRelationalOperator()) + " ") ;
          process(object.getSecondExpression()) ;
        }

        return DONE ;
      }

      /**
       * Unparse simpleexpression
       */
      public String caseSimpleExpression(SimpleExpression object)
      {
        if(object.getUnaryAddingOperator()!=UnaryAddingOperator.NONE)
        {
          _adaFileContent.addOutput(object.getUnaryAddingOperator()
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
            _adaFileContent.addOutput(" " + itOp.next().getLiteral() + " ") ;
            process(itTerm.next()) ;
          }
        }

        return DONE ;
      }

      /**
       * Unparse term
       */
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
            _adaFileContent.addOutput(" " +
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
      public String caseFactor(Factor object)
      {
        if(object.getUnaryNumericOperator() != UnaryNumericOperator.NONE)
        {
          _adaFileContent.addOutput(AadlBaToADAUnparser
                                  .getTargetLanguageOperator(object
                                                             .getUnaryNumericOperator())) ;
          _adaFileContent.addOutput("(") ;
        }
        else if(object.getUnaryBooleanOperator()!= UnaryBooleanOperator.NONE)
        {
          _adaFileContent.addOutput(AadlBaToADAUnparser
                                  .getTargetLanguageOperator(object
                                                             .getUnaryBooleanOperator())) ;
          _adaFileContent.addOutput("(") ;
        }



        if(object.getFirstValue() instanceof ValueExpression)
        {
          _adaFileContent.addOutput("(") ;
          process(object.getFirstValue()) ;
          _adaFileContent.addOutput(")") ;
        }
        else
        {
          process(object.getFirstValue()) ;
        }

        if(object.getUnaryNumericOperator()!=UnaryNumericOperator.NONE ||
              object.getUnaryBooleanOperator() != UnaryBooleanOperator.NONE)
        {
          _adaFileContent.addOutput(")") ;
        }

        if(object.getBinaryNumericOperator()!=BinaryNumericOperator.NONE)
        {
          _adaFileContent.addOutput(" " +
                object.getBinaryNumericOperator().getLiteral() + " ") ;

          if(object.getSecondValue() instanceof ValueExpression)
          {
            _adaFileContent.addOutput("(") ;
            process(object.getSecondValue()) ;
            _adaFileContent.addOutput(")") ;
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
        _adaFileContent.addOutputNewline("// " + object.getBody()) ;
        return DONE ;
      }
*/
    } ;
  }

  public void addIndent_ADB(String indent)
  {
    while(_adaFileContent.getIndentString().length() < indent.length())
    {
      _adaFileContent.incrementIndent() ;
    }
  }

  public void addIndent_ADS(String indent)
  {
    while(_headerFileContent.getIndentString().length() < indent.length())
    {
      _headerFileContent.incrementIndent() ;
    }
  }

  public void setOwner(NamedElement owner) {
	this._owner = owner;
  }

  public List<NamedElement> getCoreElementsToBeUnparsed() {
	return coreElementsToBeUnparsed;
  }
}