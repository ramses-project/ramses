package fr.tpt.aadl.ramses.transformation.selection.utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger ;
import org.eclipse.emf.ecore.EObject;

import fr.tpt.aadl.ramses.transformation.selection.sensitivity.SensitivityBasedSelection ;
import fr.tpt.aadl.ramses.transformation.tip.util.TipParser;
import fr.tpt.aadl.ramses.transformation.tip.TipSpecification;
import fr.tpt.aadl.ramses.transformation.trc.Module;
import fr.tpt.aadl.ramses.transformation.trc.Transformation;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification;
import fr.tpt.aadl.ramses.transformation.trc.util.TrcParser;
import fr.tpt.aadl.ramses.transformation.trc.util.TrcUtils ;

public class SelectionAlgorithm {
		
  private static Logger _LOGGER = Logger.getLogger(SelectionAlgorithm.class) ;
  
	/*	*//**
	 * Returns a list of transformation's identifiers of transformation rules that can applay to element of type Elem 
	 *
	 * @param availableTransformations	 transformations declared in the TRC document or a subset of these transformations
	 * @return       a list of transformation's identifiers corresponding to a given element 
	 *//*
	public List<String> findTransformationAlternativesFromTuples(){
		List<String> transformationsFound = new ArrayList<String>();
		
		Iterator<Transformation> it = getTrcSpecification().getTransformations().iterator(); 
		while (it.hasNext()){
			Transformation transformationObj = it.next();
			transformationsFound.add(transformationObj.getName());
			if (transformationObj.getElementType().equals(elementType)){
				transformationsFound.add(transformationObj.getId());
				// System.out.print(" "+transformationObj.getId());
			}
		}

		if (transformationsFound.size() > 0){
			return transformationsFound;
		} 
		return null;
	}*/

	
	/**
	 * Returns a list of transformation's identifiers of transformation rules that can applay to element of type Elem
	 * without considering sensitivities, transformations found are the best wrt QA, and equivalent with respect to other QAs 
	 *
	 * @param qaID	 quality attribute identifier
	 * @return       a list of transformations corresponding to a given element, considering given QA but not considering element's sensitivities
	 */
	public static List<String> findBestAllocations(final TrcSpecification trcSpec,
	                                               ArrayList<String> availableTransformationsIdList, final TrcSpecification trcSpecification, final String qaID){
/*		List<Transformation> transformationsAvailable = new ArrayList<Transformation>();
		
		Iterator availableTransformationIdsIt = availableTransformationsIdList.iterator();
		while (availableTransformationIdsIt.hasNext()){
			
			Transformation tr = TrcParser.getTransformationById(trcSpecification, availableTransformationIdsIt.next().toString());
			transformationsAvailable.add(tr);
			
		}*/
		
		List<String> transformationsNamesList = availableTransformationsIdList;//convertToTransformationsNameStrings(transformationsAvailable);
		
		// System.out.println("transformation strings before: "+transformationsList);
		Collections.sort(transformationsNamesList, new Comparator<String>(){
			public int compare(String s1, String s2) {
				
				Transformation t1 = TrcUtils.getTransformationById(trcSpec, s1);
				Transformation t2 = TrcUtils.getTransformationById(trcSpec, s2);
				
				Integer sensitivityValueT1 = TrcParser.getQualityImpactValue(t1, qaID);
				Integer sensitivityValueT2 = TrcParser.getQualityImpactValue(t2, qaID);

				// descending order sorting
				if (sensitivityValueT1 != null && sensitivityValueT2 != null) { 
					return sensitivityValueT2 - sensitivityValueT1;
				} else if (sensitivityValueT1 == null && sensitivityValueT2 != null) {
					return 1;					
				} else if (sensitivityValueT1 != null && sensitivityValueT2 == null) {
					return -1;					
				}
				return 0;
			}});
		// System.out.println("transformation strings after: "+transformationsList);

		return transformationsNamesList;
	}
	
	
	
