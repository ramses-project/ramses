package fr.tpt.aadl.ramses.instantiation.manager;

import java.util.ArrayList ;
import java.util.List ;

import org.eclipse.emf.ecore.resource.Resource ;

import fr.tpt.aadl.ramses.control.support.AbstractPredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.instantiation.StandAloneInstantiator ;

public class ContributedAadlRegistration extends AbstractPredefinedAadlModelManager
{ 
  private PredefinedPackagesManager _predefinedPackagesManager;
  private PredefinedPropertiesManager _predefinedPropertiesManager;

  private StandAloneInstantiator _instantiator ;
  
  public ContributedAadlRegistration(StandAloneInstantiator instantiator)
  {
    _instantiator = instantiator ;
    
    _predefinedPackagesManager =
          new PredefinedPackagesManager(_instantiator) ;
    
    _predefinedPropertiesManager = new PredefinedPropertiesManager(_instantiator);
  }
  
  @Override
  public void parsePredefinedAadlModels() throws Exception
  {
    // Always parse the property sets before packages !
    _predefinedPropertiesManager.parsePredefinedPropertySets() ;
    
    _predefinedPackagesManager.parsePredefinedPackages() ;
    
    if(!_predefinedPackagesManager.allPackagesFound())
      throw new Exception(
        "Illegal initialization of ATL transformation launcher: " +
        "some predefined packages not found: " +
        _predefinedPackagesManager.getPackagesNotFound()) ;
  }

  /**
   * @see fr.tpt.aadl.ramses.control.support.PredefinedAadlModelManager#getPredefinedResources()
   */
  @Override
  public List<Resource> getPredefinedResources() {
	List<Resource> result = new ArrayList<Resource>();

    for(int p = 0 ; p < _predefinedPackagesManager.getPackagesCount() ; p++)
	{
	  String name = _predefinedPackagesManager.getPackageName(p) ;
	  Resource r = _predefinedPackagesManager.getPackageResource(name) ;
	  result.add(r);
	}
    for(int p = 0 ; p < _predefinedPropertiesManager.getPropertiesCount() ; p++)
	{
	  String name = _predefinedPropertiesManager.getPropertySetName(p) ;
	  Resource r = _predefinedPropertiesManager.getPropertySetResource(name) ;
	  result.add(r);
	}
    return result;
  }
}