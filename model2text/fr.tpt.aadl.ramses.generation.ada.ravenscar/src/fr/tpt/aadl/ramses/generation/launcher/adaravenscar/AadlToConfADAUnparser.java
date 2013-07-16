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

package fr.tpt.aadl.ramses.generation.launcher.adaravenscar;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.osate.aadl2.ComponentCategory;
import org.osate.aadl2.ConnectedElement;
import org.osate.aadl2.DataPort;
import org.osate.aadl2.DataSubcomponent;
import org.osate.aadl2.DirectionType;
import org.osate.aadl2.EventDataPort;
import org.osate.aadl2.MemorySubcomponent;
import org.osate.aadl2.Port;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.Subcomponent;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.VirtualProcessorSubcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.ConnectionInstance;
import org.osate.aadl2.instance.ConnectionReference;
import org.osate.aadl2.instance.FeatureCategory;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.UnparseText;

import fr.tpt.aadl.ramses.control.support.generator.AadlTargetUnparser;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.adaravenscar.GenerationUtilsADA;

import fr.tpt.aadl.ramses.generation.target.specific.GeneratorUtils;
import fr.tpt.aadl.ramses.transformation.atl.hooks.impl.HookAccessImpl;
import fr.tpt.aadl.ramses.util.generation.FileUtils;
import fr.tpt.aadl.ramses.util.generation.RoutingProperties;
import fr.tpt.aadl.utils.PropertyUtils;

public class AadlToConfADAUnparser implements AadlTargetUnparser
{
	private final static long DEFAULT_REQUIRED_STACK_SIZE = 16384 ;

	
	
	public void process(ProcessorSubcomponent processor,
			File generatedFilePath,
			TargetProperties tarProp) 
					throws GenerationException
					{}
			

	public void process(ProcessSubcomponent process, File generatedFilePath,
			TargetProperties tarProp)
	{

		ProcessImplementation processImpl = (ProcessImplementation) 
				process.getComponentImplementation() ;

		//this.findCommunicationMechanism(processImpl, pp);

		// Generate main.ads
		UnparseText mainHeaderCode = new UnparseText() ;
		genMainHeader(processImpl, mainHeaderCode);

		// Generate main.adb
		UnparseText mainImplCode = new UnparseText() ;
		genMainImpl(processImpl, mainImplCode) ;

		try
		{
			FileUtils.saveFile(generatedFilePath, "main.ads",
					mainHeaderCode.getParseOutput()) ;

			FileUtils.saveFile(generatedFilePath, "main.adb",
					mainImplCode.getParseOutput()) ;
		}
		catch(IOException e)
		{
			// TODO : error message to handle.
			e.printStackTrace() ;
		}
	}

	//Generate global variables.
	private void genGlobalVariablesMainImpl(ProcessImplementation process, EList<ThreadSubcomponent> lthreads,
			UnparseText mainImplCode)
	{
		mainImplCode.addOutputNewline(GenerationUtilsADA.generateSectionMark()) ;
		mainImplCode.addOutputNewline(GenerationUtilsADA
				.generateSectionTitle("GLOBAL VARIABLES")) ;

		// Generate thread names array.
		if(false == lthreads.isEmpty())
		{
			//mainImplCode
			//.addOutputNewline(
					//"PROCESS_ID_TYPE arinc_threads[POK_CONFIG_NB_THREADS];") ;
			mainImplCode
			.addOutputNewline(
					"type Array_Of_Threads is array (Natural range<>) of PROCESS_ID_TYPE;") ;
			
			mainImplCode
			.addOutputNewline(
					"arinc_threads : Array_Of_Threads(1..POK_CONFIG_NB_THREADS);") ;
		}

		mainImplCode
		.addOutputNewline(
				"type Array_Of_Strings is array (Natural range<>) of string;") ;
		
		
		genGlobalVariablesMainOptional(process, mainImplCode);

		mainImplCode.addOutputNewline(GenerationUtilsADA.generateSectionMark()) ;
	}

	protected void genGlobalVariablesMainOptional(ProcessImplementation process,
			UnparseText mainImplCode){}

	private void genFileIncludedMainImpl(UnparseText mainImplCode)
	{
		// Files included.
		mainImplCode.addOutputNewline(GenerationUtilsADA.generateSectionMark()) ;
		//mainImplCode.addOutputNewline(GenerationUtilsADA
		//.generateSectionTitle("INCLUSION")) ;

		mainImplCode.addOutputNewline("with main.ads") ;
		mainImplCode.addOutputNewline("with activity.ads") ;
		mainImplCode.addOutputNewline("");
	}

