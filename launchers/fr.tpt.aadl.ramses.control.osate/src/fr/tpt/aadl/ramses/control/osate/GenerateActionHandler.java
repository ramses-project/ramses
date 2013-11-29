package fr.tpt.aadl.ramses.control.osate;

import java.io.File;
import java.net.URL;
import java.util.Iterator;
import java.util.Set ;

import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.jface.dialogs.IMessageProvider ;
import org.eclipse.jface.dialogs.TitleAreaDialog ;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile ;
import org.eclipse.core.resources.IProject ;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.IAdaptable ;
import org.eclipse.core.runtime.IConfigurationElement ;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Platform ;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.preference.PreferenceDialog ;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.window.Window;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.SelectionAdapter ;
import org.eclipse.swt.events.SelectionEvent ;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Control ;
import org.eclipse.swt.widgets.DirectoryDialog ;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label ;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IFileEditorInput ;
import org.eclipse.ui.ISelectionService ;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.dialogs.PreferencesUtil ;
import org.eclipse.ui.internal.Workbench ;
import org.eclipse.ui.views.contentoutline.ContentOutline;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.osate.aadl2.ComponentImplementation;
import org.osate.aadl2.Element;
import org.osate.aadl2.SystemImplementation;
import org.osate.aadl2.instance.SystemInstance;
import org.osate.aadl2.instantiation.InstantiateModel;
import org.osate.aadl2.modelsupport.errorreporting.InternalErrorReporter;
import org.osate.aadl2.modelsupport.errorreporting.LogInternalErrorReporter;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil;
import org.osate.core.OsateCorePlugin;
import org.osate.ui.dialogs.Dialog;
import org.osate.ui.navigator.AadlNavigator;

import com.google.inject.Inject;

import fr.tpt.aadl.ramses.control.osate.properties.RamsesPropertyPage;
import fr.tpt.aadl.ramses.control.support.EcorePilot;
import fr.tpt.aadl.ramses.control.support.RamsesConfiguration;
import fr.tpt.aadl.ramses.control.support.generator.Generator;
import fr.tpt.aadl.ramses.control.support.services.OSGiServiceRegistry;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry;
import fr.tpt.aadl.ramses.transformation.atl.hooks.impl.HookAccessImpl;

public abstract class GenerateActionHandler extends AbstractHandler {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;
	private Set<File> _includeDirSet = null;
	private static int TEXT_FIELD_WIDTH = 43;
	private static CustomDialog customdiag;
	private static final String extension = "org.eclipse.ui.propertyPages";
	protected static final InternalErrorReporter 
	                                           internalErrorLogger = 
	                                           new LogInternalErrorReporter
	                                           (OsateCorePlugin
	                                           .getDefault().getBundle());
  private static IProject currentProject;

  protected String _targetName=getTargetName();
  private static  enum code
  {
    YES,
    NO;
  }

	abstract String getTargetName();

	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {

	  
		final TransactionalEditingDomain domain = TransactionalEditingDomain.Registry.INSTANCE
				.getEditingDomain("org.osate.aadl2.ModelEditingDomain");
		// We execute this command on the command stack because otherwise, we will not
		//  have write permissions on the editing domain.
		Command cmd = new RecordingCommand(domain) {

			protected void doExecute() {
				doCodeGeneration();
			}
		};
		
		try {
			((TransactionalCommandStack) domain.getCommandStack()).execute(cmd, null);
			return null;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			HookAccessImpl.cleanupTransformationTrace();
		}
		return null;
	}
  
	private class CustomDialog extends TitleAreaDialog
	{
	  private Label    label;
	  private Text     outputPathText;
	  private String   _outputTargetPath;
	  private Button  yesButton;
	  private Button   noButton;
	  private String   code;

    public String getCode()
    {
      return code ;
    }

    public void setCode(String code)
    {
      this.code = code ;
    }

    public CustomDialog(
                        Shell parentShell, String path)
    {
      super(parentShell) ;
      _outputTargetPath = path;      
    }
	  
