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

package fr.tpt.aadl.ramses.util.generation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList ;
import java.util.Iterator ;
import java.util.LinkedHashSet;
import java.util.List ;
import java.util.Set ;

import org.eclipse.emf.common.util.EList ;
import org.eclipse.emf.ecore.EObject;
import org.osate.aadl2.AnnexSubclause;
import org.osate.aadl2.CallSpecification ;
import org.osate.aadl2.Data ;
import org.osate.aadl2.DataClassifier ;
import org.osate.aadl2.DataSubcomponent ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.ListValue ;
import org.osate.aadl2.MemorySubcomponent ;
import org.osate.aadl2.ModalPropertyValue ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.Parameter ;
import org.osate.aadl2.Port ;
import org.osate.aadl2.ProcessImplementation ;
import org.osate.aadl2.ProcessSubcomponent ;
import org.osate.aadl2.ProcessorSubcomponent ;
import org.osate.aadl2.Property ;
import org.osate.aadl2.PropertyAssociation ;
import org.osate.aadl2.PropertyExpression ;
import org.osate.aadl2.ReferenceValue ;
import org.osate.aadl2.StringLiteral ;
import org.osate.aadl2.Subcomponent ;
import org.osate.aadl2.Subprogram;
import org.osate.aadl2.SubprogramCall ;
import org.osate.aadl2.SubprogramCallSequence ;
import org.osate.aadl2.SubprogramImplementation ;
import org.osate.aadl2.SubprogramSubcomponent;
import org.osate.aadl2.SubprogramSubcomponentType;
import org.osate.aadl2.SubprogramType ;
import org.osate.aadl2.SystemImplementation ;
import org.osate.aadl2.ThreadImplementation ;
import org.osate.aadl2.ThreadSubcomponent ;
import org.osate.aadl2.VirtualProcessorSubcomponent ;
import org.osate.aadl2.modelsupport.UnparseText;
import org.osate.ba.aadlba.BehaviorActionBlock ;
import org.osate.ba.aadlba.BehaviorAnnex ;
import org.osate.ba.aadlba.BehaviorElement ;
import org.osate.ba.aadlba.DataRepresentation ;
import org.osate.ba.aadlba.SubprogramCallAction ;
import org.osate.ba.analyzers.TypeHolder ;
import org.osate.ba.utils.AadlBaUtils ;
import org.osate.ba.utils.DimensionException ;
import org.osate.utils.PropertyUtils ;
import org.osate.utils.names.DataModelProperties ;


public class GeneratorUtils
{

  @SuppressWarnings("unused")
  public static String getInitialValue(Element e, String language)
  {
    StringBuilder initialization = new StringBuilder() ;

    if(e instanceof Data)
    {
      Data d = (Data) e ;
      TypeHolder dataTypeHolder ;

      try
      {
        if(d instanceof DataSubcomponent)
        {
          DataSubcomponent ds = (DataSubcomponent) d ;

          for(PropertyAssociation pa : ds.getOwnedPropertyAssociations())
          {
            Property p = pa.getProperty() ;

            // Sometime, properties don't have name.
            if(p.getName() != null &&
                  p.getName()
                        .equalsIgnoreCase(DataModelProperties.INITIAL_VALUE))
            {
              setInitialization(ds, initialization, PropertyUtils
                                      .getPropertyExpression(pa), language) ;
              return initialization.toString() ;
            }
          }

          return getInitialValue(ds.getClassifier(), language) ;
        }
        else if(d instanceof DataClassifier)
        {
          DataClassifier dc = (DataClassifier) d ;
          
          EList<PropertyExpression> initialValueProperty =
                PropertyUtils
                      .getPropertyExpression(dc,
                                             DataModelProperties.INITIAL_VALUE) ;
          setInitialization(dc, initialization, initialValueProperty, language) ;
//          String ret = "";
          
//          if (language.equalsIgnoreCase("java"))
//          {
//        	if (AadlBaUtils.getDataRepresentation(dc) == DataRepresentation.ENUM)	
//        	{
//              	ret += dc.getQualifiedName() + "_";
//
//        	}  
//          }
          
          return initialization.toString() ;
//          return ret;
        }

        dataTypeHolder = AadlBaUtils.getTypeHolder(d) ;
      }
      catch(DimensionException exp)
      {
        // TODO Auto-generated catch block
        exp.printStackTrace() ;
      }
    }
    else if(e instanceof Port)
    {
    }
    else if(e instanceof Parameter)
    {
    }

    return initialization.toString() ;
  }

