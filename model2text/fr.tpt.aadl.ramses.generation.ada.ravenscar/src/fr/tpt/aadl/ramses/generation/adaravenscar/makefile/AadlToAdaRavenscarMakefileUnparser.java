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


package fr.tpt.aadl.ramses.generation.adaravenscar.makefile ;


import java.io.File ;
import java.util.Map ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.modelsupport.UnparseText ;
import org.osate.aadl2.util.Aadl2Switch ;

import fr.tpt.aadl.ramses.control.support.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.util.generation.AbstractMakefileUnparser ;

public class AadlToAdaRavenscarMakefileUnparser extends AbstractMakefileUnparser
{

  private final static String _ADA_SUB_PATH = "/Ada_runtime/PeriodicDelayed_runtime/" ;
  private final static String RUNTIME_INCL_DIR = "/libpok/ada" ;
	private UnparseText unparserContent ;
	
	/*
	private UnparseText kernelMakefileContent ;
	private List<ProcessSubcomponent> bindedProcess ;
  */
	
	@Override
	protected void setupCommonDirs()
	{
	  // Add Dir of Ada PeriodicDelayed runtime
    File adaPeriodicDelayedRuntimeDir;
    adaPeriodicDelayedRuntimeDir = new File(RamsesConfiguration.getPredefinedResourceDir()
                                            .getAbsolutePath() + _ADA_SUB_PATH);
    _includeDirManager.addCommonDependency(adaPeriodicDelayedRuntimeDir);
	}
	
	@Override
	protected void handleDirs(File runtimePath, File[] includeDirs) throws GenerationException
	{
    File pokAdaFile = new File(runtimePath + RUNTIME_INCL_DIR);
    _includeDirManager.addCommonDependency(pokAdaFile) ;
    super.handleDirs(runtimePath, includeDirs);
	}
	
	@Override
	protected void initSwitches()
	{
		aadl2Switch = new Aadl2Switch<String>()
				{

			@Override
			public String caseProcessSubcomponent(ProcessSubcomponent object)
			{
				unparserContent.addOutputNewline("###############################################################");
				unparserContent.addOutputNewline("#	This Makefile has been generated automatically #");
				unparserContent.addOutputNewline("#	by RAMSES toolsuite. #");
				unparserContent.addOutputNewline("###############################################################");

				unparserContent.addOutputNewline("C_Objects =") ;
				unparserContent.addOutputNewline("GNATMAKE = gnatmake") ;
				unparserContent.addOutputNewline("GNAT = gnat") ;
				unparserContent.addOutputNewline("GCC = gcc") ;
				unparserContent.addOutputNewline("TARGET = NATIVE") ;
				unparserContent.addOutputNewline("BUILD = Debug") ;
				unparserContent.addOutputNewline("CGCTRL = No") ;
				
				unparserContent.addOutputNewline("PROJECT_FILE = main.gpr") ;

//				unparserContent.addOutputNewline("PROJECT_FILE = " + object.getName() +
//						".gpr") ;
				unparserContent.addOutputNewline("all:") ;
				
				unparserContent
				.addOutputNewline("\tADA_PROJECT_PATH=\"/usr/local/include/ocarina/runtime/polyorb-hi-ada:$$ADA_PROJECT_PATH\" \\");

				unparserContent.addOutputNewline("\t$(GNATMAKE) -x -P$(PROJECT_FILE) -XTARGET=$(TARGET) -XBUILD=$(BUILD) -XCGCTRL=$(CGCTRL) -largs ${C_OBJECTS}") ;

				unparserContent.addOutputNewline("clean:") ;
				unparserContent.addOutputNewline("\trm *.o *.ali main *~*") ;

				
				
				process(object.getComponentImplementation()) ;
				return DONE ;
			}

				} ;
	}

	private void generateMakefile(NamedElement ne,
			File makeFile)
	{
		unparserContent = new UnparseText() ;
		process(ne) ;
		saveMakefile(unparserContent, makeFile) ;
	}

	@Override
	public void process(SystemImplementation system,
	                    File runtimePath,
	                    File outputDir,
	                    File[] includeDirs,
	                    IProgressMonitor monitor)
					              throws GenerationException
					{
	  super.process(system, runtimePath, outputDir, includeDirs, monitor) ;
	  //generateMakefile((NamedElement) system, generatedFilePath) ;
		executeMake(outputDir, runtimePath);
					}

	@Override
	public void process(ProcessorSubcomponent processor,
	                    File runtimePath,
                      File outputDir,
                      File[] includeDirs,
                      IProgressMonitor monitor)
					throws GenerationException
					{
	            throw new UnsupportedOperationException() ;
					}

	@Override
	public void process(ProcessSubcomponent process,
	                    File runtimePath,
                      File outputDir,
                      File[] includeDirs,
                      IProgressMonitor monitor)
					throws GenerationException
					{
	  super.process(process, runtimePath, outputDir, includeDirs, monitor) ;
	  unparserContent = new UnparseText() ;
		generateMakefile((NamedElement) process, outputDir) ;
					}

	@Override
	public void setParameters(Map<Enum<?>, Object> parameters)
	{
		throw new UnsupportedOperationException() ;
	}
	
	@Override
  public boolean runtimePathChecker(File runtimePath)
  {
    // TODO: to be implemented.
	  
	  return true ;
  }
}