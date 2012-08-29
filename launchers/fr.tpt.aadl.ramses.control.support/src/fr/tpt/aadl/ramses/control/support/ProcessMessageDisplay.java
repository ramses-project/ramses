package fr.tpt.aadl.ramses.control.support;

import java.io.BufferedReader ;
import java.io.IOException ;
import java.io.InputStream ;
import java.io.InputStreamReader ;

public class ProcessMessageDisplay
{

  public static void displayOutputMessage(Process p) throws IOException
  {
    InputStream is = p.getInputStream();
    BufferedReader in = new BufferedReader(new InputStreamReader(is));
    String line = null;
    while ((line = in.readLine()) != null) {
      System.out.println(line);
    }
  }

  public static void displayErrorMessage(Process makeProcess) throws IOException
  {
    InputStream is = makeProcess.getErrorStream();
    BufferedReader in = new BufferedReader(new InputStreamReader(is));
    String line = null;
    while ((line = in.readLine()) != null && !line.isEmpty()) {
      System.err.println(line);
    }
  }
  
  
 
  
}
