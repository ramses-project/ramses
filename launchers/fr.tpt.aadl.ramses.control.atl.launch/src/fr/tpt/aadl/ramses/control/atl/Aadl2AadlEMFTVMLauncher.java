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

package fr.tpt.aadl.ramses.control.atl ;

import java.io.File ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.List ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.m2m.atl.emftvm.ExecEnv ;
import org.eclipse.m2m.atl.emftvm.util.ModuleResolver ;
import org.osate.aadl2.util.Aadl2Util ;

import antlr.RecognitionException ;
import fr.tpt.aadl.ramses.control.support.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.RamsesException ;
import fr.tpt.aadl.ramses.control.support.TransformationException ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;


public class Aadl2AadlEMFTVMLauncher extends Aadl2XEMFTVMLauncher
{
  private static Logger _LOGGER = Logger.getLogger(Aadl2AadlEMFTVMLauncher.class) ;
  
	public Aadl2AadlEMFTVMLauncher(AadlModelInstantiatior modelInstantiator,
			                           PredefinedAadlModelManager predefinedResourcesManager)
	{
		super(modelInstantiator, predefinedResourcesManager);
	}

	public Resource generationEntryPoint(Resource inputResource,
			                                 List<File> transformationFileList,
			                                 File outputDir)
			                                            throws TransformationException
	{

			String aadlGeneratedFileName = inputResource.getURI().lastSegment();
			aadlGeneratedFileName = aadlGeneratedFileName.replaceFirst(
					".aaxl2", "_extended.aadl2");

			Aadl2Util.setUseTunedEqualsMethods (false);
			Resource transfoResult;
			try
			{
				transfoResult = this.doTransformation(transformationFileList,
					inputResource, aadlGeneratedFileName, "_extended");
			}
			finally
			{
				Aadl2Util.setUseTunedEqualsMethods (false);
			}

			File outputModelDir =  new File(outputDir.getAbsolutePath()+"/refined-models");
			if(outputModelDir.exists()==false)
				outputModelDir.mkdir();
			
			String outputFilePath=outputModelDir.getAbsolutePath()+File.separator+aadlGeneratedFileName;
			File outputFile = new File(outputFilePath);

			_modelInstantiator.serialize(transfoResult, outputFilePath);
			try
			{
			  return AadlToTargetSpecificAadl.extractAadlResource(inputResource,
			                                                      outputFile);
			}
			catch(IOException | RecognitionException ex)
			{
			  String msg = "fail to extract AADL resources" ;
	      throw new TransformationException(msg, ex) ;
			}
		}

	protected void registerDefaultTransformationModules()
	{
		env.loadModule(_moduleResolver, RamsesConfiguration.getAtlResourceDir().getAbsolutePath()+"/Uninstanciate");
		registerDefaultTransformationsEMFTVM(env, _moduleResolver);
	}
	
	private void registerDefaultTransformationsEMFTVM(ExecEnv env,
			                                              ModuleResolver mr)
	{
		List<String> fileName = new ArrayList<String>() ;
		fileName.add("/helpers/IOHelpers") ;
		fileName.add("/helpers/AADLCopyHelpers") ;
		fileName.add("/helpers/AADLICopyHelpers") ;
		fileName.add("/helpers/BehaviorAnnexServices") ;
		fileName.add("/tools/PropertiesTools") ;
		fileName.add("/tools/PackagesTools") ;
		fileName.add("/tools/FeaturesTools") ;
		fileName.add("/uninstanciate/Features") ;
		fileName.add("/uninstanciate/Implementations") ;
		fileName.add("/uninstanciate/Properties") ;
		fileName.add("/uninstanciate/Types") ;
		fileName.add("/uninstanciate/Connections") ;
		fileName.add("/helpers/Services") ;
		fileName.add("/tools/BehaviorAnnexTools") ;
		fileName.add("/BehaviorAnnexCopy/copyBehaviorActionBlock") ;
		fileName.add("/BehaviorAnnexCopy/copyBehaviorCondition") ;
		fileName.add("/BehaviorAnnexCopy/copyBehaviorSpecification") ;
		fileName.add("/BehaviorAnnexCopy/copyBehaviorTime") ;
		fileName.add("/BehaviorAnnexCopy/copyElementHolders") ;
		
		for(String s : fileName)
		{
			env.loadModule(mr, RamsesConfiguration.getAtlResourceDir().getAbsolutePath()+s);
		}
		
	}

	@Override
	protected Resource initTransformationOutput(Resource inputResource,
			                                        String outputDirPathName,
			                                        String resourceSuffix)
	{
		
		ResourceSet rs = inputResource.getResourceSet();
		
		String aadlGeneratedFileName = inputResource.getURI().path();
		if(aadlGeneratedFileName.startsWith("file:"))
			aadlGeneratedFileName = aadlGeneratedFileName.substring("file:".length());
		else if (aadlGeneratedFileName.startsWith("platform:/resource"))
			aadlGeneratedFileName = aadlGeneratedFileName.substring("platform:/resource".length());
		aadlGeneratedFileName = aadlGeneratedFileName.replaceFirst(
				".aaxl2", resourceSuffix+".aaxl2");
		URI uri = URI.createURI(aadlGeneratedFileName);
		Resource outputResource = rs.getResource(uri, false);
		if(outputResource==null)
		{
		  outputResource = rs.createResource(uri);
		}
		else
		{
		  try
		  {
			  outputResource.delete(null);
		  }
		  catch (IOException e)
		  {
		    String errMsg =  RamsesException.formatRethrowMessage("cannot erase the previous output resource \'" +
		                                                          uri.toString() + '\'', e) ;
        _LOGGER.error(errMsg);
        ServiceProvider.SYS_ERR_REP.error(errMsg, true);
		  }
		  outputResource = rs.createResource(uri);
		}
		
		return outputResource;
	}
}