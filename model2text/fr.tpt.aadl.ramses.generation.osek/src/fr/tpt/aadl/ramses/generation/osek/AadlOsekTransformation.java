package fr.tpt.aadl.ramses.generation.osek;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;

import fr.tpt.aadl.ramses.control.support.generator.AadlToTargetSpecificAadl;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.instantiation.StandAloneInstantiator;
import fr.tpt.aadl.ramses.transformation.atl.AtlTransfoLauncher;

public class AadlOsekTransformation implements AadlToTargetSpecificAadl {

	public static final String[] ATL_FILE_NAMES = new String[] { "osek/ExpandThreadsPorts.asm", "ExpandSubprogramCalls.asm", "CreateThreadsBehavior.asm" };

	public static final List<File> ATL_FILES = new ArrayList<File>(
			ATL_FILE_NAMES.length);

	@Override
	public Resource transform(Resource inputResource,
	                          File resourceFilePath,
	                          Map<String, Resource> standardPropertySets,
	                          File generatedFilePath)
	                                throws GenerationException {
		
	  for (String fileName : ATL_FILE_NAMES) {
      ATL_FILES.add(new File(resourceFilePath.getAbsolutePath() +"/"+ fileName));
    }
	  
	  AtlTransfoLauncher atlTransfo = null;

		try {
			atlTransfo = new AtlTransfoLauncher();

			
			atlTransfo.setResourcesDirectory(resourceFilePath);

			String aaxlGeneratedFileName = inputResource.getURI()
					.toFileString().replaceFirst(".aaxl2", "_extended.aaxl2");

			Resource expandedResult = atlTransfo.doGeneration(inputResource,
					standardPropertySets, ATL_FILES, aaxlGeneratedFileName);

			String aadlGeneratedFileName = inputResource.getURI()
					.toFileString();
			aadlGeneratedFileName = aadlGeneratedFileName.replaceFirst(
					".aaxl2", "_extended.aadl2");

			StandAloneInstantiator instantiator = StandAloneInstantiator
					.getInstantiator();
			instantiator.serialize(expandedResult, aadlGeneratedFileName);

			return expandedResult;
		} catch (Exception e) {
			e.printStackTrace();
			throw new GenerationException(e.getMessage());
		}
	}

	@Override
	public void setParameters(Map<Enum<?>, Object> parameters) {
		throw new UnsupportedOperationException();
	}
}
