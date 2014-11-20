package fr.tpt.aadl.ramses.control.support;

import org.eclipse.emf.transaction.RecordingCommand;
import org.eclipse.emf.transaction.TransactionalEditingDomain;


public abstract class RecordingCommandWithException extends RecordingCommand
{
  public RecordingCommandWithException(TransactionalEditingDomain domain)
  {
    super(domain) ;
  }

  public Throwable exceptionCaught = null ;
}