/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.analysis.eg.util;

import java.util.ArrayList ;
import java.util.Collections ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.apache.log4j.Logger ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.BehavioredImplementation ;
import org.osate.aadl2.CalledSubprogram ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.IntegerLiteral ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.RangeValue ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.SubprogramCall ;
import org.osate.aadl2.SubprogramCallSequence ;
import org.osate.aadl2.SubprogramClassifier ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.ba.aadlba.BehaviorAction ;
import org.osate.ba.aadlba.BehaviorActionSequence ;
import org.osate.ba.aadlba.BehaviorActions ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorIntegerLiteral ;
import org.osate.ba.aadlba.BehaviorState ;
import org.osate.ba.aadlba.BehaviorTransition ;
import org.osate.ba.aadlba.DataComponentReference ;
import org.osate.ba.aadlba.ElementValues ;
import org.osate.ba.aadlba.ForOrForAllStatement ;
import org.osate.ba.aadlba.IntegerValue ;
import org.osate.ba.aadlba.SubprogramCallAction ;
import org.osate.utils.IntegerRange ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;

public class BehaviorUtil {
	
	private static final String WCET_PROPERTY = "Compute_Execution_Time";
	
	private static Logger _LOGGER = Logger.getLogger(BehaviorUtil.class) ;
	
	public static DoubleRange getComputeExecutionTimeInMs(NamedElement e)
	{
		RangeValue rv = PropertyUtils.getRangeValue(e, WCET_PROPERTY);
		if (rv != null)
		{
		  IntegerLiteral min = (IntegerLiteral) rv.getMinimum();
		  IntegerLiteral max = (IntegerLiteral) rv.getMaximum();
		  double bcet = getScaledValue (min, "ms");
		  double wcet = getScaledValue (max, "ms");
		  DoubleRange r = new DoubleRange (bcet, wcet);
		  return r;
		  
			//long bcet = ((IntegerLiteral) rv.getMinimumValue()).getValue();
			//long wcet = ((IntegerLiteral) rv.getMaximumValue()).getValue();
			//return new IntegerRange((int) bcet,(int) wcet);
		}
		else
		{
		  IntegerLiteral value = (IntegerLiteral) PropertyUtils.getMaxRangeValue(e, WCET_PROPERTY);
      if(value != null)
      {
        double wcet = getScaledValue (value, "ms");
        //wcet = (int) PropertyUtils.getMaxRangeValue(e, WCET_PROPERTY).getScaledValue();
        return new DoubleRange(wcet, wcet);
      }
      else
			{
				return null;
			}
		}
	}
	
	public static SubprogramClassifier getSubprogramClassifier (
	    SubprogramCallAction action)
	{
	  NamedElement spg = action.getSubprogram().getElement(); 
    if (spg instanceof SubprogramClassifier)
    {
      return (SubprogramClassifier) spg;
    }
    else
    {
      String msg = '\'' + spg.getClass().getSimpleName() +
          "\' is not supported" ; 
      _LOGGER.fatal(msg);
      throw new UnsupportedOperationException(msg);
    }
	}
	
	public static BehaviorAnnex getBehaviorAnnex(NamedElement e)
	{
	    if(e instanceof ComponentInstance)
	    {
	      return getBehaviorAnnex(((ComponentInstance) e).getSubcomponent()) ;
	    }
	    else if(e instanceof Subcomponent)
	    {
	      return getBehaviorAnnex(((Subcomponent) e).getClassifier()) ;
	    }
	    else if (e instanceof SubprogramCall)
	    {
	      CalledSubprogram called = ((SubprogramCall) e).getCalledSubprogram();
	      if (called instanceof SubprogramClassifier)
	      {
	        return getBehaviorAnnex ((SubprogramClassifier) called);
	      }
	      else
	      {
	        String msg = '\'' + called.getClass().getSimpleName() +
              "\' is not supported" ; 
	        _LOGGER.fatal(msg);
	        throw new UnsupportedOperationException(msg);
	      }
	    }
	    else if(e instanceof Classifier)
	    {
	      Classifier c = (Classifier) e ;
	      
	      while (c != null)
	      {
	    	  for(AnnexSubclause annex : c.getOwnedAnnexSubclauses())
	          {
	            if(annex instanceof BehaviorAnnex)
	            {
	              return (BehaviorAnnex) annex ;
	            }
	          }
	    	  
	    	  c = c.getExtended();
	      }
	      
	      if (e instanceof BehavioredImplementation)
	      {
	        BehavioredImplementation bi = (BehavioredImplementation) e;
	        return getBehaviorAnnex (bi.getType());
	      }
	      else
	      {
	        return null;
	      }
	    }
	    else
	    {
	      return null ;
	    }
	}
	
