package fr.tpt.aadl.ramses.control.support;

import java.io.BufferedReader ;
import java.io.File ;
import java.io.IOException ;
import java.io.InputStream ;
import java.io.InputStreamReader ;
import java.io.PrintStream ;

public class ProcessMessageDisplay
{
  public static void displayOutputMessage(Process p) throws IOException
  {
    InputStream is = p.getInputStream();
    display(is, System.out) ;
  }

  public static void displayErrorMessage(Process makeProcess) throws IOException
  {
    InputStream is = makeProcess.getErrorStream();
    display(is, System.err) ;
  }
  
  public static void saveOutputMessage(Process p, File log) throws IOException
  {
    PrintStream ps = new PrintStream(log) ;
    InputStream is = p.getInputStream() ;
    display(is, ps) ;
    ps.close() ;
  }
  
  public static void saveErrorMessage(Process p, File log) throws IOException
  {
    PrintStream ps = new PrintStream(log) ;
    InputStream is = p.getErrorStream();
    display(is, ps) ;
    ps.close() ;
  }
  
  private static void display(InputStream is, PrintStream os) throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(is));
    String line = null;
    while ((line = in.readLine()) != null)
    {
      os.println(line);
    }
  }
}
