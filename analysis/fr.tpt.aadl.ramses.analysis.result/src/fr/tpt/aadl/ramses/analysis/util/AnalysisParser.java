package fr.tpt.aadl.ramses.analysis.util;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import fr.tpt.aadl.ramses.analysis.AnalysisArtifact;
import fr.tpt.aadl.ramses.analysis.AnalysisResultPackage;

public class AnalysisParser {

	private static ResourceSet resourceSet;

	public static AnalysisArtifact parse(String analysisPath){
		
		final Resource resource;
		
		URI p_uri = URI.createFileURI(analysisPath);
		
		getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put(AnalysisResultPackage.eNS_PREFIX, new XMIResourceFactoryImpl());
		getResourceSet().getPackageRegistry().put(AnalysisResultPackage.eNS_URI, AnalysisResultPackage.eINSTANCE);
		
		if (getResourceSet().getURIConverter().exists(p_uri, null)) {
			resource = getResourceSet().getResource(p_uri, true);			
			return (AnalysisArtifact) resource.getContents().get(0);	
		} else {
			System.out.println("AnalysisArtifact of specified path ("+analysisPath+") does not exit.");
		}
		
		return null;
	}
	
	protected static ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}
	

	
}
