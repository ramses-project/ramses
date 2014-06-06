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

import org.apache.log4j.Logger ;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import fr.tpt.aadl.ramses.analysis.AnalysisResultPackage;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;

public class AnalysisParser {

	
	private static Logger _LOGGER = Logger.getLogger(AnalysisParser.class) ;

	public static AnalysisArtifact parse(String analysisPath,
	                                     ResourceSet rs){
		
		final Resource resource;
		
		URI p_uri = URI.createFileURI(analysisPath);
		
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(AnalysisResultPackage.eNS_PREFIX, new XMIResourceFactoryImpl());
		rs.getPackageRegistry().put(AnalysisResultPackage.eNS_URI, AnalysisResultPackage.eINSTANCE);
		
		if (rs.getURIConverter().exists(p_uri, null))
		{
			resource = rs.getResource(p_uri, true);			
			return (AnalysisArtifact) resource.getContents().get(0);	
		}
		else
		{
			String msg = "analysisArtifact of specified path \'"+analysisPath+"\' does not exit" ;
		  _LOGGER.error(msg) ;
		  ServiceProvider.SYS_ERR_REP.error(msg, true);
		}
		
		return null;
	}
	
}