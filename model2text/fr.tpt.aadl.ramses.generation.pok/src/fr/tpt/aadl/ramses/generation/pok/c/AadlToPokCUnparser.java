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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.MemorySubcomponent;
import org.osate.aadl2.Port;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.UnparseText;

import fr.tpt.aadl.annex.behavior.utils.AadlBaUtils ;
import fr.tpt.aadl.annex.behavior.utils.DimensionException ;
import fr.tpt.aadl.ramses.control.support.generator.AadlTargetUnparser ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.TargetProperties ;
import fr.tpt.aadl.ramses.generation.c.GenerationUtilsC ;
import fr.tpt.aadl.ramses.generation.target.specific.GeneratorUtils ;
import fr.tpt.aadl.ramses.transformation.atl.hooks.impl.HookAccessImpl ;
import fr.tpt.aadl.ramses.util.generation.FileUtils ;
import fr.tpt.aadl.ramses.util.generation.RoutingProperties ;
import fr.tpt.aadl.utils.PropertyUtils ;

public class AadlToPokCUnparser implements AadlTargetUnparser
{
  private final static long DEFAULT_REQUIRED_STACK_SIZE = 16384 ;
  
  // TODO: factorization with ATL transformation into a naming class or enum. 
  public final static String BLACKBOARD_AADL_TYPE = 
                                             "pok_runtime::Blackboard_Id_Type" ;
  
  public final static String QUEUING_AADL_TYPE =
                                           "pok_runtime::Queuing_Port_Id_Type" ;

  public final static String SAMPLING_AADL_TYPE =
                                          "pok_runtime::Sampling_Port_Id_Type" ;
  
  public final static String EVENT_AADL_TYPE =
                                          "pok_runtime::Event_Id_Type" ;
  
  public final static String BUFFER_AADL_TYPE =
                                          "pok_runtime::Buffer_Id_Type" ;
  
  private ProcessorProperties _processorProp;
  
  public void process(ProcessorSubcomponent processor,
                      File generatedFilePath,
                      TargetProperties tarProp) 
                                                     throws GenerationException
  { 
    ProcessorProperties processorProp = new ProcessorProperties() ;
    ComponentInstance processorInst = (ComponentInstance) HookAccessImpl.
                                             getTransformationTrace(processor) ;
    RoutingProperties routing = (RoutingProperties) tarProp ;
    
    // Discard older processor properties !
    _processorProp = processorProp ;
    
    // Generate deployment.h
    UnparseText deploymentHeaderCode = new UnparseText() ;
    genDeploymentHeader(processor, deploymentHeaderCode, routing) ;
    
    // Generate deployment.c
    UnparseText deploymentImplCode = new UnparseText() ;
    genDeploymentImpl(processor, deploymentImplCode, processorProp) ;
    
    // Generate routing.h
    UnparseText routingHeaderCode = new UnparseText() ;
    genRoutingHeader(processorInst, routingHeaderCode, routing) ;

    // Generate routing.c
    UnparseText routingImplCode = new UnparseText() ;
    genRoutingImpl(processorInst, routingImplCode, routing) ;
    
    try
    {
      FileUtils.saveFile(generatedFilePath, "deployment.h",
               deploymentHeaderCode.getParseOutput()) ;
      
      FileUtils.saveFile(generatedFilePath, "deployment.c",
               deploymentImplCode.getParseOutput()) ;
      
      FileUtils.saveFile(generatedFilePath, "routing.h", routingHeaderCode.getParseOutput()) ;

      FileUtils.saveFile(generatedFilePath, "routing.c", routingImplCode.getParseOutput()) ;
    }
    catch(IOException e)
    {
      // TODO : error message to handle.
      e.printStackTrace() ;
    }
  }
  
  private void locaCommunicattionHandler(ProcessImplementation processImpl, 
                                 PartitionProperties pp)
  {
    EList<Subcomponent> subcmpts = processImpl.getAllSubcomponents() ;
    
    for(Subcomponent s : subcmpts)
    {
      if(s instanceof DataSubcomponent)
      {
        if(s.getClassifier().getQualifiedName()
              .equalsIgnoreCase(BLACKBOARD_AADL_TYPE))
        {
          blackBoardHandler(s.getName(), 
                            (FeatureInstance) HookAccessImpl.
                            getTransformationTrace(s), pp);
        }
        else if(s.getClassifier().getQualifiedName()
              .equalsIgnoreCase(EVENT_AADL_TYPE))
        {
          pp.eventNames.add(s.getName());
        }
      }
    }
  }
  
//TODO : be refactored with generic interfaces.
  private void blackBoardHandler(String id, FeatureInstance fi, PartitionProperties pp)
  {

    BlackBoardInfo blackboardInfo = new BlackBoardInfo() ;
    blackboardInfo.id = id;

    if(fi.getCategory() == FeatureCategory.DATA_PORT)
    {
      DataPort p  = (DataPort) fi.getFeature() ;
      try
      {
        blackboardInfo.dataType=PropertyUtils.getStringValue(p.getDataFeatureClassifier(), "Source_Name") ;
      }
      catch(Exception e)
      {
        blackboardInfo.dataType =GenerationUtilsC.getGenerationCIdentifier(p.getDataFeatureClassifier()
                                                                           .getQualifiedName()) ;
      }
    }
    pp.blackboardInfo.add(blackboardInfo); 

  }
  
