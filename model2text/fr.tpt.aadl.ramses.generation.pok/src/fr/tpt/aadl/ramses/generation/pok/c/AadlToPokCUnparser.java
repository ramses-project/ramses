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

package fr.tpt.aadl.ramses.generation.pok.c;

import java.io.File ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.AadlPackage ;
import org.osate.aadl2.BasicPropertyAssociation ;
import org.osate.aadl2.BehavioredImplementation ;
import org.osate.aadl2.BooleanLiteral ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.DirectionType ;
import org.osate.aadl2.EnumerationLiteral ;
import org.osate.aadl2.IntegerLiteral ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.MemorySubcomponent ;
import org.osate.aadl2.ModalPropertyValue ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.NamedValue ;
import org.osate.aadl2.NumberValue ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorImplementation ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.Property ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.RecordValue ;
import org.osate.aadl2.ReferenceValue ;
import org.osate.aadl2.StringLiteral ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.Subprogram ;
import org.osate.aadl2.SubprogramCall ;
import org.osate.aadl2.SubprogramCallSequence ;
import org.osate.aadl2.SubprogramImplementation ;
import org.osate.aadl2.SubprogramType ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.SystemSubcomponent ;
import org.osate.aadl2.ThreadImplementation ;
import org.osate.aadl2.ThreadSubcomponent ;
import org.osate.aadl2.VirtualProcessorImplementation;
import org.osate.aadl2.VirtualProcessorSubcomponent ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.ConnectionInstance ;
import org.osate.aadl2.instance.FeatureCategory ;
import org.osate.aadl2.instance.FeatureInstance ;
import org.osate.aadl2.instance.InstanceReferenceValue ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.UnparseText ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.control.atl.hooks.impl.HookAccessImpl ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.AadlTargetUnparser ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.TargetProperties ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.utils.FileUtils ;
import fr.tpt.aadl.ramses.generation.c.GenerationUtilsC ;
import fr.tpt.aadl.ramses.generation.utils.AadlToXUnparser ;
import fr.tpt.aadl.ramses.generation.utils.GenerationInfos.BlackBoardInfo ;
import fr.tpt.aadl.ramses.generation.utils.GenerationInfos.EventInfo ;
import fr.tpt.aadl.ramses.generation.utils.GenerationInfos.QueueInfo ;
import fr.tpt.aadl.ramses.generation.utils.GenerationInfos.SampleInfo ;
import fr.tpt.aadl.ramses.generation.utils.GeneratorUtils ;
import fr.tpt.aadl.ramses.generation.utils.ProcessProperties ;
import fr.tpt.aadl.ramses.generation.utils.ProcessorProperties ;
import fr.tpt.aadl.ramses.generation.utils.RoutingProperties ;

public class AadlToPokCUnparser extends AadlToXUnparser implements AadlTargetUnparser
{
  private final static long DEFAULT_REQUIRED_STACK_SIZE = 16384 ;
  
  // TODO: factorization with ATL transformation into a naming class or enum. 
  public final static String BLACKBOARD_AADL_TYPE = 
                                             "arinc653_runtime::Blackboard_Id_Type" ;
  
  public final static String QUEUING_AADL_TYPE =
                                           "arinc653_runtime::Queuing_Port_Id_Type" ;

  public final static String SAMPLING_AADL_TYPE =
                                          "arinc653_runtime::Sampling_Port_Id_Type" ;
  
  public final static String EVENT_AADL_TYPE =
                                          "arinc653_runtime::Event_Id_Type" ;
  
  public final static String BUFFER_AADL_TYPE =
                                          "arinc653_runtime::Buffer_Id_Type" ;
  
  public final static String SEMAPHORE_AADL_TYPE = 
		  								  "arinc653_runtime::Semaphore_Id_Type" ;
  
  public final static String VIRTUAL_PORT_AADL_TYPE = 
      "rtl8029_driver::Pok_Port_Id_T" ;

  private static final String VIRTUAL_PORT_SUFFIX = "_virtual_port" ;
  
  private ProcessorProperties _processorProp;
  
  private int partitionId=0;
  
  private static Logger _LOGGER = Logger.getLogger(AadlToPokCUnparser.class) ;
  
  public void process(ProcessorSubcomponent processorSubcomponent,
                      TargetProperties tarProp,
                      File runtimePath,
                      File outputDir,
                      IProgressMonitor monitor) throws GenerationException
  { 
    ProcessorProperties processorProp = new ProcessorProperties() ;
    ComponentInstance processorInst = (ComponentInstance) HookAccessImpl.
                                             getTransformationTrace(processorSubcomponent) ;
    RoutingProperties routing = (RoutingProperties) tarProp ;
    
    // Discard older processor properties !
    _processorProp = processorProp ;
    
    // Generate deployment.h
    UnparseText deploymentHeaderCode = new UnparseText() ;
    genDeploymentHeader(processorSubcomponent, deploymentHeaderCode, routing) ;
    
    // Generate deployment.c
    UnparseText deploymentImplCode = new UnparseText() ;
    genDeploymentImpl(processorSubcomponent, deploymentImplCode, processorProp) ;
    
    // Generate routing.h
    UnparseText routingHeaderCode = new UnparseText() ;
    genRoutingHeader(processorInst, routingHeaderCode, routing) ;

    // Generate routing.c
    UnparseText routingImplCode = new UnparseText() ;
    genRoutingImpl(processorInst, routingImplCode, routing) ;
    
    try
    {
      FileUtils.saveFile(outputDir, "deployment.h",
               deploymentHeaderCode.getParseOutput()) ;
      
      FileUtils.saveFile(outputDir, "deployment.c",
               deploymentImplCode.getParseOutput()) ;
      
      FileUtils.saveFile(outputDir, "routing.h", routingHeaderCode.getParseOutput()) ;

      FileUtils.saveFile(outputDir, "routing.c", routingImplCode.getParseOutput()) ;
    }
    catch(IOException e)
    {
      String errMsg = "cannot save the generated files" ;
      _LOGGER.fatal(errMsg, e) ;
      throw new RuntimeException(errMsg, e) ;
    }
  }
  
  
  private void genQueueMainImpl(UnparseText mainImplCode,
                                ProcessProperties pp)
  {
    for(QueueInfo info : pp.queueInfo)
    {
      mainImplCode.addOutput("  CREATE_QUEUING_PORT (\"") ;
      mainImplCode.addOutput(info.uniqueId);
      mainImplCode.addOutputNewline("\",");
      mainImplCode.addOutput("    sizeof( "+info.dataType+" ), ");
      mainImplCode.addOutput(Long.toString(info.size)) ;
      mainImplCode.addOutput(", ");
      
      String direction = null ;
      if(DirectionType.IN == info.direction)
      {
        direction = "DESTINATION" ;
      }
      else
      {
        direction = "SOURCE" ;
      }
      
      mainImplCode.addOutput(direction);
      mainImplCode.addOutput(", ") ;
      mainImplCode.addOutput(info.type.toUpperCase());
      mainImplCode.addOutputNewline(",");
      mainImplCode.addOutput("      &(") ;
      mainImplCode.addOutput(info.id) ;
      mainImplCode.addOutputNewline("), &(ret));") ;
    }
  }
  
  private void genEventMainImpl(UnparseText mainImplCode,
                                 ProcessProperties pp)
  {
    for(EventInfo eventInfo: pp.eventInfo)
    {
      mainImplCode.addOutput("  CREATE_EVENT (\"") ;
      mainImplCode.addOutput(eventInfo.id);
      mainImplCode.addOutput("\",");
      mainImplCode.addOutput("&"+eventInfo.id+",");
      mainImplCode.addOutputNewline("& (ret));");
    }
  }
  
  private void genBufferMainImpl(UnparseText mainImplCode,
                                ProcessProperties pp)
 {
   for(QueueInfo info: pp.bufferInfo)
   {
     mainImplCode.addOutput("  CREATE_BUFFER (\"") ;
     mainImplCode.addOutput(info.id);
     mainImplCode.addOutput("\",");
     mainImplCode.addOutput("    sizeof( "+info.dataType+" ), ");
     mainImplCode.addOutput(Long.toString(info.size)) ;
     mainImplCode.addOutput(", ");
     mainImplCode.addOutput(info.type.toUpperCase());
     mainImplCode.addOutput(",");
     mainImplCode.addOutput("&"+info.id+",");
     mainImplCode.addOutputNewline("& (ret));");
   }
 }
  
  private void genSampleMainImpl(UnparseText mainImplCode,
                                 ProcessProperties pp)
  {
    for(SampleInfo info : pp.sampleInfo)
    {
      mainImplCode.addOutput("  CREATE_SAMPLING_PORT (\"") ;
      mainImplCode.addOutput(info.uniqueId);
      mainImplCode.addOutputNewline("\",");
      mainImplCode.addOutput("    sizeof( " + info.dataType + " ), ");
      
      String direction = null ;
      if(DirectionType.IN == info.direction)
      {
        direction = "DESTINATION" ;
      }
      else
      {
        direction = "SOURCE" ;
      }
      
      mainImplCode.addOutput(direction);
      mainImplCode.addOutput(", ") ;
      mainImplCode.addOutput(Long.toString(info.refresh)) ;
      mainImplCode.addOutputNewline(",");
      mainImplCode.addOutput("      &(") ;
      mainImplCode.addOutput(info.id) ;
      mainImplCode.addOutputNewline("), &(ret));") ;
    }
  }
  
  public void process(ProcessSubcomponent process,TargetProperties tarProp,
                      File runtimePath,
                      File outputDir,
                      IProgressMonitor monitor)
  {
	  StringBuilder sb = new StringBuilder(process.getQualifiedName());
    ProcessProperties pp = new ProcessProperties(sb.substring(0, sb.lastIndexOf("::")+2)) ;
    
    ProcessImplementation processImpl = (ProcessImplementation) 
                                          process.getComponentImplementation() ;
    
    this.findCommunicationMechanism(processImpl, pp);
    
    // Generate main.h
    UnparseText mainHeaderCode = new UnparseText() ;
    genMainHeader(processImpl, mainHeaderCode, _processorProp, pp);
    
    // Generate main.c
    UnparseText mainImplCode = new UnparseText() ;
    genMainImpl(processImpl, mainImplCode, pp) ;
    
    ComponentInstance processInstance = (ComponentInstance) HookAccessImpl.getTransformationTrace(process);
    
    mainImplCode.addOutputNewline(GenerationUtilsC
                                  .generateSectionTitle("SEND OUTPUT")) ;
    genSendOutputImpl(processInstance, mainImplCode, mainHeaderCode, pp);
    
    try
    {
      FileUtils.saveFile(outputDir, "main.h",
               mainHeaderCode.getParseOutput()) ;
      
      FileUtils.saveFile(outputDir, "main.c",
               mainImplCode.getParseOutput()) ;
    }
    catch(IOException e)
    {
      String errMsg = "cannot save the generated files for \'" +
                                                            process.getName() + '\'' ;
      _LOGGER.fatal(errMsg, e) ;
      throw new RuntimeException(errMsg, e) ;
    }
  }
  
