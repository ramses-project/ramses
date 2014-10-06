/**
 * AADL-RAMSES
 *
 * Copyright © 2012 TELECOM ParisTech and CNRS
 *
 * TELECOM ParisTech/LTCI
 *
 * Authors: see AUTHORS
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Eclipse Public License as published by Eclipse,
 * either version 1.0 of the License, or (at your option) any later version.
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * Eclipse Public License for more details.
 * You should have received a copy of the Eclipse Public License
 * along with this program.  If not, see
 * http://www.eclipse.org/org/documents/epl-v10.php
 */

package fr.tpt.aadl.ramses.control.atl;

import java.io.File ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.Collection ;
import java.util.Collections ;
import java.util.Iterator ;
import java.util.List ;
import java.util.Map ;
import java.util.concurrent.Callable ;
import java.util.concurrent.FutureTask ;
import java.util.concurrent.TimeUnit ;
import java.util.concurrent.TimeoutException ;

import org.apache.log4j.Logger ;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.ResourcesPlugin ;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.core.runtime.Path ;
import org.eclipse.core.runtime.Platform ;
import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.util.EcoreUtil ;
import org.eclipse.xtext.nodemodel.ICompositeNode ;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils ;
import org.osate.aadl2.Aadl2Package ;
import org.osate.aadl2.AnnexSubclause ;
import org.osate.aadl2.Classifier ;
import org.osate.aadl2.DefaultAnnexSubclause ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.modelsupport.errorreporting.ParseErrorReporter ;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil ;
import org.osate.annexsupport.AnnexParser ;
import org.osate.annexsupport.AnnexResolver ;
import org.osate.ba.AadlBaParserAction ;

import antlr.RecognitionException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.AbstractAadlToAadl ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlResourceValidator ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;

public abstract class AadlToTargetSpecificAadl extends AbstractAadlToAadl
{
	protected AadlModelInstantiatior _modelInstantiator ;
	
	protected PredefinedAadlModelManager _predefinedAadlModels ;
	
	private static Logger _LOGGER = Logger.getLogger(AadlToTargetSpecificAadl.class) ;
	
	public AadlToTargetSpecificAadl(AadlModelInstantiatior modelInstantiator,
	                                PredefinedAadlModelManager predefinedAadlModels)
  {
    _modelInstantiator = modelInstantiator ;
    _predefinedAadlModels = predefinedAadlModels ;
  }
  
  protected static AadlResourceValidator extractor;
   
  public Resource transform(Resource inputResource,
		  					String targetId,
                            File outputDir,
                            IProgressMonitor monitor) throws TransformationException
  {
	Aadl2AadlEMFTVMLauncher atlLauncher =
			new Aadl2AadlEMFTVMLauncher(_modelInstantiator,
					_predefinedAadlModels) ;
	atlLauncher.setOutputPackageName("refined_model") ;
	AtlTransfoLauncher.initTransformation();
	if(AtlTransfoLauncher.getRamsesExecEnv(targetId)!=null)
		return atlLauncher.generationEntryPoint(inputResource,
				targetId, outputDir, monitor) ;
    initAtlFileNameList(RamsesConfiguration.getAtlResourceDir()) ;

    {
      ArrayList<File> atlFiles = new ArrayList<File>() ;

      for(String fileName : AtlTransfoLauncher.getUninstanciateTransformationModuleList())
      {
    	atlFiles.add(new File(RamsesConfiguration.getAtlResourceDir() + File.separator + fileName)) ;
      }
      for(String fileName : _atlFileNames)
      {
        atlFiles.add(new File(RamsesConfiguration.getAtlResourceDir() + File.separator + fileName)) ;
      }
      return atlLauncher.generationEntryPoint(inputResource,
                                              atlFiles, outputDir, monitor) ;
    }
  }
  
  @Override
  public Resource unparse(Resource inputResource, Resource expandedResult,
                          File outputDir, IProgressMonitor monitor) throws GenerationException
  {
	  String aadlGeneratedFileName = expandedResult.getURI().lastSegment();
	  aadlGeneratedFileName = aadlGeneratedFileName.replaceFirst(
	  		  ".aaxl2", ".aadl2");

	  File outputModelDir =  new File(outputDir.getAbsolutePath()+"/refined-models");
	  if(outputModelDir.exists()==false)
		  outputModelDir.mkdir();
	  String outputFilePath=outputModelDir.getAbsolutePath()+File.separator+aadlGeneratedFileName;
	  File outputFile = new File(outputFilePath);

	  _modelInstantiator.serialize(expandedResult, outputFilePath);

	  try
	  {
		  return extractAadlResource(inputResource, outputFile, monitor);
	  }
	  catch (Exception ex)
	  {
	    String msg = "failed to extract AADL resources" ;
        throw new GenerationException(msg, ex) ;
	  }
  }

