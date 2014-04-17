package ramses.test.cli.arinc653;

import org.junit.BeforeClass;
import org.junit.Test;

import ramses.test.util.POKScenario;

public class Test_JUnit_CBTC extends POKScenario {


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void  JUnit_cbtc_exec(){
		input = "tests/arinc653/arinc653-cbtc/input/coal_types.aadl," +
				"tests/arinc653/arinc653-cbtc/input/cbtcN2_25Fev.aadl";
		ramses_dir = System.getProperty("RAMSES_DIR");
		output = "tests/arinc653/arinc653-cbtc/output";
		output_ref = "tests/arinc653/arinc653-cbtc/output_ref";
		system_impl = "monoProc.impl";
		this.exec();
	}
}
