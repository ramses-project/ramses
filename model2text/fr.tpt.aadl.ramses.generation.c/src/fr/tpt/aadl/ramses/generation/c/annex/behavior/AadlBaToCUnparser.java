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

package fr.tpt.aadl.ramses.generation.c.annex.behavior ;

import java.util.ArrayList ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.emf.common.util.AbstractEnumerator ;
import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.AccessType ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.DataAccess ;
import org.osate.aadl2.DirectionType ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.IntegerLiteral ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Parameter ;
import org.osate.aadl2.ParameterConnectionEnd ;
import org.osate.aadl2.PropertyConstant ;
import org.osate.aadl2.SubprogramImplementation ;
import org.osate.aadl2.SubprogramSubcomponentType ;
import org.osate.aadl2.SubprogramType ;
import org.osate.aadl2.modelsupport.AadlConstants ;
import org.osate.aadl2.modelsupport.UnparseText ;

import fr.tpt.aadl.annex.behavior.aadlba.AssignmentAction ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionBlock ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSequence ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActionSet ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorActions ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorAnnex ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorBooleanLiteral ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorIntegerLiteral ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorNamedElement ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorPropertyConstant ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorRealLiteral ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorState ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorStringLiteral ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTime ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorTransition ;
import fr.tpt.aadl.annex.behavior.aadlba.BehaviorVariable ;
import fr.tpt.aadl.annex.behavior.aadlba.BinaryAddingOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.BinaryNumericOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.CompletionRelativeTimeoutConditionAndCatch ;
import fr.tpt.aadl.annex.behavior.aadlba.ComponentPropertyValue ;
import fr.tpt.aadl.annex.behavior.aadlba.DataComponentReference ;
import fr.tpt.aadl.annex.behavior.aadlba.Declarator ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchCondition ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchConjunction ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerConditionStop ;
import fr.tpt.aadl.annex.behavior.aadlba.DispatchTriggerLogicalExpression ;
import fr.tpt.aadl.annex.behavior.aadlba.ElementValues ;
import fr.tpt.aadl.annex.behavior.aadlba.Factor ;
import fr.tpt.aadl.annex.behavior.aadlba.ForOrForAllStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.Identifier ;
import fr.tpt.aadl.annex.behavior.aadlba.IfStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerRange ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValue ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueConstant ;
import fr.tpt.aadl.annex.behavior.aadlba.IntegerValueVariable ;
import fr.tpt.aadl.annex.behavior.aadlba.LockAction ;
import fr.tpt.aadl.annex.behavior.aadlba.LogicalOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.MultiplyingOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.Name ;
import fr.tpt.aadl.annex.behavior.aadlba.Numeral ;
import fr.tpt.aadl.annex.behavior.aadlba.Otherwise ;
import fr.tpt.aadl.annex.behavior.aadlba.ParameterLabel ;
import fr.tpt.aadl.annex.behavior.aadlba.PortCountValue ;
import fr.tpt.aadl.annex.behavior.aadlba.PortDequeueAction ;
import fr.tpt.aadl.annex.behavior.aadlba.PortDequeueValue ;
import fr.tpt.aadl.annex.behavior.aadlba.PortFreezeAction ;
import fr.tpt.aadl.annex.behavior.aadlba.PortFreshValue ;
import fr.tpt.aadl.annex.behavior.aadlba.PortSendAction ;
import fr.tpt.aadl.annex.behavior.aadlba.Relation ;
import fr.tpt.aadl.annex.behavior.aadlba.RelationalOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression ;
import fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction ;
import fr.tpt.aadl.annex.behavior.aadlba.Term ;
import fr.tpt.aadl.annex.behavior.aadlba.TimedAction ;
import fr.tpt.aadl.annex.behavior.aadlba.TimeoutCatch ;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.UnlockAction ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression ;
import fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.util.AadlBaSwitch ;
import fr.tpt.aadl.annex.behavior.analyzers.TypeHolder ;
import fr.tpt.aadl.annex.behavior.unparser.AadlBaUnparser ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaUtils ;
import fr.tpt.aadl.annex.behavior.utils.DimensionException ;
import fr.tpt.aadl.ramses.control.support.utils.Aadl2Utils ;
import fr.tpt.aadl.ramses.generation.c.GenerationUtilsC ;
import fr.tpt.aadl.ramses.generation.target.specific.GeneratorUtils ;
import fr.tpt.aadl.ramses.instantiation.manager.PredefinedPropertiesManager ;
import fr.tpt.aadl.ramses.util.properties.PropertyUtils ;