  public static Resource extractAadlResource(Resource inputResource,
                                             File outputFile, 
                                             IProgressMonitor monitor)
                                        throws IOException, RecognitionException
  {
    URI uri ;
    SystemInstance si = (SystemInstance) inputResource.getContents().get(0) ;
    final Resource xtextResource ;
    if(OsateResourceUtil.USES_GUI)
    {
      String workspaceLocation =
            ResourcesPlugin.getWorkspace().getRoot().getLocationURI().getPath() ;
      int outputPathHeaderIndex = workspaceLocation.length() ;
      String outputAbsolutePath = outputFile.getAbsolutePath().toString() ;
      String outputPlatformRelativePath = "" ;
      String finalResourcePath = "";
      String projectName=null;
      if(outputPathHeaderIndex > 0)
      {
        String inputURI = inputResource.getURI().toString() ;
        projectName =
              inputURI.substring(inputURI.indexOf("resource") + 9) ;
        projectName = projectName.substring(0, projectName.indexOf('/')) ;
        outputPathHeaderIndex = outputAbsolutePath.indexOf(projectName) ;
        outputPlatformRelativePath =
              outputAbsolutePath.substring(outputPathHeaderIndex) ;
      }
      
      if (Platform.getOS().equalsIgnoreCase(Platform.OS_WIN32))
      {
        workspaceLocation = workspaceLocation.substring(1, workspaceLocation.length());
        workspaceLocation = workspaceLocation.replace("/", "\\");
        outputPlatformRelativePath =
            outputAbsolutePath.replace(workspaceLocation, "") ;
        outputPlatformRelativePath = outputPlatformRelativePath.replace("\\", "/");
      }
      else
      {
        finalResourcePath =
            outputAbsolutePath.replace(workspaceLocation + Path.SEPARATOR, "") ;
      }
      if(finalResourcePath.charAt(0) == Path.SEPARATOR)
        uri = URI.createPlatformResourceURI(outputPlatformRelativePath, true);
      else
        uri = URI.createPlatformResourceURI(outputPlatformRelativePath, true) ;
      
      OsateResourceUtil.refreshResourceSet();
      ResourceSet rs = OsateResourceUtil.getResourceSet() ;
      xtextResource = rs.getResource(uri, true) ;
      IResource folderToUpdate = ResourcesPlugin.getWorkspace().getRoot().findMember(projectName);
      try {
		folderToUpdate.refreshLocal(IResource.DEPTH_INFINITE, monitor);
		
	  } catch (CoreException e) {
		String errMsg = "could not refresh output directory" ;
        _LOGGER.fatal(errMsg, e) ;
        throw new RuntimeException(errMsg, e) ;
	  }
    }
    else
    {
      uri = URI.createFileURI(outputFile.getAbsolutePath().toString()) ;
      xtextResource =
            si.getSystemImplementation().eResource().getResourceSet()
                  .getResource(uri, true) ;
      xtextResource.load(null) ;

      // Implements a timeout of 10s.

      Callable<Boolean> app = new Callable<Boolean>()
      {

        @Override
        public Boolean call()
        {
          AadlResourceValidator.validate(xtextResource.getResourceSet()) ;
          return true ;
        }

      } ;
      FutureTask<Boolean> ft = new FutureTask<Boolean>(app) ;
      new Thread(ft).start() ;

      try
      {
        ft.get(10, TimeUnit.SECONDS) ;
      }
      catch(TimeoutException e)
      {
        //Do nothing. Don't rethrow nor log: validation may never end.
      }
      catch(Exception e) //catch InterruptedException & ExecutionException
      {
        String errMsg = "internal error" ;
        _LOGGER.fatal(errMsg, e) ;
        throw new RuntimeException(errMsg, e) ;
      }

      ServiceRegistry sr = ServiceProvider.getServiceRegistry() ;
      ParseErrorReporter errReporter = ServiceRegistry.PARSE_ERR_REPORTER ;
      AnalysisErrorReporterManager errManager =
          ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER ;
      Iterator<EObject> iter = xtextResource.getAllContents() ;
      while(iter.hasNext())
      {
        Collection<Object> dasList =
              EcoreUtil.getObjectsByType(iter.next().eContents(),
                                         Aadl2Package.eINSTANCE
                                               .getDefaultAnnexSubclause()) ;
        for(Object o : dasList)
        {
          DefaultAnnexSubclause das = (DefaultAnnexSubclause) o ;
          String annexName = das.getName() ;
          if(annexName.equalsIgnoreCase(AadlBaParserAction.ANNEX_NAME))
          {
            AnnexParser ap = sr.getParser(annexName) ;
            ICompositeNode node = NodeModelUtils.findActualNodeFor(das) ;
            String annexText = das.getSourceText() ;
            if(annexText.length() > 6)
            {
              annexText = annexText.substring(3, annexText.length() - 3) ;
            }
            AnnexSubclause as =
                  ap.parseAnnexSubclause(annexName, annexText, outputFile
                                               .getName(), node.getStartLine(),
                                         node.getOffset(), errReporter) ;
            AnnexResolver ar = sr.getResolver(annexName) ;
            if(as != null && errReporter.getNumErrors() == 0)
            {
              as.setName(annexName) ;
              // replace default annex library with the new one.
              EList<AnnexSubclause> ael =
                    ((Classifier) das.eContainer()).getOwnedAnnexSubclauses() ;
              int idx = ael.indexOf(das) ;
              ael.add(idx, as) ;
              ael.remove(das) ;
              List<AnnexSubclause> annexElements =
                    Collections.singletonList(as) ;
              ar.resolveAnnex(das.getName(), annexElements, errManager) ;
            }
          }
        }
      }
    }

    ServiceRegistry sr = ServiceProvider.getServiceRegistry() ;
    ParseErrorReporter errReporter = ServiceRegistry.PARSE_ERR_REPORTER ;
    AnalysisErrorReporterManager errManager =
        ServiceRegistry.ANALYSIS_ERR_REPORTER_MANAGER ;
    Iterator<EObject> iter = xtextResource.getAllContents() ;
    while(iter.hasNext())
    {
      Collection<Object> dasList =
            EcoreUtil.getObjectsByType(iter.next().eContents(),
                                       Aadl2Package.eINSTANCE
                                             .getDefaultAnnexSubclause()) ;
      for(Object o : dasList)
      {
        DefaultAnnexSubclause das = (DefaultAnnexSubclause) o ;
        String annexName = das.getName() ;
        if(annexName.equalsIgnoreCase(AadlBaParserAction.ANNEX_NAME))
        {
          AnnexParser ap = sr.getParser(annexName) ;
          ICompositeNode node = NodeModelUtils.findActualNodeFor(das) ;
          String annexText = das.getSourceText() ;
          if(annexText.length() > 6)
          {
            annexText = annexText.substring(3, annexText.length() - 3) ;
          }
          AnnexSubclause as =
                ap.parseAnnexSubclause(annexName, annexText, outputFile
                                             .getName(), node.getStartLine(),
                                       node.getOffset(), errReporter) ;
          AnnexResolver ar = sr.getResolver(annexName) ;
          if(as != null && errReporter.getNumErrors() == 0)
          {
            as.setName(annexName) ;
            // replace default annex library with the new one.
            EList<AnnexSubclause> ael =
                  ((Classifier) das.eContainer()).getOwnedAnnexSubclauses() ;
            int idx = ael.indexOf(das) ;
            ael.add(idx, as) ;
            ael.remove(das) ;
            List<AnnexSubclause> annexElements = Collections.singletonList(as) ;
            ar.resolveAnnex(das.getName(), annexElements, errManager) ;
          }
        }
      }
    }
    return xtextResource ;
  }

abstract public void setParameters(Map<Enum<?>, Object> parameters);
 
  
  public static void validate(ResourceSet rs)
  {
	AadlResourceValidator.validate(rs);
  }
  
