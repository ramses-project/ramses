package fr.tpt.aadl.launch;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException ;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.EcoreUtil2;
import org.osate.aadl2.AadlPackage;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.util.Aadl2Util;
import org.osate.xtext.aadl2.properties.linking.PropertiesLinkingService;

import com.google.common.collect.Sets;

import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory;
import fr.tpt.aadl.ramses.analysis.eg.EG2ResultModel;
import fr.tpt.aadl.ramses.analysis.eg.EGAnalyzer;
import fr.tpt.aadl.ramses.analysis.eg.model.EGModels;
import fr.tpt.aadl.ramses.analysis.eg.model.EGNode;
import fr.tpt.aadl.ramses.control.atl.AtlTransfoLauncher;
import fr.tpt.aadl.ramses.control.support.instantiation.AadlModelInstantiatior;
import fr.tpt.aadl.ramses.control.support.instantiation.PredefinedAadlModelManager;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;
import fr.tpt.aadl.ramses.control.support.utils.Command ;
import fr.tpt.aadl.ramses.control.support.utils.WaitMonitor ;
import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer;
import fr.tpt.aadl.ramses.control.support.analysis.AnalysisException;
import fr.tpt.aadl.ramses.control.support.config.RamsesConfiguration;
import fr.tpt.aadl.sched.aadlinspector.AADLInspectorLauncher;
import fr.tpt.aadl.sched.aadlinspector.output.AnalysisResult;
import fr.tpt.aadl.sched.aadlinspector.output.ResponseTimeResult;
import fr.tpt.aadl.sched.aadlinspector.output.ResponseTimeResult.TaskResponseTimeResult;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel;

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
			File outputDir,
			AnalysisErrorReporterManager errorReporter,
			final IProgressMonitor monitor
			)
					throws AnalysisException
					{
		
		
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
			File tmpDir = new File(outputDir.getAbsolutePath()+"/wcet_"+iter);
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
        synchronized (app) {wait();}
        
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
		  }
		  
		  default:
		  {
        String errMsg = "unknown exit code" ;
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
      t.stop();
  }


  public void performAnalysis(SystemInstance root,
			File outputDir,
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
				resultingEGNodeList.addAll(this.performAnalysis(ci, outputDir, errorReporter, monitor));
			}
		}
		
		
		this.size=1;
		File resultDir = new File(outputDir.getAbsolutePath()+"/"+outputModelIdentifier);
		if(!resultDir.exists())
			resultDir.mkdir();
		AADLInspectorAnalysisThread last = new AADLInspectorAnalysisThread(this, resultingEGNodeList, resultDir, root, outputModelIdentifier, mode);
		Thread t = new Thread(last);
		t.start();
		try {
			synchronized (this) {
				wait();
			}
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
			List<ComponentInstance> cpuList)
	{
		try
		{
			Wcet2AadlEMFTVMLauncher launcher = new Wcet2AadlEMFTVMLauncher(m, _instantiator, _predefinedResourcesManager, cpuList);
			List<File> transformationFileList = new ArrayList<File>();
			
			for(String s: getTransformationModuleList())
			  transformationFileList.add(new File(s));
			
			Aadl2Util.setUseTunedEqualsMethods (false);

			launcher.setOutputPackageName(outputModelId);
			File aadlWithWcetFile = new File(outputDir.getAbsolutePath()+File.separator+outputModelIdentifier+".aadl2");
			Resource rootResource = systemInstance.eResource();
			Resource aadlModelWithWcet = launcher.doTransformation(transformationFileList, 
					rootResource,
					outputDir.getAbsolutePath(),
					"_"+outputModelId);

			
			aadlModelWithWcet.setURI(URI.createFileURI(aadlWithWcetFile.getAbsolutePath()));
			_instantiator.serialize(aadlModelWithWcet, aadlWithWcetFile.getAbsolutePath());
			return aadlModelWithWcet;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			System.exit(-1);
		}
		finally
		{
			Aadl2Util.setUseTunedEqualsMethods (false);
		}
		return null;
	}
	
	static class AADLInspectorAnalysisThread extends Thread
    {
		private List<EGNode> egNodeList;
		private File outputDir;
		private SystemInstance root;
		private AADLInspectorSchedulingAnalysis initiator;
		private String outputModelId;
		private String mode;
		private List<ComponentInstance> cpuToIgnore = new ArrayList<ComponentInstance>();
		
		public AnalysisResult analysisResult;
		
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

		public AADLInspectorAnalysisThread(AADLInspectorSchedulingAnalysis aadlInspectorSchedulingAnalysis, List<EGNode> egNodeList,
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
            EGModels models = new EGModels();
			for(EGNode node: egNodeList)
			{
				models.put((ComponentInstance)node.getThread(), node);
			}
			try {
				EG2ResultModel eg2resultModel = new EG2ResultModel(models);
				AnalysisModel result = eg2resultModel.getAnalysisModel();
				Resource aadlModel = initiator.produceAnalysisAADLModel(result, outputDir, root, outputModelId, cpuToIgnore);

				PropertiesLinkingService pls = new PropertiesLinkingService ();
				AadlPackage pkg = (AadlPackage) aadlModel.getContents().get(0);
				SystemImplementation si = (SystemImplementation) pls.
						findNamedElementInsideAadlPackage(outputModelId+".impl", 
								pkg.getOwnedPublicSection());

				SystemInstance sinst = initiator._instantiator.instantiate(si);

			
				AADLInspectorLauncher launcher = new AADLInspectorLauncher();
				analysisResult = launcher.launchAnalysis(sinst, outputDir, mode);
				for(ComponentInstance ci : EcoreUtil2.getAllContentsOfType(sinst, ComponentInstance.class))
				{
					if(ci.getCategory().equals(ComponentCategory.PROCESSOR))
					{
						ResponseTimeResult ufr = analysisResult.getResponseTimeResults("root."+ci.getName());
						initiator.addAnalysisResult(ci, ufr, egNodeList);
					}
				}
				
			} 
			catch (Exception e)
			{
				System.err.println("Intermediate AADLInspector: " + e.getMessage());
				e.printStackTrace();
				synchronized (root) {
					initiator.cpt++;
					initiator.cpt_failed++;
					String message = "INFO: "+initiator.cpt_failed+" execution(s) of AADLInspector schedulability" +
							" failed.";
					initiator._monitor.subTask(message);
					initiator._logger.trace(message);
					evaluateIfFinished();
				}
			}

			synchronized (root) {
				initiator.cpt++;
				String message = "INFO: "+initiator.cpt+" execution(s) of AADLInspector schedulability" +
						" done.";
				initiator._monitor.subTask(message);
				initiator._logger.trace(message);
				evaluateIfFinished();
			}
			
			
			return;
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
