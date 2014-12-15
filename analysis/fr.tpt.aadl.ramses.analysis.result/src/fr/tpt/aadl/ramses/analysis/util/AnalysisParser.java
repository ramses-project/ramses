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

import java.io.File ;
import java.util.List ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl ;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl ;

import fr.tpt.aadl.ramses.analysis.AnalysisResultPackage ;
import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult ;
import fr.tpt.aadl.ramses.analysis.QuantitativeAnalysisResult ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;

public class AnalysisParser {

	
	private static Logger _LOGGER = Logger.getLogger(AnalysisParser.class) ;

	public static AnalysisArtifact parse(String analysisPath,
	                                     ResourceSet rs){
		
		final Resource resource;
		File analysisFile = new File(analysisPath);
		URI p_uri = URI.createFileURI(analysisPath);
		
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(AnalysisResultPackage.eNS_PREFIX, new XMIResourceFactoryImpl());
		rs.getPackageRegistry().put(AnalysisResultPackage.eNS_URI, AnalysisResultPackage.eINSTANCE);
		
		resource = rs.getResource(p_uri, analysisFile.exists());
		if (resource!=null)
		{
			return (AnalysisArtifact) resource.getContents().get(0);	
		}
		else
		{
			String msg = "analysisArtifact of specified path \'"+analysisPath+"\' does not exit" ;
		  _LOGGER.error(msg) ;
		}
		
		return null;
	}

  public static int getLastIterationId(String analysisPath)
  {
    int res = -1;
    AnalysisArtifact aa = parse(analysisPath, new ResourceSetImpl());
    if(aa != null)
    {
      List<Object> resultsList = aa.getResults();
      for(Object obj: resultsList)
      {
        if(obj instanceof QualitativeAnalysisResult)
        {
          QualitativeAnalysisResult qar = 
              (QualitativeAnalysisResult) obj;
          int iter = qar.getSource().getIterationId();
          if(iter>res)
            res=iter;
        }
        else if (obj instanceof QuantitativeAnalysisResult)
        {
          QuantitativeAnalysisResult qar = 
              (QuantitativeAnalysisResult) obj;
          int iter = qar.getSource().getIterationId();
          if(iter>res)
            res=iter;
        }
      }
    }
    return res ;
  }
	
}