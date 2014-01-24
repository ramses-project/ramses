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

package fr.tpt.aadl.ramses.util.properties ;

import java.math.BigDecimal ;
import java.util.ArrayList ;
import java.util.Collections ;
import java.util.List ;

import org.eclipse.core.runtime.Platform;
import org.osate.aadl2.CallSpecification ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.NamedValue;
import org.osate.aadl2.NumberValue;
import org.osate.aadl2.Property;
import org.osate.aadl2.PropertyConstant;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.Subprogram ;
import org.osate.aadl2.SubprogramCall ;
import org.osate.aadl2.SubprogramCallSequence ;
import org.osate.aadl2.UnitLiteral;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.InstanceReferenceValue ;
import org.osate.utils.PropertyUtils ;
import org.osate.xtext.aadl2.properties.util.GetProperties;

import fr.tpt.aadl.ramses.instantiation.manager.PredefinedPropertiesManager;


public class AadlUtil
{

  public enum DispatchProtocol
  {
    Periodic, Aperiodic, Sporadic, Timed, Hybrid, Background, Unknown
  } ;

  private AadlUtil()
  {
  }

  public static ComponentInstance getHighestPeriodTask(ComponentInstance process)
  {
    ComponentInstance result = null ;
    int period = -1 ;

    for(ComponentInstance c : process.getComponentInstances())
    {
      if(c.getCategory() == ComponentCategory.THREAD)
      {
        int period2 = getInfoTaskPeriod(c) ;

        if(period2 > period)
        {
          period = period2 ;
          result = c ;
        }
      }
    }

    return result ;
  }

  public static ComponentInstance getInfoTaskCPU(ComponentInstance thread)
  {
    return getInfoProcessCPU((ComponentInstance) thread.getOwner()) ;
  }

  public static ComponentInstance getInfoProcessCPU(ComponentInstance process)
  {
    try
    {
      PropertyExpression val =
            PropertyUtils.getPropertyValue("Actual_Processor_Binding", process) ;

      if(val instanceof ComponentInstance)
      {
        return (ComponentInstance) val ;
      }
      else if(val instanceof InstanceReferenceValue)
      {
        return (ComponentInstance) (((InstanceReferenceValue) val)
              .getReferencedInstanceObject()) ;
      }

      return null ;
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
      return null ;
    }
  }

  public static ComponentInstance getInfoProcessGlobalCPU(ComponentInstance process)
  {
    ComponentInstance cpu = getInfoProcessCPU(process) ;

    while(cpu.getCategory() != ComponentCategory.PROCESSOR)
    {
      cpu = (ComponentInstance) cpu.getOwner() ;
    }

    return cpu ;
  }

  public static double getInfoMaxDuration(NamedElement e, String unit)
  {
    try
    {
      NumberValue nv =  PropertyUtils.getMaxRangeValue(e, "Compute_Execution_Time") ;
      return nv.getScaledValue(unit);
    }
    catch(Exception ex)
    {
      //ex.printStackTrace();
      return 0f ;
    }
  }

  public static double getInfoMinDuration(NamedElement e, String unit)
  {
    try
    {
      NumberValue nv = PropertyUtils.getMinRangeValue(e, "Compute_Execution_Time"); 
      return nv.getScaledValue(unit);
    }
    catch(Exception ex)
    {
      return getInfoMaxDuration(e, unit) ;
    }
  }

  public static int getInfoTaskDeadline(ComponentInstance task)
  {
    try
    {
      return (int) PropertyUtils.getIntValue(task, "Deadline") ;
    }
    catch(Exception e)
    {
      return getInfoTaskPeriod(task) ;
    }
  }

  public static DispatchProtocol getInfoTaskDispatch(ComponentInstance task)
  {
    try
    {
      String value = PropertyUtils.getEnumValue(task, "Dispatch_Protocol") ;
      return DispatchProtocol.valueOf(value) ;
    }
    catch(Exception e)
    {
      return DispatchProtocol.Unknown ;
    }
  }

  public static int getInfoTaskJitter(ComponentInstance task)
  {
    try
    {
      return (int) PropertyUtils.getIntValue(task, "Jitter") ;
    }
    catch(Exception e)
    {
      return 0 ;
    }
  }

  public static int getInfoTaskPeriod(ComponentInstance task)
  {
    try
    {
      return (int) PropertyUtils.getIntValue(task, "Period") ;
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
      return 0 ;
    }
  }

  public static int getInfoTaskPriority(ComponentInstance task)
  {
    try
    {
      return (int) PropertyUtils.getIntValue(task, "Priority") ;
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
      return 0 ;
    }
  }

  public static int getInfoTaskMemorySize(ComponentInstance task)
  {
    try
    {
      return (int) PropertyUtils.getIntValue(task, "Source_Code_Size") ;
    }
    catch(Exception e)
    {
      return 0 ;
    }
  }

  public static int getInfoTaskStackSize(ComponentInstance task)
  {
    try
    {
      return (int) PropertyUtils.getIntValue(task, "Source_Stack_Size") ;
    }
    catch(Exception e)
    {
      return 0 ;
    }
  }

