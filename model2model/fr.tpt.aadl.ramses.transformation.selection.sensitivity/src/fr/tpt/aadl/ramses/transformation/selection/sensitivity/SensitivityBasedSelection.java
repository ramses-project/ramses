package fr.tpt.aadl.ramses.transformation.selection.sensitivity;

import java.io.FileInputStream ;
import java.io.IOException ;
import java.io.InputStream ;
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;
import java.util.Properties ;
import java.util.Map.Entry ;
import java.util.Set ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;

import fr.openpeople.rdal2.model.rdal.Specification ;
import fr.tpt.aadl.ramses.analysis.util.AnalysisUtils ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException ;
import fr.tpt.aadl.ramses.control.support.instantiation.ParseException ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;
import fr.tpt.aadl.ramses.control.workflow.AbstractLoop ;
import fr.tpt.aadl.ramses.control.workflow.ResolutionMethod ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPilot ;
import fr.tpt.aadl.ramses.generation.target.specific.AadlTargetSpecificGenerator ;
import fr.tpt.aadl.ramses.generation.target.specific.LoopManager ;
import fr.tpt.aadl.ramses.transformation.launcher.ArchitectureRefinementProcessLauncher ;
import fr.tpt.aadl.ramses.transformation.selection.ITransformationSelection ;
import fr.tpt.aadl.ramses.transformation.selection.RuleApplicationUtils ;
import fr.tpt.aadl.ramses.transformation.selection.TupleEntry ;
import fr.tpt.aadl.ramses.transformation.selection.utils.SelectionAlgorithm ;
import fr.tpt.aadl.ramses.transformation.tip.ElementTransformation ;
import fr.tpt.aadl.ramses.transformation.tip.util.TipParser ;
import fr.tpt.aadl.ramses.transformation.tip.util.TipUtils ;
import fr.tpt.aadl.ramses.transformation.trc.Transformation ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;
import fr.tpt.aadl.ramses.transformation.trc.util.RuleApplicationTulpe ;
import fr.tpt.aadl.ramses.transformation.trc.util.TrcParser ;
import fr.tpt.aadl.ramses.transformation.trc.util.TrcUtils ;
import fr.tpt.rdal.parser.RdalParser ;

public class SensitivityBasedSelection implements ITransformationSelection,LoopManager
{

  private static Logger _LOGGER = Logger.getLogger(SensitivityBasedSelection.class) ;
  
  private TrcSpecification trc;
  private Specification rdal ;
  
  private String currentQualityAttributeToImprove=null;
  private int maxSensitivities=0;
  
  AadlTargetSpecificGenerator generator;
  Resource currentImplResource;
  AbstractLoop l;
  AnalysisErrorReporterManager errManager;
  WorkflowPilot workflowPilot;
  RamsesConfiguration config;
  IProgressMonitor monitor;
  
  Properties prop;
  
  public SensitivityBasedSelection(AadlTargetSpecificGenerator generator,
                                   AbstractLoop l,
                                   AnalysisErrorReporterManager errManager,
                                   WorkflowPilot workflowPilot,
                                   RamsesConfiguration config,
                                   IProgressMonitor monitor)
  {
    this.generator = generator;
    
    String propertyFile = (String) config.getParameters().get(Names.RAMSES_PROPERTIES);
    
    prop = new Properties();
    try {
      InputStream in = new FileInputStream(propertyFile);
      prop.load(in);
    } catch (IOException e) {
      String message = "could not open property file "
          + propertyFile;
      _LOGGER.error(message);
      e.printStackTrace();
    }
    
    currentImplResource = generator.currentImplResource;
    
    ResourceSet rs = currentImplResource.getResourceSet();
    
    String trcPath = prop.getProperty("ArchitectureRefinementLauncher.trc");
    if(trcPath!=null)
      TrcParser.parse(trcPath, rs);
    
    String rdalPath = prop.getProperty("ArchitectureRefinementLauncher.rdal");
    if(trcPath!=null)
      RdalParser.parse(rdalPath, rs);
        
    List<Transformation> list = l.getTransformations();
    Resource r = list.get(0).eResource();
    trc = (TrcSpecification) r.getContents().get(0);
    EObject obj = workflowPilot.getWokflowRoot().getRequirementsRoot();
    rdal = (Specification) obj;
    
  }
  
  @Override
  public String getResolutionMethodName()
  {
    return ResolutionMethod.SENSITIVITY_MERGE.getName() ;
  }

