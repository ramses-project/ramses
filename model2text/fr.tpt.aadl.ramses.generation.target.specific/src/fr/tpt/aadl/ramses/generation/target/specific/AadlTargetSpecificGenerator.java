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
import java.util.ArrayList;
import java.util.HashMap ;
import java.util.List ;
import java.util.Map ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.core.runtime.OperationCanceledException ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.ui.PlatformUI;
import org.osate.aadl2.AadlPackage ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.PublicPackageSection ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil ;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService ;

import fr.tpt.aadl.ramses.analysis.AnalysisResult ;
import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult ;
import fr.tpt.aadl.ramses.analysis.util.AnalysisUtils ;
import fr.tpt.aadl.ramses.control.atl.AadlModelValidator ;
import fr.tpt.aadl.ramses.control.atl.AadlToTargetSpecificAadl ;
import fr.tpt.aadl.ramses.control.atl.AtlTransfoLauncher;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisArtifact ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.analysis.Analyzer ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.generator.Aadl2StandaloneUnparser ;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException ;
import fr.tpt.aadl.ramses.control.support.generator.Generator ;
import fr.tpt.aadl.ramses.control.support.generator.TransformationException ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelsManagerImpl ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry ;
import fr.tpt.aadl.ramses.control.support.utils.Names;
import fr.tpt.aadl.ramses.control.workflow.AbstractLoop ;
import fr.tpt.aadl.ramses.control.workflow.WorkflowPilot ;


public class AadlTargetSpecificGenerator implements Generator
{
  protected AadlToTargetSpecificAadl _targetTrans ;
  
  protected AadlTargetSpecificCodeGenerator _codeGen ;
  
  protected String _registryName = null ;
  
  private Resource currentImplResource = null;
  
  private Resource _analysisResults = null;
  
  private Map<String, Resource> modelsMap = new HashMap<String, Resource>();
  
  private String systemToInstantiate = null;
  
  private AadlModelInstantiatior _modelInstantiator ;

  private AadlModelValidator _modelValidator;
  
  /** Loop debug  (loopValidIteration must be negative to disable debug) **/
  private static int loopValidIteration = -1;
  private int loopIteration = -1;
  /****************/
  

  private static Logger _LOGGER = Logger.getLogger(AadlTargetSpecificGenerator.class) ;
  
