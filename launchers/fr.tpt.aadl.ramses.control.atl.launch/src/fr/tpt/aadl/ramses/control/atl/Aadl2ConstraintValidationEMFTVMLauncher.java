/**
 * AADL-RAMSES
 * 
 * Copyright Â© 2012 TELECOM ParisTech and CNRS
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

/*
 * author: Etienne Borde
 *
 */

package fr.tpt.aadl.ramses.control.atl ;

import java.io.IOException ;

import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.EPackage ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory ;
import org.eclipse.m2m.atl.emftvm.Metamodel ;

import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager ;


public class Aadl2ConstraintValidationEMFTVMLauncher extends AadlModelValidator
{
	
	private String ERROR_REPORTER_URI = "http://fr.tpt.aadl.ramses.constraints.vilation.reporter";
	
	public Aadl2ConstraintValidationEMFTVMLauncher(AadlModelInstantiatior modelInstantiator,
			PredefinedAadlModelManager predefinedResourcesManager)
	{
		super(modelInstantiator, predefinedResourcesManager);
	}

	@Override
	protected Resource initTransformationOutput(Resource inputResource,
			String outputDirPathName, String resourceSuffix) {
		
		ResourceSet rs = inputResource.getResourceSet();
		
		// Load metamodels
		// Load aadl instance metamodel 
		Metamodel aadlInstanceMetaModel = EmftvmFactory.eINSTANCE.createMetamodel();
		aadlInstanceMetaModel.setResource(rs.getResource(URI.createURI(ERROR_REPORTER_URI), true));
		env.registerMetaModel("CV", aadlInstanceMetaModel);
		
		String aadlFileName = inputResource.getURI().path();
		if(aadlFileName.startsWith("file:"))
			aadlFileName = aadlFileName.substring("file:".length());
		else if (aadlFileName.startsWith("platform:/resource"))
			aadlFileName = aadlFileName.substring("platform:/resource".length());
		aadlFileName = aadlFileName.replaceFirst(
				".aaxl2", resourceSuffix+".xmi");
		URI uri = URI.createURI(aadlFileName);
		Resource outputResource = rs.getResource(uri, false);
		if(outputResource==null)
		  outputResource = rs.createResource(uri);
		else
		{
		  try {
			outputResource.delete(null);
		  } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		  }
		  outputResource = rs.createResource(uri);
		}
		
		return outputResource;
	}

	
	@Override
	protected void initTransformation()
	{
		EPackage.Registry.INSTANCE.put(ERROR_REPORTER_URI, 
				fr.tpt.aadl.ramses.constraintsreporter.reporterPackage.eINSTANCE);
		super.initTransformation();
	}

	@Override
	protected void registerDefaultTransformationModules() {
		// No default module here.
	}
}