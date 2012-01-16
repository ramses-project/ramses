package fr.tpt.aadl.pok.c.unparser;

import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.HashSet ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.AccessCategory ;
import org.osate.aadl2.AccessConnection ;
import org.osate.aadl2.ConnectedElement ;
import org.osate.aadl2.Connection ;
import org.osate.aadl2.DataAccess ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.ThreadImplementation ;
import org.osate.aadl2.ThreadSubcomponent ;

import fr.tpt.aadl.annex.behavior.utils.AadlBaUtils ;
import fr.tpt.aadl.c.unparser.AadlToCSwitchProcess ;
import fr.tpt.aadl.c.unparser.GenerationUtils ;
import fr.tpt.aadl.util.properties.PropertyUtils ;

public class AadlToPokCUnparser
{

}

/*

  // POK's Additional features flags.
  private static boolean _consoleFound = false, _stdioFound = false,
        _stdlibFound = false ;

  // POK config stacks size.
  private static long _requiredStackSize = 0 ;

  // POK partition's main.c flags.
  private boolean _hasToAddBlackboardHeader = false,
        _hasToAddSamplingHeader = false ;

protected AadlToCSwitchProcess cMainFileCode ;


  public AadlToCUnparser()
  {
    cMainFileCode = new AadlToCSwitchProcess(this) ;
    cMainFileCode.addOutputNewline("#include \"activity.h\"") ;
    cMainFileCode.addOutputNewline("#include \"deployment.h\"") ;
    // XXX Is there any condition for the generation of theses directives ?
    cMainFileCode.addOutputNewline("#include <arinc653/types.h>") ;
    cMainFileCode.addOutputNewline("#include <arinc653/process.h>") ;
    cMainFileCode.addOutputNewline("#include <arinc653/partition.h>") ;



private static Map<DataAccess, String> _blackboardNames ;

      public String caseProcessorSubcomponent(ProcessorSubcomponent object)
      {
        generateDeploymentHeader(object) ;
        return null ;
      }

public void saveGeneratedKernelFiles(File processorMakeFileDir)
  {
    File f = new File(processorMakeFileDir.getAbsolutePath() + "/kernel") ;

    if(f.exists() == false)
    {
      f.mkdir() ;
    }

    FileWriter deployment_C ;
    _deploymentHeaderCode.addOutputNewline("\n#endif\n") ;

    try
    {
      deployment_C =
            new FileWriter(processorMakeFileDir.getAbsolutePath() +
                  "/kernel/deployment.c") ;
      String addDeploymentHeader_C = getAdditionalHeader(_deploymentImplCode) ;
      saveFile(deployment_C, addDeploymentHeader_C +
                     _deploymentImplCode.getOutput()) ;
      FileWriter deployment_H =
            new FileWriter(processorMakeFileDir.getAbsolutePath() +
                  "/kernel/deployment.h") ;
      String addDeploymentHeader_H =
            getAdditionalHeader(this._deploymentHeaderCode) ;
      saveFile(deployment_H, this.DEPLOYMENT_HEADER + '\n' +
                     addDeploymentHeader_H +
                     _deploymentHeaderCode.getOutput()) ;
    }
    catch(IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace() ;
    }
  }



FROM save generated files

      FileWriter mainFile_C =
            new FileWriter(targetDirectory.getAbsolutePath() + "/main.c") ;
      String addMainHeader_C = getAdditionalHeader(cMainFileCode) ;
      saveFile(mainFile_C, addMainHeader_C + cMainFileCode.getOutput()) ;


  void generateDeploymentHeader(ProcessorSubcomponent object)
  {
    // POK::Additional_Features => (libc_stdio,libc_stdlib,console);
    // this property is associated to virtual processors
    List<VirtualProcessorSubcomponent> bindedVPS =
          new ArrayList<VirtualProcessorSubcomponent>() ;

    for(Subcomponent sub : object.getComponentImplementation()
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

        if(_consoleFound == false)
        {
          for(String s : additionalFeatures)
            if(s.equalsIgnoreCase("console"))
            {
              // POK_NEEDS_CONSOLE has to be in both kernel's deployment.h
              cDeploymentHeaderFileCode
                    .addOutputNewline("#define POK_NEEDS_CONSOLE 1") ;
              _consoleFound = true ;
              break ;
            }
        }

        if(_stdioFound == false)
        {
          for(String s : additionalFeatures)
            if(s.equalsIgnoreCase("libc_stdio"))
            {
              _stdioFound = true ;
              break ;
            }
        }

        if(_stdlibFound == false)
        {
          for(String s : additionalFeatures)
            if(s.equalsIgnoreCase("libc_stdlib"))
            {
              _stdlibFound = true ;
              break ;
            }
        }
      }
      catch(Exception e)
      {
      }
    }
    
    // TODO: the integer ID in this macro must be set carefully to respect the routing table
    // defined in deployment.c files in the generated code for a partition
    int id =
          ((SystemImplementation) object.eContainer())
                .getOwnedProcessorSubcomponents().indexOf(object) ;
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_CONFIG_LOCAL_NODE " +
                Integer.toString(id)) ;
    // POK_GENERATED_CODE 1 always true in our usage context
    cDeploymentHeaderFileCode.addOutputNewline("#define POK_GENERATED_CODE 1") ;
    //Hum, ici je dirai que tu dois mettre ceci d�s que tu as des t�ches p�riodiques ou ordonnanceurs RR ou du statique.
    //L'endroit o� il g�n�re cette macro n'est pas encore super clair pour moi dans ocarina ...
    cDeploymentHeaderFileCode.addOutputNewline("#define POK_NEEDS_GETTICK 1") ;
    // POK_NEEDS_THREADS 1 always true in our usage context.
    cDeploymentHeaderFileCode.addOutputNewline("#define POK_NEEDS_THREADS 1") ;

    if(bindedVPS.size() > 0)
    {
      cDeploymentHeaderFileCode
            .addOutputNewline("#define POK_NEEDS_PARTITIONS 1") ;
    }

    cDeploymentHeaderFileCode.addOutputNewline("#define POK_NEEDS_SCHED 1") ;
    //  The maccro POK_CONFIG_NB_PARTITIONS indicates the amount of partitions in
    //   the current system.It corresponds to the amount of process components in/
    //  the system.
    List<ProcessSubcomponent> bindedProcess =
          GenerationUtils.getBindedProcesses(object) ;
    cDeploymentHeaderFileCode
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
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_CONFIG_NB_THREADS " +
                Integer.toString(2 + bindedProcess.size() +
                      bindedThreads.size())) ;
    //  The maccro POK_CONFIG_NB_PARTITIONS_NTHREADS indicates the amount of 
    //  threads in each partition we also add an additional process that 
    //  initialize all partition's entities (communication, threads, ...)
    cDeploymentHeaderFileCode
          .addOutput("#define POK_CONFIG_PARTITIONS_NTHREADS {") ;

    for(Integer i : threadNumberPerPartition)
    {
      cDeploymentHeaderFileCode.addOutput(Integer.toString(i + 1)) ;

      if(threadNumberPerPartition.indexOf(i) != (threadNumberPerPartition
            .size() - 1))
      {
        cDeploymentHeaderFileCode.addOutput(",") ;
      }
    }

    cDeploymentHeaderFileCode.addOutputNewline("}") ;

    try
    {
      boolean foundRR = false ;

      for(VirtualProcessorSubcomponent vps : bindedVPS)
      {
        String requiredScheduler = PropertyUtils.getEnumValue(vps, "Scheduler") ;

        if(requiredScheduler.equalsIgnoreCase("RR") && foundRR == false)
        {
          foundRR = true ;
          cDeploymentHeaderFileCode
                .addOutputNewline("#define POK_NEEDS_SCHED_RR 1") ;
        }
      }
    }
    catch(Exception e)
    {
    }

    // TODO: define POK_CONFIG_PARTITIONS_SCHEDULER: sched algo associated to each partition
    cDeploymentHeaderFileCode
          .addOutput("#define POK_CONFIG_PARTITIONS_SCHEDULER {") ;

    try
    {
      for(VirtualProcessorSubcomponent vps : bindedVPS)
      {
        String requiredScheduler = PropertyUtils.getEnumValue(vps, "Scheduler") ;

        if(requiredScheduler.equalsIgnoreCase("RR"))
        {
          cDeploymentHeaderFileCode.addOutput("POK_SCHED_RR") ;
        }

        if(bindedVPS.indexOf(vps) != bindedVPS.size() - 1)
        {
          cDeploymentHeaderFileCode.addOutput(",") ;
        }
      }
    }
    catch(Exception e)
    {
    }

    cDeploymentHeaderFileCode.addOutputNewline("}") ;
    // TODO: define lock objects for distributed use-case
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_NEEDS_LOCKOBJECTS 1") ;
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_CONFIG_NB_LOCKOBJECTS 1") ;
    cDeploymentHeaderFileCode
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

    cDeploymentHeaderFileCode.addOutput("#define POK_CONFIG_PARTITIONS_SIZE {") ;

    for(Long l : memorySizePerPartition)
    {
      cDeploymentHeaderFileCode.addOutput(Long.toString(l)) ;

      if(memorySizePerPartition.indexOf(l) != memorySizePerPartition.size() - 1)
      {
        cDeploymentHeaderFileCode.addOutput(",") ;
      }
    }

    cDeploymentHeaderFileCode.addOutputNewline("}") ;
    List<Long> slotPerPartition =
          PropertyUtils.getIntListValue(object, "Slots") ;
    // POK_CONFIG_SCHEDULING_SLOTS extracted from POK::Slots => (500 ms);
    cDeploymentHeaderFileCode
          .addOutput("#define POK_CONFIG_SCHEDULING_SLOTS {") ;

    for(Long l : slotPerPartition)
    {
      cDeploymentHeaderFileCode.addOutput(Long.toString(l)) ;

      if(slotPerPartition.indexOf(l) != slotPerPartition.size() - 1)
      {
        cDeploymentHeaderFileCode.addOutput(",") ;
      }
    }

    cDeploymentHeaderFileCode.addOutputNewline("}") ;
    // Toujours d�fini � partir du proc impl POK::Slots_Allocation => ( reference (part1));
    List<Subcomponent> slotsAllocation =
          PropertyUtils.getSubcomponentList(object, "Slots_Allocation") ;
    cDeploymentHeaderFileCode
          .addOutput("#define POK_CONFIG_SCHEDULING_SLOTS_ALLOCATION {") ;

    for(Subcomponent sAllocation : slotsAllocation)
    {
      int referencedComponentId = bindedVPS.indexOf(sAllocation) ;
      cDeploymentHeaderFileCode.addOutput(Integer
            .toString(referencedComponentId)) ;

      if(slotsAllocation.indexOf(sAllocation) != slotsAllocation.size() - 1)
      {
        cDeploymentHeaderFileCode.addOutput(",") ;
      }
    }

    cDeploymentHeaderFileCode.addOutputNewline("}") ;
    // la pp slots de POK peut contenir une liste ... donc il faut compter
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_CONFIG_SCHEDULING_NBSLOTS " +
                Integer.toString(slotPerPartition.size())) ;

    // pp POK::Major_Frame => 1000 ms; dans proc impl
    try
    {
      Long majorFrame = PropertyUtils.getIntValue(object, "Major_Frame") ;
      cDeploymentHeaderFileCode
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
          _requiredStackSize +=
                PropertyUtils.getIntValue(ts, "Source_Stack_Size") ;
        }
        catch(Exception e)
        {
          _requiredStackSize += 16384 ;
        }
      }
    }

    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_CONFIG_STACKS_SIZE " +
                Long.toString(_requiredStackSize)) ;
    // TODO: define buses for distributed use-case
    cDeploymentHeaderFileCode.addOutputNewline("#define POK_CONFIG_NB_BUSES 0") ;
    cDeploymentHeaderFileCode.addOutputNewline("typedef enum") ;
    cDeploymentHeaderFileCode.addOutputNewline("{") ;
    cDeploymentHeaderFileCode.incrementIndent() ;
    cDeploymentHeaderFileCode.addOutputNewline("invalid_bus = 0") ;
    cDeploymentHeaderFileCode.decrementIndent() ;
    cDeploymentHeaderFileCode.addOutputNewline("} pok_bus_identifier_t;") ;
    // enum�ration de la liste de "node"
    SystemImplementation si = (SystemImplementation) object.eContainer() ;
    cDeploymentHeaderFileCode.addOutputNewline("#define POK_CONFIG_NB_NODES " +
          Integer.toString(si.getOwnedProcessorSubcomponents().size())) ;
  }


  //Populates blackboard list: pok_runtime::Blackboard_Id_Type data
  // subcomponent's names will be blackboard names.
  private Map<DataAccess, String> buildBlackboardMap(
                                              ProcessImplementation processImpl)
  {
    Map<DataAccess, String> result = new HashMap<DataAccess, String>() ;
    
    EList<Subcomponent> subcmpts = processImpl.getAllSubcomponents() ;
    
    List<String> blackboardNames = new ArrayList<String>() ;
    
    // Fetches blackboard names.
    for(Subcomponent s : subcmpts)
    {
      if(s instanceof DataSubcomponent &&
            s.getClassifier().getQualifiedName()
                  .equalsIgnoreCase("pok_runtime::Blackboard_Id_Type"))
      {
        blackboardNames.add(s.getName()) ;
      }
    }
    
    // Binds blackboard names with DataAcess objects. See process' connections.
    
    for(Connection connect : processImpl.getAllConnections())
    {
      if (connect instanceof AccessConnection &&
         ((AccessConnection) connect).getAccessCategory() == AccessCategory.DATA)
      {
        DataSubcomponent destination =  (DataSubcomponent) connect.
                                                           getAllDestination() ;
        
        if(AadlBaUtils.contains(destination.getName(), blackboardNames))
        {
          ConnectedElement source = (ConnectedElement) connect.getSource() ;
          
          DataAccess da = (DataAccess) source.getConnectionEnd() ;
          
          result.put(da, destination.getName()) ;
        }
      }
    }
    
    return result ;
  }



  private final String TYPE_HEADER = "#ifndef __GENERATED_GTYPES_H__\n"
        + "#define __GENERATED_GTYPES_H__\n" ;

  private final String SUBPROGRAM_HEADER =
        "#ifndef __GENERATED_SUBPROGRAMS_H__\n"
              + "#define __GENERATED_SUBPROGRAMS_H__\n"
              + "#include \"gtypes.h\"\n" ;



  Main.c :
  
public String caseProcessImplementation(ProcessImplementation object)
      {
       
        StringBuilder sb = new StringBuilder() ;
        
        // And set some static flags.
        // DEBUG
        _blackboardNames = buildBlackboardMap(object) ;
        
        processEList(object.getOwnedThreadSubcomponents()) ;
        EList<ThreadSubcomponent> lthreads =
              object.getOwnedThreadSubcomponents() ;
        // *** Generate deployment.h ***
        generateDeploymentHeader(object) ;
        
        // XXX performance to be improved.
        // Removes duplicates.
        Set<String> blackboardNames = new HashSet<String>(_blackboardNames.values());

        // *** Generate main.c ***

        // Adds the header files.
        if(true == _hasToAddBlackboardHeader)
        {
          cMainFileCode.addOutputNewline("#include <arinc653/blackboard.h>") ;
        }

        if(true == _hasToAddSamplingHeader)
        {
          cMainFileCode.addOutputNewline("#include <arinc653/sampling.h>") ;
        }

        //Generate global variables
        cMainFileCode.addOutputNewline(GenerationUtils.generateSectionMark()) ;
        cMainFileCode.addOutputNewline(GenerationUtils
              .generateSectionTitle("GLOBAL VARIABLES")) ;

        if(false == lthreads.isEmpty())
        {
          cMainFileCode
                .addOutputNewline("PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];") ;
        }

        if(false == blackboardNames.isEmpty())
        {
          // Generate blackboards names array.
          sb.append("char* pok_blackboards_names[POK_CONFIG_NB_BLACKBOARDS] = {") ;

          for(String name : blackboardNames)
          {
            sb.append('\"') ;
            sb.append(name) ;
            sb.append('\"') ;
          }

          sb.append("};") ;
          cMainFileCode.addOutputNewline(sb.toString()) ;
          // Generate external variable (declared in deployment.c).
          sb.setLength(0) ; // Reset string builder.

          for(String name : blackboardNames)
          {
            sb.append("extern BLACKBOARD_ID_TYPE ") ;
            sb.append(GenerationUtils.generateBlackboardId(name)) ;
            sb.append(";\n") ;
          }

          cMainFileCode.addOutput(sb.toString()) ;
          sb.setLength(0) ; // Reset string builder.
        }

        cMainFileCode.addOutputNewline(GenerationUtils.generateSectionMark()) ;
        cMainFileCode.addOutputNewline(GenerationUtils
              .generateSectionTitle("MAIN")) ;
        cMainFileCode.addOutputNewline("int main ()") ;
        cMainFileCode.addOutputNewline("{") ;
        cMainFileCode.addOutputNewline("  PROCESS_ATTRIBUTE_TYPE tattr;") ;
        cMainFileCode.addOutputNewline("  RETURN_CODE_TYPE ret;") ;
        // For each declared thread
        // Zero stands for ARINC's IDL thread.
        int threadIndex = 1 ;

        for(ThreadSubcomponent t : lthreads)
        {
          ThreadImplementation timpl =
                (ThreadImplementation) t.getComponentImplementation() ;
          cMainFileCode.addOutput("  tattr.ENTRY_POINT = ") ;
          cMainFileCode.addOutput(GenerationUtils
                .getGenerationCIdentifier(timpl.getQualifiedName())) ;
          cMainFileCode.addOutputNewline(THREAD_SUFFIX + ';') ;
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
            cMainFileCode.addOutput("  tattr.PERIOD = ") ;
            cMainFileCode.addOutputNewline(period + ';') ;
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
            cMainFileCode.addOutput("  tattr.DEADLINE = ") ;
            cMainFileCode.addOutputNewline(deadline + ';') ;
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
            cMainFileCode.addOutput("  tattr.TIME_CAPACITY = ") ;
            cMainFileCode.addOutputNewline(timeCapacity + ';') ;
          }

          cMainFileCode
                .addOutput("  CREATE_PROCESS (&(tattr), &(arinc_threads[") ;
          cMainFileCode.addOutput(Integer.toString(threadIndex)) ;
          cMainFileCode.addOutputNewline("]), &(ret));") ;
          threadIndex++ ;
        }

        // For each blackboard
        for(String name : blackboardNames)
        {
          cMainFileCode.addOutput("  CREATE_BLACKBOARD (\"") ;
          cMainFileCode.addOutput(name) ;
          cMainFileCode.addOutput("\", sizeof (int), &(") ;
          cMainFileCode.addOutput(GenerationUtils.generateBlackboardId(name));
          cMainFileCode.addOutputNewline("), &(ret));") ;
        }

        cMainFileCode
              .addOutputNewline("  SET_PARTITION_MODE (NORMAL, &(ret));") ;
        cMainFileCode.addOutputNewline("  return (0);") ;
        cMainFileCode.addOutputNewline("}") ;
        cMainFileCode.addOutputNewline(GenerationUtils.generateSectionMark()) ;
        
        
        return null ;
      }



  private void generateDeploymentHeader(ProcessImplementation processImpl)
  {
    List<ThreadSubcomponent> bindedThreads =
          processImpl.getOwnedThreadSubcomponents() ;
    // *** generate deployment.h ****
    cDeploymentHeaderFileCode.addOutputNewline("#define POK_GENERATED_CODE 1") ;

    if(_consoleFound == true)
    {
      cDeploymentHeaderFileCode.addOutputNewline("#define POK_NEEDS_CONSOLE 1") ;
    }

    if(_stdioFound == true)
    {
      cDeploymentHeaderFileCode
            .addOutputNewline("#define POK_NEEDS_LIBC_STDIO 1") ;
    }

    if(_stdlibFound == true)
    {
      cDeploymentHeaderFileCode
            .addOutputNewline("#define POK_NEEDS_LIBC_STDLIB 1") ;
    }

    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_CONFIG_NB_THREADS " +
                Integer.toString(bindedThreads.size() + 1)) ;
    
    // XXX performance to be improved.
    // Removes duplicates.
    Set<String> blackboardNames = new HashSet<String>(_blackboardNames.values());
    
    int blackboardNeeded = (blackboardNames.isEmpty()) ? 0 : 1 ;

    if(false == blackboardNames.isEmpty())
    {
      cDeploymentHeaderFileCode
            .addOutputNewline("#define POK_CONFIG_NB_BLACKBOARDS " +
                  blackboardNames.size()) ;
      cDeploymentHeaderFileCode
            .addOutputNewline("#define POK_NEEDS_ARINC653_BLACKBOARD 1") ;
      _hasToAddBlackboardHeader = true ;
    }

    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_NEEDS_BLACKBOARDS " + blackboardNeeded) ;

    if(_requiredStackSize != 0)
    {
      cDeploymentHeaderFileCode
            .addOutputNewline("#define POK_CONFIG_STACKS_SIZE " +
                  Long.toString(_requiredStackSize)) ;
    }

    // XXX Is there any condition for the generation of theses directives ?
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_NEEDS_ARINC653_TIME 1") ;
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_NEEDS_ARINC653_PROCESS 1") ;
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_NEEDS_ARINC653_PARTITION 1") ;

    // XXX Is there any condition for the generation of POK_NEEDS_MIDDLEWARE ?
    cDeploymentHeaderFileCode
          .addOutputNewline("#define POK_NEEDS_MIDDLEWARE 1") ;

    // *** Generate deployment.c ***
    if(false == blackboardNames.isEmpty())
    {
      StringBuilder sb = new StringBuilder() ;

      for(String name : blackboardNames)
      {
        sb.append("uint8_t ") ;
        sb.append(GenerationUtils.generateBlackboardId(name)) ;
        sb.append(';') ;
      }

      cDeploymentFileCode.addOutputNewline(sb.toString()) ;
    }
  }



*/