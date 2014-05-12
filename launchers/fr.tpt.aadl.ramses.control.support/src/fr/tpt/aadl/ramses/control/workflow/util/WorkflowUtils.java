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

package fr.tpt.aadl.ramses.control.workflow.util;

import java.io.IOException ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl ;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl ;

import fr.tpt.aadl.ramses.control.workflow.ModelIdentifier ;
import fr.tpt.aadl.ramses.control.workflow.Workflow ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowElement ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowFactory ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPackage ;

public class WorkflowUtils {

	private static ResourceSet resourceSet;
	private static Resource resource;
	
	private static Logger _LOGGER = Logger.getLogger(WorkflowUtils.class) ;

	/**
	 * Returns a Workflow object for a file of a given location
	 * 
	 * @param workflowPath
	 *            String representing the workflow file path
	 * @return Workflow object
	 */
	public static Workflow parse(String workflowPath) {

		getResourceSet().setResourceFactoryRegistry(
				Resource.Factory.Registry.INSTANCE);

		getResourceSet().getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());
		getResourceSet().getPackageRegistry().put(WorkflowPackage.eNS_URI,
				WorkflowPackage.eINSTANCE);

		final Resource resource;
		URI workflow_uri = URI.createFileURI(workflowPath);

		if (getResourceSet().getURIConverter().exists(workflow_uri, null)) {
			resource = getResourceSet().getResource(workflow_uri, true);
			Workflow workflowRootObject = (Workflow) resource.getContents()
					.get(0);
			return workflowRootObject;
		}

		return null;
	}

	/**
	 * Creates a new workflow definition, from a root workflow 
	 * element and under a specified path.
	 * 
	 * @param workflowPath
	 *            String representing the artifact path.
	 * @param workflowElement
	 * 			  root element of the created workflow.
	 */
	public static void createNewWorkflow(String workflowPath, WorkflowElement workflowElement, ModelIdentifier inputModelIdentifier) {

		Workflow workflow = WorkflowFactory.eINSTANCE.createWorkflow();
		workflow.setElement(workflowElement);
		workflow.setInputModelIdentifier(inputModelIdentifier);
		
		URI wf_uri = URI.createFileURI(workflowPath);

		getResourceSet().getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());
		getResourceSet().getPackageRegistry().put(WorkflowPackage.eNS_URI,
				WorkflowPackage.eINSTANCE);

		resource = getResourceSet().createResource(wf_uri);
		saveWorkflow(resource, workflow);
	}

	/**
	 * Saves the given workflow specification at the {@code resource} location
	 * 
	 * @param resource
	 *            Resource object associated with the specific disk location
	 * @param workflow
	 *            Workflow object to be saved
	 */
	private static void saveWorkflow(Resource resource, Workflow workflow) {
		resource.unload();
		resource.getContents().add(workflow);

		try
		{
			resource.save(null);
		} catch (IOException e)
		{
		  String errMsg =  "cannot save the resources" ;
      _LOGGER.fatal(errMsg, e);
      throw new RuntimeException(errMsg, e) ;
		}
	}

	/**
	 * Returns either existing ResourceSet object or a new one in case it was
	 * not already existing
	 * 
	 * @return ResourceSet object
	 */
	protected static ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	/**
	 * Returns a Resource object for a file of a given location
	 * 
	 * @param workflowPath
	 *            String representing the workflow file path
	 * @return Resource object
	 */
	protected static Resource getResource(String workflowPath) {
		URI p_uri = URI.createFileURI(workflowPath);

		getResourceSet().getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());
		getResourceSet().getPackageRegistry().put(WorkflowPackage.eNS_URI,
				WorkflowPackage.eINSTANCE);

		resource = getResourceSet().getResource(p_uri, true);

		return resource;
	}
}