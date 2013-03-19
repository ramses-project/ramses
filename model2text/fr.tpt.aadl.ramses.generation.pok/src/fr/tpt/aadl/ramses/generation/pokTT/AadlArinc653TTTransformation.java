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

package fr.tpt.aadl.ramses.generation.pokTT;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;

import fr.tpt.aadl.ramses.control.support.InstantiationManager;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.generator.AadlToTargetSpecificAadl;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.transformation.atl.Aadl2AadlLauncher;
import fr.tpt.aadl.ramses.transformation.atl.AtlTransfoLauncher;

public class AadlArinc653TTTransformation implements AadlToTargetSpecificAadl
{
	public static final String DEFAULT_ATL_FILE_PATH = "../../model2model/fr.tpt.aadl.ramses.transformation.atl/";

	public static final String[] ATL_FILE_NAMES_STEP1 = new String[] {
			"targets/arinc653_TT/CreateSchedulerEntities.asm",
			"targets/arinc653_TT/ExpandDelayedConnections.asm"};
			//"targets/arinc653_TT/ExpandArincConnections.asm" };
			
	//public static final String[] ATL_FILE_NAMES_STEP1 = new String[]{};

	public static final String[] ATL_FILE_NAMES_STEP2 = new String[] {
			"targets/arinc653/ExpandThreadsPorts.asm",
			"ExpandSubprogramCalls.asm",
			"targets/arinc653/ExpandThreadsDispatchProtocol.asm",
			"CreateThreadsBehavior.asm" };

	@Override
	public Resource transform(Resource inputResource, File resourceFilePath,
	                          File generatedFilePath)
	                                throws GenerationException
	{
		try
		{
			if (resourceFilePath == null)
			{
				resourceFilePath = new File(DEFAULT_ATL_FILE_PATH);
			}
			
			
			Resource r1 = expandDelayedConnections(inputResource, resourceFilePath, generatedFilePath);
			
			SystemInstance s = instanciate(r1);
			System.out.println("Instanciation: " + s.eResource().getURI().path());

			Resource r2 = expandThreadsBehavior(s.eResource(), resourceFilePath, generatedFilePath);
			//Resource r2 = s.eResource();
			
			return r2;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			throw new GenerationException(e.getMessage());
		}
	}
	
	 // transformXML does not act as transform since it deals with one single transformation at the same time
  // if you want to specify the same workflow as in the transform method, please just consider two
  // transformations in the XML file
  
  @Override
  public Resource transformXML(Resource inputResource, File resourceFilePath,
      List<String> resourceFileNameList,
      File generatedFilePath)
      throws GenerationException
  {
    try
    {
      if (resourceFilePath == null)
      {
        resourceFilePath = new File(DEFAULT_ATL_FILE_PATH);
      }
      
      
      ArrayList<File> atlFiles = new ArrayList<File>(resourceFileNameList.size());

      for (String fileName : resourceFileNameList)
      {
        atlFiles.add(new File(resourceFilePath + "/" + fileName));
      }

      Resource r1 ;
      
      AtlTransfoLauncher atlLauncher;
	  try {
		  atlLauncher = new Aadl2AadlLauncher();
		  r1 = atlLauncher.generationEntryPoint(inputResource,
				  resourceFilePath,
				  atlFiles,
				  generatedFilePath);
	  } catch (Exception e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		  return null;
	  }
      
      SystemInstance s = instanciate(r1);
      System.out.println("Instanciation: " + s.eResource().getURI().path());

      
      return r1;
    }
    catch (Exception e)
    {
      e.printStackTrace();
      throw new GenerationException(e.getMessage());
    }
  }
  
	
	private Resource expandDelayedConnections(Resource r, File resourceFilePath,
			File generatedFilePath) throws Exception
	{
		System.out.println("********************************************");
		System.out.println("Expansion n°1: Delayed connections\n(resource: "
				+ r.getURI().path() + ")");
		Resource r1 = transform(r, resourceFilePath,
				generatedFilePath,
				ATL_FILE_NAMES_STEP1);
		
		return r1;
	}
	
	private Resource expandThreadsBehavior(Resource r1, 
			File resourceFilePath,
			File generatedFilePath) throws Exception
	{
		System.out.println("********************************************");
		
		System.out.println("Expansion n°2: Threads behavior\n(resource: "
				+ r1.getURI().path() + ")");

		Resource r2 = transform(r1, resourceFilePath,
				generatedFilePath, ATL_FILE_NAMES_STEP2);
		
		System.out.println("**************   D O N E   *****************");

		return r2;
	}
	
	private SystemInstance instanciate (Resource r)
	{
		InstantiationManager instantiator = RamsesConfiguration.getInstantiationManager();
        PropertiesLinkingService pls = new PropertiesLinkingService ();
        AadlPackage pkg = (AadlPackage) r.getContents().get(0);
        SystemImplementation si = (SystemImplementation) pls.
        		findNamedElementInsideAadlPackage(findSystemName(r), 
        				pkg.getOwnedPublicSection());
        SystemInstance newInstance =
        		instantiator.instantiate(si);
		return newInstance;
	}

	private Resource transform(Resource inputResource, File resourceFilePath,
	                           File generatedFilePath,
	                           final String[] modules) throws Exception
  {
	  ArrayList<File> atlFiles = new ArrayList<File>(modules.length);

	  for (String fileName : modules)
	  {
	    atlFiles.add(new File(resourceFilePath + "/" + fileName));
	  }

	  AtlTransfoLauncher atlLauncher;
	  try {
		  atlLauncher = new Aadl2AadlLauncher();
		  return atlLauncher.generationEntryPoint(inputResource,
				  resourceFilePath,
				  atlFiles,
				  generatedFilePath);
	  } catch (Exception e) {
		  // TODO Auto-generated catch block
		  e.printStackTrace();
		  return null;
	  }
  }
  
	
	public String findSystemName(Resource r)
	{
		AadlPackage aadlPackage = (AadlPackage) r.getContents().get(0);

		for (NamedElement member : aadlPackage.getOwnedPublicSection()
				.getOwnedMembers())
		{
			if (member instanceof SystemImplementation)
			{
				return member.getName();
			}
		}
		return null;
	}

	@Override
	public void setParameters(Map<Enum<?>, Object> parameters)
	{
		throw new UnsupportedOperationException();
	}
}
