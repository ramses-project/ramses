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

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.AbstractEnumerator;
import org.eclipse.emf.common.util.EList;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.AccessType;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.ArrayDimension;
import org.osate.aadl2.BehavioredImplementation;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.ComponentPrototypeBinding;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.DataClassifier;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.Element;
import org.osate.aadl2.Feature;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.Parameter;
import org.osate.aadl2.ParameterConnectionEnd;
import org.osate.aadl2.PrototypeBinding;
import org.osate.aadl2.Subprogram;
import org.osate.aadl2.SubprogramClassifier;
import org.osate.aadl2.SubprogramImplementation;
import org.osate.aadl2.SubprogramPrototype;
import org.osate.aadl2.SubprogramSubcomponentType;
import org.osate.aadl2.SubprogramType;
import org.osate.aadl2.ThreadClassifier;
import org.osate.aadl2.modelsupport.AadlConstants;
import org.osate.aadl2.modelsupport.UnparseText;
import org.osate.aadl2.modelsupport.util.AadlUtil;
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

import fr.tpt.aadl.ramses.generation.c.AadlToCUnparser;
import fr.tpt.aadl.ramses.generation.c.GenerationUtilsC;
import fr.tpt.aadl.ramses.util.generation.GeneratorUtils;


public class AadlBaToCUnparser extends AadlBaUnparser
{

  protected Map<DataAccess, String> _dataAccessMapping = null ;
  protected UnparseText _cFileContent = null ;
  protected UnparseText _headerFileContent = null ;
  protected Set<String> _additionalHeaders = new HashSet<String>() ;
  private NamedElement _owner ;
  
  private List<NamedElement> coreElementsToBeUnparsed = new ArrayList<NamedElement>();
  
  public List<NamedElement> getCoreElementsToBeUnparsed() {
	return coreElementsToBeUnparsed;
  }

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

  

  public static String getInitialStateIdentifier(BehaviorAnnex ba)
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
    	String aadlComponentCId =
    		  GenerationUtilsC.getGenerationCIdentifier(aadlComponent
                  .getQualifiedName()) ;
        
        _cFileContent = new UnparseText() ;
        _headerFileContent = new UnparseText() ;
        
        processEList(_cFileContent, ba.getVariables()) ;
        _cFileContent.addOutputNewline("while(1)") ;
        _cFileContent.addOutputNewline("{") ;
        _cFileContent.incrementIndent() ;
        _cFileContent.addOutputNewline("switch(" +
        		_owner.getName().replace('.', '_')+
                "_current_state)") ;
        _cFileContent.addOutputNewline("{") ;
        _cFileContent.incrementIndent() ;
        _headerFileContent.addOutputNewline("typedef enum {") ;
        _headerFileContent.incrementIndent() ;

        for(BehaviorState state : ba.getStates())
        {
          if(AadlBaVisitors.getTransitionWhereSrc
                (state).isEmpty() == false)
          {
            _cFileContent.addOutputNewline("case " + aadlComponentCId + "_" +
                  state.getName() + ":") ;
            processEList(_cFileContent, (ArrayList<BehaviorTransition>) AadlBaVisitors.
                         getTransitionWhereSrc(state)) ;
          }
          
          String stateCId = GenerationUtilsC.
                getGenerationCIdentifier(aadlComponent.getQualifiedName()+
                                         "_"+state.getName());
          _headerFileContent.addOutput(stateCId);


          if(ba.getStates().indexOf(state) < ba.getStates()
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
        _cFileContent.decrementIndent() ;
        
        return DONE ;
      }

      /**
       * Unparse behaviorvariable
       */
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
          sourceName = GenerationUtilsC.
                getGenerationCIdentifier(object.
                                         getDataClassifier().getQualifiedName());
        }
        _cFileContent.addOutput(sourceName);
        _cFileContent.addOutput(" " + object.getName()) ;
        caseArrayDimensions(object.getArrayDimensions()) ;
        String init = GeneratorUtils.getInitialValue(object.getDataClassifier(), "c") ;
        coreElementsToBeUnparsed.add(object.getDataClassifier());
        if(!init.isEmpty())
        {
        	_cFileContent.addOutput(init) ;
        }
        _cFileContent.addOutputNewline(";") ;
        
        
        
