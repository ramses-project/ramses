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


import java.io.BufferedReader ;
import java.io.BufferedWriter ;
import java.io.File ;
import java.io.FileWriter ;
import java.io.IOException ;
import java.io.InputStream ;
import java.io.InputStreamReader ;
import java.util.List;
import java.util.Map ;
import java.util.Set;

import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.TargetBuilderGenerator ;
import fr.tpt.aadl.ramses.generation.ada.AadlToADAUnparser;
import fr.tpt.aadl.ramses.util.generation.FileUtils;
import fr.tpt.aadl.ramses.util.generation.GeneratorUtils;
import fr.tpt.aadl.utils.PropertyUtils ;

import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorImplementation ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.modelsupport.UnparseText ;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch ;
import org.osate.aadl2.util.Aadl2Switch ;

public class AadlToAdaRavenscarMakefileUnparser extends AadlProcessingSwitch
implements TargetBuilderGenerator
{

	private UnparseText unparserContent ;
	private UnparseText kernelMakefileContent ;
	private List<ProcessSubcomponent> bindedProcess ;

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

				process(object.getComponentImplementation()) ;
				return DONE ;
			}

				} ;
	}

	private void saveMakefile(UnparseText text,
			File makeFileDir)
	{
	    try
	    {
	      File makeFile = new File(makeFileDir.getAbsolutePath() + "/Makefile") ;
	      FileWriter fileW = new FileWriter(makeFile) ;
	      BufferedWriter output ;

	      try
	      {
	        output = new BufferedWriter(fileW) ;
	        output.write(text.getParseOutput()) ;
	        output.close() ;
	      }
	      catch(IOException e)
	      {
	        // TODO Auto-generated catch block
	        e.printStackTrace() ;
	      }
	    }
	    catch(IOException e)
	    {
	      // TODO Auto-generated catch block
	      e.printStackTrace() ;
	    }

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
			File generatedFilePath)
					throws GenerationException
					{
		//generateMakefile((NamedElement) system, generatedFilePath) ;
		executeMake(generatedFilePath);
					}


	public void executeMake(File generatedFilePath)
	{
	}

	@Override
	public void process(ProcessorSubcomponent processor,
			File generatedFilePath)
					throws GenerationException
					{
					}

	@Override
	public void process(ProcessSubcomponent process,
			File generatedFilePath)
					throws GenerationException
					{
		unparserContent = new UnparseText() ;
		generateMakefile((NamedElement) process, generatedFilePath) ;
					}

	@Override
	public void setParameters(Map<Enum<?>, Object> parameters)
	{
		throw new UnsupportedOperationException() ;
	}
}
