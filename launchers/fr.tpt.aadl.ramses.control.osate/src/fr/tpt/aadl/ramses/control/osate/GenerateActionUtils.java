package fr.tpt.aadl.ramses.control.osate;

import java.io.File;

public class GenerateActionUtils {

	public static String findWorkflow(File rootDirectory)
	{
		File[] list = rootDirectory.listFiles();

		if (list == null) return null;

		for ( File f : list ) {
			if ( f.isDirectory() ) {
				String result = findWorkflow( f );
				if(result == null)
					continue;
				else
					return result;
			}
			else {
				if(f.getPath().endsWith(".workflow"))
					return f.getAbsolutePath(); 
			}
		}
		return null;
	}

}
