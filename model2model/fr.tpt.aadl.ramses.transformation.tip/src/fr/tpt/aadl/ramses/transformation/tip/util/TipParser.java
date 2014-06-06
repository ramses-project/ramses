package fr.tpt.aadl.ramses.transformation.tip.util;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import fr.tpt.aadl.ramses.transformation.tip.ElementTransformation;
import fr.tpt.aadl.ramses.transformation.tip.Iteration;
import fr.tpt.aadl.ramses.transformation.tip.TipPackage;
import fr.tpt.aadl.ramses.transformation.tip.TipSpecification;

public class TipParser {

	/**
	 * Returns a TipSpecification from a given TIP
	 * 
	 * @param tipPath
	 *            String representing the path of the TIP artifact
	 * @return TipSpecification object of parsed TIP artifact
	 */
	public static TipSpecification parse(String tipPath,
	                                     ResourceSet resourceSet){

		final Resource resource;
	
		URI p_uri = URI.createFileURI(tipPath);
		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("tip", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put("http://fr.tpt.aadl.ramses.transformation/TIP/1.0", TipPackage.eINSTANCE);
		
		if (resourceSet.getURIConverter().exists(p_uri, null)) {
			resource = resourceSet.getResource(p_uri, true);			
			//resource = getResourceSet().createResource(URI.createURI(tipPath));
			return (TipSpecification) resource.getContents().get(0);	
		} else {
			System.out.println("TIP of specified path ("+tipPath+") does not exit.");
		}
		
		return null;	
	}
	
	
	/**
	 * Returns an int value of the last iteration id
	 * 
	 * @param specification
	 *            TipSpecification object obtained as the result of TIP parsing
	 * @return integer value of id of the last iteration
	 */
	public static int getLastIterationId(){
		TipSpecification specification = TipUtils.getTipSpecification();
		if(specification.getIterations().size()==0)
			return 0;
		else
		{
			int lastIndex = specification.getIterations().size()-1;
			Iteration iteration = (Iteration) specification.getIterations().get(lastIndex);
			return iteration.getId();
		}
	}
	
	
	
	/**
	 * Returns a list of transformation's identifiers of transformation rules
	 * that were applied to element of a given ID
	 * 
	 * @param specification
	 *            TipSpecification object obtained as the result of TIP parsing
	 * @param list
	 *            String representing a element identifier
	 * @return a list of transformations identifier that were applied to an
	 *         element in all the iterations
	 */
	public static ArrayList<String> getElementTransformationsHistory(List<EObject> matchedElementList) {
		TipSpecification specification = TipUtils.getTipSpecification();
		ArrayList<String> results = new ArrayList<String>();
		
		Iterator<Iteration> iterationsIt = specification.getIterations().iterator();
		while(iterationsIt.hasNext()){
			Iteration iterationObject = iterationsIt.next();
			List<ElementTransformation> elemTransformationsList = iterationObject.getElements();
			Iterator<ElementTransformation> elemTransformationsIt = elemTransformationsList.iterator();
			while(elemTransformationsIt.hasNext()){
				ElementTransformation etObject = elemTransformationsIt.next();
				if(etObject.isIsExclusion())
					continue;
				List<EObject> previouslyMatchedList = etObject.getElementId();
				if(previouslyMatchedList.size()!=matchedElementList.size())
					continue;
				boolean toContinue = true;
				for(EObject previouslyMatched: previouslyMatchedList)
				{
					for(EObject matchedElement: matchedElementList)
					{
						if (!previouslyMatched.equals(matchedElement)){
							toContinue = false;
							break;
						}
						else
						  break;
					}
					if(!toContinue)
						break;
					results.add(etObject.getTransformationId());
				}
			}
		}
		
		if (results.size()>0) return results; 
		return null;
	}

	/**
	 * Returns Iteration object of a given id
	 * 
	 * @param specification
	 *            TipSpecification object obtained as the result of TIP parsing
	 * @param iterationId
	 *            String representing the iteration identifier
	 * @return Iteration object
	 */
	public static Iteration getIterationById(TipSpecification specification, int iterationId){
		Iterator iterationsIt = specification.getIterations().iterator();
		while (iterationsIt.hasNext()){
			Iteration iterationObject = (Iteration)iterationsIt.next();
			if (iterationObject.getId() == iterationId){
				return iterationObject;
			}
		}
		return null;
	}

	/**
	 * Returns Iteration object for last defined iteration
	 * 
	 * @param specification
	 *            TipSpecification object obtained as the result of TIP parsing
	 * @return Iteration object
	 */
	public Iteration getLastIteration(TipSpecification specification){
		int lastIndex = specification.getIterations().size()-1;
		return (Iteration) specification.getIterations().get(lastIndex);
	}
	
	
}
