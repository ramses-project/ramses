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

package fr.tpt.aadl.ramses.generation.target.specific;

import java.io.File ;
import java.io.IOException ;
import java.io.PrintWriter ;
import java.io.StringWriter ;
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;
import java.util.concurrent.TimeUnit ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.CoreException ;
import org.eclipse.core.runtime.IConfigurationElement ;
import org.eclipse.core.runtime.IExtension ;
import org.eclipse.core.runtime.IExtensionPoint ;
import org.eclipse.core.runtime.IExtensionRegistry ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.core.runtime.OperationCanceledException ;
import org.eclipse.core.runtime.Platform ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.swt.SWT ;
import org.eclipse.swt.widgets.MessageBox ;
import org.eclipse.swt.widgets.Shell ;
import org.eclipse.ui.PlatformUI ;
import org.osate.aadl2.AadlPackage ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.PublicPackageSection ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil ;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService ;

import fr.tpt.aadl.ramses.analysis.AnalysisResult ;
import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory ;
import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult ;
import fr.tpt.aadl.ramses.analysis.util.AnalysisParser ;
import fr.tpt.aadl.ramses.analysis.util.AnalysisUtils ;
import fr.tpt.aadl.ramses.control.atl.AadlModelValidator ;
import fr.tpt.aadl.ramses.control.atl.AadlToTargetSpecificAadl ;
import fr.tpt.aadl.ramses.control.atl.AtlTransfoLauncher ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer ;
import fr.tpt.aadl.ramses.control.support.config.ConfigStatus ;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration ;
import fr.tpt.aadl.ramses.control.support.generator.Aadl2StandaloneUnparser ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelsManagerImpl ;
import fr.tpt.aadl.ramses.control.support.instantiation.ParseException ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;
import fr.tpt.aadl.ramses.control.workflow.AbstractLoop ;
import fr.tpt.aadl.ramses.control.workflow.ResolutionMethod ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPilot ;
import fr.tpt.aadl.ramses.transformation.trc.TrcSpecification ;


public class AadlTargetSpecificGenerator implements Generator
{
  protected AadlToTargetSpecificAadl _targetTrans ;
  
  protected AadlTargetSpecificCodeGenerator _codeGen ;
  
  protected String _registryName = null ;
  
  public Resource currentImplResource = null;
  
  private Resource _analysisResults = null;
  
  private Map<String, Resource> modelsMap = new HashMap<String, Resource>();
  
  private String systemToInstantiate = null;
  
  public AadlModelInstantiatior _modelInstantiator ;

  private AadlModelValidator _modelValidator;
  
  public PredefinedAadlModelManager _predefinedResourceManager;

  private AnalysisArtifact analysisArtefact = null ;
  
  /** Loop debug  (loopValidIteration must be negative to disable debug) **/
  private static int loopValidIteration = -1;
  
  private List<AnalysisResult> analysis_results = new ArrayList<AnalysisResult>();
  /****************/
  

  private static Logger _LOGGER = Logger.getLogger(AadlTargetSpecificGenerator.class) ;
  
  public AadlTargetSpecificGenerator(AadlToTargetSpecificAadl targetTrans,
                                     AadlTargetSpecificCodeGenerator codeGen,
                                     AadlModelInstantiatior modelInstantiator,
                                     AadlModelValidator modelValidator,
                                     PredefinedAadlModelManager predefinedResourceManager)
  {
    _targetTrans = targetTrans ;
    _codeGen = codeGen ;
    _modelInstantiator = modelInstantiator ;
    _modelValidator = modelValidator;
    _predefinedResourceManager = predefinedResourceManager;
  }
  
  public void setRegistryName(String registryName)
  {
    _registryName = registryName ;
  }
  
  @Override
  public String getRegistryName()
  {
    return _registryName ;
  }

  @Override
  public String getPluginName()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public String getPluginId()
  {
    // TODO Auto-generated method stub
    return null ;
  }

