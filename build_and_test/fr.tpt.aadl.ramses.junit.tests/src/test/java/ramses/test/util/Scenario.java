package ramses.test.util;

import static org.junit.Assert.fail ;

import java.io.File ;
import java.io.IOException ;
import java.util.Calendar ;
import java.util.concurrent.Callable ;
import java.util.concurrent.FutureTask ;
import java.util.concurrent.TimeUnit ;
import java.util.concurrent.TimeoutException ;

import org.junit.Assert ;

import fr.tpt.aadl.ramses.control.support.reporters.StdProcessTraceDisplay ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;

public abstract class Scenario
{

  protected String input;
  protected String ramses_dir;
  protected String output;
  protected String output_ref;
  protected String system_impl="root.impl";
  protected String runtimePath="";
  protected String workflowPath="";
  protected String aadlInspectorPath="";
  protected String target="";
  protected String includeList="";
  
  private Process ramsesProcess;
  
  abstract Process executeGeneratedCode() throws Exception;
  abstract void init();
  
  protected void exec()
  {
    init() ;
    this.cleanOutputDirectory(new File(output)) ;
    Process executeProcess = null ;
    try
    {
      System.out.println("") ;
      System.out.println("***************************************************") ;
      System.out.println("*** START step 1: code generation & compilation ***") ;
      System.out.println("***************************************************") ;
      System.out.println(Calendar.getInstance().getTime()) ;
      System.out.println("") ;

      // Implements a timeout.
      Callable<Boolean> app = new Callable<Boolean>()
      {
        @Override
        public Boolean call() throws Exception
        {

          ramsesProcess.waitFor() ;
          if(ramsesProcess.exitValue() != 0)
          {
            return false ;
          }
          return true ;
        }
      } ;

      FutureTask<Boolean> ft = new FutureTask<Boolean>(app) ;
      try
      {
        StringBuilder args = new StringBuilder() ;

        args.append("java") ;

        args.append(" -DDEBUG") ;

        if(ramses_dir != null)
        {
          args.append(" -D") ;
          args.append(Names.RAMSES_RESOURCES_VAR) ;
          args.append('=') ;
          args.append(ramses_dir) ;
        }

        args.append(" -DAADLINSPECTOR_PATH=") ;
        args.append(aadlInspectorPath) ;

        args.append(" -jar ") ;

        if(ramses_dir != null)
        {
          args.append(ramses_dir) ;
        }

        args.append("ramses-exe.jar") ;

        args.append(" -l trace") ;

        args.append(" -m ") ;
        args.append(input) ;

        args.append(" -g pok") ;

        args.append(" -s ") ;
        args.append(system_impl) ;

        args.append(" -o ") ;
        args.append(output) ;

        args.append(" -r ") ;
        args.append(runtimePath) ;

        if(includeList != null && includeList!="")
        {
          args.append(" -i ") ;
          args.append(includeList) ;
        }
        
        if(workflowPath != null && workflowPath != "")
        {
          args.append(" --workflow=") ;
          args.append(workflowPath) ;
        }

        Runtime runtime = Runtime.getRuntime() ;
        // Launch code generation
        String line = args.toString() ;
        System.out.println(line) ;
        ramsesProcess = runtime.exec(line) ;
        new Thread(ft).start() ;
        ft.get(300, TimeUnit.SECONDS) ;
        displayProcessMessages(ramsesProcess, 1) ;
      }
      catch(TimeoutException ee)
      {
        displayProcessMessages(ramsesProcess, 1, "exited on timeout") ;
        fail() ;
        if(ramsesProcess != null)
        {
          ramsesProcess.destroy() ;
        }
      }
      catch(Exception e)
      {
        e.printStackTrace() ;
        fail() ;
        if(ramsesProcess != null)
        {
          ramsesProcess.destroy() ;
        }
        System.exit(-1) ;
      }
      
      System.out.println("") ;
      System.out.println("***************************************************") ;
      System.out.println("**** START step 2: execution of generated code ****") ;
      System.out.println("***************************************************") ;
      System.out.println(Calendar.getInstance().getTime()) ;
      System.out.println("") ;

      try
      {
        // Launch generated code
        executeProcess = executeGeneratedCode() ;
        displayProcessMessages(executeProcess, 2) ;
      }
      catch(Exception e)
      {
        e.printStackTrace() ;
        fail() ;
        if(executeProcess != null)
        {
          executeProcess.destroy() ;
        }
        System.exit(-1) ;
      }

      try
      {
        System.out.println("") ;
        System.out.println("*********************************************************************") ;
        System.out.println("*** START step 3: comparison of output with an existing reference ***") ;
        System.out.println("*********************************************************************") ;
        System.out.println(Calendar.getInstance().getTime()) ;
        System.out.println("") ;
        
        Boolean same = false ;
        ramses.test.util.CompareDirectory cm = new ramses.test.util.
                                                    CompareDirectory(output_ref,
                                                                     output) ;
        same = cm.evaluate() ;

        String emph ;

        if(same)
        {
          emph = "###" ;
        }
        else
        {
          emph = "%%%" ;
        }

        System.out.println(emph + " Output is identical with reference: " +
                           same + ' ' + emph) ;

        Assert.assertTrue(same) ;
        
        System.out.println("") ;
        System.out.println("**********************************************************************") ;
        System.out.println("*** FINISH step 3: comparison of output with an existing reference ***") ;
        System.out.println("**********************************************************************") ;
        System.out.println(Calendar.getInstance().getTime()) ;
        System.out.println("") ;
      }
      catch(IOException e)
      {
        e.printStackTrace() ;
        fail() ;
      }
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
      fail() ;
    }
  }