  //Generate global variables.
  private void genGlobalVariablesMainImpl(ProcessImplementation process, EList<ThreadSubcomponent> lthreads,
                                          UnparseText mainImplCode,
                                          ProcessProperties pp)
  {
    mainImplCode.addOutputNewline(GenerationUtilsC.generateSectionMark()) ;
    mainImplCode.addOutputNewline(GenerationUtilsC
          .generateSectionTitle("GLOBAL VARIABLES")) ;
    
    // Generate thread names array.
    if(false == lthreads.isEmpty())
    {
      mainImplCode
            .addOutputNewline(
                    "PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];") ;
    }
    
    // Generate blackboard names array.
    if(pp.hasBlackboard)
    {
      mainImplCode.addOutput("char* pok_blackboards_names[POK_CONFIG_NB_BLACKBOARDS] = {") ;

      for(BlackBoardInfo info : pp.blackboardInfo)
      {
        mainImplCode.addOutput("\"") ;
        mainImplCode.addOutput(info.id) ;
        mainImplCode.addOutput("\",") ;
      }

      mainImplCode.addOutputNewline("};") ;
      int i = 0;
      // Generate external variable (declared in deployment.c).
      for(BlackBoardInfo info : pp.blackboardInfo)
      {
        mainImplCode.addOutput("BLACKBOARD_ID_TYPE ") ;
        mainImplCode.addOutput(info.id) ;
        mainImplCode.addOutputNewline("=" + Integer.toString(i) +";") ;
        i++;
      }
    }
    
    // Generate event names array.
    if(pp.hasEvent)
    {
      mainImplCode.addOutput("char* pok_arinc653_events_names[POK_CONFIG_NB_EVENTS] = {") ;

      for(EventInfo eventInfo : pp.eventInfo)
      {
        mainImplCode.addOutput("\"") ;
        mainImplCode.addOutput(eventInfo.id) ;
        mainImplCode.addOutput("\"") ;
      }

      mainImplCode.addOutputNewline("};") ;
      
      // Generate external variable (declared in deployment.c).
      for(EventInfo eventInfo : pp.eventInfo)
      {
        mainImplCode.addOutput("EVENT_ID_TYPE ") ;
        mainImplCode.addOutput(eventInfo.id) ;
        mainImplCode.addOutputNewline(";") ;
      }
    }
    
    // Generate semaphore names array.
    if(pp.hasSemaphore)
    {
      mainImplCode.addOutput("char* pok_arinc653_semaphores_names[POK_CONFIG_ARINC653_NB_SEMAPHORES] = {") ;

      for(String name : pp.semaphoreNames)
      {
        mainImplCode.addOutput("\"") ;
        mainImplCode.addOutput(name) ;
        mainImplCode.addOutput("\"") ;
      }

      mainImplCode.addOutputNewline("};") ;
      
      // Generate external variable (declared in deployment.c).
      for(String name : pp.semaphoreNames)
      {
        mainImplCode.addOutput("SEMAPHORE_ID_TYPE ") ;
        mainImplCode.addOutput(name) ;
        mainImplCode.addOutputNewline(";") ;
      }
    }
    
    // Generate buffer names array.
    if(pp.hasBuffer)
    {
      mainImplCode.addOutput("char* pok_buffers_names[POK_CONFIG_NB_BUFFERS] = {") ;

      for(QueueInfo info : pp.bufferInfo)
      {
        mainImplCode.addOutput("\"") ;
        mainImplCode.addOutput(info.id) ;
        mainImplCode.addOutput("\"") ;
      }

      mainImplCode.addOutputNewline("};") ;
      
      // Generate external variable (declared in deployment.c).
      for(QueueInfo info : pp.bufferInfo)
      {
        mainImplCode.addOutput("BUFFER_ID_TYPE ") ;
        mainImplCode.addOutput(info.id) ;
        mainImplCode.addOutputNewline(";") ;
      }
    }
    
    // Generate queue names array.
    if(pp.hasQueue)
    {
      for(QueueInfo info : pp.queueInfo)
      {
        mainImplCode.addOutput("QUEUING_PORT_ID_TYPE ") ;
        mainImplCode.addOutput(info.id) ;
        mainImplCode.addOutputNewline(";") ;
      }
    }
    
    // Generate sample names array.
    if(pp.hasSample)
    {
      for(SampleInfo info : pp.sampleInfo)
      {
        mainImplCode.addOutput("SAMPLING_PORT_ID_TYPE ") ;
        mainImplCode.addOutput(info.id) ;
        mainImplCode.addOutputNewline(";") ;
      }
    }
    
    genGlobalVariablesMainOptional(process, mainImplCode);

    mainImplCode.addOutputNewline(GenerationUtilsC.generateSectionMark()) ;
  }
  
  protected void genGlobalVariablesMainOptional(ProcessImplementation process,
		UnparseText mainImplCode){}

private void genFileIncludedMainImpl(UnparseText mainImplCode)
  {
    // Files included.
    mainImplCode.addOutputNewline(GenerationUtilsC.generateSectionMark()) ;
    mainImplCode.addOutputNewline(GenerationUtilsC
                                  .generateSectionTitle("INCLUSION")) ;
    
    mainImplCode.addOutputNewline("#include \"main.h\"") ;
    mainImplCode.addOutputNewline("#include \"activity.h\"") ;
  }

  private void genThreadErrorHandlerImpl(ThreadSubcomponent thread,
        UnparseText mainImplCode)
  {
    ThreadImplementation timpl =
	        (ThreadImplementation) thread.getComponentImplementation() ;
    mainImplCode.addOutput("  tattr.ENTRY_POINT = ") ;
	mainImplCode.addOutput(GenerationUtilsC
	       .getGenerationCIdentifier(timpl.getQualifiedName())) ;
	mainImplCode.addOutputNewline(GenerationUtilsC.THREAD_SUFFIX + ';') ;
	mainImplCode
    .addOutput("  CREATE_ERROR_HANDLER (tattr.ENTRY_POINT,");
	mainImplCode
    .addOutput("8192,");
    mainImplCode
    	    .addOutputNewline("&(ret));");
  }

  private void genThreadDeclarationMainImpl(ThreadSubcomponent thread,
                                            int threadIndex,
                                            UnparseText mainImplCode)
  {
    ThreadImplementation timpl =
          (ThreadImplementation) thread.getComponentImplementation() ;
    mainImplCode.addOutput("  tattr.ENTRY_POINT = ") ;
    mainImplCode.addOutput(GenerationUtilsC
          .getGenerationCIdentifier(timpl.getQualifiedName())) ;
    mainImplCode.addOutputNewline(GenerationUtilsC.THREAD_SUFFIX + ';') ;
    String period = null ;
    String deadline = null ;
    String timeCapacity = null ;

    Long value = PropertyUtils.getIntValue(thread, "Period") ;
    if(value != null)
    {
      period = Long.toString(value) ;
      mainImplCode.addOutput("  tattr.PERIOD = ") ;
      mainImplCode.addOutputNewline(period + ';') ;
    }
    else
    {
      // If period is not set, don't generate.
      period = null ;
    }
    
    value = PropertyUtils.getIntValue(thread, "Deadline") ;
    if(value != null)
    {
      deadline = Long.toString(value) ;
    }
    else
    {
      // If deadline is not set, use period instead.
      deadline = period ;
    }

    // If period and deadline are not set , don't generate.
    if(deadline != null)
    {
      mainImplCode.addOutput("  tattr.DEADLINE = ") ;
      mainImplCode.addOutputNewline(deadline + ';') ;
    }

    NumberValue nbValue =
        PropertyUtils.getMaxRangeValue(thread, "Compute_Execution_Time") ;
    if(nbValue != null)
    {
      Double d = nbValue.getScaledValue("ms");
      timeCapacity = Integer.toString(d.intValue()) ;
      mainImplCode.addOutput("  tattr.TIME_CAPACITY = ") ;
      mainImplCode.addOutputNewline(timeCapacity + ';') ;
    }
    else
    {
      // If compute execution time is not set, don't generate.
      timeCapacity = null ;
    }
    
    String priority;
    
    value = PropertyUtils.getIntValue(thread, "Priority") ;
    if(value != null)
    {
      priority = Long.toString(value) ;
      mainImplCode.addOutput("  tattr.BASE_PRIORITY = ") ;
      mainImplCode.addOutputNewline(priority + ';') ;
    }
    else
    {
      // If priority is not set, don't generate.
      priority = null ;
    }
   
    mainImplCode
    	  .addOutputNewline("  strcpy(tattr.NAME, \""+thread.getName()+"\");");
    mainImplCode
          .addOutput("  CREATE_PROCESS (&(tattr), &(arinc_threads[") ;
    mainImplCode.addOutput(Integer.toString(threadIndex)) ;
    mainImplCode.addOutputNewline("]), &(ret));") ;
    
    mainImplCode
    	  .addOutput("  START (arinc_threads[") ;
    mainImplCode.addOutput(Integer.toString(threadIndex)) ;
    mainImplCode.addOutputNewline("], &(ret));") ;
  }
  
  private void genBlackboardMainImpl(UnparseText mainImplCode,
                                     ProcessProperties pp)
  {
    // For each blackboard
    for(BlackBoardInfo info : pp.blackboardInfo)
    {
      
      mainImplCode.addOutput("  CREATE_BLACKBOARD (\"") ;
      mainImplCode.addOutput(info.id) ;
      mainImplCode.addOutput("\", sizeof (" +info.dataType+
      		"), &(") ;
      mainImplCode.addOutput(info.id);
      mainImplCode.addOutputNewline("), &(ret));") ;
    }
  }
  
  private void genSemaphoreMainImpl(UnparseText mainImplCode,
          ProcessProperties pp)
  {
    // For each semaphore
    for(String info : pp.semaphoreNames)
    {
      mainImplCode.addOutput("  CREATE_SEMAPHORE (\"") ;
      mainImplCode.addOutput(info) ;
      mainImplCode.addOutput("\", 1, 1, PRIORITY, &") ;
      mainImplCode.addOutput(info);
      mainImplCode.addOutputNewline(", &(ret));") ;
    }
  }
  
  private void genMainImpl(ProcessImplementation process,
                           UnparseText mainImplCode,
                           ProcessProperties pp)
  {
    EList<ThreadSubcomponent> lthreads =
                                         process.getOwnedThreadSubcomponents() ;
    
    // Included files.
    genFileIncludedMainImpl(mainImplCode) ;
    
    // Global files.
    genGlobalVariablesMainImpl(process, lthreads, mainImplCode, pp);
    
    // main function declaration.
    mainImplCode.addOutputNewline(GenerationUtilsC
          .generateSectionTitle("MAIN")) ;
    mainImplCode.addOutputNewline("int main ()") ;
    mainImplCode.addOutputNewline("{") ;
    
    mainImplCode.addOutputNewline("  PROCESS_ATTRIBUTE_TYPE tattr;") ;
    mainImplCode.addOutputNewline("  RETURN_CODE_TYPE ret;") ;
    
    // Blackboard declarations.
    genBlackboardMainImpl(mainImplCode, pp) ;
    
    // Semaphore declarations.
    genSemaphoreMainImpl(mainImplCode, pp) ;
    
    // Queue declarations.
    genQueueMainImpl(mainImplCode,pp) ;
    
    // Sample declarations.
    genSampleMainImpl(mainImplCode, pp) ;
    
    // Event declarations.
    genEventMainImpl(mainImplCode, pp) ;
    
    // Buffer declarations.    
    genBufferMainImpl(mainImplCode, pp) ;
    
    // For each declared thread
    // Zero stands for ARINC's IDL thread.
    int threadIndex = 1 ;
    
    // Thread declarations.
    for(ThreadSubcomponent thread : lthreads)
    {
      Boolean foundHM = PropertyUtils.getBooleanValue(thread, "Error_Handling") ;
      if(foundHM == null)
      {
        foundHM = false ;
      }
      
      if(foundHM)
      {
        genThreadErrorHandlerImpl(thread, mainImplCode) ;
      }
      else
      {
        genThreadDeclarationMainImpl(thread, threadIndex, mainImplCode) ;
        threadIndex++ ;
      }
    }
    
    genMainImplEnd(process, mainImplCode);
    
    mainImplCode
          .addOutputNewline("  SET_PARTITION_MODE (NORMAL, &(ret));") ;
    mainImplCode.addOutputNewline("  return (0);") ;
    mainImplCode.addOutputNewline("}") ;
    mainImplCode.addOutputNewline(GenerationUtilsC.generateSectionMark()) ;
  }
  
