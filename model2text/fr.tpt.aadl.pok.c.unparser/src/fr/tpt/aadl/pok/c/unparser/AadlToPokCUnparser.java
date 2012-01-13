package fr.tpt.aadl.pok.c.unparser;

import java.util.HashSet ;
import java.util.Set ;

import org.eclipse.emf.common.util.EList ;
import org.osate.aadl2.ThreadImplementation ;
import org.osate.aadl2.ThreadSubcomponent ;

import fr.tpt.aadl.c.unparser.GenerationUtils ;
import fr.tpt.aadl.util.properties.PropertyUtils ;

public class AadlToPokCUnparser
{

}

/*

  private final String TYPE_HEADER = "#ifndef __GENERATED_GTYPES_H__\n"
        + "#define __GENERATED_GTYPES_H__\n" ;

  private final String SUBPROGRAM_HEADER =
        "#ifndef __GENERATED_SUBPROGRAMS_H__\n"
              + "#define __GENERATED_SUBPROGRAMS_H__\n"
              + "#include \"gtypes.h\"\n" ;



  Main.c :
  
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