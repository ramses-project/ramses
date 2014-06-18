package fr.tpt.trc.handler;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.ui.handlers.HandlerUtil;
import org.osate.utils.Aadl2Utils;
import fr.tpt.aadl.ramses.control.support.utils.Names;


public class UpdateTrcModulesActionHandler extends AbstractHandler {

	

	protected static boolean _isOutline = false;
	protected IProject _currentProject = null ;
	protected ExecutionEvent _event = null ;

	protected static String _JOB_NAME;
//	
//	private static final String _OK_STATUS = "OK" ;
//	private static final String _CANCEL_STATUS = "CANCEL" ;
//	private static final String _ABORT_STATUS = "FATAL" ;
//	  
	private static Logger _LOGGER = Logger.getLogger(UpdateTrcModulesActionHandler.class) ;
	
	// Call init method to setup these attributes.
	//protected _trc _modules = null ;
	protected List<EObject> _trc = null;
	protected List<EClass> _modules = null;

	//OR (init will not initialize both)
	//protected SystemInstance _sysInst = null ;
	
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			init(event, "TO CHANGE");
		} catch (Exception e) {
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
//		IFile node = (IFile) ((IStructuredSelection) s).toList() ;
		_currentProject = node.getProject() ;
//		Resource resource = OsateResourceUtil.getResource((IResource) node) ;
		
		// Launch HOT ATL to Module list
		// classe atlToX qui etend atltoatl et factoriser mon code
		String atlDirPath = Aadl2Utils.getAbsolutePluginPath(Names.
                ATL_TRANSFORMATION_PLUGIN_ID).toString() ;
		
		System.out.println("chemin : "+atlDirPath);
		_LOGGER.info("OSATE project is \'" + _currentProject.getName() + '\'');
		_LOGGER.info("system implementation to generate (button action) is \'" + _trc.get(0).toString() + '\''); // to modify
	}
	
	
//	  protected void doAction()
//	  {
//	    Job job = new Job(_JOB_NAME)
//	    {
//	      @Override
//	      protected IStatus run(final IProgressMonitor monitor)
//	      {
//	        IStatus result = null ;
//	        
//	        try
//	        {
//	          final TransactionalEditingDomain domain = TransactionalEditingDomain.
//	              Registry.INSTANCE.
//	              getEditingDomain("org.osate.aadl2.ModelEditingDomain") ;
//	          // We execute this command on the command stack because otherwise, we will
//	          // not have write permissions on the editing domain.
//	          RecordingCommandWithException cmd = new RecordingCommandWithException(domain)
//	          {
//	            protected void doExecute()
//	            {
//	              try
//	              {
//
//	                // Make sure that this xtext editor is saved.
//	                IEditorPart editor = HandlerUtil.getActiveEditor(_event) ;
//	                if(editor!=null)
//	                  WorkbenchUtils.saveEditor(editor);
//	                
//	                
////	                jobCore(monitorWrapper) ;
//	                
//	                this.setLabel(_OK_STATUS) ;
//	              }
//	              catch(OperationCanceledException e)
//	              {
//	                _LOGGER.info(cancelMsg(e));
//	                this.setLabel(_CANCEL_STATUS);
//	              }
//	              catch(VMException e)
//	              {
//	                if(e.getCause() instanceof OperationCanceledException)
//	                {
//	                  _LOGGER.info(cancelMsg((OperationCanceledException) e.getCause()));
//	                  this.setLabel(_CANCEL_STATUS);
//	                }
//	                else
//	                {
//	                  _LOGGER.fatal("", e) ;
//	                  fatal(e) ;
//	                }
//	              }
//	              catch(Exception e)
//	              {
//	                _LOGGER.fatal("", e) ;
//	                fatal(e) ;
//	              }
//	            }
//
//	            private void fatal(Exception e)
//	            {
//	              // Don't report error to the user.
//	              // Eclipse will open an error dialog thanks to the status.
//	              this.setLabel(_ABORT_STATUS) ;
//	              this.exceptionCaught = e ;
//	            }
//
//	            private String cancelMsg(OperationCanceledException e)
//	            {
//	              StringBuilder sb = new StringBuilder() ;
//	              sb.append(Names.NEW_LINE) ;
//	              sb.append(Names.NEW_LINE) ;
//	              sb.append("********************************************************************************") ;
//	              sb.append(Names.NEW_LINE) ;
//	              if(! (e.getMessage() == null || e.getMessage().isEmpty()))
//	              {
//	                sb.append(e.getMessage()) ;
//	              }
//	              else
//	              {
//	                sb.append("User has canceled") ;
//	              }
//	              sb.append(Names.NEW_LINE) ;
//	              sb.append("********************************************************************************") ;
//	              sb.append(Names.NEW_LINE) ;
//	              
//	              return sb.toString() ;
//	            }
//	          } ;
//
//	          ((TransactionalCommandStack) domain.getCommandStack()).execute(cmd,
//	                                                                         null) ;
//	          if(_ABORT_STATUS.equals(cmd.getLabel()))
//	          {
//	            result = new Status(IStatus.ERROR, Activator.PLUGIN_ID,
//	                                "FATAL ERROR", cmd.exceptionCaught) ;
//	          }
//	          else
//	          {
//	            // Don't show error if any exception has been raised: escape side effects.
//	            if(_OK_STATUS.equals(cmd.getLabel()))
//	            {
//	              result = Status.OK_STATUS ;
//	            }
//	            else
//	            {
//	              result = Status.CANCEL_STATUS ;
//	            }
//	          }
//	        }
//	        catch(Exception e)
//	        {
//	          _LOGGER.fatal("", e);
//	          result = new Status(IStatus.ERROR, Activator.PLUGIN_ID, "FATAL ERROR", e) ;
//	        }
//	        finally
//	        {
//	          HookAccessImpl.cleanupTransformationTrace() ;
//	        }
//	        
//	        return result ;
//	      }
//	    };
//	    
//	    job.setUser(true);
//	    job.schedule();
//	  }
}

// TODO: make an independant class in support package since it is used (and copy/pasted) in two classes
