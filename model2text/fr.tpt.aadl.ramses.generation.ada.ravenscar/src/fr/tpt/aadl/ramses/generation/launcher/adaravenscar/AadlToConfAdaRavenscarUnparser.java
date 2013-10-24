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

import org.osate.aadl2.DirectionType;
import org.osate.aadl2.ProcessImplementation;
import org.osate.aadl2.ProcessSubcomponent;
import org.osate.aadl2.ProcessorSubcomponent;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.ThreadImplementation;
import org.osate.aadl2.ThreadSubcomponent;
import org.osate.aadl2.instance.ComponentInstance;
import org.osate.aadl2.instance.FeatureInstance;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.modelsupport.UnparseText;
import org.osate.utils.PropertyUtils ;

import fr.tpt.aadl.ramses.control.support.generator.AadlTargetUnparser;
import fr.tpt.aadl.ramses.control.support.generator.GenerationException;
import fr.tpt.aadl.ramses.control.support.generator.TargetProperties;
import fr.tpt.aadl.ramses.generation.ada.GenerationUtilsADA;

import fr.tpt.aadl.ramses.transformation.atl.hooks.impl.HookAccessImpl;
import fr.tpt.aadl.ramses.util.generation.FileUtils;
import fr.tpt.aadl.ramses.util.generation.RoutingProperties;


public class AadlToConfAdaRavenscarUnparser implements AadlTargetUnparser
{  	  
	private ProcessorProperties _processorProp;
	List<String> sporadicThreads = new ArrayList<String>();
	List<String> periodicThreads = new ArrayList<String>();
	List<String> portTypeThreads = new ArrayList<String>();
    int nbSporadic = 0;
    int nbPeriodic=0;
    public static int compteurPer=0; 
    
    UnparseText deploymentHeaderCode = new UnparseText() ;

	public void process(ProcessorSubcomponent processor,
			File generatedFilePath,
			TargetProperties tarProp) 
					throws GenerationException
					{ 
		ProcessorProperties processorProp = new ProcessorProperties() ;

		// Discard older processor properties !
		_processorProp = processorProp ;
					}

//	private Port getProcessPort(FeatureInstance fi)
//	{
//		ConnectionInstance ci = null ;
//		ConnectionReference cf = null ;
//		ConnectedElement c = null ;
//
//		// TODO : queue information are not always in process, recursively fetch
//		// these informations.
//		if(DirectionType.OUT == fi.getDirection())
//		{
//			ci = fi.getSrcConnectionInstances().get(0) ;
//			cf = ci.getConnectionReferences().get(0) ; 
//			c = (ConnectedElement)(cf.getConnection().getDestination()) ;
//		}
//		else
//		{
//			ci = fi.getDstConnectionInstances().get(0) ;
//			EList<ConnectionReference> crl = ci.getConnectionReferences() ;
//			cf = crl.get(crl.size() -1) ;
//			c = (ConnectedElement)(cf.getConnection()).getSource() ;
//		}
//
//		Port p = (Port) c.getConnectionEnd() ;
//
//		return p ;
//	}


	public void process(ProcessSubcomponent process, File generatedFilePath,
			TargetProperties tarProp)
	{
		PartitionProperties pp = new PartitionProperties();

		ProcessImplementation processImpl = (ProcessImplementation) 
				process.getComponentImplementation() ;

		// Generate main.gpr
		UnparseText mainHeaderCode = new UnparseText() ;
		genMainHeader(processImpl, mainHeaderCode, _processorProp, pp);
				
		// Generate main.ads
		UnparseText mainSpecificationCode = new UnparseText() ;
		genMainSpecification(processImpl, mainSpecificationCode, _processorProp, pp);

		// Generate main.adb
		UnparseText mainImplCode = new UnparseText() ;
		genMainImpl(processImpl, mainImplCode, pp) ;

		// Generate rooting.ads
		UnparseText rootingHeaderCode = new UnparseText() ;
		genRootingHeader(processImpl, rootingHeaderCode, pp) ;

		try
		{
			FileUtils.saveFile(generatedFilePath, "main.gpr",
					mainSpecificationCode.getParseOutput()) ;
			
			FileUtils.saveFile(generatedFilePath, "main.adb",
					mainImplCode.getParseOutput()) ;
			
			FileUtils.saveFile(generatedFilePath, "rooting.ads",
					rootingHeaderCode.getParseOutput()) ;
			
		}
		catch(IOException e)
		{
			// TODO : error message to handle.
			e.printStackTrace() ;
		}
	}