	/**
	 * Returns a list of transformation's identifiers of transformation rules that can applay to element of type Elem
	 * considering element's sensitivities, transformations found are the best wrt QA, and equivalent with respect to other QAs 
	 *
	 * @param sensitivities	 quality attribute identifiers to which the element is sensitive (ordered by priority)
	 * @return      		 a list of transformation's identifiers corresponding to a given element, considering element's sensitivities
	 */
	public static List<String> findBestAllocationsWithSensitivities(TrcSpecification trcSpec,
	                                                                List<String> availableTransformationsIdList,  
	                                                                List<String> sensitivities){
		// create List of available transformations from Strings
		List<Transformation> transformationsAvailable = new ArrayList<Transformation>();
		Iterator<String> availableTransformationIdsIt = availableTransformationsIdList.iterator();
		_LOGGER.trace("Search best allocation among "+availableTransformationsIdList.size());
    while (availableTransformationIdsIt.hasNext()){
			Transformation tr = TrcUtils.getTransformationById(trcSpec, availableTransformationIdsIt.next().toString());
			if(tr!=null)
				transformationsAvailable.add(tr);
		}
    _LOGGER.trace("Found "+availableTransformationsIdList.size()+"equivalent transformations in TRC");
    
		// for each possible transformation create a list of values for the sensitivities it is 
		List<OrderedQualityImpact> transSensList = getTransformationOrderBySensitivities(transformationsAvailable, sensitivities);
		Collections.sort(transSensList, new Comparator<OrderedQualityImpact>(){
			public int compare(OrderedQualityImpact arg0, OrderedQualityImpact arg1) {
				for (int i=0; i< arg0.sensitivityValuesList.size(); i++){
					if (arg0.sensitivityValuesList.get(i) > arg1.sensitivityValuesList.get(i)) return -1;
					else if (arg0.sensitivityValuesList.get(i) < arg1.sensitivityValuesList.get(i)) return 1;
					else if ((arg0.sensitivityValuesList.get(i) == arg1.sensitivityValuesList.get(i)) && i == arg0.sensitivityValuesList.size()-1) return -1;
				}
				return 0;
			}
		});

		_LOGGER.trace("Ordered quality attributes " + transSensList.size());
		
		List<String> results = new ArrayList<String>();
		
		for (Iterator<OrderedQualityImpact> transSensIt = transSensList.iterator(); transSensIt.hasNext();){
			OrderedQualityImpact oqi = transSensIt.next();
			Transformation selectedTransfo = oqi.transformation;
			for(String availableTransfo: availableTransformationsIdList)
			{
				for(Module m: (List<Module>)selectedTransfo.getModules())
				{
					// look for module in selectd transfo
					String moduleName = m.getPath();
					moduleName = moduleName.substring(moduleName.lastIndexOf("/")+1, moduleName.length()-4);
					if(availableTransfo.startsWith(moduleName))
					{
						results.add(availableTransfo);
						return results;
					}
				}
				
			}

		}
		_LOGGER.error("Did not find transformation");
		return results;
	}

	/**
	 * Returns a list of objects containing transformation' identifier and list of values of the impacts for a list of sensitive QAs
	 *
	 * @param transformationsList     a list of id's of transformations available for an element
	 * @param sensitivitiesList	      a list of names of quality attributes, to which an element is sensitive
	 * @return         a list of OrderedQualityImpact objects
	 */
	private static List<OrderedQualityImpact> getTransformationOrderBySensitivities(List<Transformation> transformationsList, List<String> sensitivitiesList){
		List<OrderedQualityImpact> resultsList = new ArrayList<OrderedQualityImpact>();
		
		Iterator<Transformation> transformationIt = transformationsList.iterator();
		while(transformationIt.hasNext()){
			
			Transformation t = transformationIt.next();
			if(t.getRuleName()==null ||  t.getRuleName().isEmpty())
			{
				
				OrderedQualityImpact oqi = new OrderedQualityImpact(t);

				for (Iterator<String> sensIt = sensitivitiesList.iterator(); sensIt.hasNext();){
					oqi.sensitivityValuesList.add(TrcParser.getQualityImpactValue(t, sensIt.next()));
				}

				resultsList.add(oqi);

			}
			else
			{
				for(String ruleName: (List<String>) t.getRuleName())
				{
					OrderedQualityImpact oqi = new OrderedQualityImpact(t);

					for (Iterator<String> sensIt = sensitivitiesList.iterator(); sensIt.hasNext();){
						oqi.sensitivityValuesList.add(TrcParser.getQualityImpactValue(t, sensIt.next()));
					}

					resultsList.add(oqi);
				}
			}
		}
		
		return resultsList;
	}
	
/*	-----------------------------------------------------------------------------------------------
	Class to store the transformations and sorted quality impacts wrt given sensitivity priorities
    ----------------------------------------------------------------------------------------------- */
	static class OrderedQualityImpact {
		public Transformation transformation;
		public List<Integer> sensitivityValuesList;
	
