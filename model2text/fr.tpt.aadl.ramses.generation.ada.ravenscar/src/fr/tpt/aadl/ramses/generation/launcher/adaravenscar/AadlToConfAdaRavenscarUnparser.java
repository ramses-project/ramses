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


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.UnparseText;
import org.osate.aadl2.modelsupport.modeltraversal.AadlProcessingSwitch;

import fr.tpt.aadl.ramses.control.support.generator.AadlTargetUnparser;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.ada.AadlToADASwitchProcess;
import fr.tpt.aadl.ramses.generation.ada.GenerationUtilsADA;

import fr.tpt.aadl.ramses.transformation.atl.hooks.impl.HookAccessImpl;
import fr.tpt.aadl.ramses.util.generation.FileUtils;
import fr.tpt.aadl.ramses.util.generation.RoutingProperties;
import fr.tpt.aadl.utils.PropertyNotFound;
import fr.tpt.aadl.utils.PropertyUtils;


public class AadlToConfAdaRavenscarUnparser extends AadlProcessingSwitch implements AadlTargetUnparser
{
//	private final static long DEFAULT_REQUIRED_STACK_SIZE = 16384 ;

	
	// partition rooting.ads
	protected AadlToADASwitchProcess _rootingHeaderCode ;
	private static final String MAIN_HEADER_INCLUSION = "\n" ;

	int nbSporadic = 0;
    int nbPeriodic=0;
	
    List<String> sporadicThreads = new ArrayList<String>();
    List<String> periodicThreads = new ArrayList<String>();
    
	public void process(ProcessorSubcomponent processor,
			File generatedFilePath,
			TargetProperties tarProp) 
					throws GenerationException
					{}
			
	private void saveFile(FileWriter file,
			String ... content)
	{
		BufferedWriter output ;
		StringBuilder sb = new StringBuilder() ;

		for(String s : content)
		{
			sb.append(s) ;
		}

		try
		{
			output = new BufferedWriter(file) ;

			output.write(sb.toString()) ;

			output.close() ;
		}
		catch(IOException e)
		{
			// TODO: handle error message.
			e.printStackTrace() ;
		}
	}

