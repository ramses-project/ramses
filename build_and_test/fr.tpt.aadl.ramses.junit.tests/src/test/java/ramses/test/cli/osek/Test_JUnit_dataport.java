package ramses.test.cli.osek;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import ramses.test.util.OSEKScenario;

public class Test_JUnit_dataport extends OSEKScenario{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	@Test
	public void Test_JUnit_dataport_exec() {
		
		this.exec();
//		fail("Not yet implemented");
	}

	@Override
	protected Process executeGeneratedCode() throws Exception {	
		Runtime runtime = Runtime.getRuntime();
		String[] testCommandArray = {"sleep", "3"};
		Process generatedCodeExecProcess = runtime.exec(testCommandArray);
		Thread.sleep(4000);
		return generatedCodeExecProcess;
	}

	@Override
	protected void init() {
		input = "osek-dataport/input/test_osek_dataports.aadl2,";
		includeList = "tests/osek/";
		ramses_dir = System.getProperty("RAMSES_DIR");
		output = "tests/osek/osek-dataport/output";
		output_ref = "tests/osek/osek-dataport/output_ref";
		target= "osek";
		system_impl = "root.impl";
		
	}

	@Override
	protected void initAdditionalParameters() {
		// TODO Auto-generated method stub
		
	}

}
