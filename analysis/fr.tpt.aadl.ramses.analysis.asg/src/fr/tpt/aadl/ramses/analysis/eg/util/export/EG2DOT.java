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

package fr.tpt.aadl.ramses.analysis.eg.util.export;

import java.io.BufferedWriter ;
import java.io.File ;
import java.io.FileWriter ;
import java.io.IOException ;
import java.util.ArrayList ;
import java.util.HashMap ;
import java.util.List ;

import org.apache.log4j.Logger ;
import org.osate.aadl2.NamedElement ;
import org.osate.aadl2.instance.ComponentInstance ;

import fr.tpt.aadl.ramses.analysis.eg.model.EGNode ;
import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;

public class EG2DOT extends EGExport
{
	public enum DOTLayout {dot,neato,twopi,fdp,sfdp};
	
	private static Logger _LOGGER = Logger.getLogger(EG2DOT.class) ;
	
	public static final boolean DELETE_DOT_FILES = false;

	//private boolean exportInit = false;

	private HashMap<String, String> actionToResource = new HashMap<String, String>();
	private final DOTLayout layout;
	private final boolean programFound;
	
	public EG2DOT(String outputDir, DOTLayout layout)
	{
		super(outputDir);
		this.layout = layout;
		this.programFound = commandExists(layout.name());
	}
	
	public EG2DOT(String outputDir)
	{
		this(outputDir, DOTLayout.dot);
	}
	
	public EG2DOT(File outputDir, DOTLayout layout)
	{
	  super(outputDir.getAbsolutePath());
		this.layout = layout;
		this.programFound = commandExists(layout.name());
	}
	
	public EG2DOT(File outputDir)
	{
		this(outputDir, DOTLayout.dot);
	}

	@Override
	protected void visit(ComponentInstance thread, EGNode n)
	{
		final EGNode MAIN_AST = n;

		final String PROCESS_NAME = ((NamedElement) (thread.eContainer())).getName();
		final String TASK_NAME = PROCESS_NAME + "." + thread.getName();
		
		
		/*final String INIT_AST_PATH = outputDir + TASK_NAME
				+ "_init.dot";*/
		final String MAIN_AST_PATH = outputDir + TASK_NAME + "_ast.dot";

		if (programFound)
		{
		  /*if (exportInit)
      {
        saveFlowModelAsPng(INIT_AST, INIT_AST_PATH, priority);
      }*/
      saveModelAsPng(TASK_NAME, MAIN_AST, MAIN_AST_PATH);
		}
		else
		{
			String msg = "cannot export AST to image: command \'" + layout.name() + 
			    "\' is not found";
			_LOGGER.error(msg) ;
			ServiceProvider.SYS_ERR_REP.error(msg, true);
		}
	}

	private void saveModelAsPng(String title, EGNode node, String outputPath)
	{
		try
		{
		  File f;
	    BufferedWriter writer;
	    String content;
	    List<String> actionNames;
	    List<String> transitionNames;
	    f = new File(outputPath);

	    if (!f.exists())
	    {
	      f.createNewFile();
	    }

	    writer = new BufferedWriter(new FileWriter(outputPath));
	    actionNames = new ArrayList<String>();
	    transitionNames = new ArrayList<String>();
	    collectActionNames(node, actionNames);
	    collectTransitionNames(node, transitionNames, new ArrayList<EGNode>());
	    content = getGlobalContent(title, actionNames, transitionNames);
	    writer.write(content);
	    writer.close();
	    String outputImage = outputPath.replace(".dot", ".svg");
	    String cmd = layout.name() + " " + outputPath + " -Tsvg -o " + outputImage;
	    // _LOGGER.trace(cmd);
	    Process cmdP = Runtime.getRuntime().exec(cmd);
	    cmdP.waitFor();

	    if (DELETE_DOT_FILES)
	    {
	      f.delete();
	    }
		}
		catch(Exception e) // IOException & InterruptExecutionException.
		{
		  String msg = "cannot save the model into png" ;
		  _LOGGER.fatal(msg, e) ;
		  throw new RuntimeException(msg, e) ;
		}
	}

