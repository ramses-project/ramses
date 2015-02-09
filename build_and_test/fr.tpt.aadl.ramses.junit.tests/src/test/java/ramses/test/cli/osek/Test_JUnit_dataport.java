package ramses.test.cli.osek;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import ramses.test.util.OSGIOSEKScenario;

public class Test_JUnit_dataport extends OSGIOSEKScenario{
	private static ArrayList<String> IGNORE_FILE = new ArrayList<String>() ;
	private static ArrayList<String> IGNORE_DIR = new ArrayList<String>() ;
	
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

	@Override
	protected void clean() {

	
//	for (String path : list ){
//		File f = new File(output+path);
//		System.out.println("Cleaning of "+f.getAbsolutePath());
//		deleteFile(f);	
//	}
//		System.out.println("Cleaning...");
//		Runtime runtime = Runtime.getRuntime();
//		String[] testCommandArray = {"clean"};
//		try {
//			Process generatedCodeExecProcess = runtime.exec(testCommandArray);
//			Thread.sleep(4000);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}


	}

}
