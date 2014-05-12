package fr.tpt.aadl.ramses.transformation.tip.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.osate.aadl2.NamedElement;
import org.osate.aadl2.instance.InstanceObject;

import fr.tpt.aadl.ramses.transformation.tip.ElementTransformation;
import fr.tpt.aadl.ramses.transformation.tip.Iteration;
import fr.tpt.aadl.ramses.transformation.tip.TipFactory;
import fr.tpt.aadl.ramses.transformation.tip.TipPackage;
import fr.tpt.aadl.ramses.transformation.tip.TipSpecification;


public class TipUtils {

	private static Resource resource;
	private static int currentIteration;
	private static TipSpecification tipSpecification;
	
	public static TipSpecification createNewTIP(Resource r){
		resource = r;
		TipSpecification spec = TipFactory.eINSTANCE.createTipSpecification();
		r.getContents().add(spec);
		saveTip(r, spec);
		
		return spec;
	}
	
	public static void addIteration(TipSpecification spec,
	                                ResourceSet resourceSet,
	                                String tipPath){
		int newIndex = TipParser.getLastIterationId()+1; 
		Iteration iteration = TipFactory.eINSTANCE.createIteration();
		iteration.setId(newIndex);
		spec.getIterations().add(iteration);
		saveTip(getResource(tipPath, resourceSet), spec);		
	}
	
	private static String getQualifiedName(EObject obj)
	{
		if(obj instanceof InstanceObject)
		{
			InstanceObject iObj = (InstanceObject) obj;
			return iObj.getInstanceObjectPath();
		}
		if(obj instanceof NamedElement)
		{
			NamedElement ne = (NamedElement) obj;
			return ne.getQualifiedName();
		}
		return null;
	}
	
	public static void addElementTransformationToIteration(String tipPath,
	                                                       ResourceSet resourceSet,
	                                                       TipSpecification spececification,
	                                                       int iterationId,
	                                                       ElementTransformation et){
		Iteration iteration = TipParser.getIterationById(spececification, iterationId);
		iteration.getElements().add(et);
		
		saveTip(getResource(tipPath, resourceSet), spececification);		
	}

	public static void addElementTransformationToLastIteration(String tipPath,
	                                                           ResourceSet resourceSet,
	                                                           TipSpecification specification,
	                                                           ElementTransformation et){
		Iteration iteration = TipParser.getIterationById(specification, TipParser.getLastIterationId());
		iteration.getElements().add(et);
		
		saveTip(getResource(tipPath,resourceSet), specification);		
	}

	public static void addElementTransformationToLastIteration(String tipPath,
	                                                           ResourceSet resourceSet,
	                                                           TipSpecification specification,
	                                                           List<ElementTransformation> etList){
		Iteration iteration = TipParser.getIterationById(specification, TipParser.getLastIterationId());
		
		Iterator<ElementTransformation> elementsIt = etList.iterator();
		while (elementsIt.hasNext()) {
			ElementTransformation et = elementsIt.next();
			iteration.getElements().add(et);
		}
		
		saveTip(getResource(tipPath, resourceSet), specification);		
	}

	
	public static ElementTransformation createElementTransformation(List<EObject> elementId, String transformationId) {
		ElementTransformation et = TipFactory.eINSTANCE.createElementTransformation();
		for(EObject obj: elementId)
		{
			et.getElementId().add(obj);
			et.getElementName().add(getQualifiedName(obj));			
		}
		et.setTransformationId(transformationId);
		return et;
	}

	
	private static void saveTip(Resource res, TipSpecification spececification){

		try {
			res.save(null);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	protected static Resource getResource(String tipPath,
	                                      ResourceSet resourceSet){
		URI p_uri = URI.createFileURI(tipPath);

		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("tip", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put("http://fr.tpt.aadl.ramses.transformation/TIP/1.0", TipPackage.eINSTANCE);
		if(resource==null)
			resource = resourceSet.getResource(p_uri, false);
		if(resource==null)
			resource = resourceSet.createResource(p_uri);

		return resource;
	}

	public static boolean alreadyReferenced(List<EObject> key, ArrayList<ElementTransformation> tuplesToApply) {
	  for(ElementTransformation et: tuplesToApply)
	  {
		boolean found = true;
		for(EObject obj:(List<EObject>) et.getElementId())
		{
		  if(false == obj.equals(key))
		  {
		    found=false;
		    break;
		  }
		}
		if(found)
		  return true;
	  }
	  return false;
	}

	
	public static int getCurrentIteration() {
		return currentIteration;
	}


	public static void setCurrentIteration(int currentIterationParam) {
		currentIteration = currentIterationParam;
	}

	public static TipSpecification getTipSpecification() {
		return tipSpecification;
	}
	
	public static void setTipSpecification(TipSpecification param) {
		tipSpecification = param;
	}
	
}
