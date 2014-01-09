package fr.tpt.aadl.ramses.control.support;

import java.io.BufferedReader ;
import java.io.File ;
import java.io.IOException ;
import java.io.InputStream ;
import java.io.InputStreamReader ;
import java.io.PrintStream ;

// TODO: should go in a Utils project
/**
 * This class is meant to display messages of external processes launched
 * from RAMSES (output or error messages).
 */
public class ProcessMessageDisplay
{
  /**
   * This method displays in console messages printed on 
   * standard output by the external process launched.
   * @param p the external process that was launched.
   */
  public static void displayOutputMessage(Process p)
  {
    InputStream is = p.getInputStream();
    try
    {
      display(is, System.out) ;
    }
    catch(IOException e)
    {
      // Do nothing: it should not happen
    }
  }

  /**
   * This method displays on console messages printed on
   * error output by the external process launched.
   * @param p the external process that was launched.
   */
  public static void displayErrorMessage(Process p)
  {
    InputStream is = p.getErrorStream();
    try
    {
      display(is, System.err) ;
    }
    catch(IOException e)
    {
      // Do nothing: it should not happen
    }
  }
  
  /**
   * This method save in a log file messages printed on
   * standard output by the external process launched.
   * @param p the external process that was launched.
   * @param log the log file.
   * @throws IOException if log file does not exist.
   */
  public static void saveOutputMessage(Process p, File log) throws IOException
  {
    PrintStream ps = new PrintStream(log) ;
    InputStream is = p.getInputStream() ;
    display(is, ps) ;
    ps.close() ;
  }
  
  /**
   * This method save in a log file messages printed on
   * error output by the external process launched.
   * @param p the external process that was launched.
   * @param log the log file.
   * @throws IOException if log file does not exist.
   */
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