	private PartitionProperties genMainHeader(ProcessImplementation process,
			UnparseText mainHeaderCode,
			ProcessorProperties processorProp,
			PartitionProperties pp)
	{
//		List<ThreadSubcomponent> bindedThreads =
//				process.getOwnedThreadSubcomponents() ;

		String guard = GenerationUtilsADA.generateHeaderInclusionGuard("main.ads") ;
		mainHeaderCode.addOutputNewline(guard) ;

		return pp ;
	}

	
	//Generate global variables.
	private void genGlobalVariablesMainImpl(ProcessImplementation process, EList<ThreadSubcomponent> lthreads,
			UnparseText mainImplCode,
			PartitionProperties pp)
	{
		String guard = GenerationUtilsADA.generateHeaderInclusionGuard("main.adb") ;
		mainImplCode.addOutput(guard) ;

		mainImplCode.addOutputNewline(GenerationUtilsADA.generateSectionMarkAda()) ;
		mainImplCode.addOutputNewline(GenerationUtilsADA
				.generateSectionTitleAda("GLOBAL VARIABLES")) ;

		genGlobalVariablesMainOptional(process, mainImplCode);

		mainImplCode.addOutputNewline(GenerationUtilsADA.generateSectionMarkAda()) ;
	}

	protected void genGlobalVariablesMainOptional(ProcessImplementation process,
			UnparseText mainImplCode){}
	
	private void genFileIncludedMainHeader(UnparseText mainHeaderCode)
	{
		// Files included.
		mainHeaderCode.addOutputNewline(GenerationUtilsADA.generateSectionMarkAda()) ;
		mainHeaderCode.addOutputNewline(GenerationUtilsADA
				.generateSectionTitleAda("INCLUSION")) ;
		// always files included:
      // for(String s: AadlToADAUnparser.Includes)
	    mainHeaderCode.addOutputNewline("with \"/usr/local/include/ocarina/runtime/polyorb-hi-ada/polyorb_hi\";");
	    mainHeaderCode.addOutputNewline("with \"/home/smail/workspace/sources/build_and_test/junit_tests/tests/ravenscar/generation_ravenscar_test/\"");
	}

	private void genFileIncludedMainImpl(UnparseText mainImplCode)
	{
		// Files included.
		mainImplCode.addOutputNewline(GenerationUtilsADA.generateSectionMarkAda()) ;
		mainImplCode.addOutputNewline(GenerationUtilsADA
				.generateSectionTitleAda("INCLUSION")) ;
		// always files included:
      // for(String s: AadlToADAUnparser.Includes)
		mainImplCode.addOutputNewline("with Activity;");
		mainImplCode.addOutputNewline("with PolyORB_HI.Output;use PolyORB_HI.Output;");
		mainImplCode.addOutputNewline("with Warnings (Off, Activity);");
		mainImplCode.addOutputNewline("with Elaborate_All (Activity);");
		mainImplCode.addOutputNewline("with System;");
		mainImplCode.addOutputNewline("with PolyORB_HI.Suspenders;");
	}

