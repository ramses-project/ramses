package ramses.test.cli.arinc653;

import org.junit.BeforeClass;
import org.junit.Test;

import ramses.test.util.POKScenario;

public class Test_JUnit_Events extends POKScenario {


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void  JUnit_events_exec(){
		input = "common-components/common-pkg.aadl2,tests/arinc653/arinc653-events/input/test_events.aadl2";
		includeList = "tests/arinc653/";
		ramses_dir = System.getProperty("RAMSES_DIR");
		output = "tests/arinc653/arinc653-events/output";
		output_ref = "tests/arinc653/arinc653-events/output_ref";
		this.exec();
	}
}
