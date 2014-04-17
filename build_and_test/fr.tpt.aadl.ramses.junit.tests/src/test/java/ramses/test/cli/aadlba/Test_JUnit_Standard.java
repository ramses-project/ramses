package ramses.test.cli.aadlba;

import java.io.File ;

import org.junit.Test ;

import ramses.test.util.BaExamplesScenario ;
import ramses.test.util.BaScenario ;

public class Test_JUnit_Standard extends BaExamplesScenario
{
  @Test
  public void Test_JUnit_Standard_exec()
  {
    _packages = null ;
    _include = "tests/aadlba/input/standard_examples" ;
    _refDir = "tests/aadlba/output_ref/standard_examples" ;
    _inputArray = BaScenario.setupFromDirectoryArray(new File(_include)) ;
    _outputDir = new File ("tests/aadlba/output/standard_examples") ;
    super.exec() ;
  }
}