package ramses.test.cli.aadlba;

import java.io.File ;

import org.junit.Test ;

import ramses.test.util.BaExamplesScenario ;

public class Test_JUnit_Toy extends BaExamplesScenario
{
  @Test
  public void Test_JUnit_Toy_exec()
  {
    _packages = null ;
    _inputArray = new String[] { "multiModalPingPong.aadl2"
                               } ;
    
    _include = "tests/aadlba/input/toy_examples" ;

    _refDir = "tests/aadlba/output_ref/toy_examples" ;
    
    _outputDir = new File ("tests/aadlba/output/toy_examples") ;
    
    super.exec() ;
  }
}