    @Override
    public void create() {
      super.create();
      setTitle("Do you want to change the default path ?");
      //setMessage("This is the target path, do you want to change it ?", IMessageProvider.INFORMATION);
    }

    @Override
    protected Control createDialogArea(Composite parent) {
      Composite area = (Composite) super.createDialogArea(parent);
      Composite container = new Composite(area, SWT.NONE);
      container.setLayoutData(new GridData(GridData.FILL_BOTH));
      GridLayout layout = new GridLayout(1, false);
      container.setLayoutData(new GridData(SWT.FILL, SWT.FILL, true, true));
      container.setLayout(layout);

      createWidgets(container);
      return area;
    }
    
    @Override
    protected void createButtonsForButtonBar(Composite parent)
    {
      yesButton = createButton(parent, SWT.YES, "Yes", false);
      yesButton.setEnabled(true);
//      yesButton.setLayoutData(new GridData(SWT.LEFT, SWT.CENTER, true, true, 1, 1));;
      
      yesButton.addSelectionListener(new SelectionAdapter()
      {
        public void widgetSelected(SelectionEvent e)
        {
          close();
          setCode("YES");
        }
      });
    
      noButton = createButton(parent, SWT.NO, "No", true);
      noButton.setEnabled(true);
//      noButton.setLayoutData(new GridData(SWT.RIGHT, SWT.CENTER, true, true, 1, 1));
      
      noButton.addSelectionListener(new SelectionAdapter()
      {
        public void widgetSelected(SelectionEvent e)
        {
          close();
          setCode("NO");
        }
      });   
    }
    
    private void createWidgets(Composite container) {
            
      GridData dataOutputPath = new GridData(SWT.CENTER, SWT.CENTER, true, true);      
      outputPathText = new Text(container, SWT.BORDER);
      outputPathText.setLayoutData(dataOutputPath);
      outputPathText.setEditable(false);
      if(_outputTargetPath != null)
        outputPathText.setText(_outputTargetPath);
    }

	}
	
	public void CreateCustomDialog(Shell sh, String path)
	{
	  customdiag = new CustomDialog(sh, path);
	}

