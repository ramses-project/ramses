package ramses.test.cli.arinc653;

import org.junit.BeforeClass;
import org.junit.Test;

import ramses.test.util.POKScenario;

public class Test_JUnit_Buffer extends POKScenario {


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void  JUnit_events_exec(){
		input = "common-components/common-pkg.aadl2,arinc653-buffer/input/test_buffer.aadl2";
		includeList = "tests/arinc653/";
		ramses_dir = System.getProperty("RAMSES_DIR");
		output = "tests/arinc653/arinc653-buffer/output";
		output_ref = "tests/arinc653/arinc653-buffer/output_ref";
		this.exec();
	}
}
