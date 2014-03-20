package fr.tpt.aadl.ramses.control.osate;

import org.apache.log4j.Logger ;
import org.eclipse.core.runtime.IStatus ;
import org.eclipse.core.runtime.Status ;
import org.eclipse.ui.statushandlers.StatusManager ;
import org.osate.aadl2.Element ;

import fr.tpt.aadl.ramses.control.support.reporters.MessageReporter ;
import fr.tpt.aadl.ramses.control.support.reporters.MessageStatus ;

public class MessageReporter4Osate implements MessageReporter
{
  private static StatusManager _MANAGER = StatusManager.getManager() ;
  
  private static Logger _LOGGER = Logger.getLogger(MessageReporter4Osate.class) ;
  
  private void openFatalErrorDialog(String msg, Throwable e)
  {
    openDialog(IStatus.ERROR, msg, e);
  }
  
  private void openFatalErrorDialog(String msg)
  {
    openDialog(IStatus.ERROR, msg);
  }
  
  private void openErrorDialog(String msg)
  {
    openDialog(IStatus.ERROR, msg);
  }
  
  private void openWarningDialog(String msg)
  {
    openDialog(IStatus.WARNING, msg);
  }
  
  private void openInfoDialog(String msg)
  {
    openDialog(IStatus.OK, msg) ;
  }
  
  private void openDialog(int severity, String msg)
  {
    Status status = new Status(severity, Activator.PLUGIN_ID, msg) ;
    _MANAGER.handle(status, StatusManager.BLOCK);
  }
  
  private void openDialog(int severity, String msg, Throwable e)
  {
    Status status = new Status(severity, Activator.PLUGIN_ID, msg, e) ;
    _MANAGER.handle(status, StatusManager.BLOCK);
  }

  @Override
  public void reportMessage(MessageStatus status, String filename, int line,
                            String message)
  {
    String msg = "use OSATE's parsing or analysis reporter";
    _LOGGER.fatal(msg) ;
    throw new UnsupportedOperationException(msg) ;
  }

  @Override
  public void reportMessage(MessageStatus status, Element where, String message)
  {
    String msg = "use OSATE's parsing or analysis reporter";
    _LOGGER.fatal(msg) ;
    throw new UnsupportedOperationException(msg) ;
  }

  @Override
  public void reportMessage(MessageStatus status, String msg)
  {
    this.reportMessage(status, msg, null);
  }

  @Override
  public void reportMessage(MessageStatus status, String msg, Throwable e)
  {
    switch(status)
    {
      case INTERNAL_FATAL_ERROR :
      {
        if(null == e)
        {
          openFatalErrorDialog(msg);
        }
        else
        {
          openFatalErrorDialog(msg, e);
        }
        break ;
      }
      case INTERNAL_ERROR :       {openErrorDialog(msg); break ;}
      case INTERNAL_WARNING :     {openWarningDialog(msg); break ;}
      
      case AADL_ERROR:
      case AADL_WARNING:
      {
        msg = "use OSATE's parsing or analysis reporter";
        _LOGGER.fatal(msg) ;
        throw new UnsupportedOperationException(msg) ;
      }
     
      case INFO :
      default : {openInfoDialog(msg) ; break ;}
    }
  }
}