;

public class AadlBaToCUnparser extends AadlBaUnparser
{

  protected Map<DataAccess, String> _dataAccessMapping = null ;
  protected UnparseText _cFileContent = null ;
  protected UnparseText _headerFileContent = null ;
  protected List<String> _additionalHeaders = new ArrayList<String>() ;
  
  public AadlBaToCUnparser(AnnexSubclause subclause,
                           String indent,
                           Map<DataAccess, String> dataAccessMapping)
  {
    super(subclause, indent) ;
    _dataAccessMapping = dataAccessMapping ;
  }

  public AadlBaToCUnparser()
  {
    super() ;
  }

  public void setDataAccessMapping(Map<DataAccess, String> dataAccessMapping)
  {
    _dataAccessMapping = dataAccessMapping ;
  }
  
  public String getCContent()
  {
    return _cFileContent.getParseOutput() ;
  }

  public String getHContent()
  {
    return _headerFileContent.getParseOutput() ;
  }

  public List<String> getAdditionalHeaders()
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

      if(o instanceof Element)
      {
        process((Element) o) ;
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
      }
    }
  }

  public void processEList(UnparseText aadlText,
                           final EList<? extends Element> list)
  {
    for(Iterator<? extends Element> it = list.iterator() ; it.hasNext() ;)
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
        if(s.endsWith(".h"))
        {
          _additionalHeaders.add(s) ;
          return true;
        }
      }
      throw new Exception("In component "+ne.getName()+": Source_Text " +
      		"property should also reference a header (.h extension) file");
    }
    catch(Exception e)
    {
      return false ;
    }
  }

  protected static String getInitialStateIdentifier(BehaviorAnnex ba)
  {
    for(BehaviorState s : ba.getBehaviorStates())
    {
      if(s.isInitial())
      {
        return s.getIdentifierOwned().getId() ;
      }
    }

    return null ;
  }

  protected static String getTargetLanguageOperator(LogicalOperator operator)
  {
    if(operator.equals(LogicalOperator.AND))
    {
      return "&&" ;
    }

    if(operator.equals(LogicalOperator.OR))
    {
      return "||" ;
    }

    if(operator.equals(LogicalOperator.XOR))
    {
      return "^" ;
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
      return "%" ;
    }

    // TODO: find mapping for REM operator
    if(operator.equals(MultiplyingOperator.REM))
    {
      return "" ;
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
      return "!" ;
    }

    return operator.getLiteral() ;
  }

  protected static String getTargetLanguageOperator(RelationalOperator operator)
  {
    if(operator.equals(RelationalOperator.EQUAL))
    {
      return "==" ;
    }

    if(operator.equals(RelationalOperator.NOT_EQUAL))
    {
      return "!=" ;
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
        //FIXME : TODO : update location reference
        process((BehaviorAnnex) object) ;
        return DONE ;
      }

      /**
       * Unparse behaviorannex
       */
      public String caseBehaviorAnnex(BehaviorAnnex object)
      {
        _cFileContent = new UnparseText() ;
        _headerFileContent = new UnparseText() ;
        
        BehaviorAnnex ba = (BehaviorAnnex) object ;
        NamedElement aadlComponent = (NamedElement) ba.eContainer() ;
        String aadlComponentCId =
              GenerationUtilsC.getGenerationCIdentifier(aadlComponent
                    .getQualifiedName()) ;
        _cFileContent.addOutputNewline(aadlComponentCId +
              "_BA_State_t current_state = " + aadlComponentCId + "_" +
              AadlBaToCUnparser.getInitialStateIdentifier(ba) + ";") ;
        _cFileContent.addOutputNewline("char final = 0;") ;
        processEList(_cFileContent, ba.getBehaviorVariables()) ;
        _cFileContent.addOutputNewline("while(final != 1)") ;
        _cFileContent.addOutputNewline("{") ;
        _cFileContent.incrementIndent() ;
        _cFileContent.addOutputNewline("switch(current_state)") ;
        _cFileContent.addOutputNewline("{") ;
        _cFileContent.incrementIndent() ;
        _headerFileContent.addOutputNewline("typedef enum {") ;
        _headerFileContent.incrementIndent() ;

        for(BehaviorState state : ba.getBehaviorStates())
        {
          if(state.getSourceInTrans().isEmpty() == false)
          {
            _cFileContent.addOutputNewline("case " + aadlComponentCId + "_" +
                  state.getIdentifierOwned().getId() + ":") ;
            processEList(_cFileContent, state.getSourceInTrans()) ;
          }

          aadlbaText = _headerFileContent ;
          caseIdentifier(state.getIdentifierOwned()) ;

          if(ba.getBehaviorStates().indexOf(state) < ba.getBehaviorStates()
                .size() - 1)
          {
            _headerFileContent.addOutput(",") ;
          }

          _headerFileContent.addOutputNewline("") ;
        }

        _headerFileContent.decrementIndent() ;
        _headerFileContent.addOutputNewline("} " + aadlComponentCId +
              "_BA_State_t;") ;
        _headerFileContent.addOutputNewline("") ;
        _cFileContent.decrementIndent() ;
        _cFileContent.addOutputNewline("}") ;
        _cFileContent.decrementIndent() ;
        _cFileContent.addOutputNewline("}") ;
        _cFileContent.addOutputNewline("") ;
        return DONE ;
      }

      /**
       * Unparse behaviorvariable
       */
      public String caseBehaviorVariable(BehaviorVariable object)
      {
        //FIXME : TODO : update location reference
        for(Declarator d : object.getLocalVariableDeclarators())
        {
          process(object.getDataUniqueComponentClassifierReference()) ;
          process(d) ;
          GeneratorUtils.getInitialValue(object
                .getDataUniqueComponentClassifierReference()) ;
          _cFileContent.addOutputNewline("") ;
        }

        return DONE ;
      }

      /**
       * Unparse declarators
       */
      public String caseDeclarator(Declarator object)
      {
        //FIXME : TODO : update location reference
        _cFileContent.addOutput(" " + object.getIdentifierOwned().getId()) ;
        caseArraySize(object.getArraySizes()) ;
        _cFileContent.addOutput(";") ;
        return DONE ;
      }

      /**
       * Unparse arraysize
       */
      public String caseArraySize(EList<IntegerValueConstant> arraySizes)
      {
        //FIXME : TODO : update location reference
        for(IntegerValueConstant ivc : arraySizes)
        {
          _cFileContent.addOutput("[") ;

          if(ivc instanceof BehaviorPropertyConstant)
          {
            PropertyConstant pc =
                  (PropertyConstant) ((BehaviorPropertyConstant) ivc)
                        .getAadlRef() ;
            _cFileContent.addOutput(Long.toString(((IntegerLiteral) pc
                  .getConstantValue()).getValue())) ;
          }
          else
          {
            process(ivc) ;
          }

          _cFileContent.addOutput("]") ;
        }

        return DONE ;
      }

      public String caseBehaviorNamedElement(BehaviorNamedElement object)
      {
        if(object.getAadlRef() != null &&
              object.getAadlRef() instanceof NamedElement)
        {
          if(resolveExistingCodeDependencies((NamedElement) object.getAadlRef()))
          {
            return DONE ;
          }
        }

        caseIdentifier(object.getQualifiedName()) ;
        return DONE ;
      }

      public String caseComponentPropertyValue(ComponentPropertyValue object)
      {
        // ComponentPropertyValue is defined to refer Enumerated data
        caseIdentifier(object.getElementListIdentifier()) ;
        return DONE ;
      }

      /**
       * Unparse behaviorstate
       * @object: input parameter, destination of a Behavior Transition
       */
      public String caseBehaviorState(BehaviorState object)
      {
        NamedElement aadlComponent =
              (NamedElement) object.eContainer().eContainer() ;
        String aadlComponentCId =
              GenerationUtilsC.getGenerationCIdentifier(aadlComponent
                    .getQualifiedName()) ;
        _cFileContent.addOutputNewline("current_state = " + aadlComponentCId +
              "_" + object.getIdentifierOwned().getId() + ";") ;
        //if (object.isComplete())

        if(object.isFinal())
        {
          _cFileContent.addOutputNewline("final = 1;") ;
        }

        _cFileContent.addOutputNewline("break;") ;
        return DONE ;
      }

      /**
       * Unparse identifier
       */
      public String caseIdentifier(Identifier object)
      {
        //FIXME : TODO : update location reference
        if(object.getAadlRef() != null &&
              object.getAadlRef() instanceof NamedElement)
        {
          NamedElement ne = (NamedElement) object.getAadlRef() ;
          aadlbaText.addOutput(GenerationUtilsC.getGenerationCIdentifier(ne
                .getQualifiedName())) ;
        }
        else if(object.getBaRef() != null &&
              object.getBaRef() instanceof NamedElement)
        {
          NamedElement ne = (NamedElement) object.getBaRef() ;
          aadlbaText.addOutput(GenerationUtilsC.getGenerationCIdentifier(ne
                .getQualifiedName())) ;
        }
        else
        {
          Element e = (Element) object ;

          while(e != null && e instanceof Classifier == false)
          {
            e = (Element) e.eContainer() ;
          }

          if(e != null)
          {
            Classifier ne = (Classifier) e ;
            String r =
                  GenerationUtilsC.getGenerationCIdentifier(ne
                        .getQualifiedName() +
                        "_" + object.getId()) ;
            aadlbaText.addOutput(r) ;
            return DONE ;
          }

          aadlbaText.addOutput(GenerationUtilsC.getGenerationCIdentifier(object
                .getId())) ;
          return DONE ;
        }

        return DONE ;
      }

      /**
       * Unparse behaviortransition
       */
      public String caseBehaviorTransition(BehaviorTransition object)
      {
        //FIXME : TODO : update location reference
        aadlbaText = _cFileContent ;
        Identifier tid = object.getTransitionIdentifier() ;
        Numeral num = object.getBehaviorTransitionPriority() ;

        if(tid != null)
        {
          _cFileContent.addOutput("// Transition id: ") ;
          process(tid) ;

          if(num != null) // numeral
          {
            _cFileContent.addOutput(" -- Priority " +
                  String.valueOf(num.getValue())) ;
          }

          _cFileContent.addOutputNewline("") ;
        }

        if(object.getBehaviorConditionOwned() != null)
        {
          if(object.getBehaviorConditionOwned() instanceof Otherwise)
          {
            _cFileContent.addOutput("else") ;
            process(object.getBehaviorConditionOwned()) ;
          }
          else
          {
            _cFileContent.addOutput("if(") ;
            process(object.getBehaviorConditionOwned()) ;
            _cFileContent.addOutputNewline(")") ;
          }
        }
        else
        {
          _cFileContent.addOutputNewline("if(1) // no execution condition") ;
        }

        _cFileContent.addOutputNewline("{") ;
        _cFileContent.incrementIndent() ;

        if(object.getBehaviorActionBlockOwned() != null)
        {
          process(object.getBehaviorActionBlockOwned()) ;
        }

        process((BehaviorState) object.getDestinationStateIdentifier()
              .getBaRef()) ;
        _cFileContent.decrementIndent() ;
        _cFileContent.addOutputNewline("}") ;
        return DONE ;
      }

      public String caseTimeoutCatch(TimeoutCatch object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      public String caseOtherwise(Otherwise object)
      {
        _cFileContent.addOutputNewline(" //otherwise") ;
        return DONE ;
      }

      /**
       * Unparse dispatchcondition
       */
      public String caseDispatchCondition(DispatchCondition object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      public String caseDispatchTriggerConditionStop(DispatchTriggerConditionStop object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      public String caseCompletionRelativeTimeoutConditionAndCatch(CompletionRelativeTimeoutConditionAndCatch object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      public String caseDispatchTriggerLogicalExpression(DispatchTriggerLogicalExpression object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      public String caseDispatchConjunction(DispatchConjunction object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      public String caseBehaviorActionBlock(BehaviorActionBlock object)
      {
        process(object.getBehaviorActionsOwned()) ;

        if(object.getBehaviorTimeOwned() != null)
        {
          // TODO: throw Exception
        }

        return DONE ;
      }

      public String caseBehaviorActionSequence(BehaviorActionSequence object)
      {
        processEList(_cFileContent, object.getBehaviorActions()) ;
        return DONE ;
      }

      public String caseBehaviorActionSet(BehaviorActionSet object)
      {
        // TODO: throw Exception
        return DONE ;
      }

      /**
       * Unparse ifstatement
       */
      public String caseIfStatement(IfStatement object)
      {
        //FIXME : TODO : update location reference
        boolean first = true ;
        EList<ValueExpression> lve = object.getLogicalValueExpressions() ;
        EList<BehaviorActions> lba = object.getBehaviorActionsOwned() ;

        for(ValueExpression ve : lve)
        {
          if(first)
          {
            first = false ;
            _cFileContent.addOutput("if (") ;
          }
          else
          {
            _cFileContent.addOutput("elsif (") ;
          }

          process(ve) ;
          _cFileContent.addOutput(") ") ;
          _cFileContent.addOutputNewline("{") ;
          process(lba.get(lve.indexOf(ve))) ;
          _cFileContent.addOutputNewline("}") ;
        }

        if(object.isHasElse())
        {
          _cFileContent.addOutput("else ") ;
          _cFileContent.addOutputNewline("{") ;
          process(lba.get(lba.size() - 1)) ;
          _cFileContent.addOutputNewline("}") ;
        }

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
            return ((BehaviorVariable) integerValue)
                  .getDataUniqueComponentClassifierReference().getName()
                  .getId() ;
          }

          if(integerValue instanceof DataComponentReference)
          {
            return ((BehaviorVariable) integerValue)
                  .getDataUniqueComponentClassifierReference().getName()
                  .getId() ;
          }
        }

        return "" ;
      }

      /**
       * Unparse fororforallstatement
       */
      public String caseForOrForAllStatement(ForOrForAllStatement object)
      {
        //FIXME : TODO : update location reference
        ElementValues set = object.getElementValuesOwned() ;

        if(set instanceof IntegerRange)
        {
          IntegerRange range = (IntegerRange) set ;
          String lowerRangeValue = this.toInteger(range.getLowerIntegerValue()) ;
          String upperRangeValue = this.toInteger(range.getUpperIntegerValue()) ;
          _cFileContent.addOutputNewline("int iter=0;") ;
          _cFileContent.addOutputNewline("for (iter=" + lowerRangeValue +
                ";iter<=" + upperRangeValue + ";iter++)") ;
          _cFileContent.addOutputNewline("{") ;
          _cFileContent.incrementIndent() ;
          process(object.getDataUniqueComponentClassifierReference()) ;
          _cFileContent.addOutput(" ") ;
          process(object.getElementIdentifier()) ;
          _cFileContent.addOutputNewline(" = iter;") ;
          process(object.getBehaviorActionsOwned()) ;
          _cFileContent.decrementIndent() ;
          _cFileContent.addOutputNewline("}") ;
        }

        if(set instanceof DataComponentReference)
        {
          TypeHolder dataReferenceTypeHolder = null ;

          try
          {
            dataReferenceTypeHolder =
                  AadlBaUtils.getTypeHolder(object.getElementValuesOwned()) ;
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
            _cFileContent.addOutputNewline("int " + iteratorID + "=0;") ;
            _cFileContent.addOutputNewline("for (" + iteratorID + "=0;" +
                  iteratorID + "<" +
                  Long.toString(dataReferenceTypeHolder.dimension_sizes[i]) +
                  ";" + iteratorID + "++)") ;
            _cFileContent.addOutputNewline("{") ;
            _cFileContent.incrementIndent() ;
          }

          process(object.getDataUniqueComponentClassifierReference()) ;
          _cFileContent.addOutput(" ") ;
          process(object.getElementIdentifier()) ;
          _cFileContent.addOutput(" = ") ;
          process(object.getElementValuesOwned()) ;

          for(int i = 0 ; i < numberOfLoop ; i++)
          {
            String iteratorID = "iter" + Integer.toString(i) ;
            _cFileContent.addOutput("[") ;
            _cFileContent.addOutput(iteratorID) ;
            _cFileContent.addOutput("]") ;
          }

          _cFileContent.addOutputNewline(";") ;
          process(object.getBehaviorActionsOwned()) ;

          for(int i = 0 ; i < numberOfLoop ; i++)
          {
            _cFileContent.decrementIndent() ;
            _cFileContent.addOutputNewline("}") ;
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
        //FIXME : TODO : update location reference
        _cFileContent.addOutput("while (") ;
        process(object.getLogicalValueExpression()) ;
        _cFileContent.addOutputNewline(")") ;
        _cFileContent.addOutputNewline("{") ;
        _cFileContent.incrementIndent() ;
        process(object.getBehaviorActionsOwned()) ;
        _cFileContent.decrementIndent() ;
        _cFileContent.addOutputNewline("}") ;
        return DONE ;
      }

      /**
       * Unparse dountilstatement
       */
      public String caseDoUntilStatement(WhileOrDoUntilStatement object)
      {
        //FIXME : TODO : update location reference
        _cFileContent.addOutputNewline("do") ;
        _cFileContent.addOutputNewline("{") ;
        _cFileContent.incrementIndent() ;
        process(object.getBehaviorActionsOwned()) ;
        _cFileContent.decrementIndent() ;
        _cFileContent.addOutputNewline("}") ;
        _cFileContent.addOutput("while (") ;
        process(object.getLogicalValueExpression()) ;
        _cFileContent.addOutputNewline(")") ;
        return DONE ;
      }

      /**
       * Unparse integerrange
       */
      public String caseIntegerRange(IntegerRange object)
      {
        // TODO: throw new Exception
        return "" ;
      }

      /**
       * Unparse timedaction
       */
      public String caseTimedAction(TimedAction object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      /**
       * Unparse assignmentaction
       */
      public String caseAssignmentAction(AssignmentAction object)
      {
        //FIXME : TODO : update location reference
        process(object.getTargetOwned()) ;
        _cFileContent.addOutput(" = ") ;

        if(object.isAny())
        // TODO: throw new Exception
        {
          _cFileContent.addOutput("") ;
        }
        else
        {
          process(object.getValueExpressionOwned()) ;
        }

        _cFileContent.addOutputNewline(";") ;
        return DONE ;
      }

      /**
       * Unparse name
       */
      public String caseName(Name object)
      {
        //FIXME : TODO : update location reference
        process(object.getIdentifierOwned()) ;

        if(object.isSetArrayIndexes())
        {
          return caseArrayIndex(object.getArrayIndexes()) ;
        }
        else
        {
          return DONE ;
        }
      }

      /**
       * Unparse arrayindex
       */
      public String caseArrayIndex(EList<IntegerValue> object)
      {
        //FIXME : TODO : update location reference
        for(IntegerValue iv : object)
        {
          _cFileContent.addOutput("[") ;
          process(iv) ;
          _cFileContent.addOutput("]") ;
        }

        return DONE ;
      }

      /**
       * Unparse datacomponentreference
       */
      public String caseDataComponentReference(DataComponentReference object)
      {
        if(object.getAadlRef() != null &&
              object.getAadlRef() instanceof NamedElement)
        {
          if(resolveExistingCodeDependencies((NamedElement) object.getAadlRef()))
          {
            return DONE ;
          }
        }

        Element elt =
              object.getNames().get(0).getIdentifierOwned().getAadlRef() ;

        if(elt != null && elt instanceof NamedElement)
        {
          if(resolveExistingCodeDependencies((NamedElement) elt))
          {
            return DONE ;
          }
        }

        processEList(aadlbaText, object.getNames()) ;
        return DONE ;
      }

      public String caseSubprogramCallAction(SubprogramCallAction object)
      {
        if(object.getSubprogramReference() != null)
        {
          process(object.getSubprogramReference()) ;
        }
        else if(object.isSetSubprogramNames())
        {
          processEList(_cFileContent, object.getSubprogramNames(), "_") ;
        }
        else
        {
          return DONE ;
        }

        if(object.getSubprogramReference() != null)
        {
          SubprogramType st = null ;
          SubprogramSubcomponentType sct =
                (SubprogramSubcomponentType) object.getSubprogramReference()
                      .getAadlRef() ;

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

          if(st != null)
          {
            _cFileContent.addOutput(" (") ;

            for(ParameterLabel pl : object.getParameterLabels())
            {
              ParameterConnectionEnd pce =
                    (ParameterConnectionEnd) ordereFeatureList.get(object
                          .getParameterLabels().indexOf(pl)) ;

                if(pce instanceof Parameter)
                {
                  Parameter p = (Parameter) pce ;

                  if(p.getDirection().equals(DirectionType.OUT) ||
                        p.getDirection().equals(DirectionType.IN_OUT))
                  {
                    _cFileContent.addOutput("&") ;
                  }
                  
                  process(pl) ;
                }
                else if(pce instanceof DataAccess)
                {
                  DataAccess da = (DataAccess) pce ;

                  if(da.getKind().equals(AccessType.REQUIRED))
                  {
                    String accessRight = null ;

                    try
                    {
                      accessRight =
                            PropertyUtils.getEnumValue(da, "Access_Right") ;
                    }
                    catch(Exception e)
                    {
                      accessRight =
                            PredefinedPropertiesManager
                                  .getDefaultStringValue("Memory_Properties",
                                                         "Access_Right") ;
                    }

                    if(accessRight.equalsIgnoreCase("Read_Write"))
                    {
                      _cFileContent.addOutput("&") ;
                    }
                  }
                  
                  String name = null ;
                  
                  // If a data access mapping is provided:
                  // Transforms any data access into the right data subcomponent
                  // 's name thanks to the given data access mapping.
                  if(_dataAccessMapping != null)
                  {
                    name = _dataAccessMapping.get(pl.getAadlRef());
                  }
                  
                  if (name != null)
                  {
                    _cFileContent.addOutput(name);
                  }
                  else // Otherwise, process parameter label as usual.
                  {
                    process(pl) ;
                  }
                }

                if(object.getParameterLabels().indexOf(pl) != object
                      .getParameterLabels().size() - 1)
                {
                  _cFileContent.addOutput(", ") ;
                }
              }

              _cFileContent.addOutputNewline(");") ;
          }
        }
        else
        {
          if(object.isSetParameterLabels())
          {
            _cFileContent.addOutput(" (") ;
            processEList(_cFileContent, object.getParameterLabels(), ", ") ;
            _cFileContent.addOutputNewline(");") ;
          }
        }

        return DONE ;
      }

      public String casePortSendAction(PortSendAction object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      public String casePortFreezeAction(PortFreezeAction object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      public String casePortDequeueAction(PortDequeueAction object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      public String caseLockAction(LockAction object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      public String caseUnlockAction(UnlockAction object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      /**
       * Unparse behaviortime
       */
      public String caseBehaviorTime(BehaviorTime object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      public String casePortDequeueValue(PortDequeueValue object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      public String casePortCountValue(PortCountValue object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      public String casePortFreshValue(PortFreshValue object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      /**
       * Unparse booleanliteral
       */
      public String caseBehaviorBooleanLiteral(BehaviorBooleanLiteral object)
      {
        //FIXME : TODO : update location reference
        if(object.isValue())
        {
          _cFileContent.addOutput("'1'") ;
        }
        else
        {
          _cFileContent.addOutput("'0'") ;
        }

        return DONE ;
      }

      /**
       * Unparse stringliteral
       */
      public String caseBehaviorStringLiteral(BehaviorStringLiteral object)
      {
        //FIXME : TODO : update location reference
        _cFileContent.addOutput(object.getValue()) ;
        return DONE ;
      }

      public String caseBehaviorRealLiteral(BehaviorRealLiteral object)
      {
        _cFileContent.addOutput(String.valueOf(object.getValue())) ;
        return DONE ;
      }

      public String caseBehaviorIntegerLiteral(BehaviorIntegerLiteral object)
      {
        _cFileContent.addOutput(Long.toString(object.getValue())) ;
        return DONE ;
      }

      /**
       * Unparse valueexpression
       */
      public String caseValueExpression(ValueExpression object)
      {
        //FIXME : TODO : update location reference
        Iterator<Relation> itRel = object.getRelations().iterator() ;
        process(itRel.next()) ;

        if(object.isSetLogicalOperators())
        {
          Iterator<LogicalOperator> itOp =
                object.getLogicalOperators().iterator() ;

          while(itRel.hasNext())
          {
            _cFileContent.addOutput(" " +
                  AadlBaToCUnparser.getTargetLanguageOperator(itOp.next()) +
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
        //FIXME : TODO : update location reference
        process(object.getSimpleExpressionOwned()) ;

        if(object.getSimpleExpressionSdOwned() != null)
        {
          _cFileContent.addOutput(" " +
                AadlBaToCUnparser.getTargetLanguageOperator(object
                      .getRelationalOperatorOwned()) + " ") ;
          process(object.getSimpleExpressionSdOwned()) ;
        }

        return DONE ;
      }

      /**
       * Unparse simpleexpression
       */
      public String caseSimpleExpression(SimpleExpression object)
      {
        //FIXME : TODO : update location reference
        if(object.isSetUnaryAddingOperatorOwned())
        {
          _cFileContent.addOutput(object.getUnaryAddingOperatorOwned()
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
            _cFileContent.addOutput(" " + itOp.next().getLiteral() + " ") ;
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
        //FIXME : TODO : update location reference
        Iterator<Factor> itFact = object.getFactors().iterator() ;
        process(itFact.next()) ;

        if(object.isSetMultiplyingOperators())
        {
          Iterator<MultiplyingOperator> itOp =
                object.getMultiplyingOperators().iterator() ;

          while(itFact.hasNext())
          {
            _cFileContent.addOutput(" " +
                  AadlBaToCUnparser.getTargetLanguageOperator(itOp.next()) +
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
        //FIXME : TODO : update location reference
        if(object.isSetUnaryNumericOperatorOwned() ||
              object.isSetUnaryBooleanOperatorOwned())
        {
          if(object.isSetUnaryNumericOperatorOwned())
          {
            _cFileContent.addOutput(AadlBaToCUnparser
                  .getTargetLanguageOperator(object
                        .getUnaryNumericOperatorOwned())) ;
          }
          else if(object.isSetUnaryBooleanOperatorOwned())
          {
            _cFileContent.addOutput(AadlBaToCUnparser
                  .getTargetLanguageOperator(object
                        .getUnaryBooleanOperatorOwned())) ;
          }

          _cFileContent.addOutput("(") ;
        }

        if(object.getValueOwned() instanceof ValueExpression)
        {
          _cFileContent.addOutput("(") ;
          process(object.getValueOwned()) ;
          _cFileContent.addOutput(")") ;
        }
        else
        {
          process(object.getValueOwned()) ;
        }

        if(object.isSetUnaryNumericOperatorOwned() ||
              object.isSetUnaryBooleanOperatorOwned())
        {
          _cFileContent.addOutput(")") ;
        }

        if(object.isSetBinaryNumericOperatorOwned())
        {
          _cFileContent.addOutput(" " +
                object.getBinaryNumericOperatorOwned().getLiteral() + " ") ;

          if(object.getValueSdOwned() instanceof ValueExpression)
          {
            _cFileContent.addOutput("(") ;
            process(object.getValueSdOwned()) ;
            _cFileContent.addOutput(")") ;
          }
          else
          {
            process(object.getValueSdOwned()) ;
          }
        }

        return DONE ;
      }
/*
      public String caseComment(Comment object)
      {
        _cFileContent.addOutputNewline("// " + object.getBody()) ;
        return DONE ;
      }
*/
    } ;
  }

  public void addIndent_C(String indent)
  {
    while(_cFileContent.getIndentString().length() < indent.length())
    {
      _cFileContent.incrementIndent() ;
    }
  }

  public void addIndent_H(String indent)
  {
    while(_headerFileContent.getIndentString().length() < indent.length())
    {
      _headerFileContent.incrementIndent() ;
    }
  }
}