  @Override
  public void generate(SystemInstance systemInstance,
		  			   RamsesConfiguration config,
		  			   File[] includeDirs,
                       AnalysisErrorReporterManager errManager,
                       IProgressMonitor monitor) throws GenerationException,
                                                        TransformationException
  {
    String targetId = config.getTargetId();
    File outputDir = config.getRamsesOutputDir();
    File runtimeDir = config.getRuntimePath(); 
	
    Resource inputResource = systemInstance.eResource() ;
    Resource r;
    if(_modelValidator != null)
    {
    	monitor.subTask("Model validation: check compatibility for refinement.");
    	r = _modelValidator.validate(inputResource, targetId+Names.VALIDATOR_SUFFIX, errManager, monitor);
    	if(false==r.getContents().isEmpty())
    	{
    	  for(EObject err : r.getContents())
    	  {
          if(err instanceof fr.tpt.aadl.ramses.constraintsreporter.Error)
          {
            fr.tpt.aadl.ramses.constraintsreporter.Error constraintError =
                            (fr.tpt.aadl.ramses.constraintsreporter.Error) err ;
            errManager.error((Element) constraintError.getObject(),
                             constraintError.getMessage()) ;
            ServiceProvider.SYS_ERR_REP.error(constraintError.getMessage(), true) ;
            _LOGGER.error(constraintError.getMessage());
          }
        }
        return ;
    	}
    }
    
    if(monitor.isCanceled())
    {
      String msg = "generation has been canceled after validation" ;
      _LOGGER.trace(msg);
      throw new OperationCanceledException(msg) ;
    }
    
    if(_targetTrans != null)
    {
      monitor.subTask("Model transformation (refinement) ...");
      r = _targetTrans.transform(inputResource, targetId, outputDir, monitor);
    }
    else
     r = inputResource;
    
    if(monitor.isCanceled())
    {
      String msg = "generation has been canceled after transformation" ;
      _LOGGER.trace(msg);
      throw new OperationCanceledException(msg) ;
    }
    
    _codeGen.generate(r, runtimeDir, outputDir, includeDirs, monitor) ;
  }