  public static Subcomponent getDeloymentProcessorSubcomponentName(
                                       ProcessSubcomponent aProcessSubcomponent)
  {
    PropertyAssociation aPropertyAssociation =
          PropertyUtils.findProperty("Actual_Processor_Binding",
                                     aProcessSubcomponent) ;

    if(aPropertyAssociation == null)
    {
    	System.out.println("ERROR: Actual_Processor_Binding property not set for component instance "+
    			aProcessSubcomponent.getName());
    	return null;
    }
    for(ModalPropertyValue aModalPropertyValue : aPropertyAssociation
          .getOwnedValues())
    {
      if(aModalPropertyValue.getOwnedValue() instanceof ListValue)
      {
        ListValue list = (ListValue) aModalPropertyValue.getOwnedValue() ;

        for(PropertyExpression pe : list.getOwnedListElements())
        {
          if(pe instanceof ReferenceValue)
          {
            ReferenceValue rv = (ReferenceValue) pe ;
            NamedElement anElement =
                  rv.getContainmentPathElements().get(0).getNamedElement() ;

            if(anElement instanceof ProcessorSubcomponent)
            {
              ProcessorSubcomponent ps = (ProcessorSubcomponent) anElement ;
              return ps ;
            }
            else if(anElement instanceof VirtualProcessorSubcomponent)
            {
              VirtualProcessorSubcomponent vps =
                    (VirtualProcessorSubcomponent) anElement ;
              return vps ;
            }
          }
        }
      }
    }

    return null ;
  }

  public static List<ProcessSubcomponent> getBindedProcesses(
                                                   ProcessorSubcomponent object)
  {
    List<ProcessSubcomponent> bindedProcess =
          new ArrayList<ProcessSubcomponent>() ;
    SystemImplementation si = (SystemImplementation) object.eContainer() ;

    for(ProcessSubcomponent ps : si.getOwnedProcessSubcomponents())
    {
      if(getDeloymentProcessorSubcomponentName(ps)
            .equals(object))
      {
        bindedProcess.add(ps) ;
      }
    }

    return bindedProcess ;
  }

  public static Set<File> getListOfReferencedObjects(ProcessImplementation aProcessImplementation) throws Exception
  {
    Set<File> result = new LinkedHashSet<File>() ;
    Set<File> includeDirList = FileUtils.getIncludeDir(aProcessImplementation);
    for(ThreadSubcomponent aTheadSubcomponent : aProcessImplementation
          .getOwnedThreadSubcomponents())
    {
      if(aTheadSubcomponent.getComponentImplementation() != null)
      {
    	getListOfReferencedObjects((ThreadImplementation) aTheadSubcomponent
                                         .getComponentImplementation(), includeDirList, result) ;
      }
      else
      {
        /*
         *  TODO: throw exception, the thread component instance should reference
         *  a thread implementation to call user operations
         */
      }
    }

    return result ;
  }

  public static void getListOfReferencedObjects(
                                     ThreadImplementation aThreadImplementation,
                                     Set<File> includeDirList,
                                     Set<File> result) throws Exception
  {
	for(SubprogramCallSequence aCallSequence : aThreadImplementation
          .getOwnedSubprogramCallSequences())
    {
      for(CallSpecification aCallSpecification : aCallSequence
            .getOwnedCallSpecifications())
      {
    	 try
    	 {
    		 getListOfReferencedObjects(aCallSpecification, includeDirList, result) ;
    	 }
    	 catch(Exception e)
    	 {
    		 System.err.println(e.getMessage());
    		 e.printStackTrace();
    		 continue;
    	 }
      }
    }
    for(SubprogramSubcomponent sc:aThreadImplementation.getOwnedSubprogramSubcomponents())
    {
    	try
    	{
    		getListOfReferencedObjects(sc, includeDirList, result) ;
    	}
    	catch(Exception e)
    	{
    		System.err.println(e.getMessage());
    		e.printStackTrace();
    		continue;
    	}
    }
  }

