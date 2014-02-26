package fr.tpt.aadl.ramses.control.osate;

import org.osate.ui.dialogs.Dialog ;

import fr.tpt.aadl.ramses.control.support.reporters.AbstractSystemErrReporter ;

public class SysErrReporter4Osate extends AbstractSystemErrReporter
{
  @Override
  public void fatal(String msg,
                    Throwable ex)
  {
    msg = super.formatFatalMsg(msg, ex) ;
    Dialog.showError("RAMSES Fatal error", msg);
  }

  @Override
  public void fatal(String msg)
  {
    msg = super.formatFatalMsg(msg) ;
    Dialog.showError("RAMSES Fatal error", msg);
  }

  @Override
  public void error(String msg, boolean isDelayed)
  {
    msg = super.formatErrorMsg(msg) ;
    if(isDelayed)
    {
      _delayedErrors.add(msg) ;
    }
    else
    {
      Dialog.showError("RAMSES error", msg);
    }
  }

  @Override
  public void warning(String msg, boolean isDelayed)
  {
    msg = super.formatWarningMsg(msg) ;
    
    if(isDelayed)
    {
      _delayedWarnings.add(msg) ;
    }
    else
    {
      Dialog.showWarning("RAMSES warning", msg);
    }
  }

  @Override
  public void displayDelayedErrors()
  {
    String msg = super.formatDelayedErrors() ;
    if(msg != null)
    {
      if(_delayedErrors.isEmpty())
      {
        Dialog.showWarning("RAMSES warning", msg);
        _delayedWarnings.clear();
      }
      else
      {
        Dialog.showError("RAMSES error", msg);
        _delayedErrors.clear();
        _delayedWarnings.clear();
      }
    }
  }

  @Override
  public void abortOnAadlErrors(String msg)
  {
    msg = super.formatAbortionOnAadlErrors(msg) ;
    Dialog.showInfo("RAMSES information", msg) ;
  }
}