	void doCodeGeneration()
	{		
	  Display display = Display.getCurrent();
	  Shell shell = new Shell(display, SWT.BORDER);

	  if((RamsesConfiguration.getRuntimeDir() == null) 
	        || (RamsesConfiguration.getRuntimeDir().equals(""))
	        || (RamsesConfiguration.getOutputDir() == null))
	  {
	    //Instanciate the propertyPage
	    
	    if((currentProject = RamsesConfiguration.getCurrentProject()) == null)
	    {
	      Dialog.showError("Code Generation Error",
	            "No editor displayed ");
	    }

	    PreferenceDialog prefDiag = PreferencesUtil.
	          createPropertyDialogOn(shell, currentProject,
	                                 "fr.tpt.aadl.ramses.control.osate.properties.RamsesPropertyPage",
	                                 null, null);
	    if(prefDiag.open() == Window.CANCEL)
	    {
	      return;
	    }
	  }
		
		IWorkbench wb = PlatformUI.getWorkbench();
		IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
		IWorkbenchPage page = win.getActivePage();
		IWorkbenchPart part = page.getActivePart();
		final ISelection selection;
		IEditorPart activeEditor = page.getActiveEditor();
		if (activeEditor != null){
			XtextEditor xtextEditor = (activeEditor == null)?null:(XtextEditor) activeEditor.getAdapter(XtextEditor.class);
			if (part instanceof ContentOutline) {
				selection = ((ContentOutline) part).getSelection();
			} else {
				selection = (ITextSelection) xtextEditor.getSelectionProvider().getSelection();
			}
			if (xtextEditor != null) {
				// make sure the model has been saved
				if (xtextEditor.isDirty())
					xtextEditor.doSave(new NullProgressMonitor());

				xtextEditor.getDocument().readOnly(
						new IUnitOfWork<EObject, XtextResource>() {
							public EObject exec(XtextResource resource) throws Exception {
								EObject targetElement = null;
								if (selection instanceof IStructuredSelection) {
									IStructuredSelection ss = (IStructuredSelection) selection;
									Object eon = ss.getFirstElement();
									if (eon instanceof EObjectNode) {
										targetElement = ((EObjectNode)eon).getEObject(resource);
									}
								} else {
									targetElement = eObjectAtOffsetHelper.resolveContainedElementAt(resource,
											((ITextSelection)selection).getOffset());
								}

								if (targetElement != null) {
									if (targetElement instanceof Element){
										ComponentImplementation cc = ((Element) targetElement).getContainingComponentImpl();
										if (cc instanceof SystemImplementation){
											SystemImplementation si = (SystemImplementation)cc;
											try
											{
												SystemInstance sinst=null;
												URI instanceURI = OsateResourceUtil.getInstanceModelURI(si);
												Resource sintResource = OsateResourceUtil.getResourceSet().getResource(instanceURI, false);
												if(sintResource!=null)
												{
													sinst = (SystemInstance) sintResource.getContents().get(0);
												}	
												else
													sinst = InstantiateModel.buildInstanceModelFile(si);
												if (sinst == null)
												{
													String message;
													message = "Error when instantiating the model";
													if (InstantiateModel.getErrorMessage() != null)
													{
														message = message + " - reason: " + InstantiateModel.getErrorMessage() + "\nRefer to the help content and FAQ for more information";
													}
													Dialog.showError("Model Instantiate", message);
												}
												else
												{	
													ServiceRegistry registry;
													registry = new OSGiServiceRegistry ();
													Generator generator = registry.getGenerator(_targetName) ;
													IWorkspaceRoot workspaceRoot = ResourcesPlugin.getWorkspace().getRoot();
													String workspaceURI = si.eResource().getURI().trimFragment().toString();
													workspaceURI = workspaceURI.substring(0, workspaceURI.lastIndexOf("/"));
													java.net.URI modelURI = new java.net.URI(workspaceURI);
													URL modelURL = FileLocator.toFileURL(modelURI.toURL());
													File outputDir = new File(modelURL.toURI()); 
													RamsesConfiguration.setOutputDir(outputDir);

													URI resourceURI = URI.createPlatformPluginURI("fr.tpt.aadl.ramses.transformation.atl", false);
													java.net.URI uri = new java.net.URI(resourceURI.toString());
													URL url = FileLocator.toFileURL(uri.toURL());

													File resourceDir = new File(url.toURI()); 
													RamsesConfiguration.setRamsesResourcesDir(resourceDir);
													RamsesConfiguration.setIncludeDir(sinst.getSystemImplementation().eResource(), _includeDirSet, _targetName);
													// look for a wokflow file
													Resource r = si.eResource();
													String s = r.getURI().segment(1);
													File rootDir = new File(workspaceRoot.getProject(s).getLocationURI());
													String workflow = GenerateActionUtils.findWorkflow(rootDir);
													
													if(workflow==null)
														generator.generate(sinst, 
																resourceDir,
																outputDir) ;
													else
													{
														EcorePilot xmlPilot = new EcorePilot(workflow);
														generator.generateWorkflow(sinst,
																resourceDir,
																outputDir,
																xmlPilot);

													}
												}
												ResourcesPlugin.getWorkspace().getRoot().
												refreshLocal(IResource.DEPTH_INFINITE, new NullProgressMonitor());

											}
											catch (UnsupportedOperationException uoe)
											{
												Dialog.showError("Code Generation", "Operation is not supported: " + uoe.getMessage());
											}
											catch (Exception other)
											{
												other.printStackTrace();
												Dialog.showError("Code Generation", "Error when generating code");
											}

										} 
										else 
										{
											Dialog.showInfo("Model Instantiation","Must select a system implementation. Selected " + targetElement.eClass().getName()+" "+targetElement.toString());
										}
									} else {
										Dialog.showInfo("Model Instantiation","Please select an AADL model element. You selected " + targetElement.eClass().getName()+" "+ targetElement.toString());
									}
									return null;
								}
								return null;
							}
						});
			}
		}
	}
 
}
