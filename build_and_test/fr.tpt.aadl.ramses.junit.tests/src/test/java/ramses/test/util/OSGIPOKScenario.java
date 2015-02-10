package ramses.test.util;

import java.io.IOException ;
import fr.tpt.aadl.ramses.control.support.utils.EnvUtils ;

public abstract class OSGIPOKScenario extends OSGIScenario
{
  private static final String DEFAULT_RUNTIME_PATH = "/usr/share/pok" ;
  
  	protected void init()
	{
		target="pok";
		
		if(runtimePath==null || runtimePath.equals(""))
		{
		  runtimePath=EnvUtils.getExternalVariable("POK_PATH");
	    
	    if(runtimePath==null || runtimePath.equals(""))
	    {
	      runtimePath = DEFAULT_RUNTIME_PATH ;
	    }
		}
		aadlInspectorPath = System.getenv("AADLINSPECTOR_PATH");
		if(aadlInspectorPath == null || aadlInspectorPath.equals(""))
			aadlInspectorPath = System.getProperty("AADLINSPECTOR_PATH");
		
		IGNORE_FILES.add(".pid");
		IGNORE_FILES.add("sizes.c");
		
	}
	
	@Override
	protected Process executeGeneratedCode() throws IOException, InterruptedException
	{
	  Runtime runtime = Runtime.getRuntime();
	  String[] testCommandArray = {"make","-C"+ output + "/generated-code", "test"};
	  Process generatedCodeExecProcess = runtime.exec(testCommandArray);
	  Thread.sleep(45000);
	  return generatedCodeExecProcess ;
	}
}