  protected void genMainImplEnd(ProcessImplementation process,
		  					    UnparseText mainImplCode){}

  
  private ProcessProperties genMainHeader(ProcessImplementation process,
                                            UnparseText mainHeaderCode,
                                            ProcessorProperties processorProp,
                                            ProcessProperties pp)
  {
    List<ThreadSubcomponent> bindedThreads =
                                         process.getOwnedThreadSubcomponents() ;
    
    String guard = GenerationUtilsC.generateHeaderInclusionGuard("main.h") ;
    boolean foundHM = false;
    for(ThreadSubcomponent ts: process.getOwnedThreadSubcomponents())
    {
      for(PropertyAssociation pa: ts.getOwnedPropertyAssociations())
      {
    	if(pa.getProperty().getName().equalsIgnoreCase("Error_Handling"))
    	{
    	  BooleanLiteral bl = (BooleanLiteral) pa.
    			  getOwnedValues().get(0).getOwnedValue();
    	  foundHM = bl.getValue();
    	  if(foundHM)
    		break;
    	}
      }
      if(foundHM)
  		break;
    }
    mainHeaderCode.addOutputNewline(guard) ;
    
    /**** #DEFINE ****/

    mainHeaderCode.addOutputNewline("#define POK_GENERATED_CODE 1") ;

    if(processorProp.consoleFound == true)
    {
      mainHeaderCode.addOutputNewline("#define POK_NEEDS_CONSOLE 1") ;
    }

    if(processorProp.stdioFound == true)
    {
      mainHeaderCode
            .addOutputNewline("#define POK_NEEDS_LIBC_STDIO 1") ;
    }

    if(processorProp.stdlibFound == true)
    {
      mainHeaderCode
            .addOutputNewline("#define POK_NEEDS_LIBC_STDLIB 1") ;
    }
    
    if(foundHM)
    {
      mainHeaderCode
        	.addOutputNewline("#define POK_NEEDS_ARINC653_ERROR 1") ;
      mainHeaderCode
  			.addOutputNewline("#define POK_USE_GENERATED_ERROR_HANDLER 1");
    }
    mainHeaderCode
          .addOutputNewline("#define POK_CONFIG_NB_THREADS " +
                Integer.toString(bindedThreads.size() + 1)) ;
    
    if(pp.hasBlackboard)
    {
      mainHeaderCode
            .addOutputNewline("#define POK_CONFIG_NB_BLACKBOARDS " +
                  pp.blackboardInfo.size()) ;
      mainHeaderCode
            .addOutputNewline("#define POK_NEEDS_ARINC653_BLACKBOARD 1") ;
      
      mainHeaderCode
      .addOutputNewline("#define POK_NEEDS_BLACKBOARDS 1") ;
    }
    if(pp.hasSemaphore)
    {
      mainHeaderCode
        .addOutputNewline("#define POK_NEEDS_ARINC653_SEMAPHORE 1") ;
      mainHeaderCode
        .addOutputNewline("#define POK_CONFIG_ARINC653_NB_SEMAPHORES " +
                 pp.semaphoreNames.size());
    }
    if(pp.hasEvent)
    {
      mainHeaderCode
            .addOutputNewline("#define POK_CONFIG_NB_EVENTS " +
                  pp.eventInfo.size()) ;
      mainHeaderCode
      .addOutputNewline("#define POK_CONFIG_ARINC653_NB_EVENTS " +
            pp.eventInfo.size()) ;
      
      mainHeaderCode
            .addOutputNewline("#define POK_NEEDS_ARINC653_EVENT 1") ;

      mainHeaderCode
      .addOutputNewline("#define POK_NEEDS_EVENTS 1") ;
      
      mainHeaderCode
      .addOutputNewline("#define POK_NEEDS_ARINC653_EVENTS 1") ;
    }
    
    if(pp.hasQueue)
    {
      mainHeaderCode.addOutputNewline("#define POK_NEEDS_ARINC653_QUEUEING 1") ;
      
      // XXX ARBITRARY
      mainHeaderCode.addOutputNewline("#define POK_NEEDS_LIBC_STRING 1");
      mainHeaderCode.addOutputNewline("#define POK_NEEDS_PARTITIONS 1");
      mainHeaderCode.addOutputNewline("#define POK_NEEDS_PROTOCOLS 1") ;
      
    }
    
    if(pp.hasSample)
    {
      mainHeaderCode.addOutputNewline("#define POK_NEEDS_ARINC653_SAMPLING 1");
      // XXX ARBITRARY
      mainHeaderCode.addOutputNewline("#define POK_NEEDS_LIBC_STRING 1");
      mainHeaderCode.addOutputNewline("#define POK_NEEDS_PARTITIONS 1");
      mainHeaderCode.addOutputNewline("#define POK_NEEDS_PROTOCOLS 1") ;
    }

    if(pp.hasBuffer)
    {
      
      mainHeaderCode
            .addOutputNewline("#define POK_CONFIG_NB_BUFFERS " +
                  pp.bufferInfo.size()) ;
      
      mainHeaderCode
      .addOutputNewline("#define POK_NEEDS_BUFFERS 1") ;
      
      mainHeaderCode.addOutputNewline("#define POK_NEEDS_ARINC653_BUFFER 1");
    }
    
    mainHeaderCode
    	.addOutputNewline("#define POK_CONFIG_STACKS_SIZE " +
    			Long.toString(processorProp.requiredStackSizePerPartition.get(process)));
    
    // XXX Is there any condition for the generation of theses directives ?
    // XXX ARBITRARY
    mainHeaderCode
          .addOutputNewline("#define POK_NEEDS_ARINC653_TIME 1") ;
    mainHeaderCode
          .addOutputNewline("#define POK_NEEDS_ARINC653_PROCESS 1") ;
    mainHeaderCode
          .addOutputNewline("#define POK_NEEDS_ARINC653_PARTITION 1") ;
    
    // XXX Is there any condition for the generation of POK_NEEDS_MIDDLEWARE ?
    // XXX ARBITRARY
    mainHeaderCode
          .addOutputNewline("#define POK_NEEDS_MIDDLEWARE 1") ;
    
    // The macro POK_NEEDS_PORTS_VIRTUAL is used to include functions definition
    // create and use virtual ports (for remote communications for instance)
    for(ThreadSubcomponent th : bindedThreads)
    {
      if(th.getSubcomponentType() instanceof BehavioredImplementation)
      {
        BehavioredImplementation bi = (BehavioredImplementation) th.getSubcomponentType();
        if(usesOperation(bi, "pok_port_virtual_create"))
        {
          mainHeaderCode.addOutputNewline("#define POK_NEEDS_PORTS_VIRTUAL");
          break;
        }
      }
    }
    
    for(ThreadSubcomponent th : bindedThreads)
    {
      if(th.getSubcomponentType() instanceof BehavioredImplementation)
      {
        BehavioredImplementation bi = (BehavioredImplementation) th.getSubcomponentType();
        if(usesOperation(bi, "rtl8029_init"))
        {
          mainHeaderCode.addOutputNewline("#define POK_NEEDS_RTL8029");
          mainHeaderCode.addOutputNewline("#define POK_NEEDS_PCI 1");
          mainHeaderCode.addOutputNewline("#define POK_NEEDS_IO 1");
          if(_processorProp.hwAdress!=null)
            mainHeaderCode.addOutputNewline("#define POK_HW_ADDR \""+_processorProp.hwAdress+"\"");
          break;
        }
      }
    }
    
    /**** "#INCLUDE ****/
    
    mainHeaderCode.addOutputNewline("");
    
    // always files included:
    mainHeaderCode.addOutputNewline("#include <arinc653/types.h>");
    mainHeaderCode.addOutputNewline("#include <arinc653/process.h>");
    mainHeaderCode.addOutputNewline("#include <arinc653/partition.h>");
    mainHeaderCode.addOutputNewline("#include <arinc653/time.h>");
    mainHeaderCode.addOutputNewline("#include \"gtypes.h\"");
    
    // conditioned files included:
    
    if(pp.hasBlackboard)
    {
      mainHeaderCode.addOutputNewline("#include <arinc653/blackboard.h>");
    }
    
    if(pp.hasQueue)
    {
      mainHeaderCode.addOutputNewline("#include <arinc653/queueing.h>");
      
      // XXX ARBITRARY
      mainHeaderCode.addOutputNewline("#include <protocols/protocols.h>");
    }
    
    if(foundHM)
      mainHeaderCode.addOutputNewline("#include <arinc653/error.h>");
    
    mainHeaderCode.addOutputNewline("\n#endif") ;
    
    return pp ;
  }

  private void genDeploymentImpl(ProcessorSubcomponent processor,
                                 UnparseText deploymentImplCode,
                                 ProcessorProperties pokProp)
  {
    deploymentImplCode.addOutputNewline("#include <types.h>") ;
    deploymentImplCode.addOutputNewline("#include \"deployment.h\"") ;
    
    String propertyName = "HM_Error_ID_Levels";
    PropertyAssociation pa = PropertyUtils.findPropertyAssociation(propertyName, processor);
    
    if(pa!=null)
    {
      deploymentImplCode.addOutputNewline("void pok_kernel_error");
      deploymentImplCode.incrementIndent();
      deploymentImplCode.incrementIndent();
      deploymentImplCode.addOutputNewline("(uint32_t error)");
      deploymentImplCode.decrementIndent();
      deploymentImplCode.decrementIndent();
      deploymentImplCode.addOutputNewline("{");
      deploymentImplCode.incrementIndent();
      generateErrorIdSelection(processor, deploymentImplCode, null);
      deploymentImplCode.decrementIndent();
      deploymentImplCode.addOutputNewline("}");
    }
    boolean partitionLevelErrors = false;
    
    
    ProcessorImplementation pi = (ProcessorImplementation) processor.getSubcomponentType();
    
    propertyName = "HM_Error_ID_Actions";
    
    
    for(VirtualProcessorSubcomponent vps: pi.getOwnedVirtualProcessorSubcomponents())
    {
      pa = PropertyUtils.findPropertyAssociation(propertyName, vps);
      if(pa!=null)
      {
        partitionLevelErrors = true;
        break;
      }
    }
    
    if(partitionLevelErrors==false)
      return;
    
    partitionId=0;
    deploymentImplCode.addOutputNewline("void pok_partition_error");
    deploymentImplCode.incrementIndent();
    deploymentImplCode.incrementIndent();
    deploymentImplCode.addOutputNewline("(uint8_t partition, uint32_t error)");
    deploymentImplCode.decrementIndent();
    deploymentImplCode.decrementIndent();
    deploymentImplCode.addOutputNewline("{");
    deploymentImplCode.incrementIndent();
    deploymentImplCode.addOutputNewline("switch (partition)");
    deploymentImplCode.addOutputNewline("{");
    deploymentImplCode.incrementIndent();
    for(VirtualProcessorSubcomponent vps: pi.getOwnedVirtualProcessorSubcomponents())
    {
      deploymentImplCode.addOutputNewline("case "+Integer.toString(partitionId)+":");
      deploymentImplCode.incrementIndent();
      generateErrorIdSelection(processor, deploymentImplCode, vps);

      deploymentImplCode.decrementIndent();
      deploymentImplCode.addOutputNewline("break;");
      partitionId++;
    }

    deploymentImplCode.decrementIndent();
    deploymentImplCode.addOutputNewline("}");
    
    deploymentImplCode.decrementIndent();
    deploymentImplCode.addOutputNewline("}");
  }
  
