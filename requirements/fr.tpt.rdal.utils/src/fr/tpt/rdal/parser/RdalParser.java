package fr.tpt.rdal.parser;

import java.util.ArrayList ;
import java.util.Collections ;
import java.util.Comparator ;
import java.util.Iterator ;
import java.util.List ;

import org.eclipse.emf.common.util.TreeIterator ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.util.EcoreUtil ;
import org.osate.aadl2.NamedElement ;

import fr.openpeople.rdal2.model.rdal.AbstractGoal ;
import fr.openpeople.rdal2.model.rdal.DesignElementReference ;
import fr.openpeople.rdal2.model.rdal.GoalsPackage ;
import fr.openpeople.rdal2.model.rdal.PrioritizedSatDesignElementRef ;
import fr.openpeople.rdal2.model.rdal.QualityObjective ;
import fr.openpeople.rdal2.model.rdal.RdalOrgPackage ;
import fr.openpeople.rdal2.model.rdal.ReferencedDesignElements ;
import fr.openpeople.rdal2.model.rdal.Sensitivity ;
import fr.openpeople.rdal2.model.rdal.Specification ;

public class RdalParser {

//	private Specification rdalRootObject;
//	public static Specification parse(String rdalPath){
//		final Resource resource;
//		URI rdal_uri = URI.createFileURI(rdalPath);
//		
//		getResourceSet().getResourceFactoryRegistry().getExtensionToFactoryMap().put("rdal", new XMIResourceFactoryImpl());
//		getResourceSet().getPackageRegistry().put(RdalPackage.eNS_URI, RdalPackage.eINSTANCE);
//		getResourceSet().getPackageRegistry().put(ConstraintsPackage.eNS_URI, ConstraintsPackage.eINSTANCE);
//		getResourceSet().getPackageRegistry().put(SettingsPackage.eNS_URI, SettingsPackage.eINSTANCE);
//		
//		getResourceSet().getPackageRegistry().put(Aadl2Package.eNS_URI, Aadl2Package.eINSTANCE);
//		getResourceSet().getPackageRegistry().put(InstancePackage.eNS_URI, InstancePackage.eINSTANCE);
//		
//        //resourceSet = new XtextResourceSet();
//        //Aadl2StandaloneSetup.doSetup();
//        
//		if (getResourceSet().getURIConverter().exists(rdal_uri, null)) {			
//			resource = getResourceSet().getResource(rdal_uri, true);
//			try
//      {
//        resource.load(null);
//      }
//      catch(IOException e)
//      {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//      }
//			rdalRootObject = (Specification)resource.getContents().get(0);	
//			System.out.println("Specification root element: "+rdalRootObject.getName());
//			return rdalRootObject;
//		}

/*		List<GoalsPackage> packagesList = RdalParser.getGoalsPackages(rdalSpecificationObject);
		Iterator<GoalsPackage> pakagesIt = packagesList.iterator();
		while(pakagesIt.hasNext()){
			GoalsPackage goalPackage = pakagesIt.next();
			List<Goal> goalsList = RdalParser.getGoalsForPackage(goalPackage);
			Iterator<Goal> goalsIt = goalsList.iterator();
			while(goalsIt.hasNext()){
				Goal goalObject = goalsIt.next();
				if (goalObject instanceof QualityGoal){
					Sensitivity s = RdalParser.getSensitivityForQualityGoal((QualityGoal)goalObject);
					RdalParser.getDesignElementsForSensitivity(s);
				}
			}
*///			rdal.getSensitivitiesForDesignElement(rdalRoot, designElementName)							
			
		
//		return null;
//	}
		
//------------------------------My example code-------------------------------------------------------------------------------
/*        final ResourceSet resourceSet = new ResourceSetImpl();
        final Map<String, Object> extensionToFactoryMap = resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap();
        extensionToFactoryMap.put( Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl() );
        final Registry packageRegistry = resourceSet.getPackageRegistry();
        packageRegistry.put( ConstraintsPackage.eNS_URI, ConstraintsPackage.eINSTANCE );
        packageRegistry.put( RdalPackage.eNS_URI, RdalPackage.eINSTANCE );

        final URI uri = URI.createFileURI(path);
        final Resource resource = resourceSet.getResource( uri, true );
        return (Specification)resource.getContents().get(0);
*/		        		
//-------------------------------------------------------------------------------------------------------------
	
	
	public static List<GoalsPackage> getGoalsPackages(Specification rdalSpecObj){
		
		List<RdalOrgPackage> packages = rdalSpecObj.getOwnedPackages();
		List<GoalsPackage> results = new ArrayList<GoalsPackage>();
		
		Iterator<RdalOrgPackage> rdalRootElementsIt = packages.iterator();
		while(rdalRootElementsIt.hasNext()){
			EObject goalPackageObject = rdalRootElementsIt.next();
			//System.out.println("goalPackageObject: "+goalPackageObject);
			if (goalPackageObject instanceof GoalsPackage){
				System.out.println("Package detected: "+((GoalsPackage)goalPackageObject).getName());
				results.add((GoalsPackage)goalPackageObject);
			}
		}
		
		return results;
	}
	
