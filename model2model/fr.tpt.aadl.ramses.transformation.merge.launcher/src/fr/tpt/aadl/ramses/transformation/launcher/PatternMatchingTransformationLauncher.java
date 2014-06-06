package fr.tpt.aadl.ramses.transformation.launcher;

import java.io.IOException ;
import java.util.ArrayList ;
import java.util.Collections ;
import java.util.Comparator ;
import java.util.List ;

import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.util.EcoreUtil ;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl ;
import org.eclipse.m2m.atl.emftvm.EmftvmFactory ;
import org.eclipse.m2m.atl.emftvm.Metamodel ;
import org.eclipse.m2m.atl.emftvm.Module ;
import org.eclipse.m2m.atl.emftvm.Rule ;

import fr.tpt.aadl.ramses.control.atl.Aadl2XEMFTVMLauncher ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.transformation.selection.RuleApplicationUtils ;
import fr.tpt.atl.patternmatching.ElementTransformationTuple ;

public class PatternMatchingTransformationLauncher extends Aadl2XEMFTVMLauncher {

	public PatternMatchingTransformationLauncher(
			AadlModelInstantiatior modelInstantiator,
			PredefinedAadlModelManager predefinedResourcesManager) {
		super(modelInstantiator, predefinedResourcesManager);
	}

	private static final String AADLI_MM_URI =
			org.osate.aadl2.instance.InstancePackage.eNS_URI ;
	private static final String AADLBA_MM_URI =
			org.osate.ba.aadlba.AadlBaPackage.eNS_URI ;
	private static final String PM_MM_URI =
			fr.tpt.atl.patternmatching.patternmatchingPackage.eNS_URI ;
	private static final String ATLHOOKS_MM_URI =
			fr.tpt.aadl.ramses.control.atl.hooks.AtlHooksPackage.eNS_URI;
	
	ResourceSet resourceSet;

	@Override
	protected void initTransformationInputs(Resource inputResource)
  {
	  super.initTransformationInputs(inputResource);
	  
	  // Load pattern matching metamodel
	  Metamodel patternMatchinMetaModel = EmftvmFactory.eINSTANCE.createMetamodel();
	  patternMatchinMetaModel.setResource(resourceSet.getResource(URI.createURI(PM_MM_URI), true));
	  env.registerMetaModel("MM_ATL2PM", patternMatchinMetaModel);
	  
  }
	
	@Override
	protected Resource initTransformationOutput(Resource inputResource,
			String outputDirPathName, String resourceSuffix) {
		
		Resource.Factory.Registry.INSTANCE.getExtensionToFactoryMap()
		.put("pml", new XMIResourceFactoryImpl()) ;
		
		String patternMatchingPath = outputDirPathName+inputResource.getURI().lastSegment();
		patternMatchingPath = patternMatchingPath.substring(0, patternMatchingPath.lastIndexOf("."))+".pml";
		URI uri = URI.createFileURI(patternMatchingPath);
		Resource outputResource = resourceSet.getResource(uri, false);
		if(outputResource==null)
		  outputResource = resourceSet.createResource(uri);
		
		return outputResource;
	}

	@Override
	public Resource doTransformation(Resource inputResource,
	                                 String outputDirPathName, 
	                                 String resourceSuffix, 
	                                 final IProgressMonitor monitor)
	{
	  
	  Resource outputResource = super.doTransformation(inputResource, outputDirPathName, resourceSuffix, monitor);
	  for(Module m : getModuleList())
	  {
	    for(Rule r:m.getRules())
	    {
	      List<Rule> inheritedRules = new ArrayList<Rule>();
	      for(Rule superRule:r.getAllESuperRules())
	      {
	        inheritedRules.add(superRule);
	      }

	      Collections.sort(inheritedRules, new Comparator<Rule>(){
	        public int compare(Rule arg0, Rule arg1) {
	          Module m0 = arg0.getModule();
	          Module m1 = arg1.getModule();
	          int index0=-1;
	          for(Module m : env.getModules().values())
	          {
	            index0++;
	            if(m.equals(m0))
	              break;
	          }
	          int index1=-1;
	          for(Module m : env.getModules().values())
	          {
	            index1++;
	            if(m.equals(m1))
	              break;
	          }
	          if(index0>index1)
	            return -1;
	          else if(index0<index1)
	            return 1;
	          return 0;
	        }
	      });
	      List<String> inheritedModuleName = new ArrayList<String>();
	      for(Rule inheritedRule: inheritedRules)
	      {
	        inheritedModuleName.add(getCompleteName(inheritedRule));
	      }
	      RuleApplicationUtils.getRulesInheritenceMap().put(getCompleteName(r), inheritedModuleName);
	    }
	  }
	  
	  String tmpPatternMatchingPath = outputDirPathName+"tmp_"+inputResource.getURI().lastSegment();
	  tmpPatternMatchingPath = tmpPatternMatchingPath.substring(0, tmpPatternMatchingPath.lastIndexOf("."))+".pml";
	  URI tmpUri = URI.createFileURI(tmpPatternMatchingPath);
	  Resource tmpOutputResource = resourceSet.getResource(tmpUri, false);
	  if(tmpOutputResource==null)
	    tmpOutputResource = resourceSet.createResource(tmpUri);
		
		if(outputResource.getContents() == null || outputResource.getContents().isEmpty())
		{
			for(EObject obj : tmpOutputResource.getContents())
			{
				ElementTransformationTuple copy = (ElementTransformationTuple) EcoreUtil.copy(obj);
				outputResource.getContents().add(copy);
			}
		}
		else
		{
			for(EObject obj : tmpOutputResource.getContents())
			{
				if(obj instanceof ElementTransformationTuple)
				{
					ElementTransformationTuple newTuple = (ElementTransformationTuple) obj;
					if(resultsContainsKey(outputResource.getContents(), newTuple.getKey()))
					{
						ElementTransformationTuple copy = (ElementTransformationTuple) EcoreUtil.copy(obj);
						outputResource.getContents().add(copy);
					}
				}
			}
		}
		
		try
    {
      outputResource.save(null);
    }
    catch(IOException e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
		EcoreUtil.resolveAll(resourceSet);
		// Return model
		return outputResource;
	}

	private String getCompleteName(Rule r)
	{
		String absoluteModuleName = r.getModule().getName();
		String moduleName = absoluteModuleName.substring(absoluteModuleName.lastIndexOf("/")+1, absoluteModuleName.length());
		return moduleName+"."+r.getName();
	}
	
	private boolean resultsContainsKey(List<EObject> resultTuples, EList key) {
		for(EObject resultEObject:resultTuples)
		{
			ElementTransformationTuple resultTuple = (ElementTransformationTuple) resultEObject;
			List resultKey = resultTuple.getKey();
			if(resultKey.size()!=key.size())
				continue;
			boolean same=true;
			for(int i=0; i<resultKey.size(); i++)
			{
				if(false == resultKey.get(i).equals(key.get(i)))
				{
					same=false;
					break;
				}
			}
			if(same)
				return true;
		}
		return false;
	}

	public void setResourceSet(ResourceSet resourceSet) {
		this.resourceSet = resourceSet;
	}
	
}
