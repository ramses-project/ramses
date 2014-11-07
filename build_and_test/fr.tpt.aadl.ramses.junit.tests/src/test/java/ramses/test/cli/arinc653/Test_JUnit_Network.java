package ramses.test.cli.arinc653;

import org.junit.BeforeClass;
import org.junit.Test;

import ramses.test.util.OSGIPOKScenario ;

public class Test_JUnit_Network extends OSGIPOKScenario {


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void  JUnit_network_exec(){
		input = "common-components/common-pkg.aadl2,arinc653-network/input/test_network_rtl8029.aadl2";
		includeList = "tests/arinc653/";
		ramses_dir = System.getProperty("RAMSES_DIR");
		output = "tests/arinc653/arinc653-network/output";
		output_ref = "tests/arinc653/arinc653-network/output_ref";
		workflowPath = "tests/arinc653/arinc653-network/input/test_network.workflow";
		this.exec();
	}

  @Override
  protected void initAdditionalParameters()
  {
    // TODO Auto-generated method stub
    
  }
}
