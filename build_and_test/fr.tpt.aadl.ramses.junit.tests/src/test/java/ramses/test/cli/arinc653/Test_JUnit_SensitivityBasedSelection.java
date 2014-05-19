package ramses.test.cli.arinc653;

import static org.junit.Assert.fail ;

import java.util.HashMap ;

import org.junit.Test ;

import ramses.test.util.OSGIPOKScenario ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;

public class Test_JUnit_SensitivityBasedSelection extends OSGIPOKScenario
{
  
  @Test
  public void  JUnit_sensitivity_selection_exec(){
    input = "tests/arinc653/arinc653-selection-sensitivity/input/test_buffer_delayed.aadl2";
    includeList = "tests/arinc653/";
    ramses_dir = System.getProperty("RAMSES_DIR");
    output = "tests/arinc653/arinc653-selection-sensitivity/output";
    output_ref = "tests/arinc653/arinc653-selection-sensitivity/output_ref";
    workflowPath = "tests/arinc653/arinc653-selection-sensitivity/input/test_aadlre.workflow";
    runtimePath = "/usr/share/pok";

    system_impl = "root_aadlre_test.impl";
    
    try
    {
      this.exec();
    }
    catch(Exception e)
    {
      e.printStackTrace();
      fail();
    }
  }
  
  @Override
  protected void initAdditionalParameters()
  {
    String propertyFilePath = "tests/arinc653/arinc653-selection-sensitivity/input/ArchitectureRefinementLauncher.properties";
    parameters = new HashMap<String, Object>();
    parameters.put(Names.RAMSES_PROPERTIES, propertyFilePath);
  }
  
}
