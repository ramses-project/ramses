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
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.BooleanLiteral ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.DataPort ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.DirectionType ;
import org.osate.aadl2.EventDataPort ;
import org.osate.aadl2.MemorySubcomponent ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.NumberValue ;
import org.osate.aadl2.Port ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorImplementation ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.ThreadImplementation ;
import org.osate.aadl2.ThreadSubcomponent ;
import org.osate.aadl2.VirtualProcessorSubcomponent ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.ConnectionInstance ;
import org.osate.aadl2.instance.FeatureCategory ;
import org.osate.aadl2.instance.FeatureInstance ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.UnparseText ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.utils.AadlBaVisitors ;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.control.atl.hooks.impl.HookAccessImpl ;
import fr.tpt.aadl.ramses.control.support.generator.AadlTargetUnparser ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.TargetProperties ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.utils.FileUtils ;
import fr.tpt.aadl.ramses.generation.c.GenerationUtilsC ;
import fr.tpt.aadl.ramses.generation.utils.GeneratorUtils ;
import fr.tpt.aadl.ramses.generation.utils.RoutingProperties ;

public class AadlToPokCUnparser implements AadlTargetUnparser
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
  
  //TODO : be refactored with generic interfaces.
  private void blackBoardHandler(String id, FeatureInstance fi, PartitionProperties pp)
  {

    BlackBoardInfo blackboardInfo = new BlackBoardInfo() ;
    blackboardInfo.id = id;

    if(fi.getCategory() == FeatureCategory.DATA_PORT)
    {
      DataPort p  = (DataPort) fi.getFeature() ;
      if(isUsedInFresh(fi))
    		  blackboardInfo.dataType=GenerationUtilsC.getGenerationCIdentifier(pp.prefix)+p.getDataFeatureClassifier().getName()+"_freshness_t_impl" ;
      else
      {
    	  String value = PropertyUtils.getStringValue(p.getDataFeatureClassifier(),
    	                                              "Source_Name") ;
    	  if(value != null)
    	  {
    		  blackboardInfo.dataType=value ;
    	  }
    	  else
    	  {
    		  blackboardInfo.dataType = GenerationUtilsC.getGenerationCIdentifier(p.getDataFeatureClassifier().getQualifiedName()) ;
    	  }
      }
    }
    pp.blackboardInfo.add(blackboardInfo); 

  }
  
  private boolean isUsedInFresh(FeatureInstance fi)
  {
    if(fi.getComponentInstance().getCategory() == ComponentCategory.PROCESS)
    {
      ComponentInstance process = fi.getComponentInstance() ;
      for(ComponentInstance thread : process.getComponentInstances())
      {
        if(!thread.getCategory().equals(ComponentCategory.THREAD))
          continue ;
        for(FeatureInstance threadFeature : thread.getFeatureInstances())
        {
          if(threadFeature.getDirection() == DirectionType.IN)
          {
            for(ConnectionInstance cnxInst : threadFeature
                  .getDstConnectionInstances())
            {
              int last = cnxInst.getConnectionReferences().size() - 1 ;
              if(cnxInst.getConnectionReferences().get(last).getSource() == fi)
              {
                if(isUsedInFresh((FeatureInstance) cnxInst
                      .getConnectionReferences().get(last).getDestination()))
                  return true ;
              }
            }
          }
          if(threadFeature.getDirection() == DirectionType.OUT)
          {
            for(ConnectionInstance cnxInst : threadFeature
                  .getSrcConnectionInstances())
            {
              if(cnxInst.getConnectionReferences().get(0).getDestination() == fi)
              {
                if(isUsedInFresh((FeatureInstance) cnxInst
                      .getConnectionReferences().get(0).getSource()))
                  return true ;
              }
            }
          }
        }
      }
    }
    if(fi.getComponentInstance().getCategory() == ComponentCategory.THREAD)
    {
      Port p = (Port) fi.getFeature() ;
      BehaviorAnnex ba = getBa(fi) ;
      if(ba != null)
      {
        if(AadlBaVisitors.isFresh(ba, p))
          return true ;
        for(ConnectionInstance cnxi : fi.getSrcConnectionInstances())
        {
          if(cnxi.getSource() instanceof FeatureInstance)
          {
            FeatureInstance f = (FeatureInstance) cnxi.getSource() ;
            ba = getBa(f) ;
            if(f.getFeature() instanceof Port &&
                  AadlBaVisitors.isFresh(ba, (Port) f.getFeature()))
              return true ;
          }
          if(cnxi.getDestination() instanceof FeatureInstance)
          {
            FeatureInstance f = (FeatureInstance) cnxi.getDestination() ;
            ba = getBa(f) ;
            if(f.getFeature() instanceof Port &&
                  AadlBaVisitors.isFresh(ba, (Port) f.getFeature()))
              return true ;
          }

        }
        for(ConnectionInstance cnxi : fi.getDstConnectionInstances())
        {
          if(cnxi.getSource() instanceof FeatureInstance)
          {
            FeatureInstance f = (FeatureInstance) cnxi.getSource() ;
            ba = getBa(f) ;
            if(f.getFeature() instanceof Port &&
                  AadlBaVisitors.isFresh(ba, (Port) f.getFeature()))
              return true ;
          }
          if(cnxi.getDestination() instanceof FeatureInstance)
          {
            FeatureInstance f = (FeatureInstance) cnxi.getDestination() ;
            ba = getBa(f) ;
            if(f.getFeature() instanceof Port &&
                  AadlBaVisitors.isFresh(ba, (Port) f.getFeature()))
              return true ;
          }
        }
      }
    }
    return false ;
  }

  private BehaviorAnnex getBa(FeatureInstance fi)
  {
    ComponentInstance ci = (ComponentInstance) fi.eContainer() ;
    BehaviorAnnex ba = null ;
    for(AnnexSubclause as : ci.getSubcomponent().getClassifier()
          .getOwnedAnnexSubclauses())
    {
      if(as.getName().equalsIgnoreCase("behavior_specification"))
      {
        ba = (BehaviorAnnex) as ;
        break ;
      }
    }
    return ba ;
  }

