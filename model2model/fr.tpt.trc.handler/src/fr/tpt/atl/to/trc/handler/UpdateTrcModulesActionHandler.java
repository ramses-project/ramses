package fr.tpt.atl.to.trc.handler;

import java.io.File;
import java.util.Stack;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.utils.Aadl2Utils;

import fr.tpt.aadl.ramses.control.support.utils.Names;
import fr.tpt.aadl.ramses.transformation.trc.xtext.TRCStandaloneSetup;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.Transformation;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TransformationDependency;
import fr.tpt.aadl.ramses.transformation.trc.xtext.tRC.TrcSpecification;
import fr.tpt.atl.to.trc.launcher.Atl2TrcLauncher;


public class UpdateTrcModulesActionHandler extends AbstractHandler {

  protected static boolean _isOutline = false;
  protected IProject _currentProject = null ;

  int cpt =0;

  protected ExecutionEvent _event = null ;
  private static final String COMMAND_ID = "fr.tpt.atl.to.trc.handler.trc.update";
  protected static String _JOB_NAME;
  private static Logger _LOGGER = Logger.getLogger(UpdateTrcModulesActionHandler.class) ;
	
  // Call init method to setup these attributes.
		
  @Override
  public Object execute(ExecutionEvent event) throws ExecutionException 
  {
    try 
    {
	  init(event, COMMAND_ID);
	} 
    catch (Exception e) 
	{
	  _LOGGER.error("Error in update of TRC Modules");
	}
	  return event;
  }
  	
  protected void init(ExecutionEvent event, String Command)
    throws Exception
  {
    _event = event;
	ISelection s = HandlerUtil.getCurrentSelection(event) ;
	IFile node = (IFile) ((IStructuredSelection) s).getFirstElement() ;		
	_currentProject = node.getProject() ;
	Resource resource = OsateResourceUtil.getResource((IResource) node) ;
	
   	String atlDirPath = Aadl2Utils.getAbsolutePluginPath(Names.ATL_TRANSFORMATION_PLUGIN_ID).toString();
   	_LOGGER.info("OSATE project is \'" + _currentProject.getName() + '\'');
   	   	
	
	String[] AtlInputs = getFilesDirectory(atlDirPath);	
	for (int i=0; i<AtlInputs.length;i++)
	   	_LOGGER.info("Atl files is \'" + AtlInputs[i] + '\'');
	
	//create hot launcher object
	Atl2TrcLauncher hotLauncher = new Atl2TrcLauncher("Atl2Trc4Rule", resource.getResourceSet());
	String outputPath=_currentProject.getFullPath().toOSString()+"/out_tmp.xmi";
	hotLauncher.launchHot(AtlInputs, outputPath);
	
	Resource r = resource.getResourceSet().getResource(URI.createURI(outputPath), true);
	Resource res2 = resource.getResourceSet().createResource(URI.createURI(_currentProject.getFullPath().toOSString()+"/dslExample.trcDsl"));

	TrcSpecification newSpec = (TrcSpecification) r.getContents().get(0);
	TrcSpecification oldSpec = (TrcSpecification) resource.getContents().get(0);
			
	oldSpec.getModuleList().clear();
	
    oldSpec.getModuleList().addAll(newSpec.getModuleList());
	oldSpec.getTransformationList().get(0).getTransformations().get(0).getModules().clear();	

	for (Transformation t : oldSpec.getTransformationList().get(0).getTransformations())
	{
		t.getModules().addAll(oldSpec.getModuleList().get(0).getModules());
	}
	
	oldSpec.getTransformationList().get(0).getTransformations().get(0).getModules().clear();
	oldSpec.getDependencyList().get(0).getTransformationDependencies().get(0).getAppliedTransformation().getModules().clear();
	for (TransformationDependency td : oldSpec.getDependencyList().get(0).getTransformationDependencies())
	{
		td.getAppliedTransformation().getModules().addAll(oldSpec.getModuleList().get(0).getModules());
	}

//	resource.getContents().add(oldSpec);

	res2.getContents().add(oldSpec);

//	r.delete(null);		
	
	new TRCStandaloneSetup().createInjectorAndDoEMFRegistration();
		
//	resource.save(null);

    res2.save(null);
	
  }

  private String[] getFilesDirectory(String path) 
  {
    Stack<File> stack = new Stack<File>();
    Stack<String> AtlF = new Stack<String>();
	stack.push(new File(path));
	while(!stack.isEmpty()) 
	{ 
	  File pathOfCurrrentFileOrDir = stack.pop();
	  if (pathOfCurrrentFileOrDir.isDirectory()) 
	  {	
	    for(File f : pathOfCurrrentFileOrDir.listFiles())
		  stack.push(f);		  
	  }
	  else if (pathOfCurrrentFileOrDir.isFile()) 
	  {
	    if(pathOfCurrrentFileOrDir.getName().endsWith("atl"))
	      AtlF.push(pathOfCurrrentFileOrDir.getPath());
	  }
	}
	String AtlFiles[] = new String[AtlF.size()];
	int nbfiles = 0;
	while(!AtlF.isEmpty())
	{
	  AtlFiles[nbfiles] = AtlF.pop();
	  nbfiles++;
	}
    return AtlFiles;
  }
  

}
