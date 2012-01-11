package fr.tpt.aadl.toolsuite.support.reporters ;

import org.osate.aadl2.Element ;

public interface MessageReporter
{
  public void reportMessage(MessageStatus status,
                            String filename,
                            int line,
                            String message) ;

  public void reportMessage(MessageStatus status,
                            Element where,
                            String message) ;

  public void reportMessage(MessageStatus status,
                            String message) ;
}
