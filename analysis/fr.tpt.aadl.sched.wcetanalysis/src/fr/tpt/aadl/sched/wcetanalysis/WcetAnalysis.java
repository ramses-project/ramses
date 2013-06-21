package fr.tpt.aadl.sched.wcetanalysis;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

import org.eclipse.core.runtime.IProgressMonitor;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.Element;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instance.SystemOperationMode;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

import fr.tpt.aadl.ramses.control.support.analysis.AbstractAnalyzer;
import fr.tpt.aadl.sched.wcetanalysis.model.TaskBody;
import fr.tpt.aadl.sched.wcetanalysis.util.AST2DOT;

public class WcetAnalysis extends AbstractAnalyzer {

	public static final String ANALYZER_NAME = "WCET";
	
	private static final String ACTION_NAME = "Compute WCET from AADL model";
	private static final String REGISTRY_NAME = "RAMSES";
	private final static String PLUGIN_NAME = "WCET4Osate";
	private final static String PLUGIN_ID = "fr.tpt.aadl.ramses.control.osate.wcet";

	@Override
	public void setParameters(Map<String, Object> parameters) {
		// do nothing: this is not an error but there is no parameter to be set here
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

	@Override
	protected void analyzeInstanceModel(IProgressMonitor monitor,
			AnalysisErrorReporterManager errManager, SystemInstance root,
			SystemOperationMode som) 
	{

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
		boolean threadsFound = false;
		for (ComponentInstance ci : root.getAllComponentInstances()) 
		{
			if (ci.getCategory() == ComponentCategory.THREAD) 
			{
				TaskBody tb = helper.getAST(ci);
				AadlPropertiesUpdate.update(tb);
				ast2dot.visit(tb);
				threadsFound = true;
			}
		}
		
		if (!threadsFound)
		{
			WcetAnalysisDebug.error("No thread found !");
		}
	}

}
