package fr.tpt.aadl.ramses.transformation.selection.sensitivity;

import java.util.ArrayList ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;
import java.util.Map.Entry ;

import org.eclipse.emf.ecore.EObject ;

import fr.openpeople.rdal2.model.rdal.Specification ;
import fr.tpt.aadl.ramses.transformation.selection.ITransformationSelection ;
import fr.tpt.aadl.ramses.transformation.selection.RuleApplicationUtils ;
import fr.tpt.aadl.ramses.transformation.selection.TupleEntry ;
import fr.tpt.aadl.ramses.transformation.selection.utils.SelectionAlgorithm ;
import fr.tpt.aadl.ramses.transformation.tip.ElementTransformation ;
import fr.tpt.aadl.ramses.transformation.tip.util.TipParser ;
import fr.tpt.aadl.ramses.transformation.tip.util.TipUtils ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;
import fr.tpt.aadl.ramses.transformation.trc.util.RuleApplicationTulpe ;
import fr.tpt.aadl.ramses.transformation.trc.util.TrcUtils ;
import fr.tpt.rdal.parser.RdalParser ;

public class SensitivityBasedSelection implements ITransformationSelection {

  
  private TrcSpecification trc;
  private Specification rdal ;
  
  public SensitivityBasedSelection(TrcSpecification trc,
                                   Specification rdalSpecification)
  {
    this.trc = trc;
    this.rdal = rdalSpecification;
  }
  
  public void selectTransformation (Map<List<EObject>, ArrayList<String>> patternMatchingMap, ArrayList<ElementTransformation> tuplesToApply) throws Exception
	{
		
		// for each key from the pattern matching map, execute the transformation selection algorithm
		Iterator<Entry<List<EObject>, ArrayList<String>>> patternMatchingIt = patternMatchingMap.entrySet().iterator();
			    
		// first, select transformation for element with a propagation constraint in the TRC.
		// from a transformation with dependencies, we retrieve the key in the pattern matching map
		// execute the selection algorithm for this object (key)
		// retrieve dependency objects
				
		List<List<RuleApplicationTulpe>> exclusionDependencies = new ArrayList<>();
		// add this object (and dependencies)
		List<List<EObject>> treatedObjects = new ArrayList<List<EObject>>();
		while (patternMatchingIt.hasNext()) 
		{
			Map.Entry<List<EObject>, ArrayList<String>> tuple = (Map.Entry<List<EObject>, ArrayList<String>>)patternMatchingIt.next();
			List<String> candidateTransformationList = tuple.getValue();
			List<EObject> candidateObjects = tuple.getKey();
			List<String> transformationsToApply = null; 
			if(candidateTransformationList.size()>1)
			{
				List<String> newCandidateTransformationList = new ArrayList<>();
				newCandidateTransformationList.addAll(tuple.getValue());
				for(List<RuleApplicationTulpe> toExcludeList: exclusionDependencies)
				{
					for(RuleApplicationTulpe toExclude: toExcludeList)
					{
						if(!containsAll(tuple.getKey(), toExclude.getPatternMatchedElement()))
							continue;
						for(String s: tuple.getValue())
						{
							if(s.equalsIgnoreCase(toExclude.getTransformationRuleName()))
							{
								newCandidateTransformationList.remove(s);
							}
						}
					}
					TupleEntry newTuple = new TupleEntry(tuple.getKey(), newCandidateTransformationList);
					if(((List<String>)newTuple.getValue()).size()>1)
					{
						// execute the best allocation selection algorithm
						transformationsToApply = selectBestTransformation(newTuple);
						break;
					}
					else if(((List<String>)newTuple.getValue()).size()==1)
					{
						transformationsToApply = (List<String>)newTuple.getValue();
						break;
					}
					else
					{
						continue;
					}
				}
				if(exclusionDependencies.isEmpty())
				{
					if(tuple.getValue().size()>1)
						transformationsToApply = selectBestTransformation(tuple);
					else
						transformationsToApply = (List<String>)tuple;
				}
				if(transformationsToApply == null)
					throw new Exception("Could not find transformation to apply after considering exclusions for" +
							tuple.getValue());
				}
			else
			{
				transformationsToApply = candidateTransformationList;
			}
			exclusionDependencies.addAll(TrcUtils.getExlcusionDependencies(trc,candidateObjects, transformationsToApply.get(0)));
			
			List<List<RuleApplicationTulpe>> inclusionDependencies = TrcUtils.getInclusionDependencies(trc,candidateObjects, transformationsToApply.get(0));
			if(inclusionDependencies.size()==0)
				continue;
			// possibleDependencies is returned under a disjunctive normal form
			// so options have to be considered in lists of combinations, and the choice
			// (selectBestTransformation) is made with 
			// execute the selection algorithm for dependencies
			RuleApplicationUtils.setTransformationToApply(tuple, transformationsToApply.get(0), tuplesToApply);
			
			treatedObjects.add(tuple.getKey());
			List<RuleApplicationTulpe> ruleApplicationList = selectBestTransformation(inclusionDependencies, new ArrayList<String>());
			for(RuleApplicationTulpe rat : ruleApplicationList)
			{
				if(transformationsToApply.get(0).equals(rat.getTransformationRuleName()))
					continue;
				Iterator<Entry<List<EObject>, ArrayList<String>>> patternMatchingItForDep = patternMatchingMap.entrySet().iterator();
				while(patternMatchingItForDep.hasNext())
				{
					Map.Entry<List<EObject>, ArrayList<String>> newTuple = (Map.Entry<List<EObject>, ArrayList<String>>) patternMatchingItForDep.next();
					if(containsAll(newTuple.getKey(), rat.getPatternMatchedElement())
							&& newTuple.getValue().contains(rat.getTransformationRuleName())
					  )
					{
						RuleApplicationUtils.setTransformationToApply(newTuple, rat.getTransformationRuleName(), tuplesToApply);
						treatedObjects.add(newTuple.getKey());
					}
				}
			}
					
		}
			
		patternMatchingIt = patternMatchingMap.entrySet().iterator();
		// second, select transformation for other elements
		while (patternMatchingIt.hasNext()) 
		{
			Map.Entry<List<EObject>, ArrayList<String>> tuple = (Map.Entry<List<EObject>, ArrayList<String>>)patternMatchingIt.next();
		    if(treatedObjects.contains(tuple.getKey()))
		       	continue;
		    if(tuple.getValue().size()<=1)
		       	continue;
		    System.out.println(tuple.getKey() + " = " + tuple.getValue());
			        
			        
		    //execute the best allocations selection algorithm        		
		    List<String> transformationsToApply = selectBestTransformation(tuple);
		    if(transformationsToApply.size()==1)
			{
				if(TipUtils.alreadyReferenced((List<EObject>) tuple.getKey(), tuplesToApply))
				  continue;
				RuleApplicationUtils.setTransformationToApply(tuple, transformationsToApply.get(0), tuplesToApply);
			}
			else
			{
				System.out.println("WARNING: Did not manage to select a transformation rule for :");
				for(EObject ne: tuple.getKey())
					System.out.println("\t "+ne);
			}
			patternMatchingIt.remove(); // avoids a ConcurrentModificationException
		}		
		
	}
	
	
	private boolean containsAll(List<EObject> key, List<EObject> patternMatchedElement) {
		for(EObject o: patternMatchedElement)
		{
			if(false == key.contains(o))
				return false;
		}
		return true;
	}
	
