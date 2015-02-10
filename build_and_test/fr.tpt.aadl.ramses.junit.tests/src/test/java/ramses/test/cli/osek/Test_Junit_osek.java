package ramses.test.cli.osek;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.BeforeClass;
import org.junit.Test;

import ramses.test.util.OSGIOSEKScenario;

public class Test_Junit_osek extends OSGIOSEKScenario {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Test
	public void Test_JUnit_osek_exec() {
		input = "osek/input/usecase.aadl,";
		includeList = "tests/osek/";
		ramses_dir = System.getProperty("RAMSES_DIR");
		output = "tests/osek/osek/output";
		output_ref = "tests/osek/osek/output_ref";
		system_impl = "nxt.Impl";
		
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

}
