package ramses.test.util;

import static org.junit.Assert.fail ;

import java.io.File ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.List ;

public abstract class BaExamplesScenario extends BaScenario
{
  protected String[] _inputArray ;
  protected List<String> _failedTests = new ArrayList<String>();
  
  @Override
  public void exec()
  {
    try
    {
      for(String currentModel : _inputArray)
      {
        _input = currentModel ;
        
        String prefix = currentModel.substring(0, currentModel.lastIndexOf('.')) ;
        
        _standardErr = File.createTempFile(prefix, BaScenario._ERR_EXTENSION_FILE) ;
        
        _errRef = new File (_refDir + File.separator + prefix +
                            BaScenario._ERR_EXTENSION_FILE) ;
        try
        {
          super.exec() ;
        }
        catch(AssertionError ee)
        {
          _failedTests.add(currentModel) ;
        }
        finally
        {
          _standardErr.delete() ;
        }
      }
      
      if(! _failedTests.isEmpty())
      {
        StringBuilder msg = new StringBuilder() ;
        String separator = "; " ;
        
        msg.append("the following tests have failed: ") ;
        for (String test : _failedTests)
        {
          msg.append(test) ;
          msg.append(separator) ;
        }
        msg.delete(msg.lastIndexOf(separator), msg.length()) ;
        
        fail(msg.toString()) ;
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