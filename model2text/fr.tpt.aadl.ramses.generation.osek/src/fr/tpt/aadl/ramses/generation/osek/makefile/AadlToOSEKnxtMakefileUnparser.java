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

import java.io.File ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorImplementation ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.modelsupport.UnparseText ;
import org.osate.aadl2.util.Aadl2Switch ;

import fr.tpt.aadl.ramses.control.support.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.generation.osek.OSEKGeneratorFactory ;
import fr.tpt.aadl.ramses.generation.utils.AbstractAadlToCMakefileUnparser ;
import fr.tpt.aadl.ramses.generation.utils.GeneratorUtils ;

public class AadlToOSEKnxtMakefileUnparser  extends AbstractAadlToCMakefileUnparser 
{

  private UnparseText unparserContent;
  
  private List<ProcessSubcomponent> bindedProcess ;

  private static final String _C_OSEK_SUB_PATH = "/C_runtime/OSEK/" ;
  
  // TODO set up ! 
  public static final String OSEK_NXT_ENV_VAR_NAME = "" ;
  
  public AadlToOSEKnxtMakefileUnparser()
  {
    _ENV_VAR_NAME = OSEK_NXT_ENV_VAR_NAME ;
  }
  
  @Override
  public void setupCommonDirs()
  {
    super.setupCommonDirs() ;
    
    // Add Dir of C OSEK runtime
    File OSEKRuntimeDir = new File(RamsesConfiguration.getPredefinedResourceDir().getAbsolutePath() +
                                   _C_OSEK_SUB_PATH);
    _includeDirManager.addCommonDependency(OSEKRuntimeDir);
  }

  @Override
  public void process(ProcessSubcomponent process,
                      File runtimeDir,
                      File outputDir,
                      File[] includeDirs,
                      IProgressMonitor monitor) throws GenerationException
  {
    super.process(process, runtimeDir, outputDir, includeDirs, monitor);
   	generateMakefile((NamedElement) process, outputDir) ;
  }

  private void generateMakefile(NamedElement ne,
                                File makeFile)
  {
	  unparserContent = new UnparseText() ;
	  process(ne) ;
	  super.saveMakefile(unparserContent, makeFile) ;
  }
  @Override
  protected void initSwitches()
  {
    aadl2Switch = new Aadl2Switch<String>()
    {
      @Override
      public String caseSystemImplementation(SystemImplementation object)
      {
        unparserContent.addOutputNewline("all:") ;

        for(ProcessorSubcomponent aProcessorSubcomponent : object
              .getOwnedProcessorSubcomponents())
        {
          unparserContent.addOutputNewline("\t$(MAKE) -C " +
                aProcessorSubcomponent.getName() + " all\n") ;
        }

        unparserContent.addOutputNewline("clean:") ;

        for(ProcessorSubcomponent aProcessorSubcomponent : object
              .getOwnedProcessorSubcomponents())
        {
          unparserContent.addOutputNewline("\t$(MAKE) -C " +
                aProcessorSubcomponent.getName() + " clean\n") ;
        }

        return DONE ;
      }

      @Override
      public String caseProcessSubcomponent(ProcessSubcomponent object)
      {
        unparserContent.addOutputNewline("TARGET = " + object.getName() +
              "_OSEK") ;

		    unparserContent.addOutputNewline("TOPPERS_OSEK_OIL_SOURCE = ./"+object.getName()+".oil");

        process(object.getComponentImplementation()) ;
        unparserContent.addOutputNewline("O_PATH ?= build");
    		unparserContent.addOutputNewline("include "+_runtimePath+"/ecrobot/ecrobot.mak");
        return DONE ;
      }

      @Override
      public String caseProcessImplementation(ProcessImplementation object)
      {
        unparserContent
              .addOutput("TARGET_SOURCES = main.c activity.c subprograms.c gtypes.c deployment.c ") ;
        
        Set<File> sourceFileList;
        
        sourceFileList = getListOfReferencedObjects(object);
        for(File sourceFile : sourceFileList)
        {
          String value = sourceFile.getAbsolutePath();
          if(value.endsWith(".c") || value.endsWith(".o"))
          {
          value = value.substring(0,value.length()-2);  
          value = value.concat(".c");
          }
          else
          continue;
          unparserContent.addOutput( value + " ") ;
        }
        
		unparserContent.addOutput("\n") ;
		
		Iterator<File> it = new IncludeDirIterator() ;
		File include ;
		
		if(it.hasNext())
		{
		  unparserContent.addOutput("export USER_INCLUDES=");
		  while(it.hasNext())
	    {
		    include = it.next() ;
		    unparserContent.addOutput(include.getAbsolutePath()+" ");
		  }
		  unparserContent.addOutput("\n") ;
    }
		return DONE ;
      }

      @Override
      public String caseProcessorSubcomponent(ProcessorSubcomponent object)
      {

        bindedProcess =
                GeneratorUtils.getBindedProcesses(object) ;
        
        process(object.getComponentImplementation()) ;
        return DONE ;
      }

      @Override
      public String caseProcessorImplementation(ProcessorImplementation object)
      {

        unparserContent.addOutput("\n") ;
        unparserContent
              .addOutputNewline("all: partitions") ;
        unparserContent.addOutputNewline("partitions:") ;

        for(ProcessSubcomponent part:bindedProcess)
        {
          unparserContent.addOutputNewline("\t$(MAKE) -C " + part.getName() +
                " all") ;
        }

        unparserContent.addOutputNewline("clean:") ;

        for(ProcessSubcomponent part:bindedProcess)
        {
          unparserContent.addOutputNewline("\t$(MAKE) -C " + part.getName() +
                " clean") ;
        }

        return DONE ;
      }
    } ;
  }
	// XXX: Not implemented, just used for conformance with the interface
	// definition

	@Override
	public void process(SystemImplementation system,
	                    File runtimeDir,
	                    File outputDir,
	                    File[] includeDirs,
	                    IProgressMonitor monitor)
	                                                    throws GenerationException
  {
	  super.process(system, runtimeDir, outputDir, includeDirs, monitor);
	  generateMakefile((NamedElement) system, outputDir) ;
		super.executeMake(outputDir, runtimeDir);
	}

	@Override
	public void process(ProcessorSubcomponent processor,
	                    File runtimeDir,
                      File outputDir,
                      File[] includeDirs,
                      IProgressMonitor monitor) throws GenerationException {
	  super.process(processor, runtimeDir, outputDir, includeDirs, monitor);
	  generateMakefile((NamedElement) processor, outputDir) ;
	}

	@Override
	public void setParameters(Map<Enum<?>, Object> parameters) {
		// TODO Do NOT use
	}

  @Override
  public boolean runtimePathChecker(File runtimePath)
  {
    return OSEKGeneratorFactory.runtimePathChecker(runtimePath) ;
  }
}