	private void genThreadDeclarationMainImpl(ThreadSubcomponent thread,
			int threadIndex,
			UnparseText mainImplCode,
			ProcessImplementation procImpl)
	{
			
		ThreadImplementation timpl =
				(ThreadImplementation) thread.getComponentImplementation() ;
		
		mainImplCode.incrementIndent();		
		String Dispatch = null;
		 
			    try {
					Dispatch = PropertyUtils.getEnumValue(thread, "Dispatch_Protocol");
				} catch (Exception exception) {
					System.out.println("exception");
				}
			 if (Dispatch.equals("Sporadic"))
			 {   
				 nbSporadic++;
				 portTypeThreads.add(GenerationUtilsADA.getGenerationADAIdentifier(procImpl.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(thread.getFullName())+"_Port_Type");
				 sporadicThreads.add(GenerationUtilsADA.getGenerationADAIdentifier(procImpl.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(thread.getFullName())+"_K");
			 }
			 else
			 {
				 nbPeriodic++;
				 periodicThreads.add(GenerationUtilsADA.getGenerationADAIdentifier(procImpl.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(thread.getFullName())+"_K");
			 }
			

		mainImplCode.addOutputNewline("");
		mainImplCode.addOutput("package "+GenerationUtilsADA.getGenerationADAIdentifier(timpl.getQualifiedName())+"_Task "+ "is new PolyORB_HI.Periodic_Task");
		mainImplCode.addOutputNewline(" (");

		mainImplCode.addOutputNewline("Entity => Rooting."+periodicThreads.get(compteurPer).toString()+",") ;
		compteurPer++;
		 
		String period = null ;

		try
		{
			long value = PropertyUtils.getIntValue(thread, "Period") ;
			period = Long.toString(value) ;
		}
		catch(Exception e)
		{
			period = null ;
		}

		if(period != null)
		{
			mainImplCode.addOutput("Task_Period => Ada.Real_Time.Milliseconds ") ;
			mainImplCode.addOutputNewline("("+period+")" + ',') ;
		}
		mainImplCode.addOutput("Task_Deadline => Ada.Real_Time.Milliseconds ") ;
		mainImplCode.addOutputNewline("("+period+")" + ',') ;
		
		String priority;

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
		
		if(priority != null)
		{
			mainImplCode.addOutput("Task_Priority => ") ;
			mainImplCode.addOutputNewline("("+priority+")" + ',') ;
		}
		
		mainImplCode.addOutputNewline("Task_Stack_Size => 10000,");
		mainImplCode.addOutputNewline("Job => "+GenerationUtilsADA.getGenerationADAIdentifier(timpl.getQualifiedName())+GenerationUtilsADA.THREAD_SUFFIX);
		mainImplCode.addOutputNewline(");");
		mainImplCode.decrementIndent();
	}

	private void genRootingHeader(ProcessImplementation process,
			UnparseText rootingHeaderCode,
			PartitionProperties pp)
	{
		rootingHeaderCode.addOutputNewline("package Rooting is");
		rootingHeaderCode.incrementIndent();
		rootingHeaderCode.addOutputNewline("type Node_Type is");
		rootingHeaderCode.incrementIndent();
		rootingHeaderCode.addOutputNewline("("+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_K);");
		rootingHeaderCode.decrementIndent();
		rootingHeaderCode.addOutputNewline("");				 
		rootingHeaderCode.addOutputNewline("for Node_Type use ");
		rootingHeaderCode.incrementIndent();
		rootingHeaderCode.addOutputNewline("("+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_K => 1);");
		rootingHeaderCode.decrementIndent();
		rootingHeaderCode.addOutputNewline("");				 					
		rootingHeaderCode.addOutputNewline("for Node_Type'Size use 8;");
		rootingHeaderCode.addOutputNewline("");				 					 
		rootingHeaderCode.addOutputNewline("Max_Node_Image_Size : constant Standard.Integer := 11;");
		rootingHeaderCode.addOutputNewline(""); 
		rootingHeaderCode.addOutputNewline("subtype UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_Node_Type_Range is ");
		rootingHeaderCode.incrementIndent();
		rootingHeaderCode.addOutputNewline("Node_Type range Node_Type'First .. Node_Type'Last;");
		rootingHeaderCode.decrementIndent();
		rootingHeaderCode.addOutputNewline("");
		rootingHeaderCode.addOutputNewline("subtype UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_1_Max_Node_Image_Size is");
		rootingHeaderCode.incrementIndent();
		rootingHeaderCode.addOutputNewline("Integer range 1 .. Max_Node_Image_Size;");
		rootingHeaderCode.decrementIndent();
	    rootingHeaderCode.addOutputNewline(""); 
		rootingHeaderCode.addOutputNewline("subtype UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_Node_Image_Component is");
		rootingHeaderCode.incrementIndent();
		rootingHeaderCode.addOutputNewline("Standard.String (UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_1_Max_Node_Image_Size);");
		rootingHeaderCode.decrementIndent();
		rootingHeaderCode.addOutputNewline("");		 
		rootingHeaderCode.addOutputNewline("type UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_Node_Image_Array is");
		rootingHeaderCode.incrementIndent();
		rootingHeaderCode.addOutputNewline("array (UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_Node_Type_Range)");
		rootingHeaderCode.incrementIndent();
		rootingHeaderCode.addOutputNewline("of UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_Node_Image_Component;");
		rootingHeaderCode.decrementIndent();
		rootingHeaderCode.decrementIndent();
		rootingHeaderCode.addOutputNewline("");		
		rootingHeaderCode.addOutputNewline("Node_Image : constant UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_Node_Image_Array := ");
		rootingHeaderCode.incrementIndent();
		rootingHeaderCode.incrementIndent();
		rootingHeaderCode.addOutputNewline("UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_Node_Image_Array'");
		rootingHeaderCode.incrementIndent();
		rootingHeaderCode.addOutputNewline("("+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_K"+" => \""+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_K\");");
		rootingHeaderCode.decrementIndent();
		rootingHeaderCode.decrementIndent();
		rootingHeaderCode.addOutputNewline("");
		rootingHeaderCode.addOutputNewline("My_Node : constant Node_Type :=");
		rootingHeaderCode.incrementIndent();
		rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_K"+";");
		rootingHeaderCode.decrementIndent();
		rootingHeaderCode.addOutputNewline("");
		rootingHeaderCode.addOutputNewline("--  For each thread in the distributed application nodes, add an enumerator");
		rootingHeaderCode.addOutputNewline("");
		rootingHeaderCode.addOutputNewline("type Entity_Type is "); 
		rootingHeaderCode.addOutput("(");
		int taille  = process.getOwnedThreadSubcomponents().size();
		int taille2 = process.getOwnedThreadSubcomponents().size();
		int taille3 = process.getOwnedThreadSubcomponents().size();
		int taille4 = process.getOwnedThreadSubcomponents().size();

		 for (ThreadSubcomponent th : process.getOwnedThreadSubcomponents())
		 {
			 taille--;
			 if(taille >= 1)
				 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K,");
			 else
				 rootingHeaderCode.addOutput(GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K");
		 }

		 rootingHeaderCode.addOutputNewline(");");

		 rootingHeaderCode.addOutputNewline("");

		 rootingHeaderCode.addOutputNewline("for Entity_Type use");
		 rootingHeaderCode.addOutput("(");

		 int cpt = 0;

		 for (ThreadSubcomponent th : process.getOwnedThreadSubcomponents())
		 {
			 cpt++;
			 taille2--;
			 if(taille2 >= 1)
			 {
				 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
				 rootingHeaderCode.incrementIndent();
				 rootingHeaderCode.incrementIndent();
				 rootingHeaderCode.addOutputNewline(""+cpt+",");
				 rootingHeaderCode.decrementIndent();
				 rootingHeaderCode.decrementIndent();
			 }
			 else
			 {
			 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
			 rootingHeaderCode.incrementIndent();
			 rootingHeaderCode.incrementIndent();
			 rootingHeaderCode.addOutput(""+cpt);
			 rootingHeaderCode.decrementIndent();
			 rootingHeaderCode.decrementIndent();
			 }
		 }
		 rootingHeaderCode.addOutputNewline(");");

		 rootingHeaderCode.addOutputNewline("");

		 rootingHeaderCode.addOutputNewline("for Entity_Type'Size use 8;");
		 
		 rootingHeaderCode.addOutputNewline("  --  Entity Table");
		 
		 rootingHeaderCode.addOutputNewline("");
		 
		 rootingHeaderCode.addOutputNewline("subtype UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Type_Range is");
		 rootingHeaderCode.addOutputNewline("Entity_Type range Entity_Type'First .. Entity_Type'Last;");

		 rootingHeaderCode.addOutputNewline("");

		 rootingHeaderCode.addOutputNewline("type UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Table_Array is");
		 rootingHeaderCode.addOutputNewline("array (UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Type_Range)");
		 rootingHeaderCode.addOutputNewline("of Node_Type;");
		 
		 rootingHeaderCode.addOutputNewline("");
		 
		 rootingHeaderCode.addOutputNewline("Entity_Table : constant UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Table_Array :=");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.addOutputNewline("UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Table_Array'");
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.addOutputNewline("(");
		 
		 for (ThreadSubcomponent th : process.getOwnedThreadSubcomponents())
		 {
			 
			 taille3--;
			 if(taille3 >= 1)
			 {
				 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
				 rootingHeaderCode.incrementIndent();
				 rootingHeaderCode.incrementIndent();		 
				 rootingHeaderCode.addOutputNewline(""+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_K,");
				 rootingHeaderCode.decrementIndent();
				 rootingHeaderCode.decrementIndent();
			 }
			 else
			 {
			 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
			 rootingHeaderCode.incrementIndent();
			 rootingHeaderCode.incrementIndent();
			 rootingHeaderCode.addOutputNewline(""+GenerationUtilsADA.getGenerationADAIdentifier(process.getContainingComponentImpl().getFullName())+"_K");
			 rootingHeaderCode.decrementIndent();
			 rootingHeaderCode.decrementIndent();
			 }
		 }
		 rootingHeaderCode.addOutputNewline(");");
		 rootingHeaderCode.addOutputNewline("");		 
		 rootingHeaderCode.addOutputNewline("  Max_Entity_Image_Size : constant Standard.Integer := 26;");		 
		 rootingHeaderCode.addOutputNewline("  --  Maximal Entity_Image size for this node ");
		 rootingHeaderCode.addOutputNewline("");	 
		 rootingHeaderCode.addOutputNewline("  --  Maximal Entity_Image size for this node ");
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.addOutputNewline("  --  Entity Image");
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.addOutputNewline("subtype UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_1_Max_Entity_Image_Size is");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.incrementIndent();	 
		 rootingHeaderCode.addOutputNewline("Integer range 1 .. Max_Entity_Image_Size;");
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.addOutputNewline("subtype UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Image_Component is");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.addOutputNewline("Standard.String");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.addOutputNewline("(UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_1_Max_Entity_Image_Size);");
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.addOutputNewline("type UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Image_Array is");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.addOutputNewline("array (UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Type_Range)");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.addOutputNewline("of UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Image_Component;");
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.decrementIndent();	 
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.addOutputNewline("Entity_Image : constant UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Image_Array :=");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.addOutputNewline("UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Entity_Image_Array'");
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.addOutputNewline("(");

		 for (ThreadSubcomponent th : process.getOwnedThreadSubcomponents())
		 {
			 taille4--;
			 if(taille4==process.getOwnedThreadSubcomponents().size()-1)
			 {
				 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
				 rootingHeaderCode.incrementIndent();
				 rootingHeaderCode.incrementIndent();
				 rootingHeaderCode.addOutputNewline("\""+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K    \", ");
				 rootingHeaderCode.decrementIndent();
				 rootingHeaderCode.decrementIndent();
				 
			 }
			 else if(taille4 >= 1)
			 {
				 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
				 rootingHeaderCode.incrementIndent();
				 rootingHeaderCode.incrementIndent();
				 rootingHeaderCode.addOutputNewline("\""+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K  \", ");
				 rootingHeaderCode.decrementIndent();
				 rootingHeaderCode.decrementIndent();
			 }
			 else
			 {
			 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K => ");
			 rootingHeaderCode.incrementIndent();
			 rootingHeaderCode.incrementIndent();
			 rootingHeaderCode.addOutputNewline("\""+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(th.getFullName())+"_K\"");
			 rootingHeaderCode.decrementIndent();
			 rootingHeaderCode.decrementIndent();
			 }
		 }
		 rootingHeaderCode.addOutputNewline(");");
		 rootingHeaderCode.addOutputNewline("");		 
		 rootingHeaderCode.addOutputNewline("  --  For each thread port in the distributed application nodes, add an enumerator");
		 rootingHeaderCode.addOutputNewline("");		 
		 rootingHeaderCode.addOutputNewline("type Port_Type is");
		 rootingHeaderCode.addOutput("(");
		 int sum = 0;
		 int sum2 = 0;
		 int sum3 = 0;
		 int sum4 = 0;
		 int nbP = 0;
		 for (ThreadSubcomponent th : process.getOwnedThreadSubcomponents())
		 {
			 sum =sum +th.getAllFeatures().size();
			 sum2 =sum2 +th.getAllFeatures().size();
			 sum3 = sum3 +th.getAllFeatures().size();
			 sum4 = sum4 +th.getAllFeatures().size();
			 nbP = nbP + th.getAllFeatures().size();					 
		}						 
		 for(int i=0; i<process.getOwnedThreadSubcomponents().size();i++)
		 {
			 for(int nbPorts =0; nbPorts<process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().size();nbPorts++)
			 {
				sum --;
			    if(sum >=1)
		 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K,");
				 else
		 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K");
			 }
		 }
		 rootingHeaderCode.addOutputNewline(");");
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.addOutputNewline("for Port_Type use");
		 rootingHeaderCode.addOutput("(");
		 int cptt =0;
		 for(int i=0; i<process.getOwnedThreadSubcomponents().size();i++)
		 {
			 for(int nbPorts =0; nbPorts<process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().size();nbPorts++)
			 {
				cptt++;
				sum2 --;
				if(sum2 >=1)
			    {
			    	rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => "+cptt+",");
			    }
				    else
				{
			    	rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => "+cptt);
				}
			 }
		 }
		 rootingHeaderCode.addOutputNewline(");");
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.addOutputNewline("  --  Size of Port_Type fixed to 16 bits");
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.addOutputNewline("for Port_Type'Size use 16;");
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.addOutputNewline("--  Port Table");
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.addOutputNewline("subtype UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Type_Range is");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.addOutputNewline("Port_Type range Port_Type'First .. Port_Type'Last;");
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.addOutputNewline("type UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Table_Array is");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.addOutputNewline("array (UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Type_Range)");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.addOutputNewline("of Entity_Type;");
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.addOutputNewline("  Port_Table : constant UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Table_Array :=");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.addOutputNewline("UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Table_Array'");
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.addOutput("(");
		 
		 for(int i=0; i<process.getOwnedThreadSubcomponents().size();i++)
		 {
			 for(int nbPorts =0; nbPorts<process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().size();nbPorts++)
			 {
				sum3 --;
			    if(sum3 >=1)
			    {
			    	 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => ");
					 rootingHeaderCode.incrementIndent();
					 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+process.getOwnedThreadSubcomponents().get(i).getFullName()+"_K"+",");
					 rootingHeaderCode.decrementIndent();
			    }
				 else
				 {
	  				 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => ");		 
	  				 rootingHeaderCode.incrementIndent();
	  				 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+process.getOwnedThreadSubcomponents().get(i).getFullName()+"_K");
					 rootingHeaderCode.decrementIndent();
				 }
			 }
		 }
		 rootingHeaderCode.addOutputNewline(");");
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.addOutputNewline("Max_Port_Image_Size : constant Standard.Integer := 29;");
		 rootingHeaderCode.addOutputNewline("--  Maximal Port_Image size for this node");
		 rootingHeaderCode.addOutputNewline("");		 
		 rootingHeaderCode.addOutputNewline("subtype Port_Sized_String is");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.addOutputNewline("Standard.String");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.addOutputNewline("(1 .. Rooting.Max_Port_Image_Size);");
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.addOutputNewline("--  Port Image");
		 rootingHeaderCode.addOutputNewline("");		 
		 rootingHeaderCode.addOutputNewline("type UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Image_Array is");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.addOutputNewline("array (UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Type_Range)");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.addOutputNewline("of Port_Sized_String;");
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.addOutputNewline("");		 
		 rootingHeaderCode.addOutputNewline("Port_Image : constant UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Image_Array :=");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.addOutputNewline("UT_Rooting_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_Port_Image_Array'");
		 rootingHeaderCode.incrementIndent();
		 rootingHeaderCode.addOutput("(");
		 
		 for(int i=0; i<process.getOwnedThreadSubcomponents().size();i++)
		 {
			 for(int nbPorts =0; nbPorts<process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().size();nbPorts++)
			 {
				sum4 --;

				if(sum4 == nbP-1)
				{
			    	 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => ");
					 rootingHeaderCode.incrementIndent();
			    	 rootingHeaderCode.addOutputNewline("\""+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K    \""+",");
					 rootingHeaderCode.decrementIndent();
				}

				else if(sum4 >=1)
			    {
			    	 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => ");
					 rootingHeaderCode.incrementIndent();
			    	 rootingHeaderCode.addOutputNewline("\""+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K\""+",");
					 rootingHeaderCode.decrementIndent();
			    }
				 else
				 {
	  				 rootingHeaderCode.addOutputNewline(GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K => ");		 
					 rootingHeaderCode.incrementIndent();
	  				 rootingHeaderCode.addOutputNewline("\""+GenerationUtilsADA.getGenerationADAIdentifier(process.getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getFullName())+"_"+GenerationUtilsADA.getGenerationADAIdentifier(process.getOwnedThreadSubcomponents().get(i).getComponentImplementation().getAllFeatures().get(nbPorts).getFullName())+"_K\"");
					 rootingHeaderCode.decrementIndent();
				 }
			 }
		 }
		 
		 rootingHeaderCode.addOutputNewline(");");
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.decrementIndent();
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.addOutputNewline("--  Maximal message payload size for this node (in bits)");
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.addOutputNewline("Max_Payload_Size : constant Standard.Integer := 112;");
		 rootingHeaderCode.addOutputNewline("");
		 rootingHeaderCode.decrementIndent();
 		 rootingHeaderCode.addOutputNewline("end Rooting;");
	}

	private void genMainImpl(ProcessImplementation process,
			UnparseText mainImplCode,
			PartitionProperties pp)
	{
		EList<ThreadSubcomponent> lthreads =
				process.getOwnedThreadSubcomponents() ;
		
		// Global files.
		genGlobalVariablesMainImpl(process, lthreads, mainImplCode, pp);

		genFileIncludedMainImpl(mainImplCode) ;

		
		// main function declaration.
		mainImplCode.addOutputNewline(GenerationUtilsADA
				.generateSectionTitleAda("MAIN BODY")) ;

		mainImplCode.addOutputNewline("procedure Main is");
		mainImplCode.incrementIndent();
		mainImplCode.addOutputNewline("pragma Priority");
		mainImplCode.incrementIndent();
		mainImplCode.addOutputNewline("(System.Priority'Last);");
		mainImplCode.addOutputNewline("");
        mainImplCode.decrementIndent();
        mainImplCode.decrementIndent();
        
		genMainImplEnd(process, mainImplCode);

		mainImplCode.addOutputNewline("begin") ;
		mainImplCode.incrementIndent();
		mainImplCode.addOutputNewline("Put_Line(\"here\");");
		mainImplCode.addOutputNewline("--  Unblock all user tasks");
		mainImplCode.addOutputNewline("PolyORB_HI.Suspenders.Unblock_All_Tasks;");
		mainImplCode.addOutputNewline("--  Suspend forever instead of putting an endless loop. This saves the CPU ressources.");
		mainImplCode.addOutputNewline("PolyORB_HI.Suspenders.Suspend_Forever;");
		mainImplCode.decrementIndent();
		
		// For each declared thread
		// Zero stands for ARINC's IDL thread.
		int threadIndex = 1 ;

		// Thread declarations.
		for(ThreadSubcomponent thread : lthreads)
		{
			genThreadDeclarationMainImpl(thread, threadIndex, mainImplCode, process) ;
			threadIndex++ ;
		}
		mainImplCode.addOutputNewline("end Main;") ;
	}

	protected void genMainImplEnd(ProcessImplementation process,
			UnparseText mainImplCode){}

	private PartitionProperties genMainSpecification(ProcessImplementation process,
			UnparseText mainHeaderCode,
			ProcessorProperties processorProp,
			PartitionProperties pp)
	{

		// Included files.
		genFileIncludedMainHeader(mainHeaderCode) ;
		
		// conditioned files included:


		mainHeaderCode.addOutputNewline(GenerationUtilsADA.generateSectionMarkAda()) ;
		mainHeaderCode.addOutputNewline(GenerationUtilsADA
				.generateSectionTitleAda("MAIN SPECIFICATION")) ;

	    mainHeaderCode.addOutputNewline("project main is");
	    mainHeaderCode.incrementIndent();
	    mainHeaderCode.addOutputNewline("for Source_Dirs use");
	    mainHeaderCode.incrementIndent();
	    mainHeaderCode.addOutput("(\".\",");
	    mainHeaderCode.addOutput("\"/usr/local/include/ocarina/runtime/polyorb-hi-ada\",");
	    mainHeaderCode.addOutputNewline("\"/home/smail/workspace/sources/build_and_test/junit_tests/tests/ravenscar/generation_ravenscar_test/\");");
	    mainHeaderCode.decrementIndent();
	    mainHeaderCode.addOutputNewline("");
	    mainHeaderCode.addOutputNewline("for Main use (\"main.adb\")") ;
	    mainHeaderCode.addOutputNewline("");
	    mainHeaderCode.addOutputNewline("package Naming is") ;
	    mainHeaderCode.incrementIndent();
	    mainHeaderCode.addOutputNewline("--  Custom middleware file names") ;
	    mainHeaderCode.addOutput("for Body (\"PolyORB_HI.Output_Low_Level\") use ") ;
	    mainHeaderCode.addOutputNewline("\"polyorb_hi-output_low_level_native.adb\";") ;
	    mainHeaderCode.decrementIndent();
	    mainHeaderCode.addOutputNewline("end Naming;") ;
	    mainHeaderCode.addOutputNewline("");
	    mainHeaderCode.addOutputNewline("package Compiler renames PolyORB_HI.Compiler;") ;
	    mainHeaderCode.addOutputNewline("package Builder renames PolyORB_HI.Builder;") ;
	    mainHeaderCode.addOutputNewline("package Binder renames PolyORB_HI.Binder;") ;
	    mainHeaderCode.addOutputNewline("package Linker renames PolyORB_HI.Linker;") ;
	    mainHeaderCode.addOutputNewline("package Check renames PolyORB_HI.Check;") ;
	    mainHeaderCode.addOutputNewline("");
	    mainHeaderCode.decrementIndent();
	    mainHeaderCode.addOutputNewline("end Main;") ;

		return pp ;
	}

//	private void genDeploymentImpl(ProcessorSubcomponent processor,
//			UnparseText deploymentImplCode,
//			ProcessorProperties pokProp)
//	{
//		deploymentImplCode.addOutputNewline("with Deployment") ;
//		deploymentImplCode.addOutputNewline("with Gtypes ") ;
//	}
                           

	protected void genDeploymentHeaderEnd(UnparseText deploymentHeaderCode){}

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

	  }
//	  
//	  private List<FeatureInstance> getLocalPorts(ComponentInstance processor,
//			                                          RoutingProperties routeProp)
//		                                                    throws GenerationException
//	  {
//		List<FeatureInstance> localPorts = new ArrayList<FeatureInstance>();
//		if(routeProp.processPerProcessor.get(processor).isEmpty())
//			return localPorts;
//		for(ComponentInstance deployedProcess:routeProp.processPerProcessor.get(processor))
//		{
//		  localPorts.addAll(routeProp.portPerProcess.get(deployedProcess));
//		}
//		return localPorts;
//	  }
	  
	  public static class BlackBoardInfo
	  {
	  	public String id = null ;
	      
	  	public String dataType = null;
	  }
	  
	  public static class QueueInfo
	  {
		public String id = null ;
	    
		public String uniqueId = null;
	    
		public long size = -1 ;
	    
		public String type = null ;
	    
		public String dataType = null;
	    
		public DirectionType direction = null ;
	  }
	  
	  public static class SampleInfo
	  {
		public String id = null ;
	    
		public String uniqueId = null;
	    
		public long refresh = -1 ;
	    
		public String dataType = null;
	    
		public DirectionType direction = null ;
	  }
	  
	  public static class BufferInfo
	  {
		public String id = null ;
	    
		public String uniqueId = null;
	    
		public long refresh = -1 ;
	    
		public String dataType = null;
	    
		public DirectionType direction = null ;
	  }
	}