  private static void getListOfReferencedObjects(SubprogramSubcomponent sc,
		  Set<File> includeDirList,
		  Set<File> result) throws Exception {
	SubprogramSubcomponentType sst = sc.getSubprogramSubcomponentType();
	for(PropertyAssociation aPropertyAssociation : sst
            .getOwnedPropertyAssociations())
    {
       getListOfReferencedObjects(aPropertyAssociation, includeDirList, result) ;
    }
	if (sst instanceof SubprogramImplementation)
	{
		SubprogramImplementation si = (SubprogramImplementation) sst;
		for(PropertyAssociation aPropertyAssociation : si.getType()
	            .getOwnedPropertyAssociations())
	    {
	       getListOfReferencedObjects(aPropertyAssociation, includeDirList, result) ;
	    }
	}
	
}

public static void getListOfReferencedObjects(CallSpecification aCallSpecification,
												Set<File> includeDirList,
                                                Set<File> result) throws Exception
  {
    if(aCallSpecification instanceof SubprogramCall)
    {
      SubprogramCall sc = (SubprogramCall) aCallSpecification;
      getListOfReferencedObjects((Subprogram) sc.getCalledSubprogram(), includeDirList, result) ;
    }
  }

  public static boolean getListOfReferencedObjects(Subprogram aSubprogram,
		  Set<File> includeDirList,
		  Set<File> result) throws Exception
  {
	boolean found = false;
  	if(aSubprogram instanceof SubprogramType)
    {
      SubprogramType aSubprogramType =
            (SubprogramType) aSubprogram ;
      for(AnnexSubclause annex: aSubprogramType.getAllAnnexSubclauses())
      {
      	if(annex instanceof BehaviorAnnex)
      	{
      		BehaviorAnnex ba = (BehaviorAnnex) annex;
      		getListOfReferencedObjects(ba,
      			includeDirList,
              	result);
      		return true;
      	}
      }
      for(PropertyAssociation aPropertyAssociation : aSubprogramType
            .getOwnedPropertyAssociations())
      {
        found = getListOfReferencedObjects(aPropertyAssociation, includeDirList, result) ;
        if(found)
          return found;
      }
      if(aSubprogramType.getOwnedExtension()!=null)
      {
    	found = getListOfReferencedObjects((Subprogram)aSubprogramType.getOwnedExtension().getExtended(),
    		  includeDirList,
    		  result);
      }
    }
    else if(aSubprogram instanceof SubprogramImplementation)
    {
      SubprogramImplementation aSubprogramImplementation =
            (SubprogramImplementation) aSubprogram ;

      for(AnnexSubclause annex: aSubprogramImplementation.getAllAnnexSubclauses())
      {
      	if(annex instanceof BehaviorAnnex)
      	{
      		BehaviorAnnex ba = (BehaviorAnnex) annex;
      		getListOfReferencedObjects(ba,
      			includeDirList,
              	result);
      		return true;
      	}
      }
      for(PropertyAssociation aPropertyAssociation : aSubprogramImplementation
            .getOwnedPropertyAssociations())
      {
        found = getListOfReferencedObjects(aPropertyAssociation, includeDirList, result) ;
        if(found)
          return found;
      }
   	  if(aSubprogramImplementation.getOwnedExtension()!=null)
      {
    	found = getListOfReferencedObjects((Subprogram)aSubprogramImplementation.getOwnedExtension().getExtended(),
    		  includeDirList,
    		  result);
      }
      if(!found)
      {
    	found = getListOfReferencedObjects((Subprogram)aSubprogramImplementation.getOwnedExtension().getExtended().getType(),
   			  includeDirList,
   			  result);
      }
      for(CallSpecification aCallSpecification : aSubprogramImplementation
            .getCallSpecifications())
      {
        getListOfReferencedObjects(aCallSpecification, includeDirList, result) ;
      }
    }
  	return found;
  }
  