  public static long getInfoPortCriticality(FeatureInstance port) {
	  try
	  {
	    return (int) PropertyUtils.getIntValue(port, "Criticality") ;
	  }
	  catch(Exception e)
	  {
	    return 0 ;
	  }
  }
  
  public static double getThreadContextSwitchFor(ComponentInstance processor, String unit)
  {
    try
    {
      NumberValue nv = PropertyUtils.getMaxRangeValue(processor,
                                            "Thread_Swap_Execution_Time") ;
      return nv.getScaledValue(unit);
    }
    catch(Exception e)
    {
      return 0f ;
    }
  }

  public static double getProcessContextSwitchFor(ComponentInstance processor, String unit)
  {
    try
    {
      NumberValue nv =  PropertyUtils.getMaxRangeValue(processor,
                                            "Process_Swap_Execution_Time") ;
      return nv.getScaledValue(unit);
    }
    catch(Exception e)
    {
      return 0f ;
    }
  }

  public static double getSchedulerQuantum(ComponentInstance processor, String unit)
  {
    try
    {
      NumberValue nv = PropertyUtils.getMaxRangeValue(processor, "Scheduler_Quantum") ;
      return nv.getScaledValue(unit);
    }
    catch(Exception e)
    {
      return -1 ;
    }
  }

  public static float getSequenceMaxDuration(List<Subprogram> subprograms, String unit)
  {
    BigDecimal d = new BigDecimal("0") ;

    for(Subprogram s : subprograms)
    {
      double max = getInfoMaxDuration(s,unit) ;
      d = d.add(new BigDecimal(max + "")) ;
    }

    return d.floatValue() ;
  }

  public static float getSequenceMinDuration(List<Subprogram> subprograms, String unit)
  {
    BigDecimal d = new BigDecimal("0") ;

    for(Subprogram s : subprograms)
    {
      double min = getInfoMinDuration(s,unit) ;
      d = d.add(new BigDecimal(min + "")) ;
    }

    return d.floatValue() ;
  }

  /*
  public static float getCallSequenceMinDuration(List<SubprogramCall> calls)
  {
    List<Subprogram> subprograms = new ArrayList<Subprogram>();
    for(SubprogramCall call : calls)
    {
      subprograms.add((Subprogram) call.getCalledSubprogram());
    }
    return getSequenceMinDuration(subprograms);
  }*/

  /*
  public static float getCallSequenceMaxDuration(List<SubprogramCall> calls)
  {
    List<Subprogram> subprograms = new ArrayList<Subprogram>();
    for(SubprogramCall call : calls)
    {
      subprograms.add((Subprogram) call.getCalledSubprogram());
    }
    return getSequenceMaxDuration(subprograms);
  }*/

  public static List<Subprogram> getAllCallSequenceAsSubprograms(ComponentInstance c)
  {
    List<SubprogramCall> calls = getAllCallSequence(c) ;
    List<Subprogram> spgs = new ArrayList<Subprogram>() ;

    for(SubprogramCall ca : calls)
    {
      spgs.add((Subprogram) ca.getCalledSubprogram()) ;
    }

    return spgs ;
  }

  public static List<SubprogramCall> getAllCallSequence(ComponentInstance c)
  {
    Classifier ti = c.getSubcomponent().getClassifier() ;

    for(Element e : ti.getOwnedElements())
    {
      if(e instanceof SubprogramCallSequence)
      {
        return getCallSequence((SubprogramCallSequence) e) ;
      }
    }

    return Collections.emptyList() ;
  }

  private static List<SubprogramCall> getCallSequence(SubprogramCallSequence seq)
  {
    List<SubprogramCall> l = new ArrayList<SubprogramCall>() ;

    for(CallSpecification call : seq.getOwnedCallSpecifications())
    {
      SubprogramCall sCall = (SubprogramCall) call ;
      Subprogram s = (Subprogram) sCall.getCalledSubprogram() ;
      l.add(sCall) ;

      for(Element e : s.getOwnedElements())
      {
        if(e instanceof SubprogramCallSequence)
        {
          l.addAll(getCallSequence((SubprogramCallSequence) e)) ;
        }
      }
    }

    return l ;
  }

  /*
  public static float getCallSequenceMaxDuration(ComponentInstance thread)
  {
    return getCallSequenceMaxDuration(getAllCallSequence(thread));
  }*/
  
  public static String getPrecision(NamedElement ne)
  {
	String precision = "";
	if(Platform.isRunning())
	{
		Property prop = GetProperties.lookupPropertyDefinition(ne, "AADL_Project", "Timing_Precision") ;
		UnitLiteral sl = (UnitLiteral) prop.getDefaultValue() ;
		precision = sl.getName();
	}
	else
	{
		PropertyConstant prop = PredefinedPropertiesManager.getPropertyConstantDefinition("AADL_Project", "Timing_Precision");
		NamedValue sl = (NamedValue) prop.getConstantValue() ;
		precision = ((UnitLiteral)sl.getNamedValue()).getName();
	}
	return precision;
  }
}
