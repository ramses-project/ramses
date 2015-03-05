package fr.tpt.aadl.sched.wcetanalysis.model;

import org.osate.aadl2.Element;
import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

import fr.tpt.aadl.sched.wcetanalysis.ExtractionContext;

public abstract class ASTExtractor
{

	protected final AnalysisErrorReporterManager errManager;
	protected final ExtractionContext ctxt;

	public ASTExtractor(ExtractionContext ctxt, AnalysisErrorReporterManager errManager)
	{
		this.ctxt = ctxt;
		this.errManager = errManager;
	}

	public void reportError(Element target, String msg)
	{
		System.err.println("[Error]" + msg);
		System.err.flush();
		/*
		 * if ((errManager != null) && (target!=null)) {
		 * errManager.error(target, msg); }
		 */
	}

	public void reportWarning(Element target, String msg)
	{
		System.err.println("[Warning] " + msg);
		System.err.flush();
		/*
		 * if ((errManager != null) && (target!=null)) {
		 * errManager.warning(target, msg); }
		 */
	}

}
