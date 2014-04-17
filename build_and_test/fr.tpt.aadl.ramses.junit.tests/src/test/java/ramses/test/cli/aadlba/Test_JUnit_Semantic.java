package ramses.test.cli.aadlba;

import java.io.File ;

import org.junit.Test ;

import ramses.test.util.BaExamplesScenario ;
import ramses.test.util.BaScenario ;

public class Test_JUnit_Semantic extends BaExamplesScenario
{
  @Test
  public void Test_JUnit_Semantic_exec()
  {
    _packages = null ;
    _include = "tests/aadlba/input/covering_semantic" ;
    _refDir = "tests/aadlba/output_ref/covering_semantic" ;
    _inputArray = BaScenario.setupFromDirectoryArray(new File(_include)) ;
    _outputDir = new File ("tests/aadlba/output/covering_semantic") ;
    super.exec() ;
  }
}