  private static void getListOfReferencedObjects(BehaviorAnnex ba,
		  Set<File> includeDirList,
		  Set<File> result) throws Exception
	{
		for(BehaviorActionBlock bab: ba.getActions())
		{
			Iterator<EObject> iter = bab.eAllContents();
			while(iter.hasNext())
			{
				EObject next = iter.next();
				if(next instanceof SubprogramCallAction)
				{
					SubprogramCallAction sca = (SubprogramCallAction) next;
					getListOfReferencedObjects((Subprogram) sca.getSubprogram().getElement(), includeDirList, result);
				}
			}
		}
	}

	public static boolean getListOfReferencedObjects(PropertyAssociation aPropertyAssociation,
												Set<File> includeDirList,
                                                Set<File> result) throws Exception
  {
	boolean isSourceTextPA = aPropertyAssociation.getProperty().getName() != null &&
	          (aPropertyAssociation.getProperty().getName()
	                  .equals("Source_Location")
	                  ||
	                  aPropertyAssociation.getProperty().getName()
	                  .equals("Source_Text"));
    if(isSourceTextPA)
    {
      for(ModalPropertyValue aModalPropertyValue : aPropertyAssociation
            .getOwnedValues())
      {
    	PropertyExpression aPE = aModalPropertyValue.getOwnedValue();
    	if(aPE instanceof StringLiteral)
    	{
    	  StringLiteral sl = (StringLiteral) aPE;
    	  String value = sl.getValue();
    	  boolean found = false;
    	  for(File includeDir: includeDirList)
      	  {
      	    File foundFile = new File(includeDir.getAbsoluteFile()+"/"+value);
      	    if(foundFile.exists())
      	    {
      		  result.add(foundFile);
      		  found=true;
      		  break;
      	    }
      	  }
    	  if(!found)
    		System.err.println("file referenced in object "+ aPropertyAssociation.getContainingClassifier().getFullName() + " could not be found "+ value);
    	}
    	else if(aPE instanceof ListValue)
    	{
    	  for(PropertyExpression pe: ((ListValue) aPE).getOwnedListElements())
    	  {
    		StringLiteral sl = (StringLiteral) pe;
          	String value = sl.getValue();
        	boolean found = false;
        	for(File includeDir: includeDirList)
        	{
        	  File foundFile = new File(includeDir.getAbsolutePath()+"/"+value);
        	  if(foundFile.exists())
        	  {
        		result.add(foundFile);
        		found=true;
        		break;
        	  }
        	}
        	if(!found)
        		System.err.println("file referenced in object "+ aPropertyAssociation.getContainingClassifier().getFullName() + " could not be found "+ value);
          }
    	}
      }
    }
    return isSourceTextPA;
  }

  private static void setInitialization(NamedElement obj,
		  								StringBuilder initialization,
                                        List<PropertyExpression> initialValues,
                                        String language)
  {
    for(PropertyExpression pe : initialValues)
    {
      if(pe instanceof ListValue)
      {
        ListValue lv = (ListValue) pe ;
        List<PropertyExpression> initValueList = lv.getOwnedListElements() ;

        if(initValueList.size() > 0)
        {
          if(language.equals("ada"))
            initialization.append(" := ") ;
          else
            initialization.append(" = ") ;
        }

        if(initValueList.size() > 1)
        {
          if(language.equals("ada"))
        	  initialization.append("(") ;
          else
        	  initialization.append("{") ;
        }

        Iterator<PropertyExpression> it = initValueList.iterator() ;

        while(it.hasNext())
        {
          PropertyExpression initValue = it.next() ;

          if(initValue instanceof StringLiteral)
          {
            StringLiteral sl = (StringLiteral) initValue ;
            if (language.equalsIgnoreCase("java"))
            {
            	if (obj instanceof DataClassifier)
            	{
		          	if (AadlBaUtils.getDataRepresentation((DataClassifier)obj) == DataRepresentation.ENUM)	
		          	{
		                	initialization.append(obj.getQualifiedName() + "INSERTDOTHERE");
		
		          	}
            	}
            }
            initialization.append(sl.getValue()) ;

            if(it.hasNext())
            {
              initialization.append(",") ;
            }
          }
        }

        if(initValueList.size() > 1)
        {
          if(language.equals("ada"))
            initialization.append("{") ;
          else
          	initialization.append("}") ;
        }
      }
    }
  }
  