	private void genThreadDeclarationMainImpl(ThreadSubcomponent thread,
			int threadIndex,
			UnparseText mainImplCode)
	{
		ThreadImplementation timpl =
				(ThreadImplementation) thread.getComponentImplementation() ;
		
		
		mainImplCode.addOutput(GenerationUtilsADA
				.getGenerationADAIdentifier(timpl.getQualifiedName())) ;
		mainImplCode.addOutput(GenerationUtilsADA.THREAD_SUFFIX + ':') ;
		mainImplCode.addOutput(GenerationUtilsADA
				.getGenerationADAIdentifier(timpl.getQualifiedName()) + "(");
		
		String period = null ;
		String deadline = null ;
		String timeCapacity = null ;
		String priority;
		String kind;

		try
		{
			float value =
					PropertyUtils.getIntValue(thread, "Priority") ;
			priority = Integer.toString((int) value) ;
		}
		catch(Exception e)
		{
			priority = null ;
		}

		// If priority is not set, don't generate.
		if(priority != null)
		{
			mainImplCode.addOutput(priority) ;
		}
		

		mainImplCode
		.addOutput(",\""+thread.getName()+"\"");

		
		try
		{
			float value =
					PropertyUtils.getIntValue(thread, "Dispatch_Protocol") ;
			kind = Integer.toString((int) value) ;
		}
		catch(Exception e)
		{
			kind = null ;
		}

		// If priority is not set, don't generate.
		if(kind != null)
		{
			mainImplCode.addOutput(',' + kind) ;
		}
		
		
		try
		{
			long value = PropertyUtils.getIntValue(thread, "Period") ;
			period = Long.toString(value) ;
		}
		catch(Exception e)
		{
			period = null ;
		}

		// If period is not set, don't generate.
		if(period != null)
		{
			mainImplCode.addOutput(',' + period) ;
		}

		try
		{
			long value = PropertyUtils.getIntValue(thread, "Deadline") ;
			deadline = Long.toString(value) ;
		}
		catch(Exception e)
		{
			// If deadline is not set, use period instead.
			deadline = period ;
		}

		// If period and deadline are not set , don't generate.
		if(deadline != null)
		{
			mainImplCode.addOutput(',' + deadline) ;
		}

		try
		{
			float value =
					PropertyUtils.getMaxRangeValue(thread, "Compute_Execution_Time") ;
			timeCapacity = Integer.toString((int) value) ;
		}
		catch(Exception e)
		{
			timeCapacity = null ;
		}

		// If compute execution time is not set, don't generate.
		if(timeCapacity != null)
		{
			mainImplCode.addOutput(',' + timeCapacity) ;
		}
		
		mainImplCode.addOutputNewline(");");
		
	}

	private void genMainHeader(ProcessImplementation process,
			UnparseText mainHeaderCode)
	{
		List<ThreadSubcomponent> bindedThreads =
				process.getOwnedThreadSubcomponents() ;

		String guard = GenerationUtilsADA.generateHeaderInclusionGuard("main.ads") ;
		mainHeaderCode.addOutputNewline(guard) ;
		mainHeaderCode.incrementIndent();
		mainHeaderCode.addOutputNewline("procedure Main;");
		mainHeaderCode.decrementIndent();
		mainHeaderCode.addOutputNewline("");
		genMainHeaderEnd(process, mainHeaderCode);

	}
	
	protected void genMainHeaderEnd(ProcessImplementation process,
			UnparseText mainHeaderCode){
		mainHeaderCode.addOutputNewline("end Main;");
	}


	private void genMainImpl(ProcessImplementation process,
			UnparseText mainImplCode)
	{
		EList<ThreadSubcomponent> lthreads =
				process.getOwnedThreadSubcomponents() ;

		genFileIncludedMainImpl(mainImplCode) ;
		
		String guard = GenerationUtilsADA.generateHeaderInclusionGuard("main.adb") ;
		mainImplCode.addOutputNewline(guard) ;
		mainImplCode.incrementIndent();
		

		// Global files.
		//genGlobalVariablesMainImpl(process, lthreads, mainImplCode);

		// main function declaration.
		//mainImplCode.addOutputNewline(GenerationUtilsADA
			//	.generateSectionTitle("MAIN")) ;
		mainImplCode.addOutputNewline("procedure Main is") ;
		mainImplCode.incrementIndent();
		mainImplCode.addOutputNewline("tinfo : Task_Info;") ;

		
		// For each declared thread
		// Zero stands for ARINC's IDL thread.
		int threadIndex = 1 ;

		// Thread declarations.
		for(ThreadSubcomponent thread : lthreads)
		{
			genThreadDeclarationMainImpl(thread, threadIndex, mainImplCode) ;
			threadIndex++ ;
		}

		mainImplCode.decrementIndent();
		mainImplCode.addOutputNewline("begin") ;
		mainImplCode.incrementIndent();
		mainImplCode.addOutputNewline("null;");
		mainImplCode.decrementIndent();
		mainImplCode.addOutputNewline("end Main;") ;
		mainImplCode.decrementIndent();
		mainImplCode.addOutputNewline(GenerationUtilsADA.generateSectionMark()) ;
		genMainImplEnd(process, mainImplCode);
	}

	protected void genMainImplEnd(ProcessImplementation process,
			UnparseText mainImplCode){
		mainImplCode.addOutputNewline("end Main;");
	}


	@Override
	public void setParameters(Map<Enum<?>, Object> parameters)
	{
		throw new UnsupportedOperationException() ;
	}

	public TargetProperties process(SystemImplementation si,
			File generatedFilePath)
					throws GenerationException
					{
		SystemInstance system = (SystemInstance) 
				HookAccessImpl.getTransformationTrace(si) ;

		RoutingProperties routing = new RoutingProperties();
		routing.setRoutingProperties(system);

		return routing ;
		/*
	  for(ComponentInstance subComponent: system.getComponentInstances())
	  {
		  processComponentInstance(subComponent, generatedFilePath, routing);
	  }
		 */
					}

}



