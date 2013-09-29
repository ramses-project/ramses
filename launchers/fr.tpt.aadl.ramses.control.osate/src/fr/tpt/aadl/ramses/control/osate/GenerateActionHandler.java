package fr.tpt.aadl.ramses.control.osate;

import java.io.File;
import java.net.URL;
import java.util.Iterator;

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

import fr.tpt.aadl.ramses.control.support.EcorePilot;
import fr.tpt.aadl.ramses.control.support.generator.Generator;
import fr.tpt.aadl.ramses.control.support.services.OSGiServiceRegistry;
import fr.tpt.aadl.ramses.control.support.services.ServiceRegistry;
import fr.tpt.aadl.ramses.transformation.atl.hooks.impl.HookAccessImpl;

public abstract class GenerateActionHandler extends AbstractHandler {

	@Inject
	private EObjectAtOffsetHelper eObjectAtOffsetHelper;


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

	void doCodeGeneration()
	{
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
