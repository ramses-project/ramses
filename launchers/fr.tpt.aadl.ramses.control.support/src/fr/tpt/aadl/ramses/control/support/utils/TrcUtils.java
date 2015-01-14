package fr.tpt.aadl.ramses.control.support.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EEnumLiteral;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EParameter;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.ocl.Environment;
import org.eclipse.ocl.ParserException;
import org.eclipse.ocl.Query;
import org.eclipse.ocl.ecore.CallOperationAction;
import org.eclipse.ocl.ecore.Constraint;
import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
import org.eclipse.ocl.ecore.OCL;
import org.eclipse.ocl.ecore.OCL.Helper;
import org.eclipse.ocl.ecore.SendSignalAction;
import org.eclipse.ocl.expressions.ExpressionsFactory;
import org.eclipse.ocl.expressions.OCLExpression;
import org.eclipse.ocl.expressions.Variable;
import org.eclipse.ocl.util.Bag;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.Aadl2Package;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.InstanceObject;
import org.osate.aadl2.instance.InstancePackage;
import org.osate.aadl2.instance.SystemInstance;

import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.transformation.trc.AbstractRuleDependency;
import fr.tpt.aadl.ramses.transformation.trc.Module;
import fr.tpt.aadl.ramses.transformation.trc.RuleDependency;
import fr.tpt.aadl.ramses.transformation.trc.RuleDependencyConjunction;
import fr.tpt.aadl.ramses.transformation.trc.RuleDependencyDisjunction;
import fr.tpt.aadl.ramses.transformation.trc.Transformation;
import fr.tpt.aadl.ramses.transformation.trc.TransformationDependency;
import fr.tpt.aadl.ramses.transformation.trc.TransformationImpact;
import fr.tpt.aadl.ramses.transformation.trc.TrcFactory;
import fr.tpt.aadl.ramses.transformation.trc.TrcPackage;
import fr.tpt.aadl.ramses.transformation.trc.TrcRule;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification;
import fr.tpt.aadl.ramses.transformation.trc.util.RuleApplicationTuple ;
import fr.tpt.aadl.ramses.transformation.trc.util.TaggedRuleApplicationTuple ;
import fr.tpt.aadl.ramses.transformation.trc.util.TrcParser ;

