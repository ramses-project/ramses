package ramses.test.cli.aadlba;

import java.io.File ;

import org.junit.Test ;

import ramses.test.util.BaProjectScenario ;

public class Test_JUnit_Minimal extends BaProjectScenario
{
  @Test
  public void Test_JUnit_Minimal_exec()
  {
    
    _include = "tests/minimal_runtime/input" ;
    
    _input = "minimal_example.aadl2," +
             "minimal_common_example.aadl2," +
             "minimal_aperiodic_example.aadl2," +
             "minimal_periodic_example.aadl2," +
             "minimal_system_example.aadl2" ;

    _projectName = "minimal_example" ;
    
    _include += _SEPARATOR + _RAMSES_DIR + "aadl_resources/package" ;

    _refDir = "tests/minimal_runtime/output_ref" ;
    
    _outputDir = new File ("tests/minimal_runtime/output") ;
    
    super.exec() ;
  }
}