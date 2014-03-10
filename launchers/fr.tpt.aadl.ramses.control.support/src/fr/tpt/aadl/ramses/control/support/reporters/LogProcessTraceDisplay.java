package fr.tpt.aadl.ramses.control.support.reporters;

import java.io.BufferedReader ;
import java.io.IOException ;
import java.io.InputStream ;
import java.io.InputStreamReader ;

import org.apache.log4j.Logger ;

public class LogProcessTraceDisplay extends AbstractProcessTraceDisplay
{
  //Singleton pattern.
  public static final LogProcessTraceDisplay INSTANCE = new LogProcessTraceDisplay() ;
  
  private static Logger _LOGGER = Logger.getLogger(LogProcessTraceDisplay.class) ;
  
  @Override
  protected void display(InputStream is, boolean isError) throws IOException
  {
    BufferedReader in = new BufferedReader(new InputStreamReader(is));
    String line = null;
    while ((line = in.readLine()) != null)
    {
      if(isError)
      {
        _LOGGER.error(line);
      }
      else
      {
        _LOGGER.info(line);
      }
    }
  }
}