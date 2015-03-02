package ramses.test.cli.osek;

import java.io.File;
import org.junit.BeforeClass;
import org.junit.Test;

import ramses.test.util.OSGIOSEKScenario;

public class Test_JUnit_sonarTest extends OSGIOSEKScenario{
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		
		
	}

	@Test
	public void Test_JUnit_sonarTest_exec() {
		String project = "osek-sonar-test";
		String root_path = "tests/osek/"+project;
		input = root_path+"/input/model.aadl,";
		includeList = "tests/osek/osek-lego-devices-commons";
		ramses_dir = System.getProperty("RAMSES_DIR");
		output = root_path+"/output";
		output_ref = root_path+"/output_ref";
		system_impl = "root.impl";
//		workflowPath = project+"/input/modes.workflow";
		
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
