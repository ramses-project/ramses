package fr.tpt.aadl.ramses.generation.osek.c;

import fr.tpt.aadl.ramses.control.support.generator.AadlGenericUnparser;
import fr.tpt.aadl.ramses.control.support.generator.AadlTargetUnparser;
import fr.tpt.aadl.ramses.control.support.generator.TargetBuilderGenerator;
import fr.tpt.aadl.ramses.generation.c.AadlToCUnparser;
import fr.tpt.aadl.ramses.generation.osek.makefile.AadlToOSEKnxtMakefileUnparser;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificCodeGenerator;


public class AadlOSEKCodeGenerator extends AadlTargetSpecificCodeGenerator {

	public AadlOSEKCodeGenerator(AadlToCUnparser genericCUnparser, AadlToOSEKNxtCUnparser osekCUnparser,
			AadlToOSEKnxtMakefileUnparser targetBuilderGen) {
		super((AadlGenericUnparser) genericCUnparser, 
		      (AadlTargetUnparser) osekCUnparser,
		      (TargetBuilderGenerator) targetBuilderGen);
	}

}