  private void generateErrorIdSelection(NamedElement ne,
		UnparseText deploymentImplCode,
		VirtualProcessorSubcomponent vps) {
    deploymentImplCode.addOutputNewline("switch (error)");
    deploymentImplCode.addOutputNewline("{");
    deploymentImplCode.incrementIndent();
    
    String propertyName = "HM_Error_ID_Levels";
    PropertyAssociation pa = PropertyUtils.findPropertyAssociation(propertyName, ne);

    if (pa != null) {
      Property p = pa.getProperty();
      if (p.getName().equalsIgnoreCase(propertyName)) {
        List<ModalPropertyValue> values = pa.getOwnedValues();
        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();
          if (expr instanceof ListValue) {
            ListValue lv = (ListValue) expr;
            for (PropertyExpression pe : lv.getOwnedListElements()) {
              String level = null;
              String errorCode = null;
              long errorIdentifier = -1;
              
              if(pe instanceof RecordValue)
              {
                RecordValue rv = (RecordValue) pe;
                for(BasicPropertyAssociation bpa: rv.getOwnedFieldValues())
                {
                  if(bpa.getProperty().getName().equalsIgnoreCase("ErrorIdentifier"))
                    errorIdentifier = ((IntegerLiteral) bpa.getValue()).getValue();
                  else if(bpa.getProperty().getName().equalsIgnoreCase("ErrorLevel"))
                  {
                    NamedValue nv = (NamedValue) bpa.getValue();
                    level = ((EnumerationLiteral) nv.getNamedValue()).getName();
                  }
                  else if(bpa.getProperty().getName().equalsIgnoreCase("ErrorCode"))
                  {
                    NamedValue nv = (NamedValue) bpa.getValue();
                    errorCode = ((EnumerationLiteral) nv.getNamedValue()).getName();
                  }
                }
              }
              if(level==null)
                continue;
              if(level.equalsIgnoreCase("Module_Level") && vps!=null)
                continue;
              if(level.equalsIgnoreCase("Partition_Level") && vps==null)
                continue;
              if(level.equalsIgnoreCase("Process_Level"))
                continue;
              
              String pokErrorId="POK_ERROR_KIND_INVALID";
              //Module_Config
              if(errorCode.equalsIgnoreCase("Module_Config"))
              {
                pokErrorId = "POK_ERROR_KIND_KERNEL_CONFIG";
              }
              //Module_Init
              if(errorCode.equalsIgnoreCase("Module_Init"))
              {
                pokErrorId = "POK_ERROR_KIND_KERNEL_INIT";
              }
              //Module_Scheduling
              if(errorCode.equalsIgnoreCase("Module_Scheduling"))
              {
                pokErrorId = "POK_ERROR_KIND_KERNEL_SCHEDULING";
              }
              //Partition_Scheduling
              else if(errorCode.equalsIgnoreCase("Partition_Scheduling"))
              {
                pokErrorId = "POK_ERROR_KIND_PARTITION_SCHEDULING";
              }
              //Partition_Config
              else if(errorCode.equalsIgnoreCase("Partition_Config"))
              {
                pokErrorId = "POK_ERROR_KIND_PARTITION_CONFIGURATION";
              }
              //Partition_Handler
              else if(errorCode.equalsIgnoreCase("Partition_Handler"))
              {
                pokErrorId = "POK_ERROR_KIND_PARTITION_HANDLER";
              }
              //Partition_Init
              else if(errorCode.equalsIgnoreCase("Partition_Init"))
              {
                pokErrorId = "POK_ERROR_KIND_PARTITION_INIT";
              }
              //Deadline_Miss
              else if(errorCode.equalsIgnoreCase("Deadline_Miss"))
              {
                pokErrorId = "POK_ERROR_KIND_DEADLINE_MISSED";
              }
              //Application_Error
              else if(errorCode.equalsIgnoreCase("Application_Error"))
              {
                pokErrorId = "POK_ERROR_KIND_APPLICATION_ERROR";
              }
              //Numeric_Error
              else if(errorCode.equalsIgnoreCase("Numeric_Error"))
              {
                pokErrorId = "POK_ERROR_KIND_NUMERIC_ERROR";
              }
              //Illegal_Request
              else if(errorCode.equalsIgnoreCase("Illegal_Request"))
              {
                pokErrorId = "POK_ERROR_KIND_ILLEGAL_REQUEST";
              }
              //Stack_Overflow
              else if(errorCode.equalsIgnoreCase("Stack_Overflow"))
              {
                pokErrorId = "POK_ERROR_KIND_STACK_OVERFLOW";
              }
              //Memory_Violation
              else if(errorCode.equalsIgnoreCase("Memory_Violation"))
              {
                pokErrorId = "POK_ERROR_KIND_MEMORY_VIOLATION";
              }
              //Hardware_Fault
              else if(errorCode.equalsIgnoreCase("Hardware_Fault"))
              {
                pokErrorId = "POK_ERROR_KIND_HARDWARE_FAULT";
              }
              //Power_Fail
              else if(errorCode.equalsIgnoreCase("Power_Fail"))
              {
                pokErrorId = "POK_ERROR_KIND_POWER_FAIL";
              }
              deploymentImplCode.addOutputNewline("case "+pokErrorId+":");
              deploymentImplCode.addOutputNewline("{");
              deploymentImplCode.incrementIndent();
              
              
              
              if(vps==null)
              {
                String actionId = getActionId(ne, errorIdentifier);
                genModuleErrorAction(deploymentImplCode,actionId);
              }
              else
              {  
                String actionId = getActionId(vps, errorIdentifier);
                genPartitionErrorAction(deploymentImplCode, actionId);
              }
              
              deploymentImplCode.addOutputNewline("break;");
              deploymentImplCode.decrementIndent();
              deploymentImplCode.addOutputNewline("}");
            }
            
          }
        }
      }
    }
    
