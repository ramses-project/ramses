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

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.Classifier;
import org.osate.aadl2.Element;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.PublicPackageSection;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;

import fr.tpt.aadl.ramses.control.support.generator.AadlGenericUnparser;
import fr.tpt.aadl.ramses.control.support.generator.AadlTargetUnparser;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.generator.TargetBuilderGenerator;
import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.util.generation.GeneratorUtils;


public class AadlTargetSpecificCodeGenerator
{
  public static final String GENERATED_DIR_NAME = "/generated-code/" ; 
  public static final String KERNEL_DIR_NAME = "/kernel/" ;
  
  protected AadlGenericUnparser _genericUnparser ;
  protected AadlTargetUnparser _targetUnparser ;
  protected TargetBuilderGenerator _targetBuilderGen ;
  
  public AadlTargetSpecificCodeGenerator(AadlGenericUnparser genericUnparser,
                                         AadlTargetUnparser targetUnparser,
                                        TargetBuilderGenerator targetBuilderGen)
  {
    _genericUnparser = genericUnparser ;
    _targetUnparser = targetUnparser ;
    _targetBuilderGen = targetBuilderGen ;
  }
  
  public void setParameters(Map<Enum<?>, Object> parameters)
  {
    throw new UnsupportedOperationException() ;
  }
  
  //  @Override
  public void generate(Resource inputResource,
                       File generatedFilePath) throws GenerationException
  {
	List<SystemImplementation> systemImplementationList=new ArrayList<SystemImplementation>();
	EObject root = inputResource.getContents().get(0);
	if(root instanceof SystemInstance)
	{
	  SystemInstance systemInstance = (SystemInstance) root;
	  systemImplementationList.addAll(this.getListOfSystemImplementation(systemInstance));	    
	}
	else if(root instanceof AadlPackage)
	{
	  AadlPackage aadlPackage = (AadlPackage) root;
	  PublicPackageSection pps = aadlPackage.getOwnedPublicSection();
	  for(Classifier c : pps.getOwnedClassifiers())
	  if(c instanceof SystemImplementation)
		systemImplementationList.add((SystemImplementation)c);
	}
	else
	{
	  throw new GenerationException("Try to generate from a resources that is nto an AADL model");
	}
	File generatedCodeDirectory =
          new File(generatedFilePath + GENERATED_DIR_NAME) ;
    generatedCodeDirectory.mkdir() ;

    for(SystemImplementation sys: systemImplementationList)
    {
      SystemImplementation si = (SystemImplementation) sys ;
      File generatedFileDir = new File(generatedFilePath + GENERATED_DIR_NAME);
      
      // XXX Have AadlGenericUnparser to unparse the SystemImplementation
      // object ?
      TargetProperties tarProp=null;
      if(_targetUnparser != null)
        tarProp = _targetUnparser.process(si, generatedFilePath);
      
      for(ProcessorSubcomponent ps : si.getOwnedProcessorSubcomponents())
      {
        // create directory with the processor subcomponent name
        File processorFileDir =
              new File(generatedFileDir + "/" + ps.getName()) ;
        processorFileDir.mkdir() ;
        if(_targetBuilderGen != null)
          _targetBuilderGen.process(ps, processorFileDir) ;
        
        File kernelFileDir = new File(processorFileDir + KERNEL_DIR_NAME) ;
        if(_targetUnparser != null)
          _targetUnparser.process(ps, kernelFileDir, tarProp);
        List<ProcessSubcomponent> ownedProcess = 
                                      GeneratorUtils.getBindedProcesses(ps) ;
        
        for(ProcessSubcomponent process : ownedProcess)
        {
          String generationTargetDirectory = processorFileDir +
                                             "/" + process.getName() ;
          File processDirectory = new File(generationTargetDirectory) ;
          processDirectory.mkdir() ;
          
          _genericUnparser.process(process, processDirectory) ;
          if(_targetUnparser!=null)
            _targetUnparser.process(process, processDirectory, tarProp);
          if(_targetBuilderGen!= null)
        	_targetBuilderGen.process(process, processDirectory) ;
         }
        
       // This line is at the end because it will launch the build of the generated code;
       // Thus it is better is the code has been generated...
       if(_targetBuilderGen!= null)
         _targetBuilderGen.process(si, generatedFileDir) ;
        
      }
    }  
  }

private List<SystemImplementation> getListOfSystemImplementation(
		SystemInstance systemInstance) {

	List<SystemImplementation> systemInstanceList = new ArrayList<SystemImplementation>();
	if(systemInstance.getSystemImplementation() != null)
	  systemInstanceList.add(systemInstance.getSystemImplementation());
	for(ComponentInstance ci : systemInstance.getComponentInstances())
	{
	  if(ci instanceof SystemInstance)
	  {
		systemInstanceList.addAll(getListOfSystemImplementation((SystemInstance) ci));
	  }
	}
	return systemInstanceList;
}
}