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

import java.io.IOException;
import java.util.ArrayList ;
import java.util.HashSet ;
import java.util.List ;
import java.util.Set ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.osate.aadl2.NamedElement;

import fr.tpt.aadl.ramses.analysis.AnalysisResultPackage;
import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory;
import fr.tpt.aadl.ramses.analysis.AnalysisSource;
import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult;
import fr.tpt.aadl.ramses.analysis.QuantitativeAnalysisResult;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;

public class AnalysisUtils {

	private static ResourceSet resourceSet;
	private static Resource resource;
	private static Logger _LOGGER = Logger.getLogger(AnalysisUtils.class) ;
	
	/**
	 * Creates a new Analysis artifact of a specified path 
	 *
	 * @param analysisPath   	String representing the artifact path
	 * @return 
	 */
	public static Resource createNewAnalysisArtifact(String analysisPath){
		
		AnalysisArtifact analysisSpec = AnalysisResultFactory.eINSTANCE.createAnalysisArtifact(); 
		
		URI analysis_uri = URI.createFileURI(analysisPath);

		getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put(AnalysisResultPackage.eNS_PREFIX, new XMIResourceFactoryImpl());
		getResourceSet().getPackageRegistry().put(AnalysisResultPackage.eNS_URI, AnalysisResultPackage.eINSTANCE);

		if (!getResourceSet().getURIConverter().exists(analysis_uri, null)){
			resource = getResourceSet().createResource(analysis_uri);
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
	 * Adds quantitative analysis result to AnalysisArtifact of specified path 
	 *
	 * @param _analysisPath		String representing the artifact path
	 * @param _scope			String representing the qualified name of the model element or model identifier
	 * @param _iterationId		int representing the iteration number
	 * @param _nfpId			String representing the non-functional property for which the analysis is done
	 * @param _evalValue		float representing the evaluation value
	 */
	public static void addQuantitativeAnalysisResult(String _analysisPath, String _scope, int _iterationId, String _nfpId, float _evalValue){

		AnalysisArtifact analysisSpec = AnalysisParser.parse(_analysisPath);

		QuantitativeAnalysisResult resultObj = AnalysisResultFactory.eINSTANCE.createQuantitativeAnalysisResult();
		if (_nfpId != null){
			resultObj.setNfpId(_nfpId);
		}
		if (_scope != null){
			AnalysisSource sourceObj = AnalysisResultFactory.eINSTANCE.createAnalysisSource();
			sourceObj.setScope(_scope);
			if (_iterationId > -1){
				sourceObj.setIterationId(_iterationId);
			}
			resultObj.setSource(sourceObj);
		}
		resultObj.setMargin(_evalValue);
		
		analysisSpec.getResults().add(resultObj);
					
	}
	

	/**
	 * Adds qualitative analysis result to AnalysisArtifact of specified path 
	 *
	 * @param _analysisPath		String representing the artifact path
	 * @param _scope			String representing the qualified name of the model element or model identifier
	 * @param _iterationId		int representing the iteration number
	 * @param _nfpId			String representing the non-functional property for which the analysis is done
	 * @param _evalValue		boolean representing the evaluation value
	 */
	public static void addQualitativeAnalysisResult(String _analysisPath, String _scope, int _iterationId, String _nfpId, boolean _evalValue){

		AnalysisArtifact analysisSpec = AnalysisParser.parse(_analysisPath);

		QualitativeAnalysisResult resultObj = AnalysisResultFactory.eINSTANCE.createQualitativeAnalysisResult();
		if (_nfpId != null){
			resultObj.setNfpId(_nfpId);
		}
		if (_scope != null){
			AnalysisSource sourceObj = AnalysisResultFactory.eINSTANCE.createAnalysisSource();
			sourceObj.setScope(_scope);
			if (_iterationId > -1){
				sourceObj.setIterationId(_iterationId);
			}
			resultObj.setSource(sourceObj);
		}
		resultObj.setValidated(_evalValue);
		
		analysisSpec.getResults().add(resultObj);
					
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
	 * Returns either existing ResourceSet object or a new one in case it was not already existing 
	 *
	 * @return       ResourceSet object 
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
	 * @param trcPath   String representing a element type
	 * @return     		Resource object 
	 */
	protected static Resource getResource(String analysisPath){
		URI p_uri = URI.createFileURI(analysisPath);

		getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put(AnalysisResultPackage.eNS_PREFIX, new XMIResourceFactoryImpl());
		getResourceSet().getPackageRegistry().put(AnalysisResultPackage.eNS_URI, AnalysisResultPackage.eINSTANCE);
		
		resource = getResourceSet().getResource(p_uri, true);

		return resource;
	}

	
	/**
	 * Return list of analysis identifiers for which analysis was not satisfactory 
	 * @return list of analysis identifiers 
	 */
  public static Set<String> getInvalidatedResults()
  {
    Set<String> res = new HashSet<String>();
    AnalysisArtifact aa = (AnalysisArtifact) resource.getContents().get(0);
    
    for(Object o: aa.getResults())
    {
      if(o instanceof QuantitativeAnalysisResult)
      {
        QuantitativeAnalysisResult qar = (QuantitativeAnalysisResult) o;
        if(qar.getMargin()<0)
        {
          String qaName = convertAnalysisMethodToQualityAttribute(qar.getSource().getMethodName());
          res.add(qaName);
        }
      }
    }
    return res;
  }

  private static String convertAnalysisMethodToQualityAttribute(String analysisMethod)
  {
    // TODO: implement this...
    if(analysisMethod.equals(""))
      return analysisMethod;
    else
      return analysisMethod;
  }
  
  public static String getLeastSatisfiedQualityAttribute()
  {
    String res = null;
    AnalysisArtifact aa = (AnalysisArtifact) resource.getContents().get(0);
    float worst=0;
    for(Object o: aa.getResults())
    {
      if(o instanceof QuantitativeAnalysisResult)
      {
        QuantitativeAnalysisResult qar = (QuantitativeAnalysisResult) o;
        if(qar.getMargin()<worst)
        {
          worst = qar.getMargin();
          res = qar.getSource().getMethodName();
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
          String qaName = convertAnalysisMethodToQualityAttribute(qar.getSource().getMethodName());
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