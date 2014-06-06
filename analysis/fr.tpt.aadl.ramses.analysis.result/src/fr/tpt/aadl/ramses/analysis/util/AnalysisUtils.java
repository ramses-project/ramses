/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.ramses.analysis.util;

import java.io.IOException ;
import java.util.HashSet ;
import java.util.List ;
import java.util.Set ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl ;

import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory ;
import fr.tpt.aadl.ramses.analysis.AnalysisResultPackage ;
import fr.tpt.aadl.ramses.analysis.QuantitativeAnalysisResult ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;

public class AnalysisUtils {

	private static Resource resource;
	private static Logger _LOGGER = Logger.getLogger(AnalysisUtils.class) ;
	
	/**
	 * Creates a new Analysis artifact of a specified path 
	 *
	 * @param analysisPath   	String representing the artifact path
	 * @return 
	 */
	public static Resource createNewAnalysisArtifact(ResourceSet resourceSet,
	                                                 String analysisPath){
		
		AnalysisArtifact analysisSpec = AnalysisResultFactory.eINSTANCE.createAnalysisArtifact(); 
		URI analysis_uri = URI.createFileURI(analysisPath);

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put(AnalysisResultPackage.eNS_PREFIX, new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(AnalysisResultPackage.eNS_URI, AnalysisResultPackage.eINSTANCE);

		if (!resourceSet.getURIConverter().exists(analysis_uri, null)){
			resource = resourceSet.createResource(analysis_uri);
			resource.getContents().add(analysisSpec);
			return resource;
		} else
		{
		  String msg = "analysis artifact of the specified path \'"+analysisPath+"\' already exists" ;
      _LOGGER.error(msg) ;
      ServiceProvider.SYS_ERR_REP.error(msg, true);
		}
		return null;
	}

	/**
	 * Saves the given specification at the resource location 
	 *
	 * @param resource   	Resource object associated with the specific disk location
	 * @param specification	AnalysisArtifact object to be saved
	 */
	public static void saveAnalysisArtifact(Resource resource){
		resource.unload();
		
		try
		{
			resource.save(null);
		}
		catch (IOException e)
		{
			String msg = "cannot save resource" ;
			_LOGGER.fatal(msg, e);
		  throw new RuntimeException(msg, e) ;
		}
	}

	
	/**
	 * Return list of analysis identifiers for which analysis was not satisfactory 
	 * @return list of analysis identifiers 
	 */
  public static Set<String> getInvalidatedResults()
  {
    Set<String> res = new HashSet<String>();
    AnalysisArtifact aa = (AnalysisArtifact) resource.getContents().get(resource.getContents().size()-1);
    
    for(Object o: aa.getResults())
    {
      if(o instanceof QuantitativeAnalysisResult)
      {
        QuantitativeAnalysisResult qar = (QuantitativeAnalysisResult) o;
        if(qar.getMargin()<0)
        {
          String qaName = convertAnalysisMethodNameToSensitivityName(qar.getSource().getMethodName());
          res.add(qaName);
        }
      }
    }
    return res;
  }

  private static String convertAnalysisMethodNameToSensitivityName(String analysisMethod)
  {
    if(analysisMethod.equals(Names.TIMING_ANALYSIS_PLUGIN_NAME))
      return Names.TIMING_SENSITIVITY_NAME;
    else if(analysisMethod.equals(Names.MEMORY_ANALYSIS_PLUGIN_NAME))
      return Names.MEMORY_SENSITIVITY_NAME;
    return null;
  }
  
  public static String getLeastSatisfiedQualityAttribute()
  {
    String res = null;
    AnalysisArtifact aa = (AnalysisArtifact) resource.getContents().get(resource.getContents().size()-1);
    float worst=0;
    for(Object o: aa.getResults())
    {
      if(o instanceof QuantitativeAnalysisResult)
      {
        QuantitativeAnalysisResult qar = (QuantitativeAnalysisResult) o;
        if(qar.getMargin()<worst)
        {
          worst = qar.getMargin();
          res = convertAnalysisMethodNameToSensitivityName(qar.getSource().getMethodName());
        }
      }
    }
    return res;
  }

  public static float getMarginFor(List<EObject> elementList,
                                   String currentQualityAttributeToImprove)
  {
    AnalysisArtifact aa = (AnalysisArtifact) resource.getContents().get(0);
    
    for(EObject obj: elementList)
    {
      for(Object o: aa.getResults())
      {
        if(o instanceof QuantitativeAnalysisResult)
        {
          QuantitativeAnalysisResult qar = (QuantitativeAnalysisResult) o;
          String qaName = convertAnalysisMethodNameToSensitivityName(qar.getSource().getMethodName());
          if(qaName.equals(currentQualityAttributeToImprove))
          {
            return qar.getMargin();
          }
        }
      } 
    }
    return 2 ; // 2 is not a valid result (margin goes from -infinity to 1)
  }
}