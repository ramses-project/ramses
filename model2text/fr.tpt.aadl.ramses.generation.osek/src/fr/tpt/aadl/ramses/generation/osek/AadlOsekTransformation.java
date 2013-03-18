package fr.tpt.aadl.ramses.generation.osek;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;

import fr.tpt.aadl.ramses.control.support.generator.AadlToTargetSpecificAadl;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.transformation.atl.AtlTransfoLauncher;

public class AadlOsekTransformation implements AadlToTargetSpecificAadl {

	public static final String[] ATL_FILE_NAMES = new String[] { "targets/osek/ExpandThreadsPorts.asm", "ExpandSubprogramCalls.asm", "CreateThreadsBehavior.asm" };

	public static final List<File> ATL_FILES = new ArrayList<File>(ATL_FILE_NAMES.length);



	@Override
	public Resource transform(Resource inputResource,
	                          File resourceFilePath,
	                          File generatedFilePath)
	                                throws GenerationException {
	  for (String fileName : ATL_FILE_NAMES) {
	    ATL_FILES.add(new File(resourceFilePath.getAbsolutePath() +"/"+ fileName));
	  }

	  AtlTransfoLauncher atlLauncher;
	  try {
		  atlLauncher = new AtlTransfoLauncher();
		  return atlLauncher.generationEntryPoint(inputResource,
				  resourceFilePath,
				  ATL_FILES,
				  generatedFilePath);
	  } catch (Exception e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		  return null;
	  }
	  
  }


	 @Override
	  public Resource transformXML(Resource inputResource,
	                            File resourceFilePath,
	                            List<String> resourceFileNameList,
	                            File generatedFilePath)
	                                  throws GenerationException {
	    
	    List<File> atlFiles = new ArrayList<File>();
	    for(String resourceFileName : resourceFileNameList)
	    {
	      atlFiles.add(new File(resourceFilePath.getAbsolutePath() +"/"+ resourceFileName));
	    }

	    AtlTransfoLauncher atlLauncher;
		  try {
			  atlLauncher = new AtlTransfoLauncher();
			  return atlLauncher.generationEntryPoint(inputResource,
					  resourceFilePath,
					  ATL_FILES,
					  generatedFilePath);
		  } catch (Exception e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
			  return null;
		  }
	  }
	
	@Override
	public void setParameters(Map<Enum<?>, Object> parameters) {
		throw new UnsupportedOperationException();
	}
}
