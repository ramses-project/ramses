package fr.tpt.aadl.ramses.instantiation.manager ;

import java.io.File ;
import java.io.FilenameFilter ;
import java.util.ArrayList ;
import java.util.Arrays ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.eclipse.emf.common.util.TreeIterator ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.Property ;
import org.osate.aadl2.PropertySet ;
import org.osate.aadl2.StringLiteral ;

import fr.tpt.aadl.ramses.instantiation.StandAloneInstantiator ;

public class PredefinedPropertiesManager
{

  private static List<String> expectedPropertySet = new ArrayList<String>() ;
  private static Map<String, Resource> predefinedPropertySets =
        new HashMap<String, Resource>() ;

  public PredefinedPropertiesManager()
  {
    expectedPropertySet.add("AADL_Project") ;
    expectedPropertySet.add("Communication_Properties") ;
    expectedPropertySet.add("Data_Model") ;
    expectedPropertySet.add("Deployment_Properties") ;
    expectedPropertySet.add("Memory_Properties") ;
    expectedPropertySet.add("Programming_Properties") ;
    expectedPropertySet.add("Thread_Properties") ;
    expectedPropertySet.add("Timing_Properties") ;
    expectedPropertySet.add("Scheduler_Constants") ;
    expectedPropertySet.add("Generation_Properties") ;
    expectedPropertySet.add("pok_properties") ;
  }

  public Map<String, Resource> extractStandardPropertySets(File resourceDirectory)
        throws Exception
  {
    File[] resourceDirContent = resourceDirectory.listFiles() ;
    File propertySetDir = null ;

    for(int i = 0 ; i < resourceDirContent.length ; i++)
    {
      if(resourceDirContent[i].getName().equals("propertyset"))
      {
        propertySetDir = resourceDirContent[i] ;
        break ;
      }
    }

    if(propertySetDir == null)
    {
      throw new Exception(
            "ERROR: predefined propertyset directory could not be found") ;
    }

    StandAloneInstantiator parser = StandAloneInstantiator.getInstantiator() ;
    FilenameFilter filter = new AADLFileFilter() ;
    List<File> propertySetFiles =
          Arrays.asList(propertySetDir.listFiles(filter)) ;
    List<Resource> propertySetResources = parser.parse(propertySetFiles, false) ;

    for(String resourceName : expectedPropertySet)
    {
      for(Resource r : propertySetResources)
      {
        String fileName = r.getURI().lastSegment() ;

        if(fileName.equalsIgnoreCase(resourceName + ".aadl2"))
        {
          predefinedPropertySets.put(resourceName, r) ;
          break ;
        }
      }
    }

    return predefinedPropertySets ;
  }

  public Map<String, Resource> extractStandardPropertySets(List<Resource> aadlModels)
  {
    List<Resource> removable = new ArrayList<Resource>() ;

    for(Resource r : aadlModels)
    {
      if(r.getContents().get(0) instanceof PropertySet)
      {
        String propertySetName =
              ((PropertySet) r.getContents().get(0)).getName() ;

        if(expectedPropertySet.contains(propertySetName))
        {
          predefinedPropertySets.put(propertySetName, r) ;
          removable.add(r) ;
        }
      }
      else
      {
        continue ;
      }
    }

    for(Resource toRemove : removable)
    {
      aadlModels.remove(toRemove) ;
    }

    return predefinedPropertySets ;
  }

  public static String getDefaultStringValue(String PropertySetName,
                                             String PropertyName)
  {
    String res = "" ;
    Resource r = predefinedPropertySets.get(PropertySetName) ;
    TreeIterator<EObject> it = r.getAllContents() ;

    while(it.hasNext())
    {
      if(it instanceof Property)
      {
        Property p = (Property) it ;

        if(p.getName().equalsIgnoreCase(PropertyName))
        {
          if(p.getDefaultValue() != null &&
                p.getDefaultValue() instanceof StringLiteral)
          {
            StringLiteral sl = (StringLiteral) p.getDefaultValue() ;
            return sl.getValue() ;
          }
        }
      }
    }

    return res ;
  }

}