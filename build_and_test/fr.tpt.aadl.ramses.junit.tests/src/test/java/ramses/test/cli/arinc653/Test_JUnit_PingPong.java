package ramses.test.cli.arinc653;

import org.junit.BeforeClass;
import org.junit.Test;

import ramses.test.util.OSGIPOKScenario ;

public class Test_JUnit_PingPong extends OSGIPOKScenario {


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void  JUnit_pingpong_exec(){
		input = "tests/arinc653/arinc653-pingpong/input/ping-pong_v0.4_next.aadl";
		ramses_dir = System.getProperty("RAMSES_DIR");
		output = "tests/arinc653/arinc653-pingpong/output";
		output_ref = "tests/arinc653/arinc653-pingpong/output_ref";
		system_impl = "PingPong_Communication_System.impl";
		this.exec();
	}

  @Override
  protected void initAdditionalParameters()
  {
    // TODO Auto-generated method stub
    
  }
}
