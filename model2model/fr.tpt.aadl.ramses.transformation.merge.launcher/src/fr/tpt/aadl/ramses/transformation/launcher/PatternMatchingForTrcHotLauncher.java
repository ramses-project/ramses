package fr.tpt.aadl.ramses.transformation.launcher;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList ;
import java.util.Iterator;
import java.util.List ;
import java.util.Properties;

import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.m2m.atl.core.ATLCoreException;
import org.eclipse.m2m.atl.engine.compiler.CompileTimeError;

import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.transformation.trc.Module;
import fr.tpt.aadl.ramses.transformation.trc.Transformation ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification;
import fr.tpt.aadl.ramses.transformation.trc.util.TrcParser;
import fr.tpt.atl.compiler.Atl2EmftvmCompiler;
import fr.tpt.atl.hot.launcher.Atl2AtlLauncher;

public class PatternMatchingForTrcHotLauncher {

	private List<Transformation> transformations=null;
	
	private ResourceSet resourceSet ;

  private RamsesConfiguration config ;
		
	public PatternMatchingForTrcHotLauncher(List<Transformation> transformations,
	                                        ResourceSet resourceSet,
	                                        RamsesConfiguration config)
	{
		this.transformations = transformations;
		this.resourceSet = resourceSet;
		this.config = config;
	}
	
	/**
	 * @param args
	 */
	public void launch() {		
		
		Atl2AtlLauncher hotLauncher;
		try {
			hotLauncher = new Atl2AtlLauncher("Atl2PatternMatching4Aadl2Aadl",
			                                  resourceSet);

			// retrieve module list in which each module path is present
			// at most once.
			List<Module> moduleList = new ArrayList<Module>();
			List<String> alreadyAdded = new ArrayList<String>();
			
			for(Transformation t : transformations)
			{
			  for(Module m: t.getModules())
			  {
			    if(alreadyAdded.contains(m.getPath()))
			      continue;
			    alreadyAdded.add(m.getPath());
			    moduleList.add(m);
			  }
			}
			
		  // execute the HOT for pattern matching for each transformation
      // included in the TRC iterate on available transformations
			@SuppressWarnings("unchecked")
			Iterator<Module> modulesIt = moduleList.iterator();
			while (modulesIt.hasNext()) {
				Module moduleObject = modulesIt.next();
				String mainATLFileName = moduleObject.getPath();
				String refinedAtlFile = config.getRamsesOutputDir().getAbsolutePath()
				    +"/"+mainATLFileName.replace(
						".atl", "_2pml.atl");

				// execute ATL 2 PatternMatching transformation
				String[] inputs = new String[]{RamsesConfiguration.getRamsesResourceDir().getAbsolutePath()
				                               +"/"+mainATLFileName}; 

				hotLauncher.launchHot(inputs, refinedAtlFile);

				//compile generated transformation
				Atl2EmftvmCompiler aec = new Atl2EmftvmCompiler();
				CompileTimeError[] errors = aec.compile(refinedAtlFile, refinedAtlFile.replace(".atl", ""));
				if(errors.length > 0)
				{
					for(int i=0; i< errors.length; i++)
						System.err.println("ERROR: "+errors[i].getDescription());
				}
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ATLCoreException e) {
			e.printStackTrace();
		}

	}

}