  public AadlTargetSpecificGenerator(AadlToTargetSpecificAadl targetTrans,
                                     AadlTargetSpecificCodeGenerator codeGen,
                                     AadlModelInstantiatior modelInstantiator,
                                     AadlModelValidator modelValidator)
  {
    _targetTrans = targetTrans ;
    _codeGen = codeGen ;
    _modelInstantiator = modelInstantiator ;
    _modelValidator = modelValidator;
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
	File outputDir = config.getOutputDir();
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
  public void generateWorkflow(SystemInstance systemInstance,
		  					   RamsesConfiguration config,
                               WorkflowPilot xmlPilot,
                               File[] includeDirs,
                               AnalysisErrorReporterManager errManager,
                               IProgressMonitor monitor) throws GenerationException,
                                                                TransformationException,
                                                                AnalysisException
  {
	String targetId = config.getTargetId();
	File outputDir = config.getOutputDir();
	File runtimeDir = config.getRuntimePath(); 

    if(_analysisResults == null)
      _analysisResults = AnalysisUtils.createNewAnalysisArtifact(
                                                  outputDir.getAbsolutePath() +
                                                  systemInstance.getName() +
                                                  ".ares") ;
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

    SystemInstance currentInstance = systemInstance ;
    String rootModelId = xmlPilot.getInputModelId() ;
    if(rootModelId != null && !rootModelId.isEmpty())
      modelsMap.put(rootModelId, r) ;

    systemToInstantiate = xmlPilot.getOutputModelId() + ".impl" ;
    PublicPackageSection pps = (PublicPackageSection) systemInstance.
                                                      getSystemImplementation().
                                                      getOwner() ;
    AadlPackage p = (AadlPackage) pps.getOwner() ;
    final String initialPackageName = p.getName() ;

    int transfoCounter = 0 ;
    
    while(xmlPilot.hasNextOperation())
    {
      String operation = xmlPilot.getNextOperation() ;
      
      if(operation == null)
        return ;
      
      if(operation.equals("analysis"))
      {
	    monitor.subTask("Model analysis: " + xmlPilot.getAnalysisName());
        doAnalysis(xmlPilot, config, monitor, errManager) ;
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
        doGeneration(runtimeDir, outputDir, includeDirs, r, monitor) ;
      }
      else if(operation.equals("loop"))
      {
        doLoop(xmlPilot.getLoop(), errManager, xmlPilot, config, monitor) ;
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
    }
  }

  private void doAnalysis(WorkflowPilot workflowPilot, RamsesConfiguration config,
                          IProgressMonitor monitor,
                          AnalysisErrorReporterManager errManager) throws AnalysisException
  {
    String analysisName = workflowPilot.getAnalysisName();
    String analysisMode = workflowPilot.getAnalysisMode();
    String analysisModelInputIdentifier = workflowPilot.getInputModelId();
    String analysisModelOutputIdentifier = workflowPilot.getOutputModelId();
    doAnalysis(analysisName,analysisMode,analysisModelInputIdentifier,
               analysisModelOutputIdentifier, errManager,workflowPilot,config,monitor);
  }
  
  private void doAnalysis(String analysisName, String analysisMode,
                          String analysisModelInputIdentifier,
                          String analysisModelOutputIdentifier,
                          AnalysisErrorReporterManager errManager,
                          WorkflowPilot workflowPilot,
                          RamsesConfiguration config,
                          IProgressMonitor monitor) throws AnalysisException
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
    String outputModelId = workflowPilot.getOutputModelId() ;
    Map<String, Object> analysisParam = new HashMap<String, Object>() ;
    
    analysisParam.put("Mode", analysisMode) ;
    if(outputModelId != null)
      analysisParam.put("OutputModelIdentifier", outputModelId) ;
    
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
    }
    
    // Here is the line where to catch the analysis result
    // Then just send it to the xmlPilot

    if(analysisMode.equals("automatic"))
    {
      AnalysisArtifact aa =
            (AnalysisArtifact) analysisParam.get("AnalysisResult") ;
      _analysisResults.getContents().add(aa) ;
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
        workflowPilot.setAnalysisResult(result.isValidated()) ;
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
                      WorkflowPilot xmlPilot, RamsesConfiguration config,
                      IProgressMonitor monitor) throws AnalysisException,
                                                       TransformationException,
                                                       GenerationException
  {
    AbstractLoop.AbstractAnalysis a = l.getAnalysis();
    final String inputId = l.getInputModelIdentifier();
    final String outputId = l.getOutputModelIdentifier();
    
    loopIteration = -1;
    for(List<String> moduleList : l.getModuleLists())
    {
      loopIteration++;
      String msg = "Start loop iteration = " + loopIteration ;
      _LOGGER.trace(msg);
      String transfoId = xmlPilot.getTransformationName();
      doTransformation(transfoId, moduleList,inputId,outputId,config, monitor);
      if (isValidLoopIteration(a,errManager,xmlPilot,config,outputId,monitor))
      {
        break;
      }
    }
  }
  
  private boolean isValidLoopIteration (AbstractLoop.AbstractAnalysis a, AnalysisErrorReporterManager errManager,
                                        WorkflowPilot xmlPilot, RamsesConfiguration config,
                                        String outputId, IProgressMonitor monitor) throws AnalysisException
  {
     if (loopValidIteration >= 0)
     {
       /** Debug mode (valid iteration is fixed by the user) */
       return loopIteration == loopValidIteration;
     }
     else
     {
       /** Check iteration validity by specified analysis */
       return doLoopAnalysis(a,errManager,xmlPilot,config,monitor,outputId,outputId);
     }
  }
  
  private boolean doLoopAnalysis(AbstractLoop.AbstractAnalysis a,
                              AnalysisErrorReporterManager errManager,
                              WorkflowPilot xmlPilot,
                              RamsesConfiguration config,
                              IProgressMonitor monitor,
                              String inputId,
                              String outputId) throws AnalysisException
  {
    if (a instanceof AbstractLoop.Analysis)
    {
       AbstractLoop.Analysis aa = (AbstractLoop.Analysis) a;
       String inputIdSpecific = aa.getInputModelIdentifier();
       String outputIdSpecific = aa.getOutputModelIdentifier();
       inputId = (inputIdSpecific == null) ? inputId : inputIdSpecific;
       outputId = (outputIdSpecific == null) ? outputId : outputIdSpecific;
       doAnalysis(aa.getMethod(),aa.getMode(),inputId,outputId,errManager,
                  xmlPilot,config,monitor);
      
       return xmlPilot.getAnalysisResult();
    }
    else if (a instanceof AbstractLoop.Conjunction)
    {
      AbstractLoop.Conjunction c = (AbstractLoop.Conjunction) a;
      for(AbstractLoop.AbstractAnalysis aa : c.getSequence())
      { 
         if (! doLoopAnalysis(aa,errManager,xmlPilot,config,monitor,inputId,outputId))
         {
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
         if (doLoopAnalysis(aa,errManager,xmlPilot,config,monitor,inputId,outputId))
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
                                                config.getOutputDir(), outputModelId, monitor);

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
  String msg = "XML piloting achieved in errorstate" ;
  _LOGGER.error(msg);
  ServiceProvider.SYS_ERR_REP.error(msg, true);
}

  @Override
  public void setParameters(Map<String, Object> parameters)
  {
    // AadlTargetSpecificGenerator does not take any parameters: nothing to do.
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
	res.addAll(_modelValidator.getTransformationModuleList());
	return res;
  }
  
}