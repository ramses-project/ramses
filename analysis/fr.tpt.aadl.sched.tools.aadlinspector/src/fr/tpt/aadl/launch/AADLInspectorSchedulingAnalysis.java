/**
 * AADL-RAMSES
 * 
 * Copyright © 2014 TELECOM ParisTech and CNRS
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

package fr.tpt.aadl.launch;

import java.io.File ;
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.LinkedHashSet ;
import java.util.List ;
import java.util.Map ;
import java.util.Set ;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.core.runtime.OperationCanceledException ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.m2m.atl.emftvm.util.VMException ;
import org.eclipse.xtext.EcoreUtil2 ;
import org.osate.aadl2.AadlPackage ;
import org.osate.aadl2.ComponentCategory ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.instance.ComponentInstance ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager ;
import org.osate.aadl2.util.Aadl2Util ;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService ;

import com.google.common.collect.Sets ;

import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory ;
import fr.tpt.aadl.ramses.analysis.eg.EG2ResultModel ;
import fr.tpt.aadl.ramses.analysis.eg.EGAnalyzer ;
import fr.tpt.aadl.ramses.analysis.eg.model.EGModels ;
import fr.tpt.aadl.ramses.analysis.eg.model.EGNode ;
import fr.tpt.aadl.ramses.control.atl.AtlTransfoLauncher ;
import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer ;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException ;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior ;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.utils.Command ;
import fr.tpt.aadl.ramses.control.support.utils.WaitMonitor ;
import fr.tpt.aadl.sched.aadlinspector.AADLInspectorLauncher ;
import fr.tpt.aadl.sched.aadlinspector.output.AnalysisResult ;
import fr.tpt.aadl.sched.aadlinspector.output.ResponseTimeResult ;
import fr.tpt.aadl.sched.aadlinspector.output.ResponseTimeResult.TaskResponseTimeResult ;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel ;

public class AADLInspectorSchedulingAnalysis extends AbstractAnalyzer {

	private final static String ANALYZER_NAME = "AADLInspector-SchedulingAnalysis";
	public final static String PLUGIN_NAME = "AADLInspector-SchedulingAnalysis";
	private final static String PLUGIN_ID = "AADLInspector-SchedulingAnalysis";
	private AadlModelInstantiatior _instantiator ;
	private PredefinedAadlModelManager _predefinedResourcesManager ;
	private String outputModelIdentifier;
	private Logger _logger = Logger.getLogger(AADLInspectorSchedulingAnalysis.class) ;
	private Map<ComponentInstance, List<ResponseTimeResult>> responseTimeResultList = new HashMap<ComponentInstance, List<ResponseTimeResult>>();
	
	public AADLInspectorSchedulingAnalysis(AadlModelInstantiatior instantiator,
			PredefinedAadlModelManager predefinedResourcesManager)
	{
		_instantiator = instantiator ;
		_predefinedResourcesManager = predefinedResourcesManager ;
	}


	@Override
	public String getRegistryName() 
	{
		return ANALYZER_NAME;
	}

	@Override
	public String getPluginName() 
	{
		return PLUGIN_NAME;
	}

	@Override
	public String getPluginId() 
	{
		return PLUGIN_ID;
	}

	boolean first = true;
	public int cpt;
	public int cpt_failed=0;
	public int size;
	private Map<ResponseTimeResult, List<EGNode>> analysisResult = new HashMap<ResponseTimeResult, List<EGNode>>();
	private IProgressMonitor _monitor;
	private RamsesConfiguration _config;

	@Override
	public void setParameters(Map<String, Object> parameters) 
	{
		if(first)
		{
			mode = (String) parameters.get("Mode");
			AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE;
			currentResult = f.createAnalysisArtifact();
			parameters.put("AnalysisResult", currentResult);
			outputModelIdentifier = (String) parameters.get("OutputModelIdentifier");
			first = false;
		}
	}

	public List<EGNode> performAnalysis(ComponentInstance cpu,
			RamsesConfiguration config,
			AnalysisErrorReporterManager errorReporter,
			final IProgressMonitor monitor
			)
					throws AnalysisException
					{
		
		this._config = config;
		this._monitor = monitor;
		
		/* XXX: test avec plusieurs cpu
		 * cpu per cpu
		 * Modify transformation to copy only selected CPU instances into subcomponent; 
		 * 		propagate to properties. Use EMFUtils.allInsta... to filter out.
		 * 		propagate to connections (bus, etc...)
		 * Extract one configuration per CPU.
		 * model to exhibit = merge des listes de EGNode à sélectionner.
		*/
		
		
		EGAnalyzer ega = new EGAnalyzer(_instantiator, _predefinedResourcesManager);
		Map<ComponentInstance, List<EGNode>> wcetMap = ega.extractWCETModelsMap(cpu);

		
		List<Set<EGNode>> listForProduct = new ArrayList<Set<EGNode>>();
		for(ComponentInstance thread: wcetMap.keySet())
		{
			Set<EGNode> tmp = new LinkedHashSet<EGNode>(wcetMap.get(thread));
			List<EGNode> toRemove = new ArrayList<EGNode>();
			for(EGNode t : tmp)
				if(!t.hasCapacity())
					toRemove.add(t);
			tmp.removeAll(toRemove);
			listForProduct.add(tmp);
		}

		Set<List<EGNode>> res = Sets.cartesianProduct(listForProduct);
		size = res.size();
		String message = "INFO: "+size+" executions of AADLInspector schedulability" +
				"analysis will be executed.";
		_logger.trace(message);

		if(size==0)
		{
			return null;
		}
		// Launch analysis for each configuration
		// If one is not schedulable, exhibit this one
		// otherwise exhibit one that maximizes CPU usage
		
		int iter=0;
		final Thread[] aadlInspectorThreads = new Thread[size] ;
		
		final AADLInspectorSchedulingAnalysis app = this ;
		
		for(List<EGNode> egNodeList: res)
		{
		  String outputPath;
		  if(config.getAadlInspectorOutputDir()!=null)
		    outputPath = config.getAadlInspectorOutputDir().getAbsolutePath();
		  else
		    outputPath = config.getRamsesOutputDir().getAbsolutePath();
			File tmpDir = new File(outputPath+"/wcet_"+iter);
			if(!tmpDir.exists())
				tmpDir.mkdir();
			// Execute analysis in several threads
			aadlInspectorThreads[iter] = new AADLInspectorAnalysisThread(app, egNodeList, tmpDir, cpu, "wcet_"+iter, "automatic");
			iter++;
		}
		
		Command cmd = new Command()
		{
      @Override
      public int run() throws Exception
      {
        for(Thread t : aadlInspectorThreads)
        {
          t.start();
        }
        
        // Wait all the thread end.
        synchronized (app) {app.wait();}
        
        return Command.OK ;
      }

      @Override
      public boolean isCanceled()
      {
        return monitor.isCanceled() ;
      }

      @Override
      public String getLabel()
      {
        return null ;
      }
		} ;
		
		int exitStatus ;
		WaitMonitor wm = new WaitMonitor(cmd) ;
		wm.start();
		try
    {
      exitStatus = wm.waitAndCheck(500) ;
    }
    catch(InterruptedException e)
    {
      killThreads(aadlInspectorThreads) ;
      String msg = "AADL inspector monitoring has been interrupted" ;
      _logger.fatal(msg, e);
      throw new RuntimeException(msg, e) ;
    }
		
		switch(exitStatus)
		{
		  case Command.FATAL:
		  {
		    Exception e = wm.getCaughtException() ;
		    String msg = "AADL Inspector has failed" ;
		    _logger.fatal(msg, e);
		    killThreads(aadlInspectorThreads) ;
		    throw new RuntimeException(msg, e);
		  }
		  
		  case Command.ERROR:
		  {
		    // TODO
		  }
		  
		  case Command.CANCEL:
		  {
		    killThreads(aadlInspectorThreads) ;
        String msg = "AADL Inspector has been canceled" ;
        _logger.trace(msg) ;
        throw new OperationCanceledException(msg) ;
      }
		  
		  case Command.OK:
		  {
		    String msg = "AADL Inspector process done" ;
		    _logger.trace(msg);
		    break ;
		  }
		  
		  default:
		  {
        String errMsg = "AADL Inspector error: unknown exit code" ;
        _logger.error(errMsg);
        ServiceProvider.SYS_ERR_REP.error(errMsg, true);
      }
		}
		
		int i=0;
		String outputModelId="";
		List<EGNode> resultingEGNodeList =  new ArrayList<EGNode>();
		for(ComponentInstance ci: responseTimeResultList.keySet())
		{
			List<EGNode> tmp=null;
			for(ResponseTimeResult ufr: responseTimeResultList.get(ci))
			{
				double maxResponseTime = 0.0;
				boolean schedulable=true;

				double responseTimeSum=0;
				if(ufr.isResult()==false)
				{
					tmp = new ArrayList<EGNode>();
					tmp.addAll(this.analysisResult.get(ufr));
					outputModelId = "wcet_"+(i+1);
					schedulable = false;
					break;
				}
				for(TaskResponseTimeResult rt :ufr.getResponseTimes().values())
					responseTimeSum += rt.worst;
				if(responseTimeSum>maxResponseTime && schedulable)
				{
					tmp = new ArrayList<EGNode>();
					tmp.addAll(this.analysisResult.get(ufr));
					maxResponseTime = responseTimeSum;
					outputModelId = "wcet_"+(i+1);
				}
				i++;
			}
			resultingEGNodeList.addAll(tmp);
		}
		
		return resultingEGNodeList;
		
		
					}
	
	private void killThreads(Thread[] aadlInspectorThreads)
  {
    for(Thread t : aadlInspectorThreads)
      t.interrupt();
  }


  public void performAnalysis(SystemInstance root,
			RamsesConfiguration config,
			AnalysisErrorReporterManager errorReporter,
			IProgressMonitor monitor
			)
					throws AnalysisException
					{
		
		List<ComponentInstance> cpuList = new  ArrayList<ComponentInstance>();
		List<EGNode> resultingEGNodeList = new ArrayList<EGNode>();
		for(ComponentInstance ci : EcoreUtil2.getAllContentsOfType(root, ComponentInstance.class))
		{
			if(ci.getCategory().equals(ComponentCategory.PROCESSOR))
			{
				resultingEGNodeList.addAll(this.performAnalysis(ci, config, errorReporter, monitor));
			}
		}
		
		
		this.size=1;
		String resultPath;
    if(config.getAadlInspectorOutputDir()!=null)
      resultPath = config.getAadlInspectorOutputDir().getAbsolutePath();
    else
      resultPath = config.getRamsesOutputDir().getAbsolutePath();
		File resultDir = new File(resultPath+"/"+outputModelIdentifier);
		if(!resultDir.exists())
			resultDir.mkdir();
		AADLInspectorAnalysisThread last = new AADLInspectorAnalysisThread(this, resultingEGNodeList, resultDir, root, outputModelIdentifier, mode);
		Thread t = new Thread(last);
		t.start();
		try {
			synchronized (this) {
				wait();
			}
			if(last.analysisResult!=null)
				last.analysisResult.normalize(currentResult);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return;
					}


	synchronized private void addAnalysisResult(ComponentInstance ci, ResponseTimeResult rtr, List<EGNode> nodes)
	{
		this.analysisResult.put(rtr, nodes);
		
		if(this.responseTimeResultList.containsKey(ci))
		{
			this.responseTimeResultList.get(ci).add(rtr);
		}
		else
		{
			List<ResponseTimeResult> l = new ArrayList<ResponseTimeResult>();
			l.add(rtr);
			this.responseTimeResultList.put(ci, l);
		}
	}
	
	private Resource produceAnalysisAADLModel(AnalysisModel m, File outputDir,
			                                      SystemInstance systemInstance,
			                                      String outputModelId,
			                                      List<ComponentInstance> cpuList,
			                                      IProgressMonitor monitor)
	{
	  Wcet2AadlEMFTVMLauncher launcher = new Wcet2AadlEMFTVMLauncher(m, _instantiator, _predefinedResourcesManager, cpuList);
//    List<File> transformationFileList = new ArrayList<File>();
//    
//    for(String s: getTransformationModuleList())
//      transformationFileList.add(new File(s));
    
    Aadl2Util.setUseTunedEqualsMethods (false);

    launcher.setOutputPackageName(outputModelId);
    File aadlWithWcetFile = new File(outputDir.getAbsolutePath()+File.separator+outputModelIdentifier+".aadl2");
    Resource rootResource = systemInstance.eResource();
    Resource aadlModelWithWcet = launcher.doTransformation(rootResource,
        outputDir.getAbsolutePath(),
        "_"+outputModelId,
        monitor);

    
    aadlModelWithWcet.setURI(URI.createFileURI(aadlWithWcetFile.getAbsolutePath()));
    _instantiator.serialize(aadlModelWithWcet, aadlWithWcetFile.getAbsolutePath());
    Aadl2Util.setUseTunedEqualsMethods (false);
    return aadlModelWithWcet;
	}
	
	static class AADLInspectorAnalysisThread extends Thread
    {
		private List<EGNode> egNodeList;
		private File outputDir;
		private SystemInstance root;
		private final AADLInspectorSchedulingAnalysis initiator;
		private String outputModelId;
		private String mode;
		private List<ComponentInstance> cpuToIgnore = new ArrayList<ComponentInstance>();
		
		public AnalysisResult analysisResult;
    
    private static Logger _LOGGER = Logger.getLogger(AADLInspectorAnalysisThread.class) ;
		
		public AADLInspectorAnalysisThread(AADLInspectorSchedulingAnalysis aadlInspectorSchedulingAnalysis, List<EGNode> egNodeList,
				File outputDir, ComponentInstance cpu, String outputModelId, String mode) {
        	this.initiator = aadlInspectorSchedulingAnalysis;
			this.egNodeList = egNodeList;
			this.outputDir = outputDir;
			this.root = cpu.getSystemInstance();
			this.outputModelId = outputModelId;
			this.mode = mode;
			
			for(ComponentInstance ci : EcoreUtil2.getAllContentsOfType(root, ComponentInstance.class))
			{
				if(ci.getCategory().equals(ComponentCategory.PROCESSOR)
						&& !ci.equals(cpu))
				{
					this.cpuToIgnore.add(ci);
				}
			}
		}

		public AADLInspectorAnalysisThread(final AADLInspectorSchedulingAnalysis aadlInspectorSchedulingAnalysis, List<EGNode> egNodeList,
				File outputDir, SystemInstance root, String outputModelId, String mode) {
        	this.initiator = aadlInspectorSchedulingAnalysis;
			this.egNodeList = egNodeList;
			this.outputDir = outputDir;
			this.root = root;
			this.outputModelId = outputModelId;
			this.mode = mode;
		}
		
    public void run()
    {
      Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
      
      EGModels models = new EGModels() ;
      for(EGNode node : egNodeList)
      {
        models.put((ComponentInstance) node.getThread(), node) ;
      }
      try
      {
        EG2ResultModel eg2resultModel = new EG2ResultModel(models) ;
        AnalysisModel result = eg2resultModel.getAnalysisModel() ;

        if(initiator._monitor.isCanceled())
        {
          String msg = "analysis has been canceled before analysis" ;
          _LOGGER.trace(msg) ;
          return ;
        }

        Resource aadlModel =
                             initiator.produceAnalysisAADLModel(result,
                                                                outputDir,
                                                                root,
                                                                outputModelId,
                                                                cpuToIgnore,
                                                                initiator._monitor) ;

        PropertiesLinkingService pls = new PropertiesLinkingService() ;
        AadlPackage pkg = (AadlPackage) aadlModel.getContents().get(0) ;
        SystemImplementation si =
                                  (SystemImplementation) pls.findNamedElementInsideAadlPackage(outputModelId +
                                                                                                   ".impl",
                                                                                               pkg.getOwnedPublicSection()) ;
        SystemInstance sinst = initiator._instantiator.instantiate(si) ;
        
        AADLInspectorLauncher launcher = new AADLInspectorLauncher(initiator._config.getAadlInspectorInstallDir()) ;
        analysisResult =
                         launcher.launchAnalysis(sinst, outputDir, mode,
                                                 initiator._monitor) ;
        if(initiator._monitor.isCanceled())
        {
          String msg = "analysis has been canceled after analysis" ;
          _LOGGER.trace(msg) ;
          return ;
        }

        for(ComponentInstance ci : EcoreUtil2.getAllContentsOfType(sinst,
                                                                   ComponentInstance.class))
        {
          if(ci.getCategory().equals(ComponentCategory.PROCESSOR))
          {
            ResponseTimeResult ufr =
                                     analysisResult.getResponseTimeResults("root." +
                                                                           ci.getName()) ;
            initiator.addAnalysisResult(ci, ufr, egNodeList) ;
          }
        }
      }
			catch(InterruptedException e)
			{
			  // Analysis has been canceled by the user. Stop the analysis.
			  String msg = "Intermediate AADLInspector has been interrupted" ;
        _LOGGER.trace(msg) ;
			  return ;
			}
			catch(OperationCanceledException e)
			{
			  // Analysis has been canceled by the user. Stop the analysis.
			  _LOGGER.trace(cancelMsg()) ;
			  return ;
			}
			catch(VMException e)
			{
			  if(e.getCause() instanceof OperationCanceledException)
			  {
			    // Analysis has been canceled by the user. Stop the analysis.
			    _LOGGER.trace(cancelMsg()) ;
	        return ;
			  }
			  else
			  {
	        e.printStackTrace();
	        _LOGGER.fatal(fatalMsg(), e);
	        fatal() ;
			  }
			}
      catch(Exception e)
      {
        e.printStackTrace() ;
        _LOGGER.fatal(fatalMsg(), e) ;
        fatal() ;
      }

      synchronized(root)
      {
        initiator.cpt++ ;
        String message =
                         initiator.cpt +
                             " execution(s) of AADLInspector schedulability" +
                             " done." ;
        initiator._monitor.subTask(message) ;
        _LOGGER.trace(message) ;
        evaluateIfFinished() ;
      }

      return ;
    }
		
		private String fatalMsg()
    {
		  return  initiator.cpt_failed +" execution(s) of AADLInspector schedulability" +
          " failed.";
    }

    private void fatal()
    {
      synchronized (root)
      {
        initiator.cpt++;
        initiator.cpt_failed++;
        evaluateIfFinished();
      }
    }

    private String cancelMsg()
    {
      return "Intermediate AADLInspector has been canceled" ;
    }

    void evaluateIfFinished()
		{
		  if(initiator.cpt==initiator.size)
			synchronized (initiator) {
			  initiator.notify();
			  initiator.cpt=0;
			}
		}
 
    }

	List<String> _ransformationModuleList = null;
	
	@Override
	public List<String> getTransformationModuleList() 
	{
	  if(_ransformationModuleList == null)
	  {
		_ransformationModuleList = AtlTransfoLauncher.getUninstanciateTransformationModuleList();
		_ransformationModuleList.add(
		  "/WcetAnalysis/ReducedBA");
	  }
	  return _ransformationModuleList;
	}
}