	public static List<AbstractGoal> getGoalsForPackage(GoalsPackage goalPackageObj){
		List<AbstractGoal> rdalGoalsList = goalPackageObj.getOwnedGoals();
		
		Iterator<AbstractGoal> rdalGoalsIt = rdalGoalsList.iterator();
		while(rdalGoalsIt.hasNext()){
			AbstractGoal goalObject = rdalGoalsIt.next();
			//System.out.println("goalPackageElement: "+goalObject);
			if (goalObject instanceof AbstractGoal){
				System.out.println("Goal detected: "+goalObject.getName());
			}
		}
		return rdalGoalsList;
	}
	
	public static Sensitivity getSensitivityForQualityGoal(QualityObjective qualityGoalObj){
		return qualityGoalObj.getOwnedSensitivity();
	}
	
	public static List<String> getSensitivitiesForDesignElement(Specification rdalSpecificationObj,
	                                                            List<EObject> designElementList){
		List<String> sensitivitiesResultList = new ArrayList<String>();
		
		for(EObject obj: designElementList)
		{
			sensitivitiesResultList.addAll(getSensitivitiesForDesignElement(rdalSpecificationObj, obj));
		}
		
		if(designElementList.size() >0 && sensitivitiesResultList.size()>1)
		{
			System.out.println("WARNING: sensitivities of these elements have been considered together: ");
			for(EObject ne: designElementList)
			{
				System.out.println("\t"+((NamedElement) ne).getQualifiedName());
			}
		}
		
		if(sensitivitiesResultList.isEmpty())
		{
			System.out.println("WARNING: no sensitivity found for the following components: ");
			for(EObject ne: designElementList)
			{
				System.out.println("\t"+((NamedElement) ne).getQualifiedName());
			}
		}
		
		return sensitivitiesResultList;
	}
	
	public static NamedElement getNamedElement(Specification rdalRootObject,
	                                           String qualifiedName)
	{
		NamedElement result=null;
		if(rdalRootObject==null)
			return result;
		
		for(DesignElementReference der : rdalRootObject.getOwnedReferencedDesignElements().getOwnedDesignElementRefs())
		{
			TreeIterator<EObject> iter = EcoreUtil.getAllContents(der.getDesignElement().eResource(), true);
			while(iter.hasNext())
			{
				EObject next = iter.next();
				if(next instanceof NamedElement)
				{
					if(((NamedElement) next).getQualifiedName().equals(qualifiedName))
						return (NamedElement) next;
				}
			}			
		}
		return result;
	}
	
	public static List<String> getSensitivitiesForDesignElement(Specification rdalSpecificationObj, 
	                                                            EObject designElement)
	{
		
		List<ComparableSensitivity> sensitivitiesResultList = new ArrayList<ComparableSensitivity>();
		
		List<GoalsPackage> packagesList = getGoalsPackages(rdalSpecificationObj);
		Iterator<GoalsPackage> pakagesIt = packagesList.iterator();
		while(pakagesIt.hasNext()){
			GoalsPackage goalPackageObject = pakagesIt.next();
			List<AbstractGoal> goalsList = getGoalsForPackage(goalPackageObject);
			Iterator<AbstractGoal> goalsIt = goalsList.iterator();
			while(goalsIt.hasNext()){
				AbstractGoal goalObject = goalsIt.next();
				if (goalObject instanceof QualityObjective){
					Sensitivity sensitivityObject = getSensitivityForQualityGoal((QualityObjective)goalObject);
					List<EObject> objectsList = new ArrayList<EObject>();
					long priority = getDesignElementsForSensitivity(sensitivityObject, objectsList);
					ComparableSensitivity cs = new ComparableSensitivity(sensitivityObject, priority);
					Iterator<EObject> objectsIt = objectsList.iterator();
					while(objectsIt.hasNext()){
						EObject object = objectsIt.next();
						if(object instanceof NamedElement)
						{
							NamedElement ne = (NamedElement) object;
							if(designElement.equals(ne) || isContainedIn(ne, (NamedElement) designElement))
							{
								sensitivitiesResultList.add(cs);
							}
						}
					}
				}
			}
		}
		Collections.sort(sensitivitiesResultList, new Comparator<ComparableSensitivity>(){
			@Override
			public int compare(ComparableSensitivity o1, ComparableSensitivity o2) {
				if(o1.getPriority() > o2.getPriority())
					return -1;
				else if(o1.getPriority() < o2.getPriority())
					return 1;
				else
					return 0;
			}
		}
				);
		List<String> result = new ArrayList<String>();
		for(ComparableSensitivity s:sensitivitiesResultList)
			if(false == result.contains(s.getSensitivity().getName()))
				result.add(s.getSensitivity().getName());
		return result;
	}
	