public class TrcUtils {

	
	private static Logger _LOGGER = Logger.getLogger(TrcUtils.class) ;
  
	
	/**
	 * Creates a new TRC artifact of a specified path and version 
	 *
	 * @param trcPath   	String representing the artifact path
	 * @param trcVersion	String representing the artifact version
	 */
	public static void createNewTRC(String trcPath,
	                                ResourceSet resourceSet,
	                                String trcVersion){
		
		TrcSpecification spec = TrcFactory.eINSTANCE.createTrcSpecification();
		
		URI trc_uri = URI.createFileURI(trcPath);

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("trc", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put("http://fr.tpt.aadl.ramses.transformation/TRC/1.0", TrcPackage.eINSTANCE);

		if (!resourceSet.getURIConverter().exists(trc_uri, null)){
			Resource resource = resourceSet.createResource(trc_uri);
			//getResource(trcPath).getContents().add(spec);
			saveTrc(resource, spec);
		} else {
			System.out.println("TRC artifact of the specified path: "+trcPath+" already exists.");
		}		
	}
	
	/**
	 * Adds a transformation to TRC artifact of specified path 
	 *
	 * @param trcPath   			String representing the artifact path
	 * @param transformationName   	String representing transformation's name
	 * @param transformationFile   	String representing transformation's location (.atl transformation)
	 */
	public static void addTransformationToTrc(String trcPath,
	                                     ResourceSet resourceSet,
	                                     String transformationName, 
	                                     List<String> transformationFile){

		TrcSpecification specification = TrcParser.parse(trcPath, resourceSet);

		Transformation t = TrcFactory.eINSTANCE.createTransformation();
		for(String path : transformationFile)
		{
			Module m = TrcFactory.eINSTANCE.createModule();
			m.setPath(path);
			t.getModules().add(m);
		}
		t.getRuleName().add(transformationName);
		boolean toBeAdded = true;
		
		EList<Transformation> existingTransformationsList = specification.getTransformationList().getTransformations();
		Iterator<Transformation> existingTransformationsIt = existingTransformationsList.iterator();
		while(existingTransformationsIt.hasNext()){
			Transformation tObj = existingTransformationsIt.next();
			for(String ruleName:(List<String>)tObj.getRuleName())
			{
				if (ruleName.equals(transformationName)){
					System.out.println("Transformation of the following name: "+transformationName+" already exists in the TRC.");
					toBeAdded = false;
					break;
				}
			}
			if(!toBeAdded)
				break;
		}
		
		if (toBeAdded){
			specification.getTransformationList().getTransformations().add(t);
			saveTrc(getResource(trcPath, resourceSet), specification);			
		}
	}
	
	/**
	 * Adds a transformation to TRC artifact of specified path 
	 *
	 * @param trcPath   			String representing the artifact path
	 * @param transformationId   	String representing transformation's id
	 * @param qualityAttribute   	String representing the quality attribute name/identifier
	 * @param impactValue   		Integer value representing the impact from -5 to 5
	 */
	public static void addQualityImpactForTransformation(String trcPath,
	                                                     ResourceSet resourceSet,
	                                                     TrcRule transformationId, 
	                                                     String qualityAttribute, 
	                                                     int impactValue){

		TrcSpecification specification = TrcParser.parse(trcPath,
		                                                 resourceSet);
		
		TransformationImpact impact = TrcFactory.eINSTANCE.createTransformationImpact();
		impact.setQualityAttributeName(qualityAttribute);
		impact.setImpactValue(impactValue);
		
		Transformation t = getTransformationById(specification, transformationId);
		t.getImpacts().add(impact);
		
		saveTrc(getResource(trcPath, resourceSet), specification);
	}

	/**
	 * Adds a transformation to TRC artifact of specified path 
	 *
	 * @param trcPath   			String representing the artifact path
	 * @param transformationId   	String representing transformation's id
	 * @param qualityImpactMap   	Map containing quality attributes as key and their impact value
	 */
	public static void addQualityImpactsForTransformation(String trcPath,
	                                                      ResourceSet resourceSet,
	                                                      TrcRule transformationId, 
	                                                      Map<String, Integer> qualityImpactMap){

	  TrcSpecification specification = TrcParser.parse(trcPath,resourceSet);
	  Transformation t = getTransformationById(specification, transformationId);
	  t.getImpacts().clear();

	  Iterator<Entry<String, Integer>> it = qualityImpactMap.entrySet().iterator();
	  while (it.hasNext()) {
	    Map.Entry<String, Integer> entry = it.next();
	    TransformationImpact impact = TrcFactory.eINSTANCE.createTransformationImpact();

	    impact.setQualityAttributeName(entry.getKey());
	    impact.setImpactValue(new Integer(entry.getValue().toString()).intValue());

	    t.getImpacts().add(impact);
	  }

	  saveTrc(getResource(trcPath, resourceSet), specification);
	}
	
	/**
	 * Saves the given specification at the resource location 
	 *
	 * @param resource   	Resource object associated with the specific disk location
	 * @param specification	TrcSpecification object to be saved
	 */
	private static void saveTrc(Resource resource, TrcSpecification specification){
		resource.unload();
		resource.getContents().add(specification);
		
		try {
			resource.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Returns a Resource object for a file of a given location 
	 *
	 * @param trcPath   String representing a element type
	 * @return     		Resource object 
	 */
	protected static Resource getResource(String trcPath,
	                                      ResourceSet resourceSet){
		URI p_uri = URI.createFileURI(trcPath);

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("trc", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put("http://fr.tpt.aadl.ramses.transformation/TRC/1.0", TrcPackage.eINSTANCE);
		
		Resource resource = resourceSet.getResource(p_uri, true);

		return resource;
	}

	
	public static Transformation getTransformationById(TrcSpecification specification,
                                                     TrcRule transformationRule){
	  String transformationId = transformationRule.getQualifiedName();
    Iterator<Transformation> transformationsIt = specification.getTransformationList().getTransformations().iterator();
    while (transformationsIt.hasNext()){
      Transformation transformation = transformationsIt.next();
      for(Module module: (List<Module>)transformation.getModules())
      {
        String moduleName = module.getName().replaceFirst(".atl", "");
        moduleName = moduleName.substring(moduleName.lastIndexOf('/')+1);
        if(transformation.getRuleName()==null || 
            transformation.getRuleName().isEmpty())
        {
          if(transformationId.contains("."))
          {
            if(transformationId.substring(0, transformationId.lastIndexOf('.')).equals(moduleName))
              return transformation;
          }
          else
            if(transformationId.equals(moduleName))
              return transformation;
        }
        else
        {
          for(String ruleName:(List<String>)transformation.getRuleName())
          {
            String qualifiedTransformationName = moduleName+"."+ruleName;
            
            if (qualifiedTransformationName.equals(transformationId)){
              return transformation;
            }
          }
        }
      }
    }
    
    System.out.println("WARNING: in TRC, no value provided for rule:\n\t "+transformationId);
    
    
    return null;
  }
  
  
  public static Transformation getTransformationByName(TrcSpecification specification, String transformationName){
    Iterator<Transformation> transformationsIt = specification.getTransformationList().getTransformations().iterator();
    while (transformationsIt.hasNext()){
      Transformation transformation = transformationsIt.next();
      for(String ruleName:(List<String>)transformation.getRuleName())
      {
        if (ruleName.equals(transformationName))
          return transformation;
      }
    }
    return null;
  }
	
	public static List<Module> 
	  buildVerticalDependencyList(List<Transformation> inputTransformationList)
	{
		ArrayList<Module> result = new ArrayList<Module>();
		Transformation T0 = inputTransformationList.get(0);
		result.addAll(T0.getModules());
		for(int i=1;i<inputTransformationList.size();i++)
		{
			Transformation Ti = inputTransformationList.get(i);
			Module lastInserted=null; // lastInserted
			for(int j=Ti.getModules().size()-1;j>=0;j--)
			{
				Module Mj=(Module)Ti.getModules().get(j);
				if(result.contains(Mj))
					continue;
				else if(lastInserted==null)
				{
					lastInserted = Mj;
					if(j==Ti.getModules().size()-1)
					{
						result.add(lastInserted);
					}
					else if(j==0)
					{
						ArrayList<Module> local = new ArrayList<Module>();
						local.add(lastInserted);
						local.addAll(result);
						result = local;
					}
					else
					{
						int toIndex = result.indexOf(Ti.getModules().get(j+1));
						List<Module> lhs = result.subList(0, toIndex-1);
						lhs.add(lastInserted);
						List<Module> rhs = result.subList(toIndex, result.size());
						result = new ArrayList<Module>();
						lhs.addAll(rhs);
						result.addAll(lhs);
					}
					
				}
				else
				{
					// Modules are stored as follows:
					// M0 depends on M_1 depends on M_2 ------ depends on M_N.
					
					// check that none of the dependency of Mj are
					// inserted as a subdependency of the current position
					// in the result list
					// Ti Modules:
					// [---------------M---------D1-------]
					// Result Module list:
					// [----D1--------------M-------------]
					// such situation is hazardeous
					/*
					for(int k=0;k<result.indexOf(lastInserted);k++)
					{
						int indexOfMjInTi = Ti.getModules().indexOf(lastInserted);
						List<Module> subMi=Ti.getModules().subList(indexOfMjInTi, Ti.getModules().size()-1);
						if(subMi.contains(result.get(k)))
						{
							System.out.println("ERROR: cyclic dependency found ");
							System.out.println("\t "+lastInserted.getPath());
						}
					}
					*/
					// insert Mj in result, just before lastInserted.
					List<Module> lhs;
					if(result.indexOf(lastInserted)==0)
					{
						lhs = new ArrayList<Module>();
					}
					else
						lhs = result.subList(0, result.indexOf(lastInserted));
					ArrayList<Module> local = new ArrayList<Module>();
					local.addAll(result);
					List<Module> rhs = local.subList(result.indexOf(lastInserted), result.size());
					lhs.add(Mj);
					result = new ArrayList<Module>();
					result.addAll(lhs);
					result.addAll(rhs);
				}
			}
		}
		return result;
	}
	
	/**
   *  Returns the list of RuleApplication (tuples <Elements,Rule>) that could
   *  be selected when the tuple <candidateObjects, appliedRule> is 
   *  selected
   *  
   * @param trcSpecification the TRC
   * @param candidateObjects EObjects to be transformed by appliedRule 
   * @param appliedRule selected transformation rule
   * @return the list of RuleApplication (tuples <Elements,Rule>) that could
   *  be excluded
   */
	public static List<List<RuleApplicationTuple>> getInclusionDependencies(TrcSpecification spec,
	                                                                        List<EObject> eObjList,
	                                                                        TrcRule appliedRule)
	{
		List<List<RuleApplicationTuple>> result = new ArrayList<List<RuleApplicationTuple>>();
		for(TransformationDependency dep: (List<TransformationDependency>) spec.getDependencyList().getTransformationDependencies())
		{
			if(false==dep.getAppliedRule().equals(appliedRule))
				continue;
			_LOGGER.trace("Search dependency for "+appliedRule);
			List<RuleApplicationTuple> localDependencyList = new ArrayList<RuleApplicationTuple>();
			result.add(localDependencyList);
			for(AbstractRuleDependency req: (List<AbstractRuleDependency>) dep.getRequiredTransformations())
			{
				getRestrictedPossibleDependencies(req, eObjList, localDependencyList, result, false);
			}
		}
		if(result.isEmpty())
		  _LOGGER.trace("No dependency found for "+appliedRule);
		return result;
	}
	
	
	/**
   *  Returns the list of TaggedRuleApplication (tuples <Elements,Rule> marked as
   *  included or excluded) that have to be respected when the 
   *  tuple <candidateObjects, appliedRule> is selected. The result is a list of
   *  list implementing a disjunctive normal form: elements from the first list 
   *  are separated with ORs; elements from the second list are separated by ANDs
   *  
   * @param trcSpecification the TRC
   * @param candidateObjects EObjects to be transformed by appliedRule 
   * @param appliedRule selected transformation rule
   * @return TaggedRuleApplication (tuples <Elements,Rule> marked as
   *  included or excluded) that have to be respected
   */
	public static List<List<TaggedRuleApplicationTuple>> getNormalizedDependencies(TrcSpecification spec,
	                                                                         List<EObject> eObjList,
	                                                                         TrcRule appliedRule)
  {
	  List<List<TaggedRuleApplicationTuple>> result = spec.getNormalizedDependencies(eObjList, appliedRule);
	  if(result != null)
	    return result;
	  result = new ArrayList<List<TaggedRuleApplicationTuple>>();
	  for(TransformationDependency dep: (List<TransformationDependency>) spec.getDependencyList().getTransformationDependencies())
	  {
	    TrcRule depRule = dep.getAppliedRule();
	    if(false==depRule.equals(appliedRule))
	      continue;
	    List<TaggedRuleApplicationTuple> localDependencyList = new ArrayList<TaggedRuleApplicationTuple>();
	    result.add(localDependencyList);
	    getPossibleDependencies(dep.getRequiredTransformations(), eObjList, localDependencyList, result);
	  }
    spec.addNormalizedDependencies(eObjList, appliedRule, result);
	  return result;
  }

	
	private static TransformationDependency getTransformationDependency(AbstractRuleDependency rd)
	{
		EObject container = rd.eContainer();
		if(container instanceof TransformationDependency)
			return (TransformationDependency) container;
		else if(container instanceof AbstractRuleDependency)
			return getTransformationDependency((AbstractRuleDependency) container);
		return null;
	}
	
	private static void getPossibleDependencies(AbstractRuleDependency ar, 
	                                           List<EObject> eObjList, 
	                                           List<TaggedRuleApplicationTuple> currentDependencyList,
	                                           List<List<TaggedRuleApplicationTuple>> result)
  {
	  // Here, we have to organize dependencies according to a disjunctive normal form.
	  if(ar instanceof RuleDependency)
	  {
	    RuleDependency rd = (RuleDependency) ar;
	    try
	    {
	      List<EObject> depObjList = 
	    		  getReferencedEObjects(rd.getFieldNames(), getTransformationDependency(rd).getVariableId(), eObjList);
	      for(EObject obj : depObjList)
	      {
	    	TaggedRuleApplicationTuple dep = new TaggedRuleApplicationTuple();  
			List<EObject> objList = new ArrayList<EObject>();
			objList.add(obj);
			currentDependencyList.add(dep);
			dep.setPatternMatchedElement(objList);
			dep.setTransformationRule(rd.getRequiredRule());
		      dep.setExclusion(rd.isIsExclusion());
			_LOGGER.trace("Retreived (excluded) dependency to "+rd.getRequiredRule().getName());
		  }
	    }
	    catch(Exception e)
	    {
	      _LOGGER.fatal("failed when retreiving transformation dependencies", e);
	    }
	  }
	  else if(ar instanceof RuleDependencyConjunction)
	  {
	    for(AbstractRuleDependency conjunctedAr:((RuleDependencyConjunction) ar).getRequiredTransformations())
	    {
	      getPossibleDependencies(conjunctedAr, eObjList, currentDependencyList, result);
	    }
	  }
	  else if(ar instanceof RuleDependencyDisjunction)
	  {
	    for(AbstractRuleDependency disjunctedAr:((RuleDependencyDisjunction) ar).getRequiredTransformations())
	    {
	      if(disjunctedAr.equals(((RuleDependencyDisjunction) ar).getRequiredTransformations().get(0)))
	      {
	        getPossibleDependencies(disjunctedAr, eObjList, currentDependencyList, result);
	      }
	      else
	      {
	        List<TaggedRuleApplicationTuple> disjuncResult = new ArrayList<TaggedRuleApplicationTuple>();
	        disjuncResult.addAll(currentDependencyList);
	        getPossibleDependencies(disjunctedAr, eObjList, disjuncResult, result);
	        result.add(disjuncResult);
	      }
	    }
	  }
  }

	
	@SuppressWarnings("unchecked")
	private static List<EObject> getReferencedEObjects(String queryText, 
			List<String> formalParameterList,
			List<EObject> actualParameterList) throws ParserException
	{
		if(queryText.startsWith("\""))
			queryText = queryText.substring(1);
		if(queryText.endsWith("\""))
			queryText = queryText.substring(0,queryText.length()-1);
		
		OCL ocl = OCL.newInstance(EcoreEnvironmentFactory.INSTANCE);
		Helper helper = ocl.createOCLHelper();

		int i=-1;
		for(String formal: formalParameterList)
		{
			i++;
			if(formal.equals("_"))
				continue;
			EObject actual = actualParameterList.get(i);
			Variable<EClassifier, EParameter> parameterVariable =
			        ExpressionsFactory.eINSTANCE.createVariable();
			parameterVariable.setName(formal);
			helper.setInstanceContext(actual);
			parameterVariable.setType(helper.getContextClassifier());
			ocl.getEnvironment().addElement(formal, parameterVariable, true);
		}
		EObject eObj = (EObject) actualParameterList.get(0);
		if(eObj instanceof InstanceObject)
		{
			InstanceObject io = (InstanceObject) eObj;
			while(io.eContainer()!=null)
				io = (InstanceObject) io.eContainer();
			eObj = io;
		}
		helper.setInstanceContext(eObj);
		
		Map<EClass, Set<? extends EObject>> extents =
				new HashMap<EClass, Set<? extends EObject>>();
		
		// next should not be here to optimize code
		List<ComponentInstance> ciList = 
				EcoreUtil2.getAllContentsOfType(eObj, ComponentInstance.class);
		extents.put(InstancePackage.Literals.COMPONENT_INSTANCE,
				new HashSet<ComponentInstance>(ciList));
		
		ocl.setExtentMap(extents);
		
		@SuppressWarnings("rawtypes")
		OCLExpression query = helper.createQuery(queryText);
		
		// create a Query to evaluate our query expression
		Query<EClassifier, EClass, EObject> queryEval = ocl.createQuery(query);
		i=-1;
		for(String formal: formalParameterList)
		{
			i++;
			if(formal.equals("_"))
				continue;
			EObject actual = actualParameterList.get(i);
			queryEval.getEvaluationEnvironment().add(formal, actual);
		}
		Object queryResult = queryEval.evaluate();
		if(queryResult instanceof Bag)
			return new ArrayList<EObject>((Bag<EObject>)queryResult);
		else
		{
			EObject eo = (EObject) queryResult;
			List<EObject> evalList = new ArrayList<EObject>();
			evalList.add(eo);
			return evalList;
		}
	}
	
	private static List<EObject> 
			getReferencedEObjects(List<String> queryTextList, 
				   				  List<String> formalParameterList,
				   				  List<EObject> actualParameterList) throws ParserException
	{
		List<EObject> result = new ArrayList<EObject>();
		for(String queryText: queryTextList)
		{
			result.addAll(getReferencedEObjects(queryText,
					formalParameterList,
					actualParameterList));
		}
		return result;

	}
	
	private static void getRestrictedPossibleDependencies(AbstractRuleDependency ar, 
												  List<EObject> eObjList, 
												  List<RuleApplicationTuple> currentDependencyList,
												  List<List<RuleApplicationTuple>> result,
												  boolean isExclusion)
	{
		// Here, we have to organize dependencies according to a disjunctive normal form.
		_LOGGER.trace("Start retreive dependencies under disjunctive normal form");
	  if(ar instanceof RuleDependency)
		{
			RuleDependency rd = (RuleDependency) ar;
			if(rd.isIsExclusion()!=isExclusion)
			  return;
			try
			{
				List<EObject> depObjList = 
						getReferencedEObjects(rd.getFieldNames(), getTransformationDependency(rd).getVariableId(), eObjList);
				for(EObject obj : depObjList)
				{
					List<EObject> objList = new ArrayList<EObject>();
					objList.add(obj);
					RuleApplicationTuple dep = new RuleApplicationTuple();
					currentDependencyList.add(dep);
					dep.setPatternMatchedElement(objList);
					dep.setTransformationRule(rd.getRequiredRule());
					_LOGGER.trace("Retreived (included) dependency to "+rd.getRequiredRule().getName());
				}
			}
			catch(Exception e)
			{
			  String msg = "Error when retreiving rules dependencies";
				_LOGGER.fatal(msg, e);
				ServiceProvider.SYS_ERR_REP.fatal(msg, e);
			}
		}
		else if(ar instanceof RuleDependencyConjunction)
		{
			for(AbstractRuleDependency conjunctedAr:((RuleDependencyConjunction) ar).getRequiredTransformations())
			{
			  getRestrictedPossibleDependencies(conjunctedAr, eObjList, currentDependencyList, result, isExclusion);
			}
		}
		else if(ar instanceof RuleDependencyDisjunction)
		{
			for(AbstractRuleDependency disjunctedAr:((RuleDependencyDisjunction) ar).getRequiredTransformations())
			{
				if(disjunctedAr.equals(((RuleDependencyDisjunction) ar).getRequiredTransformations().get(0)))
				{
				  getRestrictedPossibleDependencies(disjunctedAr, eObjList, currentDependencyList, result, isExclusion);
				}
				else
				{
					List<RuleApplicationTuple> disjuncResult = new ArrayList<RuleApplicationTuple>();
					disjuncResult.addAll(currentDependencyList);
					getRestrictedPossibleDependencies(disjunctedAr, eObjList, disjuncResult, result, isExclusion);
					result.add(disjuncResult);
				}
			}
		}
	  _LOGGER.trace("Finished retreive dependencies under disjunctive normal form");
	}
	
//	private static List<EObject> getReferenceList(EObject eObj, List<String> referenceNameList) throws Exception
//	{
//		List<EObject> result= new ArrayList<EObject>();
//		for(String fieldName:referenceNameList)
//		{
//			if(fieldName.equals("self"))
//				result.add(eObj);
//			else
//				result = getReferenceList(result, fieldName);
//		}
//		return result;
//	}
	
//	private static List<EObject> getReferenceList(List<EObject> eObjList, String referenceName) throws Exception
//	{
//		List<EObject> result= new ArrayList<EObject>();
//		for(EObject eObj: eObjList)
//		{
//		final EClass type = eObj.eClass();
//		if(referenceName.contains("("))
//		{
//			int firstParenthesisIdx = referenceName.indexOf("(");
//			int lastParenthesisIdx = referenceName.lastIndexOf(")");
//			String operationName = referenceName.substring(0, firstParenthesisIdx);
//			String argumentListName = referenceName.substring(firstParenthesisIdx+1, lastParenthesisIdx);
//			argumentListName = argumentListName.replaceAll(" ", "");
//			String[] argumentArray = argumentListName.split("\\s*,\\s*");
//			if(argumentArray.length>0)
//			{
//				for(int i = 0; i<argumentArray.length; i++)
//				{
//					String argumentName = argumentArray[i];
//					if(argumentName.equals(""))
//						continue;
//				}
//			}
//			final Class<? extends EObject> cl = eObj.getClass();
//			for(int i=0;i<cl.getMethods().length;i++)
//			{
//				if(operationName.equals(cl.getMethods()[i].getName()))
//				{
//					Object o = cl.getMethods()[i].invoke(eObj);
//					if(o instanceof List)
//					{
//						result.addAll((List<EObject>)o);
//					}
//					else
//						result.add((EObject) o);
//				}
//			}
//		}
//		else
//		{
//			final EStructuralFeature sf = type.getEStructuralFeature(referenceName);
//			if (sf != null) {
//				Object ref = eObj.eGet(sf);
//				if(ref instanceof EObject)
//					result.add((EObject) ref);
//				else
//					throw new Exception("Expected EObject, found regular Java Object");
//			} // TODO: lists need to ne handled; but not in a first iteration.
//			else
//			{
//				String id="";
//
//				final EStructuralFeature qn = type.getEStructuralFeature("qualifiedName");
//				if (qn != null) {
//					id=(String) eObj.eGet(qn);
//				}
//				throw new Exception("could not find "+referenceName+" on element "+id);
//			}
//		}
//		}
//		return result;
//	}

	
	/**
	 *  Returns the list of RuleApplication (tuples <Elements,Rule>) that have
	 *  to be excluded when the tuple <candidateObjects, appliedRule> is 
	 *  selected
	 *  
	 * @param trcSpecification the TRC
	 * @param candidateObjects EObjects to be transformed by appliedRule 
	 * @param appliedRule selected transformation rule
	 * @return the list of RuleApplication (tuples <Elements,Rule>) that have
   *  to be excluded
	 */
	public static List<List<RuleApplicationTuple>> getExlcusionDependencies(TrcSpecification trcSpecification,
	                                                                        List<EObject> candidateObjects,
	                                                                        TrcRule appliedRule) {
		List<List<RuleApplicationTuple>> exclusionDependencyList = new ArrayList<List<RuleApplicationTuple>>();
		for(TransformationDependency dep: (List<TransformationDependency>) trcSpecification.getDependencyList().getTransformationDependencies())
		{
			if(false==dep.getAppliedRule().equals(appliedRule))
				continue;
			List<RuleApplicationTuple> localDependencyList = new ArrayList<RuleApplicationTuple>();
			exclusionDependencyList.add(localDependencyList);
			for(AbstractRuleDependency req: (List<AbstractRuleDependency>) dep.getRequiredTransformations())
			{
				getRestrictedPossibleDependencies(req, candidateObjects, localDependencyList, exclusionDependencyList, true);
			}
		}
		return exclusionDependencyList;
	}
}
