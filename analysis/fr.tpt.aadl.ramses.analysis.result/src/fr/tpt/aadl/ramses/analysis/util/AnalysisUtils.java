package fr.tpt.aadl.ramses.analysis.util;

import java.io.IOException;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import fr.tpt.aadl.ramses.analysis.AnalysisArtifact;
import fr.tpt.aadl.ramses.analysis.AnalysisResultPackage;
import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory;
import fr.tpt.aadl.ramses.analysis.AnalysisSource;
import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult;
import fr.tpt.aadl.ramses.analysis.QuantitativeAnalysisResult;

public class AnalysisUtils {

	private static ResourceSet resourceSet;
	private static Resource resource;

	
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
		} else {
			System.out.println("Analysis artifact of the specified path: "+analysisPath+" already exists.");
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
		
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
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
	
}
