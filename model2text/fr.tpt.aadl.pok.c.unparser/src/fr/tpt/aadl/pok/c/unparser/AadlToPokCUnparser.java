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
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessSubcomponent ;
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
import fr.tpt.aadl.toolsuite.support.generator.TargetProperties ;
import fr.tpt.aadl.toolsuite.support.generator.TargetUnparserParameter ;
import fr.tpt.aadl.util.properties.PropertyUtils ;

public class AadlToPokCUnparser implements AadlTargetUnparser
{
  private final static int DEFAULT_REQUIRED_STACK_SIZE = 16384 ;
  
  // TODO: factorization with ATL transformation into a naming class or enum. 
  public final static String BLACKBOARD_AADL_TYPE = 
                                             "pok_runtime::Blackboard_Id_Type" ;
  
  public TargetProperties process(ProcessorSubcomponent processor,
                                  File generatedFilePath)
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
        // TODO: else buffers, samples, etc.
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
  }
  
  private void generateDeploymentHeader(ProcessorSubcomponent processor,
                                      AadlToCSwitchProcess deploymentHeaderCode,
                                      PokProperties pokProp)
  {
    String guard = GenerationUtilsC.generateHeaderInclusionGuard("deployment.h");
    
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

//        if(pokProp.consoleFound == false)
        {
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
        }

//        if(_stdioFound == false)
        {
          for(String s : additionalFeatures)
          {
            if(s.equalsIgnoreCase("libc_stdio"))
            {
              pokProp.stdioFound = true ;
              break ;
            }
          }
        }

//        if(_stdlibFound == false)
        {
          for(String s : additionalFeatures)
          {
            if(s.equalsIgnoreCase("libc_stdlib"))
            {
              pokProp.stdlibFound = true ;
              break ;
            }
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
    deploymentHeaderCode
          .addOutputNewline("#define POK_CONFIG_LOCAL_NODE " +
                Integer.toString(id)) ;
    // POK_GENERATED_CODE 1 always true in our usage context
    deploymentHeaderCode.addOutputNewline("#define POK_GENERATED_CODE 1") ;
    
    deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_GETTICK 1") ;
    // POK_NEEDS_THREADS 1 always true in our usage context.
    deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_THREADS 1") ;

    if(bindedVPS.size() > 0)
    {
      deploymentHeaderCode
            .addOutputNewline("#define POK_NEEDS_PARTITIONS 1") ;
    }

    deploymentHeaderCode.addOutputNewline("#define POK_NEEDS_SCHED 1") ;
    // The maccro POK_CONFIG_NB_PARTITIONS indicates the amount of partitions in
    // the current system.It corresponds to the amount of process components in
    // the system.
    List<ProcessSubcomponent> bindedProcess =
          GeneratorUtils.getBindedProcesses(processor) ;
    deploymentHeaderCode
          .addOutputNewline("#define POK_CONFIG_NB_PARTITIONS " +
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
    deploymentHeaderCode
          .addOutputNewline("#define POK_CONFIG_NB_THREADS " +
                Integer.toString(2 + bindedProcess.size() +
                      bindedThreads.size())) ;
    //  The maccro POK_CONFIG_NB_PARTITIONS_NTHREADS indicates the amount of 
    //  threads in each partition we also add an additional process that 
    //  initialize all partition's entities (communication, threads, ...)
    deploymentHeaderCode
          .addOutput("#define POK_CONFIG_PARTITIONS_NTHREADS {") ;

    for(Integer i : threadNumberPerPartition)
    {
      deploymentHeaderCode.addOutput(Integer.toString(i + 1)) ;

      if(threadNumberPerPartition.indexOf(i) != (threadNumberPerPartition
            .size() - 1))
      {
        deploymentHeaderCode.addOutput(",") ;
      }
    }

    deploymentHeaderCode.addOutputNewline("}") ;

    try
    {
      boolean foundRR = false ;

      for(VirtualProcessorSubcomponent vps : bindedVPS)
      {
        String requiredScheduler = PropertyUtils.getEnumValue(vps, "Scheduler") ;

        if(requiredScheduler.equalsIgnoreCase("RR") && foundRR == false)
        {
          foundRR = true ;
          deploymentHeaderCode
                .addOutputNewline("#define POK_NEEDS_SCHED_RR 1") ;
        }
      }
    }
    catch(Exception e)
    {
    }

    // TODO: define POK_CONFIG_PARTITIONS_SCHEDULER: sched algo associated to 
    // each partition
    deploymentHeaderCode
          .addOutput("#define POK_CONFIG_PARTITIONS_SCHEDULER {") ;

    try
    {
      for(VirtualProcessorSubcomponent vps : bindedVPS)
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
    }
    catch(Exception e)
    {
    }

    deploymentHeaderCode.addOutputNewline("}") ;
    // TODO: define lock objects for distributed use-case
    deploymentHeaderCode
          .addOutputNewline("#define POK_NEEDS_LOCKOBJECTS 1") ;
    deploymentHeaderCode
          .addOutputNewline("#define POK_CONFIG_NB_LOCKOBJECTS 1") ;
    deploymentHeaderCode
          .addOutputNewline("#define POK_CONFIG_PARTITIONS_NLOCKOBJECTS {1}") ;
    //  The maccro POK_CONFIG_PARTTITIONS_SIZE indicates the required amount of 
    //  memory for each partition.This value was deduced from the property 
    //  POK::Needed_Memory_Size of each process
    // comes from property POK::Needed_Memory_Size => XXX Kbyte;
    List<Long> memorySizePerPartition = new ArrayList<Long>() ;

    try
    {
      for(ProcessSubcomponent p : bindedProcess)
      {
        memorySizePerPartition.add(PropertyUtils
              .getIntValue(p, "Needed_Memory_Size")) ;
      }
    }
    catch(Exception e)
    {
    }

    deploymentHeaderCode.addOutput("#define POK_CONFIG_PARTITIONS_SIZE {") ;

    for(Long l : memorySizePerPartition)
    {
      deploymentHeaderCode.addOutput(Long.toString(l)) ;

      if(memorySizePerPartition.indexOf(l) != memorySizePerPartition.size() - 1)
      {
        deploymentHeaderCode.addOutput(",") ;
      }
    }

    deploymentHeaderCode.addOutputNewline("}") ;
    List<Long> slotPerPartition =
          PropertyUtils.getIntListValue(processor, "Slots") ;
    // POK_CONFIG_SCHEDULING_SLOTS extracted from POK::Slots => (500 ms);
    deploymentHeaderCode
          .addOutput("#define POK_CONFIG_SCHEDULING_SLOTS {") ;

    for(Long l : slotPerPartition)
    {
      deploymentHeaderCode.addOutput(Long.toString(l)) ;

      if(slotPerPartition.indexOf(l) != slotPerPartition.size() - 1)
      {
        deploymentHeaderCode.addOutput(",") ;
      }
    }

    deploymentHeaderCode.addOutputNewline("}") ;
    
    List<Subcomponent> slotsAllocation =
          PropertyUtils.getSubcomponentList(processor, "Slots_Allocation") ;
    deploymentHeaderCode
          .addOutput("#define POK_CONFIG_SCHEDULING_SLOTS_ALLOCATION {") ;

    for(Subcomponent sAllocation : slotsAllocation)
    {
      int referencedComponentId = bindedVPS.indexOf(sAllocation) ;
      deploymentHeaderCode.addOutput(Integer
            .toString(referencedComponentId)) ;

      if(slotsAllocation.indexOf(sAllocation) != slotsAllocation.size() - 1)
      {
        deploymentHeaderCode.addOutput(",") ;
      }
    }

    deploymentHeaderCode.addOutputNewline("}") ;
    
    deploymentHeaderCode
          .addOutputNewline("#define POK_CONFIG_SCHEDULING_NBSLOTS " +
                Integer.toString(slotPerPartition.size())) ;
    
    try
    {
      Long majorFrame = PropertyUtils.getIntValue(processor, "Major_Frame") ;
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
          pokProp.requiredStackSize +=
                PropertyUtils.getIntValue(ts, "Source_Stack_Size") ;
        }
        catch(Exception e)
        {
          pokProp.requiredStackSize += DEFAULT_REQUIRED_STACK_SIZE ;
        }
      }
    }

    deploymentHeaderCode
          .addOutputNewline("#define POK_CONFIG_STACKS_SIZE " +
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
    
    deploymentHeaderCode.addOutputNewline("#endif");
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
}