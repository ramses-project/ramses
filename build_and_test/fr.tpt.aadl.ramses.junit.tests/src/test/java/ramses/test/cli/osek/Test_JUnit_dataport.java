package ramses.test.cli.osek;

import java.io.File;
import org.junit.BeforeClass;
import org.junit.Test;

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
		
	    File dir = new File(output);
	    if (!dir.exists()) {
	        System.out.println("creating directory: " + output);
	        boolean result = false;
	        try{
	            dir.mkdir();
	            result = true;
	         } catch(SecurityException se){
	        	 se.printStackTrace();
	         }        
	         if(result) {    
	           System.out.println(output+" created");  
	         }
	      }
		this.exec();
	}

	@Override
	protected void initAdditionalParameters() {
		// TODO Auto-generated method stub
		
	}
}
