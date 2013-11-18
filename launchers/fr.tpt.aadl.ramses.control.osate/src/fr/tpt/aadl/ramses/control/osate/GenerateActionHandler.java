package fr.tpt.aadl.ramses.control.osate;

import java.io.File;
import java.net.URL;
import java.util.Iterator;
import org.eclipse.jface.dialogs.DialogPage;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.emf.common.command.Command;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.RollbackException;
import org.eclipse.emf.transaction.TransactionalCommandStack;
import org.eclipse.emf.transaction.TransactionalEditingDomain;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Rectangle;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.MessageBox;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchPart;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.PlatformUI;
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
import fr.tpt.aadl.ramses.control.support.generator.Generator;
import fr.tpt.aadl.ramses.control.support.services.OSGiServiceRegistry;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry;
import fr.tpt.aadl.ramses.transformation.atl.hooks.impl.HookAccessImpl;

public abstract class GenerateActionHandler extends AbstractHandler {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;

	private static int TEXT_FIELD_WIDTH = 43;

	protected static final InternalErrorReporter internalErrorLogger = new LogInternalErrorReporter(OsateCorePlugin
			.getDefault().getBundle());


	protected String _targetName=getTargetName();

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
//	@SuppressWarnings("unused")
//	private class CodeGenerationOperation extends Thread
//	{
//		private Display display;
//
//		private ProgressBar progressBar;
//
//		public CodeGenerationOperation(Display display, ProgressBar progressBar) {
//			this.display = display;
//			this.progressBar = progressBar;
//		}
//
//		public void run() {
//			for (int i = 0; i < 30; i++) {
//				try {
//					System.out.println("Thread is running...");	
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//				}
//				display.asyncExec(new Runnable() {
//					public void run() {
//						if (progressBar.isDisposed())
//							return;
//						progressBar.setSelection(progressBar.getSelection() + 1);
//					}
//				});
//			}
//		}
//	}
	
//	private class doShellProgress extends DialogPage
//	{
//
//		@Override
//		public void createControl(Composite parent) {
//			// TODO Auto-generated method stub
//			
//		}
//		
//	}
//	@SuppressWarnings("unused")
//	protected class myThread  extends DialogPage implements Runnable 
//	{
//
//		@Override
//		public void createControl(Composite parent) {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void run() {
//			// TODO Auto-generated method stub
//			ProgressBar progressbar = new ProgressBar(getShell(), SWT.SMOOTH);
//			progressbar.setMinimum(1);
//			progressbar.setMaximum(100);
//			progressbar.setVisible(true);
//		}
//		
//	}
	void doCodeGeneration()
	{
//		boolean isclosed = false;
//		final Display dsp = Display.getCurrent();
//		final Shell shl = dsp.getActiveShell();
//		final ProgressBar progressbar = new ProgressBar(shl, SWT.HORIZONTAL|SWT.SMOOTH);
//		progressbar.setMinimum(1);
//		progressbar.setMaximum(200);
//		final long start = System.currentTimeMillis();
//		Thread thd = new Thread(){
//			public void run()
//			{
//				
//				while (System.currentTimeMillis() < (start+(1000*5)))
//				{
//					System.out.println("The thread is running ...");
//					shl.open();
//					try {
//						Thread.sleep(2000);
//						
//						
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//				
//			}
//		};
//		
//		thd.start();
		
//		final Display dsp = Display.getCurrent();
//		final Shell shl = new Shell(dsp.getActiveShell(), SWT.BORDER);
//		shl.setText("My Progressbar");
//		final ProgressBar progressbar = new ProgressBar(shl, SWT.HORIZONTAL|SWT.SMOOTH);
//		progressbar.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		progressbar.setMinimum(0);
//		progressbar.setMaximum(30);
//		final long start = System.currentTimeMillis();
//		
//		shl.open();
//		final Display dsp = Display.getCurrent();
//		final Shell shl = dsp.getActiveShell();
//		shl.setLayout(new GridLayout());
//
//		// Create a smooth ProgressBar
//		final ProgressBar progressbar = new ProgressBar(shl, SWT.HORIZONTAL | SWT.SMOOTH);
//		progressbar.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
//		progressbar.setMinimum(0);
//		progressbar.setMaximum(30);
//		
//		new CodeGenerationOperation(dsp, progressbar).start();
//
//		shl.open();
//		while (!shl.isDisposed()) {
//			if (!dsp.readAndDispatch()) {
//				dsp.sleep();
//			}
//		}
		
//		Thread thd = new Thread()
//		{
//			public void run() 
//			{
//				for(int i = 0; i < 30; i++)
//				{
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//					dsp.asyncExec(new Runnable() {
//						
//						@Override
//						public void run() {
//							// TODO Auto-generated method stub
//							if(progressbar.isDisposed())
//								return;
//							progressbar.setSelection(progressbar.getSelection() + 1);
//						}
//					});
//				}
//			}
//		};
//		thd.start();
//		shl.open();
//		while (System.currentTimeMillis() < (start+(1000*5)))
//		{
//			System.out.println("The thread is running ...");
//			if(progressbar.isDisposed())
//				return;
//			progressbar.setSelection(progressbar.getSelection()+1);
//			progressbar.redraw();
//		}
		
		Display display = Display.getCurrent();
		Shell shell = new Shell(display, SWT.BORDER);


		MessageBox messageBox = new MessageBox(shell, SWT.ICON_QUESTION |SWT.YES | SWT.NO);
		messageBox.setMessage("You have to chose Path for the target Platform before generating Code");
		int rc = messageBox.open();
		
		if(rc == SWT.YES)
		{
			//Open another windows to set the path
			System.out.println("RC is Yes");
			shell.close();
			Shell shl = new Shell(display, SWT.BORDER);
			RememberPath rmPath = new RememberPath(shl);
			rmPath.open();
			//TO BE COMPLETED
		}
		else
		{
			//There is nothing to do for the moment
			System.out.println("RC is NO");
			//TO BE COMPLETED
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

													URI resourceURI = URI.createPlatformPluginURI("fr.tpt.aadl.ramses.transformation.atl", false);
													java.net.URI uri = new java.net.URI(resourceURI.toString());
													URL url = FileLocator.toFileURL(uri.toURL());

													File resourceDir = new File(url.toURI()); 

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