  //TODO : be refactored with generic interfaces.
  private void queueHandler(String id, FeatureInstance fi, PartitionProperties pp)
  {
    Port p = getProcessPort(fi) ;
    
    QueueInfo queueInfo = new QueueInfo() ;
    
    queueInfo.id = id;
    queueInfo.uniqueId = AadlToPokCUtils.getFeatureLocalIdentifier(fi);
    queueInfo.direction = p.getDirection() ;
    
    if(fi.getCategory() == FeatureCategory.EVENT_DATA_PORT)
    {
      EventDataPort port  = (EventDataPort) fi.getFeature() ;
      try
      {
        queueInfo.dataType=PropertyUtils.getStringValue(port.getDataFeatureClassifier(), "Source_Name") ;
      }
      catch(Exception e)
      {
        queueInfo.dataType =GenerationUtilsC.getGenerationCIdentifier(port.getDataFeatureClassifier()
                                                                           .getQualifiedName()) ;
      }
    }
    
    if(getQueueInfo(p, queueInfo))
    {
      pp.queueInfo.add(queueInfo) ;
    }
  }
  
  private void bufferHandler(String id, FeatureInstance fi, PartitionProperties pp)
  {
    
    QueueInfo queueInfo = new QueueInfo() ;
    
    
    queueInfo.id = id;
    queueInfo.uniqueId = AadlToPokCUtils.getFeatureLocalIdentifier(fi);
    
    if(fi.getCategory() == FeatureCategory.EVENT_DATA_PORT)
    {
      EventDataPort port  = (EventDataPort) fi.getFeature() ;
      try
      {
        queueInfo.dataType=PropertyUtils.getStringValue(port.getDataFeatureClassifier(), "Source_Name") ;
      }
      catch(Exception e)
      {
        queueInfo.dataType = GenerationUtilsC.getGenerationCIdentifier(port.getDataFeatureClassifier()
                                                                           .getQualifiedName()) ;
      }
    }
    
    if(getQueueInfo((Port)fi.getFeature(), queueInfo))
    {
      pp.bufferInfo.add(queueInfo) ;
    }
    else
    {
      queueInfo.type = "FIFO";
      queueInfo.size = 1;
      pp.bufferInfo.add(queueInfo) ;
    }
    
  }
  
  private Port getProcessPort(FeatureInstance fi)
  {
    ConnectionInstance ci = null ;
    ConnectionReference cf = null ;
    ConnectedElement c = null ;
    
    // TODO : queue information are not always in process, recursively fetch
    // these informations.
    if(DirectionType.OUT == fi.getDirection())
    {
      ci = fi.getSrcConnectionInstances().get(0) ;
      cf = ci.getConnectionReferences().get(0) ; 
      c = (ConnectedElement)(cf.getConnection().getDestination()) ;
    }
    else
    {
      ci = fi.getDstConnectionInstances().get(0) ;
      EList<ConnectionReference> crl = ci.getConnectionReferences() ;
      cf = crl.get(crl.size() -1) ;
      c = (ConnectedElement)(cf.getConnection()).getSource() ;
    }
    
    Port p = (Port) c.getConnectionEnd() ;
    
    return p ;
  }
  
  // Return false QueueInfo object is not completed.
  private boolean getQueueInfo(Port port, QueueInfo info)
  {
    boolean result = true ;
    
    // XXX temporary. Until ATL transformation modifications.
    //  info.id = RoutingProperties.getFeatureLocalIdentifier(fi) ;
    
    try
    {
      if(info.type == null)
      {
        info.type = PropertyUtils.getEnumValue(port, "Queue_Processing_Protocol") ;
      }
    }
    catch (Exception e)
    {
      result = false ;
    }  
    
    try
    {
      if(info.size == -1)
      {
        info.size = PropertyUtils.getIntValue(port, "Queue_Size") ;
      }
    }
    catch (Exception e)
    {
      result = false ;
    }
    
    return result ;
  }
  
