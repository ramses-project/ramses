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

import org.apache.log4j.Logger ;
import org.eclipse.emf.common.util.Diagnostic ;
import org.eclipse.emf.common.util.URI ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.ecore.resource.ResourceSet ;
import org.eclipse.emf.ecore.util.Diagnostician ;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl ;

import fr.tpt.aadl.ramses.control.support.services.ServiceProvider ;

/**
 * This class is an implementation of the WorkflowPilot for workflows
 * described in an Ecore resource.
 */
public class EcoreWorkflowPilot  implements WorkflowPilot {

	private String workflowFileName;

	private AnalysisElement currentWorkflowElement;
	
	private AnalysisElement previousWorkflowElement;
	
	private String loopModelIdSuffix;
	
	private boolean analysisResult;
	
	private String sourceModelId;

  private Workflow workflowRootObject ;
	
	private static Logger _LOGGER = Logger.getLogger(EcoreWorkflowPilot.class) ;

	/**
	 * This method creates an EcoreWorkflowPilot from the file path passed
	 * as a parameter
	 * @param workflowFileName identifies the path to the file containing 
	 * the workflow description.
	 * @throws FileNotFoundException if the path does not point to any file
	 */
	public EcoreWorkflowPilot(ResourceSet resourceSet,
	                          String workflowFileName) throws FileNotFoundException{

		this.workflowFileName = workflowFileName;

		resourceSet.setResourceFactoryRegistry(
				Resource.Factory.Registry.INSTANCE);

		resourceSet.getResourceFactoryRegistry()
				.getExtensionToFactoryMap()
				.put("xmi", new XMIResourceFactoryImpl());
		resourceSet.getPackageRegistry().put(WorkflowPackage.eNS_URI,
				WorkflowPackage.eINSTANCE);

		final Resource resource;
		URI workflow_uri = URI.createFileURI(this.workflowFileName);
		File testExist = new File(this.workflowFileName);
		if (!testExist.exists())
		{
		  String errMsg = "workflow file does not exist: " + testExist.getAbsolutePath() ;
	    _LOGGER.fatal(errMsg) ;
			throw new FileNotFoundException(errMsg);
		}

		if (resourceSet.getURIConverter().exists(workflow_uri, null)) {
			resource = resourceSet.getResource(workflow_uri, true);
			workflowRootObject = (Workflow) resource.getContents()
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
			} else if (currentWorkflowElement instanceof ErrorState)
			  return "errorstate";
		}
		return null;
	}

	/**
	 * @see WorkflowPilot#getAnalysisName()
	 */
  public String getAnalysisName()
  {
    if(currentWorkflowElement instanceof Analysis)
    {
      return ((Analysis) currentWorkflowElement).getMethod() ;
    }
    else
    {
      String msg = "You cannot ask for an analysis name if the current state is not an analysis." ;
      _LOGGER.error(msg);
      return null ;
    }
  }

	/**
	 * @see WorkflowPilot#getAnalysisMode()
	 */
	public String getAnalysisMode()
	{
    if(currentWorkflowElement instanceof Analysis)
    {
      return ((Analysis) currentWorkflowElement).getMode() ;
    }
    else
    {
      String msg = "You cannot ask for an analysis mode if the current state is not an analysis." ; 
      _LOGGER.error(msg);
      return null ;
    }
	}

	/**
	 * @see WorkflowPilot#getTransformationFileNameList()
	 */
  public List<String> getTransformationFileNameList()
  {
    if(currentWorkflowElement instanceof Transformation)
    {
      fr.tpt.aadl.ramses.control.workflow.List list =
                           ((Transformation) currentWorkflowElement).getList() ;

      List<fr.tpt.aadl.ramses.control.workflow.File> listFileTags =
                                                                list.getFile() ;
      Iterator<fr.tpt.aadl.ramses.control.workflow.File> listFileTagsIt =
                                                       listFileTags.iterator() ;

      List<String> listFileNames = new ArrayList<String>() ;

      while(listFileTagsIt.hasNext())
      {
        listFileNames.add(listFileTagsIt.next().getPath()) ;
      }

      return listFileNames ;
    }
    else
    {
      String msg = "You cannot ask for an asm file if the current state is not a transformation." ;
      _LOGGER.error(msg);
      return null ;
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
	  previousWorkflowElement = currentWorkflowElement;
		if (currentWorkflowElement instanceof Analysis) {
			
			if (analysisResult) {
				currentWorkflowElement = ((Analysis) currentWorkflowElement).getYesOption().getElement();
			} else {
				currentWorkflowElement = ((Analysis) currentWorkflowElement).getNoOption().getElement();
			}
			
		} else if (currentWorkflowElement instanceof Loop) {
		  
		  Loop l = (Loop) currentWorkflowElement;
		  if(l.getFoundOption()==null
		      || l.getNotFoundOption()==null)
		  {
		    String message = "No options found to continue workflow after the loop";
		    _LOGGER.error(message);
		    ServiceProvider.SYS_ERR_REP.error(message, true);
		    currentWorkflowElement = null;
		  }
		  else if (analysisResult) {
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
		if (currentWorkflowElement instanceof Generation) {
		  Generation g = (Generation) currentWorkflowElement;
      result = g.getInputModelIdentifier().getId();
    }
		if(previousWorkflowElement instanceof Loop)
    {
      result += loopModelIdSuffix;
    }
		return result;
	}
	
	public void setLoopModelIdSuffix(String suffix)
	{
	  loopModelIdSuffix = suffix ;
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
      String inputModelIdentifier = l.getInputModelIdentifier().getId();
      String outputModelIdentifier = l.getOutputModelIdentifier().getId();
      
      /** Convert analysis */
      AbstractLoop.AbstractAnalysis aa = convertAnalysis(l.getAnalysis());
      return new AbstractLoop(aa,l.getAlternatives(),
                                 inputModelIdentifier,outputModelIdentifier,
                                 l.getResolutionMethod(),
                                 l.getMaxNbIteration()); 
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

  @Override
  public String getTransformationName() {
    if(currentWorkflowElement instanceof Transformation)
    {
      return ((Transformation) currentWorkflowElement).getIdentifier() ;
    }
    else
    {
      String msg = "You cannot ask for a transformation name if the current state is not a transformation." ;
      _LOGGER.error(msg);
      return null ;
    }
  }

  @Override
  public Workflow getWokflowRoot()
  {
    return workflowRootObject;
  }

}