package fr.tpt.atl.to.trc.handler;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.m2m.atl.emftvm.Model;
import org.eclipse.m2m.atl.emftvm.Rule;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.xtext.resource.IContainer;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.serializer.impl.Serializer;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.utils.Aadl2Utils;

import fr.tpt.aadl.ramses.control.support.utils.Names;
import org.trc.xtext.dsl.dsl.Transformation;

import fr.tpt.atl.to.trc.launcher.Atl2TrcLauncher;

import org.trc.xtext.dsl.DslRuntimeModule;
import org.trc.xtext.dsl.DslStandaloneSetup;
import org.trc.xtext.dsl.dsl.Module;
import org.trc.xtext.dsl.dsl.ModuleList;
import org.trc.xtext.dsl.dsl.TransformationList;
import org.trc.xtext.dsl.dsl.TrcSpecification;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;


public class UpdateTrcModulesActionHandler extends AbstractHandler {

  protected static boolean _isOutline = false;
  protected IProject _currentProject = null ;

  int cpt =0;
  private static Serializer SERIALIZER = null;  

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
  

  @Inject
  private Injector injector;
	
  protected void init(ExecutionEvent event, String Command)
    throws Exception
  {
    String trcFile;
//    List<Module> moduleList = new ArrayList<Module>();
//    List<String> alreadyAdded = new ArrayList<String>();
    _event = event;
	ISelection s = HandlerUtil.getCurrentSelection(event) ;
	IFile node = (IFile) ((IStructuredSelection) s).getFirstElement() ;		
	_currentProject = node.getProject() ;
	Resource resource = OsateResourceUtil.getResource((IResource) node) ;
	
   	String atlDirPath = Aadl2Utils.getAbsolutePluginPath(Names.ATL_TRANSFORMATION_PLUGIN_ID).toString();
   	_LOGGER.info("OSATE project is \'" + _currentProject.getName() + '\'');
   	   	
	//create hot launcher object
	String[] AtlInputs = getFilesDirectory(atlDirPath);
	

//	for (int i=0; i<AtlInputs.length;i++)
//	   	_LOGGER.info("Atl files is \'" + AtlInputs[i] + '\'');
	
	Atl2TrcLauncher hotLauncher = new Atl2TrcLauncher("Atl2Trc4Rule", resource.getResourceSet());
	String outputPath=_currentProject.getFullPath().toOSString()+"/out_tmp.xmi";
	
	hotLauncher.launchHot(AtlInputs, outputPath);
	
	Resource r = resource.getResourceSet().getResource(URI.createURI(outputPath), true);

	TrcSpecification newSpec = (TrcSpecification) r.getContents().get(0);
	TrcSpecification oldSpec = (TrcSpecification) resource.getContents().get(0);
			
	oldSpec.getModuleList().clear();

	Resource res2 = resource.getResourceSet().createResource(URI.createURI(_currentProject.getFullPath().toOSString()+"/dslExample.trcDsl"));
	System.out.println("uri : "+res2.getURI().toString());
	res2.getContents().add(newSpec);

	for(Module m: newSpec.getModuleList().get(0).getModules())
	{
		Module newM = org.trc.xtext.dsl.dsl.DslFactory.eINSTANCE.createModule();
		newM.setName(m.getName());		
		res2.getContents().add(newM);
	}
	
	for(Transformation t: oldSpec.getTransformationList().get(0).getTransformations())
	{
		Transformation newT = org.trc.xtext.dsl.dsl.DslFactory.eINSTANCE.createTransformation();
		newT.setName(t.getName());
		System.out.println("valeur de newsT"+newT.getName());
		res2.getContents().add(newT);

	}

	r.delete(null);		
	
	new DslStandaloneSetup().createInjectorAndDoEMFRegistration();
		
	res2.save(null);
	
  }

//  private static Serializer getSerializer() {  
//	  if (SERIALIZER == null) {
//	   SERIALIZER = Guice.createInjector(new DslRuntimeModule())  
//	        .getInstance(Serializer.class);  
//	  }  
//	  return SERIALIZER;
//	 } 
//  
//  public static String valueOf(EObject eobj) {  
//	  if (eobj==null) {  
//	   return "null";  
//	  }  
//	  try {  
//	   return getSerializer().serialize(eobj);  
//	  } catch (Exception ex) { // fall back: 
//	   return eobj.getClass().getSimpleName()+'@'+eobj.hashCode();  
//	  }  
//	 }  

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
  


	@Override
	public boolean isEnabled() {
		return true;
	}

}
