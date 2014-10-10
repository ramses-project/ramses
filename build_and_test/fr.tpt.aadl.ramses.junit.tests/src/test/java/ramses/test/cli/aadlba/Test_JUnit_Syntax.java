package ramses.test.cli.aadlba;

import java.io.File ;

import org.junit.Test ;

import ramses.test.util.BaExamplesScenario ;

public class Test_JUnit_Syntax extends BaExamplesScenario
{
  @Test
  public void Test_JUnit_Syntaxe_exec()
  {
    _packages = "aadlBaTestPropertySet.aadl,aadlBaTestSubprogram.aadl,aadlBaTestTypes.aadl" ;
    
    _inputArray = new String[] { "aadlBaTest001.aadl",
                                 "aadlBaTest002.aadl",
                                 "aadlBaTest003.aadl",
                                 "aadlBaTest004.aadl",
                                 "aadlBaTest005.aadl",
                                 "aadlBaTest006.aadl",
                                 "aadlBaTest007.aadl"
                               } ;
    
    _include = "tests/aadlba/input/covering_syntax" ;

    _refDir = "tests/aadlba/output_ref/covering_syntax" ;
    
    _outputDir = new File ("tests/aadlba/output/covering_syntax") ;
    
    super.exec() ;
  }
}