  private void cleanOutputDirectory(File dir)
  {
    String s[] = dir.list();
    if(s==null)
      return;
    for (int i = 0; i < s.length; i++) {
      File subFile = new File(s[i]);
      subFile.delete();        
    }
  }
  
  protected void displayProcessMessages(Process process, int step,
                                      String errorMessage) throws IOException
  {
    System.out.println("") ;
    System.out.println("***************************************************************") ;
    System.out.println("*** FINISH step " + step + " abnormally: " + errorMessage + " ***") ;
    System.out.println("***************************************************************") ;
    System.out.println(Calendar.getInstance().getTime()) ;
    System.out.println("") ;
    
    displayMessages(process, step, true);
  }
  
  protected void displayProcessMessages(Process process, int step) throws IOException
  {
    if(process.exitValue() == 0)
    {
      System.out.println("") ;
      System.out.println("*************************************************************") ;
      System.out.println("******************* FINISH step " + step + " normally ******************") ;
      System.out.println("*************************************************************") ;
      System.out.println(Calendar.getInstance().getTime()) ;
      System.out.println("") ;
      
      displayMessages(process, step, false) ;
    }
    else
    {
      System.out.println("") ;
      System.out.println("***************************************************************") ;
      System.out.println("******************* FINISH step " + step + " abnormally ******************") ;
      System.out.println("***************************************************************") ;
      System.out.println(Calendar.getInstance().getTime()) ;
      System.out.println("") ;
      
      displayMessages(process, step, true) ;
    }
  }
  
  protected void displayMessages(Process process, int step,
                                 boolean hasToPrintStdErr) throws IOException
  {
    if(hasToPrintStdErr)
    {
      System.out.println("*************************************") ;
      System.out.println("*** step " + step + " error output trace: ***") ;
      System.out.println("*************************************") ;
      System.out.println("") ;
      
      StdProcessTraceDisplay.INSTANCE.displayErrorMessage(process);
      
      System.out.println("") ;
      System.out.println("********************************************") ;
      System.out.println("*** End of step " + step + " error output trace  ***") ;
      System.out.println("********************************************") ;
      System.out.println("") ;
    }
    
    System.out.println("*************************************") ;
    System.out.println("*** step " + step + " standard output trace: ***") ;
    System.out.println("*************************************") ;
    System.out.println("") ;

    StdProcessTraceDisplay.INSTANCE.displayOutputMessage(process) ;
    
    System.out.println("") ;
    System.out.println("********************************************") ;
    System.out.println("*** End of step " + step + " standard output trace  ***") ;
    System.out.println("********************************************") ;
  }
}