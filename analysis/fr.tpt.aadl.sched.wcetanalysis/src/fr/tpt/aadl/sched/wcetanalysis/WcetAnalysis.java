package fr.tpt.aadl.sched.wcetanalysis;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Platform;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.DataAccess;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;
import org.osate.aadl2.util.Aadl2Util;

import fr.tpt.aadl.ramses.analysis.AnalysisArtifact;
import fr.tpt.aadl.ramses.analysis.AnalysisResultFactory;
import fr.tpt.aadl.ramses.analysis.AnalysisSource;
import fr.tpt.aadl.ramses.analysis.QualitativeAnalysisResult;
import fr.tpt.aadl.ramses.control.support.AadlModelsManager;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer;
import fr.tpt.aadl.sched.wcetanalysis.model.TaskBody;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.AnalysisModel;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.Computation;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionBegin;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.CriticalSectionEnd;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ReducedThreadBA;
import fr.tpt.aadl.sched.wcetanalysis.result.reducedba.ThreadBehaviorElement;
import fr.tpt.aadl.sched.wcetanalysis.util.AST2DOT;

public class WcetAnalysis extends AbstractAnalyzer {

	
	private static final String ACTION_NAME = "Compute WCET from AADL model";
	private static final String REGISTRY_NAME = "RAMSES";
	public final static String PLUGIN_NAME = "WCET";
	private final static String PLUGIN_ID = "fr.tpt.aadl.ramses.control.osate.wcet";

	private String outputModelIdentifier;
	
	@Override
	public void setParameters(Map<String, Object> parameters) {
		mode = (String) parameters.get("Mode");
		AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE;
		currentResult = f.createAnalysisArtifact();
		parameters.put("AnalysisResult", currentResult);
		outputModelIdentifier = (String) parameters.get("OutputModelIdentifier");
	}

	@Override
	protected String getActionName() {
		return ACTION_NAME;
	}

	@Override
	public String getRegistryName() {
		return REGISTRY_NAME;
	}

	@Override
	public String getPluginName() {
		return PLUGIN_NAME;
	}

	@Override
	public String getPluginId() {
		return PLUGIN_ID;
	}

	@Override
	protected void analyzeDeclarativeModel(IProgressMonitor monitor,
			AnalysisErrorReporterManager errManager, Element declarativeObject) 
	{
		//Dialog.showError("WCET Computation Error", "Please select an instance model");
		System.err.println("WCET Computation Error: Please select an instance model");
	}

	@SuppressWarnings("restriction")
	@Override
	protected Resource analyzeInstanceModel(IProgressMonitor monitor,
			AnalysisErrorReporterManager errManager, SystemInstance root,
			SystemOperationMode som) 
	{
		
		AnalysisResultFactory f = AnalysisResultFactory.eINSTANCE;
		QualitativeAnalysisResult hasWCET = f.createQualitativeAnalysisResult();
		AnalysisSource as = f.createAnalysisSource();
		as.setMethodName(PLUGIN_NAME);
		hasWCET.setSource(as);
		hasWCET.setValidated(true);
		currentResult.getResults().add(hasWCET);
		
		
		String generatedFilePath = root.eResource().getURI().path();
		File generatedFile = new File(generatedFilePath);
		
		String wcetPath = generatedFile.getParentFile().getParentFile().getParentFile().getAbsolutePath() + "/wcet/";

		AST2DOT ast2dot = new AST2DOT(wcetPath);
		File outputFile = new File(wcetPath + "threads_ast_extraction.txt");
		try {
			File dir = outputFile.getParentFile();
			if (!dir.exists()) {
				dir.mkdirs();
			}
			if (!outputFile.exists()) {
				outputFile.createNewFile();
			}
			System.out.println("WCET/AST output path: " + wcetPath);

			PrintStream ps = new PrintStream(outputFile);
			WcetAnalysisDebug.addPrinter(ps);
			WcetAnalysisDebug.addErrorPrinter(ps);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// ASTDebug.addPrinter(System.out);
		WcetAnalysisDebug.addErrorPrinter(System.err);

		String outputPath = root.eResource().getURI().path();
		WcetAnalysisDebug.println("Source file: " + outputPath);

		ExtractionContext helper = ExtractionContext.createNewInstance(root, null);
		AST2ResultModel toResult = new AST2ResultModel(root,helper);
		
		AnalysisModel m = toResult.getAnalysisModel();
		Resource aadlWithWcet=null;
		try
		{
			Wcet2AadlEMFTVMLauncher launcher = new Wcet2AadlEMFTVMLauncher(m);
			List<File> transformationFileList = new ArrayList<File>();
			Aadl2Util.setUseTunedEqualsMethods (false);
			File resourceDir = RamsesConfiguration.getRamsesResourcesDir().getParentFile();
			transformationFileList.add(new File(resourceDir.getAbsolutePath()+"/WcetAnalysis/ReducedBA"));
			launcher.setPredefinedResourcesDirectory(resourceDir);
			
			if(!Platform.isRunning())
			{
				RamsesConfiguration.getPredefinedResourcesManager()
				.setPredefinedResourcesDir(resourceDir);

			}
			launcher.setOutputPackageName(outputModelIdentifier);
			File aadlWithWcetFile = new File(RamsesConfiguration.getOutputDir().getAbsolutePath()+"/wcet/"+outputModelIdentifier+".aadl2");
			Resource rootResource = root.eResource();
			aadlWithWcet = launcher.doTransformation(transformationFileList, 
										rootResource,
										RamsesConfiguration.getOutputDir().getAbsolutePath(),
										"_"+outputModelIdentifier);
			
			//aadlWithWcet.setURI(URI.createFileURI(aadlWithWcetFile.getAbsolutePath()));
			
			AadlModelsManager instantiator = RamsesConfiguration.getInstantiationManager();
			
			instantiator.serialize(aadlWithWcet, aadlWithWcetFile.getAbsolutePath());
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
		for(ReducedThreadBA rba : m.getThreadsBA())
		{
			ComponentInstance thread = rba.getThread();
			List<ThreadBehaviorElement> l = rba.getElements();
			
			System.out.println("\n\nThread " + thread.getName());
			for(ThreadBehaviorElement e : l)
			{
				if (e instanceof Computation)
				{
					Computation c = (Computation) e;
					System.out.println("\tComputation WCET=" + c.getMax());
				}
				else if (e instanceof CriticalSectionBegin)
				{
					CriticalSectionBegin csb = (CriticalSectionBegin) e;
					DataAccess da = csb.getSharedData();
					System.out.println("\tGet_Resource");
				}
				else
				{
					CriticalSectionEnd cse = (CriticalSectionEnd) e;
					DataAccess da = cse.getSharedData();
					System.out.println("\tRelease_Resource");
				}
			}
		}
		for (ComponentInstance ci : root.getAllComponentInstances()) 
		{
			if (ci.getCategory() == ComponentCategory.THREAD) 
			{
				TaskBody tb = helper.getAST(ci);
				ast2dot.visit(tb);
			}
		}
		return aadlWithWcet;
	}
	
}