        return DONE ;
      }

      /**
       * Unparse arraysize
       */
      public String caseArrayDimensions(EList<ArrayDimension> arrayDimensions)
      {
        for(ArrayDimension ivc : arrayDimensions)
        {
          _cFileContent.addOutput("[") ;
          _cFileContent.addOutput(Long.toString(ivc.getSize().getSize()));
          _cFileContent.addOutput("]") ;
        }

        return DONE ;
      }

      public String caseBehaviorEnumerationLiteral(BehaviorEnumerationLiteral object)
      {
        // ComponentPropertyValue is defined to refer Enumerated data
    	NamedElement component = object.getComponent();
    	if(component!=null)
    	{
    		try
    	    {
    	      String sourceName = PropertyUtils.getStringValue(component, "Source_Name") ;
    	      _cFileContent.addOutput(object.getEnumLiteral().getValue());
    	    }
    		catch(Exception e)
    		{
    			_cFileContent.addOutput(GenerationUtilsC.getGenerationCIdentifier(component.getQualifiedName())+"_"+object.getEnumLiteral().getValue());
    		}
    	}
    	else
    		_cFileContent.addOutput(object.getEnumLiteral().getValue());
        
        return DONE ;
      }
      
      /**
       * Unparse DataComponentReference
       */
      public String caseDataComponentReference(DataComponentReference object)
      {
        processDataComponentReference(object);
        return DONE ;
      }

      void processDataComponentReference(DataComponentReference object)
      {
      	Iterator<DataHolder> itDataHolder = object.getData().iterator() ;
      	DataHolder dh = itDataHolder.next();
      	process(dh);
      	if(dh instanceof DataSubcomponentHolder)
      	{
      	  DataSubcomponentHolder dsh = (DataSubcomponentHolder) dh;
      	  for(IntegerValue iv:dsh.getArrayIndexes())
      	  {
      		_cFileContent.addOutput("[");
      		if(iv instanceof BehaviorIntegerLiteral)
      		{
   				BehaviorIntegerLiteral ivc = (BehaviorIntegerLiteral) iv;
   				_cFileContent.addOutput(Long.toString(ivc.getValue()));
   			}
   			else if(iv instanceof DataSubcomponentHolder)
  			{
   				processDataComponentReferenceElement((DataSubcomponentHolder)iv);
  			}
  			else if(iv instanceof DataComponentReference)
  			{
  				processDataComponentReference((DataComponentReference) iv);
  			}
      		_cFileContent.addOutput("]");
   		  }
      	}
        while(itDataHolder.hasNext())
        {
          _cFileContent.addOutput(".");
          dh = (DataHolder)itDataHolder.next();
          processDataComponentReferenceElement(dh);
        }
      }
      
      void processDataComponentReferenceElement(DataHolder dh)
      {
    	_cFileContent.addOutput(dh.getElement().getName());
      	if(dh instanceof DataSubcomponentHolder)
      	{
      		DataSubcomponentHolder dsh = (DataSubcomponentHolder) dh;
      		for(IntegerValue iv:dsh.getArrayIndexes())
      		{
      			_cFileContent.addOutput("[");
      			if(iv instanceof BehaviorIntegerLiteral)
      			{
      				BehaviorIntegerLiteral ivc = (BehaviorIntegerLiteral) iv;
      				_cFileContent.addOutput(Long.toString(ivc.getValue()));
      			}
      			else if(iv instanceof DataComponentReference)
      			{
      				processDataComponentReference((DataComponentReference) iv);
      			}
      			else
      			{
      				process(iv);
      			}
      			_cFileContent.addOutput("]");
      		}
      	}
      }
      
      /**
       * Unparse behaviorstate
       * @object: input parameter, destination of a Behavior Transition
       */
      public String caseBehaviorState(BehaviorState object)
      {
        NamedElement aadlComponent = _owner ;
        String aadlComponentCId =
              GenerationUtilsC.getGenerationCIdentifier(aadlComponent
                    .getQualifiedName()) ;
        //if (object.isComplete())

        _cFileContent.addOutputNewline(_owner.getName().replace('.', '_')+
                  "_current_state = " + aadlComponentCId +
                  "_" + object.getName() + ";") ;
        
        return DONE ;
      }

      
      /**
       * Unparse behaviortransition
       */
      public String caseBehaviorTransition(BehaviorTransition object)
      {
        aadlbaText = _cFileContent ;
        long num = object.getPriority() ;


        _cFileContent.addOutput("// Transition id: " + object.getName()) ;


        if(num != -1) // numeral
        {
          _cFileContent.addOutput(" -- Priority " +
                String.valueOf(num)) ;
        }

        _cFileContent.addOutputNewline("") ;

        if(object.getCondition() != null)
        {
          if(object.getCondition() instanceof Otherwise)
          {
            _cFileContent.addOutput("else") ;
            process(object.getCondition()) ;
          }
          else
          {
            _cFileContent.addOutput("if(") ;
            process(object.getCondition()) ;
            _cFileContent.addOutputNewline(")") ;
          }
        }
        else
        {
          _cFileContent.addOutputNewline("if(1) // no execution condition") ;
        }

        _cFileContent.addOutputNewline("{") ;
        _cFileContent.incrementIndent() ;
        
        process((BehaviorState) object.getDestinationState()) ;
        if(object.getActionBlock() != null)
        {
          process(object.getActionBlock()) ;
        }
        if(!object.getDestinationState().isFinal())
            _cFileContent.addOutputNewline("break;") ;
        else
            _cFileContent.addOutputNewline("return;") ;

        _cFileContent.decrementIndent() ;
        _cFileContent.addOutputNewline("}") ;
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
        throw new UnsupportedOperationException() ;
      }

      public String caseDispatchTriggerConditionStop(DispatchTriggerConditionStop object)
      {
        throw new UnsupportedOperationException() ;
      }

      public String caseDispatchTriggerLogicalExpression(DispatchTriggerLogicalExpression object)
      {
        throw new UnsupportedOperationException() ;
      }

      public String caseDispatchConjunction(DispatchConjunction object)
      {
        throw new UnsupportedOperationException() ;
      }

      public String caseBehaviorActionBlock(BehaviorActionBlock object)
      {
        process(object.getContent()) ;

        if(object.getTimeout() != null)
        {
          throw new UnsupportedOperationException() ;
        }

        return DONE ;
      }

      public String caseBehaviorActionSequence(BehaviorActionSequence object)
      {
        processEList(_cFileContent, object.getActions()) ;
        return DONE ;
      }

      public String caseBehaviorActionSet(BehaviorActionSet object)
      {
        throw new UnsupportedOperationException() ;
      }

      
      /**
       * Unparse elsestatement
       */
      public String caseElseStatement(ElseStatement object)
      {
        BehaviorActions lba = object.getBehaviorActions() ;
        _cFileContent.addOutput("else ") ;
        _cFileContent.addOutputNewline("{") ;
        process(lba) ;
        _cFileContent.addOutputNewline("}") ;
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
          _cFileContent.addOutput("else if (") ;
        else
          _cFileContent.addOutput("if (") ;
        
        process(ve) ;
        _cFileContent.addOutput(") ") ;

        
        _cFileContent.addOutputNewline("{") ;
        process(lba) ;
        _cFileContent.addOutputNewline("}") ;
        if(object.getElseStatement()!=null)
        	process(object.getElseStatement());
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
          _cFileContent.addOutputNewline("int iter=0;") ;
          _cFileContent.addOutputNewline("for (iter=" + lowerRangeValue +
                ";iter<=" + upperRangeValue + ";iter++)") ;
          _cFileContent.addOutputNewline("{") ;
          _cFileContent.incrementIndent() ;
          DataClassifier iterativeVariableClassifier = object.getIterativeVariable().getDataClassifier() ;
          try
          {
            GenerationUtilsC.resolveExistingCodeDependencies(iterativeVariableClassifier,_additionalHeaders);
          } catch(Exception e)
          {
            _cFileContent.addOutput(GenerationUtilsC.
                                    getGenerationCIdentifier(iterativeVariableClassifier.
                                    getQualifiedName()));
          }
          
          _cFileContent.addOutput(" ") ;
          _cFileContent.addOutput(object.getIterativeVariable().getName()) ;
          _cFileContent.addOutputNewline(" = iter;") ;
          process(object.getBehaviorActions()) ;
          _cFileContent.decrementIndent() ;
          _cFileContent.addOutputNewline("}") ;
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
            _cFileContent.addOutputNewline("int " + iteratorID + "=0;") ;
            _cFileContent.addOutputNewline("for (" + iteratorID + "=0;" +
                  iteratorID + "<" +
                  Long.toString(dataReferenceTypeHolder.dimension_sizes[i]) +
                  ";" + iteratorID + "++)") ;
            _cFileContent.addOutputNewline("{") ;
            _cFileContent.incrementIndent() ;
          }

          DataClassifier iterativeVariableClassifier = object.getIterativeVariable().getDataClassifier() ;
          try
          {
            String existing = GenerationUtilsC.resolveExistingCodeDependencies(iterativeVariableClassifier, _additionalHeaders);
            aadlbaText.addOutput(existing);
          }
          catch(Exception e)
          {
            _cFileContent.addOutput(GenerationUtilsC.
                                    getGenerationCIdentifier(iterativeVariableClassifier.getQualifiedName()));
          }
          _cFileContent.addOutput(" ") ;
          _cFileContent.addOutput(object.getIterativeVariable().getName()) ;
          _cFileContent.addOutput(" = ") ;
          process(object.getIteratedValues()) ;

          for(int i = 0 ; i < numberOfLoop ; i++)
          {
            String iteratorID = "iter" + Integer.toString(i) ;
            _cFileContent.addOutput("[") ;
            _cFileContent.addOutput(iteratorID) ;
            _cFileContent.addOutput("]") ;
          }

          _cFileContent.addOutputNewline(";") ;
          process(object.getBehaviorActions()) ;

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
        process(object.getBehaviorActions()) ;
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
        process(object.getBehaviorActions()) ;
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
        throw new UnsupportedOperationException() ;
      }

      /**
       * Unparse timedaction
       */
      public String caseTimedAction(TimedAction object)
      {
        throw new UnsupportedOperationException() ;
      }

      /**
       * Unparse assignmentaction
       */
      public String caseAssignmentAction(AssignmentAction object)
      {
        process(object.getTarget()) ;
        _cFileContent.addOutput(" = ") ;

        if(object instanceof Any)
        {
          throw new UnsupportedOperationException() ;
        }
        else
        {
          process(object.getValueExpression()) ;
        }

        _cFileContent.addOutputNewline(";") ;
        return DONE ;
      }
      
      public boolean manageParameterDirection(Parameter formal, ParameterLabel actual)
      {
    	  boolean remainingParenthesis = false;
    	  String usageP = Aadl2Utils.getParameter_Usage(formal);
          if(Aadl2Utils.isInOutParameter(formal) ||
          		Aadl2Utils.isOutParameter(formal) ||
          		usageP.equalsIgnoreCase("by_reference"))
          {
            if(actual instanceof ParameterHolder)
            {
          	  ParameterHolder ph = (ParameterHolder) actual;
          	  String usage = Aadl2Utils.getParameter_Usage(ph.getParameter());
          	  // in out passed to in
          	  if(!Aadl2Utils.isOutParameter(ph.getParameter()) &&
          		!Aadl2Utils.isInOutParameter(ph.getParameter())
          		&& !usage.equalsIgnoreCase("by_reference"))
          		// and ph.getParameter not by reference
          		  _cFileContent.addOutput("*") ;
          		  
            }
            else if (actual instanceof DataSubcomponentHolder
          		  || actual instanceof BehaviorVariableHolder)
          	  _cFileContent.addOutput("&") ;
            else if (actual instanceof DataComponentReference)
            {
          	  _cFileContent.addOutput("&(") ;
          	  remainingParenthesis=true;
            }
            else if(actual instanceof DataAccessHolder)
            {
              DataAccessHolder dah = (DataAccessHolder) actual;
              if(!Aadl2Utils.isReadWriteDataAccess(dah.getDataAccess()) &&
            		  !Aadl2Utils.isWriteOnlyDataAccess(dah.getDataAccess()))
            	  //TODO: and dah.getAccess not by reference
            	  _cFileContent.addOutput("*") ;
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
          		remainingParenthesis = manageParameterDirection(formal, (ParameterLabel) v);
          	  }
          	  else if (v instanceof ParameterHolder)
          	  {
          		remainingParenthesis = manageParameterDirection(formal, (ParameterLabel) v);
          	  }
          	  else
          	  {
          		_cFileContent.addOutput("&") ;
          	  }
            }
          }
          else
          {
          	// if p not by_reference
          	if(actual instanceof ParameterHolder)
            {
          	  ParameterHolder ph = (ParameterHolder) actual;
          	  String usagePH = Aadl2Utils.getParameter_Usage(ph.getElement());
          	  // in to inout
          	  if(Aadl2Utils.isOutParameter(ph.getParameter()) ||
              	Aadl2Utils.isInOutParameter(ph.getParameter()) ||
              	  usagePH.equalsIgnoreCase("by_reference"))
          		  _cFileContent.addOutput("*") ;
            }
          	else if(actual instanceof DataAccessHolder)
            {
              DataAccessHolder dah = (DataAccessHolder) actual;
              if(Aadl2Utils.isReadWriteDataAccess(dah.getDataAccess()) &&
            		  Aadl2Utils.isWriteOnlyDataAccess(dah.getDataAccess()))
            	  //TODO: and dah.getAccess not by reference
            	  _cFileContent.addOutput("*") ;
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
          		remainingParenthesis = manageParameterDirection(formal, (ParameterLabel) v);
          	  }
          	  else if (v instanceof ParameterHolder)
          	  {
          		remainingParenthesis = manageParameterDirection(formal, (ParameterLabel) v);
          	  }
            }
          }
          return remainingParenthesis;
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
          		  _cFileContent.addOutput("*") ;
        	}
        	else if(actual instanceof DataSubcomponentHolder
        			|| actual instanceof BehaviorVariableHolder)
        		_cFileContent.addOutput("&") ;
        	else if (actual instanceof DataComponentReference)
            {
          	  _cFileContent.addOutput("&(") ;
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
        			_cFileContent.addOutput("*") ;
          	}
          }
    	  return remainingParenthesis;
      }
      
      public String caseCalledSubprogramHolder(CalledSubprogramHolder object)
      {
        aadlbaText = _cFileContent;
        String referencingExistingCode = GenerationUtilsC.resolveExistingCodeDependencies(object.getElement(), _additionalHeaders);
        if(referencingExistingCode!=null)
        	aadlbaText.addOutput(referencingExistingCode);
        else
        {
        	_cFileContent.addOutput(GenerationUtilsC.
        			getGenerationCIdentifier(object.getElement().getQualifiedName()));
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

          AadlToCUnparser aadlCUnparser = AadlToCUnparser.getAadlToCUnparser(); 
          
          if(sct instanceof SubprogramPrototype)
          {
        	  SubprogramPrototype sp = (SubprogramPrototype) sct ;
        	  Classifier cl = (Classifier) _owner;
        	  List<PrototypeBinding> prototypeBindingList = cl.getOwnedPrototypeBindings();
        	  if(cl instanceof ComponentImplementation)
        	  {
        		  ComponentImplementation ci = (ComponentImplementation) cl;
        		  prototypeBindingList.addAll(ci.getType().getOwnedPrototypeBindings());
        	  }
        	  for(PrototypeBinding pb: prototypeBindingList)
        	  {
        		  ComponentPrototypeBinding cpb = (ComponentPrototypeBinding) pb;
        		  if(pb.getFormal().equals(sp))
        		  {
        			  sct = (SubprogramSubcomponentType) cpb.getActuals().get(0).getSubcomponentType();
        			  break;
        		  }
        	  }
          }
          if(sct instanceof SubprogramType)
          {
            st = (SubprogramType) sct ;
          }
          else if(sct instanceof SubprogramImplementation)
          {
            SubprogramImplementation si = (SubprogramImplementation) sct ;
            st = si.getType() ;
          }
          additionalSubprogramsToUnparse(sct);
          List<PrototypeBinding> currentBindings = aadlCUnparser.getCurrentPrototypeBindings(
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
              boolean isReturnParam = GenerationUtilsC.isReturnParameter(p);
              if(isReturnParam)
              {
                returnParameter = p;
                process(pl);
                _cFileContent.addOutput(" = ") ;
                break;
              }
            }
          }

          process(object.getSubprogram()) ;

          if(st != null)
          {
            _cFileContent.addOutput(" (") ;
            boolean first = true;
            boolean remainingParenthesis = false;
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
                  _cFileContent.addOutput(", ") ;
                
                remainingParenthesis = manageParameterDirection(p, pl);

                if(pl instanceof ElementHolder)
                {
                  ElementHolder eh = (ElementHolder) pl;
                  if(eh instanceof ParameterHolder
                		  || eh instanceof DataAccessHolder)
                	  _cFileContent.addOutput(eh.getElement().getName());
                  else
                	  _cFileContent.addOutput(GenerationUtilsC.getGenerationCIdentifier(eh.getElement().getQualifiedName()));
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
                  	  _cFileContent.addOutput(eh.getElement().getName());
                    else
                  	  _cFileContent.addOutput(GenerationUtilsC.getGenerationCIdentifier(eh.getElement().getQualifiedName()));
              	  }
              	  else if(v instanceof DataComponentReference)
              	  {
              		process(v);
              	  }
              	  else
              	  {
              		  process(v);
              	  }
                }
                else
                {
                  process(pl) ;
                }
                if(remainingParenthesis)
                {
                	_cFileContent.addOutput(")");
                	remainingParenthesis=false;
                }
                first=false;
              }
              else if(pce instanceof DataAccess)
              {
                DataAccess da = (DataAccess) pce ;
                if(first==false)
                  _cFileContent.addOutput(", ") ;
                if(da.getKind().equals(AccessType.REQUIRES))
                {
                  remainingParenthesis = manageAccessDirection(da, pl);  
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
                  	name = GenerationUtilsC.getGenerationCIdentifier(ds.getQualifiedName());
                  }
                }

                if (name != null)
                {
                  _cFileContent.addOutput(name);
                }
                else // Otherwise, process parameter label as usual.
                {
                  process((ParameterLabel) pl) ;
                }
                if(remainingParenthesis)
                {
                	_cFileContent.addOutput(")");
                	remainingParenthesis=false;
                }
                first=false;
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
      
      private void additionalSubprogramsToUnparse(SubprogramSubcomponentType sct) {
    	AadlToCUnparser aadlCUnparser = AadlToCUnparser.getAadlToCUnparser();   
    	if(false == aadlCUnparser.additionalUnparsing.contains(sct))
    	  aadlCUnparser.additionalUnparsing.add(sct);
        for(AnnexSubclause as: ((SubprogramClassifier)sct).getAllAnnexSubclauses() )
        {
          if(as instanceof BehaviorAnnex)
          {
        	for(SubprogramHolder otherSpg: EcoreUtil2.getAllContentsOfType(as, SubprogramHolder.class))
        	{
        	  if(true == aadlCUnparser.additionalUnparsing.contains(otherSpg))
        		continue;
        	  aadlCUnparser.additionalUnparsing.add(otherSpg.getSubprogram());
        	  additionalSubprogramsToUnparse((SubprogramSubcomponentType) otherSpg.getSubprogram());
        	}
        	return;
          }
        }
	 }

	public String caseElementHolder(ElementHolder object)
      {
    	NamedElement elt = object.getElement();
    	String id;
    	boolean pointer=false;
    	if(elt instanceof Parameter)
		{
			Parameter p = (Parameter) elt;
			if(false==(object.eContainer() instanceof SubprogramCallAction))
			{
			  String usageP = Aadl2Utils.getParameter_Usage(p);
			  if(Aadl2Utils.isInOutParameter(p)
				  || Aadl2Utils.isOutParameter(p)
				  || usageP.equalsIgnoreCase("by_reference"))
			  {
			    aadlbaText.addOutput("(*");
			    pointer=true;
			  }
			
			}
			id = elt.getName();
			
		}
		else if (elt instanceof DataAccess)
		{
		  DataAccess da = (DataAccess) elt;
		  
		  if(false==(object.eContainer() instanceof SubprogramCallAction))
		  {
			if(Aadl2Utils.isReadWriteDataAccess(da)
			  || Aadl2Utils.isWriteOnlyDataAccess(da))
			{
  			   aadlbaText.addOutput("(*");
			   pointer=true;		
			}
		  }
  		  id = elt.getName();
		}
    	else	
    		id = elt.getQualifiedName();
    	aadlbaText.addOutput(GenerationUtilsC.getGenerationCIdentifier(id));
    	if(pointer)
    		aadlbaText.addOutput(")");
    	if(object instanceof IndexableElement)
    	{	
    	  IndexableElement ie = (IndexableElement) object;
    	  for(IntegerValue iv: ie.getArrayIndexes())
    	  {
    		aadlbaText.addOutput("[");
    		process(iv);
    		aadlbaText.addOutput("]");
    	  }
    	}
        return DONE ;
      }
      
      public String casePortSendAction(PortSendAction object)
      {
        throw new UnsupportedOperationException() ;
      }

      public String casePortFreezeAction(PortFreezeAction object)
      {
        throw new UnsupportedOperationException() ;
      }

      public String casePortDequeueAction(PortDequeueAction object)
      {
        throw new UnsupportedOperationException() ;
      }

      public String caseLockAction(LockAction object)
      {
        throw new UnsupportedOperationException() ;
      }

      public String caseUnlockAction(UnlockAction object)
      {
        throw new UnsupportedOperationException() ;
      }

      /**
       * Unparse behaviortime
       */
      public String caseBehaviorTime(BehaviorTime object)
      {
        throw new UnsupportedOperationException() ;
      }

      public String casePortDequeueValue(PortDequeueValue object)
      {
        throw new UnsupportedOperationException() ;
      }

      public String casePortCountValue(PortCountValue object)
      {
        throw new UnsupportedOperationException() ;
      }

      public String casePortFreshValue(PortFreshValue object)
      {
        throw new UnsupportedOperationException() ;
      }

      /**
       * Unparse booleanliteral
       */
      public String caseBehaviorBooleanLiteral(BehaviorBooleanLiteral object)
      {
        //FIXME : TODO : update location reference
        if(object.isValue())
        {
          _cFileContent.addOutput("1") ;
        }
        else
        {
          _cFileContent.addOutput("0") ;
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
        process(object.getFirstExpression()) ;

        if(object.getSecondExpression() != null)
        {
          _cFileContent.addOutput(" " +
                AadlBaToCUnparser.getTargetLanguageOperator(object
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
          _cFileContent.addOutput(object.getUnaryAddingOperator()
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
        if(object.getUnaryNumericOperator() != UnaryNumericOperator.NONE)
        {
          _cFileContent.addOutput(AadlBaToCUnparser
                                  .getTargetLanguageOperator(object
                                                             .getUnaryNumericOperator())) ;
          _cFileContent.addOutput("(") ;
        }
        else if(object.getUnaryBooleanOperator()!= UnaryBooleanOperator.NONE)
        {
          _cFileContent.addOutput(AadlBaToCUnparser
                                  .getTargetLanguageOperator(object
                                                             .getUnaryBooleanOperator())) ;
          _cFileContent.addOutput("(") ;
        }



        if(object.getFirstValue() instanceof ValueExpression)
        {
          _cFileContent.addOutput("(") ;
          process(object.getFirstValue()) ;
          _cFileContent.addOutput(")") ;
        }
        else
        {
          process(object.getFirstValue()) ;
        }

        if(object.getUnaryNumericOperator()!=UnaryNumericOperator.NONE ||
              object.getUnaryBooleanOperator() != UnaryBooleanOperator.NONE)
        {
          _cFileContent.addOutput(")") ;
        }

        if(object.getBinaryNumericOperator()!=BinaryNumericOperator.NONE)
        {
          _cFileContent.addOutput(" " +
                object.getBinaryNumericOperator().getLiteral() + " ") ;

          if(object.getSecondValue() instanceof ValueExpression)
          {
            _cFileContent.addOutput("(") ;
            process(object.getSecondValue()) ;
            _cFileContent.addOutput(")") ;
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

  public void setOwner(NamedElement owner) {
	this._owner = owner;
  }
  
}