  public static Subcomponent getDeloymentMemorySubcomponent(
                                       ProcessSubcomponent aProcessSubcomponent)
  {
    PropertyAssociation aPropertyAssociation =
          PropertyUtils.findProperty("Actual_Memory_Binding",
                                     aProcessSubcomponent) ;

    for(ModalPropertyValue aModalPropertyValue : aPropertyAssociation
            .getOwnedValues())
  {
    if(aModalPropertyValue.getOwnedValue() instanceof ListValue)
    {
      ListValue list = (ListValue) aModalPropertyValue.getOwnedValue() ;

      for(PropertyExpression pe : list.getOwnedListElements())
      {
        if(pe instanceof ReferenceValue)
        {
          ReferenceValue rv = (ReferenceValue) pe ;
          NamedElement anElement =
               rv.getContainmentPathElements().get(rv.getContainmentPathElements().
                                                   size()-1).getNamedElement() ;

          if(anElement instanceof MemorySubcomponent)
          {
            MemorySubcomponent ms = 
                (MemorySubcomponent) anElement;
            return ms;
          }
        }
      }
    }
  }

  return null ;
  }
  
  public static void executeMake(File generatedFilePath, String EnvirVarId)
  {
    Runtime runtime = Runtime.getRuntime();
    String runtimePath = getRuntimePath(EnvirVarId);
	if(runtimePath!=null && runtimePath!="")
    {
      try
      {
    	Process makeCleanProcess = runtime.exec("make -C "+ generatedFilePath.getAbsolutePath() + " clean") ;
    	makeCleanProcess.waitFor();
        Process makeProcess = runtime.exec("make -C "+ generatedFilePath.getAbsolutePath() + " all POK_PATH="+runtimePath) ;
        makeProcess.waitFor();
        if (makeProcess.exitValue() != 0) {
          System.err.println("Error when compiling generated code: ");

          InputStream is;
          is = makeProcess.getInputStream();
          BufferedReader in = new BufferedReader(new InputStreamReader(is));
          
          String line = null;
          while ((line = in.readLine()) != null) {
            System.err.println(line);
          }
          is = makeProcess.getErrorStream();
          in = new BufferedReader(new InputStreamReader(is));
          line = null;
          while ((line = in.readLine()) != null) {
            System.err.println(line);
          }
        }
        else
        {
          InputStream is;
          is = makeProcess.getInputStream();
          BufferedReader in = new BufferedReader(new InputStreamReader(is));
            
          String line = null;
          while ((line = in.readLine()) != null) {
            System.out.println(line);
          }
          System.out.println("Generated code was successfully built.\n");
        }
      }
      catch(IOException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      catch(InterruptedException e)
      {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
      
    }
	else
	{
		System.out.println("ERROR: could not build generated code, runtime path not found");
	}
  }
  
  public static String getRuntimePath(String EnvirVarId)
  {
    String runtimePath = System.getenv(EnvirVarId);
  	if(runtimePath==null || runtimePath=="")
  		runtimePath = System.getProperty(EnvirVarId);
  	return runtimePath;
  }
  
  public static void saveMakefile(UnparseText text,
          File makeFileDir)
  {
	  try
	  {
		  File makeFile = new File(makeFileDir.getAbsolutePath() + "/Makefile") ;
		  FileWriter fileW = new FileWriter(makeFile) ;
		  BufferedWriter output ;

		  try
		  {
			  output = new BufferedWriter(fileW) ;
			  output.write(text.getParseOutput()) ;
			  output.close() ;
		  }
		  catch(IOException e)
		  {
			  // TODO Auto-generated catch block
			  e.printStackTrace() ;
		  }
	  }
	  catch(IOException e)
	  {
		  // TODO Auto-generated catch block
		  e.printStackTrace() ;
	  }
  }
}