  public Resource transformWokflow(Resource inputResource,
		  							String transformationId,
		  							List<String> resourceFileNameList,
		  							File outputDir,
		  							String outputPackageName,
		  							IProgressMonitor monitor) throws TransformationException
  {
	Aadl2AadlEMFTVMLauncher atlLauncher =
	        new Aadl2AadlEMFTVMLauncher(_modelInstantiator, _predefinedAadlModels) ;
	atlLauncher.setOutputPackageName(outputPackageName) ;
	  
	AtlTransfoLauncher.initTransformation();
	if(transformationId!=null && AtlTransfoLauncher.getRamsesExecEnv(transformationId)!=null)
	  return atlLauncher.generationEntryPoint(inputResource,
			  transformationId, outputDir, monitor) ;
	
	ArrayList<File> atlFiles = new ArrayList<File>() ;
	for(String s : AtlTransfoLauncher.getUninstanciateTransformationModuleList())
	{
	  atlFiles.add(new File(RamsesConfiguration.getAtlResourceDir() +
			  File.separator +
			  s)) ;
	}
    for(String resourceFileName : resourceFileNameList)
    {
      String resourcePath = resourceFileName ;
      if(false == new File(resourcePath).exists())
        resourcePath =
              RamsesConfiguration.getAtlResourceDir() + File.separator +
                    resourceFileName ;
      atlFiles.add(new File(resourcePath)) ;
    }

    return atlLauncher.generationEntryPoint(inputResource, atlFiles, outputDir, monitor) ;
  }
}