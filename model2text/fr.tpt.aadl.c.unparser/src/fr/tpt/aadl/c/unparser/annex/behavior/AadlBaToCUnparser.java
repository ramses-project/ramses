/**
 * Author: Etienne Borde
 */

package fr.tpt.aadl.c.unparser.annex.behavior ;

import java.util.ArrayList ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.emf.common.util.AbstractEnumerator ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EClass ;
import org.eclipse.ui.internal.handlers.WizardHandler.New ;
import org.osate.aadl2.AccessType ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.Comment ;
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

import fr.tpt.aadl.annex.behavior.aadlba.AadlBaPackage ;
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
import fr.tpt.aadl.annex.behavior.aadlba.SharedDataAction ;
import fr.tpt.aadl.annex.behavior.aadlba.SimpleExpression ;
import fr.tpt.aadl.annex.behavior.aadlba.SubprogramCallAction ;
import fr.tpt.aadl.annex.behavior.aadlba.Term ;
import fr.tpt.aadl.annex.behavior.aadlba.TimedAction ;
import fr.tpt.aadl.annex.behavior.aadlba.TimeoutCatch ;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryBooleanOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.UnaryNumericOperator ;
import fr.tpt.aadl.annex.behavior.aadlba.UnlockAction ;
import fr.tpt.aadl.annex.behavior.aadlba.Value ;
import fr.tpt.aadl.annex.behavior.aadlba.ValueExpression ;
import fr.tpt.aadl.annex.behavior.aadlba.WhileOrDoUntilStatement ;
import fr.tpt.aadl.annex.behavior.aadlba.util.AadlBaSwitch ;
import fr.tpt.aadl.annex.behavior.analyzers.TypeHolder ;
import fr.tpt.aadl.annex.behavior.unparser.AadlBaUnparser ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaUtils ;
import fr.tpt.aadl.annex.behavior.utils.AadlBaVisitors ;
import fr.tpt.aadl.annex.behavior.utils.DimensionException ;
import fr.tpt.aadl.c.unparser.AadlToCSwitchProcess ;
import fr.tpt.aadl.c.unparser.GenerationUtils ;
import fr.tpt.aadl.resources.manager.PredefinedPropertiesManager ;
import fr.tpt.aadl.util.properties.PropertyUtils ;

;

public class AadlBaToCUnparser extends AadlBaUnparser
{

  private Map<DataAccess, String> _blackboardNames ;
  
  public AadlBaToCUnparser(AnnexSubclause subclause,
                           String indent,
                           Map<DataAccess, String> blackboardNames)
  {
    super(subclause, indent) ;
    _blackboardNames = blackboardNames ;
    cFileContent = new UnparseText() ;
    headerFileContent = new UnparseText() ;
  }

  public AadlBaToCUnparser()
  {
    super() ;
    cFileContent = new UnparseText() ;
    headerFileContent = new UnparseText() ;
  }

  public void setBlackboardNames(Map<DataAccess, String> blackboardNames)
  {
    _blackboardNames = blackboardNames ;
  }
  
  public String getCContent()
  {
    return cFileContent.getParseOutput() ;
  }

  public String getHContent()
  {
    return headerFileContent.getParseOutput() ;
  }

  protected UnparseText cFileContent ;
  protected UnparseText headerFileContent ;

  List<String> additionalHeaders = new ArrayList<String>() ;

  public List<String> getAdditionalHeaders()
  {
    return additionalHeaders ;
  }

