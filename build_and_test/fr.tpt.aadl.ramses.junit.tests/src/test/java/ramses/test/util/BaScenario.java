package ramses.test.util;

import static org.junit.Assert.fail ;

import java.io.File ;
import java.io.IOException ;

import junit.framework.Assert ;

import org.osate.utils.FileUtils ;

import com.saxman.textdiff.Report ;
import com.saxman.textdiff.TextDiff ;

import fr.tpt.aadl.ramses.control.support.reporters.StdProcessTraceDisplay ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;

public abstract class BaScenario
{

  protected String _input ;
  protected String _packages ;
  protected File _standardErr ;
  protected File _errRef ;
  protected File _outputDir ;
  protected String _refDir ;
  protected String _include ;
  protected StringBuffer _args ;
  
  protected final static String _RAMSES_DIR ;
  protected final static String _RAMSES_FILE_NAME = "ramses-exe.jar" ;
  protected final static String _ERR_EXTENSION_FILE = ".err" ;
  protected final static char _SEPARATOR = ',' ;
  
  static
  {
    _RAMSES_DIR = System.getProperty("RAMSES_DIR");
  }
  
  protected void createArgs()
  {
    _args = new StringBuffer() ;
    
    _args.append("java") ;
    
    _args.append(" -DDEBUG ") ;
    
    if(_RAMSES_DIR != null)
    {
      _args.append("-D") ;
      _args.append(Names.RAMSES_RESOURCES_VAR) ;
      _args.append('=') ;
      _args.append(_RAMSES_DIR) ;
    }
    
    _args.append(" -jar ") ;
    
    if(_RAMSES_DIR != null)
    {
      _args.append(_RAMSES_DIR) ;
    }

    _args.append(_RAMSES_FILE_NAME) ;
    
    _args.append(" -l trace") ;
    
    _args.append(" -m ") ;
    
    if(_packages != null)
    {
      _args.append(_packages) ;
      _args.append(_SEPARATOR) ;
    }
    
    _args.append(_input) ;
    
    if(_include != null)
    {
      _args.append(" -i ") ;
      _args.append(_include) ;
    }
    
    if(_outputDir != null)
    {
      if (! _outputDir.exists())
      {
        _outputDir.mkdirs() ;
      }
      
      _args.append(" -o ") ;
      _args.append(_outputDir.getAbsolutePath()) ;
    }
    
    _args.append(" --parse ") ;
  }
  
  public void exec()
  {
    if(_outputDir != null)
    {
      FileUtils.deleteDirectoryContain(_outputDir) ;
    }
    
    this.createArgs() ;
    
    String commandText = _args.toString() ;
    
    try
    {
      Runtime runtime = Runtime.getRuntime();     
      // Launch code generation
      System.out.println(commandText);
      Process ramsesProcess = runtime.exec(commandText);
      StdProcessTraceDisplay.saveErrorMessage(ramsesProcess,
                                              _standardErr) ;
      ramsesProcess.waitFor();
      
      test() ;
    }
    catch(Exception e)
    {
      e.printStackTrace() ;
      fail();
      System.exit(-1);
    } 
  }

  protected void test()
  {
    try
    {
      Boolean finalResult = true ;
      
      Report report = new TextDiff().compare(_errRef, _standardErr);  
      if(report.containsDiff())
      {
        System.out.println("Differences found in error output for file: " +
                           _input + '\n');
        report.print();
        finalResult = false;
      }
          
      String emph ;
      
      if(finalResult)
      {
        emph = "###" ;
      }
      else
      {
        emph = "%%%" ;
      }
      
      System.out.println(emph + " Output is identical with reference: " + finalResult + ' ' + emph);

      
      // Unparse test is optional.
      if(_outputDir != null)
      {
        boolean tmp = this.testUnparse() ;
        finalResult &= tmp ;
        if(tmp)
        {
          emph = "###" ;
        }
        else
        {
          emph = "%%%" ;
        }
        System.out.println(emph + " UNPARSE output is identical with reference: " + tmp + ' ' + emph);
      }
      
      Assert.assertTrue(finalResult);
      Assert.assertTrue(_input != null) ;
    } catch (IOException e) {
      e.printStackTrace();
      fail();
    }
    catch(Exception e)
    {
      e.printStackTrace();
      fail();
    }
  }
  
  protected boolean testUnparse() throws Exception
  {
    boolean result = true ;
    
    Report report ;
    File fileRef ;
    
    for(File f : _outputDir.listFiles(new FileUtils.AadlFileFilter()))
    {
      fileRef = new File (_refDir + File.separator + f.getName());

      report = new TextDiff().compare(fileRef, f) ;
      
      if(report.containsDiff())
      {
        System.out.println("Differences found in unparse output for file: " +
                           f.getName() + '\n');
        report.print();
        result = false;
      }
    }
    
    return result ;
  }
  
  protected static String[] setupFromDirectoryArray(File inputDir)
  {
    File[] inputFiles = inputDir.listFiles(new FileUtils.AadlFileFilter()) ;
    String[] result = new String[inputFiles.length] ;
    
    for(int i = 0 ; i < inputFiles.length ; i++)
    {
      result[i] = inputFiles[i].getName() ;
    }  
    
    return result ;
  }
  
  protected static String setupFromDirectoryString(File inputDir)
  {
    File[] inputFiles = inputDir.listFiles(new FileUtils.AadlFileFilter()) ;
    StringBuilder result = new StringBuilder() ;
    
    for(int i = 0 ; i < inputFiles.length ; i++)
    {
      result.append(inputFiles[i].getName()) ;
      result.append(_SEPARATOR) ;
    }  
    
    return result.toString() ;
  }
}