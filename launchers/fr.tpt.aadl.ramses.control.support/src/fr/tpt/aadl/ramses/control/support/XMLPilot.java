package fr.tpt.aadl.ramses.control.support;

import java.io.*;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;



public class XMLPilot implements WorkflowPilot
{

	SAXBuilder sxb;
	org.jdom2.Document document;
	Element racine;
	boolean analysisResult;
	

	public XMLPilot(String _xmlFileName)
	{
		SAXBuilder sxb = new SAXBuilder();
		try
		{
			document = sxb.build(new File(_xmlFileName));
			racine = document.getRootElement();
			
			List<Element> listChildren = racine.getChildren();
			Iterator<Element> i = listChildren.iterator();
			
			if(i.hasNext())
			{
				racine = (Element)i.next();
			}
		}
		catch(Exception e){
			System.err.println("Could not launch XMLPilot");
		}
	}

	public boolean hasNextOperation()
	{
		return racine != null;
	}
	
	public String getNextOperation()
	{
		return racine.getName();
	}
	
	public String getNextAnalysisName()
	{
		if(racine.getName() == "analysis")
		{
			return racine.getAttributeValue("method");
		}
		else
		{
			System.err.println("You cannot ask for an analysis name if the current state is not an analysis.");
			return null;
		}
	}
	
	public String getNextAnalysisMode()
	{
		if(racine.getName() == "analysis")
		{
			return racine.getAttributeValue("mode");
		}
		else
		{
			System.err.println("You cannot ask for an analysis mode if the current state is not an analysis.");
			return null;
		}
	}
	
	public List<String> getNextTransformationFileNameList()
	{
		if(racine.getName() == "transformation")
		{
			Element nodeFiles = racine.getChild("list");
							
			List<Element> listFileTags = nodeFiles.getChildren("file");
			Iterator<Element> i = listFileTags.iterator();
			
			List<String> listFileNames = new ArrayList<String>();
			
			while(i.hasNext())
			{
				String path = ((Element)i.next()).getAttributeValue("path");
				listFileNames.add(path);
			}
			
			return listFileNames;
		}
		else
		{
			System.err.println("You cannot ask for an asm file if the current state is not a transformation.");
			return null;
		}
	}

	public void setAnalysisResult(boolean _analysisResult)
	{
		analysisResult = _analysisResult;
	}
	
	public void goForward()
	{
		if(racine.getName() == "analysis")
		{
			if(analysisResult)
			{
				racine = racine.getChild("yes");
			}
			else
			{
				racine = racine.getChild("no");
			}
			
			List<Element> listChildren = racine.getChildren();
			Iterator<Element> i = listChildren.iterator();
			
			if(i.hasNext())
			{
				racine = (Element)i.next();
			}
			else
			{
				racine = null;
			}
		}
		else if(racine.getName() == "transformation")
		{
			List<Element> listChildren = racine.getChildren();

			Iterator<Element> j = listChildren.iterator();
			Element tag = null;
			while(j.hasNext())
			{
				Element temp = (Element)j.next();
				if (temp.getName() != "list")
				{
					tag = temp;
					break;
				}
			}
			racine = tag;
			
		}
		else
		{
			racine = null;
		}
	}
}