    deploymentImplCode.decrementIndent();
    deploymentImplCode.addOutputNewline("}");
  }

  private String getActionId(NamedElement ne, long errorIdentifier)
  {
    String propertyName = "HM_Error_ID_Actions";
    PropertyAssociation pa = PropertyUtils.findPropertyAssociation(propertyName, ne);

    if (pa != null) {
      Property p = pa.getProperty();
      if (p.getName().equalsIgnoreCase(propertyName)) {
        List<ModalPropertyValue> values = pa.getOwnedValues();
        if (values.size() == 1) {
          ModalPropertyValue v = values.get(0);
          PropertyExpression expr = v.getOwnedValue();
          if (expr instanceof ListValue) {
            ListValue lv = (ListValue) expr;
            for (PropertyExpression pe : lv.getOwnedListElements()) {
              long errorId=-1;
              String action=null;
              if(pe instanceof RecordValue)
              {
                RecordValue rv = (RecordValue) pe;
                for(BasicPropertyAssociation bpa: rv.getOwnedFieldValues())
                {
                  if(bpa.getProperty().getName().equalsIgnoreCase("ErrorIdentifier"))
                    errorId = ((IntegerLiteral) bpa.getValue()).getValue();
                  else if(bpa.getProperty().getName().equalsIgnoreCase("Action"))
                  {
                    StringLiteral sl = (StringLiteral) bpa.getValue();
                    action = sl.getValue();
                  }
                }
              }
              if(errorId==errorIdentifier && action!=null)
                return action;
            }
          }
        }
      }
    }
    return "";
  }

  private void genModuleErrorAction(UnparseText deploymentImplCode, String actionId) {
    // Ignore, Stop, Reset
    if(actionId.equalsIgnoreCase("Stop"))
    {
      deploymentImplCode.addOutputNewline("pok_kernel_stop();");
    }
    else if(actionId.equalsIgnoreCase("Reset"))
    {
      deploymentImplCode.addOutputNewline("pok_kernel_restart();");
    }
    else if(actionId.equalsIgnoreCase("Ignore"))
    {
      deploymentImplCode.addOutputNewline("// Ignore");
    }
  }

  private void genPartitionErrorAction(UnparseText deploymentImplCode, String actionId)
  {
    // Ignore, Partition_Stop, Warm_Restart, Cold_Restart
    if(actionId.equalsIgnoreCase("Partition_Stop"))
    {
      deploymentImplCode.addOutputNewline("pok_partition_set_mode("+partitionId+", POK_PARTITION_MODE_STOPPED);");
    }
    else if(actionId.equalsIgnoreCase("Warm_Restart"))
    {
      deploymentImplCode.addOutputNewline("pok_partition_set_mode("+partitionId+", POK_PARTITION_MODE_RESTART);");
    }
    else if(actionId.equalsIgnoreCase("Cold_Restart"))
    {
      deploymentImplCode.addOutputNewline("pok_partition_set_mode("+partitionId+", POK_PARTITION_MODE_RESTART);");
    }
    else if(actionId.equalsIgnoreCase("Ignore"))
    {
      deploymentImplCode.addOutputNewline("// Ignore");
    }
  }
  
  private void genDeploymentHeader(ProcessorSubcomponent processor,
                                   UnparseText deploymentHeaderCode,
                                   RoutingProperties routing)
                                                      throws GenerationException
  {
    _processorProp = new ProcessorProperties() ;
    
    String guard = GenerationUtilsC.generateHeaderInclusionGuard("deployment.h") ;

    deploymentHeaderCode.addOutputNewline(guard) ;

    deploymentHeaderCode.addOutputNewline("#include \"routing.h\"") ;
    // POK::Additional_Features => (libc_stdio,libc_stdlib,console);
    // this property is associated to virtual processors
    List<VirtualProcessorSubcomponent> bindedVPS =
          new ArrayList<VirtualProcessorSubcomponent>() ;

    for(Subcomponent sub : processor.getComponentImplementation()
          .getOwnedSubcomponents())
      if(sub instanceof VirtualProcessorSubcomponent)
      {
        bindedVPS.add((VirtualProcessorSubcomponent) sub) ;
      }

    List<String> additionalFeatures ;
    
    // Try to fetch POK properties: Additional_Features.
    for(VirtualProcessorSubcomponent vps : bindedVPS)
    {
    	additionalFeatures =
    			PropertyUtils.getStringListValue(vps, "Additional_Features") ;
    	if(additionalFeatures==null)
    	{
    		additionalFeatures =
    				PropertyUtils.getStringListValue(vps.getSubcomponentType(), "Additional_Features") ;
    		if(additionalFeatures==null && 
    				vps.getSubcomponentType() instanceof VirtualProcessorImplementation)
    		{
    			VirtualProcessorImplementation vpi = 
    					(VirtualProcessorImplementation) vps.getSubcomponentType();
    			additionalFeatures =
    					PropertyUtils.getStringListValue(vpi, "Additional_Features") ;
    			if(additionalFeatures==null)
    			{
    				String errMsg = "cannot fecth Additional_Features for \'" +
    						vps.getName() + '\'' ;
    				_LOGGER.error(errMsg) ;
    				ServiceProvider.SYS_ERR_REP.error(errMsg, true) ;
    			}
    		}
    	}
    	else
    	{
    		for(String s : additionalFeatures)
    		{
    			if(s.equalsIgnoreCase("console"))
    			{
    				// POK_NEEDS_CONSOLE has to be in both kernel's deployment.h
    				deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_CONSOLE 1") ;
    				_processorProp.consoleFound = true ;
    				break ;
    			}
    		}

    		for(String s : additionalFeatures)
    		{
    			if(s.equalsIgnoreCase("libc_stdio"))
    			{
    				_processorProp.stdioFound = true ;
    				break ;
    			}
    		}

    		for(String s : additionalFeatures)
    		{
    			if(s.equalsIgnoreCase("libc_stdlib"))
    			{
    				_processorProp.stdlibFound = true ;
    				break ;
    			}
    		}
    	}
    }

    String hwAddr = PropertyUtils.getStringValue(processor, "Address");
    if(hwAddr!=null && false==hwAddr.isEmpty())
      _processorProp.hwAdress = hwAddr;
    
    // TODO: the integer ID in this macro must be set carefully to respect the
    // routing table defined in deployment.c files in the generated code for a
    // partition.
    int id =
          ((SystemImplementation) processor.eContainer())
                .getOwnedProcessorSubcomponents().indexOf(processor) ;
    deploymentHeaderCode.addOutputNewline("#define POK_CONFIG_LOCAL_NODE " +
          Integer.toString(id)) ;
    
    String address = PropertyUtils.getStringValue(processor, "Address");
    if(address!=null)
    {
      deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_PCI 1");
      deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_IO 1");
      deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_PORTS_VIRTUAL 1");
    }
    // POK_GENERATED_CODE 1 always true in our usage context
    deploymentHeaderCode.addOutputNewline("#define POK_GENERATED_CODE 1") ;

    deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_GETTICK 1") ;
    // POK_NEEDS_THREADS 1 always true in our usage context.
    deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_THREADS 1") ;

    if(bindedVPS.size() > 0)
    {
      deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_PARTITIONS 1") ;
    }

    if(RamsesConfiguration.IS_DEBUG_MODE)
    {
      deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_DEBUG 1") ;
    }
    
    deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_SCHED 1") ;
    // The maccro POK_CONFIG_NB_PARTITIONS indicates the amount of partitions in
    // the current system.It corresponds to the amount of process components in
    // the system.
    List<ProcessSubcomponent> bindedProcess =
          GeneratorUtils.getBindedProcesses(processor) ;
    deploymentHeaderCode.addOutputNewline("#define POK_CONFIG_NB_PARTITIONS " +
          Integer.toString(bindedVPS.size())) ;
    List<ThreadSubcomponent> bindedThreads =
          new ArrayList<ThreadSubcomponent>() ;
    List<Integer> threadNumberPerPartition = new ArrayList<Integer>() ;

    for(ProcessSubcomponent p : bindedProcess)
    {
      ProcessImplementation processImplementation =
            (ProcessImplementation) p.getComponentImplementation() ;
      bindedThreads.addAll(processImplementation.getOwnedThreadSubcomponents()) ;
      threadNumberPerPartition.add(Integer.valueOf(processImplementation
            .getOwnedThreadSubcomponents().size())) ;
    }
    for(ThreadSubcomponent th : bindedThreads)
    {
      String dispatchProtocol = PropertyUtils.getEnumValue(th, "Dispatch_Protocol") ;
      if(dispatchProtocol != null)
      {
        if(dispatchProtocol.equalsIgnoreCase("sporadic"))
        {
          deploymentHeaderCode
                .addOutputNewline("#define POK_NEEDS_THREAD_SLEEP 1") ;
          break ;
        }
      }
      else
      {
        String errMsg =  "cannot fetch the Dispatch_Protocol for \'"+
                                    th.getName() + '\'' ;
        _LOGGER.error(errMsg);
        ServiceProvider.SYS_ERR_REP.error(errMsg, true);
      }
    }
    
    //  The macro POK_CONFIG_NB_THREADS indicates the amount of threads used in 
    //  the kernel.It comprises the tasks for the partition and the main task of 
    //  each partition that initialize all ressources.
    deploymentHeaderCode.addOutputNewline("#define POK_CONFIG_NB_THREADS " +
          Integer.toString(2 + bindedProcess.size() + bindedThreads.size())) ;
    //  The macro POK_CONFIG_NB_PARTITIONS_NTHREADS indicates the amount of 
    //  threads in each partition we also add an additional process that 
    //  initialize all partition's entities (communication, threads, ...)
    deploymentHeaderCode.addOutput("#define POK_CONFIG_PARTITIONS_NTHREADS {") ;

    int idx = 0 ;
    for(Integer i : threadNumberPerPartition)
    {

      deploymentHeaderCode.addOutput(Integer.toString(i + 1)) ;

      if(idx != (threadNumberPerPartition.size() - 1))
      {
        deploymentHeaderCode.addOutput(",") ;
      }
      idx++ ;
    }

    deploymentHeaderCode.addOutputNewline("}") ;

    for(VirtualProcessorSubcomponent vps : bindedVPS)
    {
      boolean foundSched = false ;

      PropertyAssociation pa = PropertyUtils.findPropertyAssociation(
                                                    "Scheduling_Protocol", vps);
      if(pa!=null)
      {
        ModalPropertyValue v = pa.getOwnedValues().get(0);
		ListValue lv = (ListValue) v.getOwnedValue();
		NamedValue nv = (NamedValue) lv.getOwnedListElements().get(0);
		EnumerationLiteral el = (EnumerationLiteral) nv.getNamedValue();
		String requiredScheduler = el.getName();
		if(requiredScheduler.equalsIgnoreCase("RMS") && foundSched == false)
        {
          foundSched = true ;
          deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_SCHED_RMS 1") ;
        }
        else if(requiredScheduler.equalsIgnoreCase("Round_Robin_Protocol") && foundSched == false)
        {
          foundSched = true ;
          deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_SCHED_RR 1") ;
        }
      }
      else
      {
        String errMsg = "Scheduling_Protocol is not provided for \'" +
                             vps.getName() + '\'' ;
        _LOGGER.error(errMsg);
        ServiceProvider.SYS_ERR_REP.error(errMsg, true);
      }
    }

    // TODO: define POK_CONFIG_PARTITIONS_SCHEDULER: sched algo associated to 
    // each partition
    deploymentHeaderCode.addOutput("#define POK_CONFIG_PARTITIONS_SCHEDULER {") ;

    for(VirtualProcessorSubcomponent vps : bindedVPS)
    {
      PropertyAssociation pa = PropertyUtils.findPropertyAssociation(
                                                    "Scheduling_Protocol", vps);
      if(pa!=null)
      {
        ModalPropertyValue v = pa.getOwnedValues().get(0);
  		ListValue lv = (ListValue) v.getOwnedValue();
  		NamedValue nv = (NamedValue) lv.getOwnedListElements().get(0);
  		EnumerationLiteral el = (EnumerationLiteral) nv.getNamedValue();
  		String requiredScheduler = el.getName();
        if(requiredScheduler.equalsIgnoreCase("Round_Robin_Protocol"))
        {
          deploymentHeaderCode.addOutput("POK_SCHED_RR") ;
        }
        else if(requiredScheduler.equalsIgnoreCase("RMS"))
        {
          deploymentHeaderCode.addOutput("POK_SCHED_RMS") ;
        }
        if(bindedVPS.indexOf(vps) != bindedVPS.size() - 1)
        {
          deploymentHeaderCode.addOutput(",") ;
        }
      }
      else
      {
        String errMsg =  "cannot fetch the Scheduling_Protocol for \'" + vps.getName() + '\'';
        _LOGGER.error(errMsg);
        ServiceProvider.SYS_ERR_REP.error(errMsg, true);
      }
    }

    deploymentHeaderCode.addOutputNewline("}") ;

    boolean queueAlreadyAdded = false ;
    boolean sampleAlreadyAdded = false ;
    boolean bufferAlreadyAdded = false ;
    for(ProcessSubcomponent ps : bindedProcess)
    {
      ProcessImplementation process =
            (ProcessImplementation) ps.getComponentImplementation() ;
      if(!_processorProp.processProperties.containsKey(process))
      {
    	StringBuilder sb = new StringBuilder(process.getQualifiedName());
        ProcessProperties pp = new ProcessProperties(sb.substring(0, sb.lastIndexOf("::")+2)) ;
        _processorProp.processProperties.put(process, pp) ;
        findCommunicationMechanism(process, pp) ;
      }
      ProcessProperties pp = _processorProp.processProperties.get(process) ;
      if(pp.hasBlackboard || pp.hasBuffer || pp.hasEvent || pp.hasSemaphore)
      {
        deploymentHeaderCode
              .addOutputNewline("#define POK_NEEDS_LOCKOBJECTS 1") ;
      }
      
      
      if(pp.hasQueue && false == queueAlreadyAdded)
      {
        deploymentHeaderCode
                    .addOutputNewline("#define POK_NEEDS_PORTS_QUEUEING 1");
             
        queueAlreadyAdded = true ;
      }
      
      if(pp.hasSample && false == sampleAlreadyAdded)
      {
        deploymentHeaderCode
                    .addOutputNewline("#define POK_NEEDS_PORTS_SAMPLING 1");
            
        sampleAlreadyAdded = true ;
      }
      
      if(pp.hasBuffer && false == bufferAlreadyAdded)
      {
        deploymentHeaderCode
                    .addOutputNewline("#define POK_NEEDS_PORTS_BUFFER 1");
             
        bufferAlreadyAdded = true ;
      }
    }

    if(sampleAlreadyAdded || queueAlreadyAdded)
    	deploymentHeaderCode
        .addOutputNewline("#define POK_NEEDS_THREAD_ID 1") ;
    deploymentHeaderCode
          .addOutput("#define POK_CONFIG_PARTITIONS_NLOCKOBJECTS {") ;
    for(ProcessSubcomponent ps : bindedProcess)
    {
      ProcessProperties pp =
            _processorProp.processProperties.get((ProcessImplementation) ps
                  .getComponentImplementation()) ;
      deploymentHeaderCode.addOutput(Integer
            .toString(pp.blackboardInfo.size()
                      + pp.bufferInfo.size()
                      + 3*pp.eventInfo.size() // Seems that an event port needs 3 locks. To be validated
                      + pp.semaphoreNames.size())) ;
      if(bindedProcess.indexOf(ps) < bindedProcess.size() - 1)
      {
        deploymentHeaderCode.addOutput(",") ;
      }
    }
    deploymentHeaderCode.addOutputNewline("}") ;
    //  The maccro POK_CONFIG_PARTTITIONS_SIZE indicates the required amount of 
    //  memory for each partition.This value was deduced from the property 
    //  POK::Needed_Memory_Size of each process
    // comes from property POK::Needed_Memory_Size => XXX Kbyte;
    List<Long> memorySizePerPartition = new ArrayList<Long>() ;

    for(ProcessSubcomponent p : bindedProcess)
    {
      Long value = PropertyUtils.getIntValue(p, "Needed_Memory_Size") ;
      if(value != null)
      {
        memorySizePerPartition.add(value) ;
      }
      else
      {
        String warnMsg =  "cannot fetch Needed_Memory_Size for \'"+
                          p.getName() + "\'. try to fetch the partition memory";
        _LOGGER.warn(warnMsg);
        ServiceProvider.SYS_ERR_REP.warning(warnMsg, true);
        
        MemorySubcomponent bindedMemory =
              (MemorySubcomponent) GeneratorUtils
                    .getDeloymentMemorySubcomponent(p) ;
        value = PropertyUtils.getIntValue(bindedMemory, "Memory_Size") ;
        if(value != null)
        {
          memorySizePerPartition.add(value) ;
        }
        else
        {
          String errMsg = "cannot fetch the partition memory (Memory_Size) for \'"+
                                                  bindedMemory.getName() + '\'';
          _LOGGER.error(errMsg);
          ServiceProvider.SYS_ERR_REP.error(errMsg, true);
        }
      }
    }

    deploymentHeaderCode.addOutput("#define POK_CONFIG_PARTITIONS_SIZE {") ;
    idx = 0 ;
    for(Long l : memorySizePerPartition)
    {
      deploymentHeaderCode.addOutput(Long.toString(l)) ;

      if(idx != memorySizePerPartition.size() - 1)
      {
        deploymentHeaderCode.addOutput(",") ;
      }
      idx++ ;
    }

    deploymentHeaderCode.addOutputNewline("}") ;
    
    NamedElement rootSystem = getRootSystem((AadlPackage)
                                            processor.getContainingClassifier().eContainer().eContainer());
    PropertyAssociation moduleSchedulePA = PropertyUtils.findPropertyAssociation
                                                ("Module_Schedule", rootSystem);
    if(moduleSchedulePA == null)
    {
      String errMsg =  "cannot fetch Module_Schedule for \'"+
          processor.getName() + '\'' ;
      _LOGGER.error(errMsg);
      ServiceProvider.SYS_ERR_REP.error(errMsg, true);
    }
    ModalPropertyValue mpv = moduleSchedulePA.getOwnedValues().get(0);
    ListValue lv = (ListValue) mpv.getOwnedValue();
    
    deploymentHeaderCode
    .addOutputNewline("#define POK_CONFIG_SCHEDULING_NBSLOTS " +
        Integer.toString(lv.getOwnedListElements().size())) ;

    
    deploymentHeaderCode.addOutput("#define POK_CONFIG_SCHEDULING_SLOTS {") ;
    idx = 0 ;
    for(PropertyExpression pe : lv.getOwnedListElements())
    {
      RecordValue rv = (RecordValue) pe;
      for(BasicPropertyAssociation bpa: rv.getOwnedFieldValues())
      {
        if(bpa.getProperty().getName().equalsIgnoreCase("Duration"))
        {
          IntegerLiteral il =  (IntegerLiteral) bpa.getValue();
          deploymentHeaderCode.addOutput(Long.toString(il.getValue())) ;
          if(idx != lv.getOwnedListElements().size() - 1)
          {
            deploymentHeaderCode.addOutput(",") ;
          }
          idx++ ;
        }
      }
    }

    deploymentHeaderCode.addOutputNewline("}") ;
    idx = 0;
    deploymentHeaderCode.addOutput("#define POK_CONFIG_SCHEDULING_SLOTS_ALLOCATION {") ;
    for(PropertyExpression pe : lv.getOwnedListElements())
    {
      RecordValue rv = (RecordValue) pe;
      for(BasicPropertyAssociation bpa: rv.getOwnedFieldValues())
      {
        if(bpa.getProperty().getName().equalsIgnoreCase("Partition"))
        {
          ReferenceValue sAllocation = (ReferenceValue) bpa.getValue();
          int index = sAllocation.getContainmentPathElements().size()-1; 
          int referencedComponentId = bindedVPS.indexOf(sAllocation.getContainmentPathElements().get(index).getNamedElement()) ;
          
          deploymentHeaderCode.addOutput(Integer.toString(referencedComponentId)) ;
          if(idx != lv.getOwnedListElements().size() - 1)
          {
            deploymentHeaderCode.addOutput(",") ;
          }
          idx++ ;
        }
      }
    }
    deploymentHeaderCode.addOutputNewline("}") ;
    
    Long majorFrame =
        PropertyUtils.getIntValue(processor, "Module_Major_Frame") ;
    if(majorFrame != null)
    {
      deploymentHeaderCode
      .addOutputNewline("#define POK_CONFIG_SCHEDULING_MAJOR_FRAME " +
            Long.toString(majorFrame)) ;
    }
    else
    {
      String errMsg = "cannot fetch Module_Major_Frame for \'" +
                                     processor.getName() + '\'' ;
      _LOGGER.error(errMsg);
      ServiceProvider.SYS_ERR_REP.error(errMsg, true);
    }
    
    String portsFlushTime = PropertyUtils.getEnumValue(processor, "Ports_Flush_Time");
    if(portsFlushTime != null)
    {
      if (portsFlushTime.equalsIgnoreCase("Minor_Frame_Switch"))
      {
        Long minorFrame = PropertyUtils.getIntValue(processor, "Module_Minor_Frame");
        if(minorFrame != null)
        {
          deploymentHeaderCode
          .addOutputNewline("#define POK_FLUSH_PERIOD " + 
              Long.toString(minorFrame)) ;
        }
        else
        {
          String errMsg =  "Ports_Flush_Time was set to Minor_Frame_Switch for \'"
                  +processor.getName()+"\', but cannot fetch Module_Minor_Frame" ;
            _LOGGER.error(errMsg);
            ServiceProvider.SYS_ERR_REP.error(errMsg, true);
        }
      }
      else if (portsFlushTime.equalsIgnoreCase("Partition_Slot_Switch"))
        deploymentHeaderCode
          .addOutputNewline("#define POK_NEEDS_FLUSH_ON_WINDOWS") ;
    }
    else
    {
      String warnMsg = "Ports_Flush_Time was not set on \'"+processor.getName()
          +"\', default flush policy will be used" ;
      _LOGGER.warn(warnMsg);
      ServiceProvider.SYS_ERR_REP.warning(warnMsg, true);
    }

    for(ProcessSubcomponent ps : bindedProcess)
    {
      ProcessImplementation processImplementation =
            (ProcessImplementation) ps.getComponentImplementation() ;

      for(ThreadSubcomponent ts : processImplementation.getOwnedThreadSubcomponents())
      {
        Long partitionStack =
            PropertyUtils.getIntValue(ts, "Stack_Size") ;
      
        if(partitionStack != null)
        {
          _processorProp.requiredStackSize += partitionStack ;
          _processorProp.requiredStackSizePerPartition.put(processImplementation,
                                                           partitionStack) ;
        }
        else
        {
          _processorProp.requiredStackSize += DEFAULT_REQUIRED_STACK_SIZE ;
          _processorProp.requiredStackSizePerPartition.put(processImplementation,
                                                           DEFAULT_REQUIRED_STACK_SIZE) ;
          
          String warnMsg = "Set default required stack size for \'"+processImplementation.getName()
              +"\', default flush policy will be used" ;
          _LOGGER.warn(warnMsg);
          ServiceProvider.SYS_ERR_REP.warning(warnMsg, true);
        }
      }
    }

    deploymentHeaderCode.addOutputNewline("#define POK_CONFIG_STACKS_SIZE " +
          Long.toString(_processorProp.requiredStackSize)) ;
    
    // XXX is that right ???
    if(routing.buses.isEmpty())
    {
      deploymentHeaderCode.addOutputNewline("#define POK_CONFIG_NB_BUSES 0");
    }
    else
    {
      deploymentHeaderCode.addOutputNewline("#define POK_CONFIG_NB_BUSES 1");
    }

    
    boolean needErrorHandler=false,needPartitionErrorHandler=false,needKernelErrorHandler = false;
    
    if(PropertyUtils.findPropertyAssociation("HM_Error_ID_Levels", processor) != null
        && PropertyUtils.findPropertyAssociation("HM_Error_ID_Actions", processor) != null)
    {
      needErrorHandler = true;
      needKernelErrorHandler = true;
    }
    else
    {
      //do nothing
    }
    
    ProcessorImplementation pi = (ProcessorImplementation) processor.getSubcomponentType();
    for(VirtualProcessorSubcomponent vps: pi.getOwnedVirtualProcessorSubcomponents())
    {
      if(PropertyUtils.findPropertyAssociation("HM_Error_ID_Actions", vps) != null)
      {
        needErrorHandler = true;
        needPartitionErrorHandler = true;
      }
      else
      {
        //do nothing
      }
    }
    
    for(ProcessSubcomponent ps : bindedProcess)
    {
      if(needErrorHandler)
        break ;
      ProcessImplementation procImpl =
            (ProcessImplementation) ps.getSubcomponentType() ;
      for(ThreadSubcomponent ts : procImpl.getOwnedThreadSubcomponents())
      {
        if(PropertyUtils.findPropertyAssociation("HM_Error_ID_Actions", ts) != null)
        {
          needErrorHandler = true ;
          break ;
        }
        else
        {
          //do nothing
        }
      }
    }
    
    if(needErrorHandler)
    {
      deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_ERROR_HANDLING 1");
      if(needKernelErrorHandler)
        deploymentHeaderCode.addOutputNewline("#define POK_USE_GENERATED_KERNEL_ERROR_HANDLER 1");
      if(needPartitionErrorHandler)
        deploymentHeaderCode.addOutputNewline("#define POK_USE_GENERATED_PARTITION_ERROR_HANDLER 1");
      deploymentHeaderCode.addOutputNewline("#include \"core/partition.h\"") ;
      deploymentHeaderCode.addOutputNewline("#include \"core/error.h\"") ;
      deploymentHeaderCode.addOutputNewline("#include \"core/kernel.h\"") ;
    }

    
    genDeploymentHeaderEnd(deploymentHeaderCode);
    
    deploymentHeaderCode.addOutputNewline("#endif") ;
    
  }                                            

  private NamedElement getRootSystem(AadlPackage pkg)
  {
    for(Classifier c: pkg.getOwnedPublicSection().getOwnedClassifiers())
      if(c instanceof SystemImplementation && isRoot(pkg, (SystemImplementation) c))
        return c;
    return null;
  }


  private boolean isRoot(AadlPackage pkg, SystemImplementation sys)
  {
    for(Classifier c: pkg.getOwnedPublicSection().getOwnedClassifiers())
      if(c instanceof SystemImplementation)
      {
        SystemImplementation potentialRoot = (SystemImplementation) c;
        for(SystemSubcomponent subSys: potentialRoot.getOwnedSystemSubcomponents())
          if(subSys.getSubcomponentType().equals(sys))
            return false;
      }
    return true;
  }


  private boolean usesOperation(BehavioredImplementation bi, 
                                String subprogramName)
  {
    for(SubprogramCallSequence scs: bi.getOwnedSubprogramCallSequences())
    {
      for(SubprogramCall sc: scs.getOwnedSubprogramCalls())
      {
        Subprogram s = (Subprogram) sc.getCalledSubprogram();
        if(s.getName().equals(subprogramName))
        {
          return true;
        }
        else if(s instanceof SubprogramType)
        {
          SubprogramType st = (SubprogramType) s;
          if(extendsSubprogramType(st,subprogramName))
            return true;
        }
        else if(s instanceof SubprogramImplementation)
        {
          SubprogramImplementation si = (SubprogramImplementation) s;
          if(extendsSubprogramImpl(si,subprogramName))
            return true;
        }
        if(s instanceof BehavioredImplementation)
          usesOperation((BehavioredImplementation) s, subprogramName);
      }
    }
    return false;
  }

  private boolean extendsSubprogramType(SubprogramType st, 
                                   String subprogramName)
  {
    if(st.getOwnedExtension()!=null)
    {
      SubprogramType parent = (SubprogramType) st.getOwnedExtension().getExtended();
      if(parent.getName().equals(subprogramName))
      {
        return true;
      }
      else
        return extendsSubprogramType(parent, subprogramName);
    }
    return false;
  }
  
  private boolean extendsSubprogramImpl(SubprogramImplementation si, 
                                        String subprogramName)
  {
    if(si.getOwnedExtension()!=null)
    {
      SubprogramImplementation parent = (SubprogramImplementation) si.getOwnedExtension().getExtended();
      if(parent.getName().equals(subprogramName))
      {
        return true;
      }
      else
        return extendsSubprogramImpl(parent, subprogramName);
    }
    return false;
  }
  
  protected void genDeploymentHeaderEnd(UnparseText deploymentHeaderCode){}

