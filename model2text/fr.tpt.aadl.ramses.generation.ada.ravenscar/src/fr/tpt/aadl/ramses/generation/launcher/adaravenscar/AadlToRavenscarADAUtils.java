package fr.tpt.aadl.ramses.generation.launcher.adaravenscar;

import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;

import fr.tpt.aadl.ramses.generation.ada.GenerationUtilsADA;

public class AadlToRavenscarADAUtils {

	public static String getFeatureLocalIdentifier(FeatureInstance fi)
	  {
	    return GenerationUtilsADA.getGenerationADAIdentifier(fi.getComponentInstancePath()+"_"+fi.getName());
	  }
	  
	  public static String getFeatureGlobalIdentifier(FeatureInstance fi)
	  {
	    return GenerationUtilsADA.getGenerationADAIdentifier(fi.getComponentInstancePath()+"_"+fi.getName()+"_global");
	  }
	  
	  public static String getComponentInstanceIdentifier(ComponentInstance instance)
	  {
	    return GenerationUtilsADA.getGenerationADAIdentifier(instance.getComponentInstancePath());
	  }

}