		public OrderedQualityImpact(Transformation trans){
			this.transformation = trans;
			sensitivityValuesList = new ArrayList<Integer>();
		}
		
		public String toString(){
			return "transformationID = "+((Module)transformation.getModules().get(0)).getPath()+" impact values: "+sensitivityValuesList;
		}
	}
/*	----------------------------------------------------------------------------------------------- */
	
	
	
	/**
	 * Returns a list of transformation's identifiers of transformation rules that can applay to element of type Elem
	 * not considering element's sensitivities, but excluding some already tested transformations
	 * transformations found are the best wrt QA, and equivalent with respect to other QAs 
	 *
	 * @param qaID	   quality attribute identifier
	 * @param ignored  list of transformations to be ignored while best allocation selection
	 * @return         a list of transformations corresponding to a given element, considering given QA and element's sensitivities
	 */
	public static List<String> findBestAllocationsNext(TrcSpecification trcSpec,
	                                                   ArrayList<String> availableTransformationsIdList, TrcSpecification trcSpecification, String qaID, List<String> ignored){
		List<String> results = new ArrayList<String>();
		
		List<String> transformationsList = findBestAllocations(trcSpec,
		                                                       availableTransformationsIdList, trcSpecification, qaID);
		Iterator<String> it = transformationsList.iterator();
		while(it.hasNext()){
			String transformationId = it.next();
			if (!ignored.contains(transformationId))
				results.add(transformationId);
		}
		return results;
	}

	/**
	 * Returns a list of transformation's identifiers of transformation rules that can applay to element of type Elem
	 * considering element's sensitivities, but excluding some already tested transformations
	 * transformations found are the best wrt QA, and equivalent with respect to other QAs 
	 *
	 * @param availableTransformationsIdList	ArrayList with available transformations identifiers (qualified name)
	 * @param trcSpecification	    			TrcSpecification object
	 * @param sensitivities	    				List of quality attribute identifiers to which the element is sensitive
	 * @param ignored  							List of transformations identifiers (qualified name) to be ignored while best allocation selection
	 * @return         			a list of transformations corresponding to a given element, considering given QA and element's sensitivities
	 */
	public static List<String> findBestAllocationsWithSensitivitiesNext(TrcSpecification trcSpec,
	                                                                    List<String> availableTransformationsIdList, List<String> sensitivities, List<String> ignoredTransformationList){
		List<String> results = new ArrayList<String>();
		List<String> updatedAvailableTransformationsIdList = new ArrayList<String>();
		if(ignoredTransformationList!=null)
		{
			for(String s: availableTransformationsIdList)
			{
				if(!ignoredTransformationList.contains(s))
					updatedAvailableTransformationsIdList.add(s);
			}
		}
		else
			updatedAvailableTransformationsIdList.addAll(availableTransformationsIdList);
		List<String> transformationsList = findBestAllocationsWithSensitivities(trcSpec,
		                                                                        updatedAvailableTransformationsIdList, sensitivities);
		Iterator<String> it = transformationsList.iterator();
		while(it.hasNext()){
			String s = it.next();
			if(ignoredTransformationList == null || ignoredTransformationList.isEmpty())
				results.addAll(transformationsList);
			else if (!ignoredTransformationList.contains(s))
				results.add(s);
		}
		return results;
	}
	
	
	//-----------------------------------------------------
	/**
	 * Returns a list of transformation's identifiers of transformation rules that should be ignored in the next iteration planning
	 * for an element of a given id
	 *
	 * @param elementId	    		quality attribute identifiers to which the element is sensitive
	 * @return         				a list of transformations to be ignored
	 */
	public List<String> getIgnoredTransformations(TipSpecification tipSpecification, List<EObject> elementId){
		// use of method get all transformations for an element from previous iterations
		return TipParser.getElementTransformationsHistory(elementId);
	}
	
	

	public static List<String> convertToTransformationsNameStrings(List<Transformation> transformations){
		List<String> list = new ArrayList<String>();
		
		Iterator<Transformation> transIt = transformations.iterator();
		while(transIt.hasNext()){
			Transformation t = transIt.next();
			list.addAll(t.getRuleName());
		}
		return list;
	}
	
}