@Override
  public void setParameters(Map<Enum<?>, Object> parameters)
  {
    String msg = "setParameters not supported" ;
    _LOGGER.fatal(msg);
    throw new UnsupportedOperationException(msg) ;
  }

  public TargetProperties process(SystemImplementation si,
                                  File runtimePath,
                                  File outputDir,
                                  IProgressMonitor monitor)
	     	                                             throws GenerationException
	{
	  SystemInstance system = (SystemInstance) 
                                     HookAccessImpl.getTransformationTrace(si) ;
    
    RoutingProperties routing = new RoutingProperties();
	  routing.setRoutingProperties(system);
	  
	  return routing ;
	  /*
	  for(ComponentInstance subComponent: system.getComponentInstances())
	  {
		  processComponentInstance(subComponent, generatedFilePath, routing);
	  }
	  */
  }
  
  private List<FeatureInstance> getLocalPorts(ComponentInstance processor,
		                                          RoutingProperties routeProp)
	                                                    throws GenerationException
  {
    List<FeatureInstance> localPorts = new ArrayList<FeatureInstance>();
    if(routeProp.processPerProcessor.get(processor).isEmpty())
      return localPorts;
    for(ComponentInstance deployedProcess:routeProp.processPerProcessor.get(processor))
    {
      localPorts.addAll(routeProp.portPerProcess.get(deployedProcess));
    }
    return localPorts;
  }
  
  private List<FeatureInstance> getLocalVirtualPorts(ComponentInstance processor,
                                              RoutingProperties routeProp)
                                                      throws GenerationException
  {
    List<FeatureInstance> localPorts = new ArrayList<FeatureInstance>();
    if(routeProp.processPerProcessor.get(processor).isEmpty())
      return localPorts;
    for(ComponentInstance deployedProcess:routeProp.processPerProcessor.get(processor))
    {
      localPorts.addAll(routeProp.virtualPortPerProcess.get(deployedProcess));
    }
    return localPorts;
  }
  private void genRoutingHeader(ComponentInstance processor,
                                UnparseText routingHeaderCode,
                                RoutingProperties routeProp)
                                                      throws GenerationException
  {
	String guard = GenerationUtilsC.generateHeaderInclusionGuard("routing.h") ;
	routingHeaderCode.addOutput(guard);
	
	if(routeProp.processPerProcessor.get(processor)!=null)
	{
	  int globalPortNb = routeProp.globalPort.size()
	      +routeProp.globalVirtualPort.size();
	  routingHeaderCode.addOutputNewline("#define POK_CONFIG_NB_GLOBAL_PORTS " +
			  Integer.toString(globalPortNb));
		
	  List<FeatureInstance> localPorts = getLocalPorts(processor, routeProp);
	  List<FeatureInstance> localVirtualPorts = getLocalVirtualPorts(processor, routeProp);
	  int localPortNb = localPorts.size()
	      + localVirtualPorts.size();
	  
	  routingHeaderCode.addOutputNewline("#define POK_CONFIG_NB_PORTS " +
			  Integer.toString(localPortNb));

	  routingHeaderCode.addOutputNewline("#define POK_CONFIG_NB_NODES " +
			  Integer.toString(routeProp.processors.size())) ;

	  Set<ComponentInstance> bindedPorcesses = routeProp.processPerProcessor.get(processor);
	  
	  if(!localPorts.isEmpty())
    {
	    routingHeaderCode.addOutput("#define POK_CONFIG_PARTITIONS_PORTS {");
	    generateLocalPortsToPartitionsArray(localPorts, routingHeaderCode, bindedPorcesses);
	    generateVirtualPortsToPartitionsArray(localVirtualPorts, routingHeaderCode, bindedPorcesses, routeProp);
	    routingHeaderCode.addOutputNewline("}");
    }


	  routingHeaderCode.addOutputNewline("typedef enum") ;
	  routingHeaderCode.addOutputNewline("{") ;
	  routingHeaderCode.incrementIndent() ;
	  
	  int idx=0;
	  for(ComponentInstance node : routeProp.processors)
	  {
	    routingHeaderCode.addOutput(AadlToPokCUtils.getComponentInstanceIdentifier(node)) ;
	    routingHeaderCode.addOutput(" = "+Integer.toString(idx));
	    routingHeaderCode.addOutputNewline(",") ;
	    idx++;
	  }
	  routingHeaderCode.decrementIndent() ;
	  routingHeaderCode.addOutputNewline("} pok_node_identifier_t;") ;

	  idx=0;
	  routingHeaderCode.addOutputNewline("typedef enum") ;
	  routingHeaderCode.addOutputNewline("{") ;
	  routingHeaderCode.incrementIndent() ;
	  for(FeatureInstance fi: localPorts)
	  {
	    routingHeaderCode.addOutput(AadlToPokCUtils.getFeatureLocalIdentifier(fi));
	    routingHeaderCode.addOutput(" = "+Integer.toString(idx));
	    routingHeaderCode.addOutputNewline(",") ;
	    idx++;
	  }
	  for(FeatureInstance fi: localVirtualPorts)
    {
      routingHeaderCode.addOutput(AadlToPokCUtils.getFeatureLocalIdentifier(fi)+VIRTUAL_PORT_SUFFIX);
      routingHeaderCode.addOutput(" = "+Integer.toString(idx));
      routingHeaderCode.addOutputNewline(",") ;
      idx++;
    }
	  routingHeaderCode.addOutput("invalid_local_port");
	  routingHeaderCode.addOutputNewline(" = "+Integer.toString(idx));
	  routingHeaderCode.decrementIndent() ;
	  routingHeaderCode.addOutputNewline("} pok_port_local_identifier_t;") ;

	  idx=0;
	  routingHeaderCode.addOutputNewline("typedef enum") ;
	  routingHeaderCode.addOutputNewline("{") ;
	  routingHeaderCode.incrementIndent() ;
	  for(FeatureInstance fi: routeProp.globalPort)
	  {
		  routingHeaderCode.addOutput(AadlToPokCUtils.getFeatureGlobalIdentifier(fi));
		  routingHeaderCode.addOutput(" = "+Integer.toString(idx));
		  routingHeaderCode.addOutputNewline(",") ;
		  idx++;
	  }
	  for(FeatureInstance fi: routeProp.globalVirtualPort)
    {
      routingHeaderCode.addOutput(AadlToPokCUtils.getFeatureGlobalIdentifier(fi)
                                  +VIRTUAL_PORT_SUFFIX);
      routingHeaderCode.addOutput(" = "+Integer.toString(idx));
      routingHeaderCode.addOutputNewline(",") ;
      idx++;
    }
	  routingHeaderCode.decrementIndent() ;
	  routingHeaderCode.addOutputNewline("} pok_port_identifier_t;") ;

	  idx=0;
	  routingHeaderCode.addOutputNewline("typedef enum") ;
	  routingHeaderCode.addOutputNewline("{") ;
	  routingHeaderCode.incrementIndent() ;
	  for(ComponentInstance bus:routeProp.buses)
	  {
		routingHeaderCode.addOutput(AadlToPokCUtils.getComponentInstanceIdentifier(bus));
		routingHeaderCode.addOutput(" = "+Integer.toString(idx));
		routingHeaderCode.addOutputNewline(",") ;
		idx++;
	  }
	  routingHeaderCode.addOutputNewline("invalid_bus = "+Integer.toString(idx)) ;
	  routingHeaderCode.decrementIndent() ;
	  routingHeaderCode.addOutputNewline("} pok_bus_identifier_t;") ;  
	}


	routingHeaderCode.addOutputNewline("#endif");
  }

  private
      void
      generateVirtualPortsToPartitionsArray(List<FeatureInstance> localVirtualPorts,
                                            UnparseText routingHeaderCode,
                                            Set<ComponentInstance> bindedPorcesses,
                                            RoutingProperties routeProp)
  {
    for(FeatureInstance fi: localVirtualPorts)
    {
      ComponentInstance processInstance = routeProp.processVirtualPort.get(fi);
      if(processInstance.getCategory() == ComponentCategory.PROCESS)
      {

        int partitionIndex = 0;
        for (Object entry:bindedPorcesses) {
          if (entry.equals(processInstance)) break;
          partitionIndex++;
        }

        routingHeaderCode.addOutput(Integer.toString(partitionIndex));
      }
      routingHeaderCode.addOutput(",");
    }
  }

  private void generateLocalPortsToPartitionsArray(List<FeatureInstance> localPorts,
                                        UnparseText routingHeaderCode,
                                        Set<ComponentInstance> bindedPorcesses)
  {
    for(FeatureInstance fi: localPorts)
    {
      ComponentInstance processInstance = (ComponentInstance) fi.getComponentInstance();
      if(processInstance.getCategory() == ComponentCategory.PROCESS)
      {

        int partitionIndex = 0;
        for (Object entry:bindedPorcesses) {
          if (entry.equals(processInstance)) break;
          partitionIndex++;
        }

        routingHeaderCode.addOutput(Integer.toString(partitionIndex));
      }
      routingHeaderCode.addOutput(",");
    }
  }

  private void genRoutingImpl(ComponentInstance processor,
                              UnparseText routingImplCode,
                              RoutingProperties routeProp)
                                                      throws GenerationException
  {
    routingImplCode.addOutputNewline("#include \"routing.h\"") ;
    routingImplCode.addOutputNewline("#include \"middleware/port.h\"") ;
    routingImplCode.addOutputNewline("#include <types.h>") ;

    if(routeProp.processPerProcessor.get(processor)==null)
      return;

    for(ComponentInstance deployedProcess:routeProp.processPerProcessor.get(processor))
    {
      // compute list of ports for each partition deployed on "processor"
      String processName = deployedProcess.getSubcomponent().getName();
      int nbPorts = routeProp.portPerProcess.get(deployedProcess).size()
          + routeProp.virtualPortPerProcess.get(deployedProcess).size();
      routingImplCode.addOutput("uint8_t ");
      routingImplCode.addOutput(processName+"_partport["+Integer.toString(nbPorts)
                                +"] = {" );
      for(FeatureInstance fi : routeProp.portPerProcess.get(deployedProcess))
      {
        routingImplCode.addOutput(AadlToPokCUtils.getFeatureLocalIdentifier(fi));
        routingImplCode.addOutput(",");
      }
      for(FeatureInstance fi : routeProp.virtualPortPerProcess.get(deployedProcess))
      {
        routingImplCode.addOutput(AadlToPokCUtils.getFeatureLocalIdentifier(fi)+VIRTUAL_PORT_SUFFIX);
        routingImplCode.addOutput(",");
      }
      routingImplCode.addOutputNewline("};");

      // compute list of destination ports for each port of partitions deployed on "processor"
      for(FeatureInstance fi : routeProp.portPerProcess.get(deployedProcess))
      {
        generateDestinationInit(fi, routingImplCode);
      }

      for(FeatureInstance fi : routeProp.virtualPortPerProcess.get(deployedProcess))
      {
        generateDestinationInit(fi, routingImplCode, VIRTUAL_PORT_SUFFIX);
      }
    }

    List<FeatureInstance> localPorts = getLocalPorts(processor, routeProp);
    List<FeatureInstance> localVirtualPorts = getLocalVirtualPorts(processor, routeProp);
    routingImplCode.addOutput("uint8_t pok_global_ports_to_local_ports" +
        "[POK_CONFIG_NB_GLOBAL_PORTS] = {");
    for(FeatureInstance fi:routeProp.globalPort)
    {
      if(localPorts.contains(fi))
        routingImplCode.addOutput(AadlToPokCUtils.getFeatureLocalIdentifier(fi));
      else
        routingImplCode.addOutput("invalid_local_port");

      routingImplCode.addOutput(",");
    }
    for(FeatureInstance fi:routeProp.globalVirtualPort)
    {
      if(localVirtualPorts.contains(fi))
        routingImplCode.addOutput(AadlToPokCUtils.getFeatureLocalIdentifier(fi)
                                  +VIRTUAL_PORT_SUFFIX);
      else
        routingImplCode.addOutput("invalid_local_port");

      routingImplCode.addOutput(",");
    }
    routingImplCode.addOutputNewline("};");

    routingImplCode.addOutput("uint8_t pok_global_ports_to_bus" +
        "[POK_CONFIG_NB_GLOBAL_PORTS] = {");
    for(@SuppressWarnings("unused") FeatureInstance fi:routeProp.globalPort)
    {
      routingImplCode.addOutput("invalid_bus");
      routingImplCode.addOutput(",");
    }
    for(FeatureInstance fi:routeProp.globalVirtualPort)
    {
      Iterable<ConnectionInstance> cnxIter = fi.allEnclosingConnectionInstances();
      for(ConnectionInstance connectionInstance : cnxIter)
      {
        if(false==connectionInstance.getKind().equals(org.osate.aadl2.instance.ConnectionKind.PORT_CONNECTION))
          continue;
        PropertyExpression pe = PropertyUtils.getPropertyValue("Actual_Connection_Binding", connectionInstance);
        ListValue lvBus = (ListValue) pe;
        InstanceReferenceValue irvBus = (InstanceReferenceValue) lvBus.getOwnedListElements().get(0);
        ComponentInstance inst = (ComponentInstance) irvBus.getReferencedInstanceObject();
        routingImplCode.addOutput(inst.getName());
        routingImplCode.addOutput(",");
        break;
      }
    }
    routingImplCode.addOutputNewline("};");
    
    
    routingImplCode.addOutput("uint8_t pok_local_ports_to_global_ports" +
        "[POK_CONFIG_NB_PORTS] = {");
    for(FeatureInstance fi:localPorts)
    {
      routingImplCode.addOutput(AadlToPokCUtils.getFeatureGlobalIdentifier(fi));
      routingImplCode.addOutput(",");
    }
    for(FeatureInstance fi:localVirtualPorts)
    {
      routingImplCode.addOutput(AadlToPokCUtils.getFeatureGlobalIdentifier(fi)+
                                VIRTUAL_PORT_SUFFIX);
      routingImplCode.addOutput(",");
    }
    routingImplCode.addOutputNewline("};");

    routingImplCode.addOutput("uint8_t pok_ports_nodes" +
        "[POK_CONFIG_NB_GLOBAL_PORTS] = {");
    for(FeatureInstance fi : routeProp.globalPort)
    {
      ComponentInstance inst = routeProp.processorPort.get(fi);
      routingImplCode.addOutput(AadlToPokCUtils.getComponentInstanceIdentifier(inst));
      routingImplCode.addOutput(",");
    }
    for(FeatureInstance fi : routeProp.globalVirtualPort)
    {
      ComponentInstance inst = routeProp.processorVirtualPort.get(fi);
      routingImplCode.addOutput(AadlToPokCUtils.getComponentInstanceIdentifier(inst));
      routingImplCode.addOutput(",");
    }
    routingImplCode.addOutputNewline("};");

    routingImplCode.addOutput("uint8_t pok_ports_nb_ports_by_partition" +
        "[POK_CONFIG_NB_PARTITIONS] = {");
    for(ComponentInstance deployedProcess:routeProp.processPerProcessor.get(processor))
    {
      int nbPort = routeProp.portPerProcess.get(deployedProcess).size();
      int nbVirtualPort=routeProp.virtualPortPerProcess.get(deployedProcess).size();
      routingImplCode.addOutput(Integer.toString(nbPort+nbVirtualPort));
      routingImplCode.addOutput(",");
    }
    routingImplCode.addOutputNewline("};");

    routingImplCode.addOutput("uint8_t* pok_ports_by_partition" +
        "[POK_CONFIG_NB_PARTITIONS] = {");
    for(ComponentInstance deployedProcess:routeProp.processPerProcessor.get(processor))
    {
      routingImplCode.addOutput(deployedProcess.getSubcomponent().getName()
                                +"_partport");
      routingImplCode.addOutput(",");
    }
    routingImplCode.addOutputNewline("};");

    routingImplCode.addOutput("char* pok_ports_names" +
        "[POK_CONFIG_NB_PORTS] = {");
    for(FeatureInstance fi: localPorts)
    {
      routingImplCode.addOutput("\""+
          AadlToPokCUtils.getFeatureLocalIdentifier(fi)
          +"\"");
      routingImplCode.addOutput(",");
    }
    for(FeatureInstance fi: localVirtualPorts)
    {
      routingImplCode.addOutput("\""+
          AadlToPokCUtils.getFeatureLocalIdentifier(fi)+VIRTUAL_PORT_SUFFIX
          +"\"");
      routingImplCode.addOutput(",");
    }
    routingImplCode.addOutputNewline("};");

    routingImplCode.addOutput("uint8_t pok_ports_identifiers" +
        "[POK_CONFIG_NB_PORTS] = {");
    for(FeatureInstance fi: localPorts)
    {
      routingImplCode.addOutput(""+
          AadlToPokCUtils.getFeatureLocalIdentifier(fi)
          +"");
      routingImplCode.addOutput(",");
    }
    for(FeatureInstance fi: localVirtualPorts)
    {
      routingImplCode.addOutput(""+
          AadlToPokCUtils.getFeatureLocalIdentifier(fi)+VIRTUAL_PORT_SUFFIX
          +"");
      routingImplCode.addOutput(",");
    }
    routingImplCode.addOutputNewline("};");

    routingImplCode.addOutput("uint8_t pok_ports_nb_destinations" +
        "[POK_CONFIG_NB_PORTS] = {");
    for(FeatureInstance fi: localPorts)
    {
      int destNb = RoutingProperties.getFeatureDestinations(fi).size();
      routingImplCode.addOutput(Integer.toString(destNb));
      routingImplCode.addOutput(",");
    }
    for(FeatureInstance fi: localVirtualPorts)
    {
      int destNb = RoutingProperties.getFeatureDestinations(fi).size();
      routingImplCode.addOutput(Integer.toString(destNb));
      routingImplCode.addOutput(",");
    }
    routingImplCode.addOutputNewline("};");

    routingImplCode.addOutput("uint8_t* pok_ports_destinations" +
        "[POK_CONFIG_NB_PORTS] = {");
    for(FeatureInstance fi: localPorts)
    {
      int destNb = RoutingProperties.getFeatureDestinations(fi).size();
      if(destNb==0)
        routingImplCode.addOutput("NULL");
      else
        routingImplCode.addOutput(AadlToPokCUtils.getFeatureLocalIdentifier(fi)
                                  +"_deployment_destinations");
      routingImplCode.addOutput(",");
    }
    for(FeatureInstance fi: localVirtualPorts)
    {
      int destNb = RoutingProperties.getFeatureDestinations(fi).size();
      if(destNb==0)
        routingImplCode.addOutput("NULL");
      else
        routingImplCode.addOutput(AadlToPokCUtils.getFeatureLocalIdentifier(fi)+VIRTUAL_PORT_SUFFIX
                                  +"_deployment_destinations");
      routingImplCode.addOutput(",");
    }
    routingImplCode.addOutputNewline("};");

    routingImplCode.addOutput("uint8_t pok_ports_kind" +
        "[POK_CONFIG_NB_PORTS] = {");
    for(FeatureInstance fi: localPorts)
    {
      if(fi.getCategory().equals(FeatureCategory.DATA_PORT))
        routingImplCode.addOutput("POK_PORT_KIND_SAMPLING");
      if(fi.getCategory().equals(FeatureCategory.EVENT_DATA_PORT)
          || fi.getCategory().equals(FeatureCategory.EVENT_PORT))
        routingImplCode.addOutput("POK_PORT_KIND_QUEUEING");
      routingImplCode.addOutput(",");
    }
    for(@SuppressWarnings("unused") FeatureInstance fi: localVirtualPorts)
    {
      routingImplCode.addOutput("POK_PORT_KIND_VIRTUAL");
      routingImplCode.addOutput(",");
    }
    routingImplCode.addOutputNewline("};");
  }
  
  private void generateDestinationInit(FeatureInstance fi,
                                       UnparseText routingImplCode,
                                       String portSuffix)
  {
    if(fi.getDirection().equals(DirectionType.OUT)
        || fi.getDirection().equals(DirectionType.IN_OUT))
    {
      List<FeatureInstance> destinations = RoutingProperties.getFeatureDestinations(fi);
      routingImplCode.addOutput("uint8_t ");
      routingImplCode.addOutput(AadlToPokCUtils.getFeatureLocalIdentifier(fi)+portSuffix+
                                "_deployment_destinations["+
                                Integer.toString(destinations.size())+"] = {");
      for(FeatureInstance dst:destinations)
      {
        routingImplCode.addOutput(AadlToPokCUtils.getFeatureGlobalIdentifier(dst)+portSuffix);
        routingImplCode.addOutput(",");
      }
      routingImplCode.addOutputNewline("};");   
    }
  }

  private void generateDestinationInit(FeatureInstance fi,
                                       UnparseText routingImplCode)
  {
    generateDestinationInit(fi, routingImplCode, "");
  }


  @Override
  protected String getBlackBoardType()
  {
    return BLACKBOARD_AADL_TYPE ;
  }


  @Override
  protected String getBufferType()
  {
    return BUFFER_AADL_TYPE;
  }


  @Override
  protected String getEventType()
  {
    return EVENT_AADL_TYPE ;
  }


  @Override
  protected String getQueuingType()
  {
    return QUEUING_AADL_TYPE ;
  }


  @Override
  protected String getSamplingType()
  {
    return SAMPLING_AADL_TYPE ;
  }


  @Override
  protected String getSemaphoreType()
  {
    return SEMAPHORE_AADL_TYPE ;
  }


  @Override
  protected String getVirtualPortType()
  {
    return VIRTUAL_PORT_AADL_TYPE ;
  }


  @Override
  protected String getFeatureLocalIdentifier(FeatureInstance fi)
  {
    return AadlToPokCUtils.getFeatureLocalIdentifier(fi) ;
  }


  @Override
  protected String getGenerationIdentifier(String prefix)
  {
    return GenerationUtilsC.getGenerationCIdentifier(prefix) ;
  }


  @Override
  protected void sendOutputQueueing(UnparseText mainImplCode, 
                                      QueueInfo info)
  {
    mainImplCode.addOutputNewline("time_out = "+info.timeOut+";");
    mainImplCode.addOutputNewline("length = "+"sizeof( "+info.dataType+" );");
    mainImplCode.addOutputNewline("SEND_QUEUING_MESSAGE("+info.id+", value, length, time_out, &ret);");
  }


  @Override
  protected void
      sendOutputEvent(UnparseText mainImplCode, 
                      EventInfo eventInfo)
  {
    mainImplCode.addOutputNewline("SET_EVENT("+eventInfo.id+", &ret);");
  }


  @Override
  protected void sendOutputBuffer(UnparseText mainImplCode, 
                                    QueueInfo info)
  {
    mainImplCode.addOutputNewline("time_out = "+info.timeOut+";");
    mainImplCode.addOutputNewline("length = "+"sizeof( "+info.dataType+" );");
    mainImplCode.addOutputNewline("SEND_BUFFER("+info.id+", value, length, time_out, &ret);");
  }


  @Override
  protected void sendOutputPrologue(ComponentInstance processInstance,
                                    UnparseText mainImplCode,
                                    ProcessProperties pp)
  {
    mainImplCode.addOutputNewline("RETURN_CODE_TYPE ret;");
    mainImplCode.addOutputNewline("SYSTEM_TIME_TYPE time_out;");
    mainImplCode.addOutputNewline("MESSAGE_SIZE_TYPE length;");

    mainImplCode.addOutputNewline("if(value==NULL)");
    mainImplCode.addOutputNewline("{");
    mainImplCode.incrementIndent();
    mainImplCode.addOutputNewline("char i=0;");
    mainImplCode.addOutputNewline("value = &i;");
    mainImplCode.decrementIndent();
    mainImplCode.addOutputNewline("}"); 
  }


  @Override
  protected String getGlobalQueueType()
  {
    return null ;
  }


  @Override
  protected void sendOutputVariableAccess(ComponentInstance processInstance,
                                          UnparseText mainImplCode,
                                          ProcessProperties pp)
  {
    // Nothing to do here
  }

  
}
