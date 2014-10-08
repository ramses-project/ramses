package ramses.test.cli.arinc653;

import org.junit.BeforeClass;
import org.junit.Test;

import ramses.test.util.OSGIPOKScenario ;

public class Test_JUnit_Delayed_Buffer_With_Mutex extends OSGIPOKScenario {


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void  JUnit_delayed_buffer_with_mutex_exec(){
		input = "common-components/common-pkg.aadl2,arinc653-buffer-delayed-with_mutex/input/test_buffer_delayed.aadl2";
		includeList = "tests/arinc653/";
		ramses_dir = System.getProperty("RAMSES_DIR");
		output = "tests/arinc653/arinc653-buffer-delayed-with_mutex/output";
		output_ref = "tests/arinc653/arinc653-buffer-delayed-with_mutex/output_ref";
		workflowPath = "tests/arinc653/arinc653-buffer-delayed-with_mutex/input/PDP_with_mutex.workflow";
		this.exec();
	}

  @Override
  protected void initAdditionalParameters()
  {
    // TODO Auto-generated method stub
    
  }
}
