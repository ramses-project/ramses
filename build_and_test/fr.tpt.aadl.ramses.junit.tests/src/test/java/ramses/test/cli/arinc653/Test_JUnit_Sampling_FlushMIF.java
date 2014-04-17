package ramses.test.cli.arinc653;

import org.junit.BeforeClass;
import org.junit.Test;

import ramses.test.util.POKScenario;

public class Test_JUnit_Sampling_FlushMIF extends POKScenario {


	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void  JUnit_sampling_exec(){
		input = "common-components/common-pkg.aadl2," +
				"arinc653-sampling/input/test_sampling.aadl2," +
				"arinc653-sampling-flush-mif/input/model.aadl";
		includeList = "tests/arinc653/";
		ramses_dir = System.getProperty("RAMSES_DIR");
		output = "tests/arinc653/arinc653-sampling-flush-mif/output";
		output_ref = "tests/arinc653/arinc653-sampling-flush-mif/output_ref";
		this.exec();
	}
}
