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

package fr.tpt.aadl.ramses.generation.target.specific;

import java.io.File ;
import java.util.ArrayList ;
import java.util.List ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.AadlPackage ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.PublicPackageSection ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.SystemSubcomponent ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.SystemInstance ;

import fr.tpt.aadl.ramses.control.support.generator.AadlGenericUnparser ;
import fr.tpt.aadl.ramses.control.support.generator.AadlTargetUnparser ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.TargetBuilderGenerator ;
import fr.tpt.aadl.ramses.control.support.generator.TargetProperties ;
import fr.tpt.aadl.ramses.generation.utils.GeneratorUtils ;


public class AadlTargetSpecificCodeGenerator
{
  public static final String GENERATED_DIR_NAME = "/generated-code/" ; 
  public static final String KERNEL_DIR_NAME = "/kernel/" ;
  
  protected AadlGenericUnparser _genericUnparser ;
  protected AadlTargetUnparser _targetUnparser ;
  protected TargetBuilderGenerator _targetBuilderGen ;
  
  private static Logger _LOGGER = Logger.getLogger(AadlTargetSpecificCodeGenerator.class) ;
  
  public AadlTargetSpecificCodeGenerator(AadlGenericUnparser genericUnparser,
                                         AadlTargetUnparser targetUnparser,
                                        TargetBuilderGenerator targetBuilderGen)
  {
    _genericUnparser = genericUnparser ;
    _targetUnparser = targetUnparser ;
    _targetBuilderGen = targetBuilderGen ;
  }
  
  public boolean runtimePathChecker(File runtimePath)
  {
    return _targetBuilderGen.runtimePathChecker(runtimePath) ;
  }
  
  public String getRuntimePathEnvVar()
  {
    return _targetBuilderGen.getRuntimePathEnvVar() ;
  }
  
  public void generate(Resource inputResource,
                       File runtimePath,
                       File outputDir,
                       File[] includeDirs, 
                       IProgressMonitor monitor) throws GenerationException
  {
    List<SystemImplementation> systemImplementationList=new ArrayList<SystemImplementation>();

    if ((inputResource == null ) || (inputResource.getContents() == null) || (inputResource.getContents().size() <= 0))
    {
      String errMsg = "Cannot find AADL model sources" ;
      _LOGGER.fatal(errMsg) ;
      throw new GenerationException(errMsg);
    }

    EObject root = inputResource.getContents().get(0);
    if(root instanceof SystemInstance)
    {
      SystemInstance systemInstance = (SystemInstance) root;
      if(systemInstance.eContainer()==null)
        systemImplementationList.addAll(this.getListOfSystemImplementation(systemInstance));	    
    }
    else if(root instanceof AadlPackage)
    {
      AadlPackage aadlPackage = (AadlPackage) root;
      PublicPackageSection pps = aadlPackage.getOwnedPublicSection();
      for(Classifier c : pps.getOwnedClassifiers() )
        if(c instanceof SystemImplementation && isRootSystemImplementation((SystemImplementation)c, pps))
          systemImplementationList.add((SystemImplementation)c);
    }
    else
    {
      String errMsg = "Try to generate from a resources that is into an AADL model" ;
      _LOGGER.fatal(errMsg) ;
      throw new GenerationException(errMsg);
    }
    File generatedCodeDirectory =
        new File(outputDir + GENERATED_DIR_NAME) ;
    generatedCodeDirectory.mkdir() ;

    monitor.subTask("Code generation ..."); 

    if(systemImplementationList.isEmpty())
    {
      String errMsg = "No root system in output model used for code generation" ;
      _LOGGER.fatal(errMsg) ;
      throw new GenerationException(errMsg);
    }
    
    for(SystemImplementation sys: systemImplementationList)
    {
      SystemImplementation si = (SystemImplementation) sys ;
      File generatedFileDir = new File(outputDir + GENERATED_DIR_NAME);

      // XXX Have AadlGenericUnparser to unparse the SystemImplementation
      // object ?
      TargetProperties tarProp=null;
      if(_targetUnparser != null)
        tarProp = _targetUnparser.process(si, runtimePath,
                                          outputDir, monitor);
      
      List<ProcessorSubcomponent> psList = new ArrayList<ProcessorSubcomponent>();
      psList.addAll(si.getOwnedProcessorSubcomponents());
      
      for(SystemSubcomponent ss: si.getOwnedSystemSubcomponents())
      {
        if(ss.getSystemSubcomponentType() instanceof SystemImplementation)
        {
          SystemImplementation subSi = (SystemImplementation)  ss.getSystemSubcomponentType();
          psList.addAll(subSi.getOwnedProcessorSubcomponents());
        }
      }
      
      for(ProcessorSubcomponent ps : psList)
      {
        // create directory with the processor subcomponent name
        File processorFileDir =
            new File(generatedFileDir + File.separator + ps.getName()) ;
        processorFileDir.mkdir() ;

        File kernelFileDir = new File(processorFileDir + KERNEL_DIR_NAME) ;
        kernelFileDir.mkdir();
        if(_targetUnparser != null)
          _targetUnparser.process(ps, tarProp, runtimePath,
                                  kernelFileDir, monitor);
        List<ProcessSubcomponent> ownedProcess = 
            GeneratorUtils.getBindedProcesses(ps) ;

        for(ProcessSubcomponent process : ownedProcess)
        {
          String generationTargetDirectory = processorFileDir +
              File.separator + process.getName() ;
          File processDirectory = new File(generationTargetDirectory) ;
          processDirectory.mkdir() ;

          _genericUnparser.process(process, processDirectory) ;
          if(_targetUnparser!=null)
            _targetUnparser.process(process, tarProp, runtimePath,
                                    processDirectory, monitor);
          if(_targetBuilderGen!= null)
            _targetBuilderGen.process(process, runtimePath,
                                      processDirectory, includeDirs, monitor) ;
        }

        if(_targetBuilderGen != null)
          _targetBuilderGen.process(ps, runtimePath,
                                    processorFileDir, includeDirs, monitor);

      }
      // This line is at the end because it will launch the build of the generated code;
      // Thus it is better is the code has been generated...
      if(_targetBuilderGen!= null)
        _targetBuilderGen.process(si, runtimePath,
                                  generatedFileDir, includeDirs, monitor) ;

    }
  }

  private boolean isRootSystemImplementation(SystemImplementation c,
                                             PublicPackageSection pps)
  {
    for(Classifier c2 : pps.getOwnedClassifiers() )
    {
      if(c2 instanceof SystemImplementation)
      {
        SystemImplementation si = (SystemImplementation) c2;
        for(SystemSubcomponent s: si.getOwnedSystemSubcomponents())
          if(s.getSubcomponentType().equals(c))
          return false;
      }
    }
    return true ;
  }

  private List<SystemImplementation> getListOfSystemImplementation(SystemInstance systemInstance)
  {

    List<SystemImplementation> systemInstanceList =
          new ArrayList<SystemImplementation>() ;
    if(systemInstance.getComponentImplementation() != null)
      systemInstanceList.add((SystemImplementation) systemInstance.
                                                 getComponentImplementation()) ;
    for(ComponentInstance ci : systemInstance.getComponentInstances())
    {
      if(ci instanceof SystemInstance)
      {
        systemInstanceList
              .addAll(getListOfSystemImplementation((SystemInstance) ci)) ;
      }
    }
    return systemInstanceList ;
  }
}