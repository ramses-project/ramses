package fr.tpt.aadl.ramses.control.osate;

import org.apache.log4j.Logger ;
import org.eclipse.core.commands.AbstractHandler ;
import org.eclipse.core.commands.ExecutionEvent ;
import org.eclipse.core.resources.IFile ;
import org.eclipse.core.resources.IProject ;
import org.eclipse.core.resources.IResource ;
import org.eclipse.core.runtime.IProgressMonitor ;
import org.eclipse.core.runtime.IStatus ;
import org.eclipse.core.runtime.NullProgressMonitor ;
import org.eclipse.core.runtime.OperationCanceledException ;
import org.eclipse.core.runtime.Status ;
import org.eclipse.core.runtime.jobs.Job ;
import org.eclipse.emf.ecore.EObject ;
import org.eclipse.emf.ecore.resource.Resource ;
import org.eclipse.emf.transaction.TransactionalCommandStack ;
import org.eclipse.emf.transaction.TransactionalEditingDomain ;
import org.eclipse.jface.text.ITextSelection ;
import org.eclipse.jface.viewers.ISelection ;
import org.eclipse.jface.viewers.IStructuredSelection ;
import org.eclipse.m2m.atl.emftvm.util.VMException ;
import org.eclipse.ui.IEditorPart ;
import org.eclipse.ui.IWorkbench ;
import org.eclipse.ui.IWorkbenchPage ;
import org.eclipse.ui.IWorkbenchPart ;
import org.eclipse.ui.IWorkbenchWindow ;
import org.eclipse.ui.PlatformUI ;
import org.eclipse.ui.handlers.HandlerUtil ;
import org.eclipse.ui.views.contentoutline.ContentOutline ;
import org.eclipse.xtext.resource.EObjectAtOffsetHelper ;
import org.eclipse.xtext.resource.XtextResource ;
import org.eclipse.xtext.ui.editor.XtextEditor ;
import org.eclipse.xtext.ui.editor.outline.impl.EObjectNode ;
import org.eclipse.xtext.util.concurrent.IUnitOfWork ;
import org.osate.aadl2.ComponentImplementation ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.instance.SystemInstance ;
import org.osate.aadl2.instantiation.InstantiateModel ;
import org.osate.aadl2.modelsupport.resources.OsateResourceUtil ;
import org.osate.ui.dialogs.Dialog ;

import com.google.inject.Inject ;

import fr.tpt.aadl.ramses.control.atl.hooks.impl.HookAccessImpl ;
import fr.tpt.aadl.ramses.control.support.config.ConfigurationException ;
import fr.tpt.aadl.ramses.control.support.utils.Names ;

public abstract class RamsesActionHandler extends AbstractHandler {

	protected static boolean _isOutline = false;
	protected IProject _currentProject = null ;
	protected ExecutionEvent _event = null ;

	protected static String _JOB_NAME;
	
	private static final String _OK_STATUS = "OK" ;
	private static final String _CANCEL_STATUS = "CANCEL" ;
	private static final String _ABORT_STATUS = "FATAL" ;
	  
	private static Logger _LOGGER = Logger.getLogger(RamsesActionHandler.class) ;
	
	// Call init method to setup these attributes.
	protected SystemInstance _sysInst = null ;
	
	protected abstract void jobCore(IProgressMonitor monitor) throws Exception;
	
	protected void init(ExecutionEvent event, String Command)
			throws ConfigurationException
	{
		_event = event;
		_isOutline  = Command.equals(event.getCommand().getId()) ;
	    if(_isOutline)
	    {
	      _currentProject = WorkbenchUtils.getProjectByActiveEditor() ;
	      setOutlineSelectedSystem(event) ;
	      _LOGGER.info("OSATE project is \'" + _currentProject.getName() + '\'');
	      _LOGGER.info("system implementation to generate (outline action) is \'" + _sysInst.getFullName() + '\'');
	    }
	    else
	    {
	      ISelection s = HandlerUtil.getCurrentSelection(event) ;
	      IFile node = (IFile) ((IStructuredSelection) s).getFirstElement() ;
	      _currentProject = node.getProject() ;
	      Resource resource = OsateResourceUtil.getResource((IResource) node) ;
	      // Fetch system implementation model.
	      _sysInst = (SystemInstance) resource.getContents().get(0) ;
	      _LOGGER.info("OSATE project is \'" + _currentProject.getName() + '\'');
	      _LOGGER.info("system implementation to generate (button action) is \'" + _sysInst.getFullName() + '\'');
	    }
	}
	