  public void processEList(UnparseText aadlText,
                           EList list,
                           String separator)
  {
    boolean first = true ;

    for(Iterator it = list.iterator() ; it.hasNext() ;)
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
          additionalHeaders.add(s) ;
          return true ;
        }
      }

      return false ;
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
        BehaviorAnnex ba = (BehaviorAnnex) object ;
        NamedElement aadlComponent = (NamedElement) ba.eContainer() ;
        String aadlComponentCId =
              GenerationUtils.getGenerationCIdentifier(aadlComponent
                    .getQualifiedName()) ;
        cFileContent.addOutputNewline(aadlComponentCId +
              "_BA_State_t current_state = " + aadlComponentCId + "_" +
              AadlBaToCUnparser.getInitialStateIdentifier(ba) + ";") ;
        cFileContent.addOutputNewline("char final = 0;") ;
        processEList(cFileContent, ba.getBehaviorVariables()) ;
        cFileContent.addOutputNewline("while(final != 1)") ;
        cFileContent.addOutputNewline("{") ;
        cFileContent.incrementIndent() ;
        cFileContent.addOutputNewline("switch(current_state)") ;
        cFileContent.addOutputNewline("{") ;
        cFileContent.incrementIndent() ;
        headerFileContent.addOutputNewline("typedef enum {") ;
        headerFileContent.incrementIndent() ;

        for(BehaviorState state : ba.getBehaviorStates())
        {
          if(state.getSourceInTrans().isEmpty() == false)
          {
            cFileContent.addOutputNewline("case " + aadlComponentCId + "_" +
                  state.getIdentifierOwned().getId() + ":") ;
            processEList(cFileContent, state.getSourceInTrans()) ;
          }

          aadlbaText = headerFileContent ;
          caseIdentifier(state.getIdentifierOwned()) ;

          if(ba.getBehaviorStates().indexOf(state) < ba.getBehaviorStates()
                .size() - 1)
          {
            headerFileContent.addOutput(",") ;
          }

          headerFileContent.addOutputNewline("") ;
        }

        headerFileContent.decrementIndent() ;
        headerFileContent.addOutputNewline("} " + aadlComponentCId +
              "_BA_State_t;") ;
        headerFileContent.addOutputNewline("") ;
        cFileContent.decrementIndent() ;
        cFileContent.addOutputNewline("}") ;
        cFileContent.decrementIndent() ;
        cFileContent.addOutputNewline("}") ;
        cFileContent.addOutputNewline("") ;
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
          GenerationUtils.getInitialValue(object
                .getDataUniqueComponentClassifierReference()) ;
          cFileContent.addOutputNewline("") ;
        }

        return DONE ;
      }

      /**
       * Unparse declarators
       */
      public String caseDeclarator(Declarator object)
      {
        //FIXME : TODO : update location reference
        cFileContent.addOutput(" " + object.getIdentifierOwned().getId()) ;
        caseArraySize(object.getArraySizes()) ;
        cFileContent.addOutput(";") ;
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
          cFileContent.addOutput("[") ;

          if(ivc instanceof BehaviorPropertyConstant)
          {
            PropertyConstant pc =
                  (PropertyConstant) ((BehaviorPropertyConstant) ivc)
                        .getAadlRef() ;
            cFileContent.addOutput(Long.toString(((IntegerLiteral) pc
                  .getConstantValue()).getValue())) ;
          }
          else
          {
            process(ivc) ;
          }

          cFileContent.addOutput("]") ;
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
              GenerationUtils.getGenerationCIdentifier(aadlComponent
                    .getQualifiedName()) ;
        cFileContent.addOutputNewline("current_state = " + aadlComponentCId +
              "_" + object.getIdentifierOwned().getId() + ";") ;
        //if (object.isComplete())

        if(object.isFinal())
        {
          cFileContent.addOutputNewline("final = 1;") ;
        }

        cFileContent.addOutputNewline("break;") ;
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
          aadlbaText.addOutput(GenerationUtils.getGenerationCIdentifier(ne
                .getQualifiedName())) ;
        }
        else if(object.getBaRef() != null &&
              object.getBaRef() instanceof NamedElement)
        {
          NamedElement ne = (NamedElement) object.getBaRef() ;
          aadlbaText.addOutput(GenerationUtils.getGenerationCIdentifier(ne
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
                  GenerationUtils.getGenerationCIdentifier(ne
                        .getQualifiedName() +
                        "_" + object.getId()) ;
            aadlbaText.addOutput(r) ;
            return DONE ;
          }

          aadlbaText.addOutput(GenerationUtils.getGenerationCIdentifier(object
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
        aadlbaText = cFileContent ;
        Identifier tid = object.getTransitionIdentifier() ;
        Numeral num = object.getBehaviorTransitionPriority() ;

        if(tid != null)
        {
          cFileContent.addOutput("// Transition id: ") ;
          process(tid) ;

          if(num != null) // numeral
          {
            cFileContent.addOutput(" -- Priority " +
                  String.valueOf(num.getValue())) ;
          }

          cFileContent.addOutputNewline("") ;
        }

        if(object.getBehaviorConditionOwned() != null)
        {
          if(object.getBehaviorConditionOwned() instanceof Otherwise)
          {
            cFileContent.addOutput("else") ;
            process(object.getBehaviorConditionOwned()) ;
          }
          else
          {
            cFileContent.addOutput("if(") ;
            process(object.getBehaviorConditionOwned()) ;
            cFileContent.addOutputNewline(")") ;
          }
        }
        else
        {
          cFileContent.addOutputNewline("if(1) // no execution condition") ;
        }

        cFileContent.addOutputNewline("{") ;
        cFileContent.incrementIndent() ;

        if(object.getBehaviorActionBlockOwned() != null)
        {
          process(object.getBehaviorActionBlockOwned()) ;
        }

        process((BehaviorState) object.getDestinationStateIdentifier()
              .getBaRef()) ;
        cFileContent.decrementIndent() ;
        cFileContent.addOutputNewline("}") ;
        return DONE ;
      }

      public String caseTimeoutCatch(TimeoutCatch object)
      {
        // TODO: throw new Exception
        return DONE ;
      }

      public String caseOtherwise(Otherwise object)
      {
        cFileContent.addOutputNewline(" //otherwise") ;
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
        processEList(cFileContent, object.getBehaviorActions()) ;
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
            cFileContent.addOutput("if (") ;
          }
          else
          {
            cFileContent.addOutput("elsif (") ;
          }

          process(ve) ;
          cFileContent.addOutput(") ") ;
          cFileContent.addOutputNewline("{") ;
          process(lba.get(lve.indexOf(ve))) ;
          cFileContent.addOutputNewline("}") ;
        }

        if(object.isHasElse())
        {
          cFileContent.addOutput("else ") ;
          cFileContent.addOutputNewline("{") ;
          process(lba.get(lba.size() - 1)) ;
          cFileContent.addOutputNewline("}") ;
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
          cFileContent.addOutputNewline("int iter=0;") ;
          cFileContent.addOutputNewline("for (iter=" + lowerRangeValue +
                ";iter<=" + upperRangeValue + ";iter++)") ;
          cFileContent.addOutputNewline("{") ;
          cFileContent.incrementIndent() ;
          process(object.getDataUniqueComponentClassifierReference()) ;
          cFileContent.addOutput(" ") ;
          process(object.getElementIdentifier()) ;
          cFileContent.addOutputNewline(" = iter;") ;
          process(object.getBehaviorActionsOwned()) ;
          cFileContent.decrementIndent() ;
          cFileContent.addOutputNewline("}") ;
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
            cFileContent.addOutputNewline("int " + iteratorID + "=0;") ;
            cFileContent.addOutputNewline("for (" + iteratorID + "=0;" +
                  iteratorID + "<" +
                  Long.toString(dataReferenceTypeHolder.dimension_sizes[i]) +
                  ";" + iteratorID + "++)") ;
            cFileContent.addOutputNewline("{") ;
            cFileContent.incrementIndent() ;
          }

          process(object.getDataUniqueComponentClassifierReference()) ;
          cFileContent.addOutput(" ") ;
          process(object.getElementIdentifier()) ;
          cFileContent.addOutput(" = ") ;
          process(object.getElementValuesOwned()) ;

          for(int i = 0 ; i < numberOfLoop ; i++)
          {
            String iteratorID = "iter" + Integer.toString(i) ;
            cFileContent.addOutput("[") ;
            cFileContent.addOutput(iteratorID) ;
            cFileContent.addOutput("]") ;
          }

          cFileContent.addOutputNewline(";") ;
          process(object.getBehaviorActionsOwned()) ;

          for(int i = 0 ; i < numberOfLoop ; i++)
          {
            cFileContent.decrementIndent() ;
            cFileContent.addOutputNewline("}") ;
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
        cFileContent.addOutput("while (") ;
        process(object.getLogicalValueExpression()) ;
        cFileContent.addOutputNewline(")") ;
        cFileContent.addOutputNewline("{") ;
        cFileContent.incrementIndent() ;
        process(object.getBehaviorActionsOwned()) ;
        cFileContent.decrementIndent() ;
        cFileContent.addOutputNewline("}") ;
        return DONE ;
      }

      /**
       * Unparse dountilstatement
       */
      public String caseDoUntilStatement(WhileOrDoUntilStatement object)
      {
        //FIXME : TODO : update location reference
        cFileContent.addOutputNewline("do") ;
        cFileContent.addOutputNewline("{") ;
        cFileContent.incrementIndent() ;
        process(object.getBehaviorActionsOwned()) ;
        cFileContent.decrementIndent() ;
        cFileContent.addOutputNewline("}") ;
        cFileContent.addOutput("while (") ;
        process(object.getLogicalValueExpression()) ;
        cFileContent.addOutputNewline(")") ;
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
        cFileContent.addOutput(" = ") ;

        if(object.isAny())
        // TODO: throw new Exception
        {
          cFileContent.addOutput("") ;
        }
        else
        {
          process(object.getValueExpressionOwned()) ;
        }

        cFileContent.addOutputNewline(";") ;
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
          cFileContent.addOutput("[") ;
          process(iv) ;
          cFileContent.addOutput("]") ;
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
          processEList(cFileContent, object.getSubprogramNames(), "_") ;
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

          List<Feature> ordereFeatureList = GenerationUtils.orderFeatures(st) ;

          if(st != null)
          {
            if(object.isSetParameterLabels())
            {
              cFileContent.addOutput(" (") ;

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
                    cFileContent.addOutput("&") ;
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
                      cFileContent.addOutput("&") ;
                    }
                  }
                  
                  // XXX missing condition to switch between blackboard, 
                  // buffers or sampler
                  String blackboardName = _blackboardNames.get(pl.getAadlRef());
                  
                  cFileContent.addOutput(
                          GenerationUtils.generateBlackboardId(blackboardName));
                }

                if(object.getParameterLabels().indexOf(pl) != object
                      .getParameterLabels().size() - 1)
                {
                  cFileContent.addOutput(", ") ;
                }
              }

              cFileContent.addOutputNewline(");") ;
            }
          }
        }
        else
        {
          if(object.isSetParameterLabels())
          {
            cFileContent.addOutput(" (") ;
            processEList(cFileContent, object.getParameterLabels(), ", ") ;
            cFileContent.addOutputNewline(");") ;
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

      public String caseSharedDataAction(SharedDataAction object,
                                         String token)
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

      public String casePortActionOrValue(Name object,
                                          String token)
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
          cFileContent.addOutput("'1'") ;
        }
        else
        {
          cFileContent.addOutput("'0'") ;
        }

        return DONE ;
      }

      /**
       * Unparse stringliteral
       */
      public String caseBehaviorStringLiteral(BehaviorStringLiteral object)
      {
        //FIXME : TODO : update location reference
        cFileContent.addOutput(object.getValue()) ;
        return DONE ;
      }

      public String caseBehaviorRealLiteral(BehaviorRealLiteral object)
      {
        cFileContent.addOutput(String.valueOf(object.getValue())) ;
        return DONE ;
      }

      public String caseBehaviorIntegerLiteral(BehaviorIntegerLiteral object)
      {
        cFileContent.addOutput(Long.toString(object.getValue())) ;
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
            cFileContent.addOutput(" " +
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
          cFileContent.addOutput(" " +
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
          cFileContent.addOutput(object.getUnaryAddingOperatorOwned()
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
            cFileContent.addOutput(" " + itOp.next().getLiteral() + " ") ;
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
            cFileContent.addOutput(" " +
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
            cFileContent.addOutput(AadlBaToCUnparser
                  .getTargetLanguageOperator(object
                        .getUnaryNumericOperatorOwned())) ;
          }
          else if(object.isSetUnaryBooleanOperatorOwned())
          {
            cFileContent.addOutput(AadlBaToCUnparser
                  .getTargetLanguageOperator(object
                        .getUnaryBooleanOperatorOwned())) ;
          }

          cFileContent.addOutput("(") ;
        }

        if(object.getValueOwned() instanceof ValueExpression)
        {
          cFileContent.addOutput("(") ;
          process(object.getValueOwned()) ;
          cFileContent.addOutput(")") ;
        }
        else
        {
          process(object.getValueOwned()) ;
        }

        if(object.isSetUnaryNumericOperatorOwned() ||
              object.isSetUnaryBooleanOperatorOwned())
        {
          cFileContent.addOutput(")") ;
        }

        if(object.isSetBinaryNumericOperatorOwned())
        {
          cFileContent.addOutput(" " +
                object.getBinaryNumericOperatorOwned().getLiteral() + " ") ;

          if(object.getValueSdOwned() instanceof ValueExpression)
          {
            cFileContent.addOutput("(") ;
            process(object.getValueSdOwned()) ;
            cFileContent.addOutput(")") ;
          }
          else
          {
            process(object.getValueSdOwned()) ;
          }
        }

        return DONE ;
      }

      public String caseComment(Comment object)
      {
        cFileContent.addOutputNewline("// " + object.getBody()) ;
        return DONE ;
      }
    } ;
  }

  public void addIndent_C(String indent)
  {
    while(cFileContent.getIndentString().length() < indent.length())
    {
      cFileContent.incrementIndent() ;
    }
  }

  public void addIndent_H(String indent)
  {
    while(headerFileContent.getIndentString().length() < indent.length())
    {
      headerFileContent.incrementIndent() ;
    }
  }

}
