package fr.tpt.aadl.ramses.control.support.generator;

import fr.tpt.aadl.ramses.control.support.RamsesException ;

public class TransformationException extends RamsesException
{
  /**
   * 
   */
  private static final long serialVersionUID = 7398628902124971999L ;

  public TransformationException(String errorMessage)
  {
    super(errorMessage) ;
  }
  
  public TransformationException(String errorMessage, Throwable e)
  {
    super(errorMessage) ;
  }
}
