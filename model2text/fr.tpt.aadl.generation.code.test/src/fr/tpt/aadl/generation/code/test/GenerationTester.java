package fr.tpt.aadl.generation.code.test ;

import java.io.File ;
import java.util.ArrayList ;
import java.util.List ;

import org.eclipse.emf.common.util.TreeIterator ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.PublicPackageSection ;

import fr.tpt.aadl.ramses.control.cli.StaticServiceRegistry ;
import fr.tpt.aadl.ramses.control.core.ToolSuiteLauncher ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistryProvider ;
import fr.tpt.aadl.ramses.generation.c.AadlToCUnparser ;

public class GenerationTester
{

  public static void main(String[] args)
  {
    ToolSuiteLauncher launcher = new ToolSuiteLauncher() ;

    try
    {
      ServiceRegistryProvider.setDefault(new StaticServiceRegistry()) ;
    }
    catch(Exception e1)
    {
      // TODO Auto-generated catch block
      e1.printStackTrace() ;
    }

    List<File> test = new ArrayList<File>() ;
    test.add(new File("test/dummyPropertySet.aadl")) ;
    test.add(new File("test/dummySubRoutine.aadl")) ;
    test.add(new File("test/dummyTypes.aadl")) ;
    test.add(new File("test/ba_generation_test_001.aadl")) ;
    launcher.parsePredefinedRessources(new File(
          "../../model2model/fr.tpt.aadl.transformation.atl/aadl_resources/")) ;
    List<Resource> parsedFiles = launcher.parse(test) ;
    AadlToCUnparser generator = new AadlToCUnparser() ;

    for(Resource r : parsedFiles)
    {
      TreeIterator<EObject> iter = r.getAllContents() ;

      while(iter.hasNext())
      {
        EObject elt = iter.next() ;

        if(elt instanceof PublicPackageSection)
        {
          generator.process((Element) elt) ;
        }
      }
    }

    generator.saveGeneratedFilesContent(new File("test")) ;
  }
}