  // TODO : be refactored with generic interfaces. 
  private void sampleHandler(String id, FeatureInstance fi, PartitionProperties pp)
  {
    Port p = getProcessPort(fi) ;
    
    SampleInfo sampleInfo = new SampleInfo() ;
    sampleInfo.direction = p.getDirection() ;
    
    if(fi.getCategory() == FeatureCategory.DATA_PORT)
    {
      DataPort port  = (DataPort) fi.getFeature() ;
      try
      {
        sampleInfo.dataType=PropertyUtils.getStringValue(port.getDataFeatureClassifier(), "Source_Name") ;
      }
      catch(Exception e)
      {
        sampleInfo.dataType =GenerationUtilsC.getGenerationCIdentifier(port.getDataFeatureClassifier()
                                                                           .getQualifiedName()) ;
      }
    }
    
    sampleInfo.id = id;
    sampleInfo.uniqueId = AadlToPokCUtils.getFeatureLocalIdentifier(fi);
    
    if(getSampleInfo(p, sampleInfo))
    {
      pp.sampleInfo.add(sampleInfo) ;
    }
  }
  
  private boolean getSampleInfo(Port port, SampleInfo info)
  {
    boolean result = true ;
    
    // XXX temporary. Until ATL transformation modifications.
    //  info.id = RoutingProperties.getFeatureLocalIdentifier(fi) ;
    
    try
    {
      if(info.refresh == -1)
      {
        info.refresh = PropertyUtils.getIntValue(port,
                                         "Sampling_Refresh_Period") ;
      }
    }
    catch (Exception e)
    {
      System.err.println("ERROR: sampling port "+port.getQualifiedName()+" should have property" +
      		" Sampling_Refresh_Period");
      result = false ;
    }  
    
    return result ;
  }
  