  @Override
  public Map<String, Resource> generateWorkflow(SystemInstance systemInstance,
                                                RamsesConfiguration config,
                                                WorkflowPilot xmlPilot,
                                                File[] includeDirs,
                                                AnalysisErrorReporterManager errManager,
                                                IProgressMonitor monitor) 
                                                    throws GenerationException,
                                                    TransformationException,
                                                    AnalysisException
  {
    
    long startTime = System.nanoTime();
    
    currentImplResource = systemInstance.eResource();
    
    String targetId = config.getTargetId();
    File outputDir = config.getRamsesOutputDir();
    File runtimeDir = config.getRuntimePath(); 
    ResourceSet resourceSet = currentImplResource.getResourceSet();
    if(_analysisResults == null)
    {
      _analysisResults = AnalysisParser.parse(config.getRamsesOutputDir().getAbsolutePath()+"/analysis_results.ares",
                                              resourceSet).eResource() ;
    }
    analysisArtefact = (AnalysisArtifact) _analysisResults.getContents().get(0); 
    if(monitor.isCanceled())
    {
      String msg = "generation has been canceled after analysis result" ;
      _LOGGER.trace(msg);
      throw new OperationCanceledException(msg) ;
    }

    Resource r = systemInstance.eResource() ;
    if(_modelValidator != null)
    {
      monitor.subTask("Model validation: check compatibility for refinement.") ;
      Resource errRes = _modelValidator.validate(r, targetId+Names.VALIDATOR_SUFFIX, errManager, monitor) ;
      if(false == errRes.getContents().isEmpty())
      {
        for(EObject err : errRes.getContents())
        {
          if(err instanceof fr.tpt.aadl.ramses.constraintsreporter.Error)
          {
            fr.tpt.aadl.ramses.constraintsreporter.Error constraintError =
                                                                           (fr.tpt.aadl.ramses.constraintsreporter.Error) err ;
            errManager.error((Element) constraintError.getObject(),
                             constraintError.getMessage()) ;
            ServiceProvider.SYS_ERR_REP.error(constraintError.getMessage(), true) ;
            _LOGGER.error(constraintError.getMessage());
          }
        }
        return null;
      }
    }

    if(monitor.isCanceled())
    {
      String msg = "generation has been canceled after validation" ;
      _LOGGER.trace(msg);
      throw new OperationCanceledException(msg) ;
    }

    SystemInstance currentInstance = systemInstance ;
    String rootModelId = xmlPilot.getInputModelId() ;
    if(rootModelId != null && !rootModelId.isEmpty())
      modelsMap.put(rootModelId, r) ;

    systemToInstantiate = xmlPilot.getOutputModelId() + ".impl" ;
    PublicPackageSection pps = (PublicPackageSection) systemInstance.
                                                   getComponentImplementation().
                                                   getOwner() ;
    AadlPackage p = (AadlPackage) pps.getOwner() ;
    final String initialPackageName = p.getName() ;

    int transfoCounter = 0 ;
    
    while(xmlPilot.hasNextOperation())
    {
      String operation = xmlPilot.getNextOperation() ;
      
      if(operation == null)
        return modelsMap;
      
      if(operation.equals("analysis"))
      {
        monitor.subTask("Model analysis: " + xmlPilot.getAnalysisName());
        doAnalysis(xmlPilot, config, monitor, errManager, 0) ;
      }
      else if(operation.equals("transformation"))
      {
        monitor.subTask("Model transformation " + ((xmlPilot.getTransformationName()!=null) ? xmlPilot.getTransformationName():""));
        currentInstance = doTransformation(xmlPilot, config, monitor) ;
        r = currentInstance.eResource() ;
      }
      else if(operation.equals("unparse"))
      {
        String pkgName = initialPackageName + "_" + transfoCounter ;
        monitor.subTask("Unparse output model: " + pkgName);

        doUnparse(currentInstance.eResource(), currentImplResource, outputDir,
                  pkgName, monitor) ;

        transfoCounter++ ;
      }
      else if(operation.equals("errorstate"))
      {
        doErrorState() ;
      }
      else if(operation.equals("generation"))
      {
        Resource inputResource = modelsMap.get(xmlPilot.getInputModelId());
        if(inputResource!=null)
          r = inputResource;
        if(runtimeDir==null)
          throw new GenerationException("runtime path was not set, code generation cannot be completed.");
        doGeneration(runtimeDir, outputDir, includeDirs, r, monitor) ;
      }
      else if(operation.equals("loop"))
      {
          try
          {
            doLoop(xmlPilot.getLoop(), errManager, xmlPilot, config, monitor) ;
          }
          catch(ParseException e)
          {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            _LOGGER.fatal(sw.toString());
          }
          catch(ConfigurationException e)
          {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            _LOGGER.fatal(sw.toString());
          }
          catch(IOException e)
          {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            e.printStackTrace(pw);
            _LOGGER.fatal(sw.toString());
          }
        
      }
      else
      {
        String msg = "undefined workflow operation: " + operation ;
        _LOGGER.error(msg) ;
        ServiceProvider.SYS_ERR_REP.error(msg, true) ;
      }
      
      if(monitor.isCanceled())
      {
        String msg = "generation has been canceled after xml operation \'" +
                     operation + '\'';
        _LOGGER.trace(msg);
        throw new OperationCanceledException(msg) ;
      }
      
      xmlPilot.goForward() ;
      analysisArtefact.getResults().addAll(analysis_results);
    }
    
    if(false==analysisArtefact.getResults().isEmpty())
    {
      // save analysis results
      try
      {
//        File analysisResultFile = new File(config.getRamsesOutputDir().getAbsolutePath()+"/analysis_results.ares");
//        URI uri = URI.createFileURI(analysisResultFile.getAbsolutePath());
//        ResourceSet rs = currentImplResource.getResourceSet();
//        Resource resResource = rs.getResource(uri, analysisResultFile.exists());
//        if(resResource==null)
//          resResource = rs.createResource(uri);
//        if(resResource.getContents().isEmpty())
//          resResource.getContents().add(analysisArtefact);
        _analysisResults.save(null);
      }
      catch(IOException e)
      {
        String message = "Could not save analysis results normalized for ramses";
        _LOGGER.fatal(message);
      }
    }
    long duration = System.nanoTime() - startTime;
    
    long elapsedTimeMinutes = TimeUnit.MINUTES.convert(duration, TimeUnit.NANOSECONDS);
    
    long diffSeconds = TimeUnit.SECONDS.convert(elapsedTimeMinutes, TimeUnit.MINUTES);
    long elapsedTimeSeconds = TimeUnit.SECONDS.convert(duration, TimeUnit.NANOSECONDS);
    
    long timeMinuteSeconds = elapsedTimeSeconds - diffSeconds;
    
    _LOGGER.trace("\n\n\t\t Elapsed time = " + elapsedTimeMinutes + " minutes, " +
        +timeMinuteSeconds+" seconds," +
        " (" + duration+" nanoseconds)\n\n");
    
    return modelsMap ;
  }