	private List<String> selectBestTransformation(Entry<List<EObject>, ArrayList<String>> tuple)
	{
		// get the sensitivities for a given element
		List<String> sensitivities = RdalParser.getSensitivitiesForDesignElement(rdal, tuple.getKey());

		if (TipUtils.getCurrentIteration()>1) {//if the iteration is not the first one 
			// get ignored transformations from the TIP
			ArrayList<String> ignoredTransformations = TipParser.getElementTransformationsHistory(tuple.getKey());

			return SelectionAlgorithm.findBestAllocationsWithSensitivitiesNext(trc,(ArrayList<String>) tuple.getValue(), sensitivities, ignoredTransformations);
		} else {//if it is the first iteration
			return SelectionAlgorithm.findBestAllocationsWithSensitivities(trc,(ArrayList<String>) tuple.getValue(), sensitivities);	        	
		}
	}


	private List<RuleApplicationTulpe> selectBestTransformation(
			List<List<RuleApplicationTulpe>> possibleDependencyList,
			List<String> ignoredTransformations) {

		List<String> sensitivities = new ArrayList<String>();
		List<String> candidates = new ArrayList<String>();
		for(List<RuleApplicationTulpe> alternativeTransformationList: possibleDependencyList)
		{
			for(RuleApplicationTulpe rat: alternativeTransformationList)
			{
				sensitivities.addAll(RdalParser.getSensitivitiesForDesignElement(rdal, rat.getPatternMatchedElement()));
				candidates.add(rat.getTransformationRuleName());
			}
		}
		List<String> selectedTransformations;
		if(candidates.size()==1)
			selectedTransformations = candidates;
		else
			selectedTransformations = SelectionAlgorithm.findBestAllocationsWithSensitivitiesNext(trc, candidates, sensitivities, ignoredTransformations);
		
		if(selectedTransformations.size()==1)
		{
			// return list of transformations containing the selected transfo
			for(List<RuleApplicationTulpe> alternativeTransformationList: possibleDependencyList)
			{
				for(RuleApplicationTulpe rat: alternativeTransformationList)
				{
					if(selectedTransformations.contains(rat.getTransformationRuleName()))
						return alternativeTransformationList;
				}
			}
		}
		else
		{
			List<List<RuleApplicationTulpe>> filteredAlternatives = new ArrayList<List<RuleApplicationTulpe>>();
			
			for(List<RuleApplicationTulpe> alternativeTransformationList: possibleDependencyList)
			{
				for(RuleApplicationTulpe rat: alternativeTransformationList)
				{
					if(selectedTransformations.contains(rat.getTransformationRuleName()))
					{
						filteredAlternatives.add(alternativeTransformationList);
						ignoredTransformations.add(rat.getTransformationRuleName());
					}
				}
			}
		}
		return null; // Should never reach this line
	}
}
