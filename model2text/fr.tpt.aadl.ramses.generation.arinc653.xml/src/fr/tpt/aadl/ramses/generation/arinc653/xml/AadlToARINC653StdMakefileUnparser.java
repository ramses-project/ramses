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

package fr.tpt.aadl.ramses.generation.arinc653.xml ;

import java.io.File ;
import java.util.Map ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.SystemImplementation ;

import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.generation.utils.AbstractAadlToCMakefileUnparser ;

public class AadlToARINC653StdMakefileUnparser extends AbstractAadlToCMakefileUnparser
{

  
  private static Logger _LOGGER = Logger.getLogger(AadlToARINC653StdMakefileUnparser.class) ;


  @Override
  public void process(SystemImplementation system,
                      File runtimeDir,
                      File outputDir,
                      File[] includeDirs,
                      IProgressMonitor monitor
                      )
                        throws GenerationException
  {
    
  }

  @Override
  public void process(ProcessorSubcomponent processor,
                      File runtimeDir,
                      File outputDir,
                      File[] includeDirs,
                      IProgressMonitor monitor)
        throws GenerationException
  {
    
  }

  @Override
  public void process(ProcessSubcomponent process,
                      File runtimeDir,
                      File outputDir,
                      File[] includeDirs,
                      IProgressMonitor monitor)
        throws GenerationException
  {
    
  }

  @Override
  public void setParameters(Map<Enum<?>, Object> parameters)
  {
    String msg = "setParameters not supported" ;
    _LOGGER.fatal(msg);
    throw new UnsupportedOperationException(msg) ;
  }
  
  @Override
  public boolean runtimePathChecker(File runtimePath)
  {
    return true;
  }

  @Override
  protected void initSwitches()
  {
    // TODO Auto-generated method stub

  }
}