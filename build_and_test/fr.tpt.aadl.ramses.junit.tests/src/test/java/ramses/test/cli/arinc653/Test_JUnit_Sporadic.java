package ramses.test.cli.arinc653;

import org.junit.BeforeClass;
import org.junit.Test;

import ramses.test.util.POKScenario;

public class Test_JUnit_Sporadic extends POKScenario {


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void  JUnit_sporadic_exec(){
		input = "common-components/common-pkg.aadl2,arinc653-sporadic/input/test_sporadic.aadl2";
		includeList = "tests/arinc653/";
		ramses_dir = System.getProperty("RAMSES_DIR");
		output = "tests/arinc653/arinc653-sporadic/output";
		output_ref = "tests/arinc653/arinc653-sporadic/output_ref";
		this.exec();
	}
}
