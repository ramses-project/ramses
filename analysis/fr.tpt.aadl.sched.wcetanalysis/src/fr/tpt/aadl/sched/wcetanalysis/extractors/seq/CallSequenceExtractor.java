package fr.tpt.aadl.sched.wcetanalysis.extractors.seq;

import org.osate.aadl2.modelsupport.errorreporting.AnalysisErrorReporterManager;

import fr.tpt.aadl.sched.wcetanalysis.ExtractionContext;
import fr.tpt.aadl.sched.wcetanalysis.model.ASTExtractor;

public abstract class CallSequenceExtractor extends ASTExtractor
{

	public CallSequenceExtractor(ExtractionContext ctxt,
			AnalysisErrorReporterManager errManager)
	{
		super(ctxt, errManager);
	}

}