  @Override
  public void cleanUp()
  {
    modelsMap.clear();
  }
  
  private void doAnalysis(WorkflowPilot workflowPilot, RamsesConfiguration config,
                          IProgressMonitor monitor,
                          AnalysisErrorReporterManager errManager,
                          int iterationCounter) throws AnalysisException
  {
    String analysisName = workflowPilot.getAnalysisName();
    String analysisMode = workflowPilot.getAnalysisMode();
    String analysisModelInputIdentifier = workflowPilot.getInputModelId();
    String analysisModelOutputIdentifier = workflowPilot.getOutputModelId();
    doAnalysis(analysisName,analysisMode,analysisModelInputIdentifier,
               analysisModelOutputIdentifier, 
               errManager,workflowPilot,config,monitor,iterationCounter);
  }
  
  private void doAnalysis(String analysisName, String analysisMode,
                          String analysisModelInputIdentifier,
                          String analysisModelOutputIdentifier,
                          AnalysisErrorReporterManager errManager,
                          WorkflowPilot workflowPilot,
                          RamsesConfiguration config,
                          IProgressMonitor monitor,
                          int iterationCounter) throws AnalysisException
  {
    _modelInstantiator = new AadlModelsManagerImpl(errManager) ;

    
    Resource inputResource = modelsMap.get(analysisModelInputIdentifier) ;
    SystemInstance currentInstance ;
    PropertiesLinkingService pls = new PropertiesLinkingService() ;
    if(inputResource.getContents().get(0) instanceof AadlPackage)
    {
      SystemImplementation si =
            (SystemImplementation) pls
                  .findNamedElementInsideAadlPackage(systemToInstantiate,
                                                     ((AadlPackage) inputResource
                                                           .getContents()
                                                           .get(0))
                                                           .getOwnedPublicSection()) ;
      //Check if instance model already exists
      URI instanceModelURI = OsateResourceUtil.getInstanceModelURI(si) ;
      Resource r =
            OsateResourceUtil.getResourceSet().getResource(instanceModelURI,
                                                           false) ;
      if(r != null)
      {
        currentInstance = (SystemInstance) r.getContents().get(0) ;
      }
      //otherwise produce one
      else
      {
        currentInstance = _modelInstantiator.instantiate(si) ;
      }
    }
    else
    {
      currentInstance = (SystemInstance) inputResource.getContents().get(0) ;
    }

    String msg = "Analysis launched : " + analysisName +
                 " | Analysis mode : " + analysisMode ;
    _LOGGER.trace(msg);
    
    ServiceRegistry sr = ServiceProvider.getServiceRegistry() ;
    Analyzer a = sr.getAnalyzer(analysisName) ;
    a.setIterationCounter(iterationCounter);
    
    Map<String, Object> analysisParam = new HashMap<String, Object>() ;
    
    analysisParam.put("Mode", analysisMode) ;
    if(analysisModelOutputIdentifier != null)
      analysisParam.put("OutputModelIdentifier", analysisModelOutputIdentifier) ;
    
    if(a == null)
    {
      String errMsg = "Unknown analysis: " + analysisName ;
      _LOGGER.error(msg);
      ServiceProvider.SYS_ERR_REP.error(errMsg, true);
    }
    else
    {

      a.setParameters(analysisParam) ;
      a.performAnalysis(currentInstance, config, errManager, monitor) ;
      a.setParameters(analysisParam) ;
      Resource result = (Resource) analysisParam.get("OutputResource") ;
      if(result != null)
      {
        systemToInstantiate = analysisModelOutputIdentifier + ".impl" ;
        SystemImplementation si =
              (SystemImplementation) pls
                    .findNamedElementInsideAadlPackage(systemToInstantiate,
                                                       ((AadlPackage) result
                                                             .getContents()
                                                             .get(0))
                                                             .getOwnedPublicSection()) ;

        SystemInstance sinst = _modelInstantiator.instantiate(si) ;
        modelsMap.put(analysisModelOutputIdentifier, sinst.eResource()) ;
      }
      
      AnalysisArtifact aa = (AnalysisArtifact) analysisParam.get("AnalysisResult");
      if(aa!=null)
      {
        for(Object r: aa.getResults())
        {
          analysis_results.add((AnalysisResult) r);
        }
      }
    }
    
    // Here is the line where to catch the analysis result
    // Then just send it to the xmlPilot

    if(analysisMode.equals("automatic"))
    {
      AnalysisArtifact aa =
            (AnalysisArtifact) analysisParam.get("AnalysisResult") ;
      if(aa==null)
      {
        workflowPilot.setAnalysisResult(false) ;
        return;
      }
      if(_analysisResults.getContents().isEmpty())
        _analysisResults.getContents().add(aa) ;
      else
      {
        AnalysisArtifact existingAa = 
            (AnalysisArtifact) _analysisResults.getContents().get(0);
        AnalysisUtils.updateAnalysisArtifact(existingAa, aa);
        aa = existingAa;
      }
      try
      {
        _analysisResults.save(null);
      }
      catch(IOException e)
      {
        _LOGGER.error("could not save analysis result resource");
      }
      QualitativeAnalysisResult result = null ;
      for(int j = aa.getResults().size() - 1 ; j >= 0 ; j--)
      {
        AnalysisResult r = (AnalysisResult) aa.getResults().get(j) ;
        if(r.getSource().getMethodName().toLowerCase()
              .equals(a.getPluginName().toLowerCase()))
        {
          if(aa.getResults().get(j) instanceof QualitativeAnalysisResult)
          {
            result = (QualitativeAnalysisResult) aa.getResults().get(j) ;
            workflowPilot.setAnalysisResult(result.isValidated()) ;
          }
        }
      }
      if(result == null)
      {
        msg = ">> " + analysisName + " result not found" ;
        _LOGGER.trace(msg);
        workflowPilot.setAnalysisResult(false) ;
      }
      if(result != null)
      {
        msg = ">> " + analysisName + " result set at " +
              result.isValidated() ;
        _LOGGER.trace(msg);
      }
    }
    else if(analysisMode.equals("manual"))
    {
      AnalysisChoiceRunnable choiceWindow = new AnalysisChoiceRunnable(analysisName);
      PlatformUI.getWorkbench().getDisplay().syncExec(choiceWindow);
      int res = choiceWindow.getRes();
      if(res == SWT.YES)
      {
        workflowPilot.setAnalysisResult(true) ;
        msg = ">> " + analysisName + " result set at true" ;
        _LOGGER.trace(msg);
      }
      else
      {
        workflowPilot.setAnalysisResult(false) ;
        msg = ">> " + analysisName + " result set at false" ;
        _LOGGER.trace(msg);
      }
    }
  }
  
