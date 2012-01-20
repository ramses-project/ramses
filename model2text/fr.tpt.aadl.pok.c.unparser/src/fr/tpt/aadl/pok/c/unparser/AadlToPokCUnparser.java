package fr.tpt.aadl.pok.c.unparser;

import java.io.BufferedWriter ;
import java.io.File ;
import java.io.FileWriter ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.HashSet ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.Feature ;
import org.osate.aadl2.MemorySubcomponent ;
import org.osate.aadl2.Port ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessType ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.ThreadImplementation ;
import org.osate.aadl2.ThreadSubcomponent ;
import org.osate.aadl2.VirtualProcessorSubcomponent ;

import fr.tpt.aadl.c.unparser.AadlToCSwitchProcess ;
import fr.tpt.aadl.c.unparser.GenerationUtilsC ;
import fr.tpt.aadl.target.specific.generator.GeneratorUtils ;
import fr.tpt.aadl.toolsuite.support.generator.AadlTargetUnparser ;
import fr.tpt.aadl.toolsuite.support.generator.GenerationException ;
import fr.tpt.aadl.toolsuite.support.generator.TargetProperties ;
import fr.tpt.aadl.toolsuite.support.generator.TargetUnparserParameter ;
import fr.tpt.aadl.util.properties.PropertyUtils ;

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
  
  public TargetProperties process(ProcessorSubcomponent processor,
                                  File generatedFilePath) 
                                        throws GenerationException
  {
    PokProperties result = new PokProperties() ;
    
    // Generate deployment.h
    AadlToCSwitchProcess deploymentHeaderCode = new AadlToCSwitchProcess(null) ;
    generateDeploymentHeader(processor, deploymentHeaderCode, result) ;
    
    // Generate deployment.c
    AadlToCSwitchProcess deploymentImplCode = new AadlToCSwitchProcess(null) ;
    generateDeploymentImpl(processor, deploymentImplCode, result) ;
    
    try
    {
      saveFile(generatedFilePath, "deployment.h",
               deploymentHeaderCode.getOutput()) ;
      
      saveFile(generatedFilePath, "deployment.c",
               deploymentImplCode.getOutput()) ;
    }
    catch(IOException e)
    {
      // TODO : error message to handle.
      e.printStackTrace() ;
    }
    return result ;
  }
  
  public void process(ProcessImplementation process, File generatedFilePath,
                      TargetProperties tarProp)
  {
    PartitionProperties pp ;
    
    // Generate main.h
    AadlToCSwitchProcess mainHeaderCode = new AadlToCSwitchProcess(null) ;
    pp = generateMainHeader(process, mainHeaderCode, (PokProperties) tarProp);
    
    // Generate main.c
    AadlToCSwitchProcess mainImplCode = new AadlToCSwitchProcess(null) ;
    generateMainImpl(process, mainImplCode, pp) ;
    
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
  
  private void generateMainImpl(ProcessImplementation process,
                                AadlToCSwitchProcess mainImplCode,
                                PartitionProperties pp)
  {
    StringBuilder sb = new StringBuilder() ;
    
    EList<ThreadSubcomponent> lthreads =
                                         process.getOwnedThreadSubcomponents() ;
    
    // Files included.
    mainImplCode.addOutputNewline(GenerationUtilsC.generateSectionMark()) ;
    mainImplCode.addOutputNewline(GenerationUtilsC
                                  .generateSectionTitle("INCLUSION")) ;
    
    mainImplCode.addOutputNewline("#include \"main.h\"") ;
    mainImplCode.addOutputNewline("#include \"activity.h\"") ;
    
    //Generate global variables.
    mainImplCode.addOutputNewline(GenerationUtilsC.generateSectionMark()) ;
    mainImplCode.addOutputNewline(GenerationUtilsC
          .generateSectionTitle("GLOBAL VARIABLES")) ;
    
    if(false == lthreads.isEmpty())
    {
      mainImplCode
            .addOutputNewline("PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];") ;
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
      sb.setLength(0) ; // Reset string builder.
    }

    mainImplCode.addOutputNewline(GenerationUtilsC.generateSectionMark()) ;
    mainImplCode.addOutputNewline(GenerationUtilsC
          .generateSectionTitle("MAIN")) ;
    mainImplCode.addOutputNewline("int main ()") ;
    mainImplCode.addOutputNewline("{") ;
    mainImplCode.addOutputNewline("  PROCESS_ATTRIBUTE_TYPE tattr;") ;
    mainImplCode.addOutputNewline("  RETURN_CODE_TYPE ret;") ;
    // For each declared thread
    // Zero stands for ARINC's IDL thread.
    int threadIndex = 1 ;

    for(ThreadSubcomponent t : lthreads)
    {
      ThreadImplementation timpl =
            (ThreadImplementation) t.getComponentImplementation() ;
      mainImplCode.addOutput("  tattr.ENTRY_POINT = ") ;
      mainImplCode.addOutput(GenerationUtilsC
            .getGenerationCIdentifier(timpl.getQualifiedName())) ;
      mainImplCode.addOutputNewline(GenerationUtilsC.THREAD_SUFFIX + ';') ;
      String period = null ;
      String deadline = null ;
      String timeCapacity = null ;

      try
      {
        long value = PropertyUtils.getIntValue(t, "Period") ;
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
        long value = PropertyUtils.getIntValue(t, "Deadline") ;
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
              PropertyUtils.getMaxRangeValue(t, "Compute_Execution_Time") ;
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
      threadIndex++ ;
    }

    // For each blackboard
    for(String name : pp.blackboardNames)
    {
      mainImplCode.addOutput("  CREATE_BLACKBOARD (\"") ;
      mainImplCode.addOutput(name) ;
      mainImplCode.addOutput("\", sizeof (int), &(") ;
      mainImplCode.addOutput(name);
      mainImplCode.addOutputNewline("), &(ret));") ;
    }

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
  
  private PartitionProperties generateMainHeader(ProcessImplementation process,
                                            AadlToCSwitchProcess mainHeaderCode,
                                            PokProperties pokProp)
  {
    PartitionProperties result = new PartitionProperties() ;
    
    findCommunicationMechanism(process, result) ;
    
    List<ThreadSubcomponent> bindedThreads =
                                         process.getOwnedThreadSubcomponents() ;
    
    String guard = GenerationUtilsC.generateHeaderInclusionGuard("main.h") ;
    mainHeaderCode.addOutputNewline(guard) ;
    
    /**** #DEFINE ****/

    mainHeaderCode.addOutputNewline("#define POK_GENERATED_CODE 1") ;

    if(pokProp.consoleFound == true)
    {
      mainHeaderCode.addOutputNewline("#define POK_NEEDS_CONSOLE 1") ;
    }

    if(pokProp.stdioFound == true)
    {
      mainHeaderCode
            .addOutputNewline("#define POK_NEEDS_LIBC_STDIO 1") ;
    }

    if(pokProp.stdlibFound == true)
    {
      mainHeaderCode
            .addOutputNewline("#define POK_NEEDS_LIBC_STDLIB 1") ;
    }
    
    mainHeaderCode
          .addOutputNewline("#define POK_CONFIG_NB_THREADS " +
                Integer.toString(bindedThreads.size() + 1)) ;
    
    int blackboardNeeded = (result.blackboardNames.isEmpty()) ? 0 : 1 ;

    if(false == result.blackboardNames.isEmpty())
    {
      mainHeaderCode
            .addOutputNewline("#define POK_CONFIG_NB_BLACKBOARDS " +
                  result.blackboardNames.size()) ;
      mainHeaderCode
            .addOutputNewline("#define POK_NEEDS_ARINC653_BLACKBOARD 1") ;
    }

    mainHeaderCode
        .addOutputNewline("#define POK_NEEDS_BLACKBOARDS " + blackboardNeeded) ;
    
    int queuingNeeded = (result.queuingNames.isEmpty()) ? 0 : 1 ;
    
    mainHeaderCode.addOutputNewline("#define POK_NEEDS_ARINC653_QUEUING " +
                                     queuingNeeded) ;
    
    int samplingNeeded = (result.samplingNames.isEmpty()) ? 0 : 1 ;
    
    mainHeaderCode.addOutputNewline("#define POK_NEEDS_ARINC653_SAMPLING " +
                                     samplingNeeded) ;
    
    if(pokProp.requiredStackSize != -1)
    {
      mainHeaderCode
            .addOutputNewline("#define POK_CONFIG_STACKS_SIZE " +
                  Long.toString(pokProp.requiredStackSize)) ;
    }

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
    
    if(false == result.blackboardNames.isEmpty())
    {
      mainHeaderCode.addOutputNewline("#include <arinc653/blackboard.h>");
    }
    
    mainHeaderCode.addOutputNewline("#endif") ;
    
    return result ;
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
  
  private void generateDeploymentImpl(ProcessorSubcomponent processor,
                                      AadlToCSwitchProcess deploymentImplCode,
                                      PokProperties pokProp)
  {
    deploymentImplCode.addOutputNewline("#include <arinc653/types.h>") ;
    deploymentImplCode.addOutputNewline("#include \"deployment.h\"") ;
    
    List<ProcessSubcomponent> bindedProcess =
            GeneratorUtils.getBindedProcesses(processor) ;
    
    for(ProcessSubcomponent ps: bindedProcess)
    {
      ProcessImplementation pi = (ProcessImplementation)
                                                ps.getComponentImplementation();
      ProcessType pt = (ProcessType) pi.getType();
      int nbPorts = 0;
      StringBuilder portNameList = new StringBuilder();
      for(Feature f:pt.getOwnedFeatures())
      {
      if(f instanceof Port)
      {
        nbPorts++;
        portNameList.append(ps.getName()+"_"+f.getName());
        portNameList.append(",");
      }
      }
      deploymentImplCode.addOutput("uint8_t ");
      deploymentImplCode.addOutputNewline(ps.getName()+"_partport["+nbPorts
          +"] = {" + portNameList.toString()+"};");
      
      
      
    }
    
    /*uint8_t pr1_pdataout_deployment_destinations[1] = {pr2_pdatain_global};
    uint8_t pok_global_ports_to_local_ports[POK_CONFIG_NB_GLOBAL_PORTS] = {pr2_pdatain,pr1_pdataout};
    pok_bus_identifier_t pok_global_ports_to_bus[POK_CONFIG_NB_GLOBAL_PORTS] = {invalid_bus,invalid_bus};
    uint8_t pok_buses_partitions[POK_CONFIG_NB_BUSES] = {};
    uint8_t pok_local_ports_to_global_ports[POK_CONFIG_NB_PORTS] = {pr2_pdatain_global,pr1_pdataout_global};
    uint8_t pok_ports_nodes[POK_CONFIG_NB_GLOBAL_PORTS] = {0,0};
    uint8_t pok_ports_nb_ports_by_partition[POK_CONFIG_NB_PARTITIONS] = {1,1};
    uint8_t* pok_ports_by_partition[POK_CONFIG_NB_PARTITIONS] = {pr2_partport,pr1_partport};
    char* pok_ports_names[POK_CONFIG_NB_PORTS] = {"pr2_pdatain","pr1_pdataout"};
    uint8_t pok_ports_identifiers[POK_CONFIG_NB_PORTS] = {pr2_pdatain,pr1_pdataout};
    uint8_t pok_ports_nb_destinations[POK_CONFIG_NB_PORTS] = {0,1};
    uint8_t* pok_ports_destinations[POK_CONFIG_NB_PORTS] = {NULL,pr1_pdataout_deployment_destinations};
    pok_port_kind_t pok_ports_kind[POK_CONFIG_NB_PORTS] = {POK_PORT_KIND_QUEUEING,POK_PORT_KIND_QUEUEING};*/

    
  }
  
  
  private void generateDeploymentHeader(ProcessorSubcomponent processor,
                                      AadlToCSwitchProcess deploymentHeaderCode,
                                      PokProperties pokProp)
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
            pokProp.consoleFound = true ;
            break ;
          }
        }

        for(String s : additionalFeatures)
        {
          if(s.equalsIgnoreCase("libc_stdio"))
          {
            pokProp.stdioFound = true ;
            break ;
          }
        }

        for(String s : additionalFeatures)
        {
          if(s.equalsIgnoreCase("libc_stdlib"))
          {
            pokProp.stdlibFound = true ;
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
      if(!pokProp.partitionProperties.containsKey(process))
      {
        PartitionProperties pp = new PartitionProperties() ;
        pokProp.partitionProperties.put(process, pp) ;
        findCommunicationMechanism(process, pp) ;
      }
      PartitionProperties pp = pokProp.partitionProperties.get(process) ;
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
            pokProp.partitionProperties.get((ProcessImplementation) ps
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
          pokProp.requiredStackSize += partitionStack ;
          pokProp.requiredStackSizePerPartition.put(pi, partitionStack) ;
        }
        catch(Exception e)
        {
          pokProp.requiredStackSize += DEFAULT_REQUIRED_STACK_SIZE ;
          pokProp.requiredStackSizePerPartition
                .put(pi, DEFAULT_REQUIRED_STACK_SIZE) ;
        }
      }
    }

    deploymentHeaderCode.addOutputNewline("#define POK_CONFIG_STACKS_SIZE " +
          Long.toString(pokProp.requiredStackSize)) ;
    // TODO: define buses for distributed use-case
    deploymentHeaderCode.addOutputNewline("#define POK_CONFIG_NB_BUSES 0") ;
    deploymentHeaderCode.addOutputNewline("typedef enum") ;
    deploymentHeaderCode.addOutputNewline("{") ;
    deploymentHeaderCode.incrementIndent() ;
    deploymentHeaderCode.addOutputNewline("invalid_bus = 0") ;
    deploymentHeaderCode.decrementIndent() ;
    deploymentHeaderCode.addOutputNewline("} pok_bus_identifier_t;") ;

    SystemImplementation si = (SystemImplementation) processor.eContainer() ;
    deploymentHeaderCode.addOutputNewline("#define POK_CONFIG_NB_NODES " +
          Integer.toString(si.getOwnedProcessorSubcomponents().size())) ;

    deploymentHeaderCode.addOutputNewline("#endif") ;
  }                                            


  @Override
  public void setParameters(Map<TargetUnparserParameter, Object> parameters)
  {
    throw new UnsupportedOperationException() ;
  }
}

class PartitionProperties
{
  public Set<String> blackboardNames = new HashSet<String>() ;
  
  public Set<String> queuingNames = new HashSet<String>() ;
  
  public Set<String> samplingNames = new HashSet<String>() ;
}