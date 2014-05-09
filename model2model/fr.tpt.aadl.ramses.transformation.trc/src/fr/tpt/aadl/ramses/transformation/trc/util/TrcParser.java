package fr.tpt.aadl.ramses.transformation.trc.util;

import java.util.Iterator;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import fr.tpt.aadl.ramses.transformation.trc.Module;
import fr.tpt.aadl.ramses.transformation.trc.Transformation;
import fr.tpt.aadl.ramses.transformation.trc.TransformationImpact;
import fr.tpt.aadl.ramses.transformation.trc.TrcPackage;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification;

public class TrcParser {

	
	public static TrcSpecification parse(String trcPath, 
	                                     ResourceSet resourceSet){
		
		final Resource resource;
		
		URI p_uri = URI.createFileURI(trcPath);
		
		resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("trc", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(TrcPackage.eNS_URI, TrcPackage.eINSTANCE);
		
		if (resourceSet.getURIConverter().exists(p_uri, null)) {
			resource = resourceSet.getResource(p_uri, true);
			TrcSpecification result = (TrcSpecification) resource.getContents().get(0);
			TrcUtils.setTrcSpecification(result);
			return result;	
		} else {
			System.out.println("TRC of specified path ("+trcPath+") does not exit.");
		}
		
		return null;
	}
	
	
	public static Transformation getTransformationById(String transformationId){
		TrcSpecification specification = TrcUtils.getTrcSpecification();
		Iterator transformationsIt = specification.getTransformations().getTransformations().iterator();
		while (transformationsIt.hasNext()){
			Transformation transformation = (Transformation)transformationsIt.next();
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
						//System.out.println("Transformation qualified name: "+qualifiedTransformationName);

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
		Iterator transformationsIt = specification.getTransformations().getTransformations().iterator();
		while (transformationsIt.hasNext()){
			Transformation transformation = (Transformation)transformationsIt.next();
			for(String ruleName:(List<String>)transformation.getRuleName())
			{
				if (ruleName.equals(transformationName))
					return transformation;
			}
		}
		return null;
	}
	
	
	public static int getQualityImpactValue(Transformation transformation, String qualityAttributeName){
		
		List<TransformationImpact> impactsList = transformation.getImpacts();
		Iterator<TransformationImpact> impactsIt = impactsList.iterator(); 
		while (impactsIt.hasNext()){
			TransformationImpact impactObject = impactsIt.next();
			if (impactObject.getQualityAttributeName().equals(qualityAttributeName)){
				return impactObject.getImpactValue();
			}
		}
		System.out.println("WARNING: in TRC, no information provided for sensitivity: "+qualityAttributeName);
		System.out.println("INFO: name of the sensitivity in RDAL must match the name of impacts in TRC.");
		return 0;
	} 
	
	
}