	private static boolean isContainedIn(NamedElement container,
			NamedElement designeElement) {
		if(designeElement.eContainer() == null)
			return false;
		if(designeElement.eContainer() instanceof NamedElement)
		{
			NamedElement designElementContainer = (NamedElement) designeElement.eContainer();
			if(designElementContainer.equals(container))
				return true;
			else
				return isContainedIn(container, (NamedElement) designeElement.eContainer());
		}
		return false;
	}

	public long getPriorityForDesignReference(String designElementName, Sensitivity sensitivityObj){
		List<DesignElementReference> designElementReferenceList = sensitivityObj.getOwnedReferencedDesignElements().getOwnedDesignElementRefs();
		Iterator<DesignElementReference> designElementReferenceIt = designElementReferenceList.iterator();
		while(designElementReferenceIt.hasNext()){
			DesignElementReference designElementReferenceObject = designElementReferenceIt.next();
			NamedElement namedElementObject = (NamedElement)designElementReferenceObject.getDesignElement(); 
			if (namedElementObject.getQualifiedName().equals(designElementName)){
				if (designElementReferenceObject instanceof PrioritizedSatDesignElementRef){
					PrioritizedSatDesignElementRef prioritizedReferenceObject = (PrioritizedSatDesignElementRef)designElementReferenceObject;
					return prioritizedReferenceObject.getPriority();					
				}
			}
		}
		return 0;
	}
	
	//Sensitivity -> Ref Manually Selected Design Elements -> Prioritized Sat Design Element Ref
	public static long getDesignElementsForSensitivity(Sensitivity sensitivityObj, 
	                                                   List<EObject> sensitivities){
		List<EObject> designElementsResult = new ArrayList<EObject>();
		long priority=-1;
		if (sensitivityObj!=null){
			ReferencedDesignElements referencedDesignElement = sensitivityObj.getOwnedReferencedDesignElements();
			List<DesignElementReference> designElementReferencesList = referencedDesignElement.getOwnedDesignElementRefs();
			Iterator<DesignElementReference> designElementReferencesIt = designElementReferencesList.iterator();
			while(designElementReferencesIt.hasNext()){
				DesignElementReference designElementReferenceObject = designElementReferencesIt.next();
				if(designElementReferenceObject instanceof PrioritizedSatDesignElementRef)
				{
					PrioritizedSatDesignElementRef psder = (PrioritizedSatDesignElementRef) designElementReferenceObject;
					try
					{
					  priority = psder.getPriority();
					}
					catch(Exception e)
					{
					  priority = -1;
					}
				}
				EObject designElement = designElementReferenceObject.getDesignElement();
				NamedElement n = (NamedElement) designElement;
				if(priority == -1)
					System.out.println("ERRROR: for element: "+n.getQualifiedName()+
							" referenced in RDAL, no priority found: transformation selection" +
							" will not be deterministic");
//				NamedElement n = (NamedElement) designElementReferenceObject.getDesignElement();
//				System.out.println("Design element qualified name: "+n.getQualifiedName());
				designElementsResult.add(designElementReferenceObject.getDesignElement());
			}
		}
		sensitivities.addAll(designElementsResult);
		return priority;

	}
	

/*	public List<EObject> getDesignElementsSensitiveToQA(Specification specificationObj, String qaName){
		List<QualityAttribute> qualityAttributtesList = specificationObj.getQualityAttributes();
		
		//switchObj.doSwitch(eObject)
//		QualityGoal s;
//		s.get
		
		
		Iterator<QualityAttribute> qualityAttributtesIt = qualityAttributtesList.iterator();
		while(qualityAttributtesIt.hasNext()){
			QualityAttribute qualityAttributeObject = qualityAttributtesIt.next();
			if (qualityAttributeObject.getName().equals(qaName)){
				return getDesignElementsForSensitivity(qualityAttributeObject.get);
			}
		}
		return null;
	}*/
	
	
	//-------------------------------------------------------------------------------------
	//--------------------------private methods--------------------------------------------
	//-------------------------------------------------------------------------------------	
	
	
	private static String getQualifiedNameForObject(EObject obj){
		NamedElement namedElementObject = (NamedElement)obj;
		return namedElementObject.getQualifiedName();
	}

}
