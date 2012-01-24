package fr.tpt.aadl.ramses.control.support.reporters ;

import org.eclipse.emf.ecore.resource.Resource ;
import org.osate.aadl2.Element ;
import org.osate.aadl2.modelsupport.errorreporting.AbstractAnalysisErrorReporter ;

public class StandAloneAnalysisErrorReporter extends
                                            AbstractAnalysisErrorReporter
{

  private MessageReporter _reporter ;
  private final static String STAGE = "Resolver" ;

  public StandAloneAnalysisErrorReporter(
                                         Resource rsrc, MessageReporter reporter)
  {
    super(rsrc) ;
    _reporter = reporter ;
  }

  @Override
  protected void errorImpl(Element where,
                           String message,
                           String[] attrs,
                           Object[] values)
  {
    MessageStatus ms = MessageStatus.ERROR ;
    ms._stage = STAGE ;
    _reporter.reportMessage(ms, where, message) ;
  }

  @Override
  protected void warningImpl(Element where,
                             String message,
                             String[] attrs,
                             Object[] values)
  {
    MessageStatus ms = MessageStatus.WARNING ;
    ms._stage = STAGE ;
    _reporter.reportMessage(ms, where, message) ;
  }

  @Override
  protected void infoImpl(Element where,
                          String message,
                          String[] attrs,
                          Object[] values)
  {
    MessageStatus ms = MessageStatus.INFO ;
    ms._stage = STAGE ;
    _reporter.reportMessage(ms, where, message) ;
  }

  @Override
  protected void deleteMessagesImpl()
  {
    // Nothing to do.
  }
}