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
import java.io.IOException ;
import java.util.Map ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.SystemImplementation ;

import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.reporters.LogProcessTraceDisplay ;
import fr.tpt.aadl.ramses.control.support.utils.FileUtils ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;
import fr.tpt.aadl.ramses.generation.osek.ast.OIL ;
import fr.tpt.aadl.ramses.generation.utils.AbstractAadlToCMakefileUnparser ;

public class AadlToTrampolineOSEKMakefileUnparser extends AbstractAadlToCMakefileUnparser
{
	private OIL oil;
	
	public final static String TRAMPOLINE_ENV_VAR_NAME = "TRAMPOLINEPATH" ;
	
	private static Logger _LOGGER = Logger.getLogger(AadlToTrampolineOSEKMakefileUnparser.class) ;

	public AadlToTrampolineOSEKMakefileUnparser(OIL oil) 
	{
		this.oil = oil;
		_ENV_VAR_NAME = TRAMPOLINE_ENV_VAR_NAME ;
	}

	@Override
  public void process(ProcessSubcomponent process,
                      File runtimeDir,
                      File outputDir,
                      File[] includeDirs,
                      IProgressMonitor monitor) throws GenerationException
  {

    super.process(process, runtimeDir, outputDir, includeDirs, monitor) ;
    String OS = (String) System.getProperties().get("os.name") ;
    if(OS.toLowerCase().contains("windows"))
    {
      String errMsg = "Deployment to osek supported from UNIX systems only" ;
      _LOGGER.fatal(errMsg) ;
      throw new GenerationException(errMsg) ;
    }
    Runtime runtime = Runtime.getRuntime() ;

    monitor.subTask("Generating the Trampoline make files") ;

    // XXX Kept in case of refactoring.
    File inputDir = null ;
    try
    {
      inputDir = File.createTempFile("trampoline", "compilation.properties") ;
    }
    catch(IOException e1)
    {
      String errMsg = "cannot create temporary files" ;
      _LOGGER.fatal(errMsg, e1) ;
      throw new RuntimeException(errMsg, e1) ;
    }

    File preparemake = new File(inputDir, "/preparemake.sh") ;
    
    File refineOil = null ;
    
    try
    {
      FileUtils.copyFile(preparemake, outputDir) ;
      preparemake.setExecutable(true) ;

      refineOil = new File(inputDir, "/refine_oil.sh") ;
      FileUtils.copyFile(refineOil, outputDir) ;
      refineOil.setExecutable(true) ;
    }
    catch(IOException ex)
    {
      String errMsg = "cannot copy files" ;
      _LOGGER.fatal(errMsg, ex) ;
      throw new RuntimeException(errMsg, ex) ;
    }

    File oilTrashFile = new File(outputDir, process.getName()) ;
    try
    {
      // TrampolineBasePath NOT found
      if(oil.getCpu().getOs().getTrampolineBasePath() == null)
      {
        Process makeProcess =
              runtime.exec(new String[]
              {refineOil.getCanonicalPath(),
               oilTrashFile.getCanonicalPath() + ".oil"}) ;
        makeProcess.waitFor() ;
        LogProcessTraceDisplay.INSTANCE.displayOutputMessage(makeProcess);
        if(makeProcess.exitValue() != 0)
        {
          String errMsg = "while goil generation: refine_oil" ;
          _LOGGER.fatal(errMsg) ;
          
          LogProcessTraceDisplay.INSTANCE.displayErrorMessage(makeProcess);
        }

        StringBuilder sb = new StringBuilder() ;

        sb.append("Unable to generate Makefile.") ;
        sb.append(Names.NEW_LINE) ;

        sb.append("The environment variable TRAMPOLINEPATH is not defined.") ;
        sb.append(Names.NEW_LINE) ;

        sb.append("To fix this probleme you can : ") ;
        sb.append(Names.NEW_LINE) ;

        sb.append("\t 1) add this variable in your bashrc") ;
        sb.append(Names.NEW_LINE) ;

        sb.append("\t 2) - execute 'source env' on lejos directory") ;
        sb.append(Names.NEW_LINE) ;

        sb.append("\t    - run eclipse on the same shell") ;
        sb.append(Names.NEW_LINE) ;

        sb.append("You can also generate manually the Makefile :") ;
        sb.append(Names.NEW_LINE) ;

        sb.append("\t 1) - execute source env on lejos directory") ;
        sb.append(Names.NEW_LINE) ;

        sb.append("\t 2) - execute ./refine_oil.sh ") ;
        sb.append(oilTrashFile.getCanonicalPath()) ;
        sb.append(".oil") ;
        sb.append(Names.NEW_LINE) ;

        sb.append("\t 3) - execute ./preparemake.sh ") ;
        sb.append(oilTrashFile.getCanonicalPath()) ;
        sb.append(".oil") ;
        sb.append(Names.NEW_LINE) ;

        String errMsg = sb.toString() ;
        _LOGGER.fatal(errMsg) ;
        throw new GenerationException(errMsg) ;
      }
      else
      // Generate Makefile
      {
        _LOGGER.trace("Preparing Trampoline Make") ;
        Process makeProcess =
              runtime.exec(new String[]
              {preparemake.getCanonicalPath(),
               oilTrashFile.getCanonicalPath() + ".oil"}) ;
        makeProcess.waitFor() ;
        LogProcessTraceDisplay.INSTANCE.displayOutputMessage(makeProcess);
        if(makeProcess.exitValue() != 0)
        {
          String errMsg = "while goil generation: PrepareMake" ;
          _LOGGER.fatal(errMsg) ;
          LogProcessTraceDisplay.INSTANCE.displayErrorMessage(makeProcess);
        }
        else
        {
          monitor.subTask("Compiling Trampoline Code") ;
          makeProcess = runtime.exec("make -o Makefile", null, outputDir) ;
          makeProcess.waitFor() ;
          LogProcessTraceDisplay.INSTANCE.displayOutputMessage(makeProcess);
          if(makeProcess.exitValue() != 0)
          {
            LogProcessTraceDisplay.INSTANCE.displayErrorMessage(makeProcess);
          }
        }

      }
    }
    catch(Exception e)
    {
      String errMsg = "while generating Trampoline make file or compiling code" ;
      throw new GenerationException(errMsg, e) ;
    }
  }
	
	// XXX: Not implemented, just used to be compliant with the interface
	// definition

	@Override
	public void process(SystemImplementation system,
	                    File runtimePath,
	                    File outputDir,
	                    File[] includeDirs,
	                    IProgressMonitor monitor)
	                          throws GenerationException {
		throw new UnsupportedOperationException () ;
	}

	@Override
	public void process(ProcessorSubcomponent processor,
	                    File runtimePath,
                      File outputDir,
                      File[] includeDirs,
                      IProgressMonitor monitor) throws GenerationException {
	  throw new UnsupportedOperationException () ;
	}

	@Override
	public void setParameters(Map<Enum<?>, Object> parameters)
	{
	  throw new UnsupportedOperationException () ;
	}

  @Override
  public boolean runtimePathChecker(File runtimePath)
  {
    // TODO: to be implemented
    return true ;
  }

  @Override
  protected void initSwitches()
  {
    // TODO Auto-generated method stub
  }
}