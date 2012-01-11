package fr.tpt.aadl.toolsuite.support.reporters ;

import org.osate.aadl2.modelsupport.errorreporting.AbstractParseErrorReporter ;

public class StandAloneParseErrorReporter extends AbstractParseErrorReporter
{
  private MessageReporter _reporter ;
  private final static String STAGE = "Parser" ;

  public StandAloneParseErrorReporter(
                                      MessageReporter reporter)
  {
    _reporter = reporter ;
  }

  @Override
  protected void deleteMessagesImpl()
  {
    // Nothing to do.
  }

  @Override
  protected void errorImpl(String filename,
                           int line,
                           String message)
  {
    MessageStatus ms = MessageStatus.ERROR ;
    ms._stage = STAGE ;
    _reporter.reportMessage(ms, filename, line, message) ;
  }

  @Override
  protected void warningImpl(String filename,
                             int line,
                             String message)
  {
    MessageStatus ms = MessageStatus.WARNING ;
    ms._stage = STAGE ;
    _reporter.reportMessage(ms, filename, line, message) ;
  }

  @Override
  protected void infoImpl(String filename,
                          int line,
                          String message)
  {
    MessageStatus ms = MessageStatus.INFO ;
    ms._stage = STAGE ;
    _reporter.reportMessage(ms, filename, line, message) ;
  }
}
