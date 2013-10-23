/**
 * AADL-RAMSES
 * 
 * Copyright © 2012 TELECOM ParisTech and CNRS
 * 
 * TELECOM ParisTech/LTCI
 * 
 * Authors: see AUTHORS
 * 
 * This program is free software: you can redistribute it and/or modify 
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see 
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.ramses.generation.osek;

import fr.tpt.aadl.ramses.control.support.generator.AbstractGeneratorFactory;
import fr.tpt.aadl.ramses.control.support.generator.Generator;
import fr.tpt.aadl.ramses.generation.c.AadlToCUnparser;
import fr.tpt.aadl.ramses.generation.osek.ast.OIL;
import fr.tpt.aadl.ramses.generation.osek.c.AadlOSEKCodeGenerator;
import fr.tpt.aadl.ramses.generation.osek.c.AadlToOSEKNxtCUnparser;
import fr.tpt.aadl.ramses.generation.osek.makefile.AadlToOSEKnxtMakefileUnparser;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificCodeGenerator;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificGenerator;

public class OSEKGeneratorFactory extends AbstractGeneratorFactory {
	public static String OSEK_GENERATOR_NAME = "osek";

	private static Generator createOSEKGenerator() {

		OIL oil = new OIL();
		
		// Instantiate generator ADDL-- to C
		AadlToCUnparser genericCUnparser = AadlToCUnparser.getAadlToCUnparser() ;

		// Instantiate generator OIL
		AadlToOSEKNxtCUnparser osekCUnparser = new AadlToOSEKNxtCUnparser(oil);

		// Call "goil" trampoline program
		AadlToOSEKnxtMakefileUnparser osekMakefileUnparser = new AadlToOSEKnxtMakefileUnparser();

		// Instantiate transformation AADL to refined ADDL
		AadlOsekTransformation targetTrans = new AadlOsekTransformation("helpers/LanguageSpecificitiesC");

		// new implementation
		AadlTargetSpecificCodeGenerator tarSpecCodeGen = new AadlOSEKCodeGenerator(genericCUnparser, osekCUnparser,
				osekMakefileUnparser);

		// Generate oil and C
		AadlTargetSpecificGenerator result = new AadlTargetSpecificGenerator(targetTrans, tarSpecCodeGen);

		result.setRegistryName(OSEK_GENERATOR_NAME);

		return result;
	}
	
	@Override
	public Generator createGenerator() {
			return createOSEKGenerator();
	}
}