  @Override
  public Map<? extends String, ? extends Resource> processLoop() throws AnalysisException, ParseException, TransformationException, ConfigurationException, IOException
  {
    
    Map<String, Resource> resultingMap = new HashMap<String, Resource>();
    
    ArchitectureRefinementProcessLauncher mergeLauncher = new ArchitectureRefinementProcessLauncher
        (trc,
         this.currentImplResource.getResourceSet(),
         config,
         this,
         prop,
         l.getTransformations(),
         generator._modelInstantiator,
         generator._predefinedResourceManager
         );
    
    SystemInstance sinst = (SystemInstance) this.currentImplResource.getContents().get(0);
    generator.loopIteration=0;
    boolean loopAnalysis = false;
    while(!loopAnalysis)
    {
      generator.loopIteration++;
      Resource result = mergeLauncher.launch(sinst, workflowPilot.getOutputModelId(), l.getIterationNb());
      if(result==null)
        break;
      String modelIdSuffix = "_iter_"+generator.loopIteration;
      resultingMap.put(workflowPilot.getOutputModelId()+modelIdSuffix, result);
      loopAnalysis = generator.isValidLoopIteration(l.getAnalysis(), errManager, workflowPilot, config, workflowPilot.getOutputModelId(), modelIdSuffix, monitor);
    }
    return resultingMap;
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
      }
    }
    
    @Override
    public boolean shouldSelectionContinue()
    {
      // check if we reached a decision already tried
      if(false==TipUtils.isLastIterationDifferent(currentQualityAttributeToImprove))
      {
        String message = "Exploration of possible solutions stopped because " +
            "the exploration algorithm reached a state that was already considered " +
            "(it would have looped indefinitly if not stopped).\n";
        message+="Reasons could be:\n";
        message+="\t 1 - the problem cannot satified;\n";
        message+="\tor\n";
        message+="\t 2 - analysis results provided were not sufficient " +
            "to discriminate potential solutions;\n";
        _LOGGER.error(message);
        ServiceProvider.SYS_ERR_REP.error(message, false);
        return false;
      }
      return true;
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
        {
          currentQualityAttributeToImprove=AnalysisUtils.getLeastSatisfiedQualityAttribute();
          if(currentQualityAttributeToImprove==null)
          {
            _LOGGER.error("Analysis results provide insufficient information (Quantitative information)" +
                " to continue the transformation selection process", new Exception());
          }
          TipUtils.addExperimentedDirection(currentQualityAttributeToImprove);
        }
        // we search elements for which currentQualityAttributeToImprove is sensitivity of rank "level"
        int level=1;
        Iterator<Entry<List<EObject>, ArrayList<String>>> patternMatchingIt = patternMatchingMap.entrySet().iterator();
        List<EObject> elementToModify = null;
        double worst = 1;
        
        List<String> transformationsWithUpdatedSensitivities=null;
        
        while (patternMatchingIt.hasNext()) 
        {
          Map.Entry<List<EObject>, ArrayList<String>> tuple = (Map.Entry<List<EObject>, ArrayList<String>>) patternMatchingIt.next();
          if(tuple.getValue().size()==1)
            continue;
          List<String> sensitivities = RdalParser.getSensitivitiesForDesignElement(rdal, tuple.getKey());
          double res = AnalysisUtils.getWorstMarginFor(tuple.getKey(), currentQualityAttributeToImprove);
          while(level<maxSensitivities)
          {
            if(sensitivities.size()>level &&
                sensitivities.get(level).equals(currentQualityAttributeToImprove) && res<worst)
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
              {
                elementToModify = tuple.getKey();
              }
            }
            level++;
          }
          if(elementToModify==null
              && false==sensitivities.contains(currentQualityAttributeToImprove) && (res==2||res<worst))
            // we search elements for which currentQualityAttributeToImprove
            // is not a sensitivity AND transformation previously executed is not
            // the one we would select now.
          {
            // get ignored transformations from the TIP
            ArrayList<String> appliedTransformations = TipParser.getElementTransformationsHistory(tuple.getKey());
            if(appliedTransformations==null)
              continue;
            // select a transformation with updated sensitivities, and with ignored transformations in parameters
            List<String> updatedSensitivities = promoteSensitivities(sensitivities, invalidatedAnalysisList);
            transformationsWithUpdatedSensitivities = 
                SelectionAlgorithm.findBestAllocationsWithSensitivities(trc,
                                                                            (ArrayList<String>) tuple.getValue(), 
                                                                            updatedSensitivities);
            if(false==transformationsWithUpdatedSensitivities.isEmpty()
                && transformationsWithUpdatedSensitivities.get(0)!=appliedTransformations.get(0))
            {
              elementToModify = tuple.getKey();
              break;
            }
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
    sensitivitiesCopy.addAll(invalidatedAnalysisList);
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
