package ramses.test.util;

import java.io.File;
import java.io.IOException;

import fr.tpt.aadl.ramses.control.support.utils.EnvUtils ;

public abstract class OSGIOSEKScenario extends OSGIScenario {

	private static final String DEFAULT_RUNTIME_PATH = "/data/packages/nxtOSEK" ;
	
	@Override
	protected Process executeGeneratedCode() throws IOException, InterruptedException
	{
		Runtime runtime = Runtime.getRuntime();
		  String[] testCommandArray = {"make","-C"+ output + "/generated-code", "all"};
		  Process generatedCodeExecProcess = runtime.exec(testCommandArray);
		  Thread.sleep(45000);
		  clean();
		  return generatedCodeExecProcess ;
//		  return null;
	}

	@Override
	protected void init() {
		target="osek";
		
		if(runtimePath==null || runtimePath.equals(""))
    {
      runtimePath=EnvUtils.getExternalVariable("OSEK_PATH");
      
      if(runtimePath==null || runtimePath.equals(""))
      {
        runtimePath = DEFAULT_RUNTIME_PATH ;
      }
    }
		
		aadlInspectorPath = System.getenv("AADLINSPECTOR_PATH");
		if(aadlInspectorPath == null || aadlInspectorPath.equals(""))
			aadlInspectorPath = System.getProperty("AADLINSPECTOR_PATH");
		
	}

	@Override
	protected void initAdditionalParameters() {}

	protected abstract void clean();
	
	protected void deleteFile(File f){
		if (f.exists()){
			if (f.listFiles() != null)
				for (File sub_f : f.listFiles())
					deleteFile(sub_f);

			f.delete();	
		}
	}
}
