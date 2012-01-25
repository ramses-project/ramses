package fr.tpt.aadl.ramses.generator.pok.c;

import java.io.BufferedWriter ;
import java.io.File ;
import java.io.FileWriter ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.HashSet ;
import java.util.List ;
import java.util.Map ;
import java.util.Map.Entry ;
import java.util.Set ;

import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ConnectedElement ;
import org.osate.aadl2.ConnectionEnd ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.MemorySubcomponent ;
import org.osate.aadl2.Port ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.ThreadImplementation ;
import org.osate.aadl2.ThreadSubcomponent ;
import org.osate.aadl2.VirtualProcessorSubcomponent ;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance ;
import org.osate.aadl2.instance.ConnectionReference ;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;

import fr.tpt.aadl.ramses.control.support.generator.AadlTargetUnparser ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.TargetProperties ;
import fr.tpt.aadl.ramses.generator.c.AadlToCSwitchProcess ;
import fr.tpt.aadl.ramses.generator.c.GenerationUtilsC ;
import fr.tpt.aadl.ramses.generator.target.specific.GeneratorUtils ;
import fr.tpt.aadl.ramses.transformation.atl.hooks.impl.HookAccessImpl ;
import fr.tpt.aadl.ramses.util.properties.PropertyUtils ;

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
  
  public void process(ProcessorSubcomponent processor,
                      File generatedFilePath,
                      TargetProperties tarProp) 
                                                     throws GenerationException
  { 
    PokProperties processorProp = new PokProperties() ;
    ComponentInstance processorInst = (ComponentInstance) HookAccessImpl.
                                             getTransformationTrace(processor) ;
    RoutingProperties routing = (RoutingProperties) tarProp ;
    
    // Discard older processor properties !
    routing.processorProp = processorProp ;
    
    // Generate deployment.h
    AadlToCSwitchProcess deploymentHeaderCode = new AadlToCSwitchProcess(null) ;
    genDeploymentHeader(processor, deploymentHeaderCode, processorProp) ;
    
    // Generate deployment.c
    AadlToCSwitchProcess deploymentImplCode = new AadlToCSwitchProcess(null) ;
    genDeploymentImpl(processor, deploymentImplCode, processorProp) ;
    
    // Generate routing.h
    AadlToCSwitchProcess routingHeaderCode = new AadlToCSwitchProcess(null) ;
    genRoutingHeader(processorInst, routingHeaderCode, routing) ;

    // Generate routing.c
    AadlToCSwitchProcess routingImplCode = new AadlToCSwitchProcess(null) ;
    genRoutingImpl(processorInst, routingImplCode, routing) ;
    
    try
    {
      saveFile(generatedFilePath, "deployment.h",
               deploymentHeaderCode.getOutput()) ;
      
      saveFile(generatedFilePath, "deployment.c",
               deploymentImplCode.getOutput()) ;
      
      saveFile(generatedFilePath, "routing.h", routingHeaderCode.getOutput()) ;

      saveFile(generatedFilePath, "routing.c", routingImplCode.getOutput()) ;
    }
    catch(IOException e)
    {
      // TODO : error message to handle.
      e.printStackTrace() ;
    }
  }
  
  private void blackboardHandler(FeatureInstance fi, PartitionProperties pp)
  {
    // XXX is it right ???    
    String id = RoutingProperties.getFeatureLocalIdentifier(fi) ;
    
    // TODO BIND THE TWO PORTS !!!! Otherwise see OR DO
    
    pp.blackboardNames.add(id) ;
    
    System.out.println("blackboard found : " + id) ;
    
    // OR DO :
    /*
    EList<Subcomponent> subcmpts = process.getAllSubcomponents() ;
    
    for(Subcomponent s : subcmpts)
    {
      if(s instanceof DataSubcomponent)
      {
      if(s.getClassifier().getQualifiedName()
                                        .equalsIgnoreCase(BLACKBOARD_AADL_TYPE))
        {
          pp.blackboardNames.add(s.getName()) ;
        }
    */
    
  }
  
  private void queueHandler(FeatureInstance fi, PartitionProperties pp)
  {
    ConnectionInstance ci = null ;
    ConnectionReference cf = null ;
    ConnectedElement c = null ;
    
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
    pp.queue.add(p) ;
  }
  
  private void genQueueMainImpl(PartitionProperties pp) throws Exception
  {
    // TODO How to generate queue id ?
    String id = "" ;
    
    for(Port p : pp.queue)
    {
      System.out.println("port : " + p.getName()) ;
            
      if(DirectionType.OUT == p.getDirection())
        System.out.println("Direction : SOURCE") ;
      else
        System.out.println("Direction : DESTINATION") ;
      
      System.out.println("Queue_Processing_Protocol : " + PropertyUtils.getEnumValue(p, "Queue_Processing_Protocol")) ;
      
      System.out.println("Queue_Size : " + PropertyUtils.getIntValue(p, "Queue_Size")) ;
      
      
    }
    
    
  }
  
  public void process(ProcessSubcomponent process, File generatedFilePath,
                      TargetProperties tarProp)
  {
    PartitionProperties pp = new PartitionProperties();
    RoutingProperties routing = (RoutingProperties) tarProp ;
    // ****** WORK IN PROGRESS
    
    ProcessImplementation processImpl = (ProcessImplementation) 
                                          process.getComponentImplementation() ;
    
    ComponentInstance processInst = (ComponentInstance) HookAccessImpl.
                                               getTransformationTrace(process) ;
    boolean needRoutage = false ;
    
    for(ComponentInstance ci : processInst.getComponentInstances())
    {
      if (ComponentCategory.THREAD != ci.getCategory())
      {
        continue ;
      }
      // else
      
      // Fetches thread's feature instances.
      for (FeatureInstance fi : ci.getFeatureInstances())
      {
        FeatureCategory cat = fi.getCategory() ;
        System.out.println("##### FEATURE INSTANCE : "+ fi.getName() + ", CAT : " + cat.getLiteral());
        
        if(FeatureCategory.DATA_PORT != cat &&
           FeatureCategory.EVENT_PORT != cat &&
           FeatureCategory.EVENT_DATA_PORT != cat)
        {
          continue ; 
        }
        // else
        
        needRoutage = RoutingProperties.needsRoutage(fi) ;
        
        switch(cat)
        {
          case DATA_PORT :
          {
            if(needRoutage)
            {
              pp.hasSampling = true ;
              // samplingHandler() ;
            }
            else
            {
              pp.hasBlackboard = true ;
//              blackboardHandler(fi, pp);
            }
            
            break ;
          }
          
          case EVENT_PORT :
          {
            if(needRoutage)
            {
              pp.hasQueue = true ;
              // queueHandler() ;
            }
            else
            {
              pp.hasEvent = true ;
              // eventHandler() ;
            }
            
            break ;
          }
          
          case EVENT_DATA_PORT :
          {
            if(needRoutage)
            {
              pp.hasQueue = true ;
              queueHandler(fi, pp) ;
            }
            else
            {
              pp.hasBuffer = true ;
              // bufferHandler() ;
            }
            
            break ;
          }
          
          default:
          {
            // Nothing to do.
          }
        }
      }
    }
    
    if(pp.hasBlackboard)
    {
      // blackboardHandler(fi, pp);
    }
    
//    System.out.println("&&&&&&&&&&&&& FOR PROCESS INST : " + processInst.getName()) ;
  System.out.println("***** FOR PROCESS SUB : " + process.getName()) ;
  
  System.out.println("hasBlackboard : " + pp.hasBlackboard) ;
  System.out.println("hasQueue : " + pp.hasQueue) ;  
    
    try
    {
      genQueueMainImpl(pp) ;
    }
    catch(Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    // ******
    
    // Generate main.h
    AadlToCSwitchProcess mainHeaderCode = new AadlToCSwitchProcess(null) ;
    genMainHeader(processImpl, mainHeaderCode, routing.processorProp, pp);
    
    // Generate main.c
    AadlToCSwitchProcess mainImplCode = new AadlToCSwitchProcess(null) ;
    genMainImpl(processImpl, mainImplCode, pp) ;
    
    try
    {
      saveFile(generatedFilePath, "main.h",
               mainHeaderCode.getOutput()) ;
      
      saveFile(generatedFilePath, "main.c",
               mainImplCode.getOutput()) ;
    }
    catch(IOException e)
    {
      // TODO : error message to handle.
      e.printStackTrace() ;
    }
  }
  
  //Generate global variables.
  private void genMainGlobalVariables(EList<ThreadSubcomponent> lthreads,
                               AadlToCSwitchProcess mainImplCode,
                               PartitionProperties pp)
  {
    // Preconditions
    
    if(false == lthreads.isEmpty() ||
       false == pp.blackboardNames.isEmpty())
    {
      StringBuilder sb = new StringBuilder() ;
      
      mainImplCode.addOutputNewline(GenerationUtilsC.generateSectionMark()) ;
      mainImplCode.addOutputNewline(GenerationUtilsC
            .generateSectionTitle("GLOBAL VARIABLES")) ;
      
      if(false == lthreads.isEmpty())
      {
        mainImplCode
              .addOutputNewline(
                      "PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];") ;
      }

      if(false == pp.blackboardNames.isEmpty())
      {
        // Generate blackboards names array.
        sb.append("char* pok_blackboards_names[POK_CONFIG_NB_BLACKBOARDS] = {") ;

        for(String name : pp.blackboardNames)
        {
          sb.append('\"') ;
          sb.append(name) ;
          sb.append('\"') ;
        }

        sb.append("};") ;
        mainImplCode.addOutputNewline(sb.toString()) ;
        // Generate external variable (declared in deployment.c).
        sb.setLength(0) ; // Reset string builder.

        for(String name : pp.blackboardNames)
        {
          sb.append("extern BLACKBOARD_ID_TYPE ") ;
          sb.append(name) ;
          sb.append(";\n") ;
        }

        mainImplCode.addOutput(sb.toString()) ;
      }

      mainImplCode.addOutputNewline(GenerationUtilsC.generateSectionMark()) ;
    }
  }
  
  private void genMainFileIncluded(AadlToCSwitchProcess mainImplCode)
  {
    // Files included.
    mainImplCode.addOutputNewline(GenerationUtilsC.generateSectionMark()) ;
    mainImplCode.addOutputNewline(GenerationUtilsC
                                  .generateSectionTitle("INCLUSION")) ;
    
    mainImplCode.addOutputNewline("#include \"main.h\"") ;
    mainImplCode.addOutputNewline("#include \"activity.h\"") ;
  }
  
  private void genMainThreadDeclaration(ThreadSubcomponent thread,
                                        int threadIndex,
                                        AadlToCSwitchProcess mainImplCode)
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
  
  private void genBlackboardMainImpl(AadlToCSwitchProcess mainImplCode,
                                     PartitionProperties pp)
  {
    // For each blackboard
    for(String name : pp.blackboardNames)
    {
      mainImplCode.addOutput("  CREATE_BLACKBOARD (\"") ;
      mainImplCode.addOutput(name) ;
      mainImplCode.addOutput("\", sizeof (int), &(") ;
      mainImplCode.addOutput(name);
      mainImplCode.addOutputNewline("), &(ret));") ;
    }
  }
  
  private void genMainImpl(ProcessImplementation process,
                           AadlToCSwitchProcess mainImplCode,
                           PartitionProperties pp)
  {
    EList<ThreadSubcomponent> lthreads =
                                         process.getOwnedThreadSubcomponents() ;
    
    // Included files.
    genMainFileIncluded(mainImplCode) ;
    
    // Global files.
    genMainGlobalVariables(lthreads, mainImplCode, pp);
    
    // main function declaration.
    mainImplCode.addOutputNewline(GenerationUtilsC
          .generateSectionTitle("MAIN")) ;
    mainImplCode.addOutputNewline("int main ()") ;
    mainImplCode.addOutputNewline("{") ;
    mainImplCode.addOutputNewline("  PROCESS_ATTRIBUTE_TYPE tattr;") ;
    mainImplCode.addOutputNewline("  RETURN_CODE_TYPE ret;") ;
    
    // For each declared thread
    // Zero stands for ARINC's IDL thread.
    int threadIndex = 1 ;
    
    // Thread declarations.
    for(ThreadSubcomponent thread : lthreads)
    {
      genMainThreadDeclaration(thread, threadIndex, mainImplCode) ;
      threadIndex++ ;
    }
    
    // Blackboard declarations.
    genBlackboardMainImpl(mainImplCode, pp) ;
    
    mainImplCode
          .addOutputNewline("  SET_PARTITION_MODE (NORMAL, &(ret));") ;
    mainImplCode.addOutputNewline("  return (0);") ;
    mainImplCode.addOutputNewline("}") ;
    mainImplCode.addOutputNewline(GenerationUtilsC.generateSectionMark()) ;
  }
  
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
          pp.blackboardNames.add(s.getName()) ;
        }
        else if(s.getClassifier().getQualifiedName()
                .equalsIgnoreCase(QUEUING_AADL_TYPE))
        {
          pp.queuingNames.add(s.getName());
        }
        else if(s.getClassifier().getQualifiedName()
                .equalsIgnoreCase(SAMPLING_AADL_TYPE))
        {
          pp.samplingNames.add(s.getName());
        }
      }
    }
  }
  
  private PartitionProperties genMainHeader(ProcessImplementation process,
                                            AadlToCSwitchProcess mainHeaderCode,
                                            PokProperties processorProp,
                                            PartitionProperties pp)
  {
//    PartitionProperties result = new PartitionProperties() ;
    
//    findCommunicationMechanism(process, result) ;
    
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
    
    int blackboardNeeded = (pp.blackboardNames.isEmpty()) ? 0 : 1 ;

    if(false == pp.blackboardNames.isEmpty())
    {
      mainHeaderCode
            .addOutputNewline("#define POK_CONFIG_NB_BLACKBOARDS " +
                  pp.blackboardNames.size()) ;
      mainHeaderCode
            .addOutputNewline("#define POK_NEEDS_ARINC653_BLACKBOARD 1") ;
    }

    if(blackboardNeeded>0)
      mainHeaderCode
          .addOutputNewline("#define POK_NEEDS_BLACKBOARDS " + blackboardNeeded) ;
    
    int queuingNeeded = 1 ; //(result.queuingNames.isEmpty()) ? 0 : 1 ;
    if(queuingNeeded>0)
      mainHeaderCode.addOutputNewline("#define POK_NEEDS_ARINC653_QUEUEING " +
                                       queuingNeeded) ;
    
    int samplingNeeded = (pp.samplingNames.isEmpty()) ? 0 : 1 ;
    if(samplingNeeded>0)
      mainHeaderCode.addOutputNewline("#define POK_NEEDS_ARINC653_SAMPLING " +
                                       samplingNeeded) ;

    mainHeaderCode
    	.addOutputNewline("#define POK_CONFIG_STACKS_SIZE " +
    			Long.toString(processorProp.requiredStackSizePerPartition.get(process)));
    
    // XXX Is there any condition for the generation of theses directives ?
    mainHeaderCode
          .addOutputNewline("#define POK_NEEDS_ARINC653_TIME 1") ;
    mainHeaderCode
          .addOutputNewline("#define POK_NEEDS_ARINC653_PROCESS 1") ;
    mainHeaderCode
          .addOutputNewline("#define POK_NEEDS_ARINC653_PARTITION 1") ;

    // XXX Is there any condition for the generation of POK_NEEDS_MIDDLEWARE ?
    mainHeaderCode
          .addOutputNewline("#define POK_NEEDS_MIDDLEWARE 1") ;
    
    /**** "#INCLUDE ****/
    
    // always files included:
    mainHeaderCode.addOutputNewline("#include <arinc653/types.h>");
    mainHeaderCode.addOutputNewline("#include <arinc653/process.h>");
    mainHeaderCode.addOutputNewline("#include <arinc653/partition.h>");
    
    // conditioned files included:
    
    if(false == pp.blackboardNames.isEmpty())
    {
      mainHeaderCode.addOutputNewline("#include <arinc653/blackboard.h>");
    }
    
    mainHeaderCode.addOutputNewline("#endif") ;
    
    return pp ;
  }

  private void saveFile(File directory,
                        String fileName,
                        String content) throws IOException
  {
    BufferedWriter output ;
    
    FileWriter file =
          new FileWriter(directory.getAbsolutePath() + "/" + fileName) ;
    
    output = new BufferedWriter(file) ;
    
    output.write(content) ;
    
    output.close() ;
  }
  
  private void genDeploymentImpl(ProcessorSubcomponent processor,
                                 AadlToCSwitchProcess deploymentImplCode,
                                 PokProperties pokProp)
  {
    deploymentImplCode.addOutputNewline("#include <types.h>") ;
    deploymentImplCode.addOutputNewline("#include \"deployment.h\"") ;    
  }
  
  private void genDeploymentHeader(ProcessorSubcomponent processor,
                                   AadlToCSwitchProcess deploymentHeaderCode,
                                   PokProperties processorProp)
                                                      throws GenerationException
  {
    String guard = GenerationUtilsC.generateHeaderInclusionGuard("deployment.h") ;

    deploymentHeaderCode.addOutputNewline(guard) ;

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
            processorProp.consoleFound = true ;
            break ;
          }
        }

        for(String s : additionalFeatures)
        {
          if(s.equalsIgnoreCase("libc_stdio"))
          {
            processorProp.stdioFound = true ;
            break ;
          }
        }

        for(String s : additionalFeatures)
        {
          if(s.equalsIgnoreCase("libc_stdlib"))
          {
            processorProp.stdlibFound = true ;
            break ;
          }
        }
      }
      catch(Exception e)
      {
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
        e.printStackTrace() ;
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

    for(ProcessSubcomponent ps : bindedProcess)
    {
      ProcessImplementation process =
            (ProcessImplementation) ps.getComponentImplementation() ;
      if(!processorProp.partitionProperties.containsKey(process))
      {
        PartitionProperties pp = new PartitionProperties() ;
        processorProp.partitionProperties.put(process, pp) ;
        findCommunicationMechanism(process, pp) ;
      }
      PartitionProperties pp = processorProp.partitionProperties.get(process) ;
      if(pp.blackboardNames.isEmpty() == false)
      {
        deploymentHeaderCode
              .addOutputNewline("#define POK_NEEDS_LOCKOBJECTS 1") ;
        break ;
      }
    }

    deploymentHeaderCode
          .addOutput("#define POK_CONFIG_PARTITIONS_NLOCKOBJECTS {") ;
    for(ProcessSubcomponent ps : bindedProcess)
    {
      PartitionProperties pp =
            processorProp.partitionProperties.get((ProcessImplementation) ps
                  .getComponentImplementation()) ;
      deploymentHeaderCode.addOutput(Integer
            .toString(pp.blackboardNames.size())) ;
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
          processorProp.requiredStackSize += partitionStack ;
          processorProp.requiredStackSizePerPartition.put(pi, partitionStack) ;
        }
        catch(Exception e)
        {
          processorProp.requiredStackSize += DEFAULT_REQUIRED_STACK_SIZE ;
          processorProp.requiredStackSizePerPartition
                .put(pi, DEFAULT_REQUIRED_STACK_SIZE) ;
        }
      }
    }

    deploymentHeaderCode.addOutputNewline("#define POK_CONFIG_STACKS_SIZE " +
          Long.toString(processorProp.requiredStackSize)) ;

    deploymentHeaderCode.addOutputNewline("#endif") ;
  }                                            

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
  
  /*
  private void processComponentInstance(ComponentInstance component,
                                        File generatedFilePath,
                                        RoutingProperties routing)
  {
    if(component.getCategory().equals(ComponentCategory.PROCESSOR))
    {
      try
      {
        File processorDir = new File(generatedFilePath + "/" + component.
                                                  getSubcomponent().getName()) ;
        if(!processorDir.isDirectory())
        {
          processorDir.mkdir() ;
        }

        File kernelDir = new File(processorDir + "/kernel") ;
        if(!kernelDir.isDirectory())
        {
          kernelDir.mkdir() ;
        }

        // Generate routing.h
        AadlToCSwitchProcess routingHeaderCode = new AadlToCSwitchProcess(null) ;
        genRoutingHeader(component, routingHeaderCode, routing) ;

        // Generate routing.c
        AadlToCSwitchProcess routingImplCode = new AadlToCSwitchProcess(null) ;
        genRoutingImpl(component, routingImplCode, routing) ;

        saveFile(kernelDir, "routing.h", routingHeaderCode.getOutput()) ;

        saveFile(kernelDir, "routing.c", routingImplCode.getOutput()) ;

      }
      catch(GenerationException e)
      {
        // TODO : error message to handle.
        e.printStackTrace() ;
      }
      catch(IOException e)
      {
        // TODO : error message to handle.
        e.printStackTrace() ;
      }
    }
    else
    {
      for(ComponentInstance subComponent : component.getComponentInstances())
      {
        processComponentInstance(subComponent, generatedFilePath, routing) ;
      }
    }
  }
  */
  
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
                                AadlToCSwitchProcess routingHeaderCode,
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
		
	  List<FeatureInstance> locaPorts = getLocalPorts(processor, routeProp);
	  int localPortNb = locaPorts.size();
	  
	  routingHeaderCode.addOutputNewline("#define POK_CONFIG_NB_PORTS " +
			  Integer.toString(localPortNb));

	  routingHeaderCode.addOutputNewline("#define POK_CONFIG_NB_NODES " +
			  Integer.toString(routeProp.processors.size())) ;

	  routingHeaderCode.addOutputNewline("typedef enum") ;
	  routingHeaderCode.addOutputNewline("{") ;
	  routingHeaderCode.incrementIndent() ;
	  int idx=0;
	  for(ComponentInstance node : routeProp.processors)
	  {
		routingHeaderCode.addOutput(RoutingProperties.getComponentInstanceIdentifier(node)) ;
		routingHeaderCode.addOutput(" = "+Integer.toString(idx));
		routingHeaderCode.addOutputNewline(",") ;
		idx++;
	  }
	  routingHeaderCode.decrementIndent() ;
	  routingHeaderCode.addOutputNewline("} pok_node_identifier_t;") ;

	  List<FeatureInstance> localPorts = getLocalPorts(processor, routeProp);
	  idx=0;

	  routingHeaderCode.addOutputNewline("typedef enum") ;
	  routingHeaderCode.addOutputNewline("{") ;
	  routingHeaderCode.incrementIndent() ;
	  for(FeatureInstance fi: localPorts)
	  {
		routingHeaderCode.addOutput(RoutingProperties.getFeatureLocalIdentifier(fi));
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
		  routingHeaderCode.addOutput(RoutingProperties.getFeatureGlobalIdentifier(fi));
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
		routingHeaderCode.addOutput(RoutingProperties.getComponentInstanceIdentifier(bus));
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
                              AadlToCSwitchProcess routingImplCode,
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
		routingImplCode.addOutput(RoutingProperties.getFeatureLocalIdentifier(fi));
		routingImplCode.addOutput(",");
	  }
	  routingImplCode.addOutputNewline("};");
	  
	  // compute list of destination ports for each port of partitions deployed on "processor"
	  for(FeatureInstance fi : routeProp.portPerProcess.get(deployedProcess))
	  {
		if(fi.getDirection().equals(DirectionType.OUT)
				|| fi.getDirection().equals(DirectionType.IN_OUT))
		{
		  List<FeatureInstance> destinations = routeProp.getFeatureDestinations(fi);
		  routingImplCode.addOutput("uint8_t ");
		  routingImplCode.addOutput(RoutingProperties.getFeatureLocalIdentifier(fi)+
				  "_deployment_destinations["+
				  Integer.toString(destinations.size())+"] = {");
		  for(FeatureInstance dst:destinations)
		  {
			routingImplCode.addOutput(RoutingProperties.getFeatureGlobalIdentifier(dst));
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
		routingImplCode.addOutput(RoutingProperties.getFeatureLocalIdentifier(fi));
	  else
		routingImplCode.addOutput("invalid_local_port");
	  
	  routingImplCode.addOutput(",");
	}
	routingImplCode.addOutputNewline("};");
	
	routingImplCode.addOutput("uint8_t pok_local_ports_to_global_ports" +
			"[POK_CONFIG_NB_PORTS] = {");
	for(FeatureInstance fi:localPorts)
	{
	  routingImplCode.addOutput(RoutingProperties.getFeatureGlobalIdentifier(fi));
	  routingImplCode.addOutput(",");
	}
	routingImplCode.addOutputNewline("};");
	
	routingImplCode.addOutput("uint8_t pok_ports_nodes" +
			"[POK_CONFIG_NB_GLOBAL_PORTS] = {");
	for(FeatureInstance fi : routeProp.globalPort)
	{
	  ComponentInstance inst = routeProp.processorPort.get(fi);
	  routingImplCode.addOutput(RoutingProperties.getComponentInstanceIdentifier(inst));
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
			  RoutingProperties.getFeatureLocalIdentifier(fi)
			  +"\"");
	  routingImplCode.addOutput(",");
	}
	routingImplCode.addOutputNewline("};");
	
	routingImplCode.addOutput("uint8_t pok_ports_identifiers" +
			"[POK_CONFIG_NB_PORTS] = {");
	for(FeatureInstance fi: localPorts)
	{
	  routingImplCode.addOutput(""+
			  RoutingProperties.getFeatureLocalIdentifier(fi)
			  +"");
	  routingImplCode.addOutput(",");
	}
	routingImplCode.addOutputNewline("};");
	
	routingImplCode.addOutput("uint8_t pok_ports_nb_destinations" +
			"[POK_CONFIG_NB_PORTS] = {");
	for(FeatureInstance fi: localPorts)
	{
	  int destNb = routeProp.getFeatureDestinations(fi).size();
	  routingImplCode.addOutput(Integer.toString(destNb));
	  routingImplCode.addOutput(",");
	}
	routingImplCode.addOutputNewline("};");
	
	routingImplCode.addOutput("uint8_t* pok_ports_destinations" +
			"[POK_CONFIG_NB_PORTS] = {");
	for(FeatureInstance fi: localPorts)
	{
	  int destNb = routeProp.getFeatureDestinations(fi).size();
	  if(destNb==0)
		  routingImplCode.addOutput("NULL");
	  else
		  routingImplCode.addOutput(RoutingProperties.getFeatureLocalIdentifier(fi)
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
}

class PartitionProperties
{
  public boolean hasBlackboard = false ; 
  
  public boolean hasQueue = false ;
  
  public boolean hasBuffer = false ;
  
  public boolean hasEvent = false ;
  
  public boolean hasSampling = false ;
  
  public Set<String> blackboardNames = new HashSet<String>() ;
  
  public Set<Port> queue = new HashSet<Port>() ;
  
  public Set<String> queuingNames = new HashSet<String>() ;
  
  public Set<String> samplingNames = new HashSet<String>() ;
}