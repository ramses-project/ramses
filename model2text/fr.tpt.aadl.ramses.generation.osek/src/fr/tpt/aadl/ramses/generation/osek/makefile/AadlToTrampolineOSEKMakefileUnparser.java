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

import java.io.File; 
import java.io.IOException;
import java.util.Map;

import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.SystemImplementation;

import fr.tpt.aadl.ramses.control.support.FileUtils;
import fr.tpt.aadl.ramses.control.support.ProcessMessageDisplay;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.generator.TargetBuilderGenerator;
import fr.tpt.aadl.ramses.generation.osek.ast.OIL;

public class AadlToTrampolineOSEKMakefileUnparser implements TargetBuilderGenerator {

	private OIL oil;

	public AadlToTrampolineOSEKMakefileUnparser(OIL oil) {
		this.oil = oil;
	}

	
	@Override
  public void process(ProcessSubcomponent process, File generatedFilePath) throws GenerationException {
    
	String OS = (String) System.getProperties().get("os.name");	
	if(OS.toLowerCase().contains("windows"))
	{
	  System.out.println("Deployment to osek supported from UNIX systems only");
	  return;
	}
    Runtime runtime = Runtime.getRuntime();
    
    System.out.println("* Prepare Make ...");

    
    File preparemake = new File(RamsesConfiguration.getInputDirectory(), "/preparemake.sh");
    
    FileUtils.copyFile(preparemake, generatedFilePath);
    preparemake.setExecutable(true);

    File refineOil = new File(RamsesConfiguration.getInputDirectory(), "/refine_oil.sh");
    FileUtils.copyFile(refineOil, generatedFilePath);
    refineOil.setExecutable(true);
    
    File oilTrashFile = new File(generatedFilePath, process.getName());
    try {

      // TrampolineBasePath NOT found
      if (oil.getCpu().getOs().getTrampolineBasePath() == null) {

        Process makeProcess = runtime.exec(new String[] { refineOil.getCanonicalPath(), oilTrashFile.getCanonicalPath() + ".oil"});
        makeProcess.waitFor();
        if (makeProcess.exitValue() != 0) {
          System.err.println("Error on goil generation: refine_oil;");
          ProcessMessageDisplay.displayErrorMessage(makeProcess);
        }
        
        System.err.println("Unable to generate Makefile.");
        System.err.println("The environment variable TRAMPOLINEPATH is not defined.");
        System.err.println("To fix this probleme you can : ");
        System.err.println("\t 1) add this variable in your bashrc");
        System.err.println("\t 2) - execute 'source env' on lejos directory");
        System.err.println("\t    - run eclipse on the same shell");
        System.err.println("You can also generate manually the Makefile :");
        System.err.println("\t 1) - execute source env on lejos directory");
        System.err.println("\t 2) - execute ./refine_oil.sh " + oilTrashFile.getCanonicalPath() + ".oil");
        System.err.println("\t 3) - execute ./preparemake.sh " + oilTrashFile.getCanonicalPath() + ".oil");

        return;
      }
      // Generate Makefile
      else {
        System.out.println("Premaring Make");
        Process makeProcess = runtime.exec(new String[] { preparemake.getCanonicalPath(), oilTrashFile.getCanonicalPath() + ".oil"});
        makeProcess.waitFor();

        if (makeProcess.exitValue() != 0) {
          System.err.println("Error on goil generation: PrepareMake");
          ProcessMessageDisplay.displayErrorMessage(makeProcess);
        }
        else
        {
          System.out.println("Compiling Code");
          makeProcess = runtime.exec("make -o Makefile", null, generatedFilePath);
          ProcessMessageDisplay.displayOutputMessage(makeProcess);
          makeProcess.waitFor();
          if (makeProcess.exitValue() != 0) {
            ProcessMessageDisplay.displayErrorMessage(makeProcess);
          }
        }

      }
    } catch (IOException e) {
      e.printStackTrace();
    } catch (InterruptedException e) {
      e.printStackTrace();
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
