package ramses.test.cli.arinc653;

import org.junit.BeforeClass;
import org.junit.Test;

import ramses.test.util.POKScenario;

public class Test_JUnit_PingPong_Ba extends POKScenario {


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void  JUnit_pingpong_ba_exec(){
		input = "tests/arinc653/arinc653-pingpong-ba/input/coal_types.aadl," +
				"tests/arinc653/arinc653-pingpong-ba/input/ping-pong_N2_22Fev.aadl";
		ramses_dir = System.getProperty("RAMSES_DIR");
		output = "tests/arinc653/arinc653-pingpong-ba/output";
		output_ref = "tests/arinc653/arinc653-pingpong-ba/output_ref";
		system_impl = "monoProc.impl";
		this.exec();
	}
}
