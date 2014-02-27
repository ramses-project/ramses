package fr.tpt.aadl.ramses.control.support;

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
  
  public TransformationException(Throwable e)
  {
    super(e) ;
  }
  
  public TransformationException(String errorMessage, Throwable e)
  {
    super(errorMessage) ;
  }
}