	private String getGlobalContent(String title, List<String> actionNames,
			                            List<String> transitionNames)
	{
		String s = "digraph TaskFlow {\n\t label = \"" + title + "\";\n\n";

		for (int index = 0; index < actionNames.size(); index++)
		{
		  String actionName = actionNames.get(index);
		  String sharedData = actionToResource.get(actionName);
			String shape = "";
			
			if (sharedData!=null)
      {
        shape = " shape=box";
      }
			else if (actionName.contains("*"))
			{
			  shape = " shape=plaintext";
			}
			
			if (!shape.isEmpty())
			{
				actionName = smoothText(actionName) + " ["+shape+"]";
			}
			else
			{
			  actionName = smoothText(actionName);
			}
			/*
			s += "\n\t" + smoothText(actionName) + " [label=\""
					+ smoothText(actionLabel) + "\"];";
			*/
			s += "\n\t" + actionName + ";";
		}

		s += "\n\n";

		for (String transitionName : transitionNames)
		{
			s += "\n\t" + transitionName + ";";
		}

		return s + "\n}";
	}

	private static String smoothText (String name)
	{
	  while (name.contains("."))
	  {
	    name = name.replace(".", "_");
	  }
	  while (name.contains("\t"))
	  {
	    name = name.replace("\t", "__");
	  }
	  while (name.contains(" "))
	  {
	    name = name.replace(" ", "_");
	  }
	  name = name.replace("*", "");
	  return name;
	}
	
	/*
	private static String smoothName(String name)
	{
		String newname = name;

		while (newname.contains("-"))
		{
			newname = newname.replace("-", "_");
		}
		while (newname.contains(" "))
		{
		  newname = newname.replace(" ", "_");
		}
		while (newname.contains("\t"))
    {
      newname = newname.replace("\t", "_");
    }

		return newname;
	}

	private String smoothLabel(String name)
	{
		String newname = name;

		while (newname.contains("-"))
		{
			newname = newname.replace("-", "_");
		}

		int index = newname.lastIndexOf("__");

		if (index != -1)
		{
			newname = newname.substring(0, index);
		}

		String resourceID = actionToResource.get(name);

		if (resourceID != null)
		{
			newname += " (" + resourceID + ")";
		}

		return newname;
	}*/

	private void collectActionNames(EGNode node, List<String> names)
	{
	  String key = node.getName();
	  
		if (node.getBCET()+node.getWCET()==0)
		{
		  key = node.getName()+"*";
		}
		names.add(key);

		if (node.getSharedData() != null)
		{
		  actionToResource.put(key, node.getSharedData().getName());
		}

		for (EGNode next : node.getAllNext())
		{
			if (!names.contains(next.getName()))
			{
				collectActionNames(next, names);
			}
		}
	}

	private static void collectTransitionNames(EGNode node,
			List<String> transitions, List<EGNode> visited)
	{
		if (!visited.contains(node))
		{
			visited.add(node);

			for (EGNode next : node.getAllNext())
			{
				double min = node.getBCET();
				double max = node.getWCET();
				ComponentInstance sharedData = (ComponentInstance) node.getSharedData();
				String sharedDataStr = (sharedData==null? "" : " data = " + sharedData.getName());
				
				String properties = "";
				if (min+max>0)
				{
				  properties += "[" + min + ","+ max + "]";
				}
				properties = properties + sharedDataStr;
				if (!properties.isEmpty())
				{
				  properties = "[label=\"" + properties + "\"]";
				}
				
				String name = smoothText(node.getName())
						+ " -> "
				    + smoothText(next.getName()) + properties;
				transitions.add(name);
				collectTransitionNames(next, transitions, visited);
			}
		}
	}
	
	private static boolean commandExists(String cmd)
	{
		boolean exist = true;
		try
		{
			Process p = Runtime.getRuntime().exec(new String[]{cmd});
			p.destroy();
		}
		catch (IOException e)
		{
			exist = false;
		}
		return exist;
	}
}