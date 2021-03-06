package ramses.test.cli.arinc653;

import org.junit.BeforeClass;
import org.junit.Test;

import ramses.test.util.OSGIPOKScenario ;

public class Test_JUnit_Delayed_Buffer_No_Mutex_LowMFP extends OSGIPOKScenario {


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void  JUnit_delayed_buffer_no_mutex_lowmfp_exec(){
		input = "common-components/common-pkg.aadl2,arinc653-buffer-delayed-no_mutex_lowmfp/input/test_buffer_delayed.aadl2";
		includeList = "tests/arinc653";
		ramses_dir = System.getProperty("RAMSES_DIR");
		output = "tests/arinc653/arinc653-buffer-delayed-no_mutex_lowmfp/output";
		output_ref = "tests/arinc653/arinc653-buffer-delayed-no_mutex_lowmfp/output_ref";
		workflowPath = "tests/arinc653/arinc653-buffer-delayed-no_mutex_lowmfp/input/PDP_no_mutex_lowMFP.workflow";
		this.exec();
	}

  @Override
  protected void initAdditionalParameters()
  {
    // TODO Auto-generated method stub
    
  }
}
