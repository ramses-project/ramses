package fr.tpt.aadl.toolsuite.support.reporters ;

import java.io.File ;

import org.osate.aadl2.Element ;

public abstract class AbstractMessageReporter implements MessageReporter
{
  abstract protected void printMessage(String msg) ;

  @Override
  public void reportMessage(MessageStatus status,
                            String filename,
                            int line,
                            String message)
  {
    File file = new File(filename) ;
    filename = file.getName() ;
    StringBuilder sb = new StringBuilder(status.toString()) ;
    sb.append(" in ") ;
    sb.append(filename) ;
    sb.append(" at line ") ;
    sb.append(line) ;
    sb.append(": ") ;
    sb.append(message) ;
    printMessage(sb.toString()) ;
  }

  @Override
  public void reportMessage(MessageStatus status,
                            String message)
  {
    StringBuilder sb = new StringBuilder(status.toString()) ;
    sb.append(": ") ;
    sb.append(message) ;
    printMessage(sb.toString()) ;
  }

  @Override
  public void reportMessage(MessageStatus status,
                            Element where,
                            String message)
  {
    String filename = where.getLocationReference().getFilename() ;

    if(filename.contains("null"))
    {
      filename.replace("null", where.eResource().getURI().toString()) ;
    }

    File file = new File(filename) ;
    filename = file.getName() ;
    int line = where.getLocationReference().getLine() ;
    StringBuilder sb = new StringBuilder(status.toString()) ;
    sb.append(" in ") ;
    sb.append(filename) ;
    sb.append(" at line ") ;
    sb.append(line) ;
    sb.append(": ") ;
    sb.append(message) ;
    printMessage(sb.toString()) ;
  }
}
