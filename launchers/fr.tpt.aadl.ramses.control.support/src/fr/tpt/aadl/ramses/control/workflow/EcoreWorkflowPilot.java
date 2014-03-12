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

import java.io.File ;
import java.io.FileNotFoundException ;
import java.util.ArrayList ;
import java.util.Iterator ;
import java.util.List ;

import org.eclipse.emf.common.util.Diagnostic ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl ;
import org.eclipse.emf.ecore.util.Diagnostician ;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl ;

/**
 * This class is an implementation of the WorkflowPilot for workflows
 * described in an Ecore resource.
 */
public class EcoreWorkflowPilot  implements WorkflowPilot {

	private ResourceSet resourceSet;

	private String workflowFileName;

	private AnalysisElement currentWorkflowElement;

	private boolean analysisResult;
	
	private String sourceModelId;

	/**
	 * This method creates an EcoreWorkflowPilot from the file path passed
	 * as a parameter
	 * @param workflowFileName identifies the path to the file containing 
	 * the workflow description.
	 * @throws FileNotFoundException if the path does not point to any file
	 */
	public EcoreWorkflowPilot(String workflowFileName) throws FileNotFoundException{

		this.workflowFileName = workflowFileName;

		getResourceSet().setResourceFactoryRegistry(
				Resource.Factory.Registry.INSTANCE);

		getResourceSet().getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());
		getResourceSet().getPackageRegistry().put(WorkflowPackage.eNS_URI,
				WorkflowPackage.eINSTANCE);

		final Resource resource;
		URI workflow_uri = URI.createFileURI(this.workflowFileName);
		File testExist = new File(this.workflowFileName);
		if (!testExist.exists())
		{
			System.out.println("Workflow file does not exist: " + testExist.getAbsolutePath());
			throw new FileNotFoundException();
		}

