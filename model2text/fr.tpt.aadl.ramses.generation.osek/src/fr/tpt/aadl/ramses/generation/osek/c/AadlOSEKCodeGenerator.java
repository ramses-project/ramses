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

}
