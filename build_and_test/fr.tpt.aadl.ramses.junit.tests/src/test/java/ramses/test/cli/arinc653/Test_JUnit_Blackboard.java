package ramses.test.cli.arinc653;

import org.junit.BeforeClass;
import org.junit.Test;

import ramses.test.util.OSGIPOKScenario ;
import ramses.test.util.POKScenario;

public class Test_JUnit_Blackboard extends OSGIPOKScenario {	

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void  JUnit_blackboard_exec(){
		input = "common-components/common-pkg.aadl2,arinc653-blackboard/input/test_blackboard.aadl2";
		includeList = "tests/arinc653/";
		ramses_dir = System.getProperty("RAMSES_DIR");
		output = "tests/arinc653/arinc653-blackboard/output";
		output_ref = "tests/arinc653/arinc653-blackboard/output_ref";
		this.exec();
	}

  @Override
  protected void initAdditionalParameters()
  {
    // TODO Auto-generated method stub
    
  }
}
