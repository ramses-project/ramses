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

package fr.tpt.aadl.ramses.control.support.generator;

import java.io.File ;
import java.util.Map ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.resource.Resource ;


public interface AadlToAadl
{
  public void initAtlFileNameList(File resourceFilePath);
	
  public Resource transform(Resource inputResource,
							 String targetId,
							 File outputDir,
							 IProgressMonitor monitor) throws TransformationException;
  
  public Resource unparse(Resource inputResource,
                          Resource expandedResult,
		                      File outputDir,
		                      IProgressMonitor monitor) throws GenerationException ;
  
  public void setParameters(Map<Enum<?>, Object> parameters) ;
}