  private void genQueueMainImpl(UnparseText mainImplCode,
                                PartitionProperties pp)
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
                                 PartitionProperties pp)
  {
    for(String eventId: pp.eventNames)
    {
      mainImplCode.addOutput("  CREATE_EVENT (\"") ;
      mainImplCode.addOutput(eventId);
      mainImplCode.addOutput("\",");
      mainImplCode.addOutput("&"+eventId+",");
      mainImplCode.addOutputNewline("& (ret));");
    }
  }
  
  private void genBufferMainImpl(UnparseText mainImplCode,
                                PartitionProperties pp)
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
                                 PartitionProperties pp)
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
  
  public void process(ProcessSubcomponent process, File generatedFilePath,
                      TargetProperties tarProp)
  {
    PartitionProperties pp = new PartitionProperties();
    RoutingProperties routing = (RoutingProperties) tarProp ;
    
    ProcessImplementation processImpl = (ProcessImplementation) 
                                          process.getComponentImplementation() ;
    
    this.findCommunicationMechanism(processImpl, pp);
    
//    ComponentInstance processInst = (ComponentInstance) HookAccessImpl.
//                                               getTransformationTrace(process) ;
//    boolean needRoutage = false ;
//    
//    for(ComponentInstance ci : processInst.getComponentInstances())
//    {
//      if (ComponentCategory.THREAD != ci.getCategory())
//      {
//        continue ;
//      }
//      // else
//      
//      // Fetches thread's feature instances.
//      for (FeatureInstance fi : ci.getFeatureInstances())
//      {
//        FeatureCategory cat = fi.getCategory() ;
//        
//        if(FeatureCategory.DATA_PORT != cat &&
//           FeatureCategory.EVENT_PORT != cat &&
//           FeatureCategory.EVENT_DATA_PORT != cat)
//        {
//          continue ; 
//        }
//        // else
//        
//        needRoutage = AadlToPokCUtils.needsRoutage(fi) ;
//        
//        switch(cat)
//        {
//          case DATA_PORT :
//          {
//            if(needRoutage)
//            {
//              pp.hasSample = true ;
//              sampleHandler(fi, pp) ;
//            }
//            else
//            {
//              pp.hasBlackboard = true ;
//            }
//            
//            break ;
//          }
//          
//          case EVENT_PORT :
//          {
//            if(needRoutage)
//            {
//              pp.hasQueue = true ;
//              // queueHandler() ;
//            }
//            else
//            {
//              pp.hasEvent = true ;
//              // eventHandler() ;
//            }
//            
//            break ;
//          }
//          
//          case EVENT_DATA_PORT :
//          {
//            if(needRoutage)
//            {
//              pp.hasQueue = true ;
//              queueHandler(fi, pp) ;
//            }
//            else
//            {
//              pp.hasBuffer = true ;
//              // bufferHandler() ;
//            }
//            
//            break ;
//          }
//          
//          default:
//          {
//            // Nothing to do.
//          }
//        }
//      }
//    }
    
    if(pp.hasBlackboard 
          || pp.hasEvent)
    {
      locaCommunicattionHandler(processImpl, pp);
    }
    
    // Generate main.h
    UnparseText mainHeaderCode = new UnparseText() ;
    genMainHeader(processImpl, mainHeaderCode, _processorProp, pp);
    
    // Generate main.c
    UnparseText mainImplCode = new UnparseText() ;
    genMainImpl(processImpl, mainImplCode, pp) ;
    
    try
    {
      FileUtils.saveFile(generatedFilePath, "main.h",
               mainHeaderCode.getParseOutput()) ;
      
      FileUtils.saveFile(generatedFilePath, "main.c",
               mainImplCode.getParseOutput()) ;
    }
    catch(IOException e)
    {
      // TODO : error message to handle.
      e.printStackTrace() ;
    }
  }
  
  //Generate global variables.
  private void genGlobalVariablesMainImpl(ProcessImplementation process, EList<ThreadSubcomponent> lthreads,
                                          UnparseText mainImplCode,
                                          PartitionProperties pp)
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
      
      // Generate external variable (declared in deployment.c).
      for(BlackBoardInfo info : pp.blackboardInfo)
      {
        mainImplCode.addOutput("extern BLACKBOARD_ID_TYPE ") ;
        mainImplCode.addOutput(info.id) ;
        mainImplCode.addOutputNewline(";") ;
      }
    }
    
    // Generate event names array.
    if(pp.hasEvent)
    {
      mainImplCode.addOutput("char* pok_arinc653_events_names[POK_CONFIG_NB_EVENTS] = {") ;

      for(String name : pp.eventNames)
      {
        mainImplCode.addOutput("\"") ;
        mainImplCode.addOutput(name) ;
        mainImplCode.addOutput("\"") ;
      }

      mainImplCode.addOutputNewline("};") ;
      
      // Generate external variable (declared in deployment.c).
      for(String name : pp.eventNames)
      {
        mainImplCode.addOutput("extern EVENT_ID_TYPE ") ;
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
        mainImplCode.addOutput("extern BUFFER_ID_TYPE ") ;
        mainImplCode.addOutput(info.id) ;
        mainImplCode.addOutputNewline(";") ;
      }
    }
    
    // Generate queue names array.
    if(pp.hasQueue)
    {
      for(QueueInfo info : pp.queueInfo)
      {
        mainImplCode.addOutput("extern QUEUING_PORT_ID_TYPE ") ;
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

    try
    {
      long value = PropertyUtils.getIntValue(thread, "Period") ;
      period = Long.toString(value) ;
    }
    catch(Exception e)
    {
      period = null ;
    }

    // If period is not set, don't generate.
    if(period != null)
    {
      mainImplCode.addOutput("  tattr.PERIOD = ") ;
      mainImplCode.addOutputNewline(period + ';') ;
    }

    try
    {
      long value = PropertyUtils.getIntValue(thread, "Deadline") ;
      deadline = Long.toString(value) ;
    }
    catch(Exception e)
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

    try
    {
      float value =
            PropertyUtils.getMaxRangeValue(thread, "Compute_Execution_Time") ;
      timeCapacity = Integer.toString((int) value) ;
    }
    catch(Exception e)
    {
      timeCapacity = null ;
    }

    // If compute execution time is not set, don't generate.
    if(timeCapacity != null)
    {
      mainImplCode.addOutput("  tattr.TIME_CAPACITY = ") ;
      mainImplCode.addOutputNewline(timeCapacity + ';') ;
    }

    mainImplCode
          .addOutput("  CREATE_PROCESS (&(tattr), &(arinc_threads[") ;
    mainImplCode.addOutput(Integer.toString(threadIndex)) ;
    mainImplCode.addOutputNewline("]), &(ret));") ;
  }
  
  private void genBlackboardMainImpl(UnparseText mainImplCode,
                                     PartitionProperties pp)
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
  
  
  
  private void genMainImpl(ProcessImplementation process,
                           UnparseText mainImplCode,
                           PartitionProperties pp)
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
      genThreadDeclarationMainImpl(thread, threadIndex, mainImplCode) ;
      threadIndex++ ;
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

private void findCommunicationMechanism(ProcessImplementation process,
                                          PartitionProperties pp)
  {
    EList<Subcomponent> subcmpts = process.getAllSubcomponents() ;
    
    for(Subcomponent s : subcmpts)
    {
      if(s instanceof DataSubcomponent)
      {
        if(s.getClassifier().getQualifiedName()
              .equalsIgnoreCase(BLACKBOARD_AADL_TYPE))
        {
          blackBoardHandler(s.getName(),
                            (FeatureInstance) HookAccessImpl.
                            getTransformationTrace(s), pp);
          pp.hasBlackboard = true;
        }
        else if(s.getClassifier().getQualifiedName()
              .equalsIgnoreCase(QUEUING_AADL_TYPE))
        {
          queueHandler(s.getName(),
                       (FeatureInstance) HookAccessImpl.
                       getTransformationTrace(s), pp);
          
          pp.hasQueue = true ;
        }
        else if(s.getClassifier().getQualifiedName()
              .equalsIgnoreCase(SAMPLING_AADL_TYPE))
        {
          sampleHandler(s.getName(), (FeatureInstance) HookAccessImpl.
                       getTransformationTrace(s), pp);
          pp.hasSample = true ;
        }
        else if(s.getClassifier().getQualifiedName()
              .equalsIgnoreCase(EVENT_AADL_TYPE))
        {
          pp.eventNames.add(s.getName());
          pp.hasEvent = true ;
        }
        else if(s.getClassifier().getQualifiedName()
              .equalsIgnoreCase(BUFFER_AADL_TYPE))
        {
          bufferHandler(s.getName(),
                       (FeatureInstance) HookAccessImpl.
                       getTransformationTrace(s), pp);
          pp.hasBuffer = true ;
        }
      }
    }
  }
  
  private PartitionProperties genMainHeader(ProcessImplementation process,
                                            UnparseText mainHeaderCode,
                                            ProcessorProperties processorProp,
                                            PartitionProperties pp)
  {
    List<ThreadSubcomponent> bindedThreads =
                                         process.getOwnedThreadSubcomponents() ;
    
    String guard = GenerationUtilsC.generateHeaderInclusionGuard("main.h") ;
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

    if(pp.hasEvent)
    {
      int i = pp.eventNames.size(); 
      mainHeaderCode
            .addOutputNewline("#define POK_CONFIG_NB_EVENTS " +
                  pp.eventNames.size()) ;
      mainHeaderCode
      .addOutputNewline("#define POK_CONFIG_ARINC653_NB_EVENTS " +
            pp.eventNames.size()) ;
      
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
      
      int i = pp.bufferInfo.size(); 
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
    
    mainHeaderCode.addOutputNewline("\n#endif") ;
    
    return pp ;
  }

private void genDeploymentImpl(ProcessorSubcomponent processor,
                                 UnparseText deploymentImplCode,
                                 ProcessorProperties pokProp)
  {
    deploymentImplCode.addOutputNewline("#include <types.h>") ;
    deploymentImplCode.addOutputNewline("#include \"deployment.h\"") ;    
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
      try
      {
        additionalFeatures =
              PropertyUtils.getStringListValue(vps, "Additional_Features") ;

        for(String s : additionalFeatures)
        {
          if(s.equalsIgnoreCase("console"))
          {
            // POK_NEEDS_CONSOLE has to be in both kernel's deployment.h
            deploymentHeaderCode
                  .addOutputNewline("#define POK_NEEDS_CONSOLE 1") ;
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
      catch(Exception e)
      {
        // Nothing to do
      }
    }

    // TODO: the integer ID in this macro must be set carefully to respect the
    // routing table defined in deployment.c files in the generated code for a
    // partition.
    int id =
          ((SystemImplementation) processor.eContainer())
                .getOwnedProcessorSubcomponents().indexOf(processor) ;
    deploymentHeaderCode.addOutputNewline("#define POK_CONFIG_LOCAL_NODE " +
          Integer.toString(id)) ;
    // POK_GENERATED_CODE 1 always true in our usage context
    deploymentHeaderCode.addOutputNewline("#define POK_GENERATED_CODE 1") ;

    deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_GETTICK 1") ;
    // POK_NEEDS_THREADS 1 always true in our usage context.
    deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_THREADS 1") ;

    if(bindedVPS.size() > 0)
    {
      deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_PARTITIONS 1") ;
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
      ProcessImplementation pi =
            (ProcessImplementation) p.getComponentImplementation() ;
      bindedThreads.addAll(pi.getOwnedThreadSubcomponents()) ;
      threadNumberPerPartition.add(Integer.valueOf(pi
            .getOwnedThreadSubcomponents().size())) ;
    }

    //  The maccro POK_CONFIG_NB_THREADS indicates the amount of threads used in 
    //  the kernel.It comprises the tasks for the partition and the main task of 
    //  each partition that initialize all ressources.
    deploymentHeaderCode.addOutputNewline("#define POK_CONFIG_NB_THREADS " +
          Integer.toString(2 + bindedProcess.size() + bindedThreads.size())) ;
    //  The maccro POK_CONFIG_NB_PARTITIONS_NTHREADS indicates the amount of 
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
      try
      {
        boolean foundRR = false ;

        String requiredScheduler = PropertyUtils.getEnumValue(vps, "Scheduler") ;

        if(requiredScheduler.equalsIgnoreCase("RR") && foundRR == false)
        {
          foundRR = true ;
          deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_SCHED_RR 1") ;
        }
      }
      catch(Exception e)
      {
        System.err.println("*** SCHEDULER IS NOT PROVIDED *** ") ;
//        e.printStackTrace() ;
      }
    }

    // TODO: define POK_CONFIG_PARTITIONS_SCHEDULER: sched algo associated to 
    // each partition
    deploymentHeaderCode.addOutput("#define POK_CONFIG_PARTITIONS_SCHEDULER {") ;

    for(VirtualProcessorSubcomponent vps : bindedVPS)
    {
      try
      {
        String requiredScheduler = PropertyUtils.getEnumValue(vps, "Scheduler") ;

        if(requiredScheduler.equalsIgnoreCase("RR"))
        {
          deploymentHeaderCode.addOutput("POK_SCHED_RR") ;
        }

        if(bindedVPS.indexOf(vps) != bindedVPS.size() - 1)
        {
          deploymentHeaderCode.addOutput(",") ;
        }
      }
      catch(Exception e)
      {
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
      if(!_processorProp.partitionProperties.containsKey(process))
      {
        PartitionProperties pp = new PartitionProperties() ;
        _processorProp.partitionProperties.put(process, pp) ;
        findCommunicationMechanism(process, pp) ;
      }
      PartitionProperties pp = _processorProp.partitionProperties.get(process) ;
      if(pp.hasBlackboard)
      {
        deploymentHeaderCode
              .addOutputNewline("#define POK_NEEDS_LOCKOBJECTS 1") ;
      }
      else if(pp.hasBuffer)
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

    deploymentHeaderCode
          .addOutput("#define POK_CONFIG_PARTITIONS_NLOCKOBJECTS {") ;
    for(ProcessSubcomponent ps : bindedProcess)
    {
      PartitionProperties pp =
            _processorProp.partitionProperties.get((ProcessImplementation) ps
                  .getComponentImplementation()) ;
      deploymentHeaderCode.addOutput(Integer
            .toString(pp.blackboardInfo.size()
                      + pp.bufferInfo.size())) ;
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
      try
      {
        memorySizePerPartition.add(PropertyUtils
              .getIntValue(p, "Needed_Memory_Size")) ;
      }
      catch(Exception e)
      {
        try
        {
          MemorySubcomponent bindedMemory =
                (MemorySubcomponent) GeneratorUtils
                      .getDeloymentMemorySubcomponent(p) ;
          try
          {
            memorySizePerPartition.add(PropertyUtils.getIntValue(bindedMemory,
                                                                 "Byte_Count")) ;
          }
          catch(Exception e3)
          {
            e3.printStackTrace() ;
          }
        }
        catch(Exception e2)
        {
          e.printStackTrace() ;
          e2.printStackTrace() ;
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
    try
    {
      List<Long> slotPerPartition =
            PropertyUtils.getIntListValue(processor, "Partition_Slots") ;
      // POK_CONFIG_SCHEDULING_SLOTS extracted from POK::Paritions_Slots => (500 ms);
      deploymentHeaderCode.addOutput("#define POK_CONFIG_SCHEDULING_SLOTS {") ;
      idx = 0 ;
      for(Long l : slotPerPartition)
      {
        deploymentHeaderCode.addOutput(Long.toString(l)) ;

        if(idx != slotPerPartition.size() - 1)
        {
          deploymentHeaderCode.addOutput(",") ;
        }
        idx++ ;
      }

      deploymentHeaderCode.addOutputNewline("}") ;
      deploymentHeaderCode
            .addOutputNewline("#define POK_CONFIG_SCHEDULING_NBSLOTS " +
                  Integer.toString(slotPerPartition.size())) ;

    }
    catch(Exception e)
    {
      e.printStackTrace() ;
    }
    try
    {
      List<Subcomponent> slotsAllocation =
            PropertyUtils.getSubcomponentList(processor, "Slots_Allocation") ;
      deploymentHeaderCode
            .addOutput("#define POK_CONFIG_SCHEDULING_SLOTS_ALLOCATION {") ;

      for(Subcomponent sAllocation : slotsAllocation)
      {
        int referencedComponentId = bindedVPS.indexOf(sAllocation) ;
        deploymentHeaderCode.addOutput(Integer.toString(referencedComponentId)) ;

        if(slotsAllocation.indexOf(sAllocation) != slotsAllocation.size() - 1)
        {
          deploymentHeaderCode.addOutput(",") ;
        }
      }

      deploymentHeaderCode.addOutputNewline("}") ;
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
    }

    try
    {
      Long majorFrame =
            PropertyUtils.getIntValue(processor, "Module_Major_Frame") ;
      deploymentHeaderCode
            .addOutputNewline("#define POK_CONFIG_SCHEDULING_MAJOR_FRAME " +
                  Long.toString(majorFrame)) ;
    }
    catch(Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace() ;
    }

    for(ProcessSubcomponent ps : bindedProcess)
    {
      ProcessImplementation pi =
            (ProcessImplementation) ps.getComponentImplementation() ;

      for(ThreadSubcomponent ts : pi.getOwnedThreadSubcomponents())
      {
        try
        {
          long partitionStack =
                PropertyUtils.getIntValue(ts, "Source_Stack_Size") ;
          _processorProp.requiredStackSize += partitionStack ;
          _processorProp.requiredStackSizePerPartition.put(pi, partitionStack) ;
        }
        catch(Exception e)
        {
          _processorProp.requiredStackSize += DEFAULT_REQUIRED_STACK_SIZE ;
          _processorProp.requiredStackSizePerPartition
                .put(pi, DEFAULT_REQUIRED_STACK_SIZE) ;
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

    genDeploymentHeaderEnd(deploymentHeaderCode);
    
    deploymentHeaderCode.addOutputNewline("#endif") ;
  }                                            

  protected void genDeploymentHeaderEnd(UnparseText deploymentHeaderCode){}

@Override
  public void setParameters(Map<Enum<?>, Object> parameters)
  {
    throw new UnsupportedOperationException() ;
  }

  public TargetProperties process(SystemImplementation si,
                                   File generatedFilePath)
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
  
  private void genRoutingHeader(ComponentInstance processor,
                                UnparseText routingHeaderCode,
                                RoutingProperties routeProp)
                                                      throws GenerationException
  {
	String guard = GenerationUtilsC.generateHeaderInclusionGuard("routing.h") ;
	routingHeaderCode.addOutput(guard);
	
	if(routeProp.processPerProcessor.get(processor)!=null)
	{
	  int globalPortNb = routeProp.globalPort.size();
	  routingHeaderCode.addOutputNewline("#define POK_CONFIG_NB_GLOBAL_PORTS " +
			  Integer.toString(globalPortNb));
		
	  List<FeatureInstance> localPorts = getLocalPorts(processor, routeProp);
	  int localPortNb = localPorts.size();
	  
	  routingHeaderCode.addOutputNewline("#define POK_CONFIG_NB_PORTS " +
			  Integer.toString(localPortNb));

	  routingHeaderCode.addOutputNewline("#define POK_CONFIG_NB_NODES " +
			  Integer.toString(routeProp.processors.size())) ;

	  int idx=0;
	  if(!localPorts.isEmpty())
    {
	    routingHeaderCode.addOutput("#define POK_CONFIG_PARTITIONS_PORTS {");
	  
	    idx=0;
	    for(ComponentInstance deployedProcess:routeProp.processPerProcessor.get(processor))
      {
        for(FeatureInstance f: routeProp.portPerProcess.get(deployedProcess))
        {
          List<ComponentInstance> bindedVP = PropertyUtils.getComponentInstanceList(deployedProcess,
                "Actual_Processor_Binding") ;
          for(ComponentInstance virtualProcessor:bindedVP)
          {
            if(processor.getComponentInstances().contains(virtualProcessor))
            {
              int partitionIndex = processor.getComponentInstances().indexOf(virtualProcessor);
              routingHeaderCode.addOutput(Integer.toString(partitionIndex));
            }
          }
          routingHeaderCode.addOutput(",");

        }
        idx++;
	    }
	  }
	  routingHeaderCode.addOutputNewline("}");
	  
	  
	  routingHeaderCode.addOutputNewline("typedef enum") ;
	  routingHeaderCode.addOutputNewline("{") ;
	  routingHeaderCode.incrementIndent() ;
	  
	  idx=0;
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
	  routingHeaderCode.decrementIndent() ;
	  routingHeaderCode.addOutputNewline("} pok_port_identifier_t;") ;

	  // TODO: define buses for distributed use-case
	  routingHeaderCode.addOutputNewline("#define POK_CONFIG_NB_BUSES 0") ;
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
	  int nbPorts = routeProp.portPerProcess.get(deployedProcess).size();
	  routingImplCode.addOutput("uint8_t ");
	  routingImplCode.addOutput(processName+"_partport["+Integer.toString(nbPorts)
	        +"] = {" );
	  for(FeatureInstance fi : routeProp.portPerProcess.get(deployedProcess))
	  {
		routingImplCode.addOutput(AadlToPokCUtils.getFeatureLocalIdentifier(fi));
		routingImplCode.addOutput(",");
	  }
	  routingImplCode.addOutputNewline("};");
	  
	  // compute list of destination ports for each port of partitions deployed on "processor"
	  for(FeatureInstance fi : routeProp.portPerProcess.get(deployedProcess))
	  {
	    if(fi.getDirection().equals(DirectionType.OUT)
	          || fi.getDirection().equals(DirectionType.IN_OUT))
	    {
	      List<FeatureInstance> destinations = RoutingProperties.getFeatureDestinations(fi);
	      routingImplCode.addOutput("uint8_t ");
	      routingImplCode.addOutput(AadlToPokCUtils.getFeatureLocalIdentifier(fi)+
	                                "_deployment_destinations["+
	                                Integer.toString(destinations.size())+"] = {");
	      for(FeatureInstance dst:destinations)
	      {
	        routingImplCode.addOutput(AadlToPokCUtils.getFeatureGlobalIdentifier(dst));
	        routingImplCode.addOutput(",");
	      }
	      routingImplCode.addOutputNewline("};");	  
	    }
	  }
	  
	  
	}
	
	List<FeatureInstance> localPorts = getLocalPorts(processor, routeProp);
	
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
	routingImplCode.addOutputNewline("};");
	
	routingImplCode.addOutput("uint8_t pok_local_ports_to_global_ports" +
			"[POK_CONFIG_NB_PORTS] = {");
	for(FeatureInstance fi:localPorts)
	{
	  routingImplCode.addOutput(AadlToPokCUtils.getFeatureGlobalIdentifier(fi));
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
	routingImplCode.addOutputNewline("};");
	
	routingImplCode.addOutput("uint8_t pok_ports_nb_ports_by_partition" +
			"[POK_CONFIG_NB_PARTITIONS] = {");
	for(ComponentInstance deployedProcess:routeProp.processPerProcessor.get(processor))
	{
	  int nbPort = routeProp.portPerProcess.get(deployedProcess).size();
	  routingImplCode.addOutput(Integer.toString(nbPort));
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
	routingImplCode.addOutputNewline("};");
	
	routingImplCode.addOutput("uint8_t pok_ports_nb_destinations" +
			"[POK_CONFIG_NB_PORTS] = {");
	for(FeatureInstance fi: localPorts)
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
	routingImplCode.addOutputNewline("};");
  }
  
  public static class BlackBoardInfo
  {
  	public String id = null ;
      
  	public String dataType = null;
  }
  
  public static class QueueInfo
  {
	public String id = null ;
    
	public String uniqueId = null;
    
	public long size = -1 ;
    
	public String type = null ;
    
	public String dataType = null;
    
	public DirectionType direction = null ;
  }
  
  public static class SampleInfo
  {
	public String id = null ;
    
	public String uniqueId = null;
    
	public long refresh = -1 ;
    
	public String dataType = null;
    
	public DirectionType direction = null ;
  }
  
  public static class BufferInfo
  {
	public String id = null ;
    
	public String uniqueId = null;
    
	public long refresh = -1 ;
    
	public String dataType = null;
    
	public DirectionType direction = null ;
  }
}






/*
TODO

****** ALL EXAMPLE :

KERNEL

deployment.h

  #define POK_CONFIG_NB_NODES 1


****** BUFFER EXAMPLE:

KERNEL

  #define POK_CONFIG_NB_LOCKOBJECTS 1 (also for blackboard and event and buffer)
DONE  deploymentHeaderCode.addOutputNewline("#define POK_CONFIG_NB_BUSES 0"); 


PART

main.h

  #define POK_CONFIG_NB_BUFFERS 1
  #define POK_NEEDS_BUFFERS 1
  #define POK_NEEDS_ARINC653_BUFFER 1
  
  #include <arinc653/buffer.h>
  
deployment.c

  uint8_t input_id;
  char* pok_buffers_names[POK_CONFIG_NB_BUFFERS] = {"input"};
  
activity.c
  
  test__myint input_dvalue; ?????????????
  extern BUFFER_ID_TYPE input_id;
  
main.c

  extern BUFFER_ID_TYPE input_id;
  CREATE_BUFFER ("input", sizeof (BUFFER_ID_TYPE), 1, FIFO, &(input_id), &(ret));  

****** EVENT EXAMPLE :

PART

main.h 

#define POK_CONFIG_NB_EVENTS 1
#define POK_NEEDS_EVENTS 1
#define POK_CONFIG_ARINC653_NB_EVENTS 1
#define POK_NEEDS_ARINC653_EVENT 1

#include <arinc653/event.h>

deployment.c

EVENT_ID_TYPE input_id;
char* pok_arinc653_events_names[POK_CONFIG_ARINC653_NB_EVENTS] = {"input"};

main.c

extern EVENT_ID_TYPE input_id;

CREATE_EVENT ("input", &(input_id), &(ret));

*/