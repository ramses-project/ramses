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

package fr.tpt.aadl.ramses.control.support.instantiation;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;

/**
 * This interface specifies the methods to manage AADL systems instantiation
 */
public interface AadlModelInstantiatior {

	/**
	 * Search the system implementation by the given name in the given AADL
	 * resources. Then instantiate the system implementation found and return the
	 * instance. 
	 * 
	 * @param aadlModels list of AADL model resources containing the system 
	 * implementation to instantiate
	 * @param systemToInstantiate name of the system implementation
	 * to instantiate
	 * @return the system instance resulting from the instantiation,
	 * null if the system instantiation failed.
	 */
	SystemInstance instantiate(List<Resource> aadlModels,
			                       String systemToInstantiate);
	
	/**
	 * Instantiate the given system implementation node.
	 * @param si the system implementation to instantiate
	 * @return the system instance resulting from instantiation, null
	 * if the instantiation failed.
	 */
	SystemInstance instantiate(SystemImplementation si);
	
	/**
	 * This method serializes an AADL resource into a target file.
	 * @param transfoResult the resource in which aadl model has
	 * been created.
	 * @param targetFileName the path of the aadl file in which
	 * aadl code will be added.
	 */
	void serialize(Resource transfoResult, String targetFileName);
	
	public void setProgressMonitor(IProgressMonitor monitor) ;
}