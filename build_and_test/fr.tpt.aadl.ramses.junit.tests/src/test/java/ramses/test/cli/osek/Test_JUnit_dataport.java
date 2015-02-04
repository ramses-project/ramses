package ramses.test.cli.osek;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import ramses.test.util.OSEKScenario;
import ramses.test.util.OSGIOSEKScenario;

public class Test_JUnit_dataport extends OSGIOSEKScenario{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	@Test
	public void Test_JUnit_dataport_exec() {
		input = "osek-dataport/input/test_osek_dataports.aadl2,";
		includeList = "tests/osek/";
		ramses_dir = System.getProperty("RAMSES_DIR");
		output = "tests/osek/osek-dataport/output";
		output_ref = "tests/osek/osek-dataport/output_ref";
		system_impl = "root.impl";
		this.exec();
	}

	@Override
	protected void initAdditionalParameters() {
		// TODO Auto-generated method stub
		
	}

}
