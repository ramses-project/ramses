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

import java.util.List ;
import java.util.Map ;

import org.eclipse.emf.common.util.TreeIterator ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;

import org.osate.aadl2.Element ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.SystemImplementation ;

import fr.tpt.aadl.ramses.control.support.generator.AadlGenericUnparser ;
import fr.tpt.aadl.ramses.control.support.generator.AadlTargetUnparser ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.TargetBuilderGenerator ;
import fr.tpt.aadl.ramses.control.support.generator.TargetProperties ;


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
    TreeIterator<EObject> iter = inputResource.getAllContents() ;
      
    File generatedCodeDirectory =
          new File(generatedFilePath + GENERATED_DIR_NAME) ;
    generatedCodeDirectory.mkdir() ;

    while(iter.hasNext())
    {
      Element elt = (Element) iter.next() ;
      
      if(elt instanceof SystemImplementation)
      {
        SystemImplementation si = (SystemImplementation) elt ;
        File generatedFileDir = new File(generatedFilePath + GENERATED_DIR_NAME);
        _targetBuilderGen.process(si, generatedFileDir) ;
        
        // XXX Have AadlGenericUnparser to unparse the SystemImplementation
        // object ?
        
        TargetProperties tarProp = _targetUnparser.process(si, generatedFilePath);
        
        for(ProcessorSubcomponent ps : si.getOwnedProcessorSubcomponents())
        {
          // create directory with the processor subcomponent name
          File processorFileDir =
                new File(generatedFileDir + "/" + ps.getName()) ;
          processorFileDir.mkdir() ;
          _targetBuilderGen.process(ps, processorFileDir) ;
          
          File kernelFileDir = new File(processorFileDir + KERNEL_DIR_NAME) ;
          
          // XXX Have AadlGenericUnparser to unparse the ProcessorSubcomponent 
          // object ?
//          _genericUnparser.process(ps, kernelFileDir) ;
          
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
            _targetBuilderGen.process(process, processDirectory) ;
            
            _targetUnparser.process(process, processDirectory, tarProp);
          }
        }
      }
    }  
  }
}