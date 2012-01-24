package fr.tpt.aadl.ramses.control.support.reporters ;

import org.osate.aadl2.modelsupport.errorreporting.AbstractInternalErrorReporter ;

public class StandAloneInternalErrorReporter extends
                                            AbstractInternalErrorReporter
{
  private MessageReporter _reporter ;

  public StandAloneInternalErrorReporter(
                                         MessageReporter reporter)
  {
    _reporter = reporter ;
  }

  @Override
  public void internalErrorImpl(String message)
  {
    _reporter.reportMessage(MessageStatus.ERROR, message) ;
  }

  @Override
  public void internalErrorImpl(Exception e)
  {
    e.printStackTrace() ;
  }

}