		if (getResourceSet().getURIConverter().exists(workflow_uri, null)) {
			resource = getResourceSet().getResource(workflow_uri, true);
			Workflow workflowRootObject = (Workflow) resource.getContents()
					.get(0);
			
			sourceModelId = workflowRootObject.getInputModelIdentifier().getId();
			
			this.currentWorkflowElement = (AnalysisElement) workflowRootObject.getElement();
			
			Diagnostic diagnostic = Diagnostician.INSTANCE.validate(this.currentWorkflowElement) ;

	        switch ( diagnostic.getSeverity() )
	        {
	          case Diagnostic.ERROR :

	            for(Diagnostic d : diagnostic.getChildren())
	            {
	              System.err.println("Model has errors: "
	                    + resource.getURI().lastSegment() + " " + d.getMessage()) ;
	            }

	            break ;
	          case Diagnostic.WARNING :

	            for(Diagnostic d : diagnostic.getChildren())
	            {
	              System.err.println("Model has warnings: " + d.getMessage()) ;
	            }

	            break ;
	        }
		}

	}

	/**
	 * @see WorkflowPilot#hasNextOperation()
	 */
	public boolean hasNextOperation() {
		return currentWorkflowElement != null;
	}

	/**
	 * @see WorkflowPilot#getNextOperation()
	 */
	public String getNextOperation() {
		if (hasNextOperation()) {
			if (currentWorkflowElement instanceof Transformation) {
				return "transformation";
			} else if (currentWorkflowElement instanceof Analysis) {
				return "analysis";
			} else if (currentWorkflowElement instanceof Generation) {
				return "generation";
			} else if (currentWorkflowElement instanceof Unparse) {
				return "unparse";
			} else if (currentWorkflowElement instanceof Loop) {
			  return "loop";
			}
		}
		return null;
	}

	/**
	 * @see WorkflowPilot#getAnalysisName()
	 */
	public String getAnalysisName() {
		if (currentWorkflowElement instanceof Analysis) {
			return ((Analysis) currentWorkflowElement).getMethod();
		} else {
			System.err
					.println("You cannot ask for an analysis name if the current state is not an analysis.");
			return null;
		}
	}

	/**
	 * @see WorkflowPilot#getAnalysisMode()
	 */
	public String getAnalysisMode() {
		if (currentWorkflowElement instanceof Analysis) {
			return ((Analysis) currentWorkflowElement).getMode();
		} else {
			System.err
					.println("You cannot ask for an analysis mode if the current state is not an analysis.");
			return null;
		}
	}

	/**
	 * @see WorkflowPilot#getTransformationFileNameList()
	 */
	public List<String> getTransformationFileNameList() {
		if (currentWorkflowElement instanceof Transformation) {
			fr.tpt.aadl.ramses.control.workflow.List list = ((Transformation) currentWorkflowElement).getList();

			List<fr.tpt.aadl.ramses.control.workflow.File> listFileTags = list.getFile();
			Iterator<fr.tpt.aadl.ramses.control.workflow.File> listFileTagsIt = listFileTags.iterator();

			List<String> listFileNames = new ArrayList<String>();

			while (listFileTagsIt.hasNext()) {
				listFileNames.add(listFileTagsIt.next().getPath());
			}

			return listFileNames;
		} else {
			System.err
					.println("You cannot ask for an asm file if the current state is not a transformation.");
			return null;
		}
	}

	/**
	 * @see WorkflowPilot#setAnalysisResult(boolean)
	 */
	public void setAnalysisResult(boolean analysisResult) {
		this.analysisResult = analysisResult;
	}
	
	/**
	 * @see WorkflowPilot#getAnalysisResult
	 */
	public boolean getAnalysisResult()
	{
	  return analysisResult;
	}

	/**
	 * @see WorkflowPilot#goForward()
	 */
	public void goForward() {
		if (currentWorkflowElement instanceof Analysis) {
			
			if (analysisResult) {
				currentWorkflowElement = ((Analysis) currentWorkflowElement).getYesOption().getElement();
			} else {
				currentWorkflowElement = ((Analysis) currentWorkflowElement).getNoOption().getElement();
			}
			
		} else if (currentWorkflowElement instanceof Loop) {
		  
		  Loop l = (Loop) currentWorkflowElement;
		  if (analysisResult) {
		    currentWorkflowElement = l.getFoundOption().getElement();
		  } else {
		    currentWorkflowElement = l.getNotFoundOption().getElement();
		  }
			
		} else if (currentWorkflowElement instanceof Transformation) {

			currentWorkflowElement = ((Transformation) currentWorkflowElement).getElement();

		} else if (currentWorkflowElement instanceof Unparse) {
			
			currentWorkflowElement = ((Unparse) currentWorkflowElement).getElement();
			
		} else {
			currentWorkflowElement = null;
		}
	}

	/**
	 * This method returns the workflow resource set.
	 * @return the workflow resource set.
	 */
	protected ResourceSet getResourceSet() {
		if (resourceSet == null) {
			resourceSet = new ResourceSetImpl();
		}
		return resourceSet;
	}

	/**
	 * @see WorkflowPilot#getInputModelId()
	 */
	@Override
	public String getInputModelId() {
		String result=sourceModelId;
		if (currentWorkflowElement instanceof Transformation) {
			Transformation t = (Transformation) currentWorkflowElement;
			result = t.getInputModelIdentifier().getId();
		}
		if (currentWorkflowElement instanceof Analysis) {
			Analysis a = (Analysis) currentWorkflowElement;
			result = a.getInputModelIdentifier().getId();
		}
		return result;
	}

	/**
	 * @see WorkflowPilot#getOutputModelId()
	 */
	@Override
	public String getOutputModelId() {
		String result=null;
		if (currentWorkflowElement instanceof Transformation) {
			Transformation t = (Transformation) currentWorkflowElement;
			result = t.getOutputModelIdentifier().getId();
		}
		if (currentWorkflowElement instanceof Analysis) {
			Analysis a = (Analysis) currentWorkflowElement;
			if(a.getOutputModelIdentifier()!=null)
				result = a.getOutputModelIdentifier().getId();
		}
		if (currentWorkflowElement instanceof Loop) {
		  Loop l = (Loop) currentWorkflowElement;
		  if (l.getOutputModelIdentifier()!=null)
		    result = l.getOutputModelIdentifier().getId();
		}
		return result;
	}

	
	
	
	@Override
  public AbstractLoop getLoop()
  {
    if (currentWorkflowElement instanceof Loop)
    {
      Loop l = (Loop) currentWorkflowElement;
      boolean initialAnalysis = l.isInitialAnalysis();
      String inputModelIdentifier = l.getInputModelIdentifier().getId();
      String outputModelIdentifier = l.getOutputModelIdentifier().getId();
      
      /** Convert analysis */
      AbstractLoop.AbstractAnalysis aa = convertAnalysis(l.getAnalysis());
      
      
      /** Convert module lists */
      List<List<String>> moduleLists = new ArrayList<List<String>>();
      for(fr.tpt.aadl.ramses.control.workflow.List moduleList : l.getAlternatives())
      {
        List<String> moduleListStr = new ArrayList<String>();
        for(fr.tpt.aadl.ramses.control.workflow.File f : moduleList.getFile())
        {
          moduleListStr.add(f.getPath());
        }
        moduleLists.add(moduleListStr);
      }
      
      return new AbstractLoop(initialAnalysis,aa,moduleLists,
          inputModelIdentifier,outputModelIdentifier);
    }
    return null;
  }
  
  private static AbstractLoop.AbstractAnalysis convertAnalysis(AbstractAnalysis aa)
  {
    if (aa instanceof Analysis)
    {
      Analysis a = (Analysis) aa;
      String inputId = a.getInputModelIdentifier().getId();
      String outputId = inputId;
      if (a.getOutputModelIdentifier()!=null)
      {
        outputId = a.getOutputModelIdentifier().getId();
      }
      
      return new AbstractLoop.Analysis(a.getMethod(), a.getMode(), inputId, outputId);
    }
    else if (aa instanceof Conjunction)
    {
      Conjunction seq = (Conjunction) aa;
      AbstractLoop.Conjunction c = new AbstractLoop.Conjunction();
      
      for(AbstractAnalysis subAnalysis : seq.getList())
      {
        c.add(convertAnalysis(subAnalysis));
      }
      return c;
    }
    else if (aa instanceof Disjunction)
    {
      Disjunction seq = (Disjunction) aa;
      AbstractLoop.Disjunction d = new AbstractLoop.Disjunction();
      
      for(AbstractAnalysis subAnalysis : seq.getList())
      {
        d.add(convertAnalysis(subAnalysis));
      }
      return d;
    }
    else
      return null;
  }
	
}
