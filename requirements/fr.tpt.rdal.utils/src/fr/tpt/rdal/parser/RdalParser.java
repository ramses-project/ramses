package fr.tpt.rdal.parser;

import java.util.ArrayList ;
import java.util.Collections ;
import java.util.Comparator ;
import java.util.Iterator ;
import java.util.List ;

import org.apache.log4j.Logger ;
import org.eclipse.emf.common.util.TreeIterator ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.util.EcoreUtil ;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.FeatureInstance ;
import org.osate.aadl2.instance.InstanceObject ;

import fr.openpeople.rdal2.model.rdal.AbstractGoal ;
import fr.openpeople.rdal2.model.rdal.DesignElementReference ;
import fr.openpeople.rdal2.model.rdal.GoalsPackage ;
import fr.openpeople.rdal2.model.rdal.PrioritizedSatDesignElementRef ;
import fr.openpeople.rdal2.model.rdal.QualityObjective ;
import fr.openpeople.rdal2.model.rdal.RdalOrgPackage ;
import fr.openpeople.rdal2.model.rdal.RdalPackage ;
import fr.openpeople.rdal2.model.rdal.ReferencedDesignElements ;
import fr.openpeople.rdal2.model.rdal.Sensitivity ;
import fr.openpeople.rdal2.model.rdal.Specification ;

public class RdalParser {

  private static Logger _LOGGER = Logger.getLogger(RdalParser.class) ;

  public static Specification parse(String rdalPath, 
                                    ResourceSet resourceSet){

    final Resource resource;

    URI p_uri = URI.createURI(rdalPath);

    resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("rdal", new XMIResourceFactoryImpl());
    resourceSet.getPackageRegistry().put(RdalPackage.eNS_URI, RdalPackage.eINSTANCE);

    if (resourceSet.getURIConverter().exists(p_uri, null)) {
      resource = resourceSet.getResource(p_uri, true);
      Specification result = (Specification) resource.getContents().get(0);
      return result;  
    } else {
      _LOGGER.error("RDAL of specified path ("+rdalPath+") does not exit.");
    }

    return null;
  }

  public static List<GoalsPackage> getGoalsPackages(Specification rdalSpecObj){

    List<RdalOrgPackage> packages = rdalSpecObj.getOwnedPackages();
    List<GoalsPackage> results = new ArrayList<GoalsPackage>();

    Iterator<RdalOrgPackage> rdalRootElementsIt = packages.iterator();
    while(rdalRootElementsIt.hasNext()){
      EObject goalPackageObject = rdalRootElementsIt.next();
      if (goalPackageObject instanceof GoalsPackage){
        _LOGGER.trace("Package detected: "+((GoalsPackage)goalPackageObject).getName());
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
      if (goalObject instanceof AbstractGoal){
        _LOGGER.trace("Goal detected: "+goalObject.getName());
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
      if(obj instanceof NamedElement)
      {
        NamedElement ne = (NamedElement) obj;
        _LOGGER.trace("Search sensitivity for "+ne.getName());
      }
      List<String> sensitivities = getSensitivitiesForDesignElement(rdalSpecificationObj, obj);
      String message = "Found sensitivities: ";
      for(String s: sensitivities)
        message+=s+" ";
      _LOGGER.trace(message);
      sensitivitiesResultList.addAll(sensitivities);

    }

    if(designElementList.size() >0 && sensitivitiesResultList.size()>1)
    {
      String message = "Sensitivities of these elements have been considered together: ";
      for(EObject ne: designElementList)
      {
        message+="\t"+((NamedElement) ne).getQualifiedName();
      }
      _LOGGER.warn(message);
    }

    if(sensitivitiesResultList.isEmpty())
    {
      String message = "WARNING: no sensitivity found for the following components: ";
      for(EObject ne: designElementList)
      {
        message+="\t"+((NamedElement) ne).getQualifiedName();
      }
      _LOGGER.warn(message);
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
    _LOGGER.trace("Search in "+packagesList.size()+" goal packages");
    Iterator<GoalsPackage> pakagesIt = packagesList.iterator();
    while(pakagesIt.hasNext()){
      GoalsPackage goalPackageObject = pakagesIt.next();
      List<AbstractGoal> goalsList = getGoalsForPackage(goalPackageObject);
      _LOGGER.trace("Search in "+goalsList.size()+" goals");
      Iterator<AbstractGoal> goalsIt = goalsList.iterator();
      while(goalsIt.hasNext()){
        AbstractGoal goalObject = goalsIt.next();
        if (goalObject instanceof QualityObjective){
          Sensitivity sensitivityObject = getSensitivityForQualityGoal((QualityObjective)goalObject);
          if(sensitivityObject == null)
            _LOGGER.error("Sensitivity not found");
          List<EObject> objectsList = new ArrayList<EObject>();
          long priority = getDesignElementsForSensitivity(sensitivityObject, objectsList);
          ComparableSensitivity cs = new ComparableSensitivity(sensitivityObject, priority);
          Iterator<EObject> objectsIt = objectsList.iterator();
          while(objectsIt.hasNext()){
            EObject object = objectsIt.next();
            if(object instanceof NamedElement)
            {
              NamedElement ne = (NamedElement) object;
              if(designElement.equals(ne) || isContainedIn(ne, (NamedElement) designElement)
                  || isInstanceOf(designElement, ne))
              {
                sensitivitiesResultList.add(cs);
              }
              else
                _LOGGER.warn("No sensitivitiy found for "+ne.getName());
            }
          }
        }
      }
    }
    _LOGGER.trace("Sensitivitiy list contains "+sensitivitiesResultList.size()
                  +" elements");
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
    _LOGGER.trace("Sensitivity list was sorted");
    List<String> result = new ArrayList<String>();
    for(ComparableSensitivity s:sensitivitiesResultList)
      if(false == result.contains(s.getSensitivity().getName()))
        result.add(s.getSensitivity().getName());
    return result;
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
          _LOGGER.error("For element: "+n.getQualifiedName()+
                        " referenced in RDAL, no priority found: transformation selection" +
              " will not be deterministic");
        designElementsResult.add(designElementReferenceObject.getDesignElement());
      }
    }
    sensitivities.addAll(designElementsResult);
    return priority;

  }

  //-------------------------------------------------------------------------------------
  //--------------------------private methods--------------------------------------------
  //-------------------------------------------------------------------------------------	

  
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

  private static boolean isInstanceOf(EObject designElement, NamedElement neInRdal)
  {
    if(designElement instanceof InstanceObject)
    {
      InstanceObject io = (InstanceObject) designElement;
      if(io instanceof ComponentInstance)
      {
        ComponentInstance ci = (ComponentInstance) io;
        return ci.getSubcomponent().equals(designElement) 
            || ci.getSubcomponent().getSubcomponentType().equals(designElement);
      }
      else if(io instanceof FeatureInstance)
      {
        FeatureInstance fi = (FeatureInstance) io;
        return fi.getFeature().equals(designElement);
      }
      return false;
    }
    return false ;
  }

  
}