	@Inject
  private EObjectAtOffsetHelper eObjectAtOffsetHelper;
	
	private void setOutlineSelectedSystem(ExecutionEvent event)
            throws ConfigurationException
    {
	  
	  IWorkbench wb = PlatformUI.getWorkbench();
    IWorkbenchWindow win = wb.getActiveWorkbenchWindow();
    IWorkbenchPage page = win.getActivePage();
    IWorkbenchPart part = page.getActivePart();
    final ISelection selection;
    IEditorPart activeEditor = page.getActiveEditor();
    XtextEditor xtextEditor = (activeEditor == null) ? null : (XtextEditor) activeEditor
                                                     .getAdapter(XtextEditor.class);
    if (part instanceof ContentOutline) {
      selection = ((ContentOutline) part).getSelection();
    } else {
      selection = xtextEditor.getSelectionProvider().getSelection();
    }
    if (xtextEditor != null) {
      // make sure the model has been saved
      if (xtextEditor.isDirty()) {
        xtextEditor.doSave(new NullProgressMonitor());
      }
      
      xtextEditor.getDocument().readOnly(new IUnitOfWork<EObject, XtextResource>() {
        @Override
        public EObject exec(XtextResource resource) throws Exception {
          EObject targetElement = null;
          if (selection instanceof IStructuredSelection) {
            IStructuredSelection ss = (IStructuredSelection) selection;
            Object eon = ss.getFirstElement();
            if (eon instanceof EObjectNode) {
              targetElement = ((EObjectNode) eon).getEObject(resource);
            }
          } else {
            targetElement = eObjectAtOffsetHelper.resolveContainedElementAt(resource,
                                                                            ((ITextSelection) selection).getOffset());
          }

          if (targetElement != null) {
              ComponentImplementation cc = ((Element) targetElement).getContainingComponentImpl();
                try {
                  _sysInst = InstantiateModel.buildInstanceModelFile(cc);
                } catch (UnsupportedOperationException uoe) {
                  Dialog.showError("Model Instantiate",
                                   "Operation is not supported: " + uoe.getMessage());
                } catch (Exception other) {
                  other.printStackTrace();
                  Dialog.showError("Model Instantiate", "Error when instantiating the model");
                }
              }
            return null;
        }
      });
    }
//	  SystemImplementation result = null ;
//
//      try
//      {
//        ISelection s = HandlerUtil.getCurrentSelection(event) ;
//        OsateResourceUtil.refreshResourceSet();
//        EObjectNode node = (EObjectNode)((IStructuredSelection) s).getFirstElement() ;
//        Resource resource = OsateResourceUtil.getResource(node.getEObjectURI()) ;
//        PropertiesLinkingService pls = new PropertiesLinkingService() ;
//        if(resource.getContents().get(0) instanceof AadlPackage)
//        {
//          String systemName = node.getText().toString();
//          systemName = systemName.substring(systemName.lastIndexOf(' ')+1, systemName.length());
//          result =
//                (SystemImplementation) pls
//                      .findNamedElementInsideAadlPackage(systemName,
//                                                         ((AadlPackage) resource
//                                                               .getContents()
//                                                               .get(0))
//                                                               .getOwnedPublicSection()) ;
//        }
//      }
//      catch (Exception e)
//      {
//        String message;
//        message = "Not enable to fetch the selected system implementation node";
//        if (InstantiateModel.getErrorMessage() != null)
//        {
//    	  message = message + " - reason: " + InstantiateModel.getErrorMessage() +
//    			  "\nRefer to the help content and FAQ for more information";
//        }
//
//        ConfigStatus.NOT_VALID.msg = message ;
//        throw new ConfigurationException(ConfigStatus.NOT_VALID) ;
//      }
//
//      return result ;
    }
	