	public static BehaviorState getMainLoopState(BehaviorAnnex ba)
	{
		Map<BehaviorState,List<BehaviorState>> trMap = 
				new HashMap<BehaviorState,List<BehaviorState>>();
		for(BehaviorState s : ba.getStates())
		{
			trMap.put(s, new ArrayList<BehaviorState>());
		}
		for(BehaviorTransition tr: ba.getTransitions())
		{
			List<BehaviorState> l = trMap.get(tr.getSourceState());
			l.add(tr.getDestinationState());
		}
		
		/**
		 * Renvoyer l'état principal: celui dont il y a une transition 
		 * sortante et une transition entrante.
		 * On suppose qu'il n'y a pas de boucles internes.
		 */
		for(BehaviorState s : ba.getStates())
		{
			boolean hasOutgoingTr = ! trMap.get(s).isEmpty();
			if (hasOutgoingTr)
			{
				for(BehaviorState source : ba.getStates())
				{
					boolean hasIncomingTr = trMap.get(source).contains(s);
					if (hasIncomingTr)
					{
						return s;
					}
				}
			}
		}
		return null;
	}
	
	public static List<BehaviorAction> getBehaviorActions(BehaviorActions actions)
  {
	  if (actions == null)
	  {
	    return Collections.emptyList();
	  }
    if (actions instanceof BehaviorActionSequence)
    {
      return ((BehaviorActionSequence) actions).getActions();
    }
    else if (actions instanceof BehaviorAction)
    {
      List<BehaviorAction> l = new ArrayList<BehaviorAction>();
      l.add((BehaviorAction) actions);
      return l;
    }
    else
    {
      String msg = 
          "not supported BehaviorActions kind \'" +
              actions.getClass().getSimpleName() + '\'' ;
      _LOGGER.error(msg) ;
      ServiceProvider.SYS_ERR_REP.error(msg, true);
      return Collections.emptyList();
    }
  }
	
	public static List<SubprogramCall> getCallSequence(NamedElement e)
	{
		if (e instanceof ComponentInstance)
		{
			ComponentInstance c = (ComponentInstance) e;
			return getCallSequence(c.getComponentClassifier());
		}
		else if (e instanceof BehavioredImplementation)
		{
			BehavioredImplementation bi = (BehavioredImplementation) e;
			SubprogramCallSequence seq = getMainCallSequence (bi);
			List<SubprogramCall> specs = (seq==null?null:seq.getOwnedSubprogramCalls());
			
			if (specs != null)
			{
				List<SubprogramCall> list = new ArrayList<SubprogramCall>();
				for(SubprogramCall cs : specs)
				{
					if (cs instanceof SubprogramCall)
					{
						list.add((SubprogramCall) cs);
					}
				}
				return list;
			}
		}
		return null;
	}
	
	private static SubprogramCallSequence getMainCallSequence(BehavioredImplementation bi)
	{
	  List<SubprogramCallSequence> sequences = bi.getOwnedSubprogramCallSequences();
	  for(SubprogramCallSequence s : sequences)
	  {
	    if (!s.getName().toLowerCase().contains("init"))
	    {
	      return s;
	    }
	  }
	  return (sequences.isEmpty() ? null : sequences.get(0));
	    
	}
	
	public static IntegerRange getForStatementRange(ForOrForAllStatement action)
  {
    ElementValues values = action.getIteratedValues();
    if (values instanceof org.osate.ba.aadlba.IntegerRange)
    {
      org.osate.ba.aadlba.IntegerRange ir;
      ir = (org.osate.ba.aadlba.IntegerRange) values;
      
      IntegerValue lowerValue = ir.getLowerIntegerValue();
      IntegerValue upperValue = ir.getUpperIntegerValue();
      return new IntegerRange(getValue(lowerValue), getValue(upperValue));
    }
    else
    {
      String msg = '\'' +
          values.getClass().getSimpleName() + "\' is not supported" ; 
      _LOGGER.fatal(msg);
      throw new UnsupportedOperationException (msg);
    }
  }
	
	private static int getValue(IntegerValue iv)
  {
    if (iv instanceof BehaviorIntegerLiteral)
    {
      BehaviorIntegerLiteral bil = (BehaviorIntegerLiteral) iv;
      return (int) bil.getValue();
    }
    else if (iv instanceof DataComponentReference)
    {
//      DataComponentReference dcr = (DataComponentReference) iv;
      //TODO: "For" statement: get DataComponentReference integer value
      /*NamedElement ne = SubprogramCallUtil.getAssignedValue(dcr);
      if (ne != null)
      {
        return getInitialValueOrDimension(ne);
      }
      else
      {
        return getInitialValueOrDimension(dcr);
      }*/
      return 0;
    }
    else
    {
      String msg = '\'' +
          iv.getClass().getSimpleName() + "\' is not supported" ; 
      _LOGGER.fatal(msg);
      throw new UnsupportedOperationException (msg);
    }
  }
	
	public static double getScaledValue (IntegerLiteral i, String targetUnit)
  {
    //FIXME: i.getScaledValue(targetUnit) must be fixed...
    String unit = i.getUnit().getName();
    double value = (double) i.getValue();
    if (targetUnit.equals("ms"))
    {
      if (unit.equals("ms"))
      {
        return value;
      }
      else if (unit.equals("us"))
      {
        return value/1000;
      }
      else if (unit.equals("ns"))
      {
        return value/1000000;
      }
    }
    return value; // Default
  }
}