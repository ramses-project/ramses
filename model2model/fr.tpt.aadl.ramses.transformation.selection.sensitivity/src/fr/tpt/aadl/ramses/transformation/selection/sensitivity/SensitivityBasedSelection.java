package fr.tpt.aadl.ramses.transformation.selection.sensitivity;

import java.util.ArrayList ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;
import java.util.Map.Entry ;
import java.util.Set ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.ecore.EObject ;

import fr.openpeople.rdal2.model.rdal.Specification ;
import fr.tpt.aadl.ramses.analysis.AnalysisResult ;
import fr.tpt.aadl.ramses.analysis.util.AnalysisUtils ;
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

  private static Logger _LOGGER = Logger.getLogger(SensitivityBasedSelection.class) ;
  
  private TrcSpecification trc;
  private Specification rdal ;
  
  private String currentQualityAttributeToImprove=null;
  private int maxSensitivities=0;
  
  public SensitivityBasedSelection(TrcSpecification trc,
                                   Specification rdalSpecification)
  {
    this.trc = trc;
    this.rdal = rdalSpecification;
  }
  
  
  
    public void selectTransformation (Map<List<EObject>, ArrayList<String>> patternMatchingMap, ArrayList<ElementTransformation> tuplesToApply)
    {
      if (TipUtils.getCurrentIteration()==1) {//if the iteration is not the first one
        selectTransformationFirst(patternMatchingMap, tuplesToApply);
      }
      else
      {
        updateSensitivitiesWithAnalysisResults(patternMatchingMap);
        // eliminate selected tuples from patternMatchingMap
        selectTransformationFirst(patternMatchingMap, tuplesToApply);
        // check if we reached a decision already tried
        
      }
    }
    
    private void updateSensitivitiesWithAnalysisResults(Map<List<EObject>, ArrayList<String>> patternMatchingMap)
    {
      // get analysis results and check if it violates a requirement
      Set<String> invalidatedAnalysisList = AnalysisUtils.getInvalidatedResults();

      // if it does, we promote the sensitivity on one element to this requirement
      if(false == invalidatedAnalysisList.isEmpty())
      {
        if(currentQualityAttributeToImprove==null
            || !invalidatedAnalysisList.contains(currentQualityAttributeToImprove))
          currentQualityAttributeToImprove=AnalysisUtils.getLeastSatisfiedQualityAttribute();
        
        // we search elements for which currentQualityAttributeToImprove is sensitivity of rank "level"
        int level=1;
        Iterator<Entry<List<EObject>, ArrayList<String>>> patternMatchingIt = patternMatchingMap.entrySet().iterator();
        List<EObject> elementToModify = null;
        float worst = 1;
        
        List<String> transformationsWithUpdatedSensitivities=null;
        Map.Entry<List<EObject>, ArrayList<String>> tupleWithUpdatedSensitivities=null;
        
        while (patternMatchingIt.hasNext()) 
        {
          Map.Entry<List<EObject>, ArrayList<String>> tuple = (Map.Entry<List<EObject>, ArrayList<String>>) patternMatchingIt.next();
          List<String> sensitivities = RdalParser.getSensitivitiesForDesignElement(rdal, tuple.getKey());
          float res = AnalysisUtils.getMarginFor(tuple.getKey(), currentQualityAttributeToImprove);
          while(level<maxSensitivities)
          {
            if(sensitivities.size()>level &&
                sensitivities.get(level).equals(currentQualityAttributeToImprove) && res<worst)
            {
              elementToModify = tuple.getKey();
              // get ignored transformations from the TIP
              ArrayList<String> ignoredTransformations = TipParser.getElementTransformationsHistory(tuple.getKey());

              // select a transformation with updated sensitivities, and with ignored transformations in parameters
              List<String> updatedSensitivities = promoteSensitivities(sensitivities, invalidatedAnalysisList);
              transformationsWithUpdatedSensitivities = 
                  SelectionAlgorithm.findBestAllocationsWithSensitivitiesNext(trc,
                                                                              (ArrayList<String>) tuple.getValue(), 
                                                                              updatedSensitivities, 
                                                                              ignoredTransformations);
              tupleWithUpdatedSensitivities=tuple;
              level++;
            }
          }
          if(elementToModify==null
              && false==sensitivities.contains(currentQualityAttributeToImprove) && res<worst)
            // we search elements for which currentQualityAttributeToImprove
            // is not a sensitivity AND transformation previously executed is not
            // the one we would select now.
          {
            // get ignored transformations from the TIP
            ArrayList<String> appliedTransformations = TipParser.getElementTransformationsHistory(tuple.getKey());

            // select a transformation with updated sensitivities, and with ignored transformations in parameters
            List<String> updatedSensitivities = promoteSensitivities(sensitivities, invalidatedAnalysisList);
            transformationsWithUpdatedSensitivities = 
                SelectionAlgorithm.findBestAllocationsWithSensitivities(trc,
                                                                            (ArrayList<String>) tuple.getValue(), 
                                                                            updatedSensitivities);
            if(false==transformationsWithUpdatedSensitivities.isEmpty()
                && transformationsWithUpdatedSensitivities.get(0)!=appliedTransformations.get(0))
            
              elementToModify = tuple.getKey();
            tupleWithUpdatedSensitivities=tuple;
            
          }
        }
        if(elementToModify==null)
        {
          String message = "No new candidate transformation found for elements with worst analysis results";
          _LOGGER.error(message);
        }
        else
        {
          // We just need to update sensitivities in rdal model
          RdalParser.promoteSensitivity(rdal,
                                        elementToModify,
                                        currentQualityAttributeToImprove);
          
        } 
        
      }
      else
      {
        _LOGGER.error("Selection process is iterating but analysis results are ok...");
        return;
      }
    }



  private void selectTransformationFirst (Map<List<EObject>, ArrayList<String>> patternMatchingMap, ArrayList<ElementTransformation> tuplesToApply)
	{
		
    _LOGGER.trace("Selection started: "+ patternMatchingMap.keySet().size() +" decisions to take");
    
		// for each key from the pattern matching map, execute the transformation selection algorithm
		Iterator<Entry<List<EObject>, ArrayList<String>>> patternMatchingIt = patternMatchingMap.entrySet().iterator();
			    
		// first, select transformation for element with a propagation constraint in the TRC.
		// from a transformation with dependencies, we retrieve the key in the pattern matching map
		// execute the selection algorithm for this object (key)
		// retrieve dependency objects
				
		List<List<RuleApplicationTulpe>> exclusionDependencies = new ArrayList<List<RuleApplicationTulpe>>();
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
			  _LOGGER.trace("need to proceed to selection, exclusions nb="+exclusionDependencies.size());
				ArrayList<String> newCandidateTransformationList = new ArrayList<String>();
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
					TupleEntry<List<EObject>, ArrayList<String>> newTuple = new TupleEntry<List<EObject>, ArrayList<String>>(tuple.getKey(), newCandidateTransformationList);
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
				  _LOGGER.trace("Without exclusion to consider, start selection");
				  transformationsToApply = selectBestTransformation(tuple);
				}
				if(transformationsToApply == null)
				{
				  String message = "Could not find transformation " +
				      "to apply after considering exclusions for" +
              tuple.getValue();
				  _LOGGER.fatal(message);
				}
			}
			else
			{
				transformationsToApply = candidateTransformationList;
			}
			
			_LOGGER.trace("Selected: "+transformationsToApply.get(0));
			
			exclusionDependencies.addAll(TrcUtils.getExlcusionDependencies(trc,candidateObjects, transformationsToApply.get(0)));
			_LOGGER.trace("Dependencies to exclude: "+exclusionDependencies.size());
			
			List<List<RuleApplicationTulpe>> inclusionDependencies = TrcUtils.getInclusionDependencies(trc,candidateObjects, transformationsToApply.get(0));
			_LOGGER.trace("Dependencies to include: "+inclusionDependencies.size());
			
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
		
		_LOGGER.trace("Selection with dependency propagation finished");
		
		patternMatchingIt = patternMatchingMap.entrySet().iterator();
		// second, select transformation for other elements
		while (patternMatchingIt.hasNext()) 
		{
		  Map.Entry<List<EObject>, ArrayList<String>> tuple = (Map.Entry<List<EObject>, ArrayList<String>>)patternMatchingIt.next();
		  if(treatedObjects.contains(tuple.getKey()))
		    continue;
		  if(tuple.getValue().size()<=1)
		    continue;
		  _LOGGER.trace(tuple.getKey() + " = " + tuple.getValue());


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
		    String message = "Did not manage to select a transformation Elements for :"; 
		    for(EObject ne: tuple.getKey())
		      message+=ne;
		    _LOGGER.warn(message);
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
	
	private List<String> promoteSensitivities(List<String> existingSensitivities, Set<String> invalidatedAnalysisList)
	{
	  List<String> updatedSensitivities = new ArrayList<String>();
    
	  List<String> sensitivitiesCopy =  new ArrayList<String>();
    sensitivitiesCopy.addAll(existingSensitivities);
    for(String invalidatedAnalysis: invalidatedAnalysisList)
    {
      for(String s: existingSensitivities)
      {
        if(s.equalsIgnoreCase(invalidatedAnalysis))
        {
          updatedSensitivities.add(s);
          sensitivitiesCopy.remove(s);
        }
      }
      if(false == sensitivitiesCopy.isEmpty())
        updatedSensitivities.addAll(sensitivitiesCopy);
    }
    return updatedSensitivities;
	}
	
	private List<String> selectBestTransformation(Entry<List<EObject>, ArrayList<String>> tuple)
	{
	  // get the sensitivities for a given element
	  List<String> sensitivities = RdalParser.getSensitivitiesForDesignElement(rdal, tuple.getKey());
	  if(sensitivities.size()>maxSensitivities)
	    maxSensitivities=sensitivities.size();
	  return SelectionAlgorithm.findBestAllocationsWithSensitivities(trc,(ArrayList<String>) tuple.getValue(), sensitivities);

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
