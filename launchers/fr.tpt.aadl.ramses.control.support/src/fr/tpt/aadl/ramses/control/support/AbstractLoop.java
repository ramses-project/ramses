package fr.tpt.aadl.ramses.control.support;

import java.util.ArrayList;
import java.util.List;

public class AbstractLoop {

	private final boolean hasInitialAnalysis;
	private final AbstractAnalysis analysis;
	private final List<List<String>> moduleLists;
	private final String inputModelIdentifier;
	private final String outputModelIdentifier;
	
	public AbstractLoop(boolean initialAnalysis, AbstractAnalysis analysis,
			List<List<String>> moduleLists, String inputModelIdentifier,
			String outputModelIdentifier)
	{
		this.hasInitialAnalysis = initialAnalysis;
		this.analysis = analysis;
		this.moduleLists = moduleLists;
		this.inputModelIdentifier = inputModelIdentifier;
		this.outputModelIdentifier = outputModelIdentifier;
	}
	public boolean hasInitialAnalysis() {
		return hasInitialAnalysis;
	}
	public String getInputModelIdentifier() {
		return inputModelIdentifier;
	}
	public String getOutputModelIdentifier() {
		return outputModelIdentifier;
	}
	public AbstractAnalysis getAnalysis() {
		return analysis;
	}
	public List<List<String>> getModuleLists() {
		return moduleLists;
	}
	





	public static abstract class AbstractAnalysis {}
	public static class Analysis extends AbstractAnalysis
	{
		private final String method;
		private final String mode;
		private final String inputModelIdentifier;
		private final String outputModelIdentifier;
		
		public Analysis(String method, String mode, String inputModelIdentifier,
				String outputModelIdentifier)
		{
			this.method = method;
			this.mode = mode;
			this.inputModelIdentifier = inputModelIdentifier;
			this.outputModelIdentifier = outputModelIdentifier;
		}

		public String getMethod() {
			return method;
		}

		public String getMode() {
			return mode;
		}

		public String getInputModelIdentifier() {
			return inputModelIdentifier;
		}

		public String getOutputModelIdentifier() {
			return outputModelIdentifier;
		}
	}
	
	public static abstract class AnalysisSequence extends AbstractAnalysis
	{
		private List<AbstractAnalysis> list = new ArrayList<AbstractAnalysis>();
		
		public void add(AbstractAnalysis a)
		{
			list.add(a);
		}
		
		public List<AbstractAnalysis> getSequence()
		{
			return list;
		}
	}
	
	public static class Conjunction extends AnalysisSequence {}
	public static class Disjunction extends AnalysisSequence {} 
}
