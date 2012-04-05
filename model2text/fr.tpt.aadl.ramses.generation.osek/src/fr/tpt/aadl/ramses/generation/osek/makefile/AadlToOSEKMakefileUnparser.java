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

package fr.tpt.aadl.ramses.generation.osek.makefile;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Map;

import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.SystemImplementation;

import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.TargetBuilderGenerator ;
import fr.tpt.aadl.ramses.generation.osek.ast.OIL;
import fr.tpt.aadl.ramses.util.generation.FileUtils ;

public class AadlToOSEKMakefileUnparser implements TargetBuilderGenerator {

	private OIL oil;

	public AadlToOSEKMakefileUnparser(OIL oil) {
		this.oil = oil;
	}

	
	@Override
  public void process(ProcessSubcomponent process, File generatedFilePath) throws GenerationException {
    
    Runtime runtime = Runtime.getRuntime();

    System.out.println("* Prepare Make ...");

    
    // Copy runtime and user c code
    for (File src : oil.getCpu().getOs().getAppSrcs()) {
      System.out.println("src " + src);
      FileUtils.copyFile(src, generatedFilePath);
    }

    // Copy runtime and user header code
    for (File header : oil.getCpu().getOs().getAppHeaders()) {
      FileUtils.copyFile(header, generatedFilePath);
    }

    File preparemake = new File(FileUtils.getContainingDirectory(process.eResource()), "/preparemake.sh");
    
    preparemake = FileUtils.copyFile(preparemake, generatedFilePath);
    preparemake.setExecutable(true);

    // TrampolineBasePath NOT found
    if (oil.getCpu().getOs().getTrampolineBasePath() == null) {

      File refineOil = new File(FileUtils.getContainingDirectory(process.eResource()), "/refine_oil.sh");
      refineOil = FileUtils.copyFile(refineOil, generatedFilePath);
      refineOil.setExecutable(true);

      System.err.println("Unable to generate Makefile.");
      System.err.println("The environment variable TRAMPOLINEPATH is not defined.");
      System.err.println("To fix this probleme you can : ");
      System.err.println("\t 1) add this variable in your bashrc");
      System.err.println("\t 2) - execute 'source env' on lejos directory");
      System.err.println("\t    - run eclipse on the same shell");
      System.err.println("You can also generate manually the Makefile :");
      System.err.println("\t 1) - execute source env on lejos directory");
      System.err.println("\t 2) - execute ./refine_oil.sh " + process.getName() + "_specification.oil");
      System.err.println("\t 3) - execute ./preparemake.sh " + process.getName() + "_specification.oil");

      return;
    }
    // Generate Makefile
    else {
      try {

        File oilTrashFile = new File(generatedFilePath, process.getName());

        Process makeProcess = runtime.exec(new String[] { preparemake.getCanonicalPath(),
            oilTrashFile.getCanonicalPath() });

        makeProcess.waitFor();

        if (makeProcess.exitValue() != 0) {
          System.err.println("Error on goil generation: ");

          InputStream is = makeProcess.getErrorStream();
          BufferedReader in = new BufferedReader(new InputStreamReader(is));
          String line = null;
          while ((line = in.readLine()) != null) {
            System.err.println(line);
          }
        }
      } catch (IOException e) {
        e.printStackTrace();
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
	
	
	// XXX: Not implemented, just used for conformance with the interface
	// definition

	@Override
	public void process(SystemImplementation system, File generatedFilePath) throws GenerationException {
		// TODO Do NOT use
	}

	@Override
	public void process(ProcessorSubcomponent processor, File generatedFilePath) throws GenerationException {
		// TODO Do NOT use
	}

	@Override
	public void setParameters(Map<Enum<?>, Object> parameters) {
		// TODO Do NOT use
	}
}