  private class AnalysisChoiceRunnable implements Runnable
  {

	private String analysisName;
	private int res;
	
	AnalysisChoiceRunnable (String analysisName)
	{
		this.analysisName = analysisName;
	}
	
	@Override
	public void run() 
	{
	  Shell shell = PlatformUI.getWorkbench().getActiveWorkbenchWindow().getShell();
	  MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION|
			  SWT.YES|SWT.NO);
	  messageBox.setMessage("Was the analysis " +
			  analysisName + " successfull?");
	  messageBox.setText("Manual analysis result");
	  setRes(messageBox.open());
	}

	public int getRes() 
	{
	  return res;
	}

	private void setRes(int res) 
	{
		this.res = res;
	}
	  
  }
  
  private void doLoop(AbstractLoop l,AnalysisErrorReporterManager errManager,
                      WorkflowPilot workflowPilot, RamsesConfiguration config,
                      IProgressMonitor monitor) throws AnalysisException,
                                                       TransformationException,
                                                       GenerationException, ParseException, ConfigurationException, IOException
  {
    if(l.getMethod().equals(ResolutionMethod.TRY_EACH))
    {
      doLoopTryEach(l, errManager,
                    workflowPilot, config,
                    monitor);
    }
    else
    {
      if(l.getIterationNb()>0)
        loopValidIteration = l.getIterationNb();

      String extensionId = Names.LOOPMANAGER_EXT_ID;
      IExtensionRegistry extensionRegistry = Platform.getExtensionRegistry() ;
      IExtensionPoint extensionPoint =
          extensionRegistry
          .getExtensionPoint(Names.RAMSES_TARGET_SPECIFIC_PLUGIN_ID,
                             extensionId) ;
      if(extensionPoint!=null)
      {
        IExtension[] exts = extensionPoint.getExtensions() ;
        boolean foundLoopManagementPlugin = false;

        for(int i = 0 ; i < exts.length ; i++)
        {
          IConfigurationElement[] configElems = exts[i].getConfigurationElements() ;

          for(int j = 0 ; j < configElems.length ; j++)
          {
            if(extensionId==Names.LOOPMANAGER_EXT_ID)
            {
              try
              {
                LoopManagerFactory factory = (LoopManagerFactory) configElems[j]
                    .createExecutableExtension(Names.ATT_CLASS) ;
                LoopManager gen = factory.createLoopManager(
                                                            this,
                                                            l, errManager,
                                                            workflowPilot, config,
                                                            monitor);
                String resolutionMethodName = gen.getResolutionMethodName();
                String methodNameInWorkflow = l.getMethod().getName();
                if(resolutionMethodName.equals(methodNameInWorkflow))
                {
                  foundLoopManagementPlugin = true;
                  modelsMap.putAll(gen.processLoop());
                  workflowPilot.setLoopModelIdSuffix(gen.getModelIdSuffix());
                  boolean loopAnalysis = isValidLoopIteration(l.getAnalysis(), 
                                                              errManager, 
                                                              workflowPilot, 
                                                              config, 
                                                              workflowPilot.getOutputModelId(), 
                                                              gen.getModelIdSuffix(), 
                                                              monitor,
                                                              gen.getCurrentIterationNb());
                  if(loopAnalysis==false)
                    _LOGGER.error("Analysis results show that some constraints are not satisfied");
                }
              }
              catch (CoreException e)
              {
                ConfigStatus.NOT_FOUND.msg = "loop manager factory \'" + 
                    configElems[j].getName() +
                    "\' is not found" ;
              }
            }
          }
        }
        if(foundLoopManagementPlugin==false)
        {
          ConfigStatus.NOT_FOUND.msg = "No plugin found for " + extensionId;
          throw new ConfigurationException(ConfigStatus.NOT_FOUND);
        }
      }
    }
  }

  
  private void doLoopGeneticMerge(AbstractLoop l,
                                  AnalysisErrorReporterManager errManager,
                                  WorkflowPilot workflowPilot,
                                  RamsesConfiguration config,
                                  IProgressMonitor monitor)
  {
    TrcSpecification trc = (TrcSpecification) l.getTransformations().get(0).eResource().getContents().get(0);
    
    
  }

  private void doLoopTryEach(AbstractLoop l,
                             AnalysisErrorReporterManager errManager,
                             WorkflowPilot workflowPilot,
                             RamsesConfiguration config,
                             IProgressMonitor monitor) throws AnalysisException, GenerationException, TransformationException
  {
    AbstractLoop.AbstractAnalysis a = l.getAnalysis();
    final String inputId = l.getInputModelIdentifier();
    int loopIteration = 0;
    for(fr.tpt.aadl.ramses.transformation.trc.Transformation 
        transfo : l.getTransformations())
    {
      List<String> moduleList = new ArrayList<String>();
      for(fr.tpt.aadl.ramses.transformation.trc.Module m : transfo.getModules())
        moduleList.add(m.getPath());
      
      loopIteration++;
      String outputId = l.getOutputModelIdentifier()+loopIteration;
      
      String msg = "Start loop iteration = " + loopIteration ;
      _LOGGER.trace(msg);
      String transfoId = workflowPilot.getTransformationName();
      SystemInstance si = doTransformation(transfoId, moduleList,inputId,outputId,config, monitor);
      modelsMap.put(outputId, si.eResource());
      if (isValidLoopIteration(a,errManager,workflowPilot,config,inputId,Integer.toString(loopIteration),monitor,loopIteration))
      {
        break;
      }
    }
  }

  private boolean isValidLoopIteration (AbstractLoop.AbstractAnalysis a, AnalysisErrorReporterManager errManager,
                                        WorkflowPilot xmlPilot, RamsesConfiguration config,
                                        String inputId, String suffix, IProgressMonitor monitor,
                                        int loopIteration) throws AnalysisException
  {
    boolean result = doLoopAnalysis(a,errManager,xmlPilot,config,monitor,inputId, suffix, loopIteration);
    xmlPilot.setAnalysisResult(result);
    if (loopValidIteration >= 0 && !result)
    {
      /** Debug mode (valid iteration is fixed by the user) */
      return loopIteration == loopValidIteration;
    }
    else
    {
      /** Check iteration validity by specified analysis */
      return result;
    }
  }
  
  private boolean doLoopAnalysis(AbstractLoop.AbstractAnalysis a,
                              AnalysisErrorReporterManager errManager,
                              WorkflowPilot xmlPilot,
                              RamsesConfiguration config,
                              IProgressMonitor monitor,
                              String inputId,
                              String suffix,
                              int iterationCounter) throws AnalysisException
  {
    if (a instanceof AbstractLoop.Analysis)
    {
       AbstractLoop.Analysis aa = (AbstractLoop.Analysis) a;
       String inputIdSpecific = aa.getInputModelIdentifier();
       String outputIdSpecific = aa.getOutputModelIdentifier();
       inputId = (inputIdSpecific == null) ? inputId : inputIdSpecific;
       inputIdSpecific+=suffix;
       outputIdSpecific+=suffix;
       doAnalysis(aa.getMethod(),aa.getMode(),inputIdSpecific,outputIdSpecific,errManager,
                  xmlPilot,config,monitor, iterationCounter);
      
       return xmlPilot.getAnalysisResult();
    }
    else if (a instanceof AbstractLoop.Conjunction)
    {
      AbstractLoop.Conjunction c = (AbstractLoop.Conjunction) a;
      for(AbstractLoop.AbstractAnalysis aa : c.getSequence())
      { 
         if (! doLoopAnalysis(aa,errManager,xmlPilot,config,monitor,inputId,suffix,iterationCounter))
         {
           String realInputId = inputId+suffix;
           Resource inputResource = modelsMap.get(realInputId) ;
           inputResource.unload();
           modelsMap.remove(realInputId);
           return false;
         }
      }
      return true;
    }
    else if (a instanceof AbstractLoop.Disjunction)
    {
      AbstractLoop.Disjunction d = (AbstractLoop.Disjunction) a;
      for(AbstractLoop.AbstractAnalysis aa : d.getSequence())
      {
         if (doLoopAnalysis(aa,errManager,xmlPilot,config,monitor,inputId,suffix,iterationCounter))
         {
           return true;
         }
      }
      return false;
    }
    else
      return false;
  }

  private SystemInstance doTransformation(WorkflowPilot workflowPilot, RamsesConfiguration config, IProgressMonitor monitor)
		                                                 throws GenerationException, AnalysisException, TransformationException
	{
	  String identifier = workflowPilot.getTransformationName();
    List<String> resourceFileNameList = workflowPilot.getTransformationFileNameList();
    String inputModelId = workflowPilot.getInputModelId();
    String outputModelId = workflowPilot.getOutputModelId();
    return doTransformation(identifier, resourceFileNameList,inputModelId,outputModelId,config, monitor);
	}
  
  
  private SystemInstance doTransformation(String transformationId,
		  								  List<String> resourceFileNameList,
                                          String inputModelId, String outputModelId, 
                                          RamsesConfiguration config,
                                          IProgressMonitor monitor) throws GenerationException,
                                                                    TransformationException
  {
    Resource r = modelsMap.get(inputModelId);
    String msg = "Transformation launched" ;
    _LOGGER.trace(msg);
    msg = "  Input model  : " + inputModelId ;
    _LOGGER.trace(msg);
    msg = "  Module list  : " + resourceFileNameList ;
    _LOGGER.trace(msg);
    msg = "  Transfo id  : " + transformationId ;
    _LOGGER.trace(msg);
    msg = "  Output model : " + outputModelId ;
    _LOGGER.trace(msg);

    Resource result = _targetTrans.transformWokflow(r, transformationId, resourceFileNameList, 
                                                    config.getRamsesOutputDir(), outputModelId, monitor);

    systemToInstantiate = outputModelId + ".impl" ;
    PropertiesLinkingService pls = new PropertiesLinkingService ();
    SystemImplementation si = (SystemImplementation) pls.
        findNamedElementInsideAadlPackage(systemToInstantiate, 
                                          ((AadlPackage) result.getContents().get(0)).getOwnedPublicSection());

    SystemInstance sinst = _modelInstantiator.instantiate(si);
    if(outputModelId!=null && !outputModelId.isEmpty())
      this.modelsMap.put(outputModelId, sinst.eResource());

    currentImplResource = sinst.eResource();

    return sinst;
  }
  
  private void doUnparse(Resource inputResource,
                         Resource expandedResult,
		                     File outputDir,
		                     String pkgName,
		                     IProgressMonitor monitor) throws GenerationException
  {
	  Aadl2StandaloneUnparser.getAadlUnparser().setCustomPackageName(pkgName);
	  
	  if (expandedResult != null)
	  {
		  _targetTrans.unparse(inputResource, expandedResult, outputDir, monitor);
	  }
	  else
	  {
	    String msg = "Cannot unparse model: expanded result is null" ;
	    _LOGGER.error(msg);
	    ServiceProvider.SYS_ERR_REP.error(msg, true);
	  }
  }
  
  private void doGeneration(File runtimePath,
                            File outputDir,
                            File[] includeDirs,
                            Resource r,
                            IProgressMonitor monitor) throws GenerationException
  {
    String msg = "Generation launched from " + r.getURI().toFileString() ;
    _LOGGER.trace(msg);
	  _codeGen.generate(r, runtimePath, outputDir, includeDirs, monitor) ;
  }

  private void doErrorState()
  {
    String msg = "workflow pilot reached in errorstate" ;
    _LOGGER.error(msg);
    ServiceProvider.SYS_ERR_REP.error(msg, true);
  }


  @Override
  public boolean runtimePathChecker(File runtimePath)
  {
    return _codeGen.runtimePathChecker(runtimePath) ;
  }

  @Override
  public String getRuntimePathEnvVar()
  {
    return _codeGen.getRuntimePathEnvVar() ;
  }

  @Override
  public List<String> getTransformationModuleList() {
    List<String> res = AtlTransfoLauncher.getUninstanciateTransformationModuleList(); 
    res.addAll(_targetTrans.getTransformationModuleList());
    return res;
  }
  
  @Override
  public List<String> getValidationModuleList() {
    List<String> res = new ArrayList<String>();
    if(_modelValidator!=null)
      res.addAll(_modelValidator.getTransformationModuleList());
    return res;
  }
  
}