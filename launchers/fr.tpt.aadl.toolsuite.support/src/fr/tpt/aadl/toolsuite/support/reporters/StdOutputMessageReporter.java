package fr.tpt.aadl.toolsuite.support.reporters ;

public class StdOutputMessageReporter extends AbstractMessageReporter
{
  protected void printMessage(String msg)
  {
    System.err.println(msg) ;
  }
}