package ramses.test.util;

import static org.junit.Assert.fail ;

import java.io.File ;
import java.io.IOException ;

import junit.framework.AssertionFailedError ;

public class BaProjectScenario extends BaScenario
{
  protected String _projectName ;
  
  @Override
  public void exec()
  {
    try
    {
      _standardErr = File.createTempFile(_projectName,
                                         BaScenario._ERR_EXTENSION_FILE) ;
      
      _errRef = new File (_refDir + File.separator + _projectName +
                          BaScenario._ERR_EXTENSION_FILE) ;
      try
      {
        super.exec() ;
      }
      catch(AssertionFailedError ee)
      {
        String msg = "the following test has failed: " + _projectName ;
        fail(msg) ;
      }
      finally
      {
        _standardErr.delete() ;
      }
    }
    catch(IOException e)
    {
      e.printStackTrace() ;
      fail();
      System.exit(-1);
    }
  }
}