	  protected void doAction()
	  {
	    Job job = new Job(_JOB_NAME)
	    {
	      @Override
	      protected IStatus run(final IProgressMonitor monitor)
	      {
	        IStatus result = null ;
	        
	        try
	        {
	          final TransactionalEditingDomain domain = TransactionalEditingDomain.
	              Registry.INSTANCE.
	              getEditingDomain("org.osate.aadl2.ModelEditingDomain") ;
	          // We execute this command on the command stack because otherwise, we will
	          // not have write permissions on the editing domain.
	          RecordingCommandWithException cmd = new RecordingCommandWithException(domain)
	          {
	            protected void doExecute()
	            {
	              try
	              {
	                ProgressMonitorWrapper monitorWrapper = new ProgressMonitorWrapper(
	                                                                      monitor) ;
	                // Make sure that this xtext editor is saved.
	                IEditorPart editor = HandlerUtil.getActiveEditor(_event) ;
	                if(editor!=null)
	                  WorkbenchUtils.saveEditor(editor);
	                
	                
	                jobCore(monitorWrapper) ;
	                
	                this.setLabel(_OK_STATUS) ;
	              }
	              catch(OperationCanceledException e)
	              {
	                _LOGGER.info(cancelMsg(e));
	                this.setLabel(_CANCEL_STATUS);
	              }
	              catch(VMException e)
	              {
	                if(e.getCause() instanceof OperationCanceledException)
	                {
	                  _LOGGER.info(cancelMsg((OperationCanceledException) e.getCause()));
	                  this.setLabel(_CANCEL_STATUS);
	                }
	                else
	                {
	                  _LOGGER.fatal("", e) ;
	                  fatal(e) ;
	                }
	              }
	              catch(Exception e)
	              {
	                _LOGGER.fatal("", e) ;
	                fatal(e) ;
	              }
	            }

	            private void fatal(Exception e)
	            {
	              // Don't report error to the user.
	              // Eclipse will open an error dialog thanks to the status.
	              this.setLabel(_ABORT_STATUS) ;
	              this.exceptionCaught = e ;
	            }

	            private String cancelMsg(OperationCanceledException e)
	            {
	              StringBuilder sb = new StringBuilder() ;
	              sb.append(Names.NEW_LINE) ;
	              sb.append(Names.NEW_LINE) ;
	              sb.append("********************************************************************************") ;
	              sb.append(Names.NEW_LINE) ;
	              if(! (e.getMessage() == null || e.getMessage().isEmpty()))
	              {
	                sb.append(e.getMessage()) ;
	              }
	              else
	              {
	                sb.append("User has canceled") ;
	              }
	              sb.append(Names.NEW_LINE) ;
	              sb.append("********************************************************************************") ;
	              sb.append(Names.NEW_LINE) ;
	              
	              return sb.toString() ;
	            }
	          } ;

	          ((TransactionalCommandStack) domain.getCommandStack()).execute(cmd,
	                                                                         null) ;
	          if(_ABORT_STATUS.equals(cmd.getLabel()))
	          {
	            result = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
	                                "FATAL ERROR", cmd.exceptionCaught) ;
	          }
	          else
	          {
	            // Don't show error if any exception has been raised: escape side effects.
	            if(_OK_STATUS.equals(cmd.getLabel()))
	            {
	              result = Status.OK_STATUS ;
	            }
	            else
	            {
	              result = Status.CANCEL_STATUS ;
	            }
	          }
	        }
	        catch(Exception e)
	        {
	          _LOGGER.fatal("", e);
	          result = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "FATAL ERROR", e) ;
	        }
	        finally
	        {
	          HookAccessImpl.cleanupTransformationTrace() ;
	        }
	        
	        return result ;
	      }
	    };
	    
	    job.setUser(true);
	    job.schedule();
	  }
}