	public void process(ProcessSubcomponent process, File generatedFilePath,
			TargetProperties tarProp)
	{

		ProcessImplementation processImpl = (ProcessImplementation) 
				process.getComponentImplementation() ;

		//this.findCommunicationMechanism(processImpl, pp);

		// Generate main.gpr
		UnparseText mainHeaderCode = new UnparseText() ;
		genMainHeader(processImpl, mainHeaderCode);

		// Generate main.adb
		UnparseText mainImplCode = new UnparseText() ;
		genMainImpl(processImpl, mainImplCode) ;

		_rootingHeaderCode = new AadlToADASwitchProcess(this) ;	

		try
		{
			FileUtils.saveFile(generatedFilePath, "main.gpr",
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
		mainImplCode.addOutputNewline(GenerationUtilsADA.generateSectionMarkAda()) ;
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

		mainImplCode.addOutputNewline(GenerationUtilsADA.generateSectionMarkAda()) ;
	}

	public void saveGeneratedFilesContent(File targetDirectory)
	{

		// partition's rooting.ads

		try {
			String headerGuard = null ;
			
			FileWriter rootingFile_ADS = new FileWriter(targetDirectory.getAbsolutePath() + "/rooting.ads");

			headerGuard = GenerationUtilsADA.generateHeaderInclusionGuard("rooting.ads");
			String addRootingHeader_ADS = "pragma Style_Checks(\"NM32766\");\n" + headerGuard;
			saveFile(rootingFile_ADS, "", MAIN_HEADER_INCLUSION,
					addRootingHeader_ADS, _rootingHeaderCode.getOutput()) ;
            } catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	protected void genGlobalVariablesMainOptional(ProcessImplementation process,
			UnparseText mainImplCode){}

	private void genFileIncludedMainImpl(UnparseText mainImplCode)
	{
		// Files included.
		mainImplCode.addOutputNewline(GenerationUtilsADA.generateSectionMarkAda()) ;
		//mainImplCode.addOutputNewline(GenerationUtilsADA
		//.generateSectionTitle("INCLUSION")) ;

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

		String guard = GenerationUtilsADA.generateHeaderInclusionGuard("main.gpr") ;
		mainHeaderCode.addOutputNewline(guard) ;
		mainHeaderCode.incrementIndent();
		mainHeaderCode.addOutputNewline("procedure Main;");
		mainHeaderCode.decrementIndent();
		mainHeaderCode.addOutputNewline("");
		genMainHeaderEnd(process, mainHeaderCode);
		
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("pragma Preelaborate;");
		 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("type Node_Type is ");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("("+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_K);");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.addOutputNewline("");				 

		 _rootingHeaderCode.addOutputNewline("for Node_Type use ");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("("+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_K => 1);");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 
		 _rootingHeaderCode.addOutputNewline("");				 					
		 
		 _rootingHeaderCode.addOutputNewline("for Node_Type'Size use 8;");
		 
		 _rootingHeaderCode.addOutputNewline("");				 					
		 
		 _rootingHeaderCode.addOutputNewline("Max_Node_Image_Size : constant Standard.Integer := 8;");
		 
		 _rootingHeaderCode.addOutputNewline("");				 					
		 
		 _rootingHeaderCode.addOutputNewline("subtype UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_Node_Type_Range is ");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("Node_Type range Node_Type'First .. Node_Type'Last;");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 				 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("subtype UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_1_Max_Node_Image_Size is");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("Integer range 1 .. Max_Node_Image_Size;");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();

		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("subtype UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_Node_Image_Component is");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("Standard.String (UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_1_Max_Node_Image_Size);");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();

		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("type UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_Node_Image_Array is");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("array (UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_Node_Type_Range)");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("of UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getQualifiedName()).replaceAll("_refined_", "")+"_Node_Image_Component;");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("Node_Image : constant UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_Node_Image_Array := ");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_Node_Image_Array'");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("("+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+" => \""+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"\");");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();

		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("My_Node : constant Node_Type :=");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+";");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 
		 _rootingHeaderCode.addOutputNewline("");
		 _rootingHeaderCode.addOutputNewline("--  For each thread in the distributed application nodes, add an enumerator");
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("type Entity_Type is ");
		 
		 _rootingHeaderCode.addOutput("(");
		 
		 int taille = process.getOwnedThreadSubcomponents().size();
		 int taille2 = process.getOwnedThreadSubcomponents().size();
		 int taille3 = process.getOwnedThreadSubcomponents().size();
		 int taille4 = process.getOwnedThreadSubcomponents().size();

		 for (ThreadSubcomponent th : process.getOwnedThreadSubcomponents())
		 {
			 taille--;
			 if(taille >= 1)
				 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K,");
			 else
				 _rootingHeaderCode.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K");
		 }

		 _rootingHeaderCode.addOutputNewline(");");

		 _rootingHeaderCode.addOutputNewline("");

		 _rootingHeaderCode.addOutputNewline("for Entity_Type use");
		 _rootingHeaderCode.addOutput("(");

		 int cpt = 0;

		 for (ThreadSubcomponent th : process.getOwnedThreadSubcomponents())
		 {
			 cpt++;
			 taille2--;
			 if(taille2 >= 1)
			 {
				 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
				 _rootingHeaderCode.incrementIndent();
				 _rootingHeaderCode.incrementIndent();
				 _rootingHeaderCode.addOutputNewline(""+cpt+",");
				 _rootingHeaderCode.decrementIndent();
				 _rootingHeaderCode.decrementIndent();
			 }
			 else
			 {
			 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
			 _rootingHeaderCode.incrementIndent();
			 _rootingHeaderCode.incrementIndent();
			 _rootingHeaderCode.addOutput(""+cpt);
			 _rootingHeaderCode.decrementIndent();
			 _rootingHeaderCode.decrementIndent();
			 }
		 }
		 _rootingHeaderCode.addOutputNewline(");");

		 _rootingHeaderCode.addOutputNewline("");

		 _rootingHeaderCode.addOutputNewline("for Entity_Type'Size use 8;");
		 
		 _rootingHeaderCode.addOutputNewline("  --  Entity Table");
		 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("subtype UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Type_Range is");
		 _rootingHeaderCode.addOutputNewline("Entity_Type range Entity_Type'First .. Entity_Type'Last;");

		 _rootingHeaderCode.addOutputNewline("");

		 _rootingHeaderCode.addOutputNewline("type UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Table_Array is");
		 _rootingHeaderCode.addOutputNewline("array (UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Type_Range)");
		 _rootingHeaderCode.addOutputNewline("of Node_Type");
		 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("Entity_Table : constant UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Table_Array :=");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Table_Array'");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.addOutputNewline("(");

		 	String Dispatch = null;
		 	
		 
		 for (ThreadSubcomponent th : process.getOwnedThreadSubcomponents())
		 {

			    try {
					Dispatch = PropertyUtils.getEnumValue(th, "Dispatch_Protocol");
				} catch (Exception exception) {
					throw new PropertyNotFound(exception);
				}
			 if (Dispatch.equals("Sporadic"))
			 {
				 nbSporadic++;
				 sporadicThreads.add(GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K");
			 }
			 else
			 {
				 nbPeriodic++;
				 periodicThreads.add(GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K");
			 }
			 
			 taille3--;
			 if(taille3 >= 1)
			 {
				 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
				 _rootingHeaderCode.incrementIndent();
				 _rootingHeaderCode.incrementIndent();		 
				 _rootingHeaderCode.addOutputNewline(""+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_K,");
				 _rootingHeaderCode.decrementIndent();
				 _rootingHeaderCode.decrementIndent();
			 }
			 else
			 {
			 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
			 _rootingHeaderCode.incrementIndent();
			 _rootingHeaderCode.incrementIndent();
			 _rootingHeaderCode.addOutputNewline(""+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_K");
			 _rootingHeaderCode.decrementIndent();
			 _rootingHeaderCode.decrementIndent();
			 }
		 }
		 					 
		 _rootingHeaderCode.addOutputNewline(");");
		 
		 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("  Max_Entity_Image_Size : constant Standard.Integer := 14");
		 
		 _rootingHeaderCode.addOutputNewline("  --  Maximal Entity_Image size for this node ");
		 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("  --  Maximal Entity_Image size for this node ");

		 _rootingHeaderCode.addOutputNewline("");

		 _rootingHeaderCode.addOutputNewline("  --  Entity Image");
		 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("subtype UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_1_Max_Entity_Image_Size is");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();	 
		 _rootingHeaderCode.addOutputNewline("Integer range 1 .. Max_Entity_Image_Size;");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
	 
		 _rootingHeaderCode.addOutputNewline("");

		 _rootingHeaderCode.addOutputNewline("subtype UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Image_Component is");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("Standard.String");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("(UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_1_Max_Entity_Image_Size);");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
	 
		 _rootingHeaderCode.addOutputNewline("");

		 _rootingHeaderCode.addOutputNewline("type UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Image_Array is");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("array (UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Type_Range)");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("of UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Image_Component;");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
	 
		 _rootingHeaderCode.addOutputNewline("");

		 _rootingHeaderCode.addOutputNewline("Entity_Image : constant UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Image_Array :=");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Image_Array'");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.addOutputNewline("(");

		 for (ThreadSubcomponent th : process.getOwnedThreadSubcomponents())
		 {
			 taille4--;
			 if(taille4 >= 1)
			 {
				 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
				 _rootingHeaderCode.incrementIndent();
				 _rootingHeaderCode.incrementIndent();
				 _rootingHeaderCode.addOutputNewline("\""+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K\"");
				 _rootingHeaderCode.decrementIndent();
				 _rootingHeaderCode.decrementIndent();
			 }
			 else
			 {
			 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
			 _rootingHeaderCode.incrementIndent();
			 _rootingHeaderCode.incrementIndent();
			 _rootingHeaderCode.addOutputNewline("\""+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K\"");
			 _rootingHeaderCode.decrementIndent();
			 _rootingHeaderCode.decrementIndent();

			 }
		 }
		 
		 _rootingHeaderCode.addOutputNewline(");");
		 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("  --  For each thread port in the distributed application nodes, add an enumerator");
		 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("type Port_Type is");

		 _rootingHeaderCode.addOutput("(");

		 int sum = 0;
		 int sum2 = 0;
		 int sum3 = 0;
		 int sum4 = 0;
		 
		 for (ThreadSubcomponent th : process.getOwnedThreadSubcomponents())
		 {
			 sum =sum +th.getAllFeatures().size();
			 sum2 =sum2 +th.getAllFeatures().size();
			 sum3 = sum3 +th.getAllFeatures().size();
			 sum4 = sum4 +th.getAllFeatures().size();
		 }						 
		 
		 for(int i=0; i<process.getOwnedThreadSubcomponents().size();i++)
		 {
			 for(int nbPorts =0; nbPorts<process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().size();nbPorts++)
			 {
				sum --;
			    if(sum >=1)
		 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K,");
				 else
			 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K");		 
			 }
		 }
		 
		 _rootingHeaderCode.addOutputNewline(");");

		 _rootingHeaderCode.addOutputNewline("");


		 _rootingHeaderCode.addOutputNewline("for Port_Type use");

		 _rootingHeaderCode.addOutput("(");

		 int cptt =0;
		 for(int i=0; i<process.getOwnedThreadSubcomponents().size();i++)
		 {
			 for(int nbPorts =0; nbPorts<process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().size();nbPorts++)
			 {
				cptt++;
				sum2 --;
			    if(sum2 >=1)
		 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => "+cptt+",");
				 else
			 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => "+cptt);		 
			 }
		 }
		 _rootingHeaderCode.addOutputNewline(");");
		 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("  --  Size of Port_Type fixed to 16 bits");
		 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("for Port_Type'Size use 16;");
		 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("--  Port Table");
		 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("subtype UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Type_Range is");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("Port_Type range Port_Type'First .. Port_Type'Last;");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("type UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Table_Array is");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("array (UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Type_Range)");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("of Entity_Type;");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();

		 _rootingHeaderCode.addOutputNewline("");

		 _rootingHeaderCode.addOutputNewline("  Port_Table : constant UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Table_Array :=");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Table_Array'");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.addOutput("(");
		 
		 for(int i=0; i<process.getOwnedThreadSubcomponents().size();i++)
		 {
			 for(int nbPorts =0; nbPorts<process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().size();nbPorts++)
			 {
				sum3 --;
			    if(sum3 >=1)
			    {
			    	 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => ");
					 _rootingHeaderCode.incrementIndent();
					 _rootingHeaderCode.incrementIndent();
					 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+process.getOwnedThreadSubcomponents().get(i).getFullName()+"_K"+",");
					 _rootingHeaderCode.decrementIndent();
					 _rootingHeaderCode.decrementIndent();
			    }
				 else
				 {
	  				 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => ");		 
	  				 _rootingHeaderCode.incrementIndent();
					 _rootingHeaderCode.incrementIndent();
	  				 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+process.getOwnedThreadSubcomponents().get(i).getFullName()+"_K");
					 _rootingHeaderCode.decrementIndent();
					 _rootingHeaderCode.decrementIndent();
				 }
			 }
		 }
		 _rootingHeaderCode.addOutputNewline(");");
		 
		 _rootingHeaderCode.addOutputNewline("");

		 _rootingHeaderCode.addOutputNewline("Max_Port_Image_Size : constant Standard.Integer := 19;");
		 
		 _rootingHeaderCode.addOutputNewline("--  Maximal Port_Image size for this node");

		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("subtype Port_Sized_String is");
			 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("Standard.String");
			 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("(1 .. Deployment.Max_Port_Image_Size);");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("--  Port Image");
		 
		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("type UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Image_Array is");
			 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("array (UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Type_Range)");
			 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("of Port_Sized_String;");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();

		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("Port_Image : constant UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Image_Array :=");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutputNewline("UT_Deployment_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Image_Array'");
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.incrementIndent();
		 _rootingHeaderCode.addOutput("(");
		 
		 for(int i=0; i<process.getOwnedThreadSubcomponents().size();i++)
		 {
			 for(int nbPorts =0; nbPorts<process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().size();nbPorts++)
			 {
				sum4 --;
			    if(sum4 >=1)
			    {
			    	 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => ");
					 _rootingHeaderCode.incrementIndent();
					 _rootingHeaderCode.incrementIndent();
			    	 _rootingHeaderCode.addOutputNewline("\""+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K \""+",");
					 _rootingHeaderCode.decrementIndent();
					 _rootingHeaderCode.decrementIndent();
			    }
				 else
				 {
	  				 _rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => ");		 
					 _rootingHeaderCode.incrementIndent();
					 _rootingHeaderCode.incrementIndent();
	  				 _rootingHeaderCode.addOutputNewline("\""+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K \"");
					 _rootingHeaderCode.decrementIndent();
					 _rootingHeaderCode.decrementIndent();
				 }
			 }
		 }
		 
		 _rootingHeaderCode.addOutputNewline(");");
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();
		 _rootingHeaderCode.decrementIndent();


		 _rootingHeaderCode.addOutputNewline("");
		 
		 _rootingHeaderCode.addOutputNewline("--  Maximal message payload size for this node (in bits)");
		
		 _rootingHeaderCode.addOutputNewline("");

		 _rootingHeaderCode.addOutputNewline("Max_Payload_Size : constant Standard.Integer := 112;");

		 _rootingHeaderCode.addOutputNewline("");


	}
	
	protected void genMainHeaderEnd(ProcessImplementation process,
			UnparseText mainHeaderCode){
		mainHeaderCode.addOutputNewline("end Main;");
    	_rootingHeaderCode.addOutputNewline("\nend Rooting;\n") ;

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
		genGlobalVariablesMainImpl(process, lthreads, mainImplCode);

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
		mainImplCode.addOutputNewline(GenerationUtilsADA.generateSectionMarkAda()) ;
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

	@Override
	protected void initSwitches() {
		// TODO Auto-generated method stub
		
	}

}



