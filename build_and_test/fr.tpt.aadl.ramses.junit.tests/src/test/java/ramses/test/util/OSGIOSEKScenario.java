package ramses.test.util;

import java.io.IOException;

public class OSGIOSEKScenario extends OSGIScenario {

//	private static final String DEFAULT_RUNTIME_PATH = "" ;
	
	@Override
	protected Process executeGeneratedCode() throws IOException, InterruptedException
	{
		Runtime runtime = Runtime.getRuntime();
		  String[] testCommandArray = {"make","-C"+ output + "/generated-code", "test"};
		  Process generatedCodeExecProcess = runtime.exec(testCommandArray);
		  Thread.sleep(45000);
		  return generatedCodeExecProcess ;
	}

	@Override
	protected void init() {
		target="osek";
		aadlInspectorPath = System.getenv("AADLINSPECTOR_PATH");
		if(aadlInspectorPath == null || aadlInspectorPath.equals(""))
			aadlInspectorPath = System.getProperty("AADLINSPECTOR_PATH");
		
		aadlInspectorPath = System.getenv("AADLINSPECTOR_PATH");
		if(aadlInspectorPath == null || aadlInspectorPath.equals(""))
			aadlInspectorPath = System.getProperty("AADLINSPECTOR_PATH");
	}

	@Override
	protected void initAdditionalParameters() {}

}
