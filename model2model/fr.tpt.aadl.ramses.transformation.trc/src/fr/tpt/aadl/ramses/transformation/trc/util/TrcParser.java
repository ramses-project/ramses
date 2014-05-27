package fr.tpt.aadl.ramses.transformation.trc.util;

import java.util.Iterator ;
import java.util.List ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl ;

import fr.tpt.aadl.ramses.transformation.trc.Transformation ;
import fr.tpt.aadl.ramses.transformation.trc.TransformationImpact ;
import fr.tpt.aadl.ramses.transformation.trc.TrcPackage ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;

public class TrcParser {

  private static Logger _LOGGER = Logger.getLogger(TrcParser.class) ;
  
	public static TrcSpecification parse(String trcPath, 
	                                     ResourceSet resourceSet){
		
		final Resource resource;
		
		URI p_uri = URI.createURI(trcPath);
		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("trc", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(TrcPackage.eNS_URI, TrcPackage.eINSTANCE);
		
		if (resourceSet.getURIConverter().exists(p_uri, null)) {
			resource = resourceSet.getResource(p_uri, true);
			TrcSpecification result = (TrcSpecification) resource.getContents().get(0);
			return result;	
		} else {
		  _LOGGER.error("TRC of specified path ("+trcPath+") does not exit.");
		}
		
		return null;
	}
	
	
	public static int getQualityImpactValue(Transformation transformation, String qualityAttributeName){
		
		List<TransformationImpact> impactsList = transformation.getImpacts();
		Iterator<TransformationImpact> impactsIt = impactsList.iterator(); 
		while (impactsIt.hasNext()){
			TransformationImpact impactObject = impactsIt.next();
			if (impactObject.getQualityAttributeName().equals(qualityAttributeName)){
				return impactObject.getImpactValue();
			}
		}
		System.out.println("WARNING: in TRC, no information provided for sensitivity: "+qualityAttributeName);
		System.out.println("INFO: name of the sensitivity in RDAL must match the name of impacts in TRC.");
		return 0;
	} 
	
	
}
