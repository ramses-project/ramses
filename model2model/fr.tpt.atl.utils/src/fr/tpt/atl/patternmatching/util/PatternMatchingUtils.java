package fr.tpt.atl.patternmatching.util;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import fr.tpt.aadl.ramses.transformation.trc.TrcRule ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;
import fr.tpt.atl.patternmatching.ElementTransformationTuple;
import fr.tpt.atl.patternmatching.patternmatchingPackage;


public class PatternMatchingUtils {

	
	/**
	 * Returns a map of elementId associated transformationIds from a given pml file
	 * @param trcSpec 
	 *
	 * @param startingMap   Map of elementId-transformationIds to which new results from a given file will be added
	 * @param pmlFilePath	String representing the path of the ".pml" file
	 * @return  a map of elementId associated transformationIds
	 */
	public static Map<List<EObject>, ArrayList<TrcRule>> getGroupedCandidateTuplesFromFile(TrcSpecification trcSpec, 
	                                                                                       LinkedHashMap<List<EObject>, ArrayList<TrcRule>> startingMap,
	                                                                                      String patternMatchingFilePath,
	                                                                                      ResourceSet resourceSet){
		LinkedHashMap<List<EObject>, ArrayList<TrcRule>> results = startingMap;
		
		File f = new File(patternMatchingFilePath);
		ArrayList<ElementTransformationTuple> tuplesList = PatternMatchingUtils.
		    getCandidateTuplesFromFile(f,resourceSet);
		if (tuplesList != null){
			Iterator<ElementTransformationTuple> tuplesIt = tuplesList.iterator();
			while (tuplesIt.hasNext()){
				ElementTransformationTuple tupleObject = tuplesIt.next();
				if (!resultsContainsKey(results.keySet(), tupleObject.getKey())){
					ArrayList<TrcRule> array = new ArrayList<TrcRule>();
					TrcRule rule = trcSpec.getTrcRule(tupleObject.getValue());
					array.add(rule);
					results.put(tupleObject.getKey(), array);
				} else {
				  TrcRule newVal = trcSpec.getTrcRule(tupleObject.getValue());
					List<TrcRule> oldVals = results.get(tupleObject.getKey());
					if(false == oldVals.contains(newVal))
					{
						results.get(tupleObject.getKey()).add(newVal);
					}
				}
			}
			
		} else {
			System.out.println("List of tuples was null.");										
		}
		
		//System.out.println(results);
		
		return results.size() > 0 ? results : null;
	}

	
	
	private static boolean resultsContainsKey(Set<List<EObject>> resultKeySet, EList<EObject> key) {
		for(List<EObject> resultKey:resultKeySet)
		{
			if(resultKey.size()!=key.size())
				continue;
			boolean same=true;
			for(int i=0; i<resultKey.size(); i++)
			{
				if(false == resultKey.get(i).equals(key.get(i)))
				{
					same=false;
					break;
				}
			}
			if(same)
				return true;
		}
		return false;
	}



	/**
	 * Returns a map of elementId associated transformationIds from a given pml file
	 *
	 * @param pmlFilePath	String representing the path of the ".pml" file
	 * @return  a map of elementId associated transformationIds
	 */
	public static Map getGroupedCandidateTuplesFromFile(String pmlFilePath,
	                                                    ResourceSet resourceSet){
		HashMap<List, ArrayList<String>> results = new HashMap<List, ArrayList<String>>();
		
		File f = new File(pmlFilePath);
		ArrayList<ElementTransformationTuple> tuplesList = 
		    PatternMatchingUtils.getCandidateTuplesFromFile(f,resourceSet);
		if (tuplesList != null){
			Iterator<ElementTransformationTuple> tuplesIt = tuplesList.iterator();
			while (tuplesIt.hasNext()){
				ElementTransformationTuple tupleObject = tuplesIt.next();
				if (!results.containsKey(tupleObject.getKey())){
					ArrayList<String> array = new ArrayList<String>();
					array.add(tupleObject.getValue());
					results.put(tupleObject.getKey(), array);
				} else {
					results.get(tupleObject.getKey()).add(tupleObject.getValue());
				}
			}
			
		} else {
			System.out.println("List of tuples was null.");										
		}
		
		//System.out.println(results);
		
		return results.size() > 0 ? results : null;
	}

	
	
	/**
	 * Returns a map of elementId associated transformationIds from all the ".pml" files from a given directory
	 * @param trcSpec 
	 *
	 * @param directoryPath	String representing a path to directory containing the ".pml" files
	 * @return  a map of elementId associated transformationIds
	 */
	public static Map<List<EObject>, ArrayList<TrcRule>> getGroupedCandidateTuplesFromDirectory(TrcSpecification trcSpec, String directoryPath,
	                                                                                  ResourceSet resourceSet){
		LinkedHashMap<List<EObject>, ArrayList<TrcRule>> results = new LinkedHashMap<List<EObject>, ArrayList<TrcRule>>();		
		
		File dirFile = new File(directoryPath);
		File[] files = dirFile.listFiles(new FilenameFilter() {
		    public boolean accept(File dir, String name) {
		        return name.toLowerCase().endsWith(".pml");
		    }
		});
		
		for (int i=0; i<files.length; i++){
			getGroupedCandidateTuplesFromFile(trcSpec,
			                                  results,
			                                  files[i].getPath(),
			                                  resourceSet);
		}
        

		return results;
	}
	
	
	
	/**
	 * Returns a list of ElementTransformationTuple objects gathered from a pattern matching process result for a particular file
	 *
	 * @param file	File object for a "pml" resource
	 * @return  a list of ElementTransformationTuple objects
	 */
	public static ArrayList<ElementTransformationTuple> getCandidateTuplesFromFile(File f,
	                                                                               ResourceSet resourceSet) {
		ArrayList<ElementTransformationTuple> results = new ArrayList<ElementTransformationTuple>();
		
		final Resource resource;
		URI p_uri = URI.createFileURI(f.getPath());
		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("pml", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(patternmatchingPackage.eNS_URI, patternmatchingPackage.eINSTANCE);
		
		if (resourceSet.getURIConverter().exists(p_uri, null)) {
			
			resource = resourceSet.getResource(p_uri, true);
			
			List<EObject> tuples = resource.getContents();	
			Iterator<EObject> tuplesIt = tuples.iterator();
			
			while (tuplesIt.hasNext()){
				ElementTransformationTuple ett = (ElementTransformationTuple) tuplesIt.next();
				results.add(ett);			
			}
		} else {
			System.out.println("Error: "+p_uri +" not found.");		
		}
		
		return results.size() > 0 ? results : null;
	}

	/**
	 * Returns a list of ElementTransformationTuple objects gathered from a set of pattern matching results
	 *
	 * @param listOfNamesOfFiles	 list of files obtained as pattern matching process result ("pml" extension)
	 * @return  a list of ElementTransformationTuple objects gathered from a set of pattern matching results 
	 */
	public List<ElementTransformationTuple> getCandidateTuplesFromFiles(List<String> listOfNamesOfFiles,
	                                                                    ResourceSet resourceSet) {
		ArrayList<ElementTransformationTuple> result = new ArrayList<ElementTransformationTuple>();
		
		Iterator<String> fileNamesIt = listOfNamesOfFiles.iterator();
		while (fileNamesIt.hasNext()){
			String fileName = fileNamesIt.next();
			File file = new File(fileName); 
			result.addAll(getCandidateTuplesFromFile(file,resourceSet));
		}
		
		if (result.isEmpty()){
			return null;
		}
		return result;
	}	
	
	
}
