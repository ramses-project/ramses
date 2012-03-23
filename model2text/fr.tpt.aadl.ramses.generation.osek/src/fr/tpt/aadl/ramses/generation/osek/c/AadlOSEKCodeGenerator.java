package fr.tpt.aadl.ramses.generation.osek.c;

import java.io.File;
import java.util.List;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.Element;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.impl.SubprogramTypeImpl;

import fr.tpt.aadl.ramses.control.support.generator.AadlGenericUnparser ;
import fr.tpt.aadl.ramses.control.support.generator.AadlTargetUnparser ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.generator.TargetBuilderGenerator ;
import fr.tpt.aadl.ramses.generation.c.AadlToCUnparser;
import fr.tpt.aadl.ramses.generation.osek.makefile.AadlToOSEKMakefileUnparser;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificCodeGenerator;
import fr.tpt.aadl.ramses.generation.target.specific.GeneratorUtils;
import fr.tpt.aadl.ramses.util.generation.FileUtils ;


public class AadlOSEKCodeGenerator extends AadlTargetSpecificCodeGenerator {

	public AadlOSEKCodeGenerator(AadlToCUnparser genericCUnparser, AadlToOSEKCUnparser targetUnparser,
			AadlToOSEKMakefileUnparser targetBuilderGen) {
		super((AadlGenericUnparser) genericCUnparser, 
		      (AadlTargetUnparser) targetUnparser,
		      (TargetBuilderGenerator) targetBuilderGen);
	}

	/**
	 * Generate code from aadl-- AST.
	 */
	/*public void generate(Resource inputResource, File generatedFilePath) throws GenerationException {

		String fileName = "";
		final AadlToOSEKCUnparser targetUnparser = (AadlToOSEKCUnparser) _targetUnparser;
		final File generatedCodeDirectory = new File(generatedFilePath, GENERATED_DIR_NAME);
		
		if (generatedCodeDirectory.exists())
			FileUtils.deleteDirectory(generatedCodeDirectory);
		generatedCodeDirectory.mkdir();
		
		TreeIterator<EObject> iter = inputResource.getAllContents();
		
		try {
			// Open OIL generation
			targetUnparser.open(generatedCodeDirectory, generatedFilePath);

			while (iter.hasNext()) {
				Element elt = (Element) iter.next();

				if (elt instanceof SystemImplementation) {
					SystemImplementation si = (SystemImplementation) elt;

					// OIL generation
					targetUnparser.process(si, generatedFilePath);

					for (ProcessorSubcomponent ps : si.getOwnedProcessorSubcomponents()) {
						// create directory with the processor subcomponent name
						File processorFileDir = new File(generatedCodeDirectory, ps.getName());
						processorFileDir.mkdir();

						List<ProcessSubcomponent> ownedProcess = GeneratorUtils.getBindedProcesses(ps);

						for (ProcessSubcomponent process : ownedProcess) {
							String generationTargetDirectory = processorFileDir + "/" + process.getName();
							File processDirectory = new File(generationTargetDirectory);
							processDirectory.mkdir();

							_genericUnparser.process(process, processDirectory);
						}
					}
				} else if (elt instanceof SubprogramTypeImpl) {
					targetUnparser.process((SubprogramTypeImpl) elt, generatedFilePath);
				}
			}

			targetUnparser.process(FileUtils.findFiles(generatedCodeDirectory, "c"));
		} finally {
			// close OIL generation
			targetUnparser.close();
		}
		
	}*/
}
