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

package fr.tpt.aadl.ramses.control.workflow;

import java.util.ArrayList;
import java.util.List;

public class AbstractLoop {


  private final AbstractAnalysis analysis;
	private final List<fr.tpt.aadl.ramses.transformation.trc.Transformation> transformations;
	private final String inputModelIdentifier;
	private final String outputModelIdentifier;
	private final ResolutionMethod method;
	private final int iterationNb;
	
	public AbstractLoop(AbstractAnalysis analysis,
	                    List<fr.tpt.aadl.ramses.transformation.trc.Transformation> moduleLists,
	                    String inputModelIdentifier,
	                    String outputModelIdentifier,
	                    ResolutionMethod method,
	                    int iterationNb)
	{
		this.analysis = analysis;
		this.transformations = moduleLists;
		this.inputModelIdentifier = inputModelIdentifier;
		this.outputModelIdentifier = outputModelIdentifier;
		this.method = method;
		this.iterationNb = iterationNb;
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
	public List<fr.tpt.aadl.ramses.transformation.trc.Transformation> getTransformations() {
		return transformations;
	}
	public ResolutionMethod getMethod()
	{
	  return method;
	}
	public int getIterationNb()
	{
	  return iterationNb;
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