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

import java.io.BufferedWriter;
import java.io.File; 
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.osate.aadl2.NamedElement;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorImplementation;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.modelsupport.UnparseText;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch;
import org.osate.aadl2.util.Aadl2Switch;

import fr.tpt.aadl.ramses.control.support.ProcessMessageDisplay;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.generator.TargetBuilderGenerator;
import fr.tpt.aadl.ramses.generation.osek.ast.OIL;
import fr.tpt.aadl.ramses.util.generation.FileUtils;
import fr.tpt.aadl.ramses.util.generation.GeneratorUtils;
import fr.tpt.aadl.utils.PropertyUtils;

public class AadlToOSEKnxtMakefileUnparser  extends AadlProcessingSwitch
												implements TargetBuilderGenerator {

  UnparseText unparserContent;
  private List<ProcessSubcomponent> bindedProcess ;
  private static final String OSEXNXT_ENVIRVARID = "NXTOSEK_PATH";
  private static final String runtimePath = GeneratorUtils.getRuntimePath(OSEXNXT_ENVIRVARID);

  private File processGeneratedFilePath = null;
  
  @Override
  public void process(ProcessSubcomponent process, File generatedFilePath) throws GenerationException
  {
      unparserContent = new UnparseText() ;
      processGeneratedFilePath = generatedFilePath;
	  generateMakefile((NamedElement) process, generatedFilePath) ;
  }

  private void generateMakefile(NamedElement ne,
          File makeFile)
  {
	  unparserContent = new UnparseText() ;
	  process(ne) ;
	  GeneratorUtils.saveMakefile(unparserContent, makeFile) ;
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
    	if(runtimePath!=null && runtimePath!="")
        unparserContent.addOutputNewline("include "+runtimePath+"/ecrobot/ecrobot.mak");
        return DONE ;
      }

      @Override
      public String caseProcessImplementation(ProcessImplementation object)
      {
        unparserContent
              .addOutput("TARGET_SOURCES = main.c activity.c subprograms.c gtypes.c deployment.c ") ;
        
        Set<File> includeDirList = FileUtils.getIncludeDir(object);
        Set<File> sourceFileList;
		try {
		  sourceFileList = GeneratorUtils.getListOfReferencedObjects(object);
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
          
		}catch (Exception e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		}
		unparserContent.addOutput("\n") ;
		if(false==includeDirList.isEmpty())
          unparserContent.addOutput("export USER_INCLUDES=");
        for (File include: includeDirList)
        {
          unparserContent.addOutput(include.getAbsolutePath()+" ");
        }
        unparserContent.addOutput("\n") ;
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
	public void process(SystemImplementation system, File generatedFilePath) throws GenerationException {
		generateMakefile((NamedElement) system, generatedFilePath) ;
		GeneratorUtils.executeMake(generatedFilePath, "OSEKNXT_PATH");
	}

	@Override
	public void process(ProcessorSubcomponent processor, File generatedFilePath) throws GenerationException {
		unparserContent = new UnparseText() ;
	    generateMakefile((NamedElement) processor, generatedFilePath) ;
	}

	@Override
	public void setParameters(Map<Enum<?>, Object> parameters) {
		// TODO Do NOT use
	}
}