//TODO : be refactored with generic interfaces.
  private void queueHandler(String id, FeatureInstance fi, PartitionProperties pp)
  {
    Port p = (Port) fi.getFeature() ;
    
    QueueInfo queueInfo = new QueueInfo() ;
    
    queueInfo.id = id;
    queueInfo.uniqueId = AadlToPokCUtils.getFeatureLocalIdentifier(fi);
    queueInfo.direction = p.getDirection() ;
    
    if(fi.getCategory() == FeatureCategory.EVENT_DATA_PORT)
    {
      EventDataPort port  = (EventDataPort) fi.getFeature() ;
      if(isUsedInFresh(fi))
    	  queueInfo.dataType=GenerationUtilsC.getGenerationCIdentifier(pp.prefix)+port.getDataFeatureClassifier().getName()+"_freshness_t_impl" ;
      else
      {
        String value = PropertyUtils.getStringValue(port.getDataFeatureClassifier(),
                                                    "Source_Name") ;
        if(value != null)
        {
          queueInfo.dataType=value ;
        }
        else
        {
    	  queueInfo.dataType = GenerationUtilsC.getGenerationCIdentifier(port.getDataFeatureClassifier().getQualifiedName()) ;
        }
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
      if(isUsedInFresh(fi))
    	  queueInfo.dataType=GenerationUtilsC.getGenerationCIdentifier(pp.prefix)+port.getDataFeatureClassifier().getName()+"_freshness_t_impl" ;
      else
      {
        String value = PropertyUtils.getStringValue(port.getDataFeatureClassifier(),
                                                    "Source_Name") ;
        if(value != null)
        {
          queueInfo.dataType=value ;
        }
        else
        {
          queueInfo.dataType = GenerationUtilsC.getGenerationCIdentifier(port.getDataFeatureClassifier().getQualifiedName()) ;
        }
      }
    }
    else if(fi.getCategory() == FeatureCategory.EVENT_PORT)
    {
      queueInfo.dataType="int";
    }
    
    
    if(getQueueInfo((Port)fi.getFeature(), queueInfo))
    {
      pp.bufferInfo.add(queueInfo) ;
    }
    else
    {
      queueInfo.type = "FIFO";
      queueInfo.size = 10;
      pp.bufferInfo.add(queueInfo) ;
    }
    
  }
  
  // Return false QueueInfo object is not completed.
  private boolean getQueueInfo(Port port, QueueInfo info)
  {
    boolean result = true ;
    
    // XXX temporary. Until ATL transformation modifications.
    //  info.id = RoutingProperties.getFeatureLocalIdentifier(fi) ;
    
    if(info.type == null)
    {
      String value = PropertyUtils.getEnumValue(port, "Queue_Processing_Protocol") ;
      if(value != null)
      {
        info.type = value ;
      }
      else
      {
        result = false ;
      }
    }
    
    if(info.size == -1)
    {
      Long value = PropertyUtils.getIntValue(port, "Queue_Size") ;
      if(value != null)
      {
        info.size = value ;
      }
      else
      {
        result = false ;
      }
    }
    
    return result ;
  }
  
  // TODO : be refactored with generic interfaces. 
  private void sampleHandler(String id, FeatureInstance fi, PartitionProperties pp)
  {
    Port p = (Port) fi.getFeature() ;
    
    SampleInfo sampleInfo = new SampleInfo() ;
    sampleInfo.direction = p.getDirection() ;
    
    if(fi.getCategory() == FeatureCategory.DATA_PORT)
    {
      DataPort port  = (DataPort) fi.getFeature() ;
      if(isUsedInFresh(fi))
      {
    	  sampleInfo.dataType=GenerationUtilsC.getGenerationCIdentifier(pp.prefix)+port.getDataFeatureClassifier().getName()+"_freshness_t_impl" ;
      }
      else
      {
    	  String value = PropertyUtils.getStringValue(port.getDataFeatureClassifier(),
    	                                              "Source_Name") ;
    	  if(value != null)
    	  {
    		  sampleInfo.dataType=value ;
    	  }
    	  else
    	  {
    		  sampleInfo.dataType = GenerationUtilsC.getGenerationCIdentifier(port.getDataFeatureClassifier().getQualifiedName()) ;
    	  }
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
    
    if(info.refresh == -1)
    {
      Long value = PropertyUtils.getIntValue(port,
                                             "Sampling_Refresh_Period") ;
      if(value != null)
      {
        info.refresh = value ;
      }
      else
      {
        String msg =  "set default Sampling_Refresh_Period value for sampling port \'" +
                      port.getQualifiedName() + "\'" ;
        _LOGGER.warn(msg);
        ServiceProvider.SYS_ERR_REP.warning(msg, true);

        info.refresh = 10l;
        //TODO: restore and resolve issue with pingpong-ba result = false ;
      }
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
  
  public void process(ProcessSubcomponent process,TargetProperties tarProp,
                      File runtimePath,
                      File outputDir,
                      IProgressMonitor monitor)
  {
	  StringBuilder sb = new StringBuilder(process.getQualifiedName());
    PartitionProperties pp = new PartitionProperties(sb.substring(0, sb.lastIndexOf("::")+2)) ;
    
    ProcessImplementation processImpl = (ProcessImplementation) 
                                          process.getComponentImplementation() ;
    
    this.findCommunicationMechanism(processImpl, pp);
    
    // Generate main.h
    UnparseText mainHeaderCode = new UnparseText() ;
    genMainHeader(processImpl, mainHeaderCode, _processorProp, pp);
    
    // Generate main.c
    UnparseText mainImplCode = new UnparseText() ;
    genMainImpl(processImpl, mainImplCode, pp) ;
    
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
        mainImplCode.addOutput("EVENT_ID_TYPE ") ;
        mainImplCode.addOutput(name) ;
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
  
  private void genSemaphoreMainImpl(UnparseText mainImplCode,
          PartitionProperties pp)
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
    for(ThreadSubcomponent ts:process.getOwnedThreadSubcomponents())
    {
      mainImplCode.addOutputNewline(
    	GenerationUtilsC.getInitializationCall(
    			(ThreadImplementation) ts.getClassifier()
    			)
      );
    }
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

private void findCommunicationMechanism(ProcessImplementation process,
                                          PartitionProperties pp)
  {
    EList<Subcomponent> subcmpts = process.getAllSubcomponents() ;
    
    for(Subcomponent s : subcmpts)
    {
      if(s instanceof DataSubcomponent)
      {
        if(((DataSubcomponent) s).getDataSubcomponentType().getQualifiedName()
              .equalsIgnoreCase(BLACKBOARD_AADL_TYPE))
        {
          blackBoardHandler(s.getName(),
                            (FeatureInstance) HookAccessImpl.
                            getTransformationTrace(s), pp);
          pp.hasBlackboard = true;
        }
        else if(((DataSubcomponent) s).getDataSubcomponentType().getQualifiedName()
              .equalsIgnoreCase(QUEUING_AADL_TYPE))
        {
          queueHandler(s.getName(),
                       (FeatureInstance) HookAccessImpl.
                       getTransformationTrace(s), pp);
          
          pp.hasQueue = true ;
        }
        else if(((DataSubcomponent) s).getDataSubcomponentType().getQualifiedName()
              .equalsIgnoreCase(SAMPLING_AADL_TYPE))
        {
          sampleHandler(s.getName(), (FeatureInstance) HookAccessImpl.
                       getTransformationTrace(s), pp);
          pp.hasSample = true ;
        }
        else if(((DataSubcomponent) s).getDataSubcomponentType().getQualifiedName()
              .equalsIgnoreCase(EVENT_AADL_TYPE))
        {
          pp.eventNames.add(s.getName());
          pp.hasEvent = true ;
        }
        else if(((DataSubcomponent) s).getDataSubcomponentType().getQualifiedName()
              .equalsIgnoreCase(BUFFER_AADL_TYPE))
        {
          bufferHandler(s.getName(),
                       (FeatureInstance) HookAccessImpl.
                       getTransformationTrace(s), pp);
          pp.hasBuffer = true ;
        }
        else if(((DataSubcomponent) s).getDataSubcomponentType().getQualifiedName()
                .equalsIgnoreCase(SEMAPHORE_AADL_TYPE))
        {
          pp.semaphoreNames.add(s.getName());
          pp.hasSemaphore = true;
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
    boolean processorLevelErrors = false;
    List<String> errorIdList=PropertyUtils.getStringListValue(processor, "HM_Errors");
    List<String> errorActionList=PropertyUtils.getStringListValue(processor, "HM_Module_Recovery_Actions");
    
    if(errorIdList != null && errorActionList != null)
    {
      processorLevelErrors=true;
    }
    else
    {
      // do nothing
    }
    
    if(processorLevelErrors)
    {
      deploymentImplCode.addOutputNewline("void pok_kernel_error");
      deploymentImplCode.incrementIndent();
      deploymentImplCode.incrementIndent();
      deploymentImplCode.addOutputNewline("(uint32_t error)");
      deploymentImplCode.decrementIndent();
      deploymentImplCode.decrementIndent();
      deploymentImplCode.addOutputNewline("{");
      deploymentImplCode.incrementIndent();
      generateErrorIdSelection(processor, errorIdList, errorActionList, deploymentImplCode);
      deploymentImplCode.addOutputNewline("}");
    }
    
    ProcessorImplementation pi = (ProcessorImplementation) processor.getSubcomponentType();
    boolean partitionLevelErrors=false;
    for(VirtualProcessorSubcomponent vps: pi.getOwnedVirtualProcessorSubcomponents())
    {
      errorIdList = PropertyUtils.getStringListValue(vps, "HM_Errors");
      if(errorIdList != null)
      {
        
        partitionLevelErrors=true;
        break;
      }
      else
      {
        // do nothting
      }
    }
    partitionId=0;
    if(partitionLevelErrors)
    {
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
  	    errorIdList = PropertyUtils.getStringListValue(vps, "HM_Errors");
        errorActionList = PropertyUtils.getStringListValue(vps, "HM_Partition_Recovery_Actions");
  	    if(errorIdList != null && errorActionList != null)
    		{
          deploymentImplCode.addOutputNewline("case "+Integer.toString(partitionId)+":");
    		  deploymentImplCode.incrementIndent();
    		  generateErrorIdSelection(vps, errorIdList, errorActionList, deploymentImplCode);
  	  	}
  	    else
  		  {
  		  // do nothing
    		}
  		
    		deploymentImplCode.decrementIndent();
  	  	deploymentImplCode.addOutputNewline("break;");
  		  partitionId++;
      }
  	  
      deploymentImplCode.addOutputNewline("}");
      deploymentImplCode.decrementIndent();
      deploymentImplCode.addOutputNewline("}");
      deploymentImplCode.decrementIndent();
    }
  }
  
  private void generateErrorIdSelection(NamedElement ne,
		List<String> errorIdList,
		List<String> errorActionList, UnparseText deploymentImplCode) {
    deploymentImplCode.addOutputNewline("switch (error)");
    deploymentImplCode.addOutputNewline("{");
    deploymentImplCode.incrementIndent();
    for(String errorId:errorIdList)
    {
      String actionId = errorActionList.get(errorIdList.indexOf(errorId));
      String pokErrorId="POK_ERROR_KIND_INVALID";
      //Module_Config
      if(errorId.equalsIgnoreCase("Module_Config"))
      {
    	pokErrorId = "POK_ERROR_KIND_KERNEL_CONFIG";
      }
      //Module_Init
      if(errorId.equalsIgnoreCase("Module_Init"))
      {
    	pokErrorId = "POK_ERROR_KIND_KERNEL_INIT";
      }
      //Module_Scheduling
      if(errorId.equalsIgnoreCase("Module_Scheduling"))
      {
    	pokErrorId = "POK_ERROR_KIND_KERNEL_SCHEDULING";
      }
      //Partition_Scheduling
      else if(errorId.equalsIgnoreCase("Partition_Scheduling"))
      {
    	pokErrorId = "POK_ERROR_KIND_PARTITION_SCHEDULING";
      }
      //Partition_Config
      else if(errorId.equalsIgnoreCase("Partition_Config"))
      {
    	pokErrorId = "POK_ERROR_KIND_PARTITION_CONFIGURATION";
      }
      //Partition_Handler
      else if(errorId.equalsIgnoreCase("Partition_Handler"))
      {
    	pokErrorId = "POK_ERROR_KIND_PARTITION_HANDLER";
      }
      //Partition_Init
      else if(errorId.equalsIgnoreCase("Partition_Init"))
      {
    	pokErrorId = "POK_ERROR_KIND_PARTITION_INIT";
      }
      //Deadline_Miss
      else if(errorId.equalsIgnoreCase("Deadline_Miss"))
      {
    	pokErrorId = "POK_ERROR_KIND_DEADLINE_MISSED";
      }
      //Application_Error
      else if(errorId.equalsIgnoreCase("Application_Error"))
      {
    	pokErrorId = "POK_ERROR_KIND_APPLICATION_ERROR";
      }
      //Numeric_Error
      else if(errorId.equalsIgnoreCase("Numeric_Error"))
      {
    	pokErrorId = "POK_ERROR_KIND_NUMERIC_ERROR";
      }
      //Illegal_Request
      else if(errorId.equalsIgnoreCase("Illegal_Request"))
      {
    	pokErrorId = "POK_ERROR_KIND_ILLEGAL_REQUEST";
      }
      //Stack_Overflow
      else if(errorId.equalsIgnoreCase("Stack_Overflow"))
      {
    	pokErrorId = "POK_ERROR_KIND_STACK_OVERFLOW";
      }
      //Memory_Violation
      else if(errorId.equalsIgnoreCase("Memory_Violation"))
      {
    	pokErrorId = "POK_ERROR_KIND_MEMORY_VIOLATION";
      }
      //Hardware_Fault
      else if(errorId.equalsIgnoreCase("Hardware_Fault"))
      {
    	pokErrorId = "POK_ERROR_KIND_HARDWARE_FAULT";
      }
      //Power_Fail
      else if(errorId.equalsIgnoreCase("Power_Fail"))
      {
    	pokErrorId = "POK_ERROR_KIND_POWER_FAIL";
      }
      deploymentImplCode.addOutputNewline("case "+pokErrorId+":");
      deploymentImplCode.addOutputNewline("{");
      deploymentImplCode.incrementIndent();
      
      if(ne instanceof ProcessorImplementation)
    	genModuleErrorAction(deploymentImplCode,actionId);
      else if(ne instanceof VirtualProcessorSubcomponent)
    	genPartitionErrorAction(deploymentImplCode,actionId);
      
      deploymentImplCode.addOutputNewline("break;");
      deploymentImplCode.addOutputNewline("}");
    }
    deploymentImplCode.decrementIndent();
    deploymentImplCode.addOutputNewline("}");
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
      additionalFeatures = PropertyUtils.getStringListValue(vps,
                                                            "Additional_Features") ;
      if(additionalFeatures != null)
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
      else
      {
        String errMsg = "cannot fetch the Additional_Features for \'" +
                                                        vps.getName() + '\'' ;
        _LOGGER.error(errMsg) ;
        ServiceProvider.SYS_ERR_REP.error(errMsg, true) ;
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

    if(System.getProperty("DEBUG")!=null)
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
      boolean foundRR = false ;

      String requiredScheduler = PropertyUtils.getEnumValue(vps, "Scheduler") ;
      if(requiredScheduler != null)
      {
        if(requiredScheduler.equalsIgnoreCase("RR") && foundRR == false)
        {
          foundRR = true ;
          deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_SCHED_RR 1") ;
        }
      }
      else
      {
        String errMsg = "scheduler is not provided for \'" +
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
      String requiredScheduler = PropertyUtils.getEnumValue(vps, "Scheduler") ;
      if(requiredScheduler != null)
      {
        if(requiredScheduler.equalsIgnoreCase("RR"))
        {
          deploymentHeaderCode.addOutput("POK_SCHED_RR") ;
        }

        if(bindedVPS.indexOf(vps) != bindedVPS.size() - 1)
        {
          deploymentHeaderCode.addOutput(",") ;
        }
      }
      else
      {
        String errMsg =  "cannot fetch the scheduler for \'" + vps.getName() + '\'';
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
      if(!_processorProp.partitionProperties.containsKey(process))
      {
    	StringBuilder sb = new StringBuilder(process.getQualifiedName());
        PartitionProperties pp = new PartitionProperties(sb.substring(0, sb.lastIndexOf("::")+2)) ;
        _processorProp.partitionProperties.put(process, pp) ;
        findCommunicationMechanism(process, pp) ;
      }
      PartitionProperties pp = _processorProp.partitionProperties.get(process) ;
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
      PartitionProperties pp =
            _processorProp.partitionProperties.get((ProcessImplementation) ps
                  .getComponentImplementation()) ;
      deploymentHeaderCode.addOutput(Integer
            .toString(pp.blackboardInfo.size()
                      + pp.bufferInfo.size()
                      + pp.eventNames.size()
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
    
    List<Long> slotPerPartition =
        PropertyUtils.getIntListValue(processor, "Partition_Slots") ;
    
    if(slotPerPartition != null)
    {
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
    else
    {
      String errMsg =  "cannot fetch Partition_Slots for \'"+
                                        processor.getName() + '\'' ;
      _LOGGER.error(errMsg);
      ServiceProvider.SYS_ERR_REP.error(errMsg, true);
    }
    
    List<Subcomponent> slotsAllocation =
          PropertyUtils.getSubcomponentList(processor, "Slots_Allocation") ;
    if(! slotsAllocation.isEmpty())
    {
      deploymentHeaderCode.addOutput("#define POK_CONFIG_SCHEDULING_SLOTS_ALLOCATION {") ;

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
    else
    {
      String errMsg = "cannot fetch Slots_Allocation for \'" +
                          processor.getName() + '\'' ;
      _LOGGER.error(errMsg) ;
      ServiceProvider.SYS_ERR_REP.error(errMsg, true) ;
    }
    
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
            PropertyUtils.getIntValue(ts, "Source_Stack_Size") ;
      
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
    
    if(PropertyUtils.getStringListValue(processor, "HM_Errors") != null)
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
      if(PropertyUtils.getStringListValue(vps, "HM_Errors") != null)
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
        if(PropertyUtils.getStringListValue(ts, "HM_Errors") != null)
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
    }

    
    genDeploymentHeaderEnd(deploymentHeaderCode);
    
    deploymentHeaderCode.addOutputNewline("#endif") ;
    
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

	  Set<ComponentInstance> bindedPorcesses = routeProp.processPerProcessor.get(processor);
	  
	  if(!localPorts.isEmpty())
      {
	    routingHeaderCode.addOutput("#define POK_CONFIG_PARTITIONS_PORTS {");
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