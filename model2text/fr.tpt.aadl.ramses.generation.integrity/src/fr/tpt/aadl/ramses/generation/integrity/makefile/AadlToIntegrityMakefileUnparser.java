package fr.tpt.aadl.ramses.generation.integrity.makefile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch;

import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.generator.TargetBuilderGenerator;

public class AadlToIntegrityMakefileUnparser extends AadlProcessingSwitch
												implements TargetBuilderGenerator
{

	@Override
	public void setParameters(Map<Enum<?>, Object> parameters) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void initSwitches() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process(SystemImplementation system, File runtimeDir,
			File outputDir, File[] includeDirs, IProgressMonitor monitor)
			throws GenerationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void process(ProcessorSubcomponent processor, File runtimeDir,
			File outputDir, File[] includeDirs, IProgressMonitor monitor)
			throws GenerationException {
		//Running on windows
		String command = "cmd /c python " + runtimeDir.getAbsolutePath() + "bin\\win32"+"\\intarinc.pyc "+
				outputDir.getAbsolutePath()+"\\"+processor.getName()+".xml"; //argument for the app
		
		System.out.println("Execute intarinc: "+ command);
		Process process;
		try {
			Runtime r = Runtime.getRuntime();
			process = r.exec(command, null, outputDir);
			
			BufferedReader reader=new BufferedReader(
		                  new InputStreamReader(process.getInputStream())
		              ); 
		    String line; 
		    while((line = reader.readLine()) != null) 
		    { 
		    	System.out.println(line);
		    } 
		                
		    process.waitFor();
		    process.destroy();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}

	@Override
	public void process(ProcessSubcomponent process, File runtimeDir,
			File outputDir, File[] includeDirs, IProgressMonitor monitor)
			throws GenerationException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean runtimePathChecker(File runtimePath) {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getRuntimePathEnvVar() {
		// TODO Auto-generated method stub
		return null;
	}

}
